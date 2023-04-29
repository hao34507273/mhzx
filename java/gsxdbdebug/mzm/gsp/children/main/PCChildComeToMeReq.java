/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SChildNormalFail;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.map.Location;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChildInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCChildComeToMeReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long childId;
/*     */   private final List<Location> locations;
/*     */   
/*     */   public PCChildComeToMeReq(long roleId, long childId, List<Location> locations)
/*     */   {
/*  27 */     this.roleId = roleId;
/*  28 */     this.childId = childId;
/*  29 */     this.locations = locations;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     if (this.locations.isEmpty())
/*     */     {
/*  37 */       return false;
/*     */     }
/*     */     
/*  40 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleId))
/*     */     {
/*  42 */       onChildComeToMeFail(21);
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     if (!ChildrenManager.isFunOpen(this.roleId))
/*     */     {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     if (!ChildrenManager.canDoAction(this.roleId, 836))
/*     */     {
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  57 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  59 */     lock(Lockeys.get(xtable.Role2properties.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*  61 */     ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(this.childId));
/*  62 */     if (xChildInfo == null)
/*     */     {
/*  64 */       onChildComeToMeFail(2);
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     if ((xChildInfo.getOwn_role_id() != this.roleId) && (xChildInfo.getAnother_parent_role_id() != this.roleId))
/*     */     {
/*  70 */       onChildComeToMeFail(1);
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     if (xChildInfo.getHome_state() == 0)
/*     */     {
/*  76 */       onChildComeToMeFail(3);
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     if (!ChildrenManager.checkChildrenDiscardOnOperate(this.roleId, xChildInfo))
/*     */     {
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     int mapCfgId = MapInterface.getRoleMapId(this.roleId);
/*     */     
/*  87 */     if (xChildInfo.getHome_state() == 1)
/*     */     {
/*  89 */       if (!HomelandInterface.isRoomMap(mapCfgId))
/*     */       {
/*  91 */         Map<String, Object> extraMap = new HashMap();
/*  92 */         extraMap.put("home_state", Integer.valueOf(xChildInfo.getHome_state()));
/*  93 */         extraMap.put("map_cfg_id", Integer.valueOf(mapCfgId));
/*  94 */         onChildComeToMeFail(9, extraMap);
/*     */         
/*  96 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 100 */     if (xChildInfo.getHome_state() == 2)
/*     */     {
/* 102 */       if (!HomelandInterface.isYardMap(mapCfgId))
/*     */       {
/* 104 */         Map<String, Object> extraMap = new HashMap();
/* 105 */         extraMap.put("home_state", Integer.valueOf(xChildInfo.getHome_state()));
/* 106 */         extraMap.put("map_cfg_id", Integer.valueOf(mapCfgId));
/* 107 */         onChildComeToMeFail(9, extraMap);
/*     */         
/* 109 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 113 */     int size = this.locations.size();
/* 114 */     Location lastLocation = (Location)this.locations.get(size - 1);
/* 115 */     if (MapInterface.isReachable(mapCfgId, lastLocation.x, lastLocation.y))
/*     */     {
/* 117 */       xChildInfo.setPosition_x(lastLocation.x);
/* 118 */       xChildInfo.setPosition_y(lastLocation.y);
/*     */     }
/*     */     else
/*     */     {
/* 122 */       GameServer.logger().error(String.format("[children]PCChildComeToMeReq.processImp@location can not arrive|role_id=%d|child_id=%d|last_location_x=%d|last_location_y=%d|home_state=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.childId), Integer.valueOf(lastLocation.x), Integer.valueOf(lastLocation.y), Integer.valueOf(xChildInfo.getHome_state()) }));
/*     */       
/*     */ 
/*     */ 
/* 126 */       return false;
/*     */     }
/*     */     
/* 129 */     MapInterface.mapEntityMove(MapEntityType.MET_CHILDREN, this.childId, this.locations);
/*     */     
/* 131 */     GameServer.logger().info(String.format("[children]PCChildComeToMeReq.processImp@handle call child req success|role_id=%d|child_id=%d|last_location_x=%d|last_location_y=%d|home_state=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.childId), Integer.valueOf(lastLocation.x), Integer.valueOf(lastLocation.y), Integer.valueOf(xChildInfo.getHome_state()) }));
/*     */     
/*     */ 
/*     */ 
/* 135 */     return true;
/*     */   }
/*     */   
/*     */   private void onChildComeToMeFail(int ret)
/*     */   {
/* 140 */     onChildComeToMeFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onChildComeToMeFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 145 */     SChildNormalFail sChildNormalFail = new SChildNormalFail();
/* 146 */     sChildNormalFail.result = ret;
/* 147 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sChildNormalFail);
/*     */     
/* 149 */     StringBuilder sbLog = new StringBuilder();
/* 150 */     sbLog.append("[children]PCChildComeToMeReq.processImp@failed");
/* 151 */     sbLog.append("|ret=").append(ret);
/* 152 */     sbLog.append("|role_id=").append(this.roleId);
/* 153 */     sbLog.append("|child_id=").append(this.childId);
/*     */     
/* 155 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 157 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 159 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 162 */     GameServer.logger().error(sbLog.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCChildComeToMeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */