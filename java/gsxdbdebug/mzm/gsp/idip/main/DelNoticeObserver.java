/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ 
/*    */ public class DelNoticeObserver extends Observer
/*    */ {
/*    */   private final long noticeId;
/*    */   private final long endTimeTag;
/*    */   
/*    */   public DelNoticeObserver(long intervalSeconds, long noticeId, long endTimeTag)
/*    */   {
/* 12 */     super(intervalSeconds);
/* 13 */     this.noticeId = noticeId;
/* 14 */     this.endTimeTag = endTimeTag;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 21 */     NoticeManager.delNotice(this.noticeId, this.endTimeTag);
/* 22 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\DelNoticeObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */