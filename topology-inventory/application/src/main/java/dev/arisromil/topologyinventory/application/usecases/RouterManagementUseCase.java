package dev.arisromil.topologyinventory.application.usecases;

import dev.arisromil.topologyinventory.domain.entity.CoreRouter;
import dev.arisromil.topologyinventory.domain.entity.Router;
import dev.arisromil.topologyinventory.domain.vo.*;

public interface RouterManagementUseCase {
    Router createRouter(
            Vendor vendor,
            Model model,
            IP ip,
            Location location,
            RouterType routerType);
    CoreRouter addRouterToCoreRouter(Router router, CoreRouter coreRouter);
    Router removeRouterFromCoreRouter(Router router, CoreRouter coreRouter);
    Router retrieveRouter(Id id);
    Router persistRouter(Router router);
}
