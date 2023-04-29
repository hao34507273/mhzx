package xbean;

import mzm.gsp.timer.main.Observer;
import xdb.Bean;

public abstract interface PetArenaAwardObserver
  extends Bean
{
  public abstract PetArenaAwardObserver copy();
  
  public abstract PetArenaAwardObserver toData();
  
  public abstract PetArenaAwardObserver toBean();
  
  public abstract PetArenaAwardObserver toDataIf();
  
  public abstract PetArenaAwardObserver toBeanIf();
  
  public abstract Observer getObserver();
  
  public abstract void setObserver(Observer paramObserver);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PetArenaAwardObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */