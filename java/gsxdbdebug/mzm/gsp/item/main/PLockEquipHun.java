/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.SLockHunSuccess;
/*     */ import mzm.gsp.item.confbean.LockHunNeedItemInfo;
/*     */ import mzm.gsp.item.confbean.SEquipTransferInherit;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PLockEquipHun extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long uuid;
/*     */   private final byte hunIndex;
/*     */   private final int bagid;
/*     */   private boolean isAutoUseYuanbao;
/*     */   
/*     */   public PLockEquipHun(long roleid, int bagid, long uuid, int hunIndex, boolean isAutoUseYuanbao)
/*     */   {
/*  31 */     this.roleid = roleid;
/*  32 */     this.uuid = uuid;
/*  33 */     this.hunIndex = ((byte)(hunIndex - 1));
/*  34 */     this.bagid = bagid;
/*  35 */     this.isAutoUseYuanbao = isAutoUseYuanbao;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (!ItemModuleSwitchInterface.isEquipLockHunSwitchOpenForRole(this.roleid))
/*     */     {
/*  43 */       return false;
/*     */     }
/*  45 */     if ((this.bagid < 0) || (this.hunIndex < 0))
/*     */     {
/*  47 */       return false;
/*     */     }
/*  49 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*     */     {
/*  51 */       String logStr = String.format("[item]PLockEquipHun.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  52 */       ItemManager.logger.info(logStr);
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     String userid = RoleInterface.getUserId(this.roleid);
/*  57 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*     */ 
/*  60 */     RoleItemBag equipBag = ItemManager.getBag(this.roleid, this.bagid);
/*  61 */     if (equipBag == null)
/*     */     {
/*  63 */       ItemManager.sendWrongInfo(this.roleid, 99, new String[0]);
/*  64 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  68 */     BasicItem basicItem = equipBag.getItemByUuid(this.uuid);
/*  69 */     if ((basicItem == null) || (!(basicItem instanceof EquipmentItem)))
/*     */     {
/*  71 */       ItemManager.sendWrongInfo(this.roleid, 102, new String[0]);
/*  72 */       return false;
/*     */     }
/*  74 */     EquipmentItem equipmentItem = (EquipmentItem)basicItem;
/*     */     
/*     */ 
/*  77 */     if (equipmentItem.isLockedHun(this.hunIndex))
/*     */     {
/*  79 */       ItemManager.sendWrongInfo(this.roleid, 350, new String[0]);
/*  80 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  84 */     int lockedHumNum = equipmentItem.getLockedHunNum();
/*  85 */     if (lockedHumNum >= equipmentItem.getHunNum() - 1)
/*     */     {
/*  87 */       ItemManager.sendWrongInfo(this.roleid, 351, new String[0]);
/*  88 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  92 */     SItemEquipCfg itemEquipCfg = SItemEquipCfg.get(equipmentItem.getCfgId());
/*  93 */     if (itemEquipCfg == null)
/*     */     {
/*  95 */       ItemManager.sendWrongInfo(this.roleid, 101, new String[0]);
/*  96 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 100 */     SEquipTransferInherit equipTransferInherit = ItemConfigManager.getSEquipTransferHun(itemEquipCfg.useLevel);
/* 101 */     if (equipTransferInherit == null)
/*     */     {
/* 103 */       ItemManager.sendWrongInfo(this.roleid, 300, new String[0]);
/* 104 */       return false;
/*     */     }
/* 106 */     if (lockedHumNum >= equipTransferInherit.lockHunNeedItemInfos.size())
/*     */     {
/* 108 */       ItemManager.sendWrongInfo(this.roleid, 351, new String[0]);
/* 109 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 113 */     LockHunNeedItemInfo lockHunNeedItemInfo = (LockHunNeedItemInfo)equipTransferInherit.lockHunNeedItemInfos.get(lockedHumNum);
/* 114 */     int lockHunNeedItemId = lockHunNeedItemInfo.itemId;
/* 115 */     int lockHunNeedItemNum = lockHunNeedItemInfo.itemNum;
/* 116 */     if ((lockHunNeedItemId > 0) && (lockHunNeedItemNum > 0))
/*     */     {
/*     */ 
/* 119 */       SItemCfg lockHunItemCfg = ItemInterface.getSItemCfg(lockHunNeedItemId);
/* 120 */       if (lockHunItemCfg == null)
/*     */       {
/* 122 */         ItemManager.sendWrongInfo(this.roleid, 101, new String[0]);
/* 123 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 127 */       RoleItemBag itemBag = this.bagid == 340600000 ? equipBag : ItemManager.getBag(this.roleid, 340600000);
/* 128 */       if (itemBag == null)
/*     */       {
/* 130 */         ItemManager.sendWrongInfo(this.roleid, 99, new String[0]);
/* 131 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 135 */       int hasItemNum = itemBag.getItemNumberBycfgId(lockHunNeedItemId);
/* 136 */       int deltaItemNum = lockHunNeedItemNum - hasItemNum;
/* 137 */       if ((!this.isAutoUseYuanbao) && (deltaItemNum > 0))
/*     */       {
/* 139 */         ItemManager.sendWrongInfo(this.roleid, 352, new String[0]);
/* 140 */         return false;
/*     */       }
/*     */       
/* 143 */       TLogArg logArg = new TLogArg(LogReason.EQUIP_LOCKUN_REM, equipmentItem.getCfgId());
/*     */       
/*     */ 
/* 146 */       if (hasItemNum > 0)
/*     */       {
/* 148 */         int costItemNum = Math.min(hasItemNum, lockHunNeedItemNum);
/* 149 */         ItemOperateResult result = ItemInterface.removeItemsWithBindFirst(this.roleid, lockHunNeedItemId, costItemNum, logArg);
/*     */         
/* 151 */         if (!result.success())
/*     */         {
/* 153 */           ItemManager.sendWrongInfo(this.roleid, 352, new String[0]);
/* 154 */           return false;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 159 */       if (deltaItemNum > 0)
/*     */       {
/* 161 */         int yuanbaoPrice = ItemInterface.getItemYuanBaoPrice(lockHunNeedItemId);
/* 162 */         int costYuanbao = yuanbaoPrice * deltaItemNum;
/*     */         
/*     */ 
/* 165 */         if (QingfuInterface.costYuanbao(userid, this.roleid, costYuanbao, CostType.COST_BIND_FIRST_ITEM_LOCK_EQUIP_HUN, logArg) != CostResult.Success)
/*     */         {
/*     */ 
/* 168 */           ItemManager.sendWrongInfo(this.roleid, 353, new String[0]);
/* 169 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 178 */     if (!equipmentItem.lockHun(this.hunIndex))
/*     */     {
/* 180 */       ItemManager.sendWrongInfo(this.roleid, 100, new String[0]);
/* 181 */       return false;
/*     */     }
/*     */     
/* 184 */     SLockHunSuccess resp = new SLockHunSuccess();
/* 185 */     resp.bagid = this.bagid;
/* 186 */     resp.uuid = this.uuid;
/* 187 */     resp.hunindex = ((byte)(this.hunIndex + 1));
/* 188 */     OnlineManager.getInstance().send(this.roleid, resp);
/*     */     
/* 190 */     ItemManager.tlogEquipLockhun(userid, this.roleid, this.uuid, equipmentItem.getCfgId(), this.bagid, this.hunIndex, true);
/*     */     
/* 192 */     StringBuilder sBuilder = new StringBuilder();
/* 193 */     sBuilder.append("[item]PLockEquipHun.processImp@lock hun success");
/* 194 */     sBuilder.append("|equip_uuid=").append(this.uuid);
/* 195 */     sBuilder.append("|equip_item_id=").append(equipmentItem.getCfgId());
/* 196 */     sBuilder.append("|hun_index=").append(this.hunIndex);
/* 197 */     sBuilder.append("|bag_id=").append(this.bagid);
/* 198 */     sBuilder.append("|is_use_yuan_bao=").append(this.isAutoUseYuanbao);
/*     */     
/* 200 */     GameServer.logger().info(sBuilder.toString());
/* 201 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PLockEquipHun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */