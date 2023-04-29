package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface WordQuestionInfo
  extends Bean
{
  public abstract WordQuestionInfo copy();
  
  public abstract WordQuestionInfo toData();
  
  public abstract WordQuestionInfo toBean();
  
  public abstract WordQuestionInfo toDataIf();
  
  public abstract WordQuestionInfo toBeanIf();
  
  public abstract Map<Long, RoleWordQuestionInfo> getRolequestionmap();
  
  public abstract Map<Long, RoleWordQuestionInfo> getRolequestionmapAsData();
  
  public abstract int getLevelcfgid();
  
  public abstract Object getAttachobject();
  
  public abstract void setLevelcfgid(int paramInt);
  
  public abstract void setAttachobject(Object paramObject);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\WordQuestionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */