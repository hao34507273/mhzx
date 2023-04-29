/*    */ package mzm.gsp.leitai.main;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ public class LeiTaiFightContext implements FightContext {
/*    */   public final long activeRoleid;
/*    */   public final boolean isActiveTeam;
/*    */   public final long passiveRoleid;
/*    */   public final boolean isPassiveTeam;
/*    */   
/*    */   public LeiTaiFightContext(long activeRoleid, boolean isActiveTeam, long passiveRoleid, boolean isPassiveTeam) {
/* 12 */     this.activeRoleid = activeRoleid;
/* 13 */     this.isActiveTeam = isActiveTeam;
/* 14 */     this.passiveRoleid = passiveRoleid;
/* 15 */     this.isPassiveTeam = isPassiveTeam;
/*    */   }
/*    */   
/*    */   public boolean isRecordEnable()
/*    */   {
/* 20 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\leitai\main\LeiTaiFightContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */