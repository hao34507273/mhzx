package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface BattleGrabData
  extends Bean
{
  public abstract BattleGrabData copy();
  
  public abstract BattleGrabData toData();
  
  public abstract BattleGrabData toBean();
  
  public abstract BattleGrabData toDataIf();
  
  public abstract BattleGrabData toBeanIf();
  
  public abstract Map<Integer, GrabPositionData> getPositiondatas();
  
  public abstract Map<Integer, GrabPositionData> getPositiondatasAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BattleGrabData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */