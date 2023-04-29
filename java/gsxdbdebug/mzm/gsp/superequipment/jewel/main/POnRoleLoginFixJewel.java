/*     */ package mzm.gsp.superequipment.jewel.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.EquipmentItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import xbean.Bag;
/*     */ import xbean.Item;
/*     */ import xbean.JewelInfo;
/*     */ import xbean.OcpEquipBag;
/*     */ import xbean.SuperEquipmentExtraInfo;
/*     */ import xtable.Role2super_equipment_extra;
/*     */ 
/*     */ public class POnRoleLoginFixJewel extends mzm.gsp.online.event.PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  20 */     SuperEquipmentExtraInfo xSuperEquipmentExtraInfo = Role2super_equipment_extra.get((Long)this.arg);
/*  21 */     if (xSuperEquipmentExtraInfo == null)
/*     */     {
/*  23 */       xSuperEquipmentExtraInfo = xbean.Pod.newSuperEquipmentExtraInfo();
/*  24 */       Role2super_equipment_extra.add((Long)this.arg, xSuperEquipmentExtraInfo);
/*     */     }
/*     */     
/*     */ 
/*  28 */     if (xSuperEquipmentExtraInfo.getIs_jewel_fixed()) {
/*  29 */       return true;
/*     */     }
/*     */     
/*  32 */     xSuperEquipmentExtraInfo.setIs_jewel_fixed(true);
/*     */     
/*     */ 
/*  35 */     OcpEquipBag xOcpEquipBag = xtable.Role2ocpequipbag.get((Long)this.arg);
/*  36 */     if ((xOcpEquipBag == null) || (xOcpEquipBag.getOcp2equipbag().isEmpty())) {
/*  37 */       return true;
/*     */     }
/*     */     
/*  40 */     for (Bag xBag : xOcpEquipBag.getOcp2equipbag().values())
/*     */     {
/*  42 */       for (int i = 0; i <= 5; i++)
/*     */       {
/*  44 */         Item xItem = (Item)xBag.getItems().get(Integer.valueOf(i));
/*  45 */         if (xItem != null)
/*     */         {
/*     */ 
/*  48 */           EquipmentItem equipmentItem = new EquipmentItem(xItem);
/*  49 */           if (!checkAndUnmountJewelForNonSuperEquipment(equipmentItem)) {
/*  50 */             return false;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*  55 */     mzm.gsp.item.main.RoleEquipBag roleEquipBag = ItemInterface.getRoleEquipBag(((Long)this.arg).longValue());
/*  56 */     if (roleEquipBag != null)
/*     */     {
/*  58 */       for (BasicItem basicItem : roleEquipBag.getAllItems(false).values())
/*     */       {
/*  60 */         if ((basicItem instanceof EquipmentItem))
/*     */         {
/*  62 */           EquipmentItem equipmentItem = (EquipmentItem)basicItem;
/*  63 */           if (!checkAndUnmountJewelForNonSuperEquipment(equipmentItem)) {
/*  64 */             return false;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  70 */     mzm.gsp.item.main.RoleItemBag roleItemBag = ItemInterface.getRoleItemBag(((Long)this.arg).longValue());
/*  71 */     if (roleItemBag != null)
/*     */     {
/*  73 */       for (BasicItem basicItem : roleItemBag.getAllItems(false).values())
/*     */       {
/*  75 */         if ((basicItem instanceof EquipmentItem))
/*     */         {
/*  77 */           EquipmentItem equipmentItem = (EquipmentItem)basicItem;
/*  78 */           if (!checkAndUnmountJewelForNonSuperEquipment(equipmentItem)) {
/*  79 */             return false;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  85 */     for (mzm.gsp.item.main.RoleStorageBag roleStorageBag : ItemInterface.getAllRoleStorageBags(((Long)this.arg).longValue()))
/*     */     {
/*  87 */       for (BasicItem basicItem : roleStorageBag.getAllItems(false).values())
/*     */       {
/*  89 */         if ((basicItem instanceof EquipmentItem))
/*     */         {
/*  91 */           EquipmentItem equipmentItem = (EquipmentItem)basicItem;
/*  92 */           if (!checkAndUnmountJewelForNonSuperEquipment(equipmentItem)) {
/*  93 */             return false;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*  98 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkAndUnmountJewelForNonSuperEquipment(EquipmentItem item)
/*     */   {
/* 106 */     if ((item.getSuperEquipmentStage() == 0) && (!item.getJewelMap().isEmpty()))
/*     */     {
/* 108 */       for (JewelInfo xJewelInfo : item.getJewelMap().values())
/*     */       {
/* 110 */         ItemOperateResult result = ItemInterface.addItem(((Long)this.arg).longValue(), xJewelInfo.getJewelcfgid(), 1, new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.SUPER_EQUIPMENT_JEWEL_UNMOUNT));
/*     */         
/* 112 */         if (!result.success())
/*     */         {
/* 114 */           GameServer.logger().error(String.format("[superequipmentjewel]POnRoleLoginFixJewel.checkAndUnmountJewelForNonSuperEquipment()@ummount jewel failed|roleid=%d|item_uuid=%d|jewel_cfgid=%d", new Object[] { this.arg, item.getFirstUuid(), Integer.valueOf(xJewelInfo.getJewelcfgid()) }));
/*     */           
/*     */ 
/*     */ 
/* 118 */           return false;
/*     */         }
/* 120 */         GameServer.logger().info(String.format("[superequipmentjewel]POnRoleLoginFixJewel.checkAndUnmountJewelForNonSuperEquipment()@unmount jewel|roleid=%d|item_uuid=%d|jewel_cfgid=%d", new Object[] { this.arg, item.getFirstUuid(), Integer.valueOf(xJewelInfo.getJewelcfgid()) }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 125 */       item.getJewelMap().clear();
/*     */     }
/* 127 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\jewel\main\POnRoleLoginFixJewel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */