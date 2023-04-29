package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface ExchangeDataHandlerInfo
  extends Bean
{
  public abstract ExchangeDataHandlerInfo copy();
  
  public abstract ExchangeDataHandlerInfo toData();
  
  public abstract ExchangeDataHandlerInfo toBean();
  
  public abstract ExchangeDataHandlerInfo toDataIf();
  
  public abstract ExchangeDataHandlerInfo toBeanIf();
  
  public abstract List<Long> getSn_list();
  
  public abstract List<Long> getSn_listAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ExchangeDataHandlerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */