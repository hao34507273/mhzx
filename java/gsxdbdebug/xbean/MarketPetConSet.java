package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface MarketPetConSet
  extends Bean
{
  public abstract MarketPetConSet copy();
  
  public abstract MarketPetConSet toData();
  
  public abstract MarketPetConSet toBean();
  
  public abstract MarketPetConSet toDataIf();
  
  public abstract MarketPetConSet toBeanIf();
  
  public abstract List<MarketPetCon> getPetcons();
  
  public abstract List<MarketPetCon> getPetconsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MarketPetConSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */