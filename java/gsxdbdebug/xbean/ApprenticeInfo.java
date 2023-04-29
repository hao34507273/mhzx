package xbean;

import xdb.Bean;

public abstract interface ApprenticeInfo
  extends Bean
{
  public abstract ApprenticeInfo copy();
  
  public abstract ApprenticeInfo toData();
  
  public abstract ApprenticeInfo toBean();
  
  public abstract ApprenticeInfo toDataIf();
  
  public abstract ApprenticeInfo toBeanIf();
  
  public abstract long getMasterroleid();
  
  public abstract ShiTuTimeInfo getTimeinfo();
  
  public abstract int getNow_pay_respect_times();
  
  public abstract void setMasterroleid(long paramLong);
  
  public abstract void setNow_pay_respect_times(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ApprenticeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */