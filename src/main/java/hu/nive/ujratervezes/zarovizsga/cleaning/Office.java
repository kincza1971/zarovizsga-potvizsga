package hu.nive.ujratervezes.zarovizsga.cleaning;

public class Office implements Cleanable{

    public static final int PRICE_PER_SQM = 100;
    private final String address;
    private final int area;
    private final int levels;

    public Office(String address, int area, int levels) {
        this.address = address;
        this.area = area;
        this.levels = levels;
    }

    @Override
    public int clean() {
        return levels*area* PRICE_PER_SQM;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public int getArea() {
        return area;
    }

    public int getLevels() {
        return levels;
    }
}

//Legyen egy Cleanable interfészed, annak int clean() és String getAddress() metódusa. Ez azt jelenti, hogy valamit ki
// lehet takarítani (amit visszaad a metódus, az a takarítás ára), valamint lennie kell egy címének is.
//
//Legyen két osztály, mely implementálja, a House és a Office! A House egy családi ház, melynek meg lehessen adni a címét
// és az alapterületét. A ház kitakarítása négyzetméterenként 80 Ft. Az Office egy iroda, melynek meg lehessen adni a címét,
// az alapterületét és a szintek számát. Az iroda kitakarítása négyzetméterenként 100 Ft. Természetesen az összes szintet számolni kell.
//
//Legyen egy CleaningService osztály, mely nyilvántartja az ingatlanokat. A következő metódusokat implementáld:
//
//void add(Cleanable cleanable) - hozzáaad egy ingatlant
//int cleanAll() - kitakarítja az összes ingatlant, és visszaadja, hogy mennyibe került, ezután nem marad egy ingatlan sem
//int cleanOnlyOffices() - kitakarítja csak az irodákat, és visszaadja, hogy mennyibe került. Ezután csak a házak maradnak.
//List<Cleanable> findByAddressPart(String address) - visszaadja azokat az ingatlanokat, melynek címében szerepel a paraméterként megadott érték
//String getAddresses() - visszaadja az ingatlanok címeit vesszővel és egy szóközzel elválasztva
//Ez két feladatnak számít, első az osztályok és interfész létrehozása, és a CleaningService osztály első metódusa egy feladat. A többi metódus még egy feladatnak számít.
