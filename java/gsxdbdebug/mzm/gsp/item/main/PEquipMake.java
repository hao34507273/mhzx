/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.item.ItemInfo;
/*     */ import mzm.gsp.item.SEquipMakeRes;
/*     */ import mzm.gsp.item.SEquipMakeYunanbaoPriceRes;
/*     */ import mzm.gsp.item.confbean.DesItemId2Rate;
/*     */ import mzm.gsp.item.confbean.EquipItemCfgConsts;
/*     */ import mzm.gsp.item.confbean.ItemCfgConsts;
/*     */ import mzm.gsp.item.confbean.NeedItemId2Num;
/*     */ import mzm.gsp.item.confbean.SEquipMakeCfg;
/*     */ import mzm.gsp.item.confbean.SEquipMakeItemCfg;
/*     */ import mzm.gsp.item.confbean.SEquipMaterialItem;
/*     */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*     */ import mzm.gsp.item.event.EquipMake;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Equipstate;
/*     */ import xbean.Item;
/*     */ import xbean.Pod;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Xdb;
/*     */ import xtable.Role2equipstate;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PEquipMake
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private int eqpid;
/*     */   private int eqpmakecfgid;
/*     */   private int isuseyuanbao;
/*     */   private int clientneedyuanbao;
/*     */   private long clientsilvernum;
/*     */   private Map<Integer, Integer> itemid2nummap;
/*     */   
/*     */   public PEquipMake(long roleid, int eqpid, int eqpmakecfgid, int isusegold, long clientsilvernum, Map<Integer, Integer> itemid2nummap, int clientneedyuanbao)
/*     */   {
/*  59 */     this.roleid = roleid;
/*  60 */     this.eqpid = eqpid;
/*  61 */     this.eqpmakecfgid = eqpmakecfgid;
/*  62 */     this.isuseyuanbao = isusegold;
/*  63 */     this.clientsilvernum = clientsilvernum;
/*  64 */     this.itemid2nummap = itemid2nummap;
/*  65 */     this.clientneedyuanbao = clientneedyuanbao;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  71 */     if (!ItemModuleSwitchInterface.isEquipMakeSwitchOpenForRole(this.roleid))
/*     */     {
/*  73 */       return false;
/*     */     }
/*  75 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*     */     {
/*  77 */       String logStr = String.format("[item]PEquipMake.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  78 */       ItemManager.logger.info(logStr);
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     String userid = RoleInterface.getUserId(this.roleid);
/*  83 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*  85 */     TLogArg logArg = new TLogArg(LogReason.EQUIP_MAKE, this.eqpmakecfgid);
/*  86 */     if (!checkClientData())
/*     */     {
/*  88 */       return false;
/*     */     }
/*  90 */     if (this.clientneedyuanbao < 0)
/*     */     {
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     SEquipMakeCfg sEquipMakeCfg = SEquipMakeCfg.get(this.eqpmakecfgid);
/*  96 */     if (sEquipMakeCfg == null)
/*     */     {
/*  98 */       String logstr = String.format("[item]PEquipMake.processImp@SEquipMakeCfg null|roleid=%d|eqpmakecfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.eqpmakecfgid) });
/*     */       
/* 100 */       ItemManager.logger.error(logstr);
/*     */     }
/* 102 */     if (sEquipMakeCfg.eqpId != this.eqpid)
/*     */     {
/* 104 */       String logstr = String.format("[item]PEquipMake.processImp@SEquipMakeCfg eqpId error|roleid=%d|eqpip=%d|seqpid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.eqpid), Integer.valueOf(sEquipMakeCfg.eqpId) });
/*     */       
/* 106 */       ItemManager.logger.error(logstr);
/* 107 */       ItemManager.sendWrongInfo(this.roleid, 491, new String[0]);
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     SItemEquipCfg itemEquipCfg = SItemEquipCfg.get(this.eqpid);
/* 112 */     if (itemEquipCfg == null)
/*     */     {
/* 114 */       ItemManager.sendWrongInfo(this.roleid, 492, new String[0]);
/*     */       
/* 116 */       String logstr = String.format("[item]PEquipMake.processImp@SItemEquipCfg null|roleid=%d|eqpip=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.eqpid) });
/*     */       
/* 118 */       ItemManager.logger.error(logstr);
/*     */       
/* 120 */       return false;
/*     */     }
/* 122 */     if ((itemEquipCfg.useLevel >= EquipItemCfgConsts.getInstance().N_LEVEL_EQUIP_MAKE_SWITCH) && (!ItemModuleSwitchInterface.isNLevelEquipMakeSwitchOpenForRole(this.roleid)))
/*     */     {
/* 124 */       String logstr = String.format("[item]PEquipMake.processImp@level switch is closed|roleid=%d|itemid=%d|level=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(itemEquipCfg.id), Integer.valueOf(itemEquipCfg.useLevel) });
/*     */       
/*     */ 
/* 127 */       ItemManager.logger.error(logstr);
/* 128 */       return false;
/*     */     }
/*     */     
/* 131 */     SEquipMakeItemCfg sEquipMakeItemCfg = SEquipMakeItemCfg.get(sEquipMakeCfg.makeCfgId);
/* 132 */     if (sEquipMakeItemCfg == null)
/*     */     {
/* 134 */       ItemManager.sendWrongInfo(this.roleid, 493, new String[0]);
/*     */       
/* 136 */       String logstr = String.format("[item]PEquipMake.processImp@SEquipMakeItemCfg null|roleid=%d|makeCfgId=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(sEquipMakeCfg.makeCfgId) });
/*     */       
/* 138 */       ItemManager.logger.error(logstr);
/* 139 */       return false;
/*     */     }
/*     */     
/* 142 */     int userLevel = RoleInterface.getLevel(this.roleid);
/* 143 */     if (userLevel < EquipItemCfgConsts.getInstance().EQUIP_MAKE_MIN_LEVEL)
/*     */     {
/* 145 */       String logstr = String.format("[item]PEquipMake.processImp@rolelevel error|roleid=%d|rolelevel=%d|openfunlevel=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(userLevel), Integer.valueOf(EquipItemCfgConsts.getInstance().EQUIP_MAKE_MIN_LEVEL) });
/*     */       
/* 147 */       ItemManager.logger.error(logstr);
/* 148 */       return false;
/*     */     }
/*     */     
/* 151 */     if (userLevel < EquipItemCfgConsts.getInstance().EQUIP_MAKE_OPEN_LEVEL)
/*     */     {
/*     */ 
/* 154 */       String logstr = String.format("[item]PEquipMake.processImp@rolelevel error|roleid=%d|rolelevel=%d|openlevel=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(userLevel), Integer.valueOf(EquipItemCfgConsts.getInstance().EQUIP_MAKE_OPEN_LEVEL) });
/*     */       
/* 156 */       ItemManager.logger.error(logstr);
/* 157 */       return false;
/*     */     }
/* 159 */     if (userLevel + EquipItemCfgConsts.getInstance().MAX_DELTA_OF_EQUIP_LEVEL_TO_ROLE_LEVEL < itemEquipCfg.useLevel)
/*     */     {
/* 161 */       ItemManager.sendWrongInfo(this.roleid, 494, new String[0]);
/* 162 */       String logstr = String.format("[item]PEquipMake.processImp@equiplevel error|roleid=%d|rolelevel=%d|equiplevel=%d|deltalevel=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(userLevel), Integer.valueOf(itemEquipCfg.useLevel), Integer.valueOf(EquipItemCfgConsts.getInstance().MAX_DELTA_OF_EQUIP_LEVEL_TO_ROLE_LEVEL) });
/*     */       
/*     */ 
/* 165 */       ItemManager.logger.error(logstr);
/*     */       
/* 167 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 171 */     int userOcp = RoleInterface.getOccupationId(this.roleid);
/* 172 */     if ((itemEquipCfg.menpai != 0) && (userOcp != itemEquipCfg.menpai))
/*     */     {
/* 174 */       ItemManager.sendWrongInfo(this.roleid, 495, new String[0]);
/*     */       
/* 176 */       String logstr = String.format("[item]PEquipMake.processImp@role ocp error|roleid=%d|userOcp=%d|equipocp=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(userOcp), Integer.valueOf(itemEquipCfg.menpai) });
/*     */       
/* 178 */       ItemManager.logger.error(logstr);
/*     */       
/* 180 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 184 */     int sex = RoleInterface.getGender(this.roleid);
/* 185 */     if ((itemEquipCfg.sex != 0) && (sex != itemEquipCfg.sex))
/*     */     {
/* 187 */       ItemManager.sendWrongInfo(this.roleid, 496, new String[0]);
/*     */       
/* 189 */       String logstr = String.format("[item]PEquipMake.processImp@role sex error|roleid=%d|rolesex=%d|equipsex=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(sex), Integer.valueOf(itemEquipCfg.sex) });
/*     */       
/* 191 */       ItemManager.logger.error(logstr);
/* 192 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 196 */     long hasgold = RoleInterface.getGold(this.roleid);
/* 197 */     if (hasgold < sEquipMakeItemCfg.goldNum)
/*     */     {
/* 199 */       String logstr = String.format("[item]PEquipMake.processImp@gold not enough|roleid=%d|hasgold=%d|needgold=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(hasgold), Integer.valueOf(sEquipMakeItemCfg.goldNum) });
/*     */       
/* 201 */       ItemManager.logger.error(logstr);
/*     */     }
/* 203 */     long hassilver = RoleInterface.getSilver(this.roleid);
/* 204 */     if (hassilver < sEquipMakeItemCfg.silverNum)
/*     */     {
/* 206 */       String logstr = String.format("[item]PEquipMake.processImp@silver not enough|roleid=%d|hassilver=%d|needgold=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(hassilver), Integer.valueOf(sEquipMakeItemCfg.silverNum) });
/*     */       
/* 208 */       ItemManager.logger.error(logstr);
/*     */     }
/* 210 */     long hasvigor = RoleInterface.getVigor(this.roleid);
/* 211 */     if (hasvigor < sEquipMakeItemCfg.vigorNum)
/*     */     {
/* 213 */       String logstr = String.format("[item]PEquipMake.processImp@vigor not enough|roleid=%d|hasvigor=%d|needgold=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(hasvigor), Integer.valueOf(sEquipMakeItemCfg.vigorNum) });
/*     */       
/* 215 */       ItemManager.logger.error(logstr);
/*     */     }
/*     */     
/*     */ 
/* 219 */     Map<Integer, List<Integer>> id2ids = new HashMap();
/* 220 */     Map<Integer, Integer> itemDelta = computeItemDelta(sEquipMakeItemCfg, id2ids);
/*     */     
/*     */ 
/* 223 */     if ((itemDelta.size() > 0) && (this.isuseyuanbao == 0))
/*     */     {
/* 225 */       String logstr = String.format("[item]PEquipMake.processImp@item not enough|roleid=%d|isuseyuanbao=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.isuseyuanbao) });
/*     */       
/* 227 */       ItemManager.logger.error(logstr);
/*     */       
/* 229 */       ItemManager.sendWrongInfo(this.roleid, 497, new String[0]);
/* 230 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 234 */     int totalNeedYuanBao = 0;
/* 235 */     for (Iterator i$ = itemDelta.keySet().iterator(); i$.hasNext();) { int itemId = ((Integer)i$.next()).intValue();
/*     */       
/* 237 */       totalNeedYuanBao += ItemInterface.getItemYuanBaoPrice(itemId) * ((Integer)itemDelta.get(Integer.valueOf(itemId))).intValue();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 242 */     boolean ret = RoleInterface.cutGold(this.roleid, sEquipMakeItemCfg.goldNum, logArg);
/* 243 */     if (!ret)
/*     */     {
/* 245 */       ItemManager.sendWrongInfo(this.roleid, 497, new String[0]);
/* 246 */       return false;
/*     */     }
/* 248 */     ret = RoleInterface.cutSilver(this.roleid, sEquipMakeItemCfg.silverNum, logArg);
/* 249 */     if (!ret)
/*     */     {
/* 251 */       ItemManager.sendWrongInfo(this.roleid, 497, new String[0]);
/* 252 */       return false;
/*     */     }
/* 254 */     ret = RoleInterface.cutVigor(this.roleid, sEquipMakeItemCfg.vigorNum, logArg);
/* 255 */     if (!ret)
/*     */     {
/* 257 */       ItemManager.sendWrongInfo(this.roleid, 497, new String[0]);
/* 258 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 262 */     if (totalNeedYuanBao > 0)
/*     */     {
/*     */ 
/* 265 */       if (Math.abs(totalNeedYuanBao - this.clientneedyuanbao) >= EquipItemCfgConsts.getInstance().EQUIP_MAKE_YUANBAO_PRICE_DELTA)
/*     */       {
/* 267 */         SEquipMakeYunanbaoPriceRes rs = new SEquipMakeYunanbaoPriceRes();
/* 268 */         rs.clientneedyuanbao = this.clientneedyuanbao;
/* 269 */         rs.serverneedyuanbao = totalNeedYuanBao;
/* 270 */         rs.eqpid = this.eqpid;
/* 271 */         OnlineManager.getInstance().sendAtOnce(this.roleid, rs);
/*     */         
/* 273 */         String logstr = String.format("[item]PEquipMake.processImp@yuanbao not same|roleid=%d|totalNeedYuanBao=%d|clientneedyuanbao=%d|delta=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(totalNeedYuanBao), Integer.valueOf(this.clientneedyuanbao), Integer.valueOf(EquipItemCfgConsts.getInstance().EQUIP_MAKE_YUANBAO_PRICE_DELTA) });
/*     */         
/*     */ 
/*     */ 
/* 277 */         ItemManager.logger.info(logstr);
/*     */         
/* 279 */         return false;
/*     */       }
/* 281 */       ret = QingfuInterface.costYuanbao(userid, this.roleid, totalNeedYuanBao, CostType.COST_BIND_FIRST_ITEM_QUIP_MAKE, logArg) == CostResult.Success;
/*     */       
/* 283 */       if (!ret)
/*     */       {
/* 285 */         ItemManager.sendWrongInfo(this.roleid, 498, new String[0]);
/* 286 */         String logstr = String.format("PEquipMake.processImp@cost yuanbao error|roleid=%d|totalNeedYuanBao=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(totalNeedYuanBao) });
/*     */         
/* 288 */         ItemManager.logger.info(logstr);
/*     */         
/* 290 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 296 */     for (NeedItemId2Num needItemId2Num : sEquipMakeItemCfg.needItemList)
/*     */     {
/* 298 */       int totalnum = needItemId2Num.itemNum;
/* 299 */       if (totalnum > 0)
/*     */       {
/*     */ 
/*     */ 
/* 303 */         int itemId = needItemId2Num.itemId;
/* 304 */         List<Integer> hasItemIds = (List)id2ids.get(Integer.valueOf(itemId));
/* 305 */         for (int i = 0; i < hasItemIds.size(); i++)
/*     */         {
/* 307 */           int num = ItemInterface.getItemNumberById(this.roleid, ((Integer)hasItemIds.get(i)).intValue());
/* 308 */           num = Math.min(totalnum, num);
/* 309 */           ItemInterface.removeItemsWithBindFirst(this.roleid, ((Integer)hasItemIds.get(i)).intValue(), num, logArg);
/* 310 */           totalnum -= num;
/* 311 */           if (totalnum <= 0) {
/*     */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 318 */     Equipstate xEquipstate = getXEquipState();
/*     */     
/*     */ 
/* 321 */     RandomResult randomResult = generateEqupId(sEquipMakeItemCfg, xEquipstate, itemEquipCfg.useLevel);
/* 322 */     int desEqpId = randomResult.getDesItemId();
/* 323 */     List<Item> xItems = ItemManager.createXItem(desEqpId, 1, null, false);
/* 324 */     if (xItems.size() != 1)
/*     */     {
/* 326 */       String logstr = String.format("[item]PEquipMake.processImp@bag full|roleid=%d|deseqpId=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(desEqpId) });
/* 327 */       ItemManager.logger.error(logstr);
/* 328 */       return false;
/*     */     }
/*     */     
/* 331 */     boolean isRandomSkillOpen = isEquipRandomSkillSwitchOpenForRole();
/* 332 */     Item xItem = (Item)xItems.get(0);
/* 333 */     if (randomResult.isNeedWithSkill())
/*     */     {
/* 335 */       if ((isRandomSkillOpen) && (!ItemManager.isWithSkill(xItem)))
/*     */       {
/* 337 */         ItemManager.randomEquipSkill(xItem);
/*     */       }
/* 339 */       setNoSkillCount(xEquipstate, 0);
/*     */ 
/*     */ 
/*     */     }
/* 343 */     else if (ItemManager.isWithSkill(xItem))
/*     */     {
/* 345 */       setNoSkillCount(xEquipstate, 0);
/*     */ 
/*     */ 
/*     */     }
/* 349 */     else if ((isRandomSkillOpen) && (ItemInterface.getColor(desEqpId) == 5))
/*     */     {
/* 351 */       addNoSkillCount(xEquipstate, 1);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 356 */     Integer noskillcount = (Integer)xEquipstate.getEqpid2makecount().get(Integer.valueOf(this.eqpid));
/* 357 */     int skillid = ItemManager.getSkillId(xItem);
/* 358 */     ItemOperateResult result = ItemInterface.addItem(this.roleid, xItems, logArg);
/* 359 */     if (result.isBagFull())
/*     */     {
/* 361 */       ItemManager.sendWrongInfo(this.roleid, 490, new String[0]);
/* 362 */       String logstr = String.format("[item]PEquipMake.processImp@bag full|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/* 363 */       ItemManager.logger.info(logstr);
/*     */       
/* 365 */       return false;
/*     */     }
/* 367 */     if (!result.success())
/*     */     {
/* 369 */       ItemManager.sendWrongInfo(this.roleid, 499, new String[0]);
/* 370 */       String logstr = String.format("[item]PEquipMake.processImp@unknown error|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/* 371 */       ItemManager.logger.error(logstr);
/* 372 */       return false;
/*     */     }
/*     */     
/* 375 */     ItemManager.logEquip(this.roleid, desEqpId, EquipmentLogStatus.EQUIP_MAKE, null, new String[0]);
/* 376 */     ItemManager.tlogEquipmake(this.roleid, desEqpId, totalNeedYuanBao, new BasicItem((Item)xItems.get(0)).getTlogUuid(), skillid, this.eqpid, noskillcount == null ? 0 : noskillcount.intValue());
/*     */     
/*     */ 
/* 379 */     boolean res = sendEquipMakeResult(result, desEqpId);
/* 380 */     TriggerEventsManger.getInstance().triggerEvent(new EquipMake(), new EquipMakeArg(this.roleid, desEqpId, 340600000));
/* 381 */     if (res)
/*     */     {
/* 383 */       String logstr = String.format("[item]PEquipMake.processImp@equip make success|roleid=%d|eqpid=%d|deseqpid=%d|color=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.eqpid), Integer.valueOf(desEqpId), Integer.valueOf(ItemInterface.getColor(desEqpId)) });
/*     */       
/*     */ 
/* 386 */       ItemManager.logger.info(logstr);
/*     */     }
/*     */     
/* 389 */     return res;
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
/*     */ 
/*     */   private boolean sendEquipMakeResult(ItemOperateResult result, int desEqpId)
/*     */   {
/* 404 */     if (!result.success())
/*     */     {
/* 406 */       ItemManager.sendWrongInfo(this.roleid, 499, new String[0]);
/* 407 */       return false;
/*     */     }
/* 409 */     int key = ((ItemOperateResult.ChangeItemInfo)result.getChangeItemInfoList().get(0)).grid;
/* 410 */     RoleItemBag eqpBag = ItemManager.getBag(this.roleid, 340600000);
/* 411 */     BasicItem item = eqpBag.get(key);
/* 412 */     if ((item == null) || (desEqpId != item.getCfgId()))
/*     */     {
/* 414 */       ItemManager.sendWrongInfo(this.roleid, 499, new String[0]);
/* 415 */       return false;
/*     */     }
/*     */     
/* 418 */     ItemInfo itemInfo = new ItemInfo();
/* 419 */     if (!ItemManager.fillInItemInfoBean(itemInfo, item.getItem()))
/*     */     {
/* 421 */       String logStr = String.format("[item]PEquipMake.sendEquipMakeResult@not find item uuid|roleid=%d|itemid=%d|grid=%d|eqpid=%d|eqp_make_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(item.getCfgId()), Integer.valueOf(key), Integer.valueOf(this.eqpid), Integer.valueOf(this.eqpmakecfgid) });
/*     */       
/*     */ 
/* 424 */       ItemManager.logger.error(logStr);
/* 425 */       return false;
/*     */     }
/* 427 */     SEquipMakeRes equipMake = new SEquipMakeRes();
/* 428 */     equipMake.key = key;
/* 429 */     equipMake.eqpinfo = itemInfo;
/* 430 */     OnlineManager.getInstance().sendAtOnce(this.roleid, equipMake);
/* 431 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private Equipstate getXEquipState()
/*     */   {
/* 437 */     Equipstate xEquipstate = Role2equipstate.get(Long.valueOf(this.roleid));
/* 438 */     if (xEquipstate == null)
/*     */     {
/* 440 */       xEquipstate = Pod.newEquipstate();
/* 441 */       Role2equipstate.insert(Long.valueOf(this.roleid), xEquipstate);
/*     */     }
/* 443 */     return xEquipstate;
/*     */   }
/*     */   
/*     */   private void setNoSkillCount(Equipstate xEquipstate, int count)
/*     */   {
/* 448 */     xEquipstate.getEqpid2makecount().put(Integer.valueOf(this.eqpid), Integer.valueOf(count));
/*     */   }
/*     */   
/*     */   private int addNoSkillCount(Equipstate xEquipstate, int count)
/*     */   {
/* 453 */     Integer c = (Integer)xEquipstate.getEqpid2makecount().get(Integer.valueOf(this.eqpid));
/* 454 */     if (c == null)
/*     */     {
/* 456 */       c = Integer.valueOf(0);
/*     */     }
/* 458 */     xEquipstate.getEqpid2makecount().put(Integer.valueOf(this.eqpid), Integer.valueOf(count + c.intValue()));
/* 459 */     return count + c.intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private RandomResult generateEqupId(SEquipMakeItemCfg sEquipMakeItemCfg, Equipstate xEquipstate, int useLevel)
/*     */   {
/* 470 */     RandomResult r = new RandomResult(-1, false);
/*     */     
/* 472 */     int desEqpId = ((DesItemId2Rate)sEquipMakeItemCfg.desItemList.get(0)).itemId;
/*     */     
/* 474 */     Integer count = (Integer)xEquipstate.getLevel2makecount().get(Integer.valueOf(useLevel));
/* 475 */     if (count == null)
/*     */     {
/* 477 */       count = Integer.valueOf(0);
/*     */     }
/* 479 */     Integer noskillcount = (Integer)xEquipstate.getEqpid2makecount().get(Integer.valueOf(this.eqpid));
/* 480 */     if (noskillcount == null)
/*     */     {
/* 482 */       noskillcount = Integer.valueOf(0);
/*     */     }
/* 484 */     if (count.intValue() >= EquipItemCfgConsts.getInstance().MIN_EQUIP_MAKE_COUNT_FOR_OUTPUT_ORANGE_EQUIP)
/*     */     {
/* 486 */       xEquipstate.getLevel2makecount().put(Integer.valueOf(useLevel), Integer.valueOf(0));
/* 487 */       int itemId = getOrangeEquipItemId(sEquipMakeItemCfg);
/* 488 */       if (itemId != -1)
/*     */       {
/* 490 */         r.setDesItemId(itemId);
/*     */       }
/*     */       else
/*     */       {
/* 494 */         r.setDesItemId(desEqpId);
/*     */       }
/*     */       
/* 497 */       if ((ItemInterface.getColor(r.getDesItemId()) == 5) && (noskillcount.intValue() >= EquipItemCfgConsts.getInstance().MIN_COUNT_FOR_OUTPUT_ORANGE_EQUIP_SKILL))
/*     */       {
/*     */ 
/* 500 */         r.setNeedWithSkill(true);
/*     */       }
/*     */       
/* 503 */       return r;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 510 */     int sum = 0;
/*     */     
/* 512 */     int randNum = Xdb.random().nextInt(ItemCfgConsts.getInstance().ITEM_RANDOM_SEED);
/* 513 */     for (DesItemId2Rate desItemId2Rate : sEquipMakeItemCfg.desItemList)
/*     */     {
/* 515 */       sum += desItemId2Rate.itemRate;
/* 516 */       if (randNum < sum)
/*     */       {
/* 518 */         desEqpId = desItemId2Rate.itemId;
/* 519 */         r.setDesItemId(desEqpId);
/* 520 */         break;
/*     */       }
/*     */     }
/* 523 */     if (ItemInterface.getColor(desEqpId) == 5)
/*     */     {
/* 525 */       xEquipstate.getLevel2makecount().put(Integer.valueOf(useLevel), Integer.valueOf(0));
/* 526 */       if (noskillcount.intValue() >= EquipItemCfgConsts.getInstance().MIN_COUNT_FOR_OUTPUT_ORANGE_EQUIP_SKILL)
/*     */       {
/* 528 */         r.setNeedWithSkill(true);
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 533 */       xEquipstate.getLevel2makecount().put(Integer.valueOf(useLevel), Integer.valueOf(count.intValue() + 1));
/*     */     }
/* 535 */     return r;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getOrangeEquipItemId(SEquipMakeItemCfg sEquipMakeItemCfg)
/*     */   {
/* 543 */     for (DesItemId2Rate desItemId2Rate : sEquipMakeItemCfg.desItemList)
/*     */     {
/* 545 */       if (ItemInterface.getColor(desItemId2Rate.itemId) == 5)
/*     */       {
/* 547 */         return desItemId2Rate.itemId;
/*     */       }
/*     */     }
/* 550 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkClientData()
/*     */   {
/* 561 */     if (this.clientsilvernum != RoleInterface.getSilver(this.roleid))
/*     */     {
/* 563 */       return false;
/*     */     }
/* 565 */     for (Iterator i$ = this.itemid2nummap.keySet().iterator(); i$.hasNext();) { int itemId = ((Integer)i$.next()).intValue();
/*     */       
/* 567 */       if (((Integer)this.itemid2nummap.get(Integer.valueOf(itemId))).intValue() != ItemInterface.getItemNumberById(this.roleid, 340600000, itemId, false))
/*     */       {
/* 569 */         return false;
/*     */       }
/*     */     }
/* 572 */     return true;
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
/*     */   private Map<Integer, Integer> computeItemDelta(SEquipMakeItemCfg sEquipMakeItemCfg, Map<Integer, List<Integer>> id2ids)
/*     */   {
/* 586 */     Map<Integer, Integer> itemDelta = new HashMap();
/*     */     
/* 588 */     for (NeedItemId2Num needItemId2Num : sEquipMakeItemCfg.needItemList)
/*     */     {
/* 590 */       int needItemNum = needItemId2Num.itemNum;
/* 591 */       if (needItemNum > 0)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 596 */         SEquipMaterialItem equipMaterialItem = SEquipMaterialItem.get(needItemId2Num.itemId);
/* 597 */         id2ids.put(Integer.valueOf(needItemId2Num.itemId), new ArrayList());
/* 598 */         List<Integer> ids = new ArrayList();
/* 599 */         if (equipMaterialItem.materialType == 2)
/*     */         {
/*     */ 
/* 602 */           ids = ItemConfigManager.getEquipMaterialItem(equipMaterialItem.level, 2, equipMaterialItem.wearpos);
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 607 */           ids.add(Integer.valueOf(needItemId2Num.itemId));
/*     */         }
/*     */         
/* 610 */         int userHasItemNum = 0;
/* 611 */         for (Integer i : ids)
/*     */         {
/* 613 */           int itemnum = ItemInterface.getItemNumberById(this.roleid, 340600000, i.intValue(), true);
/* 614 */           if (itemnum > 0)
/*     */           {
/*     */ 
/*     */ 
/* 618 */             userHasItemNum += itemnum;
/* 619 */             ((List)id2ids.get(Integer.valueOf(needItemId2Num.itemId))).add(i);
/* 620 */             if (userHasItemNum >= needItemNum) {
/*     */               break;
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 626 */         if (userHasItemNum < needItemNum)
/*     */         {
/* 628 */           itemDelta.put(Integer.valueOf(needItemId2Num.itemId), Integer.valueOf(needItemNum - userHasItemNum)); }
/*     */       }
/*     */     }
/* 631 */     return itemDelta;
/*     */   }
/*     */   
/*     */   private static class RandomResult
/*     */   {
/*     */     private int desItemId;
/* 637 */     private boolean needWithSkill = false;
/*     */     
/*     */     public RandomResult(int desItemId, boolean needWithSkill)
/*     */     {
/* 641 */       this.desItemId = desItemId;
/* 642 */       this.needWithSkill = needWithSkill;
/*     */     }
/*     */     
/*     */     public int getDesItemId()
/*     */     {
/* 647 */       return this.desItemId;
/*     */     }
/*     */     
/*     */     public void setDesItemId(int desItemId)
/*     */     {
/* 652 */       this.desItemId = desItemId;
/*     */     }
/*     */     
/*     */     public boolean isNeedWithSkill()
/*     */     {
/* 657 */       return this.needWithSkill;
/*     */     }
/*     */     
/*     */     public void setNeedWithSkill(boolean needWithSkill)
/*     */     {
/* 662 */       this.needWithSkill = needWithSkill;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   boolean isEquipRandomSkillSwitchOpenForRole()
/*     */   {
/* 669 */     if (!OpenInterface.getOpenStatus(191))
/*     */     {
/* 671 */       return false;
/*     */     }
/* 673 */     if (OpenInterface.isBanPlay(this.roleid, 191))
/*     */     {
/* 675 */       return false;
/*     */     }
/* 677 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PEquipMake.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */