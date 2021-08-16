package booker.app.maroos.branches.infrastructure.persistence;

import booker.app.maroos.branches.domain.Branch;
import booker.app.maroos.branches.domain.BranchRepository;
import booker.app.maroos.branches.domain.vo.BranchId;

import java.util.HashMap;
import java.util.Optional;

public class InMemoryBranchRepository implements BranchRepository{

    private final HashMap<BranchId, Branch> branches = new HashMap<>();

    @Override
    public void save(Branch branch) {
        branches.put(branch.branchId(), branch);
    }

    @Override
    public Optional<Branch> search(BranchId branchId) {
        return Optional.ofNullable(branches.get(branchId));
    }
}
