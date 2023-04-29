/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.fashiondress.confbean.SFashionDressCfg;
/*     */ import mzm.gsp.item.confbean.SMagicMarkItemCfg;
/*     */ import mzm.gsp.item.confbean.SWingViewItem;
/*     */ 
/*     */ public class ItemIdManger
/*     */ {
/*     */   public static List<Long> getWinitems(long roleid)
/*     */   {
/*  17 */     List<Long> retlist = new ArrayList();
/*  18 */     Iterator<BasicItem> items = getAllItems(roleid).values().iterator();
/*  19 */     while (items.hasNext()) {
/*  20 */       BasicItem basicItem = (BasicItem)items.next();
/*  21 */       SWingViewItem wingItem = SWingViewItem.get(basicItem.getCfgId());
/*  22 */       if ((wingItem != null) && (wingItem.type == 60)) {
/*  23 */         retlist.add(basicItem.getFirstUuid());
/*     */       }
/*     */     }
/*  26 */     return retlist;
/*     */   }
/*     */   
/*     */   public static List<Long> getAirItemUuId(Long roleId) {
/*  30 */     Iterator<BasicItem> items = getAllItems(roleId.longValue()).values().iterator();
/*  31 */     List<Long> retlist = new ArrayList();
/*  32 */     while (items.hasNext()) {
/*  33 */       BasicItem basicItem = (BasicItem)items.next();
/*  34 */       mzm.gsp.item.confbean.SAirCraftItem airCraftItem = mzm.gsp.item.confbean.SAirCraftItem.get(basicItem.getCfgId());
/*  35 */       if (airCraftItem != null) {
/*  36 */         retlist.add(basicItem.getFirstUuid());
/*     */       }
/*     */     }
/*  39 */     return retlist;
/*     */   }
/*     */   
/*     */   public static List<Integer> getFashionId(Long roleId) {
/*  43 */     int gender = mzm.gsp.role.main.RoleInterface.getGender(roleId.longValue());
/*  44 */     int occp = mzm.gsp.role.main.RoleInterface.getOccupationId(roleId.longValue());
/*  45 */     Iterator<BasicItem> items = getAllItems(roleId.longValue()).values().iterator();
/*  46 */     List<Integer> retlist = new ArrayList();
/*  47 */     BasicItem basicItem; while (items.hasNext()) {
/*  48 */       basicItem = (BasicItem)items.next();
/*  49 */       for (Map.Entry<Integer, SFashionDressCfg> entry : SFashionDressCfg.getAll().entrySet()) {
/*  50 */         SFashionDressCfg cfg = (SFashionDressCfg)entry.getValue();
/*  51 */         if (cfg.costItemId == basicItem.getCfgId()) {
/*  52 */           if ((cfg.fashionShowType == 1) && (cfg.gender == gender) && (cfg.menpai == occp))
/*     */           {
/*  54 */             retlist.add(entry.getKey());
/*  55 */           } else if (cfg.fashionShowType == 2)
/*     */           {
/*  57 */             if ((cfg.gender == 0) && (cfg.menpai == 0)) {
/*  58 */               retlist.add(entry.getKey());
/*     */             }
/*  60 */             else if (cfg.gender == gender) {
/*  61 */               retlist.add(entry.getKey());
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  69 */     return retlist;
/*     */   }
/*     */   
/*     */   public static List<Integer> getMagiceMarks(Long roleId)
/*     */   {
/*  74 */     List<Integer> retlist = new ArrayList();
/*  75 */     Iterator<BasicItem> items = getAllItems(roleId.longValue()).values().iterator();
/*  76 */     while (items.hasNext()) {
/*  77 */       BasicItem basicItem = (BasicItem)items.next();
/*  78 */       SMagicMarkItemCfg magicItem = SMagicMarkItemCfg.get(basicItem.getCfgId());
/*  79 */       if (magicItem != null) {
/*  80 */         retlist.add(Integer.valueOf(magicItem.id));
/*     */       }
/*     */     }
/*  83 */     return retlist;
/*     */   }
/*     */   
/*     */   public static List<Long> getMountsUuId(long roleId)
/*     */   {
/*  88 */     Iterator<BasicItem> items = getAllItems(roleId).values().iterator();
/*  89 */     List<Long> retlist = new ArrayList();
/*  90 */     while (items.hasNext()) {
/*  91 */       BasicItem basicItem = (BasicItem)items.next();
/*  92 */       mzm.gsp.mounts.confbean.SMountsUnLockItemCfg mountItem = mzm.gsp.mounts.confbean.SMountsUnLockItemCfg.get(basicItem.getCfgId());
/*  93 */       if (mountItem != null) {
/*  94 */         retlist.add(basicItem.getFirstUuid());
/*     */       }
/*     */     }
/*  97 */     return retlist;
/*     */   }
/*     */   
/*     */   private static Map<Integer, BasicItem> getAllItems(long roleId)
/*     */   {
/* 102 */     RoleItemBag bag = ItemManager.getBag(roleId, 340600000);
/* 103 */     Map<Integer, BasicItem> mapitem = bag.getAllItems(true);
/* 104 */     return mapitem;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\ItemIdManger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */