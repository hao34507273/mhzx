/*    */ package mzm.gsp.jiuxiao.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.confbean.SJueZhanJiuXiaoCfg;
/*    */ import mzm.gsp.award.event.RoleSelectAwardArg;
/*    */ import mzm.gsp.jiuxiao.SJiuXiaoPreciousItemBrd;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ public class PJiuXiaoRoleSelectAward extends mzm.gsp.award.event.RoleSelectAwardProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     if ((((RoleSelectAwardArg)this.arg).context instanceof JiuXiaoMultiRoleAwardContext)) {
/* 15 */       JiuXiaoMultiRoleAwardContext jiuxiaoconAwardContext = (JiuXiaoMultiRoleAwardContext)((RoleSelectAwardArg)this.arg).context;
/* 16 */       if (mzm.gsp.itembulletin.main.ItemBulletinInterface.needBulletin(((RoleSelectAwardArg)this.arg).itemid))
/*    */       {
/* 18 */         SJueZhanJiuXiaoCfg jueZhanJiuXiaoCfg = JiuXiaoCfgManager.getJiuXiaoCfg(jiuxiaoconAwardContext.activityid, jiuxiaoconAwardContext.awardFloor);
/*    */         
/* 20 */         if (jueZhanJiuXiaoCfg != null) {
/* 21 */           SJiuXiaoPreciousItemBrd jiuXiaoPreciousItemBrd = new SJiuXiaoPreciousItemBrd();
/* 22 */           jiuXiaoPreciousItemBrd.item2num.put(Integer.valueOf(((RoleSelectAwardArg)this.arg).itemid), Integer.valueOf(((RoleSelectAwardArg)this.arg).itemCount));
/* 23 */           jiuXiaoPreciousItemBrd.npcid = jueZhanJiuXiaoCfg.bossNPC;
/* 24 */           jiuXiaoPreciousItemBrd.rolename = mzm.gsp.role.main.RoleInterface.getName(((RoleSelectAwardArg)this.arg).roleid);
/* 25 */           jiuXiaoPreciousItemBrd.activityid = jiuxiaoconAwardContext.activityid;
/* 26 */           OnlineManager.getInstance().sendAll(jiuXiaoPreciousItemBrd);
/*    */         } else {
/* 28 */           GameServer.logger().error(String.format("[JiuXiao]PJiuXiaoRoleSelectAward.processImp@do not exsit floor|floor=%d", new Object[] { Integer.valueOf(jiuxiaoconAwardContext.awardFloor) }));
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\main\PJiuXiaoRoleSelectAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */