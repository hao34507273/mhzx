package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface SendInvitation
  extends Bean
{
  public abstract SendInvitation copy();
  
  public abstract SendInvitation toData();
  
  public abstract SendInvitation toBean();
  
  public abstract SendInvitation toDataIf();
  
  public abstract SendInvitation toBeanIf();
  
  public abstract Set<Long> getInvitations();
  
  public abstract Set<Long> getInvitationsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SendInvitation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */