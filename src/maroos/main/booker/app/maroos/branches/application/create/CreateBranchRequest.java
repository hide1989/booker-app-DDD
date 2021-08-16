package booker.app.maroos.branches.application.create;

import java.util.Objects;

public class CreateBranchRequest {

    private final String branchId;
    private final String restaurantId;
    private final String branchLocation;
    private final String branchPhone;
    private final String branchPicture;
    private final String openDoors;
    private final String closeDoors;

    public CreateBranchRequest(String branchId, String restaurantId, String branchLocation, String branchPhone, String branchPicture, String openDoors, String closeDoors) {
        this.branchId = branchId;
        this.restaurantId = restaurantId;
        this.branchLocation = branchLocation;
        this.branchPhone = branchPhone;
        this.branchPicture = branchPicture;
        this.openDoors = openDoors;
        this.closeDoors = closeDoors;
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

    public String openDoors() {
        return openDoors;
    }

    public String closeDoors() {
        return closeDoors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateBranchRequest)) return false;
        CreateBranchRequest request = (CreateBranchRequest) o;
        return Objects.equals(branchId, request.branchId) &&
                Objects.equals(restaurantId, request.restaurantId) &&
                Objects.equals(branchLocation, request.branchLocation) &&
                Objects.equals(branchPhone, request.branchPhone) &&
                Objects.equals(branchPicture, request.branchPicture) &&
                Objects.equals(openDoors, request.openDoors) &&
                Objects.equals(closeDoors, request.closeDoors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branchId, restaurantId, branchLocation, branchPhone, branchPicture, openDoors, closeDoors);
    }
}
