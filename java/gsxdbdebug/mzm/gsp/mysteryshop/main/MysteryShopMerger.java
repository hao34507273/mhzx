/*    */ package mzm.gsp.mysteryshop.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.MergeModule;
/*    */ import mzm.gsp.mysteryshop.confbean.CSMysteryShopConstsCfg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.MallRefreshTime;
/*    */ import xdb.Table;
/*    */ import xtable.Malltype2refreshtime;
/*    */ import xtable.Role2mystery_shops;
/*    */ 
/*    */ public class MysteryShopMerger implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 21 */     List<Table> tables = new ArrayList();
/* 22 */     tables.add(Role2mystery_shops.getTable());
/* 23 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 29 */     return new Merge_Malltype2refreshtime_Pro(null).call();
/*    */   }
/*    */   
/*    */ 
/*    */   private static class Merge_Malltype2refreshtime_Pro
/*    */     extends LogicProcedure
/*    */   {
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 39 */       for (Map.Entry<Integer, CSMysteryShopConstsCfg> entry : )
/*    */       {
/* 41 */         int shopType = ((Integer)entry.getKey()).intValue();
/*    */         
/* 43 */         long mainZoneId = MergeMain.getMainZoneid();
/* 44 */         long viceZoneId = MergeMain.getViceZoneid();
/*    */         
/* 46 */         long mainKey = GameServerInfoManager.toGlobalId(shopType, mainZoneId);
/* 47 */         long viceKey = GameServerInfoManager.toGlobalId(shopType, viceZoneId);
/*    */         
/* 49 */         lock(Malltype2refreshtime.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/* 50 */         MallRefreshTime xMain = Malltype2refreshtime.get(Long.valueOf(mainKey));
/* 51 */         MallRefreshTime xVice = Malltype2refreshtime.get(Long.valueOf(viceKey));
/*    */         
/* 53 */         if (xVice != null)
/*    */         {
/*    */ 
/*    */ 
/* 57 */           if (xMain == null)
/*    */           {
/* 59 */             xMain = xbean.Pod.newMallRefreshTime();
/* 60 */             xMain.setRefreshtime(xVice.getRefreshtime());
/* 61 */             Malltype2refreshtime.insert(Long.valueOf(mainKey), xMain);
/*    */ 
/*    */ 
/*    */ 
/*    */           }
/* 66 */           else if (xMain.getRefreshtime() < xVice.getRefreshtime())
/*    */           {
/* 68 */             xMain.setRefreshtime(xVice.getRefreshtime());
/*    */           }
/*    */           
/*    */ 
/* 72 */           Malltype2refreshtime.remove(Long.valueOf(viceKey));
/*    */         } }
/* 74 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mysteryshop\main\MysteryShopMerger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */