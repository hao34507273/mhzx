package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface BoxAwardBean
  extends Bean
{
  public abstract BoxAwardBean copy();
  
  public abstract BoxAwardBean toData();
  
  public abstract BoxAwardBean toBean();
  
  public abstract BoxAwardBean toDataIf();
  
  public abstract BoxAwardBean toBeanIf();
  
  public abstract List<Long> getRoleids();
  
  public abstract List<Long> getRoleidsAsData();
  
  public abstract Map<Long, AwardBean> getAwardrolemap();
  
  public abstract Map<Long, AwardBean> getAwardrolemapAsData();
  
  public abstract Map<Long, Integer> getRollrolemap();
  
  public abstract Map<Long, Integer> getRollrolemapAsData();
  
  public abstract List<Integer> getAwarditemids();
  
  public abstract List<Integer> getAwarditemidsAsData();
  
  public abstract int getIndex();
  
  public abstract List<Long> getOperroleids();
  
  public abstract List<Long> getOperroleidsAsData();
  
  public abstract void setIndex(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BoxAwardBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */