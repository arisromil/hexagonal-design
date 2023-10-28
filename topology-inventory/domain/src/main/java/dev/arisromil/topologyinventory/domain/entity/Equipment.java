package dev.arisromil.topologyinventory.domain.entity;



import dev.arisromil.topologyinventory.domain.vo.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Predicate;

@Getter
@AllArgsConstructor
public abstract sealed class Equipment permits Router, Switch {
    protected Id id;
    protected Vendor vendor;
    protected Model model;
    protected IP ip;
    protected Location location;

    public Equipment(Id id, Vendor vendor, Model model, IP ip, Location location) {
    }

    public static Predicate<Equipment> getVendorPredicate(Vendor vendor){
        return r -> r.getVendor().equals(vendor);
    }
}