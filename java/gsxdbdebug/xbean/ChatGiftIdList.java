package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface ChatGiftIdList
  extends Bean
{
  public abstract ChatGiftIdList copy();
  
  public abstract ChatGiftIdList toData();
  
  public abstract ChatGiftIdList toBean();
  
  public abstract ChatGiftIdList toDataIf();
  
  public abstract ChatGiftIdList toBeanIf();
  
  public abstract List<Long> getChatgiftlist();
  
  public abstract List<Long> getChatgiftlistAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChatGiftIdList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */