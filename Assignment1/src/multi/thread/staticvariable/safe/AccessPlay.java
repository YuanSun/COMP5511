package multi.thread.staticvariable.safe;

public class AccessPlay {
  private Play play;

  public AccessPlay(Play play) {
    this.play = play;
  }

  public void decrementPlay() throws InterruptedException {
    play.decrementNumber();
  }
}
