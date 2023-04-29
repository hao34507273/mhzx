package xbean;

import xdb.Bean;

public abstract interface EquipMode
  extends Bean
{
  public abstract EquipMode copy();
  
  public abstract EquipMode toData();
  
  public abstract EquipMode toBean();
  
  public abstract EquipMode toDataIf();
  
  public abstract EquipMode toBeanIf();
  
  public abstract int getMode();
  
  public abstract boolean getIsset();
  
  public abstract void setMode(int paramInt);
  
  public abstract void setIsset(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\EquipMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */