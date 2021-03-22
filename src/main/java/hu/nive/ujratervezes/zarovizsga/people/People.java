package hu.nive.ujratervezes.zarovizsga.people;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class People {

    public static final int INDEX_OF_GENDER = 4;

    public int getNumberOfMales(String path) {
        Path file = Path.of(path);
        try (Stream<String> lines = Files.lines(file)) {
            return (int) lines.filter(this::isMale).count();
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }
    }

    private boolean isMale(String line) {
        String[] parts = line.split(",");
        return parts[INDEX_OF_GENDER].equals("Male");
    }

}

//A People osztályban implementáld a int getNumberOfMales(String path) metódust! A metódus paraméterként megkapja e
// gy fájl elérési útvonalát. A tesztesetben ez a src/test/resources/people.csv, így ebbe a könyvtárba tedd a fájlt!
//
//A fájl formátuma:
//
//id,first_name,last_name,email,gender,ip_address
//1,Rebekkah,Lashmore,rlashmore0@rambler.ru,Male,140.220.218.69
//2,Chiquia,Konmann,ckonmann1@auda.org.au,Male,54.83.30.17
//3,Gloria,Bascomb,gbascomb2@ebay.co.uk,Male,67.210.132.201
//
//A metódus adja vissza, hogy hány férfi van a fájlban!