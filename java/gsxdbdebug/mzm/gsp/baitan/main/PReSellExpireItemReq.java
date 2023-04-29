/*     */ package mzm.gsp.baitan.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.baitan.SReSellExpireItemRes;
/*     */ import mzm.gsp.item.main.ItemBanTrade;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Channels;
/*     */ import xbean.Item;
/*     */ import xbean.Prices;
/*     */ import xbean.RoleGrid;
/*     */ import xbean.ShoppingIds;
/*     */ import xbean.ShoppingInfo;
/*     */ import xbean.Shoppoingid2Sessionid;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2grid;
/*     */ import xtable.Role2shoppingsession;
/*     */ import xtable.Roleshoppinginfo;
/*     */ 
/*     */ public class PReSellExpireItemReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private long shoppingId;
/*     */   private int itemid;
/*     */   private int price;
/*     */   
/*     */   public PReSellExpireItemReq(long roleId, long shoppingId, int itemid, int price)
/*     */   {
/*  35 */     this.roleId = roleId;
/*  36 */     this.shoppingId = shoppingId;
/*  37 */     this.itemid = itemid;
/*  38 */     this.price = price;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     if (ItemBanTrade.getInstance().isBanTrade(mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum.BAITAN.value, this.itemid))
/*     */     {
/*  47 */       ItemBanTrade.getInstance().sendTipToTole(this.roleId, mzm.gsp.item.main.ItemInterface.getItemName(this.itemid));
/*  48 */       return false;
/*     */     }
/*  50 */     String log = String.format("[baitan]PReSellExpireItemReq.processImp@receive resellitem req|roleid=%d|itemid=%d|shoppingid=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Long.valueOf(this.shoppingId), Integer.valueOf(this.price) });
/*     */     
/*     */ 
/*  53 */     BaiTanManager.logger.info(log);
/*  54 */     if (this.price <= 0)
/*     */     {
/*  56 */       return false;
/*     */     }
/*  58 */     RoleGrid roleGrid = Role2grid.get(Long.valueOf(this.roleId));
/*  59 */     if ((roleGrid == null) || (!roleGrid.getShoppingid2channelid().containsKey(Long.valueOf(this.shoppingId))))
/*     */     {
/*  61 */       return false;
/*     */     }
/*  63 */     if (!BaiTanManager.isRoleStateCanBaiTanBuyOrSell(this.roleId))
/*     */     {
/*  65 */       String logStr = String.format("[baitan]PReSellExpireItemReq.processImp@role state can not baitan sell or buy|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  67 */       BaiTanManager.logger.info(logStr);
/*  68 */       return false;
/*     */     }
/*  70 */     if (!BaiTanManager.isBaiTanSwitchOpenForRole(this.roleId))
/*     */     {
/*  72 */       return false;
/*     */     }
/*  74 */     int subtype = BaiTanManager.getSubtypeidByItemid(this.itemid);
/*  75 */     if (subtype == -1)
/*     */     {
/*  77 */       String logStr = String.format("[baitan]PReSellExpireItemReq.processImp@subtype error|roleid=%d|itemid=%d|price=%d|subtype=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(this.price), Integer.valueOf(subtype) });
/*     */       
/*     */ 
/*  80 */       BaiTanManager.logger.error(logStr);
/*     */       
/*  82 */       return false;
/*     */     }
/*  84 */     long key = mzm.gsp.GameServerInfoManager.toGlobalId(this.itemid);
/*  85 */     Lockeys.lock(xtable.Item2prices.getTable(), Arrays.asList(new Long[] { Long.valueOf(key) }));
/*     */     
/*  87 */     long oldchannelid = ((Long)roleGrid.getShoppingid2channelid().get(Long.valueOf(this.shoppingId))).longValue();
/*  88 */     Lockeys.lock(xtable.Channel2shoppingid.getTable(), Arrays.asList(new Long[] { Long.valueOf(oldchannelid) }));
/*     */     
/*  90 */     ShoppingInfo shoppingInfo = Roleshoppinginfo.get(Long.valueOf(this.shoppingId));
/*     */     
/*  92 */     if (shoppingInfo == null)
/*     */     {
/*  94 */       String logStr = String.format("[baitan]PReSellExpireItemReq.processImp@shoppingId error|roleid=%d|shoppingId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.shoppingId) });
/*     */       
/*  96 */       BaiTanManager.logger.error(logStr);
/*     */       
/*  98 */       return false;
/*     */     }
/* 100 */     if ((shoppingInfo.getRoleid() != this.roleId) || (shoppingInfo.getItem().getCfgid() != this.itemid))
/*     */     {
/* 102 */       String logStr = String.format("[baitan]PReSellExpireItemReq.processImp@itemid or roleid error|roleid=%d|itemid=%d|sroleid=%d|sitemid=%d|shoppingId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Long.valueOf(shoppingInfo.getRoleid()), Integer.valueOf(shoppingInfo.getItem().getCfgid()), Long.valueOf(this.shoppingId) });
/*     */       
/*     */ 
/* 105 */       BaiTanManager.logger.error(logStr);
/*     */       
/* 107 */       return false;
/*     */     }
/* 109 */     int totalnum = shoppingInfo.getItem().getNumber();
/* 110 */     if (totalnum <= 0)
/*     */     {
/* 112 */       String logStr = String.format("[baitan]PReSellExpireItemReq.processImp@rest item num less than 0|roleid=%d|itemid=%d|shoppingid=%d|restnum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Long.valueOf(this.shoppingId), Integer.valueOf(totalnum) });
/*     */       
/*     */ 
/* 115 */       BaiTanManager.logger.error(logStr);
/* 116 */       return false;
/*     */     }
/* 118 */     int oldprice = shoppingInfo.getPrice();
/* 119 */     int itemid = shoppingInfo.getItem().getCfgid();
/*     */     
/* 121 */     int desprice = 0;
/* 122 */     if (this.price == oldprice)
/*     */     {
/* 124 */       desprice = oldprice;
/*     */     }
/*     */     else
/*     */     {
/* 128 */       desprice = BaiTanManager.checkAndModifyPrice(this.price, itemid);
/* 129 */       if (desprice <= 0)
/*     */       {
/* 131 */         String logStr = String.format("[baitan]PReSellExpireItemReq.processImp@baitan resell item price error|roleid=%d|itemid=%d|price=%d|newprice=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(itemid), Integer.valueOf(this.price), Integer.valueOf(desprice) });
/*     */         
/*     */ 
/* 134 */         BaiTanManager.logger.error(logStr);
/* 135 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 140 */     if (desprice != oldprice)
/*     */     {
/*     */ 
/* 143 */       BaiTanManager.removeSCPI(itemid, oldprice, oldchannelid, this.shoppingId);
/* 144 */       ReShangjia sReShangjia = new ReShangjia(this.roleId, itemid, desprice, this.shoppingId, oldchannelid, oldprice);
/* 145 */       sReShangjia.execute();
/*     */     }
/*     */     else
/*     */     {
/* 149 */       boolean r = moveShoppingidToEnd(key, oldprice, oldchannelid);
/* 150 */       if (!r)
/*     */       {
/*     */ 
/* 153 */         ReShangjia sReShangjia = new ReShangjia(this.roleId, itemid, desprice, this.shoppingId, oldchannelid, oldprice);
/* 154 */         sReShangjia.execute();
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 159 */         int tax = BaiTanManager.computeNeedTaxSillver(desprice, itemid, totalnum);
/* 160 */         if (tax <= 0)
/*     */         {
/* 162 */           String logStr = String.format("[baitan]PReSellExpireItemReq.processImp@baitan resell item tax error|roleid=%d|itemid=%d|tax=%d|num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(itemid), Integer.valueOf(tax), Integer.valueOf(totalnum) });
/*     */           
/*     */ 
/* 165 */           BaiTanManager.logger.error(logStr);
/*     */         }
/*     */         
/* 168 */         if (!mzm.gsp.role.main.RoleInterface.cutSilver(this.roleId, tax, new TLogArg(mzm.gsp.tlog.LogReason.BAITAN_SHANGJIA_REM, itemid)))
/*     */         {
/* 170 */           BaiTanManager.sendCommonError(this.roleId, 4);
/*     */           
/* 172 */           return false;
/*     */         }
/* 174 */         int recommendPrice = BaiTanManager.getItemRecommendPrice(itemid);
/* 175 */         if (recommendPrice == -1)
/*     */         {
/* 177 */           String logStr = String.format("[baitan]PReSellExpireItemReq.processImp@recommendPrice error|roleid=%d|itemid=%d|recommendPrice=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(itemid), Integer.valueOf(recommendPrice) });
/*     */           
/*     */ 
/* 180 */           BaiTanManager.logger.error(logStr);
/* 181 */           return false;
/*     */         }
/* 183 */         boolean isLower = BaiTanManager.isLowerThanRecyclePrice(desprice, recommendPrice);
/* 184 */         boolean isNeedRecycle = false;
/* 185 */         long now = DateTimeUtils.getCurrTimeInMillis();
/* 186 */         long expireTime = 0L;
/* 187 */         long intervalMills = 0L;
/* 188 */         if (isLower)
/*     */         {
/* 190 */           intervalMills = BaiTanManager.computeRecycleInterval(desprice, recommendPrice);
/* 191 */           if (intervalMills < BaiTanManager.getBaitangItemInterval())
/*     */           {
/* 193 */             isNeedRecycle = true;
/* 194 */             expireTime = now + intervalMills;
/*     */           }
/*     */           else
/*     */           {
/* 198 */             isNeedRecycle = false;
/* 199 */             expireTime = now + BaiTanManager.getBaitangItemInterval();
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 204 */           isNeedRecycle = false;
/* 205 */           expireTime = now + BaiTanManager.getBaitangItemInterval();
/*     */         }
/*     */         
/* 208 */         shoppingInfo.setPrice(desprice);
/* 209 */         shoppingInfo.setExpire(expireTime);
/* 210 */         shoppingInfo.setTotalnum(totalnum);
/*     */         
/* 212 */         BaiTanManager.addItemGridnum(itemid);
/* 213 */         Shoppoingid2Sessionid shoppoingid2Sessionid = Role2shoppingsession.get(Long.valueOf(this.roleId));
/* 214 */         if (shoppoingid2Sessionid == null)
/*     */         {
/* 216 */           shoppoingid2Sessionid = xbean.Pod.newShoppoingid2Sessionid();
/* 217 */           Role2shoppingsession.insert(Long.valueOf(this.roleId), shoppoingid2Sessionid);
/*     */         }
/* 219 */         long lengthTime = TimeUnit.MILLISECONDS.toSeconds(BaiTanManager.getBaitangItemInterval());
/* 220 */         if (isNeedRecycle)
/*     */         {
/* 222 */           BaiTanManager.reStartRecycleObserver(shoppoingid2Sessionid, this.roleId, this.shoppingId, intervalMills);
/* 223 */           roleGrid.getNeedrecycleshoppingids().add(Long.valueOf(this.shoppingId));
/* 224 */           lengthTime = TimeUnit.MILLISECONDS.toSeconds(intervalMills);
/*     */         }
/*     */         else
/*     */         {
/* 228 */           BaiTanManager.reStartObserver(shoppoingid2Sessionid, this.roleId, this.shoppingId, BaiTanManager.getBaitangItemInterval());
/*     */           
/* 230 */           lengthTime = TimeUnit.MILLISECONDS.toSeconds(BaiTanManager.getBaitangItemInterval());
/*     */         }
/*     */         
/* 233 */         SReSellExpireItemRes res = new SReSellExpireItemRes();
/* 234 */         res.shoppingid = this.shoppingId;
/* 235 */         res.price = desprice;
/* 236 */         OnlineManager.getInstance().send(this.roleId, res);
/*     */         
/* 238 */         String logStr = String.format("[baitan]PReSellExpireItemReq.ProcessImp@resell item success|roleid=%d|itemid=%d|oldprice=%d|newprice=%d|oldchannelid=%d|shoppingid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(itemid), Integer.valueOf(oldprice), Integer.valueOf(desprice), Long.valueOf(oldchannelid), Long.valueOf(this.shoppingId) });
/*     */         
/*     */ 
/* 241 */         BaiTanManager.logger.info(logStr);
/* 242 */         BaiTanManager.tlogBaitan(this.roleId, itemid, totalnum, desprice, tax, 0, BaiTanOperateEnum.RESELL);
/* 243 */         BaiTanManager.tlogBaitanSellForIdip(this.roleId, itemid, totalnum, desprice, shoppingInfo.getItem().getUuidAsData(), this.shoppingId, lengthTime, BaiTanOperateEnum.RESELL.value);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 248 */     return true;
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
/*     */   private boolean moveShoppingidToEnd(long key, int oldprice, long oldchannelid)
/*     */   {
/* 261 */     Prices prices = xtable.Item2prices.get(Long.valueOf(key));
/* 262 */     if (prices == null)
/*     */     {
/* 264 */       String logStr = String.format("[baitan]PReSellExpireItemReq.moveShoppingidToEnd@move shopping id to last pos failed,xbean.Prices null|roleid=%d|itemid=%d|oldprice=%d|oldchannelid=%d|shoppingid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(oldprice), Long.valueOf(oldchannelid), Long.valueOf(this.shoppingId) });
/*     */       
/*     */ 
/* 267 */       BaiTanManager.logger.info(logStr);
/*     */       
/* 269 */       return false;
/*     */     }
/* 271 */     Channels channels = (Channels)prices.getPrice2channels().get(Integer.valueOf(oldprice));
/* 272 */     if ((channels == null) || (!channels.getChannels().contains(Long.valueOf(oldchannelid))))
/*     */     {
/* 274 */       String logStr = String.format("[baitan]PReSellExpireItemReq.moveShoppingidToEnd@move shopping id to last pos failed,xbean.Channels null or empty|roleid=%d|itemid=%d|oldprice=%d|oldchannelid=%d|shoppingid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(oldprice), Long.valueOf(oldchannelid), Long.valueOf(this.shoppingId) });
/*     */       
/*     */ 
/* 277 */       BaiTanManager.logger.info(logStr);
/* 278 */       return false;
/*     */     }
/* 280 */     ShoppingIds shoppingIds = xtable.Channel2shoppingid.get(Long.valueOf(oldchannelid));
/* 281 */     if ((shoppingIds == null) || (!shoppingIds.getShoppingids().contains(Long.valueOf(this.shoppingId))))
/*     */     {
/* 283 */       String logStr = String.format("[baitan]PReSellExpireItemReq.moveShoppingidToEnd@move shopping id to last pos failed, xbean.ShoppingIds null or empty|roleid=%d|itemid=%d|oldprice=%d|oldchannelid=%d|shoppingid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(oldprice), Long.valueOf(oldchannelid), Long.valueOf(this.shoppingId) });
/*     */       
/*     */ 
/* 286 */       BaiTanManager.logger.info(logStr);
/* 287 */       return false;
/*     */     }
/*     */     
/* 290 */     shoppingIds.getShoppingids().remove(Long.valueOf(this.shoppingId));
/* 291 */     shoppingIds.getShoppingids().add(Long.valueOf(this.shoppingId));
/* 292 */     return true;
/*     */   }
/*     */   
/*     */   private static class ReShangjia
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private long roleId;
/*     */     private int itemid;
/*     */     private int newprice;
/*     */     private long shoppingId;
/*     */     private long oldchannelid;
/*     */     private int oldprice;
/*     */     
/*     */     public ReShangjia(long roleid, int itemid, int newprice, long shoppingId, long oldchannelid, int oldprice)
/*     */     {
/* 307 */       this.roleId = roleid;
/* 308 */       this.itemid = itemid;
/* 309 */       this.newprice = newprice;
/* 310 */       this.shoppingId = shoppingId;
/* 311 */       this.oldchannelid = oldchannelid;
/* 312 */       this.oldprice = oldprice;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 319 */       Lockeys.lock(Role2grid.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 320 */       RoleGrid roleGrid = Role2grid.get(Long.valueOf(this.roleId));
/* 321 */       if ((roleGrid == null) || (!roleGrid.getShoppingid2channelid().containsKey(Long.valueOf(this.shoppingId))))
/*     */       {
/* 323 */         return false;
/*     */       }
/* 325 */       Channels xChannels = BaiTanManager.getChannelOnAdd(this.itemid, this.newprice);
/* 326 */       ChannelShopingIdBean cs = BaiTanManager.findChannelShoppingBean(xChannels);
/* 327 */       if (cs == null)
/*     */       {
/* 329 */         String logStr = String.format("[baitan]ReShangjia.processImp@find channelid and xbean.Shpoppingid error|roleid=%d|itemid=%d|newprice=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(this.newprice) });
/*     */         
/*     */ 
/* 332 */         BaiTanManager.logger.error(logStr);
/* 333 */         return false;
/*     */       }
/* 335 */       long channelid = cs.channelid;
/* 336 */       ShoppingIds shoppingIds = cs.xShoppingIds;
/*     */       
/* 338 */       ShoppingInfo shoppingInfo = Roleshoppinginfo.get(Long.valueOf(this.shoppingId));
/*     */       
/* 340 */       if (shoppingInfo == null)
/*     */       {
/* 342 */         String logStr = String.format("[baitan]ReShangjia.processImp@shoppingId error|roleid=%d|shoppingId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.shoppingId) });
/*     */         
/* 344 */         BaiTanManager.logger.error(logStr);
/*     */         
/* 346 */         return false;
/*     */       }
/*     */       
/* 349 */       int totalnum = shoppingInfo.getItem().getNumber();
/* 350 */       if (totalnum <= 0)
/*     */       {
/* 352 */         String logStr = String.format("[baitan]ReShangjia.processImp@rest item num less than 0|roleid=%d|itemid=%d|shoppingid=%d|restnum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Long.valueOf(this.shoppingId), Integer.valueOf(totalnum) });
/*     */         
/*     */ 
/* 355 */         BaiTanManager.logger.error(logStr);
/* 356 */         return false;
/*     */       }
/*     */       
/* 359 */       int tax = BaiTanManager.computeNeedTaxSillver(this.newprice, this.itemid, totalnum);
/* 360 */       if (tax <= 0)
/*     */       {
/* 362 */         String logStr = String.format("[baitan]ReShangjia.processImp@baitan resell item tax error|roleid=%d|itemid=%d|tax=%d|num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(tax), Integer.valueOf(totalnum) });
/*     */         
/*     */ 
/* 365 */         BaiTanManager.logger.error(logStr);
/* 366 */         return false;
/*     */       }
/*     */       
/* 369 */       if (!mzm.gsp.role.main.RoleInterface.cutSilver(this.roleId, tax, new TLogArg(mzm.gsp.tlog.LogReason.BAITAN_SHANGJIA_REM, this.itemid)))
/*     */       {
/* 371 */         BaiTanManager.sendCommonError(this.roleId, 4);
/*     */         
/* 373 */         return false;
/*     */       }
/*     */       
/* 376 */       int recommendPrice = BaiTanManager.getItemRecommendPrice(this.itemid);
/* 377 */       if (recommendPrice == -1)
/*     */       {
/* 379 */         String logStr = String.format("[baitan]ReShangjia.processImp@recommendPrice error|roleid=%d|itemid=%d|recommendPrice=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(recommendPrice) });
/*     */         
/*     */ 
/* 382 */         BaiTanManager.logger.error(logStr);
/* 383 */         return false;
/*     */       }
/* 385 */       boolean isLower = BaiTanManager.isLowerThanRecyclePrice(this.newprice, recommendPrice);
/* 386 */       boolean isNeedRecycle = false;
/* 387 */       long now = DateTimeUtils.getCurrTimeInMillis();
/* 388 */       long expireTime = 0L;
/* 389 */       long intervalMills = 0L;
/* 390 */       if (isLower)
/*     */       {
/* 392 */         intervalMills = BaiTanManager.computeRecycleInterval(this.newprice, recommendPrice);
/* 393 */         if (intervalMills < BaiTanManager.getBaitangItemInterval())
/*     */         {
/* 395 */           isNeedRecycle = true;
/* 396 */           expireTime = now + intervalMills;
/*     */         }
/*     */         else
/*     */         {
/* 400 */           isNeedRecycle = false;
/* 401 */           expireTime = now + BaiTanManager.getBaitangItemInterval();
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 406 */         isNeedRecycle = false;
/* 407 */         expireTime = now + BaiTanManager.getBaitangItemInterval();
/*     */       }
/*     */       
/* 410 */       shoppingInfo.setPrice(this.newprice);
/* 411 */       shoppingInfo.setExpire(expireTime);
/* 412 */       shoppingInfo.setTotalnum(totalnum);
/*     */       
/* 414 */       BaiTanManager.addItemGridnum(this.itemid);
/*     */       
/* 416 */       Shoppoingid2Sessionid shoppoingid2Sessionid = Role2shoppingsession.get(Long.valueOf(this.roleId));
/* 417 */       if (shoppoingid2Sessionid == null)
/*     */       {
/* 419 */         shoppoingid2Sessionid = xbean.Pod.newShoppoingid2Sessionid();
/* 420 */         Role2shoppingsession.insert(Long.valueOf(this.roleId), shoppoingid2Sessionid);
/*     */       }
/* 422 */       long lengthTime = TimeUnit.MILLISECONDS.toSeconds(BaiTanManager.getBaitangItemInterval());
/*     */       
/* 424 */       if (isNeedRecycle)
/*     */       {
/* 426 */         BaiTanManager.reStartRecycleObserver(shoppoingid2Sessionid, this.roleId, this.shoppingId, intervalMills);
/* 427 */         roleGrid.getNeedrecycleshoppingids().add(Long.valueOf(this.shoppingId));
/* 428 */         lengthTime = TimeUnit.MILLISECONDS.toSeconds(intervalMills);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 433 */         BaiTanManager.reStartObserver(shoppoingid2Sessionid, this.roleId, this.shoppingId, BaiTanManager.getBaitangItemInterval());
/* 434 */         lengthTime = TimeUnit.MILLISECONDS.toSeconds(BaiTanManager.getBaitangItemInterval());
/*     */       }
/*     */       
/*     */ 
/* 438 */       boolean ret = shoppingIds.getShoppingids().add(Long.valueOf(this.shoppingId));
/* 439 */       if (!ret)
/*     */       {
/*     */ 
/* 442 */         String logStr = String.format("[baitan]ReShangjia.ProcessImp@resell item failed|roleid=%d|itemid=%d|oldprice=%d|newprice=%d|oldchannelid=%d|newchannelid=%d|shoppingid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(this.oldprice), Integer.valueOf(this.newprice), Long.valueOf(this.oldchannelid), Long.valueOf(channelid), Long.valueOf(this.shoppingId) });
/*     */         
/*     */ 
/* 445 */         BaiTanManager.logger.error(logStr);
/* 446 */         return false;
/*     */       }
/* 448 */       BaiTanManager.addRoleShoppingChannel(this.roleId, this.shoppingId, channelid);
/* 449 */       String logStr = String.format("[baitan]ReShangjia.ProcessImp@resell item success|roleid=%d|itemid=%d|oldprice=%d|newprice=%d|oldchannelid=%d|newchannelid=%d|shoppingid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(this.oldprice), Integer.valueOf(this.newprice), Long.valueOf(this.oldchannelid), Long.valueOf(channelid), Long.valueOf(this.shoppingId) });
/*     */       
/*     */ 
/* 452 */       BaiTanManager.logger.info(logStr);
/*     */       
/* 454 */       SReSellExpireItemRes res = new SReSellExpireItemRes();
/* 455 */       res.shoppingid = this.shoppingId;
/* 456 */       res.price = this.newprice;
/* 457 */       OnlineManager.getInstance().send(this.roleId, res);
/* 458 */       BaiTanManager.tlogBaitan(this.roleId, this.itemid, totalnum, this.newprice, tax, 0, BaiTanOperateEnum.RESELL);
/* 459 */       BaiTanManager.tlogBaitanSellForIdip(this.roleId, this.itemid, totalnum, this.newprice, shoppingInfo.getItem().getUuidAsData(), this.shoppingId, lengthTime, BaiTanOperateEnum.RESELL.value);
/*     */       
/* 461 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\main\PReSellExpireItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */