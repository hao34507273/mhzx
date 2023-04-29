package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface TransferOccupationPropertiesSys
  extends Bean
{
  public abstract TransferOccupationPropertiesSys copy();
  
  public abstract TransferOccupationPropertiesSys toData();
  
  public abstract TransferOccupationPropertiesSys toBean();
  
  public abstract TransferOccupationPropertiesSys toDataIf();
  
  public abstract TransferOccupationPropertiesSys toBeanIf();
  
  public abstract Map<Integer, BasicPropertiesSystem> getProperty_sys_map();
  
  public abstract Map<Integer, BasicPropertiesSystem> getProperty_sys_mapAsData();
  
  public abstract int getActivity_bp_sys();
  
  public abstract int getToday_prop_sys_switch_count();
  
  public abstract void setActivity_bp_sys(int paramInt);
  
  public abstract void setToday_prop_sys_switch_count(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TransferOccupationPropertiesSys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */