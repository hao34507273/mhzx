package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface FurnitureUuIds
  extends Bean
{
  public abstract FurnitureUuIds copy();
  
  public abstract FurnitureUuIds toData();
  
  public abstract FurnitureUuIds toBean();
  
  public abstract FurnitureUuIds toDataIf();
  
  public abstract FurnitureUuIds toBeanIf();
  
  public abstract Set<Long> getUuids();
  
  public abstract Set<Long> getUuidsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FurnitureUuIds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */