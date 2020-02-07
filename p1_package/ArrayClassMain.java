package p1_package;

public class ArrayClassMain
    {

        public static void main(String[] args)
            {
                ArrayClass a1 = new ArrayClass();
                a1.appendItem(1);
                a1.appendItem(3);
                a1.insertItemAt(1, 2);
                a1.appendItem(4);
                a1.removeItemAt(3);
                a1.resize(3);
                a1.clear();
                boolean checkerE = a1.isEmpty();
                boolean checkerF = a1.isFull();

                int size = a1.getCurrentSize();
                int cap = a1.getCurrentCapacity();

                System.out.println("Test Values:");

                System.out.print("[");
                for (int index = 0; index < a1.getCurrentSize(); index++)
                    {
                        int value = a1.accessItemAt(index);
                        System.out.print(value + " ");
                    }
                System.out.println("]");

                System.out.println("isFull:" + checkerF);
                System.out.println("isEmpty:" + checkerE);
                System.out.println("Size:" + size);
                System.out.println("Capacity:" + cap);

            }

    }
