package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface CakeInfo
  extends Bean
{
  public abstract CakeInfo copy();
  
  public abstract CakeInfo toData();
  
  public abstract CakeInfo toBean();
  
  public abstract CakeInfo toDataIf();
  
  public abstract CakeInfo toBeanIf();
  
  public abstract Map<Integer, CakeData> getCakedatas();
  
  public abstract Map<Integer, CakeData> getCakedatasAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CakeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */