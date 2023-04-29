/*     */ package mzm.gsp.superequipment.jewel.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.EquipmentItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.superequipment.SJewelError;
/*     */ import mzm.gsp.superequipment.SUnMountJewelSuccess;
/*     */ import mzm.gsp.superequipment.jewel.event.UnMountSuperEquipmentJewel;
/*     */ import mzm.gsp.superequipment.jewel.event.UnMountSuperEquipmentJewelArg;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.JewelInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCUnMountJewel
/*     */   extends LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int bagid;
/*     */   final int grid;
/*     */   final int index;
/*     */   
/*     */   public PCUnMountJewel(long roleId, int bagid, int grid, int index)
/*     */   {
/*  37 */     this.roleId = roleId;
/*  38 */     this.bagid = bagid;
/*  39 */     this.grid = grid;
/*  40 */     this.index = index;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  46 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1604, true))
/*     */     {
/*  48 */       return false;
/*     */     }
/*  50 */     if (!OpenInterface.getOpenStatus(385))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if (this.index <= 0)
/*     */     {
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     if ((this.bagid != 340600001) && (this.bagid != 340600000))
/*     */     {
/*  62 */       GameServer.logger().error(String.format("[superequipmentjewel]PCUnMountJewel.processImp@ bag id error |roleid=%d|bagid=%d|grid=%d|index=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagid), Integer.valueOf(this.grid), Integer.valueOf(this.index) }));
/*     */       
/*     */ 
/*  65 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SJewelError(5));
/*  66 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  70 */     BasicItem basicItem = ItemInterface.getItem(this.roleId, this.bagid, this.grid);
/*  71 */     if ((basicItem == null) || (!(basicItem instanceof EquipmentItem)))
/*     */     {
/*  73 */       GameServer.logger().error(String.format("[superequipmentjewel]PCUnMountJewel.processImp@ super equipment not in bag |roleid=%d|bagid=%d|grid=%d|index=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagid), Integer.valueOf(this.grid), Integer.valueOf(this.index) }));
/*     */       
/*     */ 
/*  76 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SJewelError(7));
/*  77 */       return false;
/*     */     }
/*  79 */     EquipmentItem superEquipmentItemInBag = (EquipmentItem)basicItem;
/*     */     
/*  81 */     if (superEquipmentItemInBag.getSuperEquipmentStage() <= 0)
/*     */     {
/*  83 */       return false;
/*     */     }
/*  85 */     Map<Integer, JewelInfo> xJewelInfoMap = superEquipmentItemInBag.getJewelMap();
/*  86 */     if (xJewelInfoMap == null)
/*     */     {
/*  88 */       return false;
/*     */     }
/*  90 */     Map<Integer, Integer> slotIndex2jewelCfgIdBefore = SuperEquipmentJewelManager.getSlotIndex2JewelCfgId(xJewelInfoMap);
/*     */     
/*  92 */     JewelInfo jewelInfo = (JewelInfo)xJewelInfoMap.get(Integer.valueOf(this.index));
/*  93 */     if (jewelInfo == null)
/*     */     {
/*  95 */       GameServer.logger().error(String.format("[superequipmentjewel]PCUnMountJewel.processImp@ no jewel in that slot |roleid=%d|bagid=%d|grid=%d|index=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagid), Integer.valueOf(this.grid), Integer.valueOf(this.index) }));
/*     */       
/*     */ 
/*  98 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SJewelError(7));
/*  99 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 104 */     ItemOperateResult itemOperateResult = ItemInterface.addItem(this.roleId, jewelInfo.getJewelcfgid(), 1, new TLogArg(LogReason.SUPER_EQUIPMENT_JEWEL_UNMOUNT));
/*     */     
/* 106 */     if (!itemOperateResult.success())
/*     */     {
/* 108 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 112 */     xJewelInfoMap.remove(Integer.valueOf(this.index));
/*     */     
/* 114 */     TriggerEventsManger.getInstance().triggerEvent(new UnMountSuperEquipmentJewel(), new UnMountSuperEquipmentJewelArg(this.roleId, this.bagid, this.grid, this.index));
/*     */     
/*     */ 
/* 117 */     Map<Integer, Integer> slotIndex2jewelCfgIdNow = SuperEquipmentJewelManager.getSlotIndex2JewelCfgId(xJewelInfoMap);
/* 118 */     SuperEquipmentJewelTLogManager.tlogJewelMount(this.roleId, slotIndex2jewelCfgIdBefore, slotIndex2jewelCfgIdNow, superEquipmentItemInBag.getTlogUuid());
/*     */     
/*     */ 
/* 121 */     OnlineManager.getInstance().send(this.roleId, new SUnMountJewelSuccess(this.bagid, this.grid, this.index));
/* 122 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\jewel\main\PCUnMountJewel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */