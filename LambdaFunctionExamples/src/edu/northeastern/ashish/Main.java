package edu.northeastern.ashish;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
//        Function<String, String> reverseString = s -> {
//            char[] arr = s.toCharArray();
//            int start = 0;
//            int end = arr.length -1;
//            while(start < end){
//                char temp = arr[start];
//                arr[start] = arr[end];
//                arr[end] = temp;
//                start++;
//                end--;
//            }
//            return String.valueOf(arr);
//        };
//
//        System.out.println(reverseString.apply("ABCD") );
//
//
//        BiFunction<String, Integer , Character> findNthCharString = (s,n) ->{
//            n = n-1;
//            if(n >= s.length()){
//                return '\0';
//            }
//            return s.charAt(n);
//        };
//
//        System.out.println(findNthCharString.apply("ABCD", 3) );
//
//        String str = "My Name is Ashish"; // Remove all spaces and get every other char "MNmiAhs"
//        //String str1 = "MNmiAhs";
//
//        Function<String, String > getEverySecondChar = s -> {
//            s = s.replace(" ", "");
//            StringBuilder sb = new StringBuilder();
//            for(int i = 0 ; i < s.length(); i = i + 2){
//                sb.append(s.charAt(i));
//            }
//            return sb.toString();
//        };
//
//        System.out.println(getEverySecondChar.apply(str) );

       // streamExamples();
        studentExamples();

    }


    private static void streamExamples() {

        ArrayList<String> names = new ArrayList<>();
        names.add("Ashish");
        names.add("amber");
        names.add("amanda");
        names.add("Rahul");
        names.add("rajni");
        names.add("jay");
        names.add("Khusbu");
        names.add("Maggi");
        names.add("ping");
        names.add("Cun");

//        for (String str : names) {
//            String upper = str.substring(0, 1).toUpperCase() + str.substring(1);
//            System.out.println(upper);
//        }
        ArrayList<String> StartsWithAAndUppercase = (ArrayList<String>) names.stream()
                .map(str -> str.substring(0, 1).toUpperCase() + str.substring(1))
                .filter(s -> s.startsWith("A")).collect(Collectors.toList());

        Integer[] arr = {-1,2,3,-2,4,-5,6,8};

        ArrayList<Integer> list =new ArrayList<>() ;;//
        list.addAll(Arrays.asList(arr));

        list = (ArrayList<Integer>) list.stream()
                .map(i -> i < 0 ? i*-1 : i)
                .collect(Collectors.toList());



        System.out.println();

        Date start = new Date();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date end = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String strStart =sdf.format(start);
        String strEnd =sdf.format(end);
        System.out.println();

        ArrayList<Date> dates = new ArrayList<>();
        dates.add(end);
        dates.add(start);

        Collections.sort(dates, new Comparator<Date>() {
            @Override
            public int compare(Date date1, Date date2) {
                return date1.compareTo(date2);
            }
        });
       // Collections.sort(list,(date1, date2) ->  date1.compareTo(date2) );

        for (Date date: dates) {
            System.out.println(sdf.format(date));
        }

       // dates.stream().forEach(date -> System.out.println(sdf.format(date)));



        ArrayList<String> strings = new ArrayList<>();
        strings.add("Mark");
        strings.add("Ashish");

        Collections.sort(dates, (date1, date2) -> date1.compareTo(date2));

        for (Date date: dates) {
            System.out.println(sdf.format(date));
        }

        dates.stream().forEach(date -> System.out.println(sdf.format(date)));
        System.out.println();



    }


    private static void studentExamples(){
        Student student1 = new Student("Student1", 23);
        addSleep();
        Student student2 = new Student("Student2", 25);
        addSleep();
        Student student3 = new Student("Student3", 34);
        addSleep();
        Student student4 = new Student("Student4", 18);
        addSleep();
        Student student5 = new Student("Student5", 22);
        addSleep();
        Student student6 = new Student("Student6", 23);
        addSleep();
        Student student7 = new Student("Student7", 32);
        addSleep();
        Student student8 = new Student("Student8", 30);
        addSleep();
        Student student9 = new Student("Student9", 19);
        addSleep();
        Student student10 = new Student("Student10", 21);
        addSleep();

        student4.graduationDate = new Date();
        addSleep();
        student7.graduationDate = new Date();
        addSleep();
        student2.graduationDate = new Date();

        Student[] arr = {student1, student2, student3, student4, student5, student6, student7, student8, student9, student10};
        ArrayList<Student> students = new ArrayList<>();
        students.addAll(Arrays.asList(arr));


        students.stream()
                .sorted( ( st1, st2) ->  st1.getAge().compareTo(st2.getAge()) ).
                forEach(student -> System.out.println(student.name + " Age " + student.age));

        students.stream()
                .sorted((st1, st2) -> st1.startDate.compareTo(st2.startDate))
                .forEach(student -> System.out.println(student.name + " Age " + student.age));

        System.out.println("*******************");
        students.stream()
                .filter(student -> student.graduationDate != null)
                .sorted((st1, st2) -> st1.graduationDate.compareTo(st2.graduationDate))
                .forEach(student -> System.out.println(student.name + " Age " + student.age));





    }

    private static void addSleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
