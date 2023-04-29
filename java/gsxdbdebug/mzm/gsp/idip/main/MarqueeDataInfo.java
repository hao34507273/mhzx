/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ public class MarqueeDataInfo
/*    */   implements Comparable<MarqueeDataInfo>
/*    */ {
/*    */   private final long beginTime;
/*    */   private final long endTime;
/*    */   private final String mailTitle;
/*    */   private final String mailContent;
/*    */   private final int rollFre;
/*    */   private final int rollNum;
/*    */   private final long indexId;
/*    */   private long marqueeId;
/*    */   
/*    */   public MarqueeDataInfo(long beginTime, long endTime, String mailTitle, String mailContent, int rollFre, int rollNum, long indexId)
/*    */   {
/* 17 */     this.beginTime = beginTime;
/* 18 */     this.endTime = endTime;
/* 19 */     this.mailTitle = mailTitle;
/* 20 */     this.mailContent = mailContent;
/* 21 */     this.rollFre = rollFre;
/* 22 */     this.rollNum = rollNum;
/* 23 */     this.indexId = indexId;
/*    */   }
/*    */   
/*    */   public long getMarqueeId()
/*    */   {
/* 28 */     return this.marqueeId;
/*    */   }
/*    */   
/*    */   public void setMarqueeId(long marqueeId)
/*    */   {
/* 33 */     this.marqueeId = marqueeId;
/*    */   }
/*    */   
/*    */   public long getBeginTime()
/*    */   {
/* 38 */     return this.beginTime;
/*    */   }
/*    */   
/*    */   public long getEndTime()
/*    */   {
/* 43 */     return this.endTime;
/*    */   }
/*    */   
/*    */   public String getMailTitle()
/*    */   {
/* 48 */     return this.mailTitle;
/*    */   }
/*    */   
/*    */   public String getMailContent()
/*    */   {
/* 53 */     return this.mailContent;
/*    */   }
/*    */   
/*    */   public int getRollFre()
/*    */   {
/* 58 */     return this.rollFre;
/*    */   }
/*    */   
/*    */   public int getRollNum()
/*    */   {
/* 63 */     return this.rollNum;
/*    */   }
/*    */   
/*    */   public long getIndexId()
/*    */   {
/* 68 */     return this.indexId;
/*    */   }
/*    */   
/*    */ 
/*    */   public int compareTo(MarqueeDataInfo o)
/*    */   {
/* 74 */     if (o == null)
/*    */     {
/* 76 */       return -1;
/*    */     }
/* 78 */     return (int)(this.beginTime - o.beginTime);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\MarqueeDataInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */