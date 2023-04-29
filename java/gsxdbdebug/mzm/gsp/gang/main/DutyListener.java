/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.gang.event.DutyChange;
/*    */ import mzm.gsp.gang.event.GangArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.GangMember;
/*    */ import xdb.logs.Note;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ public class DutyListener implements xdb.logs.Listener
/*    */ {
/*    */   public void onChanged(Object o)
/*    */   {
/* 17 */     final long roleId = ((Long)o).longValue();
/* 18 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 22 */         GangMember xGangMember = Role2gangmember.select(Long.valueOf(roleId));
/* 23 */         GangArg gangArg = new GangArg();
/* 24 */         gangArg.gangId = xGangMember.getGangid();
/* 25 */         gangArg.extraMemberList.add(Long.valueOf(roleId));
/* 26 */         TriggerEventsManger.getInstance().triggerEventAtOnce(new DutyChange(), gangArg);
/* 27 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onRemoved(Object o) {}
/*    */   
/*    */ 
/*    */   public void onChanged(Object o, String s, Note note)
/*    */   {
/* 39 */     final long roleId = ((Long)o).longValue();
/* 40 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 44 */         GangMember xGangMember = Role2gangmember.select(Long.valueOf(roleId));
/* 45 */         GangArg gangArg = new GangArg();
/* 46 */         gangArg.gangId = xGangMember.getGangid();
/* 47 */         gangArg.extraMemberList.add(Long.valueOf(roleId));
/* 48 */         TriggerEventsManger.getInstance().triggerEventAtOnce(new DutyChange(), gangArg);
/* 49 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\DutyListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */