/*    */ package mzm.gsp.title.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PReplaceAppArgs
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int appId;
/*    */   private final List<String> args;
/*    */   
/*    */   public PReplaceAppArgs(long roleId, int appId, List<String> args)
/*    */   {
/* 19 */     this.roleId = roleId;
/* 20 */     this.appId = appId;
/* 21 */     this.args = args;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 26 */     return TitleManager.rpAppArgs(this.roleId, this.appId, this.args);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\main\PReplaceAppArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */