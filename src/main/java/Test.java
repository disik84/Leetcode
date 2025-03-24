import java.io.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

// Конструктор абстрактного класса
//        AbstractClassHeir abstractClassHeir = new AbstractClassHeir("String", 10);
//        abstractClassHeir.testMethod();

// Контанта интерфейса
//        System.out.println(InterfaceTest.CONSTTEST);

//  Сериализация, десеареализация
//        Person person = new Person("Denis", 12);
//        FileOutputStream outputStream = new FileOutputStream("ver.ser");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//        objectOutputStream.writeObject(person);
//        objectOutputStream.close();
//
//        FileInputStream fileInputStream = new FileInputStream("ver.ser");
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//        Person person1 = (Person) objectInputStream.readObject();
//        System.out.println(person1);

// Компоратор
//        Animal myDog = new Dog();
//        Animal myCat = new Cat();
//
//        myDog.sound(); // Вывод: Гав
//        myCat.sound(); // Вывод: Мяу
//
//        List<Person> list = new ArrayList<>();
//        list.add(new Person("Б", 12));
//        list.add(new Person("А", 32));
//        list.add(new Person("Б", 22));
//        list.add(new Person("В", 22));
//        Collections.sort(list, new ComparatorPerson());
//
//        System.out.println(list);
    }
}

// Проверка конструктора абстрактного класса
//abstract class AbstractClass {
//    String val;
//
//    public AbstractClass(String val) {
//        this.val = val;
//    }
//}
//
//class AbstractClassHeir extends AbstractClass {
//    int a;
//
//    public AbstractClassHeir(String val, int a) {
//        super(val);
//        this.a = a;
//    }
//
//    void testMethod () {
//        System.out.println(val);
//    }
//}

// Проверка констант интерфейса
//interface InterfaceTest {
//    static final String CONSTTEST = "CONSTTEST";
//}
//class Animal implements InterfaceTest {
//    public void sound() {
//        System.out.println("Животное издает звук");
//        System.out.println(CONSTTEST);
//    }
//}
//class Dog extends Animal {
//    @Override
//    public void sound() {
//        System.out.println("Гав");
//    }
//}
//class Cat extends Animal {
//    @Override
//    public void sound() {
//        System.out.println("Мяу");
//    }
//    public void testMethod() {
//        System.out.println("Тест метод");
//    }
//}

// Проверка Сериализации, Десеарелизации
//class Person implements Serializable {
//    private static final long serialVersionUID = 1L;
//    String name;
//    int age;
//
//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
//}

// Проверка компоратора
//class ComparatorPerson implements Comparator<Person> {
//
//    @Override
//    public int compare(Person o1, Person o2) {
//        int gradeComparison;
//        if ((o1.age - o2.age) < 0) {
//            gradeComparison = -1;
//        } else if ((o1.age - o2.age) > 0) {
//            gradeComparison = 1;
//        } else {
//            gradeComparison = 0;
//        }
//        if (gradeComparison == 0) {
//            return o2.getName().compareTo(o1.getName());
//        }
//        return gradeComparison;
//    }
//}