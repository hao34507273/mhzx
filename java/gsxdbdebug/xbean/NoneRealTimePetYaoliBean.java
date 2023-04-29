package xbean;

import xdb.Bean;

public abstract interface NoneRealTimePetYaoliBean
  extends Bean
{
  public abstract NoneRealTimePetYaoliBean copy();
  
  public abstract NoneRealTimePetYaoliBean toData();
  
  public abstract NoneRealTimePetYaoliBean toBean();
  
  public abstract NoneRealTimePetYaoliBean toDataIf();
  
  public abstract NoneRealTimePetYaoliBean toBeanIf();
  
  public abstract long getPetid();
  
  public abstract long getRoleid();
  
  public abstract int getPetyaoli();
  
  public abstract long getChangeyaolitime();
  
  public abstract void setPetid(long paramLong);
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setPetyaoli(int paramInt);
  
  public abstract void setChangeyaolitime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\NoneRealTimePetYaoliBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */