/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ public class PointRaceInfo
/*     */ {
/*     */   private final int activityCfgid;
/*     */   private final int zone;
/*     */   private final int timePointCfgid;
/*     */   private final long startTime;
/*     */   private final int lastTime;
/*  13 */   private final List<Integer> preTimePoints = new ArrayList();
/*     */   
/*     */   private final int index;
/*     */   private final byte backup;
/*  17 */   private volatile String basicCache = null;
/*     */   
/*     */   public PointRaceInfo(hub.PointRaceInfo pointRaceInfo)
/*     */   {
/*  21 */     this(pointRaceInfo.activity_cfgid, pointRaceInfo.zone, pointRaceInfo.time_point_cfgid, pointRaceInfo.start_time, pointRaceInfo.last_time, pointRaceInfo.pre_time_points, pointRaceInfo.index, pointRaceInfo.backup);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public PointRaceInfo(int activtyCfgid, int zone, int timePointCfgid, long startTime, int lastTime, List<Integer> preTimePoints, int index, byte backup)
/*     */   {
/*  28 */     this.activityCfgid = activtyCfgid;
/*  29 */     this.zone = zone;
/*  30 */     this.timePointCfgid = timePointCfgid;
/*  31 */     this.startTime = startTime;
/*  32 */     this.lastTime = lastTime;
/*  33 */     if (preTimePoints != null)
/*     */     {
/*  35 */       this.preTimePoints.addAll(preTimePoints);
/*     */     }
/*     */     
/*  38 */     this.index = index;
/*  39 */     this.backup = backup;
/*     */   }
/*     */   
/*     */   public int getActivityCfgid()
/*     */   {
/*  44 */     return this.activityCfgid;
/*     */   }
/*     */   
/*     */   public int getZone()
/*     */   {
/*  49 */     return this.zone;
/*     */   }
/*     */   
/*     */   public int getTimePointCfgid()
/*     */   {
/*  54 */     return this.timePointCfgid;
/*     */   }
/*     */   
/*     */   public long getStartTime()
/*     */   {
/*  59 */     return this.startTime;
/*     */   }
/*     */   
/*     */   public int getLastTime()
/*     */   {
/*  64 */     return this.lastTime;
/*     */   }
/*     */   
/*     */   public int getIndex()
/*     */   {
/*  69 */     return this.index;
/*     */   }
/*     */   
/*     */   public byte getBackup()
/*     */   {
/*  74 */     return this.backup;
/*     */   }
/*     */   
/*     */   public hub.PointRaceInfo getHubPointRaceInfo()
/*     */   {
/*     */     try
/*     */     {
/*  81 */       hub.PointRaceInfo pointRaceInfo = new hub.PointRaceInfo();
/*  82 */       pointRaceInfo.activity_cfgid = this.activityCfgid;
/*  83 */       pointRaceInfo.zone = this.zone;
/*  84 */       pointRaceInfo.time_point_cfgid = this.timePointCfgid;
/*  85 */       pointRaceInfo.start_time = this.startTime;
/*  86 */       pointRaceInfo.last_time = this.lastTime;
/*  87 */       pointRaceInfo.pre_time_points.addAll(this.preTimePoints);
/*  88 */       pointRaceInfo.index = this.index;
/*  89 */       pointRaceInfo.backup = this.backup;
/*  90 */       return pointRaceInfo;
/*     */     }
/*     */     catch (Exception e) {}
/*     */     
/*     */ 
/*  95 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String toString()
/*     */   {
/* 102 */     if (this.basicCache != null)
/*     */     {
/* 104 */       return this.basicCache;
/*     */     }
/*     */     
/* 107 */     StringBuffer sb = new StringBuffer();
/* 108 */     sb.append('{');
/* 109 */     sb.append("activity_cfgid=").append(this.activityCfgid).append(",");
/* 110 */     sb.append("zone=").append(this.zone).append(",");
/* 111 */     sb.append("time_point_cfgid=").append(this.timePointCfgid).append(",");
/* 112 */     sb.append("start_time=").append(this.startTime).append(",");
/* 113 */     sb.append("last_time=").append(this.lastTime).append(",");
/* 114 */     sb.append("pre_time_points=").append(this.preTimePoints).append(",");
/* 115 */     sb.append("index=").append(this.index).append(",");
/* 116 */     sb.append("backup=").append(this.backup);
/* 117 */     sb.append('}');
/*     */     
/* 119 */     this.basicCache = sb.toString();
/*     */     
/* 121 */     return this.basicCache;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PointRaceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */