package xbean;

import com.goldhuman.Common.Octets;
import java.util.Map;
import xdb.Bean;

public abstract interface GangTeam
  extends Bean
{
  public abstract GangTeam copy();
  
  public abstract GangTeam toData();
  
  public abstract GangTeam toBean();
  
  public abstract GangTeam toDataIf();
  
  public abstract GangTeam toBeanIf();
  
  public abstract String getName();
  
  public abstract Octets getNameOctets();
  
  public abstract long getLeader();
  
  public abstract Map<Long, GangTeamMember> getMembers();
  
  public abstract Map<Long, GangTeamMember> getMembersAsData();
  
  public abstract long getCreate_millis();
  
  public abstract void setName(String paramString);
  
  public abstract void setNameOctets(Octets paramOctets);
  
  public abstract void setLeader(long paramLong);
  
  public abstract void setCreate_millis(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GangTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */