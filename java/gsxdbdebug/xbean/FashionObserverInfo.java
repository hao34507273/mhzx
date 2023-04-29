package xbean;

import java.util.Map;
import mzm.gsp.timer.main.Observer;
import xdb.Bean;

public abstract interface FashionObserverInfo
  extends Bean
{
  public abstract FashionObserverInfo copy();
  
  public abstract FashionObserverInfo toData();
  
  public abstract FashionObserverInfo toBean();
  
  public abstract FashionObserverInfo toDataIf();
  
  public abstract FashionObserverInfo toBeanIf();
  
  public abstract Map<Integer, Observer> getObservers();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FashionObserverInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */