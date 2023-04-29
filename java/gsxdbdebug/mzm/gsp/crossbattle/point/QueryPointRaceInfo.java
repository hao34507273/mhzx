/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ public class QueryPointRaceInfo
/*    */ {
/*    */   private final int activityCfgid;
/*    */   private final int zone;
/*    */   private final int timePointCfgid;
/*    */   
/*    */   public QueryPointRaceInfo(int activityCfgid, int zone, int timePointCfgid)
/*    */   {
/* 11 */     this.activityCfgid = activityCfgid;
/* 12 */     this.zone = zone;
/* 13 */     this.timePointCfgid = timePointCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 19 */     int hashCode = 1;
/* 20 */     hashCode = 31 * hashCode + this.activityCfgid;
/* 21 */     hashCode = 31 * hashCode + this.zone;
/* 22 */     hashCode = 31 * hashCode + this.timePointCfgid;
/* 23 */     return hashCode;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 29 */     if (obj.getClass() != getClass())
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     QueryPointRaceInfo tmp = (QueryPointRaceInfo)obj;
/* 34 */     if (tmp.activityCfgid != this.activityCfgid)
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     if (tmp.zone != this.zone)
/*    */     {
/* 40 */       return false;
/*    */     }
/* 42 */     if (tmp.timePointCfgid != this.timePointCfgid)
/*    */     {
/* 44 */       return false;
/*    */     }
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\QueryPointRaceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */