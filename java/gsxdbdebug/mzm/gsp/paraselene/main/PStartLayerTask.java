/*     */ package mzm.gsp.paraselene.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.paraselene.confbean.SParaseleneActivitySeq;
/*     */ import mzm.gsp.paraselene.confbean.SParaseleneCfgConsts;
/*     */ import mzm.gsp.question.main.QuestionInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Paraselene;
/*     */ import xtable.Role2paraselene;
/*     */ 
/*     */ public class PStartLayerTask extends LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private int npcid;
/*     */   private int npcservice;
/*     */   
/*     */   public PStartLayerTask(long roleid, int npcid, int npcservice)
/*     */   {
/*  29 */     this.roleid = roleid;
/*  30 */     this.npcid = npcid;
/*  31 */     this.npcservice = npcservice;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (!OpenInterface.getOpenStatus(12))
/*     */     {
/*  40 */       String logstr = String.format("[paraselene]PStartLayerTask.processImp@Paraselene switch is closed roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*  42 */       ParaseleneManager.logger.info(logstr);
/*  43 */       return false;
/*     */     }
/*  45 */     if (!NpcInterface.checkNpcService(this.npcid, this.npcservice, this.roleid))
/*     */     {
/*  47 */       return false;
/*     */     }
/*  49 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleid, false);
/*  50 */     if (teamId == null)
/*     */     {
/*  52 */       ParaseleneManager.sendErrorInfo(this.roleid, 1);
/*  53 */       return false;
/*     */     }
/*  55 */     if (!TeamInterface.isTeamLeader(teamId.longValue(), this.roleid, false))
/*     */     {
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     if (!ParaseleneManager.checkTeam(this.roleid, teamId.longValue()))
/*     */     {
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     List<Long> memlist = TeamInterface.getNormalRoleList(this.roleid);
/*     */     
/*  67 */     SParaseleneActivitySeq pa = ParaseleneManager.getParaseleneActivityBynpcser(this.npcid, this.npcservice);
/*  68 */     if (pa == null)
/*     */     {
/*  70 */       return false;
/*     */     }
/*  72 */     if (!ParaseleneManager.canAcceptLayerTask(this.roleid, pa.layer))
/*     */     {
/*  74 */       ParaseleneManager.sendErrorInfo(this.roleid, 5);
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     if ((pa.npcservice != this.npcservice) || (pa.npcid != this.npcid))
/*     */     {
/*  80 */       return false;
/*     */     }
/*  82 */     switch (pa.tasktype)
/*     */     {
/*     */     case 1: 
/*  85 */       ParaseleneFightContext context = new ParaseleneFightContext(pa.contentid, pa.layer, FightReason.PARASELENE_ACTIVITY_FIGHT);
/*     */       
/*     */ 
/*  88 */       FightInterface.startPVEFight(this.roleid, pa.contentid, context, FightReason.PARASELENE_ACTIVITY_FIGHT);
/*  89 */       break;
/*     */     case 4: 
/*  91 */       ParaseleneJigsawContext jigsawContext = new ParaseleneJigsawContext(pa.layer);
/*     */       
/*  93 */       JigsawInterface.startJigsaw(memlist, pa.contentid, jigsawContext);
/*  94 */       break;
/*     */     case 2: 
/*  96 */       WordQuestionContext wordQuestionContext = new WordQuestionContext(SParaseleneCfgConsts.getInstance().ActivityId, pa.layer);
/*     */       
/*     */ 
/*  99 */       QuestionInterface.startHuanYueDongFuWordQuestion(memlist, pa.contentid, wordQuestionContext);
/* 100 */       break;
/*     */     case 3: 
/* 102 */       PictureQuestionContext pic = new PictureQuestionContext(SParaseleneCfgConsts.getInstance().ActivityId, pa.layer, pa.contentid);
/*     */       
/*     */ 
/* 105 */       QuestionInterface.preparePictureQuestion(memlist, pa.contentid, pic);
/*     */       
/* 107 */       break;
/*     */     
/*     */     default: 
/* 110 */       return false;
/*     */     }
/* 112 */     for (Iterator i$ = memlist.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */       
/* 114 */       ActivityInterface.logActivity(r, SParaseleneCfgConsts.getInstance().ActivityId, ActivityLogStatus.ATTEND);
/* 115 */       ActivityInterface.tlogActivity(r, SParaseleneCfgConsts.getInstance().ActivityId, ActivityLogStatus.ATTEND);
/* 116 */       Paraselene paraselene = ParaseleneManager.getParaselene(r, true);
/* 117 */       if (paraselene == null)
/*     */       {
/* 119 */         paraselene = xbean.Pod.newParaselene();
/*     */         
/* 121 */         Role2paraselene.insert(Long.valueOf(r), paraselene);
/*     */       }
/* 123 */       if (paraselene.getLayers().isEmpty())
/*     */       {
/* 125 */         paraselene.setStarttime(DateTimeUtils.getCurrTimeInMillis());
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 130 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\PStartLayerTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */