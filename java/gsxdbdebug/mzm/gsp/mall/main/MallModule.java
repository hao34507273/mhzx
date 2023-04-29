/*    */ package mzm.gsp.mall.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import xdb.TTable;
/*    */ import xtable.Role2jifen;
/*    */ 
/*    */ public class MallModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 15 */     MallManager.init();
/* 16 */     Role2jifen.getTable().addListener(new JifenChangedListener(), new String[] { "value", "type2point" });
/* 17 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int exit()
/*    */   {
/* 24 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 31 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 38 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public void postInit()
/*    */   {
/* 44 */     new LimitItemRefreshObserver(MallManager.getRefreshtimeByMalltype(2));
/*    */     
/*    */ 
/*    */ 
/* 48 */     for (Map.Entry<Integer, CurrentLimitShopRelation> entry : MallManager.CURRENT_LIMIT_SHOP.entrySet())
/*    */     {
/* 50 */       int shopType = ((Integer)entry.getKey()).intValue();
/* 51 */       new CurrentLimitMallResetObserver(shopType);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\main\MallModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */