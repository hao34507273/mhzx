/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import mzm.gsp.marriage.SParadeRobStageRes;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import xbean.MarriageParade;
/*    */ import xbean.MarriageParades;
/*    */ 
/*    */ public class PParadeRobStage extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PParadeRobStage(long roleid)
/*    */   {
/* 14 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     if ((!OpenInterface.getOpenStatus(128)) || (OpenInterface.isBanPlay(this.roleid, 128)))
/*    */     {
/* 21 */       OpenInterface.sendBanPlayMsg(this.roleid, 128);
/* 22 */       return false;
/*    */     }
/* 24 */     MarriageParades xMarriageParades = xtable.Marriageparade.get(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 25 */     if ((xMarriageParades == null) || (xMarriageParades.getMarriageparades().size() <= 0)) {
/* 26 */       sendResult(this.roleid, 2);
/* 27 */       return false;
/*    */     }
/* 29 */     MarriageParade xMarriageParade = (MarriageParade)xMarriageParades.getMarriageparades().get(0);
/* 30 */     if (xMarriageParade.getCanrob()) {
/* 31 */       sendResult(this.roleid, 1);
/*    */     } else {
/* 33 */       sendResult(this.roleid, 2);
/*    */     }
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   private void sendResult(long roleid, int errorid) {
/* 39 */     SParadeRobStageRes sParadeRobStageRes = new SParadeRobStageRes();
/* 40 */     sParadeRobStageRes.result = errorid;
/* 41 */     mzm.gsp.online.main.OnlineManager.getInstance().sendAtOnce(roleid, sParadeRobStageRes);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\PParadeRobStage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */