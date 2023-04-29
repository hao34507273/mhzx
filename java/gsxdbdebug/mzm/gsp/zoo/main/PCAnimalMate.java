/*     */ package mzm.gsp.zoo.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.homeland.confbean.SAnimalCfg;
/*     */ import mzm.gsp.homeland.confbean.SAnimalConst;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.zoo.SAnimalMateFailed;
/*     */ import mzm.gsp.zoo.SAnimalMateSuccess;
/*     */ import mzm.gsp.zoo.event.AnimalMate;
/*     */ import mzm.gsp.zoo.event.AnimalMateArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AdultStageInfo;
/*     */ import xbean.AnimalInfo;
/*     */ import xbean.MateInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Animal;
/*     */ 
/*     */ public class PCAnimalMate extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long animalid;
/*     */   private final long targetAnimalid;
/*     */   
/*     */   public PCAnimalMate(long roleid, long animalid, long targetAnimalid)
/*     */   {
/*  34 */     this.roleid = roleid;
/*  35 */     this.animalid = animalid;
/*  36 */     this.targetAnimalid = targetAnimalid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     if ((this.animalid <= 0L) || (this.targetAnimalid <= 0L))
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     if (!ZooManager.canDoAction(this.roleid, 1194))
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
/*     */     
/*  71 */     AnimalInfo xTargetAnimalInfo = Animal.select(Long.valueOf(this.targetAnimalid));
/*  72 */     if (xTargetAnimalInfo == null)
/*     */     {
/*  74 */       onFailed(7);
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     long targetRoleid = xTargetAnimalInfo.getOwner();
/*  79 */     if (this.roleid == targetRoleid)
/*     */     {
/*  81 */       onFailed(-2);
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     long marriageRoleid = mzm.gsp.marriage.main.MarriageInterface.getMarriedRoleid(this.roleid, false);
/*  86 */     if ((marriageRoleid > 0L) && (targetRoleid == marriageRoleid))
/*     */     {
/*  88 */       onFailed(-3);
/*  89 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  93 */     if (!HomelandInterface.hasHome(targetRoleid))
/*     */     {
/*  95 */       onFailed(4);
/*  96 */       return false;
/*     */     }
/*  98 */     long worldid = HomelandInterface.getHomeWorldIdByRoleId(targetRoleid, false);
/*  99 */     if (worldid < 0L)
/*     */     {
/* 101 */       onFailed(5);
/* 102 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 106 */     String userid = RoleInterface.getUserId(this.roleid);
/* 107 */     String targetUserid = RoleInterface.getUserId(targetRoleid);
/* 108 */     lock(Lockeys.get(xtable.User.getTable(), new Object[] { userid, targetUserid }));
/* 109 */     lock(Lockeys.get(xtable.Basic.getTable(), new Object[] { Long.valueOf(this.roleid), Long.valueOf(targetRoleid) }));
/* 110 */     lock(Lockeys.get(Animal.getTable(), new Object[] { Long.valueOf(this.animalid), Long.valueOf(this.targetAnimalid) }));
/*     */     
/* 112 */     AnimalInfo xAnimalInfo = ZooManager.getAnimalInfo(this.roleid, this.animalid);
/* 113 */     if (xAnimalInfo == null)
/*     */     {
/* 115 */       onFailed(7);
/* 116 */       return false;
/*     */     }
/*     */     
/* 119 */     xTargetAnimalInfo = ZooManager.getAnimalInfo(targetRoleid, this.targetAnimalid);
/* 120 */     if (xTargetAnimalInfo == null)
/*     */     {
/* 122 */       onFailed(7);
/* 123 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 127 */     if (xAnimalInfo.getStage() != 1)
/*     */     {
/* 129 */       onFailed(8);
/* 130 */       return false;
/*     */     }
/* 132 */     if (xTargetAnimalInfo.getStage() != 1)
/*     */     {
/* 134 */       onFailed(8);
/* 135 */       return false;
/*     */     }
/*     */     
/* 138 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 139 */     AdultStageInfo xAdultStageInfo = xAnimalInfo.getAdult_info();
/* 140 */     if (!checkMate(this.roleid, this.animalid, xAdultStageInfo, now))
/*     */     {
/* 142 */       return false;
/*     */     }
/* 144 */     AdultStageInfo xTargetAdultStageInfo = xTargetAnimalInfo.getAdult_info();
/* 145 */     if (!checkMate(targetRoleid, this.targetAnimalid, xTargetAdultStageInfo, now))
/*     */     {
/* 147 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 152 */     xAdultStageInfo.setMate_times(xAdultStageInfo.getMate_times() + 1);
/* 153 */     MateInfo xMateInfo = xbean.Pod.newMateInfo();
/* 154 */     xMateInfo.setAnimal_cfgid(xTargetAdultStageInfo.getAnimal_cfgid());
/* 155 */     xMateInfo.setMate_time(now);
/* 156 */     xMateInfo.setRole_name(RoleInterface.getName(targetRoleid));
/* 157 */     xAdultStageInfo.getMate_infos().add(xMateInfo);
/* 158 */     if (xAdultStageInfo.getMate_infos().size() > SAnimalConst.getInstance().MATE_RECORD_LIMIT)
/*     */     {
/* 160 */       xAdultStageInfo.getMate_infos().remove(0);
/*     */     }
/*     */     
/*     */ 
/* 164 */     xTargetAdultStageInfo.setMate_times(xTargetAdultStageInfo.getMate_times() + 1);
/* 165 */     MateInfo xMateInfo = xbean.Pod.newMateInfo();
/* 166 */     xMateInfo.setAnimal_cfgid(xAdultStageInfo.getAnimal_cfgid());
/* 167 */     xMateInfo.setMate_time(now);
/* 168 */     xMateInfo.setRole_name(RoleInterface.getName(this.roleid));
/* 169 */     xTargetAdultStageInfo.getMate_infos().add(xMateInfo);
/* 170 */     if (xTargetAdultStageInfo.getMate_infos().size() > SAnimalConst.getInstance().MATE_RECORD_LIMIT)
/*     */     {
/* 172 */       xTargetAdultStageInfo.getMate_infos().remove(0);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 177 */     ZooManager.addTLog(this.roleid, "AniamlMateForServer", new Object[] { Long.valueOf(this.animalid), Integer.valueOf(xAdultStageInfo.getAnimal_cfgid()), Long.valueOf(targetRoleid), Long.valueOf(this.targetAnimalid), Integer.valueOf(xTargetAdultStageInfo.getAnimal_cfgid()) });
/*     */     
/*     */ 
/* 180 */     ZooManager.addTLog(targetRoleid, "AniamlMateForServer", new Object[] { Long.valueOf(this.targetAnimalid), Integer.valueOf(xTargetAdultStageInfo.getAnimal_cfgid()), Long.valueOf(this.roleid), Long.valueOf(this.animalid), Integer.valueOf(xAdultStageInfo.getAnimal_cfgid()) });
/*     */     
/*     */ 
/* 183 */     GameServer.logger().info(String.format("[zoo]PCAnimalMate.processImp@animal mate success|roleid=%d|target_roleid=%d|animalid=%d|target_animalid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(targetRoleid), Long.valueOf(this.animalid), Long.valueOf(this.targetAnimalid) }));
/*     */     
/*     */ 
/*     */ 
/* 187 */     return true;
/*     */   }
/*     */   
/*     */   private boolean checkMate(long roleid, long animalid, AdultStageInfo xAdultStageInfo, long now)
/*     */   {
/* 192 */     SAnimalCfg animalCfg = SAnimalCfg.get(xAdultStageInfo.getAnimal_cfgid());
/* 193 */     if (animalCfg == null)
/*     */     {
/* 195 */       Map<String, Object> extras = new java.util.HashMap();
/* 196 */       extras.put("animal_cfgid", Integer.valueOf(xAdultStageInfo.getAnimal_cfgid()));
/* 197 */       onFailed(3, extras);
/* 198 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 202 */     if (xAdultStageInfo.getLast_mate_time() + TimeUnit.MINUTES.toMillis(animalCfg.mateCd) > now)
/*     */     {
/* 204 */       onFailed(-1);
/* 205 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 209 */     if (xAdultStageInfo.getAward_cfgid() > 0)
/*     */     {
/* 211 */       return false;
/*     */     }
/*     */     
/* 214 */     xAdultStageInfo.setLast_mate_time(now);
/* 215 */     int awardCfgid = animalCfg.awardCfgid;
/* 216 */     xAdultStageInfo.setAward_cfgid(awardCfgid);
/*     */     
/* 218 */     AnimalMateArg arg = new AnimalMateArg(roleid, animalid, now, awardCfgid);
/* 219 */     AnimalMate event = new AnimalMate();
/* 220 */     TriggerEventsManger.getInstance().triggerEvent(event, arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleid)));
/*     */     
/* 222 */     if (OnlineManager.getInstance().isOnline(roleid))
/*     */     {
/* 224 */       SAnimalMateSuccess msg = new SAnimalMateSuccess();
/* 225 */       msg.animalid = animalid;
/* 226 */       msg.last_time = ((int)TimeUnit.MILLISECONDS.toSeconds(now));
/* 227 */       msg.award_cfgid = awardCfgid;
/* 228 */       OnlineManager.getInstance().send(roleid, msg);
/*     */     }
/*     */     
/* 231 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 236 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 241 */     SAnimalMateFailed rsp = new SAnimalMateFailed();
/* 242 */     rsp.animalid = this.animalid;
/* 243 */     rsp.target_animalid = this.targetAnimalid;
/* 244 */     rsp.retcode = retcode;
/* 245 */     OnlineManager.getInstance().sendAtOnce(this.roleid, rsp);
/*     */     
/* 247 */     StringBuffer logBuilder = new StringBuffer();
/* 248 */     logBuilder.append("[zoo]PCAnimalMate.onFailed@animal mate failed");
/* 249 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 250 */     logBuilder.append('|').append("animalid=").append(this.animalid);
/* 251 */     logBuilder.append('|').append("target_animalid=").append(this.targetAnimalid);
/* 252 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 254 */     if (extraParams != null)
/*     */     {
/* 256 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 258 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 262 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\main\PCAnimalMate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */