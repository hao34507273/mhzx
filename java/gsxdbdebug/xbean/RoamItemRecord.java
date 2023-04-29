package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface RoamItemRecord
  extends Bean
{
  public abstract RoamItemRecord copy();
  
  public abstract RoamItemRecord toData();
  
  public abstract RoamItemRecord toBean();
  
  public abstract RoamItemRecord toDataIf();
  
  public abstract RoamItemRecord toBeanIf();
  
  public abstract List<Integer> getLogreason();
  
  public abstract List<Integer> getLogreasonAsData();
  
  public abstract int getRemovemodel();
  
  public abstract Map<Integer, Integer> getItemmap();
  
  public abstract Map<Integer, Integer> getItemmapAsData();
  
  public abstract void setRemovemodel(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoamItemRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */