package dev.arisromil.topologyinventory.domain.entity;

import dev.arisromil.topologyinventory.domain.specification.EmptyRouterSpec;
import dev.arisromil.topologyinventory.domain.specification.EmptySwitchSpec;
import dev.arisromil.topologyinventory.domain.specification.SameCountrySpec;
import dev.arisromil.topologyinventory.domain.specification.SameIpSpec;
import dev.arisromil.topologyinventory.domain.vo.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@ToString
public final class CoreRouter extends Router {

    @Setter
    private Map<Id, Router> routers;

    @Builder
    public CoreRouter(Id id, Vendor vendor, Model model, IP ip, Location location, RouterType routerType, Map<Id, Router> routers) {
        super(id, vendor, model, ip, location, routerType);
        this.routers = routers;
    }

    public Router addRouter(Router anyRouter) {
        var sameCountryRouterSpec = new SameCountrySpec(this);
        var sameIpSpec = new SameIpSpec(this);

        sameCountryRouterSpec.check(anyRouter);
        sameIpSpec.check(anyRouter);

        return this.routers.put(anyRouter.id, anyRouter);
    }

    public Router removeRouter(Router anyRouter) {
        var emptyRoutersSpec = new EmptyRouterSpec();
        var emptySwitchSpec = new EmptySwitchSpec();

        switch (anyRouter.routerType) {
            case CORE -> {
                var coreRouter = (CoreRouter)anyRouter;
                emptyRoutersSpec.check(coreRouter);
            }
            case EDGE -> {
                var edgeRouter = (EdgeRouter)anyRouter;
                emptySwitchSpec.check(edgeRouter);
            }
        }
        return this.routers.remove(anyRouter.id);
    }


}
