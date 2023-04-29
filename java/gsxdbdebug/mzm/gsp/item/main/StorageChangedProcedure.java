/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.item.BagChangeInfo;
/*     */ import mzm.gsp.item.ItemInfo;
/*     */ import mzm.gsp.item.SStorageChangeInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ import xdb.logs.Note;
/*     */ import xdb.logs.NoteMap;
/*     */ 
/*     */ public class StorageChangedProcedure extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final int bagid;
/*     */   private final long roleid;
/*     */   private final Note note;
/*     */   
/*     */   public StorageChangedProcedure(long roleid, int bagid, Note note)
/*     */   {
/*  24 */     this.roleid = roleid;
/*  25 */     this.bagid = bagid;
/*  26 */     this.note = note;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     NoteMap<Integer, Item> changeInfo = (NoteMap)this.note;
/*     */     
/*  37 */     mzm.event.TriggerEventsManger.getInstance().triggerEventAtOnce(new mzm.gsp.item.event.PlayerBagChange(), new ItemEventArg(this.roleid, this.bagid));
/*  38 */     if (OnlineManager.getInstance().isOnline(this.roleid))
/*     */     {
/*     */ 
/*  41 */       RoleStorageBag rolebag = ItemManager.getRoleStorageBag(this.roleid, this.bagid);
/*     */       
/*  43 */       SStorageChangeInfo core = new SStorageChangeInfo();
/*  44 */       core.data.bagid = this.bagid;
/*     */       
/*  46 */       core.data.removed = new java.util.HashSet(changeInfo.getRemoved().keySet());
/*  47 */       Map<Integer, Item> itemsMap = rolebag.getItems();
/*  48 */       for (Iterator i$ = changeInfo.getChanged().iterator(); i$.hasNext();) { item = (Item)i$.next();
/*     */         
/*     */ 
/*  51 */         for (Map.Entry<Integer, Item> itemEntry : itemsMap.entrySet())
/*     */         {
/*  53 */           if (item.equals(itemEntry.getValue()))
/*     */           {
/*  55 */             ItemInfo ci = new ItemInfo();
/*  56 */             if (!ItemManager.fillInItemInfoBean(ci, item))
/*     */             {
/*  58 */               String logStr = String.format("[item]StorageBagChanged.onChanged@not find item uuid|roleid=%d|itemid=%d|grid=%d|reason=%s", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(item.getCfgid()), itemEntry.getKey(), "changed" });
/*     */               
/*     */ 
/*  61 */               ItemManager.logger.error(logStr);
/*  62 */               break;
/*     */             }
/*  64 */             core.data.changed.put(itemEntry.getKey(), ci);
/*  65 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */       Item item;
/*  70 */       for (Integer k : changeInfo.getReplaced().keySet())
/*     */       {
/*  72 */         Item xItem = (Item)itemsMap.get(k);
/*  73 */         if ((xItem != null) && (!core.data.changed.containsKey(k)))
/*     */         {
/*  75 */           ItemInfo ci = new ItemInfo();
/*     */           
/*  77 */           if (!ItemManager.fillInItemInfoBean(ci, xItem))
/*     */           {
/*  79 */             String logStr = String.format("[item]StorageBagChanged.onChanged@not find item uuid|roleid=%d|itemid=%d|grid=%d|reason=%s", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(xItem.getCfgid()), k, "replaced" });
/*     */             
/*     */ 
/*  82 */             ItemManager.logger.error(logStr);
/*     */           }
/*     */           else {
/*  85 */             core.data.changed.put(k, ci);
/*     */           }
/*     */         } }
/*  88 */       for (Integer k : changeInfo.getAdded())
/*     */       {
/*  90 */         Item xItem = (Item)itemsMap.get(k);
/*  91 */         if ((xItem != null) && (!core.data.changed.containsKey(k)))
/*     */         {
/*  93 */           ItemInfo ci = new ItemInfo();
/*     */           
/*  95 */           if (!ItemManager.fillInItemInfoBean(ci, xItem))
/*     */           {
/*  97 */             String logStr = String.format("[item]StorageBagChanged.onChanged@not find item uuid|roleid=%d|itemid=%d|grid=%d|reason=%s", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(xItem.getCfgid()), k, "added" });
/*     */             
/*     */ 
/* 100 */             ItemManager.logger.error(logStr);
/*     */           }
/*     */           else {
/* 103 */             core.data.changed.put(k, ci);
/*     */           }
/*     */         } }
/* 106 */       if ((core.data.changed.size() != 0) || (core.data.removed.size() != 0)) {
/* 107 */         OnlineManager.getInstance().send(this.roleid, core);
/*     */       }
/*     */     }
/*     */     
/* 111 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\StorageChangedProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */