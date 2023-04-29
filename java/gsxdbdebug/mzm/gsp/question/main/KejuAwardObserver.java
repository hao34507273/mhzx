/*     */ package mzm.gsp.question.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.question.confbean.KeJuQuestionConsts;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Executor;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Xdb;
/*     */ import xtable.User;
/*     */ 
/*     */ class KejuAwardObserver extends Observer
/*     */ {
/*     */   public KejuAwardObserver(long intervalSeconds)
/*     */   {
/*  27 */     super(intervalSeconds);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  34 */     Xdb.executor().execute(new KejuAwardRunnable(this));
/*  35 */     return true;
/*     */   }
/*     */   
/*     */   private static class KejuAwardRunnable extends LogicRunnable
/*     */   {
/*     */     private KejuAwardObserver kejuAwardObserver;
/*     */     
/*     */     public KejuAwardRunnable(KejuAwardObserver kejuAwardObserver)
/*     */     {
/*  44 */       this.kejuAwardObserver = kejuAwardObserver;
/*     */     }
/*     */     
/*     */     public void process()
/*     */       throws Exception
/*     */     {
/*  50 */       if ((!OpenInterface.getOpenStatus(33)) || (!ActivityInterface.isActivityOpen(KeJuQuestionConsts.getInstance().ACTIVITY_ID)))
/*     */       {
/*     */ 
/*  53 */         String logstr = String.format("[keju]KejuAwardRunnable.process@keju activity closed", new Object[0]);
/*     */         
/*  55 */         KeJuQuestionManager.logger.info(logstr);
/*     */         
/*  57 */         this.kejuAwardObserver.stopTimer();
/*  58 */         return;
/*     */       }
/*     */       
/*  61 */       long dainshiWorld = KeJuQuestionManager.getInstance().getDianshiWorldid();
/*  62 */       List<Long> roleList = MapInterface.getAllSingleRoleInWorld(dainshiWorld);
/*  63 */       Iterator<Long> iterator = roleList.iterator();
/*  64 */       while (iterator.hasNext())
/*     */       {
/*  66 */         long roleid = ((Long)iterator.next()).longValue();
/*     */         
/*  68 */         new KejuAwardObserver.AwardToRole(roleid).call();
/*  69 */         iterator.remove();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class AwardToRole
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     
/*     */ 
/*     */     public AwardToRole(long roleid)
/*     */     {
/*  83 */       this.roleid = roleid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  89 */       if (GameServerInfoManager.isRoamServer())
/*     */       {
/*  91 */         String logStr = String.format("[keju]AwardToRole.processImp@roam server can not get award|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  92 */         KeJuQuestionManager.logger.info(logStr);
/*  93 */         return false;
/*     */       }
/*     */       
/*  96 */       String userId = RoleInterface.getUserId(this.roleid);
/*  97 */       lock(Lockeys.get(User.getTable(), userId));
/*     */       
/*  99 */       AwardModel awardModel = AwardInterface.award(KeJuQuestionConsts.getInstance().EXP_REWARD_ID, userId, this.roleid, false, true, new AwardReason(LogReason.KEJU_ACTIVITY_EXP_AWARD, KeJuQuestionConsts.getInstance().EXP_REWARD_ID));
/*     */       
/* 101 */       if (awardModel == null)
/*     */       {
/* 103 */         String logstr = String.format("[keju]AwardToRole.processImp@keju offer award error,null|roleid=%d|rewardid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(KeJuQuestionConsts.getInstance().EXP_REWARD_ID) });
/*     */         
/*     */ 
/* 106 */         KeJuQuestionManager.logger.error(logstr);
/*     */       }
/*     */       else
/*     */       {
/* 110 */         String logstr = String.format("[keju]AwardToRole.processImp@keju offer award to role success|roleid=%d|rewardid=%d|exp=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(KeJuQuestionConsts.getInstance().EXP_REWARD_ID), Integer.valueOf(awardModel.getRoleExp()) });
/*     */         
/*     */ 
/*     */ 
/* 114 */         KeJuQuestionManager.logger.info(logstr);
/*     */       }
/* 116 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\KejuAwardObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */