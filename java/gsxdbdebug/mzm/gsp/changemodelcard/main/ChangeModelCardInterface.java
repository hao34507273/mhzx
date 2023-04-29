/*     */ package mzm.gsp.changemodelcard.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.changemodelcard.SChangeModelCardLotteryBrd;
/*     */ import mzm.gsp.changemodelcard.confbean.SCardLevelBean;
/*     */ import mzm.gsp.changemodelcard.confbean.SChangeModelCardCfg;
/*     */ import mzm.gsp.changemodelcard.confbean.SChangeModelCardConsts;
/*     */ import mzm.gsp.changemodelcard.confbean.SClassLevelBean;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.ChangeModelCardInfo;
/*     */ import xbean.Role2ChangeModelCardInfo;
/*     */ import xtable.Role2changemodelcard;
/*     */ 
/*     */ public class ChangeModelCardInterface
/*     */ {
/*     */   public static ChangeModelCardLevelEntry getRoleCardCfgIdAndLevel(long roleId, boolean retainLock)
/*     */   {
/*     */     Role2ChangeModelCardInfo xRole2CardInfo;
/*     */     Role2ChangeModelCardInfo xRole2CardInfo;
/*  32 */     if (retainLock)
/*     */     {
/*  34 */       xRole2CardInfo = ChangeModelCardManager.getRole2CardInfo(roleId);
/*     */     }
/*     */     else
/*     */     {
/*  38 */       xRole2CardInfo = Role2changemodelcard.select(Long.valueOf(roleId));
/*     */     }
/*     */     
/*     */ 
/*  42 */     if (null == xRole2CardInfo)
/*     */     {
/*  44 */       return new ChangeModelCardLevelEntry(0, 0, false);
/*     */     }
/*     */     
/*  47 */     return new ChangeModelCardLevelEntry(xRole2CardInfo.getCurrent_card_cfg_id(), xRole2CardInfo.getCurrent_card_level(), xRole2CardInfo.getVisible());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ClassLevelEntry getRoleClassTypeAndLevel(long roleId, boolean retainLock)
/*     */   {
/*     */     Role2ChangeModelCardInfo xRole2CardInfo;
/*     */     
/*     */ 
/*     */ 
/*     */     Role2ChangeModelCardInfo xRole2CardInfo;
/*     */     
/*     */ 
/*  62 */     if (retainLock)
/*     */     {
/*  64 */       xRole2CardInfo = ChangeModelCardManager.getRole2CardInfo(roleId);
/*     */     }
/*     */     else
/*     */     {
/*  68 */       xRole2CardInfo = Role2changemodelcard.select(Long.valueOf(roleId));
/*     */     }
/*     */     
/*  71 */     int defaultClass = SChangeModelCardConsts.getInstance().DEFAULT_CLASS;
/*  72 */     int defaultClassLevel = SChangeModelCardConsts.getInstance().DEFAULT_CLASS_LEVEL;
/*  73 */     ClassLevelEntry defaultRes = new ClassLevelEntry(defaultClass, defaultClassLevel);
/*     */     
/*     */ 
/*  76 */     if (null == xRole2CardInfo)
/*     */     {
/*  78 */       return defaultRes;
/*     */     }
/*     */     
/*     */ 
/*  82 */     if (!ChangeModelCardManager.isChangeModelCardActivated(xRole2CardInfo))
/*     */     {
/*  84 */       return defaultRes;
/*     */     }
/*     */     
/*  87 */     int cardCfgId = xRole2CardInfo.getCurrent_card_cfg_id();
/*  88 */     SChangeModelCardCfg sChangeModelCardCfg = SChangeModelCardCfg.get(cardCfgId);
/*     */     
/*  90 */     if (null == sChangeModelCardCfg)
/*     */     {
/*  92 */       return defaultRes;
/*     */     }
/*     */     
/*  95 */     return new ClassLevelEntry(sChangeModelCardCfg.classType, xRole2CardInfo.getCurrent_card_level());
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
/*     */   public static Map<Integer, Integer> getCurChangeModelCardProp(long roleId, boolean retainLock)
/*     */   {
/* 108 */     Map<Integer, Integer> propMap = new HashMap();
/*     */     
/*     */ 
/* 111 */     if (!ChangeModelCardManager.isChangeModelCardOpen(roleId))
/*     */     {
/* 113 */       return propMap;
/*     */     }
/*     */     
/*     */     Role2ChangeModelCardInfo xRole2CardInfo;
/*     */     Role2ChangeModelCardInfo xRole2CardInfo;
/* 118 */     if (retainLock)
/*     */     {
/* 120 */       xRole2CardInfo = ChangeModelCardManager.getRole2CardInfo(roleId);
/*     */     }
/*     */     else
/*     */     {
/* 124 */       xRole2CardInfo = Role2changemodelcard.select(Long.valueOf(roleId));
/*     */     }
/* 126 */     if (null == xRole2CardInfo)
/*     */     {
/* 128 */       return propMap;
/*     */     }
/*     */     
/*     */ 
/* 132 */     if (!ChangeModelCardManager.isChangeModelCardActivated(xRole2CardInfo))
/*     */     {
/* 134 */       return propMap;
/*     */     }
/*     */     
/*     */ 
/* 138 */     int cardCfgId = xRole2CardInfo.getCurrent_card_cfg_id();
/* 139 */     int cardLevel = xRole2CardInfo.getCurrent_card_level();
/* 140 */     SCardLevelBean sCardLevelBean = ChangeModelCardCfgManager.getCardLevelCfg(cardCfgId, cardLevel);
/* 141 */     if (null == sCardLevelBean)
/*     */     {
/* 143 */       return propMap;
/*     */     }
/*     */     
/*     */ 
/* 147 */     propMap.putAll(sCardLevelBean.propMap);
/* 148 */     return propMap;
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
/*     */   public static int getClassDamageRate(int attackClassType, int attackLevel, int targetClassType, int targetLevel)
/*     */   {
/* 164 */     SClassLevelBean attackClassCfg = ChangeModelCardCfgManager.getClassLevelCfg(attackClassType, attackLevel);
/* 165 */     if (null == attackClassCfg)
/*     */     {
/* 167 */       return 0;
/*     */     }
/* 169 */     SClassLevelBean targetClassCfg = ChangeModelCardCfgManager.getClassLevelCfg(targetClassType, targetLevel);
/* 170 */     if (null == targetClassCfg)
/*     */     {
/* 172 */       return 0;
/*     */     }
/*     */     
/*     */ 
/* 176 */     Integer damageAddRate = (Integer)attackClassCfg.restrictClass2DamageAddRate.get(Integer.valueOf(targetClassType));
/* 177 */     if (null != damageAddRate)
/*     */     {
/* 179 */       return damageAddRate.intValue();
/*     */     }
/*     */     
/* 182 */     Integer damageReduceRate = (Integer)targetClassCfg.restrictClass2DamageReduceRate.get(Integer.valueOf(attackClassType));
/* 183 */     if (null != damageReduceRate)
/*     */     {
/* 185 */       return -damageReduceRate.intValue();
/*     */     }
/*     */     
/* 188 */     return 0;
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
/*     */   public static int getClassSealRate(int attackClassType, int attackLevel, int targetClassType, int targetLevel)
/*     */   {
/* 204 */     SClassLevelBean attackClassCfg = ChangeModelCardCfgManager.getClassLevelCfg(attackClassType, attackLevel);
/* 205 */     if (null == attackClassCfg)
/*     */     {
/* 207 */       return 0;
/*     */     }
/* 209 */     SClassLevelBean targetClassCfg = ChangeModelCardCfgManager.getClassLevelCfg(targetClassType, targetLevel);
/* 210 */     if (null == targetClassCfg)
/*     */     {
/* 212 */       return 0;
/*     */     }
/*     */     
/*     */ 
/* 216 */     Integer sealAddRate = (Integer)attackClassCfg.restrictClass2SealAddRate.get(Integer.valueOf(targetClassType));
/* 217 */     if (null != sealAddRate)
/*     */     {
/* 219 */       return sealAddRate.intValue();
/*     */     }
/*     */     
/* 222 */     Integer sealReduceRate = (Integer)targetClassCfg.restrictClass2SealReduceRate.get(Integer.valueOf(attackClassType));
/* 223 */     if (null != sealReduceRate)
/*     */     {
/* 225 */       return -sealReduceRate.intValue();
/*     */     }
/*     */     
/* 228 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void consumePVPFightCount(long roleId, int count)
/*     */   {
/* 240 */     ChangeModelCardManager.consumePVPFightCount(roleId, count);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isCardLotteryOutPutItem(int itemCfgId, int roleLevel)
/*     */   {
/* 251 */     int lotteryPoolTypeId = SChangeModelCardConsts.getInstance().LOTTERY_AWARD_POOL_TYPE_ID;
/* 252 */     return AwardPoolInterface.containsItem(itemCfgId, lotteryPoolTypeId, roleLevel);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void sendCardLotteryBulletin(long roleId, Collection<Integer> itemCfgIds)
/*     */   {
/* 263 */     String roleName = null;
/* 264 */     for (Iterator i$ = itemCfgIds.iterator(); i$.hasNext();) { int itemCfgId = ((Integer)i$.next()).intValue();
/*     */       
/* 266 */       if (mzm.gsp.itembulletin.main.ItemBulletinInterface.needBulletin(itemCfgId))
/*     */       {
/* 268 */         if (null == roleName)
/*     */         {
/* 270 */           roleName = RoleInterface.getName(roleId);
/*     */         }
/* 272 */         SChangeModelCardLotteryBrd proto = new SChangeModelCardLotteryBrd();
/* 273 */         proto.item_cfg_id = itemCfgId;
/* 274 */         proto.role_name = roleName;
/* 275 */         OnlineManager.getInstance().sendAll(proto);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static class ChangeModelCardLevelEntry
/*     */   {
/*     */     public final int cardCfgId;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public final int level;
/*     */     
/*     */ 
/*     */ 
/*     */     public final boolean visible;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public ChangeModelCardLevelEntry(int cardCfgId, int level, boolean visible)
/*     */     {
/* 302 */       this.cardCfgId = cardCfgId;
/* 303 */       this.level = level;
/* 304 */       this.visible = visible;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public boolean isCardActivated()
/*     */     {
/* 314 */       return this.cardCfgId > 0;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static class ClassLevelEntry
/*     */   {
/*     */     public final int classType;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public final int level;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public ClassLevelEntry(int classType, int level)
/*     */     {
/* 339 */       this.classType = classType;
/* 340 */       this.level = level;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static enum RemoveCardForIDIPResult
/*     */   {
/* 350 */     SUCCESS(0), 
/* 351 */     ROLE_NOT_EXIST(1), 
/* 352 */     CARD_NOT_EXIST(2);
/*     */     
/*     */     public final int value;
/*     */     
/*     */     private RemoveCardForIDIPResult(int value)
/*     */     {
/* 358 */       this.value = value;
/*     */     }
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
/*     */   public static RemoveCardForIDIPResult removeCardForIDIP(long roleId, long cardId)
/*     */   {
/* 372 */     Role2ChangeModelCardInfo xRole2CardInfo = Role2changemodelcard.get(Long.valueOf(roleId));
/* 373 */     if (null == xRole2CardInfo)
/*     */     {
/* 375 */       return RemoveCardForIDIPResult.ROLE_NOT_EXIST;
/*     */     }
/* 377 */     ChangeModelCardInfo xChangeModelCardInfo = (ChangeModelCardInfo)xRole2CardInfo.getCardid2info().get(Long.valueOf(cardId));
/* 378 */     if (null == xChangeModelCardInfo)
/*     */     {
/* 380 */       return RemoveCardForIDIPResult.CARD_NOT_EXIST;
/*     */     }
/*     */     
/*     */ 
/* 384 */     int cardCfgId = xChangeModelCardInfo.getCard_cfg_id();
/* 385 */     int cardLevel = xChangeModelCardInfo.getLevel();
/* 386 */     if ((cardCfgId == xRole2CardInfo.getCurrent_card_cfg_id()) && (cardLevel == xRole2CardInfo.getCurrent_card_level()))
/*     */     {
/* 388 */       ChangeModelCardManager.tryRemoveChangeModelState(roleId, xRole2CardInfo, ChangeModelCardManager.RemoveCardStateReason.IDIP);
/*     */     }
/*     */     
/*     */ 
/* 392 */     ChangeModelCardManager.removeChangeModelCard(roleId, xRole2CardInfo, Collections.singletonList(Long.valueOf(cardId)), ChangeModelCardManager.RemoveCardReason.IDIP);
/*     */     
/*     */ 
/*     */ 
/* 396 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 401 */         OnlineManager.getInstance().forceReconnect(this.val$roleId);
/* 402 */         return true;
/*     */       }
/*     */       
/* 405 */     });
/* 406 */     return RemoveCardForIDIPResult.SUCCESS;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getMatchClassLevelQualityCardNum(long roleId, int needClassType, int needLevel, int needQuality, boolean retainLock)
/*     */   {
/*     */     Role2ChangeModelCardInfo xRole2ChangeModelCardInfo;
/*     */     
/*     */ 
/*     */ 
/*     */     Role2ChangeModelCardInfo xRole2ChangeModelCardInfo;
/*     */     
/*     */ 
/*     */ 
/* 423 */     if (retainLock)
/*     */     {
/* 425 */       xRole2ChangeModelCardInfo = Role2changemodelcard.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/* 429 */       xRole2ChangeModelCardInfo = Role2changemodelcard.select(Long.valueOf(roleId));
/*     */     }
/*     */     
/* 432 */     if (null == xRole2ChangeModelCardInfo)
/*     */     {
/* 434 */       return 0;
/*     */     }
/*     */     
/* 437 */     int result = 0;
/* 438 */     for (ChangeModelCardInfo xChangeModelCardInfo : xRole2ChangeModelCardInfo.getCardid2info().values())
/*     */     {
/* 440 */       if (xChangeModelCardInfo.getLevel() >= needLevel)
/*     */       {
/*     */ 
/*     */ 
/* 444 */         SChangeModelCardCfg sCardCfg = SChangeModelCardCfg.get(xChangeModelCardInfo.getCard_cfg_id());
/* 445 */         if ((sCardCfg.quality <= needQuality) && 
/*     */         
/*     */ 
/*     */ 
/* 449 */           (sCardCfg.classType == needClassType))
/*     */         {
/*     */ 
/*     */ 
/* 453 */           result++; }
/*     */       }
/*     */     }
/* 456 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static int getOwnClassTypeNum(long roleId, boolean retainLock)
/*     */   {
/*     */     Role2ChangeModelCardInfo xRole2ChangeModelCardInfo;
/*     */     
/*     */ 
/*     */     Role2ChangeModelCardInfo xRole2ChangeModelCardInfo;
/*     */     
/*     */ 
/* 469 */     if (retainLock)
/*     */     {
/* 471 */       xRole2ChangeModelCardInfo = Role2changemodelcard.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/* 475 */       xRole2ChangeModelCardInfo = Role2changemodelcard.select(Long.valueOf(roleId));
/*     */     }
/*     */     
/* 478 */     if (null == xRole2ChangeModelCardInfo)
/*     */     {
/* 480 */       return 0;
/*     */     }
/*     */     
/* 483 */     Set<Integer> classTypeSet = new HashSet();
/* 484 */     for (ChangeModelCardInfo xChangeModelCardInfo : xRole2ChangeModelCardInfo.getCardid2info().values())
/*     */     {
/* 486 */       classTypeSet.add(Integer.valueOf(SChangeModelCardCfg.get(xChangeModelCardInfo.getCard_cfg_id()).classType));
/*     */     }
/*     */     
/* 489 */     return classTypeSet.size();
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
/*     */   public static int getSpecificCardNum(long roleId, List<Integer> rawCardCfgIds, boolean retainLock)
/*     */   {
/* 503 */     List<Integer> cardCfgIds = new LinkedList(rawCardCfgIds);
/*     */     Role2ChangeModelCardInfo xRole2ChangeModelCardInfo;
/* 505 */     Role2ChangeModelCardInfo xRole2ChangeModelCardInfo; if (retainLock)
/*     */     {
/* 507 */       xRole2ChangeModelCardInfo = Role2changemodelcard.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/* 511 */       xRole2ChangeModelCardInfo = Role2changemodelcard.select(Long.valueOf(roleId));
/*     */     }
/*     */     
/* 514 */     if (null == xRole2ChangeModelCardInfo)
/*     */     {
/* 516 */       return 0;
/*     */     }
/*     */     
/* 519 */     int result = 0;
/* 520 */     for (ChangeModelCardInfo xChangeModelCardInfo : xRole2ChangeModelCardInfo.getCardid2info().values())
/*     */     {
/* 522 */       Integer cardCfgId = Integer.valueOf(xChangeModelCardInfo.getCard_cfg_id());
/* 523 */       if (cardCfgIds.contains(cardCfgId))
/*     */       {
/* 525 */         result++;
/* 526 */         cardCfgIds.remove(cardCfgId);
/*     */       }
/*     */     }
/*     */     
/* 530 */     return result;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\main\ChangeModelCardInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */