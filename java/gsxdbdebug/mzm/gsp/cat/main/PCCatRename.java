/*     */ package mzm.gsp.cat.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.cat.SCatRenameFailed;
/*     */ import mzm.gsp.cat.SCatRenameSuccess;
/*     */ import mzm.gsp.cat.confbean.SCatCfgConsts;
/*     */ import mzm.gsp.cat.event.CatRename;
/*     */ import mzm.gsp.cat.event.CatRenameArg;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.sensitive.main.SensitiveInterface;
/*     */ import mzm.gsp.server.main.AvailableStringArgs;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CatInfo;
/*     */ 
/*     */ public class PCCatRename
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final String name;
/*     */   private long catid;
/*     */   
/*     */   public PCCatRename(long roleid, Octets nameOctets)
/*     */   {
/*  33 */     this.roleid = roleid;
/*  34 */     String tmpName = null;
/*     */     try
/*     */     {
/*  37 */       tmpName = nameOctets.getString("UTF-8");
/*     */     }
/*     */     catch (Exception e) {}
/*     */     
/*     */ 
/*     */ 
/*  43 */     this.name = tmpName;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  49 */     if (this.name == null)
/*     */     {
/*  51 */       GameServer.logger().error(String.format("[cat]PCCatRename.processImp@name is null|roleid=%d|encoding=%s", new Object[] { Long.valueOf(this.roleid), "UTF-8" }));
/*     */       
/*     */ 
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     if (!CatManager.isFunOpen(this.roleid))
/*     */     {
/*  59 */       onFailed(12);
/*  60 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  64 */     if (!CatManager.checkRoleStatus(this.roleid))
/*     */     {
/*  66 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  70 */     if (!HomelandInterface.hasHome(this.roleid))
/*     */     {
/*  72 */       onFailed(6);
/*  73 */       return false;
/*     */     }
/*  75 */     long worldid = HomelandInterface.getHomeWorldIdByRoleId(this.roleid, false);
/*  76 */     if (worldid < 0L)
/*     */     {
/*  78 */       onFailed(11);
/*  79 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  83 */     CatInfo xCatInfo = CatManager.getHomelandCat(this.roleid, true);
/*  84 */     if (xCatInfo == null)
/*     */     {
/*  86 */       onFailed(4);
/*  87 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  91 */     if (!CatManager.checkNpcService(this.roleid, xCatInfo))
/*     */     {
/*  93 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  97 */     this.catid = xCatInfo.getId();
/*  98 */     if (!CatManager.checkState(xCatInfo))
/*     */     {
/* 100 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 104 */     if (xCatInfo.getState() == 2)
/*     */     {
/* 106 */       Map<String, Object> extras = new HashMap();
/* 107 */       extras.put("current_state", Integer.valueOf(2));
/* 108 */       extras.put("cat_level_cfgid", Integer.valueOf(xCatInfo.getCat_level_cfgid()));
/* 109 */       extras.put("item_cfgid", Integer.valueOf(xCatInfo.getItem_cfgid()));
/* 110 */       onFailed(5, extras);
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     int length = (int)Math.ceil(CommonUtils.getUTF16Length(this.name) / 2.0D);
/* 115 */     if (length < SCatCfgConsts.getInstance().MIN_CAT_NAME_LEN)
/*     */     {
/* 117 */       onFailed(-2);
/* 118 */       return false;
/*     */     }
/* 120 */     if (length > SCatCfgConsts.getInstance().MAX_CAT_NAME_LEN)
/*     */     {
/* 122 */       onFailed(-3);
/* 123 */       return false;
/*     */     }
/* 125 */     if ((SensitiveInterface.isNameSensitive(this.name)) || (!AvailableStringArgs.getInstance().isStringUsable(this.name)) || (this.name.matches("\\d+")))
/*     */     {
/*     */ 
/* 128 */       onFailed(-1);
/* 129 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 133 */     String oldName = xCatInfo.getName();
/* 134 */     xCatInfo.setName(this.name);
/*     */     
/*     */ 
/* 137 */     CatRename catRenameEvent = new CatRename();
/* 138 */     CatRenameArg catRenameArg = new CatRenameArg(this.roleid, this.catid, oldName, this.name);
/* 139 */     TriggerEventsManger.getInstance().triggerEvent(catRenameEvent, catRenameArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */     
/*     */ 
/* 142 */     SCatRenameSuccess resp = new SCatRenameSuccess();
/* 143 */     resp.cat_name.setString(this.name, "UTF-8");
/* 144 */     OnlineManager.getInstance().send(this.roleid, resp);
/*     */     
/* 146 */     GameServer.logger().info(String.format("[cat]PCCatRename.processImp@cat rename success|roleid=%d|catid=%d|cat_level_cfgid=%d|item_cfgid=%d|old_name=%s|new_name=%s", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.catid), Integer.valueOf(xCatInfo.getCat_level_cfgid()), Integer.valueOf(xCatInfo.getItem_cfgid()), oldName, this.name }));
/*     */     
/*     */ 
/*     */ 
/* 150 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 155 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 160 */     if (retcode < 0)
/*     */     {
/* 162 */       SCatRenameFailed resp = new SCatRenameFailed();
/* 163 */       resp.retcode = retcode;
/* 164 */       OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     }
/*     */     
/* 167 */     StringBuffer logBuilder = new StringBuffer();
/* 168 */     logBuilder.append("[cat]PCChangePartner.onFailed@change partner failed");
/* 169 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 170 */     logBuilder.append('|').append("catid=").append(this.catid);
/* 171 */     logBuilder.append('|').append("retcode=").append(retcode);
/* 172 */     logBuilder.append('|').append("name=").append(this.name);
/*     */     
/* 174 */     if (extraParams != null)
/*     */     {
/* 176 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 178 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 182 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\main\PCCatRename.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */