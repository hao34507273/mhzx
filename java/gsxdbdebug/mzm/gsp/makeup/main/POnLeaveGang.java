/*    */ package mzm.gsp.makeup.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.gang.event.LeaveGangArg;
/*    */ import mzm.gsp.gang.event.LeaveGangProcedure;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.FactionMakeUpInfo;
/*    */ import xbean.FactionMakeUpRecord;
/*    */ import xdb.Procedure;
/*    */ import xtable.Gangmakeup;
/*    */ 
/*    */ public class POnLeaveGang
/*    */   extends LeaveGangProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     for (Iterator i$ = ((LeaveGangArg)this.arg).extraMemberList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 21 */       onRoleLeaveFaction(roleId, ((LeaveGangArg)this.arg).gangId);
/*    */     }
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   private void onRoleLeaveFaction(final long roleId, long factionId)
/*    */   {
/* 28 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/*    */ 
/* 35 */         MakeUpManager.synAllMakeupInfo(roleId);
/*    */         
/* 37 */         FactionMakeUpInfo xFactionMakeUpInfo = Gangmakeup.get(Long.valueOf(this.val$factionId));
/* 38 */         if (xFactionMakeUpInfo == null)
/*    */         {
/* 40 */           return false;
/*    */         }
/* 42 */         for (FactionMakeUpRecord xFactionMakeUpRecord : xFactionMakeUpInfo.getActivityid2record().values())
/*    */         {
/* 44 */           xFactionMakeUpRecord.getJoinroleids().remove(Long.valueOf(roleId));
/*    */         }
/* 46 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\makeup\main\POnLeaveGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */