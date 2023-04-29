/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.FactionCompetitionTmp;
/*    */ import xtable.Faction_competition_tmp;
/*    */ 
/*    */ 
/*    */ public class PLeaveCompetitionMapReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PLeaveCompetitionMapReq(long roleid)
/*    */   {
/* 20 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     Gang faction = GangInterface.getGangByRoleId(this.roleid, false);
/* 27 */     if (faction == null) {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     FactionCompetitionTmp xFCTmp = Faction_competition_tmp.select(Long.valueOf(faction.getGangId()));
/* 32 */     if (xFCTmp == null) {
/* 33 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 37 */     long world = MapInterface.getRoleWorldInstanceId(this.roleid);
/* 38 */     if (world != xFCTmp.getWorld()) {
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     TeamInfo team = TeamInterface.getTeamInfoByRoleId(this.roleid);
/* 43 */     if ((team != null) && 
/* 44 */       (team.isNormalState(this.roleid)) && 
/* 45 */       (team.getTeamAllMembersNum() > 1)) {
/* 46 */       CompetitionManager.sendNormalResult(this.roleid, 32, new String[0]);
/*    */       
/* 48 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 60 */     CompetitionManager.leaveNoneRealTime(this.roleid, faction.getGangId());
/*    */     
/* 62 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\PLeaveCompetitionMapReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */