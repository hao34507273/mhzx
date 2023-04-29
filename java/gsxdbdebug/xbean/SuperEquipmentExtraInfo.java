package xbean;

import xdb.Bean;

public abstract interface SuperEquipmentExtraInfo
  extends Bean
{
  public abstract SuperEquipmentExtraInfo copy();
  
  public abstract SuperEquipmentExtraInfo toData();
  
  public abstract SuperEquipmentExtraInfo toBean();
  
  public abstract SuperEquipmentExtraInfo toDataIf();
  
  public abstract SuperEquipmentExtraInfo toBeanIf();
  
  public abstract boolean getIs_jewel_fixed();
  
  public abstract void setIs_jewel_fixed(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SuperEquipmentExtraInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */