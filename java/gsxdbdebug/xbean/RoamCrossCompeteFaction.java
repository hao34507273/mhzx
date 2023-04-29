package xbean;

import com.goldhuman.Common.Octets;
import java.util.Map;
import xdb.Bean;

public abstract interface RoamCrossCompeteFaction
  extends Bean
{
  public abstract RoamCrossCompeteFaction copy();
  
  public abstract RoamCrossCompeteFaction toData();
  
  public abstract RoamCrossCompeteFaction toBean();
  
  public abstract RoamCrossCompeteFaction toDataIf();
  
  public abstract RoamCrossCompeteFaction toBeanIf();
  
  public abstract String getName();
  
  public abstract Octets getNameOctets();
  
  public abstract Map<Integer, GangDutyMembers> getDuty2members();
  
  public abstract Map<Integer, GangDutyMembers> getDuty2membersAsData();
  
  public abstract int getDesigned_titleid();
  
  public abstract long getOpponent();
  
  public abstract int getPk_score();
  
  public abstract int getPlayer_score();
  
  public abstract int getWin_times();
  
  public abstract int getMax_member_count();
  
  public abstract void setName(String paramString);
  
  public abstract void setNameOctets(Octets paramOctets);
  
  public abstract void setDesigned_titleid(int paramInt);
  
  public abstract void setOpponent(long paramLong);
  
  public abstract void setPk_score(int paramInt);
  
  public abstract void setPlayer_score(int paramInt);
  
  public abstract void setWin_times(int paramInt);
  
  public abstract void setMax_member_count(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoamCrossCompeteFaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */