/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ 
/*    */ public class NoticeDataInfo
/*    */   implements Comparable<NoticeDataInfo>
/*    */ {
/*    */   public long noticeId;
/*    */   
/*    */   public int noticeType;
/*    */   
/*    */   public int displayType;
/*    */   
/*    */   public int hrefType;
/*    */   public String hrefText;
/*    */   public String hrefUrl;
/*    */   public int sendType;
/*    */   public String noticeTitle;
/*    */   public String noticeContent;
/*    */   public String pictureUrl;
/*    */   public long startTime;
/*    */   public long endTime;
/*    */   public int minOpenServerDays;
/*    */   public int maxOpenServerDays;
/*    */   public int minCreateRoleDays;
/*    */   public int maxCreateRoleDays;
/*    */   public int minRoleLevel;
/*    */   public int maxRoleLevel;
/*    */   public long minSaveAmt;
/*    */   public long maxSaveAmt;
/*    */   public int noticeTag;
/*    */   public boolean badge;
/*    */   public int noticeSortID;
/*    */   public int partition;
/*    */   
/*    */   public int compareTo(NoticeDataInfo o)
/*    */   {
/* 37 */     if (o == null)
/*    */     {
/* 39 */       return -1;
/*    */     }
/* 41 */     return (int)(this.startTime - o.startTime);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\NoticeDataInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */