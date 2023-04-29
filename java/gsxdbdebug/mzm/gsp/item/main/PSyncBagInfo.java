/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.bag.confbean.SBagCfg;
/*    */ import mzm.gsp.item.BagInfo;
/*    */ import mzm.gsp.item.ItemInfo;
/*    */ import mzm.gsp.item.SAllBagInfo;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Item;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PSyncBagInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PSyncBagInfo(long roleid)
/*    */   {
/* 26 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     SAllBagInfo allBagInfo = new SAllBagInfo();
/* 33 */     for (SBagCfg bagCfg : SBagCfg.getAll().values())
/*    */     {
/* 35 */       if ((bagCfg.type == 1) && 
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 40 */         (bagCfg.id != 340600006) && 
/*    */         
/*    */ 
/*    */ 
/*    */ 
/* 45 */         (bagCfg.id != 340600007) && 
/*    */         
/*    */ 
/*    */ 
/*    */ 
/* 50 */         (bagCfg.id != 340600008) && 
/*    */         
/*    */ 
/*    */ 
/*    */ 
/* 55 */         (bagCfg.id != 340600009))
/*    */       {
/*    */ 
/*    */ 
/* 59 */         RoleItemBag bag = ItemManager.getBag(this.roleid, bagCfg.id);
/* 60 */         if (bag != null)
/*    */         {
/*    */ 
/*    */ 
/* 64 */           BagInfo aBagInfo = new BagInfo();
/* 65 */           aBagInfo.capacity = bag.getCapacity();
/* 66 */           for (Map.Entry<Integer, Item> itemEntry : bag.getItems().entrySet())
/*    */           {
/* 68 */             ItemManager.checkBaotuItem((Item)itemEntry.getValue());
/* 69 */             ItemManager.checkPrivateItem((Item)itemEntry.getValue());
/* 70 */             ItemInfo itemInfo = new ItemInfo();
/* 71 */             ItemManager.fillInItemInfoBean(itemInfo, (Item)itemEntry.getValue());
/* 72 */             aBagInfo.items.put(itemEntry.getKey(), itemInfo);
/*    */           }
/* 74 */           allBagInfo.bags.put(Integer.valueOf(bagCfg.id), aBagInfo);
/*    */         } } }
/* 76 */     OnlineManager.getInstance().send(this.roleid, allBagInfo);
/* 77 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PSyncBagInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */