package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface ReceiveInvitation
  extends Bean
{
  public abstract ReceiveInvitation copy();
  
  public abstract ReceiveInvitation toData();
  
  public abstract ReceiveInvitation toBean();
  
  public abstract ReceiveInvitation toDataIf();
  
  public abstract ReceiveInvitation toBeanIf();
  
  public abstract Set<Long> getInvitations();
  
  public abstract Set<Long> getInvitationsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ReceiveInvitation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */