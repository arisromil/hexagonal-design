module application {
    exports dev.arisromil.topologyinventory.application.ports.output;
    exports dev.arisromil.topologyinventory.application.ports.input;
    exports dev.arisromil.topologyinventory.application.usecases;
    requires domain;
    requires static lombok;
}