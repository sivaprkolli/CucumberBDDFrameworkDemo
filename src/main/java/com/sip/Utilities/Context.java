package com.sip.Utilities;

import java.util.HashMap;
import java.util.Map;

public class Context {
    Map<String, String> stepData;

  public void setContext(String key, String value){
      stepData.put(key, value);
  }

  public String getContext(String key){
      return stepData.get(key);
  }

    public Context(){
        stepData = new HashMap<>();
    }


}
