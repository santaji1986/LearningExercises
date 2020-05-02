package com.san.design;

public class TestMain {

    public static void main(String[] args) {
        final ETVPark etvPark = new ETVPark();
        displayInfo(etvPark);

        final ETVPark devOn = new DevOn(new Garden("DevOn Garden"), new Cafeteria("DevOn Cafeteria"));
        displayInfo(devOn);

        final ETVPark wellsFargo = new WellsFargo(new Garden("WellsFargo"));
        displayInfo(wellsFargo);

        final ETVPark cisco = new Cisco();
        displayInfo(cisco);
    }

    private static void displayInfo(ETVPark etvPark) {
        System.out.println("TestMain.displayInfo() : " + etvPark);
    }
}
