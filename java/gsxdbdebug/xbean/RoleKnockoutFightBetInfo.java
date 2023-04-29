package xbean;

import xdb.Bean;

public abstract interface RoleKnockoutFightBetInfo
  extends Bean
{
  public abstract RoleKnockoutFightBetInfo copy();
  
  public abstract RoleKnockoutFightBetInfo toData();
  
  public abstract RoleKnockoutFightBetInfo toBean();
  
  public abstract RoleKnockoutFightBetInfo toDataIf();
  
  public abstract RoleKnockoutFightBetInfo toBeanIf();
  
  public abstract long getBet_corps_id();
  
  public abstract int getBet_money_num();
  
  public abstract boolean getHas_got_mail();
  
  public abstract void setBet_corps_id(long paramLong);
  
  public abstract void setBet_money_num(int paramInt);
  
  public abstract void setHas_got_mail(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleKnockoutFightBetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */