/*     */ package mzm.gsp.market.auction;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.market.main.MarketInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AuctionPetInfo;
/*     */ import xbean.MarketPet;
/*     */ import xbean.Pet;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Marketpet;
/*     */ import xtable.Marketpet2sessionid;
/*     */ import xtable.Marketpetid2auction;
/*     */ import xtable.Marketpetid2concernrole;
/*     */ import xtable.Role2auctioninfo;
/*     */ 
/*     */ public class AuctiontPetTipSession extends Session
/*     */ {
/*     */   public AuctiontPetTipSession(long interval, long marketId)
/*     */   {
/*  25 */     super(interval, marketId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  33 */     new AuctiontPetTipPro(getOwerId()).execute();
/*     */   }
/*     */   
/*     */ 
/*     */   private static class AuctiontPetTipPro
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long marketId;
/*     */     
/*     */     public AuctiontPetTipPro(long marketId)
/*     */     {
/*  44 */       this.marketId = marketId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  50 */       Long maxPriceRoleId = Marketpetid2auction.selectAuctionroleid(Long.valueOf(this.marketId));
/*  51 */       if (maxPriceRoleId == null)
/*     */       {
/*  53 */         String logStr = String.format("[marketauction]AuctiontPetTipPro.processImp@ maxPriceRoleId get null|marketId=%d", new Object[] { Long.valueOf(this.marketId) });
/*     */         
/*  55 */         MarketInterface.getLogger().error(logStr);
/*  56 */         return false;
/*     */       }
/*     */       
/*  59 */       Lockeys.lock(Role2auctioninfo.getTable(), Arrays.asList(new Long[] { maxPriceRoleId }));
/*     */       
/*  61 */       MarketPet xMarketPet = Marketpet.get(Long.valueOf(this.marketId));
/*  62 */       if (xMarketPet == null)
/*     */       {
/*  64 */         String logStr = String.format("[marketauction]AuctiontPetTipPro.processImp@ xbean.MarketPet get null|marketId=%d", new Object[] { Long.valueOf(this.marketId) });
/*     */         
/*  66 */         MarketInterface.getLogger().error(logStr);
/*  67 */         return false;
/*     */       }
/*  69 */       if (!MarketInterface.hasState(xMarketPet.getState(), 16))
/*     */       {
/*  71 */         String logStr = String.format("[marketauction]AuctiontPetTipPro.processImp@ xbean.MarketPet state error|roleId=%d|marketId=%d|state=%d|auctionRoleId=%d", new Object[] { Long.valueOf(xMarketPet.getRoleid()), Long.valueOf(this.marketId), Integer.valueOf(xMarketPet.getState()), maxPriceRoleId });
/*     */         
/*     */ 
/*  74 */         MarketInterface.getLogger().error(logStr);
/*  75 */         return false;
/*     */       }
/*     */       
/*  78 */       AuctionPetInfo xAuctionInfo = Marketpetid2auction.get(Long.valueOf(this.marketId));
/*  79 */       if (xAuctionInfo == null)
/*     */       {
/*  81 */         String logStr = String.format("[marketauction]AuctiontPetTipPro.processImp@ xbean.AuctionPetInfo state error,null|roleId=%d|marketId=%d|state=%d|auctionRoleId=%d", new Object[] { Long.valueOf(xMarketPet.getRoleid()), Long.valueOf(this.marketId), Integer.valueOf(xMarketPet.getState()), maxPriceRoleId });
/*     */         
/*     */ 
/*  84 */         MarketInterface.getLogger().error(logStr);
/*  85 */         return false;
/*     */       }
/*  87 */       xAuctionInfo.setIssendtip(true);
/*  88 */       if (maxPriceRoleId.longValue() != xAuctionInfo.getAuctionroleid())
/*     */       {
/*  90 */         String logStr = String.format("[marketauction]AuctiontPetTipPro.processImp@ auction roleId not same or price error|roleId=%d|marketId=%d|state=%d|auctionRoleId=%d|newAuctionRoleId=%d", new Object[] { Long.valueOf(xMarketPet.getRoleid()), Long.valueOf(this.marketId), Integer.valueOf(xMarketPet.getState()), maxPriceRoleId, Long.valueOf(xAuctionInfo.getAuctionroleid()) });
/*     */         
/*     */ 
/*     */ 
/*  94 */         MarketInterface.getLogger().error(logStr);
/*  95 */         return false;
/*     */       }
/*  97 */       List<Long> concernRoleSet = Marketpetid2concernrole.selectRoleids(Long.valueOf(this.marketId));
/*  98 */       MarketAuctionManager.sendAuctionPublicEndTipMail(xMarketPet.getRoleid(), maxPriceRoleId.longValue(), concernRoleSet, this.marketId, xMarketPet.getPet().getTemplateid(), xMarketPet.getPet().getPetname(), xAuctionInfo.getAuctioncount(), xAuctionInfo.getAuctionprice());
/*     */       
/*     */ 
/*     */ 
/* 102 */       long interval = TimeUnit.MILLISECONDS.toSeconds(xAuctionInfo.getEndtime() - DateTimeUtils.getCurrTimeInMillis());
/* 103 */       if (interval <= 0L)
/*     */       {
/* 105 */         interval = 1L;
/*     */       }
/* 107 */       Session session = new AuctionPetEndSession(interval, this.marketId);
/* 108 */       Marketpet2sessionid.remove(Long.valueOf(this.marketId));
/* 109 */       Marketpet2sessionid.insert(Long.valueOf(this.marketId), Long.valueOf(session.getSessionId()));
/* 110 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\auction\AuctiontPetTipSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */