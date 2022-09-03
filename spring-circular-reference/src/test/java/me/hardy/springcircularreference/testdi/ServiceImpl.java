package me.hardy.springcircularreference.testdi;

public class ServiceImpl implements Service{
    @Override
    public void doingProcess() {
        System.out.println("doing Process!!!");
    }
}
