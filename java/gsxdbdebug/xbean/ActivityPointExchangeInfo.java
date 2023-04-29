package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ActivityPointExchangeInfo
  extends Bean
{
  public abstract ActivityPointExchangeInfo copy();
  
  public abstract ActivityPointExchangeInfo toData();
  
  public abstract ActivityPointExchangeInfo toBean();
  
  public abstract ActivityPointExchangeInfo toDataIf();
  
  public abstract ActivityPointExchangeInfo toBeanIf();
  
  public abstract Map<Integer, ActivityPointExchangeMallInfo> getActivityid2mallinfo();
  
  public abstract Map<Integer, ActivityPointExchangeMallInfo> getActivityid2mallinfoAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ActivityPointExchangeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */