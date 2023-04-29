/*     */ package mzm.gsp.afk.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.afk.SRemind;
/*     */ import mzm.gsp.afk.confbean.SAFKDetectCfg;
/*     */ import mzm.gsp.afk.confbean.SAFKDetectConsts;
/*     */ import mzm.gsp.afk.event.AFKDetect;
/*     */ import mzm.gsp.afk.event.AFKDetectArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.TaskOneByOne;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ public class AFKDetector
/*     */   extends Observer
/*     */ {
/*  26 */   private static AFKDetector instance = null;
/*     */   
/*     */   static void init()
/*     */   {
/*  30 */     instance = new AFKDetector(SAFKDetectConsts.getInstance().DETECT_INTERVAL_IN_SECOND);
/*     */   }
/*     */   
/*     */   static AFKDetector getInstance()
/*     */   {
/*  35 */     return instance;
/*     */   }
/*     */   
/*  38 */   private final Map<Long, AFKDetectInfo> roles = new HashMap();
/*  39 */   private final TaskOneByOne oneByOne = new TaskOneByOne();
/*  40 */   final ReentrantLock lock = new ReentrantLock();
/*     */   
/*     */   public AFKDetector(long intervalSeconds)
/*     */   {
/*  44 */     super(intervalSeconds);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  50 */     this.lock.lock();
/*     */     try
/*     */     {
/*  53 */       long now = DateTimeUtils.getCurrTimeInMillis();
/*  54 */       Iterator<Map.Entry<Long, AFKDetectInfo>> iterator = this.roles.entrySet().iterator();
/*  55 */       while (iterator.hasNext())
/*     */       {
/*  57 */         Map.Entry<Long, AFKDetectInfo> entry = (Map.Entry)iterator.next();
/*  58 */         long roleid = ((Long)entry.getKey()).longValue();
/*  59 */         AFKDetectInfo info = (AFKDetectInfo)entry.getValue();
/*  60 */         SAFKDetectCfg cfg = SAFKDetectCfg.get(info.cfgid);
/*  61 */         if (cfg == null)
/*     */         {
/*  63 */           iterator.remove();
/*     */ 
/*     */         }
/*  66 */         else if (now - info.getAddTimestamp() >= cfg.max_detect_duration_in_second * 1000L)
/*     */         {
/*  68 */           iterator.remove();
/*     */ 
/*     */         }
/*  71 */         else if (now - info.getResetTimestamp() >= cfg.confirm_threshold_in_second * 1000L)
/*     */         {
/*  73 */           TriggerEventsManger.getInstance().triggerEvent(new AFKDetect(), new AFKDetectArg(roleid, info.cfgid), this.oneByOne);
/*     */ 
/*     */ 
/*     */         }
/*  77 */         else if ((now - info.getResetTimestamp() >= cfg.remind_threshold_in_second * 1000L) && (now - info.getResetTimestamp() - getIntervalMilliSeconds() < cfg.remind_threshold_in_second * 1000L))
/*     */         {
/*     */ 
/*  80 */           SRemind protocol = new SRemind();
/*  81 */           protocol.afk_detect_cfg_id = info.cfgid;
/*  82 */           long restTime = cfg.confirm_threshold_in_second * 1000L - (now - info.getResetTimestamp());
/*  83 */           int confirmTimestamp = (int)((restTime + now) / 1000L);
/*  84 */           if (restTime % getIntervalMilliSeconds() != 0L)
/*     */           {
/*  86 */             confirmTimestamp = (int)(((restTime / getIntervalMilliSeconds() + 1L) * getIntervalMilliSeconds() + now) / 1000L);
/*     */           }
/*     */           
/*  89 */           protocol.confirm_timestamp = confirmTimestamp;
/*  90 */           OnlineManager.getInstance().send(roleid, protocol);
/*     */         }
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*  96 */       this.lock.unlock();
/*     */     }
/*  98 */     return true;
/*     */   }
/*     */   
/*     */   public void addRole(long roleid, int cfgid)
/*     */   {
/* 103 */     if (SAFKDetectCfg.get(cfgid) == null)
/*     */     {
/*     */ 
/* 106 */       return;
/*     */     }
/* 108 */     this.lock.lock();
/*     */     try
/*     */     {
/* 111 */       AFKDetectInfo oldInfo = (AFKDetectInfo)this.roles.get(Long.valueOf(roleid));
/* 112 */       if ((oldInfo != null) && (oldInfo.getCfgid() == cfgid))
/*     */       {
/* 114 */         GameServer.logger().info(String.format("[afk]AFKDetector.addRole@role is already in detector|roleid=%d|cfgid=%d|old_cfgid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(cfgid), Integer.valueOf(oldInfo == null ? -1 : oldInfo.getCfgid()) }));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 119 */         this.roles.put(Long.valueOf(roleid), new AFKDetectInfo(cfgid));
/* 120 */         GameServer.logger().info(String.format("[afk]AFKDetector.addRole@add role into detector|roleid=%d|cfgid=%d|old_cfgid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(cfgid), Integer.valueOf(oldInfo == null ? -1 : oldInfo.getCfgid()) }));
/*     */       }
/*     */       
/*     */     }
/*     */     finally
/*     */     {
/* 126 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void resetRole(long roleid, int cfgid, boolean checkTimeStamp)
/*     */   {
/* 132 */     this.lock.lock();
/*     */     try
/*     */     {
/* 135 */       AFKDetectInfo oldInfo = (AFKDetectInfo)this.roles.get(Long.valueOf(roleid));
/* 136 */       if ((oldInfo == null) || (oldInfo.getCfgid() != cfgid))
/*     */       {
/* 138 */         GameServer.logger().info(String.format("[afk]AFKDetector.resetRole@afk detect info not match|roleid=%d|cfgid=%d|check_timestamp=%b|old_cfgid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(cfgid), Boolean.valueOf(checkTimeStamp), Integer.valueOf(oldInfo == null ? -1 : oldInfo.getCfgid()) }));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 144 */         SAFKDetectCfg cfg = SAFKDetectCfg.get(oldInfo.getCfgid());
/* 145 */         if (cfg == null) {
/*     */           return;
/*     */         }
/*     */         
/*     */ 
/* 150 */         if ((checkTimeStamp) && (DateTimeUtils.getCurrTimeInMillis() - oldInfo.getResetTimestamp() < cfg.remind_threshold_in_second * 1000L))
/*     */         {
/*     */ 
/* 153 */           GameServer.logger().info(String.format("[afk]AFKDetector.resetRole@can not reset|roleid=%d|cfgid=%d|check_timestamp=%b|old_cfgid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(cfgid), Boolean.valueOf(checkTimeStamp), Integer.valueOf(oldInfo == null ? -1 : oldInfo.getCfgid()) }));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/* 159 */           oldInfo.reset();
/* 160 */           GameServer.logger().info(String.format("[afk]AFKDetector.resetRole@reset role in detector|roleid=%d|cfgid=%d|check_timestamp=%b|old_cfgid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(cfgid), Boolean.valueOf(checkTimeStamp), Integer.valueOf(oldInfo == null ? -1 : oldInfo.getCfgid()) }));
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 167 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeRole(long roleid, int cfgid)
/*     */   {
/* 173 */     this.lock.lock();
/*     */     try
/*     */     {
/* 176 */       AFKDetectInfo oldInfo = (AFKDetectInfo)this.roles.get(Long.valueOf(roleid));
/* 177 */       if ((oldInfo == null) || (oldInfo.getCfgid() != cfgid))
/*     */       {
/* 179 */         GameServer.logger().info(String.format("[afk]AFKDetector.removeRole@afk detect info not match|roleid=%d|cfgid=%d|old_cfgid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(cfgid), Integer.valueOf(oldInfo == null ? -1 : oldInfo.getCfgid()) }));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 184 */         this.roles.remove(Long.valueOf(roleid));
/* 185 */         GameServer.logger().info(String.format("[afk]AFKDetector.removeRole@remove role from detector|roleid=%d|cfgid=%d|old_cfgid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(cfgid), Integer.valueOf(oldInfo == null ? -1 : oldInfo.getCfgid()) }));
/*     */       }
/*     */       
/*     */     }
/*     */     finally
/*     */     {
/* 191 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   class AFKDetectInfo
/*     */   {
/*     */     private final int cfgid;
/*     */     private final long addTimestamp;
/*     */     private long resetTimestamp;
/*     */     
/*     */     AFKDetectInfo(int cfgid)
/*     */     {
/* 203 */       this.cfgid = cfgid;
/* 204 */       this.addTimestamp = DateTimeUtils.getCurrTimeInMillis();
/* 205 */       this.resetTimestamp = this.addTimestamp;
/*     */     }
/*     */     
/*     */     int getCfgid()
/*     */     {
/* 210 */       return this.cfgid;
/*     */     }
/*     */     
/*     */     long getAddTimestamp()
/*     */     {
/* 215 */       return this.addTimestamp;
/*     */     }
/*     */     
/*     */     long getResetTimestamp()
/*     */     {
/* 220 */       return this.resetTimestamp;
/*     */     }
/*     */     
/*     */     void reset()
/*     */     {
/* 225 */       this.resetTimestamp = DateTimeUtils.getCurrTimeInMillis();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\afk\main\AFKDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */