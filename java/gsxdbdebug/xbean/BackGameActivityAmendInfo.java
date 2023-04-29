package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface BackGameActivityAmendInfo
  extends Bean
{
  public abstract BackGameActivityAmendInfo copy();
  
  public abstract BackGameActivityAmendInfo toData();
  
  public abstract BackGameActivityAmendInfo toBean();
  
  public abstract BackGameActivityAmendInfo toDataIf();
  
  public abstract BackGameActivityAmendInfo toBeanIf();
  
  public abstract Set<Integer> getActivityidset();
  
  public abstract Set<Integer> getActivityidsetAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BackGameActivityAmendInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */