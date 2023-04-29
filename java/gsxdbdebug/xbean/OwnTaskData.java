package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface OwnTaskData
  extends Bean
{
  public abstract OwnTaskData copy();
  
  public abstract OwnTaskData toData();
  
  public abstract OwnTaskData toBean();
  
  public abstract OwnTaskData toDataIf();
  
  public abstract OwnTaskData toBeanIf();
  
  public abstract Set<Integer> getGraphids();
  
  public abstract Set<Integer> getGraphidsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\OwnTaskData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */