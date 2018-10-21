package edu.bu.cs665.dao;

import org.junit.Assert;
import org.junit.Test;

public class PersonStoreImplTest {

  /**
   * getPersistence singleton test
   *
   * <p>Test that only a single instance of PersonStore can be retrieved
   */
  @Test
  public void getPersistence() {
    final PersonStore instanceOne = PersonStoreImpl.getPersistence();
    final PersonStore instanceTwo = PersonStoreImpl.getPersistence();
    Assert.assertSame(instanceOne, instanceTwo);
  }
}
