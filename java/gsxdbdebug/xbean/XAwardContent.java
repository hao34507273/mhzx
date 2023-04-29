package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface XAwardContent
  extends Bean
{
  public abstract XAwardContent copy();
  
  public abstract XAwardContent toData();
  
  public abstract XAwardContent toBean();
  
  public abstract XAwardContent toDataIf();
  
  public abstract XAwardContent toBeanIf();
  
  public abstract Map<Integer, Integer> getXid2awardnum();
  
  public abstract Map<Integer, Integer> getXid2awardnumAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\XAwardContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */