import edu.bu.cs665.service.CarDealership;
import edu.bu.cs665.service.JimmyCorporation;
import edu.bu.cs665.ui.CarDealershipMenu;

public class App {

  private static final CarDealership carDealership =
      JimmyCorporation.getCorporation().getCarDealership();
  private static final CarDealershipMenu carDealershipMenu = new CarDealershipMenu(carDealership);

  public static void main(final String[] args) {
    carDealershipMenu.run();
  }
}
