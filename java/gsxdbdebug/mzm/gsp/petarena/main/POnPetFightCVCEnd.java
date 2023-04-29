/*     */ package mzm.gsp.petarena.main;
/*     */ 
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fight.event.PetFightCVCEndArg;
/*     */ import mzm.gsp.petarena.confbean.SPetArenaConst;
/*     */ import mzm.gsp.petarena.confbean.SPetArenaModifyCfg;
/*     */ import mzm.gsp.petarena.event.PetArenaRankChangedArg;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PetArenaFightAward;
/*     */ import xbean.PetArenaInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnPetFightCVCEnd extends mzm.gsp.fight.event.PetFightCVCEndProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  21 */     mzm.gsp.fight.main.FightContext fightContext = ((PetFightCVCEndArg)this.arg).context;
/*  22 */     if (!(fightContext instanceof PetCVCFightContext))
/*     */     {
/*  24 */       return false;
/*     */     }
/*     */     
/*  27 */     PetCVCFightContext context = (PetCVCFightContext)fightContext;
/*  28 */     boolean win = ((PetFightCVCEndArg)this.arg).isActiveWin;
/*  29 */     RankInfo activeRankInfo = context.activeRankInfo;
/*  30 */     RankInfo passiveRankInfo = context.passiveRankInfo;
/*  31 */     long activeRoleid = activeRankInfo.roleid;
/*  32 */     long passiveRoleid = passiveRankInfo.roleid;
/*  33 */     java.util.Map<Long, Integer> damages = ((PetFightCVCEndArg)this.arg).petDamages;
/*     */     
/*     */ 
/*  36 */     String activeUserid = mzm.gsp.role.main.RoleInterface.getUserId(activeRoleid);
/*  37 */     if (passiveRoleid > 0L)
/*     */     {
/*  39 */       String passiveUserid = mzm.gsp.role.main.RoleInterface.getUserId(passiveRoleid);
/*  40 */       lock(Lockeys.get(User.getTable(), new Object[] { activeUserid, passiveUserid }));
/*  41 */       lock(Lockeys.get(Basic.getTable(), new Object[] { Long.valueOf(activeRoleid), Long.valueOf(passiveRoleid) }));
/*     */     }
/*     */     else
/*     */     {
/*  45 */       lock(Lockeys.get(User.getTable(), activeUserid));
/*  46 */       lock(Lockeys.get(Basic.getTable(), Long.valueOf(activeRoleid)));
/*     */     }
/*     */     
/*  49 */     PetArenaInfo xPetArenaInfo = xtable.Role2petarenainfo.get(Long.valueOf(activeRoleid));
/*  50 */     if (xPetArenaInfo == null)
/*     */     {
/*  52 */       GameServer.logger().error(String.format("[petarena]POnPetFightCVCEnd.processImp@system error|active_roleid=%d|passive_roleid=%d|win=%b", new Object[] { Long.valueOf(activeRoleid), Long.valueOf(passiveRoleid), Boolean.valueOf(win) }));
/*     */       
/*     */ 
/*     */ 
/*  56 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  60 */     int challengeCount = xPetArenaInfo.getChallenge_count();
/*  61 */     int addPointChallenge = SPetArenaConst.getInstance().ADD_POINT_FIGHT_MAX_NUM;
/*  62 */     int addPoint = 0;
/*  63 */     int award = 0;
/*  64 */     if (win)
/*     */     {
/*  66 */       xPetArenaInfo.setWin_num(xPetArenaInfo.getWin_num() + 1);
/*  67 */       if ((addPointChallenge == 0) || (challengeCount <= addPointChallenge))
/*     */       {
/*  69 */         addPoint = SPetArenaConst.getInstance().FIGHT_WIN_ADD_POINT;
/*     */       }
/*  71 */       award = SPetArenaConst.getInstance().FIGHT_WIN_AWARD;
/*     */     }
/*     */     else
/*     */     {
/*  75 */       xPetArenaInfo.setLose_num(xPetArenaInfo.getLose_num() + 1);
/*  76 */       if ((addPointChallenge == 0) || (challengeCount <= addPointChallenge))
/*     */       {
/*  78 */         addPoint = SPetArenaConst.getInstance().FIGHT_LOSE_ADD_POINT;
/*     */       }
/*  80 */       award = SPetArenaConst.getInstance().FIGHT_LOSE_AWARD;
/*     */     }
/*     */     
/*  83 */     SPetArenaModifyCfg modifyCfg = SPetArenaModifyCfg.get(challengeCount);
/*  84 */     if (modifyCfg == null)
/*     */     {
/*  86 */       GameServer.logger().error(String.format("[petarena]POnPetFightCVCEnd.processImp@modify cfg is null|active_roleid=%d|win=%b|award=%d|challenge=%d", new Object[] { Long.valueOf(activeRoleid), Boolean.valueOf(win), Integer.valueOf(award), Integer.valueOf(challengeCount) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  91 */     if ((award > 0) && (modifyCfg != null))
/*     */     {
/*  93 */       xPetArenaInfo.getAward().setAwardid(award);
/*  94 */       xPetArenaInfo.getAward().setModify_cfgid(modifyCfg.modifyCfgid);
/*     */     }
/*  96 */     xPetArenaInfo.getAward().setPoint(addPoint);
/*     */     
/*     */ 
/*  99 */     PetArenaManager.startPetAwardObserver(activeRoleid);
/*     */     
/* 101 */     if (passiveRoleid > 0L)
/*     */     {
/* 103 */       PetArenaInfo xPassivePetArenaInfo = xtable.Role2petarenainfo.get(Long.valueOf(passiveRoleid));
/* 104 */       if (xPassivePetArenaInfo == null)
/*     */       {
/* 106 */         GameServer.logger().error(String.format("[petarena]POnPetFightCVCEnd.processImp@passive xbean is null|active_roleid=%d|win=%b|passive_roleid=%d", new Object[] { Long.valueOf(activeRoleid), Boolean.valueOf(win), Long.valueOf(passiveRoleid) }));
/*     */         
/*     */ 
/*     */ 
/* 110 */         return false;
/*     */       }
/* 112 */       if (win)
/*     */       {
/* 114 */         xPassivePetArenaInfo.setDefend_lose_num(xPassivePetArenaInfo.getDefend_lose_num() + 1);
/*     */       }
/*     */       else
/*     */       {
/* 118 */         xPassivePetArenaInfo.setDefend_win_num(xPassivePetArenaInfo.getDefend_win_num() + 1);
/*     */       }
/*     */     }
/*     */     
/* 122 */     PetArenaFightResultContext resultContext = new PetArenaFightResultContext(((PetFightCVCEndArg)this.arg).recordid, damages, addPoint);
/* 123 */     if (win)
/*     */     {
/* 125 */       PetArenaRankManager.asyncUpdateRank(context, resultContext);
/* 126 */       GameServer.logger().info(String.format("[petarena]POnPetFightCVCEnd.processImp@update rank|active_roleid=%d|win=%b|passive_roleid=%d|challenge=%d", new Object[] { Long.valueOf(activeRoleid), Boolean.valueOf(win), Long.valueOf(passiveRoleid), Integer.valueOf(challengeCount) }));
/*     */       
/*     */ 
/*     */ 
/* 130 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 134 */     PetArenaRankChangedArg activeArg = new PetArenaRankChangedArg(activeRoleid, passiveRoleid, win, 0, activeRankInfo.rank, activeRankInfo.rank, false, true, context.activeInfos, context.passiveInfos, resultContext);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 139 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.petarena.event.PetArenaRankChanged(), activeArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(activeRoleid)));
/*     */     
/*     */ 
/* 142 */     if (passiveRoleid > 0L)
/*     */     {
/*     */ 
/* 145 */       PetArenaRankChangedArg passiveArg = new PetArenaRankChangedArg(passiveRoleid, activeRoleid, !win, 1, passiveRankInfo.rank, passiveRankInfo.rank, false, false, context.activeInfos, context.passiveInfos, resultContext);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 150 */       TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.petarena.event.PetArenaRankChanged(), passiveArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(passiveRoleid)));
/*     */     }
/*     */     
/*     */ 
/* 154 */     GameServer.logger().info(String.format("[petarena]POnPetFightCVCEnd.processImp@send msg success|active_roleid=%d|win=%b|passive_roleid=%d|challenge=%d", new Object[] { Long.valueOf(activeRoleid), Boolean.valueOf(win), Long.valueOf(passiveRoleid), Integer.valueOf(challengeCount) }));
/*     */     
/*     */ 
/*     */ 
/* 158 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\POnPetFightCVCEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */