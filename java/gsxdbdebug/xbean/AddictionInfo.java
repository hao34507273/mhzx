package xbean;

import xdb.Bean;

public abstract interface AddictionInfo
  extends Bean
{
  public static final int MINOR = 0;
  public static final int ADULT = 1;
  public static final int UNKNOW = 2;
  
  public abstract AddictionInfo copy();
  
  public abstract AddictionInfo toData();
  
  public abstract AddictionInfo toBean();
  
  public abstract AddictionInfo toDataIf();
  
  public abstract AddictionInfo toBeanIf();
  
  public abstract int getIdentity();
  
  public abstract long getUpdate_time();
  
  public abstract int getOnline_time();
  
  public abstract int getTotal_online_time();
  
  public abstract boolean getReminded();
  
  public abstract int getKickout_type();
  
  public abstract void setIdentity(int paramInt);
  
  public abstract void setUpdate_time(long paramLong);
  
  public abstract void setOnline_time(int paramInt);
  
  public abstract void setTotal_online_time(int paramInt);
  
  public abstract void setReminded(boolean paramBoolean);
  
  public abstract void setKickout_type(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AddictionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */