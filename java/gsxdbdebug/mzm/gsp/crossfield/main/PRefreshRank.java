/*    */ package mzm.gsp.crossfield.main;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoleSingleCrossFieldSeasonInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PRefreshRank
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   PRefreshRank(long roleid)
/*    */   {
/* 17 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     int currentSeason = CrossFieldManager.getCurrentSeason(DateTimeUtils.getCurrTimeInMillis());
/* 24 */     if (currentSeason <= 0)
/*    */     {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     RoleSingleCrossFieldSeasonInfo xRoleSingleCrossFieldSeasonInfo = CrossFieldManager.getXRoleSingleCrossFieldSeasonInfo(this.roleid, currentSeason, true);
/*    */     
/* 31 */     if (xRoleSingleCrossFieldSeasonInfo == null)
/*    */     {
/* 33 */       return false;
/*    */     }
/* 35 */     SingleCrossFieldChartManager.getInstance().rank(this.roleid, currentSeason);
/* 36 */     CrossFieldManager.reportRoleSingleCrossFieldRankInfo(currentSeason, this.roleid, RoleInterface.getName(this.roleid), RoleInterface.getOccupationId(this.roleid), xRoleSingleCrossFieldSeasonInfo.getStar_num(), xRoleSingleCrossFieldSeasonInfo.getStar_num_timestamp());
/*    */     
/*    */ 
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\PRefreshRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */