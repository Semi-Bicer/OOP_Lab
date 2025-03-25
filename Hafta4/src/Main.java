public class Main {
    public static void main(String[] args) {
        Rectangle d1 = new Rectangle(5, 12);

        d1.setShortEdge(5);
        System.out.println(d1.getShortEdge());


        Rectangle d2 = new Rectangle(-4, 5);

        System.out.println(d2.getLongEdge());
        System.out.println(d2.circumference());
        System.out.println(d2.area());


        d2.info(); // d2 parametlerinden birisi negatif olduğu için shortEdge 0 tanımlı kalmıştır.
    }
}