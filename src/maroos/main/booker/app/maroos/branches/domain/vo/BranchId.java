package booker.app.maroos.branches.domain.vo;

import booker.app.shared.domain.Identifier;

public class BranchId extends Identifier {
    public BranchId(String value) {
        super(value);
    }

    public BranchId() {
        super("");
    }
}
