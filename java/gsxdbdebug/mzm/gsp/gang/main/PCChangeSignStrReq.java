/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.CChangeSignStrReq;
/*    */ import mzm.gsp.gang.SChangeSignStrReq;
/*    */ import mzm.gsp.gang.SGangNormalResult;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.sensitive.main.SensitiveInterface;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ public class PCChangeSignStrReq extends GangProcedure<CChangeSignStrReq>
/*    */ {
/*    */   public PCChangeSignStrReq(CChangeSignStrReq protocol)
/*    */   {
/* 15 */     super(protocol);
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean doProcess(long roleId, CChangeSignStrReq protocol)
/*    */   {
/* 21 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(roleId));
/*    */     
/* 23 */     if (xGangMember == null) {
/* 24 */       SChangeSignStrReq result = new SChangeSignStrReq();
/* 25 */       result.result = 0;
/* 26 */       result.signstr = "";
/* 27 */       OnlineManager.getInstance().sendAtOnce(roleId, result);
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(xGangMember.getGangid()));
/* 32 */     if (xGang == null) {
/* 33 */       return false;
/*    */     }
/* 35 */     if (!GangManager.isInGang(xGang, roleId)) {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     if (SensitiveInterface.isContentSensitive(protocol.signstr))
/*    */     {
/* 41 */       SChangeSignStrReq sChangeSignStrReq = new SChangeSignStrReq();
/* 42 */       sChangeSignStrReq.result = 0;
/* 43 */       sChangeSignStrReq.signstr = "";
/* 44 */       OnlineManager.getInstance().sendAtOnce(roleId, sChangeSignStrReq);
/*    */       
/* 46 */       SGangNormalResult result = new SGangNormalResult();
/* 47 */       result.result = 54;
/* 48 */       OnlineManager.getInstance().sendAtOnce(roleId, result);
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     xGangMember.setSignstr(protocol.signstr);
/*    */     
/* 54 */     SChangeSignStrReq result = new SChangeSignStrReq();
/* 55 */     result.result = 1;
/* 56 */     result.signstr = protocol.signstr;
/* 57 */     OnlineManager.getInstance().sendAtOnce(roleId, result);
/*    */     
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PCChangeSignStrReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */