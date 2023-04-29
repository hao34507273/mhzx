/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.christmasstocking.event.ChristmasHiddenStockingRemoveProcedure;
/*    */ import mzm.gsp.christmasstocking.main.ChristmasStockingInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.HomeOwners;
/*    */ import xdb.CacheQuery;
/*    */ import xdb.TTableCache;
/*    */ import xtable.Homeworld2roles;
/*    */ 
/*    */ public class POnChristmasHiddenStockingRemove
/*    */   extends ChristmasHiddenStockingRemoveProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     TTableCache<Long, HomeOwners> cacheMap = Homeworld2roles.getCache();
/*    */     
/* 21 */     cacheMap.walk(new POnChristmasHiddenStockingRemoveQuery(null));
/*    */     
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   private static class POnChristmasHiddenStockingRemoveQuery
/*    */     implements CacheQuery<Long, HomeOwners>
/*    */   {
/*    */     public void onQuery(Long key, HomeOwners value)
/*    */     {
/* 31 */       NoneRealTimeTaskManager.getInstance().addTask(new POnChristmasHiddenStockingRemove.POnChristmasHiddenStockingRemoveNoneRealTask(key.longValue()));
/*    */     }
/*    */   }
/*    */   
/*    */   private static class POnChristmasHiddenStockingRemoveNoneRealTask extends LogicProcedure
/*    */   {
/*    */     private final long homeworldId;
/*    */     
/*    */     public POnChristmasHiddenStockingRemoveNoneRealTask(long homeworldId)
/*    */     {
/* 41 */       this.homeworldId = homeworldId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 47 */       long realHomeworldId = GameServerInfoManager.toLocalId(this.homeworldId);
/*    */       
/*    */ 
/* 50 */       ChristmasStockingInterface.removeStockingFromCourtyard(realHomeworldId);
/* 51 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\POnChristmasHiddenStockingRemove.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */