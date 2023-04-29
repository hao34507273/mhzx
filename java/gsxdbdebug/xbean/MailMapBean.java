package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface MailMapBean
  extends Bean
{
  public abstract MailMapBean copy();
  
  public abstract MailMapBean toData();
  
  public abstract MailMapBean toBean();
  
  public abstract MailMapBean toDataIf();
  
  public abstract MailMapBean toBeanIf();
  
  public abstract Map<Integer, MailInfo> getMailinfomap();
  
  public abstract Map<Integer, MailInfo> getMailinfomapAsData();
  
  public abstract int getNextid();
  
  public abstract void setNextid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MailMapBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */