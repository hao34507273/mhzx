package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface WuShiAwardInfo
  extends Bean
{
  public abstract WuShiAwardInfo copy();
  
  public abstract WuShiAwardInfo toData();
  
  public abstract WuShiAwardInfo toBean();
  
  public abstract WuShiAwardInfo toDataIf();
  
  public abstract WuShiAwardInfo toBeanIf();
  
  public abstract Set<Integer> getWushiawardcfgids();
  
  public abstract Set<Integer> getWushiawardcfgidsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\WuShiAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */