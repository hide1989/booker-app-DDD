package booker.app.maroos.tables.domain.vo;

import booker.app.shared.domain.Identifier;

public class TableId extends Identifier {
    public TableId(String value) {
        super(value);
    }

    private TableId() {
        super("");
    }
}
