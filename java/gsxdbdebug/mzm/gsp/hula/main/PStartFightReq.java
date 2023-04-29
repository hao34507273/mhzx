/*     */ package mzm.gsp.hula.main;
/*     */ 
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.hula.confbean.SDoudouCfg;
/*     */ import mzm.gsp.hula.confbean.SHulaCfgConsts;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HulaInfo;
/*     */ import xbean.HulaMonsterInfo;
/*     */ import xbean.HulaWorldInfo;
/*     */ import xtable.Hulaworld;
/*     */ import xtable.Role2hula;
/*     */ 
/*     */ public class PStartFightReq extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int seq;
/*     */   
/*     */   public PStartFightReq(long roleid, int seq)
/*     */   {
/*  27 */     this.roleid = roleid;
/*  28 */     this.seq = seq;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     if (this.seq <= 0)
/*     */     {
/*  37 */       return false;
/*     */     }
/*  39 */     if (!HulaManager.isHulaSwitchOpenForRole(this.roleid))
/*     */     {
/*  41 */       return false;
/*     */     }
/*  43 */     if (!HulaManager.isInHulaFubenWorld(this.roleid))
/*     */     {
/*  45 */       String logstr = String.format("[hula]PStartFightReq.processImp@role not in hula world|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  46 */       HulaManager.logger.info(logstr);
/*  47 */       return false;
/*     */     }
/*  49 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 450, true))
/*     */     {
/*  51 */       String log = String.format("[hula]PStartFightReq.processImp@role status can not kill monster|roleid=%d|seq=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.seq) });
/*     */       
/*  53 */       HulaManager.logger.info(log);
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleid);
/*  58 */     if ((teamInfo != null) && (teamInfo.getLeaderId() != this.roleid) && (teamInfo.getMemberStatus(this.roleid) == 0))
/*     */     {
/*  60 */       String log = String.format("[hula]PStartFightReq.processImp@role in team not leader can not fight with monster|roleid=%d|seq=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.seq) });
/*     */       
/*     */ 
/*  63 */       HulaManager.logger.info(log);
/*  64 */       return false;
/*     */     }
/*  66 */     int stage = ActivityInterface.getActivityStage(SHulaCfgConsts.getInstance().ACTIVITY_ID);
/*  67 */     if (!HulaManager.isThisStage(stage, 1))
/*     */     {
/*  69 */       String log = String.format("[hula]PStartFightReq.processImp@now stage|stage=%d|roleid=%d|seq=%d", new Object[] { Integer.valueOf(stage), Long.valueOf(this.roleid), Integer.valueOf(this.seq) });
/*     */       
/*  71 */       HulaManager.logger.info(log);
/*  72 */       return false;
/*     */     }
/*  74 */     HulaInfo xHulaInfo = Role2hula.get(Long.valueOf(this.roleid));
/*  75 */     if (xHulaInfo == null)
/*     */     {
/*  77 */       String log = String.format("[hula]PStartFightReq.processImp@xHulaInfo is null|stage=%d|roleid=%d|seq=%d", new Object[] { Integer.valueOf(stage), Long.valueOf(this.roleid), Integer.valueOf(this.seq) });
/*     */       
/*  79 */       HulaManager.logger.info(log);
/*  80 */       return false;
/*     */     }
/*  82 */     long worldid = xHulaInfo.getWorldid();
/*  83 */     long key = GameServerInfoManager.toGlobalId(worldid);
/*  84 */     HulaWorldInfo xHulaWorldInfo = Hulaworld.get(Long.valueOf(key));
/*  85 */     if (xHulaWorldInfo == null)
/*     */     {
/*  87 */       String log = String.format("[hula]PStartFightReq.processImp@xHulaWorldInfo is null|stage=%d|roleid=%d|seq=%d|worldid=%d", new Object[] { Integer.valueOf(stage), Long.valueOf(this.roleid), Integer.valueOf(this.seq), Long.valueOf(worldid) });
/*     */       
/*     */ 
/*  90 */       HulaManager.logger.info(log);
/*  91 */       return false;
/*     */     }
/*  93 */     if (!xHulaWorldInfo.getRoleids().contains(Long.valueOf(this.roleid)))
/*     */     {
/*  95 */       String log = String.format("[hula]PStartFightReq.processImp@xHulaWorldInfo no this roleid|stage=%d|roleid=%d|seq=%d", new Object[] { Integer.valueOf(stage), Long.valueOf(this.roleid), Integer.valueOf(this.seq) });
/*     */       
/*     */ 
/*  98 */       HulaManager.logger.info(log);
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     int fightCfgId = -1;
/* 103 */     int modelId = -1;
/* 104 */     for (HulaMonsterInfo xHulaMonsterInfo : xHulaWorldInfo.getMonsters())
/*     */     {
/* 106 */       if ((xHulaMonsterInfo.getSeq() == this.seq) && (checkState(stage, xHulaMonsterInfo)))
/*     */       {
/* 108 */         modelId = xHulaMonsterInfo.getMonsterid();
/* 109 */         fightCfgId = SDoudouCfg.get(modelId).fightCfgId;
/* 110 */         xHulaMonsterInfo.setState(4);
/* 111 */         break;
/*     */       }
/*     */     }
/* 114 */     if ((fightCfgId == -1) || (modelId == -1))
/*     */     {
/* 116 */       String log = String.format("[hula]PStartFightReq.processImp@seq error or monster state error|stage=%d|roleid=%d|seq=%d", new Object[] { Integer.valueOf(stage), Long.valueOf(this.roleid), Integer.valueOf(this.seq) });
/*     */       
/*     */ 
/* 119 */       HulaManager.logger.info(log);
/* 120 */       return false;
/*     */     }
/*     */     
/* 123 */     HulaFightContext fightContext = new HulaFightContext(this.roleid, worldid, this.seq, modelId, fightCfgId, FightReason.HULA_FIGHT_KILL_MONSTER);
/*     */     
/* 125 */     FightInterface.startPVEFight(this.roleid, fightCfgId, fightContext, 16, FightReason.HULA_FIGHT_KILL_MONSTER);
/*     */     
/* 127 */     String log = String.format("[hula]PStartFightReq.processImp@start fight run to here|stage=%d|roleid=%d|seq=%d|modelId=%d", new Object[] { Integer.valueOf(stage), Long.valueOf(this.roleid), Integer.valueOf(this.seq), Integer.valueOf(modelId) });
/*     */     
/*     */ 
/* 130 */     HulaManager.logger.info(log);
/* 131 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean checkState(int stage, HulaMonsterInfo xHulaMonsterInfo)
/*     */   {
/* 137 */     if (xHulaMonsterInfo.getState() != 1)
/*     */     {
/* 139 */       String log = String.format("[hula]PStartFightReq.checkState@monster state is not alive|stage=%d|roleid=%d|seq=%d|state=%d", new Object[] { Integer.valueOf(stage), Long.valueOf(this.roleid), Integer.valueOf(this.seq), Integer.valueOf(xHulaMonsterInfo.getState()) });
/*     */       
/*     */ 
/* 142 */       HulaManager.logger.info(log);
/*     */       
/* 144 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 148 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\main\PStartFightReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */