package dev.arisromil.topologyinventory.framework.adapters.output.h2.data;

import jakarta.persistence.Embeddable;

@Embeddable
public enum RouterTypeData {
    EDGE,
    CORE;
}
