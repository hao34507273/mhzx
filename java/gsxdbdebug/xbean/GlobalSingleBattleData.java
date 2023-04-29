package xbean;

import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface GlobalSingleBattleData
  extends Bean
{
  public abstract GlobalSingleBattleData copy();
  
  public abstract GlobalSingleBattleData toData();
  
  public abstract GlobalSingleBattleData toBean();
  
  public abstract GlobalSingleBattleData toDataIf();
  
  public abstract GlobalSingleBattleData toBeanIf();
  
  public abstract long getWorld();
  
  public abstract long getStarttime();
  
  public abstract Map<Integer, CampInfo> getCampinfos();
  
  public abstract Map<Integer, CampInfo> getCampinfosAsData();
  
  public abstract long getContextid();
  
  public abstract BattleFightRecord getFightrecord();
  
  public abstract int getBattlecfgid();
  
  public abstract SingleBattleResult getResult();
  
  public abstract int getStage();
  
  public abstract SingleBattleSessions getSessions();
  
  public abstract Set<Long> getAllfightids();
  
  public abstract Set<Long> getAllfightidsAsData();
  
  public abstract void setWorld(long paramLong);
  
  public abstract void setStarttime(long paramLong);
  
  public abstract void setContextid(long paramLong);
  
  public abstract void setBattlecfgid(int paramInt);
  
  public abstract void setStage(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GlobalSingleBattleData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */