package pl.jerzyseweryn.server;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class HelloWorldResource extends ServerResource {

    @Get
    public String represent() {
        return "hello, world (from the cloud!)";
    }

}
