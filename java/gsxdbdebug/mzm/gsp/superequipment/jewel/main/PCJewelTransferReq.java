/*     */ package mzm.gsp.superequipment.jewel.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.ModMoneyResult;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.superequipment.SJewelTransferError;
/*     */ import mzm.gsp.superequipment.SJewelTransferRsp;
/*     */ import mzm.gsp.superequipment.jewel.confbean.SSuperEquipmentJewelItem;
/*     */ import mzm.gsp.superequipment.jewel.confbean.SuperEquipmentJewelConstants;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.wanted.main.WantedManager;
/*     */ import xbean.JewelTransferInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2jeweltransferinfo;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCJewelTransferReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int fromJewelBagId;
/*     */   final int fromJewelGridNo;
/*     */   final int toJewelCfgId;
/*     */   
/*     */   public PCJewelTransferReq(long roleId, int fromJewelBagId, int fromJewelGridNo, int toJewelCfgId)
/*     */   {
/*  40 */     this.roleId = roleId;
/*  41 */     this.fromJewelBagId = fromJewelBagId;
/*  42 */     this.fromJewelGridNo = fromJewelGridNo;
/*  43 */     this.toJewelCfgId = toJewelCfgId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  50 */     if (!OpenInterface.getOpenStatus(441))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  56 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1608, false))
/*     */     {
/*  58 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  62 */     if (!MapInterface.isNearByNPC(this.roleId, SuperEquipmentJewelConstants.getInstance().TRANSFER_NPC_ID))
/*     */     {
/*  64 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  68 */     if (!NpcInterface.checkNpcService(SuperEquipmentJewelConstants.getInstance().TRANSFER_NPC_ID, SuperEquipmentJewelConstants.getInstance().TRANSFER_NPC_SERVICE, this.roleId))
/*     */     {
/*     */ 
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     SJewelTransferError jewelTransferError = new SJewelTransferError();
/*     */     
/*  76 */     String userId = RoleInterface.getUserId(this.roleId);
/*     */     
/*  78 */     lock(User.getTable(), Arrays.asList(new String[] { userId }));
/*     */     
/*  80 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*     */     
/*     */ 
/*  83 */     BasicItem fromBasicItem = ItemInterface.getItem(this.roleId, this.fromJewelBagId, this.fromJewelGridNo, true);
/*  84 */     if (fromBasicItem == null)
/*     */     {
/*  86 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  90 */     int fromJewelCfgId = fromBasicItem.getCfgId();
/*  91 */     SSuperEquipmentJewelItem fromJewelItem = SSuperEquipmentJewelItem.get(fromJewelCfgId);
/*  92 */     if (fromJewelItem == null)
/*     */     {
/*  94 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  98 */     SSuperEquipmentJewelItem toJewelItem = SSuperEquipmentJewelItem.get(this.toJewelCfgId);
/*  99 */     if (toJewelItem == null)
/*     */     {
/* 101 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 105 */     if (!SuperEquipmentJewelManager.checkJewelLevel(fromJewelItem, toJewelItem))
/*     */     {
/* 107 */       jewelTransferError.errorcode = 2;
/* 108 */       OnlineManager.getInstance().sendAtOnce(this.roleId, jewelTransferError);
/* 109 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 113 */     int availableTransferCount = SuperEquipmentJewelManager.getAvailableTransferCount(this.roleId);
/* 114 */     if (availableTransferCount <= 0)
/*     */     {
/* 116 */       jewelTransferError.errorcode = 1;
/* 117 */       OnlineManager.getInstance().sendAtOnce(this.roleId, jewelTransferError);
/* 118 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 122 */     float fromJewelBasePrice = SuperEquipmentJewelManager.getJewelTransferBasePrice(fromJewelCfgId);
/* 123 */     if (fromJewelBasePrice == -1.0F)
/*     */     {
/* 125 */       return false;
/*     */     }
/*     */     
/* 128 */     float toJewelBasePrice = SuperEquipmentJewelManager.getJewelTransferBasePrice(this.toJewelCfgId);
/* 129 */     if (toJewelBasePrice == -1.0F)
/*     */     {
/* 131 */       return false;
/*     */     }
/*     */     
/* 134 */     SJewelTransferRsp jewelTransferRsp = new SJewelTransferRsp();
/* 135 */     jewelTransferRsp.availabletransfercount = (availableTransferCount - 1);
/* 136 */     jewelTransferRsp.fromjewelbagid = this.fromJewelBagId;
/* 137 */     jewelTransferRsp.fromjewelgridno = this.fromJewelGridNo;
/* 138 */     jewelTransferRsp.tojewelcfgid = this.toJewelCfgId;
/*     */     
/*     */ 
/* 141 */     jewelTransferRsp.moneycount = ((int)((fromJewelBasePrice - toJewelBasePrice) * Math.pow(2.0D, fromJewelItem.jewelLevel - 1)));
/*     */     
/*     */ 
/* 144 */     long roleMoneyCount = WantedManager.getMoneyForRole(userId, this.roleId, 2);
/* 145 */     if ((jewelTransferRsp.moneycount < 0) && (roleMoneyCount < Math.abs(jewelTransferRsp.moneycount)))
/*     */     {
/* 147 */       jewelTransferError.errorcode = 4;
/* 148 */       OnlineManager.getInstance().sendAtOnce(this.roleId, jewelTransferError);
/* 149 */       return false;
/*     */     }
/* 151 */     int goldMaxCount = AwardInterface.getMoneyOwnMax(2);
/* 152 */     if ((jewelTransferRsp.moneycount > 0) && (roleMoneyCount + jewelTransferRsp.moneycount > goldMaxCount))
/*     */     {
/* 154 */       jewelTransferError.errorcode = 3;
/* 155 */       OnlineManager.getInstance().sendAtOnce(this.roleId, jewelTransferError);
/* 156 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 162 */     if (jewelTransferRsp.moneycount < 0)
/*     */     {
/* 164 */       boolean ret = RoleInterface.cutGold(this.roleId, Math.abs(jewelTransferRsp.moneycount), new TLogArg(LogReason.SUPER_EQUIPMENT_JEWEL_TRANSFER));
/*     */       
/* 166 */       if (!ret)
/*     */       {
/* 168 */         return false;
/*     */       }
/*     */     }
/* 171 */     else if (jewelTransferRsp.moneycount > 0)
/*     */     {
/* 173 */       ModMoneyResult modMoneyResult = RoleInterface.addGoldWithinMax(this.roleId, jewelTransferRsp.moneycount, new TLogArg(LogReason.SUPER_EQUIPMENT_JEWEL_TRANSFER));
/*     */       
/* 175 */       if (!modMoneyResult.isSucceed())
/*     */       {
/* 177 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 182 */     boolean ret = ItemInterface.removeItemByGrid(this.roleId, this.fromJewelBagId, this.fromJewelGridNo, 1, new TLogArg(LogReason.SUPER_EQUIPMENT_JEWEL_TRANSFER));
/*     */     
/* 184 */     if (!ret)
/*     */     {
/* 186 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 190 */     ItemOperateResult itemOperateResult = ItemInterface.addItem(this.roleId, this.toJewelCfgId, 1, false, new TLogArg(LogReason.SUPER_EQUIPMENT_JEWEL_TRANSFER));
/*     */     
/* 192 */     if (!itemOperateResult.success())
/*     */     {
/* 194 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 198 */     JewelTransferInfo xJewelTransferInfo = Role2jeweltransferinfo.get(Long.valueOf(this.roleId));
/* 199 */     xJewelTransferInfo.setCount(xJewelTransferInfo.getCount() + 1);
/*     */     
/*     */ 
/* 202 */     SuperEquipmentJewelTLogManager.tlogJewelTransfer(this.roleId, this.fromJewelBagId, this.fromJewelGridNo, fromJewelCfgId, this.toJewelCfgId, jewelTransferRsp.moneycount, jewelTransferRsp.availabletransfercount);
/*     */     
/*     */ 
/* 205 */     OnlineManager.getInstance().send(this.roleId, jewelTransferRsp);
/* 206 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\jewel\main\PCJewelTransferReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */