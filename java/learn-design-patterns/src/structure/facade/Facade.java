package structure.facade;

public class Facade {

    private DVDPlayer dvdPlayer = new DVDPlayer();
    private Screen screen = new Screen();
    private Light light = new Light();

    public void start() {
        dvdPlayer.play();
        screen.down();
        light.off();
    }

    public void pause() {
        dvdPlayer.pause();
    }

    public void end() {
        screen.up();
        light.on();
    }

}
