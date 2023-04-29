package xbean;

import xdb.Bean;

public abstract interface OnlineRoleInfo
  extends Bean
{
  public abstract OnlineRoleInfo copy();
  
  public abstract OnlineRoleInfo toData();
  
  public abstract OnlineRoleInfo toBean();
  
  public abstract OnlineRoleInfo toDataIf();
  
  public abstract OnlineRoleInfo toBeanIf();
  
  public abstract int getOnlinestatus();
  
  public abstract long getOfflineprotectsessionid();
  
  public abstract void setOnlinestatus(int paramInt);
  
  public abstract void setOfflineprotectsessionid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\OnlineRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */