/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.crossbattle.SChangeCrossBattleCurrentSession;
/*    */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*    */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ public class PGM_SetCrossServerSession extends LogicRunnable
/*    */ {
/*    */   private final int session;
/*    */   
/*    */   public PGM_SetCrossServerSession(int session)
/*    */   {
/* 16 */     this.session = session;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 22 */     CrossBattleConsts.getInstance().cross_battle_session_num = this.session;
/*    */     
/* 24 */     SChangeCrossBattleCurrentSession sChangeCrossBattleCurrentSession = new SChangeCrossBattleCurrentSession();
/* 25 */     sChangeCrossBattleCurrentSession.session = this.session;
/*    */     
/* 27 */     OnlineManager.getInstance().sendAllAtOnce(sChangeCrossBattleCurrentSession);
/*    */     
/* 29 */     for (Iterator i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/*    */ 
/* 32 */       new RNotifyFinalChampionOut(roleId).execute();
/*    */     }
/*    */   }
/*    */   
/*    */   private static class RNotifyFinalChampionOut extends LogicRunnable
/*    */   {
/*    */     private final long roleId;
/*    */     
/*    */     public RNotifyFinalChampionOut(long roleId)
/*    */     {
/* 42 */       this.roleId = roleId;
/*    */     }
/*    */     
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 48 */       int crossBattleSessionNum = CrossBattleConsts.getInstance().cross_battle_session_num;
/* 49 */       int activityCfgId = CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID;
/*    */       
/* 51 */       long activityEndTime = mzm.gsp.activity.main.ActivityInterface.getActivityLimitTimeEnd(activityCfgId);
/* 52 */       if (mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() < activityEndTime)
/*    */       {
/* 54 */         CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID), new PCGetCrossBattleFinalHistoryFightReq(this.roleId, crossBattleSessionNum, 3));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PGM_SetCrossServerSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */