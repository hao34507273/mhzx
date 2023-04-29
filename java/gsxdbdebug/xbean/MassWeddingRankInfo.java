package xbean;

import xdb.Bean;

public abstract interface MassWeddingRankInfo
  extends Bean
{
  public abstract MassWeddingRankInfo copy();
  
  public abstract MassWeddingRankInfo toData();
  
  public abstract MassWeddingRankInfo toBean();
  
  public abstract MassWeddingRankInfo toDataIf();
  
  public abstract MassWeddingRankInfo toBeanIf();
  
  public abstract long getRoleida();
  
  public abstract int getRoleaoffer();
  
  public abstract long getRoleidb();
  
  public abstract int getRoleidboffer();
  
  public abstract void setRoleida(long paramLong);
  
  public abstract void setRoleaoffer(int paramInt);
  
  public abstract void setRoleidb(long paramLong);
  
  public abstract void setRoleidboffer(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MassWeddingRankInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */