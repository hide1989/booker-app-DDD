package booker.app.maroos.branches.application.create;

import java.util.Objects;

public class CreateBranchRequest {

    private final String branchId;
    private final String restaurantId;
    private final String branchLocation;
    private final String branchPhone;
    private final String branchPicture;

    public CreateBranchRequest(String branchId, String restaurantId, String branchLocation, String branchPhone, String branchPicture) {
        this.branchId = branchId;
        this.restaurantId = restaurantId;
        this.branchLocation = branchLocation;
        this.branchPhone = branchPhone;
        this.branchPicture = branchPicture;
    }

    public String branchId() {
        return branchId;
    }

    public String restaurantId() {
        return restaurantId;
    }

    public String branchLocation() {
        return branchLocation;
    }

    public String branchPhone() {
        return branchPhone;
    }

    public String branchPicture() {
        return branchPicture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateBranchRequest)) return false;
        CreateBranchRequest that = (CreateBranchRequest) o;
        return Objects.equals(branchId, that.branchId) &&
                Objects.equals(restaurantId, that.restaurantId) &&
                Objects.equals(branchLocation, that.branchLocation) &&
                Objects.equals(branchPhone, that.branchPhone) &&
                Objects.equals(branchPicture, that.branchPicture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branchId, restaurantId, branchLocation, branchPhone, branchPicture);
    }
}
