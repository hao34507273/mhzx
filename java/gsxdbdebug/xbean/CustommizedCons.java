package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface CustommizedCons
  extends Bean
{
  public abstract CustommizedCons copy();
  
  public abstract CustommizedCons toData();
  
  public abstract CustommizedCons toBean();
  
  public abstract CustommizedCons toDataIf();
  
  public abstract CustommizedCons toBeanIf();
  
  public abstract long getLastsearchtime();
  
  public abstract Map<Integer, MarketEquipConSet> getSubid2equipcons();
  
  public abstract Map<Integer, MarketEquipConSet> getSubid2equipconsAsData();
  
  public abstract Map<Integer, MarketPetConSet> getSubid2petcons();
  
  public abstract Map<Integer, MarketPetConSet> getSubid2petconsAsData();
  
  public abstract Map<Integer, MarketPetEquipConSet> getSubid2petequipcons();
  
  public abstract Map<Integer, MarketPetEquipConSet> getSubid2petequipconsAsData();
  
  public abstract void setLastsearchtime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CustommizedCons.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */