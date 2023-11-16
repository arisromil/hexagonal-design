package dev.arisromil.topologyinventory.application.ports.output;

import dev.arisromil.topologyinventory.domain.entity.Router;
import dev.arisromil.topologyinventory.domain.vo.Id;

public interface RouterManagementOutputPort {
    Router retrieveRouter(Id id);

    Router removeRouter(Id id);
    Router persistRouter(Router router);
}
