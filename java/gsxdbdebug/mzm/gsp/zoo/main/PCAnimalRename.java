/*     */ package mzm.gsp.zoo.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.homeland.confbean.SAnimalConst;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.server.main.AvailableStringArgs;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.zoo.SAnimalRenameFailed;
/*     */ import mzm.gsp.zoo.SAnimalRenameSuccess;
/*     */ import mzm.gsp.zoo.event.AnimalRename;
/*     */ import mzm.gsp.zoo.event.AnimalRenameArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AnimalInfo;
/*     */ import xbean.ZooInfo;
/*     */ import xtable.Role2zooinfo;
/*     */ 
/*     */ public class PCAnimalRename extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long animalid;
/*     */   private final String name;
/*     */   
/*     */   public PCAnimalRename(long roleid, long animalid, String name)
/*     */   {
/*  34 */     this.roleid = roleid;
/*  35 */     this.animalid = animalid;
/*  36 */     this.name = name;
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
/*  47 */     if (!ZooManager.canDoAction(this.roleid, 1196))
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
/*  79 */     lock(xdb.Lockeys.get(xtable.User.getTable(), userid));
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
/*  95 */     AnimalInfo xAnimalInfo = xtable.Animal.get(Long.valueOf(this.animalid));
/*  96 */     if (xAnimalInfo == null)
/*     */     {
/*  98 */       onFailed(7);
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     if (xAnimalInfo.getStage() == 0)
/*     */     {
/* 104 */       Map<String, Object> extras = new HashMap();
/* 105 */       extras.put("stage", Integer.valueOf(xAnimalInfo.getStage()));
/* 106 */       onFailed(8, extras);
/* 107 */       return false;
/*     */     }
/*     */     
/* 110 */     int length = (int)Math.ceil(CommonUtils.getUTF16Length(this.name) / 2.0D);
/* 111 */     if (length < SAnimalConst.getInstance().NAME_MIN_LENGTH)
/*     */     {
/* 113 */       onFailed(-1);
/* 114 */       return false;
/*     */     }
/* 116 */     if (length > SAnimalConst.getInstance().NAME_MAX_LENGTH)
/*     */     {
/* 118 */       onFailed(-2);
/* 119 */       return false;
/*     */     }
/* 121 */     if ((mzm.gsp.sensitive.main.SensitiveInterface.isNameSensitive(this.name)) || (!AvailableStringArgs.getInstance().isStringUsable(this.name)) || (this.name.matches("\\d+")))
/*     */     {
/*     */ 
/* 124 */       onFailed(-3);
/* 125 */       return false;
/*     */     }
/*     */     
/* 128 */     String oldName = xAnimalInfo.getName();
/* 129 */     xAnimalInfo.setName(this.name);
/*     */     
/*     */ 
/* 132 */     AnimalRenameArg arg = new AnimalRenameArg(this.roleid, this.animalid, oldName, this.name);
/* 133 */     AnimalRename event = new AnimalRename();
/* 134 */     TriggerEventsManger.getInstance().triggerEvent(event, arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 139 */     SAnimalRenameSuccess rsp = new SAnimalRenameSuccess();
/* 140 */     rsp.animalid = this.animalid;
/* 141 */     rsp.name.setString(this.name, "UTF-8");
/* 142 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*     */     
/* 144 */     GameServer.logger().info(String.format("[zoo]PCAnimalRename.processImp@success|roleid=%d|animalid=%d|name=%s", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.animalid), this.name }));
/*     */     
/*     */ 
/* 147 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 152 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 157 */     SAnimalRenameFailed rsp = new SAnimalRenameFailed();
/* 158 */     rsp.animalid = this.animalid;
/* 159 */     rsp.retcode = retcode;
/*     */     try
/*     */     {
/* 162 */       rsp.name.setString(this.name, "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/* 167 */     OnlineManager.getInstance().sendAtOnce(this.roleid, rsp);
/*     */     
/* 169 */     StringBuffer logBuilder = new StringBuffer();
/* 170 */     logBuilder.append("[zoo]PCAnimalRename.onFailed@rename failed");
/* 171 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 172 */     logBuilder.append('|').append("animalid=").append(this.animalid);
/* 173 */     logBuilder.append('|').append("name=").append(this.name);
/* 174 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 176 */     if (extraParams != null)
/*     */     {
/* 178 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 180 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 184 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\main\PCAnimalRename.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */