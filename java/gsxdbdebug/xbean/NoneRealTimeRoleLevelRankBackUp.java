package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface NoneRealTimeRoleLevelRankBackUp
  extends Bean
{
  public abstract NoneRealTimeRoleLevelRankBackUp copy();
  
  public abstract NoneRealTimeRoleLevelRankBackUp toData();
  
  public abstract NoneRealTimeRoleLevelRankBackUp toBean();
  
  public abstract NoneRealTimeRoleLevelRankBackUp toDataIf();
  
  public abstract NoneRealTimeRoleLevelRankBackUp toBeanIf();
  
  public abstract List<NoneRealRoleLevelBean> getRankdatas();
  
  public abstract List<NoneRealRoleLevelBean> getRankdatasAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\NoneRealTimeRoleLevelRankBackUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */