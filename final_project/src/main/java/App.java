import edu.bu.cs665.resource.CarDealershipResource;
import edu.bu.cs665.service.CarDealership;
import edu.bu.cs665.service.JimmyCorporation;

public class App {

  private static final CarDealership carDealership =
      JimmyCorporation.getCorporation().getCarDealership();
  private static final CarDealershipResource carDealershipResource =
      new CarDealershipResource(carDealership);

  public static void main(final String[] args) {
    carDealershipResource.run();
  }
}
