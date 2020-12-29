package camel.copyfiles.routes;

import org.apache.camel.builder.RouteBuilder;

public class DirectRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:directRoute")
                .log("Headers: ${headers}")
                .log("Body : ${body}")
                .to("file:data/output?fileName=output.txt");
    }
}
