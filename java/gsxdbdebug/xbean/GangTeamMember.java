package xbean;

import xdb.Bean;

public abstract interface GangTeamMember
  extends Bean
{
  public abstract GangTeamMember copy();
  
  public abstract GangTeamMember toData();
  
  public abstract GangTeamMember toBean();
  
  public abstract GangTeamMember toDataIf();
  
  public abstract GangTeamMember toBeanIf();
  
  public abstract long getJoin_time();
  
  public abstract void setJoin_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GangTeamMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */