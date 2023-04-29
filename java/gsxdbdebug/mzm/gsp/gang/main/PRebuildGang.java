/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import hub.CrossCompeteFactionDutyMembers;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.GangDutyMembers;
/*    */ import xbean.Pod;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PRebuildGang
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gangid;
/*    */   private final String gangName;
/*    */   private final List<CrossCompeteFactionDutyMembers> dutyMembersList;
/*    */   private final int designedTitleid;
/*    */   
/*    */   public PRebuildGang(long gangid, String gangName, List<CrossCompeteFactionDutyMembers> dutyMemberList, int designedTitleid)
/*    */   {
/* 25 */     this.gangid = gangid;
/* 26 */     this.gangName = gangName;
/* 27 */     this.dutyMembersList = new ArrayList(dutyMemberList);
/* 28 */     this.designedTitleid = designedTitleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     if (!GameServerInfoManager.isRoamServer()) {
/* 35 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 40 */     xtable.Gang.remove(Long.valueOf(this.gangid));
/*    */     
/* 42 */     xbean.Gang xGang = Pod.newGang();
/* 43 */     xGang.setName(this.gangName);
/* 44 */     for (CrossCompeteFactionDutyMembers dutyMembersBean : this.dutyMembersList) {
/* 45 */       GangDutyMembers xMembers = Pod.newGangDutyMembers();
/* 46 */       xMembers.getMembers().addAll(dutyMembersBean.members);
/* 47 */       xGang.getDuty2members().put(Integer.valueOf(dutyMembersBean.dutyid), xMembers);
/*    */     }
/*    */     
/* 50 */     xGang.setDesigntitlecaseid(this.designedTitleid);
/*    */     
/* 52 */     GangManager.logInfo("PRebuildGang.processImp@succeed|gangid=%d|name=%s", new Object[] { Long.valueOf(this.gangid), this.gangName });
/*    */     
/*    */ 
/*    */ 
/* 56 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PRebuildGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */