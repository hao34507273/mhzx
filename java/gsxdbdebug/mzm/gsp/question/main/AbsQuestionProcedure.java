/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xio.Protocol;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbsQuestionProcedure<T extends Protocol>
/*    */   extends LogicProcedure
/*    */ {
/*    */   protected long roleId;
/*    */   protected T protocol;
/*    */   
/*    */   public AbsQuestionProcedure(T protocol)
/*    */   {
/* 17 */     this.protocol = protocol;
/* 18 */     this.roleId = Role.getRoleId(protocol);
/* 19 */     if (this.roleId < 0L)
/*    */     {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(this.roleId, this);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\AbsQuestionProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */