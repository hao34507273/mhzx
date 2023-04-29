/*    */ package mzm.gsp.crosscompete.roam;
/*    */ 
/*    */ import mzm.gsp.crosscompete.confbean.ItemController;
/*    */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*    */ import mzm.gsp.crosscompete.main.CrossCompeteConfigManager;
/*    */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ class TriggerMapItemSession extends Session
/*    */ {
/*    */   private final long world;
/*    */   private final int leftCount;
/*    */   
/*    */   TriggerMapItemSession(int seconds, long factionid, long world, int leftCount)
/*    */   {
/* 18 */     super(seconds, factionid);
/* 19 */     this.world = world;
/* 20 */     this.leftCount = leftCount;
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 25 */     NoneRealTimeTaskManager.getInstance().addTask(new PTriggerMapItem(getOwerId(), this.world, this.leftCount));
/*    */   }
/*    */   
/*    */   static class PTriggerMapItem extends LogicProcedure
/*    */   {
/*    */     private final long factionid;
/*    */     private final long world;
/*    */     private final int leftCount;
/*    */     
/*    */     PTriggerMapItem(long factionid, long world, int leftCount)
/*    */     {
/* 36 */       this.factionid = factionid;
/* 37 */       this.world = world;
/* 38 */       this.leftCount = leftCount;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 44 */       int totalNumber = Math.min(this.leftCount, SCrossCompeteConsts.getInstance().MaxTreasureNum);
/* 45 */       for (ItemController itemController : SCrossCompeteConsts.getInstance().ItemControllers) {
/* 46 */         int sumWeight = CrossCompeteConfigManager.getSumItemWeight();
/* 47 */         int number = (int)Math.ceil(itemController.Weight * totalNumber / sumWeight);
/* 48 */         number = Math.min(number, SCrossCompeteConsts.getInstance().MaxTreasureNum);
/* 49 */         mzm.gsp.map.main.ControllerInterface.triggerWorldControllerWithMaxSpawnNum(this.world, itemController.Controller, number);
/*    */         
/* 51 */         CrossCompeteManager.logInfo("PTriggerMapItem.processImp@trigger treasure|win_factionid=%d|worldid=%d|controllerid=%d|number=%d", new Object[] { Long.valueOf(this.factionid), Long.valueOf(this.world), Integer.valueOf(itemController.Controller), Integer.valueOf(number) });
/*    */       }
/*    */       
/*    */ 
/*    */ 
/* 56 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\TriggerMapItemSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */