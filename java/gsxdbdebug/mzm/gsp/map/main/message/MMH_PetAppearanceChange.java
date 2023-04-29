/*     */ package mzm.gsp.map.main.message;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.MapModelInfo;
/*     */ import mzm.gsp.map.SSyncRoleModelChange;
/*     */ import mzm.gsp.map.SSyncRoleNameChange;
/*     */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*     */ import mzm.gsp.map.main.scene.object.MapRole;
/*     */ import mzm.gsp.pubdata.ModelInfo;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ public class MMH_PetAppearanceChange
/*     */   extends AbstractMapMsgHandler
/*     */ {
/*     */   public static final int REASON_DECORATE = 0;
/*     */   public static final int REASON_SHOW = 1;
/*     */   public static final int REASON_HIDE = 2;
/*     */   public static final int REASON_DELETE = 3;
/*     */   public static final int REASON_RENAME = 4;
/*     */   public static final int REASON_STAGE_LEVEL = 5;
/*     */   public static final int REASON_MARK = 6;
/*     */   private final long roleId;
/*     */   private final long petId;
/*     */   private final MapModelInfo petModelInfo;
/*     */   private final int reason;
/*     */   
/*     */   public MMH_PetAppearanceChange(long roleId, long petId, MapModelInfo petModelInfo, int reason)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.petId = petId;
/*  33 */     this.petModelInfo = petModelInfo;
/*  34 */     this.reason = reason;
/*     */   }
/*     */   
/*     */ 
/*     */   public void doProcess()
/*     */   {
/*  40 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleId);
/*  41 */     if (role == null)
/*     */     {
/*  43 */       return;
/*     */     }
/*     */     
/*  46 */     if (this.reason != 1)
/*     */     {
/*  48 */       if (role.getPetModel() == null)
/*     */       {
/*  50 */         return;
/*     */       }
/*     */       
/*  53 */       if (role.getPetModel().id != this.petId)
/*     */       {
/*  55 */         return;
/*     */       }
/*     */     }
/*     */     
/*  59 */     role.setPetModelInfo(this.petModelInfo);
/*     */     
/*     */ 
/*  62 */     if (role.isInTeam())
/*     */     {
/*  64 */       return;
/*     */     }
/*     */     
/*  67 */     switch (this.reason)
/*     */     {
/*     */ 
/*     */     case 0: 
/*  71 */       SSyncRoleModelChange syncRoleModelChange = new SSyncRoleModelChange();
/*  72 */       syncRoleModelChange.roleid = this.roleId;
/*  73 */       Integer petShipin = (Integer)this.petModelInfo.model.extramap.get(Integer.valueOf(9));
/*  74 */       syncRoleModelChange.intpropmap.put(Integer.valueOf(18), Integer.valueOf(petShipin == null ? 0 : petShipin.intValue()));
/*  75 */       role.broadcastProtocolIncludeSelf(syncRoleModelChange);
/*     */       
/*  77 */       return;
/*     */     
/*     */ 
/*     */     case 2: 
/*     */     case 3: 
/*  82 */       SSyncRoleModelChange syncRoleModelChange = new SSyncRoleModelChange();
/*  83 */       syncRoleModelChange.roleid = this.roleId;
/*  84 */       syncRoleModelChange.intpropmap.put(Integer.valueOf(0), Integer.valueOf(0));
/*  85 */       syncRoleModelChange.longpropmap.put(Integer.valueOf(0), Long.valueOf(0L));
/*  86 */       role.broadcastProtocolIncludeSelf(syncRoleModelChange);
/*     */       
/*  88 */       return;
/*     */     
/*     */ 
/*     */     case 1: 
/*  92 */       role.setChildrenModelInfo(null);
/*  93 */       role.tryShowFollower();
/*     */       
/*  95 */       return;
/*     */     
/*     */ 
/*     */     case 4: 
/*  99 */       SSyncRoleNameChange roleNameChange = new SSyncRoleNameChange();
/* 100 */       roleNameChange.nametype = 1;
/* 101 */       roleNameChange.name = ((String)this.petModelInfo.string_props.get(Integer.valueOf(0)));
/* 102 */       roleNameChange.roleid = this.roleId;
/* 103 */       role.broadcastProtocolIncludeSelf(roleNameChange);
/*     */       
/* 105 */       return;
/*     */     
/*     */ 
/*     */     case 5: 
/* 109 */       SSyncRoleModelChange syncRoleModelChange = new SSyncRoleModelChange();
/* 110 */       syncRoleModelChange.roleid = this.roleId;
/* 111 */       syncRoleModelChange.intpropmap.put(Integer.valueOf(26), this.petModelInfo.model.extramap.get(Integer.valueOf(17)));
/*     */       
/* 113 */       role.broadcastProtocolIncludeSelf(syncRoleModelChange);
/*     */       
/* 115 */       return;
/*     */     
/*     */ 
/*     */     case 6: 
/* 119 */       SSyncRoleModelChange syncRoleModelChange = new SSyncRoleModelChange();
/* 120 */       syncRoleModelChange.roleid = this.roleId;
/* 121 */       Integer petMarkCfgid = (Integer)this.petModelInfo.model.extramap.get(Integer.valueOf(39));
/* 122 */       syncRoleModelChange.intpropmap.put(Integer.valueOf(44), Integer.valueOf(petMarkCfgid == null ? 0 : petMarkCfgid.intValue()));
/*     */       
/* 124 */       role.broadcastProtocolIncludeSelf(syncRoleModelChange);
/*     */       
/* 126 */       return;
/*     */     }
/*     */     
/*     */     
/* 130 */     GameServer.logger().error(String.format("[map]MMH_PetAppearanceChange.doProcess@unkown reason|roleid=%d|petid=%d|reason=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(this.reason) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_PetAppearanceChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */