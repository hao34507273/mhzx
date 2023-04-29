/*    */ package mzm.gsp.cat.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.CatBestPartnerInfo;
/*    */ import xtable.Catbestpartner;
/*    */ 
/*    */ public class BestPartnerObserver extends Observer
/*    */ {
/*    */   private final long intervalSeconds;
/*    */   
/*    */   public BestPartnerObserver(long delaySeconds, long intervalSeconds)
/*    */   {
/* 15 */     super(delaySeconds);
/*    */     
/* 17 */     this.intervalSeconds = intervalSeconds;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 23 */     new PUpdateBestPartner(null).execute();
/*    */     
/* 25 */     setIntervalSeconds(this.intervalSeconds);
/*    */     
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   private static class PUpdateBestPartner
/*    */     extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 35 */       CatBestPartnerInfo xCatBestPartnerInfo = Catbestpartner.get(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 36 */       int oldPartnerCfgid = xCatBestPartnerInfo.getPartner_cfgid();
/* 37 */       int partnerCfgid = CatManager.randomBestPartner();
/* 38 */       if (partnerCfgid < 0)
/*    */       {
/* 40 */         GameServer.logger().error(String.format("[cat]PUpdateBestPartner.processImp@random best partner failed|old_partner_cfgid=%d|partner_cfgid=%d", new Object[] { Integer.valueOf(oldPartnerCfgid), Integer.valueOf(partnerCfgid) }));
/*    */         
/*    */ 
/*    */ 
/* 44 */         return false;
/*    */       }
/* 46 */       xCatBestPartnerInfo.setPartner_cfgid(partnerCfgid);
/* 47 */       xCatBestPartnerInfo.setLast_timestamp(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/*    */       
/*    */ 
/* 50 */       BestPartner.getInstance().setPartnerCfgid(partnerCfgid);
/*    */       
/* 52 */       GameServer.logger().info(String.format("[cat]PUpdateBestPartner.processImp@update best partner|old_partner_cfgid=%d|partner_cfgid=%d", new Object[] { Integer.valueOf(oldPartnerCfgid), Integer.valueOf(partnerCfgid) }));
/*    */       
/*    */ 
/*    */ 
/* 56 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\main\BestPartnerObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */