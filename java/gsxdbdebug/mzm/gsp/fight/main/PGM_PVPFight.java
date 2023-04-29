/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ 
/*    */ public class PGM_PVPFight extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long activeRoleid;
/*    */   private long passiveRoleid;
/*    */   private FightContext fightContext;
/*    */   
/*    */   public PGM_PVPFight(long activeRoleid, long passiveRoleid)
/*    */   {
/* 13 */     this(activeRoleid, passiveRoleid, new FightContext()
/*    */     {
/*    */       public boolean isRecordEnable() {
/* 16 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public PGM_PVPFight(long activeRoleid, long passiveRoleid, FightContext fightContext) {
/* 22 */     this.activeRoleid = activeRoleid;
/* 23 */     this.passiveRoleid = passiveRoleid;
/* 24 */     this.fightContext = fightContext;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     if (TeamInterface.isRoleInTeam(this.activeRoleid, false)) {
/* 31 */       long leaderid = TeamInterface.getTeamLeaderByRoleid(this.activeRoleid, false, false);
/* 32 */       if (leaderid != this.activeRoleid) {
/* 33 */         return false;
/*    */       }
/*    */     }
/*    */     
/* 37 */     if (TeamInterface.isRoleInTeam(this.passiveRoleid, false)) {
/* 38 */       long leaderid = TeamInterface.getTeamLeaderByRoleid(this.passiveRoleid, false, false);
/* 39 */       if (leaderid != this.passiveRoleid) {
/* 40 */         return false;
/*    */       }
/*    */     }
/* 43 */     if (this.activeRoleid == this.passiveRoleid) {
/* 44 */       return false;
/*    */     }
/* 46 */     FightInterface.startPVPFight(this.activeRoleid, this.passiveRoleid, this.fightContext, FightReason.GM);
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PGM_PVPFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */