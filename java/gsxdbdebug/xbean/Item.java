package xbean;

import java.util.List;
import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface Item
  extends Bean
{
  public abstract Item copy();
  
  public abstract Item toData();
  
  public abstract Item toBean();
  
  public abstract Item toDataIf();
  
  public abstract Item toBeanIf();
  
  public abstract int getCfgid();
  
  public abstract int getNumber();
  
  public abstract Set<Long> getUuid();
  
  public abstract Set<Long> getUuidAsData();
  
  public abstract long getMarketbuytime();
  
  public abstract int getFlags();
  
  public abstract Map<Integer, Integer> getExtra();
  
  public abstract Map<Integer, Integer> getExtraAsData();
  
  public abstract List<XExtraProBean> getExtraprolist();
  
  public abstract List<XExtraProBean> getExtraprolistAsData();
  
  public abstract Map<Integer, TempExtraProInfo> getTempextrapropinfos();
  
  public abstract Map<Integer, TempExtraProInfo> getTempextrapropinfosAsData();
  
  public abstract List<FumoInfo> getFumoprolist();
  
  public abstract List<FumoInfo> getFumoprolistAsData();
  
  public abstract SuperEquipmentCostBean getSuperequipmentcostbean();
  
  public abstract Map<Integer, JewelInfo> getJewelmap();
  
  public abstract Map<Integer, JewelInfo> getJewelmapAsData();
  
  public abstract void setCfgid(int paramInt);
  
  public abstract void setNumber(int paramInt);
  
  public abstract void setMarketbuytime(long paramLong);
  
  public abstract void setFlags(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Item.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */