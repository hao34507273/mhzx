/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.crossserver.event.RoamRoleDataSucceedArg;
/*    */ import mzm.gsp.crossserver.main.RoamRoleInfo;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoamRoleDataSucceed extends mzm.gsp.crossserver.event.RoamRoleDataSucceedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     java.util.List<RoamRoleInfo> roamRoleInfos = ((RoamRoleDataSucceedArg)this.arg).getRoamRoleInfos();
/* 15 */     Map<Long, String> role2UserMap = new HashMap();
/* 16 */     for (RoamRoleInfo roamRoleInfo : roamRoleInfos) {
/* 17 */       role2UserMap.put(Long.valueOf(roamRoleInfo.getRoleid()), roamRoleInfo.getUserid());
/*    */     }
/* 19 */     lock(User.getTable(), role2UserMap.values());
/* 20 */     lock(Basic.getTable(), role2UserMap.keySet());
/* 21 */     for (RoamRoleInfo roamRoleInfo : roamRoleInfos) {
/* 22 */       LoginManager.UserCrossToken userCrossToken = new LoginManager.UserCrossToken(roamRoleInfo.getUserid(), roamRoleInfo.getRoleid(), roamRoleInfo.getToken());
/*    */       
/* 24 */       LoginManager.getInstance().onRoleDataReadySucceed(((RoamRoleDataSucceedArg)this.arg).getRoamZoneid(), userCrossToken, 2);
/*    */     }
/*    */     
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\POnRoamRoleDataSucceed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */