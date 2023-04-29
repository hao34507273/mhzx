/*    */ package mzm.gsp.grow.daytarget;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.grow.confbean.TargetConsts;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_InitTarget
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_InitTarget(long roleId)
/*    */   {
/* 19 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     RoleDayInfo roleDayInfo = new RoleDayInfo(this.roleId, true);
/* 26 */     if (!roleDayInfo.hasXData())
/*    */     {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     DayTargetManager.flushNewTargets(roleDayInfo, 3);
/*    */     
/* 33 */     if (roleDayInfo.getAllTarget().size() == 0)
/*    */     {
/* 35 */       GameServer.logger().error(String.format("[dayTarget]DayTargetActivityHandler.initRoleData@ targets num not enough!|needNum=%d|ownNum=%d", new Object[] { Integer.valueOf(TargetConsts.getInstance().FLUSH_NUM), Integer.valueOf(roleDayInfo.getAllTarget().size()) }));
/*    */       
/*    */ 
/*    */ 
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     DayTargetManager.synAllTargets(roleDayInfo);
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\daytarget\PGM_InitTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */