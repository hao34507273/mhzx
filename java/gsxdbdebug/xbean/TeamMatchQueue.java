package xbean;

import java.util.NavigableMap;
import xdb.Bean;

public abstract interface TeamMatchQueue
  extends Bean
{
  public abstract TeamMatchQueue copy();
  
  public abstract TeamMatchQueue toData();
  
  public abstract TeamMatchQueue toBean();
  
  public abstract TeamMatchQueue toDataIf();
  
  public abstract TeamMatchQueue toBeanIf();
  
  public abstract NavigableMap<Integer, TeamMatchBeans> getActivitys();
  
  public abstract NavigableMap<Integer, TeamMatchBeans> getActivitysAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TeamMatchQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */