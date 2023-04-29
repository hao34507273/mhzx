/*     */ package mzm.gsp.interactivetask.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.children.main.ChildrenInterface;
/*     */ import mzm.gsp.interactivetask.SReceiveInviteStartTaskRes;
/*     */ import mzm.gsp.interactivetask.confbean.SInteractiveTaskCfg;
/*     */ import mzm.gsp.interactivetask.confbean.SInteractiveTaskTypeCfg;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.InteractivetaskInfo;
/*     */ 
/*     */ public class PSendInviteStartTaskReq extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int typeid;
/*     */   private final int graphid;
/*     */   
/*     */   public PSendInviteStartTaskReq(long roleid, int typeid, int graphid)
/*     */   {
/*  25 */     this.roleid = roleid;
/*  26 */     this.typeid = typeid;
/*  27 */     this.graphid = graphid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     SInteractiveTaskTypeCfg s = SInteractiveTaskTypeCfg.get(this.typeid);
/*  34 */     if (s == null)
/*     */     {
/*  36 */       return false;
/*     */     }
/*  38 */     SInteractiveTaskCfg sInteractiveTaskCfg = SInteractiveTaskCfg.get(this.typeid);
/*  39 */     if (sInteractiveTaskCfg == null)
/*     */     {
/*  41 */       return false;
/*     */     }
/*  43 */     if (!sInteractiveTaskCfg.graphids.contains(Integer.valueOf(this.graphid)))
/*     */     {
/*  45 */       return false;
/*     */     }
/*  47 */     if (!ChildrenInterface.isCanGiveBirth(this.roleid))
/*     */     {
/*  49 */       String log = String.format("[interactivetask]PSendInviteStartTaskReq.processImp@role can not join interactive task|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*     */ 
/*  52 */       InteractiveTaskManager.logger.info(log);
/*  53 */       InteractiveTaskManager.sendSErrorInfo(this.roleid, 4, this.typeid);
/*  54 */       return false;
/*     */     }
/*  56 */     if (!mzm.gsp.status.main.RoleStatusInterface.containsStatus(this.roleid, 650))
/*     */     {
/*  58 */       String log = String.format("[interactivetask]PSendInviteStartTaskReq.processImp@role not contains interactive task status|roleid=%d|graphid=%d|typeid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.graphid), Integer.valueOf(this.typeid) });
/*     */       
/*     */ 
/*  61 */       InteractiveTaskManager.logger.warn(log);
/*  62 */       return false;
/*     */     }
/*  64 */     InteractivetaskInfo xInteractivetaskInfo = InteractiveTaskManager.getXInteractivetask(this.roleid, this.typeid);
/*  65 */     if (xInteractivetaskInfo == null)
/*     */     {
/*  67 */       String log = String.format("[interactivetask]PSendInviteStartTaskReq.processImp@xInteractivetaskInfo is null|roleid=%d|graphid=%d|typeid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.graphid), Integer.valueOf(this.typeid) });
/*     */       
/*     */ 
/*  70 */       InteractiveTaskManager.logger.warn(log);
/*  71 */       return false;
/*     */     }
/*  73 */     long worldid = xInteractivetaskInfo.getWorldid();
/*  74 */     long roleWorld = MapInterface.getRoleWorldInstanceId(this.roleid);
/*  75 */     if (roleWorld != worldid)
/*     */     {
/*  77 */       String log = String.format("[interactivetask]PSendInviteStartTaskReq.processImp@role not in this world|roleid=%d|graphid=%d|typeid=%d|worldid=%d|roleWorld=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.graphid), Integer.valueOf(this.typeid), Long.valueOf(worldid), Long.valueOf(roleWorld) });
/*     */       
/*     */ 
/*  80 */       InteractiveTaskManager.logger.warn(log);
/*  81 */       return false;
/*     */     }
/*  83 */     if (xInteractivetaskInfo.getFinished_graphids().contains(Integer.valueOf(this.graphid)))
/*     */     {
/*  85 */       InteractiveTaskManager.sendSErrorInfo(this.roleid, 3, this.typeid);
/*  86 */       return false;
/*     */     }
/*  88 */     if (xInteractivetaskInfo.getCurrent_graphid() == this.graphid)
/*     */     {
/*  90 */       InteractiveTaskManager.sendSErrorInfo(this.roleid, 2, this.typeid);
/*  91 */       return false;
/*     */     }
/*  93 */     if (xInteractivetaskInfo.getCurrent_graphid() != 0)
/*     */     {
/*  95 */       String log = String.format("[interactivetask]PSendInviteStartTaskReq.processImp@current graph is not finished|roleid=%d|commander_roleid=%d|graphid=%d|typeid=%d|cur_graphid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(xInteractivetaskInfo.getCommander_roleid()), Integer.valueOf(this.graphid), Integer.valueOf(this.typeid), Integer.valueOf(xInteractivetaskInfo.getCurrent_graphid()) });
/*     */       
/*     */ 
/*     */ 
/*  99 */       InteractiveTaskManager.logger.warn(log);
/* 100 */       return false;
/*     */     }
/* 102 */     if (xInteractivetaskInfo.getCommander_roleid() != this.roleid)
/*     */     {
/* 104 */       String log = String.format("[interactivetask]PSendInviteStartTaskReq.processImp@role is not commander|roleid=%d|commander_roleid=%d|graphid=%d|typeid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(xInteractivetaskInfo.getCommander_roleid()), Integer.valueOf(this.graphid), Integer.valueOf(this.typeid) });
/*     */       
/*     */ 
/* 107 */       InteractiveTaskManager.logger.warn(log);
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     if (sInteractiveTaskCfg.hasSeq)
/*     */     {
/* 113 */       int i = sInteractiveTaskCfg.graphids.indexOf(Integer.valueOf(this.graphid));
/* 114 */       if (i == -1)
/*     */       {
/* 116 */         return false;
/*     */       }
/* 118 */       if (i > 0)
/*     */       {
/* 120 */         if (((Integer)xInteractivetaskInfo.getFinished_graphids().get(i - 1)).intValue() != ((Integer)sInteractiveTaskCfg.graphids.get(i - 1)).intValue())
/*     */         {
/* 122 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 127 */     SReceiveInviteStartTaskRes res = new SReceiveInviteStartTaskRes();
/* 128 */     res.graphid = this.graphid;
/* 129 */     res.typeid = this.typeid;
/* 130 */     Set<Long> roleSet = new java.util.HashSet();
/* 131 */     roleSet.addAll(xInteractivetaskInfo.getRoleids());
/* 132 */     roleSet.remove(Long.valueOf(this.roleid));
/* 133 */     for (Iterator i$ = roleSet.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */       
/* 135 */       if (!OnlineManager.getInstance().isOnline(r))
/*     */       {
/* 137 */         InteractiveTaskManager.sendSErrorInfo(this.roleid, 1, this.typeid);
/* 138 */         return false;
/*     */       }
/*     */     }
/* 141 */     OnlineManager.getInstance().sendMulti(res, roleSet);
/* 142 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interactivetask\main\PSendInviteStartTaskReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */