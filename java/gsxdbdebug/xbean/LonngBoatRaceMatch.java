package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface LonngBoatRaceMatch
  extends Bean
{
  public static final int PREPARE = 0;
  public static final int COMMAND = 1;
  public static final int TIP = 2;
  public static final int EVENT = 3;
  
  public abstract LonngBoatRaceMatch copy();
  
  public abstract LonngBoatRaceMatch toData();
  
  public abstract LonngBoatRaceMatch toBean();
  
  public abstract LonngBoatRaceMatch toDataIf();
  
  public abstract LonngBoatRaceMatch toBeanIf();
  
  public abstract long getMatchbegintimestamp();
  
  public abstract int getActivityid();
  
  public abstract int getRaceid();
  
  public abstract int getPhaseno();
  
  public abstract int getRoundno();
  
  public abstract int getTimesno();
  
  public abstract List<Integer> getCommandlist();
  
  public abstract List<Integer> getCommandlistAsData();
  
  public abstract long getEndtimestamp();
  
  public abstract int getState();
  
  public abstract Map<Long, LonngBoatRaceTeamStat> getTeamid2teamstat();
  
  public abstract Map<Long, LonngBoatRaceTeamStat> getTeamid2teamstatAsData();
  
  public abstract Map<Long, Integer> getTeamid2isallright();
  
  public abstract Map<Long, Integer> getTeamid2isallrightAsData();
  
  public abstract Map<Long, Integer> getRoleid2israndom();
  
  public abstract Map<Long, Integer> getRoleid2israndomAsData();
  
  public abstract void setMatchbegintimestamp(long paramLong);
  
  public abstract void setActivityid(int paramInt);
  
  public abstract void setRaceid(int paramInt);
  
  public abstract void setPhaseno(int paramInt);
  
  public abstract void setRoundno(int paramInt);
  
  public abstract void setTimesno(int paramInt);
  
  public abstract void setEndtimestamp(long paramLong);
  
  public abstract void setState(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LonngBoatRaceMatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */