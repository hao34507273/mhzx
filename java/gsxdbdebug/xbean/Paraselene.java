package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface Paraselene
  extends Bean
{
  public abstract Paraselene copy();
  
  public abstract Paraselene toData();
  
  public abstract Paraselene toBean();
  
  public abstract Paraselene toDataIf();
  
  public abstract Paraselene toBeanIf();
  
  public abstract long getStarttime();
  
  public abstract long getFinishtime();
  
  public abstract int getRecentlayer();
  
  public abstract boolean getIsinfuben();
  
  public abstract List<Integer> getLayers();
  
  public abstract List<Integer> getLayersAsData();
  
  public abstract void setStarttime(long paramLong);
  
  public abstract void setFinishtime(long paramLong);
  
  public abstract void setRecentlayer(int paramInt);
  
  public abstract void setIsinfuben(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Paraselene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */