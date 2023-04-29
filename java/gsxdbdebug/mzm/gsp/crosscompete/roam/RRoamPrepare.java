/*    */ package mzm.gsp.crosscompete.roam;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*    */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xbean.CrossCompete;
/*    */ import xbean.CrossCompeteAgainst;
/*    */ import xbean.CrossCompeteMatch;
/*    */ import xbean.RoamCrossCompeteFactionTmp;
/*    */ 
/*    */ public class RRoamPrepare extends LogicRunnable
/*    */ {
/*    */   private boolean firstTime;
/*    */   
/*    */   public RRoamPrepare(boolean fristTime)
/*    */   {
/* 20 */     this.firstTime = fristTime;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 26 */     CrossCompete xCompete = CrossCompeteManager.getXCrossCompete(false);
/* 27 */     if (xCompete == null) {
/* 28 */       return;
/*    */     }
/*    */     
/*    */ 
/* 32 */     for (Map.Entry<CrossCompeteMatch, CrossCompeteAgainst> entry : xCompete.getAgainsts().entrySet()) {
/* 33 */       CrossCompeteMatch cMatch = (CrossCompeteMatch)entry.getKey();
/* 34 */       CrossCompeteAgainst xAgainst = (CrossCompeteAgainst)entry.getValue();
/* 35 */       if (this.firstTime) {
/* 36 */         if (xAgainst.getCompete_index() < SCrossCompeteConsts.getInstance().MaxCompeteCountOfOneTime) {
/* 37 */           new PCreatePrepareWorld(cMatch.getFront_factionid()).call();
/* 38 */           new PCreatePrepareWorld(cMatch.getBehind_factionid()).call();
/*    */         }
/*    */         
/*    */       }
/* 42 */       else if (xAgainst.getCompete_index() >= SCrossCompeteConsts.getInstance().MaxCompeteCountOfOneTime) {
/* 43 */         new PCreatePrepareWorld(cMatch.getFront_factionid()).call();
/* 44 */         new PCreatePrepareWorld(cMatch.getBehind_factionid()).call();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   static class PCreatePrepareWorld
/*    */     extends LogicProcedure
/*    */   {
/*    */     private final long factionid;
/*    */     
/*    */     PCreatePrepareWorld(long factionid)
/*    */     {
/* 57 */       this.factionid = factionid;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 63 */       RoamCrossCompeteFactionTmp xRoamFactionTmp = CrossCompeteRoamManager.createXRoamCrossCompeteFactionTmpIfNotExist(this.factionid);
/*    */       
/*    */ 
/* 66 */       long prepareWorld = CrossCompeteRoamManager.createPrepareWorld(xRoamFactionTmp);
/*    */       
/* 68 */       CrossCompeteManager.logInfo("PCreatePrepareWorld.processImp@create prepare world|factionid=%d|world=%d", new Object[] { Long.valueOf(this.factionid), Long.valueOf(prepareWorld) });
/*    */       
/*    */ 
/*    */ 
/* 72 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\RRoamPrepare.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */