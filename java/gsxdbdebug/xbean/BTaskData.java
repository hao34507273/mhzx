package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface BTaskData
  extends Bean
{
  public abstract BTaskData copy();
  
  public abstract BTaskData toData();
  
  public abstract BTaskData toBean();
  
  public abstract BTaskData toDataIf();
  
  public abstract BTaskData toBeanIf();
  
  public abstract List<Integer> getTaskids();
  
  public abstract List<Integer> getTaskidsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BTaskData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */