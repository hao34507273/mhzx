package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ExchangeInfo
  extends Bean
{
  public abstract ExchangeInfo copy();
  
  public abstract ExchangeInfo toData();
  
  public abstract ExchangeInfo toBean();
  
  public abstract ExchangeInfo toDataIf();
  
  public abstract ExchangeInfo toBeanIf();
  
  public abstract Map<Integer, ExchangeActivityInfo> getExchange_activity_infos();
  
  public abstract Map<Integer, ExchangeActivityInfo> getExchange_activity_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ExchangeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */