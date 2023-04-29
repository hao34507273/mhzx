/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class SendNoticeObserver extends Observer
/*    */ {
/*    */   private final long noticeId;
/*    */   private final long startTimeTag;
/*    */   
/*    */   public SendNoticeObserver(long intervalSeconds, long noticeId, long startTimeTag)
/*    */   {
/* 13 */     super(intervalSeconds);
/* 14 */     this.noticeId = noticeId;
/* 15 */     this.startTimeTag = startTimeTag;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 21 */     new PSendNotice(this.noticeId, this.startTimeTag).execute();
/* 22 */     return false;
/*    */   }
/*    */   
/*    */   private static class PSendNotice extends LogicProcedure
/*    */   {
/*    */     private final long noticeId;
/*    */     private final long startTimeTag;
/*    */     
/*    */     public PSendNotice(long noticeId, long startTimeTag)
/*    */     {
/* 32 */       this.noticeId = noticeId;
/* 33 */       this.startTimeTag = startTimeTag;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 39 */       NoticeManager.onSendNoticeHandler(this.noticeId, this.startTimeTag);
/* 40 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\SendNoticeObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */