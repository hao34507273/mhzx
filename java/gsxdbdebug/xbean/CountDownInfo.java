package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface CountDownInfo
  extends Bean
{
  public abstract CountDownInfo copy();
  
  public abstract CountDownInfo toData();
  
  public abstract CountDownInfo toBean();
  
  public abstract CountDownInfo toDataIf();
  
  public abstract CountDownInfo toBeanIf();
  
  public abstract Set<Integer> getRemind_mails();
  
  public abstract Set<Integer> getRemind_mailsAsData();
  
  public abstract Set<Integer> getThank_mails();
  
  public abstract Set<Integer> getThank_mailsAsData();
  
  public abstract boolean getGet_red_packet();
  
  public abstract boolean getCan_get_red_packet();
  
  public abstract void setGet_red_packet(boolean paramBoolean);
  
  public abstract void setCan_get_red_packet(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CountDownInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */