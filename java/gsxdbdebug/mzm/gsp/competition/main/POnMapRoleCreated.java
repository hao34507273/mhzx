/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.map.event.MapRoleCreatedArg;
/*    */ import mzm.gsp.map.event.MapRoleCreatedProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.FactionCompetitionTmp;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnMapRoleCreated
/*    */   extends MapRoleCreatedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     String userid = RoleInterface.getUserId(((MapRoleCreatedArg)this.arg).roleid);
/*    */     
/*    */ 
/* 21 */     Gang faction = GangInterface.getGangByRoleId(((MapRoleCreatedArg)this.arg).roleid, true);
/*    */     
/* 23 */     if (CompetitionConfigManager.getInstance().isActivityMap(((MapRoleCreatedArg)this.arg).mapid))
/*    */     {
/* 25 */       FactionCompetitionTmp xFCTmp = null;
/* 26 */       if (faction != null) {
/* 27 */         xFCTmp = CompetitionManager.getXFactionCompetitionTmpIfNotExist(faction.getGangId());
/*    */       }
/*    */       
/* 30 */       CompetitionManager.leave(userid, ((MapRoleCreatedArg)this.arg).roleid, faction, xFCTmp);
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 35 */       CompetitionManager.clearActivityStatus(((MapRoleCreatedArg)this.arg).roleid);
/*    */     }
/*    */     
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\POnMapRoleCreated.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */