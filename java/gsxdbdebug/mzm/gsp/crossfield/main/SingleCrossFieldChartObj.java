/*    */ package mzm.gsp.crossfield.main;
/*    */ 
/*    */ import mzm.gsp.chart.main.RoleKeyChartObj;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SingleCrossFieldChartObj
/*    */   extends RoleKeyChartObj<SingleCrossFieldChartObj>
/*    */ {
/*    */   private final long roleid;
/*    */   private final int starNum;
/*    */   private final long timestamp;
/*    */   
/*    */   public SingleCrossFieldChartObj(long roleid, int starNum, long timestamp)
/*    */   {
/* 17 */     this.roleid = roleid;
/* 18 */     this.starNum = starNum;
/* 19 */     this.timestamp = timestamp;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isAvailable()
/*    */   {
/* 25 */     if (this.starNum < 0)
/*    */     {
/* 27 */       return false;
/*    */     }
/* 29 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isTopThan(SingleCrossFieldChartObj rankObj)
/*    */   {
/* 35 */     if (this.starNum != rankObj.getStarNum())
/*    */     {
/* 37 */       return this.starNum > rankObj.getStarNum();
/*    */     }
/* 39 */     if ((this.timestamp != 0L) && (rankObj.getTimestamp() != 0L) && (this.timestamp != rankObj.getTimestamp()))
/*    */     {
/* 41 */       return this.timestamp < rankObj.getTimestamp();
/*    */     }
/* 43 */     if ((this.timestamp == 0L) && (rankObj.getTimestamp() != 0L))
/*    */     {
/* 45 */       return false;
/*    */     }
/* 47 */     if ((this.timestamp != 0L) && (rankObj.getTimestamp() == 0L))
/*    */     {
/* 49 */       return true;
/*    */     }
/* 51 */     return getRoleid() < rankObj.getRoleid();
/*    */   }
/*    */   
/*    */ 
/*    */   public Long getKey()
/*    */   {
/* 57 */     return Long.valueOf(this.roleid);
/*    */   }
/*    */   
/*    */   public int getStarNum()
/*    */   {
/* 62 */     return this.starNum;
/*    */   }
/*    */   
/*    */   public long getTimestamp()
/*    */   {
/* 67 */     return this.timestamp;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\SingleCrossFieldChartObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */