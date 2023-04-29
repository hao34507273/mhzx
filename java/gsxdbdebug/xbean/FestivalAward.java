package xbean;

import xdb.Bean;

public abstract interface FestivalAward
  extends Bean
{
  public abstract FestivalAward copy();
  
  public abstract FestivalAward toData();
  
  public abstract FestivalAward toBean();
  
  public abstract FestivalAward toDataIf();
  
  public abstract FestivalAward toBeanIf();
  
  public abstract int getLastestawardedcfgid();
  
  public abstract int getLastestmailawardcfgid();
  
  public abstract void setLastestawardedcfgid(int paramInt);
  
  public abstract void setLastestmailawardcfgid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FestivalAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */