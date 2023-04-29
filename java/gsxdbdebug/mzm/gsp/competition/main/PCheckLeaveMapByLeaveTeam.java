/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.FactionCompetitionTmp;
/*    */ import xbean.RoleCompetition;
/*    */ import xtable.Basic;
/*    */ import xtable.Faction_competition_tmp;
/*    */ import xtable.Role_competition;
/*    */ import xtable.User;
/*    */ 
/*    */ class PCheckLeaveMapByLeaveTeam extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   PCheckLeaveMapByLeaveTeam(long roleid)
/*    */   {
/* 23 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     String userid = RoleInterface.getUserId(this.roleid);
/* 30 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/*    */ 
/* 33 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*    */     
/*    */ 
/* 36 */     Gang faction = GangInterface.getGangByRoleId(this.roleid, true);
/* 37 */     if (faction == null) {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     FactionCompetitionTmp xFCTmp = Faction_competition_tmp.get(Long.valueOf(faction.getGangId()));
/* 42 */     if (xFCTmp == null) {
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     long world = MapInterface.getRoleWorldInstanceId(this.roleid);
/* 47 */     if (world != xFCTmp.getWorld()) {
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     RoleCompetition xRoleCompetition = Role_competition.get(Long.valueOf(this.roleid));
/* 52 */     if (xRoleCompetition == null) {
/* 53 */       return false;
/*    */     }
/*    */     
/* 56 */     if (!OnlineManager.getInstance().isOnline(this.roleid))
/*    */     {
/* 58 */       CompetitionManager.leave(userid, this.roleid, faction, xFCTmp);
/*    */     }
/* 60 */     if (xRoleCompetition.getAction_point() <= 0)
/*    */     {
/* 62 */       CompetitionManager.leave(userid, this.roleid, faction, xFCTmp);
/* 63 */       CompetitionManager.sendNormalResult(this.roleid, 31, new String[0]);
/*    */     }
/* 65 */     else if (xRoleCompetition.getAwarded_final())
/*    */     {
/* 67 */       CompetitionManager.leave(userid, this.roleid, faction, xFCTmp);
/*    */     }
/*    */     
/* 70 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\PCheckLeaveMapByLeaveTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */