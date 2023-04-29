/*     */ package mzm.gsp.interactivetask.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.children.main.ChildrenInterface;
/*     */ import mzm.gsp.interactivetask.SFinishTaskRes;
/*     */ import mzm.gsp.interactivetask.confbean.SGraphid2typeid;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.main.TaskEventArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import xbean.InteractivetaskInfo;
/*     */ import xbean.InteractivetaskMap;
/*     */ import xtable.Role2interactivetask;
/*     */ 
/*     */ public class POnInteractiveTaskChanged extends mzm.gsp.task.event.TaskStateChangeProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  23 */     SGraphid2typeid sGraphid2typeid = SGraphid2typeid.get(((TaskEventArg)this.arg).graphId);
/*     */     
/*  25 */     if (sGraphid2typeid == null)
/*     */     {
/*  27 */       return false;
/*     */     }
/*     */     
/*  30 */     switch (((TaskEventArg)this.arg).taskState)
/*     */     {
/*     */ 
/*     */     case 8: 
/*  34 */       if (!((TaskEventArg)this.arg).isToEnd)
/*     */       {
/*  36 */         return false;
/*     */       }
/*  38 */       SFinishTaskRes res = new SFinishTaskRes();
/*  39 */       res.graphid = ((TaskEventArg)this.arg).graphId;
/*  40 */       res.typeid = sGraphid2typeid.typeid;
/*     */       
/*  42 */       InteractivetaskMap xInteractivetaskMap = Role2interactivetask.select(Long.valueOf(((TaskEventArg)this.arg).roleId));
/*  43 */       if (xInteractivetaskMap == null)
/*     */       {
/*  45 */         return false;
/*     */       }
/*     */       
/*  48 */       InteractivetaskInfo xInteractivetaskInfo = (InteractivetaskInfo)xInteractivetaskMap.getTypeid2task().get(Integer.valueOf(sGraphid2typeid.typeid));
/*     */       
/*  50 */       if (xInteractivetaskInfo == null)
/*     */       {
/*  52 */         return false;
/*     */       }
/*  54 */       tlogInteractivetaskgraph(xInteractivetaskInfo.getCommander_roleid(), sGraphid2typeid.typeid, ((TaskEventArg)this.arg).graphId);
/*  55 */       List<Long> roleList = new ArrayList(xInteractivetaskInfo.getRoleids());
/*  56 */       xdb.Lockeys.lock(Role2interactivetask.getTable(), roleList);
/*  57 */       if (!ChildrenInterface.isCanGiveBirth(xInteractivetaskInfo.getCommander_roleid()))
/*     */       {
/*  59 */         String log = String.format("[interactivetask]POnInteractiveTaskChanged.processImp@role can not join interactive task|roleid=%d", new Object[] { Long.valueOf(xInteractivetaskInfo.getCommander_roleid()) });
/*     */         
/*     */ 
/*  62 */         InteractiveTaskManager.logger.info(log);
/*  63 */         InteractiveTaskManager.sendSErrorInfo(roleList, 4, sGraphid2typeid.typeid);
/*  64 */         return false;
/*     */       }
/*  66 */       boolean isFinished = false;
/*  67 */       for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */         
/*  69 */         InteractivetaskInfo xInteractivetaskInfo2 = InteractiveTaskManager.getXInteractivetask(r, sGraphid2typeid.typeid);
/*     */         
/*  71 */         xInteractivetaskInfo2.getFinished_graphids().add(Integer.valueOf(((TaskEventArg)this.arg).graphId));
/*  72 */         xInteractivetaskInfo2.setCurrent_graphid(0);
/*  73 */         if (xInteractivetaskInfo2.getCommander_roleid() == r)
/*     */         {
/*  75 */           isFinished = InteractiveTaskManager.isFinishedAllTask(sGraphid2typeid.typeid, xInteractivetaskInfo2);
/*     */         }
/*     */       }
/*     */       
/*  79 */       if (isFinished)
/*     */       {
/*  81 */         InteractiveTaskManager.triggerFinishEvent(roleList, true);
/*     */       }
/*  83 */       OnlineManager.getInstance().sendMulti(res, roleList);
/*  84 */       return true;
/*     */     
/*     */ 
/*     */     case 9: 
/*  88 */       return false;
/*     */     
/*     */     case 2: 
/*  91 */       return false; }
/*     */     
/*  93 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void tlogInteractivetaskgraph(long partnerRoleid, int typeid, int graphid)
/*     */   {
/* 100 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 101 */     String userid = RoleInterface.getUserId(((TaskEventArg)this.arg).roleId);
/* 102 */     int rolelevel = RoleInterface.getLevel(((TaskEventArg)this.arg).roleId);
/* 103 */     Object[] columnns = { vGameIP, userid, Long.valueOf(((TaskEventArg)this.arg).roleId), Integer.valueOf(rolelevel), Long.valueOf(partnerRoleid), Integer.valueOf(typeid), Integer.valueOf(graphid) };
/* 104 */     TLogManager.getInstance().addLog(((TaskEventArg)this.arg).roleId, "Interactivetaskgraph", columnns);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interactivetask\main\POnInteractiveTaskChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */