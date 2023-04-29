/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import mzm.gsp.item.confbean.EquipItemCfgConsts;
/*     */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*     */ import mzm.gsp.item.confbean.SQiLinAccumulateModeCfg;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PEquipQiLinUseYuanbaoReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int bagid;
/*     */   private final int key;
/*     */   private final int itemid;
/*     */   private final int itemNum;
/*     */   private final int clientNeedYuabao;
/*     */   private final long clientYuanbao;
/*     */   private String userid;
/*     */   
/*     */   public PEquipQiLinUseYuanbaoReq(long roleid, int bagid, int key, int itemid, int itemNum, int clientNeedYuabao, long clientYuanbao)
/*     */   {
/*  35 */     this.roleid = roleid;
/*  36 */     this.itemid = itemid;
/*  37 */     this.itemNum = itemNum;
/*  38 */     this.bagid = bagid;
/*  39 */     this.key = key;
/*  40 */     this.clientNeedYuabao = clientNeedYuabao;
/*  41 */     this.clientYuanbao = clientYuanbao;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  48 */     if (!ItemModuleSwitchInterface.isQilinAccumulationModeSwitchOpenForRole(this.roleid))
/*     */     {
/*  50 */       return false;
/*     */     }
/*  52 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*     */     {
/*  54 */       String logStr = String.format("[item]PEquipQiLinUseYuanbaoReq.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*  56 */       ItemManager.logger.info(logStr);
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     if ((this.bagid != 340600000) && (this.bagid != 340600001))
/*     */     {
/*  62 */       ItemManager.sendWrongInfo(this.roleid, 400, new String[0]);
/*  63 */       String logstr = String.format("[item]PEquipQiLinUseYuanbaoReq.processImp@bagid error|roleid=%d|bagid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.bagid) });
/*     */       
/*  65 */       ItemManager.logger.error(logstr);
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     int wearstate = -1;
/*     */     
/*  71 */     if (this.bagid == 340600000)
/*     */     {
/*  73 */       wearstate = -1;
/*     */     }
/*     */     else
/*     */     {
/*  77 */       wearstate = 1;
/*     */     }
/*  79 */     int yuanBaoPrice = ItemInterface.getItemYuanBaoPrice(this.itemid);
/*  80 */     if (yuanBaoPrice <= 0)
/*     */     {
/*  82 */       String logstr = String.format("[item]PEquipQiLinUseYuanbaoReq.processImp@get item yuanbao price error|roleid=%d|itemid=%d|yuanbao_price=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(yuanBaoPrice) });
/*     */       
/*     */ 
/*  85 */       ItemManager.logger.error(logstr);
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     this.userid = RoleInterface.getUserId(this.roleid);
/*  90 */     lock(User.getTable(), Arrays.asList(new String[] { this.userid }));
/*  91 */     int userLevel = RoleInterface.getLevel(this.roleid);
/*  92 */     if (userLevel < EquipItemCfgConsts.getInstance().EQUIP_QILIN_OPEN_LEVEL)
/*     */     {
/*  94 */       String logstr = String.format("[item]PEquipQiLinUseYuanbaoReq.processImp@qilin level error|roleid=%d|level=%d|needlevel=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(userLevel), Integer.valueOf(EquipItemCfgConsts.getInstance().EQUIP_QILIN_OPEN_LEVEL) });
/*     */       
/*     */ 
/*  97 */       ItemManager.logger.error(logstr);
/*  98 */       return false;
/*     */     }
/*     */     
/* 101 */     RoleItemBag itemBag = ItemManager.getRoleItemBag(this.roleid);
/*     */     
/* 103 */     RoleItemBag equipBag = ItemManager.getBag(this.roleid, this.bagid);
/*     */     
/* 105 */     if ((itemBag == null) || (equipBag == null))
/*     */     {
/* 107 */       ItemManager.sendWrongInfo(this.roleid, 400, new String[0]);
/* 108 */       String logstr = String.format("[item]PEquipQiLinUseYuanbaoReq.processImp@bagid null|roleid=%d|bagid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.bagid) });
/*     */       
/* 110 */       ItemManager.logger.error(logstr);
/* 111 */       return false;
/*     */     }
/* 113 */     int hasNum = itemBag.getItemNumberBycfgId(this.itemid);
/* 114 */     if (hasNum > 0)
/*     */     {
/* 116 */       ItemManager.sendWrongInfo(this.roleid, 400, new String[0]);
/* 117 */       String logstr = String.format("[item]PEquipQiLinUseYuanbaoReq.processImp@role has this item,can not use yuanbao|roleid=%d|itemid=%d|hasnum=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.itemid), Integer.valueOf(hasNum) });
/*     */       
/*     */ 
/* 120 */       ItemManager.logger.error(logstr);
/* 121 */       ItemManager.sendWrongInfo(this.roleid, 1175, new String[] { String.valueOf(this.itemid) });
/* 122 */       return false;
/*     */     }
/*     */     
/* 125 */     BasicItem basicItem = equipBag.get(this.key);
/* 126 */     if ((basicItem == null) || (!(basicItem instanceof EquipmentItem)))
/*     */     {
/* 128 */       ItemManager.sendWrongInfo(this.roleid, 401, new String[0]);
/* 129 */       int itemId = basicItem == null ? 0 : basicItem.getCfgId();
/* 130 */       String logstr = String.format("[item]PEquipQiLinUseYuanbaoReq.processImp@item key error,not equipment|roleid=%d|key=%d|itemid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(itemId) });
/*     */       
/*     */ 
/* 133 */       ItemManager.logger.error(logstr);
/* 134 */       return false;
/*     */     }
/*     */     
/* 137 */     EquipmentItem equipmentItem = (EquipmentItem)basicItem;
/*     */     
/*     */ 
/* 140 */     SItemEquipCfg itemEquipCfg = SItemEquipCfg.get(equipmentItem.getCfgId());
/* 141 */     if (itemEquipCfg == null)
/*     */     {
/* 143 */       String logstr = String.format("[item]PEquipQiLinUseYuanbaoReq.processImp@item cfg error,not equipment|roleid=%d|key=%d|itemid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(equipmentItem.getCfgId()) });
/*     */       
/*     */ 
/* 146 */       ItemManager.logger.error(logstr);
/* 147 */       ItemManager.sendWrongInfo(this.roleid, 402, new String[0]);
/* 148 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 152 */     if (itemEquipCfg.useLevel < EquipItemCfgConsts.getInstance().MIN_LEVEL_FOR_QILIN)
/*     */     {
/* 154 */       String logstr = String.format("[item]PEquipQiLinUseYuanbaoReq.processImp@equip level error|roleid=%d|key=%d|itemid=%d|equiplevel=%d|needlevel=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(equipmentItem.getCfgId()), Integer.valueOf(itemEquipCfg.useLevel), Integer.valueOf(EquipItemCfgConsts.getInstance().MIN_LEVEL_FOR_QILIN) });
/*     */       
/*     */ 
/*     */ 
/* 158 */       ItemManager.logger.error(logstr);
/* 159 */       ItemManager.sendWrongInfo(this.roleid, 409, new String[0]);
/* 160 */       return false;
/*     */     }
/* 162 */     boolean ret = ItemManager.checkQiLingLevel(this.roleid, this.key, equipmentItem, itemEquipCfg);
/* 163 */     if (!ret)
/*     */     {
/* 165 */       return false;
/*     */     }
/* 167 */     int curStrengthLevel = equipmentItem.getStrengthLevel();
/*     */     
/*     */ 
/* 170 */     SQiLinAccumulateModeCfg sQiLinAccumulateModeCfg = SQiLinAccumulateModeCfg.get(curStrengthLevel + 1);
/* 171 */     if (sQiLinAccumulateModeCfg == null)
/*     */     {
/* 173 */       ItemManager.sendWrongInfo(this.roleid, 403, new String[0]);
/* 174 */       String logstr = String.format("[item]PEquipQiLinUseYuanbaoReq.doStrength@SEquipQiLinCfg null|roleid=%d|key=%d|itemid=%d|strengthlevel=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(equipmentItem.getCfgId()), Integer.valueOf(curStrengthLevel + 1) });
/*     */       
/*     */ 
/* 177 */       ItemManager.logger.error(logstr);
/* 178 */       return false;
/*     */     }
/* 180 */     ret = checkClientData(equipmentItem, yuanBaoPrice, sQiLinAccumulateModeCfg);
/* 181 */     if (!ret)
/*     */     {
/* 183 */       return false;
/*     */     }
/* 185 */     TLogArg logArg = new TLogArg(LogReason.EQUIP_ACCUMULATION_QILIN_REM, equipmentItem.getCfgId());
/* 186 */     ret = isScoreRight(wearstate, equipmentItem, sQiLinAccumulateModeCfg, yuanBaoPrice, logArg);
/* 187 */     if (!ret)
/*     */     {
/* 189 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 193 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkClientData(EquipmentItem equipmentItem, int serverNeedYuanbao, SQiLinAccumulateModeCfg sQiLinAccumulateModeCfg)
/*     */   {
/* 205 */     if (this.itemNum <= 0)
/*     */     {
/* 207 */       return false;
/*     */     }
/* 209 */     if (this.clientNeedYuabao != serverNeedYuanbao)
/*     */     {
/* 211 */       ItemManager.sendWrongInfo(this.roleid, 1170, new String[] { String.valueOf(this.itemid) });
/* 212 */       String logstr = String.format("[item]PEquipQiLinUseYuanbaoReq.checkClientData@clientNeedYuabao is not same as server need yuanbao|roleid=%d|key=%d|itemid=%d|client_need_yuabao=%d|strength_level=%d|server_need_yuanbao=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(this.itemid), Integer.valueOf(this.clientNeedYuabao), Integer.valueOf(equipmentItem.getStrengthLevel()), Integer.valueOf(serverNeedYuanbao) });
/*     */       
/*     */ 
/* 215 */       ItemManager.logger.error(logstr);
/* 216 */       return false;
/*     */     }
/*     */     
/* 219 */     if (!sQiLinAccumulateModeCfg.itemid2MaxNum.containsKey(Integer.valueOf(this.itemid)))
/*     */     {
/* 221 */       String logstr = String.format("[item]PEquipQiLinUseYuanbaoReq.checkClientData@itemid error,SQiLinAccumulateModeCfg itemid2MaxNum not contain this itemid|roleid=%d|key=%d|itemid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(this.itemid) });
/*     */       
/*     */ 
/* 224 */       ItemManager.logger.error(logstr);
/* 225 */       return false;
/*     */     }
/* 227 */     if (!sQiLinAccumulateModeCfg.itemid2Point.containsKey(Integer.valueOf(this.itemid)))
/*     */     {
/* 229 */       String logstr = String.format("[item]PEquipQiLinUseYuanbaoReq.checkClientData@itemid error,SQiLinAccumulateModeCfg itemid2Point not contain this itemid|roleid=%d|key=%d|itemid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(this.itemid) });
/*     */       
/*     */ 
/* 232 */       ItemManager.logger.error(logstr);
/* 233 */       return false;
/*     */     }
/* 235 */     int maxNum = ((Integer)sQiLinAccumulateModeCfg.itemid2MaxNum.get(Integer.valueOf(this.itemid))).intValue();
/* 236 */     if (this.itemNum > maxNum)
/*     */     {
/* 238 */       ItemManager.sendWrongInfo(this.roleid, 1171, new String[] { String.valueOf(this.itemid) });
/*     */       
/* 240 */       String logstr = String.format("[item]PEquipQiLinUseYuanbaoReq.checkClientData@item can use num error|roleid=%d|key=%d|itemid=%d|num=%d|strengthLevel=%d|maxNum=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(this.itemid), Integer.valueOf(this.itemNum), Integer.valueOf(equipmentItem.getStrengthLevel()), Integer.valueOf(maxNum) });
/*     */       
/*     */ 
/* 243 */       ItemManager.logger.error(logstr);
/* 244 */       return false;
/*     */     }
/* 246 */     long yuanbaoBalance = QingfuInterface.getBalance(this.userid, true);
/* 247 */     if (this.clientYuanbao != yuanbaoBalance)
/*     */     {
/* 249 */       String logstr = String.format("[item]PEquipQiLinUseYuanbaoReq.checkQiLingLevel@client has yuanbao not same as server|roleid=%d|key=%d|itemid=%d|client_yuanbao=%d|server_yuanbao=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(this.itemid), Long.valueOf(this.clientYuanbao), Long.valueOf(yuanbaoBalance) });
/*     */       
/*     */ 
/* 252 */       ItemManager.logger.info(logstr);
/* 253 */       return false;
/*     */     }
/*     */     
/* 256 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   boolean isScoreRight(int wearState, EquipmentItem equipmentItem, SQiLinAccumulateModeCfg sQiLinAccumulateModeCfg, int yuanBaoPrice, TLogArg logArg)
/*     */   {
/* 262 */     String oldExtraString = equipmentItem.getAccumulationQiLinExtraString();
/* 263 */     int useCount = ItemManager.getQiLinItemUseCount(this.itemid, equipmentItem);
/* 264 */     if (useCount < 0)
/*     */     {
/* 266 */       String logstr = String.format("[item]PEquipQiLinUseYuanbaoReq.isScoreRight@itemid use count error|roleid=%d|key=%d|itemid=%d|use_count=%d|strength_level=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(this.itemid), Integer.valueOf(useCount), Integer.valueOf(equipmentItem.getStrengthLevel()) });
/*     */       
/*     */ 
/* 269 */       ItemManager.logger.error(logstr);
/* 270 */       return false;
/*     */     }
/* 272 */     int maxNum = ((Integer)sQiLinAccumulateModeCfg.itemid2MaxNum.get(Integer.valueOf(this.itemid))).intValue();
/*     */     
/* 274 */     int maxCanUseNum = maxNum - useCount;
/* 275 */     int realUesNum = 0;
/* 276 */     if (this.itemNum > maxCanUseNum)
/*     */     {
/* 278 */       realUesNum = maxCanUseNum;
/*     */       
/* 280 */       String logstr = String.format("[item]PEquipQiLinUseYuanbaoReq.isScoreRight@itemid use count exceed max|roleid=%d|key=%d|itemid=%d|use_count=%d|item_num=%d|strength_level=%d|maxnum=%d|maxCanUseNum=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(this.itemid), Integer.valueOf(useCount), Integer.valueOf(this.itemNum), Integer.valueOf(equipmentItem.getStrengthLevel()), Integer.valueOf(maxNum), Integer.valueOf(maxCanUseNum) });
/*     */       
/*     */ 
/* 283 */       ItemManager.logger.info(logstr);
/*     */     }
/*     */     else
/*     */     {
/* 287 */       realUesNum = this.itemNum;
/*     */     }
/* 289 */     int nextLevelNeedNum = ItemManager.computeQiLingLevelUpNeedItemNum(equipmentItem, sQiLinAccumulateModeCfg, this.itemid);
/* 290 */     if (nextLevelNeedNum <= 0)
/*     */     {
/* 292 */       String logstr = String.format("[item]PEquipQiLinUseYuanbaoReq.isScoreRight@need item num error|roleid=%d|key=%d|itemid=%d|use_count=%d|num=%d|strength_level=%d|maxnum=%d|maxCanUseNum=%d|next_level_need_num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(this.itemid), Integer.valueOf(useCount), Integer.valueOf(this.itemNum), Integer.valueOf(equipmentItem.getStrengthLevel()), Integer.valueOf(maxNum), Integer.valueOf(maxCanUseNum), Integer.valueOf(nextLevelNeedNum) });
/*     */       
/*     */ 
/*     */ 
/* 296 */       ItemManager.logger.info(logstr);
/* 297 */       return false;
/*     */     }
/* 299 */     realUesNum = Math.min(nextLevelNeedNum, realUesNum);
/*     */     
/* 301 */     int totalCostYuanbao = realUesNum * yuanBaoPrice;
/* 302 */     boolean r = QingfuInterface.costYuanbao(this.userid, this.roleid, totalCostYuanbao, CostType.COST_BIND_FIRST_QILIN_ACCUMULATION_MODE, logArg) == CostResult.Success;
/*     */     
/* 304 */     if (!r)
/*     */     {
/* 306 */       String logstr = String.format("[item]PEquipQiLinUseYuanbaoReq.isScoreRight@cost yuanbao error|roleid=%d|key=%d|itemid=%d|use_count=%d|strength_level=%d|costYuanbao=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(this.itemid), Integer.valueOf(useCount), Integer.valueOf(equipmentItem.getStrengthLevel()), Integer.valueOf(totalCostYuanbao) });
/*     */       
/*     */ 
/* 309 */       ItemManager.logger.error(logstr);
/* 310 */       return false;
/*     */     }
/* 312 */     equipmentItem.setState(1);
/* 313 */     int ret = ItemManager.addQiLinItemUseCount(this.itemid, equipmentItem, realUesNum);
/* 314 */     if (ret == -1)
/*     */     {
/* 316 */       String logstr = String.format("[item]PEquipQiLinUseYuanbaoReq.isScoreRight@add qilin item use count error|roleid=%d|key=%d|itemid=%d|use_count=%d|num=%d|strength_level=%d|maxnum=%d|real_use_num", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(this.itemid), Integer.valueOf(useCount), Integer.valueOf(this.itemNum), Integer.valueOf(equipmentItem.getStrengthLevel()), Integer.valueOf(maxNum), Integer.valueOf(realUesNum) });
/*     */       
/*     */ 
/* 319 */       ItemManager.logger.error(logstr);
/* 320 */       return false;
/*     */     }
/* 322 */     int totalPoint = ItemManager.getQiLinToalPoint(equipmentItem, sQiLinAccumulateModeCfg);
/* 323 */     int oldStrengthLevel = equipmentItem.getStrengthLevel();
/* 324 */     if (totalPoint >= sQiLinAccumulateModeCfg.needScore)
/*     */     {
/* 326 */       ItemManager.doStrength(this.roleid, wearState, this.bagid, equipmentItem, totalPoint - sQiLinAccumulateModeCfg.needScore);
/*     */     }
/* 328 */     ItemManager.tlogEquipqilinAccumulation(this.roleid, this.userid, oldStrengthLevel, equipmentItem, this.itemid, realUesNum, totalCostYuanbao, oldExtraString);
/*     */     
/* 330 */     ItemManager.sendSEquipQiLinAccumulateModeRes(this.roleid, equipmentItem);
/*     */     
/* 332 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PEquipQiLinUseYuanbaoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */