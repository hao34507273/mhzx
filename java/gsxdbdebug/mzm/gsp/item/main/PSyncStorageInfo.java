/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.item.BagInfo;
/*    */ import mzm.gsp.item.ItemInfo;
/*    */ import mzm.gsp.item.SAllStorageInfo;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Item;
/*    */ 
/*    */ 
/*    */ public class PSyncStorageInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PSyncStorageInfo(long roleid)
/*    */   {
/* 23 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     List<Integer> storageids = ItemInterface.getOpenStorageids(this.roleid, true);
/* 33 */     for (Iterator i$ = storageids.iterator(); i$.hasNext();) { int storageid = ((Integer)i$.next()).intValue();
/*    */       
/*    */ 
/* 36 */       SAllStorageInfo allStorageInfo = new SAllStorageInfo();
/*    */       
/* 38 */       RoleStorageBag bag = ItemManager.getRoleStorageBag(this.roleid, storageid);
/* 39 */       if (bag != null)
/*    */       {
/*    */ 
/*    */ 
/* 43 */         BagInfo s = new BagInfo();
/* 44 */         s.capacity = bag.getCapacity();
/* 45 */         s.name = bag.getBagName();
/*    */         
/* 47 */         for (Map.Entry<Integer, Item> itemEntry : bag.getItems().entrySet()) {
/* 48 */           ItemManager.checkBaotuItem((Item)itemEntry.getValue());
/* 49 */           ItemManager.checkPrivateItem((Item)itemEntry.getValue());
/* 50 */           ItemInfo itemInfo = new ItemInfo();
/* 51 */           ItemManager.fillInItemInfoBean(itemInfo, (Item)itemEntry.getValue());
/* 52 */           s.items.put(itemEntry.getKey(), itemInfo);
/*    */         }
/* 54 */         allStorageInfo.storages.put(Integer.valueOf(storageid), s);
/* 55 */         OnlineManager.getInstance().send(this.roleid, allStorageInfo);
/*    */       }
/*    */     }
/*    */     
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PSyncStorageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */