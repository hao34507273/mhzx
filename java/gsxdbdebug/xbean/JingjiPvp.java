package xbean;

import xdb.Bean;

public abstract interface JingjiPvp
  extends Bean
{
  public abstract JingjiPvp copy();
  
  public abstract JingjiPvp toData();
  
  public abstract JingjiPvp toBean();
  
  public abstract JingjiPvp toDataIf();
  
  public abstract JingjiPvp toBeanIf();
  
  public abstract int getJifen();
  
  public abstract int getBuycount();
  
  public abstract int getBuychallengecount();
  
  public abstract int getChallengecount();
  
  public abstract int getWinpoint();
  
  public abstract int getFirstvictoryrewardid();
  
  public abstract int getFivefightrewardid();
  
  public abstract int getFightcount();
  
  public abstract int getVictorycount();
  
  public abstract boolean getIssendbulletin();
  
  public abstract int getLastseasonphase();
  
  public abstract int getLastseasonrank();
  
  public abstract long getLastseasonendtime();
  
  public abstract int getReservedexp();
  
  public abstract long getInittime();
  
  public abstract int getMerge_cleared();
  
  public abstract void setJifen(int paramInt);
  
  public abstract void setBuycount(int paramInt);
  
  public abstract void setBuychallengecount(int paramInt);
  
  public abstract void setChallengecount(int paramInt);
  
  public abstract void setWinpoint(int paramInt);
  
  public abstract void setFirstvictoryrewardid(int paramInt);
  
  public abstract void setFivefightrewardid(int paramInt);
  
  public abstract void setFightcount(int paramInt);
  
  public abstract void setVictorycount(int paramInt);
  
  public abstract void setIssendbulletin(boolean paramBoolean);
  
  public abstract void setLastseasonphase(int paramInt);
  
  public abstract void setLastseasonrank(int paramInt);
  
  public abstract void setLastseasonendtime(long paramLong);
  
  public abstract void setReservedexp(int paramInt);
  
  public abstract void setInittime(long paramLong);
  
  public abstract void setMerge_cleared(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\JingjiPvp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */