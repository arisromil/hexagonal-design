package dev.arisromil.topologyinventory.framework.adapters.input.generic;

import dev.arisromil.topologyinventory.application.ports.input.NetworkManagementInputPort;
import dev.arisromil.topologyinventory.application.ports.input.SwitchManagementInputPort;
import dev.arisromil.topologyinventory.application.usecases.NetworkManagementUseCase;
import dev.arisromil.topologyinventory.application.usecases.SwitchManagementUseCase;
import dev.arisromil.topologyinventory.domain.entity.Switch;
import dev.arisromil.topologyinventory.domain.vo.Id;
import dev.arisromil.topologyinventory.domain.vo.Network;

public class NetworkManagementGenericAdapter {
    private SwitchManagementUseCase switchManagementUseCase;
    private NetworkManagementUseCase networkManagementUseCase;

    public NetworkManagementGenericAdapter(){
        setPorts();
    }

    private void setPorts(){
        this.switchManagementUseCase = new SwitchManagementInputPort();
        this.networkManagementUseCase = new NetworkManagementInputPort();
    }

    /**
     * POST /network/add
     * */
    public Switch addNetworkToSwitch(Network network, Id switchId) {
        Switch networkSwitch = switchManagementUseCase.retrieveSwitch(switchId);
        return networkManagementUseCase.addNetworkToSwitch(network, networkSwitch);
    }

    /**
     * POST /network/remove
     * */
    public Switch removeNetworkFromSwitch(String networkName, Id switchId) {
        Switch networkSwitch = switchManagementUseCase.retrieveSwitch(switchId);
        return networkManagementUseCase.removeNetworkFromSwitch(networkName, networkSwitch);
    }

}
