package p2_package;

public class StudentClassMain
    {

        public static void main(String[] args)
            {
                GenericArrayClass<StudentClass> testObj = new GenericArrayClass<StudentClass>();
                StudentClass student1 = new StudentClass("Jerry", 132, 'M', 2.8);
                StudentClass student2 = new StudentClass("Ben", 123, 'M', 3.8);
                StudentClass student3 = new StudentClass("Janessa", 321, 'F', 4.0);
                StudentClass student4 = new StudentClass("Zach", 532, 'M', 3.1);

                testObj.appendItem(student4);
                testObj.appendItem(student3);
                testObj.appendItem(student2);
                testObj.insertItemAt(0, student1);

                

                for (int i = 0; i < testObj.getCurrentSize(); i++)
                    {
                        System.out.println(testObj.accessItemAt(i).toString());
                        System.out.println("1");
                    }

            }

    }
