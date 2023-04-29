package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface AllActivityInfo
  extends Bean
{
  public abstract AllActivityInfo copy();
  
  public abstract AllActivityInfo toData();
  
  public abstract AllActivityInfo toBean();
  
  public abstract AllActivityInfo toDataIf();
  
  public abstract AllActivityInfo toBeanIf();
  
  public abstract Map<Integer, SingleActivityInfo> getActivitydata();
  
  public abstract Map<Integer, SingleActivityInfo> getActivitydataAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AllActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */