package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface CrossBattleOwn
  extends Bean
{
  public abstract CrossBattleOwn copy();
  
  public abstract CrossBattleOwn toData();
  
  public abstract CrossBattleOwn toBean();
  
  public abstract CrossBattleOwn toDataIf();
  
  public abstract CrossBattleOwn toBeanIf();
  
  public abstract int getStage();
  
  public abstract Map<Long, AttendCorpsInfo> getAttend_corps_infos();
  
  public abstract Map<Long, AttendCorpsInfo> getAttend_corps_infosAsData();
  
  public abstract List<Long> getVote_stage_direct_promotion_corps_list();
  
  public abstract List<Long> getVote_stage_direct_promotion_corps_listAsData();
  
  public abstract List<Long> getRound_robin_point_rank_list();
  
  public abstract List<Long> getRound_robin_point_rank_listAsData();
  
  public abstract int getRound_robin_round_index();
  
  public abstract List<RoundRobinRoundInfo> getRound_robin_round_infos();
  
  public abstract List<RoundRobinRoundInfo> getRound_robin_round_infosAsData();
  
  public abstract List<Long> getRound_robin_stage_promotion_corps_list();
  
  public abstract List<Long> getRound_robin_stage_promotion_corps_listAsData();
  
  public abstract boolean getReport_result_success();
  
  public abstract void setStage(int paramInt);
  
  public abstract void setRound_robin_round_index(int paramInt);
  
  public abstract void setReport_result_success(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossBattleOwn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */