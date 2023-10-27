package dev.arisromil.topologyinventory.domain.vo;

public record Location (
        String address,
        String city,
        String state,
        int zipCode,
        String country,
        float latitude,
        float longitude
        ) {}
