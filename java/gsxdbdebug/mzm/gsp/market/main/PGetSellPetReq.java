/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.market.SGetSellPetRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AuctionPetInfo;
/*     */ import xbean.MarketPet;
/*     */ import xbean.Pet;
/*     */ import xbean.RoleMarketInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Marketpet;
/*     */ import xtable.Marketpet2sessionid;
/*     */ 
/*     */ public class PGetSellPetReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long marketId;
/*     */   public final int petCfgId;
/*     */   
/*     */   public PGetSellPetReq(long roleId, long marketId, int petCfgId)
/*     */   {
/*  28 */     this.roleId = roleId;
/*  29 */     this.marketId = marketId;
/*  30 */     this.petCfgId = petCfgId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*     */     {
/*  38 */       String logStr = String.format("[market]PGetSellPetReq.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  40 */       MarketManager.logger.info(logStr);
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     String logStr = String.format("[market]PGetSellPetReq.processImp@receive get sell pet req|roleid=%d|petCfgId=%d|marketId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId) });
/*     */     
/*     */ 
/*  47 */     MarketManager.logger.info(logStr);
/*     */     
/*  49 */     RoleMarketInfo xRoleMarketInfo = xtable.Role2marketinfo.get(Long.valueOf(this.roleId));
/*  50 */     if (xRoleMarketInfo == null)
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if (!xRoleMarketInfo.getOnshelf_pet_ids().contains(Long.valueOf(this.marketId)))
/*     */     {
/*  57 */       return false;
/*     */     }
/*  59 */     if (xRoleMarketInfo.getMarketid2timeoutorselledpet().containsKey(Long.valueOf(this.marketId)))
/*     */     {
/*  61 */       MarketPet xMarketPet = (MarketPet)xRoleMarketInfo.getMarketid2timeoutorselledpet().get(Long.valueOf(this.marketId));
/*  62 */       if (xMarketPet.getState() != 8)
/*     */       {
/*  64 */         return false;
/*     */       }
/*     */       
/*  67 */       Pet xPet = xbean.Pod.newPet();
/*  68 */       PetInterface.fillXpet(xPet, xMarketPet.getPet());
/*     */       
/*  70 */       boolean ret = PetInterface.addXpetIntoPetbag(this.roleId, xPet);
/*  71 */       if (!ret)
/*     */       {
/*  73 */         MarketManager.sendCommonError(this.roleId, 3);
/*  74 */         return false;
/*     */       }
/*     */       
/*  77 */       xRoleMarketInfo.getOnshelf_pet_ids().remove(Long.valueOf(this.marketId));
/*  78 */       xRoleMarketInfo.getMarketid2timeoutorselledpet().remove(Long.valueOf(this.marketId));
/*     */       
/*  80 */       sendSGetSellPetRes(0);
/*     */       
/*  82 */       MarketInterface.triggerGetBackPetEvent(this.roleId, xMarketPet.getPet().getId(), this.petCfgId);
/*     */       
/*  84 */       String log = String.format("[market]PGetSellPetReq.processImp@get pet from role shelf sucess|roleid=%d|petCfgId=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(xMarketPet.getPet().getTemplateid()), Long.valueOf(this.marketId), Integer.valueOf(xMarketPet.getPrice()) });
/*     */       
/*     */ 
/*  87 */       MarketManager.logger.info(log);
/*  88 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  93 */     Long channel_id = Marketpet.selectChannel_id(Long.valueOf(this.marketId));
/*  94 */     if (channel_id == null)
/*     */     {
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     long petLockKey = mzm.gsp.GameServerInfoManager.toGlobalId(this.petCfgId);
/* 100 */     Lockeys.lock(xtable.Pet2marketchannelids.getTable(), Arrays.asList(new Long[] { Long.valueOf(petLockKey) }));
/*     */     
/* 102 */     Lockeys.lock(xtable.Channel2marketids.getTable(), Arrays.asList(new Long[] { channel_id }));
/*     */     
/* 104 */     MarketPet xMarketPet = Marketpet.get(Long.valueOf(this.marketId));
/* 105 */     if (xMarketPet == null)
/*     */     {
/* 107 */       return false;
/*     */     }
/* 109 */     if (xMarketPet.getChannel_id() != channel_id.longValue())
/*     */     {
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     if (xMarketPet.getState() == 4)
/*     */     {
/* 116 */       MarketManager.sendCommonError(this.roleId, 4);
/* 117 */       return false;
/*     */     }
/*     */     
/* 120 */     if (xMarketPet.getPet().getTemplateid() != this.petCfgId)
/*     */     {
/* 122 */       return false;
/*     */     }
/* 124 */     int needGold = 0;
/* 125 */     AuctionPetInfo xAuctionPetInfo = xtable.Marketpetid2auction.get(Long.valueOf(this.marketId));
/* 126 */     if ((MarketManager.isCutGoldSwitchOpen()) && (MarketManager.hasState(xMarketPet.getState(), 16)) && (xAuctionPetInfo != null))
/*     */     {
/*     */ 
/*     */ 
/* 130 */       needGold = MarketManager.computeOffSheldNeedGold(xMarketPet.getPrice());
/* 131 */       TLogArg logArg = new TLogArg(mzm.gsp.tlog.LogReason.MARKET_AUCTION_GOODS_OFFSHELF, this.petCfgId);
/*     */       
/* 133 */       boolean ret = mzm.gsp.role.main.RoleInterface.cutGold(this.roleId, needGold, logArg);
/* 134 */       if (!ret)
/*     */       {
/* 136 */         String log = String.format("[market]PGetSellPetReq.processImp@pet is auctioned,cut gold error|roleid=%d|petcfgid=%d|marketId=%d|price=%d|need_total_gold=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId), Integer.valueOf(xMarketPet.getPrice()), Integer.valueOf(needGold) });
/*     */         
/*     */ 
/* 139 */         MarketManager.logger.info(log);
/*     */         
/* 141 */         MarketManager.sendCommonError(this.roleId, 25);
/* 142 */         return false;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 147 */       String log = String.format("[market]PGetSellPetReq.processImp@pet is not auctioned|roleid=%d|petcfgid=%d|marketId=%d|price=%d|state=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petCfgId), Long.valueOf(this.marketId), Integer.valueOf(xMarketPet.getPrice()), Integer.valueOf(xMarketPet.getState()) });
/*     */       
/*     */ 
/* 150 */       MarketManager.logger.info(log);
/*     */     }
/*     */     
/* 153 */     boolean ret = MarketInterface.addPetToRole(this.roleId, xMarketPet.getPet(), 0L);
/* 154 */     if (!ret)
/*     */     {
/* 156 */       return false;
/*     */     }
/*     */     
/* 159 */     xtable.Marketpetid2concernrole.remove(Long.valueOf(this.marketId));
/* 160 */     Marketpet.remove(Long.valueOf(this.marketId));
/* 161 */     MarketManager.removeMarketIdFromPetChannel(petLockKey, this.marketId, channel_id.longValue());
/*     */     
/* 163 */     xRoleMarketInfo.getOnshelf_pet_ids().remove(Long.valueOf(this.marketId));
/*     */     
/* 165 */     Long sessionId = Marketpet2sessionid.get(Long.valueOf(this.marketId));
/* 166 */     if (sessionId != null)
/*     */     {
/* 168 */       Session.removeSession(sessionId.longValue());
/* 169 */       Marketpet2sessionid.remove(Long.valueOf(this.marketId));
/*     */     }
/*     */     
/* 172 */     int subid = MarketManager.getSubidByPetId(this.petCfgId);
/* 173 */     if (MarketManager.isLevelSift(subid))
/*     */     {
/* 175 */       LevelSiftRankManager.deletePub(subid, this.marketId, xMarketPet.getPet().getLevel());
/* 176 */       LevelSiftRankManager.deleteSell(subid, this.marketId, xMarketPet.getPet().getLevel());
/*     */     }
/*     */     else
/*     */     {
/* 180 */       PriceRankManager.deletePub(subid, this.marketId);
/* 181 */       PriceRankManager.deleteSell(subid, this.marketId);
/*     */     }
/* 183 */     sendSGetSellPetRes(needGold);
/*     */     
/* 185 */     if (MarketManager.hasState(xMarketPet.getState(), 1))
/*     */     {
/* 187 */       MarketInterface.triggerMarketPetOffShelfEvent(this.marketId, this.petCfgId, true, xMarketPet.toData());
/*     */     }
/* 189 */     else if (MarketManager.hasState(xMarketPet.getState(), 2))
/*     */     {
/* 191 */       MarketInterface.triggerMarketPetOffShelfEvent(this.marketId, this.petCfgId, false, xMarketPet.toData());
/* 192 */       MarketItemPetPriceManager.removePrice(xMarketPet.getPet().getTemplateid(), xMarketPet.getPrice());
/*     */     }
/* 194 */     mzm.gsp.market.auction.MarketAuctionManager.removeMarketPetAuction(this.marketId, true, true, true);
/* 195 */     MarketInterface.triggerGetBackPetEvent(this.roleId, xMarketPet.getPet().getId(), this.petCfgId);
/*     */     
/* 197 */     String log = String.format("[market]PGetSellPetReq.processImp@get pet from market shelf sucess|roleid=%d|petCfgId=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(xMarketPet.getPet().getTemplateid()), Long.valueOf(this.marketId), Integer.valueOf(xMarketPet.getPrice()) });
/*     */     
/*     */ 
/* 200 */     MarketManager.logger.info(log);
/* 201 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void sendSGetSellPetRes(int cutGold)
/*     */   {
/* 208 */     SGetSellPetRes res = new SGetSellPetRes();
/* 209 */     res.marketid = this.marketId;
/* 210 */     res.cutgold = cutGold;
/* 211 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PGetSellPetReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */