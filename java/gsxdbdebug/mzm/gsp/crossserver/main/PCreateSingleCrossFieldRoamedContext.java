/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import hub.SingleCrossFieldRoleMatchInfo;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.User2roamedinfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ class PCreateSingleCrossFieldRoamedContext
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roamedRoomInstanceid;
/*    */   private final int activityCfgid;
/*    */   private final List<SingleCrossFieldRoleMatchInfo> roleMatchInfos;
/*    */   
/*    */   PCreateSingleCrossFieldRoamedContext(long roamedRoomInstanceid, int activityCfgid, List<SingleCrossFieldRoleMatchInfo> roleMatchInfos)
/*    */   {
/* 22 */     this.roamedRoomInstanceid = roamedRoomInstanceid;
/* 23 */     this.activityCfgid = activityCfgid;
/* 24 */     this.roleMatchInfos = roleMatchInfos;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     Set<String> userids = new HashSet();
/* 31 */     for (SingleCrossFieldRoleMatchInfo roleMatchInfo : this.roleMatchInfos)
/*    */     {
/* 33 */       userids.add(roleMatchInfo.userid.getString("UTF-8"));
/*    */     }
/* 35 */     lock(User2roamedinfo.getTable(), userids);
/*    */     
/* 37 */     for (String userid : userids)
/*    */     {
/* 39 */       CrossServerManager.setUserRoamedInfo(userid, RoamType.SINGLE_CROSS_FIELD, this.roamedRoomInstanceid);
/*    */     }
/*    */     
/* 42 */     SingleCrossFieldRoamedContext context = SingleCrossFieldRoamedContextManager.getInstance().addContext(this.roamedRoomInstanceid, this.activityCfgid, this.roleMatchInfos);
/*    */     
/* 44 */     if (context == null)
/*    */     {
/* 46 */       return false;
/*    */     }
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\PCreateSingleCrossFieldRoamedContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */