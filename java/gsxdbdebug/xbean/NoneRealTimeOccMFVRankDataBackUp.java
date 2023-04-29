package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface NoneRealTimeOccMFVRankDataBackUp
  extends Bean
{
  public abstract NoneRealTimeOccMFVRankDataBackUp copy();
  
  public abstract NoneRealTimeOccMFVRankDataBackUp toData();
  
  public abstract NoneRealTimeOccMFVRankDataBackUp toBean();
  
  public abstract NoneRealTimeOccMFVRankDataBackUp toDataIf();
  
  public abstract NoneRealTimeOccMFVRankDataBackUp toBeanIf();
  
  public abstract Map<Integer, NoneRealTimeOccMFVRoleRankBackUp> getRank_datas();
  
  public abstract Map<Integer, NoneRealTimeOccMFVRoleRankBackUp> getRank_datasAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\NoneRealTimeOccMFVRankDataBackUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */