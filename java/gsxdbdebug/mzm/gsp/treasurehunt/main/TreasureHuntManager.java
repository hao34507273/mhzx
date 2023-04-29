/*    */ package mzm.gsp.treasurehunt.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.buff.main.BuffInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.treasurehunt.confbean.STreasureHuntCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TreasureHuntManager
/*    */ {
/*    */   static boolean isActivitySwitchOpen(int activityCfgId)
/*    */   {
/* 22 */     STreasureHuntCfg sTreasureHuntCfg = STreasureHuntCfg.get(activityCfgId);
/* 23 */     if (sTreasureHuntCfg == null)
/*    */     {
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     if (!OpenInterface.getOpenStatus(sTreasureHuntCfg.switch_type))
/*    */     {
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   static void regMapItemCheck()
/*    */   {
/* 41 */     TreasureHuntMapItemHandler handler = new TreasureHuntMapItemHandler();
/*    */     
/* 43 */     for (STreasureHuntCfg sTreasureHuntCfg : STreasureHuntCfg.getAll().values())
/*    */     {
/* 45 */       if (!MapInterface.regisMapItemGatherHandler(sTreasureHuntCfg.map_item_handler_type, handler))
/*    */       {
/* 47 */         throw new RuntimeException(String.format("[treasure_hunt]TreasureHuntManager.regMapItemCheck@regisMapItemGatherHandler err!|checkType=%d", new Object[] { Integer.valueOf(sTreasureHuntCfg.map_item_handler_type) }));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   static void onLeaveTreasureHunt(long roleId, Set<Integer> triggerBuffSet)
/*    */   {
/* 56 */     for (Integer buffId : triggerBuffSet)
/*    */     {
/* 58 */       BuffInterface.uninstallBuf(roleId, buffId.intValue());
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\treasurehunt\main\TreasureHuntManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */