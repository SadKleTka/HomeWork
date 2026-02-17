package HomeWork3;

import java.util.*;

public class PractiseWorkHW3 {

    public static void main(String[] args) {

        // Number 1.
        Map<String, Integer> map = n1();

        // Number 2.
        n2(map);

        // Number 3.
        n3(map);

        // Number 4.
        n4(map);

        // Number 5.
        n5(map);

        // Number 6.
        n6(map);

        // Number 7.
        n7(map);

        // Number 8.
        n8(map);

        // Number 9.
        n9(map);

        // Number 10.
        n10(map);

        // Number 11.
        n11(map);

        // Number 12.
        n12();

        // Number 13.
        n13();

        // Number 14.
        n14();

        // Number 15.
        n15();

        // Number 16.
        n16();

        // Number 17.
        n17();

        // Number 18.
        n18();

        // Number 19.
        n19();

        // Number 20.
        n20();

        // Number 21.
        n21();

        // Number 22.
        n22();
    }

    static Map<String, Integer> n1() {
        Map<String, Integer> m = new HashMap<>();
        m.put("Aida", 85);
        m.put("Azat", 92);
        m.put("Dana", 77);
        System.out.println(m + " size=" + m.size());
        return m;
    }

    static void n2(Map<String, Integer> m) {
        System.out.println("Aida=" + m.get("Aida"));
        System.out.println(m.containsKey("Mira") ? "Mira=" + m.get("Mira") : "Mira not found");
    }

    static void n3(Map<String, Integer> m) {
        Integer old = m.put("Dana", 80);
        System.out.println("Dana old=" + old + ", new=" + m.get("Dana"));
    }

    static void n4(Map<String, Integer> m) {
        System.out.println("remove Azat -> " + m.remove("Azat"));
        System.out.println("remove NonExisting -> " + m.remove("NonExisting"));
        System.out.println(m);
    }

    static void n5(Map<String, Integer> m) {
        System.out.println("isEmpty before=" + m.isEmpty());
        m.clear();
        System.out.println("isEmpty after=" + m.isEmpty());

        m.put("Aida", 85);
        m.put("Azat", 92);
        m.put("Dana", 80);
    }

    static void n6(Map<String, Integer> m) {
        check(m, "Mira");
        check(m, "Aida");
        check(m, "NonExisting");
    }

    static void check(Map<String, Integer> m, String name) {
        int v = m.getOrDefault(name, -1);
        System.out.println(name + ": " + (v == -1 ? "Not found" : v));
    }

    static void n7(Map<String, Integer> m) {
        m.putIfAbsent("Aida", 90);
        m.putIfAbsent("Mira", 88);
        System.out.println(m);
    }

    static void n8(Map<String, Integer> m) {
        System.out.println("cond replace -> " + m.replace("Aida", 85, 86));
        System.out.println("uncond old -> " + m.replace("Aida", 91));
        System.out.println("missing -> " + m.replace("Missing", 100));
        System.out.println(m);
    }

    static void n9(Map<String, Integer> m) {
        System.out.println("keys=" + m.keySet());
        System.out.println("vals=" + m.values());
        for (Map.Entry<String, Integer> e : m.entrySet()) {
            System.out.println(e.getKey() + "=" + e.getValue());
        }
    }

    static void n10(Map<String, Integer> m) {
        int c = 0;
        for (int v : m.values()) if (v >= 80) c++;
        System.out.println(">=80: " + c);
    }

    static void n11(Map<String, Integer> m) {
        int max = Integer.MIN_VALUE;
        List<String> names = new ArrayList<>();
        for (Map.Entry<String, Integer> e : m.entrySet()) {
            int v = e.getValue();
            if (v > max) {
                max = v;
                names.clear();
                names.add(e.getKey());
            } else if (v == max) {
                names.add(e.getKey());
            }
        }
        System.out.println("max=" + max + " -> " + names);
    }

    static void n12() {
        String s = "Java is fun and Java is powerful and fun";
        Map<String, Integer> f = new HashMap<>();
        for (String w : s.toLowerCase().split("\\s+")) f.put(w, f.getOrDefault(w, 0) + 1);
        System.out.println(f);
    }

    static void n13() {
        String s = "Mississippi".toLowerCase();
        Map<Character, Integer> f = new HashMap<>();
        for (char ch : s.toCharArray()) if (Character.isLetter(ch)) f.put(ch, f.getOrDefault(ch, 0) + 1);

        char best = 0;
        int bestC = -1;
        for (Map.Entry<Character, Integer> e : f.entrySet()) {
            if (e.getValue() > bestC) {
                bestC = e.getValue();
                best = e.getKey();
            }
        }
        System.out.println(f);
        System.out.println("most=" + best + " (" + bestC + ")");
    }

    static void n14() {
        List<String> ws = Arrays.asList("hi", "book", "java", "sun", "loop", "map");
        Map<Integer, List<String>> g = new HashMap<>();
        for (String w : ws) g.computeIfAbsent(w.length(), k -> new ArrayList<>()).add(w);
        System.out.println(g);
    }

    static void n15() {
        String s = "swiss";
        Map<Character, Integer> f = new HashMap<>();
        for (char ch : s.toCharArray()) f.put(ch, f.getOrDefault(ch, 0) + 1);

        Character ans = null;
        for (char ch : s.toCharArray()) if (f.get(ch) == 1) { ans = ch; break; }
        System.out.println(ans == null ? "None" : ans);
    }

    static void n16() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        Map<Integer, Integer> idx = new HashMap<>();
        int a = -1, b = -1;

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (idx.containsKey(need)) { a = idx.get(need); b = i; break; }
            idx.put(nums[i], i);
        }
        System.out.println(a == -1 ? "No pair" : a + ", " + b);
    }

    static void n17() {
        List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana", "kiwi");
        Map<String, Integer> f = new HashMap<>();
        for (String x : items) f.put(x, f.getOrDefault(x, 0) + 1);

        List<String> uniq = new ArrayList<>();
        Map<String, Integer> dup = new HashMap<>();
        for (Map.Entry<String, Integer> e : f.entrySet()) {
            if (e.getValue() == 1) uniq.add(e.getKey());
            else dup.put(e.getKey(), e.getValue());
        }

        System.out.println("unique=" + uniq);
        System.out.println("dup=" + dup);
    }

    static void n18() {
        Map<String, Integer> a = new HashMap<>();
        a.put("Aida", 85);
        a.put("Azat", 92);
        a.put("Dana", 80);

        Map<String, Integer> b = new HashMap<>();
        b.put("Dana", 80);
        b.put("Aida", 85);
        b.put("Azat", 92);

        System.out.println("equals=" + a.equals(b));
        System.out.println("hash=" + a.hashCode() + " / " + b.hashCode());
    }

    static void n19() {
        Map<String, Integer> m = new HashMap<>();
        m.put("Aida", 55);
        m.put("Azat", 92);
        m.put("Dana", 59);
        m.put("Mira", 60);

        Iterator<Map.Entry<String, Integer>> it = m.entrySet().iterator();
        while (it.hasNext()) if (it.next().getValue() < 60) it.remove();
        System.out.println(m);
    }

    static void n20() {
        Map<String, Integer> s1 = new HashMap<>();
        s1.put("Aida", 40);
        s1.put("Azat", 35);
        s1.put("Dana", 50);

        Map<String, Integer> s2 = new HashMap<>();
        s2.put("Azat", 10);
        s2.put("Dana", 5);
        s2.put("Mira", 45);

        for (Map.Entry<String, Integer> e : s2.entrySet()) {
            s1.merge(e.getKey(), e.getValue(), Integer::sum);
        }
        System.out.println(s1);
    }

    static void n21() {
        Map<String, Integer> st = new HashMap<>();
        st.put("Aida", 85);
        st.put("Azat", 92);
        st.put("Dana", 85);
        st.put("Mira", 92);

        Map<Integer, List<String>> inv = new HashMap<>();
        for (Map.Entry<String, Integer> e : st.entrySet()) {
            inv.computeIfAbsent(e.getValue(), k -> new ArrayList<>()).add(e.getKey());
        }
        System.out.println(inv);
    }

    static void n22() {
        String s = "Java is fun and Java is powerful and fun and fun";
        Map<String, Integer> f = new HashMap<>();

        for (String w : s.toLowerCase().split(" ")) {
            f.put(w, f.getOrDefault(w, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(f.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        System.out.println("top1=" + list.get(0));
        System.out.println("top2=" + list.get(1));
    }

}

