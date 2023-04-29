package xbean;

import mzm.gsp.timer.main.Observer;
import xdb.Bean;

public abstract interface AdvertObserver
  extends Bean
{
  public abstract AdvertObserver copy();
  
  public abstract AdvertObserver toData();
  
  public abstract AdvertObserver toBean();
  
  public abstract AdvertObserver toDataIf();
  
  public abstract AdvertObserver toBeanIf();
  
  public abstract Observer getObserver();
  
  public abstract void setObserver(Observer paramObserver);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AdvertObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */