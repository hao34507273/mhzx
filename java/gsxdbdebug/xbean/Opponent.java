package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface Opponent
  extends Bean
{
  public abstract Opponent copy();
  
  public abstract Opponent toData();
  
  public abstract Opponent toBean();
  
  public abstract Opponent toDataIf();
  
  public abstract Opponent toBeanIf();
  
  public abstract long getLastfreshtime();
  
  public abstract long getAutofreshtime();
  
  public abstract List<Long> getOpponentroleids();
  
  public abstract List<Long> getOpponentroleidsAsData();
  
  public abstract void setLastfreshtime(long paramLong);
  
  public abstract void setAutofreshtime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Opponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */