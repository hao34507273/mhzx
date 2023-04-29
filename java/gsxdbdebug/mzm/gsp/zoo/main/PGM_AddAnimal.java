/*     */ package mzm.gsp.zoo.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.gm.SGMMessageTipRes;
/*     */ import mzm.gsp.homeland.confbean.SAnimalCfg;
/*     */ import mzm.gsp.homeland.confbean.SAnimalConst;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.zoo.event.AnimalCreate;
/*     */ import mzm.gsp.zoo.event.AnimalCreateArg;
/*     */ import xbean.AdultStageInfo;
/*     */ import xbean.AnimalInfo;
/*     */ import xbean.ZooInfo;
/*     */ 
/*     */ public class PGM_AddAnimal extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long gmRoleid;
/*     */   private final long roleid;
/*     */   private final int animalCfgid;
/*     */   
/*     */   public PGM_AddAnimal(long gmRoleid, long roleid, int animalCfgid)
/*     */   {
/*  24 */     this.gmRoleid = gmRoleid;
/*  25 */     this.roleid = roleid;
/*  26 */     this.animalCfgid = animalCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     if (!ZooInterface.isFunOpen(this.roleid))
/*     */     {
/*  34 */       notifyClient("功能未开启");
/*  35 */       return false;
/*     */     }
/*     */     
/*  38 */     if (!mzm.gsp.homeland.main.HomelandInterface.hasHome(this.roleid))
/*     */     {
/*  40 */       notifyClient("家园未创建");
/*  41 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  45 */     int level = mzm.gsp.role.main.RoleInterface.getLevel(this.roleid);
/*  46 */     if (level < SAnimalConst.getInstance().OPEN_LEVEL)
/*     */     {
/*  48 */       notifyClient(String.format("人物等级达到%d级功能开启", new Object[] { Integer.valueOf(SAnimalConst.getInstance().OPEN_LEVEL) }));
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     int maxSize = ZooManager.getAnimalMaxSize(this.roleid);
/*  53 */     if (maxSize < 0)
/*     */     {
/*  55 */       notifyClient("庭院饲养动物数量配置错误");
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     ZooInfo xZooInfo = xtable.Role2zooinfo.get(Long.valueOf(this.roleid));
/*  60 */     if (xZooInfo == null)
/*     */     {
/*  62 */       xZooInfo = ZooManager.initZooInfo(this.roleid);
/*     */     }
/*     */     
/*  65 */     int size = xZooInfo.getAnimals().size();
/*  66 */     if (size >= maxSize)
/*     */     {
/*  68 */       notifyClient("庭院饲养动物数量达到最大值");
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     SAnimalCfg animalCfg = SAnimalCfg.get(this.animalCfgid);
/*  73 */     if (animalCfg == null)
/*     */     {
/*  75 */       notifyClient("小动物配置不存在");
/*  76 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  80 */     AnimalInfo xAnimalInfo = xbean.Pod.newAnimalInfo();
/*  81 */     xAnimalInfo.setOwner(this.roleid);
/*  82 */     xAnimalInfo.setStage(1);
/*     */     
/*     */ 
/*  85 */     xAnimalInfo.setName(animalCfg.name);
/*  86 */     xAnimalInfo.setStage(1);
/*  87 */     AdultStageInfo xAdultStageInfo = xAnimalInfo.getAdult_info();
/*  88 */     xAdultStageInfo.setAnimal_cfgid(this.animalCfgid);
/*  89 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  90 */     xAdultStageInfo.setBirth_time(now);
/*     */     
/*  92 */     Long animalid = xtable.Animal.insert(xAnimalInfo);
/*  93 */     xZooInfo.getAnimals().add(animalid);
/*     */     
/*     */ 
/*  96 */     AnimalCreateArg arg = new AnimalCreateArg(this.roleid, animalid.longValue());
/*  97 */     AnimalCreate event = new AnimalCreate();
/*  98 */     TriggerEventsManger.getInstance().triggerEventAtOnce(event, arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */     
/*     */ 
/* 101 */     notifyClient("添加成功");
/* 102 */     return true;
/*     */   }
/*     */   
/*     */   private void notifyClient(String str)
/*     */   {
/* 107 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 108 */     messagetip.result = Integer.MAX_VALUE;
/* 109 */     messagetip.args.add(str);
/* 110 */     OnlineManager.getInstance().sendAtOnce(this.gmRoleid, messagetip);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\main\PGM_AddAnimal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */