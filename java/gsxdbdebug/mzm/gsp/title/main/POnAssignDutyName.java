/*    */ package mzm.gsp.title.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.gang.event.AssignDutyNameProcedure;
/*    */ import mzm.gsp.gang.event.GangArg;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnAssignDutyName
/*    */   extends AssignDutyNameProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     Set<Long> gangMembers = GangInterface.getGangMemberList(((GangArg)this.arg).gangId);
/* 19 */     if ((gangMembers == null) || (gangMembers.size() == 0)) {
/* 20 */       return false;
/*    */     }
/* 22 */     int gangAppId = TitleManager.getGangAppId();
/* 23 */     for (Iterator i$ = gangMembers.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/* 24 */       NoneRealTimeTaskManager.getInstance().addTask(new PGangMemberAppellationChange(roleId, ((GangArg)this.arg).gangId, gangAppId));
/*    */     }
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\main\POnAssignDutyName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */