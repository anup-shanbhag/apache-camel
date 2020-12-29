package camel.copyfiles.routes;

import org.apache.camel.builder.RouteBuilder;

public class MockRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:input")
                .log("Headers: ${headers}")
                .log("Body: ${body}")
                .to("mock:output");
    }
}
