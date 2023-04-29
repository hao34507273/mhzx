package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface ChatGiftTimeList
  extends Bean
{
  public abstract ChatGiftTimeList copy();
  
  public abstract ChatGiftTimeList toData();
  
  public abstract ChatGiftTimeList toBean();
  
  public abstract ChatGiftTimeList toDataIf();
  
  public abstract ChatGiftTimeList toBeanIf();
  
  public abstract List<Long> getChatgifttimelist();
  
  public abstract List<Long> getChatgifttimelistAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChatGiftTimeList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */