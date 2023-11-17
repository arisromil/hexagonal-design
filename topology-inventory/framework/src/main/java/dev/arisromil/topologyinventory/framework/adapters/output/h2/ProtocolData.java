package dev.arisromil.topologyinventory.framework.adapters.output.h2;

import jakarta.persistence.Embeddable;

@Embeddable
public enum ProtocolData {
    IPV4,
    IPV6;
}