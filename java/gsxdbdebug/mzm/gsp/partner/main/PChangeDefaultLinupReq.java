/*    */ package mzm.gsp.partner.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PChangeDefaultLinupReq extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int lineUpNum;
/*    */   
/*    */   public PChangeDefaultLinupReq(long roleId, int lineUpNum)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.lineUpNum = lineUpNum;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     String userid = RoleInterface.getUserId(this.roleId);
/* 29 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 31 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 32 */     if (!canActiveChangeDefaultLinupInStatus(this.roleId))
/*    */     {
/* 34 */       return false;
/*    */     }
/* 36 */     return PartnerManager.onChangeDefaultLinupReq(this.roleId, this.lineUpNum);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private boolean canActiveChangeDefaultLinupInStatus(long roleId)
/*    */   {
/* 50 */     if (!RoleStatusInterface.checkCanSetStatus(roleId, 59, true))
/*    */     {
/* 52 */       GameServer.logger().error(String.format("[parnter]PChangeDefaultLinupReq.canActiveChangeDefaultLinupInStatus@ active ChangeDefaultLinup is forbiddened!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*    */       
/*    */ 
/*    */ 
/* 56 */       return false;
/*    */     }
/* 58 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\PChangeDefaultLinupReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */