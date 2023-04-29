/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SCancelChildShowSuccess;
/*     */ import mzm.gsp.children.SChildNormalFail;
/*     */ import mzm.gsp.children.event.ChildShowModelChange;
/*     */ import mzm.gsp.children.event.ChildShowModelChangeArg;
/*     */ import mzm.gsp.children.event.ChildShowModelChangeReason;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Role2ChildrenInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2children;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCCancelChildShow extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PCCancelChildShow(long roleId)
/*     */   {
/*  24 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  30 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.roleId))
/*     */     {
/*  32 */       onCancelChildShowFail(21);
/*  33 */       return false;
/*     */     }
/*     */     
/*  36 */     if (!ChildrenManager.isFunOpen(this.roleId))
/*     */     {
/*  38 */       return false;
/*     */     }
/*     */     
/*  41 */     if (!ChildrenManager.canDoAction(this.roleId, 833))
/*     */     {
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  47 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*     */ 
/*  50 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 902, true))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     Role2ChildrenInfo xRole2ChildrenInfo = Role2children.get(Long.valueOf(this.roleId));
/*  56 */     if (xRole2ChildrenInfo == null)
/*     */     {
/*  58 */       onCancelChildShowFail(4);
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     if (xRole2ChildrenInfo.getShow_child_id() == -1L)
/*     */     {
/*  64 */       onCancelChildShowFail(4);
/*  65 */       return false;
/*     */     }
/*  67 */     int oldShowChildId = xRole2ChildrenInfo.getShow_child_period();
/*     */     
/*  69 */     xRole2ChildrenInfo.setShow_child_id(-1L);
/*  70 */     xRole2ChildrenInfo.setShow_child_period(0);
/*     */     
/*  72 */     ChildrenManager.trigChildrenEvent(new ChildShowModelChange(), new ChildShowModelChangeArg(this.roleId, ChildShowModelChangeReason.REMOVE));
/*     */     
/*     */ 
/*  75 */     ChildrenManager.tlogChildOperator(userId, this.roleId, oldShowChildId, 3, 0);
/*     */     
/*  77 */     SCancelChildShowSuccess sCancelChildShowSuccess = new SCancelChildShowSuccess();
/*  78 */     OnlineManager.getInstance().send(this.roleId, sCancelChildShowSuccess);
/*     */     
/*  80 */     GameServer.logger().info(String.format("[children]PCCancelChildShow.processImp@handle cancel child show success|role_id=%d|old_child_show=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(oldShowChildId) }));
/*     */     
/*     */ 
/*     */ 
/*  84 */     return true;
/*     */   }
/*     */   
/*     */   private void onCancelChildShowFail(int ret)
/*     */   {
/*  89 */     onCancelChildShowFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onCancelChildShowFail(int ret, Map<String, ?> extraMap)
/*     */   {
/*  94 */     StringBuilder sbLog = new StringBuilder();
/*  95 */     sbLog.append("[children]PCCancelChildShow.processImp@cancel child show failed");
/*  96 */     sbLog.append("|ret=").append(ret);
/*  97 */     sbLog.append("|role_id=").append(this.roleId);
/*  98 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 100 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 102 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 105 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 107 */     SChildNormalFail sChildNormalFail = new SChildNormalFail();
/* 108 */     sChildNormalFail.result = ret;
/*     */     
/* 110 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sChildNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCCancelChildShow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */