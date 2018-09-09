public class Tea implements Beverage {

    private TeaType teaType;

    public TeaType getTeaType() {
        return teaType;
    }

    public void setTeaType(final TeaType teaType) {
        this.teaType = teaType;
    }

    @Override
    public void prepare() {
        System.out.println("You chose: " + this);
    }

    @Override
    public String toString() {
        return String.format("%s tea", getTeaType().toString().toLowerCase());
    }
}
