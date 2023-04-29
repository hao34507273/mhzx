package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface TreasureBagRoamOperator
  extends Bean
{
  public abstract TreasureBagRoamOperator copy();
  
  public abstract TreasureBagRoamOperator toData();
  
  public abstract TreasureBagRoamOperator toBean();
  
  public abstract TreasureBagRoamOperator toDataIf();
  
  public abstract TreasureBagRoamOperator toBeanIf();
  
  public abstract List<RoamItemRecord> getRecordlist();
  
  public abstract List<RoamItemRecord> getRecordlistAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TreasureBagRoamOperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */