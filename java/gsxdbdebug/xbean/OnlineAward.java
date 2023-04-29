package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface OnlineAward
  extends Bean
{
  public abstract OnlineAward copy();
  
  public abstract OnlineAward toData();
  
  public abstract OnlineAward toBean();
  
  public abstract OnlineAward toDataIf();
  
  public abstract OnlineAward toBeanIf();
  
  public abstract long getLogintime();
  
  public abstract long getOnlinetime();
  
  public abstract List<Integer> getOnlineawardlist();
  
  public abstract List<Integer> getOnlineawardlistAsData();
  
  public abstract void setLogintime(long paramLong);
  
  public abstract void setOnlinetime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\OnlineAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */