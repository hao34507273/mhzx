/*    */ package mzm.gsp.menpaipvp.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.mail.main.MailInterface;
/*    */ import mzm.gsp.menpaipvp.confbean.MenpaiRankAward;
/*    */ import mzm.gsp.menpaipvp.confbean.SMenpaiRankAwardCfg;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.title.main.TitleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class PMenpaiRankAward
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final SMenpaiRankAwardCfg rankAwardCfg;
/*    */   
/*    */   PMenpaiRankAward(long roleid, SMenpaiRankAwardCfg rankAwardCfg)
/*    */   {
/* 25 */     this.roleid = roleid;
/* 26 */     this.rankAwardCfg = rankAwardCfg;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     String userid = RoleInterface.getUserId(this.roleid);
/*    */     
/*    */ 
/* 37 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/*    */ 
/* 40 */     int gender = RoleInterface.getGender(this.roleid);
/*    */     
/* 42 */     MenpaiRankAward awardCfg = MenpaiPVPConfigManager.getInstance().getMenpaiRankAwardCfg(gender, this.rankAwardCfg);
/*    */     
/* 44 */     if (awardCfg == null) {
/* 45 */       MenpaiPVPManager.logError("PMenpaiRankAward.processImp@not gender award config|roleid=%d|menpai=%d|gender=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.rankAwardCfg.menpai), Integer.valueOf(gender) });
/*    */       
/*    */ 
/* 48 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 52 */     TitleInterface.addAppellation(this.roleid, awardCfg.appellation, true);
/*    */     
/*    */ 
/* 55 */     TLogArg tLogArg = new TLogArg(LogReason.MENPAI_PVP_TOPN_AWARD);
/* 56 */     MailInterface.synBuildAndSendMail(this.roleid, awardCfg.mail, null, null, tLogArg);
/*    */     
/* 58 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\main\PMenpaiRankAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */