/*    */ package mzm.gsp.partner.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.partner.event.ChangePartnerZhenFaIdArg.ChangeZhenFaIdType;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PChangeZhenFaReq extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int lineUpNum;
/*    */   private final int zhenFaId;
/*    */   
/*    */   public PChangeZhenFaReq(long roleId, int lineUpNum, int zhenFaId)
/*    */   {
/* 22 */     this.roleId = roleId;
/* 23 */     this.lineUpNum = lineUpNum;
/* 24 */     this.zhenFaId = zhenFaId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     String userid = RoleInterface.getUserId(this.roleId);
/* 32 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 34 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 35 */     if (!canActiveChangeZhenFaInStatus(this.roleId))
/*    */     {
/* 37 */       return false;
/*    */     }
/* 39 */     return PartnerManager.onChangeZhenFaReq(this.roleId, this.lineUpNum, this.zhenFaId, ChangePartnerZhenFaIdArg.ChangeZhenFaIdType.PARTNER);
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
/*    */   private boolean canActiveChangeZhenFaInStatus(long roleId)
/*    */   {
/* 53 */     if (!RoleStatusInterface.checkCanSetStatus(roleId, 63, true))
/*    */     {
/* 55 */       GameServer.logger().error(String.format("[parnter]PChangeZhenFaReq.canActiveChangeZhenFaInStatus@ active ChangeZhenFa is forbiddened!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*    */       
/*    */ 
/*    */ 
/* 59 */       return false;
/*    */     }
/* 61 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\PChangeZhenFaReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */