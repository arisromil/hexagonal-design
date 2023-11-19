package dev.arisromil.topologyinventory.application.usecases;

import dev.arisromil.topologyinventory.domain.entity.EdgeRouter;
import dev.arisromil.topologyinventory.domain.entity.Switch;
import dev.arisromil.topologyinventory.domain.vo.*;

public interface SwitchManagementUseCase {
    Switch createSwitch(
            Vendor vendor,
            Model model,
            IP ip,
            Location location,
            SwitchType switchType
    );
    Switch retrieveSwitch(Id id);
    EdgeRouter addSwitchToEdgeRouter(Switch networkSwitch, EdgeRouter edgeRouter);
    EdgeRouter removeSwitchFromEdgeRouter(Switch networkSwitch, EdgeRouter edgeRouter);
}
