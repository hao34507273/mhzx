/*     */ package mzm.gsp.map.main.scene;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.map.main.WorldInstance;
/*     */ import mzm.gsp.map.main.WorldManager;
/*     */ import mzm.gsp.map.main.message.MMH_PlayerTransferToScene;
/*     */ import mzm.gsp.map.main.message.MapProtocolSendQueue;
/*     */ import mzm.gsp.map.main.scene.object.MapRole;
/*     */ import mzm.gsp.map.main.scene.object.SceneObject;
/*     */ import mzm.gsp.map.main.scene.view.IView;
/*     */ import mzm.gsp.map.main.team.MapTeamData;
/*     */ import mzm.gsp.map.main.team.MapTeamManager;
/*     */ import xio.Protocol;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Grid
/*     */ {
/*  29 */   private List<Grid> surroundingGrids = new ArrayList();
/*     */   
/*     */   private Map<Integer, Set<MapRole>> channelMap;
/*     */   private Set<SceneObject> sceneObjectSet;
/*     */   private boolean active;
/*     */   
/*     */   public void addSurroundingGrid(Grid grid)
/*     */   {
/*  37 */     this.surroundingGrids.add(grid);
/*     */   }
/*     */   
/*     */   public Collection<Long> getAllRoleIds()
/*     */   {
/*  42 */     if (this.channelMap == null)
/*     */     {
/*  44 */       return null;
/*     */     }
/*     */     
/*  47 */     List<Long> roleids = new ArrayList();
/*  48 */     for (Set<MapRole> mapRoles : this.channelMap.values())
/*     */     {
/*  50 */       for (MapRole mapRole : mapRoles)
/*     */       {
/*  52 */         roleids.add(Long.valueOf(mapRole.getRoleId()));
/*     */       }
/*     */     }
/*  55 */     return roleids;
/*     */   }
/*     */   
/*     */   public Collection<Long> getRoleIds()
/*     */   {
/*  60 */     return getRoleIds(-1);
/*     */   }
/*     */   
/*     */   public Collection<Long> getRoleIds(int channelid)
/*     */   {
/*  65 */     if (this.channelMap == null)
/*     */     {
/*  67 */       return null;
/*     */     }
/*     */     
/*  70 */     if (channelid >= 0)
/*     */     {
/*  72 */       Set<MapRole> mapRoles = (Set)this.channelMap.get(Integer.valueOf(channelid));
/*  73 */       if ((mapRoles == null) || (mapRoles.isEmpty()))
/*     */       {
/*  75 */         return null;
/*     */       }
/*     */       
/*  78 */       List<Long> roleids = new ArrayList();
/*  79 */       for (MapRole mapRole : mapRoles)
/*     */       {
/*  81 */         roleids.add(Long.valueOf(mapRole.getRoleId()));
/*     */       }
/*  83 */       return roleids;
/*     */     }
/*     */     
/*     */ 
/*  87 */     List<Long> roleids = new ArrayList();
/*  88 */     for (Set<MapRole> mapRoles : this.channelMap.values())
/*     */     {
/*  90 */       for (MapRole mapRole : mapRoles)
/*     */       {
/*  92 */         roleids.add(Long.valueOf(mapRole.getRoleId()));
/*     */       }
/*     */     }
/*  95 */     return roleids;
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<MapRole> getRoles(int channelid)
/*     */   {
/* 101 */     if (this.channelMap == null)
/*     */     {
/* 103 */       return null;
/*     */     }
/*     */     
/* 106 */     return (Set)this.channelMap.get(Integer.valueOf(channelid));
/*     */   }
/*     */   
/*     */   public Set<SceneObject> getObjects()
/*     */   {
/* 111 */     return this.sceneObjectSet;
/*     */   }
/*     */   
/*     */   public List<Grid> getNeighbourGrids()
/*     */   {
/* 116 */     return this.surroundingGrids;
/*     */   }
/*     */   
/*     */   public boolean isActive()
/*     */   {
/* 121 */     return this.active;
/*     */   }
/*     */   
/*     */   public void addSceneObj(SceneObject obj)
/*     */   {
/* 126 */     if ((obj instanceof MapRole))
/*     */     {
/* 128 */       MapRole role = (MapRole)obj;
/* 129 */       int channelid = role.getChannelid();
/* 130 */       Set<MapRole> roleSet = getRoles(channelid);
/* 131 */       if (roleSet == null)
/*     */       {
/* 133 */         roleSet = new HashSet();
/* 134 */         if (this.channelMap == null)
/*     */         {
/* 136 */           this.channelMap = new HashMap();
/*     */         }
/* 138 */         this.channelMap.put(Integer.valueOf(channelid), roleSet);
/*     */       }
/* 140 */       roleSet.add(role);
/*     */       
/* 142 */       this.active = true;
/*     */       
/* 144 */       return;
/*     */     }
/*     */     
/* 147 */     if (this.sceneObjectSet == null)
/*     */     {
/* 149 */       this.sceneObjectSet = new HashSet();
/*     */     }
/* 151 */     this.sceneObjectSet.add(obj);
/* 152 */     if (obj.isActivity())
/*     */     {
/* 154 */       this.active = true;
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeSceneObj(SceneObject obj)
/*     */   {
/* 160 */     if ((obj instanceof MapRole))
/*     */     {
/* 162 */       MapRole role = (MapRole)obj;
/* 163 */       int channelid = role.getChannelid();
/* 164 */       Set<MapRole> roleSet = getRoles(channelid);
/* 165 */       if (roleSet != null)
/*     */       {
/* 167 */         roleSet.remove(role);
/* 168 */         if (roleSet.isEmpty())
/*     */         {
/* 170 */           this.channelMap.remove(Integer.valueOf(channelid));
/* 171 */           if (this.channelMap.isEmpty())
/*     */           {
/* 173 */             this.channelMap = null;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 178 */       return;
/*     */     }
/*     */     
/* 181 */     if ((this.sceneObjectSet != null) && (this.sceneObjectSet.remove(obj)) && (this.sceneObjectSet.isEmpty()))
/*     */     {
/* 183 */       this.sceneObjectSet = null;
/*     */     }
/*     */   }
/*     */   
/*     */   public void kickOutAllRole()
/*     */   {
/* 189 */     if (this.channelMap == null)
/*     */     {
/* 191 */       return;
/*     */     }
/*     */     
/* 194 */     Iterator<Map.Entry<Integer, Set<MapRole>>> iter = this.channelMap.entrySet().iterator();
/* 195 */     while (iter.hasNext())
/*     */     {
/* 197 */       Map.Entry<Integer, Set<MapRole>> entry = (Map.Entry)iter.next();
/* 198 */       Iterator<MapRole> mapRoleIter = ((Set)entry.getValue()).iterator();
/* 199 */       while (mapRoleIter.hasNext())
/*     */       {
/* 201 */         MapRole role = (MapRole)mapRoleIter.next();
/* 202 */         MapTeamData mapTeamData = MapTeamManager.getInstance().getTeamById(role.getTeamId());
/* 203 */         if ((mapTeamData == null) || (mapTeamData.isLeader(role.getRoleId())))
/*     */         {
/* 205 */           Position loc = WorldManager.getInstance().getRoleWorldInstanceFromStack(role.getRoleId()).getPosition(role.getRoleId());
/*     */           
/* 207 */           new MMH_PlayerTransferToScene(role.getRoleId(), loc.getSceneId(), loc.getX(), loc.getY(), TransferType.FORCE_TRANSFER).execute();
/*     */         }
/*     */         
/* 210 */         mapRoleIter.remove();
/*     */       }
/* 212 */       iter.remove();
/*     */     }
/*     */     
/* 215 */     this.channelMap = null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onMove(SceneObject obj)
/*     */   {
/* 225 */     if (!obj.updateView())
/*     */     {
/* 227 */       return;
/*     */     }
/*     */     
/* 230 */     List<Grid> neighbourGrids = getNeighbourGrids();
/* 231 */     for (Grid grid : neighbourGrids)
/*     */     {
/* 233 */       grid.testView(obj);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void testView(SceneObject obj)
/*     */   {
/* 244 */     if (!obj.isActivity())
/*     */     {
/* 246 */       return;
/*     */     }
/*     */     
/* 249 */     Collection<Set<MapRole>> channels = null;
/* 250 */     if (((obj instanceof MapRole)) && (!((MapRole)obj).isServerDominateGroup()))
/*     */     {
/* 252 */       Set<MapRole> roleSet = getRoles(((MapRole)obj).getChannelid());
/* 253 */       if (roleSet != null)
/*     */       {
/* 255 */         channels = new LinkedList();
/* 256 */         channels.add(roleSet);
/*     */       }
/*     */       
/*     */ 
/*     */     }
/* 261 */     else if (this.channelMap != null)
/*     */     {
/* 263 */       channels = this.channelMap.values();
/*     */     }
/*     */     
/* 266 */     if (channels != null)
/*     */     {
/* 268 */       List<Long> enterIntoObjs = new LinkedList();
/* 269 */       List<Long> leaveFromObjs = new LinkedList();
/* 270 */       List<Long> moveInObjs = new LinkedList();
/* 271 */       for (Set<MapRole> roleSet : channels)
/*     */       {
/* 273 */         for (MapRole role : roleSet)
/*     */         {
/* 275 */           if ((!role.getView().isBeDelegated()) && 
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 280 */             (obj != role))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 285 */             int result = obj.getView().test(role);
/* 286 */             if (SceneViewBitMask.isEnterIntoOthersView(result))
/*     */             {
/* 288 */               enterIntoObjs.add(Long.valueOf(role.getRoleId()));
/*     */             }
/* 290 */             if (SceneViewBitMask.isLeaveFromOthersView(result))
/*     */             {
/* 292 */               leaveFromObjs.add(Long.valueOf(role.getRoleId()));
/*     */             }
/* 294 */             if (SceneViewBitMask.isMoveInOthersView(result))
/*     */             {
/* 296 */               moveInObjs.add(Long.valueOf(role.getRoleId())); }
/*     */           }
/*     */         }
/*     */       }
/* 300 */       if (enterIntoObjs.size() > 0)
/*     */       {
/* 302 */         Protocol core = obj.createEnterView();
/* 303 */         if (core != null)
/*     */         {
/* 305 */           MapProtocolSendQueue.getInstance().sendMulti(enterIntoObjs, core);
/*     */         }
/*     */       }
/* 308 */       if (leaveFromObjs.size() > 0)
/*     */       {
/* 310 */         Protocol core = obj.createLeaveView();
/* 311 */         if (core != null)
/*     */         {
/* 313 */           MapProtocolSendQueue.getInstance().sendMulti(leaveFromObjs, core);
/*     */         }
/*     */       }
/* 316 */       if (moveInObjs.size() > 0)
/*     */       {
/* 318 */         Protocol core = obj.createMoveProtocol();
/* 319 */         if (core != null)
/*     */         {
/* 321 */           MapProtocolSendQueue.getInstance().sendMulti(moveInObjs, core);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 326 */     if (this.sceneObjectSet != null)
/*     */     {
/* 328 */       for (SceneObject mapObj : this.sceneObjectSet)
/*     */       {
/* 330 */         if (obj != mapObj)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 335 */           obj.getView().test(mapObj);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void release() {
/* 342 */     this.surroundingGrids.clear();
/* 343 */     this.surroundingGrids = null;
/*     */     
/* 345 */     if (this.channelMap != null)
/*     */     {
/* 347 */       Iterator<Map.Entry<Integer, Set<MapRole>>> iter = this.channelMap.entrySet().iterator();
/* 348 */       while (iter.hasNext())
/*     */       {
/* 350 */         ((Set)((Map.Entry)iter.next()).getValue()).clear();
/* 351 */         iter.remove();
/*     */       }
/*     */       
/* 354 */       this.channelMap = null;
/*     */     }
/*     */     
/* 357 */     if (this.sceneObjectSet != null)
/*     */     {
/* 359 */       this.sceneObjectSet.clear();
/* 360 */       this.sceneObjectSet = null;
/*     */     }
/*     */     
/* 363 */     this.active = false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\Grid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */