package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface QuestionVoiceBean
  extends Bean
{
  public abstract QuestionVoiceBean copy();
  
  public abstract QuestionVoiceBean toData();
  
  public abstract QuestionVoiceBean toBean();
  
  public abstract QuestionVoiceBean toDataIf();
  
  public abstract QuestionVoiceBean toBeanIf();
  
  public abstract int getNow_question_id();
  
  public abstract List<Integer> getNow_optional_order();
  
  public abstract List<Integer> getNow_optional_orderAsData();
  
  public abstract int getLast_question_id();
  
  public abstract void setNow_question_id(int paramInt);
  
  public abstract void setLast_question_id(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\QuestionVoiceBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */