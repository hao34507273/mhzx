/*    */ package mzm.gsp.grow.daytarget;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.grow.confbean.TargetConsts;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PRoleLvUp extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int oldLv;
/*    */   private final int newLv;
/*    */   
/*    */   public PRoleLvUp(long roleId, int oldLv, int newLv)
/*    */   {
/* 18 */     this.roleId = roleId;
/* 19 */     this.oldLv = oldLv;
/* 20 */     this.newLv = newLv;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     if (!DayTargetManager.needOpenDayTarget(this.newLv, this.oldLv))
/*    */     {
/* 28 */       return false;
/*    */     }
/* 30 */     String userId = RoleInterface.getUserId(this.roleId);
/*    */     
/* 32 */     lock(Lockeys.get(User.getTable(), userId));
/*    */     
/* 34 */     RoleDayInfo roleDayInfo = new RoleDayInfo(this.roleId, true);
/*    */     
/* 36 */     if (!roleDayInfo.hasXData())
/*    */     {
/* 38 */       roleDayInfo.createDayInfo();
/*    */     }
/* 40 */     new PRefreshenTarget().execute();
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   class PRefreshenTarget extends LogicProcedure
/*    */   {
/*    */     PRefreshenTarget() {}
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 50 */       String userId = RoleInterface.getUserId(PRoleLvUp.this.roleId);
/*    */       
/* 52 */       lock(Lockeys.get(User.getTable(), userId));
/*    */       
/* 54 */       RoleDayInfo roleDayInfo = new RoleDayInfo(PRoleLvUp.this.roleId, true);
/* 55 */       DayTargetManager.flushNewTargets(roleDayInfo, 1);
/* 56 */       if (roleDayInfo.getAllTarget().size() == 0)
/*    */       {
/* 58 */         mzm.gsp.GameServer.logger().error(String.format("[dayTarget]POnRoleLogin.processImp@ targets num not enough!|needNum=%d|ownNum=%d", new Object[] { Integer.valueOf(TargetConsts.getInstance().FLUSH_NUM), Integer.valueOf(roleDayInfo.getAllTarget().size()) }));
/*    */         
/*    */ 
/* 61 */         return false;
/*    */       }
/*    */       
/* 64 */       DayTargetManager.synAllTargets(roleDayInfo);
/* 65 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\daytarget\PRoleLvUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */