/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.SGetRoleInfoRes;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGetRoleInfoReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long targetId;
/*    */   
/*    */   public PGetRoleInfoReq(long roleId, long targetId)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.targetId = targetId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     int errCode = isRoleInfoValid();
/* 29 */     if (errCode > 0)
/*    */     {
/* 31 */       RoleModuleManager.sendSCommonResultRes(this.roleId, errCode, true);
/* 32 */       return false;
/*    */     }
/* 34 */     SGetRoleInfoRes res = new SGetRoleInfoRes();
/* 35 */     RoleInterface.fillRoleInfo(this.targetId, res.roleinfo);
/* 36 */     OnlineManager.getInstance().send(this.roleId, res);
/* 37 */     return true;
/*    */   }
/*    */   
/*    */   private int isRoleInfoValid()
/*    */   {
/* 42 */     boolean isRoleExist = RoleInterface.isRoleExist(this.targetId, false);
/* 43 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 45 */       if ((!isRoleExist) || (!OnlineManager.getInstance().isOnline(this.targetId)))
/*    */       {
/* 47 */         return 21;
/*    */       }
/*    */       
/*    */ 
/*    */     }
/* 52 */     else if (!isRoleExist)
/*    */     {
/* 54 */       return 20;
/*    */     }
/*    */     
/* 57 */     return -1;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PGetRoleInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */