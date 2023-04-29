package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface LineUp
  extends Bean
{
  public abstract LineUp copy();
  
  public abstract LineUp toData();
  
  public abstract LineUp toBean();
  
  public abstract LineUp toDataIf();
  
  public abstract LineUp toBeanIf();
  
  public abstract Map<Integer, Integer> getPositions();
  
  public abstract Map<Integer, Integer> getPositionsAsData();
  
  public abstract int getZhenfaid();
  
  public abstract void setZhenfaid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LineUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */