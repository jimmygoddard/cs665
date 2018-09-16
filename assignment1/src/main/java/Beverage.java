import java.util.List;

/**
 * Interface for Beverages
 */
public interface Beverage {

    /**
     * Provide a string description of the beverage
     *
     * @return the string description
     */
    String getDescriptor();

    /**
     * Return the list of possible types of the beverage
     *
     * @return a list of valid types for this beverage
     */
    List<String> getTypes();

    /**
     * Set the type of beverage
     *
     * @param type the type to set for the beverage
     */
    void setType(String type);
}
