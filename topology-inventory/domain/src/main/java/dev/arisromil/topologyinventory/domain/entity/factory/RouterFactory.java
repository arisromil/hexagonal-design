package dev.arisromil.topologyinventory.domain.entity.factory;

import dev.arisromil.topologyinventory.domain.entity.CoreRouter;
import dev.arisromil.topologyinventory.domain.entity.EdgeRouter;
import dev.arisromil.topologyinventory.domain.entity.Router;
import dev.arisromil.topologyinventory.domain.vo.*;

import static dev.arisromil.topologyinventory.domain.vo.RouterType.EDGE;

public class RouterFactory {
    public static Router getRouter(Id id,
                                   Vendor vendor,
                                   Model model,
                                   IP ip,
                                   Location location,
                                   RouterType routerType){

        switch (routerType) {
            case CORE -> {
                return CoreRouter.builder().
                        id(id == null ? Id.withoutId() : id).
                        vendor(vendor).
                        model(model).
                        ip(ip).
                        location(location).
                        routerType(routerType).
                        build();
            }
            case EDGE -> {
                return EdgeRouter.builder().
                        id(id==null ? Id.withoutId():id).
                        vendor(vendor).
                        model(model).
                        ip(ip).
                        location(location).
                        routerType(routerType).
                        build();
            }
            default -> throw new UnsupportedOperationException( "No valid router type informed");
        }
    }
}
