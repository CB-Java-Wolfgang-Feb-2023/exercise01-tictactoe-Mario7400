package Queue;

public class Program {
    public static void main(String[] args) {

        // Array Größe --> 5
        Queue queue = new Queue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        queue.printQueue();
        System.out.println("****************************************");
        System.out.println(" ");

        System.out.println(queue.peek());
        queue.printQueue();
        System.out.println("Wert '1' wird nach dem 'first in - first out Prinzip' ausgegeben ohne diesen zu löschen --> 'value front ändert sich nicht!'");
        System.out.println("****************************************");
        System.out.println(" ");

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.printQueue();
        System.out.println("Wert '1' und '2' werden nach dem 'first in - first out Prinzip' ausgegeben --> 'value front' ändert sich!");
        System.out.println("****************************************");
        System.out.println(" ");


        queue.enqueue(6); // wird die Array Größe überschritten --> new int[size*2] --> Array Größe verdoppelt
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
        queue.printQueue();
        System.out.println("Weitere Werte werden hinzugefügt --> rear überschreitet die Array size --> Array Größe verdoppelt sich!");
        System.out.println("****************************************");
        System.out.println(" ");


        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.printQueue();
        System.out.println("Array ist nun 'leer'!");
        System.out.println("****************************************");
        System.out.println(" ");

        // Error if Array is empty:
//        System.out.println(queue.dequeue());

    }
}
