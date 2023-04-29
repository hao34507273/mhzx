package xbean;

import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface TransferOccupationFashionDress
  extends Bean
{
  public abstract TransferOccupationFashionDress copy();
  
  public abstract TransferOccupationFashionDress toData();
  
  public abstract TransferOccupationFashionDress toBean();
  
  public abstract TransferOccupationFashionDress toDataIf();
  
  public abstract TransferOccupationFashionDress toBeanIf();
  
  public abstract int getCurrent_fashion_dress_cfg_id();
  
  public abstract Map<Integer, FashionDressInfo> getFashion_dress_map();
  
  public abstract Map<Integer, FashionDressInfo> getFashion_dress_mapAsData();
  
  public abstract Set<Integer> getActivate_property_set();
  
  public abstract Set<Integer> getActivate_property_setAsData();
  
  public abstract void setCurrent_fashion_dress_cfg_id(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TransferOccupationFashionDress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */