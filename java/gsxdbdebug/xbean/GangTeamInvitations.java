package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface GangTeamInvitations
  extends Bean
{
  public abstract GangTeamInvitations copy();
  
  public abstract GangTeamInvitations toData();
  
  public abstract GangTeamInvitations toBean();
  
  public abstract GangTeamInvitations toDataIf();
  
  public abstract GangTeamInvitations toBeanIf();
  
  public abstract Map<Long, GangTeamInvitation> getInvitations();
  
  public abstract Map<Long, GangTeamInvitation> getInvitationsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GangTeamInvitations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */