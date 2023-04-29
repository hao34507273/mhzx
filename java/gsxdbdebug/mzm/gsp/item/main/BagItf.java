package mzm.gsp.item.main;

import java.util.Map;

public abstract interface BagItf<E>
{
  public abstract boolean add(E paramE);
  
  public abstract boolean add(int paramInt, E paramE);
  
  public abstract E removeByGrid(int paramInt);
  
  public abstract Map<Integer, E> getAllItems(boolean paramBoolean);
  
  public abstract E get(int paramInt);
  
  public abstract int getCapacity();
  
  public abstract boolean expandCapacity(int paramInt);
  
  public abstract boolean isBagFull();
  
  public abstract boolean isGridEmpty(int paramInt);
  
  public abstract int size();
  
  public abstract void clear();
  
  public abstract int getNextAvailableGrid();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\BagItf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */