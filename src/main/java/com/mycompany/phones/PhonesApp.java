package com.mycompany.phones;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.stream.Collectors;

/**
 *
 * @author mrebrov
 */
public class PhonesApp {

    private final static Path DIR = FileSystems.getDefault().getPath("C:\\TestData");
    private final static String REGEXP = ".*\\d{3}-?\\d{2}-?\\d{2}.*";

    public static void main(String[] args) {
        PhonesApp pa = new PhonesApp();
        PhonesLoader pl = new PhonesLoader();
        PhoneBook pb = new PhoneBook(pl.load(DIR, REGEXP));
        PhoneNumbersFormatter pnf = new PhoneNumbersFormatter();
        pa.doMagic(pb, pnf);
    }
    
    private void doMagic(PhoneBook pb, PhoneNumbersFormatter pnf) {
        pb.setPhoneNumbers(
                pb.getPhoneNumbers()
                        .stream()
                        .map((String s) -> pnf.removeNotNumbers(s))
                        .map((String s) -> pnf.formatNumbers(s))
                        .sorted((a, b) -> {
                            return Long.compare(Long.parseLong(a), Long.parseLong(b));
                        })
                        .distinct()
                        .map((String s) -> pnf.toPhoneFormat(s))
                        .collect(Collectors.toList()));
        pb.getPhoneNumbers().forEach(System.out::println);
    }
}
