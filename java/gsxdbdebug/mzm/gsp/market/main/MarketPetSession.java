/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.market.SSyncPetExpire;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MarketPet;
/*     */ import xbean.Pet;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Marketpet;
/*     */ import xtable.Marketpet2sessionid;
/*     */ 
/*     */ public class MarketPetSession extends Session
/*     */ {
/*     */   public MarketPetSession(long interval, long marketId)
/*     */   {
/*  18 */     super(interval, marketId);
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  24 */     new MarketPetSessionPro(getOwerId()).execute();
/*     */   }
/*     */   
/*     */   private static class MarketPetSessionPro
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long marketId;
/*     */     
/*     */     public MarketPetSessionPro(long marketId)
/*     */     {
/*  34 */       this.marketId = marketId;
/*     */     }
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  39 */       MarketPet xMarketPet = Marketpet.select(Long.valueOf(this.marketId));
/*  40 */       if (xMarketPet == null)
/*     */       {
/*  42 */         String logStr = String.format("[market]MarketPetSessionPro.processImp@ xbean.MarketPet get roleid null|marketId=%d", new Object[] { Long.valueOf(this.marketId) });
/*     */         
/*  44 */         MarketManager.logger.error(logStr);
/*  45 */         return false;
/*     */       }
/*  47 */       long roleId = xMarketPet.getRoleid();
/*  48 */       if (roleId != 0L)
/*     */       {
/*  50 */         Lockeys.lock(xtable.Role2auctioninfo.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId) }));
/*     */       }
/*     */       
/*  53 */       long petLockKey = mzm.gsp.GameServerInfoManager.toGlobalId(xMarketPet.getPet().getTemplateid());
/*  54 */       Lockeys.lock(xtable.Pet2marketchannelids.getTable(), Arrays.asList(new Long[] { Long.valueOf(petLockKey) }));
/*     */       
/*  56 */       Lockeys.lock(xtable.Channel2marketids.getTable(), Arrays.asList(new Long[] { Long.valueOf(xMarketPet.getChannel_id()) }));
/*     */       
/*  58 */       xMarketPet = Marketpet.get(Long.valueOf(this.marketId));
/*  59 */       if (xMarketPet == null)
/*     */       {
/*  61 */         String logStr = String.format("[market]MarketPetSessionPro.processImp@ xbean.MarketPet get null|marketId=%d|", new Object[] { Long.valueOf(this.marketId) });
/*     */         
/*  63 */         MarketManager.logger.error(logStr);
/*  64 */         return false;
/*     */       }
/*  66 */       if (xMarketPet.getRoleid() != roleId)
/*     */       {
/*  68 */         String logStr = String.format("[market]MarketPetSessionPro.processImp@ xbean.MarketPet role error|marketId=%d|marketRoleId=%d|roleId=%d", new Object[] { Long.valueOf(this.marketId), Long.valueOf(xMarketPet.getRoleid()), Long.valueOf(roleId) });
/*     */         
/*     */ 
/*  71 */         MarketManager.logger.error(logStr);
/*  72 */         return false;
/*     */       }
/*  74 */       xMarketPet.setState(8);
/*  75 */       xMarketPet.setConcern_role_num(0);
/*  76 */       int petCfgId = xMarketPet.getPet().getTemplateid();
/*  77 */       int subid = MarketManager.getSubidByPetId(petCfgId);
/*     */       
/*  79 */       if (subid != -1)
/*     */       {
/*     */ 
/*  82 */         MarketInterface.triggerMarketPetOffShelfEvent(this.marketId, xMarketPet.getPet().getTemplateid(), false, xMarketPet.toData());
/*     */       }
/*     */       
/*     */ 
/*  86 */       if (roleId != 0L)
/*     */       {
/*  88 */         xbean.RoleMarketInfo xRoleMarketInfo = xtable.Role2marketinfo.get(Long.valueOf(roleId));
/*  89 */         if (xRoleMarketInfo == null)
/*     */         {
/*  91 */           String logs = String.format("[market]MarketPetSessionPro.processImp@xRoleMarketInfo null|roleid=%d", new Object[] { Long.valueOf(roleId) });
/*  92 */           MarketManager.logger.info(logs);
/*  93 */           return false;
/*     */         }
/*  95 */         MarketManager.addMarketTimeOutOrSelledPet(xRoleMarketInfo, this.marketId, xMarketPet);
/*     */         
/*  97 */         SSyncPetExpire expireRes = new SSyncPetExpire();
/*  98 */         expireRes.marketid = this.marketId;
/*  99 */         expireRes.petcfgid = xMarketPet.getPet().getTemplateid();
/* 100 */         OnlineManager.getInstance().send(roleId, expireRes);
/*     */       }
/*     */       
/* 103 */       MarketManager.removeMarketIdFromPetChannel(petLockKey, this.marketId, xMarketPet.getChannel_id());
/* 104 */       Marketpet.remove(Long.valueOf(this.marketId));
/* 105 */       Marketpet2sessionid.remove(Long.valueOf(this.marketId));
/*     */       
/* 107 */       if (MarketManager.isLevelSift(subid))
/*     */       {
/* 109 */         LevelSiftRankManager.deleteSell(subid, this.marketId, xMarketPet.getPet().getLevel());
/*     */       }
/*     */       else
/*     */       {
/* 113 */         PriceRankManager.deleteSell(subid, this.marketId);
/*     */       }
/* 115 */       MarketItemPetPriceManager.removePrice(xMarketPet.getPet().getTemplateid(), xMarketPet.getPrice());
/*     */       
/* 117 */       String logStr = String.format("[market]MarketPetSessionPro.processImp@ market pet time out|roleId=%d|marketId=%d|petCfgId=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(this.marketId), Integer.valueOf(petCfgId) });
/*     */       
/*     */ 
/* 120 */       MarketManager.logger.info(logStr);
/*     */       
/* 122 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\MarketPetSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */