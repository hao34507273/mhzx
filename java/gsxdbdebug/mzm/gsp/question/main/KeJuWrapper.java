/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.KeJuInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class KeJuWrapper
/*    */ {
/*    */   private KeJuInfo xKeJuInfo;
/*    */   
/*    */   public KeJuWrapper(KeJuInfo xKeJuInfo)
/*    */   {
/* 14 */     this.xKeJuInfo = xKeJuInfo;
/*    */   }
/*    */   
/*    */   public int getAnswerNum()
/*    */   {
/* 19 */     return this.xKeJuInfo.getAnswernum();
/*    */   }
/*    */   
/*    */ 
/*    */   public int getRightNum()
/*    */   {
/* 25 */     return this.xKeJuInfo.getRightnum();
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPunishTime()
/*    */   {
/* 31 */     return this.xKeJuInfo.getPunishtime();
/*    */   }
/*    */   
/*    */   public void addPunishTime(int punishTime)
/*    */   {
/* 36 */     this.xKeJuInfo.setPunishtime(this.xKeJuInfo.getPunishtime() + punishTime);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public long getQuestionBeginTime()
/*    */   {
/* 43 */     return this.xKeJuInfo.getStarttime();
/*    */   }
/*    */   
/*    */   public int getQuestionid()
/*    */   {
/* 48 */     if (this.xKeJuInfo.getQuestionlist().isEmpty())
/* 49 */       return -1;
/* 50 */     return ((Integer)this.xKeJuInfo.getQuestionlist().get(0)).intValue();
/*    */   }
/*    */   
/*    */   public int moveNextQuestion()
/*    */   {
/* 55 */     this.xKeJuInfo.getQuestionlist().remove(0);
/* 56 */     return getQuestionid();
/*    */   }
/*    */   
/*    */   public void addRightAnswer()
/*    */   {
/* 61 */     this.xKeJuInfo.setRightnum(this.xKeJuInfo.getRightnum() + 1);
/* 62 */     addAnswer();
/*    */   }
/*    */   
/*    */   public void addAnswer()
/*    */   {
/* 67 */     this.xKeJuInfo.setAnswernum(this.xKeJuInfo.getAnswernum() + 1);
/*    */   }
/*    */   
/*    */   public boolean isFinish()
/*    */   {
/* 72 */     return this.xKeJuInfo.getQuestionlist().isEmpty();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\KeJuWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */