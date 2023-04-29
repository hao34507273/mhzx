package mzm.gsp.confirm.main;

import xio.Protocol;

public abstract interface TeamConfirmHandler
{
  public abstract Protocol getConfirmProtocol(long paramLong, int paramInt, TeamConfirmContext paramTeamConfirmContext);
  
  public abstract boolean afterAllAccepted(long paramLong, int paramInt, TeamConfirmContext paramTeamConfirmContext);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\confirm\main\TeamConfirmHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */