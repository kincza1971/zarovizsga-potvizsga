package hu.nive.ujratervezes.zarovizsga.cleaning;

public class House implements Cleanable{
    public static final int PRICE_PER_SQM = 80;
    private final String address;
    private final int area;

    public House(String address, int area) {
        this.address = address;
        this.area = area;
    }

    @Override
    public int clean() {
        return area* PRICE_PER_SQM;
    }

    @Override
    public String getAddress() {
        return address;
    }
}
