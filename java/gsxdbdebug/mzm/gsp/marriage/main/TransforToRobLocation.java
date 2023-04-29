/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import mzm.gsp.map.main.PTransformMapReq;
/*    */ import mzm.gsp.marriage.STransforToRobLocationRes;
/*    */ import mzm.gsp.marriage.confbean.SMarriageParadeCfg;
/*    */ import xbean.MarriageParade;
/*    */ import xbean.MarriageParades;
/*    */ 
/*    */ public class TransforToRobLocation extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public TransforToRobLocation(long roleid)
/*    */   {
/* 15 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     MarriageParades xMarriageParades = xtable.Marriageparade.get(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 21 */     if ((xMarriageParades == null) || (xMarriageParades.getMarriageparades().size() <= 0)) {
/* 22 */       sendError(1);
/* 23 */       return false;
/*    */     }
/* 25 */     MarriageParade xMarriageParade = (MarriageParade)xMarriageParades.getMarriageparades().get(0);
/* 26 */     int cfgid = xMarriageParade.getLevel();
/* 27 */     SMarriageParadeCfg marriageParadeCfg = SMarriageParadeCfg.get(cfgid);
/* 28 */     new PTransformMapReq(this.roleid, marriageParadeCfg.paradeMapid, 0, 0).execute();
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   private void sendError(int errorid) {
/* 33 */     STransforToRobLocationRes transforToRobLocationRes = new STransforToRobLocationRes();
/* 34 */     transforToRobLocationRes.result = errorid;
/* 35 */     mzm.gsp.online.main.OnlineManager.getInstance().sendAtOnce(this.roleid, transforToRobLocationRes);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\TransforToRobLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */