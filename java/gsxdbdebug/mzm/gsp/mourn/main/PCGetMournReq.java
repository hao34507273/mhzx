/*    */ package mzm.gsp.mourn.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCGetMournReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PCGetMournReq(long roleId)
/*    */   {
/* 21 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     if (!MournManager.isMournOpen())
/*    */     {
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     String userId = RoleInterface.getUserId(this.roleId);
/* 33 */     lock(Lockeys.get(User.getTable(), userId));
/*    */     
/* 35 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 36 */     MournManager.checkAndSynMournInfo(userId, this.roleId);
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mourn\main\PCGetMournReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */