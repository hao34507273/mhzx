package xbean;

import java.util.Map;
import java.util.Set;
import mzm.gsp.effect.fighter.Interface.TeamEffect;
import mzm.gsp.fight.main.FightInfo.AITeamVariable;
import xdb.Bean;

public abstract interface FightTeam
  extends Bean
{
  public abstract FightTeam copy();
  
  public abstract FightTeam toData();
  
  public abstract FightTeam toBean();
  
  public abstract FightTeam toDataIf();
  
  public abstract FightTeam toBeanIf();
  
  public abstract Map<Integer, FightGroup> getGroups();
  
  public abstract Map<Integer, Integer> getExtra();
  
  public abstract Map<Integer, Integer> getExtraAsData();
  
  public abstract Set<TeamEffect> getTeameffects();
  
  public abstract FightInfo.AITeamVariable getAiteamvariable();
  
  public abstract int getAssistfellownum();
  
  public abstract void setAiteamvariable(FightInfo.AITeamVariable paramAITeamVariable);
  
  public abstract void setAssistfellownum(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FightTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */