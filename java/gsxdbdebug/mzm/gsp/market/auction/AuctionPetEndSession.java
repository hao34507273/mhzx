/*     */ package mzm.gsp.market.auction;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.market.main.MarketInterface;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AuctionPetInfo;
/*     */ import xbean.MarketPet;
/*     */ import xbean.Pet;
/*     */ import xbean.RoleAuctionInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Channel2marketids;
/*     */ import xtable.Marketpet;
/*     */ import xtable.Marketpet2sessionid;
/*     */ import xtable.Marketpetid2auction;
/*     */ import xtable.Marketpetid2concernrole;
/*     */ import xtable.Role2auctioninfo;
/*     */ 
/*     */ public class AuctionPetEndSession extends Session
/*     */ {
/*     */   public AuctionPetEndSession(long interval, long marketId)
/*     */   {
/*  28 */     super(interval, marketId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  36 */     new AuctionPetEndPro(getOwerId()).execute();
/*     */   }
/*     */   
/*     */ 
/*     */   private static class AuctionPetEndPro
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long marketId;
/*     */     
/*     */     public AuctionPetEndPro(long marketId)
/*     */     {
/*  47 */       this.marketId = marketId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  53 */       Long maxPriceRoleId = Marketpetid2auction.selectAuctionroleid(Long.valueOf(this.marketId));
/*  54 */       if (maxPriceRoleId == null)
/*     */       {
/*  56 */         String logStr = String.format("[marketauction]AuctionPetEndPro.processImp@ maxPriceRoleId get null|marketId=%d", new Object[] { Long.valueOf(this.marketId) });
/*     */         
/*  58 */         MarketInterface.getLogger().error(logStr);
/*  59 */         return false;
/*     */       }
/*     */       
/*  62 */       MarketPet xMarketPet = Marketpet.select(Long.valueOf(this.marketId));
/*  63 */       if (xMarketPet == null)
/*     */       {
/*  65 */         String logStr = String.format("[marketauction]AuctionPetEndPro.processImp@ sellerRoleId get null|marketId=%d", new Object[] { Long.valueOf(this.marketId) });
/*     */         
/*  67 */         MarketInterface.getLogger().error(logStr);
/*  68 */         return false;
/*     */       }
/*  70 */       long sellerRoleId = xMarketPet.getRoleid();
/*  71 */       List<Long> roleList = new ArrayList();
/*  72 */       roleList.add(maxPriceRoleId);
/*  73 */       if (!MarketInterface.isSysRoleid(sellerRoleId))
/*     */       {
/*  75 */         roleList.add(Long.valueOf(sellerRoleId));
/*     */       }
/*     */       
/*  78 */       Lockeys.lock(Role2auctioninfo.getTable(), roleList);
/*  79 */       long petLockKey = mzm.gsp.GameServerInfoManager.toGlobalId(xMarketPet.getPet().getTemplateid());
/*  80 */       Lockeys.lock(xtable.Pet2marketchannelids.getTable(), Arrays.asList(new Long[] { Long.valueOf(petLockKey) }));
/*     */       
/*  82 */       Lockeys.lock(Channel2marketids.getTable(), Arrays.asList(new Long[] { Long.valueOf(xMarketPet.getChannel_id()) }));
/*  83 */       RoleAuctionInfo xRoleAuctionInfo = Role2auctioninfo.get(maxPriceRoleId);
/*  84 */       if (xRoleAuctionInfo == null)
/*     */       {
/*  86 */         String logStr = String.format("[marketauction]AuctionPetEndPro.processImp@ xRoleAuctionInfo get null|maxPriceRoleId=%d|marketId=%d", new Object[] { maxPriceRoleId, Long.valueOf(this.marketId) });
/*     */         
/*     */ 
/*  89 */         MarketInterface.getLogger().error(logStr);
/*  90 */         return false;
/*     */       }
/*  92 */       if (!xRoleAuctionInfo.getAuction_pet_ids().contains(Long.valueOf(this.marketId)))
/*     */       {
/*  94 */         String logStr = String.format("[marketauction]AuctionPetEndPro.processImp@no auction pet marketid|maxPriceRoleId=%d|marketId=%d", new Object[] { maxPriceRoleId, Long.valueOf(this.marketId) });
/*     */         
/*     */ 
/*  97 */         MarketInterface.getLogger().error(logStr);
/*  98 */         return false;
/*     */       }
/*     */       
/* 101 */       xMarketPet = Marketpet.get(Long.valueOf(this.marketId));
/* 102 */       if (xMarketPet == null)
/*     */       {
/* 104 */         String logStr = String.format("[marketauction]AuctionPetEndPro.processImp@ xMarketPet get null|marketId=%d", new Object[] { Long.valueOf(this.marketId) });
/*     */         
/* 106 */         MarketInterface.getLogger().error(logStr);
/* 107 */         return false;
/*     */       }
/* 109 */       if (xMarketPet.getRoleid() != sellerRoleId)
/*     */       {
/* 111 */         String logStr = String.format("[marketauction]AuctionPetEndPro.processImp@ seller roleid error|sellerRoleid=%d|marketRoleId=%d", new Object[] { Long.valueOf(sellerRoleId), Long.valueOf(xMarketPet.getRoleid()) });
/*     */         
/*     */ 
/* 114 */         MarketInterface.getLogger().error(logStr);
/* 115 */         return false;
/*     */       }
/* 117 */       if (!MarketInterface.hasState(xMarketPet.getState(), 16))
/*     */       {
/* 119 */         String logStr = String.format("[marketauction]AuctionPetEndPro.processImp@ xMarketPet state error|roleId=%d|marketId=%d|state=%d|auctionRoleId=%d", new Object[] { Long.valueOf(sellerRoleId), Long.valueOf(this.marketId), Integer.valueOf(xMarketPet.getState()), maxPriceRoleId });
/*     */         
/*     */ 
/* 122 */         MarketInterface.getLogger().error(logStr);
/* 123 */         return false;
/*     */       }
/*     */       
/* 126 */       xMarketPet.setState(4);
/*     */       
/* 128 */       AuctionPetInfo xAuctionInfo = Marketpetid2auction.get(Long.valueOf(this.marketId));
/* 129 */       if (xAuctionInfo == null)
/*     */       {
/* 131 */         String logStr = String.format("[marketauction]AuctionPetEndPro.processImp@ xAuctionInfo state error,null|roleId=%d|marketId=%d|state=%d|auctionRoleId=%d", new Object[] { Long.valueOf(sellerRoleId), Long.valueOf(this.marketId), Integer.valueOf(xMarketPet.getState()), maxPriceRoleId });
/*     */         
/*     */ 
/* 134 */         MarketInterface.getLogger().error(logStr);
/* 135 */         return false;
/*     */       }
/*     */       
/* 138 */       if (maxPriceRoleId.longValue() != xAuctionInfo.getAuctionroleid())
/*     */       {
/* 140 */         String logStr = String.format("[marketauction]AuctionPetEndPro.processImp@ auction roleId not same or price error|roleId=%d|marketId=%d|state=%d|auctionRoleId=%d|newAuctionRoleId=%d", new Object[] { Long.valueOf(sellerRoleId), Long.valueOf(this.marketId), Integer.valueOf(xMarketPet.getState()), maxPriceRoleId, Long.valueOf(xAuctionInfo.getAuctionroleid()) });
/*     */         
/*     */ 
/* 143 */         MarketInterface.getLogger().error(logStr);
/* 144 */         return false;
/*     */       }
/*     */       
/* 147 */       Pet xPet = xbean.Pod.newPet();
/* 148 */       PetInterface.fillXpet(xPet, xMarketPet.getPet());
/*     */       
/* 150 */       xPet.setMarketbuytime(TimeUnit.MILLISECONDS.toSeconds(xAuctionInfo.getEndtime()));
/* 151 */       xRoleAuctionInfo.getMarketid2auctionpet().put(Long.valueOf(this.marketId), xPet);
/*     */       
/* 153 */       if (!MarketInterface.isSysRoleid(sellerRoleId))
/*     */       {
/* 155 */         xbean.RoleMarketInfo xRoleMarketInfo = xtable.Role2marketinfo.get(Long.valueOf(sellerRoleId));
/* 156 */         if (xRoleMarketInfo == null)
/*     */         {
/* 158 */           String logStr = String.format("[marketauction]AuctionPetEndPro.processImp@ xRoleMarketInfo null|roleId=%d|marketId=%d|state=%d|auctionRoleId=%d", new Object[] { Long.valueOf(sellerRoleId), Long.valueOf(this.marketId), Integer.valueOf(xMarketPet.getState()), maxPriceRoleId });
/*     */           
/*     */ 
/* 161 */           MarketInterface.getLogger().error(logStr);
/* 162 */           return false;
/*     */         }
/* 164 */         MarketInterface.addMarketTimeOutOrSelledPet(xRoleMarketInfo, this.marketId, xMarketPet);
/* 165 */         MarketInterface.sendSSyncSellPetNotify(sellerRoleId, this.marketId, xMarketPet.getPet().getTemplateid());
/*     */       }
/*     */       
/* 168 */       MarketInterface.removeMarketIdFromPetChannel(petLockKey, this.marketId, xMarketPet.getChannel_id());
/* 169 */       Marketpet.remove(Long.valueOf(this.marketId));
/*     */       
/* 171 */       Marketpetid2concernrole.remove(Long.valueOf(this.marketId));
/*     */       
/* 173 */       MarketInterface.logMarketBuyPet(maxPriceRoleId.longValue(), sellerRoleId, this.marketId, xMarketPet.getPet().getTemplateid(), 1, xMarketPet.getPrice(), xMarketPet.getPet().getLevel(), PetInterface.getPetScoreLevel(xMarketPet.getPet()), xMarketPet.getPet().getId(), DateTimeUtils.getCurrTimeInMillis());
/*     */       
/*     */ 
/*     */ 
/* 177 */       int subid = MarketInterface.getSubidByPetId(xMarketPet.getPet().getTemplateid());
/* 178 */       if (subid != -1)
/*     */       {
/*     */ 
/* 181 */         Marketpet2sessionid.remove(Long.valueOf(this.marketId));
/*     */         
/* 183 */         if (MarketInterface.isLevelSift(subid))
/*     */         {
/* 185 */           MarketInterface.deleteFromPubLevelSiftRank(subid, this.marketId, xMarketPet.getPet().getLevel());
/*     */         }
/*     */         else
/*     */         {
/* 189 */           MarketInterface.deleteFromPubPriceRank(subid, this.marketId);
/*     */         }
/*     */         
/* 192 */         MarketInterface.triggerMarketPetOffShelfEvent(this.marketId, xMarketPet.getPet().getTemplateid(), true, xMarketPet.toData());
/*     */         
/*     */ 
/* 195 */         String logStr = String.format("[marketauction]AuctionPetEndPro.processImp@ market pet auction success|roleId=%d|marketId=%d|subid=%d|petCfgId=%d|price=%d|auctionRoleId=%d|auctionPrice=%d", new Object[] { Long.valueOf(sellerRoleId), Long.valueOf(this.marketId), Integer.valueOf(subid), Integer.valueOf(xMarketPet.getPet().getTemplateid()), Integer.valueOf(xMarketPet.getPrice()), maxPriceRoleId, Integer.valueOf(xAuctionInfo.getAuctionprice()) });
/*     */         
/*     */ 
/*     */ 
/* 199 */         MarketInterface.getLogger().info(logStr);
/*     */       }
/*     */       else
/*     */       {
/* 203 */         Marketpet2sessionid.remove(Long.valueOf(this.marketId));
/*     */       }
/* 205 */       MarketAuctionManager.sendAuctionSuccessMail(maxPriceRoleId.longValue(), this.marketId, xMarketPet.getPet().getTemplateid(), xMarketPet.getPet().getPetname(), xAuctionInfo.getAuctionprice());
/*     */       
/*     */ 
/* 208 */       MarketAuctionManager.tlogMarketAuctionSuccess(maxPriceRoleId.longValue(), subid, xMarketPet.getPet().getTemplateid(), xMarketPet.getPrice(), this.marketId, xMarketPet.getPet().getId(), sellerRoleId);
/*     */       
/* 210 */       MarketAuctionManager.removeMarketPetAuction(this.marketId, false, false, false);
/* 211 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\auction\AuctionPetEndSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */