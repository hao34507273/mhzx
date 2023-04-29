/*     */ package mzm.gsp.grow.daytarget;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import xbean.DayTargetData;
/*     */ import xbean.Pod;
/*     */ import xbean.TargetData;
/*     */ import xtable.Role2daytargetdata;
/*     */ 
/*     */ public class RoleDayInfo
/*     */ {
/*     */   private long roleId;
/*     */   private DayTargetData xDayInfo;
/*     */   
/*     */   public RoleDayInfo(long roleId, boolean remainLock)
/*     */   {
/*  17 */     this.roleId = roleId;
/*  18 */     if (remainLock)
/*     */     {
/*  20 */       this.xDayInfo = Role2daytargetdata.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/*  24 */       this.xDayInfo = Role2daytargetdata.select(Long.valueOf(roleId));
/*     */     }
/*     */   }
/*     */   
/*     */   public long getRoleId()
/*     */   {
/*  30 */     return this.roleId;
/*     */   }
/*     */   
/*     */   public boolean hasXData()
/*     */   {
/*  35 */     return this.xDayInfo != null;
/*     */   }
/*     */   
/*     */   public void createDayInfo()
/*     */   {
/*  40 */     if (this.xDayInfo != null)
/*     */     {
/*  42 */       return;
/*     */     }
/*  44 */     this.xDayInfo = Pod.newDayTargetData();
/*  45 */     Role2daytargetdata.insert(Long.valueOf(this.roleId), this.xDayInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addTarget(int targetId)
/*     */   {
/*  55 */     changeTarget(targetId, 1, 0, true);
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
/*     */   public boolean changeTarget(int targetId, int state, int param)
/*     */   {
/*  68 */     return changeTarget(targetId, state, param, false);
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
/*     */   public boolean changeTarget(int targetId, int state, int param, boolean create)
/*     */   {
/*  84 */     Map<Integer, TargetData> xTargets = this.xDayInfo.getTargets();
/*  85 */     TargetData xData = (TargetData)xTargets.get(Integer.valueOf(targetId));
/*  86 */     if (xData == null)
/*     */     {
/*  88 */       if (create)
/*     */       {
/*  90 */         xData = Pod.newTargetData();
/*  91 */         xTargets.put(Integer.valueOf(targetId), xData);
/*     */       }
/*     */       else
/*     */       {
/*  95 */         return false;
/*     */       }
/*     */     }
/*  98 */     xData.setTargetid(targetId);
/*  99 */     xData.setTargetparam(param);
/* 100 */     xData.setTargetstate(state);
/* 101 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void rmTarget(int targetId)
/*     */   {
/* 111 */     Map<Integer, TargetData> xTargets = this.xDayInfo.getTargets();
/* 112 */     xTargets.remove(Integer.valueOf(targetId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public TargetData getTargetData(int targetId)
/*     */   {
/* 123 */     if (this.xDayInfo == null)
/*     */     {
/* 125 */       return null;
/*     */     }
/* 127 */     Map<Integer, TargetData> xTargets = this.xDayInfo.getTargets();
/* 128 */     if (xTargets == null)
/*     */     {
/* 130 */       return null;
/*     */     }
/* 132 */     return (TargetData)xTargets.get(Integer.valueOf(targetId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getTargetState(int targetId)
/*     */   {
/* 144 */     TargetData xData = getTargetData(targetId);
/* 145 */     if (xData == null)
/*     */     {
/* 147 */       return -1;
/*     */     }
/* 149 */     return xData.getTargetstate();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getTargetParam(int targetId)
/*     */   {
/* 160 */     TargetData xData = getTargetData(targetId);
/* 161 */     if (xData == null)
/*     */     {
/* 163 */       return -1;
/*     */     }
/* 165 */     return xData.getTargetparam();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Map<Integer, TargetData> getAllTarget()
/*     */   {
/* 175 */     return this.xDayInfo.getTargets();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<Integer> getXSateTargetIds(int state)
/*     */   {
/* 186 */     Set<Integer> targetIds = new java.util.HashSet();
/* 187 */     for (TargetData xData : getAllTarget().values())
/*     */     {
/* 189 */       if (xData.getTargetstate() == state)
/*     */       {
/* 191 */         targetIds.add(Integer.valueOf(xData.getTargetid()));
/*     */       }
/*     */     }
/* 194 */     return targetIds;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\daytarget\RoleDayInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */