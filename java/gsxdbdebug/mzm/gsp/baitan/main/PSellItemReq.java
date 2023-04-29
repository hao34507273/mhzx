/*     */ package mzm.gsp.baitan.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.baitan.event.ShangJiaArg;
/*     */ import mzm.gsp.baitan.event.ShangJiaEvent;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemBanTrade;
/*     */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Channels;
/*     */ import xbean.RoleGrid;
/*     */ import xbean.ShoppingIds;
/*     */ import xbean.Shoppoingid2Sessionid;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Item2prices;
/*     */ import xtable.Role2grid;
/*     */ import xtable.Role2shoppingsession;
/*     */ 
/*     */ public class PSellItemReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private int bagId;
/*     */   private int itemKey;
/*     */   private int itemid;
/*     */   private int price;
/*     */   private int num;
/*     */   
/*     */   public PSellItemReq(long roleId, int bagId, int itemKey, int itemid, int price, int num)
/*     */   {
/*  40 */     this.roleId = roleId;
/*  41 */     this.bagId = bagId;
/*  42 */     this.itemKey = itemKey;
/*  43 */     this.itemid = itemid;
/*  44 */     this.price = price;
/*  45 */     this.num = num;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  51 */     if (ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.BAITAN.value, this.itemid))
/*     */     {
/*  53 */       ItemBanTrade.getInstance().sendTipToTole(this.roleId, ItemInterface.getItemName(this.itemid));
/*  54 */       return false;
/*     */     }
/*  56 */     String log = String.format("[baitan]PSellItemReq.processImp@receive sellitem req|roleid=%d|bagid=%d|itemid=%d|itemkey=%d|price=%d|num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagId), Integer.valueOf(this.itemid), Integer.valueOf(this.itemKey), Integer.valueOf(this.price), Integer.valueOf(this.num) });
/*     */     
/*     */ 
/*  59 */     BaiTanManager.logger.info(log);
/*     */     
/*  61 */     if ((this.price <= 0) || (this.num <= 0) || (this.num > BaiTanManager.getCanShangjiaNumPerGrid(this.itemid)))
/*     */     {
/*  63 */       return false;
/*     */     }
/*  65 */     Lockeys.lock(Role2grid.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  66 */     if (!BaiTanManager.isRoleStateCanBaiTanBuyOrSell(this.roleId))
/*     */     {
/*  68 */       String logStr = String.format("[baitan]PSellItemReq.processImp@role state can not baitan sell or buy|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  70 */       BaiTanManager.logger.info(logStr);
/*  71 */       return false;
/*     */     }
/*  73 */     long key = GameServerInfoManager.toGlobalId(this.itemid);
/*  74 */     Lockeys.lock(Item2prices.getTable(), Arrays.asList(new Long[] { Long.valueOf(key) }));
/*  75 */     RoleGrid roleGrid = Role2grid.get(Long.valueOf(this.roleId));
/*  76 */     if (roleGrid == null)
/*     */     {
/*  78 */       return false;
/*     */     }
/*  80 */     if (!BaiTanManager.isBaiTanSwitchOpenForRole(this.roleId))
/*     */     {
/*  82 */       return false;
/*     */     }
/*  84 */     int subtype = BaiTanManager.getSubtypeidByItemid(this.itemid);
/*  85 */     if (subtype == -1)
/*     */     {
/*  87 */       String logStr = String.format("[baitan]PSellItemReq.processImp@subtype error|roleid=%d|bagid=%d|itemid=%d|price=%d|subtype=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagId), Integer.valueOf(this.itemid), Integer.valueOf(this.price), Integer.valueOf(subtype) });
/*     */       
/*     */ 
/*  90 */       BaiTanManager.logger.error(logStr);
/*     */       
/*  92 */       return false;
/*     */     }
/*  94 */     if (roleGrid.getShoppingid2channelid().size() >= roleGrid.getMaxgridnum())
/*     */     {
/*  96 */       String logStr = String.format("[baitan]PSellItemReq.processImp@baitan grid not enough|roleid=%d|gridnum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(roleGrid.getShoppingid2channelid().size()) });
/*     */       
/*  98 */       BaiTanManager.logger.error(logStr);
/*     */       
/* 100 */       return false;
/*     */     }
/*     */     
/* 103 */     TLogArg logArg = new TLogArg(LogReason.BAITAN_SHANGJIA_REM, this.itemid);
/*     */     
/* 105 */     BasicItem basicitem = ItemInterface.getAndRemoveItemInBag(this.roleId, this.bagId, this.itemKey, this.num, logArg);
/* 106 */     if ((basicitem == null) || (basicitem.getCfgId() != this.itemid) || (this.num != basicitem.getNumber()) || (basicitem.isBind()))
/*     */     {
/* 108 */       String logStr = String.format("[baitan]PSellItemReq.processImp@baitan item error|roleid=%d|bagid=%d|itmekey=%d|itemid=%d|serveritemid=%d|num=%d|servernum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagId), Integer.valueOf(this.itemKey), Integer.valueOf(this.itemid), Integer.valueOf(basicitem == null ? 0 : basicitem.getCfgId()), Integer.valueOf(this.num), Integer.valueOf(basicitem == null ? 0 : basicitem.getNumber()) });
/*     */       
/*     */ 
/*     */ 
/* 112 */       BaiTanManager.logger.error(logStr);
/*     */       
/* 114 */       return false;
/*     */     }
/*     */     
/* 117 */     int itemid = basicitem.getCfgId();
/* 118 */     int needgridnum = BaiTanManager.getNeedGrid(itemid, this.num);
/* 119 */     if (roleGrid.getShoppingid2channelid().size() + needgridnum > roleGrid.getMaxgridnum())
/*     */     {
/* 121 */       String logStr = String.format("[baitan]PSellItemReq.processImp@baitan item grid not enough|roleid=%d|bagid=%d|itmekey=%d|itemid=%d|needgrid=%d|hasgrid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagId), Integer.valueOf(this.itemKey), Integer.valueOf(this.itemid), Integer.valueOf(needgridnum), Integer.valueOf(roleGrid.getMaxgridnum() - roleGrid.getShoppingid2channelid().size()) });
/*     */       
/*     */ 
/*     */ 
/* 125 */       BaiTanManager.logger.error(logStr);
/* 126 */       return false;
/*     */     }
/*     */     
/* 129 */     int recommendPrice = BaiTanManager.getItemRecommendPrice(itemid);
/* 130 */     int newprice = BaiTanManager.checkAndModifyPrice(this.price, itemid);
/* 131 */     if ((recommendPrice <= 0) || (newprice <= 0))
/*     */     {
/* 133 */       String logStr = String.format("[baitan]PSellItemReq.processImp@baitan sell item price error|roleid=%d|bagid=%d|itmekey=%d|itemid=%d|price=%d|newprice=%d|recommendPrice=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagId), Integer.valueOf(this.itemKey), Integer.valueOf(this.itemid), Integer.valueOf(this.price), Integer.valueOf(newprice), Integer.valueOf(recommendPrice) });
/*     */       
/*     */ 
/* 136 */       BaiTanManager.logger.error(logStr);
/* 137 */       return false;
/*     */     }
/*     */     
/* 140 */     int tax = BaiTanManager.computeNeedTaxSillver(newprice, itemid, this.num);
/* 141 */     if (tax <= 0)
/*     */     {
/* 143 */       String logStr = String.format("[baitan]PSellItemReq.processImp@baitan sell item tax error|roleid=%d|bagid=%d|itmekey=%d|itemid=%d|tax=%d|num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagId), Integer.valueOf(this.itemKey), Integer.valueOf(this.itemid), Integer.valueOf(tax), Integer.valueOf(this.num) });
/*     */       
/*     */ 
/* 146 */       BaiTanManager.logger.error(logStr);
/* 147 */       return false;
/*     */     }
/* 149 */     if (!mzm.gsp.role.main.RoleInterface.cutSilver(this.roleId, tax, logArg))
/*     */     {
/* 151 */       BaiTanManager.sendCommonError(this.roleId, 4);
/*     */       
/* 153 */       return false;
/*     */     }
/* 155 */     Channels xChannels = BaiTanManager.getChannelOnAdd(itemid, newprice);
/*     */     
/* 157 */     ChannelShopingIdBean cs = BaiTanManager.findChannelShoppingBean(xChannels);
/* 158 */     if (cs == null)
/*     */     {
/* 160 */       String logStr = String.format("[baitan]PSellItemReq.processImp@find channelid and xbean.Shpoppingid error|roleid=%d|itemid=%d|newprice=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(itemid), Integer.valueOf(newprice) });
/*     */       
/*     */ 
/* 163 */       BaiTanManager.logger.error(logStr);
/* 164 */       return false;
/*     */     }
/* 166 */     long channelid = cs.channelid;
/* 167 */     ShoppingIds shoppingIds = cs.xShoppingIds;
/*     */     
/* 169 */     boolean isLower = BaiTanManager.isLowerThanRecyclePrice(newprice, recommendPrice);
/* 170 */     boolean isNeedRecycle = false;
/* 171 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 172 */     long expireTime = 0L;
/* 173 */     long intervalMills = 0L;
/* 174 */     if (isLower)
/*     */     {
/* 176 */       intervalMills = BaiTanManager.computeRecycleInterval(newprice, recommendPrice);
/* 177 */       if (intervalMills < BaiTanManager.getBaitangItemInterval())
/*     */       {
/* 179 */         isNeedRecycle = true;
/* 180 */         expireTime = now + intervalMills;
/*     */       }
/*     */       else
/*     */       {
/* 184 */         isNeedRecycle = false;
/* 185 */         expireTime = now + BaiTanManager.getBaitangItemInterval();
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 190 */       isNeedRecycle = false;
/* 191 */       expireTime = now + BaiTanManager.getBaitangItemInterval();
/*     */     }
/*     */     
/* 194 */     long shoppingid = BaiTanManager.createShoppingInfo(basicitem.getItem(), this.roleId, newprice, expireTime);
/* 195 */     boolean ret = shoppingIds.getShoppingids().add(Long.valueOf(shoppingid));
/* 196 */     if (!ret)
/*     */     {
/* 198 */       return false;
/*     */     }
/*     */     
/* 201 */     ret = BaiTanManager.addRoleShoppingChannel(this.roleId, shoppingid, channelid);
/* 202 */     if (!ret)
/*     */     {
/* 204 */       return false;
/*     */     }
/*     */     
/* 207 */     BaiTanManager.sendSSellItemRes(this.roleId, newprice, shoppingid, basicitem.getItem());
/*     */     
/* 209 */     TriggerEventsManger.getInstance().triggerEvent(new ShangJiaEvent(), new ShangJiaArg(this.roleId, itemid, this.num, newprice));
/*     */     
/* 211 */     Shoppoingid2Sessionid shoppoingid2Sessionid = Role2shoppingsession.get(Long.valueOf(this.roleId));
/* 212 */     if (shoppoingid2Sessionid == null)
/*     */     {
/* 214 */       shoppoingid2Sessionid = xbean.Pod.newShoppoingid2Sessionid();
/* 215 */       Role2shoppingsession.insert(Long.valueOf(this.roleId), shoppoingid2Sessionid);
/*     */     }
/* 217 */     long lengthTime = TimeUnit.MILLISECONDS.toSeconds(BaiTanManager.getBaitangItemInterval());
/*     */     
/* 219 */     if (isNeedRecycle)
/*     */     {
/* 221 */       lengthTime = TimeUnit.MILLISECONDS.toSeconds(intervalMills);
/*     */       
/* 223 */       BaiTanManager.startRecycleObserver(shoppoingid2Sessionid, this.roleId, shoppingid, intervalMills);
/* 224 */       roleGrid.getNeedrecycleshoppingids().add(Long.valueOf(shoppingid));
/*     */     }
/*     */     else
/*     */     {
/* 228 */       BaiTanManager.startObserver(shoppoingid2Sessionid, this.roleId, shoppingid, BaiTanManager.getBaitangItemInterval());
/* 229 */       lengthTime = TimeUnit.MILLISECONDS.toSeconds(BaiTanManager.getBaitangItemInterval());
/*     */     }
/*     */     
/*     */ 
/* 233 */     BaiTanManager.addItemGridnum(itemid);
/* 234 */     BaiTanManager.tlogBaitan(this.roleId, itemid, this.num, newprice, tax, 0, BaiTanOperateEnum.NORMAL);
/* 235 */     BaiTanManager.tlogBaitanSellForIdip(this.roleId, itemid, this.num, newprice, new HashSet(basicitem.getUuid()), shoppingid, lengthTime, BaiTanOperateEnum.NORMAL.value);
/*     */     
/* 237 */     return ret;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\main\PSellItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */