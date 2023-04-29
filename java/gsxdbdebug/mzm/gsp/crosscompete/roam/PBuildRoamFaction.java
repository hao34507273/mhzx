/*    */ package mzm.gsp.crosscompete.roam;
/*    */ 
/*    */ import hub.CrossCompeteFactionDutyMembers;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.GangDutyMembers;
/*    */ import xbean.Pod;
/*    */ import xbean.RoamCrossCompeteFaction;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PBuildRoamFaction
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long factionid;
/*    */   private final String factionName;
/*    */   private final List<CrossCompeteFactionDutyMembers> dutyMembersList;
/*    */   private final int designedTitleid;
/*    */   private final int participateCount;
/*    */   
/*    */   public PBuildRoamFaction(long factionid, String factionName, List<CrossCompeteFactionDutyMembers> dutyMemberList, int designedTitleid, int participateCount)
/*    */   {
/* 27 */     this.factionid = factionid;
/* 28 */     this.factionName = factionName;
/* 29 */     this.dutyMembersList = new ArrayList(dutyMemberList);
/* 30 */     this.designedTitleid = designedTitleid;
/* 31 */     this.participateCount = participateCount;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 38 */     RoamCrossCompeteFaction xFaction = CrossCompeteRoamManager.createRoamCrossCompeteFactionIfNotExist(this.factionid);
/*    */     
/*    */ 
/* 41 */     xFaction.setName(this.factionName);
/* 42 */     for (CrossCompeteFactionDutyMembers dutyMembersBean : this.dutyMembersList) {
/* 43 */       GangDutyMembers xMembers = Pod.newGangDutyMembers();
/* 44 */       xMembers.getMembers().addAll(dutyMembersBean.members);
/* 45 */       xFaction.getDuty2members().put(Integer.valueOf(dutyMembersBean.dutyid), xMembers);
/*    */     }
/*    */     
/* 48 */     xFaction.setDesigned_titleid(this.designedTitleid);
/*    */     
/*    */ 
/* 51 */     RoamLoadManager.instance.addFaction(this.factionid, this.participateCount);
/*    */     
/* 53 */     CrossCompeteManager.logInfo("PBuildRoamFaction.processImp@succeed|gangid=%d|name=%s", new Object[] { Long.valueOf(this.factionid), this.factionName });
/*    */     
/*    */ 
/*    */ 
/* 57 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\PBuildRoamFaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */