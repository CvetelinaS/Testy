package com.cvetelina.book;

public class HomePage {

         private static DriverInit driver;
         private static final String homePageUrl = "http://book.theautomatedtester.co.uk/";

        public static void main(String[] args) {
            driver.initializeDriver(homePageUrl);
    }
}
