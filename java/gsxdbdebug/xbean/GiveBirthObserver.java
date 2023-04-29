package xbean;

import mzm.gsp.children.main.GiveBirthTimeOutObserver;
import xdb.Bean;

public abstract interface GiveBirthObserver
  extends Bean
{
  public abstract GiveBirthObserver copy();
  
  public abstract GiveBirthObserver toData();
  
  public abstract GiveBirthObserver toBean();
  
  public abstract GiveBirthObserver toDataIf();
  
  public abstract GiveBirthObserver toBeanIf();
  
  public abstract GiveBirthTimeOutObserver getObserver();
  
  public abstract void setObserver(GiveBirthTimeOutObserver paramGiveBirthTimeOutObserver);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GiveBirthObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */