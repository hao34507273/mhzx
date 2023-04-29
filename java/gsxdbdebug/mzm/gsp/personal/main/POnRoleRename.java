/*    */ package mzm.gsp.personal.main;
/*    */ 
/*    */ import mzm.gsp.personal.confbean.SNSConsts;
/*    */ import mzm.gsp.role.event.RoleRenameProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.PersonalInfo;
/*    */ 
/*    */ public class POnRoleRename extends RoleRenameProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     long roleId = ((Long)this.arg).longValue();
/* 13 */     if (RoleInterface.getLevel(roleId) < SNSConsts.getInstance().OPEN_LEVEL)
/*    */     {
/* 15 */       return true;
/*    */     }
/*    */     
/* 18 */     PersonalInfo xPersonalInfo = xtable.Role2personal.get((Long)this.arg);
/* 19 */     if (xPersonalInfo == null)
/*    */     {
/* 21 */       return true;
/*    */     }
/* 23 */     if (xPersonalInfo.getAdverts().isEmpty())
/*    */     {
/* 25 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 29 */     String newName = RoleInterface.getName(roleId);
/* 30 */     UpdateCacheOneByOne.getInstance().add(new RUpdateName(((Long)this.arg).longValue(), newName));
/*    */     
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   private static class RUpdateName extends mzm.gsp.util.LogicRunnable
/*    */   {
/*    */     private final long roleId;
/*    */     private final String newName;
/*    */     
/*    */     public RUpdateName(long roleId, String newName)
/*    */     {
/* 42 */       this.roleId = roleId;
/* 43 */       this.newName = newName;
/*    */     }
/*    */     
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 49 */       AdvertDataCache.getInstance().roleNameChange(this.roleId, this.newName);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\POnRoleRename.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */