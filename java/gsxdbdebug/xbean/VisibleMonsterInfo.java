package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface VisibleMonsterInfo
  extends Bean
{
  public abstract VisibleMonsterInfo copy();
  
  public abstract VisibleMonsterInfo toData();
  
  public abstract VisibleMonsterInfo toBean();
  
  public abstract VisibleMonsterInfo toDataIf();
  
  public abstract VisibleMonsterInfo toBeanIf();
  
  public abstract Map<Integer, Integer> getMonster_type_times_map();
  
  public abstract Map<Integer, Integer> getMonster_type_times_mapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\VisibleMonsterInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */