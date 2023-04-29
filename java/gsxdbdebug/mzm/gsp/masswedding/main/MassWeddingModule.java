/*    */ package mzm.gsp.masswedding.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.masswedding.confbean.SMassWeddingConsts;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.MassWeddingRankInfo;
/*    */ import xbean.MassWeddingRankInfos;
/*    */ import xtable.Massweddingrank;
/*    */ 
/*    */ public class MassWeddingModule implements Module, PostModuleInitListner
/*    */ {
/*    */   public int cleanupForMerge()
/*    */   {
/* 19 */     return 0;
/*    */   }
/*    */   
/*    */   public int exit()
/*    */   {
/* 24 */     return 0;
/*    */   }
/*    */   
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 29 */     ActivityInterface.registerActivityByLogicType(56, new MassWeddingHandler());
/*    */     
/* 31 */     new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 35 */         MassWeddingRankInfos xMassWeddingRankInfos = Massweddingrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*    */         
/* 37 */         if (xMassWeddingRankInfos != null) {
/* 38 */           for (MassWeddingRankInfo xMassWeddingRankInfo : xMassWeddingRankInfos.getMassweddingrankinfos())
/*    */           {
/* 40 */             MassWeddingSignUpChart massWeddingSignUpChart = new MassWeddingSignUpChart(xMassWeddingRankInfo.getRoleida(), xMassWeddingRankInfo.getRoleaoffer(), xMassWeddingRankInfo.getRoleidb(), xMassWeddingRankInfo.getRoleidboffer());
/*    */             
/*    */ 
/* 43 */             MassWeddingSignUpChartManager.getInstance().rank(massWeddingSignUpChart);
/*    */           }
/*    */         }
/* 46 */         return true;
/*    */       }
/*    */       
/*    */ 
/* 50 */     }.call();
/* 51 */     boolean isNeedReturn = MassWeddingManager.isNeedCheckReturnSignupMoneyWhenStart();
/* 52 */     if (isNeedReturn) {
/* 53 */       MassWeddingRankInfos xMassWeddingRankInfos = MassWeddingManager.getMassWeddingRankInfos(false);
/* 54 */       if (xMassWeddingRankInfos != null) {
/* 55 */         for (MassWeddingRankInfo xMassWeddingRankInfo : xMassWeddingRankInfos.getMassweddingrankinfos()) {
/* 56 */           new MassWeddingHandler.CheckAndReturnMoneyProcedure(xMassWeddingRankInfo, SMassWeddingConsts.getInstance().serverReasonMailid, new mzm.gsp.tlog.TLogArg(LogReason.MASSWEDDING_SIGN_UP_SERVER_REASON_RETURN)).call();
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 63 */     return 0;
/*    */   }
/*    */   
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 68 */     return 0;
/*    */   }
/*    */   
/*    */   public void postInit() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\MassWeddingModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */