/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.gang.main.ModBangGongResult;
/*     */ import mzm.gsp.gang.main.ModBangGongResult.ErrorResult;
/*     */ import mzm.gsp.item.SUseMoneyBagItemRes;
/*     */ import mzm.gsp.item.confbean.MoneybagAwardCfg;
/*     */ import mzm.gsp.item.confbean.SMoneybagItem;
/*     */ import mzm.gsp.item.confbean.SUseAllItemCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.PresentResult;
/*     */ import mzm.gsp.qingfu.main.PresentType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.ModMoneyResult;
/*     */ import mzm.gsp.role.main.ModMoneyResult.ErrorResult;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.yuanbao.main.CurrencyType;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PUseMoneybagItem extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long uuid;
/*     */   private final boolean isUseAll;
/*     */   
/*     */   public PUseMoneybagItem(long roleid, long uuid, boolean isUseAll)
/*     */   {
/*  35 */     this.roleid = roleid;
/*  36 */     this.uuid = uuid;
/*  37 */     this.isUseAll = isUseAll;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  43 */     if (!ItemModuleSwitchInterface.isUseMoneyBagItemSwitchOpenForRole(this.roleid))
/*     */     {
/*  45 */       return false;
/*     */     }
/*  47 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*     */     {
/*  49 */       String logStr = String.format("[item]PUseMoneybagItem.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  50 */       ItemManager.logger.info(logStr);
/*  51 */       return false;
/*     */     }
/*  53 */     int serverlevel = ServerInterface.getCurrentServerLevel();
/*     */     
/*     */ 
/*  56 */     String userid = RoleInterface.getUserId(this.roleid);
/*  57 */     lock(Lockeys.get(User.getTable(), userid));
/*  58 */     BasicItem basicItem = ItemInterface.getItemByUuid(this.roleid, this.uuid);
/*  59 */     if ((basicItem == null) || (basicItem.getNumber() <= 0))
/*     */     {
/*  61 */       return false;
/*     */     }
/*  63 */     SMoneybagItem moneybagItem = SMoneybagItem.get(basicItem.getCfgId());
/*  64 */     if (moneybagItem == null)
/*     */     {
/*  66 */       return false;
/*     */     }
/*  68 */     if ((this.isUseAll) && (SUseAllItemCfg.get(moneybagItem.id) == null))
/*     */     {
/*  70 */       String logStr = String.format("[item]PUseMoneybagItem.processImp@item can not use all|roleid=%d|uuid=%d|itemid=%d|is_use_all=%b", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(basicItem.getCfgId()), Boolean.valueOf(this.isUseAll) });
/*     */       
/*     */ 
/*  73 */       ItemManager.logger.error(logStr);
/*  74 */       return false;
/*     */     }
/*  76 */     int key = serverlevel * 1000 + moneybagItem.currencytype;
/*  77 */     MoneybagAwardCfg moneybagAwardCfg = MoneybagAwardCfg.get(key);
/*  78 */     if (moneybagAwardCfg == null)
/*     */     {
/*  80 */       return false;
/*     */     }
/*  82 */     int singleAddNum = moneybagAwardCfg.num;
/*     */     
/*  84 */     int gridNum = basicItem.getNumber();
/*  85 */     int toatalItemNum = ItemInterface.getItemNumberById(this.roleid, moneybagItem.id);
/*  86 */     if (toatalItemNum < basicItem.getNumber())
/*     */     {
/*  88 */       return false;
/*     */     }
/*  90 */     int maxCanUsedNum = 1;
/*  91 */     if (this.isUseAll)
/*     */     {
/*  93 */       maxCanUsedNum = toatalItemNum;
/*     */     }
/*  95 */     int realUsedNum = 0;
/*  96 */     TLogArg logArg = new TLogArg(LogReason.ITEM_USE_Moneybag, basicItem.getCfgId());
/*     */     
/*  98 */     switch (moneybagItem.currencytype)
/*     */     {
/*     */ 
/*     */     case 2: 
/* 102 */       long hasGoldNum = RoleInterface.getGold(this.roleid);
/* 103 */       long canUseNUm = getCanUsedNum(2, hasGoldNum, singleAddNum);
/* 104 */       if (canUseNUm <= 0L)
/*     */       {
/* 106 */         String logStr = String.format("[item]PUseMoneybagItem.processImp@gold max can use num error|roleid=%d|uuid=%d|itemid=%d|is_use_all=%b|max_can_use_num=%d|can_use_num=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(basicItem.getCfgId()), Boolean.valueOf(this.isUseAll), Integer.valueOf(maxCanUsedNum), Long.valueOf(canUseNUm) });
/*     */         
/*     */ 
/* 109 */         ItemManager.logger.error(logStr);
/* 110 */         ItemManager.sendWrongInfo(this.roleid, 1102, new String[0]);
/* 111 */         return false;
/*     */       }
/*     */       
/* 114 */       realUsedNum = (int)Math.min(canUseNUm, maxCanUsedNum);
/* 115 */       long totalAddNum = realUsedNum * singleAddNum;
/* 116 */       logArg.addCurrencytype2num(CurrencyType.CURRENCY_GOLD, Integer.valueOf((int)totalAddNum));
/* 117 */       ModMoneyResult modGRes = RoleInterface.addGoldWithinMax(this.roleid, totalAddNum, logArg);
/* 118 */       if (!modGRes.isSucceed())
/*     */       {
/* 120 */         if (modGRes.getRes() == ModMoneyResult.ErrorResult.ERROR_MONEY_NUM_HAS_REACH_TOP_LIMIT)
/*     */         {
/* 122 */           ItemManager.sendWrongInfo(this.roleid, 1102, new String[0]);
/*     */         }
/* 124 */         String logStr = String.format("[item]PUseMoneybagItem.processImp@add gold error|roleid=%d|uuid=%d|itemid=%d|is_use_all=%b|max_can_use_num=%d|can_use_num=%d|real_use_num=%d|total_add_gold=%d|has_gold=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(basicItem.getCfgId()), Boolean.valueOf(this.isUseAll), Integer.valueOf(maxCanUsedNum), Long.valueOf(canUseNUm), Integer.valueOf(realUsedNum), Long.valueOf(totalAddNum), Long.valueOf(hasGoldNum) });
/*     */         
/*     */ 
/*     */ 
/* 128 */         ItemManager.logger.info(logStr);
/* 129 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */       break;
/*     */     case 3: 
/* 135 */       long hasSilverNum = RoleInterface.getSilver(this.roleid);
/* 136 */       long canUseNUm = getCanUsedNum(3, hasSilverNum, singleAddNum);
/* 137 */       if (canUseNUm <= 0L)
/*     */       {
/* 139 */         String logStr = String.format("[item]PUseMoneybagItem.processImp@silver max can use num error|roleid=%d|uuid=%d|itemid=%d|is_use_all=%b|max_can_use_num=%d|can_use_num=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(basicItem.getCfgId()), Boolean.valueOf(this.isUseAll), Integer.valueOf(maxCanUsedNum), Long.valueOf(canUseNUm) });
/*     */         
/*     */ 
/* 142 */         ItemManager.logger.error(logStr);
/* 143 */         ItemManager.sendWrongInfo(this.roleid, 1103, new String[0]);
/* 144 */         return false;
/*     */       }
/* 146 */       realUsedNum = (int)Math.min(canUseNUm, maxCanUsedNum);
/* 147 */       long totalAddNum = realUsedNum * singleAddNum;
/* 148 */       logArg.addCurrencytype2num(CurrencyType.CURRENCY_SILVE, Integer.valueOf((int)totalAddNum));
/* 149 */       ModMoneyResult modGRes = RoleInterface.addSilverWithinMax(this.roleid, totalAddNum, logArg);
/* 150 */       if (!modGRes.isSucceed())
/*     */       {
/* 152 */         if (modGRes.getRes() == ModMoneyResult.ErrorResult.ERROR_MONEY_NUM_HAS_REACH_TOP_LIMIT)
/*     */         {
/* 154 */           ItemManager.sendWrongInfo(this.roleid, 1103, new String[0]);
/*     */         }
/* 156 */         String logStr = String.format("[item]PUseMoneybagItem.processImp@add silver error|roleid=%d|uuid=%d|itemid=%d|is_use_all=%b|max_can_use_num=%d|can_use_num=%d|real_use_num=%d|total_add_silver=%d|has_silver=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(basicItem.getCfgId()), Boolean.valueOf(this.isUseAll), Integer.valueOf(maxCanUsedNum), Long.valueOf(canUseNUm), Integer.valueOf(realUsedNum), Long.valueOf(totalAddNum), Long.valueOf(hasSilverNum) });
/*     */         
/*     */ 
/*     */ 
/* 160 */         ItemManager.logger.info(logStr);
/* 161 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */       break;
/*     */     case 1: 
/* 168 */       logArg.addCurrencytype2num(CurrencyType.CURRENCY_AWARDYUANBAO, Integer.valueOf(singleAddNum));
/* 169 */       for (int i = 0; i < maxCanUsedNum; i++)
/*     */       {
/* 171 */         boolean ret = QingfuInterface.presentYuanbao(userid, this.roleid, singleAddNum, PresentType.PRSENT_BIND_USE_MONEY_BAG_ITEM, logArg) == PresentResult.Success;
/*     */         
/* 173 */         if (!ret) {
/*     */           break;
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 179 */         realUsedNum++;
/*     */       }
/*     */       
/* 182 */       logArg.addCurrencytype2num(CurrencyType.CURRENCY_AWARDYUANBAO, Integer.valueOf(realUsedNum * singleAddNum));
/*     */       
/* 184 */       break;
/*     */     
/*     */ 
/*     */     case 4: 
/* 188 */       long hasGangNum = GangInterface.getBangGong(this.roleid);
/* 189 */       long canUseNUm = getCanUsedNum(4, hasGangNum, singleAddNum);
/* 190 */       if (canUseNUm <= 0L)
/*     */       {
/* 192 */         String logStr = String.format("[item]PUseMoneybagItem.processImp@gang contribute max can use num error|roleid=%d|uuid=%d|itemid=%d|is_use_all=%b|max_can_use_num=%d|can_use_num=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(basicItem.getCfgId()), Boolean.valueOf(this.isUseAll), Integer.valueOf(maxCanUsedNum), Long.valueOf(canUseNUm) });
/*     */         
/*     */ 
/* 195 */         ItemManager.logger.error(logStr);
/* 196 */         return false;
/*     */       }
/* 198 */       realUsedNum = (int)Math.min(canUseNUm, maxCanUsedNum);
/* 199 */       long totalAddNum = realUsedNum * singleAddNum;
/* 200 */       logArg.addCurrencytype2num(CurrencyType.CURRENCY_GANG, Integer.valueOf((int)totalAddNum));
/* 201 */       ModBangGongResult s = GangInterface.addBangGongWithinMax(this.roleid, totalAddNum, logArg);
/* 202 */       if (!s.isSucceed())
/*     */       {
/* 204 */         if (s.getRes() == ModBangGongResult.ErrorResult.ERROR_BANGGONG_NUM_HAS_REACH_TOP_LIMIT)
/*     */         {
/* 206 */           ItemManager.sendWrongInfo(this.roleid, 1104, new String[0]);
/*     */         }
/* 208 */         String logStr = String.format("[item]PUseMoneybagItem.processImp@add gang contribute error|roleid=%d|uuid=%d|itemid=%d|is_use_all=%b|max_can_use_num=%d|can_use_num=%d|real_use_num=%d|total_add_gang=%d|has_gang=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(basicItem.getCfgId()), Boolean.valueOf(this.isUseAll), Integer.valueOf(maxCanUsedNum), Long.valueOf(canUseNUm), Integer.valueOf(realUsedNum), Long.valueOf(totalAddNum), Long.valueOf(hasGangNum) });
/*     */         
/*     */ 
/*     */ 
/* 212 */         ItemManager.logger.info(logStr);
/* 213 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */       break;
/*     */     default: 
/* 219 */       return false; }
/*     */     
/* 221 */     boolean ret = false;
/* 222 */     if (realUsedNum <= gridNum)
/*     */     {
/* 224 */       ret = ItemInterface.removeItemByUuid(this.roleid, this.uuid, realUsedNum, logArg);
/*     */     }
/*     */     else
/*     */     {
/* 228 */       ret = ItemInterface.removeItemByUuid(this.roleid, this.uuid, gridNum, logArg);
/* 229 */       if (ret)
/*     */       {
/* 231 */         ret = ItemInterface.removeItemById(this.roleid, moneybagItem.id, realUsedNum - gridNum, logArg);
/*     */       }
/*     */     }
/*     */     
/* 235 */     if (!ret)
/*     */     {
/* 237 */       String logStr = String.format("[item]PUseMoneybagItem.processImp@cut item error|roleid=%d|uuid=%d|itemid=%d|is_use_all=%b|max_can_use_num=%d|real_use_num=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(basicItem.getCfgId()), Boolean.valueOf(this.isUseAll), Integer.valueOf(maxCanUsedNum), Integer.valueOf(realUsedNum) });
/*     */       
/*     */ 
/* 240 */       ItemManager.logger.info(logStr);
/* 241 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 245 */     SUseMoneyBagItemRes res = new SUseMoneyBagItemRes();
/* 246 */     res.moneytype = moneybagItem.currencytype;
/* 247 */     res.num = (realUsedNum * singleAddNum);
/* 248 */     res.useditemnum = realUsedNum;
/* 249 */     OnlineManager.getInstance().send(this.roleid, res);
/*     */     
/* 251 */     String logStr = String.format("[item]PUseMoneybagItem.processImp@use money bag item success|roleid=%d|uuid=%d|itemid=%d|is_use_all=%b|max_can_use_num=%d|real_use_num=%d|total_add_money", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(basicItem.getCfgId()), Boolean.valueOf(this.isUseAll), Integer.valueOf(maxCanUsedNum), Integer.valueOf(realUsedNum), Integer.valueOf(res.num) });
/*     */     
/*     */ 
/* 254 */     ItemManager.logger.info(logStr);
/* 255 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   long getCanUsedNum(int moneyType, long hasNum, int singleAddNum)
/*     */   {
/* 261 */     long max = AwardInterface.getMoneyOwnMax(moneyType);
/* 262 */     if (max <= 0L)
/*     */     {
/* 264 */       return 0L;
/*     */     }
/* 266 */     long delta = max - hasNum;
/* 267 */     return delta / singleAddNum;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PUseMoneybagItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */