package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface Reason2Resource
  extends Bean
{
  public abstract Reason2Resource copy();
  
  public abstract Reason2Resource toData();
  
  public abstract Reason2Resource toBean();
  
  public abstract Reason2Resource toDataIf();
  
  public abstract Reason2Resource toBeanIf();
  
  public abstract Map<Integer, ResourceId2Num> getReason2item();
  
  public abstract Map<Integer, ResourceId2Num> getReason2itemAsData();
  
  public abstract long getItemupdatetime();
  
  public abstract void setItemupdatetime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Reason2Resource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */