/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.fight.event.PetFightCVCFailArg;
/*    */ import xbean.PetArenaInfo;
/*    */ 
/*    */ public class POnPetFightCVCFail extends mzm.gsp.fight.event.PetFightCVCFailProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     mzm.gsp.fight.main.FightContext fightContext = ((PetFightCVCFailArg)this.arg).fightContext;
/* 12 */     if (!(fightContext instanceof PetCVCFightContext))
/*    */     {
/* 14 */       return false;
/*    */     }
/*    */     
/* 17 */     long roleid = ((PetFightCVCFailArg)this.arg).activeRoleId;
/* 18 */     PetArenaInfo xPetArenaInfo = xtable.Role2petarenainfo.get(Long.valueOf(roleid));
/* 19 */     if (xPetArenaInfo == null)
/*    */     {
/* 21 */       GameServer.logger().error(String.format("[petarena]POnPetFightCVCFail.processImp@xbean is null|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/* 22 */       return false;
/*    */     }
/* 24 */     int challenge = xPetArenaInfo.getChallenge_count();
/* 25 */     if (challenge > 0)
/*    */     {
/* 27 */       xPetArenaInfo.setChallenge_count(challenge - 1);
/*    */     }
/* 29 */     GameServer.logger().info(String.format("[petarena]POnPetFightCVCFail.processImp@start fight failed|roleid=%d|challenge=%d|reason=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(challenge), Integer.valueOf(((PetFightCVCFailArg)this.arg).faliReason != null ? ((PetFightCVCFailArg)this.arg).faliReason.ordinal() : -1) }));
/*    */     
/*    */ 
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\POnPetFightCVCFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */