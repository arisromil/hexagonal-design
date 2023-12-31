package dev.arisromil.topologyinventory.application.ports.input;

import dev.arisromil.topologyinventory.application.usecases.SwitchManagementUseCase;
import dev.arisromil.topologyinventory.domain.entity.EdgeRouter;
import dev.arisromil.topologyinventory.domain.entity.Switch;
import dev.arisromil.topologyinventory.domain.vo.*;

public class SwitchManagementInputPort implements SwitchManagementUseCase {

    @Override
    public Switch createSwitch(
            Vendor vendor,
            Model model,
            IP ip,
            Location location,
            SwitchType switchType) {
        return Switch
                .builder()
                .id(Id.withoutId())
                .vendor(vendor)
                .model(model)
                .ip(ip)
                .location(location)
                .switchType(switchType)
                .build();
    }
    @Override
    public EdgeRouter addSwitchToEdgeRouter(Switch networkSwitch, EdgeRouter edgeRouter) {
        edgeRouter.addSwitch(networkSwitch);
        return edgeRouter;
    }
    @Override
    public EdgeRouter removeSwitchFromEdgeRouter(Switch networkSwitch, EdgeRouter edgeRouter) {
        edgeRouter.removeSwitch(networkSwitch);
        return edgeRouter;
    }
}
