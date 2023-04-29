/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SChangeChildNameSuccess;
/*     */ import mzm.gsp.children.SChildNormalFail;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.children.event.ChildNameChangeArg;
/*     */ import mzm.gsp.children.event.ChildShowModelChange;
/*     */ import mzm.gsp.children.event.ChildShowModelChangeArg;
/*     */ import mzm.gsp.children.event.ChildShowModelChangeReason;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.sensitive.main.SensitiveInterface;
/*     */ import mzm.gsp.server.main.AvailableStringArgs;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChildInfo;
/*     */ import xbean.Role2ChildrenInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Children;
/*     */ import xtable.Role2children;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCChangeChildName extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long childId;
/*     */   private final Octets childNewName;
/*     */   private String childNewNameStr;
/*     */   
/*     */   public PCChangeChildName(long roleId, long childId, Octets childNewName)
/*     */   {
/*  41 */     this.roleId = roleId;
/*  42 */     this.childId = childId;
/*  43 */     this.childNewName = childNewName;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  49 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleId))
/*     */     {
/*  51 */       onChangeChildNameFail(21);
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if (!ChildrenManager.isFunOpen(this.roleId))
/*     */     {
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     if (!ChildrenManager.canDoAction(this.roleId, 835))
/*     */     {
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     Role2ChildrenInfo xRole2ChildrenInfo = null;
/*  66 */     String userId = RoleInterface.getUserId(this.roleId);
/*     */     
/*  68 */     long marriedRoleId = MarriageInterface.getMarriedRoleid(this.roleId, false);
/*  69 */     if (marriedRoleId > 0L)
/*     */     {
/*  71 */       String marriedUserId = RoleInterface.getUserId(marriedRoleId);
/*  72 */       lock(User.getTable(), Arrays.asList(new String[] { userId, marriedUserId }));
/*  73 */       lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(marriedRoleId) }));
/*     */     }
/*     */     else
/*     */     {
/*  77 */       lock(Lockeys.get(User.getTable(), userId));
/*     */     }
/*  79 */     xRole2ChildrenInfo = Role2children.get(Long.valueOf(this.roleId));
/*     */     
/*  81 */     ChildInfo xChildInfo = Children.get(Long.valueOf(this.childId));
/*  82 */     if (xChildInfo == null)
/*     */     {
/*  84 */       onChangeChildNameFail(2);
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     if (!ChildrenManager.checkChildrenDiscardOnOperate(this.roleId, xChildInfo))
/*     */     {
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     if ((xChildInfo.getOwn_role_id() != this.roleId) && (xChildInfo.getAnother_parent_role_id() != this.roleId))
/*     */     {
/*  95 */       onChangeChildNameFail(1);
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     if ((xRole2ChildrenInfo != null) && (!xRole2ChildrenInfo.getChild_bag_id_list().contains(Long.valueOf(this.childId))) && (xChildInfo.getHome_state() == 0))
/*     */     {
/*     */ 
/* 102 */       onChangeChildNameFail(36);
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     this.childNewNameStr = this.childNewName.getString("UTF-8");
/* 107 */     int length = (int)Math.ceil(CommonUtils.getUTF16Length(this.childNewNameStr) / 2.0D);
/*     */     
/* 109 */     if ((length < SChildrenConsts.getInstance().change_name_min_length) || (length > SChildrenConsts.getInstance().change_name_max_length))
/*     */     {
/*     */ 
/* 112 */       onChangeChildNameFail(38);
/* 113 */       return false;
/*     */     }
/*     */     
/* 116 */     if (SensitiveInterface.isNameSensitive(this.childNewNameStr))
/*     */     {
/* 118 */       onChangeChildNameFail(39);
/* 119 */       return false;
/*     */     }
/*     */     
/* 122 */     if (!AvailableStringArgs.getInstance().isStringUsable(this.childNewNameStr))
/*     */     {
/* 124 */       onChangeChildNameFail(40);
/* 125 */       return false;
/*     */     }
/*     */     
/* 128 */     if (this.childNewNameStr.matches("\\d+"))
/*     */     {
/* 130 */       onChangeChildNameFail(41);
/* 131 */       return false;
/*     */     }
/*     */     
/* 134 */     boolean cutResult = RoleInterface.cutGold(this.roleId, SChildrenConsts.getInstance().change_name_cost_gold_value, new TLogArg(LogReason.CHILDREN_CHANGE_NAME_CUT_GOLD));
/*     */     
/* 136 */     if (!cutResult)
/*     */     {
/* 138 */       onChangeChildNameFail(42);
/* 139 */       return false;
/*     */     }
/* 141 */     String childOldNameStr = xChildInfo.getChild_name();
/* 142 */     xChildInfo.setChild_name(this.childNewNameStr);
/*     */     
/* 144 */     Map<Integer, String> stringParameterMap = new HashMap();
/* 145 */     stringParameterMap.put(Integer.valueOf(1), this.childNewNameStr);
/* 146 */     stringParameterMap.put(Integer.valueOf(0), childOldNameStr);
/* 147 */     ChildrenInterface.fillChildGrowthDiary(this.childId, null, stringParameterMap, 1);
/*     */     
/* 149 */     if ((xRole2ChildrenInfo != null) && (xRole2ChildrenInfo.getShow_child_id() == this.childId))
/*     */     {
/* 151 */       ChildrenManager.trigChildrenEvent(new ChildShowModelChange(), new ChildShowModelChangeArg(this.roleId, ChildShowModelChangeReason.CHANGE_NAME));
/*     */     }
/*     */     
/*     */ 
/* 155 */     ChildrenManager.tlogChildChangeName(userId, this.roleId, this.childId, childOldNameStr, this.childNewNameStr);
/*     */     
/* 157 */     ChildrenManager.trigChildrenEvent(new mzm.gsp.children.event.ChildNameChange(), new ChildNameChangeArg(this.roleId, this.childId));
/*     */     
/* 159 */     SChangeChildNameSuccess sChangeChildNameSuccess = new SChangeChildNameSuccess();
/* 160 */     sChangeChildNameSuccess.child_id = this.childId;
/* 161 */     sChangeChildNameSuccess.child_new_name = this.childNewName;
/*     */     
/* 163 */     if (marriedRoleId > 0L)
/*     */     {
/* 165 */       OnlineManager.getInstance().send(marriedRoleId, sChangeChildNameSuccess);
/*     */     }
/*     */     
/* 168 */     OnlineManager.getInstance().send(this.roleId, sChangeChildNameSuccess);
/*     */     
/* 170 */     GameServer.logger().info(String.format("[children]PCChangeChildName.processImp@change child name success|role_id=%d|child_id=%d|child_new_name=%s", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.childId), this.childNewNameStr }));
/*     */     
/*     */ 
/*     */ 
/* 174 */     return true;
/*     */   }
/*     */   
/*     */   private void onChangeChildNameFail(int ret)
/*     */   {
/* 179 */     onChangeChildNameFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onChangeChildNameFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 184 */     StringBuilder sbLog = new StringBuilder();
/* 185 */     sbLog.append("[children]PCChangeChildName.processImp@change child name failed");
/* 186 */     sbLog.append("|ret=").append(ret);
/* 187 */     sbLog.append("|role_id=").append(this.roleId);
/* 188 */     sbLog.append("|child_id=").append(this.childId);
/* 189 */     sbLog.append("|child_new_name").append(this.childNewNameStr);
/* 190 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 192 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 194 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 197 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 199 */     SChildNormalFail sChildNormalFail = new SChildNormalFail();
/* 200 */     sChildNormalFail.result = ret;
/*     */     
/* 202 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sChildNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCChangeChildName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */