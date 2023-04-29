/*    */ package mzm.gsp.hula.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.hula.confbean.SHulaCfgConsts;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.npc.main.NpcInterface;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PJoinHulaReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PJoinHulaReq(long roleId)
/*    */   {
/* 27 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     if (!OpenInterface.getOpenStatus(200))
/*    */     {
/* 35 */       String logstr = String.format("[hula]PJoinHulaReq.processImp@hula switch is closed roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/* 36 */       HulaManager.logger.info(logstr);
/*    */       
/* 38 */       return false;
/*    */     }
/* 40 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 450, true))
/*    */     {
/* 42 */       String log = String.format("[hula]PJoinHulaReq.processImp@role status can not mark monster|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/* 43 */       HulaManager.logger.info(log);
/* 44 */       return false;
/*    */     }
/* 46 */     if (!NpcInterface.checkNpcService(SHulaCfgConsts.getInstance().NPCID, SHulaCfgConsts.getInstance().NPC_SERVICE, this.roleId))
/*    */     {
/* 48 */       String logstr = String.format("[hula]PJoinHulaReq.processImp@role not near npc|roleid=%d|npc=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(SHulaCfgConsts.getInstance().NPCID) });
/*    */       
/* 50 */       HulaManager.logger.info(logstr);
/* 51 */       return false;
/*    */     }
/* 53 */     int stage = ActivityInterface.getActivityStage(SHulaCfgConsts.getInstance().ACTIVITY_ID);
/* 54 */     if (stage == -1)
/*    */     {
/* 56 */       String logstr = String.format("[hula]PJoinHulaReq.processImp@activity not open|roleid=%d|stage=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(stage) });
/* 57 */       HulaManager.logger.info(logstr);
/* 58 */       return false;
/*    */     }
/* 60 */     if (!HulaManager.isThisStage(stage, 0))
/*    */     {
/* 62 */       HulaManager.sendErrorInfo(this.roleId, 1);
/* 63 */       return false;
/*    */     }
/* 65 */     List<Long> roleList = new ArrayList();
/* 66 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/* 67 */     if (teamInfo == null)
/*    */     {
/* 69 */       roleList.add(Long.valueOf(this.roleId));
/*    */     }
/*    */     else
/*    */     {
/* 73 */       if (teamInfo.getLeaderId() != this.roleId)
/*    */       {
/* 75 */         return false;
/*    */       }
/* 77 */       roleList = teamInfo.getTeamNormalList();
/*    */     }
/*    */     
/* 80 */     if (!HulaManager.checkTeam(this.roleId, roleList))
/*    */     {
/* 82 */       return false;
/*    */     }
/*    */     
/* 85 */     boolean ret = RoleStatusInterface.setStatus(roleList, 450, true);
/* 86 */     if (!ret)
/*    */     {
/* 88 */       String logstr = String.format("[hula]PJoinHulaReq.processImp@can not set role hula state|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/* 89 */       HulaManager.logger.info(logstr);
/* 90 */       return false;
/*    */     }
/* 92 */     long worldid = HulaWorldManager.getInstance().getPrepareWorldId();
/* 93 */     MapInterface.transferToScene(this.roleId, worldid, SHulaCfgConsts.getInstance().PREPARE_MAP_ID);
/* 94 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\main\PJoinHulaReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */