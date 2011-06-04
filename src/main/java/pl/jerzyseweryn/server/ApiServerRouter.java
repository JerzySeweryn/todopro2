package pl.jerzyseweryn.server;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class ApiServerRouter extends Application {
	
	@Override
    public Restlet createInboundRoot() {
		
        Router router = new Router(getContext());
        router.attachDefault(HelloWorldResource.class);

        return router;
    }
}
