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

public class MergeFiles {

    public static Directory directory;
    public static List<BufferedReader> readers;
    public static List<String> lines;

    // Процесс сортировки слиянием, выбор минимального времени и вывод соотвествующей строки
    public static void Merge() throws IOException {
        while(!readers.isEmpty()) {
            int minIndex = 0;
            Long min = Long.MAX_VALUE;
            List<Long> times = new ArrayList<>();
            for(int i = 0; i < lines.size(); ++i) {
                long time = Long.parseLong(lines.get(i).substring(0,lines.get(i).indexOf(' ')));
                times.add(time);
                if(time < min) {
                    min = time;
                    minIndex = i;
                }
            }
            System.out.println(lines.get(minIndex));
            String line = readers.get(minIndex).readLine();
            if(line == null) {
                readers.remove(readers.get(minIndex));
                lines.remove(lines.get(minIndex));
            }
            else {
                lines.set(minIndex, line);
            }
        }
    }


    //Первая итерация считывания
    public static void mergeSortFiles() throws IOException {
        readers = directory.readersToDirectory();
        lines = new ArrayList<>();
        for(BufferedReader reader: readers) {
            String line = reader.readLine();
            if(line == null) {
                readers.remove(reader);
            }
            else {
                lines.add(line);
            }
        }
        Merge();
    }

    public static void main(String[] args) {
        String path = args[0];
        directory = new Directory(path);
        try {
            mergeSortFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
