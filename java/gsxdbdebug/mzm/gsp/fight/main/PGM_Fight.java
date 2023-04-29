/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ 
/*    */ public class PGM_Fight extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private int fightcfgid;
/*    */   private long roleid;
/*    */   
/*    */   public PGM_Fight(int fightcfgid, long roleid)
/*    */   {
/* 12 */     this.fightcfgid = fightcfgid;
/* 13 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     if (TeamInterface.isRoleInTeam(this.roleid, false)) {
/* 20 */       long leaderid = TeamInterface.getTeamLeaderByRoleid(this.roleid, false, false);
/* 21 */       if (leaderid != this.roleid) {
/* 22 */         return false;
/*    */       }
/*    */     }
/*    */     
/* 26 */     FightInterface.startPVEFight(this.roleid, this.fightcfgid, new FightContext()
/*    */     {
/*    */ 
/* 29 */       public boolean isRecordEnable() { return true; } }, FightReason.GM);
/*    */     
/*    */ 
/*    */ 
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PGM_Fight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */