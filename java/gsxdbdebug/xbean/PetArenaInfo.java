package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface PetArenaInfo
  extends Bean
{
  public abstract PetArenaInfo copy();
  
  public abstract PetArenaInfo toData();
  
  public abstract PetArenaInfo toBean();
  
  public abstract PetArenaInfo toDataIf();
  
  public abstract PetArenaInfo toBeanIf();
  
  public abstract int getToday_point();
  
  public abstract int getChallenge_count();
  
  public abstract int getBuy_count();
  
  public abstract long getRefresh_time();
  
  public abstract List<PetArenaRankInfo> getOpponent_ranks();
  
  public abstract List<PetArenaRankInfo> getOpponent_ranksAsData();
  
  public abstract int getMax_rank();
  
  public abstract int getWin_num();
  
  public abstract int getLose_num();
  
  public abstract int getDefend_win_num();
  
  public abstract int getDefend_lose_num();
  
  public abstract List<PetArenaFightRecordInfo> getRecords();
  
  public abstract List<PetArenaFightRecordInfo> getRecordsAsData();
  
  public abstract long getInit_time();
  
  public abstract PetArenaFightAward getAward();
  
  public abstract int getOpponent_serial();
  
  public abstract void setToday_point(int paramInt);
  
  public abstract void setChallenge_count(int paramInt);
  
  public abstract void setBuy_count(int paramInt);
  
  public abstract void setRefresh_time(long paramLong);
  
  public abstract void setMax_rank(int paramInt);
  
  public abstract void setWin_num(int paramInt);
  
  public abstract void setLose_num(int paramInt);
  
  public abstract void setDefend_win_num(int paramInt);
  
  public abstract void setDefend_lose_num(int paramInt);
  
  public abstract void setInit_time(long paramLong);
  
  public abstract void setOpponent_serial(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PetArenaInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */