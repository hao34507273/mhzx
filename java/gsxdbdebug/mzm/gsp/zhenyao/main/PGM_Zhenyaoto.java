/*    */ package mzm.gsp.zhenyao.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.activity.confbean.ZhenYaoActivityCfgConsts;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Pod;
/*    */ import xbean.ZhenyaoCount;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2properties;
/*    */ import xtable.Role2zhenyaocount;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ public class PGM_Zhenyaoto
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int count;
/*    */   
/*    */   public PGM_Zhenyaoto(long roleid, int count)
/*    */   {
/* 24 */     this.roleid = roleid;
/* 25 */     this.count = count;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     String userid = RoleInterface.getUserId(this.roleid);
/* 33 */     Lockeys.lock(User.getTable(), Arrays.asList(new String[] { userid }));
/* 34 */     Lockeys.lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/* 35 */     ZhenyaoCount xCount = Role2zhenyaocount.get(Long.valueOf(this.roleid));
/* 36 */     if (xCount == null)
/*    */     {
/* 38 */       xCount = Pod.newZhenyaoCount();
/* 39 */       Role2zhenyaocount.insert(Long.valueOf(this.roleid), xCount);
/*    */     }
/* 41 */     xCount.setZhenyaocount(this.count);
/* 42 */     xCount.setDoublecount(0);
/* 43 */     xCount.setSinglecount(this.count);
/* 44 */     ActivityInterface.setActivityDataForGM(userid, this.roleid, ZhenYaoActivityCfgConsts.getInstance().ACTIVITYID, this.count);
/*    */     
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenyao\main\PGM_Zhenyaoto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */