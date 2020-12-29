package camel.copyfiles.routes;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class FilesRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new FilesRoute();
    }

    @Test
    public void checkRouteOK () throws InterruptedException {
        Thread.sleep(5000);
        File file = new File("data/output");
        assertTrue(file.isDirectory());
        assertEquals(4,  file.listFiles().length);
    }

}
