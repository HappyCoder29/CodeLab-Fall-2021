package edu.northeastern.ashish;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        String[] arr = {"Abd", "abd", "awf","adf","adf", "fgtbgt"};
        list.addAll(Arrays.asList(arr));
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

       ArrayList<String> test = (ArrayList<String>) list.stream().sorted((str1, str2) -> str1.compareTo(str2))
               .collect(Collectors.toList());

        for (String str: list) {
            System.out.println(str);
        }

        String str = "cccaabbbb";
        System.out.println(sortBasedOnFrequency(str));

        employeeExample();


    }

    private static void employeeExample(){
        Employee Mark = new Employee("Mark Bruce", 67);
        Employee Ashish = new Employee("Ashish Singh", 21);
        Employee John = new Employee("John Mercer", 56);
        Employee Peter = new Employee("Peter Hambling", 21);
        Employee Tom = new Employee("Tom Serecy", 58);
        Employee Sara = new Employee("Sara Smith", 32);
        Employee Beth = new Employee("Beth Clinton", 45);

        ArrayList<Employee> listEmployees = new ArrayList<>();
        listEmployees.add(Ashish);
        listEmployees.add(John);
        listEmployees.add(Peter);
        listEmployees.add(Tom);
        listEmployees.add(Mark);
        listEmployees.add(Sara);
        listEmployees.add(Beth);

        Collections.sort(listEmployees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        Collections.sort(listEmployees, (employee1, employee2) -> employee1.getAge() - employee1.getAge() );

        for (Employee emp: listEmployees
             ) {
            System.out.println(emp.getName() + " Age " + emp.getAge());

        }

        Function<String, String> makeUpperCase = (String str) ->{
            return str.toUpperCase();
        };
        String upper =  makeUpperCase.apply("Ashish");
        System.out.println(upper);

        Integer[] arr = {1,2,3,4,-1,5,6,7,-2,5};

        BiFunction<Integer[], Integer , Integer > doesArrayContainNegativeValue
                = (Integer[] arrBiFunc, Integer end )->{
            for(int i = 0 ; i < end ; i ++){
                if(arrBiFunc[i] == -1){
                    return i;
                }
            }
            return -1;
        };

        Integer index = doesArrayContainNegativeValue.apply(arr, 5);

        System.out.println(index);





    }

    private static String makeUpper(String str){
        return  str.toUpperCase();
    }

    private static String sortBasedOnFrequency(String str){

        HashMap<Character, Integer> map = new HashMap<>();
        for (Character ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) +1);
        }

        Set<Character>  entries = map.keySet();
        List<Character> characters = new ArrayList<>(entries);
        //Collections.sort(characters,  (entry1, entry2) -> map.get(entry1) - map.get(entry2));

        Collections.sort(characters, new Comparator<Character>() {
            @Override
            public int compare(Character ch1, Character ch2) {
                return map.get(ch1) - map.get(ch2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Character ch : characters) {
            for(int i = 0 ; i < map.get(ch); i ++){
               sb.append(Character.toString(ch)) ;
            }
        }


        return sb.toString();
    }
}
