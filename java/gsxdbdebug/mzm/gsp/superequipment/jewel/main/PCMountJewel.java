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
/*     */ import mzm.gsp.superequipment.SMountJewelSuccess;
/*     */ import mzm.gsp.superequipment.confbean.SSuperEquipmentStageCfg;
/*     */ import mzm.gsp.superequipment.jewel.confbean.SSuperEquipmentJewelItem;
/*     */ import mzm.gsp.superequipment.jewel.event.MountSuperEquipmentJewel;
/*     */ import mzm.gsp.superequipment.jewel.event.MountSuperEquipmentJewelArg;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ import xbean.JewelInfo;
/*     */ import xbean.Pod;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCMountJewel
/*     */   extends LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int bagid;
/*     */   final int grid;
/*     */   final int index;
/*     */   final int jewelcfgid;
/*     */   
/*     */   public PCMountJewel(long roleId, int bagid, int grid, int index, int jewelcfgid)
/*     */   {
/*  40 */     this.roleId = roleId;
/*  41 */     this.bagid = bagid;
/*  42 */     this.grid = grid;
/*  43 */     this.index = index;
/*  44 */     this.jewelcfgid = jewelcfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  50 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1603, true))
/*     */     {
/*  52 */       return false;
/*     */     }
/*  54 */     if (!OpenInterface.getOpenStatus(385))
/*     */     {
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     if (this.index <= 0)
/*     */     {
/*  61 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  65 */     SSuperEquipmentJewelItem cfgJewelItem = SSuperEquipmentJewelItem.get(this.jewelcfgid);
/*  66 */     if (cfgJewelItem == null)
/*     */     {
/*  68 */       GameServer.logger().error(String.format("[superequipmentjewel]PCMountJewel.processImp@ cfg jewel item not exist |roleid=%d|bagid=%d|grid=%d|index=%d|jewelcfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagid), Integer.valueOf(this.grid), Integer.valueOf(this.index), Integer.valueOf(this.jewelcfgid) }));
/*     */       
/*     */ 
/*  71 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SJewelError(7));
/*  72 */       return false;
/*     */     }
/*  74 */     BasicItem jewelItemInBag = ItemInterface.getItemByCfgId(this.roleId, 340600005, this.jewelcfgid, true);
/*     */     
/*  76 */     if (jewelItemInBag == null)
/*     */     {
/*  78 */       GameServer.logger().error(String.format("[superequipmentjewel]PCMountJewel.processImp@ jewel item not in bag |roleid=%d|bagid=%d|grid=%d|index=%d|jewelcfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagid), Integer.valueOf(this.grid), Integer.valueOf(this.index), Integer.valueOf(this.jewelcfgid) }));
/*     */       
/*     */ 
/*  81 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SJewelError(7));
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     if ((this.bagid != 340600001) && (this.bagid != 340600000))
/*     */     {
/*  87 */       GameServer.logger().error(String.format("[superequipmentjewel]PCMountJewel.processImp@ bag id error |roleid=%d|bagid=%d|grid=%d|index=%d|jewelcfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagid), Integer.valueOf(this.grid), Integer.valueOf(this.index), Integer.valueOf(this.jewelcfgid) }));
/*     */       
/*     */ 
/*  90 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SJewelError(5));
/*  91 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  95 */     BasicItem basicItem = ItemInterface.getItem(this.roleId, this.bagid, this.grid);
/*  96 */     if ((basicItem == null) || (!(basicItem instanceof EquipmentItem)))
/*     */     {
/*  98 */       GameServer.logger().error(String.format("[superequipmentjewel]PCMountJewel.processImp@ super equipment not in bag |roleid=%d|bagid=%d|grid=%d|index=%d|jewelcfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagid), Integer.valueOf(this.grid), Integer.valueOf(this.index), Integer.valueOf(this.jewelcfgid) }));
/*     */       
/*     */ 
/* 101 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SJewelError(7));
/* 102 */       return false;
/*     */     }
/* 104 */     EquipmentItem superEquipmentItemInBag = (EquipmentItem)basicItem;
/* 105 */     int stage = superEquipmentItemInBag.getSuperEquipmentStage();
/* 106 */     if (stage <= 0)
/*     */     {
/* 108 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 112 */     int equipmentType = ItemInterface.getEquipWearpos(superEquipmentItemInBag.getCfgId());
/* 113 */     if (cfgJewelItem.jewelType != equipmentType)
/*     */     {
/* 115 */       GameServer.logger().error(String.format("[superequipmentjewel]PCMountJewel.processImp@ jewel can not match equipment |roleid=%d|bagid=%d|grid=%d|index=%d|jewelcfgid=%d|jeweltype=%d|equipmenttype=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagid), Integer.valueOf(this.grid), Integer.valueOf(this.index), Integer.valueOf(this.jewelcfgid), Integer.valueOf(cfgJewelItem.jewelType), Integer.valueOf(equipmentType) }));
/*     */       
/*     */ 
/* 118 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SJewelError(7));
/* 119 */       return false;
/*     */     }
/*     */     
/* 122 */     SSuperEquipmentStageCfg superEquipmentStageCfg = SSuperEquipmentStageCfg.get(stage);
/* 123 */     if (superEquipmentStageCfg == null)
/*     */     {
/* 125 */       return false;
/*     */     }
/* 127 */     if (cfgJewelItem.jewelLevel > superEquipmentStageCfg.maxGemLevel)
/*     */     {
/* 129 */       GameServer.logger().error(String.format("[superequipmentjewel]PCMountJewel.processImp@ jewel level error |roleid=%d|bagid=%d|grid=%d|index=%d|jewelcfgid=%d|jewellevel=%d|maxjewellevel=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagid), Integer.valueOf(this.grid), Integer.valueOf(this.index), Integer.valueOf(this.jewelcfgid), Integer.valueOf(cfgJewelItem.jewelLevel), Integer.valueOf(superEquipmentStageCfg.maxGemLevel) }));
/*     */       
/*     */ 
/* 132 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SJewelError(2));
/* 133 */       return false;
/*     */     }
/* 135 */     if (this.index > superEquipmentStageCfg.gemSlotNum)
/*     */     {
/* 137 */       GameServer.logger().error(String.format("[superequipmentjewel]PCMountJewel.processImp@ index error |roleid=%d|bagid=%d|grid=%d|index=%d|jewelcfgid=%d|maxslotnum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagid), Integer.valueOf(this.grid), Integer.valueOf(this.index), Integer.valueOf(this.jewelcfgid), Integer.valueOf(superEquipmentStageCfg.gemSlotNum) }));
/*     */       
/*     */ 
/* 140 */       return false;
/*     */     }
/*     */     
/* 143 */     Map<Integer, JewelInfo> jewelMap = superEquipmentItemInBag.getItem().getJewelmap();
/* 144 */     Map<Integer, Integer> slotIndex2jewelCfgIdBefore = SuperEquipmentJewelManager.getSlotIndex2JewelCfgId(jewelMap);
/*     */     
/* 146 */     JewelInfo jewelInfo = (JewelInfo)jewelMap.get(Integer.valueOf(this.index));
/* 147 */     if (jewelInfo != null)
/*     */     {
/*     */ 
/* 150 */       ItemOperateResult itemOperateResult = ItemInterface.addItem(this.roleId, jewelInfo.getJewelcfgid(), 1, new TLogArg(LogReason.SUPER_EQUIPMENT_JEWEL_UNMOUNT));
/*     */       
/* 152 */       if (!itemOperateResult.success())
/*     */       {
/* 154 */         return false;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 159 */       jewelInfo = Pod.newJewelInfo();
/* 160 */       jewelMap.put(Integer.valueOf(this.index), jewelInfo);
/*     */     }
/*     */     
/* 163 */     boolean ret = ItemInterface.removeItemById(this.roleId, 340600005, this.jewelcfgid, 1, new TLogArg(LogReason.SUPER_EQUIPMENT_JEWEL_MOUNT));
/*     */     
/* 165 */     if (!ret)
/*     */     {
/* 167 */       return false;
/*     */     }
/*     */     
/* 170 */     jewelInfo.setJewelcfgid(this.jewelcfgid);
/*     */     
/*     */ 
/* 173 */     TriggerEventsManger.getInstance().triggerEvent(new MountSuperEquipmentJewel(), new MountSuperEquipmentJewelArg(this.roleId, this.bagid, this.grid, this.index, this.jewelcfgid));
/*     */     
/*     */ 
/* 176 */     Map<Integer, Integer> slotIndex2jewelCfgIdNow = SuperEquipmentJewelManager.getSlotIndex2JewelCfgId(jewelMap);
/* 177 */     SuperEquipmentJewelTLogManager.tlogJewelMount(this.roleId, slotIndex2jewelCfgIdBefore, slotIndex2jewelCfgIdNow, superEquipmentItemInBag.getTlogUuid());
/*     */     
/*     */ 
/* 180 */     OnlineManager.getInstance().send(this.roleId, new SMountJewelSuccess(this.bagid, this.grid, this.index, this.jewelcfgid));
/*     */     
/* 182 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\jewel\main\PCMountJewel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */