/*    */ package mzm.gsp.interactivetask.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2interactivetask;
/*    */ 
/*    */ public class InteractiveTaskSession
/*    */   extends Session
/*    */ {
/*    */   public InteractiveTaskSession(long interval, List<Long> roleids, int typeid)
/*    */   {
/* 15 */     super(interval, ((Long)roleids.get(0)).longValue());
/* 16 */     this.roleids.addAll(roleids);
/* 17 */     this.typeid = typeid;
/*    */   }
/*    */   
/* 20 */   private final List<Long> roleids = new ArrayList();
/*    */   
/*    */   private final int typeid;
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 26 */     new InteractiveTaskSessionPro(this.roleids, this.typeid).execute();
/*    */   }
/*    */   
/*    */   private static class InteractiveTaskSessionPro
/*    */     extends LogicProcedure
/*    */   {
/*    */     private final List<Long> roleids;
/*    */     private final int typeid;
/*    */     
/*    */     public InteractiveTaskSessionPro(List<Long> roleids, int typeid)
/*    */     {
/* 37 */       this.roleids = roleids;
/* 38 */       this.typeid = typeid;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 44 */       Lockeys.lock(Role2interactivetask.getTable(), this.roleids);
/* 45 */       InteractiveTaskManager.leaveFuben(this.typeid, new ArrayList(this.roleids));
/* 46 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interactivetask\main\InteractiveTaskSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */