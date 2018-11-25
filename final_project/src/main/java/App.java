import edu.bu.cs665.resource.CarDealershipResource;

public class App {

  private static final CarDealershipResource carDealershipResource = new CarDealershipResource();

  public static void main(final String[] args) {
    carDealershipResource.run();
  }
}
