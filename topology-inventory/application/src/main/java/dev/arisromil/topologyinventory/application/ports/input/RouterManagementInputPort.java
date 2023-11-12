package dev.arisromil.topologyinventory.application.ports.input;

import dev.arisromil.topologyinventory.application.ports.output.RouterManagementOutputPort;
import dev.arisromil.topologyinventory.application.usecases.RouterManagementUseCase;
import dev.arisromil.topologyinventory.domain.entity.CoreRouter;
import dev.arisromil.topologyinventory.domain.entity.Router;
import dev.arisromil.topologyinventory.domain.entity.factory.RouterFactory;
import dev.arisromil.topologyinventory.domain.vo.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RouterManagementInputPort implements RouterManagementUseCase {

    RouterManagementOutputPort routerManagementOutputPort;

    @Override
    public Router createRouter(Vendor vendor,
                               Model model,
                               IP ip,
                               Location location,
                               RouterType routerType) {
        return RouterFactory.getRouter(null,
                vendor, model, ip, location, routerType);
    }
    @Override
    public Router retrieveRouter(Id id) {
        return routerManagementOutputPort.retrieveRouter(id);
    }

    @Override
    public Router persistRouter(Router router) {
        return routerManagementOutputPort.persistRouter(router);
    }

    @Override
    public CoreRouter addRouterToCoreRouter(Router router, CoreRouter coreRouter) {
        var addedRouter =  coreRouter.addRouter(router);
        return (CoreRouter) addedRouter;
    }
    @Override
    public Router removeRouterFromCoreRouter(Router router, CoreRouter coreRouter) {
        return coreRouter.removeRouter(router);
    }
}
