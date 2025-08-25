package Interface_examples;

public interface Device {
	int DeviceVersion=12;
	public void turnOn();
	default public void reset() {
		System.out.println("the device is reseted and the version is : " + DeviceVersion);
	}
	public static void ShowDetailsInfo() {
		System.out.println("show factory settings");
	}

}
