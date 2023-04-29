/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.SGangNormalResult;
/*    */ import mzm.gsp.gang.SSyncGangMiFangInfo;
/*    */ import mzm.gsp.gang.confbean.GangMiFangConst;
/*    */ import mzm.gsp.gang.confbean.SGangMiFangCfg;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.GangMember;
/*    */ import xbean.GangMemoryBean;
/*    */ import xbean.MiFang;
/*    */ import xtable.Gangmemory;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PGetGangMiFangReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   public PGetGangMiFangReq(long roleId)
/*    */   {
/* 25 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/* 32 */     lock(xdb.Lockeys.get(User.getTable(), userid));
/*    */     
/* 34 */     GangMember xGangMember = xtable.Role2gangmember.get(Long.valueOf(this.roleId));
/* 35 */     if (xGangMember == null) {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(xGangMember.getGangid()));
/* 40 */     if ((xGang == null) || (!GangManager.isInGang(xGang, this.roleId))) {
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     GangMemoryBean xGangMemory = Gangmemory.select(Long.valueOf(xGangMember.getGangid()));
/* 45 */     if (xGangMemory == null) {
/* 46 */       return false;
/*    */     }
/* 48 */     if (xGangMemory.getGangworldid() != MapInterface.getRoleWorldInstanceId(this.roleId)) {
/* 49 */       return false;
/*    */     }
/* 51 */     MiFang xMiFang = xGang.getYaodian().getMifang();
/* 52 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 53 */     if (!GangManager.isInMiFangDurationTime(curTime, xMiFang)) {
/* 54 */       return false;
/*    */     }
/* 56 */     long haveTime = xGangMember.getLasthavemifangtime();
/* 57 */     if (GangManager.isInMiFangDurationTime(haveTime, xMiFang)) {
/* 58 */       return false;
/*    */     }
/* 60 */     if (xMiFang.getMifangcfgstarttime() < xGangMember.getJointime()) {
/* 61 */       SGangNormalResult result = new SGangNormalResult();
/* 62 */       result.result = 36;
/* 63 */       OnlineManager.getInstance().sendAtOnce(this.roleId, result);
/* 64 */       return false;
/*    */     }
/*    */     
/* 67 */     SGangMiFangCfg cfg = SGangMiFangCfg.get(xMiFang.getMifangcfgid());
/* 68 */     if (!GangInterface.cutBangGong(this.roleId, cfg.needBangGong, new TLogArg(mzm.gsp.tlog.LogReason.GANG_BUILDING_LEVELUP_SILVER_DONATE_REM))) {
/* 69 */       GangManager.sendNormalResult(this.roleId, 40, new Object[] { Integer.valueOf(cfg.needBangGong) });
/*    */       
/* 71 */       return false;
/*    */     }
/* 73 */     xGangMember.setLasthavemifangtime(curTime);
/* 74 */     int totalCount = CommonUtils.random(cfg.lowTime, cfg.maxTime);
/* 75 */     xGangMember.setMakemifangcount(0);
/* 76 */     xGangMember.setTotalmakemifangcount(totalCount);
/*    */     
/* 78 */     TaskInterface.activeGraph(Long.valueOf(this.roleId), GangMiFangConst.getInstance().TASK_GRAPH_ID);
/*    */     
/* 80 */     SSyncGangMiFangInfo sSyncGangMiFangInfo = new SSyncGangMiFangInfo();
/* 81 */     GangManager.fillMiFang(xMiFang, xGangMember, sSyncGangMiFangInfo.mifanginfo);
/* 82 */     OnlineManager.getInstance().send(this.roleId, sSyncGangMiFangInfo);
/* 83 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PGetGangMiFangReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */