package mzm.gsp.breakegg.invite;

import java.util.List;
import xio.Protocol;

public abstract interface InviteConfirmHandler
{
  public abstract Protocol getExtroInfoProtocol(InviteConfirmContext paramInviteConfirmContext);
  
  public abstract boolean afterInviteSuccess(List<Long> paramList, InviteConfirmContext paramInviteConfirmContext);
  
  public abstract boolean afterInviteFail(List<Long> paramList, InviteConfirmContext paramInviteConfirmContext);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\invite\InviteConfirmHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */