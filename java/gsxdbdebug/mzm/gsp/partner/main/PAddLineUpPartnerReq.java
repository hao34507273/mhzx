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
/*    */ public class PAddLineUpPartnerReq extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int partnerId;
/*    */   private final int lineUpNum;
/*    */   
/*    */   public PAddLineUpPartnerReq(long roleId, int partnerId, int lineUpNum)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.partnerId = partnerId;
/* 23 */     this.lineUpNum = lineUpNum;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     String userid = RoleInterface.getUserId(this.roleId);
/* 31 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 33 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 34 */     if (!canActiveLineupPartnerInStatus(this.roleId))
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     return PartnerManager.onAddLineUpPartner(this.roleId, this.partnerId, this.lineUpNum);
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
/*    */   private boolean canActiveLineupPartnerInStatus(long roleId)
/*    */   {
/* 52 */     if (!RoleStatusInterface.checkCanSetStatus(roleId, 57, true))
/*    */     {
/* 54 */       GameServer.logger().error(String.format("[parnter]PAddLineUpPartnerReq.canActiveActiveLineupPartnerInStatus@ active line up partner is forbiddened!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*    */       
/*    */ 
/*    */ 
/* 58 */       return false;
/*    */     }
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\PAddLineUpPartnerReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */