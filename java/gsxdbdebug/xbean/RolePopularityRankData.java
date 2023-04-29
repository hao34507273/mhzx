package xbean;

import xdb.Bean;

public abstract interface RolePopularityRankData
  extends Bean
{
  public abstract RolePopularityRankData copy();
  
  public abstract RolePopularityRankData toData();
  
  public abstract RolePopularityRankData toBean();
  
  public abstract RolePopularityRankData toDataIf();
  
  public abstract RolePopularityRankData toBeanIf();
  
  public abstract long getRole_id();
  
  public abstract void setRole_id(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RolePopularityRankData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */