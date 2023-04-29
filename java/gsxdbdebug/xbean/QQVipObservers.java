package xbean;

import java.util.Map;
import mzm.gsp.grc.main.QQVipLostObserver;
import xdb.Bean;

public abstract interface QQVipObservers
  extends Bean
{
  public abstract QQVipObservers copy();
  
  public abstract QQVipObservers toData();
  
  public abstract QQVipObservers toBean();
  
  public abstract QQVipObservers toDataIf();
  
  public abstract QQVipObservers toBeanIf();
  
  public abstract Map<Integer, QQVipLostObserver> getObservers();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\QQVipObservers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */