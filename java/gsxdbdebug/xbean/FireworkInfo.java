package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface FireworkInfo
  extends Bean
{
  public abstract FireworkInfo copy();
  
  public abstract FireworkInfo toData();
  
  public abstract FireworkInfo toBean();
  
  public abstract FireworkInfo toDataIf();
  
  public abstract FireworkInfo toBeanIf();
  
  public abstract Map<Integer, FireworkRecord> getActivityid2record();
  
  public abstract Map<Integer, FireworkRecord> getActivityid2recordAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FireworkInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */