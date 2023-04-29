/*     */ package mzm.gsp.award.watchdog;
/*     */ 
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.event.RoleAwardBarkEvent;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AwardTotalData;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbsAwardWatchDog
/*     */ {
/*     */   protected final long _roleId;
/*     */   protected final int _roleLv;
/*     */   protected final AwardTotalData _xTotalData;
/*     */   protected final AwardModel _awardModel;
/*     */   
/*     */   public AbsAwardWatchDog(long roleId, int roleLv, AwardTotalData xTotalData, AwardModel awardModel)
/*     */   {
/*  23 */     this._roleId = roleId;
/*  24 */     this._roleLv = roleLv;
/*  25 */     this._xTotalData = xTotalData;
/*  26 */     this._awardModel = awardModel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void addXValue()
/*     */   {
/*  36 */     long addValue = getAddValue();
/*  37 */     if (addValue <= 0L)
/*     */     {
/*  39 */       return;
/*     */     }
/*  41 */     long orgValue = getXValue();
/*  42 */     long lastValue = orgValue + addValue;
/*  43 */     setXValue(lastValue);
/*     */     
/*  45 */     if (!needBark(orgValue, lastValue))
/*     */     {
/*  47 */       return;
/*     */     }
/*  49 */     triggerEvent();
/*  50 */     GameServer.logger().info(String.format("[awardWatchDog]AbsAwardSum.addXValue@ touch the upline!|roleId=%d|roleLv=%d|lastValue=%d|type=%d", new Object[] { Long.valueOf(this._roleId), Integer.valueOf(this._roleLv), Long.valueOf(lastValue), Integer.valueOf(getType().getTypeValue()) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void triggerEvent()
/*     */   {
/*  61 */     AwardBarkEventArg arg = new AwardBarkEventArg(this._roleId, this._xTotalData.getRolestartlv(), getXValue(), getType());
/*  62 */     TriggerEventsManger.getInstance().triggerEvent(new RoleAwardBarkEvent(), arg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   abstract long getAddValue();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   long getAddValue(long awardValue, long orgValue)
/*     */   {
/*  83 */     if (awardValue <= 0L)
/*     */     {
/*  85 */       return 0L;
/*     */     }
/*  87 */     if (orgValue <= 0L)
/*     */     {
/*  89 */       return 0L;
/*     */     }
/*  91 */     return orgValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   abstract long getXValue();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   abstract void setXValue(long paramLong);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean needBark(long orgValue, long lastValue)
/*     */   {
/* 118 */     long upline = getUplimit(this._xTotalData.getRolestartlv());
/* 119 */     if (upline <= 0L)
/*     */     {
/* 121 */       return false;
/*     */     }
/* 123 */     if (orgValue >= upline)
/*     */     {
/* 125 */       GameServer.logger().info(String.format("[awardWatchDog]already over upline!|roleId=%d|roleLv=%d|lastValue=%d|type=%d", new Object[] { Long.valueOf(this._roleId), Integer.valueOf(this._roleLv), Long.valueOf(lastValue), Integer.valueOf(getType().getTypeValue()) }));
/*     */       
/*     */ 
/* 128 */       return false;
/*     */     }
/* 130 */     if (lastValue < upline)
/*     */     {
/* 132 */       return false;
/*     */     }
/*     */     
/* 135 */     return true;
/*     */   }
/*     */   
/*     */   abstract long getUplimit(int paramInt);
/*     */   
/*     */   abstract AwardWatchType getType();
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\watchdog\AbsAwardWatchDog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */