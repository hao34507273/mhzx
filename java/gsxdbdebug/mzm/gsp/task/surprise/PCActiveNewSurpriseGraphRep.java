/*    */ package mzm.gsp.task.surprise;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xbean.SurpriseScheduleInfo;
/*    */ 
/*    */ public class PCActiveNewSurpriseGraphRep extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PCActiveNewSurpriseGraphRep(long roleId)
/*    */   {
/* 12 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     SurpriseScheduleInfo xSurpriseScheduleInfo = xtable.Surpriseschedule.get(Long.valueOf(this.roleId));
/* 20 */     if (xSurpriseScheduleInfo == null)
/*    */     {
/* 22 */       xtable.Surpriseschedule.insert(Long.valueOf(this.roleId), xSurpriseScheduleInfo = xbean.Pod.newSurpriseScheduleInfo());
/*    */     }
/*    */     
/* 25 */     xbean.GlobalSurpriseScheduleInfo xGlobalSurpriseScheduleInfo = xtable.Globalsurpriseschedule.get(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 26 */     if (xGlobalSurpriseScheduleInfo == null)
/*    */     {
/*    */ 
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     xSurpriseScheduleInfo.getOpenedgraphids().clear();
/* 33 */     xSurpriseScheduleInfo.getOpenedgraphids().addAll(xGlobalSurpriseScheduleInfo.getOpenedgraphids());
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\surprise\PCActiveNewSurpriseGraphRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */