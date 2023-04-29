package xbean;

import com.goldhuman.Common.Marshal.Marshal;
import xdb.Bean;

public abstract interface ChatDataBean
  extends Bean
{
  public abstract ChatDataBean copy();
  
  public abstract ChatDataBean toData();
  
  public abstract ChatDataBean toBean();
  
  public abstract ChatDataBean toDataIf();
  
  public abstract ChatDataBean toBeanIf();
  
  public abstract <T extends Marshal> T getChatdata(T paramT);
  
  public abstract boolean isChatdataEmpty();
  
  public abstract byte[] getChatdataCopy();
  
  public abstract void setChatdata(Marshal paramMarshal);
  
  public abstract void setChatdataCopy(byte[] paramArrayOfByte);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChatDataBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */