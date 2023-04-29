/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import mzm.gsp.chart.main.ChartObj;
/*    */ import mzm.gsp.chart.main.ObjWithKey;
/*    */ 
/*    */ public class PointRaceChartObj
/*    */   extends ChartObj<Long, PointRaceChartObj>
/*    */   implements ObjWithKey<Long>, Comparable<PointRaceChartObj>
/*    */ {
/*    */   public final long corpsid;
/*    */   public final int zoneid;
/*    */   public final String corpsName;
/*    */   public final int icon;
/*    */   public final int point;
/*    */   public final long updateTime;
/*    */   
/*    */   public PointRaceChartObj(long corpsid, int point, int zoneid, String corpsName, int icon, long updateTime)
/*    */   {
/* 19 */     this.corpsid = corpsid;
/* 20 */     this.point = point;
/* 21 */     this.zoneid = zoneid;
/* 22 */     this.corpsName = corpsName;
/* 23 */     this.icon = icon;
/* 24 */     this.updateTime = updateTime;
/*    */   }
/*    */   
/*    */ 
/*    */   public Long getKey()
/*    */   {
/* 30 */     return Long.valueOf(this.corpsid);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isAvailable()
/*    */   {
/* 36 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isTopThan(PointRaceChartObj rankObj)
/*    */   {
/* 42 */     return compareTo(rankObj) < 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int compareTo(PointRaceChartObj other)
/*    */   {
/* 48 */     if (this.point != other.point)
/*    */     {
/* 50 */       return other.point - this.point;
/*    */     }
/*    */     
/* 53 */     if (this.updateTime != other.updateTime)
/*    */     {
/* 55 */       return (int)(this.updateTime - other.updateTime);
/*    */     }
/*    */     
/* 58 */     return (int)(this.corpsid - other.corpsid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PointRaceChartObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */