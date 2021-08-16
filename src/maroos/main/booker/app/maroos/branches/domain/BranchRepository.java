package booker.app.maroos.branches.domain;

import booker.app.maroos.branches.domain.vo.BranchId;

import java.util.Optional;

public interface BranchRepository {

    void save(Branch branch);

    Optional<Branch> search(BranchId branchId);
}
