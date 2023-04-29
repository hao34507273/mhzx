package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface QuestionVoiceInfo
  extends Bean
{
  public abstract QuestionVoiceInfo copy();
  
  public abstract QuestionVoiceInfo toData();
  
  public abstract QuestionVoiceInfo toBean();
  
  public abstract QuestionVoiceInfo toDataIf();
  
  public abstract QuestionVoiceInfo toBeanIf();
  
  public abstract Map<Integer, QuestionVoiceBean> getActivity2question_voice();
  
  public abstract Map<Integer, QuestionVoiceBean> getActivity2question_voiceAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\QuestionVoiceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */