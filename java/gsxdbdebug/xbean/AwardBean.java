package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface AwardBean
  extends Bean
{
  public abstract AwardBean copy();
  
  public abstract AwardBean toData();
  
  public abstract AwardBean toBean();
  
  public abstract AwardBean toDataIf();
  
  public abstract AwardBean toBeanIf();
  
  public abstract List<Integer> getAwarditems();
  
  public abstract List<Integer> getAwarditemsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AwardBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */