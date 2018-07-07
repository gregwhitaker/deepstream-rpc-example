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
package demo.deepstream.client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.deepstream.DeepstreamClient;
import io.deepstream.RpcResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String... args) throws Exception {
        // Connect to Deepstream
        DeepstreamClient client = new DeepstreamClient("ws://localhost:6020");
        client.login();

        callFooService(client);
        callBarService(client);
    }

    private static void callFooService(DeepstreamClient client) {
        Gson gson = new Gson();
        RequestMessage request = new RequestMessage("World");

        LOGGER.info("Sending request to 'services.foo'...");

        RpcResult result = client.rpc.make("services.foo", gson.toJson(request));

        if (result.success()) {
            ResponseMessage response = gson.fromJson((JsonObject) result.getData(), ResponseMessage.class);
            LOGGER.info("Response from 'services.foo': " + response.getMessage());
        } else {
            LOGGER.error("Request to 'services.foo' failed!");
        }
    }

    private static void callBarService(DeepstreamClient client) {
        Gson gson = new Gson();
        RequestMessage request = new RequestMessage("World");

        LOGGER.info("Sending request to 'services.bar'...");

        RpcResult result = client.rpc.make("services.bar", gson.toJson(request));

        if (result.success()) {
            ResponseMessage response = gson.fromJson((JsonObject) result.getData(), ResponseMessage.class);
            LOGGER.info("Response from 'services.bar': " + response.getMessage());
        } else {
            LOGGER.error("Request to 'services.bar' failed!");
        }
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
