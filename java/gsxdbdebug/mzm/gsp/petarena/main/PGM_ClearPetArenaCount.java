/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.petarena.SGetPetArenaInfoSuccess;
/*    */ import mzm.gsp.petarena.confbean.SPetArenaConst;
/*    */ import xbean.PetArenaInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class PGM_ClearPetArenaCount extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   
/*    */   public PGM_ClearPetArenaCount(long gmRoleid, long roleid)
/*    */   {
/* 20 */     this.gmRoleid = gmRoleid;
/* 21 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     if (!PetArenaManager.isFunOpen())
/*    */     {
/* 29 */       notifyClient("开关未开启");
/* 30 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 34 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/* 35 */     lock(Lockeys.get(xtable.User.getTable(), userid));
/* 36 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*    */     
/* 38 */     int activityCfgid = SPetArenaConst.getInstance().ACTIVITY_CFG_ID;
/* 39 */     ActivityJoinResult joinResult = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, activityCfgid);
/*    */     
/* 41 */     if (!joinResult.isCanJoin())
/*    */     {
/* 43 */       notifyClient("活动参与失败");
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     PetArenaInfo xPetArenaInfo = xtable.Role2petarenainfo.get(Long.valueOf(this.roleid));
/* 48 */     if (xPetArenaInfo == null)
/*    */     {
/* 50 */       notifyClient("服务器错误");
/* 51 */       return false;
/*    */     }
/*    */     
/* 54 */     xPetArenaInfo.setBuy_count(0);
/* 55 */     xPetArenaInfo.setChallenge_count(0);
/*    */     
/* 57 */     int rank = PetArenaRankManager.getInstance().getRank(this.roleid);
/* 58 */     SGetPetArenaInfoSuccess rsp = new SGetPetArenaInfoSuccess();
/* 59 */     PetArenaManager.fillPetArenaInfo(rsp.pet_arena_info, this.roleid, rank, xPetArenaInfo);
/* 60 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*    */     
/* 62 */     notifyClient("修改成功");
/* 63 */     return true;
/*    */   }
/*    */   
/*    */   private void notifyClient(String str)
/*    */   {
/* 68 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 69 */     messagetip.result = Integer.MAX_VALUE;
/* 70 */     messagetip.args.add(str);
/* 71 */     OnlineManager.getInstance().sendAtOnce(this.gmRoleid, messagetip);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PGM_ClearPetArenaCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */