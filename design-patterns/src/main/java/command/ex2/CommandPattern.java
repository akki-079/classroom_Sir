package command.ex2;

//invoker
class Remote {

	private SwitchOnCommand onCommand;
	private SwitchOffCommand offCommand;
	private ChangeChannel channelCommand;

	public Remote(SwitchOnCommand onCommand, SwitchOffCommand offCommand, ChangeChannel channelCommand) {
		this.onCommand = onCommand;
		this.offCommand = offCommand;
		this.channelCommand = channelCommand;
	}

	public void on() {
		onCommand.execute();
	}

	public void off() {
		offCommand.execute();
	}

	public void changeChannel(int ch) {
		channelCommand.setCh(ch);
		channelCommand.execute();
	}
}

interface Command {

	public void execute();
}


class SwitchOnCommand implements Command {
	private Television tv;

	public SwitchOnCommand(Television tv) {
		this.tv = tv;
	}

	@Override
	public void execute() {
		tv.switchOn();

	}

}

class SwitchOffCommand implements Command {
	private Television tv;

	public SwitchOffCommand(Television tv) {
		this.tv = tv;
	}

	@Override
	public void execute() {
		tv.switchOff();

	}

}

class ChangeChannel implements Command {
	private Television tv;
	int ch = 0;

	public ChangeChannel(Television tv) {
		this.tv = tv;
	}

	public void setCh(int ch) {
		this.ch = ch;
	}

	@Override
	public void execute() {
		tv.setChannel(ch);
	}

}

//Receiver
class Television {

	public void setChannel(int channel) {
		System.out.println("Channel set to " + channel);
	}

	public void switchOff() {
		System.out.println("TV Switched off..");
	}

	public void switchOn() {
		System.out.println("TV Switched On..");
	}
}

//client
public class CommandPattern {

	public static void main(String[] args) {

		Television tv= new Television();
		SwitchOnCommand on = new SwitchOnCommand(tv);
		SwitchOffCommand off=new SwitchOffCommand(tv);
		ChangeChannel channel=new ChangeChannel(tv);
		
		Remote remote=new Remote(on, off, channel);
		
		remote.on();
		remote.changeChannel(16);
		remote.off();
	}

}
