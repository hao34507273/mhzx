package xbean;

import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface GangRaceGameInfo
  extends Bean
{
  public abstract GangRaceGameInfo copy();
  
  public abstract GangRaceGameInfo toData();
  
  public abstract GangRaceGameInfo toBean();
  
  public abstract GangRaceGameInfo toDataIf();
  
  public abstract GangRaceGameInfo toBeanIf();
  
  public abstract int getGameid();
  
  public abstract Set<Long> getCurgameroleids();
  
  public abstract Set<Long> getCurgameroleidsAsData();
  
  public abstract Set<Long> getAllroleids();
  
  public abstract Set<Long> getAllroleidsAsData();
  
  public abstract Map<Integer, Integer> getRaceid2money();
  
  public abstract Map<Integer, Integer> getRaceid2moneyAsData();
  
  public abstract void setGameid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GangRaceGameInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */