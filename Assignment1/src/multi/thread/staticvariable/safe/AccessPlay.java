package multi.thread.staticvariable.safe;

public class AccessPlay {
  private Play play;

  public AccessPlay(Play play) {
    this.play = play;
  }

  public void decrementPlay() throws InterruptedException {
    for (int i = 0; i < play.N; i++)
      Play.number --;
  }
}
