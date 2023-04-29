/*    */ package mzm.gsp.cat.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.item.confbean.SCatItemCfg;
/*    */ import mzm.gsp.item.event.RemoveItemeArg;
/*    */ import mzm.gsp.item.main.ItemOperateResult;
/*    */ import xbean.CatBag;
/*    */ import xbean.CatInfo;
/*    */ 
/*    */ public class POnRemoveItem extends mzm.gsp.item.event.RemoveItemEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     ItemOperateResult itemOperateResult = ((RemoveItemeArg)this.arg).itemOperateResult;
/* 18 */     if (!itemOperateResult.success())
/*    */     {
/* 20 */       return false;
/*    */     }
/*    */     
/* 23 */     long roleid = ((RemoveItemeArg)this.arg).roleId;
/* 24 */     CatBag xCatBag = xtable.Role2catbag.get(Long.valueOf(roleid));
/* 25 */     if (xCatBag == null)
/*    */     {
/* 27 */       return false;
/*    */     }
/* 29 */     if (xCatBag.getCats().isEmpty())
/*    */     {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     Set<Long> uuids = new java.util.HashSet();
/* 35 */     Map<Integer, Set<Long>> changeItemUuids = itemOperateResult.getChangedItemId2Uuids();
/* 36 */     for (Map.Entry<Integer, Set<Long>> entry : changeItemUuids.entrySet())
/*    */     {
/* 38 */       int itemCfgid = ((Integer)entry.getKey()).intValue();
/* 39 */       SCatItemCfg catItemCfg = SCatItemCfg.get(itemCfgid);
/* 40 */       if (catItemCfg != null)
/*    */       {
/* 42 */         uuids.addAll((java.util.Collection)entry.getValue());
/*    */       }
/*    */     }
/*    */     
/* 46 */     if (uuids.isEmpty())
/*    */     {
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     for (Iterator i$ = uuids.iterator(); i$.hasNext();) { long uuid = ((Long)i$.next()).longValue();
/*    */       
/* 53 */       if (!xCatBag.getItems().containsKey(Long.valueOf(uuid)))
/*    */       {
/*    */ 
/*    */ 
/* 57 */         CatInfo xCatInfo = (CatInfo)xCatBag.getCats().remove(Long.valueOf(uuid));
/* 58 */         if (xCatInfo != null)
/*    */         {
/* 60 */           mzm.gsp.GameServer.logger().info(String.format("[cat]POnRemoveItem.processImp@remove cat item|roleid=%d|catid=%d|cat_level_cfgid=%d|item_cfgid=%d|total_explore_num=%d|vigor=%d|state=%d|partner_cfgid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(uuid), Integer.valueOf(xCatInfo.getCat_level_cfgid()), Integer.valueOf(xCatInfo.getItem_cfgid()), Integer.valueOf(xCatInfo.getTotal_explore_num()), Integer.valueOf(xCatInfo.getVigor()), Integer.valueOf(xCatInfo.getState()), Integer.valueOf(xCatInfo.getPartner_cfgid()) }));
/*    */           
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 67 */           CatManager.addSystemRecoveryCatItemTlog(roleid, uuid, xCatInfo.getCat_level_cfgid(), xCatInfo.getItem_cfgid(), xCatInfo.getTotal_explore_num(), xCatInfo.getVigor(), xCatInfo.getState(), xCatInfo.getPartner_cfgid());
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 72 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\main\POnRemoveItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */