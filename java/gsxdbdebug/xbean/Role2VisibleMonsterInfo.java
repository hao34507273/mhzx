package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface Role2VisibleMonsterInfo
  extends Bean
{
  public abstract Role2VisibleMonsterInfo copy();
  
  public abstract Role2VisibleMonsterInfo toData();
  
  public abstract Role2VisibleMonsterInfo toBean();
  
  public abstract Role2VisibleMonsterInfo toDataIf();
  
  public abstract Role2VisibleMonsterInfo toBeanIf();
  
  public abstract Map<Integer, VisibleMonsterInfo> getActivity_visible_monster_map();
  
  public abstract Map<Integer, VisibleMonsterInfo> getActivity_visible_monster_mapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Role2VisibleMonsterInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */