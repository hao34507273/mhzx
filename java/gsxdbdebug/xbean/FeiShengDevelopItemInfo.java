package xbean;

import xdb.Bean;

public abstract interface FeiShengDevelopItemInfo
  extends Bean
{
  public abstract FeiShengDevelopItemInfo copy();
  
  public abstract FeiShengDevelopItemInfo toData();
  
  public abstract FeiShengDevelopItemInfo toBean();
  
  public abstract FeiShengDevelopItemInfo toDataIf();
  
  public abstract FeiShengDevelopItemInfo toBeanIf();
  
  public abstract boolean getHas_get_item();
  
  public abstract void setHas_get_item(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FeiShengDevelopItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */