/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.christmasstocking.event.ChristmasStockingTreeRemoveProcedure;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.HomeOwners;
/*    */ import xdb.CacheQuery;
/*    */ import xdb.TTableCache;
/*    */ import xtable.Homeworld2roles;
/*    */ 
/*    */ public class POnChristmasStockingTreeRemove extends ChristmasStockingTreeRemoveProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     TTableCache<Long, HomeOwners> cacheMap = Homeworld2roles.getCache();
/*    */     
/* 18 */     cacheMap.walk(new POnChristmasStockingTreeRemoveQuery(null));
/*    */     
/* 20 */     return true;
/*    */   }
/*    */   
/*    */   private static class POnChristmasStockingTreeRemoveQuery
/*    */     implements CacheQuery<Long, HomeOwners>
/*    */   {
/*    */     public void onQuery(Long key, HomeOwners value)
/*    */     {
/* 28 */       NoneRealTimeTaskManager.getInstance().addTask(new POnChristmasStockingTreeRemove.POnChristmasStockingTreeRemoveNoneRealTask(key.longValue(), value.getCreatorroleid()));
/*    */     }
/*    */   }
/*    */   
/*    */   private static class POnChristmasStockingTreeRemoveNoneRealTask
/*    */     extends LogicProcedure
/*    */   {
/*    */     private final long homeworldId;
/*    */     private final long ownerRoleId;
/*    */     
/*    */     public POnChristmasStockingTreeRemoveNoneRealTask(long homeworldId, long ownerRoleId)
/*    */     {
/* 40 */       this.homeworldId = homeworldId;
/* 41 */       this.ownerRoleId = ownerRoleId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 47 */       HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.ownerRoleId);
/* 48 */       if (homeInfoWrapper == null)
/*    */       {
/* 50 */         return false;
/*    */       }
/*    */       
/* 53 */       long realHomeworldId = GameServerInfoManager.toLocalId(this.homeworldId);
/*    */       
/*    */ 
/* 56 */       mzm.gsp.christmasstocking.main.ChristmasStockingInterface.removeTreeFromCourtyard(this.ownerRoleId, homeInfoWrapper.getPartnerRoleId(), realHomeworldId);
/*    */       
/* 58 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\POnChristmasStockingTreeRemove.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */