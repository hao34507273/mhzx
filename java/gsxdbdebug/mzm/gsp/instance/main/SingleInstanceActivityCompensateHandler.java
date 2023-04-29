/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activitycompensate.main.ActivityCompensateHandler;
/*    */ import mzm.gsp.instance.confbean.SInstanceCfg;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.InstanceBean;
/*    */ import xbean.SingleInstance;
/*    */ import xtable.Role2instance;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SingleInstanceActivityCompensateHandler
/*    */   implements ActivityCompensateHandler
/*    */ {
/*    */   public int getCompensateAwardTimes(long roleid, int count, int activityid)
/*    */   {
/* 22 */     int instanceCfgid = -1;
/* 23 */     int level = RoleInterface.getLevel(roleid);
/* 24 */     for (SInstanceCfg cfg : SInstanceCfg.getAll().values())
/*    */     {
/* 26 */       if ((cfg.instanceType == 1) && 
/*    */       
/*    */ 
/*    */ 
/* 30 */         ((cfg.level <= 0) || (level >= cfg.level)) && (
/*    */         
/*    */ 
/*    */ 
/* 34 */         (cfg.closeLevel <= 0) || (level < cfg.closeLevel)))
/*    */       {
/*    */ 
/*    */ 
/* 38 */         instanceCfgid = cfg.id;
/*    */       }
/*    */     }
/* 41 */     if (instanceCfgid <= 0)
/*    */     {
/* 43 */       return 0;
/*    */     }
/* 45 */     SInstanceCfg cfg = SInstanceCfg.get(instanceCfgid);
/* 46 */     if (cfg == null)
/*    */     {
/* 48 */       return 0;
/*    */     }
/* 50 */     InstanceBean xInstanceBean = Role2instance.get(Long.valueOf(roleid));
/* 51 */     if (xInstanceBean == null)
/*    */     {
/* 53 */       return cfg.finishTime;
/*    */     }
/* 55 */     SingleInstance xSingleInstance = (SingleInstance)xInstanceBean.getSingleinstancemap().get(Integer.valueOf(instanceCfgid));
/* 56 */     if (xSingleInstance == null)
/*    */     {
/* 58 */       return cfg.finishTime;
/*    */     }
/* 60 */     if (xSingleInstance.getSign() == 0)
/*    */     {
/* 62 */       return 0;
/*    */     }
/* 64 */     if (xSingleInstance.getCurprocess() > 1)
/*    */     {
/* 66 */       return Math.max(0, cfg.finishTime - xSingleInstance.getFinishtimes() - 1);
/*    */     }
/* 68 */     return Math.max(0, cfg.finishTime - xSingleInstance.getFinishtimes());
/*    */   }
/*    */   
/*    */ 
/*    */   public List<Integer> getActivitySwitchList(int activityid)
/*    */   {
/* 74 */     List<Integer> switches = new ArrayList();
/* 75 */     switches.add(Integer.valueOf(4));
/* 76 */     return switches;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\SingleInstanceActivityCompensateHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */