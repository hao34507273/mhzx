/*     */ package mzm.gsp.zoo.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.gm.SGMMessageTipRes;
/*     */ import mzm.gsp.homeland.confbean.SAnimalConst;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.zoo.SyncAnimalInfos;
/*     */ import mzm.gsp.zoo.event.EmbryoHatchDayChange;
/*     */ import mzm.gsp.zoo.event.EmbryoHatchDayChangeArg;
/*     */ import xbean.EmbryoStageInfo;
/*     */ import xbean.ZooInfo;
/*     */ import xtable.Animal;
/*     */ import xtable.Role2zooinfo;
/*     */ 
/*     */ public class PGM_ClearHatchDays extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long gmRoleid;
/*     */   private final long roleid;
/*     */   
/*     */   public PGM_ClearHatchDays(long gmRoleid, long roleid)
/*     */   {
/*  26 */     this.gmRoleid = gmRoleid;
/*  27 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     if (!ZooManager.isFunOpen(this.roleid))
/*     */     {
/*  35 */       notifyClient("功能关闭");
/*  36 */       return false;
/*     */     }
/*     */     
/*  39 */     int level = mzm.gsp.role.main.RoleInterface.getLevel(this.roleid);
/*  40 */     if (level < SAnimalConst.getInstance().OPEN_LEVEL)
/*     */     {
/*  42 */       notifyClient(String.format("等级不足,请升级到%d", new Object[] { Integer.valueOf(SAnimalConst.getInstance().OPEN_LEVEL) }));
/*  43 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  47 */     if (!mzm.gsp.homeland.main.HomelandInterface.hasHome(this.roleid))
/*     */     {
/*  49 */       notifyClient("请先创建家园");
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     ZooInfo xZooInfo = Role2zooinfo.get(Long.valueOf(this.roleid));
/*  54 */     if (xZooInfo == null)
/*     */     {
/*  56 */       notifyClient("未拥有小动物");
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     List<Long> xList = xZooInfo.getAnimals();
/*  61 */     if (xList.isEmpty())
/*     */     {
/*  63 */       notifyClient("未拥有小动物");
/*  64 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  68 */     lock(xdb.Lockeys.get(Animal.getTable(), xList));
/*  69 */     for (Long animalid : xList)
/*     */     {
/*  71 */       xbean.AnimalInfo xAnimalInfo = Animal.get(animalid);
/*  72 */       if ((xAnimalInfo != null) && 
/*     */       
/*     */ 
/*     */ 
/*  76 */         (xAnimalInfo.getStage() == 0))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  81 */         xAnimalInfo.getEmbryo_info().setHatch_days(0);
/*  82 */         xAnimalInfo.getEmbryo_info().setLast_hatch_time(0L);
/*     */         
/*     */ 
/*  85 */         EmbryoHatchDayChangeArg arg = new EmbryoHatchDayChangeArg(this.roleid, animalid.longValue(), 0);
/*  86 */         EmbryoHatchDayChange event = new EmbryoHatchDayChange();
/*  87 */         TriggerEventsManger.getInstance().triggerEvent(event, arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  92 */     SyncAnimalInfos msg = new SyncAnimalInfos();
/*  93 */     for (Long animalid : xList)
/*     */     {
/*  95 */       xbean.AnimalInfo xAnimalInfo = Animal.get(animalid);
/*  96 */       if (xAnimalInfo != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 101 */         mzm.gsp.zoo.AnimalInfo animalInfo = ZooManager.transToAnimalInfo(animalid.longValue(), xAnimalInfo);
/* 102 */         msg.animals.put(animalid, animalInfo);
/*     */       } }
/* 104 */     OnlineManager.getInstance().send(this.roleid, msg);
/*     */     
/* 106 */     notifyClient("操作成功");
/* 107 */     return true;
/*     */   }
/*     */   
/*     */   private void notifyClient(String str)
/*     */   {
/* 112 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 113 */     messagetip.result = Integer.MAX_VALUE;
/* 114 */     messagetip.args.add(str);
/* 115 */     OnlineManager.getInstance().sendAtOnce(this.gmRoleid, messagetip);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\main\PGM_ClearHatchDays.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */