/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ public class QueryNoticeInfo
/*    */ {
/*    */   private final long startTime;
/*    */   private final long endTime;
/*    */   
/*    */   public QueryNoticeInfo(long startTime, long endTime)
/*    */   {
/* 10 */     this.startTime = startTime;
/* 11 */     this.endTime = endTime;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 18 */     int hashCode = (int)(this.startTime ^ this.startTime >>> 32);
/* 19 */     hashCode = hashCode * 31 + (int)(this.endTime ^ this.endTime >>> 32);
/* 20 */     return hashCode;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 26 */     if (obj == this)
/*    */     {
/* 28 */       return true;
/*    */     }
/*    */     
/* 31 */     if (!(obj instanceof QueryNoticeInfo))
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     QueryNoticeInfo temp = (QueryNoticeInfo)obj;
/* 37 */     if ((this.startTime == temp.startTime) && (this.endTime == temp.endTime))
/*    */     {
/* 39 */       return true;
/*    */     }
/*    */     
/* 42 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\QueryNoticeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */