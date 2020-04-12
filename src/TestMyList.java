public class TestMyList {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<Integer>();
        myList.add(1, 0);
        myList.add(2, 1);
        myList.add(3);
        System.out.println(myList.get(2));
        myList.remove(1);
        System.out.println(myList.get(1));
        myList.clone();
    }
}
