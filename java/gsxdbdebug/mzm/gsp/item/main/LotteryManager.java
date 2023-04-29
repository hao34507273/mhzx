/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.gang.main.ModBangGongResult;
/*     */ import mzm.gsp.item.confbean.ItemCfgConsts;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.main.Pet;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.qingfu.main.PresentResult;
/*     */ import mzm.gsp.qingfu.main.PresentType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.ModMoneyResult;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.Pair;
/*     */ import mzm.gsp.xiulian.main.XiuLianSkillInterface;
/*     */ import xbean.Lottery;
/*     */ import xbean.LotteryResult;
/*     */ import xbean.Pod;
/*     */ import xio.Protocol;
/*     */ import xtable.Role2lottery;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LotteryManager
/*     */ {
/*     */   public static final int LOTTRY_TYPE_USE_BAOTU_ITEM = 0;
/*     */   public static final int LOTTRY_TYPE_USE_LOTTERY_ITEM = 1;
/*     */   public static final int LOTTRY_TYPE_OFFER_AWARD = 2;
/*     */   public static final int LOTTRY_TYPE_FUBEN = 3;
/*     */   public static final int LOTTRY_TYPE_QYXT = 4;
/*     */   public static final int LOTTRY_TYPE_MI_BAO = 5;
/*     */   public static final int LOTTRY_TYPE_LUCKY_BAG = 6;
/*     */   public static final int LOTTRY_TYPE_PAY_NEW_YEAR = 7;
/*     */   public static final int LOTTRY_TYPE_ROMANTIC_DANCE = 8;
/*     */   public static final int LOTTRY_TYPE_SIGN_PRECIOUS = 9;
/*     */   public static final int LOTTRY_TYPE_AXE_ACTIVITY = 10;
/*     */   public static final int LOTTRY_TYPE_XIAO_HUI_KUAI_PAO_INNER_DRAW = 11;
/*     */   public static final int LOTTRY_TYPE_XIAO_HUI_KUAI_PAO_OUTER_DRAW = 12;
/*     */   public static final int LOTTRY_TYPE_CHANGE_MODEL_CARD_DRAW = 13;
/*     */   public static final int LOTTRY_TYPE_PET_MARK_DRAW = 14;
/*     */   public static final int LOTTERY_TYPE_DRAW_CARNIVAL = 15;
/*     */   public static final int RESULT_GOLD_KEY = 0;
/*     */   public static final int RESULT_SILVER_KEY = 1;
/*     */   public static final int RESULT_YUANBAO_KEY = 2;
/*     */   public static final int RESULT_BANGGONG_KEY = 3;
/*     */   public static final int RESULT_PETEXP_KEY = 4;
/*     */   public static final int RESULT_ROLEEXP_KEY = 5;
/*     */   public static final int RESULT_XIULIANEXP_KEY = 6;
/*     */   public static final int RESULT_CONTROLLER_KEY = 7;
/*     */   
/*     */   public static boolean canAdd(long roleid, int lotterytype)
/*     */   {
/*  79 */     Lottery lottery = Role2lottery.get(Long.valueOf(roleid));
/*  80 */     if (lottery == null)
/*     */     {
/*  82 */       return true;
/*     */     }
/*  84 */     if (lottery.getLottery().containsKey(Integer.valueOf(lotterytype)))
/*     */     {
/*  86 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  90 */     return true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean addLottery(long roleid, int lotterytype, int useditemid, AwardPoolResultData resultData, TLogArg logArg)
/*     */   {
/* 111 */     return addLottery(roleid, lotterytype, useditemid, resultData, logArg, ItemCfgConsts.getInstance().LOTTERY_DELAY_INTERVAL);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean addLottery(long roleid, int lotterytype, int useditemid, AwardPoolResultData resultData, TLogArg logArg, int time)
/*     */   {
/* 131 */     return addLottery(roleid, lotterytype, useditemid, Arrays.asList(new AwardPoolResultData[] { resultData }), logArg, time);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean addLottery(long roleid, int lotterytype, int useditemid, List<AwardPoolResultData> resultDatas, TLogArg logArg, int time)
/*     */   {
/* 150 */     Map<Integer, Integer> resultinfo = new HashMap();
/* 151 */     fillResult(resultinfo, resultDatas);
/* 152 */     Lottery lottery = Role2lottery.get(Long.valueOf(roleid));
/* 153 */     if (lottery == null)
/*     */     {
/* 155 */       lottery = Pod.newLottery();
/* 156 */       Role2lottery.insert(Long.valueOf(roleid), lottery);
/*     */     }
/* 158 */     if (lottery.getLottery().containsKey(Integer.valueOf(lotterytype)))
/*     */     {
/* 160 */       return false;
/*     */     }
/*     */     
/* 163 */     LotteryResult result = Pod.newLotteryResult();
/* 164 */     result.setLotterytype(lotterytype);
/* 165 */     result.getMap().putAll(resultinfo);
/* 166 */     result.setUseditemid(useditemid);
/* 167 */     result.setLogreason(logArg.getLogReason().value);
/* 168 */     result.setSubreason(logArg.getSubReason());
/* 169 */     Session session = new LotteryObserver(time, roleid, lotterytype);
/* 170 */     result.setSessionid(session.getSessionId());
/*     */     
/* 172 */     lottery.getLottery().put(Integer.valueOf(lotterytype), result);
/* 173 */     return true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean addLottery(long roleid, int lotterytype, int useditemid, Map<Integer, Integer> itemid2num, TLogArg logArg)
/*     */   {
/* 191 */     Map<Integer, Integer> resultinfo = new HashMap();
/* 192 */     fillItem(resultinfo, itemid2num);
/* 193 */     Lottery lottery = Role2lottery.get(Long.valueOf(roleid));
/* 194 */     if (lottery == null)
/*     */     {
/* 196 */       lottery = Pod.newLottery();
/* 197 */       Role2lottery.insert(Long.valueOf(roleid), lottery);
/*     */     }
/* 199 */     if (lottery.getLottery().containsKey(Integer.valueOf(lotterytype)))
/*     */     {
/* 201 */       return false;
/*     */     }
/*     */     
/* 204 */     LotteryResult result = Pod.newLotteryResult();
/* 205 */     result.setLotterytype(lotterytype);
/* 206 */     result.getMap().putAll(resultinfo);
/* 207 */     result.setUseditemid(useditemid);
/* 208 */     result.setLogreason(logArg.getLogReason().value);
/* 209 */     result.setSubreason(logArg.getSubReason());
/* 210 */     Session session = new LotteryObserver(ItemCfgConsts.getInstance().LOTTERY_DELAY_INTERVAL, roleid, lotterytype);
/* 211 */     result.setSessionid(session.getSessionId());
/*     */     
/* 213 */     lottery.getLottery().put(Integer.valueOf(lotterytype), result);
/* 214 */     return true;
/*     */   }
/*     */   
/*     */   static Lottery getLottery(long roleid)
/*     */   {
/* 219 */     Lottery lottery = Role2lottery.select(Long.valueOf(roleid));
/* 220 */     return lottery;
/*     */   }
/*     */   
/*     */   public static LotteryResult removeLottery(long roleid, int lotterytype)
/*     */   {
/* 225 */     Lottery lottery = Role2lottery.get(Long.valueOf(roleid));
/* 226 */     if (lottery == null)
/*     */     {
/* 228 */       return null;
/*     */     }
/* 230 */     LotteryResult xLotteryResult = (LotteryResult)lottery.getLottery().get(Integer.valueOf(lotterytype));
/* 231 */     if (xLotteryResult == null)
/*     */     {
/* 233 */       return null;
/*     */     }
/* 235 */     long sessionid = xLotteryResult.getSessionid();
/* 236 */     Session session = Session.getSession(sessionid);
/* 237 */     if (session != null)
/*     */     {
/* 239 */       session.stopTimer();
/*     */     }
/* 241 */     return (LotteryResult)lottery.getLottery().remove(Integer.valueOf(lotterytype));
/*     */   }
/*     */   
/*     */ 
/*     */   static void fillItem(Map<Integer, Integer> lotteryMap, Map<Integer, Integer> itemid2num)
/*     */   {
/* 247 */     for (Iterator i$ = itemid2num.keySet().iterator(); i$.hasNext();) { int itemId = ((Integer)i$.next()).intValue();
/*     */       
/* 249 */       Integer old = (Integer)lotteryMap.get(Integer.valueOf(itemId));
/* 250 */       if (old == null)
/*     */       {
/* 252 */         old = Integer.valueOf(0);
/*     */       }
/*     */       
/* 255 */       lotteryMap.put(Integer.valueOf(itemId), Integer.valueOf(old.intValue() + ((Integer)itemid2num.get(Integer.valueOf(itemId))).intValue()));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static void fillGold(Map<Integer, Integer> lotteryMap, int num)
/*     */   {
/* 262 */     Integer old = (Integer)lotteryMap.get(Integer.valueOf(0));
/* 263 */     if (old == null)
/*     */     {
/* 265 */       old = Integer.valueOf(0);
/*     */     }
/*     */     
/* 268 */     lotteryMap.put(Integer.valueOf(0), Integer.valueOf(old.intValue() + num));
/*     */   }
/*     */   
/*     */   static void fillSilver(Map<Integer, Integer> lotteryMap, int num)
/*     */   {
/* 273 */     Integer old = (Integer)lotteryMap.get(Integer.valueOf(1));
/* 274 */     if (old == null)
/*     */     {
/* 276 */       old = Integer.valueOf(0);
/*     */     }
/*     */     
/* 279 */     lotteryMap.put(Integer.valueOf(1), Integer.valueOf(old.intValue() + num));
/*     */   }
/*     */   
/*     */   static void fillYuanbao(Map<Integer, Integer> lotteryMap, int num)
/*     */   {
/* 284 */     Integer old = (Integer)lotteryMap.get(Integer.valueOf(2));
/* 285 */     if (old == null)
/*     */     {
/* 287 */       old = Integer.valueOf(0);
/*     */     }
/*     */     
/* 290 */     lotteryMap.put(Integer.valueOf(2), Integer.valueOf(old.intValue() + num));
/*     */   }
/*     */   
/*     */   static void fillBangGong(Map<Integer, Integer> lotteryMap, int num)
/*     */   {
/* 295 */     Integer old = (Integer)lotteryMap.get(Integer.valueOf(3));
/* 296 */     if (old == null)
/*     */     {
/* 298 */       old = Integer.valueOf(0);
/*     */     }
/* 300 */     lotteryMap.put(Integer.valueOf(3), Integer.valueOf(old.intValue() + num));
/*     */   }
/*     */   
/*     */ 
/*     */   static void fillController(Map<Integer, Integer> lotteryMap, int controllerid)
/*     */   {
/* 306 */     lotteryMap.put(Integer.valueOf(7), Integer.valueOf(controllerid));
/*     */   }
/*     */   
/*     */   static void fillRoleExp(Map<Integer, Integer> lotteryMap, int num)
/*     */   {
/* 311 */     Integer old = (Integer)lotteryMap.get(Integer.valueOf(5));
/* 312 */     if (old == null)
/*     */     {
/* 314 */       old = Integer.valueOf(0);
/*     */     }
/* 316 */     lotteryMap.put(Integer.valueOf(5), Integer.valueOf(0 + num));
/*     */   }
/*     */   
/*     */   static void fillPetExp(Map<Integer, Integer> lotteryMap, int num)
/*     */   {
/* 321 */     Integer old = (Integer)lotteryMap.get(Integer.valueOf(4));
/* 322 */     if (old == null)
/*     */     {
/* 324 */       old = Integer.valueOf(0);
/*     */     }
/*     */     
/* 327 */     lotteryMap.put(Integer.valueOf(4), Integer.valueOf(0 + num));
/*     */   }
/*     */   
/*     */   static void fillXiuLianExp(Map<Integer, Integer> lotteryMap, int num)
/*     */   {
/* 332 */     Integer old = (Integer)lotteryMap.get(Integer.valueOf(6));
/* 333 */     if (old == null)
/*     */     {
/* 335 */       old = Integer.valueOf(0);
/*     */     }
/*     */     
/* 338 */     lotteryMap.put(Integer.valueOf(6), Integer.valueOf(0 + num));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean awardToRole(String userid, long roleid, int lotterytype)
/*     */   {
/* 350 */     Lottery lottery = Role2lottery.get(Long.valueOf(roleid));
/* 351 */     if (lottery == null)
/*     */     {
/* 353 */       return false;
/*     */     }
/* 355 */     LotteryResult xLotteryResult = (LotteryResult)lottery.getLottery().get(Integer.valueOf(lotterytype));
/* 356 */     if (xLotteryResult == null)
/*     */     {
/* 358 */       return false;
/*     */     }
/*     */     
/* 361 */     TLogArg logArg = new TLogArg(LogReason.getReason(xLotteryResult.getLogreason()), xLotteryResult.getSubreason());
/*     */     
/* 363 */     Map<Integer, Integer> map = new HashMap();
/* 364 */     map.putAll(xLotteryResult.getMap());
/* 365 */     boolean ret = awardExp(userid, roleid, map, logArg);
/* 366 */     if (ret)
/*     */     {
/* 368 */       ret = awardMoney(userid, roleid, map, logArg);
/*     */     }
/* 370 */     if (ret)
/*     */     {
/* 372 */       awardController(roleid, map, logArg);
/*     */     }
/* 374 */     if (ret)
/*     */     {
/* 376 */       if (lotterytype == 0)
/*     */       {
/* 378 */         ret = awardBaotuResultItem(roleid, map, logArg);
/* 379 */         if (!ret)
/*     */         {
/* 381 */           return false;
/*     */         }
/*     */       }
/* 384 */       ret = awardItem(roleid, map, logArg);
/*     */     }
/*     */     
/* 387 */     return ret;
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
/*     */   private static boolean awardMoney(String userid, long roleId, Map<Integer, Integer> map, TLogArg logArg)
/*     */   {
/* 400 */     boolean ret = true;
/* 401 */     if ((map.get(Integer.valueOf(0)) != null) && (((Integer)map.get(Integer.valueOf(0))).intValue() > 0))
/*     */     {
/* 403 */       ret = RoleInterface.addGold(roleId, ((Integer)map.get(Integer.valueOf(0))).intValue(), logArg).isSucceed();
/* 404 */       map.remove(Integer.valueOf(0));
/*     */     }
/* 406 */     if (!ret)
/*     */     {
/* 408 */       return false;
/*     */     }
/* 410 */     if ((map.get(Integer.valueOf(1)) != null) && (((Integer)map.get(Integer.valueOf(1))).intValue() > 0))
/*     */     {
/* 412 */       ret = RoleInterface.addSilver(roleId, ((Integer)map.get(Integer.valueOf(1))).intValue(), logArg).isSucceed();
/* 413 */       map.remove(Integer.valueOf(1));
/*     */     }
/* 415 */     if (!ret)
/*     */     {
/* 417 */       return false;
/*     */     }
/* 419 */     if ((map.get(Integer.valueOf(3)) != null) && (((Integer)map.get(Integer.valueOf(3))).intValue() > 0))
/*     */     {
/* 421 */       ModBangGongResult s = GangInterface.addBangGong(roleId, ((Integer)map.get(Integer.valueOf(3))).intValue(), logArg);
/* 422 */       ret = s.isSucceed();
/* 423 */       map.remove(Integer.valueOf(3));
/*     */     }
/* 425 */     if (!ret)
/*     */     {
/* 427 */       return false;
/*     */     }
/* 429 */     if ((map.get(Integer.valueOf(2)) != null) && (map.get(Integer.valueOf(2)) != null))
/*     */     {
/* 431 */       ret = QingfuInterface.presentYuanbao(userid, roleId, ((Integer)map.get(Integer.valueOf(2))).intValue(), PresentType.PRSENT_BIND_ITEM_LOTTERY, logArg) == PresentResult.Success;
/*     */       
/* 433 */       map.remove(Integer.valueOf(2));
/*     */     }
/* 435 */     return ret;
/*     */   }
/*     */   
/*     */   private static boolean awardExp(String userId, long roleId, Map<Integer, Integer> map, TLogArg logArg)
/*     */   {
/* 440 */     boolean ret = true;
/* 441 */     if ((map.get(Integer.valueOf(4)) != null) && (((Integer)map.get(Integer.valueOf(4))).intValue() > 0))
/*     */     {
/* 443 */       Pet pet = PetInterface.getFightPet(roleId, true);
/* 444 */       if (pet != null)
/*     */       {
/* 446 */         pet.addExp(((Integer)map.get(Integer.valueOf(4))).intValue());
/*     */       }
/*     */       
/* 449 */       map.remove(Integer.valueOf(4));
/*     */     }
/* 451 */     if (!ret)
/*     */     {
/* 453 */       return false;
/*     */     }
/* 455 */     if ((map.get(Integer.valueOf(5)) != null) && (((Integer)map.get(Integer.valueOf(5))).intValue() > 0))
/*     */     {
/* 457 */       ret = RoleInterface.addExp(userId, roleId, ((Integer)map.get(Integer.valueOf(5))).intValue(), logArg);
/* 458 */       map.remove(Integer.valueOf(5));
/*     */     }
/* 460 */     if (!ret)
/*     */     {
/* 462 */       return false;
/*     */     }
/* 464 */     if ((map.get(Integer.valueOf(6)) != null) && (((Integer)map.get(Integer.valueOf(6))).intValue() > 0))
/*     */     {
/* 466 */       XiuLianSkillInterface.addXiuLianExp(roleId, ((Integer)map.get(Integer.valueOf(6))).intValue(), logArg);
/* 467 */       map.remove(Integer.valueOf(6));
/*     */     }
/*     */     
/* 470 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */   private static boolean awardItem(long roleId, Map<Integer, Integer> map, TLogArg logArg)
/*     */   {
/* 476 */     if (map.size() > 0)
/*     */     {
/* 478 */       ItemOperateResult result = ItemInterface.addItem(roleId, map, false, logArg);
/* 479 */       return (result.success()) || (result.isBagFull());
/*     */     }
/* 481 */     return true;
/*     */   }
/*     */   
/*     */   private static boolean awardBaotuResultItem(long roleId, Map<Integer, Integer> map, TLogArg logArg)
/*     */   {
/* 486 */     if (map.size() > 0)
/*     */     {
/* 488 */       Pair<Boolean, Protocol> pair = ItemInterface.triggerDoubleItemAward(roleId, map);
/*     */       
/* 490 */       if (pair != null)
/*     */       {
/* 492 */         if (pair.second != null)
/*     */         {
/* 494 */           OnlineManager.getInstance().send(roleId, (Protocol)pair.second);
/*     */         }
/* 496 */         if (pair.first != null)
/*     */         {
/* 498 */           return ((Boolean)pair.first).booleanValue();
/*     */         }
/*     */         
/*     */ 
/* 502 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 507 */       return false;
/*     */     }
/*     */     
/* 510 */     return true;
/*     */   }
/*     */   
/*     */   private static boolean awardController(long roleId, Map<Integer, Integer> map, TLogArg logArg)
/*     */   {
/* 515 */     if (map.get(Integer.valueOf(7)) != null)
/*     */     {
/* 517 */       ControllerInterface.triggerController(roleId, ((Integer)map.get(Integer.valueOf(7))).intValue());
/* 518 */       map.remove(Integer.valueOf(7));
/*     */     }
/*     */     
/* 521 */     return true;
/*     */   }
/*     */   
/*     */   static void fillResult(Map<Integer, Integer> lotteryMap, List<AwardPoolResultData> awardPoolResultDatas)
/*     */   {
/* 526 */     for (AwardPoolResultData re : awardPoolResultDatas)
/*     */     {
/* 528 */       if (re.getGang() > 0)
/*     */       {
/* 530 */         fillBangGong(lotteryMap, re.getGang());
/*     */       }
/* 532 */       if (re.getGold() > 0)
/*     */       {
/* 534 */         fillGold(lotteryMap, re.getGold());
/*     */       }
/* 536 */       if (re.getSilver() > 0)
/*     */       {
/* 538 */         fillSilver(lotteryMap, re.getSilver());
/*     */       }
/* 540 */       if (re.getYuanbao() > 0)
/*     */       {
/* 542 */         fillYuanbao(lotteryMap, re.getYuanbao());
/*     */       }
/* 544 */       if (re.getItemMap().size() > 0)
/*     */       {
/* 546 */         fillItem(lotteryMap, re.getItemMap());
/*     */       }
/* 548 */       if (re.getRoleExp() > 0)
/*     */       {
/* 550 */         fillRoleExp(lotteryMap, re.getRoleExp());
/*     */       }
/* 552 */       if (re.getXiuLianExp() > 0)
/*     */       {
/* 554 */         fillXiuLianExp(lotteryMap, re.getXiuLianExp());
/*     */       }
/* 556 */       if (re.getPetExp() > 0)
/*     */       {
/* 558 */         fillPetExp(lotteryMap, re.getPetExp());
/*     */       }
/* 560 */       if (re.getControllerId() > 0)
/*     */       {
/* 562 */         fillController(lotteryMap, re.getControllerId());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static Map<Integer, Integer> getItemMap(long roleid, int lotterytype)
/*     */   {
/* 570 */     Map<Integer, Integer> map = new HashMap();
/* 571 */     Lottery lottery = Role2lottery.select(Long.valueOf(roleid));
/* 572 */     if (lottery == null)
/*     */     {
/* 574 */       return map;
/*     */     }
/* 576 */     LotteryResult xLotteryResult = (LotteryResult)lottery.getLottery().get(Integer.valueOf(lotterytype));
/* 577 */     if (xLotteryResult == null)
/*     */     {
/* 579 */       return map;
/*     */     }
/*     */     
/* 582 */     for (Iterator i$ = xLotteryResult.getMap().keySet().iterator(); i$.hasNext();) { int key = ((Integer)i$.next()).intValue();
/*     */       
/* 584 */       if (ItemInterface.isItemExist(key))
/*     */       {
/* 586 */         map.put(Integer.valueOf(key), xLotteryResult.getMap().get(Integer.valueOf(key)));
/*     */       }
/*     */     }
/*     */     
/* 590 */     return map;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\LotteryManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */