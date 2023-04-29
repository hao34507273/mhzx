package xbean;

import xdb.Bean;

public abstract interface SingleWorshipInfo
  extends Bean
{
  public abstract SingleWorshipInfo copy();
  
  public abstract SingleWorshipInfo toData();
  
  public abstract SingleWorshipInfo toBean();
  
  public abstract SingleWorshipInfo toDataIf();
  
  public abstract SingleWorshipInfo toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract int getWorshipid();
  
  public abstract int getContentindex();
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setWorshipid(int paramInt);
  
  public abstract void setContentindex(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SingleWorshipInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */