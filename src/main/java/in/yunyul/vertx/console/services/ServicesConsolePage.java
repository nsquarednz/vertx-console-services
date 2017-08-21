package in.yunyul.vertx.console.services;

import in.yunyul.vertx.console.base.ConsolePage;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.servicediscovery.ServiceDiscovery;
import io.vertx.servicediscovery.rest.ServiceDiscoveryRestEndpoint;

@SuppressWarnings("unused")
public class ServicesConsolePage implements ConsolePage {
    private ServiceDiscovery discovery;

    /**
     * Creates the services console page, using the provided service discovery instance
     *
     * @param discovery the service discovery instance
     * @return the console page
     */
    public static ServicesConsolePage create(ServiceDiscovery discovery) {
        return new ServicesConsolePage(discovery);
    }

    private ServicesConsolePage(ServiceDiscovery discovery) {
        this.discovery = discovery;
    }

    @Override
    public void mount(Vertx vertx, Router router, String basePath) {
        ServiceDiscoveryRestEndpoint.create(router, discovery, basePath + "/discovery");
    }

    @Override
    public String getLoaderFileName() {
        return "/js/services.js";
    }
}
