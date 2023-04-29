/*     */ package mzm.gsp.map.main.scene.view;
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
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import mzm.gsp.map.main.MapManager;
/*     */ import mzm.gsp.map.main.message.MapProtocolSendQueue;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.map.main.scene.SceneViewBitMask;
/*     */ import mzm.gsp.map.main.scene.object.MapRole;
/*     */ import mzm.gsp.map.main.scene.object.SceneObject;
/*     */ import mzm.gsp.map.main.scene.object.SceneObjectId;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CircleView
/*     */   implements IView
/*     */ {
/*     */   protected final SceneObject owner;
/*     */   protected final int radiusSquare;
/*     */   protected final int radius;
/*  52 */   protected final Map<SceneObjectId, SceneObject> mapObjMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  57 */   protected final Set<SceneObject> delegateSet = new HashSet();
/*     */   
/*     */ 
/*     */   protected IView delegate;
/*     */   
/*     */ 
/*     */ 
/*     */   public CircleView(SceneObject owner, int radius)
/*     */   {
/*  66 */     this.owner = owner;
/*  67 */     this.radius = radius;
/*  68 */     this.radiusSquare = (radius * radius);
/*     */   }
/*     */   
/*     */ 
/*     */   public SceneObject getOwner()
/*     */   {
/*  74 */     return this.owner;
/*     */   }
/*     */   
/*     */   protected int getDistanceSquare(SceneObject obj)
/*     */   {
/*  79 */     Position ownerPt = this.owner.getPositionForInner();
/*  80 */     Position targetPt = obj.getPositionForInner();
/*  81 */     return MapManager.getDistanceSquare(ownerPt.getX(), ownerPt.getY(), targetPt.getX(), targetPt.getY());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean validateView()
/*     */   {
/*  88 */     if (this.delegate != null)
/*     */     {
/*  90 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  94 */     List<Long> leaveFromObjs = new LinkedList();
/*  95 */     Iterator<Map.Entry<SceneObjectId, SceneObject>> itr = this.mapObjMap.entrySet().iterator();
/*  96 */     while (itr.hasNext())
/*     */     {
/*  98 */       Map.Entry<SceneObjectId, SceneObject> entry = (Map.Entry)itr.next();
/*  99 */       SceneObject obj = (SceneObject)entry.getValue();
/* 100 */       if (!obj.getView().isBeDelegated())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 105 */         if (obj == this.owner)
/*     */         {
/* 107 */           itr.remove();
/*     */ 
/*     */ 
/*     */         }
/* 111 */         else if (removeTest(obj))
/*     */         {
/* 113 */           itr.remove();
/*     */           
/*     */ 
/* 116 */           if (SceneViewBitMask.isLeaveFromOthersView(onLeave(obj, true)))
/*     */           {
/* 118 */             if ((obj instanceof MapRole))
/*     */             {
/* 120 */               leaveFromObjs.add(Long.valueOf(((MapRole)obj).getRoleId()));
/*     */             }
/*     */           }
/*     */           
/*     */ 
/* 125 */           obj.getView().inActiveLeave(this.owner, this.owner.isTeleporting());
/*     */         } }
/*     */     }
/* 128 */     if (leaveFromObjs.size() > 0)
/*     */     {
/* 130 */       MapProtocolSendQueue.getInstance().sendMulti(leaveFromObjs, this.owner.createLeaveView());
/*     */     }
/*     */     
/* 133 */     return true;
/*     */   }
/*     */   
/*     */   private boolean removeTest(SceneObject obj)
/*     */   {
/* 138 */     if ((obj.isAlive()) && (this.owner.getSceneId() == obj.getSceneId()))
/*     */     {
/* 140 */       int dist = getDistanceSquare(obj);
/* 141 */       if (dist < this.radiusSquare)
/*     */       {
/* 143 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 147 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setDelegate(IView view)
/*     */   {
/* 153 */     this.delegate = view;
/* 154 */     view.addDelgateObject(this.owner);
/* 155 */     this.mapObjMap.clear();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void deleteDelegate(boolean isCopyView)
/*     */   {
/* 162 */     if (this.delegate == null)
/*     */     {
/* 164 */       return;
/*     */     }
/*     */     
/* 167 */     if (isCopyView)
/*     */     {
/* 169 */       Collection<SceneObject> objs = this.delegate.getSceneObjects();
/* 170 */       for (SceneObject obj : objs)
/*     */       {
/* 172 */         if (obj != this.owner)
/*     */         {
/*     */ 
/*     */ 
/* 176 */           this.mapObjMap.put(obj.getObjectId(), obj);
/*     */         }
/*     */       }
/* 179 */       SceneObject leader = this.delegate.getOwner();
/* 180 */       this.mapObjMap.put(leader.getObjectId(), leader);
/*     */       
/* 182 */       Set<SceneObject> dels = this.delegate.getDelegateObjects();
/* 183 */       for (SceneObject del : dels)
/*     */       {
/* 185 */         this.mapObjMap.put(del.getObjectId(), del);
/*     */       }
/* 187 */       this.delegate.removeDelegateObject(this.owner);
/*     */     }
/* 189 */     this.delegate = null;
/*     */   }
/*     */   
/*     */ 
/*     */   public int test(SceneObject obj)
/*     */   {
/* 195 */     if ((obj.isAlive()) && (this.owner.getSceneId() == obj.getSceneId()))
/*     */     {
/* 197 */       int dist = getDistanceSquare(obj);
/* 198 */       if (dist < this.radiusSquare)
/*     */       {
/* 200 */         int result = 1;
/* 201 */         if (this.mapObjMap.put(obj.getObjectId(), obj) == null)
/*     */         {
/*     */ 
/* 204 */           if (SceneViewBitMask.isEnterIntoOthersView(onEnter(obj, true)))
/*     */           {
/* 206 */             result |= 0x2;
/*     */           }
/*     */           
/*     */ 
/* 210 */           obj.getView().inActiveEnter(this.owner, false);
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/* 215 */         else if (SceneViewBitMask.isMoveInOthersView(onMove(obj, true)))
/*     */         {
/* 217 */           result |= 0x20;
/*     */         }
/*     */         
/*     */ 
/* 221 */         return result;
/*     */       }
/*     */     }
/*     */     
/* 225 */     if (this.mapObjMap.remove(obj.getObjectId()) != null)
/*     */     {
/* 227 */       int result = 0;
/*     */       
/* 229 */       if (SceneViewBitMask.isLeaveFromOthersView(onLeave(obj, true)))
/*     */       {
/* 231 */         result |= 0x8;
/*     */       }
/*     */       
/*     */ 
/* 235 */       obj.getView().inActiveLeave(this.owner, this.owner.isTeleporting());
/* 236 */       return result;
/*     */     }
/*     */     
/* 239 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public Collection<MapRole> getPlayers()
/*     */   {
/* 245 */     if (this.delegate != null)
/*     */     {
/* 247 */       Collection<MapRole> roleList = this.delegate.getPlayers();
/* 248 */       if ((this.delegate.getOwner() instanceof MapRole))
/*     */       {
/* 250 */         roleList.add((MapRole)this.delegate.getOwner());
/*     */       }
/* 252 */       return roleList;
/*     */     }
/*     */     
/* 255 */     Collection<MapRole> roleList = new ArrayList();
/* 256 */     for (SceneObject object : this.mapObjMap.values())
/*     */     {
/* 258 */       if ((object instanceof MapRole))
/*     */       {
/* 260 */         roleList.add((MapRole)object);
/*     */       }
/*     */     }
/*     */     
/* 264 */     for (SceneObject del : this.delegateSet)
/*     */     {
/* 266 */       if ((del instanceof MapRole))
/*     */       {
/* 268 */         roleList.add((MapRole)del);
/*     */       }
/*     */     }
/* 271 */     return roleList;
/*     */   }
/*     */   
/*     */ 
/*     */   public Collection<SceneObject> getSceneObjects()
/*     */   {
/* 277 */     if (this.delegate != null)
/*     */     {
/* 279 */       return this.delegate.getSceneObjects();
/*     */     }
/*     */     
/*     */ 
/* 283 */     CopyOnWriteArrayList<SceneObject> objects = new CopyOnWriteArrayList(this.mapObjMap.values());
/* 284 */     for (SceneObject del : this.delegateSet)
/*     */     {
/* 286 */       objects.add(del);
/*     */     }
/* 288 */     return objects;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getRadius()
/*     */   {
/* 294 */     return this.radius;
/*     */   }
/*     */   
/*     */ 
/*     */   public int onEnter(SceneObject enterObj, boolean delaySync)
/*     */   {
/* 300 */     return enterObj.acceptEnterView(this.owner, delaySync);
/*     */   }
/*     */   
/*     */ 
/*     */   public int onMove(SceneObject moveObj, boolean delaySync)
/*     */   {
/* 306 */     return moveObj.acceptMoveView(this.owner, delaySync);
/*     */   }
/*     */   
/*     */ 
/*     */   public int onLeave(SceneObject leaveObj, boolean delaySync)
/*     */   {
/* 312 */     return leaveObj.acceptLeaveView(this.owner, delaySync);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isBeDelegated()
/*     */   {
/* 318 */     return this.delegate != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void clearView()
/*     */   {
/* 325 */     List<Long> leaveFromObjs = new LinkedList();
/*     */     
/* 327 */     for (SceneObject obj : this.mapObjMap.values())
/*     */     {
/* 329 */       if ((!obj.getView().isBeDelegated()) && 
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 334 */         (obj != this.owner))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 339 */         IView objView = obj.getView();
/* 340 */         if (objView != null)
/*     */         {
/*     */ 
/* 343 */           objView.inActiveLeave(this.owner, this.owner.isTeleporting());
/*     */         }
/*     */         
/*     */ 
/* 347 */         if (SceneViewBitMask.isLeaveFromOthersView(onLeave(obj, true)))
/*     */         {
/* 349 */           if ((obj instanceof MapRole))
/*     */           {
/* 351 */             leaveFromObjs.add(Long.valueOf(((MapRole)obj).getRoleId())); }
/*     */         }
/*     */       }
/*     */     }
/* 355 */     if (leaveFromObjs.size() > 0)
/*     */     {
/* 357 */       MapProtocolSendQueue.getInstance().sendMulti(leaveFromObjs, this.owner.createLeaveView());
/*     */     }
/*     */     
/* 360 */     this.mapObjMap.clear();
/*     */   }
/*     */   
/*     */ 
/*     */   public int inActiveEnter(SceneObject object, boolean delaySync)
/*     */   {
/* 366 */     this.mapObjMap.put(object.getObjectId(), object);
/* 367 */     return onEnter(object, delaySync);
/*     */   }
/*     */   
/*     */ 
/*     */   public int inActiveLeave(SceneObject object, boolean delaySync)
/*     */   {
/* 373 */     this.mapObjMap.remove(object.getObjectId());
/* 374 */     return onLeave(object, delaySync);
/*     */   }
/*     */   
/*     */ 
/*     */   public void addDelgateObject(SceneObject object)
/*     */   {
/* 380 */     this.delegateSet.add(object);
/* 381 */     this.mapObjMap.remove(object.getObjectId());
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<SceneObject> getDelegateObjects()
/*     */   {
/* 387 */     return this.delegateSet;
/*     */   }
/*     */   
/*     */ 
/*     */   public void removeDelegateObject(SceneObject object)
/*     */   {
/* 393 */     this.mapObjMap.put(object.getObjectId(), object);
/* 394 */     this.delegateSet.remove(object);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isBeDelegated(IView view)
/*     */   {
/* 400 */     return view == this.delegate;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\view\CircleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */