/*     */ package mzm.gsp.market.auction;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.item.main.ItemBanTrade;
/*     */ import mzm.gsp.market.SPetAuctionRes;
/*     */ import mzm.gsp.market.main.MarketInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AuctionPetInfo;
/*     */ import xbean.ConcernRoleIdSet;
/*     */ import xbean.MarketPet;
/*     */ import xbean.Pet;
/*     */ import xbean.RoleAuctionInfo;
/*     */ import xbean.RoleMarketInfo;
/*     */ import xtable.Marketpetid2auction;
/*     */ 
/*     */ public class PPetAuction extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long marketId;
/*     */   private final int petCfgId;
/*     */   private final int price;
/*     */   
/*     */   public PPetAuction(long roleId, long marketId, int petCfgId, int price)
/*     */   {
/*  28 */     this.roleId = roleId;
/*  29 */     this.marketId = marketId;
/*  30 */     this.petCfgId = petCfgId;
/*  31 */     this.price = price;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*     */     {
/*  39 */       String logStr = String.format("[marketauction]PPetAuction.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  41 */       MarketInterface.getLogger().info(logStr);
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     if (ItemBanTrade.getInstance().isBanTrade(mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum.MARKET_PET.value, this.petCfgId))
/*     */     {
/*  47 */       ItemBanTrade.getInstance().sendTipToTole(this.roleId, mzm.gsp.pet.main.PetInterface.getPetName(this.petCfgId));
/*  48 */       return false;
/*     */     }
/*  50 */     String log = String.format("[marketauction]PPetAuction.processImp@receive auction pet req|roleid=%d|petCfgId=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId), Integer.valueOf(this.price) });
/*     */     
/*     */ 
/*  53 */     MarketInterface.getLogger().info(log);
/*     */     
/*  55 */     if ((this.price <= 0) || (this.petCfgId <= 0) || (this.marketId <= 0L))
/*     */     {
/*  57 */       log = String.format("[marketauction]PPetAuction.processImp@price error|roleid=%d|petCfgId=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId), Integer.valueOf(this.price) });
/*     */       
/*  59 */       MarketInterface.getLogger().warn(log);
/*     */       
/*  61 */       return false;
/*     */     }
/*  63 */     if (!MarketInterface.isMarketSwitchOpenForRole(this.roleId))
/*     */     {
/*  65 */       log = String.format("[marketauction]PPetAuction.processImp@market switch closed for role|roleid=%d|petCfgId=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId), Integer.valueOf(this.price) });
/*     */       
/*     */ 
/*  68 */       MarketInterface.getLogger().warn(log);
/*  69 */       return false;
/*     */     }
/*  71 */     if (!MarketInterface.isMarketAuctionSwitchOpenForRole(this.roleId))
/*     */     {
/*  73 */       log = String.format("[marketauction]PPetAuction.processImp@market auction switch closed for role|roleid=%d|petCfgId=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId), Integer.valueOf(this.price) });
/*     */       
/*     */ 
/*  76 */       MarketInterface.getLogger().warn(log);
/*  77 */       return false;
/*     */     }
/*  79 */     if (!MarketInterface.isMarketOpen(this.roleId))
/*     */     {
/*  81 */       log = String.format("[marketauction]PPetAuction.processImp@role level error|roleid=%d|petCfgId=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId), Integer.valueOf(this.price) });
/*     */       
/*     */ 
/*  84 */       MarketInterface.getLogger().warn(log);
/*  85 */       return false;
/*     */     }
/*  87 */     int subid = MarketInterface.getSubidByPetId(this.petCfgId);
/*  88 */     if (subid == -1)
/*     */     {
/*  90 */       MarketInterface.sendCommonError(this.roleId, 19);
/*  91 */       return false;
/*     */     }
/*  93 */     if (!MarketInterface.isRoleLevelRight(mzm.gsp.role.main.RoleInterface.getLevel(this.roleId), subid))
/*     */     {
/*  95 */       log = String.format("[marketauction]PPetAuction.processImp@role level can not see this pet|roleid=%d|petCfgId=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId), Integer.valueOf(this.price) });
/*     */       
/*     */ 
/*  98 */       MarketInterface.getLogger().warn(log);
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     RoleAuctionInfo xRoleAuctionInfo = xtable.Role2auctioninfo.get(Long.valueOf(this.roleId));
/* 103 */     if (xRoleAuctionInfo == null)
/*     */     {
/* 105 */       xRoleAuctionInfo = xbean.Pod.newRoleAuctionInfo();
/* 106 */       xtable.Role2auctioninfo.insert(Long.valueOf(this.roleId), xRoleAuctionInfo);
/*     */     }
/*     */     
/* 109 */     MarketPet xMarketPet = xtable.Marketpet.get(Long.valueOf(this.marketId));
/* 110 */     if (xMarketPet == null)
/*     */     {
/* 112 */       MarketInterface.sendCommonError(this.roleId, 8);
/* 113 */       return false;
/*     */     }
/* 115 */     long sellerRoleid = xMarketPet.getRoleid();
/* 116 */     if (sellerRoleid == this.roleId)
/*     */     {
/* 118 */       log = String.format("[marketauction]PPetAuction.processImp@roleid error, self|roleid=%d|petCfgId=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId), Integer.valueOf(this.price) });
/*     */       
/*     */ 
/* 121 */       MarketInterface.getLogger().warn(log);
/* 122 */       return false;
/*     */     }
/* 124 */     int maxPrice = MarketInterface.getMaxPetPrice(xMarketPet.getPet());
/* 125 */     if (maxPrice <= 0)
/*     */     {
/* 127 */       log = String.format("[marketauction]PPetAuction.processImp@maxPrice is below zero|roleid=%d|petCfgId=%d|marketId=%d|price=%d|state=%d|maxprice=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId), Integer.valueOf(this.price), Integer.valueOf(xMarketPet.getState()), Integer.valueOf(maxPrice) });
/*     */       
/*     */ 
/* 130 */       MarketInterface.getLogger().warn(log);
/* 131 */       return false;
/*     */     }
/* 133 */     if (xMarketPet.getPrice() >= maxPrice)
/*     */     {
/* 135 */       log = String.format("[marketauction]PPetAuction.processImp@pet price is already to max price|roleid=%d|petCfgId=%d|marketId=%d|price=%d|state=%d|maxprice=%d|currentprice=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId), Integer.valueOf(this.price), Integer.valueOf(xMarketPet.getState()), Integer.valueOf(maxPrice), Integer.valueOf(xMarketPet.getPrice()) });
/*     */       
/*     */ 
/* 138 */       MarketInterface.getLogger().warn(log);
/* 139 */       MarketAuctionManager.sendSPetMaxPriceRes(this.roleId, this.marketId, this.petCfgId, maxPrice);
/* 140 */       return false;
/*     */     }
/* 142 */     if (this.price > maxPrice)
/*     */     {
/* 144 */       log = String.format("[marketauction]PPetAuction.processImp@price is over than max price|roleid=%d|petCfgId=%d|marketId=%d|price=%d|state=%d|maxprice=%d|currentprice=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId), Integer.valueOf(this.price), Integer.valueOf(xMarketPet.getState()), Integer.valueOf(maxPrice), Integer.valueOf(xMarketPet.getPrice()) });
/*     */       
/*     */ 
/* 147 */       MarketInterface.getLogger().warn(log);
/* 148 */       MarketAuctionManager.sendSPetMaxPriceRes(this.roleId, this.marketId, this.petCfgId, maxPrice);
/* 149 */       return false;
/*     */     }
/* 151 */     if (!MarketAuctionManager.canAuction(xMarketPet.getState()))
/*     */     {
/* 153 */       log = String.format("[marketauction]PPetAuction.processImp@pet state can not auction|roleid=%d|petCfgId=%d|marketId=%d|price=%d|state=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId), Integer.valueOf(this.price), Integer.valueOf(xMarketPet.getState()) });
/*     */       
/*     */ 
/* 156 */       MarketInterface.getLogger().warn(log);
/* 157 */       return false;
/*     */     }
/* 159 */     if (xMarketPet.getPet().getTemplateid() != this.petCfgId)
/*     */     {
/* 161 */       log = String.format("[marketauction]PPetAuction.processImp@petCfgId error|roleid=%d|petCfgId=%d|serverPetCfgId=%d|marketId=%d|price=%d|state=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Integer.valueOf(xMarketPet.getPet().getTemplateid()), Long.valueOf(this.marketId), Integer.valueOf(this.price), Integer.valueOf(xMarketPet.getState()) });
/*     */       
/*     */ 
/* 164 */       MarketInterface.getLogger().warn(log);
/* 165 */       return false;
/*     */     }
/*     */     
/* 168 */     if (!MarketAuctionManager.isPetAuctionPriceRight(this.price, xMarketPet.getPrice(), maxPrice))
/*     */     {
/* 170 */       log = String.format("[marketauction]PPetAuction.processImp@pet auction price error|roleid=%d|petCfgId=%d|marketId=%d|price=%d|state=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId), Integer.valueOf(this.price), Integer.valueOf(xMarketPet.getState()) });
/*     */       
/*     */ 
/* 173 */       MarketInterface.getLogger().warn(log);
/* 174 */       MarketInterface.sendCommonError(this.roleId, 24);
/* 175 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 179 */     RoleMarketInfo xRoleMarketInfo = xtable.Role2marketinfo.get(Long.valueOf(this.roleId));
/* 180 */     if ((xRoleMarketInfo != null) && (xRoleMarketInfo.getConcern_pet_ids().contains(Long.valueOf(this.marketId))))
/*     */     {
/* 182 */       xRoleMarketInfo.getConcern_pet_ids().remove(Long.valueOf(this.marketId));
/*     */       
/* 184 */       xMarketPet.setConcern_role_num(Math.max(0, xMarketPet.getConcern_role_num() - 1));
/*     */       
/* 186 */       ConcernRoleIdSet xConcernRoleIdSet = xtable.Marketpetid2concernrole.get(Long.valueOf(this.marketId));
/* 187 */       if (xConcernRoleIdSet != null)
/*     */       {
/* 189 */         xConcernRoleIdSet.getRoleids().remove(Long.valueOf(this.roleId));
/*     */       }
/*     */     }
/*     */     
/* 193 */     int oldPrice = xMarketPet.getPrice();
/*     */     
/* 195 */     xMarketPet.setPrice(this.price);
/* 196 */     xMarketPet.setState(xMarketPet.getState() | 0x10);
/*     */     
/* 198 */     AuctionPetInfo xAuctionInfo = Marketpetid2auction.get(Long.valueOf(this.marketId));
/* 199 */     if (xAuctionInfo == null)
/*     */     {
/* 201 */       xAuctionInfo = xbean.Pod.newAuctionPetInfo();
/* 202 */       Marketpetid2auction.insert(Long.valueOf(this.marketId), xAuctionInfo);
/*     */     }
/* 204 */     long oldRoleId = xAuctionInfo.getAuctionroleid();
/* 205 */     if (oldRoleId == this.roleId)
/*     */     {
/* 207 */       log = String.format("[marketauction]PPetAuction.processImp@auction role error,already the max price role|roleid=%d|petCfgId=%d|marketId=%d|price=%d|state=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId), Integer.valueOf(this.price), Integer.valueOf(xMarketPet.getState()) });
/*     */       
/*     */ 
/* 210 */       MarketInterface.getLogger().warn(log);
/* 211 */       return false;
/*     */     }
/* 213 */     xAuctionInfo.setAuctionroleid(this.roleId);
/* 214 */     xAuctionInfo.setAuctioncount(xAuctionInfo.getAuctioncount() + 1);
/* 215 */     xAuctionInfo.setAuctionprice(this.price);
/* 216 */     xAuctionInfo.setPetcfgid(xMarketPet.getPet().getTemplateid());
/* 217 */     xAuctionInfo.getAuctionroleset().add(Long.valueOf(this.roleId));
/*     */     
/* 219 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 220 */     if (xAuctionInfo.getAuctioncount() == 1)
/*     */     {
/* 222 */       xAuctionInfo.setEndtime(TimeUnit.SECONDS.toMillis(MarketInterface.computePublicEndtime(xMarketPet.getOnshelf_time())));
/*     */     }
/*     */     else
/*     */     {
/* 226 */       long endTime = MarketAuctionManager.computeNewAuctionEndTime(xAuctionInfo.getEndtime(), xMarketPet.getOnshelf_time(), now);
/*     */       
/* 228 */       xAuctionInfo.setEndtime(endTime);
/*     */     }
/* 230 */     if (!xRoleAuctionInfo.getAuction_pet_ids().contains(Long.valueOf(this.marketId)))
/*     */     {
/* 232 */       xRoleAuctionInfo.getAuction_pet_ids().add(Long.valueOf(this.marketId));
/*     */     }
/*     */     
/* 235 */     TLogArg logArg = new TLogArg(mzm.gsp.tlog.LogReason.MARKET_AUCTION, this.petCfgId);
/* 236 */     if (!mzm.gsp.role.main.RoleInterface.cutGoldIngot(this.roleId, this.price, logArg))
/*     */     {
/* 238 */       return false;
/*     */     }
/*     */     
/* 241 */     MarketAuctionManager.startAuctionPetSession(this.marketId, xAuctionInfo, now);
/*     */     
/* 243 */     SPetAuctionRes res = new SPetAuctionRes();
/* 244 */     res.marketid = this.marketId;
/* 245 */     res.petcfgid = this.petCfgId;
/* 246 */     res.price = this.price;
/* 247 */     res.endtime = TimeUnit.MILLISECONDS.toSeconds(xAuctionInfo.getEndtime());
/* 248 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 250 */     String logStr = String.format("[marketauction]PPetAuction.processImp@auction pet success|roleid=%d|petCfgId=%d|marketId=%d|price=%d|endTime=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId), Integer.valueOf(this.price), Long.valueOf(res.endtime) });
/*     */     
/*     */ 
/* 253 */     MarketInterface.getLogger().info(logStr);
/*     */     
/* 255 */     if (oldRoleId != 0L)
/*     */     {
/* 257 */       MarketAuctionManager.sendAuctionPriceBePassedMail(oldRoleId, oldPrice, this.marketId, this.petCfgId, xMarketPet.getPet().getPetname(), this.price, 1);
/*     */     }
/*     */     
/*     */ 
/* 261 */     if (MarketInterface.isLevelSift(subid))
/*     */     {
/* 263 */       int level = xMarketPet.getPet().getLevel();
/* 264 */       MarketInterface.deleteFromPubLevelSiftRank(subid, this.marketId, level);
/* 265 */       MarketInterface.rankIntoPubLevelSiftRank(subid, this.marketId, level, this.price);
/*     */     }
/*     */     else
/*     */     {
/* 269 */       MarketInterface.deleteFromPubPriceRank(subid, this.marketId);
/* 270 */       MarketInterface.rankIntoPubPriceRank(subid, this.marketId, this.price);
/*     */     }
/*     */     
/* 273 */     if (!MarketInterface.isSysRoleid(sellerRoleid))
/*     */     {
/* 275 */       MarketAuctionManager.sendSSynPetPriceRes(sellerRoleid, this.marketId, xMarketPet, xAuctionInfo);
/*     */     }
/*     */     
/* 278 */     MarketAuctionManager.tlogMarketauction(this.roleId, subid, this.petCfgId, this.price, oldRoleId, oldPrice, this.marketId, xMarketPet.getPet().getId(), sellerRoleid);
/*     */     
/* 280 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\auction\PPetAuction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */