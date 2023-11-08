package dev.arisromil.topologyinventory.application.usecases;

import dev.arisromil.topologyinventory.domain.entity.Switch;
import dev.arisromil.topologyinventory.domain.vo.IP;
import dev.arisromil.topologyinventory.domain.vo.Network;

public interface NetworkManagementUseCase {
    Network createNetwork(IP networkAddress,String networkName,int networkCidr);
    Switch addNetworkToSwitch(Network network,Switch networkSwitch);
    Switch removeNetworkFromSwitch(Network network, Switch networkSwitch);
}
