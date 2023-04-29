/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.petarena.SGetPetArenaInfoFailed;
/*    */ import mzm.gsp.petarena.confbean.SPetArenaConst;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCGetPetArenaInfo extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCGetPetArenaInfo(long roleid)
/*    */   {
/* 23 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if (!PetArenaManager.canDoAction(this.roleid, 2111))
/*    */     {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     if (!PetArenaManager.isFunOpen(this.roleid))
/*    */     {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     int level = RoleInterface.getLevel(this.roleid);
/* 40 */     if (level < SPetArenaConst.getInstance().OPEN_LEVEL)
/*    */     {
/* 42 */       onFailed(-1);
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     if ((TeamInterface.isTeamMemberNormal(this.roleid)) && (TeamInterface.getNormalRoleList(this.roleid).size() > 1))
/*    */     {
/* 48 */       onFailed(-3);
/* 49 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 53 */     String userid = RoleInterface.getUserId(this.roleid);
/* 54 */     lock(Lockeys.get(User.getTable(), userid));
/* 55 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*    */     
/* 57 */     int activityCfgid = SPetArenaConst.getInstance().ACTIVITY_CFG_ID;
/* 58 */     ActivityJoinResult joinResult = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, activityCfgid);
/*    */     
/* 60 */     if ((!joinResult.isCanJoin()) && (!joinResult.isSingleRoleTeam()))
/*    */     {
/* 62 */       onFailed(-2);
/* 63 */       return false;
/*    */     }
/*    */     
/* 66 */     xbean.PetArenaInfo xPetArenaInfo = PetArenaManager.checkAndInitData(this.roleid);
/* 67 */     PetArenaManager.sendPetAreanInfoMsg(this.roleid, xPetArenaInfo);
/*    */     
/* 69 */     GameServer.logger().info(String.format("[petarena]PCGetPetArenaInfo.processImp@get success|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/* 70 */     return true;
/*    */   }
/*    */   
/*    */   private void onFailed(int retcode)
/*    */   {
/* 75 */     onFailed(retcode, null);
/*    */   }
/*    */   
/*    */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*    */   {
/* 80 */     SGetPetArenaInfoFailed rsp = new SGetPetArenaInfoFailed();
/* 81 */     rsp.retcode = retcode;
/* 82 */     OnlineManager.getInstance().sendAtOnce(this.roleid, rsp);
/*    */     
/* 84 */     StringBuilder logBuilder = new StringBuilder();
/* 85 */     logBuilder.append("[petarena]PCGetPetArenaInfo.onFailed@get pet arena info failed");
/* 86 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 87 */     logBuilder.append('|').append("retcode=").append(retcode);
/*    */     
/* 89 */     if (extraParams != null)
/*    */     {
/* 91 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*    */       {
/* 93 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*    */       }
/*    */     }
/*    */     
/* 97 */     GameServer.logger().error(logBuilder.toString());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PCGetPetArenaInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */