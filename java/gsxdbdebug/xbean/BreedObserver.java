package xbean;

import mzm.gsp.children.main.BabyPeriodBreedObserver;
import xdb.Bean;

public abstract interface BreedObserver
  extends Bean
{
  public abstract BreedObserver copy();
  
  public abstract BreedObserver toData();
  
  public abstract BreedObserver toBean();
  
  public abstract BreedObserver toDataIf();
  
  public abstract BreedObserver toBeanIf();
  
  public abstract BabyPeriodBreedObserver getObserver();
  
  public abstract void setObserver(BabyPeriodBreedObserver paramBabyPeriodBreedObserver);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BreedObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */