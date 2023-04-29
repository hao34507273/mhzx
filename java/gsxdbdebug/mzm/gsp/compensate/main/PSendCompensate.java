/*    */ package mzm.gsp.compensate.main;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PSendCompensate extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final CompensateInfo compensateInfo;
/*    */   
/*    */   public PSendCompensate(long roleid, CompensateInfo compensateInfo)
/*    */   {
/* 14 */     this.roleid = roleid;
/* 15 */     this.compensateInfo = compensateInfo;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     String userid = RoleInterface.getUserId(this.roleid);
/* 22 */     lock(xdb.Lockeys.get(User.getTable(), userid));
/*    */     
/* 24 */     int roleLevel = RoleInterface.getLevel(this.roleid);
/* 25 */     if ((roleLevel < this.compensateInfo.minLevel) || (roleLevel > this.compensateInfo.maxLevel))
/*    */     {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     long createRoleTime = RoleInterface.getRoleCreateTime(this.roleid);
/* 31 */     if (this.compensateInfo.minCreateRoleTime > 0L)
/*    */     {
/* 33 */       if (createRoleTime < this.compensateInfo.minCreateRoleTime)
/*    */       {
/* 35 */         return false;
/*    */       }
/*    */     }
/*    */     
/* 39 */     if (this.compensateInfo.maxCreateRoleTime > 0L)
/*    */     {
/* 41 */       if (createRoleTime > this.compensateInfo.maxCreateRoleTime)
/*    */       {
/* 43 */         return false;
/*    */       }
/*    */     }
/*    */     
/* 47 */     return CompensateManager.trySendCompensateMail(userid, this.roleid, this.compensateInfo);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\compensate\main\PSendCompensate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */