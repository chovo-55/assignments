package Structural.Adapter;

public class Adapter {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "call me maybe.mp3");
        audioPlayer.play("mp4", "horehroine.mp4");
    }
}
