/*    */ package mzm.gsp.menpaistar.main;
/*    */ 
/*    */ import mzm.gsp.chart.main.ChartObj;
/*    */ import mzm.gsp.chart.main.ObjWithKey;
/*    */ 
/*    */ public class MenPaiStarChartObj extends ChartObj<Integer, MenPaiStarChartObj> implements ObjWithKey<Integer>
/*    */ {
/*    */   private final long roleid;
/*    */   private final int ocpid;
/*    */   private final int point;
/*    */   private final long updatePointTime;
/*    */   private final String name;
/*    */   
/*    */   public MenPaiStarChartObj(long roleid, int ocpid, int point, long updatePointTime, String name)
/*    */   {
/* 16 */     this.roleid = roleid;
/* 17 */     this.ocpid = ocpid;
/* 18 */     this.point = point;
/* 19 */     this.updatePointTime = updatePointTime;
/* 20 */     this.name = name;
/*    */   }
/*    */   
/*    */   public long getRoleid()
/*    */   {
/* 25 */     return this.roleid;
/*    */   }
/*    */   
/*    */   public int getOcpid()
/*    */   {
/* 30 */     return this.ocpid;
/*    */   }
/*    */   
/*    */   public int getPoint()
/*    */   {
/* 35 */     return this.point;
/*    */   }
/*    */   
/*    */   public long getUpdatePointTime()
/*    */   {
/* 40 */     return this.updatePointTime;
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 45 */     return this.name;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isAvailable()
/*    */   {
/* 51 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isTopThan(MenPaiStarChartObj rankObj)
/*    */   {
/* 57 */     if (rankObj == null)
/*    */     {
/* 59 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 63 */     if (this.point > rankObj.point)
/*    */     {
/* 65 */       return true;
/*    */     }
/* 67 */     if (this.point < rankObj.point)
/*    */     {
/* 69 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 73 */     if (this.updatePointTime < rankObj.updatePointTime)
/*    */     {
/* 75 */       return true;
/*    */     }
/* 77 */     if (this.updatePointTime > rankObj.updatePointTime)
/*    */     {
/* 79 */       return false;
/*    */     }
/*    */     
/* 82 */     return this.roleid < rankObj.roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   public Integer getKey()
/*    */   {
/* 88 */     return Integer.valueOf(this.ocpid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\MenPaiStarChartObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */