/*    */ package mzm.gsp.fight.event;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ public class PetFightCVCFailArg
/*    */ {
/*    */   public long activeRoleId;
/*    */   public long passiveRoleId;
/*    */   public FightContext fightContext;
/*    */   public FailReason faliReason;
/*    */   
/*    */   public static enum FailReason {
/* 13 */     FIGHT_ID_NOT_EXIST,  FIGHT_TYPE_NOT_EXIST,  ROLE_IS_IN_FIGHT,  ROLE_SET_STATUS_WRONG;
/*    */     
/*    */     private FailReason() {}
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\PetFightCVCFailArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */