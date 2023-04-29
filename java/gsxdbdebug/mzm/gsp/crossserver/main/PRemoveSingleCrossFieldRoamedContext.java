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
/*    */ class PRemoveSingleCrossFieldRoamedContext
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roamedRoomInstanceid;
/*    */   private final List<SingleCrossFieldRoleMatchInfo> roleMatchInfos;
/*    */   
/*    */   PRemoveSingleCrossFieldRoamedContext(long roamedRoomInstanceid, List<SingleCrossFieldRoleMatchInfo> roleMatchInfos)
/*    */   {
/* 21 */     this.roamedRoomInstanceid = roamedRoomInstanceid;
/* 22 */     this.roleMatchInfos = roleMatchInfos;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     Set<String> userids = new HashSet();
/* 29 */     for (SingleCrossFieldRoleMatchInfo roleMatchInfo : this.roleMatchInfos)
/*    */     {
/* 31 */       userids.add(roleMatchInfo.userid.getString("UTF-8"));
/*    */     }
/* 33 */     lock(User2roamedinfo.getTable(), userids);
/*    */     
/* 35 */     for (String userid : userids)
/*    */     {
/* 37 */       CrossServerManager.removeUserRoamedInfo(userid, RoamType.SINGLE_CROSS_FIELD, this.roamedRoomInstanceid);
/*    */     }
/*    */     
/* 40 */     SingleCrossFieldRoamedContextManager.getInstance().removeContext(this.roamedRoomInstanceid);
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\PRemoveSingleCrossFieldRoamedContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */