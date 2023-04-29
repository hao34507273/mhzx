/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.CGetYaoDianInfoReq;
/*    */ import mzm.gsp.gang.SYaoDianInfoRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.GangMember;
/*    */ import xbean.YaoDian;
/*    */ 
/*    */ public class PGetYaoDianInfoReq extends GangProcedure<CGetYaoDianInfoReq>
/*    */ {
/*    */   public PGetYaoDianInfoReq(CGetYaoDianInfoReq protocol)
/*    */   {
/* 13 */     super(protocol);
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean doProcess(long roleId, CGetYaoDianInfoReq protocol)
/*    */   {
/* 19 */     GangMember xMember = xtable.Role2gangmember.get(Long.valueOf(roleId));
/* 20 */     if (xMember == null) {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(xMember.getGangid()));
/* 25 */     if ((xGang == null) || (!GangManager.isInGang(xGang, roleId))) {
/* 26 */       return false;
/*    */     }
/* 28 */     YaoDian xYaoDian = xGang.getYaodian();
/* 29 */     SYaoDianInfoRes res = new SYaoDianInfoRes();
/* 30 */     GangManager.fillYaoDian(xYaoDian, res.yaodianinfo);
/* 31 */     OnlineManager.getInstance().send(roleId, res);
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PGetYaoDianInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */