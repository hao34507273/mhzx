/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.CGetGangQQGroupReq;
/*    */ import mzm.gsp.gang.SGangNormalResult;
/*    */ import mzm.gsp.gang.SSyncGangQQGroupRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ public class PCGetGangQQGroupReq extends GangProcedure<CGetGangQQGroupReq>
/*    */ {
/*    */   public PCGetGangQQGroupReq(CGetGangQQGroupReq protocol)
/*    */   {
/* 14 */     super(protocol);
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean doProcess(long roleId, CGetGangQQGroupReq protocol)
/*    */   {
/* 20 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(roleId));
/* 21 */     if (null == xGangMember)
/*    */     {
/* 23 */       SGangNormalResult result = new SGangNormalResult();
/* 24 */       result.result = 45;
/* 25 */       OnlineManager.getInstance().sendAtOnce(roleId, result);
/*    */       
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(xGangMember.getGangid()));
/* 31 */     if (null == xGang) {
/* 32 */       SGangNormalResult result = new SGangNormalResult();
/* 33 */       result.result = 46;
/* 34 */       OnlineManager.getInstance().sendAtOnce(roleId, result);
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     if (!GangManager.isInGang(xGang, roleId))
/*    */     {
/* 40 */       SGangNormalResult result = new SGangNormalResult();
/* 41 */       result.result = 45;
/* 42 */       OnlineManager.getInstance().sendAtOnce(roleId, result);
/*    */       
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     SSyncGangQQGroupRes syncresult = new SSyncGangQQGroupRes();
/* 48 */     syncresult.groupopenid = xGang.getGroupopenid();
/* 49 */     OnlineManager.getInstance().send(roleId, syncresult);
/*    */     
/* 51 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PCGetGangQQGroupReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */