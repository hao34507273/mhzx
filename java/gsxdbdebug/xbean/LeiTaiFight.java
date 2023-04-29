package xbean;

import xdb.Bean;

public abstract interface LeiTaiFight
  extends Bean
{
  public abstract LeiTaiFight copy();
  
  public abstract LeiTaiFight toData();
  
  public abstract LeiTaiFight toBean();
  
  public abstract LeiTaiFight toDataIf();
  
  public abstract LeiTaiFight toBeanIf();
  
  public abstract long getActiveroleid();
  
  public abstract int getActiveteamnum();
  
  public abstract long getPassiveroleid();
  
  public abstract int getPassiveteamnum();
  
  public abstract void setActiveroleid(long paramLong);
  
  public abstract void setActiveteamnum(int paramInt);
  
  public abstract void setPassiveroleid(long paramLong);
  
  public abstract void setPassiveteamnum(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LeiTaiFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */