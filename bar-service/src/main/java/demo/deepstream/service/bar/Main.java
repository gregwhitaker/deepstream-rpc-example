/**
 * Copyright 2018 Greg Whitaker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package demo.deepstream.service.bar;

import com.google.gson.Gson;
import io.deepstream.DeepstreamClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides the foo-service to Deepstream.
 */
public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String... args) throws Exception {
        // Connect to Deepstream
        DeepstreamClient client = new DeepstreamClient("ws://localhost:6020");
        client.login();

        // Provide a service named "services.bar"
        client.rpc.provide("services.bar", (name, data, rpcResponse) -> {
            Gson gson = new Gson();
            System.out.println(data);
            rpcResponse.ack();
        });

        // Block main thread to prevent JVM exit
        Thread.currentThread().join();
    }

    /**
     *
     */
    static class RequestMessage {
        final String name;

        RequestMessage(final String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    /**
     *
     */
    static class ResponseMessage {
        final String message;

        ResponseMessage(final String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
