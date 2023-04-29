/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.item.SRefreshHunSuccess;
/*     */ import mzm.gsp.item.confbean.EquipItemCfgConsts;
/*     */ import mzm.gsp.item.confbean.SEquipTransferInherit;
/*     */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2properties;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PRefreshHunReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private long uuid;
/*     */   private int bagid;
/*     */   private int isUseYuanbao;
/*     */   private long clientYuanbaoNum;
/*     */   private int clientNeedYuanbaoNum;
/*     */   
/*     */   public PRefreshHunReq(long roleid, int bagid, long uuid, int isUseYuanbao, long clientYuanbaoNum, int clientNeedYuanbaoNum)
/*     */   {
/*  34 */     this.roleid = roleid;
/*  35 */     this.uuid = uuid;
/*  36 */     this.bagid = bagid;
/*  37 */     this.isUseYuanbao = isUseYuanbao;
/*  38 */     this.clientYuanbaoNum = clientYuanbaoNum;
/*  39 */     this.clientNeedYuanbaoNum = clientNeedYuanbaoNum;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     if (!ItemModuleSwitchInterface.isEquipXihunSwitchOpenForRole(this.roleid))
/*     */     {
/*  47 */       return false;
/*     */     }
/*  49 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*     */     {
/*  51 */       String logStr = String.format("[item]PRefreshHunReq.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  52 */       ItemManager.logger.info(logStr);
/*  53 */       return false;
/*     */     }
/*  55 */     String userid = RoleInterface.getUserId(this.roleid);
/*  56 */     lock(Lockeys.get(User.getTable(), userid));
/*  57 */     lock(Lockeys.get(Role2properties.getTable(), Long.valueOf(this.roleid)));
/*  58 */     long serverHasNum = QingfuInterface.getBalance(userid, true);
/*  59 */     if (serverHasNum != this.clientYuanbaoNum)
/*     */     {
/*  61 */       String logStr = String.format("[item]PRefreshHunReq.processImp@client yuanbao num is not same as server num|roleid=%d|clientYuanbaoNum=%d|serverYuanbaoNum=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.clientYuanbaoNum), Long.valueOf(serverHasNum) });
/*     */       
/*     */ 
/*     */ 
/*  65 */       ItemManager.logger.info(logStr);
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     int userLevel = RoleInterface.getLevel(this.roleid);
/*  70 */     if (userLevel < EquipItemCfgConsts.getInstance().EQUIP_XIHUN_OPEN_LEVEL)
/*     */     {
/*  72 */       String logstr = String.format("[item]PRefreshHunReq.processImp@rolelevel error|roleid=%d|rolelevel=%d|openlevel=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(userLevel), Integer.valueOf(EquipItemCfgConsts.getInstance().EQUIP_XIHUN_OPEN_LEVEL) });
/*     */       
/*     */ 
/*  75 */       ItemManager.logger.error(logstr);
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     RoleItemBag itemBag = ItemManager.getBag(this.roleid, this.bagid);
/*  80 */     if (itemBag == null)
/*     */     {
/*  82 */       String logstr = String.format("[item]PRefreshHunReq.processImp@role bag error|roleid=%d|bagid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.bagid) });
/*  83 */       ItemManager.logger.error(logstr);
/*  84 */       ItemManager.sendWrongInfo(this.roleid, 99, new String[0]);
/*  85 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  89 */     BasicItem basicItem = itemBag.getItemByUuid(this.uuid);
/*  90 */     if ((basicItem == null) || (!(basicItem instanceof EquipmentItem)))
/*     */     {
/*  92 */       String logstr = String.format("[item]PRefreshHunReq.processImp@role item error|roleid=%d|uuid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid) });
/*  93 */       ItemManager.logger.error(logstr);
/*  94 */       ItemManager.sendWrongInfo(this.roleid, 102, new String[0]);
/*  95 */       return false;
/*     */     }
/*  97 */     EquipmentItem equipmentItem = (EquipmentItem)basicItem;
/*     */     
/*     */ 
/* 100 */     int lockedHumNum = equipmentItem.getLockedHunNum();
/* 101 */     if (lockedHumNum >= equipmentItem.getHunNum())
/*     */     {
/* 103 */       String logstr = String.format("[item]PRefreshHunReq.processImp@equipitem hun error|roleid=%d|lockedhunnum=%d|totalhunhun=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(lockedHumNum), Integer.valueOf(equipmentItem.getHunNum()) });
/*     */       
/*     */ 
/* 106 */       ItemManager.logger.error(logstr);
/*     */       
/*     */ 
/* 109 */       ItemManager.sendWrongInfo(this.roleid, 100, new String[0]);
/* 110 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 114 */     SItemEquipCfg itemEquipCfg = SItemEquipCfg.get(equipmentItem.getCfgId());
/* 115 */     if (itemEquipCfg == null)
/*     */     {
/* 117 */       String logstr = String.format("[item]PRefreshHunReq.processImp@SItemEquipCfg null|roleid=%d|cfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(equipmentItem.getCfgId()) });
/*     */       
/* 119 */       ItemManager.logger.error(logstr);
/* 120 */       ItemManager.sendWrongInfo(this.roleid, 101, new String[0]);
/* 121 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 125 */     SEquipTransferInherit equitTransferInherit = ItemConfigManager.getSEquipTransferHun(itemEquipCfg.useLevel);
/* 126 */     if (equitTransferInherit == null)
/*     */     {
/* 128 */       ItemManager.sendWrongInfo(this.roleid, 300, new String[0]);
/*     */       
/* 130 */       String logstr = String.format("[item]PRefreshHunReq.processImp@SEquipTransferInherit null|roleid=%d|uselevel=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(itemEquipCfg.useLevel) });
/*     */       
/* 132 */       ItemManager.logger.error(logstr);
/* 133 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 137 */     if ((equitTransferInherit.refreshHunCostItemId > 0) && (equitTransferInherit.refreshHunCostItemNum > 0))
/*     */     {
/* 139 */       TLogArg logArg = new TLogArg(LogReason.EQUIP_REFRESH_REM, equipmentItem.getCfgId());
/* 140 */       if (this.isUseYuanbao == 1)
/*     */       {
/* 142 */         Map<Integer, Integer> itemid2num = new HashMap();
/* 143 */         itemid2num.put(Integer.valueOf(equitTransferInherit.refreshHunCostItemId), Integer.valueOf(equitTransferInherit.refreshHunCostItemNum));
/* 144 */         boolean ret = ItemInterface.removeItemsWithCutYuanbao(userid, this.roleid, CostType.COST_BIND_FIRST_ITEM_REFRESH_HUN, itemid2num, this.clientNeedYuanbaoNum, logArg);
/*     */         
/*     */ 
/* 147 */         if (!ret)
/*     */         {
/* 149 */           String logStr = String.format("[wing]PRefreshHunReq.processImp@refresh hun error,item not enough or yuanbao not enough |roleid=%d|itemid=%d|itemnum=%d|yuanbaonum=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(equitTransferInherit.refreshHunCostItemId), Integer.valueOf(equitTransferInherit.refreshHunCostItemNum), Long.valueOf(serverHasNum) });
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 154 */           ItemManager.logger.info(logStr);
/*     */           
/* 156 */           return false;
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 161 */         ItemOperateResult ret = ItemInterface.removeItemsWithBindFirst(this.roleid, equitTransferInherit.refreshHunCostItemId, equitTransferInherit.refreshHunCostItemNum, logArg);
/*     */         
/* 163 */         if (!ret.success())
/*     */         {
/* 165 */           ItemManager.sendWrongInfo(this.roleid, 302, new String[0]);
/* 166 */           String logstr = String.format("[item]PRefreshHunReq.processImp@remove refreshhun item error|roleid=%d|itemid=%d|itemnum=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(equitTransferInherit.refreshHunCostItemId), Integer.valueOf(equitTransferInherit.refreshHunCostItemNum) });
/*     */           
/*     */ 
/* 169 */           ItemManager.logger.error(logstr);
/* 170 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 181 */     if (equipmentItem.refreshHun() != 0)
/*     */     {
/* 183 */       ItemManager.sendWrongInfo(this.roleid, 300, new String[0]);
/* 184 */       String logstr = String.format("[item]PRefreshHunReq.processImp@equip refreshhun failed|roleid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(equipmentItem.getCfgId()) });
/*     */       
/* 186 */       ItemManager.logger.error(logstr);
/* 187 */       return false;
/*     */     }
/*     */     
/* 190 */     SRefreshHunSuccess resp = new SRefreshHunSuccess();
/* 191 */     resp.bagid = this.bagid;
/* 192 */     resp.uuid = this.uuid;
/* 193 */     for (Map.Entry<Integer, xbean.TempExtraProInfo> entry : equipmentItem.getTempExtraPropInfos().entrySet())
/*     */     {
/* 195 */       xbean.TempExtraProInfo xTempExtraProInfo = (xbean.TempExtraProInfo)entry.getValue();
/* 196 */       mzm.gsp.item.TempExtraProInfo tempExtraProInfo = new mzm.gsp.item.TempExtraProInfo();
/* 197 */       tempExtraProInfo.protype = xTempExtraProInfo.getProtype();
/* 198 */       tempExtraProInfo.provalue = xTempExtraProInfo.getProvalue();
/* 199 */       resp.extrprops.put(entry.getKey(), tempExtraProInfo);
/*     */     }
/* 201 */     OnlineManager.getInstance().send(this.roleid, resp);
/*     */     
/* 203 */     String logstr = String.format("[item]PRefreshHunReq.processImp@equip refreshhun success|roleid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(equipmentItem.getCfgId()) });
/*     */     
/* 205 */     ItemManager.logger.info(logstr);
/* 206 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PRefreshHunReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */