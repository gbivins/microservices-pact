/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.pivotal.microservices.pact.provider;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;
import au.com.dius.pact.provider.spring.target.SpringBootHttpTarget;
import io.pivotal.microservices.pact.provider.controller.FooController;
import java.util.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@Provider("microservice-provider") // Set up name of tested provider
//@PactFolder("/Users/gbivins/research/external-tools/microservices-pact/microservices-pact-consumer/target/pacts") // Point where to find pacts (See also section Pacts source in documentation)
@PactFolder("../microservices-pact-consumer/target/pacts") // Point where to find pacts (See also section Pacts source in documentation)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRestPactRunner.class)
public class ProviderTest {

    @LocalServerPort
    private int port;
    @TestTarget
    public final Target target = new SpringBootHttpTarget(port);

    @InjectMocks
    private FooController fooController = new FooController();

}
