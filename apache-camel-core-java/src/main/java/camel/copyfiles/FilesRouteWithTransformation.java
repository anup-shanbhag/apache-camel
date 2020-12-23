package camel.copyfiles;

import org.apache.camel.builder.RouteBuilder;

public class FilesRouteWithTransformation extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:data/input?noop=true")
                .log("Headers: ${headers}")
                .log("Body: ${body}")
                .process(new FilesRouteProcessor())
                .to("file:data/output");
    }
}
