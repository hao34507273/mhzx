/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SChildNormalFail;
/*     */ import mzm.gsp.children.SChildShowSuccess;
/*     */ import mzm.gsp.children.event.ChildShowModelChange;
/*     */ import mzm.gsp.children.event.ChildShowModelChangeArg;
/*     */ import mzm.gsp.children.event.ChildShowModelChangeReason;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChildInfo;
/*     */ import xbean.Role2ChildrenInfo;
/*     */ import xtable.Role2children;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCChildShow extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long childId;
/*     */   private final int childPeriod;
/*     */   
/*     */   public PCChildShow(long roleId, long childId, int childPeriod)
/*     */   {
/*  28 */     this.roleId = roleId;
/*  29 */     this.childId = childId;
/*  30 */     this.childPeriod = childPeriod;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleId))
/*     */     {
/*  38 */       return false;
/*     */     }
/*     */     
/*  41 */     if (!ChildrenManager.isFunOpen(this.roleId))
/*     */     {
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     if (!ChildrenManager.canDoAction(this.roleId, 837))
/*     */     {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  52 */     lock(xdb.Lockeys.get(User.getTable(), userId));
/*     */     
/*  54 */     Role2ChildrenInfo xRole2ChildrenInfo = Role2children.get(Long.valueOf(this.roleId));
/*  55 */     if (xRole2ChildrenInfo == null)
/*     */     {
/*  57 */       onChildShowFail(4);
/*  58 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  62 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 902, true, true))
/*     */     {
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     List<Long> xChildBagIdList = xRole2ChildrenInfo.getChild_bag_id_list();
/*  68 */     if (!xChildBagIdList.contains(Long.valueOf(this.childId)))
/*     */     {
/*  70 */       onChildShowFail(5);
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(this.childId));
/*  75 */     if (xChildInfo == null)
/*     */     {
/*  77 */       onChildShowFail(2);
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     if (!ChildrenManager.checkChildrenDiscardOnOperate(this.roleId, xChildInfo))
/*     */     {
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     if ((xChildInfo.getOwn_role_id() != this.roleId) && (xChildInfo.getAnother_parent_role_id() != this.roleId))
/*     */     {
/*  88 */       onChildShowFail(1);
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     if (xChildInfo.getChild_period() < this.childPeriod)
/*     */     {
/*  94 */       onChildShowFail(7);
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     xRole2ChildrenInfo.setShow_child_id(this.childId);
/*  99 */     xRole2ChildrenInfo.setShow_child_period(this.childPeriod);
/*     */     
/* 101 */     PetInterface.hidePet(this.roleId, false);
/*     */     
/* 103 */     ChildrenManager.trigChildrenEvent(new ChildShowModelChange(), new ChildShowModelChangeArg(this.roleId, ChildShowModelChangeReason.ADD));
/*     */     
/*     */ 
/* 106 */     ChildrenManager.tlogChildOperator(userId, this.roleId, this.childId, 2, 0);
/*     */     
/* 108 */     SChildShowSuccess sChildShowSuccess = new SChildShowSuccess();
/* 109 */     sChildShowSuccess.child_id = this.childId;
/* 110 */     sChildShowSuccess.child_period = this.childPeriod;
/*     */     
/* 112 */     OnlineManager.getInstance().send(this.roleId, sChildShowSuccess);
/*     */     
/* 114 */     GameServer.logger().info(String.format("[children]PCChildShow.processImp@handle child show success|role_id=%d|child_id=%d|child_period=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.childId), Integer.valueOf(this.childPeriod) }));
/*     */     
/*     */ 
/*     */ 
/* 118 */     return true;
/*     */   }
/*     */   
/*     */   private void onChildShowFail(int ret)
/*     */   {
/* 123 */     onChildShowFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onChildShowFail(int ret, Map<String, ?> extraMap)
/*     */   {
/* 128 */     StringBuilder sbLog = new StringBuilder();
/* 129 */     sbLog.append("[children]PCChildShow.processImp@child show failed");
/* 130 */     sbLog.append("|ret=").append(ret);
/* 131 */     sbLog.append("|role_id=").append(this.roleId);
/* 132 */     sbLog.append("|child_id=").append(this.childId);
/* 133 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 135 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 137 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 140 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 142 */     SChildNormalFail sChildNormalFail = new SChildNormalFail();
/* 143 */     sChildNormalFail.result = ret;
/*     */     
/* 145 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sChildNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCChildShow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */