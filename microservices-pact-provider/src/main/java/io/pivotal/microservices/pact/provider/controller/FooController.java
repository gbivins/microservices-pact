/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.pivotal.microservices.pact.provider.controller;

import io.pivotal.microservices.pact.provider.Foo;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {
    @GetMapping(value = "/foos",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Foo> foos() {
        return Arrays.asList(new Foo(42), new Foo(100));
    }
}
