package xbean;

import java.util.Map;
import mzm.gsp.timer.main.Observer;
import xdb.Bean;

public abstract interface MassExpObserver
  extends Bean
{
  public abstract MassExpObserver copy();
  
  public abstract MassExpObserver toData();
  
  public abstract MassExpObserver toBean();
  
  public abstract MassExpObserver toDataIf();
  
  public abstract MassExpObserver toBeanIf();
  
  public abstract Map<Integer, Observer> getObservers();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MassExpObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */