/*      */ package mzm.gsp.children.main;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.children.SAddChild;
/*      */ import mzm.gsp.children.SCancelChildShowSuccess;
/*      */ import mzm.gsp.children.SChildNormalFail;
/*      */ import mzm.gsp.children.SSyncBreedInfo;
/*      */ import mzm.gsp.children.SSyncChildrenInfo;
/*      */ import mzm.gsp.children.childhood.ChildhoodManager;
/*      */ import mzm.gsp.children.confbean.SChildrenConsts;
/*      */ import mzm.gsp.children.confbean.SFashionCfg;
/*      */ import mzm.gsp.children.event.AddChildIntoHome;
/*      */ import mzm.gsp.children.event.AddChildIntoHomeArg;
/*      */ import mzm.gsp.children.event.ChildAddHomeReason;
/*      */ import mzm.gsp.children.event.ChildShowModelChange;
/*      */ import mzm.gsp.children.event.ChildShowModelChangeArg;
/*      */ import mzm.gsp.children.event.ChildShowModelChangeReason;
/*      */ import mzm.gsp.children.event.GiveBirthTimerEvent;
/*      */ import mzm.gsp.children.event.GiveBirthTimerEventArg;
/*      */ import mzm.gsp.children.fashion.FashionManager;
/*      */ import mzm.gsp.children.fashion.ShowChildFashionObj;
/*      */ import mzm.gsp.friend.main.FriendInterface;
/*      */ import mzm.gsp.gift.main.InvitationInterface;
/*      */ import mzm.gsp.homeland.confbean.ChildPos;
/*      */ import mzm.gsp.homeland.main.HomelandInterface;
/*      */ import mzm.gsp.map.main.MapInterface;
/*      */ import mzm.gsp.map.main.scene.Position;
/*      */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*      */ import mzm.gsp.marriage.main.MarriageInterface;
/*      */ import mzm.gsp.marriage.main.MarriageInterface.PregnantState;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.pubdata.ModelInfo;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.status.main.RoleStatusInterface;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.AdulthoodInfo;
/*      */ import xbean.BabyPeriodInfo;
/*      */ import xbean.ChildGrowthDiaryInfo;
/*      */ import xbean.ChildGrowthInfo;
/*      */ import xbean.ChildInfo;
/*      */ import xbean.ChildhoodInfo;
/*      */ import xbean.DressedInfo;
/*      */ import xbean.Pod;
/*      */ import xbean.Role2ChildrenInfo;
/*      */ import xdb.Lockeys;
/*      */ import xdb.Xdb;
/*      */ import xtable.Childrengrowthdiary;
/*      */ import xtable.Role2childoutfightbean;
/*      */ import xtable.Role2children;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ChildrenInterface
/*      */ {
/*      */   public static void addChildrenWhenCreateScene(long roleId, long partnerRoleId, long worldInstanceId, int yardMapCfgId, int roomMapCfgId, int createMapCfgId)
/*      */   {
/*   74 */     if (!ChildrenManager.isFunOpen(roleId))
/*      */     {
/*   76 */       return;
/*      */     }
/*      */     
/*   79 */     List<Long> childIdList = ChildrenManager.getChildIdList(roleId, partnerRoleId, true);
/*      */     
/*   81 */     if ((childIdList == null) || (childIdList.isEmpty()))
/*      */     {
/*   83 */       return;
/*      */     }
/*      */     
/*      */ 
/*   87 */     Lockeys.lock(xtable.Children.getTable(), childIdList);
/*   88 */     List<ChildPos> aleardyUseChildPosList = new ArrayList();
/*   89 */     for (Iterator i$ = childIdList.iterator(); i$.hasNext();) { long xChildId = ((Long)i$.next()).longValue();
/*      */       
/*   91 */       ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(xChildId));
/*   92 */       if (xChildInfo == null)
/*      */       {
/*   94 */         GameServer.logger().error(String.format("[children]ChildrenInterface.addChildrenIntoWorldWhenCreateWorld@child not found|role_id=%d|partner_role_id=%d|child_id=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(partnerRoleId), Long.valueOf(xChildId) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       }
/*  101 */       else if ((!xChildInfo.getIs_discard()) && 
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*  106 */         (xChildInfo.getHome_state() != 0))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  111 */         int realMapCfgId = xChildInfo.getHome_state() == 1 ? roomMapCfgId : yardMapCfgId;
/*  112 */         if (createMapCfgId == realMapCfgId)
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*  117 */           Map<Integer, String> stringExtraInfoEntries = new HashMap();
/*  118 */           stringExtraInfoEntries.put(Integer.valueOf(702), xChildInfo.getChild_name());
/*      */           
/*  120 */           Map<Integer, Long> longExtraInfoEntries = new HashMap();
/*  121 */           longExtraInfoEntries.put(Integer.valueOf(701), Long.valueOf(xChildId));
/*      */           
/*  123 */           Map<Integer, Integer> intExtraInfoEntries = new HashMap();
/*  124 */           fillIntExtraInfoEntries(xChildId, intExtraInfoEntries, xChildInfo);
/*      */           
/*  126 */           if ((xChildInfo.getPosition_x() > 0) && (xChildInfo.getPosition_y() > 0))
/*      */           {
/*  128 */             if (MapInterface.isReachable(realMapCfgId, xChildInfo.getPosition_x(), xChildInfo.getPosition_y()))
/*      */             {
/*  130 */               MapInterface.addMapEntity(MapEntityType.MET_CHILDREN, xChildId, worldInstanceId, realMapCfgId, xChildInfo.getPosition_x(), xChildInfo.getPosition_y(), -1, intExtraInfoEntries, longExtraInfoEntries, stringExtraInfoEntries, null);
/*      */               
/*      */ 
/*      */ 
/*  134 */               GameServer.logger().info(String.format("[children]ChildrenInterface.addChildrenWhenCreateWorld@add child success,aleardy has position|role_id=%d|partner_role_id=%d|child_id=%d|position_x=%d|position_y=%d|home_state=%d|world_instance_id=%d|yard_map_cfg_id=%d|room_map_cfg_id=%d|create_map_cfg_id=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(partnerRoleId), Long.valueOf(xChildId), Integer.valueOf(xChildInfo.getPosition_x()), Integer.valueOf(xChildInfo.getPosition_y()), Integer.valueOf(xChildInfo.getHome_state()), Long.valueOf(worldInstanceId), Integer.valueOf(yardMapCfgId), Integer.valueOf(roomMapCfgId), Integer.valueOf(createMapCfgId) }));
/*      */ 
/*      */ 
/*      */ 
/*      */             }
/*      */             else
/*      */             {
/*      */ 
/*      */ 
/*  143 */               tlogRepairPositionPostion(roleId, partnerRoleId, xChildId, realMapCfgId, xChildInfo.getPosition_x(), xChildInfo.getPosition_y());
/*      */             }
/*      */           }
/*      */           else
/*      */           {
/*  148 */             List<ChildPos> childPosList = HomelandInterface.getChildPositions(createMapCfgId);
/*  149 */             ChildPos giveBirthPosition = getRandomChildPos(childPosList, aleardyUseChildPosList);
/*  150 */             int giveBirthX = 0;
/*  151 */             int giveBirthY = 0;
/*  152 */             if (giveBirthPosition != null)
/*      */             {
/*  154 */               giveBirthX = giveBirthPosition.childX;
/*  155 */               giveBirthY = giveBirthPosition.childY;
/*      */             }
/*      */             else
/*      */             {
/*  159 */               Position position = MapInterface.randomWalkablePos(realMapCfgId);
/*  160 */               if (position == null)
/*      */               {
/*  162 */                 GameServer.logger().error(String.format("[children]ChildrenInterface.addChildrenWhenCreateWorld@no can walk position|map_cfg_id=%d", new Object[] { Integer.valueOf(realMapCfgId) }));
/*      */                 
/*      */ 
/*      */ 
/*  166 */                 return;
/*      */               }
/*  168 */               giveBirthX = position.getX();
/*  169 */               giveBirthY = position.getY();
/*      */             }
/*      */             
/*  172 */             xChildInfo.setPosition_x(giveBirthX);
/*  173 */             xChildInfo.setPosition_y(giveBirthY);
/*      */             
/*  175 */             MapInterface.addMapEntity(MapEntityType.MET_CHILDREN, xChildId, worldInstanceId, realMapCfgId, giveBirthX, giveBirthY, -1, intExtraInfoEntries, longExtraInfoEntries, stringExtraInfoEntries, null);
/*      */             
/*      */ 
/*  178 */             GameServer.logger().info(String.format("[children]ChildrenInterface.addChildrenWhenCreateWorld@add child success,random position|role_id=%d|partner_role_id=%d|child_id=%d|position_x=%d|position_y=%d|home_state=%d|world_instance_id=%d|yard_map_cfg_id=%d|room_map_cfg_id=%d|create_map_cfg_id=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(partnerRoleId), Long.valueOf(xChildId), Integer.valueOf(xChildInfo.getPosition_x()), Integer.valueOf(xChildInfo.getPosition_y()), Integer.valueOf(xChildInfo.getHome_state()), Long.valueOf(worldInstanceId), Integer.valueOf(yardMapCfgId), Integer.valueOf(roomMapCfgId), Integer.valueOf(createMapCfgId) }));
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  185 */     FashionManager.onCreateHomeWorld(roleId, partnerRoleId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void tlogRepairPositionPostion(long roleId, long anotherParentRoleId, long childId, int mapCfgId, int positionX, int positionY)
/*      */   {
/*  193 */     StringBuilder sbLog = new StringBuilder();
/*  194 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  195 */     sbLog.append(roleId).append('|');
/*  196 */     sbLog.append(anotherParentRoleId).append('|');
/*  197 */     sbLog.append(mapCfgId).append('|');
/*  198 */     sbLog.append(positionX).append('|');
/*  199 */     sbLog.append(positionY).append('|');
/*  200 */     sbLog.append(childId);
/*      */     
/*  202 */     TLogManager.getInstance().addLog(roleId, "ChildPositionRepairStatis", sbLog.toString());
/*      */   }
/*      */   
/*      */   private static ChildPos getRandomChildPos(List<ChildPos> childPosList, List<ChildPos> aleardyUseYardChildPosList)
/*      */   {
/*  207 */     if (childPosList == null)
/*      */     {
/*  209 */       return null;
/*      */     }
/*  211 */     for (ChildPos childPos : aleardyUseYardChildPosList)
/*      */     {
/*  213 */       Iterator<ChildPos> iterator = childPosList.iterator();
/*  214 */       while (iterator.hasNext())
/*      */       {
/*  216 */         ChildPos randomChildPos = (ChildPos)iterator.next();
/*  217 */         if ((randomChildPos.childX == childPos.childX) && (randomChildPos.childY == childPos.childY))
/*      */         {
/*  219 */           iterator.remove();
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  224 */     if (childPosList.isEmpty())
/*      */     {
/*  226 */       return null;
/*      */     }
/*      */     
/*  229 */     int randomSize = childPosList.size();
/*  230 */     int randomResult = Xdb.random().nextInt(randomSize);
/*      */     
/*  232 */     ChildPos childPos = (ChildPos)childPosList.get(randomResult);
/*  233 */     aleardyUseYardChildPosList.add(childPos);
/*  234 */     return childPos;
/*      */   }
/*      */   
/*      */ 
/*      */   private static void fillIntExtraInfoEntries(long childId, Map<Integer, Integer> intExtraInfoEntries, ChildInfo xChildInfo)
/*      */   {
/*  240 */     if (intExtraInfoEntries == null)
/*      */     {
/*  242 */       return;
/*      */     }
/*      */     
/*  245 */     intExtraInfoEntries.put(Integer.valueOf(706), Integer.valueOf(getChildModelCfgId(childId, xChildInfo)));
/*      */     
/*  247 */     intExtraInfoEntries.put(Integer.valueOf(703), Integer.valueOf(xChildInfo.getChild_gender()));
/*      */     
/*      */ 
/*  250 */     int childrenWeaponCfgid = ChildrenManager.getChildrenWeaponCfgid(xChildInfo);
/*  251 */     intExtraInfoEntries.put(Integer.valueOf(707), Integer.valueOf(childrenWeaponCfgid));
/*      */     
/*  253 */     int phase = xChildInfo.getChild_period();
/*  254 */     intExtraInfoEntries.put(Integer.valueOf(704), Integer.valueOf(phase));
/*  255 */     DressedInfo xDressedInfo = (DressedInfo)xChildInfo.getDressed().get(Integer.valueOf(phase));
/*  256 */     if (xDressedInfo != null)
/*      */     {
/*  258 */       int fashionCfgid = xDressedInfo.getFashion_cfgid();
/*  259 */       SFashionCfg fashionCfg = SFashionCfg.get(fashionCfgid);
/*  260 */       if (fashionCfg == null)
/*      */       {
/*  262 */         GameServer.logger().error(String.format("[Children]ChildrenInterface.fillIntExtraInfoEntries@fashion cfg is null|fashion_cfgid=%d", new Object[] { Integer.valueOf(fashionCfgid) }));
/*      */         
/*      */ 
/*      */ 
/*  266 */         return;
/*      */       }
/*  268 */       intExtraInfoEntries.put(Integer.valueOf(705), Integer.valueOf(fashionCfg.changeFashionCfgid));
/*      */     }
/*      */     else
/*      */     {
/*  272 */       intExtraInfoEntries.put(Integer.valueOf(705), Integer.valueOf(0));
/*      */     }
/*      */   }
/*      */   
/*      */   private static int getChildModelCfgId(long childId, ChildInfo xChildInfo)
/*      */   {
/*  278 */     int childPeriod = xChildInfo.getChild_period();
/*  279 */     if (childPeriod == 0)
/*      */     {
/*  281 */       ChildrenManager.checkBabyModelCfgId(xChildInfo);
/*  282 */       return xChildInfo.getBaby_period_info().getBaby_model_cfg_id();
/*      */     }
/*  284 */     if (childPeriod == 1)
/*      */     {
/*  286 */       ChildhoodManager.checkModelCfgid(childId, xChildInfo);
/*  287 */       return xChildInfo.getChildhood_info().getChild_hood_model_cfg_id();
/*      */     }
/*  289 */     if (childPeriod == 2)
/*      */     {
/*  291 */       AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(xChildInfo);
/*  292 */       if (xAdulthoodInfo != null)
/*      */       {
/*  294 */         return xAdulthoodInfo.getModelcfgid();
/*      */       }
/*  296 */       return -1;
/*      */     }
/*      */     
/*      */ 
/*  300 */     return -1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void addChildrenAfterCreateWorld(long roleId, long childId, long worldInstanceId, int mapCfgid, int positionX, int positionY, ChildAddHomeReason childAddHomeReason)
/*      */   {
/*  319 */     ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(childId));
/*  320 */     if (xChildInfo == null)
/*      */     {
/*  322 */       return;
/*      */     }
/*      */     
/*  325 */     if (xChildInfo.getHome_state() == 0)
/*      */     {
/*  327 */       return;
/*      */     }
/*      */     
/*  330 */     if (xChildInfo.getIs_discard())
/*      */     {
/*  332 */       return;
/*      */     }
/*      */     
/*  335 */     Map<Integer, String> stringExtraInfoEntries = new HashMap();
/*  336 */     stringExtraInfoEntries.put(Integer.valueOf(702), xChildInfo.getChild_name());
/*      */     
/*  338 */     Map<Integer, Long> longExtraInfoEntries = new HashMap();
/*  339 */     longExtraInfoEntries.put(Integer.valueOf(701), Long.valueOf(childId));
/*      */     
/*  341 */     Map<Integer, Integer> intExtraInfoEntries = new HashMap();
/*  342 */     fillIntExtraInfoEntries(childId, intExtraInfoEntries, xChildInfo);
/*      */     
/*  344 */     if (childAddHomeReason == ChildAddHomeReason.BAG_TO_HOME)
/*      */     {
/*  346 */       MapInterface.addMapEntity(MapEntityType.MET_CHILDREN, childId, worldInstanceId, mapCfgid, xChildInfo.getPosition_x(), xChildInfo.getPosition_y(), -1, intExtraInfoEntries, longExtraInfoEntries, stringExtraInfoEntries, null);
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/*      */ 
/*  352 */       List<ChildPos> childPosList = HomelandInterface.getChildPositions(mapCfgid);
/*  353 */       ChildPos giveBirthPosition = getRandomChildPos(childPosList, new ArrayList());
/*  354 */       int giveBirthX = 0;
/*  355 */       int giveBirthY = 0;
/*  356 */       if (giveBirthPosition != null)
/*      */       {
/*  358 */         giveBirthX = giveBirthPosition.childX;
/*  359 */         giveBirthY = giveBirthPosition.childY;
/*      */       }
/*      */       else
/*      */       {
/*  363 */         Position position = MapInterface.randomWalkablePos(mapCfgid);
/*  364 */         if (position == null)
/*      */         {
/*  366 */           GameServer.logger().error(String.format("[children]ChildrenInterface.addChildrenWhenCreateWorld@no can walk position|map_cfg_id=%d", new Object[] { Integer.valueOf(mapCfgid) }));
/*      */           
/*      */ 
/*      */ 
/*  370 */           return;
/*      */         }
/*  372 */         giveBirthX = position.getX();
/*  373 */         giveBirthY = position.getY();
/*      */       }
/*      */       
/*  376 */       xChildInfo.setPosition_x(giveBirthX);
/*  377 */       xChildInfo.setPosition_y(giveBirthY);
/*      */       
/*  379 */       MapInterface.addMapEntity(MapEntityType.MET_CHILDREN, childId, worldInstanceId, mapCfgid, giveBirthX, giveBirthY, -1, intExtraInfoEntries, longExtraInfoEntries, stringExtraInfoEntries, null);
/*      */     }
/*      */     
/*      */ 
/*  383 */     GameServer.logger().info(String.format("[children]ChildrenInterface.addChildrenAfterCreateWorld@add child success|role_id=%d|child_id=%d|position_x=%d|position_y=%d|home_state=%d|world_instance_id=%d|map_cfg_id=%d|reason=%s", new Object[] { Long.valueOf(roleId), Long.valueOf(childId), Integer.valueOf(xChildInfo.getPosition_x()), Integer.valueOf(xChildInfo.getPosition_y()), Integer.valueOf(xChildInfo.getHome_state()), Long.valueOf(worldInstanceId), Integer.valueOf(mapCfgid), childAddHomeReason }));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void removeChildByRoleid(long roleId, long childId, boolean retainLock)
/*      */   {
/*  398 */     MapInterface.removeMapEntity(MapEntityType.MET_CHILDREN, childId, null);
/*      */     
/*  400 */     GameServer.logger().info(String.format("[children]ChildrenInterface.removeChildByRoleid@remove child success|role_id=%d|child_id=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(childId) }));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void addChildrenByRoleId(long roleId, long worldInstanceId, int yardMapCfgId, int roomMapCfgId)
/*      */   {
/*  418 */     List<Long> childIdList = ChildrenManager.getChildIdList(roleId, -1L, true);
/*      */     
/*  420 */     if ((childIdList == null) || (childIdList.isEmpty()))
/*      */     {
/*  422 */       return;
/*      */     }
/*      */     
/*      */ 
/*  426 */     Lockeys.lock(xtable.Children.getTable(), childIdList);
/*      */     
/*  428 */     List<ChildPos> aleardyUseChildHomePosList = new ArrayList();
/*  429 */     List<ChildPos> aleardyUseChildYardPosList = new ArrayList();
/*  430 */     for (Iterator i$ = childIdList.iterator(); i$.hasNext();) { long xChildId = ((Long)i$.next()).longValue();
/*      */       
/*  432 */       ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(xChildId));
/*  433 */       if (xChildInfo == null)
/*      */       {
/*  435 */         GameServer.logger().error(String.format("[children]ChildrenInterface.addChildrenIntoWorldWhenCreateWorld@child not found|role_id=%d|child_id=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(xChildId) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       }
/*  442 */       else if ((xChildInfo.getHome_state() != 0) && 
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*  447 */         (!xChildInfo.getIs_discard()))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  452 */         Map<Integer, String> stringExtraInfoEntries = new HashMap();
/*  453 */         stringExtraInfoEntries.put(Integer.valueOf(702), xChildInfo.getChild_name());
/*      */         
/*  455 */         Map<Integer, Long> longExtraInfoEntries = new HashMap();
/*  456 */         longExtraInfoEntries.put(Integer.valueOf(701), Long.valueOf(xChildId));
/*      */         
/*  458 */         Map<Integer, Integer> intExtraInfoEntries = new HashMap();
/*  459 */         fillIntExtraInfoEntries(xChildId, intExtraInfoEntries, xChildInfo);
/*      */         
/*  461 */         int realMapCfgId = xChildInfo.getHome_state() == 1 ? roomMapCfgId : yardMapCfgId;
/*      */         
/*  463 */         if ((xChildInfo.getPosition_x() > 0) && (xChildInfo.getPosition_y() > 0))
/*      */         {
/*  465 */           MapInterface.addMapEntity(MapEntityType.MET_CHILDREN, xChildId, worldInstanceId, realMapCfgId, xChildInfo.getPosition_x(), xChildInfo.getPosition_y(), -1, intExtraInfoEntries, longExtraInfoEntries, stringExtraInfoEntries, null);
/*      */           
/*      */ 
/*      */ 
/*  469 */           GameServer.logger().info(String.format("[children]ChildrenInterface.addChildrenByRoleId@add child success,aleardy has position|role_id=%d|child_id=%d|position_x=%d|position_y=%d|home_state=%d|world_instance_id=%d|yard_map_cfg_id=%d|room_map_cfg_id=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(xChildId), Integer.valueOf(xChildInfo.getPosition_x()), Integer.valueOf(xChildInfo.getPosition_y()), Integer.valueOf(xChildInfo.getHome_state()), Long.valueOf(worldInstanceId), Integer.valueOf(yardMapCfgId), Integer.valueOf(roomMapCfgId) }));
/*      */ 
/*      */ 
/*      */ 
/*      */         }
/*      */         else
/*      */         {
/*      */ 
/*      */ 
/*  478 */           ChildPos giveBirthChildPos = null;
/*  479 */           if (xChildInfo.getHome_state() == 1)
/*      */           {
/*  481 */             List<ChildPos> childPosList = HomelandInterface.getChildPositions(realMapCfgId);
/*  482 */             giveBirthChildPos = getRandomChildPos(childPosList, aleardyUseChildHomePosList);
/*      */           }
/*      */           else
/*      */           {
/*  486 */             List<ChildPos> childPosList = HomelandInterface.getChildPositions(realMapCfgId);
/*  487 */             giveBirthChildPos = getRandomChildPos(childPosList, aleardyUseChildYardPosList);
/*      */           }
/*      */           
/*  490 */           int giveBirthX = 0;
/*  491 */           int giveBirthY = 0;
/*  492 */           if (giveBirthChildPos != null)
/*      */           {
/*  494 */             giveBirthX = giveBirthChildPos.childX;
/*  495 */             giveBirthY = giveBirthChildPos.childY;
/*      */           }
/*      */           else
/*      */           {
/*  499 */             Position position = MapInterface.randomWalkablePos(realMapCfgId);
/*  500 */             if (position == null)
/*      */             {
/*  502 */               GameServer.logger().error(String.format("[children]ChildrenInterface.addChildrenByRoleId@no can walk position|roomMapCfgId=%d", new Object[] { Integer.valueOf(roomMapCfgId) }));
/*      */               
/*      */ 
/*      */ 
/*  506 */               return;
/*      */             }
/*  508 */             giveBirthX = position.getX();
/*  509 */             giveBirthY = position.getY();
/*      */           }
/*      */           
/*  512 */           xChildInfo.setPosition_x(giveBirthX);
/*  513 */           xChildInfo.setPosition_y(giveBirthY);
/*  514 */           MapInterface.addMapEntity(MapEntityType.MET_CHILDREN, xChildId, worldInstanceId, realMapCfgId, giveBirthX, giveBirthY, -1, intExtraInfoEntries, longExtraInfoEntries, stringExtraInfoEntries, null);
/*      */           
/*      */ 
/*  517 */           GameServer.logger().info(String.format("[children]ChildrenInterface.addChildrenByRoleId@add child success,random position|role_id=%d|child_id=%d|position_x=%d|position_y=%d|home_state=%d|world_instance_id=%d|yard_map_cfg_id=%d|room_map_cfg_id=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(xChildId), Integer.valueOf(xChildInfo.getPosition_x()), Integer.valueOf(xChildInfo.getPosition_y()), Integer.valueOf(xChildInfo.getHome_state()), Long.valueOf(worldInstanceId), Integer.valueOf(yardMapCfgId), Integer.valueOf(roomMapCfgId) }));
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void removeChildByRoleid(long roleId)
/*      */   {
/*  536 */     Role2ChildrenInfo xRole2ChildrenInfo = Role2children.get(Long.valueOf(roleId));
/*  537 */     if (xRole2ChildrenInfo == null)
/*      */     {
/*  539 */       return;
/*      */     }
/*      */     
/*  542 */     List<Long> xChildIdList = xRole2ChildrenInfo.getChild_id_list();
/*      */     
/*  544 */     Lockeys.lock(xtable.Children.getTable(), xChildIdList);
/*      */     
/*  546 */     for (Iterator i$ = xChildIdList.iterator(); i$.hasNext();) { long childId = ((Long)i$.next()).longValue();
/*      */       
/*  548 */       MapInterface.removeMapEntity(MapEntityType.MET_CHILDREN, childId, null);
/*      */       
/*  550 */       GameServer.logger().info(String.format("[children]ChildrenInterface.removeChildByRoleid@remove child success,divorce|role_id=%d|child_id=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(childId) }));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void onChildNameChange(long roleId, long childId)
/*      */   {
/*  562 */     ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(childId));
/*  563 */     if (xChildInfo == null)
/*      */     {
/*  565 */       return;
/*      */     }
/*      */     
/*  568 */     Map<Integer, String> replaceStringExtraInfoEntries = new HashMap();
/*  569 */     replaceStringExtraInfoEntries.put(Integer.valueOf(702), xChildInfo.getChild_name());
/*      */     
/*  571 */     MapInterface.changeMapEntityExtraInfos(MapEntityType.MET_CHILDREN, childId, null, null, replaceStringExtraInfoEntries, null, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void onChildPeriodChange(long roleId, long childId)
/*      */   {
/*  580 */     ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(childId));
/*  581 */     if (xChildInfo == null)
/*      */     {
/*  583 */       return;
/*      */     }
/*      */     
/*  586 */     if (xChildInfo.getHome_state() == 0)
/*      */     {
/*  588 */       return;
/*      */     }
/*      */     
/*  591 */     Map<Integer, Integer> replaceIntegerExtraInfoEntries = new HashMap();
/*  592 */     replaceIntegerExtraInfoEntries.put(Integer.valueOf(704), Integer.valueOf(xChildInfo.getChild_period()));
/*  593 */     replaceIntegerExtraInfoEntries.put(Integer.valueOf(705), Integer.valueOf(0));
/*  594 */     replaceIntegerExtraInfoEntries.put(Integer.valueOf(706), Integer.valueOf(getChildModelCfgId(childId, xChildInfo)));
/*      */     
/*      */ 
/*  597 */     int childrenWeaponCfgid = ChildrenManager.getChildrenWeaponCfgid(xChildInfo);
/*  598 */     replaceIntegerExtraInfoEntries.put(Integer.valueOf(707), Integer.valueOf(childrenWeaponCfgid));
/*      */     
/*  600 */     MapInterface.changeMapEntityExtraInfos(MapEntityType.MET_CHILDREN, childId, replaceIntegerExtraInfoEntries, null, null, null, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void hideChild(long roleId, boolean isTriggerEvent)
/*      */   {
/*  611 */     Role2ChildrenInfo xRole2ChildrenInfo = Role2children.get(Long.valueOf(roleId));
/*  612 */     if (xRole2ChildrenInfo == null)
/*      */     {
/*  614 */       return;
/*      */     }
/*      */     
/*  617 */     if (xRole2ChildrenInfo.getShow_child_id() == -1L)
/*      */     {
/*  619 */       return;
/*      */     }
/*      */     
/*  622 */     xRole2ChildrenInfo.setShow_child_id(-1L);
/*      */     
/*  624 */     SCancelChildShowSuccess sCancelChildShowSuccess = new SCancelChildShowSuccess();
/*  625 */     OnlineManager.getInstance().send(roleId, sCancelChildShowSuccess);
/*      */     
/*  627 */     if (isTriggerEvent)
/*      */     {
/*  629 */       ChildrenManager.trigChildrenEvent(new ChildShowModelChange(), new ChildShowModelChangeArg(roleId, ChildShowModelChangeReason.REMOVE));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static ShowChildObj getShowChildObj(long roleId, boolean isRemainLock)
/*      */   {
/*      */     Role2ChildrenInfo xRole2ChildrenInfo;
/*      */     
/*      */ 
/*      */ 
/*      */     Role2ChildrenInfo xRole2ChildrenInfo;
/*      */     
/*      */ 
/*      */ 
/*  647 */     if (isRemainLock)
/*      */     {
/*  649 */       xRole2ChildrenInfo = Role2children.get(Long.valueOf(roleId));
/*      */     }
/*      */     else
/*      */     {
/*  653 */       xRole2ChildrenInfo = Role2children.select(Long.valueOf(roleId));
/*      */     }
/*      */     
/*  656 */     if (xRole2ChildrenInfo == null)
/*      */     {
/*  658 */       return null;
/*      */     }
/*      */     
/*  661 */     long showChildId = xRole2ChildrenInfo.getShow_child_id();
/*  662 */     if (showChildId == -1L)
/*      */     {
/*  664 */       return null;
/*      */     }
/*      */     
/*  667 */     ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(showChildId));
/*  668 */     if (xChildInfo == null)
/*      */     {
/*  670 */       return null;
/*      */     }
/*      */     
/*  673 */     int fashionid = 0;
/*  674 */     int showPhase = xRole2ChildrenInfo.getShow_child_period();
/*  675 */     DressedInfo xDressedInfo = (DressedInfo)xChildInfo.getDressed().get(Integer.valueOf(showPhase));
/*  676 */     if (xDressedInfo != null)
/*      */     {
/*  678 */       SFashionCfg fashionCfg = SFashionCfg.get(xDressedInfo.getFashion_cfgid());
/*  679 */       if (fashionCfg != null)
/*      */       {
/*  681 */         fashionid = fashionCfg.changeFashionCfgid;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  686 */     int childrenCfgid = ChildrenManager.getShowChildrenCfgid(showPhase, xChildInfo);
/*  687 */     if (childrenCfgid < 0)
/*      */     {
/*  689 */       GameServer.logger().error(String.format("[children]ChildrenInterface.getShowChildObj@get children_cfgid failed|roleid=%d|childid=%d|show_phase=%d|gender=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(showChildId), Integer.valueOf(showPhase), Integer.valueOf(xChildInfo.getChild_gender()) }));
/*      */       
/*      */ 
/*      */ 
/*  693 */       return null;
/*      */     }
/*      */     
/*      */ 
/*  697 */     int childrenWeaponCfgid = ChildrenManager.getChildrenWeaponCfgid(xChildInfo);
/*  698 */     return new ShowChildObj(showChildId, showPhase, xChildInfo.getChild_gender(), xChildInfo.getChild_name(), fashionid, childrenCfgid, childrenWeaponCfgid);
/*      */   }
/*      */   
/*      */ 
/*      */   public static class ShowChildObj
/*      */   {
/*      */     private final long childId;
/*      */     
/*      */     private final int childPeriod;
/*      */     
/*      */     private final int childGender;
/*      */     
/*      */     private final String childName;
/*      */     
/*      */     private final int fashionCfgid;
/*      */     
/*      */     private final int childrenCfgid;
/*      */     
/*      */     private final int childrenWeaponCfgid;
/*      */     
/*      */ 
/*      */     public ShowChildObj(long childId, int childPeriod, int childGender, String childName, int fashionCfgid, int childrenCfgid, int childrenWeaponCfgid)
/*      */     {
/*  721 */       this.childId = childId;
/*  722 */       this.childPeriod = childPeriod;
/*  723 */       this.childGender = childGender;
/*  724 */       this.childName = childName;
/*  725 */       this.fashionCfgid = fashionCfgid;
/*  726 */       this.childrenCfgid = childrenCfgid;
/*  727 */       this.childrenWeaponCfgid = childrenWeaponCfgid;
/*      */     }
/*      */     
/*      */     public long getChildId()
/*      */     {
/*  732 */       return this.childId;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */     public int getChildPeriod()
/*      */     {
/*  740 */       return this.childPeriod;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */     public int getChildGender()
/*      */     {
/*  748 */       return this.childGender;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */     public String getChildName()
/*      */     {
/*  756 */       return this.childName;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public int getFashionCfgid()
/*      */     {
/*  765 */       return this.fashionCfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */     public int getChildrenCfgid()
/*      */     {
/*  773 */       return this.childrenCfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public int getChildrenWeaponCfgid()
/*      */     {
/*  783 */       return this.childrenWeaponCfgid;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isCanGiveBirth(long roleId)
/*      */   {
/*  798 */     long marriedId = MarriageInterface.getMarriedId(roleId, true);
/*  799 */     if (marriedId < 0L)
/*      */     {
/*  801 */       syncChildNormalFail(roleId, 22);
/*  802 */       return false;
/*      */     }
/*      */     
/*  805 */     MarriageInterface.PregnantState pregnantState = MarriageInterface.getPregnantState(marriedId, true);
/*  806 */     if (pregnantState == null)
/*      */     {
/*  808 */       syncChildNormalFail(roleId, 29);
/*  809 */       return false;
/*      */     }
/*      */     
/*  812 */     if (pregnantState.step != 4)
/*      */     {
/*  814 */       syncChildNormalFail(roleId, 30);
/*  815 */       return false;
/*      */     }
/*  817 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getSignalWayChildScore(long roleId, boolean isRemainRoleLock)
/*      */   {
/*  831 */     Role2ChildrenInfo xRole2ChildrenInfo = null;
/*  832 */     if (isRemainRoleLock)
/*      */     {
/*  834 */       xRole2ChildrenInfo = Role2children.get(Long.valueOf(roleId));
/*      */     }
/*      */     else
/*      */     {
/*  838 */       xRole2ChildrenInfo = Role2children.select(Long.valueOf(roleId));
/*      */     }
/*      */     
/*  841 */     if (xRole2ChildrenInfo == null)
/*      */     {
/*  843 */       return 0;
/*      */     }
/*      */     
/*  846 */     return xRole2ChildrenInfo.getSignal_way_child_score();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int isCanSignalBreed(long roleId, boolean isRemainlock)
/*      */   {
/*  864 */     BreedInfo breedInfo = ChildrenManager.getBreedInfo(roleId, isRemainlock);
/*      */     
/*  866 */     if (breedInfo == null)
/*      */     {
/*  868 */       return 0;
/*      */     }
/*      */     
/*  871 */     if (breedInfo.breed_state != 1)
/*      */     {
/*  873 */       syncChildNormalFail(roleId, 28);
/*  874 */       return -1;
/*      */     }
/*      */     
/*  877 */     if (breedInfo.step != 1)
/*      */     {
/*  879 */       syncChildNormalFail(roleId, 28);
/*  880 */       return -1;
/*      */     }
/*      */     
/*      */ 
/*  884 */     int totalChildSize = ChildrenManager.getOwnChildSize(roleId, isRemainlock);
/*  885 */     if (totalChildSize >= SChildrenConsts.getInstance().max_children_can_carrey)
/*      */     {
/*  887 */       syncChildNormalFail(roleId, 27);
/*  888 */       return -1;
/*      */     }
/*      */     
/*  891 */     return breedInfo.score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int isCanCouplePreparePregnant(long roleId, long partnerRoleId, boolean isRemainlock)
/*      */   {
/*  908 */     BreedInfo breedInfo = ChildrenManager.getBreedInfo(roleId, isRemainlock);
/*  909 */     BreedInfo partnerBreedInfo = ChildrenManager.getBreedInfo(partnerRoleId, isRemainlock);
/*  910 */     long marriedRoleId = MarriageInterface.getMarriedRoleid(roleId, isRemainlock);
/*  911 */     if ((marriedRoleId != partnerRoleId) || (marriedRoleId < 0L))
/*      */     {
/*  913 */       syncChildNormalFail(roleId, partnerRoleId, 22);
/*  914 */       return -1;
/*      */     }
/*      */     
/*  917 */     if ((breedInfo == null) && (partnerBreedInfo == null))
/*      */     {
/*      */ 
/*  920 */       return 0;
/*      */     }
/*      */     
/*  923 */     if ((breedInfo != null) && (breedInfo.breed_state != 0))
/*      */     {
/*  925 */       syncChildNormalFail(roleId, partnerRoleId, 23);
/*  926 */       return -1;
/*      */     }
/*      */     
/*  929 */     if ((breedInfo != null) && (breedInfo.step != 1))
/*      */     {
/*  931 */       syncChildNormalFail(roleId, partnerRoleId, 24);
/*  932 */       return -1;
/*      */     }
/*      */     
/*  935 */     if ((partnerBreedInfo != null) && (partnerBreedInfo.breed_state != 0))
/*      */     {
/*  937 */       syncChildNormalFail(roleId, partnerRoleId, 25);
/*  938 */       return -1;
/*      */     }
/*      */     
/*  941 */     if ((partnerBreedInfo != null) && (partnerBreedInfo.step != 1))
/*      */     {
/*  943 */       syncChildNormalFail(roleId, partnerRoleId, 26);
/*  944 */       return -1;
/*      */     }
/*      */     
/*      */ 
/*  948 */     int totalChildSize = ChildrenManager.getOwnChildSize(roleId, isRemainlock);
/*      */     
/*  950 */     int marriedRoleIdChildSize = ChildrenManager.getOwnChildSize(partnerRoleId, isRemainlock);
/*  951 */     totalChildSize += marriedRoleIdChildSize;
/*  952 */     if (totalChildSize >= SChildrenConsts.getInstance().max_children_can_carrey * 2)
/*      */     {
/*  954 */       syncChildNormalFail(roleId, partnerRoleId, 27);
/*  955 */       return -1;
/*      */     }
/*      */     
/*  958 */     return breedInfo.score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int isCanCoupleFetusEduaction(long roleId, long partnerRoleId, boolean isRemainlock)
/*      */   {
/*  974 */     BreedInfo breedInfo = ChildrenManager.getBreedInfo(roleId, isRemainlock);
/*  975 */     BreedInfo partnerBreedInfo = ChildrenManager.getBreedInfo(partnerRoleId, isRemainlock);
/*      */     
/*  977 */     long marriedRoleId = MarriageInterface.getMarriedRoleid(roleId, isRemainlock);
/*  978 */     if ((marriedRoleId != partnerRoleId) || (marriedRoleId < 0L))
/*      */     {
/*  980 */       syncChildNormalFail(roleId, partnerRoleId, 22);
/*  981 */       return -1;
/*      */     }
/*      */     
/*  984 */     if ((breedInfo == null) || (breedInfo.breed_state != 0))
/*      */     {
/*  986 */       syncChildNormalFail(roleId, partnerRoleId, 23);
/*  987 */       return -1;
/*      */     }
/*      */     
/*  990 */     if (breedInfo.step != 3)
/*      */     {
/*  992 */       syncChildNormalFail(roleId, partnerRoleId, 24);
/*  993 */       return -1;
/*      */     }
/*      */     
/*  996 */     if ((partnerBreedInfo == null) || (partnerBreedInfo.breed_state != 0))
/*      */     {
/*  998 */       syncChildNormalFail(roleId, partnerRoleId, 25);
/*  999 */       return -1;
/*      */     }
/*      */     
/* 1002 */     if (partnerBreedInfo.step != 3)
/*      */     {
/* 1004 */       syncChildNormalFail(roleId, partnerRoleId, 26);
/* 1005 */       return -1;
/*      */     }
/*      */     
/*      */ 
/* 1009 */     int totalChildSize = ChildrenManager.getOwnChildSize(roleId, isRemainlock);
/*      */     
/* 1011 */     int marriedRoleIdChildSize = ChildrenManager.getOwnChildSize(marriedRoleId, isRemainlock);
/* 1012 */     totalChildSize += marriedRoleIdChildSize;
/* 1013 */     if (totalChildSize >= SChildrenConsts.getInstance().max_children_can_carrey * 2)
/*      */     {
/* 1015 */       syncChildNormalFail(roleId, partnerRoleId, 27);
/* 1016 */       return -1;
/*      */     }
/*      */     
/* 1019 */     return breedInfo.score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void addSignalWayChildScore(long roleId, int addScore)
/*      */   {
/* 1036 */     Role2ChildrenInfo xRole2ChildrenInfo = ChildrenManager.initAndGetChildrenInfo(roleId);
/*      */     
/* 1038 */     int nowScore = xRole2ChildrenInfo.getSignal_way_child_score();
/* 1039 */     if (nowScore >= SChildrenConsts.getInstance().single_children_need_score)
/*      */     {
/* 1041 */       return;
/*      */     }
/*      */     
/* 1044 */     int newScore = nowScore + addScore;
/*      */     
/* 1046 */     if (newScore >= SChildrenConsts.getInstance().single_children_need_score)
/*      */     {
/* 1048 */       long partnerRoleId = MarriageInterface.getMarriedRoleid(roleId, true);
/* 1049 */       long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*      */       
/* 1051 */       ChildInfo xChildInfo = ChildrenManager.generatorChild(roleId, currentTimeMillis);
/* 1052 */       xChildInfo.setOwn_role_id(roleId);
/* 1053 */       if (partnerRoleId > 0L)
/*      */       {
/* 1055 */         xChildInfo.setAnother_parent_role_id(partnerRoleId);
/*      */       }
/*      */       
/* 1058 */       long childId = xtable.Children.insert(xChildInfo).longValue();
/*      */       
/* 1060 */       ChildrenManager.generatorChildGrowthDiary(currentTimeMillis, childId);
/* 1061 */       xRole2ChildrenInfo.getChild_id_list().add(Long.valueOf(childId));
/*      */       
/* 1063 */       SAddChild sAddChild = new SAddChild();
/* 1064 */       sAddChild.child_id = childId;
/* 1065 */       ChildrenManager.fillChildBean(roleId, childId, xChildInfo, sAddChild.child_info, false);
/*      */       
/* 1067 */       int mapCfgId = HomelandInterface.getCurrentHomeMapId(roleId);
/* 1068 */       if (mapCfgId == -1)
/*      */       {
/* 1070 */         return;
/*      */       }
/* 1072 */       ChildrenManager.trigChildrenEvent(new AddChildIntoHome(), new AddChildIntoHomeArg(roleId, childId, mapCfgId, ChildAddHomeReason.GIVE_BIRTH));
/*      */       
/*      */ 
/* 1075 */       xRole2ChildrenInfo.setSignal_way_child_score(0);
/*      */       
/* 1077 */       String roleName = RoleInterface.getName(roleId);
/* 1078 */       List<Long> friendRoleIdList = FriendInterface.getAllFriends(roleId, true);
/*      */       
/* 1080 */       InvitationInterface.sendInvitationToRoles(roleId, friendRoleIdList, 1, Arrays.asList(new String[] { roleName }));
/*      */       
/* 1082 */       OnlineManager.getInstance().send(roleId, sAddChild);
/* 1083 */       if (partnerRoleId > 0L)
/*      */       {
/* 1085 */         OnlineManager.getInstance().send(partnerRoleId, sAddChild);
/*      */       }
/* 1087 */       ChildrenManager.tlogSignalWayGetChildren(RoleInterface.getUserId(roleId), roleId, childId);
/*      */       
/* 1089 */       SSyncBreedInfo sSyncBreedInfo = new SSyncBreedInfo();
/* 1090 */       sSyncBreedInfo.breed_state = 2;
/* 1091 */       sSyncBreedInfo.step = 1;
/* 1092 */       sSyncBreedInfo.score = 0;
/* 1093 */       OnlineManager.getInstance().send(roleId, sSyncBreedInfo);
/*      */     }
/*      */     else
/*      */     {
/* 1097 */       xRole2ChildrenInfo.setSignal_way_child_score(newScore);
/*      */       
/* 1099 */       ChildrenManager.tlogSingleBreedScoreChange(roleId, newScore);
/*      */       
/* 1101 */       SSyncBreedInfo sSyncBreedInfo = new SSyncBreedInfo();
/* 1102 */       sSyncBreedInfo.breed_state = 1;
/* 1103 */       sSyncBreedInfo.step = 1;
/* 1104 */       sSyncBreedInfo.score = xRole2ChildrenInfo.getSignal_way_child_score();
/* 1105 */       OnlineManager.getInstance().send(roleId, sSyncBreedInfo);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void addPreparePregnantScore(long roleId, long partnerRoleId, long marrigeId, int score)
/*      */   {
/* 1124 */     long xPartnerRoleId = MarriageInterface.getMarriedRoleid(roleId, true);
/* 1125 */     if (xPartnerRoleId != partnerRoleId)
/*      */     {
/* 1127 */       return;
/*      */     }
/*      */     
/* 1130 */     long xMarrigeId = MarriageInterface.getMarriedId(roleId, true);
/* 1131 */     if (xMarrigeId != marrigeId)
/*      */     {
/* 1133 */       return;
/*      */     }
/* 1135 */     BreedInfo breedInfo = ChildrenManager.getBreedInfo(roleId, true);
/* 1136 */     if ((breedInfo != null) && (breedInfo.breed_state != 0))
/*      */     {
/* 1138 */       return;
/*      */     }
/*      */     
/* 1141 */     if ((breedInfo != null) && (breedInfo.step != 1))
/*      */     {
/* 1143 */       return;
/*      */     }
/*      */     
/* 1146 */     if ((breedInfo != null) && (breedInfo.score >= SChildrenConsts.getInstance().prepare_pregnant_need_score))
/*      */     {
/* 1148 */       return;
/*      */     }
/*      */     
/* 1151 */     SSyncBreedInfo sSyncBreedInfo = new SSyncBreedInfo();
/* 1152 */     sSyncBreedInfo.breed_state = 0;
/* 1153 */     int nowScore = MarriageInterface.addAndGetPreparePregnantScore(marrigeId, score);
/* 1154 */     if (nowScore >= SChildrenConsts.getInstance().prepare_pregnant_need_score)
/*      */     {
/* 1156 */       sSyncBreedInfo.score = 0;
/* 1157 */       sSyncBreedInfo.step = 2;
/*      */       
/* 1159 */       ChildrenManager.tlogCoupleBreedFinishStep(roleId, partnerRoleId, 1);
/*      */     }
/*      */     else
/*      */     {
/* 1163 */       sSyncBreedInfo.score = nowScore;
/* 1164 */       sSyncBreedInfo.step = 1;
/*      */     }
/*      */     
/* 1167 */     ChildrenManager.tlogCoupleBreedStepScore(roleId, partnerRoleId, 1, nowScore);
/* 1168 */     OnlineManager.getInstance().sendMulti(sSyncBreedInfo, Arrays.asList(new Long[] { Long.valueOf(roleId), Long.valueOf(partnerRoleId) }));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void addGiveBirthScore(long roleId, long partnerRoleId, long marrigeId, int score)
/*      */   {
/* 1184 */     long xPartnerRoleId = MarriageInterface.getMarriedRoleid(roleId, true);
/* 1185 */     if (xPartnerRoleId != partnerRoleId)
/*      */     {
/* 1187 */       return;
/*      */     }
/*      */     
/* 1190 */     long xMarrigeId = MarriageInterface.getMarriedId(roleId, true);
/* 1191 */     if (xMarrigeId != marrigeId)
/*      */     {
/* 1193 */       return;
/*      */     }
/* 1195 */     BreedInfo breedInfo = ChildrenManager.getBreedInfo(roleId, true);
/* 1196 */     if ((breedInfo == null) || (breedInfo.breed_state != 0))
/*      */     {
/* 1198 */       return;
/*      */     }
/*      */     
/* 1201 */     if ((breedInfo == null) || (breedInfo.step != 3))
/*      */     {
/* 1203 */       return;
/*      */     }
/*      */     
/* 1206 */     if ((breedInfo == null) || (breedInfo.score >= SChildrenConsts.getInstance().give_birth_need_score))
/*      */     {
/* 1208 */       return;
/*      */     }
/*      */     
/* 1211 */     SSyncBreedInfo sSyncBreedInfo = new SSyncBreedInfo();
/* 1212 */     sSyncBreedInfo.breed_state = 0;
/* 1213 */     int nowScore = MarriageInterface.addAndGetGiveBirthScore(marrigeId, score);
/* 1214 */     if (nowScore >= SChildrenConsts.getInstance().give_birth_need_score)
/*      */     {
/* 1216 */       long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/* 1217 */       MarriageInterface.setGiveBirthScoreEnoughTime(marrigeId, currentTimeMillis);
/*      */       
/* 1219 */       long waitTime = SChildrenConsts.getInstance().give_birth_days * 86400000L;
/*      */       
/* 1221 */       GiveBirthTimerEventArg arg = new GiveBirthTimerEventArg(roleId, waitTime, marrigeId, partnerRoleId, currentTimeMillis);
/*      */       
/*      */ 
/* 1224 */       TriggerEventsManger.getInstance().triggerEvent(new GiveBirthTimerEvent(), arg);
/*      */       
/* 1226 */       sSyncBreedInfo.score = 0;
/* 1227 */       sSyncBreedInfo.step = 4;
/* 1228 */       sSyncBreedInfo.remain_give_birth_seconds = (waitTime / 1000L);
/*      */       
/* 1230 */       ChildrenManager.tlogCoupleBreedFinishStep(roleId, partnerRoleId, 3);
/*      */     }
/*      */     else
/*      */     {
/* 1234 */       sSyncBreedInfo.score = nowScore;
/* 1235 */       sSyncBreedInfo.step = 3;
/*      */     }
/*      */     
/* 1238 */     ChildrenManager.tlogCoupleBreedStepScore(roleId, partnerRoleId, 3, nowScore);
/* 1239 */     OnlineManager.getInstance().sendMulti(sSyncBreedInfo, Arrays.asList(new Long[] { Long.valueOf(roleId), Long.valueOf(partnerRoleId) }));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getOwnChildSize(long roleId, boolean isRemainRoleLock)
/*      */   {
/* 1254 */     return ChildrenManager.getOwnChildSize(roleId, isRemainRoleLock);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void onDivorce(long marriageId, long roleIdA, long roleIdB, boolean isSendChildAbortionNotify)
/*      */   {
/* 1269 */     if (isSendChildAbortionNotify)
/*      */     {
/* 1271 */       ChildrenManager.notifyChildAbortion(roleIdA, roleIdB, AbortionReasonEnum.DIVORCE.reason);
/* 1272 */       RoleStatusInterface.unsetStatus(Arrays.asList(new Long[] { Long.valueOf(roleIdA), Long.valueOf(roleIdB) }), 901);
/* 1273 */       ChildrenManager.cancelGiveBirthObserver(marriageId);
/*      */     }
/*      */     
/* 1276 */     Role2ChildrenInfo xRoleIdAChildrenInfo = ChildrenManager.initAndGetChildrenInfo(roleIdA);
/* 1277 */     Role2ChildrenInfo xRoleIdBChildrenInfo = ChildrenManager.initAndGetChildrenInfo(roleIdB);
/*      */     
/* 1279 */     List<Long> childIdList = new ArrayList();
/*      */     
/* 1281 */     List<Long> roleIdABagIdList = new ArrayList();
/* 1282 */     List<Long> roleIdBBagIdList = new ArrayList();
/*      */     
/* 1284 */     roleIdABagIdList.addAll(xRoleIdAChildrenInfo.getChild_bag_id_list());
/* 1285 */     roleIdBBagIdList.addAll(xRoleIdBChildrenInfo.getChild_bag_id_list());
/*      */     
/* 1287 */     childIdList.addAll(xRoleIdAChildrenInfo.getChild_id_list());
/* 1288 */     childIdList.addAll(xRoleIdBChildrenInfo.getChild_id_list());
/*      */     
/* 1290 */     Lockeys.lock(xtable.Children.getTable(), childIdList);
/*      */     
/* 1292 */     for (Iterator i$ = childIdList.iterator(); i$.hasNext();) { long childId = ((Long)i$.next()).longValue();
/*      */       
/* 1294 */       ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(childId));
/* 1295 */       if (xChildInfo != null)
/*      */       {
/*      */ 
/*      */ 
/* 1299 */         xChildInfo.setPosition_x(-1);
/* 1300 */         xChildInfo.setPosition_y(-1);
/* 1301 */         xChildInfo.setAnother_parent_role_id(-1L);
/*      */       }
/*      */     }
/* 1304 */     for (Iterator i$ = roleIdABagIdList.iterator(); i$.hasNext();) { long childId = ((Long)i$.next()).longValue();
/*      */       
/* 1306 */       ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(childId));
/* 1307 */       if ((xChildInfo != null) && (xChildInfo.getOwn_role_id() != roleIdA))
/*      */       {
/* 1309 */         xChildInfo.setHome_state(0);
/* 1310 */         xRoleIdAChildrenInfo.getChild_bag_id_list().remove(Long.valueOf(childId));
/*      */         
/* 1312 */         xRoleIdBChildrenInfo.getChild_bag_id_list().add(Long.valueOf(childId));
/* 1313 */         xChildInfo.setCarry_role_id(roleIdB);
/*      */       }
/*      */     }
/*      */     
/* 1317 */     for (Iterator i$ = roleIdBBagIdList.iterator(); i$.hasNext();) { long childId = ((Long)i$.next()).longValue();
/*      */       
/* 1319 */       ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(childId));
/* 1320 */       if ((xChildInfo != null) && (xChildInfo.getOwn_role_id() != roleIdB))
/*      */       {
/* 1322 */         xChildInfo.setHome_state(0);
/* 1323 */         xRoleIdBChildrenInfo.getChild_bag_id_list().remove(Long.valueOf(childId));
/*      */         
/* 1325 */         xRoleIdAChildrenInfo.getChild_bag_id_list().add(Long.valueOf(childId));
/* 1326 */         xChildInfo.setCarry_role_id(roleIdA);
/*      */       }
/*      */     }
/*      */     
/* 1330 */     long roleIdAshowChildId = xRoleIdAChildrenInfo.getShow_child_id();
/* 1331 */     if (roleIdAshowChildId != -1L)
/*      */     {
/* 1333 */       ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(roleIdAshowChildId));
/* 1334 */       if ((xChildInfo != null) && (xChildInfo.getOwn_role_id() != roleIdA))
/*      */       {
/* 1336 */         xRoleIdAChildrenInfo.setShow_child_id(-1L);
/* 1337 */         xRoleIdAChildrenInfo.setShow_child_period(0);
/* 1338 */         ChildrenManager.trigChildrenEvent(new ChildShowModelChange(), new ChildShowModelChangeArg(roleIdA, ChildShowModelChangeReason.REMOVE));
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1343 */     long roleIdBshowChildId = xRoleIdBChildrenInfo.getShow_child_id();
/* 1344 */     if (roleIdBshowChildId != -1L)
/*      */     {
/* 1346 */       ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(roleIdBshowChildId));
/* 1347 */       if ((xChildInfo != null) && (xChildInfo.getOwn_role_id() != roleIdB))
/*      */       {
/* 1349 */         xRoleIdBChildrenInfo.setShow_child_id(-1L);
/* 1350 */         xRoleIdBChildrenInfo.setShow_child_period(0);
/* 1351 */         ChildrenManager.trigChildrenEvent(new ChildShowModelChange(), new ChildShowModelChangeArg(roleIdB, ChildShowModelChangeReason.REMOVE));
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1357 */     FashionManager.onDivorce(roleIdA, xRoleIdAChildrenInfo, roleIdABagIdList, roleIdB, xRoleIdBChildrenInfo, roleIdBBagIdList);
/*      */     
/*      */ 
/* 1360 */     syncChildrenInfo(roleIdA, -1L, childIdList, xRoleIdAChildrenInfo, 1);
/* 1361 */     syncChildrenInfo(roleIdB, -1L, childIdList, xRoleIdBChildrenInfo, 1);
/*      */   }
/*      */   
/*      */ 
/*      */   private static void syncChildrenInfo(long roleIdA, long roleIdB, List<Long> childIdList, Role2ChildrenInfo xRole2ChildrenInfo, int type)
/*      */   {
/* 1367 */     SSyncChildrenInfo roleIdASyncChildrenInfo = new SSyncChildrenInfo();
/* 1368 */     if (xRole2ChildrenInfo != null)
/*      */     {
/* 1370 */       roleIdASyncChildrenInfo.bag_child_id_list.addAll(xRole2ChildrenInfo.getChild_bag_id_list());
/* 1371 */       roleIdASyncChildrenInfo.show_child_id = xRole2ChildrenInfo.getShow_child_id();
/* 1372 */       roleIdASyncChildrenInfo.show_child_period = xRole2ChildrenInfo.getShow_child_period();
/*      */     }
/*      */     else
/*      */     {
/* 1376 */       roleIdASyncChildrenInfo.show_child_id = -1L;
/*      */     }
/* 1378 */     ChildrenManager.syncChildrenInfo(roleIdA, roleIdB, childIdList, roleIdASyncChildrenInfo, type);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void onMarry(long roleIdA, long roleIdB)
/*      */   {
/* 1392 */     Role2ChildrenInfo xRoleIdAChildrenInfo = Role2children.get(Long.valueOf(roleIdA));
/* 1393 */     Role2ChildrenInfo xRoleIdBChildrenInfo = Role2children.get(Long.valueOf(roleIdB));
/*      */     
/* 1395 */     List<Long> childIdList = null;
/* 1396 */     if (xRoleIdAChildrenInfo != null)
/*      */     {
/* 1398 */       childIdList = new ArrayList();
/* 1399 */       childIdList.addAll(xRoleIdAChildrenInfo.getChild_id_list());
/*      */     }
/*      */     
/* 1402 */     if (xRoleIdBChildrenInfo != null)
/*      */     {
/* 1404 */       if (childIdList == null)
/*      */       {
/* 1406 */         childIdList = new ArrayList();
/*      */       }
/* 1408 */       childIdList.addAll(xRoleIdBChildrenInfo.getChild_id_list());
/*      */     }
/*      */     
/* 1411 */     if ((childIdList == null) || (childIdList.isEmpty()))
/*      */     {
/* 1413 */       return;
/*      */     }
/*      */     
/* 1416 */     Lockeys.lock(xtable.Children.getTable(), childIdList);
/* 1417 */     for (Iterator i$ = childIdList.iterator(); i$.hasNext();) { long childId = ((Long)i$.next()).longValue();
/*      */       
/* 1419 */       ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(childId));
/* 1420 */       if (xChildInfo == null)
/*      */       {
/* 1422 */         GameServer.logger().error(String.format("[children]ChildrenInterface.onMarry@children not exist|roleId_A=%d|roleId_B=%d|child_id=%d", new Object[] { Long.valueOf(roleIdA), Long.valueOf(roleIdB), Long.valueOf(childId) }));
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/*      */ 
/* 1428 */         if (xChildInfo.getOwn_role_id() == roleIdA)
/*      */         {
/* 1430 */           xChildInfo.setAnother_parent_role_id(roleIdB);
/*      */         }
/*      */         else
/*      */         {
/* 1434 */           xChildInfo.setAnother_parent_role_id(roleIdA);
/*      */         }
/* 1436 */         xChildInfo.setPosition_x(-1);
/* 1437 */         xChildInfo.setPosition_y(-1);
/*      */       }
/*      */     }
/* 1440 */     syncChildrenInfo(roleIdB, roleIdA, childIdList, xRoleIdBChildrenInfo, 2);
/* 1441 */     syncChildrenInfo(roleIdA, roleIdB, childIdList, xRoleIdAChildrenInfo, 2);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static ShowChildFashionObj getShowChildFashionObj(long roleid, boolean remainLock)
/*      */   {
/* 1456 */     return FashionManager.getShowChildFashionObj(roleid, remainLock);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void fillChildGrowthDiary(long childId, Map<Integer, Integer> intParameterMap, Map<Integer, String> stringParameterMap, int growType, long currentTimeMillis)
/*      */   {
/* 1476 */     ChildGrowthDiaryInfo xChildGrowthDiaryInfo = Childrengrowthdiary.get(Long.valueOf(childId));
/* 1477 */     if (xChildGrowthDiaryInfo == null)
/*      */     {
/* 1479 */       return;
/*      */     }
/*      */     
/* 1482 */     ChildGrowthInfo xChildGrowthInfo = Pod.newChildGrowthInfo();
/* 1483 */     xChildGrowthInfo.setGrow_time(currentTimeMillis);
/* 1484 */     xChildGrowthInfo.setGrow_type(growType);
/* 1485 */     if (intParameterMap != null)
/*      */     {
/* 1487 */       xChildGrowthInfo.getInt_parameter_map().putAll(intParameterMap);
/*      */     }
/*      */     
/* 1490 */     if (stringParameterMap != null)
/*      */     {
/* 1492 */       xChildGrowthInfo.getString_parameter_map().putAll(stringParameterMap);
/*      */     }
/* 1494 */     List<ChildGrowthInfo> xGrowthInfoList = xChildGrowthDiaryInfo.getGrowth_info_list();
/* 1495 */     xGrowthInfoList.add(0, xChildGrowthInfo);
/*      */     
/* 1497 */     if (xGrowthInfoList.size() > SChildrenConsts.getInstance().grow_diary_record_num)
/*      */     {
/* 1499 */       xGrowthInfoList.remove(SChildrenConsts.getInstance().grow_diary_record_num);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void fillChildGrowthDiary(long childId, Map<Integer, Integer> intParameterMap, Map<Integer, String> stringParameterMap, int growType)
/*      */   {
/* 1518 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/* 1519 */     fillChildGrowthDiary(childId, intParameterMap, stringParameterMap, growType, currentTimeMillis);
/*      */   }
/*      */   
/*      */ 
/*      */   public static void syncChildNormalFail(long roleId, long partnerRoleId, int ret)
/*      */   {
/* 1525 */     SChildNormalFail sChildNormalFail = new SChildNormalFail();
/* 1526 */     sChildNormalFail.result = ret;
/* 1527 */     OnlineManager.getInstance().sendMultiAtOnce(sChildNormalFail, Arrays.asList(new Long[] { Long.valueOf(roleId), Long.valueOf(partnerRoleId) }));
/*      */   }
/*      */   
/*      */   public static void syncChildNormalFail(long roleId, int ret)
/*      */   {
/* 1532 */     SChildNormalFail sChildNormalFail = new SChildNormalFail();
/* 1533 */     sChildNormalFail.result = ret;
/* 1534 */     OnlineManager.getInstance().sendAtOnce(roleId, sChildNormalFail);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static ChildrenOutFightObj getChildrenOutFightObj(long roleid, long childid)
/*      */   {
/* 1547 */     return getChildrenOutFightObj(roleid, childid, true);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static ChildrenOutFightObj getChildrenOutFightObj(long roleid, long childid, boolean retainChildLock)
/*      */   {
/* 1560 */     ChildInfo xChildInfo = null;
/* 1561 */     if (retainChildLock)
/*      */     {
/* 1563 */       xChildInfo = xtable.Children.get(Long.valueOf(childid));
/*      */     }
/*      */     else
/*      */     {
/* 1567 */       xChildInfo = xtable.Children.select(Long.valueOf(childid));
/*      */     }
/* 1569 */     if (xChildInfo == null)
/*      */     {
/* 1571 */       return null;
/*      */     }
/* 1573 */     return ChildrenManager.getChildrenOutFightObj(roleid, childid, xChildInfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean canJoinFight(long roleid, long childid, boolean retainChildLock)
/*      */   {
/* 1585 */     if (!ChildrenManager.isChildAdultHoodSwithOpen(roleid))
/*      */     {
/* 1587 */       GameServer.logger().info(String.format("[Children]ChildrenInterface.canJoinFight@switch is not open|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*      */       
/* 1589 */       return false;
/*      */     }
/* 1591 */     Role2ChildrenInfo xRole2ChildrenInfo = Role2children.get(Long.valueOf(roleid));
/* 1592 */     if (xRole2ChildrenInfo == null)
/*      */     {
/* 1594 */       return false;
/*      */     }
/* 1596 */     boolean inBag = xRole2ChildrenInfo.getChild_bag_id_list().contains(Long.valueOf(childid));
/* 1597 */     if (!inBag)
/*      */     {
/* 1599 */       return false;
/*      */     }
/* 1601 */     ChildInfo xChildInfo = null;
/* 1602 */     if (retainChildLock)
/*      */     {
/* 1604 */       xChildInfo = xtable.Children.get(Long.valueOf(childid));
/*      */     }
/*      */     else
/*      */     {
/* 1608 */       xChildInfo = xtable.Children.select(Long.valueOf(childid));
/*      */     }
/* 1610 */     if (xChildInfo == null)
/*      */     {
/* 1612 */       return false;
/*      */     }
/* 1614 */     if (xChildInfo.getOwn_role_id() != roleid)
/*      */     {
/* 1616 */       return false;
/*      */     }
/* 1618 */     return xChildInfo.getChild_period() == 2;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isInFight(long roleid, long childid)
/*      */   {
/* 1631 */     return isInFight(roleid, childid, true);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isInFight(long roleid, long childid, boolean retainChildrenLock)
/*      */   {
/* 1644 */     Role2ChildrenInfo xRole2ChildrenInfo = Role2children.get(Long.valueOf(roleid));
/* 1645 */     if (xRole2ChildrenInfo == null)
/*      */     {
/* 1647 */       return false;
/*      */     }
/* 1649 */     ChildrenOutFightObj childrenOutFightObj = getChildrenOutFightObj(roleid, childid, retainChildrenLock);
/* 1650 */     if (childrenOutFightObj == null)
/*      */     {
/* 1652 */       return false;
/*      */     }
/* 1654 */     return childrenOutFightObj.isInFight();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Set<Integer> getChildFightSkills(long childid, boolean retainLock)
/*      */   {
/* 1665 */     ChildInfo xChildInfo = null;
/* 1666 */     if (retainLock)
/*      */     {
/* 1668 */       xChildInfo = xtable.Children.get(Long.valueOf(childid));
/*      */     }
/*      */     else
/*      */     {
/* 1672 */       xChildInfo = xtable.Children.select(Long.valueOf(childid));
/*      */     }
/* 1674 */     if (xChildInfo == null)
/*      */     {
/* 1676 */       return Collections.emptySet();
/*      */     }
/* 1678 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(xChildInfo);
/* 1679 */     if (xAdulthoodInfo == null)
/*      */     {
/* 1681 */       return Collections.emptySet();
/*      */     }
/* 1683 */     return ChildrenOutFightObj.getActiveSkills(xAdulthoodInfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void onHomeLevelUp(long roleId, long partnerRoleId)
/*      */   {
/* 1697 */     List<Long> childIdList = ChildrenManager.getChildIdList(roleId, partnerRoleId, true);
/*      */     
/* 1699 */     if ((childIdList == null) || (childIdList.isEmpty()))
/*      */     {
/* 1701 */       return;
/*      */     }
/*      */     
/* 1704 */     Lockeys.lock(xtable.Children.getTable(), childIdList);
/* 1705 */     for (Iterator i$ = childIdList.iterator(); i$.hasNext();) { long childId = ((Long)i$.next()).longValue();
/*      */       
/* 1707 */       ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(childId));
/* 1708 */       if (xChildInfo == null)
/*      */       {
/* 1710 */         GameServer.logger().error(String.format("[children]ChildrenInterface.onHomeLevelUp@children not exist|role_id=%d|partner_role_id=%d|child_id=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(partnerRoleId), Long.valueOf(childId) }));
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/*      */ 
/* 1716 */         xChildInfo.setPosition_x(-1);
/* 1717 */         xChildInfo.setPosition_y(-1);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Collection<Long> getRoleBagChilds(long roleid, boolean retainLock)
/*      */   {
/* 1731 */     Role2ChildrenInfo xRole2ChildrenInfo = null;
/* 1732 */     if (retainLock)
/*      */     {
/* 1734 */       xRole2ChildrenInfo = Role2children.get(Long.valueOf(roleid));
/*      */     }
/*      */     else
/*      */     {
/* 1738 */       xRole2ChildrenInfo = Role2children.select(Long.valueOf(roleid));
/*      */     }
/* 1740 */     if (xRole2ChildrenInfo == null)
/*      */     {
/* 1742 */       return Collections.EMPTY_LIST;
/*      */     }
/* 1744 */     return xRole2ChildrenInfo.getChild_bag_id_list();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean removeRoleCacheChildOutfightObj(long roleid)
/*      */   {
/* 1754 */     return Role2childoutfightbean.remove(Long.valueOf(roleid));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getChildrenOccupation(long childrenid, boolean retainLock)
/*      */   {
/* 1766 */     ChildInfo xChildInfo = null;
/* 1767 */     if (retainLock)
/*      */     {
/* 1769 */       xChildInfo = xtable.Children.get(Long.valueOf(childrenid));
/*      */     }
/*      */     else
/*      */     {
/* 1773 */       xChildInfo = xtable.Children.select(Long.valueOf(childrenid));
/*      */     }
/* 1775 */     if (xChildInfo == null)
/*      */     {
/* 1777 */       return -1;
/*      */     }
/* 1779 */     AdulthoodInfo xAdulthoodInfo = ChildrenManager.getXChildAdulthoodInfo(xChildInfo);
/* 1780 */     if (xAdulthoodInfo == null)
/*      */     {
/* 1782 */       return -1;
/*      */     }
/* 1784 */     return xAdulthoodInfo.getOccupation();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<String> getOwnChildNameList(long roleId, long marriedRoleId)
/*      */   {
/* 1799 */     List<String> ownChildNameList = null;
/* 1800 */     List<Long> childIdList = ChildrenManager.getChildIdList(roleId, marriedRoleId, true);
/* 1801 */     if ((childIdList == null) || (childIdList.isEmpty()))
/*      */     {
/* 1803 */       return ownChildNameList;
/*      */     }
/*      */     
/* 1806 */     Lockeys.lock(xtable.Children.getTable(), childIdList);
/* 1807 */     for (Iterator i$ = childIdList.iterator(); i$.hasNext();) { long childId = ((Long)i$.next()).longValue();
/*      */       
/* 1809 */       ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(childId));
/* 1810 */       if (ownChildNameList == null)
/*      */       {
/* 1812 */         ownChildNameList = new ArrayList();
/*      */       }
/* 1814 */       ownChildNameList.add(xChildInfo.getChild_name());
/*      */     }
/* 1816 */     return ownChildNameList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void fillChildModelInfo(ModelInfo modelInfo, long childId, boolean retainLock)
/*      */   {
/*      */     ChildInfo xChildInfo;
/*      */     
/*      */ 
/*      */ 
/*      */     ChildInfo xChildInfo;
/*      */     
/*      */ 
/*      */ 
/* 1832 */     if (retainLock)
/*      */     {
/* 1834 */       xChildInfo = xtable.Children.get(Long.valueOf(childId));
/*      */     }
/*      */     else
/*      */     {
/* 1838 */       xChildInfo = xtable.Children.select(Long.valueOf(childId));
/*      */     }
/* 1840 */     if (null == xChildInfo)
/*      */     {
/* 1842 */       return;
/*      */     }
/* 1844 */     Children children = new Children(xChildInfo.getOwn_role_id(), childId, xChildInfo);
/* 1845 */     children.getModel(modelInfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getTotalChildrenRating(long roleId, boolean retainLock)
/*      */   {
/* 1857 */     return ChildrenManager.getTotalChildrenRating(roleId, retainLock);
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\ChildrenInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */