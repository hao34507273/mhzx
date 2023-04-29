package xbean;

import java.util.List;
import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface Invitation
  extends Bean
{
  public abstract Invitation copy();
  
  public abstract Invitation toData();
  
  public abstract Invitation toBean();
  
  public abstract Invitation toDataIf();
  
  public abstract Invitation toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract int getGifttype();
  
  public abstract List<String> getMsgargs();
  
  public abstract List<String> getMsgargsAsData();
  
  public abstract Map<Long, InvitedRole> getInvitedmap();
  
  public abstract Map<Long, InvitedRole> getInvitedmapAsData();
  
  public abstract long getInvitationtime();
  
  public abstract Set<Long> getKnowninvitedroles();
  
  public abstract Set<Long> getKnowninvitedrolesAsData();
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setGifttype(int paramInt);
  
  public abstract void setInvitationtime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Invitation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */