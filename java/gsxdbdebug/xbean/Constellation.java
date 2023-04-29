package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface Constellation
  extends Bean
{
  public abstract Constellation copy();
  
  public abstract Constellation toData();
  
  public abstract Constellation toBean();
  
  public abstract Constellation toDataIf();
  
  public abstract Constellation toBeanIf();
  
  public abstract List<ConstellationCards> getCards();
  
  public abstract List<ConstellationCards> getCardsAsData();
  
  public abstract int getIndex();
  
  public abstract void setIndex(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Constellation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */