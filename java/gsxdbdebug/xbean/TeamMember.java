package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface TeamMember
  extends Bean
{
  public abstract TeamMember copy();
  
  public abstract TeamMember toData();
  
  public abstract TeamMember toBean();
  
  public abstract TeamMember toDataIf();
  
  public abstract TeamMember toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract int getStatus();
  
  public abstract List<Long> getInvitees();
  
  public abstract List<Long> getInviteesAsData();
  
  public abstract int getTempstatus();
  
  public abstract boolean getIstobefired();
  
  public abstract boolean getIstobeoffline();
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setStatus(int paramInt);
  
  public abstract void setTempstatus(int paramInt);
  
  public abstract void setIstobefired(boolean paramBoolean);
  
  public abstract void setIstobeoffline(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TeamMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */