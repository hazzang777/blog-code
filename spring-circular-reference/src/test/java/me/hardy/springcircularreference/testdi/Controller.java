package me.hardy.springcircularreference.testdi;

public class Controller {

    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public void doingByService() {
        service.doingProcess();
    }
}
