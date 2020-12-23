package camel.copyfiles;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class FilesRouteWithTransformationTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder(){
        return new FilesRouteWithTransformation();
    }

    @Test
    public void checkRouteOK() throws InterruptedException {
        Thread.sleep(5000);

        File file = new File ("data/output");
        assertTrue(file.exists());
    }
}
