package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface ConstellationCards
  extends Bean
{
  public abstract ConstellationCards copy();
  
  public abstract ConstellationCards toData();
  
  public abstract ConstellationCards toBean();
  
  public abstract ConstellationCards toDataIf();
  
  public abstract ConstellationCards toBeanIf();
  
  public abstract int getConstellation();
  
  public abstract List<Integer> getStars();
  
  public abstract List<Integer> getStarsAsData();
  
  public abstract int getFortune();
  
  public abstract void setConstellation(int paramInt);
  
  public abstract void setFortune(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ConstellationCards.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */