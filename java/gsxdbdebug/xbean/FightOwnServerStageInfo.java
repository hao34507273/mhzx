package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface FightOwnServerStageInfo
  extends Bean
{
  public abstract FightOwnServerStageInfo copy();
  
  public abstract FightOwnServerStageInfo toData();
  
  public abstract FightOwnServerStageInfo toBean();
  
  public abstract FightOwnServerStageInfo toDataIf();
  
  public abstract FightOwnServerStageInfo toBeanIf();
  
  public abstract List<FightAgainstInfo> getFight_against_info_list();
  
  public abstract List<FightAgainstInfo> getFight_against_info_listAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FightOwnServerStageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */