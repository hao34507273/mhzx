/*     */ package mzm.gsp.qingyunzhi.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.chivalry.main.ChivalryInterface;
/*     */ import mzm.gsp.fight.event.PVEFightEndArg;
/*     */ import mzm.gsp.fight.event.PVEFightEndProcedure;
/*     */ import mzm.gsp.fight.main.FightContext;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingyunzhi.SNoMoreAwardNotice;
/*     */ import mzm.gsp.qingyunzhi.SSynHelpAwardInfo;
/*     */ import mzm.gsp.qingyunzhi.confbean.QingConsts;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HelpData;
/*     */ import xbean.Pod;
/*     */ import xbean.Progress;
/*     */ import xbean.QingData;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2qingyun;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnPVEFightEnd extends PVEFightEndProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  44 */     Set<Long> needDoHelpAwardRoleIds = new HashSet();
/*     */     
/*  46 */     QingFightBean qingBean = new QingFightBean();
/*  47 */     List<Long> allRoles = new ArrayList(((PVEFightEndArg)this.arg).roleList);
/*  48 */     switch (beforeLock(allRoles, qingBean))
/*     */     {
/*     */     case -1: 
/*  51 */       return false;
/*     */     case 0: 
/*  53 */       return true;
/*     */     }
/*     */     
/*     */     
/*     */ 
/*     */ 
/*  59 */     Map<Long, String> roleId2userId = lockAllUser(allRoles);
/*  60 */     if (roleId2userId == null)
/*     */     {
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     lock(Basic.getTable(), allRoles);
/*  66 */     if (!setFixAwardId(qingBean))
/*     */     {
/*  68 */       return false;
/*     */     }
/*  70 */     if (!doQingAwardAll(allRoles, roleId2userId, qingBean, needDoHelpAwardRoleIds))
/*     */     {
/*  72 */       GameServer.logger().error(String.format("[qing]POnPVEFightEnd.processImp@ doQingAwardAll err!|roleIds=%s", new Object[] { roleId2userId.keySet() }));
/*     */       
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     asynDoHelpAward(needDoHelpAwardRoleIds, qingBean.getxType());
/*  78 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int beforeLock(List<Long> allRoles, QingFightBean qingBean)
/*     */   {
/*  89 */     if (!initData(qingBean))
/*     */     {
/*  91 */       return -1;
/*     */     }
/*  93 */     if (!((PVEFightEndArg)this.arg).isPlayerWin)
/*     */     {
/*  95 */       tlogRolesFail(allRoles, qingBean);
/*  96 */       return 0;
/*     */     }
/*  98 */     allRoles.removeAll(((PVEFightEndArg)this.arg).escapedRoles);
/*  99 */     if (allRoles.size() == 0)
/*     */     {
/* 101 */       return -1;
/*     */     }
/* 103 */     tlogRolesEscaped(qingBean);
/* 104 */     return 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void tlogRolesEscaped(QingFightBean qingBean)
/*     */   {
/* 112 */     RoleQingManager.tlogAllRoleQingInfo(qingBean.xType, ((PVEFightEndArg)this.arg).escapedRoles, 3, qingBean.context.getChapter(), qingBean.context.getSection(), qingBean.passTime);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean setFixAwardId(QingFightBean qingBean)
/*     */   {
/* 123 */     qingBean.fixAwardId = RoleQingManager.getAwardIdBy(qingBean.xType, qingBean.context.getChapter(), qingBean.context.getSection());
/*     */     
/* 125 */     if (qingBean.fixAwardId > 0)
/*     */     {
/* 127 */       return true;
/*     */     }
/* 129 */     if (GameServer.logger().isDebugEnabled())
/*     */     {
/* 131 */       GameServer.logger().debug(String.format("[qingyunzhi]POnPVEFightEnd.processImp@get fixAwardId error!|type=%d|chapterId=%d|sectionId=%d", new Object[] { Integer.valueOf(qingBean.xType), Integer.valueOf(qingBean.context.getChapter()), Integer.valueOf(qingBean.context.getSection()) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 136 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void tlogRolesFail(List<Long> allRoles, QingFightBean qingBean)
/*     */   {
/* 146 */     if ((allRoles.size() == 0) && (((PVEFightEndArg)this.arg).escapedRoles.size() > 0))
/*     */     {
/* 148 */       allRoles.addAll(((PVEFightEndArg)this.arg).escapedRoles);
/*     */     }
/* 150 */     RoleQingManager.tlogAllRoleQingInfo(qingBean.xType, allRoles, 3, qingBean.context.getChapter(), qingBean.context.getSection(), qingBean.passTime);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean initData(QingFightBean qingBean)
/*     */   {
/* 161 */     FightContext fightContextontext = ((PVEFightEndArg)this.arg).context;
/* 162 */     if (!(fightContextontext instanceof QingFightContext))
/*     */     {
/* 164 */       return false;
/*     */     }
/* 166 */     qingBean.context = ((QingFightContext)fightContextontext);
/* 167 */     long curTime = TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis());
/* 168 */     qingBean.passTime = (curTime - qingBean.context.getCurTime());
/* 169 */     qingBean.xType = qingBean.context.getOutPostType();
/* 170 */     qingBean.xiaValue = QingConsts.getInstance().XIAYI_VALUE;
/* 171 */     return true;
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
/*     */   private boolean doQingAwardAll(List<Long> allRoles, Map<Long, String> roleId2userId, QingFightBean qingBean, Set<Long> needDoHelpAwardRoleIds)
/*     */   {
/* 186 */     if (!awardPassAwardTo(allRoles, roleId2userId, qingBean))
/*     */     {
/* 188 */       return false;
/*     */     }
/*     */     
/* 191 */     if (!awardHelpTo(allRoles, qingBean, needDoHelpAwardRoleIds))
/*     */     {
/* 193 */       return false;
/*     */     }
/* 195 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean awardPassAwardTo(List<Long> allRoles, Map<Long, String> roleId2userId, QingFightBean qingBean)
/*     */   {
/* 207 */     for (Iterator i$ = allRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 209 */       QingData xQingData = Role2qingyun.get(Long.valueOf(roleId));
/* 210 */       if (xQingData != null)
/*     */       {
/*     */ 
/*     */ 
/* 214 */         Progress xProgress = (Progress)xQingData.getType2progress().get(Integer.valueOf(qingBean.xType));
/* 215 */         if (xProgress != null)
/*     */         {
/*     */ 
/*     */ 
/* 219 */           int chapter_own = xProgress.getChapter();
/* 220 */           int section_own = xProgress.getSection();
/* 221 */           RoleQingManager.tlogQing(roleId, qingBean.xType, chapter_own, section_own, qingBean.context.getChapter(), qingBean.context.getSection(), 2, qingBean.passTime);
/*     */           
/* 223 */           if (!doQingAward((String)roleId2userId.get(Long.valueOf(roleId)), roleId, xProgress, qingBean))
/*     */           {
/* 225 */             return false; }
/*     */         }
/*     */       } }
/* 228 */     return true;
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
/*     */   private boolean doQingAward(String userId, long roleId, Progress xProgress, QingFightBean qingBean)
/*     */   {
/* 242 */     if (!RoleQingManager.isProcessing(qingBean.context.getChapter(), qingBean.context.getSection(), xProgress, qingBean.xType))
/*     */     {
/*     */ 
/* 245 */       return true;
/*     */     }
/* 247 */     if (!doPassSectionAward(userId, roleId, xProgress, qingBean))
/*     */     {
/* 249 */       return false;
/*     */     }
/* 251 */     qingBean.roleInProcessing.add(Long.valueOf(roleId));
/* 252 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean awardHelpTo(List<Long> allRoles, QingFightBean qingBean, Set<Long> needDoHelpAwardRoleIds)
/*     */   {
/* 263 */     if (qingBean.roleInProcessing.size() == 0)
/*     */     {
/* 265 */       return true;
/*     */     }
/* 267 */     for (Iterator i$ = allRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 269 */       if (!qingBean.roleInProcessing.contains(Long.valueOf(roleId)))
/*     */       {
/*     */ 
/*     */ 
/* 273 */         needDoHelpAwardRoleIds.add(Long.valueOf(roleId));
/*     */         
/* 275 */         awardChivalryTo(roleId, qingBean);
/*     */       } }
/* 277 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void asynDoHelpAward(Set<Long> roleIds, int xType)
/*     */   {
/* 288 */     if (!OpenInterface.getOpenStatus(368))
/*     */     {
/* 290 */       return;
/*     */     }
/* 292 */     if ((roleIds == null) || (roleIds.size() == 0))
/*     */     {
/* 294 */       return;
/*     */     }
/* 296 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { final long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 298 */       new LogicProcedure()
/*     */       {
/*     */ 
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/* 304 */           return POnPVEFightEnd.this.doHelpAward(roleId, this.val$xType);
/*     */         }
/*     */       }.execute();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   boolean doHelpAward(long roleId, int xType)
/*     */   {
/* 313 */     String userId = RoleInterface.getUserId(roleId);
/* 314 */     Lockeys.lock(User.getTable(), Arrays.asList(new String[] { userId }));
/*     */     
/* 316 */     QingData xQData = Role2qingyun.get(Long.valueOf(roleId));
/* 317 */     if (xQData == null)
/*     */     {
/* 319 */       return false;
/*     */     }
/* 321 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 322 */     HelpData xHelpData = (HelpData)xQData.getType2helpdata().get(Integer.valueOf(xType));
/* 323 */     if (xHelpData == null)
/*     */     {
/* 325 */       xQData.getType2helpdata().put(Integer.valueOf(xType), xHelpData = Pod.newHelpData());
/* 326 */       xHelpData.setHelptime(curTime);
/*     */     }
/* 328 */     if (DateTimeUtils.needDailyReset(xHelpData.getHelptime(), curTime, 0))
/*     */     {
/* 330 */       xHelpData.setHelpcount(0);
/* 331 */       xHelpData.setHelptime(curTime);
/*     */     }
/* 333 */     int cfgHelpCountMax = getHelpCountMax(xType);
/* 334 */     if (cfgHelpCountMax <= 0)
/*     */     {
/* 336 */       GameServer.logger().warn(String.format("[qing]POnPVEFightEnd.doHelpAward@ cfgHelpCountMax is not valid!|roleId=%d|xType=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(xType) }));
/*     */       
/*     */ 
/* 339 */       return false;
/*     */     }
/* 341 */     if (xHelpData.getHelpcount() >= cfgHelpCountMax)
/*     */     {
/* 343 */       OnlineManager.getInstance().sendAtOnce(roleId, new SNoMoreAwardNotice(xType));
/* 344 */       return false;
/*     */     }
/* 346 */     int awardId = getHelpAwardId(xType);
/* 347 */     if (awardId <= 0)
/*     */     {
/* 349 */       GameServer.logger().warn(String.format("[qing]POnPVEFightEnd.doHelpAward@ awardId is not valid!|roleId=%d|xType=%d|awardId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(xType), Integer.valueOf(awardId) }));
/*     */       
/*     */ 
/* 352 */       return false;
/*     */     }
/* 354 */     AwardModel awardModel = AwardInterface.award(awardId, userId, roleId, false, false, new AwardReason(LogReason.QING_HELP_AWARD_ADD));
/*     */     
/* 356 */     if (awardModel == null)
/*     */     {
/* 358 */       GameServer.logger().warn(String.format("[qing]POnPVEFightEnd.doHelpAward@ do awardId err!|roleId=%d|xType=%d|awardId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(xType), Integer.valueOf(awardId) }));
/*     */       
/*     */ 
/* 361 */       return false;
/*     */     }
/*     */     
/* 364 */     xHelpData.setHelpcount(xHelpData.getHelpcount() + 1);
/*     */     
/* 366 */     synHelpData(roleId, xType, cfgHelpCountMax - xHelpData.getHelpcount(), awardModel);
/* 367 */     return true;
/*     */   }
/*     */   
/*     */   private void synHelpData(long roleId, int xType, int lefthelpcount, AwardModel awardModel)
/*     */   {
/* 372 */     SSynHelpAwardInfo p = new SSynHelpAwardInfo();
/* 373 */     p.lefthelpcount = lefthelpcount;
/* 374 */     p.outposttype = xType;
/* 375 */     AwardInterface.fillAwardBean(p.awardbean, awardModel);
/* 376 */     OnlineManager.getInstance().send(roleId, p);
/*     */   }
/*     */   
/*     */   int getHelpCountMax(int xType)
/*     */   {
/* 381 */     switch (xType)
/*     */     {
/*     */     case 2: 
/* 384 */       return QingConsts.getInstance().HELP_ELITE_COUNT_MAX;
/*     */     
/*     */     case 3: 
/* 387 */       return QingConsts.getInstance().HELP_HERO_COUNT_MAX;
/*     */     }
/*     */     
/* 390 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   int getHelpAwardId(int xType)
/*     */   {
/* 396 */     switch (xType)
/*     */     {
/*     */     case 2: 
/* 399 */       return QingConsts.getInstance().HELP_ELITE_AWARD_ID;
/*     */     
/*     */     case 3: 
/* 402 */       return QingConsts.getInstance().HELP_HERO_AWARD_ID;
/*     */     }
/*     */     
/* 405 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void awardChivalryTo(long roleId, QingFightBean qingBean)
/*     */   {
/* 417 */     ChivalryInterface.addRoleChivalry(roleId, qingBean.xiaValue, 6, new TLogArg(LogReason.QING_AWARD_ADD), true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean doPassSectionAward(String userId, long roleId, Progress xProgress, QingFightBean qingBean)
/*     */   {
/* 424 */     AwardModel awardModel = AwardInterface.awardFixAward(qingBean.fixAwardId, userId, roleId, false, true, new AwardReason(LogReason.QING_AWARD_ADD));
/*     */     
/* 426 */     if (awardModel == null)
/*     */     {
/* 428 */       RoleQingManager.loggerError(String.format("[qingyunzhi]POnPVEFightEnd.doPassSectionAward@award fixAward error!|roleId=%d|type=%d|chapterId=%d|sectionId=%d|fixAwardId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(qingBean.xType), Integer.valueOf(qingBean.context.getChapter()), Integer.valueOf(qingBean.context.getSection()), Integer.valueOf(qingBean.fixAwardId) }));
/*     */       
/*     */ 
/* 431 */       return false;
/*     */     }
/*     */     
/* 434 */     if (!RoleQingManager.addProgress(roleId, xProgress, qingBean.xType))
/*     */     {
/* 436 */       return false;
/*     */     }
/* 438 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private Map<Long, String> lockAllUser(List<Long> members)
/*     */   {
/* 449 */     if ((members == null) || (members.size() == 0))
/*     */     {
/* 451 */       return null;
/*     */     }
/* 453 */     Map<Long, String> roleId2userId = new HashMap();
/* 454 */     for (Iterator i$ = members.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 456 */       String userid = RoleInterface.getUserId(roleId);
/* 457 */       roleId2userId.put(Long.valueOf(roleId), userid);
/*     */     }
/* 459 */     if (roleId2userId.size() == 0)
/*     */     {
/* 461 */       return null;
/*     */     }
/*     */     
/* 464 */     lock(User.getTable(), roleId2userId.values());
/* 465 */     return roleId2userId;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyunzhi\main\POnPVEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */