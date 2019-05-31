package com.emids.appriss.component;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import com.emids.appriss.model.Patient;

@Component
public class CamelRoutes extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		/* from("direct:firstRoute").log("Camle body : ${body}"); */

		restConfiguration().component("servlet").bindingMode(RestBindingMode.json);

		rest("/patient").produces("application/json").get("/hello/{patientName}").route().transform()
				.simple("Hello ${header.patientName}").endRest().get("/records/{patientName}").to("direct:records");

		from("direct:records").process(new Processor() {
			final AtomicLong counter = new AtomicLong();

			@Override
			public void process(Exchange exchange) throws Exception {
				final String name = exchange.getIn().getHeader("patientName", String.class);
				exchange.getIn().setBody(new Patient(counter.incrementAndGet(), name, "India"));

			}

		});

	}

}
