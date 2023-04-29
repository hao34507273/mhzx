package xbean;

import java.util.List;
import java.util.Map;
import mzm.gsp.memorycompetition.main.MemoryCompetitionPrepareObserver;
import mzm.gsp.memorycompetition.main.MemoryCompetitionQuestionObserver;
import xdb.Bean;

public abstract interface MemoryCompetitionInfo
  extends Bean
{
  public abstract MemoryCompetitionInfo copy();
  
  public abstract MemoryCompetitionInfo toData();
  
  public abstract MemoryCompetitionInfo toBean();
  
  public abstract MemoryCompetitionInfo toDataIf();
  
  public abstract MemoryCompetitionInfo toBeanIf();
  
  public abstract Map<Integer, Integer> getMapping();
  
  public abstract Map<Integer, Integer> getMappingAsData();
  
  public abstract List<Long> getRole_id_list();
  
  public abstract List<Long> getRole_id_listAsData();
  
  public abstract int getActivity_cfg_id();
  
  public abstract int getMemory_competition_cfg_id();
  
  public abstract int getCurrent_round_num();
  
  public abstract int getCurrent_score();
  
  public abstract boolean getIs_need_notify_after_every_question();
  
  public abstract MemoryCompetitionQuestionObserver getRoles_current_question_observer();
  
  public abstract Map<Long, RolesMemoryQuestion> getRoles_answered_question_map();
  
  public abstract Map<Long, RolesMemoryQuestion> getRoles_answered_question_mapAsData();
  
  public abstract Map<Long, Integer> getRoles_seek_help_times_map();
  
  public abstract Map<Long, Integer> getRoles_seek_help_times_mapAsData();
  
  public abstract MemoryCompetitionPrepareObserver getRoles_current_prepare_question_observer();
  
  public abstract void setActivity_cfg_id(int paramInt);
  
  public abstract void setMemory_competition_cfg_id(int paramInt);
  
  public abstract void setCurrent_round_num(int paramInt);
  
  public abstract void setCurrent_score(int paramInt);
  
  public abstract void setIs_need_notify_after_every_question(boolean paramBoolean);
  
  public abstract void setRoles_current_question_observer(MemoryCompetitionQuestionObserver paramMemoryCompetitionQuestionObserver);
  
  public abstract void setRoles_current_prepare_question_observer(MemoryCompetitionPrepareObserver paramMemoryCompetitionPrepareObserver);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MemoryCompetitionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */