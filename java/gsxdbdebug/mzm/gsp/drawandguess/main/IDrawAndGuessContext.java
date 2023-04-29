package mzm.gsp.drawandguess.main;

import java.util.List;
import java.util.Map;
import mzm.gsp.drawandguess.AnswerInfo;
import mzm.gsp.drawandguess.DrawLineInfo;

public abstract interface IDrawAndGuessContext
{
  public abstract int getQuestionCfgid();
  
  public abstract boolean draw(DrawLineInfo paramDrawLineInfo);
  
  public abstract void clear();
  
  public abstract void answer(AnswerInfo paramAnswerInfo);
  
  public abstract Map<Long, Integer> getJifenInfo();
  
  public abstract void addJifen(long paramLong, List<Long> paramList);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\main\IDrawAndGuessContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */