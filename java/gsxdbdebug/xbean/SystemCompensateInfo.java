package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface SystemCompensateInfo
  extends Bean
{
  public abstract SystemCompensateInfo copy();
  
  public abstract SystemCompensateInfo toData();
  
  public abstract SystemCompensateInfo toBean();
  
  public abstract SystemCompensateInfo toDataIf();
  
  public abstract SystemCompensateInfo toBeanIf();
  
  public abstract int getNextid();
  
  public abstract Map<Long, CompensateInfo> getCompensates();
  
  public abstract Map<Long, CompensateInfo> getCompensatesAsData();
  
  public abstract void setNextid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SystemCompensateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */