package edu.bu.cs665;

import edu.bu.cs665.resource.Chooser;
import edu.bu.cs665.resource.ChooserImpl;
import edu.bu.cs665.resource.HRResource;

public class App {

  private static final HRResource HR_RESOURCE = new HRResource();

  public static void main(final String[] args) {
    final Chooser chooser = new ChooserImpl();
    HR_RESOURCE.menu();
  }
}
