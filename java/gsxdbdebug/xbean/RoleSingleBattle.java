package xbean;

import xdb.Bean;

public abstract interface RoleSingleBattle
  extends Bean
{
  public abstract RoleSingleBattle copy();
  
  public abstract RoleSingleBattle toData();
  
  public abstract RoleSingleBattle toBean();
  
  public abstract RoleSingleBattle toDataIf();
  
  public abstract RoleSingleBattle toBeanIf();
  
  public abstract long getBattleid();
  
  public abstract int getBattlecfgid();
  
  public abstract int getCampid();
  
  public abstract int getNumber();
  
  public abstract long getJointime();
  
  public abstract int getPoint();
  
  public abstract RoleSessions getRolesessions();
  
  public abstract int getKilladdpoint();
  
  public abstract int getPvpfightcount();
  
  public abstract void setBattleid(long paramLong);
  
  public abstract void setBattlecfgid(int paramInt);
  
  public abstract void setCampid(int paramInt);
  
  public abstract void setNumber(int paramInt);
  
  public abstract void setJointime(long paramLong);
  
  public abstract void setPoint(int paramInt);
  
  public abstract void setKilladdpoint(int paramInt);
  
  public abstract void setPvpfightcount(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleSingleBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */