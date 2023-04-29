package xbean;

import xdb.Bean;

public abstract interface UserLoginPrivilegeInfo
  extends Bean
{
  public abstract UserLoginPrivilegeInfo copy();
  
  public abstract UserLoginPrivilegeInfo toData();
  
  public abstract UserLoginPrivilegeInfo toBean();
  
  public abstract UserLoginPrivilegeInfo toDataIf();
  
  public abstract UserLoginPrivilegeInfo toBeanIf();
  
  public abstract long getRecord_time();
  
  public abstract void setRecord_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\UserLoginPrivilegeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */