/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.CGangDismissReq;
/*    */ import mzm.gsp.gang.SGangNormalResult;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.GangGlobal;
/*    */ import xbean.GangMember;
/*    */ 
/*    */ public class PCGangDismissReq extends GangProcedure<CGangDismissReq>
/*    */ {
/*    */   public PCGangDismissReq(CGangDismissReq protocol)
/*    */   {
/* 14 */     super(protocol);
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean doProcess(long roleId, CGangDismissReq protocol)
/*    */   {
/* 20 */     GangMember xGangMember = xtable.Role2gangmember.get(Long.valueOf(roleId));
/* 21 */     if (null == xGangMember)
/*    */     {
/* 23 */       SGangNormalResult result = new SGangNormalResult();
/* 24 */       result.result = 45;
/* 25 */       OnlineManager.getInstance().sendAtOnce(roleId, result);
/*    */       
/* 27 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 31 */     String userId = RoleInterface.getUserId(roleId);
/* 32 */     int roleLevel = RoleInterface.getLevel(roleId);
/*    */     
/* 34 */     long gangid = xGangMember.getGangid();
/*    */     
/* 36 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangid));
/* 37 */     if (null == xGang) {
/* 38 */       SGangNormalResult result = new SGangNormalResult();
/* 39 */       result.result = 46;
/* 40 */       OnlineManager.getInstance().sendAtOnce(roleId, result);
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     if (!GangManager.isInGang(xGang, roleId)) {
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     if (xGang.getBangzhuid() != roleId) {
/* 49 */       SGangNormalResult result = new SGangNormalResult();
/* 50 */       result.result = 48;
/* 51 */       OnlineManager.getInstance().sendAtOnce(roleId, result);
/* 52 */       return false;
/*    */     }
/*    */     
/* 55 */     if (GangManager.getMemberSize(xGang) > 1) {
/* 56 */       SGangNormalResult result = new SGangNormalResult();
/* 57 */       result.result = 48;
/* 58 */       OnlineManager.getInstance().sendAtOnce(roleId, result);
/* 59 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 63 */     xbean.GangMemoryBean xGangMemory = GangManager.getXGangMemory(gangid, true);
/*    */     
/*    */ 
/* 66 */     GangGlobal xGlobal = GangManager.getXGlobal(true);
/*    */     
/* 68 */     boolean ret = GangManager.dissolveGangAndTlog(gangid, xGang, xGangMemory, xGlobal, userId, roleLevel);
/* 69 */     if (ret)
/*    */     {
/* 71 */       SGangNormalResult result = new SGangNormalResult();
/* 72 */       result.result = 47;
/* 73 */       OnlineManager.getInstance().sendAtOnce(roleId, result);
/*    */     }
/*    */     
/* 76 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PCGangDismissReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */