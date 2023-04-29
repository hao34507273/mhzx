package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface CampInfo
  extends Bean
{
  public abstract CampInfo copy();
  
  public abstract CampInfo toData();
  
  public abstract CampInfo toBean();
  
  public abstract CampInfo toDataIf();
  
  public abstract CampInfo toBeanIf();
  
  public abstract Map<Long, Integer> getRoleid2state();
  
  public abstract Map<Long, Integer> getRoleid2stateAsData();
  
  public abstract int getSource();
  
  public abstract Map<Long, roleBattleData> getRolebattledatas();
  
  public abstract Map<Long, roleBattleData> getRolebattledatasAsData();
  
  public abstract boolean getSurrender();
  
  public abstract void setSource(int paramInt);
  
  public abstract void setSurrender(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CampInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */