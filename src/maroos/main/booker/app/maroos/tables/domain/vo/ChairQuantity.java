package booker.app.maroos.tables.domain.vo;

import booker.app.shared.domain.IntegerValueObject;

public class ChairQuantity extends IntegerValueObject {
    public ChairQuantity(Integer value) {
        super(value);
    }

    private ChairQuantity() {
        super(null);
    }
}
