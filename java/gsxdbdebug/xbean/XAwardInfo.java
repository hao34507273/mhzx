package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface XAwardInfo
  extends Bean
{
  public abstract XAwardInfo copy();
  
  public abstract XAwardInfo toData();
  
  public abstract XAwardInfo toBean();
  
  public abstract XAwardInfo toDataIf();
  
  public abstract XAwardInfo toBeanIf();
  
  public abstract Map<Integer, XAwardContent> getType2awardcontent();
  
  public abstract Map<Integer, XAwardContent> getType2awardcontentAsData();
  
  public abstract Map<Integer, XAwardData> getType2awarddata();
  
  public abstract Map<Integer, XAwardData> getType2awarddataAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\XAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */