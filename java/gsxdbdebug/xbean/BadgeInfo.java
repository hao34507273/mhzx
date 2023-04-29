package xbean;

import xdb.Bean;

public abstract interface BadgeInfo
  extends Bean
{
  public abstract BadgeInfo copy();
  
  public abstract BadgeInfo toData();
  
  public abstract BadgeInfo toBean();
  
  public abstract BadgeInfo toDataIf();
  
  public abstract BadgeInfo toBeanIf();
  
  public abstract int getBadgeid();
  
  public abstract long getTimelimit();
  
  public abstract long getSessionid();
  
  public abstract void setBadgeid(int paramInt);
  
  public abstract void setTimelimit(long paramLong);
  
  public abstract void setSessionid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BadgeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */