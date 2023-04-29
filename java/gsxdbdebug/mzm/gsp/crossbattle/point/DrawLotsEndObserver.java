/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleDrawLotsCfg;
/*    */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class DrawLotsEndObserver extends Observer
/*    */ {
/*    */   private final int activityCfgid;
/*    */   
/*    */   public DrawLotsEndObserver(long intervalSeconds, int activityCfgid)
/*    */   {
/* 15 */     super(intervalSeconds);
/* 16 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 22 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgid), new PDrawLotsEnd(this.activityCfgid));
/* 23 */     return false;
/*    */   }
/*    */   
/*    */   private static class PDrawLotsEnd extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private final int activityCfgid;
/*    */     
/*    */     public PDrawLotsEnd(int activityCfgid)
/*    */     {
/* 32 */       this.activityCfgid = activityCfgid;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 38 */       SCrossBattleDrawLotsCfg cfg = SCrossBattleDrawLotsCfg.get(this.activityCfgid);
/* 39 */       if (cfg == null)
/*    */       {
/* 41 */         GameServer.logger().error(String.format("[crossbattlepoint]PDrawLotsEnd.processImp@cfg is null|activity_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*    */         
/*    */ 
/* 44 */         return false;
/*    */       }
/*    */       
/* 47 */       if (!CrossBattlePointManager.isFunOpen(cfg.activitySwitch, cfg.funSwitch))
/*    */       {
/* 49 */         GameServer.logger().error(String.format("[crossbattlepoint]PDrawLotsEnd.processImp@fun not open|activity_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*    */         
/*    */ 
/* 52 */         return false;
/*    */       }
/*    */       
/* 55 */       CrossBattlePointManager.checkSendZoneMail(this.activityCfgid);
/* 56 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\DrawLotsEndObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */