/*
 * Copyright (C) 2016-2017 Lightbend Inc. <http://www.lightbend.com>
 */

package akka.stream.alpakka.s3.javadsl;

import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.alpakka.s3.MemoryBufferType;
import akka.stream.alpakka.s3.Proxy;
import akka.stream.alpakka.s3.S3Settings;
import akka.stream.alpakka.s3.scaladsl.S3WireMockBase;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import scala.Some;

public class DocSnippets extends S3WireMockBase {

    final Materializer materializer = ActorMaterializer.create(system());

    // Documentation snippet only
    public void connectBluemix() {
        final Materializer mat = ActorMaterializer.create(system());
        // #java-bluemix-example
        final String host = "s3.eu-geo.objectstorage.softlayer.net";
        final int port = 443;


        final AWSStaticCredentialsProvider credentials = new AWSStaticCredentialsProvider(
                new BasicAWSCredentials(
                        "myAccessKeyId",
                        "mySecretAccessKey"
                )
        );
        final Proxy proxy = new Proxy(host, port, "https");

        // Set pathStyleAccess to true and specify proxy, leave region blank
        final S3Settings settings = new S3Settings(
                MemoryBufferType.getInstance(),
                Some.apply(proxy),
                credentials,
                "",
                true
        );
        final S3Client s3Client = new S3Client(settings,system(), mat);
        // #java-bluemix-example
    }
}
