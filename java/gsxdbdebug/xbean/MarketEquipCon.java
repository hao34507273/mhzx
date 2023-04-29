package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface MarketEquipCon
  extends Bean
{
  public abstract MarketEquipCon copy();
  
  public abstract MarketEquipCon toData();
  
  public abstract MarketEquipCon toBean();
  
  public abstract MarketEquipCon toDataIf();
  
  public abstract MarketEquipCon toBeanIf();
  
  public abstract int getLevel();
  
  public abstract Set<Integer> getColors();
  
  public abstract Set<Integer> getColorsAsData();
  
  public abstract Set<Integer> getSkillids();
  
  public abstract Set<Integer> getSkillidsAsData();
  
  public abstract long getCusttime();
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setCusttime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MarketEquipCon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */