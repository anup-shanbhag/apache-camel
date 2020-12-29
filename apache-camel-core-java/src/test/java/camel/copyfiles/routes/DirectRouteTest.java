package camel.copyfiles.routes;

import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class DirectRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new DirectRoute();
    }

    @Test
    public void checkRouteOK() throws InterruptedException {
        template.sendBody("direct:directRoute", "SuperTester@123");
        Thread.sleep(5000);
        File file = new File("data/output/output.txt");
        assertTrue(file.exists());

        Exchange exchange = consumer.receive("file:data/output?fileName=output.txt");
        assertEquals("output.txt",exchange.getIn().getHeader("CamelFileName"));
        //assertEquals("SuperTester@123",exchange.getIn().getBody().toString());
    }
}
