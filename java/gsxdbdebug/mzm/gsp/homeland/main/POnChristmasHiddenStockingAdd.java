/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.christmasstocking.event.ChristmasHiddenStockingAddProcedure;
/*    */ import mzm.gsp.christmasstocking.main.ChristmasStockingInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.HomeOwners;
/*    */ import xdb.CacheQuery;
/*    */ import xdb.TTableCache;
/*    */ import xtable.Homeworld2roles;
/*    */ 
/*    */ public class POnChristmasHiddenStockingAdd
/*    */   extends ChristmasHiddenStockingAddProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     TTableCache<Long, HomeOwners> cacheMap = Homeworld2roles.getCache();
/*    */     
/* 21 */     cacheMap.walk(new POnChristmasHiddenStockingAddQuery(null));
/*    */     
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   private static class POnChristmasHiddenStockingAddQuery
/*    */     implements CacheQuery<Long, HomeOwners>
/*    */   {
/*    */     public void onQuery(Long key, HomeOwners value)
/*    */     {
/* 31 */       NoneRealTimeTaskManager.getInstance().addTask(new POnChristmasHiddenStockingAdd.POnChristmasHiddenStockingAddNoneRealTask(key.longValue(), value.getCreatorroleid()));
/*    */     }
/*    */   }
/*    */   
/*    */   private static class POnChristmasHiddenStockingAddNoneRealTask extends LogicProcedure
/*    */   {
/*    */     private final long homeworldId;
/*    */     private final long ownerRoleId;
/*    */     
/*    */     public POnChristmasHiddenStockingAddNoneRealTask(long homeworldId, long ownerRoleId)
/*    */     {
/* 42 */       this.homeworldId = homeworldId;
/* 43 */       this.ownerRoleId = ownerRoleId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 49 */       HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.ownerRoleId);
/* 50 */       if (homeInfoWrapper == null)
/*    */       {
/* 52 */         return false;
/*    */       }
/*    */       
/* 55 */       long realHomeworldId = GameServerInfoManager.toLocalId(this.homeworldId);
/*    */       
/*    */ 
/* 58 */       ChristmasStockingInterface.addStockingToCourtyard(this.ownerRoleId, homeInfoWrapper.getPartnerRoleId(), realHomeworldId);
/* 59 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\POnChristmasHiddenStockingAdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */