/*     */ package mzm.gsp.compensate.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.Pod;
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
/*     */ public class CompensateInfo
/*     */ {
/*     */   volatile long id;
/*     */   final int mode;
/*     */   final int minLevel;
/*     */   final int maxLevel;
/*     */   final long startTime;
/*     */   final long endTime;
/*     */   final String mailTitle;
/*     */   final String mailContent;
/*  59 */   final Map<Integer, Integer> items = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  64 */   final Map<Integer, Integer> currencies = new HashMap();
/*     */   
/*     */   final long minCreateRoleTime;
/*     */   
/*     */   final long maxCreateRoleTime;
/*     */   final int tag;
/*  70 */   volatile Observer observer = null;
/*     */   
/*     */   public CompensateInfo(long id, xbean.CompensateInfo xCompensateInfo)
/*     */   {
/*  74 */     this.id = id;
/*     */     
/*  76 */     this.mode = xCompensateInfo.getMode();
/*  77 */     this.minLevel = xCompensateInfo.getMin_level();
/*  78 */     this.maxLevel = xCompensateInfo.getMax_level();
/*  79 */     this.startTime = xCompensateInfo.getStart_time();
/*  80 */     this.endTime = xCompensateInfo.getEnd_time();
/*  81 */     this.mailTitle = xCompensateInfo.getMail_title();
/*  82 */     this.mailContent = xCompensateInfo.getMail_content();
/*  83 */     this.items.putAll(xCompensateInfo.getItems());
/*  84 */     this.currencies.putAll(xCompensateInfo.getCurrencies());
/*  85 */     this.minCreateRoleTime = xCompensateInfo.getMin_create_role_time();
/*  86 */     this.maxCreateRoleTime = xCompensateInfo.getMax_create_role_time();
/*  87 */     this.tag = xCompensateInfo.getTagid();
/*     */     
/*  89 */     convertYuanbaoToBindYuanbao();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CompensateInfo(int mode, int minLevel, int maxLevel, long startTime, long endTime, String mailTitle, String mailContent, Map<Integer, Integer> items, Map<Integer, Integer> currencies, long minCreateRoleTime, long maxCreateRoleTIme, int tag)
/*     */   {
/*  96 */     this.mode = mode;
/*  97 */     this.minLevel = minLevel;
/*  98 */     this.maxLevel = maxLevel;
/*  99 */     this.startTime = startTime;
/* 100 */     this.endTime = endTime;
/* 101 */     this.mailTitle = mailTitle;
/* 102 */     this.mailContent = mailContent;
/* 103 */     this.items.putAll(items);
/* 104 */     this.currencies.putAll(currencies);
/* 105 */     this.minCreateRoleTime = minCreateRoleTime;
/* 106 */     this.maxCreateRoleTime = maxCreateRoleTIme;
/* 107 */     this.tag = tag;
/*     */     
/* 109 */     convertYuanbaoToBindYuanbao();
/*     */   }
/*     */   
/*     */   void convertYuanbaoToBindYuanbao()
/*     */   {
/* 114 */     Integer yuanbaoValue = (Integer)this.currencies.remove(Integer.valueOf(1));
/* 115 */     if ((yuanbaoValue == null) || (yuanbaoValue.intValue() <= 0))
/*     */     {
/* 117 */       return;
/*     */     }
/*     */     
/* 120 */     int newBindYuanbaoValue = yuanbaoValue.intValue();
/* 121 */     Integer bindYuanbaoValue = (Integer)this.currencies.get(Integer.valueOf(2));
/* 122 */     if ((bindYuanbaoValue != null) && (bindYuanbaoValue.intValue() > 0))
/*     */     {
/* 124 */       newBindYuanbaoValue += bindYuanbaoValue.intValue();
/* 125 */       if (newBindYuanbaoValue < 0)
/*     */       {
/* 127 */         newBindYuanbaoValue = Integer.MAX_VALUE;
/*     */       }
/*     */     }
/* 130 */     this.currencies.put(Integer.valueOf(2), Integer.valueOf(newBindYuanbaoValue));
/*     */   }
/*     */   
/*     */   void onRemove()
/*     */   {
/* 135 */     if (this.observer != null)
/*     */     {
/* 137 */       this.observer.stopTimer();
/* 138 */       this.observer = null;
/*     */     }
/*     */   }
/*     */   
/*     */   void trySendCompensate()
/*     */   {
/* 144 */     long currTime = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*     */ 
/* 147 */     if (this.endTime < currTime)
/*     */     {
/* 149 */       return;
/*     */     }
/*     */     
/*     */ 
/* 153 */     if (this.startTime > currTime)
/*     */     {
/* 155 */       this.observer = new Observer(TimeUnit.MILLISECONDS.toSeconds(this.startTime - currTime))
/*     */       {
/*     */ 
/*     */         public boolean update()
/*     */         {
/* 160 */           CompensateInfo.this.sendCompensate();
/*     */           
/* 162 */           return false;
/*     */         }
/*     */         
/* 165 */       };
/* 166 */       return;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 171 */     sendCompensate();
/*     */   }
/*     */   
/*     */   void sendCompensate()
/*     */   {
/* 176 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 181 */         for (Iterator i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */           
/* 183 */           NoneRealTimeTaskManager.getInstance().addTask(new PSendCompensate(roleid, CompensateInfo.this));
/*     */         }
/* 185 */         return true;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   xbean.CompensateInfo toXBean()
/*     */   {
/* 192 */     xbean.CompensateInfo xCompensateInfo = Pod.newCompensateInfo();
/* 193 */     xCompensateInfo.setMode(this.mode);
/* 194 */     xCompensateInfo.setMin_level(this.minLevel);
/* 195 */     xCompensateInfo.setMax_level(this.maxLevel);
/* 196 */     xCompensateInfo.setStart_time(this.startTime);
/* 197 */     xCompensateInfo.setEnd_time(this.endTime);
/* 198 */     xCompensateInfo.setMail_title(this.mailTitle);
/* 199 */     xCompensateInfo.setMail_content(this.mailContent);
/* 200 */     xCompensateInfo.getItems().putAll(this.items);
/* 201 */     xCompensateInfo.getCurrencies().putAll(this.currencies);
/* 202 */     xCompensateInfo.setMin_create_role_time(this.minCreateRoleTime);
/* 203 */     xCompensateInfo.setMax_create_role_time(this.maxCreateRoleTime);
/* 204 */     xCompensateInfo.setTagid(this.tag);
/*     */     
/* 206 */     return xCompensateInfo;
/*     */   }
/*     */   
/*     */   public long getId()
/*     */   {
/* 211 */     return this.id;
/*     */   }
/*     */   
/*     */   public String getMailTitle()
/*     */   {
/* 216 */     return this.mailTitle;
/*     */   }
/*     */   
/*     */   public int getTag()
/*     */   {
/* 221 */     return this.tag;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\compensate\main\CompensateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */