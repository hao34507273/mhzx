/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.corps.main.CorpsInfo;
/*    */ import mzm.gsp.corps.main.CorpsInterface;
/*    */ import mzm.gsp.crossbattle.SNotifyKnockOutCorpsQualification;
/*    */ import mzm.gsp.crossbattle.event.KnockOutFightEndArg;
/*    */ import mzm.gsp.crossbattle.event.KnockOutFightEndProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ public class POnKnockoutStageFightEnd extends KnockOutFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     if ((((KnockOutFightEndArg)this.arg).rank == 4) && (!((KnockOutFightEndArg)this.arg).isDraw))
/*    */     {
/* 18 */       return false;
/*    */     }
/*    */     
/* 21 */     if (((KnockOutFightEndArg)this.arg).isWin)
/*    */     {
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     if (((KnockOutFightEndArg)this.arg).rank == 1)
/*    */     {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     CrossBattleKnockoutManager.removeCanJoinNowStageKnockOutCorpsIdSet(((KnockOutFightEndArg)this.arg).corpsId);
/*    */     
/* 33 */     CorpsInfo corpsInfo = CorpsInterface.getCorpsInfoByCorpsId(((KnockOutFightEndArg)this.arg).corpsId, true);
/* 34 */     if (corpsInfo == null)
/*    */     {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     for (Iterator i$ = corpsInfo.getAllMemberIds().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 41 */       SNotifyKnockOutCorpsQualification sNotifKnockOutCorpsQualification = new SNotifyKnockOutCorpsQualification(((KnockOutFightEndArg)this.arg).knockOutType, 0);
/*    */       
/*    */ 
/*    */ 
/* 45 */       OnlineManager.getInstance().send(roleId, sNotifKnockOutCorpsQualification);
/*    */     }
/*    */     
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\POnKnockoutStageFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */