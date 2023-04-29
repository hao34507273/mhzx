package xbean;

import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface Role2FashionDressInfo
  extends Bean
{
  public abstract Role2FashionDressInfo copy();
  
  public abstract Role2FashionDressInfo toData();
  
  public abstract Role2FashionDressInfo toBean();
  
  public abstract Role2FashionDressInfo toDataIf();
  
  public abstract Role2FashionDressInfo toBeanIf();
  
  public abstract int getCurrent_fashion_dress_cfg_id();
  
  public abstract Map<Integer, FashionDressInfo> getFashion_dress_map();
  
  public abstract Map<Integer, FashionDressInfo> getFashion_dress_mapAsData();
  
  public abstract Set<Integer> getActivate_property_set();
  
  public abstract Set<Integer> getActivate_property_setAsData();
  
  public abstract Map<Integer, TransferOccupationFashionDress> getTransfer_occupation_fashion_dress_map();
  
  public abstract Map<Integer, TransferOccupationFashionDress> getTransfer_occupation_fashion_dress_mapAsData();
  
  public abstract boolean getNew_year_fashion_dress_is_repaired();
  
  public abstract Set<Integer> getOwn_unlock_theme_fashion_dress_type_set();
  
  public abstract Set<Integer> getOwn_unlock_theme_fashion_dress_type_setAsData();
  
  public abstract void setCurrent_fashion_dress_cfg_id(int paramInt);
  
  public abstract void setNew_year_fashion_dress_is_repaired(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Role2FashionDressInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */