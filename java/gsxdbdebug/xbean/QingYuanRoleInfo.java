package xbean;

import xdb.Bean;

public abstract interface QingYuanRoleInfo
  extends Bean
{
  public abstract QingYuanRoleInfo copy();
  
  public abstract QingYuanRoleInfo toData();
  
  public abstract QingYuanRoleInfo toBean();
  
  public abstract QingYuanRoleInfo toDataIf();
  
  public abstract QingYuanRoleInfo toBeanIf();
  
  public abstract long getStart_time();
  
  public abstract int getAppellation_cfg_id();
  
  public abstract void setStart_time(long paramLong);
  
  public abstract void setAppellation_cfg_id(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\QingYuanRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */