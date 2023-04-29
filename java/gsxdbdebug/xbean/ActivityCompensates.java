package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ActivityCompensates
  extends Bean
{
  public abstract ActivityCompensates copy();
  
  public abstract ActivityCompensates toData();
  
  public abstract ActivityCompensates toBean();
  
  public abstract ActivityCompensates toDataIf();
  
  public abstract ActivityCompensates toBeanIf();
  
  public abstract Map<Integer, ActivityCompensate> getCompensates();
  
  public abstract Map<Integer, ActivityCompensate> getCompensatesAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ActivityCompensates.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */