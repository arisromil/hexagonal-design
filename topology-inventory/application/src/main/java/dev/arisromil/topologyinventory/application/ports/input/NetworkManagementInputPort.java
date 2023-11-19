package dev.arisromil.topologyinventory.application.ports.input;

import dev.arisromil.topologyinventory.application.usecases.NetworkManagementUseCase;
import dev.arisromil.topologyinventory.domain.entity.Switch;
import dev.arisromil.topologyinventory.domain.vo.IP;
import dev.arisromil.topologyinventory.domain.vo.Network;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NetworkManagementInputPort implements NetworkManagementUseCase {

    @Override
    public Network createNetwork(
            IP networkAddress, String networkName, int networkCidr) {
        return Network
                .builder()
                .networkAddress(networkAddress)
                .networkName(networkName)
                .networkCidr(networkCidr)
                .build();
    }
    @Override
    public Switch addNetworkToSwitch(Network network, Switch networkSwitch) {
        networkSwitch.addNetworkToSwitch(network);
        return networkSwitch;
    }
    @Override
    public Switch removeNetworkFromSwitch(String network, Switch networkSwitch) {
        networkSwitch.removeNetworkFromSwitch(network);
        return networkSwitch;
    }
}