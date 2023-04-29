/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class NoticeInterface
/*    */ {
/*    */   public static boolean contains(long noticeid)
/*    */   {
/*  9 */     return NoticeManager.containsNotice(noticeid);
/*    */   }
/*    */   
/*    */   public static long getMinDuration()
/*    */   {
/* 14 */     return NoticeManager.DURATION_MILLI_SECONDS;
/*    */   }
/*    */   
/*    */   public static boolean addNotice(NoticeDataInfo notice)
/*    */   {
/* 19 */     return NoticeManager.addNotice(notice);
/*    */   }
/*    */   
/*    */   public static boolean update(long noticeid, NoticeDataInfo newNotice)
/*    */   {
/* 24 */     return NoticeManager.updateNoitce(noticeid, newNotice);
/*    */   }
/*    */   
/*    */   public static void del(long noticeid)
/*    */   {
/* 29 */     NoticeManager.forceDelNotice(noticeid);
/*    */   }
/*    */   
/*    */   public static List<NoticeDataInfo> query(long startTime, long endTime, int page)
/*    */   {
/* 34 */     return NoticeManager.queryNotices(startTime, endTime, page);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\NoticeInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */