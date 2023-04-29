package xbean;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mzm.gsp.fight.main.FightContext;
import mzm.gsp.fight.main.FightParam;
import mzm.gsp.fight.main.FightRecorder;
import mzm.gsp.fight.main.FightTimer;
import mzm.gsp.fight.main.SkillResultHandle;
import mzm.gsp.fight.main.UpdateTimer;
import xdb.Bean;

public abstract interface Fight
  extends Bean
{
  public static final int FLOW_FIGHT_START = 0;
  public static final int FLOW_BEFORE_ROUND = 1;
  public static final int FLOW_PREPARE_1 = 2;
  public static final int FLOW_PREPARE_2 = 3;
  public static final int FLOW_BEFORE_PLAY = 4;
  public static final int FLOW_PLAY = 5;
  public static final int FLOW_ROUND_END = 6;
  
  public abstract Fight copy();
  
  public abstract Fight toData();
  
  public abstract Fight toBean();
  
  public abstract Fight toDataIf();
  
  public abstract Fight toBeanIf();
  
  public abstract FightContext getContext();
  
  public abstract int getType();
  
  public abstract int getCfgtype();
  
  public abstract int getFightreason();
  
  public abstract int getRound();
  
  public abstract long getStarttime();
  
  public abstract int getNextid();
  
  public abstract FightTeam getActive();
  
  public abstract FightTeam getPassive();
  
  public abstract Set<Long> getCurroundendroles();
  
  public abstract Set<Long> getCurroundendrolesAsData();
  
  public abstract boolean getIscurroundend();
  
  public abstract int getFlow();
  
  public abstract List<FightCmd> getCmds();
  
  public abstract List<FightCmd> getCmdsAsData();
  
  public abstract Map<Integer, Integer> getExtra();
  
  public abstract Map<Integer, Integer> getExtraAsData();
  
  public abstract LinkedHashMap<Long, Integer> getObservers();
  
  public abstract FightTimer getTimer();
  
  public abstract UpdateTimer getUpdatetimer();
  
  public abstract long getNexttimermillsec();
  
  public abstract int getActiontotalcount();
  
  public abstract int getActionroundmaxcount();
  
  public abstract int getActioncountcurround();
  
  public abstract FightParam getFightparams();
  
  public abstract FightRecorder getFight_recorder();
  
  public abstract Set<SkillResultHandle> getSkillresulthandles();
  
  public abstract boolean getGenresultatonce();
  
  public abstract void setContext(FightContext paramFightContext);
  
  public abstract void setType(int paramInt);
  
  public abstract void setCfgtype(int paramInt);
  
  public abstract void setFightreason(int paramInt);
  
  public abstract void setRound(int paramInt);
  
  public abstract void setStarttime(long paramLong);
  
  public abstract void setNextid(int paramInt);
  
  public abstract void setIscurroundend(boolean paramBoolean);
  
  public abstract void setFlow(int paramInt);
  
  public abstract void setObservers(LinkedHashMap<Long, Integer> paramLinkedHashMap);
  
  public abstract void setTimer(FightTimer paramFightTimer);
  
  public abstract void setUpdatetimer(UpdateTimer paramUpdateTimer);
  
  public abstract void setNexttimermillsec(long paramLong);
  
  public abstract void setActiontotalcount(int paramInt);
  
  public abstract void setActionroundmaxcount(int paramInt);
  
  public abstract void setActioncountcurround(int paramInt);
  
  public abstract void setFightparams(FightParam paramFightParam);
  
  public abstract void setFight_recorder(FightRecorder paramFightRecorder);
  
  public abstract void setGenresultatonce(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Fight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */