package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface BattleFightRecord
  extends Bean
{
  public abstract BattleFightRecord copy();
  
  public abstract BattleFightRecord toData();
  
  public abstract BattleFightRecord toBean();
  
  public abstract BattleFightRecord toDataIf();
  
  public abstract BattleFightRecord toBeanIf();
  
  public abstract Map<Long, SingleRecord> getRoleids();
  
  public abstract Map<Long, SingleRecord> getRoleidsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BattleFightRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */