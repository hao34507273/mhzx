/*    */ package mzm.gsp.festival.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.FestivalAwardOwnCfg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.FestivalAward;
/*    */ 
/*    */ public class PCFestivalInfoReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PCFestivalInfoReq(long roleid)
/*    */   {
/* 13 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     FestivalAwardOwnCfg festivalAwardOwnCfg = FestivalManager.getCurrentFestivalAwardCfg();
/* 19 */     mzm.gsp.festival.SFestivalInfoRes sFestivalInfoRes = new mzm.gsp.festival.SFestivalInfoRes();
/* 20 */     if (festivalAwardOwnCfg == null) {
/* 21 */       OnlineManager.getInstance().sendAtOnce(this.roleid, sFestivalInfoRes);
/* 22 */       return false;
/*    */     }
/* 24 */     sFestivalInfoRes.festivalawardid = festivalAwardOwnCfg.cfgid;
/* 25 */     sFestivalInfoRes.awardstate = 0;
/* 26 */     FestivalAward festivalAward = xtable.Role2festivalaward.get(Long.valueOf(this.roleid));
/* 27 */     if ((festivalAward != null) && (festivalAward.getLastestawardedcfgid() == festivalAwardOwnCfg.cfgid)) {
/* 28 */       sFestivalInfoRes.awardstate = 1;
/*    */     }
/* 30 */     OnlineManager.getInstance().send(this.roleid, sFestivalInfoRes);
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\festival\main\PCFestivalInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */