package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface Ladder
  extends Bean
{
  public abstract Ladder copy();
  
  public abstract Ladder toData();
  
  public abstract Ladder toBean();
  
  public abstract Ladder toDataIf();
  
  public abstract Ladder toBeanIf();
  
  public abstract int getScore();
  
  public abstract int getStage();
  
  public abstract int getWincount();
  
  public abstract int getLosecount();
  
  public abstract Set<Integer> getAwardstages();
  
  public abstract Set<Integer> getAwardstagesAsData();
  
  public abstract long getInittime();
  
  public abstract long getWeekinittime();
  
  public abstract int getWeekfightcount();
  
  public abstract long getWeekgotfightscore();
  
  public abstract void setScore(int paramInt);
  
  public abstract void setStage(int paramInt);
  
  public abstract void setWincount(int paramInt);
  
  public abstract void setLosecount(int paramInt);
  
  public abstract void setInittime(long paramLong);
  
  public abstract void setWeekinittime(long paramLong);
  
  public abstract void setWeekfightcount(int paramInt);
  
  public abstract void setWeekgotfightscore(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Ladder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */