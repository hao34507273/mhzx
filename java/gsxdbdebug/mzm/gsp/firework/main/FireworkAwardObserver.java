/*     */ package mzm.gsp.firework.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity3.confbean.SFireworkCfg;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.firework.SGetFireworkAward;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.ActivityFireData;
/*     */ import xbean.FireworkInfo;
/*     */ import xbean.FireworkRecord;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleFireData;
/*     */ import xtable.Basic;
/*     */ import xtable.Globalfirework;
/*     */ import xtable.Role2firedata;
/*     */ import xtable.User;
/*     */ 
/*     */ public class FireworkAwardObserver extends Observer
/*     */ {
/*     */   private final int activityId;
/*     */   private final long startTime;
/*     */   
/*     */   public FireworkAwardObserver(long intervalSeconds, int activityId, long startTime)
/*     */   {
/*  37 */     super(intervalSeconds);
/*  38 */     this.activityId = activityId;
/*  39 */     this.startTime = startTime;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  45 */     new RandomAward(this.activityId, this.startTime, this).execute();
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   private final class RandomAward
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final int activityId;
/*     */     private final long startTime;
/*     */     private final FireworkAwardObserver observer;
/*     */     
/*     */     public RandomAward(int activityId, long startTime, FireworkAwardObserver observer)
/*     */     {
/*  58 */       this.activityId = activityId;
/*  59 */       this.startTime = startTime;
/*  60 */       this.observer = observer;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  66 */       SFireworkCfg cfg = SFireworkCfg.get(this.activityId);
/*  67 */       if (shutDownObserver(cfg))
/*     */       {
/*  69 */         this.observer.stopTimer();
/*     */       }
/*  71 */       for (Iterator i$ = MapInterface.getRoleList(MapInterface.getBigWorldid(), cfg.showMapId).iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */         
/*  73 */         asynAward(roleId, cfg.fireworkAwardId, this.activityId, cfg.getAwardRet);
/*     */       }
/*  75 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private boolean getTarget(int rate)
/*     */     {
/*  86 */       if ((rate <= 0) || (rate > 10000))
/*     */       {
/*  88 */         return false;
/*     */       }
/*  90 */       int ran = xdb.Xdb.random().nextInt(10000);
/*  91 */       return ran < rate;
/*     */     }
/*     */     
/*     */     private void asynAward(long roleId, int awardId, int activityId, int awardRet)
/*     */     {
/*  96 */       NoneRealTimeTaskManager.getInstance().addTask(new DoAward(roleId, awardId, activityId, awardRet));
/*     */     }
/*     */     
/*     */     private class DoAward extends LogicProcedure
/*     */     {
/*     */       private final long roleId;
/*     */       private final int awardId;
/*     */       private final int activityId;
/*     */       private final int awardRet;
/*     */       
/*     */       public DoAward(long roleId, int awardId, int activityId, int awardRet)
/*     */       {
/* 108 */         this.roleId = roleId;
/* 109 */         this.awardId = awardId;
/* 110 */         this.activityId = activityId;
/* 111 */         this.awardRet = awardRet;
/*     */       }
/*     */       
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 117 */         if (RoleInterface.getLevel(this.roleId) < mzm.gsp.activity.main.ActivityInterface.getActivityLevelMin(this.activityId))
/*     */         {
/*     */ 
/* 120 */           return false;
/*     */         }
/* 122 */         if (!FireworkAwardObserver.RandomAward.this.getTarget(this.awardRet))
/*     */         {
/* 124 */           return false;
/*     */         }
/* 126 */         String userId = RoleInterface.getUserId(this.roleId);
/*     */         
/* 128 */         lock(User.getTable(), Arrays.asList(new String[] { userId }));
/*     */         
/* 130 */         lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*     */         
/* 132 */         if (!mzm.gsp.status.main.RoleStatusInterface.getStatusSet(this.roleId).contains(Integer.valueOf(2)))
/*     */         {
/* 134 */           return false;
/*     */         }
/*     */         
/*     */ 
/* 138 */         ActivityFireData xActivityFireData = FireworkAwardObserver.RandomAward.this.getAndInitFireDataData(this.roleId, this.activityId);
/* 139 */         int alreadyHitCount = xActivityFireData.getHitawardcount();
/* 140 */         if (alreadyHitCount >= SFireworkCfg.get(this.activityId).hitAwardCountMax)
/*     */         {
/* 142 */           FireworkManager.loggerInfo("DoAward.processImp@ award enough!|roleId=%d|activityId=%d|alreadyHitCount=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(alreadyHitCount) });
/*     */           
/* 144 */           return false;
/*     */         }
/*     */         
/* 147 */         AwardModel awardModel = AwardInterface.award(this.awardId, userId, this.roleId, false, false, new mzm.gsp.award.main.AwardReason(mzm.gsp.tlog.LogReason.FIREWORK_RANDOM_AWARD, this.activityId));
/*     */         
/* 149 */         if (awardModel == null)
/*     */         {
/* 151 */           FireworkManager.loggerError("DoAward.processImp@ award fail!|roleId=%d|awardId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.awardId), Integer.valueOf(this.activityId) });
/*     */           
/* 153 */           return false;
/*     */         }
/*     */         
/* 156 */         xActivityFireData.setHitawardcount(alreadyHitCount + 1);
/*     */         
/* 158 */         getAwardNotic(this.roleId, this.activityId, awardModel, xActivityFireData.getHitawardcount());
/*     */         
/* 160 */         FireworkManager.tlogFireworkHitAward(userId, this.roleId, this.activityId, xActivityFireData.getHitawardcount());
/* 161 */         return true;
/*     */       }
/*     */       
/*     */       private void getAwardNotic(long roleId, int activityId, AwardModel awardModel, int nowCount)
/*     */       {
/* 166 */         SGetFireworkAward p = new SGetFireworkAward();
/* 167 */         p.activityid = activityId;
/* 168 */         p.hitcount = nowCount;
/* 169 */         AwardInterface.fillAwardBean(p.awardbean, awardModel);
/* 170 */         OnlineManager.getInstance().send(roleId, p);
/*     */       }
/*     */     }
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
/*     */     private ActivityFireData getAndInitFireDataData(long roleId, int activityId)
/*     */     {
/* 186 */       long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 187 */       RoleFireData xRoleFireData = Role2firedata.get(Long.valueOf(roleId));
/* 188 */       if (xRoleFireData == null)
/*     */       {
/* 190 */         Role2firedata.insert(Long.valueOf(roleId), xRoleFireData = Pod.newRoleFireData());
/*     */       }
/* 192 */       ActivityFireData xActivityFireData = (ActivityFireData)xRoleFireData.getActivitydata().get(Integer.valueOf(activityId));
/* 193 */       if (xActivityFireData == null)
/*     */       {
/* 195 */         xRoleFireData.getActivitydata().put(Integer.valueOf(activityId), xActivityFireData = Pod.newActivityFireData());
/* 196 */         xActivityFireData.setUpdatatime(curTime);
/*     */       }
/* 198 */       if (DateTimeUtils.needDailyReset(xActivityFireData.getUpdatatime(), curTime, 0))
/*     */       {
/* 200 */         xActivityFireData.setHitawardcount(0);
/* 201 */         xActivityFireData.setUpdatatime(curTime);
/*     */       }
/* 203 */       return xActivityFireData;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private boolean shutDownObserver(SFireworkCfg cfg)
/*     */     {
/* 213 */       if (cfg == null)
/*     */       {
/* 215 */         return true;
/*     */       }
/* 217 */       if (DateTimeUtils.getCurrTimeInMillis() - this.startTime >= cfg.fireworkEffectDuration * 1000L)
/*     */       {
/* 219 */         return true;
/*     */       }
/* 221 */       if (!OpenInterface.getOpenStatus(cfg.switchId))
/*     */       {
/* 223 */         return true;
/*     */       }
/*     */       
/* 226 */       if (!isDBStartTimeValid())
/*     */       {
/* 228 */         return true;
/*     */       }
/* 230 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */     private boolean isDBStartTimeValid()
/*     */     {
/* 236 */       FireworkInfo xFireworkInfo = Globalfirework.select(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 237 */       if (xFireworkInfo == null)
/*     */       {
/* 239 */         return false;
/*     */       }
/* 241 */       FireworkRecord xFireworkRecord = (FireworkRecord)xFireworkInfo.getActivityid2record().get(Integer.valueOf(this.activityId));
/* 242 */       if (xFireworkRecord == null)
/*     */       {
/* 244 */         return false;
/*     */       }
/* 246 */       if (xFireworkRecord.getFireworkstarttime() != this.startTime)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 251 */         return false;
/*     */       }
/* 253 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\firework\main\FireworkAwardObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */