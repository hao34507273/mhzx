package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ItemSubid2Count
  extends Bean
{
  public abstract ItemSubid2Count copy();
  
  public abstract ItemSubid2Count toData();
  
  public abstract ItemSubid2Count toBean();
  
  public abstract ItemSubid2Count toDataIf();
  
  public abstract ItemSubid2Count toBeanIf();
  
  public abstract Map<Integer, IdCounter> getItemsubid2count();
  
  public abstract Map<Integer, IdCounter> getItemsubid2countAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ItemSubid2Count.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */