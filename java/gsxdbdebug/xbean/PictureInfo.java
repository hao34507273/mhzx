package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface PictureInfo
  extends Bean
{
  public static final int STATE_PREPARE = 0;
  public static final int STATE_READY = 1;
  public static final int STATE_ANSWER = 2;
  
  public abstract PictureInfo copy();
  
  public abstract PictureInfo toData();
  
  public abstract PictureInfo toBean();
  
  public abstract PictureInfo toDataIf();
  
  public abstract PictureInfo toBeanIf();
  
  public abstract int getState();
  
  public abstract long getSessionid();
  
  public abstract List<Long> getRoleidlist();
  
  public abstract List<Long> getRoleidlistAsData();
  
  public abstract int getQuestionlevelcfgid();
  
  public abstract int getQuestionidx();
  
  public abstract List<PictureQuestionInfo> getQuestionlist();
  
  public abstract List<PictureQuestionInfo> getQuestionlistAsData();
  
  public abstract int getRightanswercount();
  
  public abstract Object getAttachobject();
  
  public abstract void setState(int paramInt);
  
  public abstract void setSessionid(long paramLong);
  
  public abstract void setQuestionlevelcfgid(int paramInt);
  
  public abstract void setQuestionidx(int paramInt);
  
  public abstract void setRightanswercount(int paramInt);
  
  public abstract void setAttachobject(Object paramObject);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PictureInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */