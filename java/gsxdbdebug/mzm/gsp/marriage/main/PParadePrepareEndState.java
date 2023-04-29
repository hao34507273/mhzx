/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import mzm.gsp.marriage.SParadePrepareEndStageRes;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import xbean.MarriageParade;
/*    */ import xbean.MarriageParades;
/*    */ 
/*    */ public class PParadePrepareEndState extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PParadePrepareEndState(long roleid)
/*    */   {
/* 14 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     MarriageParades xMarriageParades = xtable.Marriageparade.select(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 20 */     if ((xMarriageParades == null) || (xMarriageParades.getMarriageparades().size() <= 0)) {
/* 21 */       sendResult(this.roleid, 2);
/* 22 */       return false;
/*    */     }
/* 24 */     MarriageParade xMarriageParade = (MarriageParade)xMarriageParades.getMarriageparades().get(0);
/* 25 */     if ((this.roleid != xMarriageParade.getRoleid1()) || (this.roleid != xMarriageParade.getRoleid2())) {
/* 26 */       sendResult(this.roleid, 2);
/* 27 */       return false;
/*    */     }
/* 29 */     if ((!OpenInterface.getOpenStatus(128)) || (OpenInterface.isBanPlay(this.roleid, 128)))
/*    */     {
/* 31 */       OpenInterface.sendBanPlayMsg(this.roleid, 128);
/* 32 */       return false;
/*    */     }
/* 34 */     ParadePrepareSession.stopParadePrepareSession();
/* 35 */     sendResult(this.roleid, 1);
/* 36 */     return true;
/*    */   }
/*    */   
/*    */   private void sendResult(long roleid, int ret) {
/* 40 */     SParadePrepareEndStageRes paradePrepareEndStageRes = new SParadePrepareEndStageRes();
/* 41 */     paradePrepareEndStageRes.result = ret;
/* 42 */     mzm.gsp.online.main.OnlineManager.getInstance().send(roleid, paradePrepareEndStageRes);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\PParadePrepareEndState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */