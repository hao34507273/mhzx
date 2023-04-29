/*     */ package mzm.gsp.zoo.main;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.homeland.confbean.SAnimalConst;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.zoo.SGetAnimalMatesSuccess;
/*     */ import xbean.AdultStageInfo;
/*     */ import xbean.AnimalInfo;
/*     */ import xbean.ZooInfo;
/*     */ import xtable.Role2zooinfo;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetAnimalMates extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long animalid;
/*     */   
/*     */   public PCGetAnimalMates(long roleid, long animalid)
/*     */   {
/*  29 */     this.roleid = roleid;
/*  30 */     this.animalid = animalid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     if (this.animalid <= 0L)
/*     */     {
/*  38 */       return false;
/*     */     }
/*     */     
/*  41 */     if (!ZooManager.canDoAction(this.roleid, 1198))
/*     */     {
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     if (!ZooManager.isFunOpen(this.roleid))
/*     */     {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     int level = RoleInterface.getLevel(this.roleid);
/*  52 */     if (level < SAnimalConst.getInstance().OPEN_LEVEL)
/*     */     {
/*  54 */       onFailed(6);
/*  55 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  59 */     if (!HomelandInterface.hasHome(this.roleid))
/*     */     {
/*  61 */       onFailed(4);
/*  62 */       return false;
/*     */     }
/*  64 */     long worldid = HomelandInterface.getHomeWorldIdByRoleId(this.roleid, false);
/*  65 */     if (worldid < 0L)
/*     */     {
/*  67 */       onFailed(5);
/*  68 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  72 */     String userid = RoleInterface.getUserId(this.roleid);
/*  73 */     lock(xdb.Lockeys.get(User.getTable(), userid));
/*  74 */     ZooInfo xZooInfo = Role2zooinfo.get(Long.valueOf(this.roleid));
/*  75 */     if (xZooInfo == null)
/*     */     {
/*  77 */       onFailed(1);
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     if (!xZooInfo.getAnimals().contains(Long.valueOf(this.animalid)))
/*     */     {
/*  83 */       Map<String, Object> extras = new HashMap();
/*  84 */       extras.put("animals", xZooInfo.getAnimals().toString());
/*  85 */       onFailed(7, extras);
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     AnimalInfo xAnimalInfo = xtable.Animal.get(Long.valueOf(this.animalid));
/*  90 */     if (xAnimalInfo == null)
/*     */     {
/*  92 */       onFailed(7);
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     int stage = xAnimalInfo.getStage();
/*  97 */     if (stage == 0)
/*     */     {
/*  99 */       Map<String, Object> extras = new HashMap();
/* 100 */       extras.put("stage", Integer.valueOf(xAnimalInfo.getStage()));
/* 101 */       onFailed(8, extras);
/* 102 */       return false;
/*     */     }
/*     */     
/* 105 */     AdultStageInfo xAdultStageInfo = xAnimalInfo.getAdult_info();
/*     */     
/* 107 */     SGetAnimalMatesSuccess msg = new SGetAnimalMatesSuccess();
/* 108 */     msg.animalid = this.animalid;
/* 109 */     msg.birth_time = ((int)TimeUnit.MILLISECONDS.toSeconds(xAdultStageInfo.getBirth_time()));
/* 110 */     msg.mate_times = xAdultStageInfo.getMate_times();
/* 111 */     fillMateInfos(msg.mate_infos, xAdultStageInfo.getMate_infos());
/* 112 */     OnlineManager.getInstance().send(this.roleid, msg);
/*     */     
/* 114 */     return true;
/*     */   }
/*     */   
/*     */   private void fillMateInfos(List<mzm.gsp.zoo.MateInfo> list, List<xbean.MateInfo> xSource)
/*     */   {
/* 119 */     if (list == null)
/*     */     {
/* 121 */       return;
/*     */     }
/* 123 */     if ((xSource == null) || (xSource.isEmpty()))
/*     */     {
/* 125 */       return;
/*     */     }
/*     */     
/* 128 */     ListIterator<xbean.MateInfo> xListIterator = xSource.listIterator(xSource.size());
/* 129 */     while (xListIterator.hasPrevious())
/*     */     {
/* 131 */       xbean.MateInfo xMateInfo = (xbean.MateInfo)xListIterator.previous();
/* 132 */       mzm.gsp.zoo.MateInfo mateInfo = new mzm.gsp.zoo.MateInfo();
/* 133 */       mateInfo.animal_cfgid = xMateInfo.getAnimal_cfgid();
/* 134 */       mateInfo.mate_time = ((int)TimeUnit.MILLISECONDS.toSeconds(xMateInfo.getMate_time()));
/*     */       try
/*     */       {
/* 137 */         mateInfo.role_name.setString(xMateInfo.getRole_name(), "UTF-8");
/*     */       }
/*     */       catch (UnsupportedEncodingException e) {}
/*     */       
/*     */ 
/* 142 */       list.add(mateInfo);
/*     */     }
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 148 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 153 */     StringBuffer logBuilder = new StringBuffer();
/* 154 */     logBuilder.append("[zoo]PCGetAnimalMates.onFailed@get animal mates failed");
/* 155 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 156 */     logBuilder.append('|').append("animalid=").append(this.animalid);
/* 157 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 159 */     if (extraParams != null)
/*     */     {
/* 161 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 163 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 167 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\main\PCGetAnimalMates.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */