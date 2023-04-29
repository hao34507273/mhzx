package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface VisibleMonsterFight
  extends Bean
{
  public abstract VisibleMonsterFight copy();
  
  public abstract VisibleMonsterFight toData();
  
  public abstract VisibleMonsterFight toBean();
  
  public abstract VisibleMonsterFight toDataIf();
  
  public abstract VisibleMonsterFight toBeanIf();
  
  public abstract Map<Integer, Integer> getCountermap();
  
  public abstract Map<Integer, Integer> getCountermapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\VisibleMonsterFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */