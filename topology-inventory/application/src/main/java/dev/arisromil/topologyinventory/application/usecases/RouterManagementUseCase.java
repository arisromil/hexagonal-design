package dev.arisromil.topologyinventory.application.usecases;

import dev.arisromil.topologyinventory.domain.entity.CoreRouter;
import dev.arisromil.topologyinventory.domain.entity.Router;
import dev.arisromil.topologyinventory.domain.vo.*;

public interface RouterManagementUseCase {
    Router createRouter(
            Id id,
            Vendor vendor,
            Model model,
            IP ip,
            Location location,
            RouterType routerType);

    Router removeRouter(Id id);

    Router retrieveRouter(Id id);

    Router persistRouter(Router router);

    Router addRouterToCoreRouter(
            Router router, CoreRouter coreRouter);

    Router removeRouterFromCoreRouter(
            Router router, CoreRouter coreRouter);
}
