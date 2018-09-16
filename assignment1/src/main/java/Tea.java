import java.util.Arrays;
import java.util.List;

public class Tea implements Beverage {

    private String type;

    @Override
    public String getDescriptor() {
        return "tea";
    }

    @Override
    public List<String> getTypes() {
        return Arrays.asList("black", "green", "yellow");
    }

    @Override
    public void setType(final String type) {
        if (!getTypes().contains(type)) {
            throw new IllegalArgumentException("Type must be one of " + getTypes());
        }
        this.type = type;
    }

    private String getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return String.format("%s tea", getType());
    }
}
