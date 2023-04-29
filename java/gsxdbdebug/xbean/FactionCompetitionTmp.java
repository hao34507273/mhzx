package xbean;

import xdb.Bean;

public abstract interface FactionCompetitionTmp
  extends Bean
{
  public abstract FactionCompetitionTmp copy();
  
  public abstract FactionCompetitionTmp toData();
  
  public abstract FactionCompetitionTmp toBean();
  
  public abstract FactionCompetitionTmp toDataIf();
  
  public abstract FactionCompetitionTmp toBeanIf();
  
  public abstract long getWorld();
  
  public abstract int getPlayer_num();
  
  public abstract void setWorld(long paramLong);
  
  public abstract void setPlayer_num(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FactionCompetitionTmp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */