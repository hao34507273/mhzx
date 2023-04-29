/*      */ package mzm.gsp.baitan.main;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.baitan.MyShoppingItem;
/*      */ import mzm.gsp.baitan.PageInfo;
/*      */ import mzm.gsp.baitan.SSellItemRes;
/*      */ import mzm.gsp.baitan.ShoppingItem;
/*      */ import mzm.gsp.baitan.confbean.BaiTanConsts;
/*      */ import mzm.gsp.baitan.confbean.SBaiTanCfg;
/*      */ import mzm.gsp.baitan.confbean.SBaitanItemCfg;
/*      */ import mzm.gsp.baitan.confbean.SBaitanSubTypeCfg;
/*      */ import mzm.gsp.baitan.confbean.SItemId2BaitanItemCfgid;
/*      */ import mzm.gsp.baitan.confbean.SSubtypeid2ItemList;
/*      */ import mzm.gsp.huanhun.main.HunNeedItemData;
/*      */ import mzm.gsp.item.confbean.SItemCfg;
/*      */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*      */ import mzm.gsp.item.confbean.SItemPriceCfg;
/*      */ import mzm.gsp.item.main.ItemBanTrade;
/*      */ import mzm.gsp.item.main.ItemInterface;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.open.main.OpenInterface;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.task.main.TaskNeedItemInfo;
/*      */ import mzm.gsp.timer.main.Session;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.LogicProcedure;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.Channels;
/*      */ import xbean.DisplayItem;
/*      */ import xbean.DisplayItemList;
/*      */ import xbean.Item;
/*      */ import xbean.ItemSale;
/*      */ import xbean.Pod;
/*      */ import xbean.Prices;
/*      */ import xbean.RoleGrid;
/*      */ import xbean.ShoppingIds;
/*      */ import xbean.ShoppingInfo;
/*      */ import xbean.Shoppoingid2Sessionid;
/*      */ import xbean.Subtype2ItemList;
/*      */ import xbean.SysSellItem;
/*      */ import xdb.Xdb;
/*      */ import xtable.Channel2shoppingid;
/*      */ import xtable.Item2prices;
/*      */ import xtable.Item2sales;
/*      */ import xtable.Roleshoppinginfo;
/*      */ import xtable.Sysbaitanitem;
/*      */ 
/*      */ class BaiTanManager
/*      */ {
/*   58 */   static Map<Long, ClearRoleBaitanInfoOberver> roleid2baitanfreshoberver = Collections.synchronizedMap(new java.util.HashMap());
/*      */   
/*   60 */   static Logger logger = null;
/*      */   
/*      */ 
/*      */   public static void init()
/*      */   {
/*   65 */     logger = Logger.getLogger("baitan");
/*      */   }
/*      */   
/*      */ 
/*      */   static void postInit()
/*      */   {
/*   71 */     new PPriceRecommandObserver(getRecommendPriceUpdatetime());
/*      */     
/*   73 */     initItemSales();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getRecommendPriceUpdatetime()
/*      */   {
/*   84 */     return TimeUnit.MINUTES.toSeconds(BaiTanConsts.getInstance().RECOMMAND_PRICE_UPDATE_INTERVAL);
/*      */   }
/*      */   
/*      */   static int getSubSizeByid(int subid)
/*      */   {
/*   89 */     SBaitanSubTypeCfg subTypeCfg = SBaitanSubTypeCfg.get(subid);
/*   90 */     if (subTypeCfg == null)
/*      */     {
/*   92 */       return 0;
/*      */     }
/*   94 */     return subTypeCfg.size;
/*      */   }
/*      */   
/*      */   static boolean isSubtyperight(int subtype)
/*      */   {
/*   99 */     SBaitanSubTypeCfg subTypeCfg = SBaitanSubTypeCfg.get(subtype);
/*  100 */     if (subTypeCfg == null)
/*      */     {
/*  102 */       return false;
/*      */     }
/*  104 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isOpenForLevel(int roleLevel)
/*      */   {
/*  116 */     return roleLevel >= BaiTanConsts.getInstance().SERVICE_OPEN_LEVEL;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isBaiTanSwitchOpenForRole(long roleid)
/*      */   {
/*  127 */     if (!OpenInterface.getOpenStatus(27))
/*      */     {
/*  129 */       return false;
/*      */     }
/*  131 */     if (OpenInterface.isBanPlay(roleid, 27))
/*      */     {
/*  133 */       OpenInterface.sendBanPlayMsg(roleid, 27);
/*  134 */       return false;
/*      */     }
/*  136 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void fillMyShoppingItem(MyShoppingItem myShoppingItem, boolean isExpire, ShoppingInfo shoppingInfo, long shoppingid)
/*      */   {
/*  143 */     myShoppingItem.price = shoppingInfo.getPrice();
/*  144 */     myShoppingItem.shoppingid = shoppingid;
/*  145 */     myShoppingItem.state = 0;
/*  146 */     myShoppingItem.sellnum = (shoppingInfo.getTotalnum() - shoppingInfo.getItem().getNumber());
/*      */     
/*  148 */     if ((shoppingInfo.getItem().getNumber() <= 0) || (shoppingInfo.getItem().getNumber() < shoppingInfo.getTotalnum()))
/*      */     {
/*  150 */       myShoppingItem.state = 1;
/*      */     }
/*      */     else
/*      */     {
/*  154 */       myShoppingItem.state = (isExpire ? 2 : 0);
/*      */     }
/*  156 */     fillItem(myShoppingItem.item, shoppingInfo.getItem());
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
/*      */   static Item separateItem(Item item, int sepNumber)
/*      */   {
/*  169 */     int totalNumber = item.getNumber();
/*  170 */     if (totalNumber < sepNumber)
/*      */     {
/*  172 */       return null;
/*      */     }
/*  174 */     Item newItem = Pod.newItem();
/*  175 */     ItemInterface.fillXItem(newItem, item);
/*      */     
/*  177 */     item.setNumber(totalNumber - sepNumber);
/*      */     
/*  179 */     newItem.setNumber(sepNumber);
/*  180 */     newItem.getUuid().clear();
/*      */     
/*  182 */     List<Long> uuidSet = new ArrayList(item.getUuid());
/*  183 */     Collections.sort(uuidSet);
/*      */     
/*  185 */     List<Long> toremoveuuids = new ArrayList();
/*      */     
/*  187 */     for (int i = uuidSet.size() - 1; i >= 0; i--)
/*      */     {
/*  189 */       toremoveuuids.add(uuidSet.get(i));
/*  190 */       if (toremoveuuids.size() == sepNumber) {
/*      */         break;
/*      */       }
/*      */     }
/*      */     
/*  195 */     newItem.getUuid().addAll(toremoveuuids);
/*  196 */     item.getUuid().removeAll(toremoveuuids);
/*      */     
/*  198 */     return newItem;
/*      */   }
/*      */   
/*      */   static void fillItem(mzm.gsp.item.ItemInfo iteminfo, Item xItem)
/*      */   {
/*  203 */     ItemInterface.fillInItemInfoBean(iteminfo, xItem);
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
/*      */   static void startObserver(Shoppoingid2Sessionid shoppoingid2Sessionid, long roleid, long shoppingId, long millSecond)
/*      */   {
/*  217 */     Long sessionid = (Long)shoppoingid2Sessionid.getShoppingid2sessionid().get(Long.valueOf(shoppingId));
/*  218 */     if (sessionid == null)
/*      */     {
/*  220 */       Session session = new ShoppingSession(TimeUnit.MILLISECONDS.toSeconds(millSecond), shoppingId);
/*  221 */       sessionid = Long.valueOf(session.getSessionId());
/*  222 */       shoppoingid2Sessionid.getShoppingid2sessionid().put(Long.valueOf(shoppingId), sessionid);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void startRecycleObserver(Shoppoingid2Sessionid shoppoingid2Sessionid, long roleid, long shoppingId, long millSecond)
/*      */   {
/*  243 */     Long sessionid = (Long)shoppoingid2Sessionid.getShoppingid2sessionid().get(Long.valueOf(shoppingId));
/*  244 */     if (sessionid == null)
/*      */     {
/*  246 */       Session session = new RecycleShoppingSession(TimeUnit.MILLISECONDS.toSeconds(millSecond), shoppingId, roleid);
/*  247 */       sessionid = Long.valueOf(session.getSessionId());
/*  248 */       shoppoingid2Sessionid.getShoppingid2sessionid().put(Long.valueOf(shoppingId), sessionid);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   static void reStartObserver(Shoppoingid2Sessionid shoppoingid2Sessionid, long roleid, long shoppingId, long millSecond)
/*      */   {
/*  268 */     Long sessionid = (Long)shoppoingid2Sessionid.getShoppingid2sessionid().get(Long.valueOf(shoppingId));
/*  269 */     if (sessionid != null)
/*      */     {
/*  271 */       Session.removeSession(sessionid.longValue());
/*      */     }
/*      */     
/*  274 */     Session session = new ShoppingSession(TimeUnit.MILLISECONDS.toSeconds(millSecond), shoppingId);
/*  275 */     sessionid = Long.valueOf(session.getSessionId());
/*  276 */     shoppoingid2Sessionid.getShoppingid2sessionid().put(Long.valueOf(shoppingId), sessionid);
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
/*      */   static void reStartRecycleObserver(Shoppoingid2Sessionid shoppoingid2Sessionid, long roleid, long shoppingId, long millSecond)
/*      */   {
/*  291 */     Long sessionid = (Long)shoppoingid2Sessionid.getShoppingid2sessionid().get(Long.valueOf(shoppingId));
/*  292 */     if (sessionid != null)
/*      */     {
/*  294 */       Session.removeSession(sessionid.longValue());
/*      */     }
/*      */     
/*  297 */     Session session = new RecycleShoppingSession(TimeUnit.MILLISECONDS.toSeconds(millSecond), shoppingId, roleid);
/*  298 */     sessionid = Long.valueOf(session.getSessionId());
/*  299 */     shoppoingid2Sessionid.getShoppingid2sessionid().put(Long.valueOf(shoppingId), sessionid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void stopObserver(long roleid, long shoppingId)
/*      */   {
/*  311 */     new RemoveroleShoppingSession(roleid, shoppingId).execute();
/*      */   }
/*      */   
/*      */ 
/*      */   private static class RemoveroleShoppingSession
/*      */     extends LogicProcedure
/*      */   {
/*      */     private final long roleid;
/*      */     private final long shoppingid;
/*      */     
/*      */     public RemoveroleShoppingSession(long roleid, long shoppingid)
/*      */     {
/*  323 */       this.roleid = roleid;
/*  324 */       this.shoppingid = shoppingid;
/*      */     }
/*      */     
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/*  330 */       Shoppoingid2Sessionid shoppoingid2Sessionid = xtable.Role2shoppingsession.get(Long.valueOf(this.roleid));
/*  331 */       if (shoppoingid2Sessionid == null)
/*      */       {
/*  333 */         return false;
/*      */       }
/*  335 */       Long sessionid = (Long)shoppoingid2Sessionid.getShoppingid2sessionid().remove(Long.valueOf(this.shoppingid));
/*  336 */       if (sessionid == null)
/*      */       {
/*  338 */         return false;
/*      */       }
/*  340 */       Session.removeSession(sessionid.longValue());
/*  341 */       return true;
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
/*      */   static long createShoppingInfo(Item xItem, long roleId, int price, long expireTime)
/*      */   {
/*  357 */     ShoppingInfo shoppingInfo = createShoppingInfo(roleId, xItem, price, expireTime);
/*      */     
/*  359 */     long shoppingId = Roleshoppinginfo.insert(shoppingInfo).longValue();
/*  360 */     return shoppingId;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Channels getChannelOnAdd(int itemid, int price)
/*      */   {
/*  372 */     long key = GameServerInfoManager.toGlobalId(itemid);
/*  373 */     Prices prices = Item2prices.get(Long.valueOf(key));
/*  374 */     if (prices == null)
/*      */     {
/*  376 */       prices = Pod.newPrices();
/*      */       
/*  378 */       Item2prices.insert(Long.valueOf(key), prices);
/*      */     }
/*  380 */     Channels channels = (Channels)prices.getPrice2channels().get(Integer.valueOf(price));
/*  381 */     if (channels == null)
/*      */     {
/*  383 */       channels = Pod.newChannels();
/*  384 */       prices.getPrice2channels().put(Integer.valueOf(price), channels);
/*      */     }
/*  386 */     return channels;
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
/*      */   static Channels getChannels(int itemid, int price, boolean islock)
/*      */   {
/*  399 */     long key = GameServerInfoManager.toGlobalId(itemid);
/*  400 */     Prices prices = null;
/*  401 */     if (islock)
/*      */     {
/*  403 */       prices = Item2prices.get(Long.valueOf(key));
/*      */     }
/*      */     else
/*      */     {
/*  407 */       prices = Item2prices.select(Long.valueOf(key));
/*      */     }
/*      */     
/*  410 */     if (prices == null)
/*      */     {
/*  412 */       return null;
/*      */     }
/*  414 */     Channels channels = (Channels)prices.getPrice2channels().get(Integer.valueOf(price));
/*      */     
/*  416 */     return channels;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long findLastChannelid(Channels channels)
/*      */   {
/*  427 */     if ((channels == null) || (channels.getChannels().isEmpty()))
/*      */     {
/*  429 */       return -1L;
/*      */     }
/*  431 */     return ((Long)channels.getChannels().get(channels.getChannels().size() - 1)).longValue();
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean addRoleShoppingChannel(long roleid, long shoppingid, long channelid)
/*      */   {
/*  437 */     RoleGrid roleGrid = xtable.Role2grid.get(Long.valueOf(roleid));
/*  438 */     if (roleGrid == null)
/*      */     {
/*  440 */       roleGrid = Pod.newRoleGrid();
/*  441 */       xtable.Role2grid.insert(Long.valueOf(roleid), roleGrid);
/*      */     }
/*      */     
/*  444 */     roleGrid.getShoppingid2channelid().put(Long.valueOf(shoppingid), Long.valueOf(channelid));
/*  445 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long addRoleChannelShoppingid(long channelid, long shoppingid)
/*      */   {
/*  457 */     long chid = channelid;
/*  458 */     ShoppingIds shoppingIds = Channel2shoppingid.get(Long.valueOf(channelid));
/*  459 */     if ((shoppingIds == null) || (shoppingIds.getShoppingids().size() > getChannelSize()))
/*      */     {
/*  461 */       shoppingIds = Pod.newShoppingIds();
/*  462 */       chid = Channel2shoppingid.insert(shoppingIds).longValue();
/*  463 */       shoppingIds = Channel2shoppingid.get(Long.valueOf(chid));
/*      */     }
/*      */     
/*  466 */     shoppingIds.getShoppingids().add(Long.valueOf(shoppingid));
/*  467 */     return chid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getChannelSize()
/*      */   {
/*  478 */     return BaiTanConsts.getInstance().CHANNEL_SIZE;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getBigTypeBySubType(int subTypeId)
/*      */   {
/*  489 */     for (SBaiTanCfg baiTanCfg : SBaiTanCfg.getAll().values())
/*      */     {
/*  491 */       if (baiTanCfg.subTypeIdList.contains(Integer.valueOf(subTypeId)))
/*      */       {
/*  493 */         return baiTanCfg.ItemGroupSeq;
/*      */       }
/*      */     }
/*  496 */     return -1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getSupplyIntervalSeconds()
/*      */   {
/*  506 */     return TimeUnit.MINUTES.toSeconds(BaiTanConsts.getInstance().SUPPLY_INTERVAL);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getPageSize()
/*      */   {
/*  516 */     return BaiTanConsts.getInstance().PAGE_SIZE;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static List<Integer> getNeededItemidList(long roleid)
/*      */   {
/*  526 */     TaskNeedItemInfo ta = mzm.gsp.task.main.TaskInterface.getRoleTaskNeedItemInfos(roleid);
/*  527 */     HunNeedItemData huan = mzm.gsp.huanhun.main.HuanhunInterface.getRoleHunNeedItemData(roleid);
/*  528 */     List<Integer> res = new ArrayList();
/*  529 */     if ((ta == null) || (huan == null))
/*      */     {
/*  531 */       return res;
/*      */     }
/*      */     
/*  534 */     res.addAll(ta.getNormalItemIds());
/*  535 */     res.addAll(huan.getNeedNormalItemIds());
/*      */     
/*  537 */     for (Iterator i$ = ta.getEqualItemIds().iterator(); i$.hasNext();) { int configid = ((Integer)i$.next()).intValue();
/*      */       
/*  539 */       res.addAll(ItemInterface.getSamePriceItems(configid));
/*      */     }
/*      */     
/*  542 */     for (Iterator i$ = huan.getNeedEqualItemIds().iterator(); i$.hasNext();) { int configid = ((Integer)i$.next()).intValue();
/*      */       
/*  544 */       res.addAll(ItemInterface.getSamePriceItems(configid));
/*      */     }
/*      */     
/*  547 */     return res;
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
/*      */   static void fillPageInfo(long roleid, PageInfo pageInfo, Subtype2ItemList subtype2ItemList, int pageindex, int subtype)
/*      */   {
/*  562 */     DisplayItemList displayItemList = (DisplayItemList)subtype2ItemList.getSub2itemlist().get(Integer.valueOf(subtype));
/*  563 */     pageInfo.subtype = subtype;
/*  564 */     pageInfo.pageindex = pageindex;
/*      */     
/*  566 */     int startindex = (pageindex - 1) * getPageSize();
/*  567 */     if ((displayItemList == null) || (displayItemList.getDisplayitemlist().isEmpty()) || (startindex >= displayItemList.getDisplayitemlist().size()))
/*      */     {
/*      */ 
/*  570 */       pageInfo.totalpagenum = 0;
/*  571 */       return;
/*      */     }
/*  573 */     pageInfo.totalpagenum = ((displayItemList.getDisplayitemlist().size() - 1) / getPageSize() + 1);
/*      */     
/*  575 */     List<Integer> needItemList = getNeededItemidList(roleid);
/*  576 */     for (int i = startindex; i < Math.min(startindex + getPageSize(), displayItemList.getDisplayitemlist().size()); 
/*  577 */         i++)
/*      */     {
/*      */ 
/*  580 */       DisplayItem displayItem = (DisplayItem)displayItemList.getDisplayitemlist().get(i);
/*      */       
/*  582 */       ShoppingItem shoppingItem = new ShoppingItem();
/*  583 */       shoppingItem.itemid = displayItem.getItemid();
/*      */       
/*  585 */       shoppingItem.price = displayItem.getPrice();
/*  586 */       shoppingItem.isneed = (needItemList.contains(Integer.valueOf(shoppingItem.itemid)) ? 1 : 0);
/*  587 */       shoppingItem.index = i;
/*  588 */       if (displayItem.getShoppingid() == 0L)
/*      */       {
/*  590 */         shoppingItem.num = ((int)displayItem.getChannelidornum());
/*      */       }
/*      */       else
/*      */       {
/*  594 */         ShoppingInfo shoppingInfo = Roleshoppinginfo.select(Long.valueOf(displayItem.getShoppingid()));
/*  595 */         shoppingItem.num = (shoppingInfo == null ? 0 : shoppingInfo.getItem().getNumber());
/*      */       }
/*      */       
/*  598 */       pageInfo.shoppingitemlist.add(shoppingItem);
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
/*      */ 
/*      */ 
/*      */   static void fillEquipPageInfo(long roleid, PageInfo pageInfo, Subtype2ItemList subtype2ItemList, int pageindex, int subtype, int param)
/*      */   {
/*  617 */     DisplayItemList displayItemList = (DisplayItemList)subtype2ItemList.getSub2itemlist().get(Integer.valueOf(subtype));
/*  618 */     pageInfo.subtype = subtype;
/*  619 */     pageInfo.pageindex = pageindex;
/*  620 */     int startindex = (pageindex - 1) * getPageSize();
/*  621 */     if ((displayItemList == null) || (displayItemList.getDisplayitemlist().isEmpty()) || (startindex >= displayItemList.getDisplayitemlist().size()))
/*      */     {
/*      */ 
/*  624 */       pageInfo.totalpagenum = 0;
/*  625 */       return;
/*      */     }
/*  627 */     int totalneednum = 0;
/*  628 */     List<Integer> needItemList = getNeededItemidList(roleid);
/*  629 */     for (int i = 0; i < displayItemList.getDisplayitemlist().size(); i++)
/*      */     {
/*      */ 
/*  632 */       DisplayItem displayItem = (DisplayItem)displayItemList.getDisplayitemlist().get(i);
/*  633 */       SItemEquipCfg itemEquipCfg = SItemEquipCfg.get(displayItem.getItemid());
/*      */       
/*  635 */       if ((itemEquipCfg == null) || (itemEquipCfg.useLevel == param))
/*      */       {
/*      */ 
/*      */ 
/*  639 */         totalneednum++;
/*  640 */         if ((totalneednum >= startindex) && (pageInfo.shoppingitemlist.size() < getPageSize()))
/*      */         {
/*  642 */           ShoppingItem shoppingItem = new ShoppingItem();
/*  643 */           shoppingItem.itemid = displayItem.getItemid();
/*      */           
/*  645 */           shoppingItem.price = displayItem.getPrice();
/*  646 */           shoppingItem.isneed = (needItemList.contains(Integer.valueOf(shoppingItem.itemid)) ? 1 : 0);
/*  647 */           shoppingItem.index = i;
/*  648 */           if (displayItem.getShoppingid() == 0L)
/*      */           {
/*  650 */             shoppingItem.num = ((int)displayItem.getChannelidornum());
/*      */           }
/*      */           else
/*      */           {
/*  654 */             ShoppingInfo shoppingInfo = Roleshoppinginfo.select(Long.valueOf(displayItem.getShoppingid()));
/*  655 */             shoppingItem.num = (shoppingInfo == null ? 0 : shoppingInfo.getItem().getNumber());
/*      */           }
/*      */           
/*  658 */           pageInfo.shoppingitemlist.add(shoppingItem);
/*      */         }
/*      */       }
/*      */     }
/*  662 */     pageInfo.totalpagenum = ((totalneednum - 1) / getPageSize() + 1);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getItemRecommendPrice(int itemId)
/*      */   {
/*  674 */     long key = GameServerInfoManager.toGlobalId(itemId);
/*  675 */     ItemSale price = Item2sales.select(Long.valueOf(key));
/*      */     
/*  677 */     SItemPriceCfg itemPriceCfg = ItemInterface.getSItemPriceCfg(itemId);
/*  678 */     if (itemPriceCfg == null)
/*      */     {
/*  680 */       return -1;
/*      */     }
/*      */     
/*  683 */     if (isBaiTanFixPriceSwitchOpen())
/*      */     {
/*  685 */       return itemPriceCfg.baiTanSilverNum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  690 */     if (price != null)
/*      */     {
/*  692 */       if (price.getRecommendprice() <= itemPriceCfg.baiTanMinSilver)
/*      */       {
/*  694 */         return itemPriceCfg.baiTanMinSilver;
/*      */       }
/*  696 */       if (price.getRecommendprice() >= itemPriceCfg.baiTanMaxSilver)
/*      */       {
/*  698 */         return itemPriceCfg.baiTanMaxSilver;
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  703 */       return price.getRecommendprice();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  709 */     return itemPriceCfg.baiTanSilverNum;
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
/*      */   static int getCanShangjiaNumPerGrid(int itemid)
/*      */   {
/*  723 */     int pilenum = ItemInterface.getPileMaxCount(itemid);
/*  724 */     int numpergrid = Math.min(BaiTanConsts.getInstance().ITEM_STOCK_NUM, pilenum);
/*  725 */     return numpergrid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getNeedGrid(int itemid, int num)
/*      */   {
/*  737 */     int numpergrid = getCanShangjiaNumPerGrid(itemid);
/*  738 */     return (num - 1) / numpergrid + 1;
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
/*      */   private static ShoppingInfo createShoppingInfo(long roleid, Item xItem, int recommandPrice, long expireTime)
/*      */   {
/*  751 */     ShoppingInfo gridInfo = Pod.newShoppingInfo();
/*  752 */     ItemInterface.fillXItem(gridInfo.getItem(), xItem);
/*  753 */     gridInfo.setExpire(expireTime);
/*  754 */     gridInfo.setPrice(recommandPrice);
/*  755 */     gridInfo.setRoleid(roleid);
/*  756 */     gridInfo.setTotalnum(xItem.getNumber());
/*      */     
/*  758 */     return gridInfo;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getBaitangItemInterval()
/*      */   {
/*  801 */     return TimeUnit.MINUTES.toMillis(BaiTanConsts.getInstance().ONSHOW_PERSIST_TIME);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int checkAndModifyPrice(int sellPrice, int itemid)
/*      */   {
/*  813 */     SItemPriceCfg itemPriceCfg = ItemInterface.getSItemPriceCfg(itemid);
/*  814 */     if (itemPriceCfg == null)
/*      */     {
/*  816 */       return -1;
/*      */     }
/*  818 */     if (sellPrice > itemPriceCfg.baiTanMaxSilver)
/*      */     {
/*  820 */       sellPrice = itemPriceCfg.baiTanMaxSilver;
/*      */     }
/*  822 */     if (sellPrice < itemPriceCfg.baiTanMinSilver)
/*      */     {
/*  824 */       sellPrice = itemPriceCfg.baiTanMinSilver;
/*      */     }
/*      */     
/*  827 */     int recommandPrice = getItemRecommendPrice(itemid);
/*      */     
/*  829 */     if (recommandPrice == -1)
/*      */     {
/*  831 */       return -1;
/*      */     }
/*      */     
/*  834 */     int recommandAddRate = (int)(sellPrice / recommandPrice * BaiTanConsts.getInstance().BASE_RATE);
/*      */     
/*  836 */     if ((recommandAddRate > BaiTanConsts.getInstance().HIGH_PRICE_RATE_LIMIT) || (recommandAddRate < BaiTanConsts.getInstance().LOW_PRICE_RATE_LIMIT))
/*      */     {
/*      */ 
/*  839 */       return 0;
/*      */     }
/*  841 */     return sellPrice;
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
/*      */   static int computeNeedTaxSillver(int price, int itemid, int num)
/*      */   {
/*  855 */     int tax = (int)(BaiTanConsts.getInstance().BAITAN_FEE_RATE / BaiTanConsts.getInstance().BASE_RATE * price * num);
/*  856 */     return tax;
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
/*      */   static int getSysSellItemNum(int itemid, boolean islock)
/*      */   {
/*  869 */     long key = GameServerInfoManager.toGlobalId(itemid);
/*  870 */     SysSellItem sellItem = null;
/*  871 */     if (islock)
/*      */     {
/*  873 */       sellItem = Sysbaitanitem.get(Long.valueOf(key));
/*      */     }
/*      */     else
/*      */     {
/*  877 */       sellItem = Sysbaitanitem.select(Long.valueOf(key));
/*      */     }
/*      */     
/*  880 */     if (sellItem == null)
/*      */     {
/*  882 */       return 0;
/*      */     }
/*  884 */     int c = 0;
/*  885 */     for (Iterator i$ = sellItem.getPrice2num().values().iterator(); i$.hasNext();) { int num = ((Integer)i$.next()).intValue();
/*      */       
/*  887 */       c += num;
/*      */     }
/*  889 */     return c;
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
/*      */   static void addSysSellItemNum(int itemid, int price, int num)
/*      */   {
/*  902 */     long key = GameServerInfoManager.toGlobalId(itemid);
/*  903 */     SysSellItem sellItem = Sysbaitanitem.get(Long.valueOf(key));
/*  904 */     if (sellItem == null)
/*      */     {
/*  906 */       sellItem = Pod.newSysSellItem();
/*  907 */       Sysbaitanitem.insert(Long.valueOf(key), sellItem);
/*      */     }
/*  909 */     Integer oldnum = (Integer)sellItem.getPrice2num().get(Integer.valueOf(price));
/*  910 */     if (oldnum == null)
/*      */     {
/*  912 */       oldnum = Integer.valueOf(0);
/*      */     }
/*  914 */     sellItem.getPrice2num().put(Integer.valueOf(price), Integer.valueOf(num + oldnum.intValue()));
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
/*      */   static int getMaxSysSellNum(int itemid)
/*      */   {
/*  927 */     SItemId2BaitanItemCfgid itemId2Subid = SItemId2BaitanItemCfgid.get(itemid);
/*  928 */     if (itemId2Subid == null)
/*      */     {
/*  930 */       return 0;
/*      */     }
/*  932 */     SBaitanItemCfg sType = SBaitanItemCfg.get(itemId2Subid.baitanItemid);
/*  933 */     if (sType == null)
/*      */     {
/*  935 */       return 0;
/*      */     }
/*      */     
/*  938 */     return sType.supplyGridNum * getCanShangjiaNumPerGrid(itemid);
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
/*      */   static void removeSCPI(int itemId, int price, long channelid, long shoppingid)
/*      */   {
/*  952 */     new RemoveScpiProcedure(itemId, price, channelid, shoppingid).execute();
/*      */   }
/*      */   
/*      */ 
/*      */   private static class RemoveScpiProcedure
/*      */     extends LogicProcedure
/*      */   {
/*      */     private final int itemId;
/*      */     private final int price;
/*      */     private final long channelid;
/*      */     private final long shoppingid;
/*      */     
/*      */     public RemoveScpiProcedure(int itemId, int price, long channelid, long shoppingid)
/*      */     {
/*  966 */       this.itemId = itemId;
/*  967 */       this.price = price;
/*  968 */       this.channelid = channelid;
/*  969 */       this.shoppingid = shoppingid;
/*      */     }
/*      */     
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/*  975 */       long key = GameServerInfoManager.toGlobalId(this.itemId);
/*  976 */       Prices prices = Item2prices.get(Long.valueOf(key));
/*  977 */       if (prices == null)
/*      */       {
/*  979 */         return false;
/*      */       }
/*  981 */       Channels channels = (Channels)prices.getPrice2channels().get(Integer.valueOf(this.price));
/*  982 */       if ((channels == null) || (!channels.getChannels().contains(Long.valueOf(this.channelid))))
/*      */       {
/*  984 */         return false;
/*      */       }
/*  986 */       ShoppingIds shoppingIds = Channel2shoppingid.get(Long.valueOf(this.channelid));
/*  987 */       if ((shoppingIds == null) || (!shoppingIds.getShoppingids().contains(Long.valueOf(this.shoppingid))))
/*      */       {
/*  989 */         return false;
/*      */       }
/*      */       
/*  992 */       shoppingIds.getShoppingids().remove(Long.valueOf(this.shoppingid));
/*  993 */       boolean isShoppingsremoves = false;
/*  994 */       if (shoppingIds.getShoppingids().isEmpty())
/*      */       {
/*  996 */         isShoppingsremoves = Channel2shoppingid.remove(Long.valueOf(this.channelid));
/*      */       }
/*  998 */       boolean ischannelsremoved = false;
/*  999 */       if (isShoppingsremoves)
/*      */       {
/* 1001 */         ischannelsremoved = channels.getChannels().remove(Long.valueOf(this.channelid));
/*      */       }
/* 1003 */       boolean ispriceremoved = false;
/* 1004 */       if ((ischannelsremoved) && (channels.getChannels().isEmpty()))
/*      */       {
/* 1006 */         prices.getPrice2channels().remove(Integer.valueOf(this.price));
/* 1007 */         ispriceremoved = true;
/*      */       }
/* 1009 */       if ((ispriceremoved) && (prices.getPrice2channels().isEmpty()))
/*      */       {
/* 1011 */         Item2prices.remove(Long.valueOf(key));
/*      */       }
/* 1013 */       return true;
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
/*      */   static int computeMoney(int price)
/*      */   {
/* 1026 */     int tax = (int)((BaiTanConsts.getInstance().BASE_RATE - BaiTanConsts.getInstance().SELL_TAX_RATE) * price / BaiTanConsts.getInstance().BASE_RATE);
/* 1027 */     return tax;
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
/*      */   static int getSubtypeidByItemid(int itemid)
/*      */   {
/* 1041 */     SItemId2BaitanItemCfgid id2Subid = SItemId2BaitanItemCfgid.get(itemid);
/* 1042 */     if (id2Subid == null)
/*      */     {
/* 1044 */       return -1;
/*      */     }
/* 1046 */     SBaitanItemCfg baitanItemCfg = SBaitanItemCfg.get(id2Subid.baitanItemid);
/* 1047 */     if (baitanItemCfg == null)
/*      */     {
/* 1049 */       return -1;
/*      */     }
/* 1051 */     return baitanItemCfg.subTypeId;
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
/*      */   static void tlogBaitan(long roleid, int itemid, int num, int price, int cutsilver, int cutvigor, BaiTanOperateEnum baiTanOperateEnum)
/*      */   {
/* 1069 */     String logname = "Baitan";
/* 1070 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 1071 */     String userid = RoleInterface.getUserId(roleid);
/* 1072 */     int rolelevel = RoleInterface.getLevel(roleid);
/*      */     
/* 1074 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(baiTanOperateEnum.value), Integer.valueOf(itemid), Integer.valueOf(num), Integer.valueOf(price), Integer.valueOf(cutsilver), Integer.valueOf(cutvigor) });
/*      */     
/* 1076 */     TLogManager.getInstance().addLog(roleid, logname, logStr);
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
/*      */   static void tlogBaitanBuy(long roleid, int itemid, int num, int price, long sellerroleid)
/*      */   {
/* 1090 */     String logname = "Baitanbuy";
/* 1091 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 1092 */     String userid = RoleInterface.getUserId(roleid);
/* 1093 */     int rolelevel = RoleInterface.getLevel(roleid);
/*      */     
/* 1095 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(itemid), Integer.valueOf(num), Integer.valueOf(price), Long.valueOf(sellerroleid) });
/*      */     
/* 1097 */     TLogManager.getInstance().addLog(roleid, logname, logStr);
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
/*      */   static void tlogBaitanBuyForIdip(long roleid, long sellerRoleid, int itemid, int num, int price, Set<Long> uuids, long shoppingId)
/*      */   {
/* 1118 */     int DealMainType = BaiTanInterface.getBigTypeGroup(itemid);
/* 1119 */     int DealSubType = BaiTanInterface.getSubTypeGroup(itemid);
/* 1120 */     int DealLevel = ItemInterface.getUseLevel(itemid);
/*      */     
/*      */ 
/* 1123 */     mzm.gsp.idip.main.IdipManager.baitanBuyTLogAsync(roleid, sellerRoleid, itemid, num, price, uuids, shoppingId, DealMainType, DealSubType, DealLevel);
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
/*      */ 
/*      */ 
/*      */   static void tlogBaitanSellForIdip(long sellerRoleid, int itemId, int num, int price, Set<Long> uuids, long shoppingId, long lengthTime, int sellType)
/*      */   {
/* 1146 */     int DealMainType = BaiTanInterface.getBigTypeGroup(itemId);
/* 1147 */     int DealSubType = BaiTanInterface.getSubTypeGroup(itemId);
/* 1148 */     int DealLevel = ItemInterface.getUseLevel(itemId);
/*      */     
/*      */ 
/* 1151 */     mzm.gsp.idip.main.IdipManager.baitanSellTLogAsync(sellerRoleid, itemId, num, price, uuids, shoppingId, lengthTime, DealMainType, DealSubType, DealLevel);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getNumPerGrid(int itemid)
/*      */   {
/* 1163 */     int pilenum = ItemInterface.getPileMaxCount(itemid);
/* 1164 */     int numpergrid = Math.min(BaiTanConsts.getInstance().ITEM_STOCK_NUM, pilenum);
/* 1165 */     return numpergrid;
/*      */   }
/*      */   
/*      */   static void sendCommonError(long roleid, int rescode)
/*      */   {
/* 1170 */     mzm.gsp.baitan.SCommonResultRes res = new mzm.gsp.baitan.SCommonResultRes();
/* 1171 */     res.res = rescode;
/* 1172 */     OnlineManager.getInstance().sendAtOnce(roleid, res);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void initItemSales()
/*      */   {
/* 1182 */     for (Iterator i$ = SItemId2BaitanItemCfgid.getAll().keySet().iterator(); i$.hasNext();) { int itemid = ((Integer)i$.next()).intValue();
/*      */       
/*      */ 
/* 1185 */       mzm.gsp.util.NoneRealTimeTaskManager.getInstance().addTask(new InitItemSaleProcedure(itemid));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private static class InitItemSaleProcedure
/*      */     extends LogicProcedure
/*      */   {
/*      */     private int itemid;
/*      */     
/*      */ 
/*      */     public InitItemSaleProcedure(int itemid)
/*      */     {
/* 1198 */       this.itemid = itemid;
/*      */     }
/*      */     
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/* 1204 */       long key = GameServerInfoManager.toGlobalId(this.itemid);
/* 1205 */       ItemSale itemSale = Item2sales.get(Long.valueOf(key));
/* 1206 */       if (itemSale == null)
/*      */       {
/* 1208 */         itemSale = Pod.newItemSale();
/* 1209 */         SItemPriceCfg sItemPriceCfg = ItemInterface.getSItemPriceCfg(this.itemid);
/* 1210 */         int recommandSilver = 0;
/* 1211 */         if (sItemPriceCfg != null)
/*      */         {
/* 1213 */           recommandSilver = sItemPriceCfg.baiTanSilverNum;
/*      */         }
/* 1215 */         itemSale.setRecommendprice(recommandSilver);
/* 1216 */         itemSale.setTotalsellnum(0L);
/* 1217 */         itemSale.setTotalsellmoney(0L);
/* 1218 */         Item2sales.insert(Long.valueOf(key), itemSale);
/*      */       }
/*      */       
/* 1221 */       return true;
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
/*      */   static void addItemSellMoney(int itemid, int sellmoney, int sellnum)
/*      */   {
/* 1235 */     long key = GameServerInfoManager.toGlobalId(itemid);
/* 1236 */     ItemSale itemSale = Item2sales.get(Long.valueOf(key));
/* 1237 */     if (itemSale == null)
/*      */     {
/* 1239 */       itemSale = Pod.newItemSale();
/* 1240 */       SItemPriceCfg sItemPriceCfg = ItemInterface.getSItemPriceCfg(itemid);
/* 1241 */       int recommandSilver = 0;
/* 1242 */       if (sItemPriceCfg != null)
/*      */       {
/* 1244 */         recommandSilver = sItemPriceCfg.baiTanSilverNum;
/*      */       }
/* 1246 */       itemSale.setRecommendprice(recommandSilver);
/* 1247 */       itemSale.setTotalsellnum(0L);
/* 1248 */       itemSale.setTotalsellmoney(0L);
/* 1249 */       Item2sales.insert(Long.valueOf(key), itemSale);
/*      */     }
/* 1251 */     itemSale.setTotalsellnum(itemSale.getTotalsellnum() + sellnum);
/* 1252 */     itemSale.setTotalsellmoney(itemSale.getTotalsellmoney() + sellmoney);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void addItemGridnum(int itemid)
/*      */   {
/* 1264 */     long key = GameServerInfoManager.toGlobalId(itemid);
/* 1265 */     ItemSale itemSale = Item2sales.get(Long.valueOf(key));
/* 1266 */     if (itemSale == null)
/*      */     {
/* 1268 */       itemSale = Pod.newItemSale();
/* 1269 */       SItemPriceCfg sItemPriceCfg = ItemInterface.getSItemPriceCfg(itemid);
/* 1270 */       int recommandSilver = 0;
/* 1271 */       if (sItemPriceCfg != null)
/*      */       {
/* 1273 */         recommandSilver = sItemPriceCfg.baiTanSilverNum;
/*      */       }
/* 1275 */       itemSale.setRecommendprice(recommandSilver);
/* 1276 */       itemSale.setTotalsellnum(0L);
/* 1277 */       itemSale.setTotalsellmoney(0L);
/* 1278 */       Item2sales.insert(Long.valueOf(key), itemSale);
/*      */     }
/* 1280 */     itemSale.setTotalgridnum(itemSale.getTotalgridnum() + 1);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void decItemGridnum(int itemid)
/*      */   {
/* 1292 */     long key = GameServerInfoManager.toGlobalId(itemid);
/* 1293 */     ItemSale itemSale = Item2sales.get(Long.valueOf(key));
/*      */     
/* 1295 */     if ((itemSale == null) || (itemSale.getTotalgridnum() <= 0))
/*      */     {
/* 1297 */       return;
/*      */     }
/* 1299 */     itemSale.setTotalgridnum(itemSale.getTotalgridnum() - 1);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getFreshCanBuyGroupNum(int itemid)
/*      */   {
/* 1311 */     SItemId2BaitanItemCfgid id2BaitanItemCfgid = SItemId2BaitanItemCfgid.get(itemid);
/* 1312 */     if (id2BaitanItemCfgid == null)
/*      */     {
/* 1314 */       return 0;
/*      */     }
/* 1316 */     SBaitanItemCfg sb = SBaitanItemCfg.get(id2BaitanItemCfgid.baitanItemid);
/* 1317 */     if (sb == null)
/*      */     {
/* 1319 */       return 0;
/*      */     }
/* 1321 */     int num = sb.minBuyNum;
/* 1322 */     if (sb.maxBuyNum - sb.minBuyNum > 0)
/*      */     {
/* 1324 */       num += Xdb.random().nextInt(sb.maxBuyNum - sb.minBuyNum);
/*      */     }
/*      */     
/* 1327 */     return num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean canDisplayItem(int itemid, int serverlevel)
/*      */   {
/* 1338 */     SItemId2BaitanItemCfgid id2BaitanItemCfgid = SItemId2BaitanItemCfgid.get(itemid);
/* 1339 */     if (id2BaitanItemCfgid == null)
/*      */     {
/* 1341 */       return false;
/*      */     }
/* 1343 */     SBaitanItemCfg sb = SBaitanItemCfg.get(id2BaitanItemCfgid.baitanItemid);
/* 1344 */     if (sb == null)
/*      */     {
/* 1346 */       return false;
/*      */     }
/* 1348 */     if (sb.supplyLevel == 0)
/*      */     {
/* 1350 */       return true;
/*      */     }
/* 1352 */     if (sb.supplyLevel == -1)
/*      */     {
/* 1354 */       return false;
/*      */     }
/*      */     
/* 1357 */     return (BaiTanConsts.getInstance().ITEM_DISPLAY_INIT_SERVER_LEVEL <= sb.supplyLevel) && (sb.supplyLevel <= serverlevel + BaiTanConsts.getInstance().SERVER_LEVEL_DELTA);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static int getCanBuyPriceTypeNum(int itemid)
/*      */   {
/* 1369 */     SItemId2BaitanItemCfgid id2BaitanItemCfgid = SItemId2BaitanItemCfgid.get(itemid);
/* 1370 */     if (id2BaitanItemCfgid == null)
/*      */     {
/* 1372 */       return 0;
/*      */     }
/* 1374 */     SBaitanItemCfg sb = SBaitanItemCfg.get(id2BaitanItemCfgid.baitanItemid);
/* 1375 */     if (sb == null)
/*      */     {
/* 1377 */       return 0;
/*      */     }
/* 1379 */     return sb.pricetypenum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static List<Integer> getPriceTypes(List<Integer> priceSet, int maxPriceNum)
/*      */   {
/* 1390 */     List<Integer> reList = new ArrayList();
/* 1391 */     if (maxPriceNum >= priceSet.size())
/*      */     {
/* 1393 */       reList.addAll(priceSet);
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/* 1398 */       mzm.gsp.util.CommonUtils.regionRandom(priceSet, maxPriceNum, reList);
/*      */     }
/*      */     
/* 1401 */     return reList;
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
/*      */   static List<Integer> getSupplyPriceTypes(List<Integer> toremovePrices, int supplyPricenum, int itemid)
/*      */   {
/* 1417 */     List<Integer> prices = new ArrayList();
/*      */     
/* 1419 */     int basePrice = getItemRecommendPrice(itemid);
/* 1420 */     if (basePrice == -1)
/*      */     {
/* 1422 */       return prices;
/*      */     }
/* 1424 */     prices.add(Integer.valueOf(basePrice));
/* 1425 */     int x = BaiTanConsts.getInstance().BASE_RATE / BaiTanConsts.getInstance().SINGLE_ADD_PRICE_RATE;
/* 1426 */     int delta = (int)(basePrice / x);
/* 1427 */     int s = 0;
/* 1428 */     for (int i = 1; i <= x / 2; i++)
/*      */     {
/* 1430 */       s += delta;
/* 1431 */       prices.add(Integer.valueOf(basePrice + s));
/*      */     }
/*      */     
/*      */ 
/* 1435 */     if ((toremovePrices != null) && (!toremovePrices.isEmpty()))
/*      */     {
/* 1437 */       prices.removeAll(toremovePrices);
/*      */     }
/*      */     
/* 1440 */     Collections.shuffle(prices);
/* 1441 */     return prices.subList(0, Math.min(supplyPricenum, prices.size()));
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
/*      */   static void freshRoleShoppingListBySubtype(long roleid, Subtype2ItemList subtype2ItemList, int subtype, int rolelevel, int serverlevel, long curtime, RoleGrid roleGrid)
/*      */   {
/* 1461 */     DisplayItemList displayItemList = (DisplayItemList)subtype2ItemList.getSub2itemlist().get(Integer.valueOf(subtype));
/* 1462 */     if (displayItemList == null)
/*      */     {
/* 1464 */       displayItemList = Pod.newDisplayItemList();
/* 1465 */       subtype2ItemList.getSub2itemlist().put(Integer.valueOf(subtype), displayItemList);
/*      */     }
/* 1467 */     displayItemList.getDisplayitemlist().clear();
/* 1468 */     displayItemList.setFreshtime(curtime);
/* 1469 */     clearTimeOutSubtype(subtype2ItemList, curtime);
/* 1470 */     int subsize = getSubSizeByid(subtype);
/*      */     
/* 1472 */     SSubtypeid2ItemList subtypeid2ItemListCfg = SSubtypeid2ItemList.get(subtype);
/* 1473 */     if ((subtypeid2ItemListCfg == null) || (subtypeid2ItemListCfg.itemlist.isEmpty()))
/*      */     {
/* 1475 */       String logStr = String.format("[baitan]BaiTanManager.freshRoleShoppingList@subtype id not exists or itemlist id empty|roleid=%d|subtype=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(subtype) });
/*      */       
/*      */ 
/* 1478 */       logger.error(logStr);
/* 1479 */       return;
/*      */     }
/* 1481 */     List<Integer> itemList = new ArrayList(subtypeid2ItemListCfg.itemlist);
/* 1482 */     Collections.shuffle(itemList);
/* 1483 */     for (Iterator i$ = itemList.iterator(); i$.hasNext();) { int itemid = ((Integer)i$.next()).intValue();
/*      */       
/* 1485 */       SItemCfg itemCfg = ItemInterface.getSItemCfg(itemid);
/* 1486 */       if (itemCfg == null)
/*      */       {
/* 1488 */         String logStr = String.format("[baitan]BaiTanManager.freshRoleShoppingList@itemid error|roleid=%d|itemid=%d|subtype=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(itemid), Integer.valueOf(subtype) });
/*      */         
/*      */ 
/* 1491 */         logger.error(logStr);
/*      */ 
/*      */       }
/* 1494 */       else if ((!ItemBanTrade.getInstance().isBanTrade(mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum.BAITAN.value, itemid)) && 
/*      */       
/*      */ 
/*      */ 
/* 1498 */         (itemCfg.awardRoleLevelMax > rolelevel) && (itemCfg.awardRoleLevelMin < rolelevel) && 
/*      */         
/*      */ 
/*      */ 
/* 1502 */         (canDisplayItem(itemid, serverlevel)))
/*      */       {
/*      */ 
/*      */ 
/* 1506 */         long key = GameServerInfoManager.toGlobalId(itemid);
/* 1507 */         Prices prices = Item2prices.select(Long.valueOf(key));
/* 1508 */         Set<Integer> sellingpriceSet = new java.util.HashSet();
/* 1509 */         if (prices != null)
/*      */         {
/* 1511 */           sellingpriceSet.addAll(filterPrice(prices, curtime));
/*      */         }
/*      */         
/* 1514 */         int maxPricenum = getCanBuyPriceTypeNum(itemid);
/* 1515 */         List<Integer> priceList = null;
/* 1516 */         int sysmaxsellnum = getMaxSysSellNum(itemid);
/* 1517 */         if (!sellingpriceSet.isEmpty())
/*      */         {
/* 1519 */           priceList = getPriceTypes(new ArrayList(sellingpriceSet), maxPricenum);
/*      */ 
/*      */ 
/*      */         }
/* 1523 */         else if ((sysmaxsellnum != 0) && (getSysSellItemNum(itemid, false) < sysmaxsellnum))
/*      */         {
/* 1525 */           priceList = getSupplyPriceTypes(null, maxPricenum, itemid);
/*      */         }
/*      */         
/*      */ 
/* 1529 */         if ((priceList != null) && (!priceList.isEmpty()))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/* 1534 */           Collections.shuffle(priceList);
/* 1535 */           if (itemCfg.type == 2)
/*      */           {
/*      */ 
/* 1538 */             if (itemCfg.useLevel <= getCanSeeMaxEquipLevel(rolelevel))
/*      */             {
/* 1540 */               int totalgridnum = getFreshCanBuyGroupNum(itemid);
/* 1541 */               int gridnumPerPrice = (totalgridnum - 1) / priceList.size() + 1;
/* 1542 */               if (!sellingpriceSet.isEmpty())
/*      */               {
/* 1544 */                 fillEquipItem(roleid, itemid, prices, priceList, displayItemList.getDisplayitemlist(), totalgridnum, gridnumPerPrice, subsize, roleGrid);
/*      */ 
/*      */               }
/*      */               else
/*      */               {
/* 1549 */                 fillEquipFromSys(displayItemList.getDisplayitemlist(), priceList, totalgridnum, gridnumPerPrice, itemid, subsize);
/*      */ 
/*      */               }
/*      */               
/*      */ 
/*      */             }
/*      */             
/*      */ 
/*      */ 
/*      */           }
/*      */           else
/*      */           {
/* 1561 */             fillNormalItem(displayItemList.getDisplayitemlist(), priceList, itemid, subsize); }
/*      */         }
/*      */       }
/*      */     }
/* 1565 */     startClearFreshObserver(roleid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void clearTimeOutSubtype(Subtype2ItemList subtype2ItemList, long curtime)
/*      */   {
/* 1576 */     List<Integer> toremove = new ArrayList();
/* 1577 */     for (Iterator i$ = subtype2ItemList.getSub2itemlist().keySet().iterator(); i$.hasNext();) { int subtype = ((Integer)i$.next()).intValue();
/*      */       
/* 1579 */       if (((DisplayItemList)subtype2ItemList.getSub2itemlist().get(Integer.valueOf(subtype))).getFreshtime() != curtime)
/*      */       {
/* 1581 */         toremove.add(Integer.valueOf(subtype));
/*      */       }
/*      */     }
/* 1584 */     for (Iterator i$ = toremove.iterator(); i$.hasNext();) { int su = ((Integer)i$.next()).intValue();
/*      */       
/* 1586 */       subtype2ItemList.getSub2itemlist().remove(Integer.valueOf(su));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void startClearFreshObserver(long roleid)
/*      */   {
/* 1598 */     ClearRoleBaitanInfoOberver oldoberver = (ClearRoleBaitanInfoOberver)roleid2baitanfreshoberver.get(Long.valueOf(roleid));
/* 1599 */     if (oldoberver == null)
/*      */     {
/* 1601 */       roleid2baitanfreshoberver.put(Long.valueOf(roleid), new ClearRoleBaitanInfoOberver(roleid, BaiTanConsts.getInstance().FREE_REFRESH_TIME_COUNTER));
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
/*      */   static void removeClearFreshObserver(long roleid)
/*      */   {
/* 1614 */     ClearRoleBaitanInfoOberver oldoberver = (ClearRoleBaitanInfoOberver)roleid2baitanfreshoberver.remove(Long.valueOf(roleid));
/* 1615 */     if (oldoberver != null)
/*      */     {
/* 1617 */       oldoberver.stopTimer();
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
/*      */ 
/*      */   private static int fillNormalItem(List<DisplayItem> displayItemList, List<Integer> priceList, int itemid, int subsize)
/*      */   {
/* 1635 */     int numberpergrid = getNumPerGrid(itemid);
/* 1636 */     int totalgridnum = getFreshCanBuyGroupNum(itemid);
/*      */     
/* 1638 */     int gridnumPerPrice = (totalgridnum - 1) / priceList.size() + 1;
/* 1639 */     int t = 0;
/* 1640 */     for (Iterator i$ = priceList.iterator(); i$.hasNext();) { int price = ((Integer)i$.next()).intValue();
/*      */       
/*      */ 
/* 1643 */       if ((displayItemList.size() >= subsize) || (totalgridnum <= 0)) {
/*      */         break;
/*      */       }
/*      */       
/* 1647 */       int c = 0;
/*      */       
/* 1649 */       while ((c < gridnumPerPrice) && (totalgridnum > 0) && (displayItemList.size() < subsize))
/*      */       {
/* 1651 */         int num = numberpergrid == 0 ? 1 : Xdb.random().nextInt(numberpergrid) + 1;
/* 1652 */         DisplayItem displayItem = Pod.newDisplayItem();
/* 1653 */         displayItem.setItemid(itemid);
/* 1654 */         displayItem.setPrice(price);
/* 1655 */         displayItem.setShoppingid(0L);
/* 1656 */         displayItem.setChannelidornum(num);
/* 1657 */         displayItemList.add(displayItem);
/* 1658 */         totalgridnum--;
/* 1659 */         c++;
/* 1660 */         t++;
/* 1661 */         if (c >= gridnumPerPrice) {
/*      */           break;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1668 */     return t;
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
/*      */   static int fillNormalItemWithRolePrice(long roleid, int itemid, Prices prices, List<Integer> priceList, List<DisplayItem> displayItemList, int totalgridnum, int gridnumPerPrice, int subsize, RoleGrid roleGrid)
/*      */   {
/* 1687 */     return fillEquipItem(roleid, itemid, prices, priceList, displayItemList, totalgridnum, gridnumPerPrice, subsize, roleGrid);
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
/*      */   private static int fillEquipItem(long roleid, int itemid, Prices prices, List<Integer> priceList, List<DisplayItem> displayItemList, int totalgridnum, int gridnumPerPrice, int subsize, RoleGrid roleGrid)
/*      */   {
/* 1708 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*      */     
/* 1710 */     int restgridnum = totalgridnum;
/* 1711 */     int usedgridnum = 0;
/* 1712 */     for (Iterator i$ = priceList.iterator(); i$.hasNext();) { int price = ((Integer)i$.next()).intValue();
/*      */       
/* 1714 */       if ((displayItemList.size() >= subsize) || (restgridnum <= 0)) {
/*      */         break;
/*      */       }
/*      */       
/* 1718 */       Channels channels = (Channels)prices.getPrice2channels().get(Integer.valueOf(price));
/* 1719 */       if ((channels != null) && (!channels.getChannels().isEmpty()))
/*      */       {
/*      */ 
/*      */ 
/* 1723 */         int k = 0;
/* 1724 */         int c = 0;
/* 1725 */         while ((k < channels.getChannels().size()) && (displayItemList.size() < subsize) && (restgridnum > 0))
/*      */         {
/* 1727 */           long chid = ((Long)channels.getChannels().get(k)).longValue();
/* 1728 */           k++;
/* 1729 */           ShoppingIds shoppingIds = Channel2shoppingid.select(Long.valueOf(chid));
/* 1730 */           if ((shoppingIds != null) && (!shoppingIds.getShoppingids().isEmpty()))
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/* 1735 */             int i = 0;
/* 1736 */             while ((i < shoppingIds.getShoppingids().size()) && (displayItemList.size() < subsize) && (restgridnum > 0))
/*      */             {
/* 1738 */               long shoppingid = ((Long)shoppingIds.getShoppingids().get(i)).longValue();
/* 1739 */               i++;
/* 1740 */               if (!roleGrid.getShoppingid2channelid().containsKey(Long.valueOf(shoppingid)))
/*      */               {
/*      */ 
/*      */ 
/* 1744 */                 Long expiretime = Roleshoppinginfo.selectExpire(Long.valueOf(shoppingid));
/* 1745 */                 if ((expiretime != null) && (expiretime.longValue() > now))
/*      */                 {
/*      */ 
/*      */ 
/* 1749 */                   DisplayItem displayItem = Pod.newDisplayItem();
/* 1750 */                   displayItem.setItemid(itemid);
/* 1751 */                   displayItem.setPrice(price);
/* 1752 */                   displayItem.setShoppingid(shoppingid);
/* 1753 */                   displayItem.setChannelidornum(chid);
/* 1754 */                   displayItemList.add(displayItem);
/* 1755 */                   c++;
/* 1756 */                   restgridnum--;
/* 1757 */                   usedgridnum++;
/* 1758 */                   if (c >= gridnumPerPrice) {
/*      */                     break;
/*      */                   }
/*      */                 }
/*      */               }
/*      */             }
/* 1764 */             if (c >= gridnumPerPrice) {
/*      */               break;
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/* 1771 */     return usedgridnum;
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
/*      */   private static int fillEquipFromSys(List<DisplayItem> displayItemList, List<Integer> restPricelist, int restgridnum, int gridnumPerPrice, int itemid, int subsize)
/*      */   {
/* 1791 */     int c = 0;
/* 1792 */     int t = 0;
/* 1793 */     while ((t < restPricelist.size()) && (displayItemList.size() < subsize) && (restgridnum > 0))
/*      */     {
/* 1795 */       int price = ((Integer)restPricelist.get(t)).intValue();
/* 1796 */       t++;
/* 1797 */       int restnum = Math.min(gridnumPerPrice, restgridnum);
/* 1798 */       for (int i = 0; i < restnum; i++)
/*      */       {
/* 1800 */         DisplayItem displayItem = Pod.newDisplayItem();
/* 1801 */         displayItem.setChannelidornum(1L);
/* 1802 */         displayItem.setShoppingid(0L);
/* 1803 */         displayItem.setItemid(itemid);
/* 1804 */         displayItem.setPrice(price);
/* 1805 */         displayItemList.add(displayItem);
/*      */       }
/*      */       
/* 1808 */       restgridnum -= restnum;
/* 1809 */       c += restnum;
/*      */     }
/*      */     
/* 1812 */     return c;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getBaitanSubtype()
/*      */   {
/* 1822 */     return ((Integer)SBaitanSubTypeCfg.getAll().keySet().iterator().next()).intValue();
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
/*      */   static void sendSSellItemRes(long roleId, int price, long shoppingid, Item item)
/*      */   {
/* 1835 */     SSellItemRes res = new SSellItemRes();
/* 1836 */     res.myshoppingitem.price = price;
/* 1837 */     res.myshoppingitem.shoppingid = shoppingid;
/* 1838 */     res.myshoppingitem.state = 0;
/* 1839 */     res.myshoppingitem.sellnum = 0;
/* 1840 */     fillItem(res.myshoppingitem.item, item);
/*      */     
/* 1842 */     OnlineManager.getInstance().send(roleId, res);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isEquipSubtype(int subtype)
/*      */   {
/* 1854 */     SSubtypeid2ItemList subtypeid2ItemList = SSubtypeid2ItemList.get(subtype);
/* 1855 */     if ((subtypeid2ItemList == null) || (subtypeid2ItemList.itemlist.isEmpty()))
/*      */     {
/* 1857 */       return false;
/*      */     }
/* 1859 */     int itemid = ((Integer)subtypeid2ItemList.itemlist.get(0)).intValue();
/* 1860 */     return SItemEquipCfg.get(itemid) != null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getCanSeeMaxEquipLevel(int rolelevel)
/*      */   {
/* 1872 */     return rolelevel / BaiTanConsts.getInstance().ROLE_LEVEL_PHASE * BaiTanConsts.getInstance().ROLE_LEVEL_PHASE + BaiTanConsts.getInstance().CAN_SEE_EQUIP_LEVEL_DELTA;
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
/*      */   static mzm.gsp.item.main.EquipmentItem createFixEquipItem(int itemid, boolean isbind, boolean isgenerateUuid)
/*      */   {
/* 1885 */     return mzm.gsp.item.main.EquipmentItem.createFixEquipItem(itemid, 1, 1, 1, isbind, isgenerateUuid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static List<Integer> filterPrice(Prices prices, long now)
/*      */   {
/* 1896 */     List<Integer> pricelist = new ArrayList();
/*      */     
/* 1898 */     for (Iterator i$ = prices.getPrice2channels().keySet().iterator(); i$.hasNext();) { int price = ((Integer)i$.next()).intValue();
/*      */       
/*      */ 
/* 1901 */       Channels channels = (Channels)prices.getPrice2channels().get(Integer.valueOf(price));
/*      */       
/* 1903 */       if ((channels != null) && (!channels.getChannels().isEmpty()))
/*      */       {
/*      */ 
/*      */ 
/* 1907 */         int size = channels.getChannels().size();
/* 1908 */         for (int i = size - 1; i >= 0; i--)
/*      */         {
/* 1910 */           long channelid = ((Long)channels.getChannels().get(i)).longValue();
/* 1911 */           ShoppingIds shoppingIds = Channel2shoppingid.select(Long.valueOf(channelid));
/* 1912 */           if ((shoppingIds != null) && (!shoppingIds.getShoppingids().isEmpty()))
/*      */           {
/*      */ 
/*      */ 
/* 1916 */             long lastshoppingid = ((Long)shoppingIds.getShoppingids().get(shoppingIds.getShoppingids().size() - 1)).longValue();
/* 1917 */             ShoppingInfo shoppingInfo = Roleshoppinginfo.select(Long.valueOf(lastshoppingid));
/* 1918 */             if (shoppingInfo != null)
/*      */             {
/*      */ 
/*      */ 
/* 1922 */               if (shoppingInfo.getExpire() > now)
/*      */               {
/* 1924 */                 pricelist.add(Integer.valueOf(price));
/* 1925 */                 break;
/*      */               } }
/*      */           }
/*      */         } } }
/* 1929 */     return pricelist;
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
/*      */   static boolean isLowerThanRecyclePrice(int price, int recommendPrice)
/*      */   {
/* 1944 */     return price / recommendPrice * BaiTanConsts.getInstance().BASE_RATE < BaiTanConsts.getInstance().RECYCLE_PRICE_RATE;
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
/*      */   static long computeRecycleInterval(int price, int recommendPrice)
/*      */   {
/* 1959 */     int min = BaiTanConsts.getInstance().RECYCLE_MIN_TIME;
/* 1960 */     int max = BaiTanConsts.getInstance().RECYCLE_FIX_TIME + (int)(price / recommendPrice * BaiTanConsts.getInstance().RECYCLE_FLOAT_TIME);
/*      */     
/* 1962 */     int r = 0;
/* 1963 */     if (max - min > 0)
/*      */     {
/* 1965 */       r = Xdb.random().nextInt(max - min);
/*      */     }
/*      */     
/* 1968 */     return TimeUnit.HOURS.toMillis(r + min);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static boolean isBaiTanFixPriceSwitchOpen()
/*      */   {
/* 1978 */     return OpenInterface.getOpenStatus(56);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isRoleStateCanBaiTanBuyOrSell(long roleid)
/*      */   {
/* 1990 */     return mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(roleid, 145, true);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static ChannelShopingIdBean findChannelShoppingBean(Channels xChannels)
/*      */   {
/* 2001 */     long channelid = findLastChannelid(xChannels);
/* 2002 */     ShoppingIds shoppingIds = null;
/* 2003 */     if (channelid != -1L)
/*      */     {
/* 2005 */       shoppingIds = Channel2shoppingid.select(Long.valueOf(channelid));
/* 2006 */       if ((shoppingIds == null) || (shoppingIds.getShoppingids().size() >= getChannelSize()))
/*      */       {
/* 2008 */         return addXShoppingIds(xChannels);
/*      */       }
/*      */       
/*      */ 
/* 2012 */       shoppingIds = Channel2shoppingid.get(Long.valueOf(channelid));
/* 2013 */       if ((shoppingIds == null) || (shoppingIds.getShoppingids().size() >= getChannelSize()))
/*      */       {
/* 2015 */         return null;
/*      */       }
/*      */       
/*      */ 
/* 2019 */       return new ChannelShopingIdBean(channelid, shoppingIds);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2026 */     return addXShoppingIds(xChannels);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static ChannelShopingIdBean addXShoppingIds(Channels xChannels)
/*      */   {
/* 2033 */     ShoppingIds xShoppingIds = Pod.newShoppingIds();
/* 2034 */     long channelid = Channel2shoppingid.insert(xShoppingIds).longValue();
/* 2035 */     xChannels.getChannels().add(Long.valueOf(channelid));
/* 2036 */     return new ChannelShopingIdBean(channelid, xShoppingIds);
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\main\BaiTanManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */