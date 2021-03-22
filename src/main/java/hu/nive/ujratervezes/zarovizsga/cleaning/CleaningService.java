package hu.nive.ujratervezes.zarovizsga.cleaning;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class CleaningService {
    private List<Cleanable> cleanables = new ArrayList<>();

    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    }

    public int cleanAll() {
        Iterator <Cleanable> it = cleanables.iterator();
        int sum = 0;
        Cleanable cleanable;
        while (it.hasNext()) {
            cleanable = it.next();
            sum += cleanable.clean();
            it.remove();
        }
        return sum;
    }

    public int cleanOnlyOffices() {
        Iterator <Cleanable> it = cleanables.iterator();
        int sum = 0;
        Cleanable cleanable;
        while (it.hasNext()) {
            cleanable = it.next();
            if (cleanable instanceof Office) {
                sum += cleanable.clean();
                it.remove();
            }
        }
        return sum;
    }

    public List<Cleanable> findByAddressPart(String addressPart) {
        return cleanables.stream()
                       .filter(m->m.getAddress().contains(addressPart))
                       .collect(Collectors.toList());
    }

    public String getAddresses() {
        StringBuilder result = new StringBuilder();
        for (Cleanable cleanable : cleanables) {
            result.append(cleanable.getAddress()).append(", ");
        }
        return result.substring(0,result.length()-2);
    }

    public List<Cleanable> getCleanables() {
        return cleanables;
    }
}


//Legyen egy CleaningService osztály, mely nyilvántartja az ingatlanokat. A következő metódusokat implementáld:
//
//void add(Cleanable cleanable) - hozzáaad egy ingatlant
//int cleanAll() - kitakarítja az összes ingatlant, és visszaadja, hogy mennyibe került, ezután nem marad egy ingatlan sem
//int cleanOnlyOffices() - kitakarítja csak az irodákat, és visszaadja, hogy mennyibe került. Ezután csak a házak maradnak.
//List<Cleanable> findByAddressPart(String address) - visszaadja azokat az ingatlanokat, melynek címében szerepel a paraméterként megadott érték
//String getAddresses() - visszaadja az ingatlanok címeit vesszővel és egy szóközzel elválasztva
//Ez két feladatnak számít, első az osztályok és interfész létrehozása, és a CleaningService osztály első metódusa egy feladat.
// A többi metódus még egy feladatnak számít.