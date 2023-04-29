package xbean;

import mzm.gsp.timer.main.Observer;
import xdb.Bean;

public abstract interface CatExploreObserver
  extends Bean
{
  public abstract CatExploreObserver copy();
  
  public abstract CatExploreObserver toData();
  
  public abstract CatExploreObserver toBean();
  
  public abstract CatExploreObserver toDataIf();
  
  public abstract CatExploreObserver toBeanIf();
  
  public abstract Observer getObserver();
  
  public abstract void setObserver(Observer paramObserver);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CatExploreObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */