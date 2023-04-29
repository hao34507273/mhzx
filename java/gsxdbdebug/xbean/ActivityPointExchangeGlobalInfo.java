package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ActivityPointExchangeGlobalInfo
  extends Bean
{
  public abstract ActivityPointExchangeGlobalInfo copy();
  
  public abstract ActivityPointExchangeGlobalInfo toData();
  
  public abstract ActivityPointExchangeGlobalInfo toBean();
  
  public abstract ActivityPointExchangeGlobalInfo toDataIf();
  
  public abstract ActivityPointExchangeGlobalInfo toBeanIf();
  
  public abstract Map<Integer, ActivityPointExchangeMallGlobalInfo> getMallcfgid2mallinfo();
  
  public abstract Map<Integer, ActivityPointExchangeMallGlobalInfo> getMallcfgid2mallinfoAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ActivityPointExchangeGlobalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */