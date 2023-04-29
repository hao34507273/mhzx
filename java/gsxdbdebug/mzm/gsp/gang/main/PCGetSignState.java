/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.CGetSignState;
/*    */ import mzm.gsp.gang.SGangNormalResult;
/*    */ import mzm.gsp.gang.SGetSignState;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ public class PCGetSignState extends GangProcedure<CGetSignState>
/*    */ {
/*    */   public PCGetSignState(CGetSignState protocol)
/*    */   {
/* 14 */     super(protocol);
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean doProcess(long roleId, CGetSignState protocol)
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
/* 38 */     if (!GangManager.isInGang(xGang, roleId)) {
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     SGetSignState result = new SGetSignState();
/* 43 */     result.state = GangManager.checkGangSign(roleId, xGangMember);
/* 44 */     OnlineManager.getInstance().sendAtOnce(roleId, result);
/*    */     
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PCGetSignState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */