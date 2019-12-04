package com.san.design;

public class TestMain {
    public static void main(String[] args) {
        final Company devOn = new Company();
    }

    public static void main1(String[] args) {
        final ETVPark etvPark = new ETVPark();
        displayInfo(etvPark);

        final ETVPark devOn = new DevOn(new Garden("DevOn Garden"), new Cafeteria("DevOn Cafeteria"));
        displayInfo(devOn);

        final ETVPark wellsFargo = new WellsFargo(new Garden("WellsFargo"));
        displayInfo(wellsFargo);

        final ETVPark cisco = new Cisco();
        displayInfo(cisco);
        final Test t = new Test();
    }

    private static void displayInfo(ETVPark etvPark) {
        System.out.println("TestMain.displayInfo() : " + etvPark);
    }
}

class Test {
    public Test() {
    }

    public Test(String str) {
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
