package dev.arisromil.topologyinventory.framework.adapters.input.generic;

import dev.arisromil.topologyinventory.application.ports.input.RouterManagementInputPort;
import dev.arisromil.topologyinventory.application.ports.input.SwitchManagementInputPort;
import dev.arisromil.topologyinventory.application.usecases.RouterManagementUseCase;
import dev.arisromil.topologyinventory.application.usecases.SwitchManagementUseCase;
import dev.arisromil.topologyinventory.domain.entity.EdgeRouter;
import dev.arisromil.topologyinventory.domain.entity.Router;
import dev.arisromil.topologyinventory.domain.entity.Switch;
import dev.arisromil.topologyinventory.domain.vo.*;
import dev.arisromil.topologyinventory.framework.adapters.output.h2.RouterManagementH2Adapter;

public class SwitchManagementGenericAdapter {

    private SwitchManagementUseCase switchManagementUseCase;
    private RouterManagementUseCase routerManagementUseCase;

    public SwitchManagementGenericAdapter(){
        setPorts();
    }

    private void setPorts(){
        this.routerManagementUseCase = new RouterManagementInputPort();
        this.switchManagementUseCase = new SwitchManagementInputPort();
    }

    /**
     * GET /switch/retrieve/{id}
     * */
    public Switch retrieveSwitch(Id switchId) {
        return switchManagementUseCase.retrieveSwitch(switchId);
    }

    /**
     * POST /switch/create
     * */
    public EdgeRouter createAndAddSwitchToEdgeRouter(
            Vendor vendor,
            Model model,
            IP ip,
            Location location,
            SwitchType switchType,
            Id routerId
    ) {
        Switch newSwitch = switchManagementUseCase.createSwitch(vendor, model, ip, location, switchType);
        Router edgeRouter = routerManagementUseCase.retrieveRouter(routerId);
        if(!edgeRouter.getRouterType().equals(RouterType.EDGE))
            throw new UnsupportedOperationException("Please inform the id of an edge router to add a switch");
        Router router = switchManagementUseCase.addSwitchToEdgeRouter(newSwitch, (EdgeRouter) edgeRouter);
        return (EdgeRouter) routerManagementUseCase.persistRouter(router);
    }

    /**
     * POST /switch/remove
     * */
    public EdgeRouter removeSwitchFromEdgeRouter(Id switchId, Id edgeRouterId) {
        EdgeRouter edgeRouter = (EdgeRouter) routerManagementUseCase
                .retrieveRouter(edgeRouterId);
        Switch networkSwitch = edgeRouter.getSwitches().get(switchId);
        Router router = switchManagementUseCase
                .removeSwitchFromEdgeRouter(networkSwitch, edgeRouter);
        return (EdgeRouter) routerManagementUseCase.persistRouter(router);
    }
}
