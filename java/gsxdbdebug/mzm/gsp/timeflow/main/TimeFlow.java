/*     */ package mzm.gsp.timeflow.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.timeflow.event.StepActivate;
/*     */ import mzm.gsp.timeflow.event.StepActivateArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.TimeFlowInfo;
/*     */ import xbean.TimeFlowInfos;
/*     */ import xtable.Timeflows;
/*     */ 
/*     */ class TimeFlow
/*     */ {
/*     */   final TimeFlowType type;
/*     */   final int subType;
/*     */   final long limitTime;
/*  20 */   final List<TimeFlowStep> steps = new java.util.ArrayList();
/*     */   final long eventKey;
/*     */   
/*     */   public TimeFlow(TimeFlowType type, int subType, long limitTime, List<Long> absoluteSteps)
/*     */   {
/*  25 */     this.type = type;
/*  26 */     this.subType = subType;
/*  27 */     this.limitTime = limitTime;
/*     */     
/*  29 */     long interval = 0L;
/*  30 */     long triggerTime = ((Long)absoluteSteps.get(0)).longValue();
/*  31 */     this.steps.add(new TimeFlowStep(triggerTime, interval));
/*     */     
/*  33 */     int size = absoluteSteps.size();
/*  34 */     for (int i = 1; i < size; i++)
/*     */     {
/*  36 */       triggerTime = ((Long)absoluteSteps.get(i)).longValue();
/*  37 */       interval = triggerTime - ((Long)absoluteSteps.get(i - 1)).longValue();
/*  38 */       this.steps.add(new TimeFlowStep(triggerTime, interval));
/*     */     }
/*     */     
/*  41 */     this.eventKey = mzm.gsp.util.CommonUtils.getLong(this.type.ordinal(), this.subType);
/*     */   }
/*     */   
/*     */   public void onPostInit()
/*     */   {
/*  46 */     if (!new POnPostInit(this).call())
/*     */     {
/*  48 */       throw new RuntimeException(String.format("[timeflow]TimeFlow.onPostInit@time flow post init failed|type=%s|subtype=%d|limit_time=%d|steps=%s", new Object[] { this.type, Integer.valueOf(this.subType), Long.valueOf(this.limitTime), this.steps }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   boolean handleOnPostInit()
/*     */   {
/*  56 */     long currTime = DateTimeUtils.getCurrTimeInMillis();
/*  57 */     if (currTime >= this.limitTime)
/*     */     {
/*  59 */       return true;
/*     */     }
/*     */     
/*  62 */     TimeFlowInfo xTimeFlowInfo = createXTimeFlowInfoIfNeeded();
/*  63 */     int dbStep = xTimeFlowInfo.getStep();
/*     */     
/*  65 */     int step = 1;
/*  66 */     TimeFlowStep nextTimeFlowStep = null;
/*  67 */     int stepSize = this.steps.size();
/*  68 */     for (int i = 0; i < stepSize; step++)
/*     */     {
/*  70 */       TimeFlowStep timeFlowStep = (TimeFlowStep)this.steps.get(i);
/*  71 */       if (step <= dbStep)
/*     */       {
/*  73 */         triggerEvent(step, true);
/*     */         
/*  75 */         if (timeFlowStep.triggerTime >= currTime)
/*     */         {
/*  77 */           GameServer.logger().warn(String.format("[timeflow]TimeFlow.handleOnPostInit@time flow step activate again, but trigger time is greater than current time|type=%s|subtype=%d|limit_time=%d|step=%d|steps=%s", new Object[] { this.type, Integer.valueOf(this.subType), Long.valueOf(this.limitTime), Integer.valueOf(step), this.steps }));
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/*  84 */           GameServer.logger().info(String.format("[timeflow]TimeFlow.handleOnPostInit@time flow step activate again|type=%s|subtype=%d|limit_time=%d|step=%d|steps=%s", new Object[] { this.type, Integer.valueOf(this.subType), Long.valueOf(this.limitTime), Integer.valueOf(step), this.steps }));
/*     */ 
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/*  93 */       else if (timeFlowStep.triggerTime <= currTime)
/*     */       {
/*  95 */         triggerEvent(step, false);
/*     */         
/*  97 */         GameServer.logger().info(String.format("[timeflow]TimeFlow.handleOnPostInit@time flow step activate|type=%s|subtype=%d|limit_time=%d|step=%d|steps=%s", new Object[] { this.type, Integer.valueOf(this.subType), Long.valueOf(this.limitTime), Integer.valueOf(step), this.steps }));
/*     */ 
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*     */ 
/* 105 */         nextTimeFlowStep = timeFlowStep;
/*     */         
/* 107 */         break;
/*     */       }
/*  68 */       i++;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 110 */     if (nextTimeFlowStep == null)
/*     */     {
/* 112 */       xTimeFlowInfo.setStep(stepSize);
/*     */     }
/*     */     else
/*     */     {
/* 116 */       xTimeFlowInfo.setStep(step - 1);
/*     */       
/* 118 */       new TimeFlowStepObserver(this, nextTimeFlowStep.triggerTime - currTime, step);
/*     */     }
/*     */     
/* 121 */     return true;
/*     */   }
/*     */   
/*     */   boolean handleOnTimeout()
/*     */   {
/* 126 */     long currTime = DateTimeUtils.getCurrTimeInMillis();
/* 127 */     TimeFlowInfo xTimeFlowInfo = createXTimeFlowInfoIfNeeded();
/* 128 */     int activateStep = xTimeFlowInfo.getStep() + 1;
/* 129 */     triggerEvent(activateStep, false);
/*     */     
/* 131 */     GameServer.logger().info(String.format("[timeflow]TimeFlow.handleOnTimeout@time flow step activate|type=%s|subtype=%d|limit_time=%d|step=%d|steps=%s", new Object[] { this.type, Integer.valueOf(this.subType), Long.valueOf(this.limitTime), Integer.valueOf(activateStep), this.steps }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 136 */     int step = activateStep + 1;
/* 137 */     TimeFlowStep nextTimeFlowStep = null;
/* 138 */     int stepSize = this.steps.size();
/* 139 */     for (int i = activateStep; i < stepSize; step++)
/*     */     {
/* 141 */       TimeFlowStep timeFlowStep = (TimeFlowStep)this.steps.get(i);
/* 142 */       if (timeFlowStep.triggerTime <= currTime)
/*     */       {
/* 144 */         triggerEvent(step, false);
/*     */         
/* 146 */         GameServer.logger().warn(String.format("[timeflow]TimeFlow.handleOnTimeout@time flow step activate, the time may be adjusted|type=%s|subtype=%d|limit_time=%d|step=%d|steps=%s", new Object[] { this.type, Integer.valueOf(this.subType), Long.valueOf(this.limitTime), Integer.valueOf(step), this.steps }));
/*     */ 
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*     */ 
/* 154 */         nextTimeFlowStep = timeFlowStep;
/*     */         
/* 156 */         break;
/*     */       }
/* 139 */       i++;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 159 */     if (nextTimeFlowStep == null)
/*     */     {
/* 161 */       xTimeFlowInfo.setStep(stepSize);
/*     */     }
/*     */     else
/*     */     {
/* 165 */       xTimeFlowInfo.setStep(step - 1);
/*     */       
/* 167 */       new TimeFlowStepObserver(this, nextTimeFlowStep.triggerTime - currTime, step);
/*     */     }
/*     */     
/* 170 */     return true;
/*     */   }
/*     */   
/*     */   TimeFlowInfo createXTimeFlowInfoIfNeeded()
/*     */   {
/* 175 */     long key = this.type.toKey();
/* 176 */     TimeFlowInfos xTimeFlowInfos = Timeflows.get(Long.valueOf(key));
/* 177 */     if (xTimeFlowInfos == null)
/*     */     {
/* 179 */       xTimeFlowInfos = xbean.Pod.newTimeFlowInfos();
/* 180 */       Timeflows.add(Long.valueOf(key), xTimeFlowInfos);
/*     */     }
/*     */     
/* 183 */     TimeFlowInfo xTimeFlowInfo = (TimeFlowInfo)xTimeFlowInfos.getFlows().get(Integer.valueOf(this.subType));
/* 184 */     if (xTimeFlowInfo == null)
/*     */     {
/* 186 */       xTimeFlowInfo = xbean.Pod.newTimeFlowInfo();
/* 187 */       xTimeFlowInfo.setStep(0);
/* 188 */       xTimeFlowInfos.getFlows().put(Integer.valueOf(this.subType), xTimeFlowInfo);
/*     */     }
/*     */     
/* 191 */     return xTimeFlowInfo;
/*     */   }
/*     */   
/*     */   void triggerEvent(int activateStep, boolean activateAgain)
/*     */   {
/* 196 */     StepActivate event = new StepActivate();
/* 197 */     StepActivateArg arg = new StepActivateArg(this.type, this.subType, activateStep, activateAgain);
/* 198 */     TriggerEventsManger.getInstance().triggerEvent(event, arg, TimeFlowEventOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.eventKey)));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\timeflow\main\TimeFlow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */