/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SCarryChildSuccess;
/*     */ import mzm.gsp.children.SChildNormalFail;
/*     */ import mzm.gsp.children.SSynChildrenAdulthoodInfoRes;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.children.event.RemoveChildFromHome;
/*     */ import mzm.gsp.children.event.RemoveChildFromHomeArg;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChildInfo;
/*     */ import xbean.Role2ChildrenInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Children;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCCarryChild extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long childId;
/*     */   
/*     */   public PCCarryChild(long roleId, long childId)
/*     */   {
/*  33 */     this.roleId = roleId;
/*  34 */     this.childId = childId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleId))
/*     */     {
/*  42 */       onCarryChildFail(21);
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     if (!ChildrenManager.isFunOpen(this.roleId))
/*     */     {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     if (!ChildrenManager.canDoAction(this.roleId, 834))
/*     */     {
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     String userId = RoleInterface.getUserId(this.roleId);
/*  57 */     long marriedRoleId = MarriageInterface.getMarriedRoleid(this.roleId);
/*     */     
/*  59 */     if (marriedRoleId > 0L)
/*     */     {
/*  61 */       String marriedRoleUserId = RoleInterface.getUserId(marriedRoleId);
/*  62 */       lock(User.getTable(), Arrays.asList(new String[] { userId, marriedRoleUserId }));
/*  63 */       lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(marriedRoleId) }));
/*     */     }
/*     */     else
/*     */     {
/*  67 */       lock(Lockeys.get(User.getTable(), userId));
/*     */     }
/*     */     
/*     */ 
/*  71 */     Role2ChildrenInfo xRole2ChildrenInfo = ChildrenManager.initAndGetChildrenInfo(this.roleId);
/*     */     
/*  73 */     ChildInfo xChildInfo = Children.get(Long.valueOf(this.childId));
/*  74 */     if (xChildInfo == null)
/*     */     {
/*  76 */       onCarryChildFail(2);
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     if (!ChildrenManager.checkChildrenDiscardOnOperate(this.roleId, xChildInfo))
/*     */     {
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     if ((xChildInfo.getOwn_role_id() != this.roleId) && (xChildInfo.getAnother_parent_role_id() != this.roleId))
/*     */     {
/*  87 */       onCarryChildFail(1);
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     if (xChildInfo.getHome_state() == 0)
/*     */     {
/*  93 */       onCarryChildFail(3);
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     List<Long> xChildBagIdList = xRole2ChildrenInfo.getChild_bag_id_list();
/*  98 */     if (xChildBagIdList.contains(Long.valueOf(this.childId)))
/*     */     {
/* 100 */       Map<String, String> extraMap = new HashMap();
/* 101 */       extraMap.put("bag_child_id_list", xChildBagIdList.toString());
/*     */       
/* 103 */       onCarryChildFail(37, extraMap);
/* 104 */       return false;
/*     */     }
/*     */     
/* 107 */     if (xChildBagIdList.size() >= SChildrenConsts.getInstance().max_children_can_carrey)
/*     */     {
/* 109 */       onCarryChildFail(49);
/* 110 */       return false;
/*     */     }
/*     */     
/* 113 */     xChildInfo.setHome_state(0);
/* 114 */     xChildInfo.setCarry_role_id(this.roleId);
/* 115 */     xChildBagIdList.add(Long.valueOf(this.childId));
/*     */     
/* 117 */     ChildrenManager.tlogChildOperator(userId, this.roleId, this.childId, 0, 0);
/*     */     
/*     */ 
/* 120 */     RemoveChildFromHomeArg removeChildFromHomeArg = new RemoveChildFromHomeArg(this.roleId, this.childId);
/* 121 */     ChildrenManager.trigChildrenEvent(new RemoveChildFromHome(), removeChildFromHomeArg);
/*     */     
/* 123 */     SCarryChildSuccess sCarryChildSuccess = new SCarryChildSuccess();
/* 124 */     sCarryChildSuccess.child_id = this.childId;
/*     */     
/* 126 */     OnlineManager.getInstance().send(this.roleId, sCarryChildSuccess);
/*     */     
/* 128 */     if (xChildInfo.getChild_period() == 2)
/*     */     {
/*     */ 
/* 131 */       ChildrenOutFightObj childrenOutFightObj = ChildrenManager.getChildrenOutFightObj(xChildInfo.getOwn_role_id(), this.childId, xChildInfo);
/*     */       
/* 133 */       childrenOutFightObj.initOwner();
/* 134 */       SSynChildrenAdulthoodInfoRes synChildrenAdulthoodInfoRes = new SSynChildrenAdulthoodInfoRes();
/* 135 */       ChildrenManager.fillAdulthoodInfo(xChildInfo.getOwn_role_id(), synChildrenAdulthoodInfoRes.adulthoodinfo, xChildInfo, childrenOutFightObj);
/*     */       
/* 137 */       synChildrenAdulthoodInfoRes.childrenid = this.childId;
/* 138 */       OnlineManager.getInstance().send(this.roleId, synChildrenAdulthoodInfoRes);
/*     */       
/* 140 */       long otherRoleid = xChildInfo.getOwn_role_id();
/* 141 */       if (this.roleId == xChildInfo.getOwn_role_id())
/*     */       {
/* 143 */         otherRoleid = xChildInfo.getAnother_parent_role_id();
/*     */       }
/* 145 */       if (otherRoleid > 0L)
/*     */       {
/* 147 */         ChildrenManager.asynRemChildOutFightData(otherRoleid, this.childId);
/*     */       }
/*     */     }
/*     */     
/* 151 */     GameServer.logger().info(String.format("[children]PCCarryChild.processImp@handle carry child success|role_id=%d|child_id=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.childId) }));
/*     */     
/*     */ 
/* 154 */     return true;
/*     */   }
/*     */   
/*     */   private void onCarryChildFail(int ret)
/*     */   {
/* 159 */     onCarryChildFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onCarryChildFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 164 */     StringBuilder sbLog = new StringBuilder();
/* 165 */     sbLog.append("[children]PCCarryChild.processImp@carry child failed");
/* 166 */     sbLog.append("|ret=").append(ret);
/* 167 */     sbLog.append("|role_id=").append(this.roleId);
/* 168 */     sbLog.append("|child_id=").append(this.childId);
/* 169 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 171 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 173 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 176 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 178 */     SChildNormalFail sChildNormalFail = new SChildNormalFail();
/* 179 */     sChildNormalFail.result = ret;
/*     */     
/* 181 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sChildNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCCarryChild.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */