package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleLimitShop
  extends Bean
{
  public abstract RoleLimitShop copy();
  
  public abstract RoleLimitShop toData();
  
  public abstract RoleLimitShop toBean();
  
  public abstract RoleLimitShop toDataIf();
  
  public abstract RoleLimitShop toBeanIf();
  
  public abstract Map<Integer, ItemBuyCount> getType2itembuycount();
  
  public abstract Map<Integer, ItemBuyCount> getType2itembuycountAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleLimitShop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */