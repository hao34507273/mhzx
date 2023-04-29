/*    */ package mzm.gsp.husong.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.HuSongDataBean;
/*    */ import xtable.Role2husong;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PGM_SetSpecialHusongCount extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long targetRoleid;
/*    */   private final int count;
/*    */   
/*    */   public PGM_SetSpecialHusongCount(long gmRoleid, long targetRoleId, int count)
/*    */   {
/* 17 */     this.gmRoleid = gmRoleid;
/* 18 */     this.targetRoleid = targetRoleId;
/* 19 */     this.count = count;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.targetRoleid);
/* 27 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/* 28 */     HuSongDataBean xHuSongDataBean = Role2husong.get(Long.valueOf(this.targetRoleid));
/* 29 */     if (xHuSongDataBean == null)
/*    */     {
/* 31 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("husong data is null|target_roleid=%d", new Object[] { Long.valueOf(this.targetRoleid) }));
/*    */       
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     xHuSongDataBean.setSpecialcount(this.count);
/*    */     
/* 38 */     HuSongManager.syncHusongData(userid, this.targetRoleid, xHuSongDataBean);
/*    */     
/* 40 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("set special husong count success|target_roleid=%d|count=%d", new Object[] { Long.valueOf(this.targetRoleid), Integer.valueOf(this.count) }));
/*    */     
/*    */ 
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\husong\main\PGM_SetSpecialHusongCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */