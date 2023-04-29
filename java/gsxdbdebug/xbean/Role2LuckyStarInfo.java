package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface Role2LuckyStarInfo
  extends Bean
{
  public abstract Role2LuckyStarInfo copy();
  
  public abstract Role2LuckyStarInfo toData();
  
  public abstract Role2LuckyStarInfo toBean();
  
  public abstract Role2LuckyStarInfo toDataIf();
  
  public abstract Role2LuckyStarInfo toBeanIf();
  
  public abstract Map<Integer, LuckyStarInfo> getLucky_star_info_map();
  
  public abstract Map<Integer, LuckyStarInfo> getLucky_star_info_mapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Role2LuckyStarInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */