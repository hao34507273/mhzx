/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.PictureInfo;
/*    */ import xtable.Picturequestion;
/*    */ import xtable.Role2picturequestion;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PictureQuestionStartSession
/*    */   extends Session
/*    */ {
/*    */   public PictureQuestionStartSession(long interval, long questionid)
/*    */   {
/* 24 */     super(interval, questionid);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 30 */     new PicQuesStartSessionTimeOutPro(getOwerId()).execute();
/*    */   }
/*    */   
/*    */   private static class PicQuesStartSessionTimeOutPro extends LogicProcedure {
/*    */     private final long questionid;
/*    */     
/* 36 */     PicQuesStartSessionTimeOutPro(long questionid) { this.questionid = questionid; }
/*    */     
/*    */ 
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 42 */       PictureInfo xPictureInfo = Picturequestion.get(Long.valueOf(this.questionid));
/* 43 */       if (xPictureInfo == null)
/*    */       {
/* 45 */         String logStr = String.format("[picquestion]PicQuesStartSessionTimeOutPro.processImp@xPictureInfo null|questionid=%d", new Object[] { Long.valueOf(this.questionid) });
/*    */         
/*    */ 
/*    */ 
/* 49 */         PictureQuestionManager.logger.error(logStr);
/*    */         
/* 51 */         return false;
/*    */       }
/* 53 */       if (xPictureInfo.getState() != 1)
/*    */       {
/* 55 */         String logStr = String.format("[picquestion]PicQuesStartSessionTimeOutPro.processImp@state error,not ready state|questionid=%d|state=%d", new Object[] { Long.valueOf(this.questionid), Integer.valueOf(xPictureInfo.getState()) });
/*    */         
/*    */ 
/*    */ 
/* 59 */         PictureQuestionManager.logger.error(logStr);
/*    */         
/* 61 */         return false;
/*    */       }
/* 63 */       xPictureInfo.setState(2);
/* 64 */       List<Long> roleList = xPictureInfo.getRoleidlist();
/*    */       
/* 66 */       new PictureQuestionStartSession.NotifyCurrentQuestionPro(this.questionid, roleList).execute();
/* 67 */       return true;
/*    */     }
/*    */   }
/*    */   
/*    */   private static class NotifyCurrentQuestionPro extends LogicProcedure {
/*    */     private final long questionid;
/*    */     private final List<Long> roleList;
/*    */     
/*    */     public NotifyCurrentQuestionPro(long questionid, List<Long> roleList) {
/* 76 */       this.questionid = questionid;
/* 77 */       this.roleList = roleList;
/*    */     }
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 82 */       lock(Role2picturequestion.getTable(), this.roleList);
/* 83 */       PictureInfo xPictureInfo = Picturequestion.get(Long.valueOf(this.questionid));
/* 84 */       PictureQuestionManager.getInstance().notifyCurrentQuestion(this.questionid, xPictureInfo);
/*    */       
/* 86 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PictureQuestionStartSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */