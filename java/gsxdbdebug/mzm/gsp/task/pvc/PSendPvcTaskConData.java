/*    */ package mzm.gsp.task.pvc;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.main.RoleTaskManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class PSendPvcTaskConData
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int graphId;
/*    */   private final int taskId;
/*    */   private final int conId;
/*    */   private final long param;
/*    */   
/*    */   public PSendPvcTaskConData(long roleId, int graphId, int taskId, int conId, long param)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.graphId = graphId;
/* 22 */     this.taskId = taskId;
/* 23 */     this.conId = conId;
/* 24 */     this.param = param;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     String name = "";
/* 32 */     if (this.param > 0L)
/*    */     {
/* 34 */       name = RoleInterface.getName(this.param);
/* 35 */       if ((name == null) || (name.equals("")))
/*    */       {
/* 37 */         return false;
/*    */       }
/*    */     }
/*    */     
/* 41 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 42 */     RoleTaskManager.sendConChangeMsg(this.roleId, this.graphId, this.taskId, this.conId, this.param, name);
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\pvc\PSendPvcTaskConData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */