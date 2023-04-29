/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SChildNormalFail;
/*     */ import mzm.gsp.children.SMoveChildHomeSuccess;
/*     */ import mzm.gsp.children.event.AddChildIntoHome;
/*     */ import mzm.gsp.children.event.AddChildIntoHomeArg;
/*     */ import mzm.gsp.children.event.ChildShowModelChange;
/*     */ import mzm.gsp.children.event.ChildShowModelChangeArg;
/*     */ import mzm.gsp.children.event.ChildShowModelChangeReason;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.map.main.MapCallback;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.scene.PositionWithCfgid;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChildInfo;
/*     */ import xbean.Role2ChildrenInfo;
/*     */ import xtable.Role2children;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCMoveChildHome extends LogicProcedure implements MapCallback<Map<Long, PositionWithCfgid>>
/*     */ {
/*     */   private final long roleId;
/*     */   private final long childId;
/*     */   
/*     */   public PCMoveChildHome(long roleId, long childId)
/*     */   {
/*  37 */     this.roleId = roleId;
/*  38 */     this.childId = childId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleId))
/*     */     {
/*  46 */       onMoveChildHomeFail(21);
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     if (!ChildrenManager.isFunOpen(this.roleId))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if (!ChildrenManager.canDoAction(this.roleId, 841))
/*     */     {
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     MapInterface.getRolePosition(this.roleId, this);
/*     */     
/*  62 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isCallInProcedure()
/*     */   {
/*  68 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean onResult(Map<Long, PositionWithCfgid> result)
/*     */   {
/*  74 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleId))
/*     */     {
/*  76 */       onMoveChildHomeFail(21);
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     if (!ChildrenManager.isFunOpen(this.roleId))
/*     */     {
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     if (!ChildrenManager.canDoAction(this.roleId, 841))
/*     */     {
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     PositionWithCfgid position = (PositionWithCfgid)result.get(Long.valueOf(this.roleId));
/*  91 */     if (position == null)
/*     */     {
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     String userId = RoleInterface.getUserId(this.roleId);
/*     */     
/*  98 */     long marriedRoleId = MarriageInterface.getMarriedRoleid(this.roleId, false);
/*  99 */     if (marriedRoleId > 0L)
/*     */     {
/* 101 */       String marriedUserId = RoleInterface.getUserId(marriedRoleId);
/*     */       
/* 103 */       lock(User.getTable(), Arrays.asList(new String[] { marriedUserId, userId }));
/* 104 */       lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(marriedRoleId) }));
/*     */     }
/*     */     else
/*     */     {
/* 108 */       lock(xdb.Lockeys.get(User.getTable(), userId));
/*     */     }
/*     */     
/* 111 */     Role2ChildrenInfo xRole2ChildrenInfo = Role2children.get(Long.valueOf(this.roleId));
/* 112 */     if (xRole2ChildrenInfo == null)
/*     */     {
/* 114 */       onMoveChildHomeFail(4);
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     List<Long> xBagChildIdList = xRole2ChildrenInfo.getChild_bag_id_list();
/* 119 */     if (!xBagChildIdList.contains(Long.valueOf(this.childId)))
/*     */     {
/* 121 */       onMoveChildHomeFail(4);
/* 122 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 126 */     ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(this.childId));
/* 127 */     if (xChildInfo == null)
/*     */     {
/* 129 */       onMoveChildHomeFail(2);
/* 130 */       return false;
/*     */     }
/*     */     
/* 133 */     if (!ChildrenManager.checkChildrenDiscardOnOperate(this.roleId, xChildInfo))
/*     */     {
/* 135 */       return false;
/*     */     }
/*     */     
/* 138 */     if ((xChildInfo.getOwn_role_id() != this.roleId) && (xChildInfo.getAnother_parent_role_id() != this.roleId))
/*     */     {
/* 140 */       onMoveChildHomeFail(1);
/* 141 */       return false;
/*     */     }
/*     */     
/* 144 */     if (xChildInfo.getHome_state() != 0)
/*     */     {
/* 146 */       onMoveChildHomeFail(6);
/* 147 */       return false;
/*     */     }
/* 149 */     if (xChildInfo.getChild_period() == 2)
/*     */     {
/* 151 */       if (ChildrenInterface.isInFight(xChildInfo.getOwn_role_id(), this.childId))
/*     */       {
/* 153 */         onMoveChildHomeFail(51);
/* 154 */         return false;
/*     */       }
/*     */     }
/* 157 */     int mapCfgId = position.getMapCfgid();
/* 158 */     if (HomelandInterface.isYardMap(mapCfgId))
/*     */     {
/* 160 */       xChildInfo.setHome_state(2);
/*     */     }
/* 162 */     else if (HomelandInterface.isRoomMap(mapCfgId))
/*     */     {
/* 164 */       xChildInfo.setHome_state(1);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 169 */       onMoveChildHomeFail(9);
/* 170 */       return false;
/*     */     }
/*     */     
/* 173 */     if (!MapInterface.isReachable(mapCfgId, position.getX(), position.getY()))
/*     */     {
/* 175 */       onMoveChildHomeFail(54);
/* 176 */       new PRecordChildWrongPosition(userId, this.roleId, marriedRoleId, this.childId, mapCfgId, position.getX(), position.getY()).execute();
/*     */       
/* 178 */       return false;
/*     */     }
/*     */     
/* 181 */     xBagChildIdList.remove(Long.valueOf(this.childId));
/* 182 */     xChildInfo.setCarry_role_id(-1L);
/* 183 */     xChildInfo.setPosition_x(position.getX());
/* 184 */     xChildInfo.setPosition_y(position.getY());
/*     */     
/* 186 */     AddChildIntoHomeArg addChildIntoHomeArg = new AddChildIntoHomeArg(this.roleId, this.childId, mapCfgId, position.getX(), position.getY(), mzm.gsp.children.event.ChildAddHomeReason.BAG_TO_HOME);
/*     */     
/*     */ 
/*     */ 
/* 190 */     ChildrenManager.trigChildrenEvent(new AddChildIntoHome(), addChildIntoHomeArg);
/*     */     
/* 192 */     if (xRole2ChildrenInfo.getShow_child_id() == this.childId)
/*     */     {
/* 194 */       xRole2ChildrenInfo.setShow_child_id(-1L);
/* 195 */       xRole2ChildrenInfo.setShow_child_period(0);
/*     */       
/* 197 */       ChildrenManager.trigChildrenEvent(new ChildShowModelChange(), new ChildShowModelChangeArg(this.roleId, ChildShowModelChangeReason.REMOVE));
/*     */     }
/*     */     
/*     */ 
/* 201 */     ChildrenManager.tlogChildOperator(userId, this.roleId, this.childId, 1, 0);
/*     */     
/* 203 */     SMoveChildHomeSuccess sMoveChildHomeSuccess = new SMoveChildHomeSuccess();
/* 204 */     sMoveChildHomeSuccess.child_id = this.childId;
/* 205 */     OnlineManager.getInstance().send(this.roleId, sMoveChildHomeSuccess);
/*     */     
/* 207 */     GameServer.logger().info(String.format("[children]PCMoveChildHome.processImp@move child home success|role_id=%d|child_id=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.childId) }));
/*     */     
/*     */ 
/* 210 */     return true;
/*     */   }
/*     */   
/*     */   private void onMoveChildHomeFail(int ret)
/*     */   {
/* 215 */     onMoveChildHomeFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onMoveChildHomeFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 220 */     StringBuilder sbLog = new StringBuilder();
/* 221 */     sbLog.append("[children]PCMoveChildHome.processImp@move child home failed");
/* 222 */     sbLog.append("|ret=").append(ret);
/* 223 */     sbLog.append("|role_id=").append(this.roleId);
/* 224 */     sbLog.append("|child_id=").append(this.childId);
/* 225 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 227 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 229 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 232 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 234 */     SChildNormalFail sChildNormalFail = new SChildNormalFail();
/* 235 */     sChildNormalFail.result = ret;
/*     */     
/* 237 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sChildNormalFail);
/*     */   }
/*     */   
/*     */   private static class PRecordChildWrongPosition
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final String userId;
/*     */     private final long roleId;
/*     */     private final long partnerRoleId;
/*     */     private final long childId;
/*     */     private final int mapCfgId;
/*     */     private final int positionX;
/*     */     private final int positionY;
/*     */     
/*     */     public PRecordChildWrongPosition(String userId, long roleId, long partnerRoleId, long childId, int mapCfgId, int positionX, int positionY)
/*     */     {
/* 253 */       this.userId = userId;
/* 254 */       this.roleId = roleId;
/* 255 */       this.partnerRoleId = partnerRoleId;
/* 256 */       this.childId = childId;
/* 257 */       this.mapCfgId = mapCfgId;
/* 258 */       this.positionX = positionX;
/* 259 */       this.positionY = positionY;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 265 */       tlogChildWrongPosition(this.userId, this.roleId, this.partnerRoleId, this.childId, this.mapCfgId, this.positionX, this.positionY);
/* 266 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     private void tlogChildWrongPosition(String userId, long roleId, long partnerRoleId, long childId, int mapCfgId, int positionX, int positionY)
/*     */     {
/* 272 */       int roleLevel = RoleInterface.getLevel(roleId);
/*     */       
/* 274 */       StringBuilder sbLog = new StringBuilder();
/* 275 */       sbLog.append(mzm.gsp.GameServerInfoManager.getHostIP()).append('|');
/* 276 */       sbLog.append(userId).append('|');
/* 277 */       sbLog.append(roleId).append('|');
/* 278 */       sbLog.append(roleLevel).append('|');
/*     */       
/* 280 */       sbLog.append(partnerRoleId).append('|');
/*     */       
/* 282 */       sbLog.append(mapCfgId).append('|');
/* 283 */       sbLog.append(positionX).append('|');
/* 284 */       sbLog.append(positionY).append('|');
/* 285 */       sbLog.append(childId);
/*     */       
/* 287 */       TLogManager.getInstance().addLog(roleId, "ChildPositionWrongStatis", sbLog.toString());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCMoveChildHome.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */