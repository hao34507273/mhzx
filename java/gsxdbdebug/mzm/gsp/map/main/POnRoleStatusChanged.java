/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.map.main.message.MMH_SetMapRoleStatus;
/*    */ import mzm.gsp.status.event.RoleStatusChangeArg;
/*    */ import mzm.gsp.status.event.RoleStatusChangedProcedure;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ 
/*    */ public class POnRoleStatusChanged extends RoleStatusChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     List<Integer> addList = new ArrayList();
/* 16 */     List<Integer> remList = new ArrayList();
/* 17 */     filterToClientStatus(addList, ((RoleStatusChangeArg)this.arg).addedset);
/* 18 */     filterToClientStatus(remList, ((RoleStatusChangeArg)this.arg).remedSet);
/* 19 */     new MMH_SetMapRoleStatus(addList, remList, ((RoleStatusChangeArg)this.arg).roleid).execute();
/*    */     
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   private void filterToClientStatus(List<Integer> list, Set<Integer> statusSet)
/*    */   {
/* 26 */     for (Integer status : statusSet)
/*    */     {
/* 28 */       if (RoleStatusInterface.isToClient(status.intValue()))
/*    */       {
/* 30 */         list.add(status);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnRoleStatusChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */