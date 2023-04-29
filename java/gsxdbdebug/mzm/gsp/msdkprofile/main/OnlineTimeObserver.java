/*     */ package mzm.gsp.msdkprofile.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import mzm.gsp.util.Pair;
/*     */ import xdb.Executor;
/*     */ 
/*     */ class OnlineTimeObserver
/*     */   extends Observer
/*     */ {
/*     */   private static final int INTERVAL = 300;
/*     */   
/*     */   public OnlineTimeObserver(long delay)
/*     */   {
/*  23 */     super(delay);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  29 */     Executor.getInstance().execute(new ROnlineTime(null));
/*  30 */     setIntervalSeconds(300L);
/*  31 */     return true;
/*     */   }
/*     */   
/*     */   private class ROnlineTime extends LogicRunnable
/*     */   {
/*     */     private ROnlineTime() {}
/*     */     
/*     */     public void process() throws Exception
/*     */     {
/*  40 */       List<Long> roles = OnlineManager.getInstance().getAllRolesInWorld();
/*  41 */       for (Long roleId : roles)
/*     */       {
/*  43 */         NoneRealTimeTaskManager.getInstance().addTask(new OnlineTimeObserver.PCalcuateOnlineTime(OnlineTimeObserver.this, roleId.longValue()));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private class PCalcuateOnlineTime
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     
/*     */     public PCalcuateOnlineTime(long roleId)
/*     */     {
/*  55 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  62 */       Role role = RoleInterface.getRole(this.roleId, true);
/*     */       
/*  64 */       long lastLogin = role.getLastLoginTime();
/*  65 */       long lastCalcuate = role.getLastCalcuateTime();
/*     */       
/*     */ 
/*  68 */       if (lastCalcuate < lastLogin)
/*     */       {
/*  70 */         lastCalcuate = 0L;
/*     */       }
/*     */       
/*     */ 
/*  74 */       Pair<Boolean, Integer> result = null;
/*  75 */       if (lastCalcuate == 0L)
/*     */       {
/*  77 */         long lastLogoff = role.getLastLogoffTime();
/*  78 */         if (lastLogin > lastLogoff)
/*     */         {
/*     */ 
/*  81 */           result = OnlineTimeObserver.this.calcuteOnlineSeconds(lastLogin);
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*  86 */           return false;
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/*  91 */         result = OnlineTimeObserver.this.calcuteOnlineSeconds(lastCalcuate);
/*     */       }
/*     */       
/*     */ 
/*  95 */       int seconds = 0;
/*  96 */       if (((Boolean)result.first).booleanValue())
/*     */       {
/*     */ 
/*  99 */         seconds = role.getDayOnlineSeconds() + ((Integer)result.second).intValue();
/* 100 */         role.setDayOnlineSeconds(seconds);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 105 */         seconds = ((Integer)result.second).intValue();
/* 106 */         role.setDayOnlineSeconds(((Integer)result.second).intValue());
/*     */       }
/*     */       
/*     */ 
/* 110 */       role.setLastCalcuateTime(DateTimeUtils.getCurrTimeInMillis());
/*     */       
/*     */ 
/* 113 */       role.setOnlineSeconds(role.getOnlineSeconds() + ((Integer)result.second).intValue());
/*     */       
/*     */ 
/* 116 */       MSDKProfileManager.reportRoleOnlineSecondsAsync(this.roleId, seconds);
/*     */       
/* 118 */       return true;
/*     */     }
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
/*     */   private Pair<Boolean, Integer> calcuteOnlineSeconds(long beginTime)
/*     */   {
/* 133 */     Pair<Boolean, Integer> result = new Pair(Boolean.valueOf(false), Integer.valueOf(0));
/* 134 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 135 */     if (DateTimeUtils.isInSameDay(beginTime, now))
/*     */     {
/* 137 */       int second = (int)TimeUnit.MILLISECONDS.toSeconds(now - beginTime);
/* 138 */       result.first = Boolean.valueOf(true);
/* 139 */       result.second = Integer.valueOf(second);
/*     */     }
/*     */     else
/*     */     {
/* 143 */       long todayBeginTime = DateTimeUtils.getBeginTimeOfCurrDay(now);
/* 144 */       int second = (int)TimeUnit.MILLISECONDS.toSeconds(now - todayBeginTime);
/* 145 */       result.first = Boolean.valueOf(false);
/* 146 */       result.second = Integer.valueOf(second);
/*     */     }
/* 148 */     return result;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\msdkprofile\main\OnlineTimeObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */