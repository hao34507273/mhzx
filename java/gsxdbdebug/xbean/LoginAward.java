package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface LoginAward
  extends Bean
{
  public abstract LoginAward copy();
  
  public abstract LoginAward toData();
  
  public abstract LoginAward toBean();
  
  public abstract LoginAward toDataIf();
  
  public abstract LoginAward toBeanIf();
  
  public abstract long getLogintime();
  
  public abstract int getLoginday();
  
  public abstract List<Integer> getDayawardlist();
  
  public abstract List<Integer> getDayawardlistAsData();
  
  public abstract void setLogintime(long paramLong);
  
  public abstract void setLoginday(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LoginAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */