package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface AwarGiftInfo
  extends Bean
{
  public abstract AwarGiftInfo copy();
  
  public abstract AwarGiftInfo toData();
  
  public abstract AwarGiftInfo toBean();
  
  public abstract AwarGiftInfo toDataIf();
  
  public abstract AwarGiftInfo toBeanIf();
  
  public abstract Map<Integer, Integer> getType2global();
  
  public abstract Map<Integer, Integer> getType2globalAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AwarGiftInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */