package camel.copyfiles.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFile;

import java.io.*;

public class FilesRouteProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("Exchange: " + exchange.getIn().getBody());
        GenericFile<File> file = (GenericFile<File>) exchange.getIn().getBody();
        if(file!=null){
            BufferedReader reader = new BufferedReader(new FileReader(file.getFile()));
            StringBuilder newValue = new StringBuilder("");
            reader.lines().forEach(line -> newValue.append(line + "("+line.length()+")\n"));
            exchange.getIn().setBody(newValue);
        }

    }
}
