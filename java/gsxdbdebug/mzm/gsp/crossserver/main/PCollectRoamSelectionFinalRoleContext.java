/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.User2roamedinfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCollectRoamSelectionFinalRoleContext
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roamedRoomInstanceid;
/*    */   private final RoamedKnockOutTeamInfo roamedCrossBattleTeamInfo;
/*    */   private final RoamedKnockOutTeamInfo opponentCrossBattleTeamInfo;
/*    */   private final int activityFightTypeId;
/*    */   private final int fightStage;
/*    */   private final int fightIndexId;
/*    */   
/*    */   PCollectRoamSelectionFinalRoleContext(long roamedRoomInstanceid, RoamedKnockOutTeamInfo roamedCrossBattleTeamInfo, RoamedKnockOutTeamInfo opponentCrossBattleTeamInfo, int activityTypeId, int fightStage, int fightIndexId)
/*    */   {
/* 27 */     this.roamedRoomInstanceid = roamedRoomInstanceid;
/* 28 */     this.roamedCrossBattleTeamInfo = roamedCrossBattleTeamInfo;
/* 29 */     this.opponentCrossBattleTeamInfo = opponentCrossBattleTeamInfo;
/* 30 */     this.activityFightTypeId = activityTypeId;
/* 31 */     this.fightStage = fightStage;
/* 32 */     this.fightIndexId = fightIndexId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 38 */     Set<String> userids = new HashSet();
/* 39 */     for (RoamedKnockOutRoleInfo roamedRoleCrossBattleInfo : this.roamedCrossBattleTeamInfo.getCrossBattleRoleInfoList())
/*    */     {
/* 41 */       userids.add(roamedRoleCrossBattleInfo.getUserid());
/*    */     }
/* 43 */     for (RoamedKnockOutRoleInfo roamedRoleCrossBattleInfo : this.opponentCrossBattleTeamInfo.getCrossBattleRoleInfoList())
/*    */     {
/* 45 */       userids.add(roamedRoleCrossBattleInfo.getUserid());
/*    */     }
/* 47 */     lock(User2roamedinfo.getTable(), userids);
/*    */     
/* 49 */     for (String userid : userids)
/*    */     {
/* 51 */       CrossServerManager.setUserRoamedInfo(userid, RoamType.CROSS_BATTLE_SELECTION_FINAL, this.roamedRoomInstanceid);
/*    */     }
/*    */     
/*    */ 
/* 55 */     RoamedKnockOutContext roamedCrossBattleContext = RoamedKnockOutContextManager.getInstance().addRoamedCrossBattleContext(this.roamedRoomInstanceid, this.roamedCrossBattleTeamInfo, this.opponentCrossBattleTeamInfo, this.activityFightTypeId, this.fightStage, this.fightIndexId);
/*    */     
/*    */ 
/* 58 */     if (roamedCrossBattleContext == null)
/*    */     {
/* 60 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 65 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\PCollectRoamSelectionFinalRoleContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */