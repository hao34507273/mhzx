package xbean;

import xdb.Bean;

public abstract interface GangTeamInvitation
  extends Bean
{
  public abstract GangTeamInvitation copy();
  
  public abstract GangTeamInvitation toData();
  
  public abstract GangTeamInvitation toBean();
  
  public abstract GangTeamInvitation toDataIf();
  
  public abstract GangTeamInvitation toBeanIf();
  
  public abstract long getGang_teamid();
  
  public abstract long getEnd_millis();
  
  public abstract void setGang_teamid(long paramLong);
  
  public abstract void setEnd_millis(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GangTeamInvitation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */