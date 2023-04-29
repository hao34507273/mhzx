package xbean;

import com.goldhuman.Common.Octets;
import java.util.Map;
import xdb.Bean;

public abstract interface Bag
  extends Bean
{
  public abstract Bag copy();
  
  public abstract Bag toData();
  
  public abstract Bag toBean();
  
  public abstract Bag toDataIf();
  
  public abstract Bag toBeanIf();
  
  public abstract String getBagname();
  
  public abstract Octets getBagnameOctets();
  
  public abstract int getCapacity();
  
  public abstract Map<Integer, Item> getItems();
  
  public abstract Map<Integer, Item> getItemsAsData();
  
  public abstract void setBagname(String paramString);
  
  public abstract void setBagnameOctets(Octets paramOctets);
  
  public abstract void setCapacity(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Bag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */