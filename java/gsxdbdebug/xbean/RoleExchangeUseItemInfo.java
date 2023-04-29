package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleExchangeUseItemInfo
  extends Bean
{
  public abstract RoleExchangeUseItemInfo copy();
  
  public abstract RoleExchangeUseItemInfo toData();
  
  public abstract RoleExchangeUseItemInfo toBean();
  
  public abstract RoleExchangeUseItemInfo toDataIf();
  
  public abstract RoleExchangeUseItemInfo toBeanIf();
  
  public abstract Map<Integer, ExchangeUseItemInfo> getExchange_use_item_infos();
  
  public abstract Map<Integer, ExchangeUseItemInfo> getExchange_use_item_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleExchangeUseItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */