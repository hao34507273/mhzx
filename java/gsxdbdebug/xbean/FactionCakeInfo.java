package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface FactionCakeInfo
  extends Bean
{
  public abstract FactionCakeInfo copy();
  
  public abstract FactionCakeInfo toData();
  
  public abstract FactionCakeInfo toBean();
  
  public abstract FactionCakeInfo toDataIf();
  
  public abstract FactionCakeInfo toBeanIf();
  
  public abstract Map<Integer, FactionCakeData> getFactioncakedatas();
  
  public abstract Map<Integer, FactionCakeData> getFactioncakedatasAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FactionCakeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */