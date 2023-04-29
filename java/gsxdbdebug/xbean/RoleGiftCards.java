package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleGiftCards
  extends Bean
{
  public abstract RoleGiftCards copy();
  
  public abstract RoleGiftCards toData();
  
  public abstract RoleGiftCards toBean();
  
  public abstract RoleGiftCards toDataIf();
  
  public abstract RoleGiftCards toBeanIf();
  
  public abstract Map<String, RoleGiftCardInfo> getCards();
  
  public abstract Map<String, RoleGiftCardInfo> getCardsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleGiftCards.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */