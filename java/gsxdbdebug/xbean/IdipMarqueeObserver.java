package xbean;

import mzm.gsp.timer.main.Observer;
import xdb.Bean;

public abstract interface IdipMarqueeObserver
  extends Bean
{
  public abstract IdipMarqueeObserver copy();
  
  public abstract IdipMarqueeObserver toData();
  
  public abstract IdipMarqueeObserver toBean();
  
  public abstract IdipMarqueeObserver toDataIf();
  
  public abstract IdipMarqueeObserver toBeanIf();
  
  public abstract Observer getObserver();
  
  public abstract void setObserver(Observer paramObserver);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\IdipMarqueeObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */