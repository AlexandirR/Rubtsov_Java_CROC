package Ex10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxCall {

    //Статик класс для сканлайна где есть поля: точка во времени и является эта точка началом или концом звонка
    public static class TimePoint {
        public long time;
        public boolean inOut; //правда - начало звонка, ложь - конец звонка
    }

    //Преобразование данных о звонках в объекты с точками во времени
    public static List<TimePoint> stringToList(List<String> words) {
        List<TimePoint> timePoints = new ArrayList<TimePoint>();
        for(String word : words) {
            String[] line = word.split(",");
            TimePoint timePoint1 = new TimePoint();
            timePoint1.time = Long.parseLong(line[0]);
            timePoint1.inOut = true;
            timePoints.add(timePoint1);
            TimePoint timePoint2 = new TimePoint();
            timePoint2.time = Long.parseLong(line[1]);
            timePoint2.inOut = false;
            timePoints.add(timePoint2);
        }
        return timePoints;
    }

    public static int scanLine(List<TimePoint> timePoints) {
        int window = 0;
        int answer = 0;
        for(TimePoint timePoint: timePoints) {
            if (timePoint.inOut) {
                window++;
            }
            else {
                window--;
            }
            if(window > answer) {
                answer = window;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        try {
            Path path = Paths.get("src/Ex10/input.txt");
            List<String> words = Files.readAllLines(path);
            List<TimePoint> timePoints = stringToList(words);
            Collections.sort(timePoints, new Comparator<TimePoint>() {
                public int compare(TimePoint o1, TimePoint o2) {
                    if(o1.time < o2.time){
                        return -1;
                    }
                    else if(o1.time == o2.time) {
                        if(o1.inOut == false)
                            return -1;
                        else return 1;
                    }
                    else
                        return 1;
                }
            });
            System.out.println(scanLine(timePoints));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
