package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface LonngBoatRaceTeamStat
  extends Bean
{
  public abstract LonngBoatRaceTeamStat copy();
  
  public abstract LonngBoatRaceTeamStat toData();
  
  public abstract LonngBoatRaceTeamStat toBean();
  
  public abstract LonngBoatRaceTeamStat toDataIf();
  
  public abstract LonngBoatRaceTeamStat toBeanIf();
  
  public abstract float getSpeed();
  
  public abstract float getLocation();
  
  public abstract int getEventtypeid();
  
  public abstract int getEventid();
  
  public abstract int getEventtriggerid();
  
  public abstract long getEndtimestamp();
  
  public abstract Map<Long, LonngBoatRaceStat> getRole2stat();
  
  public abstract Map<Long, LonngBoatRaceStat> getRole2statAsData();
  
  public abstract Map<Long, LonngBoatRaceStat> getRole2stat_phase();
  
  public abstract Map<Long, LonngBoatRaceStat> getRole2stat_phaseAsData();
  
  public abstract Map<Long, Boolean> getRole2isright_times();
  
  public abstract Map<Long, Boolean> getRole2isright_timesAsData();
  
  public abstract void setSpeed(float paramFloat);
  
  public abstract void setLocation(float paramFloat);
  
  public abstract void setEventtypeid(int paramInt);
  
  public abstract void setEventid(int paramInt);
  
  public abstract void setEventtriggerid(int paramInt);
  
  public abstract void setEndtimestamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LonngBoatRaceTeamStat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */