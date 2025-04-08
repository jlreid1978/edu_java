public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        System.out.println("Adding elements...");
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println("List: " + list); // [Apple, Banana, Cherry]

        System.out.println("\nAdding at index 1:");
        list.add(1, "Blueberry");
        System.out.println("List: " + list); // [Apple, Blueberry, Banana, Cherry]

        System.out.println("\nContains 'Banana'? " + list.contains("Banana")); // true
        System.out.println("Index of 'Cherry': " + list.indexOf("Cherry"));   // 3

        System.out.println("\nRemoving 'Blueberry'...");
        list.remove("Blueberry");
        System.out.println("List: " + list); // [Apple, Banana, Cherry]

        System.out.println("\nRemoving at index 0...");
        String removed = list.remove(0);
        System.out.println("Removed: " + removed);
        System.out.println("List: " + list); // [Banana, Cherry]

        System.out.println("\nSetting index 1 to 'Date'...");
        list.set(1, "Date");
        System.out.println("List: " + list); // [Banana, Date]

        System.out.println("\nClearing list...");
        list.clear();
        System.out.println("Is empty? " + list.isEmpty()); // true
        System.out.println("List: " + list); // []

        System.out.println("\nTesting equals method...");
        LinkedList<String> list1 = new LinkedList<>();
        LinkedList<String> list2 = new LinkedList<>();
        list1.add("One");
        list1.add("Two");
        list2.add("One");
        list2.add("Two");
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);
        System.out.println("list1 equals list2? " + list1.equals(list2)); // true
    }
}
