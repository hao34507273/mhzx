/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.User2roamedinfo;
/*    */ 
/*    */ 
/*    */ class PCollectRoamRoleContext
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roamedRoomInstanceid;
/*    */   private final int activityContextTypeid;
/*    */   private final List<RoamedRoleMatchMarkingInfo> roleMatchMarkingInfos;
/*    */   private final List<RoamedRoleMatchMarkingInfo> opponentRoleMatchMarkingInfos;
/*    */   
/*    */   PCollectRoamRoleContext(long roamedRoomInstanceid, int activityContextTypeid, List<RoamedRoleMatchMarkingInfo> roleMatchMarkingInfos, List<RoamedRoleMatchMarkingInfo> opponentRoleMatchMarkingInfos)
/*    */   {
/* 20 */     this.roamedRoomInstanceid = roamedRoomInstanceid;
/* 21 */     this.activityContextTypeid = activityContextTypeid;
/* 22 */     this.roleMatchMarkingInfos = roleMatchMarkingInfos;
/* 23 */     this.opponentRoleMatchMarkingInfos = opponentRoleMatchMarkingInfos;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     Set<String> userids = new HashSet();
/* 30 */     for (RoamedRoleMatchMarkingInfo roamedRoleMatchMarkingInfo : this.roleMatchMarkingInfos)
/*    */     {
/* 32 */       userids.add(roamedRoleMatchMarkingInfo.getUserid());
/*    */     }
/* 34 */     for (RoamedRoleMatchMarkingInfo roamedRoleMatchMarkingInfo : this.opponentRoleMatchMarkingInfos)
/*    */     {
/* 36 */       userids.add(roamedRoleMatchMarkingInfo.getUserid());
/*    */     }
/* 38 */     lock(User2roamedinfo.getTable(), userids);
/*    */     
/* 40 */     for (String userid : userids)
/*    */     {
/* 42 */       CrossServerManager.setUserRoamedInfo(userid, RoamType.LADDER, this.roamedRoomInstanceid);
/*    */     }
/*    */     
/* 45 */     RoamedMatchContext roamedMatchContext = RoamedMatchContextManager.getInstance().addRoamedMathContext(this.roamedRoomInstanceid, this.activityContextTypeid, this.roleMatchMarkingInfos, this.opponentRoleMatchMarkingInfos);
/*    */     
/*    */ 
/* 48 */     if (roamedMatchContext == null)
/*    */     {
/* 50 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 55 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\PCollectRoamRoleContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */