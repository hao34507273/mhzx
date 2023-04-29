package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface BreakEggInfo
  extends Bean
{
  public abstract BreakEggInfo copy();
  
  public abstract BreakEggInfo toData();
  
  public abstract BreakEggInfo toBean();
  
  public abstract BreakEggInfo toDataIf();
  
  public abstract BreakEggInfo toBeanIf();
  
  public abstract long getRole_id();
  
  public abstract Map<Integer, Integer> getItemid2num();
  
  public abstract Map<Integer, Integer> getItemid2numAsData();
  
  public abstract void setRole_id(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BreakEggInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */