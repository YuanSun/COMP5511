package second.pack;

import test.on.enumerator.Analyser;
import test.on.enumerator.IAnalyzable;

class NeoAnalyzer extends Analyser implements IAnalyzable {
  private Insider insider;
  public NeoAnalyzer(String name) {
    insider = new Insider(name);
  }
  
  @Override
  public void analyze() {

  }

  protected class Insider {
    private String name;
    
    Insider(String name) {
      this.name = name;
    }
  }
  
  protected String getName() {
    return insider.name;
  }
}
