package io.pivotal.microservices.pact.consumer;

import au.com.dius.pact.consumer.*;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;
import au.com.dius.pact.model.RequestResponsePact;
import java.io.IOException;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class ConsumerPortTest extends ConsumerPactTestMk2{

    @Override
    protected RequestResponsePact createPact(PactDslWithProvider pdwp) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json;charset=UTF-8");

        return pdwp.uponReceiving("a request for Foos")
                .path("/foos")
                .method("GET")

                .willRespondWith()
                .headers(headers)
                .status(200)
                .body("[{\"value\":42}, {\"value\":100}]").toPact();
    }

    @Override
    protected String providerName() {
        return "microservice-provider";
    }

    @Override
    protected String consumerName() {
        return "microservice-consumer";    }

    @Override
    protected void runTest(MockServer ms) throws IOException {
         assertEquals(new ConsumerPort(ms.getUrl()).foos(), Arrays.asList(new Foo(42), new Foo(100)));
    }
}
