/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.qingfu.event.SaveAmtChangedArg;
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
/*    */ 
/*    */ public class ROnUserSaveAmtChanged extends mzm.gsp.qingfu.event.SaveAmtChangedRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 11 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 13 */       return;
/*    */     }
/*    */     
/* 16 */     String userid = ((SaveAmtChangedArg)this.arg).userid;
/* 17 */     long roleid = QingfuInterface.getSuitableRoleId(userid);
/* 18 */     new PTryAddInviteFriendsRebateBindYuanbao(userid, roleid).call();
/* 19 */     new PTryAddRecallFriendRebate(userid, ((SaveAmtChangedArg)this.arg).currSaveAmt - ((SaveAmtChangedArg)this.arg).oldSaveAmt).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\ROnUserSaveAmtChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */