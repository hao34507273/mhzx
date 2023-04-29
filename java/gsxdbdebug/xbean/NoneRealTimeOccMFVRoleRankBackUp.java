package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface NoneRealTimeOccMFVRoleRankBackUp
  extends Bean
{
  public abstract NoneRealTimeOccMFVRoleRankBackUp copy();
  
  public abstract NoneRealTimeOccMFVRoleRankBackUp toData();
  
  public abstract NoneRealTimeOccMFVRoleRankBackUp toBean();
  
  public abstract NoneRealTimeOccMFVRoleRankBackUp toDataIf();
  
  public abstract NoneRealTimeOccMFVRoleRankBackUp toBeanIf();
  
  public abstract List<NoneRealRoleMultiFightValueBean> getRole_datas();
  
  public abstract List<NoneRealRoleMultiFightValueBean> getRole_datasAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\NoneRealTimeOccMFVRoleRankBackUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */