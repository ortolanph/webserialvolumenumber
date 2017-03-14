package org.wvsn.api;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;
import org.wvsn.service.VolumeSerialNumberService;

@Component
public class RestAPI extends RouteBuilder {

    public void configure() throws Exception {
        restConfiguration()
                .contextPath("/api").apiContextPath("/api-doc")
                .apiProperty("api.title", "Volume Serial Number REST API")
                .apiProperty("api.version", "1.0")
                .apiProperty("cors", "true")
                .apiContextRouteId("doc-api")
                .dataFormatProperty("pretty-print", "true")
                .bindingMode(RestBindingMode.json);

        rest("/vsn")
                .description("Volume Serial Number Calculation")
                .get("/fromDate/{date}")
                    .description("Returns the calculated Volume Serial Number from a given date")
                    .route()
                    .bean(VolumeSerialNumberService.class, "fromDate(${header.date})")
                    .endRest()
                .get("/randomDate")
                    .description("Returns the calculated Volume Serial Number from a generated random date ")
                    .route()
                    .bean(VolumeSerialNumberService.class, "randomDate()");

    }
}
