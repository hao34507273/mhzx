/*    */ package mzm.gsp.interactivetask.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.interactivetask.SSynInteractiveTaskRes;
/*    */ import mzm.gsp.interactivetask.TaskInfo;
/*    */ import xbean.InteractivetaskInfo;
/*    */ import xbean.InteractivetaskMap;
/*    */ 
/*    */ public class POnRoleLogin extends mzm.gsp.online.event.PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     InteractivetaskMap xInteractivetaskMap = xtable.Role2interactivetask.get((Long)this.arg);
/* 15 */     if ((xInteractivetaskMap == null) || (xInteractivetaskMap.getTypeid2task().isEmpty()))
/*    */     {
/* 17 */       return false;
/*    */     }
/* 19 */     SSynInteractiveTaskRes res = new SSynInteractiveTaskRes();
/* 20 */     for (Iterator i$ = xInteractivetaskMap.getTypeid2task().keySet().iterator(); i$.hasNext();) { int typeid = ((Integer)i$.next()).intValue();
/*    */       
/*    */ 
/* 23 */       InteractivetaskInfo xInteractivetaskInfo = (InteractivetaskInfo)xInteractivetaskMap.getTypeid2task().get(Integer.valueOf(typeid));
/* 24 */       mzm.gsp.timer.main.Session session = mzm.gsp.timer.main.Session.getSession(xInteractivetaskInfo.getSessionid());
/* 25 */       if (session != null)
/*    */       {
/*    */ 
/*    */ 
/* 29 */         TaskInfo taskInfo = new TaskInfo();
/* 30 */         InteractiveTaskManager.fillTaskInfo(taskInfo, ((Long)this.arg).longValue(), typeid, xInteractivetaskInfo);
/* 31 */         res.typeid2graphs.put(Integer.valueOf(typeid), taskInfo);
/*    */       } }
/* 33 */     mzm.gsp.online.main.OnlineManager.getInstance().send(((Long)this.arg).longValue(), res);
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interactivetask\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */