/*     */ package mzm.gsp.market.auction;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.market.SPetAuctionBePassedRes;
/*     */ import mzm.gsp.market.SPetAuctionSuccessRes;
/*     */ import mzm.gsp.market.SSynItemPriceRes;
/*     */ import mzm.gsp.market.SSynPetPriceRes;
/*     */ import mzm.gsp.market.confbean.SMarketConsts;
/*     */ import mzm.gsp.market.main.MarketInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.AuctionItemInfo;
/*     */ import xbean.AuctionPetInfo;
/*     */ import xbean.MarketPet;
/*     */ import xbean.RoleAuctionInfo;
/*     */ import xtable.Marketitem2sessionid;
/*     */ import xtable.Marketpet2sessionid;
/*     */ import xtable.Role2auctioninfo;
/*     */ 
/*     */ public class MarketAuctionManager
/*     */ {
/*     */   private static final float WAN = 10000.0F;
/*     */   
/*     */   static boolean isItemAuctionPriceRight(int auctionPrice, int currentPrice, int maxprice)
/*     */   {
/*  38 */     return checkPrice(auctionPrice, currentPrice, maxprice);
/*     */   }
/*     */   
/*     */   static boolean isPetAuctionPriceRight(int auctionPrice, int currentPrice, int maxprice)
/*     */   {
/*  43 */     return checkPrice(auctionPrice, currentPrice, maxprice);
/*     */   }
/*     */   
/*     */   private static boolean checkPrice(int auctionPrice, int currentPrice, int maxprice)
/*     */   {
/*  48 */     if (auctionPrice <= currentPrice)
/*     */     {
/*  50 */       return false;
/*     */     }
/*  52 */     if (currentPrice >= maxprice)
/*     */     {
/*  54 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  58 */     if (auctionPrice == maxprice)
/*     */     {
/*  60 */       return true;
/*     */     }
/*     */     
/*     */ 
/*  64 */     if (auctionPrice < currentPrice * (1.0F + SMarketConsts.getInstance().AUCTION_ADD_PRICE_RATE / 10000.0F))
/*     */     {
/*  66 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  70 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isAuctuonNumRight(RoleAuctionInfo xRoleAuctionInfo)
/*     */   {
/*  79 */     if (xRoleAuctionInfo.getAuction_pet_ids().size() + xRoleAuctionInfo.getAuction_item_ids().size() >= SMarketConsts.getInstance().MAX_AUCTION_NUM)
/*     */     {
/*  81 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  85 */     return true;
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
/*     */   static long computeNewAuctionEndTime(long currentEndTime, long onShelfTime, long now)
/*     */   {
/* 100 */     long endTime = currentEndTime + TimeUnit.MINUTES.toMillis(SMarketConsts.getInstance().AUCTION_ADD_PUBLIC_TIME);
/*     */     
/* 102 */     long lengthTime = endTime - now;
/* 103 */     long maxAuctionTime = TimeUnit.HOURS.toMillis(SMarketConsts.getInstance().MAX_AUCTION_PUBLIC_TIME);
/* 104 */     if (lengthTime >= maxAuctionTime)
/*     */     {
/* 106 */       endTime -= lengthTime - maxAuctionTime;
/*     */     }
/* 108 */     long forbiddenStartTime = DateTimeUtils.getTimeInToday(endTime, SMarketConsts.getInstance().FORBIDDEN_ON_SHELF_START_HOUR, 0, 0);
/*     */     
/* 110 */     long forbiddenEndTime = DateTimeUtils.getTimeInToday(endTime, SMarketConsts.getInstance().FORBIDDEN_ON_SHELF_END_HOUR, 0, 0);
/*     */     
/* 112 */     if ((forbiddenStartTime <= endTime) && (endTime < forbiddenEndTime))
/*     */     {
/* 114 */       endTime = forbiddenEndTime;
/*     */     }
/* 116 */     return endTime;
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
/*     */   static void sendAuctionPriceBePassedMail(long roleId, int auctionPrice, long marketId, int itemIdOrpetCfgId, String name, int currentAuctionPrice, int num)
/*     */   {
/* 131 */     TLogArg logArg = new TLogArg(LogReason.MARKET_AUCTION_PRICE_BE_PASSED, itemIdOrpetCfgId);
/* 132 */     List<String> contentArgs = new ArrayList();
/* 133 */     contentArgs.add(name);
/*     */     
/*     */ 
/*     */ 
/* 137 */     MailAttachment mailAttachment = MailInterface.createMailAttachment();
/* 138 */     mailAttachment.setGoldIngot(auctionPrice * num);
/*     */     
/* 140 */     MailInterface.asynBuildAndSendMail(roleId, SMarketConsts.getInstance().AUCTION_BE_PASSED_MAIL_ID, null, contentArgs, mailAttachment, logArg);
/*     */     
/*     */ 
/* 143 */     if (ItemInterface.isItemExist(itemIdOrpetCfgId))
/*     */     {
/* 145 */       mzm.gsp.market.SItemAuctionBePassedRes res = new mzm.gsp.market.SItemAuctionBePassedRes();
/* 146 */       res.marketid = marketId;
/* 147 */       res.myprice = auctionPrice;
/* 148 */       res.newprice = currentAuctionPrice;
/* 149 */       res.itemid = itemIdOrpetCfgId;
/*     */       
/* 151 */       OnlineManager.getInstance().send(roleId, res);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 156 */       SPetAuctionBePassedRes res = new SPetAuctionBePassedRes();
/* 157 */       res.marketid = marketId;
/* 158 */       res.myprice = auctionPrice;
/* 159 */       res.newprice = currentAuctionPrice;
/* 160 */       res.petcfgid = itemIdOrpetCfgId;
/*     */       
/* 162 */       OnlineManager.getInstance().send(roleId, res);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendAuctionPublicEndTipMail(long sellerRoleid, long buyerRoleid, List<Long> concernRoles, long marketId, int itemIdOrpetCfgId, String name, int auctionCount, int price)
/*     */   {
/* 179 */     TLogArg logArg = new TLogArg(LogReason.MARKET_AUCTION_PUBLIC_END_TIP_MAIL, itemIdOrpetCfgId);
/* 180 */     List<String> contentArgs = new ArrayList();
/* 181 */     contentArgs.add(name);
/* 182 */     contentArgs.add(String.valueOf(auctionCount));
/* 183 */     contentArgs.add(String.valueOf(price));
/*     */     
/* 185 */     MailInterface.asynBuildAndSendMail(sellerRoleid, SMarketConsts.getInstance().SELLER_AUCTION_PUBLIC_END_TIP_MAIL_ID, null, contentArgs, null, logArg);
/*     */     
/* 187 */     MailInterface.asynBuildAndSendMail(buyerRoleid, SMarketConsts.getInstance().BUYER_AUCTION_PUBLIC_END_TIP_MAIL_ID, null, contentArgs, null, logArg);
/*     */     
/*     */     Iterator i$;
/* 190 */     if (concernRoles != null)
/*     */     {
/* 192 */       for (i$ = concernRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/* 194 */         MailInterface.asynBuildAndSendMail(roleid, SMarketConsts.getInstance().CONCERN_AUCTION_PUBLIC_END_TIP_MAIL_ID, null, contentArgs, null, logArg);
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendAuctionSuccessMail(long roleid, long marketId, int itemIdOrpetCfgId, String name, int price)
/*     */   {
/* 212 */     TLogArg logArg = new TLogArg(LogReason.MARKET_AUCTION_SUCCESS_MAIL, itemIdOrpetCfgId);
/* 213 */     List<String> contentArgs = new ArrayList();
/* 214 */     contentArgs.add(name);
/*     */     
/*     */ 
/*     */ 
/* 218 */     if (ItemInterface.isItemExist(itemIdOrpetCfgId))
/*     */     {
/* 220 */       mzm.gsp.market.SItemAuctionSuccessRes res = new mzm.gsp.market.SItemAuctionSuccessRes();
/* 221 */       res.marketid = marketId;
/* 222 */       res.itemid = itemIdOrpetCfgId;
/* 223 */       OnlineManager.getInstance().send(roleid, res);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 228 */       SPetAuctionSuccessRes res = new SPetAuctionSuccessRes();
/* 229 */       res.marketid = marketId;
/* 230 */       res.petcfgid = itemIdOrpetCfgId;
/*     */       
/* 232 */       OnlineManager.getInstance().send(roleid, res);
/*     */     }
/*     */     
/* 235 */     MailInterface.asynBuildAndSendMail(roleid, SMarketConsts.getInstance().AUCTION_SUCCESS_MAIL_ID, null, contentArgs, null, logArg);
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
/*     */   static void tlogMarketauction(long roleid, int subid, int itemIdOrPetCfgId, int newPrice, long oldRoleId, int oldPrice, long marketId, long uuid, long ownerRoleid)
/*     */   {
/* 256 */     String logName = "Marketauction";
/* 257 */     String vGameIP = mzm.gsp.GameServerInfoManager.getHostIP();
/* 258 */     String userid = RoleInterface.getUserId(roleid);
/* 259 */     int rolelevel = RoleInterface.getLevel(roleid);
/*     */     
/* 261 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(subid), Integer.valueOf(itemIdOrPetCfgId), Integer.valueOf(newPrice), Long.valueOf(oldRoleId), Integer.valueOf(oldPrice), Long.valueOf(marketId), Long.valueOf(uuid), Long.valueOf(ownerRoleid) });
/*     */     
/* 263 */     TLogManager.getInstance().addLog(roleid, logName, logStr);
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
/*     */   static void tlogMarketAuctionSuccess(long roleid, int subid, int itemIdOrPetCfgId, int newPrice, long marketId, long uuid, long ownerRoleid)
/*     */   {
/* 281 */     String logName = "Marketauctionsuccess";
/* 282 */     String vGameIP = mzm.gsp.GameServerInfoManager.getHostIP();
/* 283 */     String userid = RoleInterface.getUserId(roleid);
/* 284 */     int rolelevel = RoleInterface.getLevel(roleid);
/*     */     
/* 286 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(subid), Integer.valueOf(itemIdOrPetCfgId), Integer.valueOf(newPrice), Long.valueOf(marketId), Long.valueOf(uuid), Long.valueOf(ownerRoleid) });
/*     */     
/* 288 */     TLogManager.getInstance().addLog(roleid, logName, logStr);
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
/*     */   public static void removeMarketItemAuction(long marketId, boolean isSendMailToMaxPriceRole, boolean isRemoveMaxRoleId, boolean isRemoveAuctionInfo)
/*     */   {
/* 305 */     AuctionItemInfo xAuctionItemInfo = xtable.Marketitemid2auction.get(Long.valueOf(marketId));
/* 306 */     if (xAuctionItemInfo == null)
/*     */     {
/* 308 */       return;
/*     */     }
/* 310 */     for (Iterator i$ = xAuctionItemInfo.getAuctionroleset().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/* 312 */       if ((isRemoveMaxRoleId) || (roleid != xAuctionItemInfo.getAuctionroleid()))
/*     */       {
/*     */ 
/*     */ 
/* 316 */         new RemoveRoleAuctionItemPro(roleid, marketId).execute(); }
/*     */     }
/* 318 */     if (isSendMailToMaxPriceRole)
/*     */     {
/* 320 */       long roleid = xAuctionItemInfo.getAuctionroleid();
/* 321 */       sendAuctionItemOrPetOffShelfMail(roleid, marketId, xAuctionItemInfo.getItemid(), ItemInterface.getItemName(xAuctionItemInfo.getItemid()), xAuctionItemInfo.getAuctionprice(), xAuctionItemInfo.getItemnum());
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 326 */     if (isRemoveAuctionInfo)
/*     */     {
/* 328 */       xtable.Marketitemid2auction.remove(Long.valueOf(marketId));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class RemoveRoleAuctionItemPro
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final long marketId;
/*     */     
/*     */     public RemoveRoleAuctionItemPro(long roleId, long marketId)
/*     */     {
/* 341 */       this.roleId = roleId;
/* 342 */       this.marketId = marketId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 348 */       RoleAuctionInfo xRoleAuctionInfo = Role2auctioninfo.get(Long.valueOf(this.roleId));
/* 349 */       if (xRoleAuctionInfo == null)
/*     */       {
/* 351 */         return false;
/*     */       }
/* 353 */       xRoleAuctionInfo.getAuction_item_ids().remove(Long.valueOf(this.marketId));
/* 354 */       return true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void removeMarketPetAuction(long marketId, boolean isSendMailToMaxPriceRole, boolean isRemoveMaxRoleId, boolean isRemoveAuctionInfo)
/*     */   {
/* 373 */     AuctionPetInfo xAuctionPetInfo = xtable.Marketpetid2auction.get(Long.valueOf(marketId));
/* 374 */     if (xAuctionPetInfo == null)
/*     */     {
/* 376 */       return;
/*     */     }
/* 378 */     for (Iterator i$ = xAuctionPetInfo.getAuctionroleset().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/* 380 */       if ((isRemoveMaxRoleId) || (roleid != xAuctionPetInfo.getAuctionroleid()))
/*     */       {
/*     */ 
/*     */ 
/* 384 */         new RemoveRoleAuctionPetPro(roleid, marketId).execute(); }
/*     */     }
/* 386 */     if (isSendMailToMaxPriceRole)
/*     */     {
/* 388 */       long roleid = xAuctionPetInfo.getAuctionroleid();
/* 389 */       sendAuctionItemOrPetOffShelfMail(roleid, marketId, xAuctionPetInfo.getPetcfgid(), mzm.gsp.pet.main.PetInterface.getPetName(xAuctionPetInfo.getPetcfgid()), xAuctionPetInfo.getAuctionprice(), 1);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 394 */     if (isRemoveAuctionInfo)
/*     */     {
/* 396 */       xtable.Marketpetid2auction.remove(Long.valueOf(marketId));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class RemoveRoleAuctionPetPro
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final long marketId;
/*     */     
/*     */     public RemoveRoleAuctionPetPro(long roleId, long marketId)
/*     */     {
/* 409 */       this.roleId = roleId;
/* 410 */       this.marketId = marketId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 416 */       RoleAuctionInfo xRoleAuctionInfo = Role2auctioninfo.get(Long.valueOf(this.roleId));
/* 417 */       if (xRoleAuctionInfo == null)
/*     */       {
/* 419 */         return false;
/*     */       }
/* 421 */       xRoleAuctionInfo.getAuction_pet_ids().remove(Long.valueOf(this.marketId));
/* 422 */       return true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void sendAuctionItemOrPetOffShelfMail(long roleid, long marketId, int itemIdOrpetCfgId, String name, int price, int num)
/*     */   {
/* 439 */     TLogArg logArg = new TLogArg(LogReason.MARKET_AUCTION_OFFSHELF_MAIL, itemIdOrpetCfgId);
/* 440 */     List<String> contentArgs = new ArrayList();
/* 441 */     contentArgs.add(name);
/*     */     
/*     */ 
/* 444 */     MailAttachment mailAttachment = MailInterface.createMailAttachment();
/* 445 */     mailAttachment.setGoldIngot(price * num);
/* 446 */     MailInterface.asynBuildAndSendMail(roleid, SMarketConsts.getInstance().AUCTION_OFF_SHELF_MAIL_ID, null, contentArgs, mailAttachment, logArg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static boolean canAuction(int state)
/*     */   {
/* 453 */     if ((!MarketInterface.hasState(state, 16)) && (!MarketInterface.hasState(state, 1)))
/*     */     {
/*     */ 
/* 456 */       return false;
/*     */     }
/* 458 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void startAuctionPetSession(long marketId, AuctionPetInfo xAuctionInfo, long now)
/*     */   {
/* 469 */     Long sessionId = Marketpet2sessionid.get(Long.valueOf(marketId));
/* 470 */     if (sessionId != null)
/*     */     {
/* 472 */       Session.removeSession(sessionId.longValue());
/*     */     }
/*     */     
/* 475 */     Marketpet2sessionid.remove(Long.valueOf(marketId));
/*     */     
/* 477 */     long endTime = xAuctionInfo.getEndtime();
/*     */     
/* 479 */     long interval = TimeUnit.MILLISECONDS.toSeconds(endTime - now);
/*     */     
/* 481 */     Session session = null;
/* 482 */     if ((xAuctionInfo.getIssendtip()) || (interval <= TimeUnit.MINUTES.toSeconds(SMarketConsts.getInstance().TIME_BEFORE_END_AUCTION_SEND_TIP_MAIL)))
/*     */     {
/*     */ 
/*     */ 
/* 486 */       if (interval <= 0L)
/*     */       {
/* 488 */         interval = 1L;
/*     */       }
/* 490 */       session = new AuctionPetEndSession(interval, marketId);
/*     */     }
/*     */     else
/*     */     {
/* 494 */       long inter = TimeUnit.MILLISECONDS.toSeconds(endTime - now - TimeUnit.MINUTES.toMillis(SMarketConsts.getInstance().TIME_BEFORE_END_AUCTION_SEND_TIP_MAIL));
/*     */       
/*     */ 
/* 497 */       if (inter <= 0L)
/*     */       {
/* 499 */         inter = 1L;
/*     */       }
/* 501 */       session = new AuctiontPetTipSession(inter, marketId);
/*     */     }
/*     */     
/* 504 */     Marketpet2sessionid.insert(Long.valueOf(marketId), Long.valueOf(session.getSessionId()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void startAuctionItemSession(long marketId, AuctionItemInfo xAuctionInfo, long now)
/*     */   {
/* 515 */     Long sessionId = Marketitem2sessionid.get(Long.valueOf(marketId));
/* 516 */     if (sessionId != null)
/*     */     {
/* 518 */       Session.removeSession(sessionId.longValue());
/*     */     }
/*     */     
/* 521 */     Marketitem2sessionid.remove(Long.valueOf(marketId));
/*     */     
/* 523 */     long endTime = xAuctionInfo.getEndtime();
/*     */     
/* 525 */     long interval = TimeUnit.MILLISECONDS.toSeconds(endTime - now);
/*     */     
/* 527 */     Session session = null;
/* 528 */     if ((xAuctionInfo.getIssendtip()) || (interval <= TimeUnit.MINUTES.toSeconds(SMarketConsts.getInstance().TIME_BEFORE_END_AUCTION_SEND_TIP_MAIL)))
/*     */     {
/*     */ 
/*     */ 
/* 532 */       if (interval <= 0L)
/*     */       {
/* 534 */         interval = 1L;
/*     */       }
/* 536 */       session = new AuctionItemEndSession(interval, marketId);
/*     */     }
/*     */     else
/*     */     {
/* 540 */       long inter = TimeUnit.MILLISECONDS.toSeconds(endTime - now - TimeUnit.MINUTES.toMillis(SMarketConsts.getInstance().TIME_BEFORE_END_AUCTION_SEND_TIP_MAIL));
/*     */       
/*     */ 
/* 543 */       if (inter <= 0L)
/*     */       {
/* 545 */         inter = 1L;
/*     */       }
/* 547 */       session = new AuctiontItemTipSession(inter, marketId);
/*     */     }
/*     */     
/* 550 */     Marketitem2sessionid.insert(Long.valueOf(marketId), Long.valueOf(session.getSessionId()));
/*     */   }
/*     */   
/*     */ 
/*     */   static void sendSPetMaxPriceRes(long roleid, long marketId, int petCfgId, int maxprice)
/*     */   {
/* 556 */     mzm.gsp.market.SPetMaxPriceRes res = new mzm.gsp.market.SPetMaxPriceRes();
/* 557 */     res.marketid = marketId;
/* 558 */     res.petcfgid = petCfgId;
/* 559 */     res.maxprice = maxprice;
/* 560 */     OnlineManager.getInstance().sendAtOnce(roleid, res);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void sendSSynItemPriceRes(long sellerRoleid, long marketId, xbean.MarketItem xMarketItem, AuctionItemInfo xAuctionItemInfo)
/*     */   {
/* 567 */     SSynItemPriceRes res = new SSynItemPriceRes();
/* 568 */     MarketInterface.fillProtocolMarketItem(res.marketitem, marketId, xMarketItem, xAuctionItemInfo);
/* 569 */     OnlineManager.getInstance().send(sellerRoleid, res);
/*     */   }
/*     */   
/*     */ 
/*     */   static void sendSSynPetPriceRes(long sellerRoleid, long marketId, MarketPet xMarketPet, AuctionPetInfo xAuctionPetInfo)
/*     */   {
/* 575 */     SSynPetPriceRes res = new SSynPetPriceRes();
/* 576 */     MarketInterface.fillProtocolMarketPet(res.marketpet, marketId, xMarketPet, xAuctionPetInfo);
/* 577 */     OnlineManager.getInstance().send(sellerRoleid, res);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\auction\MarketAuctionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */