/*     */ package mzm.gsp.memorycompetition.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity2.confbean.SMemoryCompetitionCfg;
/*     */ import mzm.gsp.memorycompetition.SMemoryCompetitionNormalFail;
/*     */ import mzm.gsp.memorycompetition.SMemoryCompetitionSeekHelpNotify;
/*     */ import mzm.gsp.memorycompetition.SMemoryCompetitionSeekHelpSuccess;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MemoryCompetitionInfo;
/*     */ import xtable.Role2memorycompetition;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCMemoryCompetitionSeekHelp extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private long memoryCompetitionId;
/*     */   
/*     */   public PCMemoryCompetitionSeekHelp(long roleId)
/*     */   {
/*  25 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  31 */     if (!MemoryCompetitionManager.isMemoryCompetitionFunOpen(this.roleId))
/*     */     {
/*  33 */       return false;
/*     */     }
/*     */     
/*  36 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  37 */     lock(xdb.Lockeys.get(User.getTable(), userId));
/*     */     
/*     */ 
/*  40 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 923, true, true))
/*     */     {
/*     */ 
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     Long xMemoryCompetitioId = Role2memorycompetition.get(Long.valueOf(this.roleId));
/*  47 */     if (xMemoryCompetitioId == null)
/*     */     {
/*  49 */       onMemoryCompetitionSeekHelpFail(1);
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     this.memoryCompetitionId = xMemoryCompetitioId.longValue();
/*     */     
/*  55 */     MemoryCompetitionInfo xMemoryCompetitionInfo = xtable.Memorycompetition.get(Long.valueOf(this.memoryCompetitionId));
/*  56 */     if (xMemoryCompetitionInfo == null)
/*     */     {
/*  58 */       onMemoryCompetitionSeekHelpFail(2);
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     MemoryCompetitionQuestionObserver questionObserver = xMemoryCompetitionInfo.getRoles_current_question_observer();
/*  63 */     if (questionObserver == null)
/*     */     {
/*  65 */       onMemoryCompetitionSeekHelpFail(3);
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     SMemoryCompetitionCfg competitionCfg = SMemoryCompetitionCfg.get(xMemoryCompetitionInfo.getMemory_competition_cfg_id());
/*  70 */     if (competitionCfg == null)
/*     */     {
/*  72 */       onMemoryCompetitionSeekHelpFail(11);
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     if (questionObserver.isAleardySeekHelp(this.roleId))
/*     */     {
/*  78 */       onMemoryCompetitionSeekHelpFail(4);
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     if (questionObserver.isAleardyAnswered(this.roleId))
/*     */     {
/*  84 */       onMemoryCompetitionSeekHelpFail(5);
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     Map<Long, Integer> xRolesSeekHelpTimesMap = xMemoryCompetitionInfo.getRoles_seek_help_times_map();
/*     */     
/*  90 */     Integer nowSeekHelpTimes = (Integer)xRolesSeekHelpTimesMap.get(Long.valueOf(this.roleId));
/*  91 */     if (nowSeekHelpTimes == null)
/*     */     {
/*  93 */       nowSeekHelpTimes = new Integer(0);
/*     */     }
/*     */     
/*  96 */     if (nowSeekHelpTimes.intValue() >= competitionCfg.seek_help_times)
/*     */     {
/*  98 */       onMemoryCompetitionSeekHelpFail(6);
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     questionObserver.setSeekHelpState(this.roleId);
/*     */     
/* 104 */     xRolesSeekHelpTimesMap.put(Long.valueOf(this.roleId), nowSeekHelpTimes = Integer.valueOf(nowSeekHelpTimes.intValue() + 1));
/*     */     
/* 106 */     SMemoryCompetitionSeekHelpNotify seekHelpNotify = new SMemoryCompetitionSeekHelpNotify();
/* 107 */     seekHelpNotify.activity_cfg_id = xMemoryCompetitionInfo.getActivity_cfg_id();
/* 108 */     seekHelpNotify.seek_help_role_id = this.roleId;
/*     */     
/* 110 */     List<Long> xRoleIdList = xMemoryCompetitionInfo.getRole_id_list();
/* 111 */     for (Iterator i$ = xRoleIdList.iterator(); i$.hasNext();) { long gameRoleId = ((Long)i$.next()).longValue();
/*     */       
/* 113 */       if (this.roleId != gameRoleId)
/*     */       {
/*     */ 
/*     */ 
/* 117 */         OnlineManager.getInstance().send(gameRoleId, seekHelpNotify);
/*     */       }
/*     */     }
/* 120 */     SMemoryCompetitionSeekHelpSuccess seekHelpSuccess = new SMemoryCompetitionSeekHelpSuccess();
/* 121 */     seekHelpSuccess.activity_cfg_id = xMemoryCompetitionInfo.getActivity_cfg_id();
/* 122 */     seekHelpSuccess.left_seek_help_times = (competitionCfg.seek_help_times - nowSeekHelpTimes.intValue());
/*     */     
/* 124 */     OnlineManager.getInstance().send(this.roleId, seekHelpSuccess);
/*     */     
/* 126 */     GameServer.logger().info(String.format("[memorycompetition]PCMemoryCompetitionSeekHelp.processImp@handle seek help success|role_id=%d|memory_competition_id=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.memoryCompetitionId) }));
/*     */     
/*     */ 
/*     */ 
/* 130 */     return true;
/*     */   }
/*     */   
/*     */   private void onMemoryCompetitionSeekHelpFail(int ret)
/*     */   {
/* 135 */     onMemoryCompetitionSeekHelpFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onMemoryCompetitionSeekHelpFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 140 */     StringBuilder sbLog = new StringBuilder();
/* 141 */     sbLog.append("[memorycompetition]PCMemoryCompetitionSeekHelp.processImp@memory competition seek help failed");
/* 142 */     sbLog.append("|ret=").append(ret);
/* 143 */     sbLog.append("|role_id=").append(this.roleId);
/* 144 */     sbLog.append("|memory_competition_id=").append(this.memoryCompetitionId);
/*     */     
/* 146 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 148 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 150 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 153 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 155 */     SMemoryCompetitionNormalFail sMemoryCompetitionNormalFail = new SMemoryCompetitionNormalFail();
/* 156 */     sMemoryCompetitionNormalFail.result = ret;
/*     */     
/* 158 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sMemoryCompetitionNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\main\PCMemoryCompetitionSeekHelp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */