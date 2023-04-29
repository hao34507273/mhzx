package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface ActivityPointExchangeMallGlobalInfo
  extends Bean
{
  public abstract ActivityPointExchangeMallGlobalInfo copy();
  
  public abstract ActivityPointExchangeMallGlobalInfo toData();
  
  public abstract ActivityPointExchangeMallGlobalInfo toBean();
  
  public abstract ActivityPointExchangeMallGlobalInfo toDataIf();
  
  public abstract ActivityPointExchangeMallGlobalInfo toBeanIf();
  
  public abstract Set<Integer> getSoldoutgoodscfgidset();
  
  public abstract Set<Integer> getSoldoutgoodscfgidsetAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ActivityPointExchangeMallGlobalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */