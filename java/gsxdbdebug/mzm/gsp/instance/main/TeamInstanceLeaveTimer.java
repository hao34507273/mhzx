/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import xbean.InstanceCacheBean;
/*    */ import xtable.Role2instanceuuid;
/*    */ 
/*    */ public class TeamInstanceLeaveTimer extends Session
/*    */ {
/* 12 */   private final List<Long> roleids = new ArrayList();
/*    */   
/*    */   public TeamInstanceLeaveTimer(long interval, long instanceUuid, List<Long> roleids) {
/* 15 */     super(interval, instanceUuid);
/* 16 */     this.roleids.addAll(roleids);
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 21 */     xdb.Procedure.execute(new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 26 */         lock(xtable.Role2properties.getTable(), TeamInstanceLeaveTimer.this.roleids);
/* 27 */         long instanceUuid = TeamInstanceLeaveTimer.this.getOwerId();
/* 28 */         Iterator<Long> iterator = TeamInstanceLeaveTimer.this.roleids.iterator();
/* 29 */         while (iterator.hasNext()) {
/* 30 */           long roleid = ((Long)iterator.next()).longValue();
/* 31 */           Long instanceUuid1 = Role2instanceuuid.get(Long.valueOf(roleid));
/* 32 */           if ((instanceUuid1 == null) || (instanceUuid1.longValue() != instanceUuid)) {
/* 33 */             iterator.remove();
/*    */           }
/*    */         }
/*    */         
/*    */ 
/* 38 */         InstanceCacheBean xInstanceCacheBean = xtable.Instance.get(Long.valueOf(TeamInstanceLeaveTimer.this.getOwerId()));
/* 39 */         if (xInstanceCacheBean == null) {
/* 40 */           return false;
/*    */         }
/* 42 */         return TeamInstance.onleaveInstance(TeamInstanceLeaveTimer.this.roleids, instanceUuid, xInstanceCacheBean);
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\TeamInstanceLeaveTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */