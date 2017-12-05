/*
 * Copyright (C) 2016-2017 Lightbend Inc. <http://www.lightbend.com>
 */

package akka.stream.alpakka.mqtt.scaladsl

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.alpakka.mqtt.{MqttConnectionSettings, MqttMessage, MqttQoS, MqttSourceSettings}
import akka.stream.scaladsl.{Keep, Sink, Source}
import akka.testkit.TestKit
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence
import org.scalatest.{Matchers, WordSpecLike}
import org.scalatest.concurrent.ScalaFutures

import scala.concurrent.duration._

class MqttFlowSpec extends TestKit(ActorSystem("MqttFlowSpec")) with WordSpecLike with Matchers with ScalaFutures {

  implicit val defaultPatience =
    PatienceConfig(timeout = 5.seconds, interval = 100.millis)

  implicit val mat = ActorMaterializer()
  val connectionSettings = MqttConnectionSettings(
    "tcp://localhost:1883",
    "test-client",
    new MemoryPersistence
  )

  val topic = "flow-spec/topic"

  val settings =
    MqttSourceSettings(connectionSettings.withClientId(clientId = "flow-spec/flow"), Map(topic -> MqttQoS.atLeastOnce))

  "mqtt flow" should {
    "establish a bidirectional connection and subscribe to a topic" in {
      //#create-flow
      val mqttFlow = MqttFlow(settings, 8, MqttQoS.atLeastOnce)
      //#create-flow

      val source = Source.maybe[MqttMessage]

      //#run-flow
      val ((mqttMessagePromise, subscriptionFuture), result) = source
        .viaMat(mqttFlow)(Keep.both)
        .toMat(Sink.seq)(Keep.both)
        .run()
      //#run-flow

      whenReady(subscriptionFuture) { _ =>
        mqttMessagePromise.success(None)
        noException should be thrownBy result.futureValue
      }
    }
  }
}
