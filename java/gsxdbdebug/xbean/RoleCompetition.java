package xbean;

import xdb.Bean;

public abstract interface RoleCompetition
  extends Bean
{
  public abstract RoleCompetition copy();
  
  public abstract RoleCompetition toData();
  
  public abstract RoleCompetition toBean();
  
  public abstract RoleCompetition toDataIf();
  
  public abstract RoleCompetition toBeanIf();
  
  public abstract int getAction_point();
  
  public abstract int getWin_streak();
  
  public abstract boolean getParticipated();
  
  public abstract boolean getAwarded_final();
  
  public abstract void setAction_point(int paramInt);
  
  public abstract void setWin_streak(int paramInt);
  
  public abstract void setParticipated(boolean paramBoolean);
  
  public abstract void setAwarded_final(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleCompetition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */