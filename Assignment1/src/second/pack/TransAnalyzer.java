package second.pack;

public class TransAnalyzer extends NeoAnalyzer {
  protected NeoInsider neoInsider;
  public TransAnalyzer(String name) {
    super(name);
    neoInsider = new NeoInsider(name);
  }
  
  protected String getName() {
    return super.getName();
  }
  
  protected class NeoInsider extends Insider {

    public NeoInsider(String name) {
      super(name);
    }
  }
}
