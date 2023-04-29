/*    */ package mzm.gsp.auction.main;
/*    */ 
/*    */ import java.text.SimpleDateFormat;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ActivityPeriod
/*    */ {
/*    */   public int timeIdIndex;
/*    */   public long startTimeStamp;
/*    */   public long endTimeStamp;
/*    */   
/*    */   public String toString()
/*    */   {
/* 16 */     SimpleDateFormat simpleDateFormat = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 17 */     return "ActivityPeriod{timeIdIndex=" + this.timeIdIndex + ", startTimeStamp=" + simpleDateFormat.format(Long.valueOf(this.startTimeStamp)) + ", endTimeStamp=" + simpleDateFormat.format(Long.valueOf(this.endTimeStamp)) + '}';
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\main\ActivityPeriod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */