/*    */ package mzm.gsp.npc.main;
/*    */ 
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.npc.event.FinishDlgArg;
/*    */ import mzm.gsp.npc.event.FinishDlgEvent;
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
/*    */ public class RoleNpcManager
/*    */ {
/*    */   static boolean roleFinishDlg(long roleId, int npcId, int taskId)
/*    */   {
/* 21 */     FinishDlgArg finishDlgArg = new FinishDlgArg(roleId, npcId, taskId);
/* 22 */     TriggerEventsManger.getInstance().triggerEvent(new FinishDlgEvent(), finishDlgArg);
/* 23 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean npcInteractReq(int npcId)
/*    */   {
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\main\RoleNpcManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */