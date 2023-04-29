/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.fashiondress.main.FashionDressInterface;
/*     */ import mzm.gsp.item.CEquipQiLin;
/*     */ import mzm.gsp.item.SEquipQiLinRes;
/*     */ import mzm.gsp.item.confbean.EquipItemCfgConsts;
/*     */ import mzm.gsp.item.confbean.ItemCfgConsts;
/*     */ import mzm.gsp.item.confbean.SEquipQiLinCfg;
/*     */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*     */ import mzm.gsp.item.confbean.SQiLinItem;
/*     */ import mzm.gsp.item.confbean.StrengthLevel2SucRate;
/*     */ import mzm.gsp.item.event.EquipQiLin;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.skill.main.SkillInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Xdb;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PEquipQiLin
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int bagid;
/*     */   private final int key;
/*     */   private final int isuseyuanbao_qilingzhu;
/*     */   private final int isusezhenlingstone;
/*     */   private final int isuseyuanbao_zhenlingstone;
/*     */   private final int isuseluckystone;
/*     */   private final int luckystonenum;
/*     */   private final int isuseyuanbao_luckystone;
/*     */   private final int costTotalYuanbao;
/*     */   private final long clientSilverNum;
/*     */   private final int cliStrengthLevel;
/*  50 */   private String userid = null;
/*     */   
/*     */   public PEquipQiLin(long roleid, CEquipQiLin c)
/*     */   {
/*  54 */     this.roleid = roleid;
/*  55 */     this.bagid = c.bagid;
/*  56 */     this.key = c.key;
/*  57 */     this.isuseyuanbao_qilingzhu = c.isuseyuanbao_qilingzhu;
/*  58 */     this.isusezhenlingstone = c.isusezhenlingstone;
/*  59 */     this.isuseyuanbao_zhenlingstone = c.isuseyuanbao_zhenlingstone;
/*  60 */     this.isuseluckystone = c.isuseluckystone;
/*  61 */     this.luckystonenum = c.luckystonenum;
/*  62 */     this.isuseyuanbao_luckystone = c.isuseyuanbao_luckystone;
/*  63 */     this.costTotalYuanbao = c.costtotalyuanbao;
/*  64 */     this.clientSilverNum = c.clientsilvernum;
/*  65 */     this.cliStrengthLevel = c.clistrengthlevel;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  71 */     if (!ItemModuleSwitchInterface.isEquipQilinSwitchOpenForRole(this.roleid))
/*     */     {
/*  73 */       return false;
/*     */     }
/*  75 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*     */     {
/*  77 */       String logStr = String.format("[item]PEquipQiLin.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  78 */       ItemManager.logger.info(logStr);
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     if ((this.bagid != 340600000) && (this.bagid != 340600001))
/*     */     {
/*  84 */       ItemManager.sendWrongInfo(this.roleid, 400, new String[0]);
/*  85 */       String logstr = String.format("[item]PEquipQiLin.processImp@bagid error|roleid=%d|bagid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.bagid) });
/*  86 */       ItemManager.logger.error(logstr);
/*  87 */       return false;
/*     */     }
/*  89 */     int wearstate = -1;
/*     */     
/*  91 */     if (this.bagid == 340600000)
/*     */     {
/*  93 */       wearstate = -1;
/*     */     }
/*     */     else
/*     */     {
/*  97 */       wearstate = 1;
/*     */     }
/*     */     
/* 100 */     this.userid = RoleInterface.getUserId(this.roleid);
/* 101 */     lock(User.getTable(), Arrays.asList(new String[] { this.userid }));
/* 102 */     int userLevel = RoleInterface.getLevel(this.roleid);
/* 103 */     if (userLevel < EquipItemCfgConsts.getInstance().EQUIP_QILIN_OPEN_LEVEL)
/*     */     {
/* 105 */       String logstr = String.format("[item]PEquipQiLin.processImp@qilin level error|roleid=%d|level=%d|needlevel=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(userLevel), Integer.valueOf(EquipItemCfgConsts.getInstance().EQUIP_QILIN_OPEN_LEVEL) });
/*     */       
/* 107 */       ItemManager.logger.error(logstr);
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     RoleItemBag itemBag = ItemManager.getRoleItemBag(this.roleid);
/*     */     
/* 113 */     RoleItemBag equipBag = ItemManager.getBag(this.roleid, this.bagid);
/*     */     
/* 115 */     if ((itemBag == null) || (equipBag == null))
/*     */     {
/* 117 */       ItemManager.sendWrongInfo(this.roleid, 400, new String[0]);
/* 118 */       String logstr = String.format("[item]PEquipQiLin.processImp@bagid null|roleid=%d|bagid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.bagid) });
/* 119 */       ItemManager.logger.error(logstr);
/* 120 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 124 */     BasicItem basicItem = equipBag.get(this.key);
/* 125 */     if ((basicItem == null) || (!(basicItem instanceof EquipmentItem)))
/*     */     {
/* 127 */       ItemManager.sendWrongInfo(this.roleid, 401, new String[0]);
/* 128 */       int itemId = basicItem == null ? 0 : basicItem.getCfgId();
/* 129 */       String logstr = String.format("[item]PEquipQiLin.processImp@item key error,not equipment|roleid=%d|key=%d|itemid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(itemId) });
/*     */       
/*     */ 
/* 132 */       ItemManager.logger.error(logstr);
/* 133 */       return false;
/*     */     }
/*     */     
/* 136 */     EquipmentItem equipmentItem = (EquipmentItem)basicItem;
/*     */     
/*     */ 
/* 139 */     SItemEquipCfg itemEquipCfg = SItemEquipCfg.get(equipmentItem.getCfgId());
/* 140 */     if (itemEquipCfg == null)
/*     */     {
/* 142 */       String logstr = String.format("[item]PEquipQiLin.processImp@item cfg error,not equipment|roleid=%d|key=%d|itemid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(equipmentItem.getCfgId()) });
/*     */       
/*     */ 
/* 145 */       ItemManager.logger.error(logstr);
/* 146 */       ItemManager.sendWrongInfo(this.roleid, 402, new String[0]);
/* 147 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 151 */     if (itemEquipCfg.useLevel < EquipItemCfgConsts.getInstance().MIN_LEVEL_FOR_QILIN)
/*     */     {
/* 153 */       String logstr = String.format("[item]PEquipQiLin.processImp@equip level error|roleid=%d|key=%d|itemid=%d|equiplevel=%d|needlevel=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(equipmentItem.getCfgId()), Integer.valueOf(itemEquipCfg.useLevel), Integer.valueOf(EquipItemCfgConsts.getInstance().MIN_LEVEL_FOR_QILIN) });
/*     */       
/*     */ 
/*     */ 
/* 157 */       ItemManager.logger.error(logstr);
/* 158 */       ItemManager.sendWrongInfo(this.roleid, 409, new String[0]);
/* 159 */       return false;
/*     */     }
/*     */     
/* 162 */     if (!checkClientData(equipmentItem))
/*     */     {
/* 164 */       return false;
/*     */     }
/*     */     
/* 167 */     boolean r = doStrength(equipmentItem, itemBag, itemEquipCfg, wearstate);
/* 168 */     if (r)
/*     */     {
/* 170 */       String logstr = String.format("[item]PEquipQiLin.processImp@equip qilin success|roleid=%d|key=%d|itemid=%d|equiplevel=%d|afterstrengthlevel=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(equipmentItem.getCfgId()), Integer.valueOf(itemEquipCfg.useLevel), Integer.valueOf(equipmentItem.getStrengthLevel()) });
/*     */       
/*     */ 
/* 173 */       ItemManager.logger.info(logstr);
/*     */     }
/* 175 */     return r;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean doStrength(EquipmentItem equipmentItem, RoleItemBag itemBag, SItemEquipCfg equipCfg, int wearstate)
/*     */   {
/* 189 */     int curStrengthLevel = equipmentItem.getStrengthLevel();
/*     */     
/*     */ 
/* 192 */     SEquipQiLinCfg equipQiLingCfg = ItemConfigManager.getSEquipQiLin(equipCfg.qilinTypeid, curStrengthLevel + 1);
/* 193 */     if (equipQiLingCfg == null)
/*     */     {
/* 195 */       ItemManager.sendWrongInfo(this.roleid, 403, new String[0]);
/* 196 */       String logstr = String.format("[item]PEquipQiLin.doStrength@SEquipQiLinCfg null|roleid=%d|key=%d|itemid=%d|qilinTypeid=%d|strengthlevel=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(equipmentItem.getCfgId()), Integer.valueOf(equipCfg.qilinTypeid), Integer.valueOf(curStrengthLevel + 1) });
/*     */       
/*     */ 
/* 199 */       ItemManager.logger.error(logstr);
/* 200 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 205 */     boolean result = ItemManager.checkQiLingLevel(this.roleid, this.key, equipmentItem, equipCfg);
/* 206 */     if (!result)
/*     */     {
/* 208 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 214 */     boolean result = checkCurrencyAndItem(itemBag, equipQiLingCfg);
/* 215 */     if (!result)
/*     */     {
/* 217 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 221 */     TLogArg logArg = new TLogArg(LogReason.EQUIP_QILIN_REM);
/*     */     
/* 223 */     int initSuccessProb = equipQiLingCfg.sucRate;
/* 224 */     int baseProb = ItemCfgConsts.getInstance().ITEM_RANDOM_SEED;
/* 225 */     int successProb = initSuccessProb;
/*     */     
/*     */ 
/* 228 */     int addProp = SkillInterface.getQiLingAddRateWithSkills(FashionDressInterface.getFashionDressPassiveSkillMap(this.roleid, false));
/*     */     
/* 230 */     successProb += addProp;
/*     */     
/*     */ 
/* 233 */     int qilingScoreRate = 0;
/* 234 */     Integer qilingScore = equipmentItem.getExtra(ItemStoreEnum.QILING_SCORE);
/* 235 */     if (qilingScore != null)
/*     */     {
/* 237 */       qilingScoreRate = qilingScore.intValue() * equipQiLingCfg.score2rate;
/*     */     }
/* 239 */     successProb += qilingScoreRate;
/* 240 */     if (successProb > 10000)
/*     */     {
/* 242 */       successProb = 10000;
/*     */     }
/*     */     
/* 245 */     int hasLuckItemNum = 0;
/* 246 */     int deltaItemNum = 0;
/* 247 */     int luckyStoneCostYuanbao = 0;
/* 248 */     int luckItemId = EquipItemCfgConsts.getInstance().LUCKY_ITEM_ID;
/* 249 */     if (this.isuseluckystone > 0)
/*     */     {
/* 251 */       SQiLinItem qiLingItem = SQiLinItem.get(luckItemId);
/* 252 */       int deltaProb = baseProb - initSuccessProb;
/* 253 */       int singleLuckyItemSuccessRate = getLuckyItemSuccessRate(qiLingItem, curStrengthLevel + 1);
/* 254 */       if (singleLuckyItemSuccessRate < 0)
/*     */       {
/* 256 */         String logStr = String.format("[item]PEquipQiLin.doStrength@singleLuckyItemSuccessRate is below than zero|roleid=%d|bagid=%d|itemid=%d|grid=%d|use_luck_item_num=%d|is_use_zhenling_stone=%b|is_auto_use_yuanbao=%b|single_success_rate=%d|current_strength_level=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.bagid), Integer.valueOf(equipmentItem.getCfgId()), Integer.valueOf(this.key), Integer.valueOf(this.isuseluckystone), Integer.valueOf(this.isusezhenlingstone), Integer.valueOf(this.isuseyuanbao_zhenlingstone), Integer.valueOf(singleLuckyItemSuccessRate), Integer.valueOf(curStrengthLevel) });
/*     */         
/*     */ 
/*     */ 
/* 260 */         ItemManager.logger.error(logStr);
/* 261 */         return false;
/*     */       }
/* 263 */       if (deltaProb > 0)
/*     */       {
/*     */ 
/* 266 */         int needLuckItemMaxNum = (deltaProb - 1) / singleLuckyItemSuccessRate + 1;
/* 267 */         if ((needLuckItemMaxNum < this.luckystonenum) && (this.isuseyuanbao_luckystone == 0))
/*     */         {
/* 269 */           String logStr = String.format("[item]PEquipQiLin.doStrength@do not need lucky item|roleid=%d|bagid=%d|itemid=%d|grid=%d|use_luck_item_num=%d|is_use_zhenling_stone=%b|is_auto_use_yuanbao=%b|single_success_rate=%d|current_strength_level=%d|needLuckItemMaxNum=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.bagid), Integer.valueOf(equipmentItem.getCfgId()), Integer.valueOf(this.key), Integer.valueOf(this.isuseluckystone), Integer.valueOf(this.isusezhenlingstone), Integer.valueOf(this.isuseyuanbao_zhenlingstone), Integer.valueOf(singleLuckyItemSuccessRate), Integer.valueOf(curStrengthLevel), Integer.valueOf(needLuckItemMaxNum) });
/*     */           
/*     */ 
/*     */ 
/* 273 */           ItemManager.logger.info(logStr);
/* 274 */           return false;
/*     */         }
/*     */       }
/* 277 */       successProb += singleLuckyItemSuccessRate * this.luckystonenum;
/*     */       
/*     */ 
/* 280 */       hasLuckItemNum = itemBag.getItemNumberBycfgId(luckItemId);
/* 281 */       deltaItemNum = this.luckystonenum - hasLuckItemNum;
/* 282 */       if (deltaItemNum > 0)
/*     */       {
/* 284 */         if (this.isuseyuanbao_luckystone == 0)
/*     */         {
/* 286 */           ItemManager.sendWrongInfo(this.roleid, 405, new String[0]);
/* 287 */           return false;
/*     */         }
/* 289 */         int luckYuanbaoPrice = ItemInterface.getItemYuanBaoPrice(luckItemId);
/* 290 */         luckyStoneCostYuanbao = luckYuanbaoPrice * deltaItemNum;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 295 */     int hasQiLinZhuNum = itemBag.getItemNumberBycfgId(EquipItemCfgConsts.getInstance().QILIN_NEED_ITEM_ID);
/* 296 */     int needQinLinZhuNum = equipQiLingCfg.strengthItemNum - hasQiLinZhuNum;
/* 297 */     int qilingzhuCostYuanbao = 0;
/* 298 */     if (needQinLinZhuNum > 0)
/*     */     {
/* 300 */       if (this.isuseyuanbao_qilingzhu == 0)
/*     */       {
/* 302 */         ItemManager.sendWrongInfo(this.roleid, 405, new String[0]);
/* 303 */         return false;
/*     */       }
/* 305 */       int qilingzhuYuanbaoPrice = ItemInterface.getItemYuanBaoPrice(EquipItemCfgConsts.getInstance().QILIN_NEED_ITEM_ID);
/* 306 */       qilingzhuCostYuanbao = qilingzhuYuanbaoPrice * needQinLinZhuNum;
/*     */     }
/*     */     
/*     */ 
/* 310 */     int hasZhenLingShiNum = itemBag.getItemNumberBycfgId(EquipItemCfgConsts.getInstance().ZHENLIN_STONE_ITEM_ID);
/* 311 */     int needZhenLingShiNum = 0;
/* 312 */     if (this.isuseyuanbao_zhenlingstone == 1)
/*     */     {
/* 314 */       needZhenLingShiNum = equipQiLingCfg.zhenLinStonNum - hasZhenLingShiNum;
/*     */     }
/* 316 */     int zhenlingshiCostYuanbao = 0;
/* 317 */     if (needZhenLingShiNum > 0)
/*     */     {
/* 319 */       if (this.isuseyuanbao_zhenlingstone == 0)
/*     */       {
/* 321 */         ItemManager.sendWrongInfo(this.roleid, 405, new String[0]);
/* 322 */         return false;
/*     */       }
/* 324 */       int zhenglingshiYuanbaoPrice = ItemInterface.getItemYuanBaoPrice(EquipItemCfgConsts.getInstance().ZHENLIN_STONE_ITEM_ID);
/* 325 */       zhenlingshiCostYuanbao = zhenglingshiYuanbaoPrice * needZhenLingShiNum;
/*     */     }
/*     */     
/*     */ 
/* 329 */     if (this.costTotalYuanbao != luckyStoneCostYuanbao + qilingzhuCostYuanbao + zhenlingshiCostYuanbao)
/*     */     {
/* 331 */       ItemManager.sendWrongInfo(this.roleid, 404, new String[0]);
/*     */     }
/*     */     
/*     */ 
/* 335 */     if (hasLuckItemNum > 0)
/*     */     {
/* 337 */       int costItemNum = Math.min(hasLuckItemNum, this.luckystonenum);
/* 338 */       ItemOperateResult result = ItemInterface.removeItemsWithBindFirst(this.roleid, luckItemId, costItemNum, logArg);
/* 339 */       if (!result.success())
/*     */       {
/* 341 */         ItemManager.sendWrongInfo(this.roleid, 405, new String[0]);
/* 342 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 346 */     if (luckyStoneCostYuanbao > 0)
/*     */     {
/*     */ 
/* 349 */       if (QingfuInterface.costYuanbao(this.userid, this.roleid, luckyStoneCostYuanbao, CostType.COST_BIND_FIRST_ITEM_QUIP_QI_LING, logArg) != CostResult.Success)
/*     */       {
/*     */ 
/* 352 */         ItemManager.sendWrongInfo(this.roleid, 410, new String[0]);
/* 353 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 358 */     if (hasQiLinZhuNum > 0)
/*     */     {
/* 360 */       ItemOperateResult result = ItemInterface.removeItemsWithBindFirst(this.roleid, EquipItemCfgConsts.getInstance().QILIN_NEED_ITEM_ID, Math.min(equipQiLingCfg.strengthItemNum, hasQiLinZhuNum), logArg);
/*     */       
/*     */ 
/* 363 */       if (!result.success())
/*     */       {
/* 365 */         ItemManager.sendWrongInfo(this.roleid, 405, new String[0]);
/* 366 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 370 */     if (qilingzhuCostYuanbao > 0)
/*     */     {
/*     */ 
/* 373 */       if (QingfuInterface.costYuanbao(this.userid, this.roleid, qilingzhuCostYuanbao, CostType.COST_BIND_FIRST_ITEM_QUIP_QI_LING, logArg) != CostResult.Success)
/*     */       {
/*     */ 
/* 376 */         ItemManager.sendWrongInfo(this.roleid, 410, new String[0]);
/* 377 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 382 */     if ((hasZhenLingShiNum > 0) && (this.isusezhenlingstone == 1))
/*     */     {
/* 384 */       ItemOperateResult zhenlingshiResult = ItemInterface.removeItemsWithBindFirst(this.roleid, EquipItemCfgConsts.getInstance().ZHENLIN_STONE_ITEM_ID, Math.min(equipQiLingCfg.zhenLinStonNum, hasZhenLingShiNum), logArg);
/*     */       
/*     */ 
/* 387 */       if (!zhenlingshiResult.success())
/*     */       {
/* 389 */         ItemManager.sendWrongInfo(this.roleid, 406, new String[0]);
/* 390 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 394 */     if (zhenlingshiCostYuanbao > 0)
/*     */     {
/*     */ 
/* 397 */       if (QingfuInterface.costYuanbao(this.userid, this.roleid, zhenlingshiCostYuanbao, CostType.COST_BIND_FIRST_ITEM_QUIP_QI_LING, logArg) != CostResult.Success)
/*     */       {
/*     */ 
/* 400 */         ItemManager.sendWrongInfo(this.roleid, 410, new String[0]);
/* 401 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 407 */     boolean moneyResult = RoleInterface.cutSilver(this.roleid, equipQiLingCfg.strengthSilverNum, logArg);
/* 408 */     if (!moneyResult)
/*     */     {
/* 410 */       ItemManager.sendWrongInfo(this.roleid, 404, new String[0]);
/* 411 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 415 */     equipmentItem.setState(1);
/*     */     
/* 417 */     SEquipQiLinRes res = new SEquipQiLinRes();
/*     */     
/* 419 */     int prob = Xdb.random().nextInt(10000);
/*     */     
/* 421 */     if (prob < successProb)
/*     */     {
/* 423 */       res.issuccess = 1;
/*     */       
/*     */ 
/* 426 */       equipmentItem.setStrengthLevel(curStrengthLevel + 1);
/*     */       
/*     */ 
/* 429 */       ItemManager.sendQilinBulletin(this.roleid, equipmentItem);
/*     */       
/* 431 */       equipmentItem.setExtra(ItemStoreEnum.QILING_SCORE, 0);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 436 */       res.issuccess = 0;
/*     */       
/* 438 */       if ((this.isusezhenlingstone > 0) && (equipQiLingCfg.zhenLinStonNum > 0))
/*     */       {
/* 440 */         equipmentItem.setStrengthLevel(curStrengthLevel);
/*     */       }
/*     */       else
/*     */       {
/* 444 */         equipmentItem.setStrengthLevel(equipQiLingCfg.failStrengthLevel);
/*     */       }
/*     */       
/*     */ 
/* 448 */       Integer qiLingScore = equipmentItem.getExtra(ItemStoreEnum.QILING_SCORE);
/* 449 */       if (qiLingScore != null)
/*     */       {
/* 451 */         equipmentItem.setExtra(ItemStoreEnum.QILING_SCORE, qiLingScore.intValue() + equipQiLingCfg.fialGetScore);
/*     */       }
/*     */       else
/*     */       {
/* 455 */         equipmentItem.setExtra(ItemStoreEnum.QILING_SCORE, equipQiLingCfg.fialGetScore);
/*     */       }
/*     */     }
/* 458 */     equipmentItem.clearQilinAccumulationPoint();
/* 459 */     equipmentItem.setCanNotUseQiLinInitPoint();
/* 460 */     res.strengthlevel = equipmentItem.getStrengthLevel();
/* 461 */     if (!ItemManager.fillInItemInfoBean(res.iteminfo, equipmentItem.xItem))
/*     */     {
/* 463 */       String logStr = String.format("[item]PEquipQiLin.doStrength@not find item uuid|roleid=%d|bagid=%d|itemid=%d|grid=%d|use_luck_item_num=%d|is_use_zhenling_stone=%b|is_auto_use_yuanbao=%b", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.bagid), Integer.valueOf(equipmentItem.getCfgId()), Integer.valueOf(this.key), Integer.valueOf(this.isuseluckystone), Integer.valueOf(this.isusezhenlingstone), Integer.valueOf(this.isuseyuanbao_zhenlingstone) });
/*     */       
/*     */ 
/*     */ 
/* 467 */       ItemManager.logger.error(logStr);
/* 468 */       return false;
/*     */     }
/* 470 */     OnlineManager.getInstance().send(this.roleid, res);
/*     */     
/* 472 */     ItemManager.logEquip(this.roleid, equipmentItem.getCfgId(), EquipmentLogStatus.EQUIP_QILIN, Integer.valueOf(equipmentItem.getStrengthLevel()), new String[0]);
/*     */     
/* 474 */     ItemManager.tlogEquipqilin(this.roleid, equipmentItem.getCfgId(), equipmentItem.getStrengthLevel(), curStrengthLevel, wearstate, equipmentItem.getTlogUuid(), successProb, prob);
/*     */     
/*     */ 
/* 477 */     TriggerEventsManger.getInstance().triggerEvent(new EquipQiLin(), new EquipQiLinArg(this.roleid, this.bagid, ((Long)equipmentItem.getUuid().iterator().next()).longValue(), curStrengthLevel, equipmentItem.getStrengthLevel()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 482 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkCurrencyAndItem(RoleItemBag itemBag, SEquipQiLinCfg equpQiLingCfg)
/*     */   {
/* 495 */     if ((this.luckystonenum > 0) && (!equpQiLingCfg.canUseLuckStone))
/*     */     {
/* 497 */       String logstr = String.format("[item]PEquipQiLin.checkCurrencyAndItem@can not use luck item|roleid=%d|key=%d|useLuckItemNum=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(this.luckystonenum) });
/*     */       
/*     */ 
/* 500 */       ItemManager.logger.error(logstr);
/*     */       
/* 502 */       ItemManager.sendWrongInfo(this.roleid, 300, new String[0]);
/* 503 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 507 */     long hasSilverNum = RoleInterface.getSilver(this.roleid);
/* 508 */     if (hasSilverNum < equpQiLingCfg.strengthSilverNum)
/*     */     {
/* 510 */       ItemManager.sendWrongInfo(this.roleid, 404, new String[0]);
/* 511 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 515 */     if (equpQiLingCfg.strengthItemNum <= 0)
/*     */     {
/* 517 */       ItemManager.sendWrongInfo(this.roleid, 300, new String[0]);
/* 518 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 522 */     int hasQiLinItemNum = itemBag.getItemNumberBycfgId(EquipItemCfgConsts.getInstance().QILIN_NEED_ITEM_ID);
/* 523 */     if ((hasQiLinItemNum < equpQiLingCfg.strengthItemNum) && (this.isuseyuanbao_qilingzhu == 0))
/*     */     {
/* 525 */       String logstr = String.format("[item]PEquipQiLin.checkCurrencyAndItem@qilin need item not enough|roleid=%d|key=%d|hasItemNum=%d|needitemnum=%d|needitemid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(hasQiLinItemNum), Integer.valueOf(equpQiLingCfg.strengthItemNum), Integer.valueOf(EquipItemCfgConsts.getInstance().QILIN_NEED_ITEM_ID) });
/*     */       
/*     */ 
/*     */ 
/* 529 */       ItemManager.logger.error(logstr);
/* 530 */       ItemManager.sendWrongInfo(this.roleid, 405, new String[0]);
/* 531 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 535 */     if (this.isusezhenlingstone == 1)
/*     */     {
/* 537 */       if (equpQiLingCfg.zhenLinStonNum <= 0)
/*     */       {
/* 539 */         ItemManager.sendWrongInfo(this.roleid, 300, new String[0]);
/* 540 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 544 */       int hasQiLinSucItemNum = itemBag.getItemNumberBycfgId(EquipItemCfgConsts.getInstance().ZHENLIN_STONE_ITEM_ID);
/* 545 */       if ((hasQiLinSucItemNum < equpQiLingCfg.zhenLinStonNum) && (this.isuseyuanbao_zhenlingstone == 0))
/*     */       {
/* 547 */         String logstr = String.format("[item]PEquipQiLin.checkCurrencyAndItem@qilinStone need item not enough|roleid=%d|key=%d|hasItemNum=%d|needitemnum=%d|needitemid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(hasQiLinSucItemNum), Integer.valueOf(equpQiLingCfg.zhenLinStonNum), Integer.valueOf(EquipItemCfgConsts.getInstance().ZHENLIN_STONE_ITEM_ID) });
/*     */         
/*     */ 
/*     */ 
/* 551 */         ItemManager.logger.error(logstr);
/* 552 */         ItemManager.sendWrongInfo(this.roleid, 406, new String[0]);
/* 553 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 557 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkClientData(EquipmentItem equipmentItem)
/*     */   {
/* 567 */     if (this.cliStrengthLevel != equipmentItem.getStrengthLevel())
/*     */     {
/* 569 */       String logstr = String.format("[item]PEquipQiLin.checkClientData@equip strength level error|roleid=%d|key=%d|itemid=%d|strengthlevel=%d|clientstrlevel=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(equipmentItem.getCfgId()), Integer.valueOf(equipmentItem.getStrengthLevel()), Integer.valueOf(this.cliStrengthLevel) });
/*     */       
/*     */ 
/* 572 */       ItemManager.logger.error(logstr);
/* 573 */       return false;
/*     */     }
/*     */     
/* 576 */     long hasSivelr = RoleInterface.getSilver(this.roleid);
/* 577 */     if (this.clientSilverNum != hasSivelr)
/*     */     {
/* 579 */       String logstr = String.format("[item]PEquipQiLin.checkClientData@silver error|roleid=%d|key=%d|itemid=%d|hassilver=%d|clientsilver=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(equipmentItem.getCfgId()), Long.valueOf(hasSivelr), Long.valueOf(this.clientSilverNum) });
/*     */       
/*     */ 
/* 582 */       ItemManager.logger.error(logstr);
/* 583 */       return false;
/*     */     }
/*     */     
/* 586 */     return true;
/*     */   }
/*     */   
/*     */   private int getLuckyItemSuccessRate(SQiLinItem sQiLinItem, int strengthLevel)
/*     */   {
/* 591 */     for (int i = sQiLinItem.level2Rate.size() - 1; i >= 0; i--)
/*     */     {
/* 593 */       if (strengthLevel >= ((StrengthLevel2SucRate)sQiLinItem.level2Rate.get(i)).strengthLevel)
/*     */       {
/* 595 */         return ((StrengthLevel2SucRate)sQiLinItem.level2Rate.get(i)).sucRate;
/*     */       }
/*     */     }
/* 598 */     return -1;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PEquipQiLin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */