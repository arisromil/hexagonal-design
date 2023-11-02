package dev.arisromil.topologyinventory.domain.specification;

import dev.arisromil.topologyinventory.domain.entity.CoreRouter;
import dev.arisromil.topologyinventory.domain.exception.GenericSpecificationException;

public final class EmptyRouterSpec extends AbstractSpecification<CoreRouter> {

    @Override
    public boolean isSatisfiedBy(CoreRouter coreRouter) {
        return coreRouter.getRouters()==null||
                coreRouter.getRouters().isEmpty();
    }

    @Override
    public void check(CoreRouter coreRouter) {
        if(!isSatisfiedBy(coreRouter))
            throw new GenericSpecificationException("It isn't allowed to remove a core router with other routers attached to it");
    }

}
