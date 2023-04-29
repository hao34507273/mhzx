package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface MarketPetCon
  extends Bean
{
  public abstract MarketPetCon copy();
  
  public abstract MarketPetCon toData();
  
  public abstract MarketPetCon toBean();
  
  public abstract MarketPetCon toDataIf();
  
  public abstract MarketPetCon toBeanIf();
  
  public abstract Set<Integer> getQualitys();
  
  public abstract Set<Integer> getQualitysAsData();
  
  public abstract Set<Integer> getPettypes();
  
  public abstract Set<Integer> getPettypesAsData();
  
  public abstract int getSkillnum();
  
  public abstract Set<Integer> getSkillids();
  
  public abstract Set<Integer> getSkillidsAsData();
  
  public abstract long getCusttime();
  
  public abstract void setSkillnum(int paramInt);
  
  public abstract void setCusttime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MarketPetCon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */