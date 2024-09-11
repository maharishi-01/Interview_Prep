package StreamPrep;



import java.util.*;
import java.util.stream.Collectors;


class Student {
    private Integer id;
    private String name;
    private Double marks;

    Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(Integer id, String name, Double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public Double getMarks() {
        return marks;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}

public class StreamPractice {

    public static void main(String[] args) {

        //totalSum();

        //maxElement();

        //findString();

        //convertToUpperCase();

        //filterEvenOdd();

        //calAvg();

        //sortedStudent();

        //concatString();

        // findFreqOfEachWord();

        // mapByFirstLetter();

        //getDuplicates();

        // studentReport();

        //flattingList();

        sortMap();


    }

    // --> for concatenation or joining of list of string into single string
    private static void concatString() {
        List<String> list = Arrays.asList("Rishi", "Raj", "Aman", "Kumar", "Joker", "BatMan");
        String str = list.stream().collect(Collectors.joining(","));
        System.out.println(str);
    }


    // --> Sort list of student based on name
    private static void sortedStudent() {
        List<Student> studentList = Arrays.asList(new Student(1, "Rishi"), new Student(2, "Aman"), new Student(3, "Amit"), new Student(4, "Rakesh"));
        List<Student> newList = studentList.stream().sorted((Student s1, Student s2) -> s1.getName().compareTo(s2.getName())).collect(Collectors.toList());
        System.out.println(newList);
    }

    // --> calculate average of list of numbers
    private static void calAvg() {
        List<Integer> list = Arrays.asList(2, 4, 5, 2, 7, 7, 4, 8);

        //System.out.println(list.stream().reduce((curr,total)->total+curr).map(a->a/list.stream().count()).get());

        Double avg = list.stream().mapToDouble(a -> a).average().getAsDouble();

        System.out.println(avg);
    }


    // --> print odd and even
    private static void filterEvenOdd() {
        List<Integer> list = Arrays.asList(2, 4, 5, 2, 7, 7, 4, 8);
        System.out.println(list.stream().filter(a -> a % 2 != 0).collect(Collectors.toList()));
        System.out.println(list.stream().filter(a -> a % 2 == 0).count());


    }


    // --> convert list of string to uppercase
    private static void convertToUpperCase() {
        List<String> list = Arrays.asList("dkdkd", "dkdkd", "ieehe", "dkdh", "sgeeb");
        List<String> newList = list.stream().map(a -> a.toUpperCase()).collect(Collectors.toList());
        System.out.println(newList);
    }


    // --> find the string which starts with "apple"
    private static void findString() {
        List<String> list = Arrays.asList("apqle", "applejuice", "applesake", "applepie", "orange", "malta");
        List<String> newList = list.stream().filter((a) -> a.startsWith("apple")).collect(Collectors.toList());
        System.out.println(newList);
    }


    // --> find the maxim ele from the list
    private static void maxElement() {
        List<Integer> list = Arrays.asList(4, 2, 1, 6, 45, 23, 67, 89, 0);
        int max = list.stream().max((a, b) -> a - b).get();
        System.out.println(max);
    }


    // --> get total sum of list
    private static void totalSum() {
        List<Integer> list = Arrays.asList(3, 5, 2, 9, 5);
        int sum = list.stream().reduce((curr, total) -> total + curr).get();

        System.out.println(sum);
    }


    // --> find frequency of each word present in string
    private static void findFreqOfEachWord() {
        String str = "Java is the best programming language. you can learn Java from geeks for geeks";
        System.out.println(Arrays.stream(str.split("\\s")).collect(Collectors.groupingBy(a -> a, Collectors.counting())));
    }

    // --> map based on first letter of string present in list
    private static void mapByFirstLetter() {
        List<String> list = Arrays.asList("Radha", "Ram", "Krishna", "Kartikya", "Ravan", "Ganesha");
        System.out.println(list.stream().collect(Collectors.groupingBy(a -> a.charAt(0), Collectors.counting())));

    }

    // --> find element who occur more than 1
    private static void getDuplicates() {
        List<Integer> list = Arrays.asList(1, 1, 2, 2, 2, 3, 2, 5, 5, 6, 8, 7, 8);
        System.out.println(list.stream().filter(a -> Collections.frequency(list, a) > 1).collect(Collectors.toSet()));
    }


    // --> map student report passing criteria average of all student's marks
    private static void studentReport() {

        List<Student> studentList = Arrays.asList(
                new Student(1, "rishi", 45.0),
                new Student(2, "Ravi", 78.0),
                new Student(3, "sakir", 59.5),
                new Student(4, "limi", 63.2),
                new Student(5, "ruby", 55.1)
        );

        //Map<String, List<Student>> report = studentList.stream().collect(Collectors.groupingBy(stu -> stu.getMarks() >= 70 ? "Pass" : "Fail"));
        Map<String, List<Student>> report = studentList.stream().collect(Collectors.groupingBy(student -> student.getMarks() >= studentList.stream().mapToDouble(a -> a.getMarks()).average().getAsDouble() ? "Pass" : "Fail"));
        for (Map.Entry<String, List<Student>> e : report.entrySet()) {
            System.out.println(e.getKey() + " --> " + e.getValue());
        }

    }


    // --> using of flatmap
    private static void flattingList() {
        List<List<Integer>> listOfList = Arrays.asList(Arrays.asList(1, 2, 4), Arrays.asList(4, 2, 6), Arrays.asList(0));
        List<Integer> flatList = listOfList.stream().flatMap(a -> a.stream()).collect(Collectors.toList());
        System.out.println(flatList);
    }


    // --> sort the map
    private static void sortMap() {
        List<String> list = Arrays.asList("Java", "C++", "Ruby", "Java", "C", "GO", "Ruby", "RUby", "Java");

        // step:- 1 store in HashMap key-> word and value-> frequency of word in list

        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(a -> a, Collectors.counting()));

        // step:-2  sort the HashMap based on key in increasing order....

        map = map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(TreeMap::new, (treeMap, entry) -> treeMap.put(entry.getKey(), entry.getValue()), TreeMap::putAll);

        //map = map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldVal, newVal) -> oldVal, TreeMap::new));

        map.forEach((key, value) -> System.out.println(key + " " + value));
    }


}


