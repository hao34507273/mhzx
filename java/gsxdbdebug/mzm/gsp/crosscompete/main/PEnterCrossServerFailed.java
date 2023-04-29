/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import hub.CrossCompeteEnterRole;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Basic;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PEnterCrossServerFailed
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long factionid;
/*    */   private final List<CrossCompeteEnterRole> members;
/*    */   private final int reason;
/*    */   
/*    */   public PEnterCrossServerFailed(long factionid, List<CrossCompeteEnterRole> members, int reason)
/*    */   {
/* 20 */     this.factionid = factionid;
/* 21 */     this.members = members;
/* 22 */     this.reason = reason;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 27 */     List<Long> roleList = new ArrayList();
/* 28 */     for (CrossCompeteEnterRole member : this.members) {
/* 29 */       roleList.add(Long.valueOf(member.roleid));
/*    */     }
/*    */     
/*    */ 
/* 33 */     lock(Basic.getTable(), roleList);
/*    */     
/* 35 */     CrossCompeteManager.crossRoamServerFail(roleList, this.reason);
/*    */     
/* 37 */     CrossCompeteManager.logInfo("PEnterCrossServerFailed.processImp@enter cross server failed|factionid=%d|members=%s|reason=%d", new Object[] { Long.valueOf(this.factionid), roleList, Integer.valueOf(this.reason) });
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\PEnterCrossServerFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */