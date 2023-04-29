/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import mzm.gsp.role.event.RoleLevelUpProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.confbean.SGraph;
/*    */ 
/*    */ public class POnRoleLevelUp
/*    */   extends RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     Long roleId = Long.valueOf(((RoleLevelUpArg)this.arg).roleId);
/* 14 */     if (roleId == null)
/*    */     {
/* 16 */       return false;
/*    */     }
/* 18 */     int oldLv = ((RoleLevelUpArg)this.arg).oldLevel;
/* 19 */     int curLv = ((RoleLevelUpArg)this.arg).newLevel;
/* 20 */     TaskInterface.updateTaskCondition(roleId.longValue(), 1, new Object());
/*    */     
/* 22 */     for (Graph graph : GraphManager.getInstance().getAllCondtionGraph())
/*    */     {
/* 24 */       if (isWithinLvs(oldLv, curLv, graph.getSgraph().activeLevel))
/*    */       {
/* 26 */         if (graph.getSgraph().activeMenPai == 0)
/*    */         {
/* 28 */           RoleTaskManager.activeGraph(graph.id(), roleId.longValue());
/*    */         }
/*    */         else
/*    */         {
/* 32 */           int menpai = RoleInterface.getOccupationId(roleId.longValue());
/* 33 */           if (menpai == graph.getSgraph().activeMenPai)
/*    */           {
/* 35 */             RoleTaskManager.activeGraph(graph.id(), roleId.longValue());
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 41 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private boolean isWithinLvs(int oldLv, int curLv, int needLv)
/*    */   {
/* 57 */     if (oldLv >= needLv)
/*    */     {
/* 59 */       return false;
/*    */     }
/* 61 */     if (curLv < needLv)
/*    */     {
/* 63 */       return false;
/*    */     }
/* 65 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */