package hw5;

public class WallDisplayObserverV2 implements StatusObserver {
    @Override
    public void onStatus(StatusEvent event) {
        System.out.println("Wall \u2022 Machine " + event.getMachineId() + " : " + event.getStatus());
    }
}

