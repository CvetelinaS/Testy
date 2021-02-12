package com.cvetelina.book.tools;

import org.testng.Assert;


public class Tools {

  public static void waitForSeconds(long secondsToWait) {
    try {
      Thread.sleep(secondsToWait * 1000);
    } catch (InterruptedException e) {
      System.out.println("There was error when waiting for action " + e);
      Assert.fail();
    }
  }



}
