/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.map.event.MapRoleDestroyedArg;
/*    */ import mzm.gsp.map.event.MapRoleDestroyedEventProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.FactionCompetitionTmp;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Faction_competition_tmp;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnMapRoleDestroyed
/*    */   extends MapRoleDestroyedEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     long roleid = ((MapRoleDestroyedArg)this.arg).roleid;
/*    */     
/*    */ 
/* 22 */     String userid = RoleInterface.getUserId(roleid);
/* 23 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/*    */ 
/* 26 */     Gang faction = GangInterface.getGangByRoleId(roleid, true);
/* 27 */     if (faction == null) {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     FactionCompetitionTmp xFCTmp = Faction_competition_tmp.get(Long.valueOf(faction.getGangId()));
/* 32 */     if (xFCTmp == null) {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     if (((MapRoleDestroyedArg)this.arg).worldid != xFCTmp.getWorld()) {
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     if (TeamInterface.isRoleInTeam(roleid, true))
/*    */     {
/* 42 */       TeamInterface.leaveTeamNoneRealTime(roleid);
/*    */     }
/*    */     else
/*    */     {
/* 46 */       CompetitionManager.leave(userid, roleid, faction, xFCTmp);
/*    */     }
/*    */     
/* 49 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\POnMapRoleDestroyed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */