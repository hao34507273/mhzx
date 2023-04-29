/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ public class QueryMarqueeInfo
/*    */ {
/*    */   private final long startTime;
/*    */   private final long endTime;
/*    */   
/*    */   public QueryMarqueeInfo(long startTime, long endTime)
/*    */   {
/* 10 */     this.startTime = startTime;
/* 11 */     this.endTime = endTime;
/*    */   }
/*    */   
/*    */   public long getStartTime()
/*    */   {
/* 16 */     return this.startTime;
/*    */   }
/*    */   
/*    */   public long getEndTime()
/*    */   {
/* 21 */     return this.endTime;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 28 */     int hashCode = (int)(this.startTime ^ this.startTime >>> 32);
/* 29 */     hashCode = hashCode * 31 + (int)(this.endTime ^ this.endTime >>> 32);
/* 30 */     return hashCode;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 36 */     if (obj == this)
/*    */     {
/* 38 */       return true;
/*    */     }
/*    */     
/* 41 */     if (!(obj instanceof QueryMarqueeInfo))
/*    */     {
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     QueryMarqueeInfo temp = (QueryMarqueeInfo)obj;
/* 47 */     if ((this.startTime == temp.startTime) && (this.endTime == temp.endTime))
/*    */     {
/* 49 */       return true;
/*    */     }
/*    */     
/* 52 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\QueryMarqueeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */