package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface FactionCompetition
  extends Bean
{
  public abstract FactionCompetition copy();
  
  public abstract FactionCompetition toData();
  
  public abstract FactionCompetition toBean();
  
  public abstract FactionCompetition toDataIf();
  
  public abstract FactionCompetition toBeanIf();
  
  public abstract int getElo_rank();
  
  public abstract int getPk_score();
  
  public abstract int getPlayer_score();
  
  public abstract boolean getParticipated();
  
  public abstract long getOpponent();
  
  public abstract int getWin_times();
  
  public abstract int getLose_times();
  
  public abstract int getActive_number();
  
  public abstract int getLast_active_number();
  
  public abstract long getActive_timestamp();
  
  public abstract int getMercenary_score();
  
  public abstract int getPaticipate_count();
  
  public abstract int getLast_partcipate_count();
  
  public abstract List<Long> getParticipate_roles();
  
  public abstract List<Long> getParticipate_rolesAsData();
  
  public abstract void setElo_rank(int paramInt);
  
  public abstract void setPk_score(int paramInt);
  
  public abstract void setPlayer_score(int paramInt);
  
  public abstract void setParticipated(boolean paramBoolean);
  
  public abstract void setOpponent(long paramLong);
  
  public abstract void setWin_times(int paramInt);
  
  public abstract void setLose_times(int paramInt);
  
  public abstract void setActive_number(int paramInt);
  
  public abstract void setLast_active_number(int paramInt);
  
  public abstract void setActive_timestamp(long paramLong);
  
  public abstract void setMercenary_score(int paramInt);
  
  public abstract void setPaticipate_count(int paramInt);
  
  public abstract void setLast_partcipate_count(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FactionCompetition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */