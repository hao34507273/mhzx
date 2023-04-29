/*    */ package mzm.gsp.festival.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.FestivalAwardOwnCfg;
/*    */ import mzm.gsp.festival.SNextFestivalInfoRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ public class PCNextFestivalInfoReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PCNextFestivalInfoReq(long roleid)
/*    */   {
/* 13 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     SNextFestivalInfoRes nextFestivalInfoRes = new SNextFestivalInfoRes();
/* 19 */     FestivalAwardOwnCfg nextAwardCfg = FestivalManager.getNextFestivalAwardCfg();
/* 20 */     if (nextAwardCfg != null) {
/* 21 */       nextFestivalInfoRes.festivalawardid = nextAwardCfg.cfgid;
/*    */     }
/* 23 */     OnlineManager.getInstance().send(this.roleid, nextFestivalInfoRes);
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\festival\main\PCNextFestivalInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */