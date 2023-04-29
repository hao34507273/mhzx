package mzm.gsp.team.main;

import java.util.List;

public abstract interface ActivityTeamHandler
{
  public abstract List<Long> findTeams(long paramLong1, long paramLong2);
  
  public abstract List<Long> findMembers(long paramLong1, long paramLong2);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\ActivityTeamHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */