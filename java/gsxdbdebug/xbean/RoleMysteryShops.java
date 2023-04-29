package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleMysteryShops
  extends Bean
{
  public abstract RoleMysteryShops copy();
  
  public abstract RoleMysteryShops toData();
  
  public abstract RoleMysteryShops toBean();
  
  public abstract RoleMysteryShops toDataIf();
  
  public abstract RoleMysteryShops toBeanIf();
  
  public abstract Map<Integer, MysteryShopInfo> getType2shop_info();
  
  public abstract Map<Integer, MysteryShopInfo> getType2shop_infoAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleMysteryShops.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */