/*     */ package mzm.gsp.qingyunzhi.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingyunzhi.confbean.QingConsts;
/*     */ import mzm.gsp.qingyunzhi.confbean.SQingYunZhiCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.QingData;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2qingyun;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCChallengeQing
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int outPostType;
/*     */   private final int chapter;
/*     */   private final int section;
/*     */   
/*     */   public PCChallengeQing(long roleId, int outPostType, int chapter, int section)
/*     */   {
/*  39 */     this.roleId = roleId;
/*  40 */     this.outPostType = outPostType;
/*  41 */     this.chapter = chapter;
/*  42 */     this.section = section;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  48 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/*  49 */     int xType = RoleQingManager.changeToXType(this.outPostType);
/*  50 */     if (xType < 0)
/*     */     {
/*  52 */       RoleQingManager.loggerError(String.format("[qingyunzhi]PCChallengeQing.processImp@illegal type!|roleId=%d|type=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.outPostType) }));
/*     */       
/*  54 */       return false;
/*     */     }
/*  56 */     SQingYunZhiCfg cfg = RoleQingManager.getQingCfgByPType(this.outPostType, this.chapter, this.section);
/*  57 */     if (cfg == null)
/*     */     {
/*  59 */       RoleQingManager.loggerError(String.format("[qingyunzhi]PCChallengeQing.processImp@ no cfg!|roleId=%d|type=%d|chapter=%d|section=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.outPostType), Integer.valueOf(this.chapter), Integer.valueOf(this.section) }));
/*     */       
/*     */ 
/*  62 */       return false;
/*     */     }
/*  64 */     int fightCfgId = cfg.fightCfgId;
/*  65 */     if (fightCfgId <= 0)
/*     */     {
/*  67 */       return false;
/*     */     }
/*  69 */     int openLevel = cfg.openLevel;
/*  70 */     int rolelevel = RoleInterface.getLevel(this.roleId);
/*  71 */     if (rolelevel < openLevel)
/*     */     {
/*  73 */       RoleQingManager.loggerError(String.format("[qingyunzhi]PCChallengeQing.processImp@ level illegal!|roleId=%d|type=%d|chapter=%d|section=%d|roleLevel=%d|needLevel", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.outPostType), Integer.valueOf(this.chapter), Integer.valueOf(this.section), Integer.valueOf(rolelevel), Integer.valueOf(openLevel) }));
/*     */       
/*     */ 
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     if (!MapInterface.isNearByNPC(this.roleId, QingConsts.getInstance().QING_NPC_ID))
/*     */     {
/*  81 */       RoleQingManager.loggerError(String.format("[qingyunzhi]PCChallengeQing.processImp@player is not near npc|roleid=%d|NPCid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(QingConsts.getInstance().QING_NPC_ID) }));
/*     */       
/*     */ 
/*  84 */       return false;
/*     */     }
/*  86 */     if ((teamInfo != null) && (teamInfo.isNormalState(this.roleId)))
/*     */     {
/*  88 */       long teamId = teamInfo.getTeamId();
/*  89 */       List<Long> lockRoles = teamInfo.getTeamNormalList();
/*  90 */       lock(Basic.getTable(), lockRoles);
/*     */       
/*  92 */       teamInfo = TeamInterface.getTeamInfo(teamId, true);
/*  93 */       List<Long> normalMembers = teamInfo.getTeamNormalList();
/*  94 */       if ((normalMembers.size() != lockRoles.size()) || (!normalMembers.containsAll(lockRoles)))
/*     */       {
/*  96 */         if (GameServer.logger().isDebugEnabled())
/*     */         {
/*  98 */           GameServer.logger().debug(String.format("[qingyunzhi]PCChallengeQing.processImp@team changed!|roleId=%d|type=%d|chapter=%d|section=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.outPostType), Integer.valueOf(this.chapter), Integer.valueOf(this.section) }));
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 103 */         return false;
/*     */       }
/* 105 */       for (Iterator i$ = normalMembers.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */         
/* 107 */         if (!RoleStatusInterface.checkCanSetStatus(roleId, 216, true))
/*     */         {
/* 109 */           return false;
/*     */         }
/*     */       }
/* 112 */       if (!teamChallengeQingPro(teamInfo.getLeaderId(), this.roleId, xType, fightCfgId, normalMembers, openLevel))
/*     */       {
/* 114 */         return false;
/*     */       }
/* 116 */       RoleQingManager.tlogAllRoleQingInfo(xType, normalMembers, 1, this.chapter, this.section, 0L);
/* 117 */       return true;
/*     */     }
/* 119 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 120 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 216, true))
/*     */     {
/* 122 */       return false;
/*     */     }
/* 124 */     if (!singleChallengeQingPro(this.roleId, xType, fightCfgId))
/*     */     {
/* 126 */       return false;
/*     */     }
/* 128 */     RoleQingManager.tlogAllRoleQingInfo(xType, Arrays.asList(new Long[] { Long.valueOf(this.roleId) }), 1, this.chapter, this.section, 0L);
/* 129 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean singleChallengeQingPro(long roleId, int xType, int fightCfgId)
/*     */   {
/* 142 */     if (!QingManager.isQingOpen(roleId))
/*     */     {
/* 144 */       return false;
/*     */     }
/* 146 */     QingData xQingData = Role2qingyun.get(Long.valueOf(roleId));
/* 147 */     if (!RoleQingManager.canChallengeQing(roleId, xType, xQingData, this.chapter, this.section))
/*     */     {
/* 149 */       RoleQingManager.sendNormalResult(roleId, 1, new String[0]);
/* 150 */       return false;
/*     */     }
/* 152 */     FightInterface.startPVEFight(roleId, fightCfgId, new QingFightContext(xType, this.chapter, this.section, Arrays.asList(new Long[] { Long.valueOf(roleId) }), TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis())), FightReason.QING_NORMAL_FIGHT);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 158 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean teamChallengeQingPro(long leaderId, long roleId, int xType, int fightCfgId, List<Long> normalMembers, int openLevel)
/*     */   {
/* 174 */     if (!checkBanQing(normalMembers, leaderId))
/*     */     {
/* 176 */       return false;
/*     */     }
/* 178 */     if (leaderId != roleId)
/*     */     {
/* 180 */       RoleQingManager.sendNormalResult(roleId, 3, new String[0]);
/* 181 */       return false;
/*     */     }
/* 183 */     if (xType == 1)
/*     */     {
/* 185 */       RoleQingManager.sendNormalResult(roleId, 4, new String[0]);
/* 186 */       return false;
/*     */     }
/* 188 */     if (!RoleQingManager.canChallengeQing(xType, normalMembers, this.chapter, this.section, openLevel))
/*     */     {
/* 190 */       return false;
/*     */     }
/* 192 */     FightInterface.startPVEFight(roleId, fightCfgId, new QingFightContext(xType, this.chapter, this.section, normalMembers, TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis())), FightReason.QING_ELITE_FIGHT);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 198 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean checkBanQing(List<Long> roleIds, long leaderId)
/*     */   {
/* 212 */     if (!OpenInterface.getOpenStatus(17))
/*     */     {
/* 214 */       return false;
/*     */     }
/* 216 */     List<Long> banRoleIds = QingManager.qingBanRoleIds(roleIds);
/* 217 */     if (banRoleIds.size() == 0)
/*     */     {
/* 219 */       return true;
/*     */     }
/*     */     
/* 222 */     long ranRoleId = ((Long)banRoleIds.get(0)).longValue();
/* 223 */     OpenInterface.sendBanPlayMsg(leaderId, ranRoleId, RoleInterface.getName(ranRoleId), 17);
/* 224 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyunzhi\main\PCChallengeQing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */