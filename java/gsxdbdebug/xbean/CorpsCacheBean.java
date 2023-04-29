package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface CorpsCacheBean
  extends Bean
{
  public abstract CorpsCacheBean copy();
  
  public abstract CorpsCacheBean toData();
  
  public abstract CorpsCacheBean toBean();
  
  public abstract CorpsCacheBean toDataIf();
  
  public abstract CorpsCacheBean toBeanIf();
  
  public abstract Set<Long> getInvitedroleinfo();
  
  public abstract Set<Long> getInvitedroleinfoAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CorpsCacheBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */