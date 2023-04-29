/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.HomeInfo;
/*    */ import xbean.HomeOwners;
/*    */ import xdb.CacheQuery;
/*    */ import xdb.TTableCache;
/*    */ import xtable.Homeworld2roles;
/*    */ 
/*    */ public class POnChristmasStockingTreeAdd extends mzm.gsp.christmasstocking.event.ChristmasStockingTreeAddProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     TTableCache<Long, HomeOwners> cacheMap = Homeworld2roles.getCache();
/*    */     
/* 18 */     cacheMap.walk(new POnChristmasStockingTreeAddQuery(null));
/*    */     
/* 20 */     return true;
/*    */   }
/*    */   
/*    */   private static class POnChristmasStockingTreeAddQuery
/*    */     implements CacheQuery<Long, HomeOwners>
/*    */   {
/*    */     public void onQuery(Long key, HomeOwners value)
/*    */     {
/* 28 */       NoneRealTimeTaskManager.getInstance().addTask(new POnChristmasStockingTreeAdd.POnChristmasStockingTreeAddNoneRealTask(key.longValue(), value.getCreatorroleid()));
/*    */     }
/*    */   }
/*    */   
/*    */   private static class POnChristmasStockingTreeAddNoneRealTask
/*    */     extends LogicProcedure
/*    */   {
/*    */     private final long homeworldId;
/*    */     private final long ownerRoleId;
/*    */     
/*    */     public POnChristmasStockingTreeAddNoneRealTask(long homeworldId, long ownerRoleId)
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
/* 53 */       int courtYardLevel = homeInfoWrapper.getxHomeInfo().getCourtyardlevel();
/* 54 */       int courtYardMapCfgId = HomelandManager.getHomelandCourtyardMapId(courtYardLevel);
/*    */       
/* 56 */       long realHomeworldId = GameServerInfoManager.toLocalId(this.homeworldId);
/*    */       
/*    */ 
/* 59 */       mzm.gsp.christmasstocking.main.ChristmasStockingInterface.addTreeToCourtyard(this.ownerRoleId, homeInfoWrapper.getPartnerRoleId(), realHomeworldId, courtYardMapCfgId, courtYardLevel);
/*    */       
/* 61 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\POnChristmasStockingTreeAdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */