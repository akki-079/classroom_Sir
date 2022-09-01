package command.ex1;

//receiver
public class Light {

	public void switchOn() {
		System.out.println("Light is ON now");
	}

	public void switchOff() {
		System.out.println("Light is OFF now");
	}
}

interface Command {

	public void execute();
}

class OnCommand implements Command {
	Light light;

	public OnCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.switchOn();
	}
}

class OffCommand implements Command {
	Light light;

	public OffCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.switchOff();
	}

}

class Remote {
	OnCommand onCommand;
	OffCommand offCOmCommand;

	public Remote(OnCommand onCommand, OffCommand offCOmCommand) {
		this.onCommand = onCommand;
		this.offCOmCommand = offCOmCommand;
	}

	public void on() {
		onCommand.execute();
	}

	public void off() {
		offCOmCommand.execute();
	}
}

class Client {

	public static void main(String[] args) {
		Light light = new Light();
		OnCommand on = new OnCommand(light);
		OffCommand off = new OffCommand(light);

		Remote remote = new Remote(on, off);
		
		remote.on();
		
		remote.off();
	}
}
