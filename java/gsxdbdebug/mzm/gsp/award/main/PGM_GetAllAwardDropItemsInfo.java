/*    */ package mzm.gsp.award.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.award.confbean.STAward;
/*    */ import mzm.gsp.award.drop.DropManager;
/*    */ import mzm.gsp.item.confbean.SItemCfg;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PGM_GetAllAwardDropItemsInfo extends LogicProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     for (STAward cfg : STAward.getAll().values())
/*    */     {
/* 20 */       Set<Integer> itemIds = DropManager.getAllTimeDropItemIds(cfg.awardId);
/* 21 */       if ((itemIds != null) && (itemIds.size() != 0))
/*    */       {
/*    */ 
/*    */ 
/* 25 */         GameServer.logger().info(String.format("awardId=%d@itemNames=%s", new Object[] { Integer.valueOf(cfg.awardId), getItemNames(itemIds) })); }
/*    */     }
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   String getItemNames(Set<Integer> itemIds)
/*    */   {
/* 32 */     if ((itemIds == null) || (itemIds.size() == 0))
/*    */     {
/* 34 */       return "";
/*    */     }
/* 36 */     StringBuffer sb = new StringBuffer();
/* 37 */     for (Iterator i$ = itemIds.iterator(); i$.hasNext();) { int itemId = ((Integer)i$.next()).intValue();
/*    */       
/* 39 */       SItemCfg cfg = ItemInterface.getSItemCfg(itemId);
/* 40 */       if (cfg != null)
/*    */       {
/*    */ 
/*    */ 
/* 44 */         sb.append("|").append(itemId).append("=").append(cfg.name); }
/*    */     }
/* 46 */     return sb.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\PGM_GetAllAwardDropItemsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */