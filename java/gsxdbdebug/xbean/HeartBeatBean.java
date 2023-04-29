package xbean;

import mzm.gsp.online.main.HeartbeatLogObserver;
import xdb.Bean;

public abstract interface HeartBeatBean
  extends Bean
{
  public abstract HeartBeatBean copy();
  
  public abstract HeartBeatBean toData();
  
  public abstract HeartBeatBean toBean();
  
  public abstract HeartBeatBean toDataIf();
  
  public abstract HeartBeatBean toBeanIf();
  
  public abstract HeartbeatLogObserver getHeartbeatobserver();
  
  public abstract void setHeartbeatobserver(HeartbeatLogObserver paramHeartbeatLogObserver);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\HeartBeatBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */