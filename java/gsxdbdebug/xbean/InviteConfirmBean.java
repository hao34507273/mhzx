package xbean;

import java.util.List;
import mzm.gsp.breakegg.invite.InviteConfirmContext;
import xdb.Bean;

public abstract interface InviteConfirmBean
  extends Bean
{
  public abstract InviteConfirmBean copy();
  
  public abstract InviteConfirmBean toData();
  
  public abstract InviteConfirmBean toBean();
  
  public abstract InviteConfirmBean toDataIf();
  
  public abstract InviteConfirmBean toBeanIf();
  
  public abstract long getSessionid();
  
  public abstract int getInvitetype();
  
  public abstract List<Long> getAllroles();
  
  public abstract List<Long> getAllrolesAsData();
  
  public abstract InviteConfirmContext getContext();
  
  public abstract void setSessionid(long paramLong);
  
  public abstract void setInvitetype(int paramInt);
  
  public abstract void setContext(InviteConfirmContext paramInviteConfirmContext);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\InviteConfirmBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */