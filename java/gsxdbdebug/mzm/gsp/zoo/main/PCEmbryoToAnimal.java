/*     */ package mzm.gsp.zoo.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.homeland.confbean.SAnimalCfg;
/*     */ import mzm.gsp.homeland.confbean.SAnimalConst;
/*     */ import mzm.gsp.homeland.confbean.SEmbryoCfg;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.zoo.SEmbryoToAnimalFailed;
/*     */ import mzm.gsp.zoo.SEmbryoToAnimalSuccess;
/*     */ import mzm.gsp.zoo.event.AnimalStageChange;
/*     */ import mzm.gsp.zoo.event.AnimalStageChangeArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AdultStageInfo;
/*     */ import xbean.AnimalInfo;
/*     */ import xbean.EmbryoStageInfo;
/*     */ import xbean.ZooInfo;
/*     */ 
/*     */ public class PCEmbryoToAnimal extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long animalid;
/*     */   
/*     */   public PCEmbryoToAnimal(long roleid, long animalid)
/*     */   {
/*  33 */     this.roleid = roleid;
/*  34 */     this.animalid = animalid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if (this.animalid <= 0L)
/*     */     {
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     if (!ZooManager.canDoAction(this.roleid, 1193))
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     if (!ZooManager.isFunOpen(this.roleid))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     int level = RoleInterface.getLevel(this.roleid);
/*  56 */     if (level < SAnimalConst.getInstance().OPEN_LEVEL)
/*     */     {
/*  58 */       onFailed(6);
/*  59 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  63 */     if (!HomelandInterface.hasHome(this.roleid))
/*     */     {
/*  65 */       onFailed(4);
/*  66 */       return false;
/*     */     }
/*  68 */     long worldid = HomelandInterface.getHomeWorldIdByRoleId(this.roleid, false);
/*  69 */     if (worldid < 0L)
/*     */     {
/*  71 */       onFailed(5);
/*  72 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  76 */     String userid = RoleInterface.getUserId(this.roleid);
/*  77 */     lock(xdb.Lockeys.get(xtable.User.getTable(), userid));
/*  78 */     ZooInfo xZooInfo = xtable.Role2zooinfo.get(Long.valueOf(this.roleid));
/*  79 */     if (xZooInfo == null)
/*     */     {
/*  81 */       onFailed(1);
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     if (!xZooInfo.getAnimals().contains(Long.valueOf(this.animalid)))
/*     */     {
/*  87 */       Map<String, Object> extras = new HashMap();
/*  88 */       extras.put("animals", xZooInfo.getAnimals().toString());
/*  89 */       onFailed(7, extras);
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     AnimalInfo xAnimalInfo = xtable.Animal.get(Long.valueOf(this.animalid));
/*  94 */     if (xAnimalInfo == null)
/*     */     {
/*  96 */       onFailed(7);
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     if (xAnimalInfo.getStage() != 0)
/*     */     {
/* 102 */       Map<String, Object> extras = new HashMap();
/* 103 */       extras.put("stage", Integer.valueOf(xAnimalInfo.getStage()));
/* 104 */       onFailed(8, extras);
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     EmbryoStageInfo xEmbryoStageInfo = xAnimalInfo.getEmbryo_info();
/* 109 */     int embryoCfgid = xEmbryoStageInfo.getEmbryo_cfgid();
/* 110 */     SEmbryoCfg embryoCfg = SEmbryoCfg.get(embryoCfgid);
/* 111 */     if (embryoCfg == null)
/*     */     {
/* 113 */       Map<String, Object> extras = new HashMap();
/* 114 */       extras.put("embryo_cfgid", Integer.valueOf(embryoCfgid));
/* 115 */       onFailed(3, extras);
/* 116 */       return false;
/*     */     }
/*     */     
/* 119 */     if (xEmbryoStageInfo.getHatch_days() < embryoCfg.days)
/*     */     {
/* 121 */       Map<String, Object> extras = new HashMap();
/* 122 */       extras.put("hatch_day", Integer.valueOf(xEmbryoStageInfo.getHatch_days()));
/* 123 */       onFailed(-1, extras);
/* 124 */       return false;
/*     */     }
/*     */     
/* 127 */     int randomGroup = embryoCfg.randomGroup;
/* 128 */     int animalCfgid = ZooManager.randomAnimalCfgid(randomGroup);
/* 129 */     if (animalCfgid <= 0)
/*     */     {
/* 131 */       Map<String, Object> extras = new HashMap();
/* 132 */       extras.put("random_group", Integer.valueOf(randomGroup));
/* 133 */       onFailed(3, extras);
/* 134 */       return false;
/*     */     }
/*     */     
/* 137 */     SAnimalCfg animalCfg = SAnimalCfg.get(animalCfgid);
/* 138 */     if (animalCfg == null)
/*     */     {
/* 140 */       Map<String, Object> extras = new HashMap();
/* 141 */       extras.put("animal_cfgid", Integer.valueOf(animalCfgid));
/* 142 */       onFailed(3, extras);
/* 143 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 147 */     xAnimalInfo.setName(animalCfg.name);
/* 148 */     int oldStage = xAnimalInfo.getStage();
/* 149 */     xAnimalInfo.setStage(1);
/* 150 */     AdultStageInfo xAdultStageInfo = xAnimalInfo.getAdult_info();
/* 151 */     xAdultStageInfo.setAnimal_cfgid(animalCfgid);
/* 152 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 153 */     xAdultStageInfo.setBirth_time(now);
/*     */     
/* 155 */     int life = animalCfg.life;
/* 156 */     if (life > 0)
/*     */     {
/* 158 */       long delaySecond = TimeUnit.HOURS.toSeconds(life);
/* 159 */       ZooManager.startAnimalLifeObserver(this.roleid, this.animalid, delaySecond);
/*     */     }
/*     */     
/*     */ 
/* 163 */     AnimalStageChangeArg arg = new AnimalStageChangeArg(this.roleid, this.animalid, oldStage, xAnimalInfo.getStage());
/* 164 */     AnimalStageChange event = new AnimalStageChange();
/* 165 */     TriggerEventsManger.getInstance().triggerEvent(event, arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */     
/*     */ 
/*     */ 
/* 169 */     ZooManager.addTLog(this.roleid, "AniamlFromEmbryoForServer", new Object[] { Long.valueOf(this.animalid), Integer.valueOf(embryoCfgid), Integer.valueOf(xEmbryoStageInfo.getHatch_days()), Integer.valueOf(animalCfgid) });
/*     */     
/*     */ 
/* 172 */     SEmbryoToAnimalSuccess rsp = new SEmbryoToAnimalSuccess();
/* 173 */     rsp.animal = ZooManager.transToAnimalInfo(this.animalid, xAnimalInfo);
/* 174 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*     */     
/* 176 */     GameServer.logger().info(String.format("[zoo]PCEmbryoToAnimal.processImp@embryo to animal success|roleid=%d|animalid=%d|animal_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.animalid), Integer.valueOf(animalCfgid) }));
/*     */     
/*     */ 
/*     */ 
/* 180 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 185 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 190 */     SEmbryoToAnimalFailed rsp = new SEmbryoToAnimalFailed();
/* 191 */     rsp.animalid = this.animalid;
/* 192 */     rsp.retcode = retcode;
/* 193 */     OnlineManager.getInstance().sendAtOnce(this.roleid, rsp);
/*     */     
/* 195 */     StringBuffer logBuilder = new StringBuffer();
/* 196 */     logBuilder.append("[zoo]PCEmbryoToAnimal.onFailed@embryo to animal failed");
/* 197 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 198 */     logBuilder.append('|').append("animalid=").append(this.animalid);
/* 199 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 201 */     if (extraParams != null)
/*     */     {
/* 203 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 205 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 209 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\main\PCEmbryoToAnimal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */