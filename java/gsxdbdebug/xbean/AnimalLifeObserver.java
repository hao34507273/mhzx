package xbean;

import mzm.gsp.timer.main.Observer;
import xdb.Bean;

public abstract interface AnimalLifeObserver
  extends Bean
{
  public abstract AnimalLifeObserver copy();
  
  public abstract AnimalLifeObserver toData();
  
  public abstract AnimalLifeObserver toBean();
  
  public abstract AnimalLifeObserver toDataIf();
  
  public abstract AnimalLifeObserver toBeanIf();
  
  public abstract Observer getObserver();
  
  public abstract void setObserver(Observer paramObserver);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AnimalLifeObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */