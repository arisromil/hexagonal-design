package dev.arisromil.topologyinventory.domain.entity;

import dev.arisromil.topologyinventory.domain.specification.SameCountrySpec;
import dev.arisromil.topologyinventory.domain.specification.SameIpSpec;
import dev.arisromil.topologyinventory.domain.vo.*;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class CoreRouter extends Router {
    public CoreRouter(Id id, Vendor vendor, Model model, IP ip, Location location, RouterType routerType) {
        super(id, vendor, model, ip, location, routerType);
    }




}
