/*     */ package mzm.gsp.zoo.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.homeland.confbean.SAnimalConst;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.zoo.SGetAwardFailed;
/*     */ import mzm.gsp.zoo.SGetAwardSuccess;
/*     */ import mzm.gsp.zoo.event.AnimalGetAward;
/*     */ import mzm.gsp.zoo.event.AnimalGetAwardArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AdultStageInfo;
/*     */ import xbean.AnimalInfo;
/*     */ import xbean.ZooInfo;
/*     */ import xtable.Animal;
/*     */ import xtable.Role2zooinfo;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetAward extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long animalid;
/*     */   
/*     */   public PCGetAward(long roleid, long animalid)
/*     */   {
/*  35 */     this.roleid = roleid;
/*  36 */     this.animalid = animalid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     if (this.animalid <= 0L)
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     if (!ZooManager.canDoAction(this.roleid, 1195))
/*     */     {
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     if (!ZooManager.isFunOpen(this.roleid))
/*     */     {
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     int level = RoleInterface.getLevel(this.roleid);
/*  58 */     if (level < SAnimalConst.getInstance().OPEN_LEVEL)
/*     */     {
/*  60 */       onFailed(6);
/*  61 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  65 */     if (!HomelandInterface.hasHome(this.roleid))
/*     */     {
/*  67 */       onFailed(4);
/*  68 */       return false;
/*     */     }
/*  70 */     long worldid = HomelandInterface.getHomeWorldIdByRoleId(this.roleid, false);
/*  71 */     if (worldid < 0L)
/*     */     {
/*  73 */       onFailed(5);
/*  74 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  78 */     String userid = RoleInterface.getUserId(this.roleid);
/*  79 */     lock(xdb.Lockeys.get(User.getTable(), userid));
/*  80 */     ZooInfo xZooInfo = Role2zooinfo.get(Long.valueOf(this.roleid));
/*  81 */     if (xZooInfo == null)
/*     */     {
/*  83 */       onFailed(1);
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     if (!xZooInfo.getAnimals().contains(Long.valueOf(this.animalid)))
/*     */     {
/*  89 */       Map<String, Object> extras = new HashMap();
/*  90 */       extras.put("animals", xZooInfo.getAnimals().toString());
/*  91 */       onFailed(7, extras);
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     AnimalInfo xAnimalInfo = Animal.get(Long.valueOf(this.animalid));
/*  96 */     if (xAnimalInfo == null)
/*     */     {
/*  98 */       onFailed(7);
/*  99 */       return false;
/*     */     }
/* 101 */     if (xAnimalInfo.getStage() == 0)
/*     */     {
/* 103 */       Map<String, Object> extras = new HashMap();
/* 104 */       extras.put("stage", Integer.valueOf(xAnimalInfo.getStage()));
/* 105 */       onFailed(8, extras);
/* 106 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 110 */     AdultStageInfo xAdultStageInfo = xAnimalInfo.getAdult_info();
/* 111 */     int awardCfgid = xAdultStageInfo.getAward_cfgid();
/* 112 */     if (awardCfgid <= 0)
/*     */     {
/* 114 */       onFailed(-1);
/* 115 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 119 */     xAdultStageInfo.setAward_cfgid(0);
/*     */     
/*     */ 
/* 122 */     if (ItemInterface.isBagFull(this.roleid, 340600000, true))
/*     */     {
/* 124 */       onFailed(-2);
/* 125 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 129 */     LogReason logReason = LogReason.ANIMAL_GET_MATE_AWARD;
/* 130 */     AwardReason awardReason = new AwardReason(logReason, awardCfgid);
/* 131 */     awardReason.setAwardItemBind(true);
/* 132 */     mzm.gsp.award.main.AwardModel awardModel = mzm.gsp.award.main.AwardInterface.award(awardCfgid, userid, this.roleid, true, true, awardReason);
/* 133 */     if (awardModel == null)
/*     */     {
/*     */ 
/* 136 */       Map<String, Object> extras = new HashMap();
/* 137 */       extras.put("award_cfgid", Integer.valueOf(awardCfgid));
/* 138 */       onFailed(3, extras);
/* 139 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 143 */     AnimalGetAwardArg arg = new AnimalGetAwardArg(this.roleid, this.animalid, awardCfgid);
/* 144 */     AnimalGetAward event = new AnimalGetAward();
/* 145 */     TriggerEventsManger.getInstance().triggerEvent(event, arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */     
/*     */ 
/* 148 */     ZooManager.addTLog(this.roleid, "AniamlGetAwardForServer", new Object[] { Long.valueOf(this.animalid), Integer.valueOf(xAdultStageInfo.getAnimal_cfgid()), Integer.valueOf(awardCfgid) });
/*     */     
/* 150 */     SGetAwardSuccess rsp = new SGetAwardSuccess();
/* 151 */     rsp.animalid = this.animalid;
/* 152 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*     */     
/* 154 */     GameServer.logger().info(String.format("[zoo]PCGetAward.processImp@get award success|roleid=%d|animalid=%d|award_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.animalid), Integer.valueOf(awardCfgid) }));
/*     */     
/*     */ 
/*     */ 
/* 158 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 163 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 168 */     SGetAwardFailed rsp = new SGetAwardFailed();
/* 169 */     rsp.animalid = this.animalid;
/* 170 */     rsp.retcode = retcode;
/* 171 */     OnlineManager.getInstance().sendAtOnce(this.roleid, rsp);
/*     */     
/* 173 */     StringBuffer logBuilder = new StringBuffer();
/* 174 */     logBuilder.append("[zoo]PCGetAward.onFailed@get award failed");
/* 175 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 176 */     logBuilder.append('|').append("animalid=").append(this.animalid);
/* 177 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 179 */     if (extraParams != null)
/*     */     {
/* 181 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 183 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 187 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\main\PCGetAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */