package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface NoneRealTimeFightValueRankBackUp
  extends Bean
{
  public abstract NoneRealTimeFightValueRankBackUp copy();
  
  public abstract NoneRealTimeFightValueRankBackUp toData();
  
  public abstract NoneRealTimeFightValueRankBackUp toBean();
  
  public abstract NoneRealTimeFightValueRankBackUp toDataIf();
  
  public abstract NoneRealTimeFightValueRankBackUp toBeanIf();
  
  public abstract List<NoneRealRoleFightValueBean> getRankdatas();
  
  public abstract List<NoneRealRoleFightValueBean> getRankdatasAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\NoneRealTimeFightValueRankBackUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */