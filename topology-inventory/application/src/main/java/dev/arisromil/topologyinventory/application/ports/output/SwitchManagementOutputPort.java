package dev.arisromil.topologyinventory.application.ports.output;

import dev.arisromil.topologyinventory.domain.entity.Switch;
import dev.arisromil.topologyinventory.domain.vo.Id;

public interface SwitchManagementOutputPort {
    Switch retrieveSwitch(Id id);
}