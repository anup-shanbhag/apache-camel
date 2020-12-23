package camel.copyfiles;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class MockRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new MockRoute();
    }

    @Test
    public void checkRouteOK() throws InterruptedException {
        String input = "SuperTester@123";
        MockEndpoint output = getMockEndpoint("mock:output");
        output.expectedBodiesReceived(input);
        template.sendBody("direct:input",input);
        Thread.sleep(5000);
        assertMockEndpointsSatisfied();
    }

}
