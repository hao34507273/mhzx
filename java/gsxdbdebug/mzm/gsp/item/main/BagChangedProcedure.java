/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.item.BagChangeInfo;
/*     */ import mzm.gsp.item.ItemInfo;
/*     */ import mzm.gsp.item.SBagChangeInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ import xdb.logs.Note;
/*     */ import xdb.logs.NoteMap;
/*     */ 
/*     */ class BagChangedProcedure extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final int bagid;
/*     */   private final long roleid;
/*     */   private final Note note;
/*     */   
/*     */   public BagChangedProcedure(long roleid, int bagid, Note note)
/*     */   {
/*  28 */     this.roleid = roleid;
/*  29 */     this.bagid = bagid;
/*  30 */     this.note = note;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     NoteMap<Integer, Item> changeInfo = (NoteMap)this.note;
/*  39 */     TriggerEventsManger.getInstance().triggerEventAtOnce(new mzm.gsp.item.event.PlayerBagChange(), new ItemEventArg(this.roleid, this.bagid));
/*     */     
/*  41 */     if (this.bagid == 340600001)
/*     */     {
/*     */ 
/*  44 */       Set<Integer> changedPos = new HashSet();
/*     */       
/*  46 */       changedPos.addAll(changeInfo.getRemoved().keySet());
/*  47 */       changedPos.addAll(changeInfo.getAdded());
/*  48 */       changedPos.addAll(changeInfo.getReplaced().keySet());
/*  49 */       RoleItemBag rolebag = ItemManager.getBag(this.roleid, this.bagid);
/*     */       
/*  51 */       for (Iterator i$ = changeInfo.getChanged().iterator(); i$.hasNext();) { xItem = (Item)i$.next();
/*     */         
/*  53 */         for (Map.Entry<Integer, Item> itemEntry : rolebag.getItems().entrySet())
/*     */         {
/*  55 */           if (xItem.equals(itemEntry.getValue()))
/*     */           {
/*  57 */             changedPos.add(itemEntry.getKey());
/*  58 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */       Item xItem;
/*  63 */       TriggerEventsManger.getInstance().triggerEventAtOnce(new mzm.gsp.item.event.PlayerEquipChange(), new EquipChangeArg(this.roleid, changedPos));
/*     */     }
/*     */     
/*     */ 
/*  67 */     if (OnlineManager.getInstance().isOnline(this.roleid))
/*     */     {
/*     */ 
/*  70 */       RoleItemBag rolebag = ItemManager.getBag(this.roleid, this.bagid);
/*     */       
/*  72 */       SBagChangeInfo core = new SBagChangeInfo();
/*  73 */       core.data.bagid = this.bagid;
/*     */       
/*  75 */       core.data.removed = new HashSet(changeInfo.getRemoved().keySet());
/*  76 */       Map<Integer, Item> itemsMap = rolebag.getItems();
/*  77 */       for (Iterator i$ = changeInfo.getChanged().iterator(); i$.hasNext();) { item = (Item)i$.next();
/*     */         
/*     */ 
/*  80 */         for (Map.Entry<Integer, Item> itemEntry : itemsMap.entrySet())
/*     */         {
/*  82 */           if (item.equals(itemEntry.getValue()))
/*     */           {
/*  84 */             ItemInfo ci = new ItemInfo();
/*  85 */             if (!ItemManager.fillInItemInfoBean(ci, (Item)itemEntry.getValue()))
/*     */             {
/*  87 */               String logStr = String.format("[item]BagChanged.onChanged@not find item uuid|roleid=%d|itemid=%d|grid=%d|reason=%s", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(((Item)itemEntry.getValue()).getCfgid()), itemEntry.getKey(), "changed" });
/*     */               
/*     */ 
/*  90 */               ItemManager.logger.error(logStr);
/*  91 */               break;
/*     */             }
/*  93 */             core.data.changed.put(itemEntry.getKey(), ci);
/*  94 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */       Item item;
/*  99 */       for (Integer k : changeInfo.getReplaced().keySet())
/*     */       {
/* 101 */         Item xItem = (Item)itemsMap.get(k);
/* 102 */         if ((xItem != null) && (!core.data.changed.containsKey(k)))
/*     */         {
/* 104 */           ItemInfo ci = new ItemInfo();
/*     */           
/* 106 */           if (!ItemManager.fillInItemInfoBean(ci, xItem))
/*     */           {
/* 108 */             String logStr = String.format("[item]BagChanged.onChanged@not find item uuid|roleid=%d|itemid=%d|grid=%d|reason=%s", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(xItem.getCfgid()), k, "replaced" });
/*     */             
/*     */ 
/* 111 */             ItemManager.logger.error(logStr);
/*     */           }
/*     */           else {
/* 114 */             core.data.changed.put(k, ci);
/*     */           }
/*     */         } }
/* 117 */       for (Integer k : changeInfo.getAdded())
/*     */       {
/* 119 */         Item xItem = (Item)itemsMap.get(k);
/* 120 */         if ((xItem != null) && (!core.data.changed.containsKey(k)))
/*     */         {
/* 122 */           ItemInfo ci = new ItemInfo();
/*     */           
/* 124 */           if (!ItemManager.fillInItemInfoBean(ci, xItem))
/*     */           {
/* 126 */             String logStr = String.format("[item]BagChanged.onChanged@not find item uuid|roleid=%d|itemid=%d|grid=%d|reason=%s", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(xItem.getCfgid()), k, "added" });
/*     */             
/*     */ 
/* 129 */             ItemManager.logger.error(logStr);
/*     */           }
/*     */           else {
/* 132 */             core.data.changed.put(k, ci);
/*     */           }
/*     */         } }
/* 135 */       if ((core.data.changed.size() != 0) || (core.data.removed.size() != 0)) {
/* 136 */         OnlineManager.getInstance().send(this.roleid, core);
/*     */       }
/*     */     }
/*     */     
/* 140 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\BagChangedProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */