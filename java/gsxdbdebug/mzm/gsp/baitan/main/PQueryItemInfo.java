/*     */ package mzm.gsp.baitan.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.baitan.SQueryItemRes;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.DisplayItem;
/*     */ import xbean.DisplayItemList;
/*     */ import xbean.Subtype2ItemList;
/*     */ 
/*     */ public class PQueryItemInfo extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private int index;
/*     */   private int itemid;
/*     */   private int price;
/*     */   
/*     */   public PQueryItemInfo(long roleId, int index, int itemid, int price)
/*     */   {
/*  20 */     this.roleId = roleId;
/*  21 */     this.index = index;
/*  22 */     this.itemid = itemid;
/*  23 */     this.price = price;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  30 */     if ((this.index < 0) || (this.price <= 0) || (this.itemid <= 0))
/*     */     {
/*  32 */       return false;
/*     */     }
/*  34 */     if (!BaiTanManager.isBaiTanSwitchOpenForRole(this.roleId))
/*     */     {
/*  36 */       return false;
/*     */     }
/*  38 */     int level = mzm.gsp.role.main.RoleInterface.getLevel(this.roleId);
/*  39 */     if (!BaiTanManager.isOpenForLevel(level))
/*     */     {
/*  41 */       String logStr = String.format("[baitan]PQueryItemInfo.processImp@ role level not open for baitan|roleid=%d|level=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(level) });
/*     */       
/*  43 */       BaiTanManager.logger.warn(logStr);
/*  44 */       return false;
/*     */     }
/*  46 */     SQueryItemRes res = new SQueryItemRes();
/*  47 */     res.itemid = this.itemid;
/*  48 */     res.index = this.index;
/*  49 */     res.price = this.price;
/*     */     
/*  51 */     int subtype = BaiTanManager.getSubtypeidByItemid(this.itemid);
/*  52 */     if (subtype == -1)
/*     */     {
/*  54 */       return false;
/*     */     }
/*  56 */     Subtype2ItemList id2Price = xtable.Role2baitanshoppinglist.get(Long.valueOf(this.roleId));
/*  57 */     if ((id2Price == null) || (id2Price.getSub2itemlist().isEmpty()))
/*     */     {
/*  59 */       return false;
/*     */     }
/*  61 */     DisplayItemList displayItemList = (DisplayItemList)id2Price.getSub2itemlist().get(Integer.valueOf(subtype));
/*  62 */     if ((displayItemList == null) || (displayItemList.getDisplayitemlist().isEmpty()) || (this.index >= displayItemList.getDisplayitemlist().size()))
/*     */     {
/*     */ 
/*     */ 
/*  66 */       String logStr = String.format("[baitan]PQueryItemInfo.processImp@item not exist|roleid=%d|itemid=%d|index=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(this.index) });
/*     */       
/*  68 */       BaiTanManager.logger.error(logStr);
/*  69 */       return false;
/*     */     }
/*  71 */     DisplayItem displayItem = (DisplayItem)displayItemList.getDisplayitemlist().get(this.index);
/*  72 */     if ((displayItem.getItemid() != this.itemid) || (displayItem.getPrice() != this.price))
/*     */     {
/*  74 */       String logStr = String.format("[baitan]PQueryItemInfo.processImp@itemid or price error|roleid=%d|itemid=%d|price=%d|sitemid=%d|sprice=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(this.price), Integer.valueOf(displayItem.getItemid()), Integer.valueOf(displayItem.getPrice()) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  79 */       BaiTanManager.logger.error(logStr);
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     boolean ret = true;
/*  84 */     if (displayItem.getShoppingid() == 0L)
/*     */     {
/*  86 */       if (BaiTanManager.isEquipSubtype(subtype))
/*     */       {
/*  88 */         mzm.gsp.item.main.EquipmentItem equipmentItem = BaiTanManager.createFixEquipItem(this.itemid, false, false);
/*  89 */         if (equipmentItem == null)
/*     */         {
/*  91 */           return false;
/*     */         }
/*  93 */         BaiTanManager.fillItem(res.iteminfo, equipmentItem.getItem());
/*     */       }
/*     */       else
/*     */       {
/*  97 */         xbean.Item xItem = mzm.gsp.item.main.ItemInterface.createXItemWithOutUuid(this.itemid, 1, null, false);
/*  98 */         if (xItem == null)
/*     */         {
/* 100 */           return false;
/*     */         }
/* 102 */         BaiTanManager.fillItem(res.iteminfo, xItem);
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*     */     else {
/* 108 */       ret = fillShoppingItem(res.iteminfo, displayItem.getShoppingid());
/*     */     }
/*     */     
/* 111 */     mzm.gsp.online.main.OnlineManager.getInstance().send(this.roleId, res);
/* 112 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean fillShoppingItem(mzm.gsp.item.ItemInfo iteminfo, long shoppingid)
/*     */   {
/* 118 */     xbean.ShoppingInfo gridInfo = xtable.Roleshoppinginfo.get(Long.valueOf(shoppingid));
/* 119 */     if (gridInfo == null)
/*     */     {
/* 121 */       return false;
/*     */     }
/* 123 */     BaiTanManager.fillItem(iteminfo, gridInfo.getItem());
/* 124 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\main\PQueryItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */