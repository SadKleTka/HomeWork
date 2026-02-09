package HomeWork2;

import java.util.*;

public class PractiseWorkHW2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Number 1
        /*
        List<Integer> list = new ArrayList<>(
                List.of(1, 2, 2, 3, 3 ,4 ,4, 5)
        );
        numberOne(list).forEach(System.out::print);

        //Number 2
        Set<String> set = new HashSet<>(
                Arrays.asList("Amir", "Maks", "Ulana", "Chyngyz", "Diana")
        );
        System.out.println(numberTwo(set, scan));

        //Number 3
        Set<Integer> set = new HashSet<>(
                List.of(1, 2, 2, 3, 3 ,4 ,4, 5)
        );
        System.out.println(numberThree(set));
         */

        //Number 4
        /*
        Set<String> set = new HashSet<>(
                Arrays.asList("Amir", "Maks", "Ulana", "Chyngyz", "Diana")
        );
        for (Map.Entry<Boolean, Set<String>> map : numberFour(set).entrySet()) {
            System.out.println(map.getKey());
            System.out.println(map.getValue());
        }
         */

        //Number 5
        /*
        Set<Integer> set = new HashSet<>(
                List.of(1, 2, 2, 3, 3 ,4 ,4, 5)
        );
        numberFive(set).forEach(System.out::println);
         */

        //Number 6
        /*
        Set<Integer> set = new HashSet<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
        );
        Set<Integer> set2 = new HashSet<>(
                List.of(1, 2, 2, 3, 3 ,4 ,4, 5,6 ,7 , 8, 9, 20)
        );
        numberSix(set, set2).forEach(System.out::println);
         */

        //Number 7
        /*
        Set<Integer> set = new HashSet<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
        );
        Set<Integer> set2 = new HashSet<>(
                Arrays.asList(1, 2, 2, 3, 3 ,4 ,4, 5,6 ,7 , 8, 9, 20)
        );
        numberSeven(set, set2).forEach(System.out::println);
         */

        //Number 8
        /*
        Set<Integer> set = new HashSet<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
        );
        Set<Integer> set2 = new HashSet<>(
                Arrays.asList(1, 2, 2, 3, 3 ,4 ,4, 5,6 ,7 , 8, 9, 20)
        );
        Map<Boolean, String> map = numberEight(set, set2);
        map.keySet().forEach(System.out::print);
        System.out.print(" - ");
        map.values().forEach(System.out::print);
         */

        //Number 9
        /*
        String sentence = "Napoleon captured a Moscow";
        numberNine(sentence).forEach(System.out::println);

        //Number 10
        String[] str = new String[] {"APPLE", "AppLe", "APPle", "apple"};
        numberTen(str).forEach(System.out::println);

        //Number 11
        ArrayDeque<Integer> deque = new ArrayDeque<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        );
        for (Map.Entry<ArrayDeque<Integer>, Set<Integer>> map : numberEleven(deque).entrySet()) {
            map.getValue().forEach(System.out::println);
            System.out.println(map.getKey().isEmpty());
        }

        //Number 12
        Stack<String> stack = new Stack<>();
        stack.push("apple");
        stack.push("banana");
        stack.push("orange");
        numberTwelve(stack);


        //Number 13
        numberThirteen();
         */

        //Number 14
        /*
        numberFourteen().forEach(System.out::println);

        //Number 15
        numberFifteen();

        //Number 16
        numberSixteen();

        //Number 17
        numberSeventeen();

        //Number 18
        numberEighteen();
         */

        //Number 19
        /*
        numberNineteen();

        //Number 20
        numberTwenty();
         */

        //Number 21
        numberTwentyOne();



    }
    public static void numberTwentyOne() {
        ArrayDeque<String> tasks = new ArrayDeque<>();

        addTask(tasks, "Homework", false);
        addTask(tasks, "Feed a dog", true);
        addTask(tasks, "Read book", false);

        while (!tasks.isEmpty()) {
            System.out.println(processTask(tasks));
        }
    }

    public static void addTask(ArrayDeque<String> tasks, String task, boolean highPriority) {
        if (highPriority) tasks.offerFirst(task);
        else tasks.offerLast(task);
    }

    public static String processTask(ArrayDeque<String> tasks) {
        return tasks.pollFirst();
    }

    public static void numberTwenty() {
        Deque<Integer> deque = new ArrayDeque<>(Arrays.asList(1, 2, 3));
        deque.clear();
        System.out.println(deque.peek());
        System.out.println(deque.isEmpty());
    }

    public static void numberNineteen() {
        Deque<Integer> deque = new ArrayDeque<>(Arrays.asList(1, 2, 3));
        deque.clear();
        System.out.println(deque.isEmpty());
    }

    public static void numberEighteen() {
        Deque<Integer> deque = new ArrayDeque<>();
        System.out.println(deque.size() + " " + deque.isEmpty());

        deque.offerFirst(1);
        System.out.println(deque.size() + " " + deque.isEmpty());

        deque.offerLast(2);
        System.out.println(deque.size() + " " + deque.isEmpty());

        deque.pollFirst();
        System.out.println(deque.size() + " " + deque.isEmpty());

        deque.pollLast();
        System.out.println(deque.size() + " " + deque.isEmpty());
    }

    public static void numberSeventeen() {
        Deque<String> deque = new ArrayDeque<>(Arrays.asList("a", "b", "c", "b", "a"));

        deque.removeFirstOccurrence("b");
        System.out.println(deque);

        deque.removeLastOccurrence("a");
        System.out.println(deque);
    }

    public static void numberSixteen() {
        Deque<Integer> deque = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4, 5));

        while (!deque.isEmpty()) {
            System.out.print(deque.poll() + " ");
        }
        System.out.println();
    }

    public static void numberFifteen() {
        Deque<String> deque = new ArrayDeque<>(
                Arrays.asList("A", "B", "C")
        );
        System.out.println(deque.peek());
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());

        Deque<String> empty = new ArrayDeque<>();
        System.out.println(empty.peek());
        System.out.println(empty.peekFirst());
        System.out.println(empty.peekLast());
    }

    public static Deque<String> numberFourteen() {
        Deque<String> deque = new ArrayDeque<>();
        System.out.println(deque.offerFirst("1"));
        System.out.println(deque.offerLast("2"));
        return deque;
    }

    public static void numberThirteen() {
        Stack<Integer> st = new Stack<>();
        for (int i = 1; i < 5; i++) {
            st.addLast(i);
        }
        st.addFirst(0);
        for (Integer integer : st) {
            System.out.print(integer + " ");
        }
    }

    public static void numberTwelve(Stack<String> stack) {
        int num = stack.size();
        for (int i = 0; i < num; i++) {
            System.out.println(stack.pop());
        }
        System.out.println(stack.isEmpty());
    }

    public static Map<ArrayDeque<Integer>, Set<Integer>> numberEleven(ArrayDeque<Integer> deque) {
        Map<ArrayDeque<Integer>, Set<Integer>> map = new HashMap<>();
        int num = deque.size();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < num; i++) {
            set.add(deque.poll());
        }
        map.put(deque, set);
        return map;
    }

    public static Set<String> numberTen(String[] str) {
        Set<String> set = new HashSet<>();
        for (String i : str) {
            set.add(i.toLowerCase());
        }
        return set;
    }

    public static Set<String> numberNine(String sentence) {
        return new HashSet<>(
                List.of(sentence.split(" "))
        );
    }

    public static Map<Boolean, String> numberEight(Set<Integer> set, Set<Integer> set2) {
        Map<Boolean, String> map = new HashMap<>();
        map.put(set.containsAll(set2), "Friendly Message");
        return map;
    }

    public static Set<Integer> numberSeven(Set<Integer> set, Set<Integer> set2) {
        set.retainAll(set2);
        return set;
    }

    public static Set<Integer> numberSix(Set<Integer> set, Set<Integer> set2) {
        set.removeAll(set2);
        return set;
    }

    public static Set<Integer> numberFive(Set<Integer> set) {
        return new HashSet<>(set);
    }

    public static HashMap<Boolean, Set<String>> numberFour(Set<String> set) {
        HashMap<Boolean, Set<String>> map = new HashMap<>();
        map.put(set.remove("Amir"), set);
        return map;
    }

    public static boolean numberThree(Set<Integer> set) {
        System.out.println(set.size());
        set.clear();
        return set.isEmpty();
    }

    public static boolean numberTwo(Set<String> set, Scanner scan) {
        System.out.println();
        System.out.print("Enter name: ");
        String name = scan.nextLine();
        return set.add(name);
    }


    public static Set<Integer> numberOne(List<Integer> list) {
        return new  HashSet<>(list);
    }



}
