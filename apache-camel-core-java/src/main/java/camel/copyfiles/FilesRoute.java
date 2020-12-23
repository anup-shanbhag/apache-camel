package camel.copyfiles;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class FilesRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:data/input?noop=true")
                .to("log:learn?level=INFO&showBody=true&logMask=true&showHeaders=true")
                .to("file:data/staging");
        from("file:data/staging?delete=true")
                .to("log:learn?level=INFO&showBody=true&logMask=true&showHeaders=true")
                .to("file:data/output");
    }
}
