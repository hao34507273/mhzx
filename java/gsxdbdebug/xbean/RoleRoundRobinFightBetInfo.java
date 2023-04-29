package xbean;

import xdb.Bean;

public abstract interface RoleRoundRobinFightBetInfo
  extends Bean
{
  public abstract RoleRoundRobinFightBetInfo copy();
  
  public abstract RoleRoundRobinFightBetInfo toData();
  
  public abstract RoleRoundRobinFightBetInfo toBean();
  
  public abstract RoleRoundRobinFightBetInfo toDataIf();
  
  public abstract RoleRoundRobinFightBetInfo toBeanIf();
  
  public abstract long getBet_corps_id();
  
  public abstract int getMoney_num();
  
  public abstract boolean getHas_got_mail();
  
  public abstract void setBet_corps_id(long paramLong);
  
  public abstract void setMoney_num(int paramInt);
  
  public abstract void setHas_got_mail(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleRoundRobinFightBetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */