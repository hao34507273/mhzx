package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface PetArenaRankBackup
  extends Bean
{
  public abstract PetArenaRankBackup copy();
  
  public abstract PetArenaRankBackup toData();
  
  public abstract PetArenaRankBackup toBean();
  
  public abstract PetArenaRankBackup toDataIf();
  
  public abstract PetArenaRankBackup toBeanIf();
  
  public abstract Map<Long, Integer> getRole_ranks();
  
  public abstract Map<Long, Integer> getRole_ranksAsData();
  
  public abstract Map<Long, Integer> getAwards();
  
  public abstract Map<Long, Integer> getAwardsAsData();
  
  public abstract long getAward_time();
  
  public abstract void setAward_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PetArenaRankBackup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */