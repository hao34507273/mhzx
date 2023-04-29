package xbean;

import xdb.Bean;

public abstract interface OfflineExpReward
  extends Bean
{
  public abstract OfflineExpReward copy();
  
  public abstract OfflineExpReward toData();
  
  public abstract OfflineExpReward toBean();
  
  public abstract OfflineExpReward toDataIf();
  
  public abstract OfflineExpReward toBeanIf();
  
  public abstract long getDayofflinetime();
  
  public abstract void setDayofflinetime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\OfflineExpReward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */