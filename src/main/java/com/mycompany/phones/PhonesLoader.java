package com.mycompany.phones;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author mrebrov
 */
public class PhonesLoader {

    private List<String> numbersList = new ArrayList<>();

    public List<String> load(Path dir, String regExp) {
        try (Stream<Path> filesStream = Files.list(dir)) {
            Iterator<Path> iterator = filesStream.iterator();
            while (iterator.hasNext()) {
                Path path = iterator.next();
                if (Files.isDirectory(path)) {
                    load(path, regExp);
                } else {
                    if (path.toFile().getName().lastIndexOf(".txt") != -1) {
                        Files.lines(path).filter(i -> i.matches(regExp)).forEach(e -> numbersList.add(e));
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return numbersList;
    }
}
