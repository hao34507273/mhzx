package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleBattleTaskData
  extends Bean
{
  public abstract RoleBattleTaskData copy();
  
  public abstract RoleBattleTaskData toData();
  
  public abstract RoleBattleTaskData toBean();
  
  public abstract RoleBattleTaskData toDataIf();
  
  public abstract RoleBattleTaskData toBeanIf();
  
  public abstract Map<Integer, BattleTaskData> getTaskdatas();
  
  public abstract Map<Integer, BattleTaskData> getTaskdatasAsData();
  
  public abstract int getPoint();
  
  public abstract void setPoint(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleBattleTaskData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */