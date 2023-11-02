package dev.arisromil.topologyinventory.domain.specification;

import dev.arisromil.topologyinventory.domain.entity.EdgeRouter;
import dev.arisromil.topologyinventory.domain.exception.GenericSpecificationException;

public final class EmptySwitchSpec extends AbstractSpecification<EdgeRouter> {

    @Override
    public boolean isSatisfiedBy(EdgeRouter edgeRouter) {
        return edgeRouter.getSwitches()==null ||
                edgeRouter.getSwitches().isEmpty();
    }

    @Override
    public void check(EdgeRouter edgeRouter) {
        if(!isSatisfiedBy(edgeRouter))
            throw new GenericSpecificationException("It isn't allowed to remove an edge router with a switch attached to it");
    }
}