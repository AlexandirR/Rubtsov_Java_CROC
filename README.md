Проверенны задачи 1-11 и доп задача,
*** 
Загружены задачи 1 - 13 и доп задача вне оценки
***
Рубцов Александр, задачи курса КРОК Введение в Java
***
ЗАДАЧИ
==========

Задача 1
============
Реализовать функцию, вычисляющую площадь треугольника по координатам его вершин в декартовой системе координат. Результат вывести на экран.

Для задания координат можно определить вспомогательный класс Point:
```Java
public class Main {

  static class Point {
    double x;
    double y;
  }

  public static void main(String[] args) {

    Point a = new Point();
    a.x = 0.0;
    a.y = 0.0;

    Point b = new Point();
    b.x = 2.0;
    b.y = 0.0;

    Point c = new Point();
    c.x = 0.0;
    c.y = 2.0;

    // ...
  }
}
```
Для вычисления площади можно использовать формулу Герона или применить геометрические свойства векторного произведения. Функция извлечения квадратного корня в Java: Math.sqrt(x).
### Входные данные
Программа запрашивает входные данные у пользователя, каждую координату отдельно для каждой вершины.

### Пример вызова программы
% java ru/croc/task1/Main

% Введите координату х вершины №1: 0

% Введите координату y вершины №1: 0

% Введите координату х вершины №2: 2

% Введите координату y вершины №2: 0

% Введите координату х вершины №3: 0

% Введите координату y вершины №3: 2

% Площадь треугольника: 2

Если командная строка не видит JAVA - скорее всего необходимо корректно установить переменные окружения (environment variables). См. (пример для java 10, но аналогично для любой другой версии): <https://docs.oracle.com/javase/10/install/installation-jdk-and-jre-microsoft-windows-platforms.htm#JSJIG-GUID-96EB3876-8C7A-4A25-9F3A-A2983FEC016A>

Задача 2
=========================
Написать метод, форматирующий и выводящий на экран заданный размер в байтах в человекочитаемом виде.
Человекочитаемый вид: 

{целая часть < 1024}.{дробная часть макс. 1 знак} {единица измерения}

### Например:

printBytes(23) -> "23.0 B"
printBytes(1024) -> "1.0 KB"
printBytes(53692044905543) -> "48.8 TB"

Для вывода только одного знака дробной части вещественного числа можно воспользоваться методом:

String.format("%.1f", 1.23456);

Задача 3
=========
Задан массив целых чисел. Необходимо переставить наименьшее из этих чисел в начало массива, а наибольшее - в конец.

Массивы в Java определяются с помощью указания их размера в квадратных скобках:

int[] v = new int[77];

Размер можно не указывать, но тогда нужно определить сами элементы в фигурных скобках:

int[] v = new int[] {6, 28, 1};

Обращаться к элементам можно по индексу:

System.out.println(v[0]); // выводим первый по счету элемент

v[1] = 16; // изменяем значение элемента с индексом 1

Размер массива:

v.length;

### Входные данные
Элементы массива, по очереди через пробел. Без экранирующих символов и обозначений начала и конца массива.

Задача 4
================
Вы разрабатываете небольшое приложение по аннотированию (разметке) изображений с целью последующего использования этой разметки для обучения моделей computer vision. В этом приложении пользователь может выделять области на изображении с помощью прямоугольников и окружностей и подписывать их произвольным текстом.

Прямоугольники определяются координатами левого нижнего и правого верхнего углов, а окружности - координатами центра и радиусом. Вся разметка для изображения представляется массивом Annotation[].

В приложении определен класс аннотированного изображения:
```Java
class AnnotatedImage {

  private final String imagePath;

  private final Annotation[] annotations;

  public AnnotatedImage(String imagePath, Annotation... annotations) {
    this.imagePath = imagePath;
    this.annotations = annotations;
  }

  public String getImagePath() {
    return this.imagePath;
  }

  public Annotation[] getAnnotations() {
    return this.annotations;
  }
}
```
Определите класс Annotation для представления данных разметки (подпись + фигура) и классы Figure, Rectangle, Circle для задания размеченных областей.

Переопределите метод toString класса Annotation так, чтобы в результат выводилась информация о полях и вложенных объектах. Формата вывода:

Окружность:

“C ( X0 , Y0 ), R : Подпись”

Прямоугольник:

“R ( X1 , Y1 ), ( X2 ,  Y2 ):  Подпись ”

Например:

C (100, 100), 10: Tree
R (100, 100), (150, 200): Car

Задача 5
==============
От пользователей приложения (см. задачу 4) пришел запрос на возможность перемещать уже размеченные области. Для поддержки новой функциональности вам требуется внести несколько изменений: 

1) выбор аннотации по координатам точки (x, y);

В массиве аннотаций требуется найти первую, фигура которой содержит точку с заданными координатами.
```Java
Annotation findByPoint(int x, int y) {
  // ...
}
```
2) выбор аннотации по шаблону подписи;

В массиве аннотаций требуется найти первую, подпись которой содержит заданную подстроку.
```Java
Annotation findByLabel(String label) {
  // ...
}
```
Определить, содержит ли строка заданную подстроку, можно с помощью метода contains(CharSequence s) класса String.

3) перемещение фигуры выбранной аннотации на смещение (dx, dy);

В рамках этого изменения вы решили доработать классы фигур таким образом, чтобы они реализовывали интерфейс
```Java
public interface Movable {
  
  void move(int dx, int dy);
}
```
Доработайте классы и реализуйте соответствующие методы.

Задача Б1 (вне зачета)
=====================
Государственная организация принимает от пользователей заявки, на которые необходимо сформировать ответ. В формировании ответа участвуют разные отделы организации по следующему принципу:
сначала заявка рассматривается корневым отделом A;
затем она переводится во все дочернии отделы A: B1, B2, ..., Bn;
после рассмотрения заявки отделом Bi она переходит в его дочерние отделы: Ci1, Ci2, ..., Cik;
и т.д., пока заявка не пройдет через все отделы.

Для каждого отдела известно количество часов, необходимых для рассмотрения заявки.

Определить классы для представления иерархии обработки заявок отделами. То есть, по произвольной схеме (например, которая указана ниже), должна быть возможность сконструировать набор объектов, которые бы отражали иерархию обработки. (Имеется в виду явное создание объектов в коде, а не пользовательский ввод.)

Реализовать метод, вычисляющий время, необходимое для обработки заявки в заданной конфигурации (при условии что все отделы начинают обработку заявки без задержек: сразу после предшествующих).
Пример
A: 1 час
- B1: 3 часа
  - C11: 1 час
  - C12: 1 час
- B2: 1 час
  - C21: 4 часа
- B3: 2 часа
  - C31: 1 час
    - D311: 1 час

Время обработки заявки для этой конфигурации: 6 часов

Задача 6
==================
В текстах программ на Java могут использоваться многострочные (/* ... */) и однострочные (// ...) комментарии. Реализовать метод, принимающий на вход строковую переменную - исходный текст программы на Java, вырезающий из этой строки все комментарии и возвращающий результат в виде строки.
```Java
public static void main(String[] args) {
  String source = “...”; // test data
  String noComments = removeJavaComments(source);
  System.out.println(noComments);
}
```
### Пример

    /*
     * My first ever program in Java!
     */
    class Hello { // class body starts here 
  
     /* main method */
      public static void main(String[] args/* we put command line arguments here*/) {
        // this line prints my first greeting to the screen
        System.out.println("Hi!"); // :)
      }
    } // the end
    // to be continued...
### Результат
    class Hello {  
  
  
      public static void main(String[] args) {
    
        System.out.println("Hi!"); 
      }
    }
    
Задача 7
==============
Определить класс, описывающий позицию на шахматной доске 8x8. Данные класса: компоненты x и y, отсчитываемые от левого нижнего угла (x = 0, y = 0 - левая нижняя клетка).

Все методы, позволяющие установить координаты, в том числе и конструкторы, должны проверять корректность аргументов и генерировать IllegalPositionException (необходимо определить это исключение самостоятельно) в случае ошибочных значений.

Переопределить метод toString(), выводящий координаты позиции в формате <номер колонки в виде буквы от 'a' до 'h'><номер строки, начиная с 1>. Например, позиция с координатами (1, 1) имеет строковое представление "b2".

Реализовать "фабричный метод" конструирования объекта позиции из строкового представления ("b2" -> объект):
```Java
static ChessPosition parse(String position) {
  // ...
}
```
В виде массива строк задана некоторая последовательность позиций на шахматной доске 8x8. Например, "b1", "a3", "c4", "d6". Реализовать метод, проверяющий, что последовательность может быть пройдена фигурой конь в соответствии с правилами хода этой фигуры (буквой "Г"). На вход метод принимает массив объектов класса, определенных в текущей задаче.

Определить новый класс IllegalMoveException обрабатываемого исключения, которое генерируется методом проверки в случае ошибки. Класс должен содержать информацию о неправильном ходе: из какой в какую позиции ход запрещен. При вызове метода проверки это исключение должно обрабатываться, а неправильный ход выводиться на экран. Последовательность ходов для проверки задается в аргументах командной строки программы.
```Java
public class IllegalMoveException extends Exception {
  // ...
}
```
### Тестовые примеры
[in]  "g8", "e7", "e6"
[out] "конь так не ходит: e7 -> e6"

[in]  "g8", "e7", "c8"
[out] "OK"

Задача 8
====================
В текстовом файле слова могут быть разделены одним или несколькими пробелами или символами перевода строки. Необходимо реализовать программу, считающую количество слов в файле и выводящую результат на экран. Путь к файлу задается первым аргументом командной строки (args[0]).
### Пример
[in]
Забыл   Панкрат  Кондратьевич домкрат,
А без домкрату ну  не  поднять на тракте трактор.

[out]
13

Задача 9
===============
Вы разрабатываете систему в микросервисной архитектуре, в которой сервисы в процессе работы записывают логи в отдельные файлы. Каждая строка файла лога имеет вид:

time message\n

где time - время в формате POSIX time (количество миллисекунд с 1 января 1970 года), message - произвольный текст.

Строки в логах всегда отсортированы по времени в порядке возрастания.

Сервисов в системе много, и вы обнаружили, что при анализе ошибок тратите слишком много времени, так как приходится восстанавливать общий порядок действий в системе по большому количеству разных логов.

Поэтому вы решили реализовать утилиту слияния нескольких логов в один общий. Утилита в качестве аргумента командной строки принимает путь к директории, в которой находятся файлы логов (возможно, разбитые по вложенным директориям). Результат слияния утилита записывает в стандартный поток вывода в виде общей последовательности строк из всех логов в порядке возрастания времени. Логами считаются файлы с расширениями .log или .trace, все файлы с другими расширениями игнорируются.

Реализуйте эту утилиту, имея в виду, что логи бывают большими и не всегда могут поместиться в оперативной памяти целиком.

Задача 10
=================
В колл-центре крупной компании сохраняются логи всех телефонных звонков за день. Каждая строка файла лога состоит из времени начала и времени окончания одного телефонного разговора, разделенных запятой. Время задается в формате POSIX time (количество миллисекунд с 1 января 1970 года). Строки в файле отсортированы по времени начала разговора.

Необходимо посчитать пиковое количество одновременных разговоров и вывести его на экран. (Максимальное количество разговоров, которые происходили в одно и то же время.)
### Пример
[in]
1,12
4,6
7,12
10,32
15,30

[out]
3

Задача 11
============
Вы работаете над приложением для проведения аукциона. Начать разработку решили с самого важного - класса лота аукциона. В ходе анализа предметной области вы пришли к выводу, что каждый лот должен иметь 3 параметра: текущую стоимость, имя пользователя, предложившего ее, и время окончания торгов по этому лоту. 

Также класс должен предоставлять два метода - метод “ставки”, который обновляет текущую стоимость лота и сохраняет предложившего ее пользователя, если торги по лоту еще ведутся по времени и предложенная цена выше текущей. Второй метод - метод получения имени пользователя победителя.

Делать ставки на лот одновременно могут сразу несколько пользователей.

Реализуйте класс по описанию так, чтобы одновременное участие в ставках большого количества пользователей не приводило к ошибкам в проведении аукциона (то есть, потокобезопасно).

Задача 12
===============
Вы “ответственно” подходите к информационной безопасности и храните свои пароли в файлах в виде MD5-хешей (<https://ru.wikipedia.org/wiki/MD5>, <https://www.baeldung.com/java-md5>).

Но, к сожалению, вы забыли и никак не можете вспомнить свой пароль от учетной записи в почте. Хотя у вас остался его хеш 40682260CC011947FC2D0B1A927138C5. Вы точно помните, что пароль состоял из 7 букв латинского алфавита, и что все они были строчными.

Для генерации хеша вы используете функцию hashPassword
```Java
private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();

private static String toHexString(byte[] bytes) {
  StringBuilder hex = new StringBuilder(bytes.length * 2);
  for (byte b : bytes) {
    hex.append(HEX_DIGITS[(b & 0xff) >> 4]);
    hex.append(HEX_DIGITS[b & 0x0f]);
  }
  return hex.toString();
}

private static String hashPassword(String password) {
  MessageDigest digest;
  try {
    digest = MessageDigest.getInstance("MD5");
  } catch (NoSuchAlgorithmException e) {
    throw new RuntimeException(e);
  }
  digest.update(password.getBytes());
  byte[] bytes = digest.digest();
  return toHexString(bytes);
}
```
Напишите программу, которая методом полного перебора (<https://ru.wikipedia.org/wiki/%D0%9F%D0%BE%D0%BB%D0%BD%D1%8B%D0%B9_%D0%BF%D0%B5%D1%80%D0%B5%D0%B1%D0%BE%D1%80>) напомнит вам пароль. Причем за наиболее короткий срок - пароль вам нужен как можно быстрее. Для ускорения процесса вы решили перебор выполнять в несколько потоков.

Количество потоков - входные данные для программы, задается первым аргументом командной строки. Хеш пароля - вторым аргументом. Найденный пароль печатается в стандартный поток вывода.

Задача 13
=============
Небольшой стартап разрабатывает социальный сервис, в котором пользователи могут оставлять комментарии. Со временем в комментариях появился спам и разработчики решили бороться с ним с помощью "черных списков" запрещенных слов. Они составили такие списки и поручили вам написать функцию, удаляющую из всех накопленных комментариев нежелательные.

Они предоставили вам интерфейс, который внедрили в свой продукт, и попросили написать его реализацию:
```Java
import java.util.List;
import java.util.Set;

public interface BlackListFilter {

  /**
   * From the given list of comments removes ones 
   * that contain words from the black list.
   * 
   * @param comments list of comments; every comment 
   *                 is a sequence of words, separated 
   *                 by spaces, punctuation or line breaks   
   * @param blackList list of words that should not 
   *                  be present in a comment
   */
  void filterComments(List<String> comments, Set<String> blackList);
}
```
Реализуйте интерфейс BlackListFilter.

Задача 14
===================
Кинотеатр "Места для поцелуев" открыл стриминговый сервис для онлайн-просмотра фильмов. За несколько месяцев работы сервиса накопилась история просмотров разными пользователями и владельцы решили внедрить в него систему рекомендаций, которая предлагала бы пользователям интересный фильм на основе их истории просмотров.

У вас есть два файла:

1. Список доступных фильмов. Каждая строка содержит числовой идентификатор фильма и его название, разделенные запятой. Например:

        1,Мстители: Финал
        2,Хатико
        3,Дюна
       4,Унесенные призраками

2. История просмотров по всем пользователям сервиса. Каждая строка файла содержит список идентификаторов фильмов, просмотренных одним человеком за все время пользования сервисом. Идентификаторы разделены запятыми. Например:

        2,1,3
        1,4,3
        2,2,2,2,2,3

На основе этих данных реализуйте алгоритм рекомендаций, который бы для списка просмотров конкретного пользователя рекомендовал следующий фильм. 

Алгоритм выбора рекомендации:

1. Для просмотров пользователя из историй по всем пользователям выбираются те, у которых хотя бы половина фильмов совпадает с заданной. (То есть, выбираются все пользователи, которые посмотрели минимум половину фильмов пользователя, для которого формируется рекомендация.)

2. Из отобранных списков исключаются все, которые пользователь уже посмотрел.

3. Для оставшегося списка фильмов подсчитывается суммарное количество просмотров среди всех пользователей сервиса и фильм с максимальным числом просмотров выбирается как рекомендация (если таких фильмов оказалось несколько, выбирается любой из них).

Список просмотров текущего пользователя задается через пользовательский ввод, рекомендация выдается в виде названия фильма в System.out. Пути к файлам с названиями фильмов и истории просмотров пользователей сервиса могут быть определены в виде констант в приложении.

### Пример:

[in]
2,4

[out]
Дюна

Задача Б2 (вне зачета)
========================
Посчитайте приближенное (с заданной точностью) значение числа π при помощи ряда Лейбница: 



Считаем, что точность в N знаков обеспечивается 10^N слагаемыми ряда. Количество потоков и точность задается с клавиатуры или передается в args-параметрах.
В решении задачи постарайтесь максимально утилизировать концепции ExecutorService и Future.
