/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ import mzm.gsp.gang.SSyncUnForbiddenTalk;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.MilliObserver;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.GangMember;
/*    */ import xdb.Procedure;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ 
/*    */ public class ForbidTalkObserver
/*    */   extends MilliObserver
/*    */ {
/*    */   private long roleId;
/* 18 */   public static Map<Long, ForbidTalkObserver> observerMap = new ConcurrentHashMap();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public ForbidTalkObserver(long intervalMilliSeconds, long roleId)
/*    */   {
/* 26 */     super(intervalMilliSeconds);
/* 27 */     observerMap.put(Long.valueOf(roleId), this);
/* 28 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 34 */     Procedure.execute(new PForbidTalkObserver(this.roleId));
/* 35 */     return false;
/*    */   }
/*    */   
/*    */   public static void stopObserver(long roleId) {
/* 39 */     ForbidTalkObserver observer = (ForbidTalkObserver)observerMap.remove(Long.valueOf(roleId));
/* 40 */     if (observer != null) {
/* 41 */       observer.stopTimer();
/*    */     }
/*    */   }
/*    */   
/*    */   class PForbidTalkObserver extends LogicProcedure {
/*    */     private final long roleId;
/*    */     
/*    */     PForbidTalkObserver(long roleId) {
/* 49 */       this.roleId = roleId;
/*    */     }
/*    */     
/*    */     protected boolean processImp() throws Exception {
/* 53 */       GangMember xGangMember = Role2gangmember.get(Long.valueOf(this.roleId));
/* 54 */       xGangMember.setForbiddentalkend(0L);
/* 55 */       SSyncUnForbiddenTalk sSyncUnForbiddenTalk = new SSyncUnForbiddenTalk();
/* 56 */       OnlineManager.getInstance().send(this.roleId, sSyncUnForbiddenTalk);
/* 57 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\ForbidTalkObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */