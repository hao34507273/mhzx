/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import mzm.gsp.item.confbean.EquipItemCfgConsts;
/*     */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*     */ import mzm.gsp.item.confbean.SQiLinAccumulateModeCfg;
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
/*     */ public class PEquipQiLinUseItemReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int bagid;
/*     */   private final int key;
/*     */   private final int itemid;
/*     */   private final int num;
/*     */   private String userid;
/*     */   
/*     */   public PEquipQiLinUseItemReq(long roleid, int bagid, int key, int itemid, int num)
/*     */   {
/*  30 */     this.roleid = roleid;
/*  31 */     this.bagid = bagid;
/*  32 */     this.key = key;
/*  33 */     this.itemid = itemid;
/*  34 */     this.num = num;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if (!ItemModuleSwitchInterface.isQilinAccumulationModeSwitchOpenForRole(this.roleid))
/*     */     {
/*  42 */       return false;
/*     */     }
/*  44 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*     */     {
/*  46 */       String logStr = String.format("[item]PEquipQiLinUseItemReq.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*  48 */       ItemManager.logger.info(logStr);
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     if ((this.bagid != 340600000) && (this.bagid != 340600001))
/*     */     {
/*  54 */       ItemManager.sendWrongInfo(this.roleid, 400, new String[0]);
/*  55 */       String logstr = String.format("[item]PEquipQiLinUseItemReq.processImp@bagid error|roleid=%d|bagid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.bagid) });
/*     */       
/*  57 */       ItemManager.logger.error(logstr);
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     int wearstate = -1;
/*     */     
/*  63 */     if (this.bagid == 340600000)
/*     */     {
/*  65 */       wearstate = -1;
/*     */     }
/*     */     else
/*     */     {
/*  69 */       wearstate = 1;
/*     */     }
/*     */     
/*  72 */     this.userid = RoleInterface.getUserId(this.roleid);
/*  73 */     lock(User.getTable(), Arrays.asList(new String[] { this.userid }));
/*  74 */     int userLevel = RoleInterface.getLevel(this.roleid);
/*  75 */     if (userLevel < EquipItemCfgConsts.getInstance().EQUIP_QILIN_OPEN_LEVEL)
/*     */     {
/*  77 */       String logstr = String.format("[item]PEquipQiLinUseItemReq.processImp@qilin level error|roleid=%d|level=%d|needlevel=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(userLevel), Integer.valueOf(EquipItemCfgConsts.getInstance().EQUIP_QILIN_OPEN_LEVEL) });
/*     */       
/*     */ 
/*  80 */       ItemManager.logger.error(logstr);
/*  81 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  85 */     RoleItemBag itemBag = ItemManager.getRoleItemBag(this.roleid);
/*     */     
/*  87 */     RoleItemBag equipBag = ItemManager.getBag(this.roleid, this.bagid);
/*     */     
/*  89 */     if ((itemBag == null) || (equipBag == null))
/*     */     {
/*  91 */       ItemManager.sendWrongInfo(this.roleid, 400, new String[0]);
/*  92 */       String logstr = String.format("[item]PEquipQiLinUseItemReq.processImp@bagid null|roleid=%d|bagid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.bagid) });
/*     */       
/*  94 */       ItemManager.logger.error(logstr);
/*  95 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  99 */     BasicItem basicItem = equipBag.get(this.key);
/* 100 */     if ((basicItem == null) || (!(basicItem instanceof EquipmentItem)))
/*     */     {
/* 102 */       ItemManager.sendWrongInfo(this.roleid, 401, new String[0]);
/* 103 */       int itemId = basicItem == null ? 0 : basicItem.getCfgId();
/* 104 */       String logstr = String.format("[item]PEquipQiLinUseItemReq.processImp@item key error,not equipment|roleid=%d|key=%d|itemid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(itemId) });
/*     */       
/*     */ 
/* 107 */       ItemManager.logger.error(logstr);
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     EquipmentItem equipmentItem = (EquipmentItem)basicItem;
/*     */     
/*     */ 
/* 114 */     SItemEquipCfg itemEquipCfg = SItemEquipCfg.get(equipmentItem.getCfgId());
/* 115 */     if (itemEquipCfg == null)
/*     */     {
/* 117 */       String logstr = String.format("[item]PEquipQiLinUseItemReq.processImp@item cfg error,not equipment|roleid=%d|key=%d|itemid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(equipmentItem.getCfgId()) });
/*     */       
/*     */ 
/* 120 */       ItemManager.logger.error(logstr);
/* 121 */       ItemManager.sendWrongInfo(this.roleid, 402, new String[0]);
/* 122 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 126 */     if (itemEquipCfg.useLevel < EquipItemCfgConsts.getInstance().MIN_LEVEL_FOR_QILIN)
/*     */     {
/* 128 */       String logstr = String.format("[item]PEquipQiLinUseItemReq.processImp@equip level error|roleid=%d|key=%d|itemid=%d|equiplevel=%d|needlevel=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(equipmentItem.getCfgId()), Integer.valueOf(itemEquipCfg.useLevel), Integer.valueOf(EquipItemCfgConsts.getInstance().MIN_LEVEL_FOR_QILIN) });
/*     */       
/*     */ 
/*     */ 
/* 132 */       ItemManager.logger.error(logstr);
/* 133 */       ItemManager.sendWrongInfo(this.roleid, 409, new String[0]);
/* 134 */       return false;
/*     */     }
/* 136 */     boolean ret = ItemManager.checkQiLingLevel(this.roleid, this.key, equipmentItem, itemEquipCfg);
/* 137 */     if (!ret)
/*     */     {
/* 139 */       return false;
/*     */     }
/* 141 */     int curStrengthLevel = equipmentItem.getStrengthLevel();
/*     */     
/*     */ 
/* 144 */     SQiLinAccumulateModeCfg sQiLinAccumulateModeCfg = SQiLinAccumulateModeCfg.get(curStrengthLevel + 1);
/* 145 */     if (sQiLinAccumulateModeCfg == null)
/*     */     {
/* 147 */       ItemManager.sendWrongInfo(this.roleid, 403, new String[0]);
/* 148 */       String logstr = String.format("[item]PEquipQiLinUseItemReq.doStrength@SEquipQiLinCfg null|roleid=%d|key=%d|itemid=%d|strengthlevel=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(equipmentItem.getCfgId()), Integer.valueOf(curStrengthLevel + 1) });
/*     */       
/*     */ 
/* 151 */       ItemManager.logger.error(logstr);
/* 152 */       return false;
/*     */     }
/* 154 */     ret = checkClientData(equipmentItem, sQiLinAccumulateModeCfg);
/* 155 */     if (!ret)
/*     */     {
/* 157 */       return false;
/*     */     }
/* 159 */     TLogArg logArg = new TLogArg(LogReason.EQUIP_ACCUMULATION_QILIN_REM, equipmentItem.getCfgId());
/* 160 */     ret = isScoreRight(wearstate, equipmentItem, sQiLinAccumulateModeCfg, logArg);
/* 161 */     if (!ret)
/*     */     {
/* 163 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 167 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkClientData(EquipmentItem equipmentItem, SQiLinAccumulateModeCfg sQiLinAccumulateModeCfg)
/*     */   {
/* 179 */     if (this.num <= 0)
/*     */     {
/* 181 */       return false;
/*     */     }
/* 183 */     if (!sQiLinAccumulateModeCfg.itemid2MaxNum.containsKey(Integer.valueOf(this.itemid)))
/*     */     {
/* 185 */       String logstr = String.format("[item]PEquipQiLinUseItemReq.checkClientData@itemid error,SQiLinAccumulateModeCfg itemid2MaxNum not contain this itemid|roleid=%d|key=%d|itemid=%d|num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(this.itemid), Integer.valueOf(this.num) });
/*     */       
/*     */ 
/* 188 */       ItemManager.logger.error(logstr);
/* 189 */       return false;
/*     */     }
/* 191 */     if (!sQiLinAccumulateModeCfg.itemid2Point.containsKey(Integer.valueOf(this.itemid)))
/*     */     {
/* 193 */       String logstr = String.format("[item]PEquipQiLinUseItemReq.checkClientData@itemid error,SQiLinAccumulateModeCfg itemid2Point not contain this itemid|roleid=%d|key=%d|itemid=%d|num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(this.itemid), Integer.valueOf(this.num) });
/*     */       
/*     */ 
/* 196 */       ItemManager.logger.error(logstr);
/* 197 */       return false;
/*     */     }
/* 199 */     int maxNum = ((Integer)sQiLinAccumulateModeCfg.itemid2MaxNum.get(Integer.valueOf(this.itemid))).intValue();
/* 200 */     if (this.num > maxNum)
/*     */     {
/* 202 */       ItemManager.sendWrongInfo(this.roleid, 1171, new String[] { String.valueOf(this.itemid) });
/*     */       
/* 204 */       String logstr = String.format("[item]PEquipQiLinUseItemReq.checkClientData@item can use num error|roleid=%d|key=%d|itemid=%d|num=%d|strengthLevel=%d|maxNum=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(this.itemid), Integer.valueOf(this.num), Integer.valueOf(equipmentItem.getStrengthLevel()), Integer.valueOf(maxNum) });
/*     */       
/*     */ 
/* 207 */       ItemManager.logger.error(logstr);
/* 208 */       return false;
/*     */     }
/*     */     
/* 211 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   boolean isScoreRight(int wearState, EquipmentItem equipmentItem, SQiLinAccumulateModeCfg sQiLinAccumulateModeCfg, TLogArg logArg)
/*     */   {
/* 217 */     String oldExtraString = equipmentItem.getAccumulationQiLinExtraString();
/* 218 */     int useCount = ItemManager.getQiLinItemUseCount(this.itemid, equipmentItem);
/* 219 */     if (useCount < 0)
/*     */     {
/* 221 */       String logstr = String.format("[item]PEquipQiLinUseItemReq.isScoreRight@itemid use count error|roleid=%d|key=%d|itemid=%d|use_count=%d|strength_level=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(this.itemid), Integer.valueOf(useCount), Integer.valueOf(equipmentItem.getStrengthLevel()) });
/*     */       
/*     */ 
/* 224 */       ItemManager.logger.error(logstr);
/* 225 */       return false;
/*     */     }
/*     */     
/* 228 */     int maxNum = ((Integer)sQiLinAccumulateModeCfg.itemid2MaxNum.get(Integer.valueOf(this.itemid))).intValue();
/* 229 */     int maxCanUseNum = maxNum - useCount;
/* 230 */     int realUesNum = 0;
/* 231 */     if (this.num > maxCanUseNum)
/*     */     {
/* 233 */       realUesNum = maxCanUseNum;
/*     */       
/* 235 */       String logstr = String.format("[item]PEquipQiLinUseItemReq.isScoreRight@itemid use count exceed max|roleid=%d|key=%d|itemid=%d|use_count=%d|num=%d|strength_level=%d|maxnum=%d|maxCanUseNum=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(this.itemid), Integer.valueOf(useCount), Integer.valueOf(this.num), Integer.valueOf(equipmentItem.getStrengthLevel()), Integer.valueOf(maxNum), Integer.valueOf(maxCanUseNum) });
/*     */       
/*     */ 
/* 238 */       ItemManager.logger.info(logstr);
/*     */     }
/*     */     else
/*     */     {
/* 242 */       realUesNum = this.num;
/*     */     }
/* 244 */     int nextLevelNeedNum = ItemManager.computeQiLingLevelUpNeedItemNum(equipmentItem, sQiLinAccumulateModeCfg, this.itemid);
/* 245 */     if (nextLevelNeedNum <= 0)
/*     */     {
/* 247 */       String logstr = String.format("[item]PEquipQiLinUseItemReq.isScoreRight@need item num error|roleid=%d|key=%d|itemid=%d|use_count=%d|num=%d|strength_level=%d|maxnum=%d|maxCanUseNum=%d|next_level_need_num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(this.itemid), Integer.valueOf(useCount), Integer.valueOf(this.num), Integer.valueOf(equipmentItem.getStrengthLevel()), Integer.valueOf(maxNum), Integer.valueOf(maxCanUseNum), Integer.valueOf(nextLevelNeedNum) });
/*     */       
/*     */ 
/*     */ 
/* 251 */       ItemManager.logger.info(logstr);
/* 252 */       return false;
/*     */     }
/* 254 */     realUesNum = Math.min(nextLevelNeedNum, realUesNum);
/* 255 */     int totalHasNum = ItemInterface.getItemNumberById(this.roleid, this.itemid);
/* 256 */     realUesNum = Math.min(realUesNum, totalHasNum);
/* 257 */     ItemOperateResult result = ItemInterface.removeItemsWithBindFirst(this.roleid, this.itemid, realUesNum, logArg);
/* 258 */     if (!result.success())
/*     */     {
/* 260 */       String logstr = String.format("[item]PEquipQiLinUseItemReq.isScoreRight@cut item error|roleid=%d|key=%d|itemid=%d|use_count=%d|num=%d|strength_level=%d|maxnum=%d|cutnum=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(this.itemid), Integer.valueOf(useCount), Integer.valueOf(this.num), Integer.valueOf(equipmentItem.getStrengthLevel()), Integer.valueOf(maxNum), Integer.valueOf(realUesNum) });
/*     */       
/*     */ 
/* 263 */       ItemManager.logger.error(logstr);
/* 264 */       return false;
/*     */     }
/* 266 */     equipmentItem.setState(1);
/* 267 */     int ret = ItemManager.addQiLinItemUseCount(this.itemid, equipmentItem, realUesNum);
/* 268 */     if (ret == -1)
/*     */     {
/* 270 */       String logstr = String.format("[item]PEquipQiLinUseItemReq.isScoreRight@add qilin item use count error|roleid=%d|key=%d|itemid=%d|use_count=%d|num=%d|strength_level=%d|maxnum=%d|real_use_num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(this.itemid), Integer.valueOf(useCount), Integer.valueOf(this.num), Integer.valueOf(equipmentItem.getStrengthLevel()), Integer.valueOf(maxNum), Integer.valueOf(realUesNum) });
/*     */       
/*     */ 
/* 273 */       ItemManager.logger.error(logstr);
/* 274 */       return false;
/*     */     }
/* 276 */     int totalPoint = ItemManager.getQiLinToalPoint(equipmentItem, sQiLinAccumulateModeCfg);
/* 277 */     int oldStrengthLevel = equipmentItem.getStrengthLevel();
/* 278 */     if (totalPoint >= sQiLinAccumulateModeCfg.needScore)
/*     */     {
/* 280 */       ItemManager.doStrength(this.roleid, wearState, this.bagid, equipmentItem, totalPoint - sQiLinAccumulateModeCfg.needScore);
/*     */     }
/* 282 */     ItemManager.tlogEquipqilinAccumulation(this.roleid, this.userid, oldStrengthLevel, equipmentItem, this.itemid, realUesNum, 0, oldExtraString);
/*     */     
/* 284 */     ItemManager.sendSEquipQiLinAccumulateModeRes(this.roleid, equipmentItem);
/*     */     
/* 286 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PEquipQiLinUseItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */