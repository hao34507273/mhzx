package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface AllLostExpInfo
  extends Bean
{
  public abstract AllLostExpInfo copy();
  
  public abstract AllLostExpInfo toData();
  
  public abstract AllLostExpInfo toBean();
  
  public abstract AllLostExpInfo toDataIf();
  
  public abstract AllLostExpInfo toBeanIf();
  
  public abstract Map<Integer, LostExpInfo> getActivityid2lostexpinfo();
  
  public abstract Map<Integer, LostExpInfo> getActivityid2lostexpinfoAsData();
  
  public abstract long getLastupdatetime();
  
  public abstract void setLastupdatetime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AllLostExpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */