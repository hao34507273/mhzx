package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface GlobalCakeInfo
  extends Bean
{
  public abstract GlobalCakeInfo copy();
  
  public abstract GlobalCakeInfo toData();
  
  public abstract GlobalCakeInfo toBean();
  
  public abstract GlobalCakeInfo toDataIf();
  
  public abstract GlobalCakeInfo toBeanIf();
  
  public abstract Map<Integer, GlobalCakeData> getFactioncakedatas();
  
  public abstract Map<Integer, GlobalCakeData> getFactioncakedatasAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GlobalCakeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */