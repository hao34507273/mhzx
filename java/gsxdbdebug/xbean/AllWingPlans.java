package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface AllWingPlans
  extends Bean
{
  public abstract AllWingPlans copy();
  
  public abstract AllWingPlans toData();
  
  public abstract AllWingPlans toBean();
  
  public abstract AllWingPlans toDataIf();
  
  public abstract AllWingPlans toBeanIf();
  
  public abstract Map<Integer, WingPlan> getWings();
  
  public abstract Map<Integer, WingPlan> getWingsAsData();
  
  public abstract int getCurplan();
  
  public abstract Map<Integer, TransferOccupationWing> getTransfer_occupation_wing_map();
  
  public abstract Map<Integer, TransferOccupationWing> getTransfer_occupation_wing_mapAsData();
  
  public abstract int getEffectwingoccid();
  
  public abstract Map<Integer, Integer> getOcc2lastplanoccid();
  
  public abstract Map<Integer, Integer> getOcc2lastplanoccidAsData();
  
  public abstract List<Integer> getNewoccplans();
  
  public abstract List<Integer> getNewoccplansAsData();
  
  public abstract void setCurplan(int paramInt);
  
  public abstract void setEffectwingoccid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AllWingPlans.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */