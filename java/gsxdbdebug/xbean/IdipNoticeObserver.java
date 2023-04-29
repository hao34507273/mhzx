package xbean;

import mzm.gsp.timer.main.Observer;
import xdb.Bean;

public abstract interface IdipNoticeObserver
  extends Bean
{
  public abstract IdipNoticeObserver copy();
  
  public abstract IdipNoticeObserver toData();
  
  public abstract IdipNoticeObserver toBean();
  
  public abstract IdipNoticeObserver toDataIf();
  
  public abstract IdipNoticeObserver toBeanIf();
  
  public abstract Observer getObserver();
  
  public abstract void setObserver(Observer paramObserver);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\IdipNoticeObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */