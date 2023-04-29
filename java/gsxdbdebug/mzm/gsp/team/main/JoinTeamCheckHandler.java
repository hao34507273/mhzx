package mzm.gsp.team.main;

public abstract interface JoinTeamCheckHandler
{
  public abstract JoinTeamResult canJoinTeam(TeamInfo paramTeamInfo, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, JoinTeamType paramJoinTeamType);
  
  public abstract ReturnTeamResult canReturnTeam(TeamInfo paramTeamInfo, long paramLong1, long paramLong2, long paramLong3);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\JoinTeamCheckHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */