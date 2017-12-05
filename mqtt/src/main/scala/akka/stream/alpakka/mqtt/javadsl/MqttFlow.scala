/*
 * Copyright (C) 2016-2017 Lightbend Inc. <http://www.lightbend.com>
 */

package akka.stream.alpakka.mqtt.javadsl

import java.util.concurrent.CompletionStage

import akka.Done
import akka.stream.alpakka.mqtt.{MqttMessage, MqttQoS, MqttSourceSettings}

object MqttFlow {

  /**
   * Java API: create an [[MqttFlow]] for a provided QoS.
   */
  def create(sourceSettings: MqttSourceSettings,
             bufferSize: Int,
             qos: MqttQoS): akka.stream.javadsl.Flow[MqttMessage, MqttMessage, CompletionStage[Done]] = {
    import scala.compat.java8.FutureConverters._
    akka.stream.alpakka.mqtt.scaladsl.MqttFlow
      .apply(sourceSettings, bufferSize, qos)
      .mapMaterializedValue(_.toJava)
      .asJava
  }
}
