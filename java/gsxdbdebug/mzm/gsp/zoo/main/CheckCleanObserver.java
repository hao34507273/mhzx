/*    */ package mzm.gsp.zoo.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.homeland.confbean.SAnimalConst;
/*    */ import mzm.gsp.marriage.main.MarriageInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xdb.Executor;
/*    */ 
/*    */ public class CheckCleanObserver extends Observer
/*    */ {
/*    */   private final long intervalSeconds;
/*    */   
/*    */   public CheckCleanObserver(long delaySeconds, long intervalSeconds)
/*    */   {
/* 20 */     super(delaySeconds);
/*    */     
/* 22 */     this.intervalSeconds = intervalSeconds;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 28 */     Executor.getInstance().execute(new RAllCheckClean(null));
/*    */     
/* 30 */     setIntervalSeconds(this.intervalSeconds);
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   private static class RAllCheckClean
/*    */     extends LogicRunnable
/*    */   {
/*    */     public void process() throws Exception
/*    */     {
/* 39 */       List<Long> roles = OnlineManager.getInstance().getAllRolesInWorld();
/* 40 */       for (Iterator i$ = roles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */         
/* 42 */         NoneRealTimeTaskManager.getInstance().addTask(new CheckCleanObserver.PCheckCleanForEscape(roleid));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   private static class PCheckCleanForEscape extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private final long roleid;
/*    */     
/*    */     public PCheckCleanForEscape(long roleid)
/*    */     {
/* 53 */       this.roleid = roleid;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 59 */       long marriageRoleid = MarriageInterface.getMarriedRoleid(this.roleid, false);
/* 60 */       if (marriageRoleid > 0L)
/*    */       {
/*    */ 
/* 63 */         new PCheckClean(marriageRoleid).execute();
/*    */       }
/*    */       
/* 66 */       int level = RoleInterface.getLevel(this.roleid);
/* 67 */       if (level < SAnimalConst.getInstance().OPEN_LEVEL)
/*    */       {
/* 69 */         return false;
/*    */       }
/*    */       
/* 72 */       ZooManager.checkCleanForEscape(this.roleid);
/* 73 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\main\CheckCleanObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */