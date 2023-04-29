package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface FactionCrossCompete
  extends Bean
{
  public abstract FactionCrossCompete copy();
  
  public abstract FactionCrossCompete toData();
  
  public abstract FactionCrossCompete toBean();
  
  public abstract FactionCrossCompete toDataIf();
  
  public abstract FactionCrossCompete toBeanIf();
  
  public abstract long getSignup_time();
  
  public abstract int getWin_times();
  
  public abstract int getLose_times();
  
  public abstract Map<Long, Integer> getFactionid2matchtimes();
  
  public abstract Map<Long, Integer> getFactionid2matchtimesAsData();
  
  public abstract int getMiss_turn_times();
  
  public abstract long getOpponent();
  
  public abstract void setSignup_time(long paramLong);
  
  public abstract void setWin_times(int paramInt);
  
  public abstract void setLose_times(int paramInt);
  
  public abstract void setMiss_turn_times(int paramInt);
  
  public abstract void setOpponent(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FactionCrossCompete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */