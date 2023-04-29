/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.FactionCompetitionTmp;
/*    */ import xtable.Basic;
/*    */ import xtable.Faction_competition_tmp;
/*    */ import xtable.User;
/*    */ 
/*    */ class PLeave
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long gangid;
/*    */   
/*    */   PLeave(long roleid, long gangid)
/*    */   {
/* 21 */     this.roleid = roleid;
/* 22 */     this.gangid = gangid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 27 */     String userid = RoleInterface.getUserId(this.roleid);
/*    */     
/* 29 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/* 31 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*    */     
/* 33 */     Gang faction = GangInterface.getGang(this.gangid, true);
/* 34 */     FactionCompetitionTmp xFCTmp = Faction_competition_tmp.get(Long.valueOf(this.gangid));
/*    */     
/* 36 */     CompetitionManager.leave(userid, this.roleid, faction, xFCTmp);
/*    */     
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\PLeave.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */