package booker.app.maroos.branches.application.addTable;

import booker.app.maroos.branches.domain.Branch;
import booker.app.maroos.branches.domain.BranchRepository;
import booker.app.maroos.branches.domain.vo.BranchId;
import booker.app.maroos.branches.domain.vo.Table;
import booker.app.shared.domain.Service;

import java.util.Optional;

@Service
public class AddTableToBranchUseCase {

    private final BranchRepository repository;

    public AddTableToBranchUseCase(BranchRepository repository) {
        this.repository = repository;
    }

    public void addTableBranch(CreateTableRequest request) throws Exception {

        Branch branch;
        Table table = new Table(request.tableNumber(), request.chairQuantity());
        BranchId branchId = new BranchId(request.branchId());

        Optional<Branch> branchOptional = repository.search(branchId);

        if(branchOptional.isPresent()){
            branch = branchOptional.get();
            branch.addTable(table);
            repository.save(branch);
        }else{
            throw new Exception("there is not branches with aggregateId "+ request.branchId());
        }

    }

}



