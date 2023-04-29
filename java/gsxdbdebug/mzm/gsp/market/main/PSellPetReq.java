/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.item.main.ItemBanTrade;
/*     */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*     */ import mzm.gsp.market.confbean.SMarketConsts;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MarketIds;
/*     */ import xbean.RoleMarketInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Marketpet2sessionid;
/*     */ import xtable.Pet2marketchannelids;
/*     */ import xtable.Role2marketinfo;
/*     */ 
/*     */ public class PSellPetReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private long petId;
/*     */   private int price;
/*     */   
/*     */   public PSellPetReq(long roleId, long petId, int price)
/*     */   {
/*  32 */     this.roleId = roleId;
/*  33 */     this.petId = petId;
/*  34 */     this.price = price;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     String log = String.format("[market]PSellPetReq.processImp@receive sell pet req|roleid=%d|petId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(this.price) });
/*     */     
/*  44 */     MarketManager.logger.info(log);
/*     */     
/*  46 */     if (this.price <= 0)
/*     */     {
/*  48 */       return false;
/*     */     }
/*  50 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*     */     {
/*  52 */       String logStr = String.format("[market]PSellPetReq.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  53 */       MarketManager.logger.info(logStr);
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     if (!MarketManager.isMarketSwitchOpenForRole(this.roleId))
/*     */     {
/*  59 */       return false;
/*     */     }
/*  61 */     if (!MarketManager.isMarketOpen(this.roleId))
/*     */     {
/*  63 */       return false;
/*     */     }
/*  65 */     Lockeys.lock(Role2marketinfo.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*     */     
/*  67 */     mzm.gsp.pet.main.Pet pet = PetInterface.getPetById(this.roleId, this.petId);
/*  68 */     if (pet == null)
/*     */     {
/*  70 */       return false;
/*     */     }
/*  72 */     if (pet.getXPetIsBinded())
/*     */     {
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     int petCfgId = pet.getCfgId();
/*  78 */     if (!MarketManager.canSellPet(petCfgId))
/*     */     {
/*  80 */       String logStr = String.format("[market]PSellPetReq.processImp@pet can not sell|roleid=%d|petCfgId=%d|petId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(petCfgId), Long.valueOf(this.petId), Integer.valueOf(this.price) });
/*     */       
/*     */ 
/*  83 */       MarketManager.logger.error(logStr);
/*  84 */       return false;
/*     */     }
/*  86 */     if (ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.MARKET_PET.value, petCfgId))
/*     */     {
/*  88 */       ItemBanTrade.getInstance().sendTipToTole(this.roleId, pet.getName());
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     int minPoint = MarketManager.getMinPointForSellPet(petCfgId);
/*  93 */     if (minPoint == -1)
/*     */     {
/*  95 */       String logStr = String.format("[market]PSellPetReq.processImp@pet can not sell,petcfgId error|roleid=%d|petCfgId=%d|petId=%d|price=%d|minPoint=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(petCfgId), Long.valueOf(this.petId), Integer.valueOf(this.price), Integer.valueOf(minPoint) });
/*     */       
/*     */ 
/*  98 */       MarketManager.logger.error(logStr);
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     if (!PetInterface.isAboveScoreValue(minPoint, pet.getXPet()))
/*     */     {
/* 104 */       String logStr = String.format("[market]PSellPetReq.processImp@pet can not sell,minPoint error|roleid=%d|petCfgId=%d|petId=%d|price=%d|minPoint=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(petCfgId), Long.valueOf(this.petId), Integer.valueOf(this.price), Integer.valueOf(minPoint) });
/*     */       
/*     */ 
/* 107 */       MarketManager.logger.error(logStr);
/* 108 */       return false;
/*     */     }
/* 110 */     if (MarketManager.isPetInFrozenState(petCfgId, pet.getMarketBuytime()))
/*     */     {
/* 112 */       String logStr = String.format("[market]PSellPetReq.processImp@pet can not sell,frozen state|roleid=%d|petCfgId=%d|petId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(petCfgId), Long.valueOf(this.petId), Integer.valueOf(this.price) });
/*     */       
/*     */ 
/* 115 */       MarketManager.logger.error(logStr);
/* 116 */       return false;
/*     */     }
/*     */     
/* 119 */     int subid = MarketManager.getSubidByPetId(petCfgId);
/* 120 */     if (subid == -1)
/*     */     {
/* 122 */       MarketManager.sendCommonError(this.roleId, 8);
/* 123 */       return false;
/*     */     }
/*     */     
/* 126 */     if (MarketManager.isMarketSellnumToMax(subid))
/*     */     {
/* 128 */       MarketManager.sendCommonError(this.roleId, 13);
/* 129 */       return false;
/*     */     }
/* 131 */     long key = GameServerInfoManager.toGlobalId(petCfgId);
/* 132 */     Lockeys.lock(Pet2marketchannelids.getTable(), Arrays.asList(new Long[] { Long.valueOf(key) }));
/*     */     
/* 134 */     RoleMarketInfo xRoleMarketInfo = Role2marketinfo.get(Long.valueOf(this.roleId));
/* 135 */     if (xRoleMarketInfo == null)
/*     */     {
/* 137 */       xRoleMarketInfo = xbean.Pod.newRoleMarketInfo();
/* 138 */       Role2marketinfo.insert(Long.valueOf(this.roleId), xRoleMarketInfo);
/*     */     }
/*     */     
/* 141 */     int alreadySellNum = xRoleMarketInfo.getOnshelf_item_ids().size() + xRoleMarketInfo.getOnshelf_pet_ids().size();
/* 142 */     if (alreadySellNum >= MarketManager.getRoleMaxMarketGrid())
/*     */     {
/* 144 */       String logStr = String.format("[market]PSellPetReq.processImp@market grid not enough|roleid=%d|gridnum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(alreadySellNum) });
/*     */       
/* 146 */       MarketManager.logger.error(logStr);
/*     */       
/* 148 */       return false;
/*     */     }
/*     */     
/* 151 */     if (!MarketManager.isPetPriceRight(pet.getXPet(), this.price))
/*     */     {
/* 153 */       String logStr = String.format("[market]PSellPetReq.processImp@market sell pet price error|roleid=%d|petId=%d|petCfgId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(petCfgId), Integer.valueOf(this.price) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 158 */       MarketManager.logger.error(logStr);
/* 159 */       return false;
/*     */     }
/*     */     
/* 162 */     long tax = MarketManager.computeSellNeedTaxGold(this.price, 1);
/* 163 */     if (tax <= 0L)
/*     */     {
/* 165 */       String logStr = String.format("[market]PSellPetReq.processImp@market sell pet tax error|roleid=%d|petId=%d|petCfgId=%d|tax=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(petCfgId), Long.valueOf(tax), Integer.valueOf(this.price) });
/*     */       
/*     */ 
/* 168 */       MarketManager.logger.error(logStr);
/* 169 */       return false;
/*     */     }
/* 171 */     TLogArg logArg = new TLogArg(mzm.gsp.tlog.LogReason.MARKET_SHANGJIA, petCfgId);
/* 172 */     if (!RoleInterface.cutGold(this.roleId, tax, logArg))
/*     */     {
/* 174 */       MarketManager.sendCommonError(this.roleId, 6);
/*     */       
/* 176 */       return false;
/*     */     }
/* 178 */     int channelSize = MarketManager.getChannelSizeByPetId(petCfgId);
/* 179 */     if (channelSize == -1)
/*     */     {
/*     */ 
/* 182 */       String logStr = String.format("[market]PSellPetReq.processImp@market sell pet channelSize error|roleid=%d|petId=%d|petCfgId=%d|channelSize=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(petCfgId), Integer.valueOf(channelSize) });
/*     */       
/*     */ 
/* 185 */       MarketManager.logger.error(logStr);
/* 186 */       return false;
/*     */     }
/*     */     
/* 189 */     xbean.MarketChannelIds xMarketChannelIds = MarketManager.getMarketPetChannelIdsOnAdd(petCfgId);
/*     */     
/* 191 */     ChannelIdXMarketIdsBean channelIdXMarketIdsBean = MarketManager.findChannelIdXMarketIdsBean(xMarketChannelIds, channelSize);
/*     */     
/* 193 */     if (channelIdXMarketIdsBean == null)
/*     */     {
/* 195 */       String logStr = String.format("[market]PSellPetReq.processImp@market sell pet error,not get an available channle|roleid=%d|petcfgid=%d|channelSize=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(petCfgId), Integer.valueOf(channelSize) });
/*     */       
/*     */ 
/* 198 */       MarketManager.logger.error(logStr);
/* 199 */       return false;
/*     */     }
/* 201 */     long channelid = channelIdXMarketIdsBean.channelid;
/* 202 */     MarketIds xMarketIds = channelIdXMarketIdsBean.xMarketIds;
/*     */     
/* 204 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 205 */     long marketId = MarketManager.createMarketPetInfo(this.roleId, pet.getXPet(), this.price, now, channelid, 1);
/*     */     
/* 207 */     boolean ret = xMarketIds.getMarket_ids().add(Long.valueOf(marketId));
/* 208 */     if (!ret)
/*     */     {
/* 210 */       return false;
/*     */     }
/* 212 */     xRoleMarketInfo.getOnshelf_pet_ids().add(Long.valueOf(marketId));
/*     */     
/* 214 */     long publicEndtime = MarketManager.computePublicEndtime(now);
/*     */     
/* 216 */     MarketManager.sendSSellPetRes(this.roleId, marketId, petCfgId, this.price, publicEndtime, 0, 1, marketId);
/*     */     
/* 218 */     MarketManager.tlogMarket(this.roleId, petCfgId, 1, this.price, tax, MarketOperateEnum.SELL_PET);
/*     */     
/* 220 */     ret = PetInterface.removePetInBag(this.roleId, this.petId);
/* 221 */     if (!ret)
/*     */     {
/* 223 */       return false;
/*     */     }
/*     */     
/* 226 */     long lengthTime = MarketManager.computePublicEndtime(now) - TimeUnit.MILLISECONDS.toSeconds(now) + TimeUnit.MINUTES.toSeconds(SMarketConsts.getInstance().AUCTION_TIME);
/*     */     
/* 228 */     Set<Long> uuids = new HashSet();
/* 229 */     uuids.add(Long.valueOf(pet.getId()));
/* 230 */     MarketManager.tlogMarketSellPetForIdip(this.roleId, petCfgId, 1, pet.getLevel(), PetInterface.getPetScoreLevel(pet.getXPet().copy()), this.price, uuids, marketId, lengthTime, MarketOperateEnum.SELL_PET.value);
/*     */     
/*     */ 
/*     */ 
/* 234 */     long publicTipEndtime = MarketManager.computePublicTipEndTime(now);
/* 235 */     long length = publicTipEndtime - TimeUnit.MILLISECONDS.toSeconds(now);
/* 236 */     if (length <= 0L)
/*     */     {
/* 238 */       length = 1L;
/*     */     }
/* 240 */     PrePubPetSession prePubItemSession = new PrePubPetSession(length, marketId);
/* 241 */     Marketpet2sessionid.remove(Long.valueOf(marketId));
/* 242 */     Marketpet2sessionid.insert(Long.valueOf(marketId), Long.valueOf(prePubItemSession.getSessionId()));
/*     */     
/* 244 */     if (MarketManager.isLevelSift(subid))
/*     */     {
/*     */ 
/* 247 */       LevelSiftRankManager.rankPub(subid, marketId, pet.getLevel(), this.price);
/*     */     }
/*     */     else
/*     */     {
/* 251 */       PriceRankManager.rankPub(subid, marketId, this.price);
/*     */     }
/*     */     
/* 254 */     String logStr = String.format("[market]PSellPetReq.processImp@market sell pet success|roleid=%d|petId=%d|petCfgId=%d|price=%d|marketId=%d|channel_id=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(petCfgId), Integer.valueOf(this.price), Long.valueOf(marketId), Long.valueOf(channelid) });
/*     */     
/*     */ 
/* 257 */     MarketManager.logger.info(logStr);
/*     */     
/* 259 */     MarketInterface.triggerMarketPetOnShelfEvent(marketId, petCfgId, true);
/* 260 */     MarketInterface.triggerSellPetEvent(this.roleId, this.petId, petCfgId, this.price);
/* 261 */     MarketManager.sendBulletinForPet(RoleInterface.getName(this.roleId), marketId, petCfgId, this.price, false);
/*     */     
/* 263 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PSellPetReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */