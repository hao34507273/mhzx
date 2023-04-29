package xbean;

import xdb.Bean;

public abstract interface QQVipInfo
  extends Bean
{
  public abstract QQVipInfo copy();
  
  public abstract QQVipInfo toData();
  
  public abstract QQVipInfo toBean();
  
  public abstract QQVipInfo toDataIf();
  
  public abstract QQVipInfo toBeanIf();
  
  public abstract int getVip_flag();
  
  public abstract boolean getIs_vip();
  
  public abstract boolean getIs_year();
  
  public abstract boolean getIs_luxury();
  
  public abstract int getLevel();
  
  public abstract int getExpire_timestamp();
  
  public abstract void setVip_flag(int paramInt);
  
  public abstract void setIs_vip(boolean paramBoolean);
  
  public abstract void setIs_year(boolean paramBoolean);
  
  public abstract void setIs_luxury(boolean paramBoolean);
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setExpire_timestamp(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\QQVipInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */