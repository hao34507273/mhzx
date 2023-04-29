package xbean;

import xdb.Bean;

public abstract interface OnlineInfo
  extends Bean
{
  public static final int MINOR = 0;
  public static final int ADULT = 1;
  public static final int UNKNOW = 2;
  
  public abstract OnlineInfo copy();
  
  public abstract OnlineInfo toData();
  
  public abstract OnlineInfo toBean();
  
  public abstract OnlineInfo toDataIf();
  
  public abstract OnlineInfo toBeanIf();
  
  public abstract long getLastcalcuatetime();
  
  public abstract int getSingle_online();
  
  public abstract int getIs_adult();
  
  public abstract int getAccumu_time();
  
  public abstract int getAge();
  
  public abstract int getReport_count();
  
  public abstract int getPeriod_time();
  
  public abstract int getKickout_type();
  
  public abstract int getRest_time();
  
  public abstract void setLastcalcuatetime(long paramLong);
  
  public abstract void setSingle_online(int paramInt);
  
  public abstract void setIs_adult(int paramInt);
  
  public abstract void setAccumu_time(int paramInt);
  
  public abstract void setAge(int paramInt);
  
  public abstract void setReport_count(int paramInt);
  
  public abstract void setPeriod_time(int paramInt);
  
  public abstract void setKickout_type(int paramInt);
  
  public abstract void setRest_time(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\OnlineInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */