/*      */ package mzm.gsp.item.main;
/*      */ 
/*      */ import java.lang.reflect.Constructor;
/*      */ import java.lang.reflect.InvocationTargetException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.award.main.AwardInterface;
/*      */ import mzm.gsp.bag.confbean.ItemType2BagCfg;
/*      */ import mzm.gsp.bag.confbean.SBagCfg;
/*      */ import mzm.gsp.bag.confbean.SStorageCfg;
/*      */ import mzm.gsp.bulletin.SBulletinInfo;
/*      */ import mzm.gsp.bulletin.main.BulletinInterface;
/*      */ import mzm.gsp.common.TimeCommonUtil;
/*      */ import mzm.gsp.common.confbean.STimePointCommonCfg;
/*      */ import mzm.gsp.gang.main.GangInterface;
/*      */ import mzm.gsp.item.BagInfo;
/*      */ import mzm.gsp.item.ExtraProBean;
/*      */ import mzm.gsp.item.ItemInfo;
/*      */ import mzm.gsp.item.SAllBagInfo;
/*      */ import mzm.gsp.item.SCommonErrorInfo;
/*      */ import mzm.gsp.item.SSynEquipQiLinOperateRes;
/*      */ import mzm.gsp.item.SSynEquipQilinModeRes;
/*      */ import mzm.gsp.item.SSynMoshouExchangeCountRes;
/*      */ import mzm.gsp.item.SuperEquipmentCostInfo;
/*      */ import mzm.gsp.item.confbean.EquipItemCfgConsts;
/*      */ import mzm.gsp.item.confbean.SEquipTransferInherit;
/*      */ import mzm.gsp.item.confbean.SGangFileItem;
/*      */ import mzm.gsp.item.confbean.SItemCangBaoTuCfg;
/*      */ import mzm.gsp.item.confbean.SItemCfg;
/*      */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*      */ import mzm.gsp.item.confbean.SMarriageSugerItem;
/*      */ import mzm.gsp.item.confbean.SQiLinAccumulateModeCfg;
/*      */ import mzm.gsp.item.confbean.STimeEffectItemCfg;
/*      */ import mzm.gsp.item.event.EquipQiLin;
/*      */ import mzm.gsp.item.event.EquipSkillGet;
/*      */ import mzm.gsp.item.event.EquipSkillGetArg;
/*      */ import mzm.gsp.item.event.GainItemEvent;
/*      */ import mzm.gsp.item.event.GainItemeArg;
/*      */ import mzm.gsp.item.event.RemoveItemEvent;
/*      */ import mzm.gsp.item.event.RemoveItemeArg;
/*      */ import mzm.gsp.item.main.expbottle.ExpBottleItem;
/*      */ import mzm.gsp.item.main.expbottle.FixAwardExpBottleItem;
/*      */ import mzm.gsp.item.main.expbottle.MergeServerLevelExpBottleItem;
/*      */ import mzm.gsp.item.main.expbottle.ServerLevelExpBottleItem;
/*      */ import mzm.gsp.mail.main.MailAttachment;
/*      */ import mzm.gsp.mail.main.MailInterface;
/*      */ import mzm.gsp.map.main.MapInterface;
/*      */ import mzm.gsp.ocpequip.main.TransferStrengthLevelBean;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.open.main.OpenInterface;
/*      */ import mzm.gsp.qingfu.main.CostResult;
/*      */ import mzm.gsp.qingfu.main.CostType;
/*      */ import mzm.gsp.qingfu.main.QingfuInterface;
/*      */ import mzm.gsp.role.main.ModMoneyResult;
/*      */ import mzm.gsp.role.main.ModMoneyResult.ErrorResult;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.shimen.confbean.ShimenActivityCfgConsts;
/*      */ import mzm.gsp.status.main.RoleStatusInterface;
/*      */ import mzm.gsp.superequipment.main.SuperEquipmentInterface;
/*      */ import mzm.gsp.tlog.LogReason;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.LogManager;
/*      */ import mzm.gsp.util.UuidUtils;
/*      */ import mzm.gsp.util.UuidUtils.UuidType;
/*      */ import mzm.gsp.yuanbao.main.CurrencyType;
/*      */ import org.apache.log4j.Logger;
/*      */ import util.ClassHelper;
/*      */ import xbean.Bag;
/*      */ import xbean.EquipMode;
/*      */ import xbean.Item;
/*      */ import xbean.ItemUseCount;
/*      */ import xbean.Pod;
/*      */ import xbean.SuperEquipmentCostBean;
/*      */ import xbean.Sysawards;
/*      */ import xbean.SystemAwardBean;
/*      */ import xbean.SystemAwards;
/*      */ import xbean.XExtraProBean;
/*      */ import xdb.TField;
/*      */ import xdb.TTable;
/*      */ import xdb.Tables;
/*      */ import xdb.Xdb;
/*      */ import xtable.Role2equipmode;
/*      */ import xtable.Role2itemusecount;
/*      */ import xtable.Role2sysaward;
/*      */ import xtable.Systemaward;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ class ItemManager
/*      */ {
/*      */   public static final String TLOG_ITEM = "Item";
/*      */   public static final String TLOG_ITEM_FLOW = "ItemFlow";
/*      */   public static final String LOG_ITEM = "item";
/*      */   public static final String LOG_EQUIP = "equipment";
/*      */   public static final int TEN_THOUSEND = 10000;
/*  117 */   static final Logger logger = Logger.getLogger("item");
/*      */   
/*      */   static final String SPECIAL_ITEM_PACKAGE = "mzm.gsp.item.main";
/*      */   
/*  121 */   static Map<Integer, Constructor<? extends BasicItem>> typeToClassMap = new HashMap();
/*      */   
/*  123 */   static Map<Integer, ExpBottleItem> expBotleItemMap = new HashMap();
/*      */   
/*      */   static {
/*  126 */     expBotleItemMap.put(Integer.valueOf(1), new FixAwardExpBottleItem());
/*  127 */     expBotleItemMap.put(Integer.valueOf(2), new ServerLevelExpBottleItem());
/*  128 */     expBotleItemMap.put(Integer.valueOf(3), new MergeServerLevelExpBottleItem());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void registerSpecialItem()
/*      */   {
/*  136 */     Map<Integer, Class<? extends BasicItem>> tempClassMap = new HashMap();
/*  137 */     tempClassMap.put(Integer.valueOf(2), EquipmentItem.class);
/*  138 */     tempClassMap.put(Integer.valueOf(12), BaoTuItem.class);
/*  139 */     tempClassMap.put(Integer.valueOf(3), PetEquipmentItem.class);
/*  140 */     tempClassMap.put(Integer.valueOf(84), CatItem.class);
/*      */     
/*  142 */     tempClassMap.put(Integer.valueOf(44), FabaoItem.class);
/*  143 */     tempClassMap.put(Integer.valueOf(103), ChildrenEquipItem.class);
/*  144 */     for (Map.Entry<Integer, Class<? extends BasicItem>> entry : tempClassMap.entrySet())
/*      */     {
/*      */       try
/*      */       {
/*  148 */         Constructor<? extends BasicItem> constraConstructor = ((Class)entry.getValue()).getDeclaredConstructor(new Class[] { Item.class });
/*  149 */         constraConstructor.setAccessible(true);
/*  150 */         typeToClassMap.put(entry.getKey(), constraConstructor);
/*      */       }
/*      */       catch (SecurityException e)
/*      */       {
/*  154 */         logger.error(e);
/*  155 */         throw new RuntimeException();
/*      */       }
/*      */       catch (NoSuchMethodException e)
/*      */       {
/*  159 */         logger.error(e);
/*  160 */         throw new RuntimeException();
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */     try
/*      */     {
/*  167 */       List<Class<?>> allClasses = ClassHelper.getAllClass("mzm.gsp.item.main");
/*  168 */       for (Class<?> class1 : allClasses)
/*      */       {
/*  170 */         if ((BasicItem.class.isAssignableFrom(class1)) && (!class1.equals(BasicItem.class)))
/*      */         {
/*  172 */           if (!tempClassMap.values().contains(class1))
/*      */           {
/*  174 */             throw new RuntimeException("该特殊道具类并没有注册:" + class1.getName());
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  181 */       logger.error(e);
/*  182 */       throw new RuntimeException(e);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getItemType(int itemid)
/*      */   {
/*  194 */     SItemCfg itemCfg = SItemCfg.get(itemid);
/*  195 */     if (itemCfg == null)
/*      */     {
/*  197 */       String logStr = String.format("[item]ItemManager.getItemType@itemid not exist|itemid=%d", new Object[] { Integer.valueOf(itemid) });
/*  198 */       logger.error(logStr);
/*  199 */       return 0;
/*      */     }
/*  201 */     return itemCfg.type;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static List<Item> createXItem(int itemId, int itemCount)
/*      */   {
/*  214 */     return createXItem(itemId, itemCount, new HashMap(), false);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static List<Item> createXItem(int itemId, int itemCount, Map<Integer, Integer> extraMap, boolean isbind)
/*      */   {
/*  226 */     List<Item> itemList = new ArrayList();
/*  227 */     if (itemCount <= 0)
/*      */     {
/*  229 */       return itemList;
/*      */     }
/*  231 */     int pileMaxNum = ItemConfigManager.getPileMaxCount(itemId);
/*  232 */     if (pileMaxNum == 0)
/*      */     {
/*  234 */       return itemList;
/*      */     }
/*  236 */     int xitemNum = itemCount / pileMaxNum;
/*  237 */     for (int i = 0; i < xitemNum; i++)
/*      */     {
/*  239 */       Item item = Pod.newItem();
/*  240 */       item.setCfgid(itemId);
/*  241 */       item.setNumber(pileMaxNum);
/*      */       
/*  243 */       if ((extraMap != null) && (extraMap.size() > 0))
/*      */       {
/*  245 */         item.getExtra().putAll(extraMap);
/*      */       }
/*  247 */       if ((isbind) || (ItemConfigManager.isProprietary(itemId)))
/*      */       {
/*  249 */         item.setFlags(item.getFlags() | 0x1);
/*      */       }
/*  251 */       fillItemUUid(item, pileMaxNum);
/*      */       
/*  253 */       BasicItem basicItem = getBasicItem(item);
/*  254 */       if ((basicItem != null) && (basicItem.onCreateItem()))
/*      */       {
/*  256 */         itemList.add(item);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  261 */     if (itemCount % pileMaxNum != 0)
/*      */     {
/*  263 */       Item item = Pod.newItem();
/*  264 */       item.setCfgid(itemId);
/*  265 */       item.setNumber(itemCount % pileMaxNum);
/*      */       
/*  267 */       if ((extraMap != null) && (extraMap.size() > 0))
/*      */       {
/*  269 */         item.getExtra().putAll(extraMap);
/*      */       }
/*  271 */       if ((isbind) || (ItemConfigManager.isProprietary(itemId)))
/*      */       {
/*  273 */         item.setFlags(item.getFlags() | 0x1);
/*      */       }
/*  275 */       fillItemUUid(item, itemCount % pileMaxNum);
/*  276 */       BasicItem basicItem = getBasicItem(item);
/*  277 */       if (basicItem.onCreateItem())
/*      */       {
/*  279 */         itemList.add(item);
/*      */       }
/*      */     }
/*      */     
/*  283 */     return itemList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Item createXItemWithOutUuid(int itemId, int itemCount, Map<Integer, Integer> extraMap, boolean isbind)
/*      */   {
/*  296 */     if (itemCount <= 0)
/*      */     {
/*  298 */       return null;
/*      */     }
/*      */     
/*  301 */     Item item = Pod.newItem();
/*  302 */     item.setCfgid(itemId);
/*  303 */     item.setNumber(itemCount);
/*      */     
/*  305 */     if ((extraMap != null) && (extraMap.size() > 0))
/*      */     {
/*  307 */       item.getExtra().putAll(extraMap);
/*      */     }
/*  309 */     if (isbind)
/*      */     {
/*  311 */       item.setFlags(item.getFlags() | 0x1);
/*      */     }
/*  313 */     BasicItem basicItem = getBasicItem(item);
/*  314 */     if ((basicItem == null) || (!basicItem.onCreateItem()))
/*      */     {
/*  316 */       return null;
/*      */     }
/*      */     
/*  319 */     return basicItem.getItem();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static BasicItem getBasicItem(Item xItem)
/*      */   {
/*  331 */     BasicItem basicItem = null;
/*  332 */     if (SItemCfg.get(xItem.getCfgid()) == null)
/*      */     {
/*  334 */       String logStr = String.format("[item]ItemManager.getBasicItem@itemid error|itemid=%d", new Object[] { Integer.valueOf(xItem.getCfgid()) });
/*  335 */       logger.error(logStr);
/*  336 */       return null;
/*      */     }
/*      */     
/*  339 */     int type = SItemCfg.get(xItem.getCfgid()).type;
/*  340 */     if (typeToClassMap.containsKey(Integer.valueOf(type)))
/*      */     {
/*      */       try
/*      */       {
/*  344 */         basicItem = (BasicItem)((Constructor)typeToClassMap.get(Integer.valueOf(type))).newInstance(new Object[] { xItem });
/*      */       }
/*      */       catch (IllegalArgumentException e)
/*      */       {
/*  348 */         String logStr = String.format("ItemManager.getBasicItem@xItem type error|itemid=%d", new Object[] { Integer.valueOf(xItem.getCfgid()) });
/*  349 */         logger.error(logStr, e);
/*      */ 
/*      */       }
/*      */       catch (InstantiationException e)
/*      */       {
/*  354 */         String logStr = String.format("ItemManager.getBasicItem@xItem type error|itemid=%d", new Object[] { Integer.valueOf(xItem.getCfgid()) });
/*  355 */         logger.error(logStr, e);
/*      */       }
/*      */       catch (IllegalAccessException e)
/*      */       {
/*  359 */         String logStr = String.format("ItemManager.getBasicItem@xItem type error|itemid=%d", new Object[] { Integer.valueOf(xItem.getCfgid()) });
/*  360 */         logger.error(logStr, e);
/*      */       }
/*      */       catch (InvocationTargetException e)
/*      */       {
/*  364 */         String logStr = String.format("ItemManager.getBasicItem@xItem type error|itemid=%d", new Object[] { Integer.valueOf(xItem.getCfgid()) });
/*  365 */         logger.error(logStr, e);
/*      */       }
/*      */       
/*      */     }
/*      */     else {
/*  370 */       basicItem = new BasicItem(xItem);
/*      */     }
/*  372 */     return basicItem;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static boolean fillItemUUid(Item item, int number)
/*      */   {
/*  385 */     if (number <= 0)
/*  386 */       return false;
/*  387 */     int uuidsize = item.getUuid().size();
/*      */     
/*  389 */     item.getUuid().addAll(UuidUtils.generateUuids(UuidUtils.UuidType.Item, number));
/*  390 */     if (item.getUuid().size() != number + uuidsize)
/*  391 */       return false;
/*  392 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void logItem(long roleid, int itemid, int changenum, TLogArg logArg)
/*      */   {
/*  409 */     if (logArg.logReason == null)
/*      */     {
/*  411 */       String logStr = String.format("[item]ItemManager.logItem@logreason error,null|roleid=%d|itmeid=%d|changenum=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(itemid), Integer.valueOf(changenum) });
/*      */       
/*  413 */       logger.error(logStr);
/*  414 */       return;
/*      */     }
/*  416 */     int platform = RoleInterface.getPlatform(roleid);
/*  417 */     String channel = RoleInterface.getChannel(roleid);
/*  418 */     String mac = RoleInterface.getMac(roleid);
/*      */     
/*  420 */     String userid = RoleInterface.getUserId(roleid);
/*  421 */     int rolelevel = RoleInterface.getLevel(roleid);
/*  422 */     int leftnum = ItemInterface.getTotalItemNumberById(roleid, itemid, true);
/*  423 */     int vipLevel = 0;
/*  424 */     String logStr = String.format("%d|%s|%s|%s|%d|%d|%s|%d|%d|%d|%d", new Object[] { Integer.valueOf(platform), channel, mac, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), String.valueOf(itemid), Integer.valueOf(logArg.logReason.value), Integer.valueOf(changenum), Integer.valueOf(leftnum), Integer.valueOf(logArg.subReason), Integer.valueOf(vipLevel) });
/*      */     
/*  426 */     LogManager.getInstance().addLog("item", logStr);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogItem(long roleid, int itemid, int changenum, TLogArg logArg)
/*      */   {
/*  443 */     if (logArg.logReason == null)
/*      */     {
/*      */ 
/*  446 */       String logStr = String.format("[item]ItemManager.tlogItem@logArg error,null|roleid=%d|itmeid=%d|changenum=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(itemid), Integer.valueOf(changenum) });
/*      */       
/*  448 */       logger.error(logStr);
/*  449 */       return;
/*      */     }
/*  451 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  452 */     String userid = RoleInterface.getUserId(roleid);
/*  453 */     int rolelevel = RoleInterface.getLevel(roleid);
/*  454 */     int leftnum = ItemInterface.getTotalItemNumberById(roleid, itemid, true);
/*      */     
/*  456 */     Object[] columnns = { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(itemid), Integer.valueOf(changenum), Integer.valueOf(logArg.logReason.value), Integer.valueOf(leftnum) };
/*      */     
/*      */ 
/*  459 */     TLogManager.getInstance().addLog(roleid, "Item", columnns);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogItemFlow(long roleid, BasicItem basicItem, boolean addOrRemove, TLogArg logArg)
/*      */   {
/*  472 */     if (logArg.logReason == null)
/*      */     {
/*  474 */       String logStr = String.format("[item]ItemManager.tlogItemFlow@logreason error,null|roleid=%d|itmeid=%d|changenum=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(basicItem.getCfgId()), Integer.valueOf(basicItem.getItem().getNumber()) });
/*      */       
/*      */ 
/*  477 */       logger.error(logStr);
/*  478 */       return;
/*      */     }
/*  480 */     int rolelevel = RoleInterface.getLevel(roleid);
/*  481 */     int iGoodsType = ItemConfigManager.getItemTypeByItemId(basicItem.getCfgId());
/*  482 */     int iGoodsId = basicItem.getCfgId();
/*  483 */     int Count = Math.abs(basicItem.getNumber());
/*  484 */     int AfterCount = ItemInterface.getTotalItemNumberById(roleid, basicItem.getCfgId(), false);
/*  485 */     int Reason = logArg.logReason.value;
/*  486 */     long SubReason = logArg.subReason;
/*  487 */     int AddOrReduce = addOrRemove ? 0 : 1;
/*      */     
/*  489 */     if ((logArg.getCurrencytype2num() != null) && (logArg.getCurrencytype2num().size() > 0))
/*      */     {
/*  491 */       for (Map.Entry<CurrencyType, Integer> c2n : logArg.getCurrencytype2num().entrySet())
/*      */       {
/*      */ 
/*  494 */         long sequence = logArg.getSequence();
/*      */         
/*  496 */         long iMoney = Math.abs(((Integer)c2n.getValue()).intValue());
/*  497 */         int iMoneyType = ((CurrencyType)c2n.getKey()).value;
/*      */         
/*  499 */         Object[] columnns = { Integer.valueOf(rolelevel), Long.valueOf(sequence), Integer.valueOf(iGoodsType), Integer.valueOf(iGoodsId), Integer.valueOf(Count), Integer.valueOf(AfterCount), Integer.valueOf(Reason), Long.valueOf(SubReason), Long.valueOf(iMoney), Integer.valueOf(iMoneyType), Integer.valueOf(AddOrReduce), Long.valueOf(roleid), Long.valueOf(basicItem.getTlogUuid()) };
/*      */         
/*      */ 
/*  502 */         TLogManager.getInstance().addLog(roleid, "ItemFlow", columnns);
/*      */       }
/*      */       
/*      */     }
/*      */     else
/*      */     {
/*  508 */       long sequence = 0L;
/*  509 */       int iMoney = 0;
/*  510 */       int iMoneyType = 0;
/*      */       
/*  512 */       Object[] columnns = { Integer.valueOf(rolelevel), Long.valueOf(sequence), Integer.valueOf(iGoodsType), Integer.valueOf(iGoodsId), Integer.valueOf(Count), Integer.valueOf(AfterCount), Integer.valueOf(Reason), Long.valueOf(SubReason), Integer.valueOf(iMoney), Integer.valueOf(iMoneyType), Integer.valueOf(AddOrReduce), Long.valueOf(roleid), Long.valueOf(basicItem.getTlogUuid()) };
/*      */       
/*  514 */       TLogManager.getInstance().addLog(roleid, "ItemFlow", columnns);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void logEquip(long roleid, int equipmentid, EquipmentLogStatus status, Integer strengthlevel, String... extras)
/*      */   {
/*  531 */     int platform = RoleInterface.getPlatform(roleid);
/*  532 */     String channel = RoleInterface.getChannel(roleid);
/*  533 */     String mac = RoleInterface.getMac(roleid);
/*      */     
/*  535 */     String userid = RoleInterface.getUserId(roleid);
/*  536 */     int rolelevel = RoleInterface.getLevel(roleid);
/*      */     
/*  538 */     Object[] args = new Object[9 + extras.length];
/*  539 */     args[0] = Integer.valueOf(platform);
/*  540 */     args[1] = channel;
/*  541 */     args[2] = mac;
/*  542 */     args[3] = userid;
/*  543 */     args[4] = Long.valueOf(roleid);
/*  544 */     args[5] = Integer.valueOf(rolelevel);
/*  545 */     args[6] = Integer.valueOf(equipmentid);
/*  546 */     args[7] = Integer.valueOf(status.value);
/*  547 */     args[8] = (strengthlevel + "");
/*  548 */     int i = 9;
/*  549 */     StringBuffer sb = new StringBuffer("%d|%s|%s|%s|%d|%d|%d|%d|%s");
/*  550 */     for (String ex : extras)
/*      */     {
/*  552 */       args[(i++)] = ex;
/*  553 */       sb.append("|%s");
/*      */     }
/*      */     
/*  556 */     String logStr = String.format(sb.toString(), args);
/*  557 */     LogManager.getInstance().addLog("equipment", logStr);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogEquipmake(long roleid, int itemid, int cutyuanbao, long uuid, int skillid, int eqpid, int noskillcount)
/*      */   {
/*  571 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  572 */     String userid = RoleInterface.getUserId(roleid);
/*  573 */     int rolelevel = RoleInterface.getLevel(roleid);
/*      */     
/*  575 */     int wearPos = ItemConfigManager.getWearPos(itemid);
/*      */     
/*  577 */     Object[] columnns = { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(itemid), Integer.valueOf(cutyuanbao), Long.valueOf(uuid), Integer.valueOf(wearPos), Integer.valueOf(skillid), Integer.valueOf(eqpid), Integer.valueOf(noskillcount) };
/*      */     
/*  579 */     TLogManager.getInstance().addLog(roleid, "Equipmake", columnns);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogEquipqilin(long roleid, int itemid, int newstrengthlevel, int oldstrengthlevel, int wearstate, long uuid, int successRate, int randomNum)
/*      */   {
/*  594 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  595 */     String userid = RoleInterface.getUserId(roleid);
/*  596 */     int rolelevel = RoleInterface.getLevel(roleid);
/*  597 */     int wearPos = ItemConfigManager.getWearPos(itemid);
/*  598 */     Object[] columnns = { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(itemid), Integer.valueOf(newstrengthlevel), Integer.valueOf(oldstrengthlevel), Integer.valueOf(wearstate), Long.valueOf(uuid), Integer.valueOf(wearPos), Integer.valueOf(successRate), Integer.valueOf(randomNum) };
/*      */     
/*  600 */     TLogManager.getInstance().addLog(roleid, "Equipqilin", columnns);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogEquipfuhun(long roleid, int itemid, int newstrengthlevel, List<XExtraProBean> newExtraProBeans, int oldstrengthlevel, List<XExtraProBean> oldExtraProBeans, int remitemid, long uuid, long removeuuid)
/*      */   {
/*  615 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  616 */     String userid = RoleInterface.getUserId(roleid);
/*  617 */     int rolelevel = RoleInterface.getLevel(roleid);
/*      */     
/*  619 */     StringBuffer newPro = new StringBuffer("");
/*  620 */     if ((newExtraProBeans != null) && (!newExtraProBeans.isEmpty()))
/*      */     {
/*  622 */       for (XExtraProBean e : newExtraProBeans)
/*      */       {
/*      */ 
/*  625 */         newPro.append(e.getProtype() + "=" + e.getProvalue()).append("#");
/*      */       }
/*      */     }
/*      */     
/*  629 */     StringBuffer oldPro = new StringBuffer("");
/*  630 */     if ((oldExtraProBeans != null) && (!oldExtraProBeans.isEmpty()))
/*      */     {
/*  632 */       for (XExtraProBean e : oldExtraProBeans)
/*      */       {
/*      */ 
/*  635 */         oldPro.append(e.getProtype() + "=" + e.getProvalue()).append("#");
/*      */       }
/*      */     }
/*      */     
/*  639 */     int wearPos = ItemConfigManager.getWearPos(itemid);
/*  640 */     Object[] columnns = { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(itemid), Integer.valueOf(newstrengthlevel), newPro.toString(), Integer.valueOf(oldstrengthlevel), oldPro.toString(), Integer.valueOf(remitemid), Long.valueOf(uuid), Long.valueOf(removeuuid), Integer.valueOf(wearPos) };
/*      */     
/*  642 */     TLogManager.getInstance().addLog(roleid, "Equipfuhun", columnns);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogEquiptransferlin(long roleid, int itemid, int newstrengthlevel, int oldstrengthlevel, int srcitemid, long uuid, long srcuuid, String oldExtraString, String newExtraString)
/*      */   {
/*  658 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  659 */     String userid = RoleInterface.getUserId(roleid);
/*  660 */     int rolelevel = RoleInterface.getLevel(roleid);
/*  661 */     int wearPos = ItemConfigManager.getWearPos(itemid);
/*  662 */     Object[] columnns = { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(itemid), Integer.valueOf(newstrengthlevel), Integer.valueOf(oldstrengthlevel), Integer.valueOf(srcitemid), Long.valueOf(uuid), Long.valueOf(srcuuid), Integer.valueOf(wearPos), oldExtraString, newExtraString };
/*      */     
/*  664 */     TLogManager.getInstance().addLog(roleid, "Equiptransferlin", columnns);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogEquiphunrefresh(long roleid, int itemid, List<XExtraProBean> newExtraProBeans, List<XExtraProBean> oldExtraProBeans, long uuid)
/*      */   {
/*  679 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  680 */     String userid = RoleInterface.getUserId(roleid);
/*  681 */     int rolelevel = RoleInterface.getLevel(roleid);
/*      */     
/*  683 */     StringBuffer newPro = new StringBuffer("");
/*  684 */     if ((newExtraProBeans != null) && (!newExtraProBeans.isEmpty()))
/*      */     {
/*  686 */       for (XExtraProBean e : newExtraProBeans)
/*      */       {
/*      */ 
/*  689 */         newPro.append(e.getProtype() + "=" + e.getProvalue()).append("#");
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  694 */     StringBuffer oldPro = new StringBuffer("");
/*  695 */     if ((oldExtraProBeans != null) && (!oldExtraProBeans.isEmpty()))
/*      */     {
/*  697 */       for (XExtraProBean e : oldExtraProBeans)
/*      */       {
/*      */ 
/*  700 */         oldPro.append(e.getProtype() + "=" + e.getProvalue()).append("#");
/*      */       }
/*      */     }
/*      */     
/*  704 */     int wearPos = ItemConfigManager.getWearPos(itemid);
/*  705 */     Object[] columnns = { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(itemid), newPro.toString(), oldPro.toString(), Long.valueOf(uuid), Integer.valueOf(wearPos) };
/*      */     
/*      */ 
/*      */ 
/*  709 */     TLogManager.getInstance().addLog(roleid, "Equiphunrefresh", columnns);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean useItemLevel(long roleId, int level)
/*      */   {
/*  721 */     return RoleInterface.getLevel(roleId) >= level;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean useItemOccupation(long roleId, int equipOccupation)
/*      */   {
/*  734 */     return useItemOccupation(RoleInterface.getOccupationId(roleId), equipOccupation);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean useItemOccupation(int roleOcp, int equipOccupation)
/*      */   {
/*  748 */     if (equipOccupation == 0)
/*      */     {
/*  750 */       return true;
/*      */     }
/*  752 */     return roleOcp == equipOccupation;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean useItemSex(long roleId, int gender)
/*      */   {
/*  765 */     if (0 == gender)
/*      */     {
/*  767 */       return true;
/*      */     }
/*  769 */     return RoleInterface.getGender(roleId) == gender;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void sendWrongInfo(long roleid, int resCode, String... params)
/*      */   {
/*  781 */     SCommonErrorInfo sCommonErrorInfo = new SCommonErrorInfo();
/*  782 */     sCommonErrorInfo.errorcode = resCode;
/*  783 */     for (String param : params)
/*      */     {
/*  785 */       sCommonErrorInfo.params.add(param);
/*      */     }
/*  787 */     OnlineManager.getInstance().sendAtOnce(roleid, sCommonErrorInfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean fillInItemInfoBean(ItemInfo iteminfo, Item xItem)
/*      */   {
/*  798 */     iteminfo.id = xItem.getCfgid();
/*  799 */     iteminfo.number = xItem.getNumber();
/*  800 */     iteminfo.flag = xItem.getFlags();
/*      */     
/*  802 */     iteminfo.extramap.putAll(xItem.getExtra());
/*  803 */     iteminfo.extrainfomap.put(Integer.valueOf(ItemStoreEnum.MARKET_BUY_TIME.getStoreType()), Long.valueOf(xItem.getMarketbuytime()));
/*  804 */     Integer Pri = (Integer)xItem.getExtra().get(Integer.valueOf(ItemStoreEnum.SHANGHUI_PRICE.getStoreType()));
/*  805 */     if (Pri != null)
/*      */     {
/*  807 */       iteminfo.extramap.put(Integer.valueOf(ItemStoreEnum.SHANGHUI_PRICE.getStoreType()), Integer.valueOf(new BasicItem(xItem).getShangHuiPrice()));
/*      */     }
/*  809 */     for (XExtraProBean xExtraProBean : xItem.getExtraprolist())
/*      */     {
/*  811 */       ExtraProBean extraProBean = new ExtraProBean();
/*  812 */       extraProBean.protype = xExtraProBean.getProtype();
/*  813 */       extraProBean.provalue = xExtraProBean.getProvalue();
/*  814 */       extraProBean.islock = xExtraProBean.getIslock();
/*  815 */       iteminfo.exprolist.add(extraProBean);
/*      */     }
/*  817 */     for (Map.Entry<Integer, xbean.TempExtraProInfo> entry : xItem.getTempextrapropinfos().entrySet())
/*      */     {
/*  819 */       xbean.TempExtraProInfo xTempExtraProInfo = (xbean.TempExtraProInfo)entry.getValue();
/*  820 */       mzm.gsp.item.TempExtraProInfo tempExtraProInfo = new mzm.gsp.item.TempExtraProInfo();
/*  821 */       tempExtraProInfo.protype = xTempExtraProInfo.getProtype();
/*  822 */       tempExtraProInfo.provalue = xTempExtraProInfo.getProvalue();
/*  823 */       iteminfo.extraprops.put(entry.getKey(), tempExtraProInfo);
/*      */     }
/*  825 */     for (xbean.FumoInfo f : xItem.getFumoprolist())
/*      */     {
/*  827 */       mzm.gsp.item.FumoInfo fi = new mzm.gsp.item.FumoInfo();
/*  828 */       fi.addvalue = f.getAddvalue();
/*  829 */       fi.protype = f.getProtype();
/*  830 */       fi.timeout = f.getTimeout();
/*      */       
/*  832 */       iteminfo.fumoprolist.add(fi);
/*      */     }
/*      */     
/*  835 */     iteminfo.super_equipment_cost_bean.stage_cost_map.putAll(xItem.getSuperequipmentcostbean().getStage_cost_map());
/*  836 */     iteminfo.super_equipment_cost_bean.level_cost_map.putAll(xItem.getSuperequipmentcostbean().getLevel_cost_map());
/*      */     
/*  838 */     for (Map.Entry<Integer, xbean.JewelInfo> entry : xItem.getJewelmap().entrySet())
/*      */     {
/*  840 */       mzm.gsp.item.JewelInfo jewelInfo = new mzm.gsp.item.JewelInfo(((xbean.JewelInfo)entry.getValue()).getJewelcfgid());
/*  841 */       iteminfo.jewelmap.put(entry.getKey(), jewelInfo);
/*      */     }
/*      */     
/*  844 */     if (xItem.getUuid().isEmpty())
/*      */     {
/*  846 */       return false;
/*      */     }
/*  848 */     List<Long> uuidList = new ArrayList(xItem.getUuid());
/*  849 */     Collections.sort(uuidList);
/*  850 */     iteminfo.uuid.add(uuidList.get(0));
/*      */     
/*  852 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static ItemInfo getItemInfo(long roleId, int bagId, int key)
/*      */   {
/*  866 */     RoleItemBag bag = getBag(roleId, bagId);
/*  867 */     if (bag == null)
/*      */     {
/*  869 */       return null;
/*      */     }
/*  871 */     Item xItem = (Item)bag.getItems().get(Integer.valueOf(key));
/*  872 */     if (xItem == null)
/*      */     {
/*  874 */       return null;
/*      */     }
/*  876 */     ItemInfo itemInfo = new ItemInfo();
/*  877 */     if (!fillInItemInfoBean(itemInfo, xItem))
/*      */     {
/*  879 */       return null;
/*      */     }
/*  881 */     return itemInfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static ItemInfo getItemInfo(long roleId, long uuid, boolean islocked)
/*      */   {
/*  895 */     RoleItemBag bag = getBag(roleId, 340600000, islocked);
/*  896 */     if (bag != null)
/*      */     {
/*  898 */       BasicItem item = bag.getItemByUuid(uuid);
/*  899 */       if (item != null)
/*      */       {
/*  901 */         ItemInfo itemInfo = new ItemInfo();
/*  902 */         fillInItemInfoBean(itemInfo, item.getItem());
/*  903 */         return itemInfo;
/*      */       }
/*      */     }
/*      */     
/*  907 */     bag = getBag(roleId, 340600001, islocked);
/*  908 */     if (bag != null)
/*      */     {
/*  910 */       BasicItem item = bag.getItemByUuid(uuid);
/*  911 */       if (item != null)
/*      */       {
/*  913 */         ItemInfo itemInfo = new ItemInfo();
/*  914 */         fillInItemInfoBean(itemInfo, item.getItem());
/*  915 */         return itemInfo;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  920 */     bag = getBag(roleId, 340600005, islocked);
/*  921 */     if (bag != null)
/*      */     {
/*  923 */       BasicItem item = bag.getItemByUuid(uuid);
/*  924 */       if (item != null)
/*      */       {
/*  926 */         ItemInfo itemInfo = new ItemInfo();
/*  927 */         fillInItemInfoBean(itemInfo, item.getItem());
/*  928 */         return itemInfo;
/*      */       }
/*      */     }
/*      */     
/*  932 */     bag = getBag(roleId, 340600007, islocked);
/*  933 */     if (bag != null)
/*      */     {
/*  935 */       BasicItem item = bag.getItemByUuid(uuid);
/*  936 */       if (item != null)
/*      */       {
/*  938 */         ItemInfo itemInfo = new ItemInfo();
/*  939 */         fillInItemInfoBean(itemInfo, item.getItem());
/*  940 */         return itemInfo;
/*      */       }
/*      */     }
/*      */     
/*  944 */     bag = getBag(roleId, 340600006, islocked);
/*  945 */     if (bag != null)
/*      */     {
/*  947 */       BasicItem item = bag.getItemByUuid(uuid);
/*  948 */       if (item != null)
/*      */       {
/*  950 */         ItemInfo itemInfo = new ItemInfo();
/*  951 */         fillInItemInfoBean(itemInfo, item.getItem());
/*  952 */         return itemInfo;
/*      */       }
/*      */     }
/*      */     
/*  956 */     bag = getBag(roleId, 340600008, islocked);
/*  957 */     if (bag != null)
/*      */     {
/*  959 */       BasicItem item = bag.getItemByUuid(uuid);
/*  960 */       if (item != null)
/*      */       {
/*  962 */         ItemInfo itemInfo = new ItemInfo();
/*  963 */         fillInItemInfoBean(itemInfo, item.getItem());
/*  964 */         return itemInfo;
/*      */       }
/*      */     }
/*      */     
/*  968 */     bag = getBag(roleId, 340600009, islocked);
/*  969 */     if (bag != null)
/*      */     {
/*  971 */       BasicItem item = bag.getItemByUuid(uuid);
/*  972 */       if (item != null)
/*      */       {
/*  974 */         ItemInfo itemInfo = new ItemInfo();
/*  975 */         fillInItemInfoBean(itemInfo, item.getItem());
/*  976 */         return itemInfo;
/*      */       }
/*      */     }
/*      */     
/*  980 */     List<RoleStorageBag> bags = getAllRoleStorageBags(roleId, islocked);
/*  981 */     for (RoleStorageBag storageBag : bags)
/*      */     {
/*  983 */       if (storageBag != null)
/*      */       {
/*  985 */         BasicItem item = storageBag.getItemByUuid(uuid);
/*  986 */         if (item != null)
/*      */         {
/*  988 */           ItemInfo itemInfo = new ItemInfo();
/*  989 */           fillInItemInfoBean(itemInfo, item.getItem());
/*  990 */           return itemInfo;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  995 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static RoleItemBag getBag(long roleid, int bagid, boolean islocked)
/*      */   {
/* 1010 */     Bag xmybag = null;
/* 1011 */     if ((bagid == 340600000) || (bagid == 340600001) || (bagid == 340600005) || (bagid == 340600006) || (bagid == 340600007) || (bagid == 340600008) || (bagid == 340600009))
/*      */     {
/*      */ 
/* 1014 */       SBagCfg bagCfg = SBagCfg.get(bagid);
/* 1015 */       if ((bagCfg == null) || (bagCfg.id == 0) || (bagCfg.initcapacity == 0) || (bagCfg.classname.length() <= 0) || (bagCfg.type != 1))
/*      */       {
/*      */ 
/*      */ 
/* 1019 */         String logStr = String.format("[item]ItemManager.getBag@SBagCfg error,null|roleid=%d|bagid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(bagid) });
/* 1020 */         logger.error(logStr);
/*      */         
/* 1022 */         return null;
/*      */       }
/*      */       
/*      */ 
/* 1026 */       TTable<Long, Bag> table = (TTable)Xdb.getInstance().getTables().getTable(bagCfg.classname.trim());
/*      */       
/*      */ 
/* 1029 */       if (table == null)
/*      */       {
/* 1031 */         String logStr = String.format("[item]ItemManager.getBag@xtable error|roleid=%d|bagid=%d|tablename=%s", new Object[] { Long.valueOf(roleid), Integer.valueOf(bagid), bagCfg.classname });
/*      */         
/* 1033 */         logger.error(logStr);
/* 1034 */         return null;
/*      */       }
/* 1036 */       if (islocked)
/*      */       {
/* 1038 */         xmybag = (Bag)table.get(Long.valueOf(roleid));
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/* 1043 */         xmybag = (Bag)table.select(Long.valueOf(roleid), new TField()
/*      */         {
/*      */           public Bag get(Bag v)
/*      */           {
/* 1047 */             return v.toData();
/*      */           }
/*      */           
/*      */         });
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/* 1055 */       SStorageCfg storageCfg = SStorageCfg.get(bagid);
/* 1056 */       if ((storageCfg == null) || (storageCfg.id == 0) || (storageCfg.classname.length() <= 0))
/*      */       {
/* 1058 */         String logStr = String.format("[item]ItemManager.getBag@SStorageCfg error,null|roleid=%d|bagid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(bagid) });
/*      */         
/* 1060 */         logger.info(logStr);
/* 1061 */         return null;
/*      */       }
/*      */       
/*      */ 
/* 1065 */       TTable<Long, Bag> table = (TTable)Xdb.getInstance().getTables().getTable(storageCfg.classname.trim());
/*      */       
/* 1067 */       if (table == null)
/*      */       {
/* 1069 */         String logStr = String.format("[item]ItemManager.getBag@xtable error|roleid=%d|bagid=%d|tablename=%s", new Object[] { Long.valueOf(roleid), Integer.valueOf(bagid), storageCfg.classname });
/*      */         
/* 1071 */         logger.info(logStr);
/* 1072 */         return null;
/*      */       }
/* 1074 */       if (islocked)
/*      */       {
/* 1076 */         xmybag = (Bag)table.get(Long.valueOf(roleid));
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/* 1081 */         xmybag = (Bag)table.select(Long.valueOf(roleid), new TField()
/*      */         {
/*      */           public Bag get(Bag v)
/*      */           {
/* 1085 */             return v.toData();
/*      */           }
/*      */         });
/*      */       }
/*      */     }
/*      */     
/* 1091 */     if (xmybag == null)
/*      */     {
/* 1093 */       String logStr = String.format("[item]ItemManager.getBag@role bag error,null|roleid=%d|bagid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(bagid) });
/* 1094 */       logger.info(logStr);
/* 1095 */       return null;
/*      */     }
/* 1097 */     if (bagid == 340600000)
/*      */     {
/* 1099 */       return new RoleItemBag(xmybag, roleid);
/*      */     }
/* 1101 */     if (bagid == 340600001)
/*      */     {
/* 1103 */       return new RoleEquipBag(xmybag);
/*      */     }
/* 1105 */     if (bagid == 340600005)
/*      */     {
/* 1107 */       return new SuperEquipmentJewelBag(xmybag);
/*      */     }
/* 1109 */     if (bagid == 340600006)
/*      */     {
/* 1111 */       return new RoleFaBaoBag(xmybag);
/*      */     }
/* 1113 */     if (bagid == 340600007)
/*      */     {
/* 1115 */       return new RoleChangeModelCardBag(xmybag);
/*      */     }
/* 1117 */     if (bagid == 340600008)
/*      */     {
/* 1119 */       return new RoleTreasureBag(xmybag);
/*      */     }
/* 1121 */     if (bagid == 340600009)
/*      */     {
/* 1123 */       return new RolePetMarkBag(xmybag);
/*      */     }
/*      */     
/*      */ 
/* 1127 */     return new RoleStorageBag(xmybag, bagid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static RoleItemBag getBag(long roleid, int bagid)
/*      */   {
/* 1134 */     return getBag(roleid, bagid, true);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean createRoleItemBag(long roleid, int bagid)
/*      */   {
/* 1142 */     SBagCfg bagCfg = SBagCfg.get(bagid);
/* 1143 */     if ((bagCfg == null) || (bagCfg.id == 0) || (bagCfg.initcapacity == 0) || (bagCfg.classname.length() <= 0) || (bagCfg.type != 1))
/*      */     {
/*      */ 
/* 1146 */       String logStr = String.format("[item]ItemManager.createRoleItemBag@SBagCfg error,null|roleid=%d|bagid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(bagid) });
/*      */       
/* 1148 */       logger.error(logStr);
/* 1149 */       return false;
/*      */     }
/*      */     
/*      */ 
/* 1153 */     TTable<Long, Bag> table = (TTable)Xdb.getInstance().getTables().getTable(bagCfg.classname.trim());
/*      */     
/*      */ 
/* 1156 */     if (table == null)
/*      */     {
/* 1158 */       String logStr = String.format("[item]ItemManager.createRoleItemBag@xtable error|roleid=%d|bagid=%d|tablename=%s", new Object[] { Long.valueOf(roleid), Integer.valueOf(bagid), bagCfg.classname });
/*      */       
/* 1160 */       logger.error(logStr);
/*      */       
/* 1162 */       return false;
/*      */     }
/*      */     
/* 1165 */     Bag xmybag = (Bag)table.get(Long.valueOf(roleid));
/* 1166 */     if (xmybag == null)
/*      */     {
/* 1168 */       xmybag = Pod.newBag();
/* 1169 */       xmybag.setCapacity(bagCfg.initcapacity);
/* 1170 */       table.insert(Long.valueOf(roleid), xmybag);
/* 1171 */       return true;
/*      */     }
/* 1173 */     String logStr = String.format("[item]ItemManager.createRoleItemBag@create role bag error|roleid=%d|bagid=%d|tablename=%s", new Object[] { Long.valueOf(roleid), Integer.valueOf(bagid), bagCfg.classname });
/*      */     
/*      */ 
/* 1176 */     logger.error(logStr);
/* 1177 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static RoleStorageBag getRoleStorageBag(long roleid, int bagid)
/*      */   {
/* 1185 */     SStorageCfg storageCfg = SStorageCfg.get(bagid);
/* 1186 */     if ((storageCfg == null) || (storageCfg.id == 0) || (storageCfg.classname.length() <= 0))
/*      */     {
/* 1188 */       String logStr = String.format("[item]ItemManager.getRoleStorageBag@SStorageCfg error,null|roleid=%d|bagid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(bagid) });
/*      */       
/* 1190 */       logger.info(logStr);
/* 1191 */       return null;
/*      */     }
/*      */     
/*      */ 
/* 1195 */     TTable<Long, Bag> table = (TTable)Xdb.getInstance().getTables().getTable(storageCfg.classname.trim());
/*      */     
/*      */ 
/* 1198 */     if (table == null)
/*      */     {
/* 1200 */       String logStr = String.format("[item]ItemManager.getRoleStorageBag@xtable error|roleid=%d|bagid=%d|tablename=%s", new Object[] { Long.valueOf(roleid), Integer.valueOf(bagid), storageCfg.classname });
/*      */       
/* 1202 */       logger.info(logStr);
/*      */       
/* 1204 */       return null;
/*      */     }
/* 1206 */     Bag xmybag = (Bag)table.get(Long.valueOf(roleid));
/* 1207 */     if (xmybag == null)
/*      */     {
/* 1209 */       String logStr = String.format("[item]ItemManager.getRoleStorageBag@xtable error|roleid=%d|bagid=%d|tablename=%s", new Object[] { Long.valueOf(roleid), Integer.valueOf(bagid), storageCfg.classname });
/*      */       
/* 1211 */       logger.info(logStr);
/*      */       
/* 1213 */       return null;
/*      */     }
/*      */     
/* 1216 */     return new RoleStorageBag(xmybag, bagid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean createRoleStorageBag(long roleid, int bagid)
/*      */   {
/* 1225 */     SStorageCfg storageCfg = SStorageCfg.get(bagid);
/* 1226 */     if ((storageCfg == null) || (storageCfg.id == 0) || (storageCfg.classname.length() <= 0))
/*      */     {
/* 1228 */       String logStr = String.format("[item]ItemManager.createRoleStorageBag@SStorageCfg error,null|roleid=%d|bagid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(bagid) });
/*      */       
/* 1230 */       logger.error(logStr);
/*      */       
/* 1232 */       return false;
/*      */     }
/*      */     
/*      */ 
/* 1236 */     TTable<Long, Bag> table = (TTable)Xdb.getInstance().getTables().getTable(storageCfg.classname.trim());
/*      */     
/*      */ 
/* 1239 */     if (table == null)
/*      */     {
/* 1241 */       String logStr = String.format("[item]ItemManager.createRoleStorageBag@xtable error|roleid=%d|bagid=%d|tablename=%s", new Object[] { Long.valueOf(roleid), Integer.valueOf(bagid), storageCfg.classname });
/*      */       
/*      */ 
/* 1244 */       logger.error(logStr);
/*      */       
/* 1246 */       return false;
/*      */     }
/* 1248 */     Bag xmybag = (Bag)table.get(Long.valueOf(roleid));
/*      */     
/* 1250 */     if (xmybag == null)
/*      */     {
/*      */ 
/* 1253 */       xmybag = Pod.newBag();
/* 1254 */       xmybag.setCapacity(storageCfg.initcapacity);
/* 1255 */       xmybag.setBagname(storageCfg.name);
/* 1256 */       table.insert(Long.valueOf(roleid), xmybag);
/* 1257 */       return true;
/*      */     }
/*      */     
/*      */ 
/* 1261 */     String logStr = String.format("[item]ItemManager.createRoleStorageBag@xtable error,null|roleid=%d|bagid=%d|tablename=%s", new Object[] { Long.valueOf(roleid), Integer.valueOf(bagid), storageCfg.classname });
/*      */     
/*      */ 
/* 1264 */     logger.error(logStr);
/* 1265 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static RoleItemBag getRoleItemBag(long roleId)
/*      */   {
/* 1280 */     return getBag(roleId, 340600000);
/*      */   }
/*      */   
/*      */ 
/*      */   static RoleEquipBag getRoleEquipBag(long roleId)
/*      */   {
/* 1286 */     RoleItemBag roleItemBag = getBag(roleId, 340600001);
/* 1287 */     if ((roleItemBag == null) || (!(roleItemBag instanceof RoleEquipBag)))
/*      */     {
/* 1289 */       return null;
/*      */     }
/* 1291 */     return (RoleEquipBag)roleItemBag;
/*      */   }
/*      */   
/*      */ 
/*      */   static int getRoleStorageBagSize(long roleId, boolean islocked)
/*      */   {
/* 1297 */     int size = 0;
/*      */     
/* 1299 */     for (SStorageCfg storageCfg : SStorageCfg.getAll().values())
/*      */     {
/* 1301 */       TTable<Long, Bag> table = (TTable)Xdb.getInstance().getTables().getTable(storageCfg.classname.trim());
/* 1302 */       Bag bag = null;
/* 1303 */       if (islocked)
/*      */       {
/* 1305 */         bag = (Bag)table.get(Long.valueOf(roleId));
/*      */       }
/*      */       else
/*      */       {
/* 1309 */         bag = (Bag)table.select(Long.valueOf(roleId), new TField()
/*      */         {
/*      */           public Bag get(Bag v)
/*      */           {
/* 1313 */             return v.toData();
/*      */           }
/*      */         });
/*      */       }
/*      */       
/* 1318 */       if (bag != null)
/*      */       {
/* 1320 */         size++;
/*      */       }
/*      */     }
/* 1323 */     return size;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static List<RoleStorageBag> getAllRoleStorageBags(long roleid, boolean islocked)
/*      */   {
/* 1330 */     List<RoleStorageBag> bags = new ArrayList();
/*      */     
/* 1332 */     for (SStorageCfg storageCfg : SStorageCfg.getAll().values())
/*      */     {
/* 1334 */       TTable<Long, Bag> table = (TTable)Xdb.getInstance().getTables().getTable(storageCfg.classname.trim());
/* 1335 */       Bag bag = null;
/* 1336 */       if (islocked)
/*      */       {
/* 1338 */         bag = (Bag)table.get(Long.valueOf(roleid));
/*      */       }
/*      */       else
/*      */       {
/* 1342 */         bag = (Bag)table.select(Long.valueOf(roleid), new TField()
/*      */         {
/*      */           public Bag get(Bag v)
/*      */           {
/* 1346 */             return v.toData();
/*      */           }
/*      */         });
/*      */       }
/* 1350 */       if (bag != null)
/*      */       {
/*      */ 
/*      */ 
/* 1354 */         bags.add(new RoleStorageBag(bag, storageCfg.id));
/*      */       }
/*      */     }
/* 1357 */     return bags;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static RoleStorageBag getRoleStorageBag(long roleid, int storageid, boolean islocked)
/*      */   {
/* 1366 */     SStorageCfg storageCfg = SStorageCfg.get(storageid);
/* 1367 */     if (storageCfg == null)
/*      */     {
/* 1369 */       return null;
/*      */     }
/* 1371 */     TTable<Long, Bag> table = (TTable)Xdb.getInstance().getTables().getTable(storageCfg.classname.trim());
/* 1372 */     Bag bag = null;
/* 1373 */     if (islocked)
/*      */     {
/* 1375 */       bag = (Bag)table.get(Long.valueOf(roleid));
/* 1376 */       if (bag == null)
/*      */       {
/* 1378 */         return null;
/*      */       }
/*      */       
/*      */     }
/*      */     else
/*      */     {
/* 1384 */       bag = (Bag)table.select(Long.valueOf(roleid), new TField()
/*      */       {
/*      */         public Bag get(Bag v)
/*      */         {
/* 1388 */           return v.toData();
/*      */         }
/*      */       });
/* 1391 */       if (bag == null)
/*      */       {
/* 1393 */         return null;
/*      */       }
/*      */     }
/*      */     
/* 1397 */     return new RoleStorageBag(bag, storageid);
/*      */   }
/*      */   
/*      */ 
/*      */   static SuperEquipmentJewelBag getSuperEquipmentJewelBag(long roleId)
/*      */   {
/* 1403 */     return (SuperEquipmentJewelBag)getBag(roleId, 340600005);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getItemUseCount(long roleid, int itemid)
/*      */   {
/* 1415 */     ItemUseCount itemUseCount = Role2itemusecount.get(Long.valueOf(roleid));
/* 1416 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 1417 */     if (itemUseCount == null)
/*      */     {
/* 1419 */       itemUseCount = Pod.newItemUseCount();
/* 1420 */       itemUseCount.setCleartime(now);
/* 1421 */       Role2itemusecount.insert(Long.valueOf(roleid), itemUseCount);
/*      */     }
/* 1423 */     Integer oldUsedCount = (Integer)itemUseCount.getId2count().get(Integer.valueOf(itemid));
/* 1424 */     if (oldUsedCount == null)
/*      */     {
/* 1426 */       oldUsedCount = Integer.valueOf(0);
/*      */     }
/* 1428 */     long cleartime = itemUseCount.getCleartime();
/* 1429 */     if (!DateTimeUtils.isInSameDay(now, cleartime))
/*      */     {
/* 1431 */       itemUseCount.setCleartime(now);
/* 1432 */       itemUseCount.getId2count().clear();
/*      */       
/* 1434 */       String logStr = String.format("ItemManager.getItemUseCount@reset item use count success|roleid=%d|cleartime=%d|now=%d|itemid=%d|oldUsedCount=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(cleartime), Long.valueOf(now), Integer.valueOf(itemid), oldUsedCount });
/*      */       
/*      */ 
/* 1437 */       logger.info(logStr);
/*      */       
/* 1439 */       return 0;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1444 */     return oldUsedCount.intValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean addItemUseCount(long roleid, int itemid, int count)
/*      */   {
/* 1460 */     if (count <= 0)
/*      */     {
/* 1462 */       return false;
/*      */     }
/* 1464 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 1465 */     ItemUseCount itemUseCount = Role2itemusecount.get(Long.valueOf(roleid));
/* 1466 */     if (itemUseCount == null)
/*      */     {
/* 1468 */       itemUseCount = Pod.newItemUseCount();
/* 1469 */       itemUseCount.setCleartime(now);
/* 1470 */       Role2itemusecount.insert(Long.valueOf(roleid), itemUseCount);
/*      */     }
/* 1472 */     Integer oldUsedCount = (Integer)itemUseCount.getId2count().get(Integer.valueOf(itemid));
/* 1473 */     if (oldUsedCount == null)
/*      */     {
/* 1475 */       oldUsedCount = Integer.valueOf(0);
/*      */     }
/* 1477 */     if (!DateTimeUtils.isInSameDay(now, itemUseCount.getCleartime()))
/*      */     {
/* 1479 */       itemUseCount.setCleartime(now);
/* 1480 */       itemUseCount.getId2count().clear();
/*      */       
/* 1482 */       String logStr = String.format("ItemManager.addItemUseCount@reset item use count success|roleid=%d|cleartime=%d|now=%d|itemid=%d|oldUsedCount=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(itemUseCount.getCleartime()), Long.valueOf(now), Integer.valueOf(itemid), oldUsedCount });
/*      */       
/*      */ 
/* 1485 */       logger.info(logStr);
/*      */     }
/*      */     
/*      */ 
/* 1489 */     Integer c = (Integer)itemUseCount.getId2count().get(Integer.valueOf(itemid));
/* 1490 */     if (c == null)
/*      */     {
/* 1492 */       itemUseCount.getId2count().put(Integer.valueOf(itemid), Integer.valueOf(count));
/*      */     }
/*      */     else
/*      */     {
/* 1496 */       itemUseCount.getId2count().put(Integer.valueOf(itemid), Integer.valueOf(count + c.intValue()));
/*      */     }
/*      */     
/* 1499 */     String logStr = String.format("ItemManager.addItemUseCount@add item use count success|roleid=%d|oldUsedCount=%d|newUsedCount=%d|addNum=%d|itemid=%d", new Object[] { Long.valueOf(roleid), oldUsedCount, itemUseCount.getId2count().get(Integer.valueOf(itemid)), Integer.valueOf(count), Integer.valueOf(itemid) });
/*      */     
/*      */ 
/* 1502 */     logger.info(logStr);
/*      */     
/* 1504 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getItemCarryMax(int itemid)
/*      */   {
/* 1515 */     SItemCfg itemCfg = SItemCfg.get(itemid);
/* 1516 */     if ((itemCfg instanceof SGangFileItem))
/*      */     {
/* 1518 */       SGangFileItem gangFileItem = (SGangFileItem)itemCfg;
/* 1519 */       return gangFileItem.carrymax;
/*      */     }
/* 1521 */     if ((itemCfg instanceof SMarriageSugerItem))
/*      */     {
/* 1523 */       SMarriageSugerItem marriageSugerItem = (SMarriageSugerItem)itemCfg;
/* 1524 */       return marriageSugerItem.carrymax;
/*      */     }
/* 1526 */     return 0;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean addSystemAward(Map<Integer, Integer> itemid2count, long starttime, long endtime, Map<Integer, Integer> type2value, Map<Integer, String> mailcontemMap)
/*      */   {
/* 1542 */     long cur = DateTimeUtils.getCurrTimeInMillis();
/*      */     
/* 1544 */     if (starttime >= endtime)
/*      */     {
/* 1546 */       return false;
/*      */     }
/* 1548 */     if (endtime < cur)
/*      */     {
/* 1550 */       return false; }
/*      */     Iterator i$;
/* 1552 */     if ((itemid2count != null) && (itemid2count.size() > 0))
/*      */     {
/* 1554 */       for (i$ = itemid2count.keySet().iterator(); i$.hasNext();) { int itemid = ((Integer)i$.next()).intValue();
/*      */         
/* 1556 */         if (!ItemInterface.isItemExist(itemid))
/*      */         {
/* 1558 */           return false;
/*      */         }
/* 1560 */         if (((Integer)itemid2count.get(Integer.valueOf(itemid))).intValue() <= 0)
/*      */         {
/* 1562 */           return false; }
/*      */       }
/*      */     }
/*      */     Iterator i$;
/* 1566 */     if ((type2value != null) && (type2value.size() > 0))
/*      */     {
/* 1568 */       for (i$ = type2value.keySet().iterator(); i$.hasNext();) { int type = ((Integer)i$.next()).intValue();
/*      */         
/* 1570 */         if (((Integer)type2value.get(Integer.valueOf(type))).intValue() <= 0)
/*      */         {
/* 1572 */           return false;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1577 */     SystemAwards systemAwards = Systemaward.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 1578 */     if (systemAwards == null)
/*      */     {
/* 1580 */       systemAwards = Pod.newSystemAwards();
/* 1581 */       Systemaward.insert(Long.valueOf(GameServerInfoManager.getLocalId()), systemAwards);
/*      */     }
/*      */     
/*      */ 
/* 1585 */     List<Long> toremoveAwardBeans = new ArrayList();
/* 1586 */     for (Long key : systemAwards.getAwards().keySet())
/*      */     {
/* 1588 */       SystemAwardBean systemAwardBean = (SystemAwardBean)systemAwards.getAwards().get(key);
/*      */       
/* 1590 */       if (systemAwardBean.getEndtime() < cur)
/*      */       {
/* 1592 */         toremoveAwardBeans.add(key);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1597 */     for (Long key : toremoveAwardBeans)
/*      */     {
/* 1599 */       systemAwards.getAwards().remove(key);
/*      */     }
/*      */     
/* 1602 */     SystemAwardBean awardBean = Pod.newSystemAwardBean();
/* 1603 */     awardBean.setEndtime(endtime);
/* 1604 */     awardBean.setStarttime(starttime);
/* 1605 */     if ((mailcontemMap != null) && (mailcontemMap.size() > 0))
/*      */     {
/* 1607 */       awardBean.getContentmap().putAll(mailcontemMap);
/*      */     }
/* 1609 */     if ((type2value != null) && (type2value.size() > 0))
/*      */     {
/* 1611 */       awardBean.getType2value().putAll(type2value);
/*      */     }
/* 1613 */     if ((itemid2count != null) && (itemid2count.size() > 0))
/*      */     {
/* 1615 */       awardBean.getItemid2count().putAll(itemid2count);
/*      */     }
/*      */     
/* 1618 */     systemAwards.setSequence(systemAwards.getSequence() + 1L);
/*      */     
/* 1620 */     systemAwards.getAwards().put(Long.valueOf(systemAwards.getSequence()), awardBean);
/* 1621 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean offerSystemAwards(long roleid)
/*      */   {
/* 1632 */     Sysawards rolesysawards = Role2sysaward.get(Long.valueOf(roleid));
/* 1633 */     if (rolesysawards == null)
/*      */     {
/* 1635 */       rolesysawards = Pod.newSysawards();
/* 1636 */       Role2sysaward.insert(Long.valueOf(roleid), rolesysawards);
/*      */     }
/*      */     
/* 1639 */     long cur = DateTimeUtils.getCurrTimeInMillis();
/* 1640 */     SystemAwards systemAwards = Systemaward.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 1641 */     if (systemAwards == null)
/*      */     {
/* 1643 */       return false;
/*      */     }
/* 1645 */     List<Long> toremoves = new ArrayList();
/* 1646 */     for (Long key : systemAwards.getAwards().keySet())
/*      */     {
/* 1648 */       SystemAwardBean systemAwardBean = (SystemAwardBean)systemAwards.getAwards().get(key);
/* 1649 */       if (systemAwardBean.getEndtime() < cur)
/*      */       {
/* 1651 */         toremoves.add(key);
/* 1652 */         rolesysawards.getAwardids().remove(key);
/*      */ 
/*      */       }
/* 1655 */       else if (!rolesysawards.getAwardids().contains(key))
/*      */       {
/*      */ 
/*      */ 
/* 1659 */         rolesysawards.getAwardids().add(key);
/* 1660 */         MailAttachment mailAttachment = MailInterface.createMailAttachment();
/* 1661 */         mailAttachment.addItemMap(systemAwardBean.getItemid2count());
/* 1662 */         Integer gold = (Integer)systemAwardBean.getType2value().get(Integer.valueOf(2));
/* 1663 */         if ((gold != null) && (gold.intValue() > 0))
/*      */         {
/* 1665 */           mailAttachment.setGold(gold.intValue());
/*      */         }
/* 1667 */         Integer silver = (Integer)systemAwardBean.getType2value().get(Integer.valueOf(1));
/* 1668 */         if ((silver != null) && (silver.intValue() > 0))
/*      */         {
/* 1670 */           mailAttachment.setSilver(silver.intValue());
/*      */         }
/* 1672 */         Integer awardyuanbao = (Integer)systemAwardBean.getType2value().get(Integer.valueOf(4));
/* 1673 */         if ((awardyuanbao != null) && (awardyuanbao.intValue() > 0))
/*      */         {
/* 1675 */           mailAttachment.setBindYuanBao(awardyuanbao.intValue());
/*      */         }
/* 1677 */         TLogArg logArg = new TLogArg(LogReason.GM_ADD);
/*      */         
/* 1679 */         MailInterface.synBuildAndSendMail(roleid, 1, (String)systemAwardBean.getContentmap().get(Integer.valueOf(1000)), (String)systemAwardBean.getContentmap().get(Integer.valueOf(1001)), mailAttachment, logArg);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1684 */     for (Long key : toremoves)
/*      */     {
/* 1686 */       systemAwards.getAwards().remove(key);
/*      */     }
/* 1688 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   static void tlogBagExpend(long roleid, int bagtype, int beforecapacity, int aftercapacity)
/*      */   {
/* 1694 */     String logname = "BagExpend";
/* 1695 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 1696 */     String userid = RoleInterface.getUserId(roleid);
/* 1697 */     int rolelevel = RoleInterface.getLevel(roleid);
/*      */     
/* 1699 */     Object[] columnns = { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(bagtype), Integer.valueOf(beforecapacity), Integer.valueOf(aftercapacity) };
/* 1700 */     TLogManager.getInstance().addLog(roleid, logname, columnns);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean addMoneyWithinMax(long roleId, TLogArg tLogArg, int value, int moneyType)
/*      */   {
/* 1714 */     ModMoneyResult modRes = null;
/* 1715 */     int res = -1;
/* 1716 */     switch (moneyType)
/*      */     {
/*      */     case 2: 
/* 1719 */       modRes = RoleInterface.addGoldWithinMax(roleId, value, tLogArg);
/* 1720 */       res = 21;
/* 1721 */       break;
/*      */     case 3: 
/* 1723 */       modRes = RoleInterface.addSilverWithinMax(roleId, value, tLogArg);
/* 1724 */       res = 22;
/* 1725 */       break;
/*      */     case 5: 
/* 1727 */       modRes = RoleInterface.addGoldIngotInAll(roleId, value, tLogArg, true);
/* 1728 */       res = 27;
/* 1729 */       break;
/*      */     case 4: default: 
/* 1731 */       return false;
/*      */     }
/* 1733 */     if (!modRes.isSucceed())
/*      */     {
/* 1735 */       if (modRes.getRes() == ModMoneyResult.ErrorResult.ERROR_MONEY_NUM_HAS_REACH_TOP_LIMIT)
/*      */       {
/* 1737 */         AwardInterface.sendNormalRet(roleId, res, true, new String[0]);
/*      */       }
/* 1739 */       return false;
/*      */     }
/* 1741 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void triggerGetItemEvent(long roleId, ItemOperateResult itemOperateResult, TLogArg logArg)
/*      */   {
/* 1754 */     TriggerEventsManger.getInstance().triggerEvent(new GainItemEvent(), new GainItemeArg(roleId, itemOperateResult, logArg));
/*      */     
/* 1756 */     triggerGetEquipSkillEvent(roleId, itemOperateResult, logArg);
/*      */   }
/*      */   
/*      */   static void triggerGetEquipSkillEvent(long roleId, ItemOperateResult itemOperateResult, TLogArg logArg)
/*      */   {
/* 1761 */     for (ItemOperateResult.ChangeItemInfo changeItemInfo : itemOperateResult.getChangeItemInfoList())
/*      */     {
/* 1763 */       if ((changeItemInfo.basicItem instanceof EquipmentItem))
/*      */       {
/* 1765 */         Integer equipSkillId = changeItemInfo.basicItem.getExtra(ItemStoreEnum.EQUIP_SKILL);
/* 1766 */         if (equipSkillId != null)
/*      */         {
/*      */ 
/*      */ 
/* 1770 */           TriggerEventsManger.getInstance().triggerEvent(new EquipSkillGet(), new EquipSkillGetArg(roleId, changeItemInfo.basicItem.getCfgId(), equipSkillId.intValue()));
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void triggerRemoveItemEvent(long roleId, ItemOperateResult itemOperateResult, TLogArg logArg)
/*      */   {
/* 1786 */     TriggerEventsManger.getInstance().triggerEvent(new RemoveItemEvent(), new RemoveItemeArg(roleId, itemOperateResult, logArg));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void fillXItem(Item xDesItem, Item xItem)
/*      */   {
/* 1799 */     xDesItem.setCfgid(xItem.getCfgid());
/* 1800 */     xDesItem.setFlags(xItem.getFlags());
/* 1801 */     xDesItem.setNumber(xItem.getNumber());
/* 1802 */     xDesItem.setMarketbuytime(xItem.getMarketbuytime());
/* 1803 */     xDesItem.getExtra().putAll(xItem.getExtra());
/* 1804 */     for (XExtraProBean xb : xItem.getExtraprolist())
/*      */     {
/* 1806 */       XExtraProBean t = Pod.newXExtraProBean();
/* 1807 */       t.setIslock(xb.getIslock());
/* 1808 */       t.setProtype(xb.getProtype());
/* 1809 */       t.setProvalue(xb.getProvalue());
/* 1810 */       xDesItem.getExtraprolist().add(t);
/*      */     }
/* 1812 */     for (xbean.FumoInfo fu : xItem.getFumoprolist())
/*      */     {
/* 1814 */       xbean.FumoInfo fumoInfo = Pod.newFumoInfo();
/* 1815 */       fumoInfo.setAddvalue(fu.getAddvalue());
/* 1816 */       fumoInfo.setProtype(fu.getProtype());
/* 1817 */       fumoInfo.setTimeout(fu.getTimeout());
/* 1818 */       xDesItem.getFumoprolist().add(fumoInfo);
/*      */     }
/* 1820 */     for (Map.Entry<Integer, xbean.TempExtraProInfo> entry : xItem.getTempextrapropinfos().entrySet())
/*      */     {
/* 1822 */       xbean.TempExtraProInfo xTempExtraProInfo = Pod.newTempExtraProInfo();
/* 1823 */       xTempExtraProInfo.setProtype(((xbean.TempExtraProInfo)entry.getValue()).getProtype());
/* 1824 */       xTempExtraProInfo.setProvalue(((xbean.TempExtraProInfo)entry.getValue()).getProvalue());
/* 1825 */       xDesItem.getTempextrapropinfos().put(entry.getKey(), xTempExtraProInfo);
/*      */     }
/*      */     
/* 1828 */     xDesItem.getUuid().addAll(xItem.getUuid());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogEquipOn(long roleid, BasicItem basicItem, int wearpos, int offitemid, long offuuid, int strengthLevel, TransferStrengthLevelBean transferStrengthLevelBean)
/*      */   {
/* 1849 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 1850 */     String userid = RoleInterface.getUserId(roleid);
/* 1851 */     int rolelevel = RoleInterface.getLevel(roleid);
/*      */     
/* 1853 */     int ocp = -1;
/* 1854 */     int ocpitemid = -1;
/* 1855 */     long ocpuuid = -1L;
/* 1856 */     int ocpstrengthlevel = strengthLevel;
/* 1857 */     if (transferStrengthLevelBean != null)
/*      */     {
/* 1859 */       ocp = transferStrengthLevelBean.getOcp();
/* 1860 */       ocpitemid = transferStrengthLevelBean.getItemId();
/* 1861 */       ocpuuid = transferStrengthLevelBean.getUuid();
/* 1862 */       ocpstrengthlevel = transferStrengthLevelBean.getStrengthLevel();
/*      */     }
/* 1864 */     Object[] columnns = { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(basicItem.getCfgId()), Integer.valueOf(wearpos), Long.valueOf(basicItem.getTlogUuid()), basicItem.getTlogExtraString(), basicItem.getTlogHunProString(), Integer.valueOf(offitemid), Long.valueOf(offuuid), Integer.valueOf(ocp), Integer.valueOf(ocpitemid), Long.valueOf(ocpuuid), Integer.valueOf(ocpstrengthlevel) };
/*      */     
/*      */ 
/* 1867 */     TLogManager.getInstance().addLog(roleid, "Equipon", columnns);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogEquipLockhun(String userId, long roleId, long equipUuid, int equipItemId, int bagid, int hunIndex, boolean isLock)
/*      */   {
/* 1876 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/* 1878 */     StringBuilder sbLog = new StringBuilder();
/* 1879 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 1880 */     sbLog.append(userId).append('|');
/* 1881 */     sbLog.append(roleId).append('|');
/* 1882 */     sbLog.append(roleLevel).append('|');
/*      */     
/* 1884 */     sbLog.append(equipUuid).append('|');
/* 1885 */     sbLog.append(equipItemId).append('|');
/* 1886 */     sbLog.append(bagid).append('|');
/* 1887 */     sbLog.append(hunIndex).append('|');
/* 1888 */     sbLog.append(isLock ? 1 : 0);
/*      */     
/* 1890 */     TLogManager.getInstance().addLog(roleId, "EquipLockhun", sbLog.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogEquipOff(long roleid, BasicItem basicItem, long toUnUUid, int wearpos)
/*      */   {
/* 1903 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 1904 */     String userid = RoleInterface.getUserId(roleid);
/* 1905 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 1906 */     Object[] columnns = { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(basicItem.getCfgId()), Integer.valueOf(wearpos), Long.valueOf(toUnUUid), basicItem.getTlogExtraString(), basicItem.getTlogHunProString() };
/*      */     
/* 1908 */     TLogManager.getInstance().addLog(roleid, "Equipoff", columnns);
/*      */   }
/*      */   
/*      */   static void sendSSynMoshouExchangeCountRes(long roleId, int exchangeCount)
/*      */   {
/* 1913 */     SSynMoshouExchangeCountRes res = new SSynMoshouExchangeCountRes();
/* 1914 */     res.exchangecount = exchangeCount;
/* 1915 */     res.canexchangemoshou = (exchangeCount >= ShimenActivityCfgConsts.getInstance().EXCHANGE_MOSHOU_MAX_COUNT ? 0 : 1);
/*      */     
/* 1917 */     OnlineManager.getInstance().send(roleId, res);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isRoleStateCanOperateItem(long roleid)
/*      */   {
/* 1928 */     return RoleStatusInterface.checkCanSetStatus(roleid, 147, true);
/*      */   }
/*      */   
/*      */   static boolean isWithSkill(Item xItem)
/*      */   {
/* 1933 */     return getSkillId(xItem) != 0;
/*      */   }
/*      */   
/*      */   static int getSkillId(Item xItem)
/*      */   {
/* 1938 */     Integer skill = (Integer)xItem.getExtra().get(Integer.valueOf(6));
/* 1939 */     if (skill == null)
/*      */     {
/* 1941 */       return 0;
/*      */     }
/* 1943 */     return skill.intValue();
/*      */   }
/*      */   
/*      */   static boolean randomEquipSkill(Item xItem)
/*      */   {
/* 1948 */     SItemEquipCfg sItemEquipCfg = SItemEquipCfg.get(xItem.getCfgid());
/* 1949 */     if (sItemEquipCfg == null)
/*      */     {
/* 1951 */       String logStr = String.format("[item]ItemManager.randomEquipSkill@equip generate skill error|itemid=%d", new Object[] { Integer.valueOf(xItem.getCfgid()) });
/*      */       
/* 1953 */       logger.error(logStr);
/* 1954 */       return false;
/*      */     }
/* 1956 */     int skillid = ItemConfigManager.randomEquipSkill(sItemEquipCfg.skillid);
/*      */     
/* 1958 */     if (skillid > 0)
/*      */     {
/* 1960 */       xItem.getExtra().put(Integer.valueOf(6), Integer.valueOf(skillid));
/* 1961 */       String logStr = String.format("[item]ItemManager.randomEquipSkill@equip generate skill|itemid=%d|skillid=%d", new Object[] { Integer.valueOf(xItem.getCfgid()), Integer.valueOf(skillid) });
/*      */       
/* 1963 */       logger.info(logStr);
/* 1964 */       return true;
/*      */     }
/*      */     
/*      */ 
/* 1968 */     String logStr = String.format("[item]ItemManager.randomEquipSkill@equip generate skill error|itemid=%d|skillid=%d", new Object[] { Integer.valueOf(xItem.getCfgid()), Integer.valueOf(skillid) });
/*      */     
/* 1970 */     logger.info(logStr);
/* 1971 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static void checkBaotuItem(Item xItem)
/*      */   {
/* 1977 */     if (xItem == null)
/*      */     {
/* 1979 */       return;
/*      */     }
/* 1981 */     if (SItemCangBaoTuCfg.get(xItem.getCfgid()) != null)
/*      */     {
/* 1983 */       BasicItem basicItem = getBasicItem(xItem);
/* 1984 */       if (basicItem == null)
/*      */       {
/* 1986 */         return;
/*      */       }
/*      */       
/* 1989 */       if ((basicItem instanceof BaoTuItem))
/*      */       {
/* 1991 */         BaoTuItem baoTuItem = (BaoTuItem)basicItem;
/* 1992 */         if (!MapInterface.isReachable(baoTuItem.getMapId().intValue(), baoTuItem.getX().intValue(), baoTuItem.getY().intValue()))
/*      */         {
/* 1994 */           baoTuItem.onCreateItem();
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void checkPrivateItem(Item xItem)
/*      */   {
/* 2004 */     if (xItem == null)
/*      */     {
/* 2006 */       return;
/*      */     }
/* 2008 */     if (ItemConfigManager.isProprietary(xItem.getCfgid()))
/*      */     {
/* 2010 */       xItem.setFlags(xItem.getFlags() | 0x1);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static EquipMode getXEquipMode(long roleid)
/*      */   {
/* 2017 */     EquipMode xEquipMode = Role2equipmode.get(Long.valueOf(roleid));
/* 2018 */     if (xEquipMode == null)
/*      */     {
/* 2020 */       xEquipMode = Pod.newEquipMode();
/* 2021 */       xEquipMode.setMode(0);
/* 2022 */       xEquipMode.setIsset(false);
/* 2023 */       Role2equipmode.insert(Long.valueOf(roleid), xEquipMode);
/*      */     }
/* 2025 */     return xEquipMode;
/*      */   }
/*      */   
/*      */   static void sendSSynEquipQilinModeRes(long roleid, int mode)
/*      */   {
/* 2030 */     SSynEquipQilinModeRes res = new SSynEquipQilinModeRes();
/* 2031 */     res.mode = mode;
/* 2032 */     OnlineManager.getInstance().send(roleid, res);
/*      */   }
/*      */   
/*      */   static void sendSEquipQiLinAccumulateModeRes(long roleid, EquipmentItem equipmentItem)
/*      */   {
/* 2037 */     SSynEquipQiLinOperateRes res = new SSynEquipQiLinOperateRes();
/* 2038 */     fillInItemInfoBean(res.iteminfo, equipmentItem.getItem());
/* 2039 */     res.strengthlevel = equipmentItem.getStrengthLevel();
/* 2040 */     OnlineManager.getInstance().send(roleid, res);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean checkQiLingLevel(long roleid, int itemKey, EquipmentItem equipmentItem, SItemEquipCfg itemEquipCfg)
/*      */   {
/* 2052 */     if (equipmentItem.getStrengthLevel() >= EquipItemCfgConsts.getInstance().EQUIP_QILIN_MAX_LIN_LEVEL)
/*      */     {
/* 2054 */       sendWrongInfo(roleid, 407, new String[0]);
/* 2055 */       String logstr = String.format("[item]ItemManager.checkQiLingLevel@strength level to global max|roleid=%d|key=%d|itemid=%d|curStrengthlevel=%d|maxstrengthlevel=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(itemKey), Integer.valueOf(equipmentItem.getCfgId()), Integer.valueOf(equipmentItem.getStrengthLevel()), Integer.valueOf(EquipItemCfgConsts.getInstance().EQUIP_QILIN_MAX_LIN_LEVEL) });
/*      */       
/*      */ 
/*      */ 
/* 2059 */       logger.error(logstr);
/* 2060 */       return false;
/*      */     }
/*      */     
/*      */ 
/* 2064 */     if (equipmentItem.getSuperEquipmentStage() > 0)
/*      */     {
/* 2066 */       int maxLevel = SuperEquipmentInterface.getMaxStrengthLevel(equipmentItem.getSuperEquipmentStage());
/* 2067 */       if (equipmentItem.getStrengthLevel() >= maxLevel)
/*      */       {
/* 2069 */         String logstr = String.format("ItemManager.checkQiLingLevel()@reach max strength level at current super equipment stage|roleid=%d|key=%d|curStrengthlevel=%d|stage=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(itemKey), Integer.valueOf(equipmentItem.getStrengthLevel()), Integer.valueOf(equipmentItem.getSuperEquipmentStage()) });
/*      */         
/*      */ 
/*      */ 
/* 2073 */         logger.error(logstr);
/* 2074 */         return false;
/*      */       }
/*      */       
/*      */ 
/* 2078 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 2084 */     SEquipTransferInherit equipTransferInherit = ItemConfigManager.getSEquipTransferHun(itemEquipCfg.useLevel);
/* 2085 */     if (equipTransferInherit == null)
/*      */     {
/* 2087 */       String logstr = String.format("[item]ItemManager.checkQiLingLevel@SEquipTransferInherit null|roleid=%d|key=%d|itemid=%d|uselevel=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(itemKey), Integer.valueOf(equipmentItem.getCfgId()), Integer.valueOf(itemEquipCfg.useLevel) });
/*      */       
/*      */ 
/* 2090 */       logger.error(logstr);
/* 2091 */       return false;
/*      */     }
/*      */     
/* 2094 */     if (equipmentItem.getStrengthLevel() >= equipTransferInherit.qilingMaxLevel)
/*      */     {
/* 2096 */       sendWrongInfo(roleid, 407, new String[0]);
/* 2097 */       String logstr = String.format("[item]ItemManager.checkQiLingLevel@strength level to phase max|roleid=%d|key=%d|itemid=%d|curStrengthlevel=%d|maxstrengthlevel=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(itemKey), Integer.valueOf(equipmentItem.getCfgId()), Integer.valueOf(equipmentItem.getStrengthLevel()), Integer.valueOf(equipTransferInherit.qilingMaxLevel) });
/*      */       
/*      */ 
/*      */ 
/* 2101 */       logger.error(logstr);
/* 2102 */       return false;
/*      */     }
/*      */     
/* 2105 */     return true;
/*      */   }
/*      */   
/*      */   static int getQiLinItemUseCount(int itemid, EquipmentItem equipmentItem)
/*      */   {
/* 2110 */     if (itemid == EquipItemCfgConsts.getInstance().QILIN_NEED_ITEM_ID)
/*      */     {
/* 2112 */       Integer qiLinZhuPoint = equipmentItem.getExtra(ItemStoreEnum.QILINZHU_USE_COUNT);
/* 2113 */       if (qiLinZhuPoint == null)
/*      */       {
/* 2115 */         qiLinZhuPoint = Integer.valueOf(0);
/*      */       }
/*      */       
/* 2118 */       return qiLinZhuPoint.intValue();
/*      */     }
/* 2120 */     if (itemid == EquipItemCfgConsts.getInstance().LUCKY_ITEM_ID)
/*      */     {
/* 2122 */       Integer xingYunShiPoint = equipmentItem.getExtra(ItemStoreEnum.XINGYUNSHI_USE_COUNT);
/* 2123 */       if (xingYunShiPoint == null)
/*      */       {
/* 2125 */         xingYunShiPoint = Integer.valueOf(0);
/*      */       }
/* 2127 */       return xingYunShiPoint.intValue();
/*      */     }
/* 2129 */     if (itemid == EquipItemCfgConsts.getInstance().ZHENLIN_STONE_ITEM_ID)
/*      */     {
/* 2131 */       Integer zhengLinShiPoint = equipmentItem.getExtra(ItemStoreEnum.ZHENGLINSHI_USE_COUNT);
/* 2132 */       if (zhengLinShiPoint == null)
/*      */       {
/* 2134 */         zhengLinShiPoint = Integer.valueOf(0);
/*      */       }
/* 2136 */       return zhengLinShiPoint.intValue();
/*      */     }
/*      */     
/*      */ 
/* 2140 */     return -1;
/*      */   }
/*      */   
/*      */ 
/*      */   static int addQiLinItemUseCount(int itemid, EquipmentItem equipmentItem, int addNum)
/*      */   {
/* 2146 */     if (itemid == EquipItemCfgConsts.getInstance().QILIN_NEED_ITEM_ID)
/*      */     {
/* 2148 */       Integer qiLinZhuPoint = equipmentItem.getExtra(ItemStoreEnum.QILINZHU_USE_COUNT);
/* 2149 */       if (qiLinZhuPoint == null)
/*      */       {
/* 2151 */         qiLinZhuPoint = Integer.valueOf(0);
/*      */       }
/* 2153 */       equipmentItem.setExtra(ItemStoreEnum.QILINZHU_USE_COUNT, qiLinZhuPoint.intValue() + addNum);
/* 2154 */       return qiLinZhuPoint.intValue() + addNum;
/*      */     }
/* 2156 */     if (itemid == EquipItemCfgConsts.getInstance().LUCKY_ITEM_ID)
/*      */     {
/* 2158 */       Integer xingYunShiPoint = equipmentItem.getExtra(ItemStoreEnum.XINGYUNSHI_USE_COUNT);
/* 2159 */       if (xingYunShiPoint == null)
/*      */       {
/* 2161 */         xingYunShiPoint = Integer.valueOf(0);
/*      */       }
/* 2163 */       equipmentItem.setExtra(ItemStoreEnum.XINGYUNSHI_USE_COUNT, xingYunShiPoint.intValue() + addNum);
/* 2164 */       return xingYunShiPoint.intValue() + addNum;
/*      */     }
/* 2166 */     if (itemid == EquipItemCfgConsts.getInstance().ZHENLIN_STONE_ITEM_ID)
/*      */     {
/* 2168 */       Integer zhengLinShiPoint = equipmentItem.getExtra(ItemStoreEnum.ZHENGLINSHI_USE_COUNT);
/* 2169 */       if (zhengLinShiPoint == null)
/*      */       {
/* 2171 */         zhengLinShiPoint = Integer.valueOf(0);
/*      */       }
/* 2173 */       equipmentItem.setExtra(ItemStoreEnum.ZHENGLINSHI_USE_COUNT, zhengLinShiPoint.intValue() + addNum);
/* 2174 */       return zhengLinShiPoint.intValue() + addNum;
/*      */     }
/*      */     
/*      */ 
/* 2178 */     return -1;
/*      */   }
/*      */   
/*      */ 
/*      */   static int getQiLinToalPoint(EquipmentItem equipmentItem, SQiLinAccumulateModeCfg sQiLinAccumulateModeCfg)
/*      */   {
/* 2184 */     int totalPoint = 0;
/* 2185 */     Integer canNotUse = equipmentItem.getExtra(ItemStoreEnum.CAN_ADD_INIT_QILIN_SCORE);
/* 2186 */     if (canNotUse == null)
/*      */     {
/* 2188 */       totalPoint += sQiLinAccumulateModeCfg.initScore;
/*      */     }
/*      */     
/* 2191 */     Integer restPoint = equipmentItem.getExtra(ItemStoreEnum.ACCUMULATION_QILIN_SCORE);
/* 2192 */     if (restPoint == null)
/*      */     {
/* 2194 */       restPoint = Integer.valueOf(0);
/*      */     }
/* 2196 */     totalPoint += restPoint.intValue();
/* 2197 */     Integer qiLinCount1 = equipmentItem.getExtra(ItemStoreEnum.QILINZHU_USE_COUNT);
/* 2198 */     if (qiLinCount1 == null)
/*      */     {
/* 2200 */       qiLinCount1 = Integer.valueOf(0);
/*      */     }
/* 2202 */     totalPoint += qiLinCount1.intValue() * ((Integer)sQiLinAccumulateModeCfg.itemid2Point.get(Integer.valueOf(EquipItemCfgConsts.getInstance().QILIN_NEED_ITEM_ID))).intValue();
/*      */     
/*      */ 
/* 2205 */     Integer qiLinCount2 = equipmentItem.getExtra(ItemStoreEnum.XINGYUNSHI_USE_COUNT);
/* 2206 */     if (qiLinCount2 == null)
/*      */     {
/* 2208 */       qiLinCount2 = Integer.valueOf(0);
/*      */     }
/* 2210 */     totalPoint += qiLinCount2.intValue() * ((Integer)sQiLinAccumulateModeCfg.itemid2Point.get(Integer.valueOf(EquipItemCfgConsts.getInstance().LUCKY_ITEM_ID))).intValue();
/*      */     
/* 2212 */     Integer qiLinCount3 = equipmentItem.getExtra(ItemStoreEnum.ZHENGLINSHI_USE_COUNT);
/* 2213 */     if (qiLinCount3 == null)
/*      */     {
/* 2215 */       qiLinCount3 = Integer.valueOf(0);
/*      */     }
/* 2217 */     totalPoint += qiLinCount3.intValue() * ((Integer)sQiLinAccumulateModeCfg.itemid2Point.get(Integer.valueOf(EquipItemCfgConsts.getInstance().ZHENLIN_STONE_ITEM_ID))).intValue();
/*      */     
/* 2219 */     return totalPoint;
/*      */   }
/*      */   
/*      */ 
/*      */   static int computeQiLingLevelUpNeedItemNum(EquipmentItem equipmentItem, SQiLinAccumulateModeCfg sQiLinAccumulateModeCfg, int itemid)
/*      */   {
/* 2225 */     int totalPint = getQiLinToalPoint(equipmentItem, sQiLinAccumulateModeCfg);
/* 2226 */     int delta = sQiLinAccumulateModeCfg.needScore - totalPint;
/* 2227 */     if (delta <= 0)
/*      */     {
/* 2229 */       return 0;
/*      */     }
/* 2231 */     Integer point = (Integer)sQiLinAccumulateModeCfg.itemid2Point.get(Integer.valueOf(itemid));
/* 2232 */     if ((point == null) || (point.intValue() == 0))
/*      */     {
/* 2234 */       return -1;
/*      */     }
/* 2236 */     return (delta - 1) / point.intValue() + 1;
/*      */   }
/*      */   
/*      */ 
/*      */   static void doStrength(long roleid, int wearState, int bagid, EquipmentItem equipmentItem, int restPoint)
/*      */   {
/* 2242 */     int curStrengthLevel = equipmentItem.getStrengthLevel();
/* 2243 */     equipmentItem.setStrengthLevel(curStrengthLevel + 1);
/* 2244 */     equipmentItem.clearQilinAccumulationPoint();
/* 2245 */     equipmentItem.setExtra(ItemStoreEnum.ACCUMULATION_QILIN_SCORE, restPoint);
/* 2246 */     equipmentItem.clearCanNotUseQiLinInitPoint();
/* 2247 */     logEquip(roleid, equipmentItem.getCfgId(), EquipmentLogStatus.EQUIP_QILIN, Integer.valueOf(equipmentItem.getStrengthLevel()), new String[0]);
/* 2248 */     tlogEquipqilin(roleid, equipmentItem.getCfgId(), equipmentItem.getStrengthLevel(), curStrengthLevel, wearState, equipmentItem.getTlogUuid(), 10000, -1);
/*      */     
/* 2250 */     sendQilinBulletin(roleid, equipmentItem);
/* 2251 */     TriggerEventsManger.getInstance().triggerEvent(new EquipQiLin(), new EquipQiLinArg(roleid, bagid, ((Long)equipmentItem.getUuid().iterator().next()).longValue(), curStrengthLevel, equipmentItem.getStrengthLevel()));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogEquipqilinAccumulation(long roleid, String userId, int oldStrengthLevel, EquipmentItem equipmentItem, int used_itemid, int used_item_num, int cut_yuanbao, String oldExtraString)
/*      */   {
/* 2272 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 2273 */     int rolelevel = RoleInterface.getLevel(roleid);
/*      */     
/* 2275 */     Object[] columnns = { vGameIP, userId, Long.valueOf(roleid), Integer.valueOf(rolelevel), Long.valueOf(equipmentItem.getTlogUuid()), Integer.valueOf(equipmentItem.getCfgId()), Integer.valueOf(used_itemid), Integer.valueOf(used_item_num), Integer.valueOf(cut_yuanbao), Integer.valueOf(oldStrengthLevel), Integer.valueOf(equipmentItem.getStrengthLevel()), oldExtraString, equipmentItem.getAccumulationQiLinExtraString() };
/*      */     
/*      */ 
/* 2278 */     TLogManager.getInstance().addLog(roleid, "EquipqilinAccumulation", columnns);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean cutMoney(String userid, long roleId, LogReason logReason, int subReason, int moneyType, int moneyNum, CostType costType)
/*      */   {
/* 2299 */     if (moneyNum <= 0)
/*      */     {
/* 2301 */       return false;
/*      */     }
/* 2303 */     TLogArg logArg = new TLogArg(logReason, subReason);
/* 2304 */     switch (moneyType)
/*      */     {
/*      */     case 3: 
/* 2307 */       if (!RoleInterface.cutSilver(roleId, moneyNum, logArg))
/*      */       {
/* 2309 */         return false;
/*      */       }
/*      */       break;
/*      */     case 2: 
/* 2313 */       if (!RoleInterface.cutGold(roleId, moneyNum, logArg))
/*      */       {
/* 2315 */         return false;
/*      */       }
/*      */       
/*      */       break;
/*      */     case 5: 
/* 2320 */       if (!RoleInterface.cutGoldIngot(roleId, moneyNum, logArg))
/*      */       {
/* 2322 */         return false;
/*      */       }
/*      */       break;
/*      */     case 1: 
/* 2326 */       if (costType == null)
/*      */       {
/* 2328 */         return false;
/*      */       }
/* 2330 */       CostResult costResult = QingfuInterface.costYuanbao(userid, roleId, moneyNum, costType, logArg);
/* 2331 */       if (costResult != CostResult.Success)
/*      */       {
/* 2333 */         return false;
/*      */       }
/*      */       break;
/*      */     case 4: 
/* 2337 */       if (!GangInterface.cutBangGong(roleId, moneyNum, logArg))
/*      */       {
/* 2339 */         return false;
/*      */       }
/*      */       break;
/*      */     default: 
/* 2343 */       return false;
/*      */     }
/*      */     
/* 2346 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   static void transferEquipAccumulationQilinInfo(EquipmentItem srcEquipmentItem, EquipmentItem desEquipmentItem)
/*      */   {
/* 2352 */     desEquipmentItem.setStrengthLevel(srcEquipmentItem.getStrengthLevel());
/* 2353 */     srcEquipmentItem.setStrengthLevel(0);
/* 2354 */     Integer accumulation_score = srcEquipmentItem.getExtra(ItemStoreEnum.ACCUMULATION_QILIN_SCORE);
/* 2355 */     if (accumulation_score != null)
/*      */     {
/* 2357 */       srcEquipmentItem.removeExtra(ItemStoreEnum.ACCUMULATION_QILIN_SCORE);
/* 2358 */       desEquipmentItem.setExtra(ItemStoreEnum.ACCUMULATION_QILIN_SCORE, accumulation_score.intValue());
/*      */     }
/*      */     else
/*      */     {
/* 2362 */       desEquipmentItem.removeExtra(ItemStoreEnum.ACCUMULATION_QILIN_SCORE);
/*      */     }
/*      */     
/* 2365 */     Integer qi_linzhu_use_count = srcEquipmentItem.getExtra(ItemStoreEnum.QILINZHU_USE_COUNT);
/* 2366 */     if (qi_linzhu_use_count != null)
/*      */     {
/* 2368 */       srcEquipmentItem.removeExtra(ItemStoreEnum.QILINZHU_USE_COUNT);
/* 2369 */       desEquipmentItem.setExtra(ItemStoreEnum.QILINZHU_USE_COUNT, qi_linzhu_use_count.intValue());
/*      */     }
/*      */     else
/*      */     {
/* 2373 */       desEquipmentItem.removeExtra(ItemStoreEnum.QILINZHU_USE_COUNT);
/*      */     }
/*      */     
/* 2376 */     Integer zhen_lin_shi_use_count = srcEquipmentItem.getExtra(ItemStoreEnum.ZHENGLINSHI_USE_COUNT);
/* 2377 */     if (zhen_lin_shi_use_count != null)
/*      */     {
/* 2379 */       srcEquipmentItem.removeExtra(ItemStoreEnum.ZHENGLINSHI_USE_COUNT);
/* 2380 */       desEquipmentItem.setExtra(ItemStoreEnum.ZHENGLINSHI_USE_COUNT, zhen_lin_shi_use_count.intValue());
/*      */     }
/*      */     else
/*      */     {
/* 2384 */       desEquipmentItem.removeExtra(ItemStoreEnum.ZHENGLINSHI_USE_COUNT);
/*      */     }
/*      */     
/* 2387 */     Integer xinyun_shi_use_count = srcEquipmentItem.getExtra(ItemStoreEnum.XINGYUNSHI_USE_COUNT);
/* 2388 */     if (xinyun_shi_use_count != null)
/*      */     {
/* 2390 */       srcEquipmentItem.removeExtra(ItemStoreEnum.XINGYUNSHI_USE_COUNT);
/* 2391 */       desEquipmentItem.setExtra(ItemStoreEnum.XINGYUNSHI_USE_COUNT, xinyun_shi_use_count.intValue());
/*      */     }
/*      */     else
/*      */     {
/* 2395 */       desEquipmentItem.removeExtra(ItemStoreEnum.XINGYUNSHI_USE_COUNT);
/*      */     }
/*      */     
/* 2398 */     Integer can_add_init_score = srcEquipmentItem.getExtra(ItemStoreEnum.CAN_ADD_INIT_QILIN_SCORE);
/* 2399 */     if (can_add_init_score != null)
/*      */     {
/* 2401 */       srcEquipmentItem.removeExtra(ItemStoreEnum.CAN_ADD_INIT_QILIN_SCORE);
/* 2402 */       desEquipmentItem.setExtra(ItemStoreEnum.CAN_ADD_INIT_QILIN_SCORE, can_add_init_score.intValue());
/*      */     }
/*      */     else
/*      */     {
/* 2406 */       desEquipmentItem.removeExtra(ItemStoreEnum.CAN_ADD_INIT_QILIN_SCORE);
/*      */     }
/*      */   }
/*      */   
/*      */   static void exchangeEquipAccumulationQilinInfo(EquipmentItem srcEquipmentItem, EquipmentItem desEquipmentItem)
/*      */   {
/* 2412 */     int temp = desEquipmentItem.getStrengthLevel();
/* 2413 */     desEquipmentItem.setStrengthLevel(srcEquipmentItem.getStrengthLevel());
/* 2414 */     srcEquipmentItem.setStrengthLevel(temp);
/*      */     
/* 2416 */     Integer src_accumulation_score = srcEquipmentItem.removeExtra(ItemStoreEnum.ACCUMULATION_QILIN_SCORE);
/* 2417 */     Integer des_accumulation_score = desEquipmentItem.removeExtra(ItemStoreEnum.ACCUMULATION_QILIN_SCORE);
/* 2418 */     if (src_accumulation_score != null)
/*      */     {
/* 2420 */       desEquipmentItem.setExtra(ItemStoreEnum.ACCUMULATION_QILIN_SCORE, src_accumulation_score.intValue());
/*      */     }
/* 2422 */     if (des_accumulation_score != null)
/*      */     {
/* 2424 */       srcEquipmentItem.setExtra(ItemStoreEnum.ACCUMULATION_QILIN_SCORE, des_accumulation_score.intValue());
/*      */     }
/*      */     
/* 2427 */     Integer src_qi_linzhu_use_count = srcEquipmentItem.removeExtra(ItemStoreEnum.QILINZHU_USE_COUNT);
/* 2428 */     Integer des_qi_linzhu_use_count = desEquipmentItem.removeExtra(ItemStoreEnum.QILINZHU_USE_COUNT);
/* 2429 */     if (src_qi_linzhu_use_count != null)
/*      */     {
/* 2431 */       desEquipmentItem.setExtra(ItemStoreEnum.QILINZHU_USE_COUNT, src_qi_linzhu_use_count.intValue());
/*      */     }
/* 2433 */     if (des_qi_linzhu_use_count != null)
/*      */     {
/* 2435 */       srcEquipmentItem.setExtra(ItemStoreEnum.QILINZHU_USE_COUNT, des_qi_linzhu_use_count.intValue());
/*      */     }
/*      */     
/* 2438 */     Integer src_zhen_lin_shi_use_count = srcEquipmentItem.removeExtra(ItemStoreEnum.ZHENGLINSHI_USE_COUNT);
/* 2439 */     Integer des_zhen_lin_shi_use_count = desEquipmentItem.removeExtra(ItemStoreEnum.ZHENGLINSHI_USE_COUNT);
/* 2440 */     if (src_zhen_lin_shi_use_count != null)
/*      */     {
/* 2442 */       desEquipmentItem.setExtra(ItemStoreEnum.ZHENGLINSHI_USE_COUNT, src_zhen_lin_shi_use_count.intValue());
/*      */     }
/* 2444 */     if (des_zhen_lin_shi_use_count != null)
/*      */     {
/* 2446 */       srcEquipmentItem.setExtra(ItemStoreEnum.ZHENGLINSHI_USE_COUNT, des_zhen_lin_shi_use_count.intValue());
/*      */     }
/*      */     
/* 2449 */     Integer src_xinyun_shi_use_count = srcEquipmentItem.removeExtra(ItemStoreEnum.XINGYUNSHI_USE_COUNT);
/* 2450 */     Integer des_xinyun_shi_use_count = desEquipmentItem.removeExtra(ItemStoreEnum.XINGYUNSHI_USE_COUNT);
/* 2451 */     if (src_xinyun_shi_use_count != null)
/*      */     {
/* 2453 */       desEquipmentItem.setExtra(ItemStoreEnum.XINGYUNSHI_USE_COUNT, src_xinyun_shi_use_count.intValue());
/*      */     }
/* 2455 */     if (des_xinyun_shi_use_count != null)
/*      */     {
/* 2457 */       srcEquipmentItem.setExtra(ItemStoreEnum.XINGYUNSHI_USE_COUNT, des_xinyun_shi_use_count.intValue());
/*      */     }
/*      */     
/* 2460 */     Integer src_can_add_init_score = srcEquipmentItem.removeExtra(ItemStoreEnum.CAN_ADD_INIT_QILIN_SCORE);
/* 2461 */     Integer des_can_add_init_score = desEquipmentItem.removeExtra(ItemStoreEnum.CAN_ADD_INIT_QILIN_SCORE);
/* 2462 */     if (src_can_add_init_score != null)
/*      */     {
/* 2464 */       desEquipmentItem.setExtra(ItemStoreEnum.CAN_ADD_INIT_QILIN_SCORE, src_can_add_init_score.intValue());
/*      */     }
/* 2466 */     if (des_can_add_init_score != null)
/*      */     {
/* 2468 */       srcEquipmentItem.setExtra(ItemStoreEnum.CAN_ADD_INIT_QILIN_SCORE, des_can_add_init_score.intValue());
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static void sendQilinBulletin(long roleid, EquipmentItem equipmentItem)
/*      */   {
/* 2475 */     if (equipmentItem.getStrengthLevel() >= EquipItemCfgConsts.getInstance().EQUIP_ANNOUNCE_MIN_LIN_LEVEL)
/*      */     {
/*      */ 
/* 2478 */       SBulletinInfo bulletinInfo = new SBulletinInfo();
/* 2479 */       bulletinInfo.bulletintype = 4;
/* 2480 */       bulletinInfo.params.put(Integer.valueOf(1), RoleInterface.getName(roleid));
/* 2481 */       bulletinInfo.params.put(Integer.valueOf(4), String.valueOf(equipmentItem.getCfgId()));
/* 2482 */       bulletinInfo.params.put(Integer.valueOf(6), String.valueOf(equipmentItem.getStrengthLevel()));
/* 2483 */       BulletinInterface.sendBulletin(bulletinInfo);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isExpBottleSwitchOpen(long roleId)
/*      */   {
/* 2497 */     if (!OpenInterface.getOpenStatus(312))
/*      */     {
/* 2499 */       return false;
/*      */     }
/*      */     
/* 2502 */     if (OpenInterface.isBanPlay(roleId, 312))
/*      */     {
/* 2504 */       OpenInterface.sendBanPlayMsg(roleId, 312);
/* 2505 */       return false;
/*      */     }
/*      */     
/* 2508 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isDoubleItemSwitchOpen(long roleId)
/*      */   {
/* 2521 */     if (!OpenInterface.getOpenStatus(315))
/*      */     {
/* 2523 */       return false;
/*      */     }
/*      */     
/* 2526 */     if (OpenInterface.isBanPlay(roleId, 315))
/*      */     {
/* 2528 */       OpenInterface.sendBanPlayMsg(roleId, 315);
/* 2529 */       return false;
/*      */     }
/*      */     
/* 2532 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean checkTimeIsValid(Item xItem)
/*      */   {
/* 2546 */     if (xItem == null)
/*      */     {
/* 2548 */       return false;
/*      */     }
/*      */     
/* 2551 */     int itemCfgId = xItem.getCfgid();
/*      */     
/*      */ 
/* 2554 */     STimeEffectItemCfg sTimeEffectItemCfg = STimeEffectItemCfg.get(itemCfgId);
/* 2555 */     if (sTimeEffectItemCfg == null)
/*      */     {
/* 2557 */       return true;
/*      */     }
/*      */     
/* 2560 */     if ((sTimeEffectItemCfg.item_time_type == 2) || (sTimeEffectItemCfg.item_time_type == 3))
/*      */     {
/*      */ 
/* 2563 */       Map<Integer, Integer> xExtraMap = xItem.getExtra();
/* 2564 */       Integer endTime = (Integer)xExtraMap.get(Integer.valueOf(231));
/* 2565 */       if (endTime == null)
/*      */       {
/* 2567 */         return true;
/*      */       }
/*      */       
/* 2570 */       if (endTime.intValue() <= DateTimeUtils.getCurrTimeInMillis() / 1000L)
/*      */       {
/* 2572 */         return false;
/*      */       }
/*      */     }
/* 2575 */     else if (sTimeEffectItemCfg.item_time_type == 1)
/*      */     {
/* 2577 */       STimePointCommonCfg sBeginTimePointCommonCfg = STimePointCommonCfg.get(sTimeEffectItemCfg.begin_effect_time_cfg_id);
/* 2578 */       STimePointCommonCfg sEndTimePointCommonCfg = STimePointCommonCfg.get(sTimeEffectItemCfg.end_effect_time_cfg_id);
/* 2579 */       if ((sBeginTimePointCommonCfg == null) && (sEndTimePointCommonCfg == null))
/*      */       {
/* 2581 */         return false;
/*      */       }
/*      */       
/* 2584 */       int begingTime = sBeginTimePointCommonCfg == null ? 0 : (int)(TimeCommonUtil.getTimePoint(sBeginTimePointCommonCfg) / 1000L);
/*      */       
/* 2586 */       int endTime = sEndTimePointCommonCfg == null ? 0 : (int)(TimeCommonUtil.getTimePoint(sEndTimePointCommonCfg) / 1000L);
/*      */       
/*      */ 
/* 2589 */       int currentTime = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/* 2590 */       if (((currentTime < begingTime) && (begingTime > 0)) || ((currentTime > endTime) && (endTime > 0)))
/*      */       {
/* 2592 */         return false;
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/* 2597 */       return false;
/*      */     }
/*      */     
/* 2600 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean removeExpiredItemByUuid(long roleId, long uuid, int num, TLogArg tLogArg)
/*      */   {
/* 2617 */     RoleItemBag itemBag = getBag(roleId, 340600000);
/* 2618 */     if (itemBag == null)
/*      */     {
/* 2620 */       return false;
/*      */     }
/* 2622 */     ItemOperateResult ret = itemBag.removeItemByUuid(uuid, num, true);
/* 2623 */     if (!ret.success())
/*      */     {
/* 2625 */       return false;
/*      */     }
/* 2627 */     logItemAndTriggerEvent(roleId, ret, -1, tLogArg);
/*      */     
/* 2629 */     return ret.success();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void logItemAndTriggerEvent(long roleId, ItemOperateResult itemOperateResult, int countSign, TLogArg logArg)
/*      */   {
/* 2642 */     logItem(roleId, itemOperateResult.getItemChangeMap(), countSign, logArg);
/* 2643 */     tlogItem(roleId, itemOperateResult.getItemChangeMap(), countSign, logArg);
/* 2644 */     tlogItemFlow(roleId, itemOperateResult, countSign, logArg);
/*      */     
/* 2646 */     if (countSign > 0)
/*      */     {
/* 2648 */       triggerGetItemEvent(roleId, itemOperateResult, logArg);
/*      */     }
/*      */     else
/*      */     {
/* 2652 */       triggerRemoveItemEvent(roleId, itemOperateResult, logArg);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void logItem(long roleid, Map<Integer, Integer> itemid2num, int countSign, TLogArg logArg)
/*      */   {
/* 2668 */     for (Integer id : itemid2num.keySet())
/*      */     {
/* 2670 */       logItem(roleid, id.intValue(), countSign * ((Integer)itemid2num.get(id)).intValue(), logArg);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void tlogItem(long roleid, Map<Integer, Integer> itemid2num, int countSign, TLogArg logArg)
/*      */   {
/* 2686 */     for (Integer id : itemid2num.keySet())
/*      */     {
/* 2688 */       tlogItem(roleid, id.intValue(), countSign * ((Integer)itemid2num.get(id)).intValue(), logArg);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void tlogItemFlow(long roleid, ItemOperateResult itemOperateResult, int countSign, TLogArg logArg)
/*      */   {
/* 2703 */     for (ItemOperateResult.ChangeItemInfo c : itemOperateResult.getChangeItemInfoList())
/*      */     {
/* 2705 */       tlogItemFlow(roleid, c.basicItem, countSign > 0, logArg);
/*      */     }
/*      */   }
/*      */   
/*      */   static int getBagIdByItemId(int itemId)
/*      */   {
/* 2711 */     return getBagIdByItemId(340600000, itemId);
/*      */   }
/*      */   
/*      */   static int getBagIdByItemId(int defaultBagId, int itemId)
/*      */   {
/* 2716 */     SItemCfg itemCfg = SItemCfg.get(itemId);
/* 2717 */     if (itemCfg == null)
/*      */     {
/* 2719 */       return defaultBagId;
/*      */     }
/* 2721 */     return getBagIdByItemType(defaultBagId, itemCfg.type);
/*      */   }
/*      */   
/*      */   static int getBagIdByItemType(int defaultBagId, int itemType)
/*      */   {
/* 2726 */     ItemType2BagCfg itemType2BagCfg = ItemType2BagCfg.get(itemType);
/* 2727 */     if (itemType2BagCfg == null)
/*      */     {
/* 2729 */       return defaultBagId;
/*      */     }
/* 2731 */     return itemType2BagCfg.bagId;
/*      */   }
/*      */   
/*      */   static RoleItemBag getBagByItemId(long roleId, int defaultBagId, int itemId, boolean isLocked)
/*      */   {
/* 2736 */     return getBag(roleId, getBagIdByItemId(defaultBagId, itemId), isLocked);
/*      */   }
/*      */   
/*      */   static RoleItemBag getBagByItemType(long roleId, int defaultBagId, int itemType, boolean isLocked)
/*      */   {
/* 2741 */     return getBag(roleId, getBagIdByItemType(defaultBagId, itemType), isLocked);
/*      */   }
/*      */   
/*      */   static int getBagIdByUUID(long roleId, long uuid)
/*      */   {
/* 2746 */     if (ItemInterface.getItemByUuid(roleId, 340600005, uuid) != null)
/*      */     {
/* 2748 */       return 340600005;
/*      */     }
/* 2750 */     if (ItemInterface.getItemByUuid(roleId, 340600006, uuid) != null)
/*      */     {
/* 2752 */       return 340600006;
/*      */     }
/* 2754 */     if (ItemInterface.getItemByUuid(roleId, 340600007, uuid) != null)
/*      */     {
/* 2756 */       return 340600007;
/*      */     }
/* 2758 */     if (ItemInterface.getItemByUuid(roleId, 340600008, uuid) != null)
/*      */     {
/* 2760 */       return 340600008;
/*      */     }
/* 2762 */     if (ItemInterface.getItemByUuid(roleId, 340600009, uuid) != null)
/*      */     {
/* 2764 */       return 340600009;
/*      */     }
/*      */     
/* 2767 */     return 340600000;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void syncBagInfo(long roleId, int bagCfgId)
/*      */   {
/* 2781 */     SBagCfg bagCfg = SBagCfg.get(bagCfgId);
/* 2782 */     if ((bagCfg == null) || (bagCfg.type != 1))
/*      */     {
/* 2784 */       return;
/*      */     }
/* 2786 */     RoleItemBag bag = getBag(roleId, bagCfgId);
/* 2787 */     if (bag == null)
/*      */     {
/* 2789 */       return;
/*      */     }
/* 2791 */     SAllBagInfo allBagInfo = new SAllBagInfo();
/* 2792 */     BagInfo aBagInfo = new BagInfo();
/* 2793 */     aBagInfo.capacity = bag.getCapacity();
/* 2794 */     for (Map.Entry<Integer, Item> itemEntry : bag.getItems().entrySet())
/*      */     {
/* 2796 */       checkBaotuItem((Item)itemEntry.getValue());
/* 2797 */       checkPrivateItem((Item)itemEntry.getValue());
/* 2798 */       ItemInfo itemInfo = new ItemInfo();
/* 2799 */       fillInItemInfoBean(itemInfo, (Item)itemEntry.getValue());
/* 2800 */       aBagInfo.items.put(itemEntry.getKey(), itemInfo);
/*      */     }
/* 2802 */     allBagInfo.bags.put(Integer.valueOf(bagCfgId), aBagInfo);
/* 2803 */     OnlineManager.getInstance().send(roleId, allBagInfo);
/*      */   }
/*      */   
/*      */   static List<Integer> getJewelCfgIdList(Map<Integer, xbean.JewelInfo> slot2jewelInfo)
/*      */   {
/* 2808 */     List<Integer> result = new ArrayList();
/* 2809 */     for (Map.Entry<Integer, xbean.JewelInfo> entry : slot2jewelInfo.entrySet())
/*      */     {
/* 2811 */       result.add(Integer.valueOf(((xbean.JewelInfo)entry.getValue()).getJewelcfgid()));
/*      */     }
/* 2813 */     return result;
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\ItemManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */