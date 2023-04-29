package xbean;

import xdb.Bean;

public abstract interface AwardTotalData
  extends Bean
{
  public abstract AwardTotalData copy();
  
  public abstract AwardTotalData toData();
  
  public abstract AwardTotalData toBean();
  
  public abstract AwardTotalData toDataIf();
  
  public abstract AwardTotalData toBeanIf();
  
  public abstract long getStarttime();
  
  public abstract long getYuanbao();
  
  public abstract long getGold();
  
  public abstract long getSilver();
  
  public abstract long getGoldingot();
  
  public abstract long getRoleexp();
  
  public abstract long getPetexp();
  
  public abstract int getRolestartlv();
  
  public abstract void setStarttime(long paramLong);
  
  public abstract void setYuanbao(long paramLong);
  
  public abstract void setGold(long paramLong);
  
  public abstract void setSilver(long paramLong);
  
  public abstract void setGoldingot(long paramLong);
  
  public abstract void setRoleexp(long paramLong);
  
  public abstract void setPetexp(long paramLong);
  
  public abstract void setRolestartlv(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AwardTotalData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */