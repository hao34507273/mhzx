/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pubdata.ModelInfo;
/*    */ import mzm.gsp.role.SSendRoleModelInfo;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Role2properties;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGetRoleModleInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long targetRoleId;
/*    */   
/*    */   public PGetRoleModleInfo(long roleId, long targetRoleId)
/*    */   {
/* 24 */     this.roleId = roleId;
/* 25 */     this.targetRoleId = targetRoleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     if (Role2properties.select(Long.valueOf(this.targetRoleId)) == null)
/*    */     {
/* 34 */       return false;
/*    */     }
/* 36 */     SSendRoleModelInfo pro = new SSendRoleModelInfo();
/* 37 */     fillModelInfo(pro);
/* 38 */     OnlineManager.getInstance().send(this.roleId, pro);
/* 39 */     return true;
/*    */   }
/*    */   
/*    */   private void fillModelInfo(SSendRoleModelInfo pro)
/*    */   {
/* 44 */     Role targetRole = RoleInterface.getRole(this.targetRoleId, false);
/* 45 */     ModelInfo modelInfo = new ModelInfo();
/* 46 */     targetRole.fillModelInfo(modelInfo);
/* 47 */     pro.targetroleid = this.targetRoleId;
/* 48 */     pro.model = modelInfo;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PGetRoleModleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */