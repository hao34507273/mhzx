package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface NoneRealTimeMultiFightValueRankBackUp
  extends Bean
{
  public abstract NoneRealTimeMultiFightValueRankBackUp copy();
  
  public abstract NoneRealTimeMultiFightValueRankBackUp toData();
  
  public abstract NoneRealTimeMultiFightValueRankBackUp toBean();
  
  public abstract NoneRealTimeMultiFightValueRankBackUp toDataIf();
  
  public abstract NoneRealTimeMultiFightValueRankBackUp toBeanIf();
  
  public abstract List<NoneRealRoleMultiFightValueBean> getRankdatas();
  
  public abstract List<NoneRealRoleMultiFightValueBean> getRankdatasAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\NoneRealTimeMultiFightValueRankBackUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */