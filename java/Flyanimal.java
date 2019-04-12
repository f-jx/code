interface Flyanimal {
    void fly();

    public static void main(String args[]) {
        Ant a = new Ant();
        a.fly();
        System.out.println("Ant's legs are" + a.legnum);
        Pigeon p = new Pigeon();
        p.fly();
        p.egg();
    }

}

class Insect {
    int legnum = 6;
}

class Bird {
    int legnum = 2;

    void egg() {
    };
}

class Ant extends Insect implements Flyanimal {
    public void fly() {// 重写接口Flyanimal中的fly方法
        System.out.println("Ant can fly");
    }

}

class Pigeon extends Bird implements Flyanimal {

    public void fly() {// 重写接口Flyanimal中的fly方法
        System.out.println("pigeon can fly");
    }

    public void egg() {// 重写Bird类中的egg方法
        System.out.println("pigeon can lay eggs ");
    }

}

// public class InterfaceDemo {

// public static void main(String args[]) {
// Ant a = new Ant();
// a.fly();
// System.out.println("Ant's legs are" + a.legnum);
// Pigeon p = new Pigeon();
// p.fly();
// p.egg();
// }
// }