# deepstream-rpc-example
[![Build Status](https://travis-ci.org/gregwhitaker/deepstream-rpc-example.svg?branch=master)](https://travis-ci.org/gregwhitaker/deepstream-rpc-example)

An example of using [DeepStream](https://deepstreamhub.com/) for microservices RPC.

## Prerequisites
This example requires a running instance of the Deepstream server.

You can pull the latest Deepstream server from DockerHub using the following command:

    $ docker pull deepstreamio/deepstream.io

Create a container from this image using the following command:

    $ docker create -t -p 6020:6020 -p 8080:8080 \
       --name deepstream.io \
       -v $(pwd)/conf:/usr/local/deepstream/conf \
       -v $(pwd)/var:/usr/local/deepstream/var \
       deepstreamio/deepstream.io

Start the Deepstream server using the following command:

    $ docker start -ia deepstream.io

## Running the Example
You can run the example using the following commands:

## Bugs and Feedback
For bugs, questions, and discussions please use the [Github Issues](https://github.com/gregwhitaker/deepstream-rpc-example/issues).

## License
Copyright 2018 Greg Whitaker

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.