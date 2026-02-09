package HomeWork1;

import java.util.*;

public class PractiseWorkHW {
    public static void main(String[] args) {
        //Number 1.
        /*
        List<String> bList1 = new ArrayList<>(
                List.of("Pride and Prejudice", "The Picture of Dorian Gray", "The Adventures of Sherlock Holmes",
                        "To Kill a Mockingbird", "The Hobbit"));
        List<String> bList2 = new ArrayList<>(
                List.of("The Hobbit", "Alice in Wonderland", "The Little Prince", "Pride and Prejudice",
                        "To Kill a Mockingbird", "Bridget Jones' Diary")
        );
        numberOne(bList1, bList2).forEach(System.out::println);
         */

        //Number 2.
        /*
        List<String> list = new ArrayList<>(
                List.of("Avengers", "Harry Potter", "I'm a robot",
                        "Truman's show", "Bad boys")
        );
        numberTwo(list).forEach(System.out::println);
         */

        //Number 3.
        /*
        List<String> list = new ArrayList<>(
                List.of("pizza", "apple", "burger",
                        "Pizza", "shawarma", "sushi")
        );
        System.out.println(numberThree(list));
         */

        //Number 4.
        /*
        List<String> list = new ArrayList<>(
                List.of("Banana", "banana", "orange", "apple")
        );
        numberFour(list).forEach(System.out::println);
         */

        //Number 5.
        /*
        List<String> list = new ArrayList<>(
                List.of("black", "Black", "white", "orange")
        );
        numberFive(list).forEach(System.out::println);
         */

        //Number 6.
        /*
        List<ArrayList<String>> list = new ArrayList<>();
        ArrayList<String> sports = new ArrayList<>(
                List.of("Football", "Basketball", "Volleyball", "Tennis")
        );
        System.out.println(numberSix(list, sports));
         */

        //Number 7.
        /*
        List<String> list = new ArrayList<>(
                List.of("Rose", "Mak", "Flower", "Rose", "Undersnow")
        );
        numberSeven(list).forEach(System.out::println);
         */

        //Number 8.
        /*
        List<String> list = new ArrayList<>(
                List.of("Elephant", "Lion", "Elephant", "Wolf", "Snake")
        );
        numberEight(list).forEach(System.out::println);
         */

        //Number 9.
        /*
        List<String> list = new ArrayList<>(
                List.of("Bishkek", "Moscow", "Mayumi", "New York")
        );
        System.out.println(Arrays.toString(numberNine(list)));
         */


        //Number 10.
        /*
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        numberTen(arr).forEach(System.out::println);
         */

        //Number 11.
        /*
        List<Integer> list = new ArrayList<>(
                List.of(1, 2, 2, 4, 5, 6, 7, 8, 9, 10)
        );
        List<Integer> list2 = new ArrayList<>(
                List.of(1, 2, 2, 2, 2, 6, 7, 8)
        );
        numberEleven(list, list2).forEach(System.out::println);
         */


        //Number 12.
        /*
        List<String> list = new ArrayList<>(
                List.of("Aman", "Maks", "Ulana", "Diera", "Erjan", "Aigerim", "Medina")
        );
        numberTwelve(list).forEach(System.out::println);
         */


        //Number 13.
        /*
        List<String> list = new ArrayList<>(
                List.of("Teeth", "Monster", "Feel Invincible", "Believer")
        );
        System.out.println(numberFourteen(list));
         */

        //Number 14.
        /*
        List<String> list = new ArrayList<>(
                List.of("Animal", "Know", "Job", "Hello")
        );
        String vowels = "eyuioa";
        numberFifteen(list, vowels).forEach(System.out::println);
         */

        //Number 15.
        /*
        List<Integer> list = new ArrayList<>(
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        );
        numberFifteen(list).forEach(System.out::println);
         */

        //Number 16.
        /*
        List<String> list = new ArrayList<>(
                List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        );
        numberSixteen(list).forEach(System.out::println);
         */

        //Number 17.
        /*
        List<String> list = new ArrayList<>(
                Arrays.asList(null, "Azamat", null, "Diana", "Chyngyz", "Aigerim", "Amir")
        );
        numberSeventeen(list).forEach(System.out::println);
         */

        //Number 18.
        /*
        List<String> list = new ArrayList<>(
                Arrays.asList("Word", "Again", "And Again", "Second")
        );
        System.out.println(numberEighteen(list));
         */

        //Number 19.
        /*
        List<String> list = new ArrayList<>(
                Arrays.asList("Apple", "Orange", "Watermelon", "Grapefruit")
        );
        numberNineteen(list).forEach(System.out::println);
         */

        //Number 20.
        String dep1 = "IT";
        String dep2 = "Business";
        List<String> list = new ArrayList<>(
                Arrays.asList("Aman", "Aigerim", "Ulana", "Amir", "Erjan")
        );
        List<String> list2 = new ArrayList<>(
                Arrays.asList("Medina", "Gauhar")
        );
        Map<String, List<String>> map = numberTwenty(dep1, list, dep2, list2);
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
    //20.
    public static Map<String, List<String>> numberTwenty(String dep1, List<String> list, String dep2, List<String> list2) {
        Map<String, List<String>> map = new HashMap<>();
        map.put(dep1, list);
        map.put(dep2, list2);
        return map;
    }



    //19.
    public static List<String> numberNineteen(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, String.valueOf(list.get(i).length()));
        }
        return list;
    }



    //18.
    public static String numberEighteen(List<String> list) {
        String result = "";
        String target = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > result.length()) {
                result = list.get(i);
            }
        }
        list.remove(result);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > target.length()) {
                target = list.get(i);
            }
        }
        return target;
    }



    //17.
    public static List<String> numberSeventeen(List<String> list) {
        list.removeIf(Objects::isNull);
        return list;
    }




    //16.
    public static List<String> numberSixteen(List<String> list) {
        Collections.rotate(list, 2);
        return list;
    }



    //15.
    public static List<List<Integer>> numberFifteen(List<Integer> list) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for (int i = 0; i <= list.size() - 1; i++) {
            if (list.get(i) % 2 == 0)
                even.add(list.get(i));
            else
                odd.add(list.get(i));
        }
        result.add(even);
        result.add(odd);
        return result;
    }



    //14.
    public static List<String> numberFifteen(List<String> list, String vowels) {
        for (Character c : vowels.toCharArray()) {
            list.replaceAll(s -> s.replace(c, '*'));
        }
        return list;
    }



    //13.
    public static String numberFourteen(List<String> list) {
        String res = "Something";
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).length() < list.get(j).length()) {
                    if (res.length() > list.get(i).length())
                        res = list.get(i);
                }
            }
        }
        return res;
    }



    //12.
    public static List<String> numberTwelve(List<String> list) {
        list.removeIf(s -> s.length() % 2 == 0);
        return list;
    }



    //11.
    public static List<Integer> numberEleven(List<Integer> arr, List<Integer> arr2) {
        Collections.sort(arr);
        Collections.sort(arr2);
        List<Integer> list = new ArrayList<>();
        for (Integer integer : arr) {
            for (Integer value : arr2) {
                if (integer.equals(value)) {
                    list.add(integer);
                    break;
                }
            }
        }
        return list;
    }





    //10.
    public static List<Integer> numberTen(int[] arr) {
        Iterator<Integer> iterator = Arrays.stream(arr).iterator();
        List<Integer> list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }




    //9.
    public static String[] numberNine(List<String> list) {
        return list.toArray(new String[0]);
    }






    //8.
    public static List<String> numberEight(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j)))
                    list.remove(list.get(j));
            }
        }
        return list;
    }




    //7.
    public static List<Integer> numberSeven(List<String> list) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equalsIgnoreCase("rose"))
                res.add(i);
        }
        return res;
    }



    //6.
    public static boolean numberSix(List<ArrayList<String>> list, ArrayList<String> str) {
        return list.add(str);
    }




    //5.
    public static List<String> numberFive(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equalsIgnoreCase("black"))
                list.set(i, "white");
        }
        return list;
    }




    //4.
    public static List<String> numberFour(List<String> list) {
        list.removeIf(s -> s.equalsIgnoreCase("banana"));
        return list;
    }




    //3.
    public static int numberThree(List<String> list) {
        int count = 0;
        for (String s : list) {
            if (s.equalsIgnoreCase("pizza")) count++;
        }
        return count;
    }



    //2.
    public static List<String> numberTwo(List<String> list) {
        int max = 0;
        List<String> result = new ArrayList<>();
        for (String s : list) {
            if (s.length() > max) max = s.length();
        }
        for (String s : list) {
            if (s.length() == max) {
                result.add(s);
            }
        }
        return result;
    }


    //1.
    public static Set<String> numberOne(List<String> bList1, List<String> bList2) {
        int i = 0;
        if (bList1.size() >= bList2.size()) {
            Set<String> set = new HashSet<>(bList1);
            set.addAll(bList2);
            return set;
        }
        else {
            Set<String> set = new HashSet<>(bList2);
            set.addAll(bList1);
            return set;
        }
    }
}
