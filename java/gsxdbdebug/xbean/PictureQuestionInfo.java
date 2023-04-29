package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface PictureQuestionInfo
  extends Bean
{
  public static final int SELECTED_RESOURCE_TYPE = 0;
  
  public abstract PictureQuestionInfo copy();
  
  public abstract PictureQuestionInfo toData();
  
  public abstract PictureQuestionInfo toBean();
  
  public abstract PictureQuestionInfo toDataIf();
  
  public abstract PictureQuestionInfo toBeanIf();
  
  public abstract int getQuestionid();
  
  public abstract long getAnswerroleid();
  
  public abstract List<Integer> getWronganswerlist();
  
  public abstract List<Integer> getWronganswerlistAsData();
  
  public abstract int getRightanswer();
  
  public abstract Map<Integer, Integer> getParammap();
  
  public abstract Map<Integer, Integer> getParammapAsData();
  
  public abstract void setQuestionid(int paramInt);
  
  public abstract void setAnswerroleid(long paramLong);
  
  public abstract void setRightanswer(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PictureQuestionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */