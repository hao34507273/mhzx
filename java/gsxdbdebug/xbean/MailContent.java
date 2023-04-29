package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface MailContent
  extends Bean
{
  public abstract MailContent copy();
  
  public abstract MailContent toData();
  
  public abstract MailContent toBean();
  
  public abstract MailContent toDataIf();
  
  public abstract MailContent toBeanIf();
  
  public abstract int getMailcontenttype();
  
  public abstract Map<Integer, String> getContentmap();
  
  public abstract Map<Integer, String> getContentmapAsData();
  
  public abstract Map<Integer, FormatArgs> getFormatargsmap();
  
  public abstract Map<Integer, FormatArgs> getFormatargsmapAsData();
  
  public abstract void setMailcontenttype(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MailContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */