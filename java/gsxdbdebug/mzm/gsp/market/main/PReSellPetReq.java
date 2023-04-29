/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.item.main.ItemBanTrade;
/*     */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*     */ import mzm.gsp.market.confbean.SMarketConsts;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MarketIds;
/*     */ import xbean.MarketPet;
/*     */ import xbean.Pet;
/*     */ import xbean.RoleMarketInfo;
/*     */ import xtable.Marketpet2sessionid;
/*     */ 
/*     */ public class PReSellPetReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private long marketId;
/*     */   private int price;
/*     */   
/*     */   public PReSellPetReq(long roleId, long marketId, int price)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.marketId = marketId;
/*  33 */     this.price = price;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     String log = String.format("[market]PReSellPetReq.processImp@receive resell pet req|roleid=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.marketId), Integer.valueOf(this.price) });
/*     */     
/*  43 */     MarketManager.logger.info(log);
/*     */     
/*  45 */     if (this.price <= 0)
/*     */     {
/*  47 */       return false;
/*     */     }
/*  49 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*     */     {
/*  51 */       String logStr = String.format("[market]PReSellPetReq.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  53 */       MarketManager.logger.info(logStr);
/*  54 */       return false;
/*     */     }
/*  56 */     if (!MarketManager.isMarketSwitchOpenForRole(this.roleId))
/*     */     {
/*  58 */       return false;
/*     */     }
/*  60 */     if (!MarketManager.isMarketOpen(this.roleId))
/*     */     {
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     RoleMarketInfo xRoleMarketInfo = xtable.Role2marketinfo.get(Long.valueOf(this.roleId));
/*  66 */     if (xRoleMarketInfo == null)
/*     */     {
/*  68 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  72 */     if (!xRoleMarketInfo.getOnshelf_pet_ids().contains(Long.valueOf(this.marketId)))
/*     */     {
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     MarketPet xMarketPet = (MarketPet)xRoleMarketInfo.getMarketid2timeoutorselledpet().get(Long.valueOf(this.marketId));
/*  78 */     if (xMarketPet == null)
/*     */     {
/*  80 */       return false;
/*     */     }
/*  82 */     if (xMarketPet.getRoleid() != this.roleId)
/*     */     {
/*  84 */       return false;
/*     */     }
/*  86 */     long key = mzm.gsp.GameServerInfoManager.toGlobalId(xMarketPet.getPet().getTemplateid());
/*  87 */     xdb.Lockeys.lock(xtable.Pet2marketchannelids.getTable(), Arrays.asList(new Long[] { Long.valueOf(key) }));
/*     */     
/*  89 */     int oldPrice = xMarketPet.getPrice();
/*  90 */     int petCfgId = xMarketPet.getPet().getTemplateid();
/*  91 */     int subid = MarketManager.getSubidByPetId(petCfgId);
/*  92 */     if (subid == -1)
/*     */     {
/*  94 */       MarketManager.sendCommonError(this.roleId, 8);
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     if (!MarketManager.hasState(xMarketPet.getState(), 8))
/*     */     {
/* 100 */       String logStr = String.format("[market]PReSellPetReq.processImp@market pet is not expired|roleid=%d|marketId=%d|petCfgId=%d|price=%d|state=%d|reSellPrice", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.marketId), Integer.valueOf(petCfgId), Integer.valueOf(oldPrice), Integer.valueOf(xMarketPet.getState()), Integer.valueOf(this.price) });
/*     */       
/*     */ 
/* 103 */       MarketManager.logger.error(logStr);
/* 104 */       return false;
/*     */     }
/* 106 */     if (!MarketManager.canSellPet(petCfgId))
/*     */     {
/* 108 */       String logStr = String.format("[market]PReSellPetReq.processImp@pet can not sell|roleid=%d|petCfgId=%d|petId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(petCfgId), Long.valueOf(xMarketPet.getPet().getId()), Integer.valueOf(this.price) });
/*     */       
/*     */ 
/* 111 */       MarketManager.logger.error(logStr);
/* 112 */       return false;
/*     */     }
/* 114 */     if (ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.MARKET_PET.value, petCfgId))
/*     */     {
/* 116 */       ItemBanTrade.getInstance().sendTipToTole(this.roleId, PetInterface.getPetName(petCfgId));
/* 117 */       return false;
/*     */     }
/* 119 */     int minPoint = MarketManager.getMinPointForSellPet(petCfgId);
/* 120 */     if (minPoint == -1)
/*     */     {
/* 122 */       String logStr = String.format("[market]PReSellPetReq.processImp@pet can not sell,petcfgId error|roleid=%d|petCfgId=%d|petId=%d|price=%d|minPoint=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(petCfgId), Long.valueOf(xMarketPet.getPet().getId()), Integer.valueOf(this.price), Integer.valueOf(minPoint) });
/*     */       
/*     */ 
/* 125 */       MarketManager.logger.error(logStr);
/* 126 */       return false;
/*     */     }
/*     */     
/* 129 */     if (!PetInterface.isAboveScoreValue(minPoint, xMarketPet.getPet()))
/*     */     {
/* 131 */       String logStr = String.format("[market]PReSellPetReq.processImp@pet can not sell,minPoint error|roleid=%d|petCfgId=%d|petId=%d|price=%d|minPoint=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(petCfgId), Long.valueOf(xMarketPet.getPet().getId()), Integer.valueOf(this.price), Integer.valueOf(minPoint) });
/*     */       
/*     */ 
/* 134 */       MarketManager.logger.error(logStr);
/* 135 */       return false;
/*     */     }
/*     */     
/* 138 */     if (!MarketManager.isPetPriceRight(xMarketPet.getPet(), this.price))
/*     */     {
/* 140 */       String logStr = String.format("[market]PReSellPetReq.processImp@market sell pet price error|roleid=%d|marketId=%d|petCfgId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.marketId), Integer.valueOf(petCfgId), Integer.valueOf(this.price) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 145 */       MarketManager.logger.error(logStr);
/* 146 */       return false;
/*     */     }
/*     */     
/* 149 */     long tax = MarketManager.computeSellNeedTaxGold(this.price, 1);
/* 150 */     if (tax <= 0L)
/*     */     {
/* 152 */       String logStr = String.format("[market]PReSellPetReq.processImp@market sell pet tax error|roleid=%d|marketId=%d|petCfgId=%d|tax=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.marketId), Integer.valueOf(petCfgId), Long.valueOf(tax), Integer.valueOf(this.price) });
/*     */       
/*     */ 
/* 155 */       MarketManager.logger.error(logStr);
/* 156 */       return false;
/*     */     }
/* 158 */     TLogArg logArg = new TLogArg(mzm.gsp.tlog.LogReason.MARKET_SHANGJIA, petCfgId);
/* 159 */     if (!RoleInterface.cutGold(this.roleId, tax, logArg))
/*     */     {
/* 161 */       MarketManager.sendCommonError(this.roleId, 6);
/*     */       
/* 163 */       return false;
/*     */     }
/*     */     
/* 166 */     int channelSize = MarketManager.getChannelSizeByPetId(petCfgId);
/* 167 */     if (channelSize == -1)
/*     */     {
/*     */ 
/* 170 */       String logStr = String.format("[market]PReSellPetReq.processImp@market sell pet channelSize error|roleid=%d|petCfgId=%d|channelSize=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(petCfgId), Integer.valueOf(channelSize) });
/*     */       
/*     */ 
/* 173 */       MarketManager.logger.error(logStr);
/* 174 */       return false;
/*     */     }
/*     */     
/* 177 */     xbean.MarketChannelIds xMarketChannelIds = MarketManager.getMarketPetChannelIdsOnAdd(petCfgId);
/*     */     
/* 179 */     ChannelIdXMarketIdsBean channelIdXMarketIdsBean = MarketManager.findChannelIdXMarketIdsBean(xMarketChannelIds, channelSize);
/*     */     
/* 181 */     if (channelIdXMarketIdsBean == null)
/*     */     {
/* 183 */       String logStr = String.format("[market]PReSellPetReq.processImp@market resell pet error,not get an available channle|roleid=%d|petcfgid=%d|channelSize=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(petCfgId), Integer.valueOf(channelSize) });
/*     */       
/*     */ 
/* 186 */       MarketManager.logger.error(logStr);
/* 187 */       return false;
/*     */     }
/* 189 */     long channelid = channelIdXMarketIdsBean.channelid;
/* 190 */     MarketIds xMarketIds = channelIdXMarketIdsBean.xMarketIds;
/*     */     
/* 192 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 193 */     long endtime = 0L;
/* 194 */     long lengthTime = 0L;
/* 195 */     boolean isPub = false;
/* 196 */     long newMarketid = 0L;
/* 197 */     if (oldPrice != this.price)
/*     */     {
/* 199 */       newMarketid = MarketManager.createMarketPetInfo(this.roleId, xMarketPet.getPet(), this.price, now, channelid, 1);
/*     */       
/*     */ 
/* 202 */       endtime = MarketManager.computePublicEndtime(now);
/*     */       
/* 204 */       if (MarketManager.isLevelSift(subid))
/*     */       {
/*     */ 
/* 207 */         LevelSiftRankManager.rankPub(subid, newMarketid, xMarketPet.getPet().getLevel(), this.price);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 212 */         PriceRankManager.rankPub(subid, newMarketid, this.price);
/*     */       }
/*     */       
/* 215 */       long publicTipEndtime = MarketManager.computePublicTipEndTime(now);
/* 216 */       long length = publicTipEndtime - TimeUnit.MILLISECONDS.toSeconds(now);
/* 217 */       if (length <= 0L)
/*     */       {
/* 219 */         length = 1L;
/*     */       }
/* 221 */       PrePubPetSession prePubPetSession = new PrePubPetSession(length, newMarketid);
/* 222 */       Marketpet2sessionid.remove(Long.valueOf(newMarketid));
/* 223 */       Marketpet2sessionid.insert(Long.valueOf(newMarketid), Long.valueOf(prePubPetSession.getSessionId()));
/*     */       
/* 225 */       lengthTime = MarketManager.computePublicEndtime(now) - TimeUnit.MILLISECONDS.toSeconds(now) + TimeUnit.MINUTES.toSeconds(SMarketConsts.getInstance().AUCTION_TIME);
/*     */       
/* 227 */       isPub = true;
/* 228 */       MarketManager.sendSSellPetRes(this.roleId, newMarketid, petCfgId, this.price, endtime, 0, 1, this.marketId);
/*     */     }
/*     */     else
/*     */     {
/* 232 */       newMarketid = MarketManager.createMarketPetInfo(this.roleId, xMarketPet.getPet(), this.price, now, channelid, 2);
/*     */       
/* 234 */       endtime = MarketManager.computeShangjiaExpireTime(now);
/* 235 */       if (MarketManager.isLevelSift(subid))
/*     */       {
/* 237 */         LevelSiftRankManager.rankSell(subid, newMarketid, xMarketPet.getPet().getLevel(), this.price);
/*     */       }
/*     */       else
/*     */       {
/* 241 */         PriceRankManager.rankSell(subid, newMarketid, this.price);
/*     */       }
/* 243 */       MarketItemPetPriceManager.addPrice(petCfgId, this.price);
/*     */       
/* 245 */       long interval = endtime - TimeUnit.MILLISECONDS.toSeconds(now);
/* 246 */       MarketManager.startOnSellPetPhaseSession(newMarketid, xMarketPet, MarketManager.getRecycleSeconds(petCfgId), interval);
/*     */       
/*     */ 
/* 249 */       lengthTime = interval;
/* 250 */       isPub = false;
/* 251 */       MarketManager.sendSSellPetRes(this.roleId, newMarketid, petCfgId, this.price, endtime, 0, 2, this.marketId);
/*     */     }
/* 253 */     boolean ret = xMarketIds.getMarket_ids().add(Long.valueOf(newMarketid));
/* 254 */     if (!ret)
/*     */     {
/* 256 */       String logStr = String.format("[market]PReSellPetReq.processImp@add new marketid error|roleid=%d|petCfgId=%d|price=%d|marketId=%d|channel_id=%d|new_market_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(petCfgId), Integer.valueOf(this.price), Long.valueOf(this.marketId), Long.valueOf(xMarketPet.getChannel_id()), Long.valueOf(newMarketid) });
/*     */       
/*     */ 
/* 259 */       MarketManager.logger.error(logStr);
/* 260 */       return false;
/*     */     }
/* 262 */     xRoleMarketInfo.getMarketid2timeoutorselledpet().remove(Long.valueOf(this.marketId));
/* 263 */     xRoleMarketInfo.getOnshelf_pet_ids().remove(Long.valueOf(this.marketId));
/* 264 */     xRoleMarketInfo.getOnshelf_pet_ids().add(Long.valueOf(newMarketid));
/* 265 */     MarketManager.tlogMarket(this.roleId, petCfgId, 1, this.price, tax, MarketOperateEnum.RESELL_PET);
/*     */     
/* 267 */     Set<Long> uuids = new HashSet();
/* 268 */     uuids.add(Long.valueOf(xMarketPet.getPet().getId()));
/* 269 */     MarketManager.tlogMarketSellPetForIdip(this.roleId, petCfgId, 1, xMarketPet.getPet().getLevel(), PetInterface.getPetScoreLevel(xMarketPet.getPet().copy()), this.price, uuids, newMarketid, lengthTime, MarketOperateEnum.RESELL_PET.value);
/*     */     
/*     */ 
/*     */ 
/* 273 */     String logStr = String.format("[market]PReSellPetReq.processImp@market sell pet success|roleid=%d|petCfgId=%d|price=%d|marketId=%d|channel_id=%d|new_market_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(petCfgId), Integer.valueOf(this.price), Long.valueOf(this.marketId), Long.valueOf(xMarketPet.getChannel_id()), Long.valueOf(newMarketid) });
/*     */     
/*     */ 
/* 276 */     MarketManager.logger.info(logStr);
/*     */     
/* 278 */     MarketInterface.triggerMarketPetOnShelfEvent(newMarketid, petCfgId, isPub);
/* 279 */     MarketManager.sendBulletinForPet(RoleInterface.getName(this.roleId), newMarketid, petCfgId, this.price, isPub);
/* 280 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PReSellPetReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */