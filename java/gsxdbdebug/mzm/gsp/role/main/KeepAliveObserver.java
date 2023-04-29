/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.Properties;
/*    */ import xdb.Executor;
/*    */ import xdb.Xdb;
/*    */ import xtable.Role2properties;
/*    */ 
/*    */ public class KeepAliveObserver
/*    */   extends Observer
/*    */ {
/*    */   public KeepAliveObserver()
/*    */   {
/* 21 */     super(RoleCfgArgs.getInstance().intervalMin * 60);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 27 */     Xdb.executor().execute(new LogicRunnable()
/*    */     {
/*    */ 
/*    */       public void process()
/*    */         throws Exception
/*    */       {
/* 33 */         for (Iterator i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */           
/* 35 */           NoneRealTimeTaskManager.getInstance().addTask(new KeepAliveObserver.UpdateRoleKeepAliveTime(KeepAliveObserver.this, roleId));
/*    */         }
/*    */         
/*    */       }
/* 39 */     });
/* 40 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   class UpdateRoleKeepAliveTime
/*    */     extends LogicProcedure
/*    */   {
/*    */     private final long roleId;
/*    */     
/*    */ 
/*    */ 
/*    */     public UpdateRoleKeepAliveTime(long roleId)
/*    */     {
/* 55 */       this.roleId = roleId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 61 */       if (!OnlineManager.getInstance().isOnline(this.roleId))
/*    */       {
/* 63 */         return false;
/*    */       }
/*    */       
/* 66 */       Properties xProperties = Role2properties.get(Long.valueOf(this.roleId));
/* 67 */       xProperties.setKeeponlinetime(DateTimeUtils.getCurrTimeInMillis());
/* 68 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\KeepAliveObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */