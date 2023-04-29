package mzm.event;

import java.util.Map;

public abstract interface Module
{
  public abstract int init(Map<String, String> paramMap);
  
  public abstract int exit();
  
  public abstract int cleanupForMerge();
  
  public abstract int loadconf(Map<String, String> paramMap, int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\event\Module.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */