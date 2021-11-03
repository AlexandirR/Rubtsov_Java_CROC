package Ex9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Directory {

    private Path root;

    public Directory(String path) {
        this.root = Paths.get(path);
    }

    public Directory(Path root) {
        this.root = root;
    }

    // проверка является ли файл логом по расширению
    private static boolean isFileExtensionLog(Path root) {
        String name = root.getFileName().toString();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return false;
        }
        return (name.substring(lastIndexOf).equals(".log") || name.substring(lastIndexOf).equals(".trace"));
    }

    //Возвращает список файлов в директории и ее поддиректориях
    public List<Path> listFiles() throws IOException {
        List<Path> result;
        try (Stream<Path> walk = Files.walk(root)) {
            result = walk.filter(Files::isRegularFile)
                    .filter(Directory::isFileExtensionLog)
                    .collect(Collectors.toList());
        }
        return result;
    }

    //Возвращает список BufferedReader для каждого файла чтобы потом считывать из всех файлов
    public List<BufferedReader> readersToDirectory() throws IOException {
        ArrayList<BufferedReader> readers = new ArrayList<>();
        for(Path file : this.listFiles()) {
            readers.add(new BufferedReader(
                    new FileReader(file.getParent().toString() + "\\" + file.getFileName().toString())));
        }
        return readers;
    }
}
