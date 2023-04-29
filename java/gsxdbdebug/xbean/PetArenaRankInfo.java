package xbean;

import xdb.Bean;

public abstract interface PetArenaRankInfo
  extends Bean
{
  public abstract PetArenaRankInfo copy();
  
  public abstract PetArenaRankInfo toData();
  
  public abstract PetArenaRankInfo toBean();
  
  public abstract PetArenaRankInfo toDataIf();
  
  public abstract PetArenaRankInfo toBeanIf();
  
  public abstract int getRank();
  
  public abstract long getRoleid();
  
  public abstract void setRank(int paramInt);
  
  public abstract void setRoleid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PetArenaRankInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */