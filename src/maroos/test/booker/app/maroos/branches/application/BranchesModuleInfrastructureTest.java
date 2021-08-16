package booker.app.maroos.branches.application;

import booker.app.maroos.MaroosContextInfrastructuraTestCase;
import booker.app.maroos.branches.infrastructure.persistence.InMemoryBranchRepository;

public abstract class BranchesModuleInfrastructureTest extends MaroosContextInfrastructuraTestCase {
    protected InMemoryBranchRepository inMemoryBranchRepository = new InMemoryBranchRepository();
}
