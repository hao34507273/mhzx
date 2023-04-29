/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.SSyncRoleFightProp;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGMShowFightPropertyCmd
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGMShowFightPropertyCmd(long roleId)
/*    */   {
/* 14 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     RoleOutFightObj role = RoleInterface.getRoleOutFightObject(this.roleId);
/* 21 */     if (role == null)
/*    */     {
/* 23 */       return false;
/*    */     }
/* 25 */     SSyncRoleFightProp ssyncfightProp = new SSyncRoleFightProp();
/* 26 */     role.fillSelfFixFightProperty(ssyncfightProp.fightpropmap);
/* 27 */     OnlineManager.getInstance().send(this.roleId, ssyncfightProp);
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PGMShowFightPropertyCmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */