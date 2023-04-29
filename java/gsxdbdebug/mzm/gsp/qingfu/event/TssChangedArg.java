/*    */ package mzm.gsp.qingfu.event;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ 
/*    */ public class TssChangedArg
/*    */ {
/*    */   public final String userid;
/*    */   
/*    */   public static class TssChangedInfo
/*    */   {
/*    */     public final long oldTotalOpenDays;
/*    */     public final long curTotalOpenDays;
/*    */     public final long beginTime;
/*    */     public final long endTime;
/*    */     
/*    */     public TssChangedInfo(long oldTotalOpenDays, long curTotalOpenDays, long beginTime, long endTime) {
/* 17 */       this.oldTotalOpenDays = oldTotalOpenDays;
/* 18 */       this.curTotalOpenDays = curTotalOpenDays;
/* 19 */       this.beginTime = beginTime;
/* 20 */       this.endTime = endTime;
/*    */     }
/*    */     
/*    */ 
/*    */     public String toString()
/*    */     {
/* 26 */       StringBuilder sb = new StringBuilder();
/* 27 */       sb.append("TssChangedArg.TssChangedInfo(");
/* 28 */       sb.append("old_total_open_days=").append(this.oldTotalOpenDays);
/* 29 */       sb.append("|cur_total_open_days=").append(this.curTotalOpenDays);
/* 30 */       sb.append("|begin_time=").append(this.beginTime);
/* 31 */       sb.append("|end_time=").append(this.endTime);
/* 32 */       sb.append(")");
/* 33 */       return sb.toString();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/* 39 */   public final java.util.Map<String, TssChangedInfo> changedInfos = new HashMap();
/*    */   
/*    */   public TssChangedArg(String userid)
/*    */   {
/* 43 */     this.userid = userid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\event\TssChangedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */