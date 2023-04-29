/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xdb.Executor;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CrossTokenCheckObserver
/*    */   extends Observer
/*    */ {
/* 16 */   private static Object lock = new Object();
/*    */   
/* 18 */   private static Map<Long, CrossTokenCheckObserver> role2CheckMap = new OnlineRoleSizeExtendMap();
/*    */   private final long roleid;
/*    */   
/* 21 */   public static void createCrossTokenCheckObserver(Collection<Long> roleids) { Iterator i$; synchronized (lock) {
/* 22 */       for (i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 23 */         if (!role2CheckMap.containsKey(Long.valueOf(roleid)))
/*    */         {
/*    */ 
/* 26 */           role2CheckMap.put(Long.valueOf(roleid), new CrossTokenCheckObserver(60L, roleid)); }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public static void createCrossTokenCheckObserver(long roleid) {
/* 32 */     synchronized (lock) {
/* 33 */       if (role2CheckMap.containsKey(Long.valueOf(roleid))) {
/* 34 */         return;
/*    */       }
/* 36 */       role2CheckMap.put(Long.valueOf(roleid), new CrossTokenCheckObserver(60L, roleid));
/*    */     }
/*    */   }
/*    */   
/*    */   static void removeServer(CrossTokenCheckObserver crossTokenCheckObserver) {
/* 41 */     crossTokenCheckObserver.stopTimer();
/* 42 */     synchronized (lock) {
/* 43 */       role2CheckMap.remove(Long.valueOf(crossTokenCheckObserver.getRoleid()));
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   long getRoleid()
/*    */   {
/* 50 */     return this.roleid;
/*    */   }
/*    */   
/*    */   public CrossTokenCheckObserver(long interval, long roleid) {
/* 54 */     super(interval);
/* 55 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   public boolean update()
/*    */   {
/* 60 */     Executor.getInstance().execute(new LogicRunnable()
/*    */     {
/*    */       public void process() throws Exception
/*    */       {
/* 64 */         long roieid = CrossTokenCheckObserver.this.getRoleid();
/* 65 */         String userid = RoleInterface.getUserId(roieid);
/* 66 */         boolean crossStatus = new PCheckCrossToken(userid, roieid).call();
/* 67 */         if (!crossStatus) {
/* 68 */           CrossTokenCheckObserver.removeServer(CrossTokenCheckObserver.this);
/* 69 */           return;
/*    */         }
/* 71 */         new PCheckCrossToken(userid, roieid).call();
/*    */       }
/* 73 */     });
/* 74 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\CrossTokenCheckObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */