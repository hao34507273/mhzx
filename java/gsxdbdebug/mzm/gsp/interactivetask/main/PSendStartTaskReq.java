/*     */ package mzm.gsp.interactivetask.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.interactivetask.SReceiveStartTaskRes;
/*     */ import mzm.gsp.interactivetask.confbean.SInteractiveTaskCfg;
/*     */ import mzm.gsp.interactivetask.confbean.SInteractiveTaskTypeCfg;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.InteractivetaskInfo;
/*     */ import xbean.InteractivetaskMap;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2interactivetask;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PSendStartTaskReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int typeid;
/*     */   private final int graphid;
/*     */   private final int result;
/*     */   
/*     */   public PSendStartTaskReq(long roleid, int typeid, int graphid, int reuslt)
/*     */   {
/*  29 */     this.roleid = roleid;
/*  30 */     this.typeid = typeid;
/*  31 */     this.graphid = graphid;
/*  32 */     this.result = reuslt;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     SInteractiveTaskTypeCfg s = SInteractiveTaskTypeCfg.get(this.typeid);
/*  39 */     if (s == null)
/*     */     {
/*  41 */       return false;
/*     */     }
/*  43 */     SInteractiveTaskCfg sInteractiveTaskCfg = SInteractiveTaskCfg.get(this.typeid);
/*  44 */     if (sInteractiveTaskCfg == null)
/*     */     {
/*  46 */       return false;
/*     */     }
/*  48 */     if (!sInteractiveTaskCfg.graphids.contains(Integer.valueOf(this.graphid)))
/*     */     {
/*  50 */       return false;
/*     */     }
/*  52 */     InteractivetaskMap xInteractivetaskMap = Role2interactivetask.select(Long.valueOf(this.roleid));
/*  53 */     if (xInteractivetaskMap == null)
/*     */     {
/*  55 */       String log = String.format("[interactivetask]PSendStartTaskReq.processImp@xInteractivetaskMap is null|roleid=%d|graphid=%d|typeid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.graphid), Integer.valueOf(this.typeid) });
/*     */       
/*     */ 
/*  58 */       InteractiveTaskManager.logger.warn(log);
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     InteractivetaskInfo xInteractivetaskInfo = (InteractivetaskInfo)xInteractivetaskMap.getTypeid2task().get(Integer.valueOf(this.typeid));
/*  63 */     if (xInteractivetaskInfo == null)
/*     */     {
/*  65 */       String log = String.format("[interactivetask]PSendStartTaskReq.processImp@xInteractivetaskInfo is null|roleid=%d|graphid=%d|typeid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.graphid), Integer.valueOf(this.typeid) });
/*     */       
/*     */ 
/*  68 */       InteractiveTaskManager.logger.warn(log);
/*  69 */       return false;
/*     */     }
/*  71 */     List<String> userList = new ArrayList();
/*  72 */     for (Iterator i$ = xInteractivetaskInfo.getRoleids().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/*  74 */       String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/*  75 */       userList.add(userid);
/*     */     }
/*  77 */     Lockeys.lock(User.getTable(), userList);
/*  78 */     Lockeys.lock(Role2interactivetask.getTable(), xInteractivetaskInfo.getRoleids());
/*  79 */     if (!mzm.gsp.status.main.RoleStatusInterface.containsStatus(this.roleid, 650))
/*     */     {
/*  81 */       String log = String.format("[interactivetask]PSendStartTaskReq.processImp@role not contains interactive task status|roleid=%d|graphid=%d|commander_roleid=%d|typeid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.graphid), Long.valueOf(xInteractivetaskInfo.getCommander_roleid()), Integer.valueOf(this.typeid) });
/*     */       
/*     */ 
/*  84 */       InteractiveTaskManager.logger.warn(log);
/*  85 */       return false;
/*     */     }
/*  87 */     if (!mzm.gsp.children.main.ChildrenInterface.isCanGiveBirth(this.roleid))
/*     */     {
/*  89 */       String log = String.format("[interactivetask]PSendStartTaskReq.processImp@role can not join interactive task|roleid=%d|graphid=%d|commander_roleid=%d|typeid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.graphid), Long.valueOf(xInteractivetaskInfo.getCommander_roleid()), Integer.valueOf(this.typeid) });
/*     */       
/*     */ 
/*  92 */       InteractiveTaskManager.logger.info(log);
/*  93 */       InteractiveTaskManager.sendSErrorInfo(this.roleid, 4, this.typeid);
/*  94 */       return false;
/*     */     }
/*  96 */     xInteractivetaskInfo = InteractiveTaskManager.getXInteractivetask(this.roleid, this.typeid);
/*  97 */     if (xInteractivetaskInfo == null)
/*     */     {
/*  99 */       String log = String.format("[interactivetask]PSendStartTaskReq.processImp@xInteractivetaskInfo is null|roleid=%d|graphid=%d|typeid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.graphid), Integer.valueOf(this.typeid) });
/*     */       
/*     */ 
/* 102 */       InteractiveTaskManager.logger.warn(log);
/* 103 */       return false;
/*     */     }
/* 105 */     if (xInteractivetaskInfo.getFinished_graphids().contains(Integer.valueOf(this.graphid)))
/*     */     {
/* 107 */       String log = String.format("[interactivetask]PSendStartTaskReq.processImp@graph is finished|roleid=%d|commander_roleid=%d|graphid=%d|typeid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(xInteractivetaskInfo.getCommander_roleid()), Integer.valueOf(this.graphid), Integer.valueOf(this.typeid) });
/*     */       
/*     */ 
/* 110 */       InteractiveTaskManager.logger.warn(log);
/* 111 */       return false;
/*     */     }
/* 113 */     if (xInteractivetaskInfo.getCurrent_graphid() == this.graphid)
/*     */     {
/* 115 */       String log = String.format("[interactivetask]PSendStartTaskReq.processImp@graph is doing|roleid=%d|commander_roleid=%d|graphid=%d|typeid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(xInteractivetaskInfo.getCommander_roleid()), Integer.valueOf(this.graphid), Integer.valueOf(this.typeid) });
/*     */       
/*     */ 
/* 118 */       InteractiveTaskManager.logger.warn(log);
/* 119 */       return false;
/*     */     }
/* 121 */     if (xInteractivetaskInfo.getCommander_roleid() == this.roleid)
/*     */     {
/* 123 */       String log = String.format("[interactivetask]PSendStartTaskReq.processImp@role is commander|roleid=%d|commander_roleid=%d|graphid=%d|typeid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(xInteractivetaskInfo.getCommander_roleid()), Integer.valueOf(this.graphid), Integer.valueOf(this.typeid) });
/*     */       
/*     */ 
/* 126 */       InteractiveTaskManager.logger.warn(log);
/* 127 */       return false;
/*     */     }
/* 129 */     long worldid = xInteractivetaskInfo.getWorldid();
/* 130 */     long roleWorld = MapInterface.getRoleWorldInstanceId(this.roleid);
/* 131 */     if (roleWorld != worldid)
/*     */     {
/* 133 */       String log = String.format("[interactivetask]PSendStartTaskReq.processImp@role not in this world|roleid=%d|graphid=%d|typeid=%d|worldid=%d|roleWorld=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.graphid), Integer.valueOf(this.typeid), Long.valueOf(worldid), Long.valueOf(roleWorld) });
/*     */       
/*     */ 
/* 136 */       InteractiveTaskManager.logger.warn(log);
/* 137 */       return false;
/*     */     }
/* 139 */     SReceiveStartTaskRes res = new SReceiveStartTaskRes();
/* 140 */     res.graphid = this.graphid;
/* 141 */     res.typeid = this.typeid;
/* 142 */     res.result = this.result;
/*     */     Iterator i$;
/* 144 */     if (this.result == 1)
/*     */     {
/* 146 */       xInteractivetaskInfo.setCurrent_graphid(this.graphid);
/* 147 */       for (i$ = xInteractivetaskInfo.getRoleids().iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */         
/* 149 */         if (r != this.roleid)
/*     */         {
/*     */ 
/*     */ 
/* 153 */           InteractivetaskInfo xInteractivetaskInfo2 = InteractiveTaskManager.getXInteractivetask(r, this.typeid);
/* 154 */           xInteractivetaskInfo2.setCurrent_graphid(this.graphid);
/*     */         }
/*     */       }
/*     */     }
/*     */     else {
/* 159 */       String log = String.format("[interactivetask]PSendStartTaskReq.processImp@role refused do this task|roleid=%d|graphid=%d|commander_roleid=%d|typeid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.graphid), Long.valueOf(xInteractivetaskInfo.getCommander_roleid()), Integer.valueOf(this.typeid) });
/*     */       
/*     */ 
/* 162 */       InteractiveTaskManager.logger.info(log);
/* 163 */       OnlineManager.getInstance().sendAtOnce(xInteractivetaskInfo.getCommander_roleid(), res);
/* 164 */       return false;
/*     */     }
/* 166 */     boolean ret = TaskInterface.activeGraph(Long.valueOf(this.roleid), this.graphid);
/* 167 */     if (ret)
/*     */     {
/* 169 */       OnlineManager.getInstance().send(xInteractivetaskInfo.getCommander_roleid(), res);
/*     */       
/* 171 */       String log = String.format("[interactivetask]PSendStartTaskReq.processImp@role active graph success|roleid=%d|graphid=%d|commander_roleid=%d|typeid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.graphid), Long.valueOf(xInteractivetaskInfo.getCommander_roleid()), Integer.valueOf(this.typeid) });
/*     */       
/*     */ 
/* 174 */       InteractiveTaskManager.logger.info(log);
/*     */       
/* 176 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 180 */     String log = String.format("[interactivetask]PSendStartTaskReq.processImp@active graph error|roleid=%d|graphid=%d|commander_roleid=%d|typeid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.graphid), Long.valueOf(xInteractivetaskInfo.getCommander_roleid()), Integer.valueOf(this.typeid) });
/*     */     
/*     */ 
/* 183 */     InteractiveTaskManager.logger.error(log);
/* 184 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interactivetask\main\PSendStartTaskReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */