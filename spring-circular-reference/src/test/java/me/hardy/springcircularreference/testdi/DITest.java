package me.hardy.springcircularreference.testdi;

public class DITest {
    public static void main(String[] args) {
        Controller controller = new Controller(new ServiceImpl());
        controller.doingByService();
    }
}
