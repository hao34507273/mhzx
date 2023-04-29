/*    */ package mzm.gsp.interactivetask.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.interactivetask.confbean.SInteractiveTaskTypeCfg;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.InteractivetaskInfo;
/*    */ import xbean.InteractivetaskMap;
/*    */ import xtable.Role2interactivetask;
/*    */ 
/*    */ public class PQuitInteractiveTaskReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int typeid;
/*    */   
/*    */   public PQuitInteractiveTaskReq(long roleid, int typeid)
/*    */   {
/* 17 */     this.roleid = roleid;
/* 18 */     this.typeid = typeid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     SInteractiveTaskTypeCfg s = SInteractiveTaskTypeCfg.get(this.typeid);
/* 25 */     if (s == null)
/*    */     {
/* 27 */       return false;
/*    */     }
/* 29 */     InteractivetaskMap xInteractivetaskMap = Role2interactivetask.select(Long.valueOf(this.roleid));
/* 30 */     if (xInteractivetaskMap == null)
/*    */     {
/* 32 */       String log = String.format("[interactivetask]PQuitInteractiveTaskReq.processImp@xInteractivetaskMap is null|roleid=%d|typeid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.typeid) });
/*    */       
/*    */ 
/* 35 */       InteractiveTaskManager.logger.warn(log);
/* 36 */       return false;
/*    */     }
/* 38 */     InteractivetaskInfo xInteractivetaskInfo = (InteractivetaskInfo)xInteractivetaskMap.getTypeid2task().get(Integer.valueOf(this.typeid));
/* 39 */     if (xInteractivetaskInfo == null)
/*    */     {
/* 41 */       String log = String.format("[interactivetask]PQuitInteractiveTaskReq.processImp@xInteractivetaskInfo is null|roleid=%d|typeid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.typeid) });
/*    */       
/*    */ 
/* 44 */       InteractiveTaskManager.logger.warn(log);
/* 45 */       return false;
/*    */     }
/* 47 */     xdb.Lockeys.lock(Role2interactivetask.getTable(), xInteractivetaskInfo.getRoleids());
/* 48 */     InteractiveTaskManager.leaveFuben(this.typeid, new ArrayList(xInteractivetaskInfo.getRoleids()));
/* 49 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interactivetask\main\PQuitInteractiveTaskReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */