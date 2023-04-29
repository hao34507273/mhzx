/*    */ package mzm.gsp.fight.event;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PVEFightStartFailArg
/*    */ {
/*    */   public final int fightCfgID;
/*    */   public final FightContext context;
/*    */   public final long roleid;
/*    */   public final FailReason faliReason;
/*    */   
/*    */   public PVEFightStartFailArg(int fightCfgID, FightContext context, long roleid, FailReason failReason)
/*    */   {
/* 20 */     this.fightCfgID = fightCfgID;
/* 21 */     this.context = context;
/* 22 */     this.roleid = roleid;
/* 23 */     this.faliReason = failReason;
/*    */   }
/*    */   
/*    */   public static enum FailReason {
/* 27 */     FIGHT_ID_NOT_EXIST, 
/* 28 */     FIGHT_TYPE_NOT_EXIST, 
/* 29 */     ROLE_IS_IN_FIGHT, 
/* 30 */     ROLE_SET_STATUS_WRONG;
/*    */     
/*    */     private FailReason() {}
/*    */   }
/*    */   
/* 35 */   public boolean isFightIdNotExist() { return this.faliReason == FailReason.FIGHT_ID_NOT_EXIST; }
/*    */   
/*    */   public boolean isFightTypeNotExist()
/*    */   {
/* 39 */     return this.faliReason == FailReason.FIGHT_TYPE_NOT_EXIST;
/*    */   }
/*    */   
/*    */   public boolean isRoleInFight() {
/* 43 */     return this.faliReason == FailReason.ROLE_IS_IN_FIGHT;
/*    */   }
/*    */   
/*    */   public boolean isRoleStatusWrong() {
/* 47 */     return this.faliReason == FailReason.ROLE_SET_STATUS_WRONG;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\PVEFightStartFailArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */