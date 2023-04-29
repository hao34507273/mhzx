package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface Team
  extends Bean
{
  public abstract Team copy();
  
  public abstract Team toData();
  
  public abstract Team toBean();
  
  public abstract Team toDataIf();
  
  public abstract Team toBeanIf();
  
  public abstract List<TeamMember> getMembers();
  
  public abstract List<TeamMember> getMembersAsData();
  
  public abstract List<TeamApplicant> getApplicants();
  
  public abstract List<TeamApplicant> getApplicantsAsData();
  
  public abstract Map<Integer, TeamDispositionMember> getDisposition();
  
  public abstract Map<Integer, TeamDispositionMember> getDispositionAsData();
  
  public abstract int getSameteamfightcount();
  
  public abstract int getZhenfaid();
  
  public abstract boolean getIsfromplatform();
  
  public abstract boolean getIschangeleadering();
  
  public abstract void setSameteamfightcount(int paramInt);
  
  public abstract void setZhenfaid(int paramInt);
  
  public abstract void setIsfromplatform(boolean paramBoolean);
  
  public abstract void setIschangeleadering(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Team.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */