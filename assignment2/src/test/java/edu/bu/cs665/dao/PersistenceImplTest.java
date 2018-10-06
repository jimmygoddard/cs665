package edu.bu.cs665.dao;

import org.junit.Assert;
import org.junit.Test;

public class PersistenceImplTest {

  @Test
  public void getPersistence() {
    final Persistence instanceOne = PersistenceImpl.getPersistence();
    final Persistence instanceTwo = PersistenceImpl.getPersistence();
    Assert.assertSame(instanceOne, instanceTwo);
  }
}
