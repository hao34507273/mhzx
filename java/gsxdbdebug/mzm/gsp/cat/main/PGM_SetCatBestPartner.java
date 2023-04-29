/*    */ package mzm.gsp.cat.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.cat.confbean.SCatPartnerCfg;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.CatBestPartnerInfo;
/*    */ import xtable.Catbestpartner;
/*    */ 
/*    */ public class PGM_SetCatBestPartner extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final int partner_cfgid;
/*    */   
/*    */   public PGM_SetCatBestPartner(long gmRoleid, int partner_cfgid)
/*    */   {
/* 16 */     this.gmRoleid = gmRoleid;
/* 17 */     this.partner_cfgid = partner_cfgid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     SCatPartnerCfg catPartnerCfg = SCatPartnerCfg.get(this.partner_cfgid);
/* 24 */     if (catPartnerCfg == null)
/*    */     {
/* 26 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, "仙侣配置不存在");
/* 27 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 31 */     CatBestPartnerInfo xCatBestPartnerInfo = Catbestpartner.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 32 */     if (xCatBestPartnerInfo == null)
/*    */     {
/* 34 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, "系统错误");
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     xCatBestPartnerInfo.setPartner_cfgid(this.partner_cfgid);
/* 39 */     BestPartner.getInstance().setPartnerCfgid(this.partner_cfgid);
/*    */     
/* 41 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, "设置今日最佳仙侣成功");
/*    */     
/* 43 */     mzm.gsp.GameServer.logger().info(String.format("[gm]PGM_SetCatBestPartner.processImp@set beat partner success|gm_roleid=%d|partner_cfgid=%d", new Object[] { Long.valueOf(this.gmRoleid), Integer.valueOf(this.partner_cfgid) }));
/*    */     
/*    */ 
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\main\PGM_SetCatBestPartner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */