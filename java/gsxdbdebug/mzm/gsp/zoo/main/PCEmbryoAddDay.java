/*     */ package mzm.gsp.zoo.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.homeland.confbean.SAnimalConst;
/*     */ import mzm.gsp.homeland.confbean.SEmbryoCfg;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.zoo.SEmbryoAddDayFailed;
/*     */ import mzm.gsp.zoo.SEmbryoAddDaySuccess;
/*     */ import mzm.gsp.zoo.event.EmbryoHatchDayChange;
/*     */ import mzm.gsp.zoo.event.EmbryoHatchDayChangeArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AnimalInfo;
/*     */ import xbean.EmbryoStageInfo;
/*     */ import xbean.ZooInfo;
/*     */ 
/*     */ public class PCEmbryoAddDay extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long animalid;
/*     */   
/*     */   public PCEmbryoAddDay(long roleid, long animalid)
/*     */   {
/*  32 */     this.roleid = roleid;
/*  33 */     this.animalid = animalid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (this.animalid <= 0L)
/*     */     {
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     if (!ZooManager.canDoAction(this.roleid, 1192))
/*     */     {
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     if (!ZooManager.isFunOpen(this.roleid))
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     int level = RoleInterface.getLevel(this.roleid);
/*  55 */     if (level < SAnimalConst.getInstance().OPEN_LEVEL)
/*     */     {
/*  57 */       onFailed(6);
/*  58 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  62 */     if (!HomelandInterface.hasHome(this.roleid))
/*     */     {
/*  64 */       onFailed(4);
/*  65 */       return false;
/*     */     }
/*  67 */     long worldid = HomelandInterface.getHomeWorldIdByRoleId(this.roleid, false);
/*  68 */     if (worldid < 0L)
/*     */     {
/*  70 */       onFailed(5);
/*  71 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  75 */     String userid = RoleInterface.getUserId(this.roleid);
/*  76 */     lock(xdb.Lockeys.get(xtable.User.getTable(), userid));
/*  77 */     ZooInfo xZooInfo = xtable.Role2zooinfo.get(Long.valueOf(this.roleid));
/*  78 */     if (xZooInfo == null)
/*     */     {
/*  80 */       onFailed(1);
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     if (!xZooInfo.getAnimals().contains(Long.valueOf(this.animalid)))
/*     */     {
/*  86 */       Map<String, Object> extras = new HashMap();
/*  87 */       extras.put("animals", xZooInfo.getAnimals().toString());
/*  88 */       onFailed(7, extras);
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     AnimalInfo xAnimalInfo = xtable.Animal.get(Long.valueOf(this.animalid));
/*  93 */     if (xAnimalInfo == null)
/*     */     {
/*  95 */       onFailed(7);
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     if (xAnimalInfo.getStage() != 0)
/*     */     {
/* 101 */       Map<String, Object> extras = new HashMap();
/* 102 */       extras.put("stage", Integer.valueOf(xAnimalInfo.getStage()));
/* 103 */       onFailed(8, extras);
/* 104 */       return false;
/*     */     }
/*     */     
/* 107 */     EmbryoStageInfo xEmbryoStageInfo = xAnimalInfo.getEmbryo_info();
/* 108 */     int embryoCfgid = xEmbryoStageInfo.getEmbryo_cfgid();
/* 109 */     SEmbryoCfg embryoCfg = SEmbryoCfg.get(embryoCfgid);
/* 110 */     if (embryoCfg == null)
/*     */     {
/* 112 */       Map<String, Object> extras = new HashMap();
/* 113 */       extras.put("embryo_cfgid", Integer.valueOf(embryoCfgid));
/* 114 */       onFailed(3, extras);
/* 115 */       return false;
/*     */     }
/* 117 */     if (xEmbryoStageInfo.getHatch_days() >= embryoCfg.days)
/*     */     {
/* 119 */       Map<String, Object> extras = new HashMap();
/* 120 */       extras.put("hatch_day", Integer.valueOf(xEmbryoStageInfo.getHatch_days()));
/* 121 */       onFailed(-2, extras);
/* 122 */       return false;
/*     */     }
/*     */     
/* 125 */     long lastPraiseTime = xEmbryoStageInfo.getLast_hatch_time();
/* 126 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 127 */     if (!DateTimeUtils.needDailyReset(lastPraiseTime, now, 0, 0))
/*     */     {
/* 129 */       onFailed(-1);
/* 130 */       return false;
/*     */     }
/*     */     
/* 133 */     xEmbryoStageInfo.setHatch_days(xEmbryoStageInfo.getHatch_days() + 1);
/* 134 */     xEmbryoStageInfo.setLast_hatch_time(now);
/*     */     
/*     */ 
/* 137 */     EmbryoHatchDayChangeArg arg = new EmbryoHatchDayChangeArg(this.roleid, this.animalid, xEmbryoStageInfo.getHatch_days());
/*     */     
/* 139 */     EmbryoHatchDayChange event = new EmbryoHatchDayChange();
/* 140 */     TriggerEventsManger.getInstance().triggerEvent(event, arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */     
/*     */ 
/*     */ 
/* 144 */     ZooManager.addTLog(this.roleid, "AniamlAddHatchForServer", new Object[] { Long.valueOf(this.animalid), Integer.valueOf(embryoCfgid), Integer.valueOf(xEmbryoStageInfo.getHatch_days()) });
/*     */     
/* 146 */     SEmbryoAddDaySuccess rsp = new SEmbryoAddDaySuccess();
/* 147 */     rsp.animalid = this.animalid;
/* 148 */     rsp.last_time = ((int)TimeUnit.MILLISECONDS.toSeconds(now));
/* 149 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*     */     
/* 151 */     GameServer.logger().info(String.format("[zoo]PCEmbryoAddDay.processImp@add day success|roleid=%d|animalid=%d|days=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.animalid), Integer.valueOf(xEmbryoStageInfo.getHatch_days()) }));
/*     */     
/*     */ 
/* 154 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 159 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 164 */     SEmbryoAddDayFailed rsp = new SEmbryoAddDayFailed();
/* 165 */     rsp.animalid = this.animalid;
/* 166 */     rsp.retcode = retcode;
/* 167 */     OnlineManager.getInstance().sendAtOnce(this.roleid, rsp);
/*     */     
/* 169 */     StringBuffer logBuilder = new StringBuffer();
/* 170 */     logBuilder.append("[zoo]PCEmbryoAddDay.onFailed@add day failed");
/* 171 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 172 */     logBuilder.append('|').append("animalid=").append(this.animalid);
/* 173 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 175 */     if (extraParams != null)
/*     */     {
/* 177 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 179 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 183 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\main\PCEmbryoAddDay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */