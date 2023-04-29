package xbean;

import xdb.Bean;

public abstract interface ItemInfo
  extends Bean
{
  public abstract ItemInfo copy();
  
  public abstract ItemInfo toData();
  
  public abstract ItemInfo toBean();
  
  public abstract ItemInfo toDataIf();
  
  public abstract ItemInfo toBeanIf();
  
  public abstract int getItemcfgid();
  
  public abstract int getItemnum();
  
  public abstract int getItemtype();
  
  public abstract boolean getTaskstate();
  
  public abstract boolean getGanghelpstate();
  
  public abstract boolean getFriendhelpstate();
  
  public abstract long getRoleid();
  
  public abstract int getXiulianexp();
  
  public abstract void setItemcfgid(int paramInt);
  
  public abstract void setItemnum(int paramInt);
  
  public abstract void setItemtype(int paramInt);
  
  public abstract void setTaskstate(boolean paramBoolean);
  
  public abstract void setGanghelpstate(boolean paramBoolean);
  
  public abstract void setFriendhelpstate(boolean paramBoolean);
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setXiulianexp(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */