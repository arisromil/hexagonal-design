package dev.arisromil.topologyinventory.framework.adapters.input.generic;

import dev.arisromil.topologyinventory.application.ports.input.RouterManagementInputPort;
import dev.arisromil.topologyinventory.application.usecases.RouterManagementUseCase;
import dev.arisromil.topologyinventory.domain.entity.CoreRouter;
import dev.arisromil.topologyinventory.domain.entity.Router;
import dev.arisromil.topologyinventory.domain.vo.*;
import dev.arisromil.topologyinventory.framework.adapters.output.h2.RouterManagementH2Adapter;

public class RouterManagementGenericAdapter {

    private RouterManagementUseCase routerManagementUseCase;

    public RouterManagementGenericAdapter(){
        setPorts();
    }

    private void setPorts(){
        this.routerManagementUseCase = new RouterManagementInputPort();
    }

    /**
     * GET /router/retrieve/{id}
     * */
    public Router retrieveRouter(Id id){
        return routerManagementUseCase.retrieveRouter(id);
    }

    /**
     * GET /router/remove/{id}
     * */
    public Router removeRouter(Id id){
        return routerManagementUseCase.removeRouter(id);
    }

    /**
     * POST /router/create
     * */
    public Router createRouter(Vendor vendor,
                               Model model,
                               IP ip,
                               Location location,
                               RouterType routerType){
        var router = routerManagementUseCase.createRouter(
                null,
                vendor,
                model,
                ip,
                location,
                routerType

        );
        return routerManagementUseCase.persistRouter(router);
    }

    /**
     * POST /router/add
     * */
    public Router addRouterToCoreRouter(Id routerId, Id coreRouterId){
        Router router = routerManagementUseCase.retrieveRouter(routerId);
        CoreRouter coreRouter = (CoreRouter) routerManagementUseCase.retrieveRouter(coreRouterId);
        return routerManagementUseCase.
                addRouterToCoreRouter(router, coreRouter);
    }

    /**
     * POST /router/remove
     * */
    public Router removeRouterFromCoreRouter(Id routerId, Id coreRouterId){
        Router router = routerManagementUseCase.retrieveRouter(routerId);
        CoreRouter coreRouter = (CoreRouter) routerManagementUseCase.retrieveRouter(coreRouterId);
        return routerManagementUseCase.
                removeRouterFromCoreRouter(router, coreRouter);
    }
}