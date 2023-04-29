/*    */ package mzm.gsp.cat.main;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.cat.confbean.SCatCfgConsts;
/*    */ import mzm.gsp.common.TimeCommonUtil;
/*    */ import mzm.gsp.common.confbean.STimeCommonCfg;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.CatBestPartnerInfo;
/*    */ import xtable.Catbestpartner;
/*    */ 
/*    */ public class PBestPartnerInit extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 19 */     STimeCommonCfg sTimeCommonCfg = TimeCommonUtil.getCommonCfg(SCatCfgConsts.getInstance().FEED_CLEAR_TIME);
/* 20 */     long todayResetTime = DateTimeUtils.getDailyResetTime(now, sTimeCommonCfg.activeHour, sTimeCommonCfg.activeMinute);
/*    */     
/*    */ 
/* 23 */     int partnerCfgid = 0;
/* 24 */     CatBestPartnerInfo xCatBestPartnerInfo = Catbestpartner.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 25 */     if (xCatBestPartnerInfo == null)
/*    */     {
/* 27 */       xCatBestPartnerInfo = xbean.Pod.newCatBestPartnerInfo();
/* 28 */       Catbestpartner.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xCatBestPartnerInfo);
/*    */     }
/*    */     else
/*    */     {
/* 32 */       long lastUpdateTime = xCatBestPartnerInfo.getLast_timestamp();
/* 33 */       if (lastUpdateTime >= todayResetTime)
/*    */       {
/* 35 */         partnerCfgid = xCatBestPartnerInfo.getPartner_cfgid();
/*    */       }
/*    */     }
/*    */     
/* 39 */     if (partnerCfgid == 0)
/*    */     {
/* 41 */       partnerCfgid = CatManager.randomBestPartner();
/* 42 */       if (partnerCfgid < 0)
/*    */       {
/* 44 */         GameServer.logger().error(String.format("[cat]PBestPartnerInit.processImp@random best partner failed|partner_cfgid=%d", new Object[] { Integer.valueOf(partnerCfgid) }));
/*    */         
/*    */ 
/* 47 */         return false;
/*    */       }
/*    */       
/* 50 */       xCatBestPartnerInfo.setPartner_cfgid(partnerCfgid);
/* 51 */       xCatBestPartnerInfo.setLast_timestamp(now);
/*    */     }
/*    */     
/* 54 */     BestPartner.getInstance().setPartnerCfgid(partnerCfgid);
/*    */     
/* 56 */     long nextUpdateTime = now < todayResetTime ? todayResetTime : todayResetTime + 86400000L;
/* 57 */     long delaySeconds = TimeUnit.MILLISECONDS.toSeconds(nextUpdateTime - now);
/* 58 */     new BestPartnerObserver(delaySeconds, 86400L);
/*    */     
/* 60 */     GameServer.logger().info(String.format("[cat]PBestPartnerInit.processImp@best partner init|partner_cfgid=%d|delay=%d|now=%d", new Object[] { Integer.valueOf(partnerCfgid), Long.valueOf(delaySeconds), Long.valueOf(now) }));
/*    */     
/*    */ 
/*    */ 
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\main\PBestPartnerInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */