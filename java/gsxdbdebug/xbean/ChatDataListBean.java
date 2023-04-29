package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ChatDataListBean
  extends Bean
{
  public static final int FRIEND = 0;
  public static final int STRANGER = 1;
  
  public abstract ChatDataListBean copy();
  
  public abstract ChatDataListBean toData();
  
  public abstract ChatDataListBean toBean();
  
  public abstract ChatDataListBean toDataIf();
  
  public abstract ChatDataListBean toBeanIf();
  
  public abstract Map<Integer, ChatDataInfo> getChatdatamap();
  
  public abstract Map<Integer, ChatDataInfo> getChatdatamapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChatDataListBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */