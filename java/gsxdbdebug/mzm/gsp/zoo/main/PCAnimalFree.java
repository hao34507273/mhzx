/*     */ package mzm.gsp.zoo.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.homeland.confbean.SAnimalConst;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.zoo.SAnimalFreeFailed;
/*     */ import mzm.gsp.zoo.SAnimalFreeSuccess;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AdultStageInfo;
/*     */ import xbean.AnimalInfo;
/*     */ import xbean.ZooInfo;
/*     */ import xtable.Animal;
/*     */ 
/*     */ public class PCAnimalFree extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long animalid;
/*     */   
/*     */   public PCAnimalFree(long roleid, long animalid)
/*     */   {
/*  25 */     this.roleid = roleid;
/*  26 */     this.animalid = animalid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     if (this.animalid <= 0L)
/*     */     {
/*  34 */       return false;
/*     */     }
/*     */     
/*  37 */     if (!ZooManager.canDoAction(this.roleid, 1197))
/*     */     {
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     if (!ZooManager.isFunOpen(this.roleid))
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     int level = mzm.gsp.role.main.RoleInterface.getLevel(this.roleid);
/*  48 */     if (level < SAnimalConst.getInstance().OPEN_LEVEL)
/*     */     {
/*  50 */       onFailed(6);
/*  51 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  55 */     if (!HomelandInterface.hasHome(this.roleid))
/*     */     {
/*  57 */       onFailed(4);
/*  58 */       return false;
/*     */     }
/*  60 */     long worldid = HomelandInterface.getHomeWorldIdByRoleId(this.roleid, false);
/*  61 */     if (worldid < 0L)
/*     */     {
/*  63 */       onFailed(5);
/*  64 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  68 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*  69 */     lock(xdb.Lockeys.get(xtable.User.getTable(), userid));
/*  70 */     ZooInfo xZooInfo = xtable.Role2zooinfo.get(Long.valueOf(this.roleid));
/*  71 */     if (xZooInfo == null)
/*     */     {
/*  73 */       onFailed(1);
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     if (!xZooInfo.getAnimals().contains(Long.valueOf(this.animalid)))
/*     */     {
/*  79 */       Map<String, Object> extras = new HashMap();
/*  80 */       extras.put("animals", xZooInfo.getAnimals().toString());
/*  81 */       onFailed(7, extras);
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     AnimalInfo xAnimalInfo = Animal.get(Long.valueOf(this.animalid));
/*  86 */     if (xAnimalInfo == null)
/*     */     {
/*  88 */       onFailed(7);
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     int stage = xAnimalInfo.getStage();
/*  93 */     if (stage == 0)
/*     */     {
/*  95 */       Map<String, Object> extras = new HashMap();
/*  96 */       extras.put("stage", Integer.valueOf(xAnimalInfo.getStage()));
/*  97 */       onFailed(8, extras);
/*  98 */       return false;
/*     */     }
/*     */     
/* 101 */     AdultStageInfo xAdultStageInfo = xAnimalInfo.getAdult_info();
/* 102 */     int animalCfgid = xAdultStageInfo.getAnimal_cfgid();
/* 103 */     int awardCfgid = xAdultStageInfo.getAward_cfgid();
/*     */     
/*     */ 
/* 106 */     xZooInfo.getAnimals().remove(Long.valueOf(this.animalid));
/* 107 */     Animal.remove(Long.valueOf(this.animalid));
/*     */     
/*     */ 
/* 110 */     ZooManager.triggerAnimalDisappearEvent(this.roleid, this.animalid, 1);
/*     */     
/*     */ 
/* 113 */     ZooManager.goneTlog(this.roleid, this.animalid, xAnimalInfo, 1);
/*     */     
/* 115 */     SAnimalFreeSuccess rsp = new SAnimalFreeSuccess();
/* 116 */     rsp.animalid = this.animalid;
/* 117 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*     */     
/* 119 */     GameServer.logger().info(String.format("[zoo]PCAnimalFree.processImp@success|roleid=%d|animalid=%d|animal_cfgid=%d|award_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.animalid), Integer.valueOf(animalCfgid), Integer.valueOf(awardCfgid) }));
/*     */     
/*     */ 
/*     */ 
/* 123 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 128 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 133 */     SAnimalFreeFailed rsp = new SAnimalFreeFailed();
/* 134 */     rsp.animalid = this.animalid;
/* 135 */     rsp.retcode = retcode;
/* 136 */     OnlineManager.getInstance().sendAtOnce(this.roleid, rsp);
/*     */     
/* 138 */     StringBuffer logBuilder = new StringBuffer();
/* 139 */     logBuilder.append("[zoo]PCAnimalFree.onFailed@free failed");
/* 140 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 141 */     logBuilder.append('|').append("animalid=").append(this.animalid);
/* 142 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 144 */     if (extraParams != null)
/*     */     {
/* 146 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 148 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 152 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\main\PCAnimalFree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */