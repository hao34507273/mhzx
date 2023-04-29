package xbean;

import xdb.Bean;

public abstract interface RoleMasterRankInfo
  extends Bean
{
  public abstract RoleMasterRankInfo copy();
  
  public abstract RoleMasterRankInfo toData();
  
  public abstract RoleMasterRankInfo toBean();
  
  public abstract RoleMasterRankInfo toDataIf();
  
  public abstract RoleMasterRankInfo toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract void setRoleid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleMasterRankInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */