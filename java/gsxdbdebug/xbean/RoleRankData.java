package xbean;

import xdb.Bean;

public abstract interface RoleRankData
  extends Bean
{
  public abstract RoleRankData copy();
  
  public abstract RoleRankData toData();
  
  public abstract RoleRankData toBean();
  
  public abstract RoleRankData toDataIf();
  
  public abstract RoleRankData toBeanIf();
  
  public abstract int getMaxvalue();
  
  public abstract long getLogtime();
  
  public abstract void setMaxvalue(int paramInt);
  
  public abstract void setLogtime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleRankData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */