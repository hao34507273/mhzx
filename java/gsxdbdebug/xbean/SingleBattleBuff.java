package xbean;

import java.util.Map;
import mzm.gsp.timer.main.Session;
import xdb.Bean;

public abstract interface SingleBattleBuff
  extends Bean
{
  public abstract SingleBattleBuff copy();
  
  public abstract SingleBattleBuff toData();
  
  public abstract SingleBattleBuff toBean();
  
  public abstract SingleBattleBuff toDataIf();
  
  public abstract SingleBattleBuff toBeanIf();
  
  public abstract Session getSession();
  
  public abstract Map<Integer, BuffInfo> getBuff_infos();
  
  public abstract Map<Integer, BuffInfo> getBuff_infosAsData();
  
  public abstract Map<Integer, ZoneInfo> getZone_infos();
  
  public abstract Map<Integer, ZoneInfo> getZone_infosAsData();
  
  public abstract void setSession(Session paramSession);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SingleBattleBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */