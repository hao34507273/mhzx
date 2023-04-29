package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface ChatDataInfo
  extends Bean
{
  public abstract ChatDataInfo copy();
  
  public abstract ChatDataInfo toData();
  
  public abstract ChatDataInfo toBean();
  
  public abstract ChatDataInfo toDataIf();
  
  public abstract ChatDataInfo toBeanIf();
  
  public abstract List<ChatDataBean> getChatdatalist();
  
  public abstract List<ChatDataBean> getChatdatalistAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChatDataInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */