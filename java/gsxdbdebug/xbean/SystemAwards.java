package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface SystemAwards
  extends Bean
{
  public abstract SystemAwards copy();
  
  public abstract SystemAwards toData();
  
  public abstract SystemAwards toBean();
  
  public abstract SystemAwards toDataIf();
  
  public abstract SystemAwards toBeanIf();
  
  public abstract long getSequence();
  
  public abstract Map<Long, SystemAwardBean> getAwards();
  
  public abstract Map<Long, SystemAwardBean> getAwardsAsData();
  
  public abstract void setSequence(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SystemAwards.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */