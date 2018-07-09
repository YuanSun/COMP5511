package test.on.enumerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ESCustomAnalyzer {
  private static ESCustomAnalyzer INSTANCE;
  private final String name;
  private final List<? extends ESAnalyzerFilter> filters;
  
  private ESCustomAnalyzer(String name, List<? extends ESAnalyzerFilter> filters) {
    this.name = name;
    this.filters = filters;
  }
  
  private static synchronized ESCustomAnalyzer getInstance() {
    if(INSTANCE == null) {
      List<ESAnalyzerFilter> filters = new ArrayList<>();
      CustomAsciiFilter filter = new CustomAsciiFilter();
      filters.add(filter);
      INSTANCE = new ESCustomAnalyzer("standard", filters);
    }
    
    return INSTANCE;
  }

   class CustomAsciiFilter extends ESAnalyzerFilter {
    final Map<String, Object> settings;
    private final CustomAsciiFilter INSTANCE = new CustomAsciiFilter();
    
    private CustomAsciiFilter() {
      super("custom_ascii_folding");
      settings = new HashMap<String, Object>();
      settings.put("type", "asciifolding");
      settings.put("preserve_orginal", true);
    }

    @Override
    final String getName() {
      return this.name;
    }

    @Override
    final Map<String, Object> getSettings() {
      return this.settings;
    }
  }

   abstract class ESAnalyzerFilter {
    final String name;

    ESAnalyzerFilter(String name) {
      this.name = name;
    }

    abstract String getName();

    abstract Map<String, Object> getSettings();
  }
}
