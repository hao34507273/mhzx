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
/*    */ public class POnShuffleLovesReq extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int partnerId;
/*    */   
/*    */   public POnShuffleLovesReq(long roleId, int partnerId)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.partnerId = partnerId;
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
/* 32 */     if (!canActiveShuffleLovesInStatus(this.roleId))
/*    */     {
/* 34 */       return false;
/*    */     }
/* 36 */     return PartnerManager.onShuffleLovesReq(this.roleId, this.partnerId);
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
/*    */   private boolean canActiveShuffleLovesInStatus(long roleId)
/*    */   {
/* 50 */     if (!RoleStatusInterface.checkCanSetStatus(roleId, 60, true))
/*    */     {
/* 52 */       GameServer.logger().error(String.format("[parnter]POnShuffleLovesReq.canActiveShuffleLovesInStatus@ active ShuffleLoves is forbiddened!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*    */       
/*    */ 
/*    */ 
/* 56 */       return false;
/*    */     }
/* 58 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\POnShuffleLovesReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */