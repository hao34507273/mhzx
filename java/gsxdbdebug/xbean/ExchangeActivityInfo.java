package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ExchangeActivityInfo
  extends Bean
{
  public abstract ExchangeActivityInfo copy();
  
  public abstract ExchangeActivityInfo toData();
  
  public abstract ExchangeActivityInfo toBean();
  
  public abstract ExchangeActivityInfo toDataIf();
  
  public abstract ExchangeActivityInfo toBeanIf();
  
  public abstract Map<Integer, ExchangeAwardInfo> getExchange_award_infos();
  
  public abstract Map<Integer, ExchangeAwardInfo> getExchange_award_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ExchangeActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */