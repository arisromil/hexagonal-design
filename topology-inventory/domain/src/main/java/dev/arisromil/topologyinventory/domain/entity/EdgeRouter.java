package dev.arisromil.topologyinventory.domain.entity;

import dev.arisromil.topologyinventory.domain.vo.*;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@Getter
@ToString
public final class EdgeRouter extends Router {

    private final Map<Id, Switch> switches;

    @Builder
    public EdgeRouter(Id id, Vendor vendor, Model model, IP ip, Location location, RouterType routerType, Map<Id, Switch> switches) {
        super(id, vendor, model, ip, location, routerType);
        this.switches = switches;
    }


}