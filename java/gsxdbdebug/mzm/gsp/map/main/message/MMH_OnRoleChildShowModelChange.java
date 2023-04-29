/*     */ package mzm.gsp.map.main.message;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import mzm.gsp.children.event.ChildShowModelChangeReason;
/*     */ import mzm.gsp.children.main.ChildrenInterface.ShowChildObj;
/*     */ import mzm.gsp.map.MapModelInfo;
/*     */ import mzm.gsp.map.SSyncRoleModelChange;
/*     */ import mzm.gsp.map.main.MapManager;
/*     */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*     */ import mzm.gsp.map.main.scene.object.MapRole;
/*     */ import mzm.gsp.pubdata.ModelInfo;
/*     */ 
/*     */ public class MMH_OnRoleChildShowModelChange extends AbstractMapMsgHandler
/*     */ {
/*     */   private final long roleid;
/*     */   private final ChildShowModelChangeReason reason;
/*     */   private final ChildrenInterface.ShowChildObj showChildObj;
/*     */   
/*     */   public MMH_OnRoleChildShowModelChange(long roleid, ChildShowModelChangeReason reason, ChildrenInterface.ShowChildObj showChildObj)
/*     */   {
/*  21 */     this.roleid = roleid;
/*  22 */     this.reason = reason;
/*  23 */     this.showChildObj = showChildObj;
/*     */   }
/*     */   
/*     */ 
/*     */   public void doProcess()
/*     */   {
/*  29 */     MapRole mapRole = MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/*  30 */     if (mapRole == null)
/*     */     {
/*  32 */       return;
/*     */     }
/*     */     
/*  35 */     switch (this.reason)
/*     */     {
/*     */ 
/*     */     case ADD: 
/*  39 */       if (this.showChildObj == null)
/*     */       {
/*  41 */         return;
/*     */       }
/*     */       
/*  44 */       MapModelInfo childrenModelInfo = MapManager.boxChildrenModelInfo(this.showChildObj);
/*  45 */       mapRole.setChildrenModelInfo(childrenModelInfo);
/*  46 */       mapRole.setPetModelInfo(null);
/*  47 */       mapRole.tryShowFollower();
/*     */       
/*  49 */       break;
/*     */     
/*     */ 
/*     */     case REMOVE: 
/*  53 */       mapRole.setChildrenModelInfo(null);
/*     */       
/*  55 */       SSyncRoleModelChange syncRoleModelChange = new SSyncRoleModelChange();
/*  56 */       syncRoleModelChange.roleid = this.roleid;
/*  57 */       syncRoleModelChange.longpropmap.put(Integer.valueOf(1), Long.valueOf(0L));
/*  58 */       mapRole.broadcastProtocolIncludeSelf(syncRoleModelChange);
/*     */       
/*  60 */       break;
/*     */     
/*     */ 
/*     */     case CHANGE_NAME: 
/*  64 */       if (this.showChildObj == null)
/*     */       {
/*  66 */         return;
/*     */       }
/*     */       
/*  69 */       MapModelInfo childrenModelInfo = mapRole.getChildrenModel();
/*  70 */       if (childrenModelInfo == null)
/*     */       {
/*  72 */         return;
/*     */       }
/*     */       
/*  75 */       String childName = this.showChildObj.getChildName();
/*  76 */       childrenModelInfo.string_props.put(Integer.valueOf(0), childName);
/*  77 */       mapRole.updateChildrenModelCache();
/*     */       
/*  79 */       SSyncRoleModelChange syncRoleModelChange = new SSyncRoleModelChange();
/*  80 */       syncRoleModelChange.roleid = this.roleid;
/*  81 */       syncRoleModelChange.stringpropmap.put(Integer.valueOf(3), childName);
/*  82 */       mapRole.broadcastProtocolIncludeSelf(syncRoleModelChange);
/*     */       
/*     */ 
/*  85 */       break;
/*     */     
/*     */ 
/*     */     case PERIOD_CHANGE: 
/*  89 */       if (this.showChildObj == null)
/*     */       {
/*  91 */         return;
/*     */       }
/*     */       
/*  94 */       MapModelInfo childrenModelInfo = mapRole.getChildrenModel();
/*  95 */       if (childrenModelInfo == null)
/*     */       {
/*  97 */         return;
/*     */       }
/*     */       
/* 100 */       int phase = this.showChildObj.getChildPeriod();
/* 101 */       int modelid = this.showChildObj.getChildrenCfgid();
/* 102 */       childrenModelInfo.model.extramap.put(Integer.valueOf(25), Integer.valueOf(phase));
/* 103 */       childrenModelInfo.model.extramap.put(Integer.valueOf(28), Integer.valueOf(modelid));
/* 104 */       mapRole.updateChildrenModelCache();
/*     */       
/* 106 */       SSyncRoleModelChange syncRoleModelChange = new SSyncRoleModelChange();
/* 107 */       syncRoleModelChange.roleid = this.roleid;
/* 108 */       syncRoleModelChange.intpropmap.put(Integer.valueOf(31), Integer.valueOf(phase));
/* 109 */       syncRoleModelChange.intpropmap.put(Integer.valueOf(34), Integer.valueOf(modelid));
/* 110 */       mapRole.broadcastProtocolIncludeSelf(syncRoleModelChange);
/*     */       
/*     */ 
/* 113 */       break;
/*     */     
/*     */ 
/*     */     case FASHION_CHANGE: 
/* 117 */       if (this.showChildObj == null)
/*     */       {
/* 119 */         return;
/*     */       }
/*     */       
/* 122 */       MapModelInfo childrenModelInfo = mapRole.getChildrenModel();
/* 123 */       if (childrenModelInfo == null)
/*     */       {
/* 125 */         return;
/*     */       }
/*     */       
/* 128 */       int fashionCfgid = this.showChildObj.getFashionCfgid();
/* 129 */       childrenModelInfo.model.extramap.put(Integer.valueOf(27), Integer.valueOf(fashionCfgid));
/* 130 */       mapRole.updateChildrenModelCache();
/*     */       
/* 132 */       SSyncRoleModelChange syncRoleModelChange = new SSyncRoleModelChange();
/* 133 */       syncRoleModelChange.roleid = this.roleid;
/* 134 */       syncRoleModelChange.intpropmap.put(Integer.valueOf(34), Integer.valueOf(this.showChildObj.getChildrenCfgid()));
/*     */       
/* 136 */       syncRoleModelChange.intpropmap.put(Integer.valueOf(33), Integer.valueOf(fashionCfgid));
/* 137 */       mapRole.broadcastProtocolIncludeSelf(syncRoleModelChange);
/*     */       
/*     */ 
/* 140 */       break;
/*     */     
/*     */ 
/*     */     case FASHION_REMOVE: 
/* 144 */       if (this.showChildObj == null)
/*     */       {
/* 146 */         return;
/*     */       }
/*     */       
/* 149 */       MapModelInfo childrenModelInfo = mapRole.getChildrenModel();
/* 150 */       if (childrenModelInfo == null)
/*     */       {
/* 152 */         return;
/*     */       }
/*     */       
/* 155 */       childrenModelInfo.model.extramap.remove(Integer.valueOf(27));
/* 156 */       mapRole.updateChildrenModelCache();
/*     */       
/* 158 */       SSyncRoleModelChange syncRoleModelChange = new SSyncRoleModelChange();
/* 159 */       syncRoleModelChange.roleid = this.roleid;
/* 160 */       syncRoleModelChange.intpropmap.put(Integer.valueOf(34), Integer.valueOf(this.showChildObj.getChildrenCfgid()));
/*     */       
/* 162 */       syncRoleModelChange.intpropmap.put(Integer.valueOf(33), Integer.valueOf(0));
/* 163 */       mapRole.broadcastProtocolIncludeSelf(syncRoleModelChange);
/*     */       
/*     */ 
/* 166 */       break;
/*     */     
/*     */ 
/*     */     case CHILD_WEAPON_CHANGE: 
/* 170 */       if (this.showChildObj == null)
/*     */       {
/* 172 */         return;
/*     */       }
/*     */       
/* 175 */       MapModelInfo childrenModelInfo = mapRole.getChildrenModel();
/* 176 */       if (childrenModelInfo == null)
/*     */       {
/* 178 */         return;
/*     */       }
/*     */       
/* 181 */       SSyncRoleModelChange syncRoleModelChange = new SSyncRoleModelChange();
/*     */       
/* 183 */       int childrenWeaponCfgid = this.showChildObj.getChildrenWeaponCfgid();
/* 184 */       if (childrenWeaponCfgid > 0)
/*     */       {
/* 186 */         childrenModelInfo.model.extramap.put(Integer.valueOf(29), Integer.valueOf(childrenWeaponCfgid));
/*     */         
/* 188 */         syncRoleModelChange.intpropmap.put(Integer.valueOf(35), Integer.valueOf(childrenWeaponCfgid));
/*     */       }
/*     */       else
/*     */       {
/* 192 */         childrenModelInfo.model.extramap.remove(Integer.valueOf(29));
/*     */         
/* 194 */         syncRoleModelChange.intpropmap.put(Integer.valueOf(35), Integer.valueOf(0));
/*     */       }
/* 196 */       mapRole.updateChildrenModelCache();
/*     */       
/* 198 */       syncRoleModelChange.roleid = this.roleid;
/* 199 */       mapRole.broadcastProtocolIncludeSelf(syncRoleModelChange);
/*     */       
/*     */ 
/* 202 */       break;
/*     */     }
/*     */     
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_OnRoleChildShowModelChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */