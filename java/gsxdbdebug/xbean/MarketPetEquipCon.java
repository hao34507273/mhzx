package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface MarketPetEquipCon
  extends Bean
{
  public abstract MarketPetEquipCon copy();
  
  public abstract MarketPetEquipCon toData();
  
  public abstract MarketPetEquipCon toBean();
  
  public abstract MarketPetEquipCon toDataIf();
  
  public abstract MarketPetEquipCon toBeanIf();
  
  public abstract int getProperty();
  
  public abstract Set<Integer> getSkillids();
  
  public abstract Set<Integer> getSkillidsAsData();
  
  public abstract long getCusttime();
  
  public abstract void setProperty(int paramInt);
  
  public abstract void setCusttime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MarketPetEquipCon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */