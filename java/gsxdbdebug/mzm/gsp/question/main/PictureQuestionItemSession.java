/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.PictureInfo;
/*    */ import xtable.Picturequestion;
/*    */ 
/*    */ 
/*    */ public class PictureQuestionItemSession
/*    */   extends Session
/*    */ {
/* 15 */   private int nowQuestionIdx = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private int endTime;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public PictureQuestionItemSession(long interval, long roleId, int nowQuestionIdx)
/*    */   {
/* 27 */     super(interval, roleId);
/* 28 */     this.nowQuestionIdx = nowQuestionIdx;
/* 29 */     this.endTime = ((int)(TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis()) + interval));
/*    */   }
/*    */   
/*    */   public int getEndTime()
/*    */   {
/* 34 */     return this.endTime;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 40 */     new PictureQuestionItemTimeOutPro(this.nowQuestionIdx, getOwerId()).execute();
/*    */   }
/*    */   
/*    */   private static class PictureQuestionItemTimeOutPro extends LogicProcedure
/*    */   {
/*    */     private final int nowQuestionIdx;
/*    */     private final long picInfoId;
/*    */     
/*    */     PictureQuestionItemTimeOutPro(int nowQuestionIdx, long picInfoId)
/*    */     {
/* 50 */       this.nowQuestionIdx = nowQuestionIdx;
/* 51 */       this.picInfoId = picInfoId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 57 */       PictureInfo xPictureInfo = Picturequestion.get(Long.valueOf(this.picInfoId));
/* 58 */       if (xPictureInfo == null)
/*    */       {
/* 60 */         String logStr = String.format("PictureQuestionItemTimeOutPro.processImp@xPictureInfo is null|picInfoId=%d", new Object[] { Long.valueOf(this.picInfoId) });
/*    */         
/* 62 */         PictureQuestionManager.logger.warn(logStr);
/* 63 */         return false;
/*    */       }
/* 65 */       if (xPictureInfo.getState() != 2)
/*    */       {
/* 67 */         return false;
/*    */       }
/*    */       
/* 70 */       if (xPictureInfo.getQuestionidx() != this.nowQuestionIdx)
/*    */       {
/* 72 */         return true;
/*    */       }
/*    */       
/*    */ 
/* 76 */       xPictureInfo.setQuestionidx(xPictureInfo.getQuestionidx() + 1);
/*    */       
/* 78 */       PictureQuestionManager.getInstance().moveToCurrentQuestion(this.picInfoId, xPictureInfo, false, -1);
/* 79 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PictureQuestionItemSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */