/*    */ package mzm.gsp.fashiondress.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PRefreshBuff
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PRefreshBuff(long roleid)
/*    */   {
/* 18 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     String userid = RoleInterface.getUserId(this.roleid);
/*    */     
/* 26 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/* 28 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*    */     
/* 30 */     FashionDressManager.refreshTimeLimitedThemeFashionDressBuff(this.roleid);
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\main\PRefreshBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */