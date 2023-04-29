package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface FightStageInfo
  extends Bean
{
  public abstract FightStageInfo copy();
  
  public abstract FightStageInfo toData();
  
  public abstract FightStageInfo toBean();
  
  public abstract FightStageInfo toDataIf();
  
  public abstract FightStageInfo toBeanIf();
  
  public abstract Map<Integer, FightAgainstInfo> getFight_against_info_map();
  
  public abstract Map<Integer, FightAgainstInfo> getFight_against_info_mapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FightStageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */