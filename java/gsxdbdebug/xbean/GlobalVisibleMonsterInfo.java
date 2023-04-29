package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface GlobalVisibleMonsterInfo
  extends Bean
{
  public abstract GlobalVisibleMonsterInfo copy();
  
  public abstract GlobalVisibleMonsterInfo toData();
  
  public abstract GlobalVisibleMonsterInfo toBean();
  
  public abstract GlobalVisibleMonsterInfo toDataIf();
  
  public abstract GlobalVisibleMonsterInfo toBeanIf();
  
  public abstract Map<Integer, VisibleMonsterInfo> getActivity_visible_monster_map();
  
  public abstract Map<Integer, VisibleMonsterInfo> getActivity_visible_monster_mapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GlobalVisibleMonsterInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */