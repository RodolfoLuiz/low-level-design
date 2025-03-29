public final class ServiceLocator {
    private static volatile ServiceLocator serviceLocator;
    private ElevatorController elevatorController;

    private ServiceLocator(){}

    public static ServiceLocator getInstance(){
        ServiceLocator result = serviceLocator;
        if(result != null){
            return result;
        }
        synchronized (ServiceLocator.class){
            if(serviceLocator == null){
                serviceLocator = new ServiceLocator();
            }
            return serviceLocator;
        }
    }

    public void registerElevatorController(ElevatorController elevatorController){
        this.elevatorController = elevatorController;
    }
    public ElevatorController getElevatorController(){
        return elevatorController;
    }
}
