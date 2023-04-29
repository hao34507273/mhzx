/*    */ package mzm.gsp.gift.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.friend.main.FriendInterface;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_Test
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   private final int giftType;
/* 16 */   private final ArrayList<String> args = new ArrayList();
/*    */   
/*    */   public PGM_Test(long gmRoleid, long roleid, int giftType, List<String> args) {
/* 19 */     this.gmRoleid = gmRoleid;
/* 20 */     this.roleid = roleid;
/* 21 */     this.giftType = giftType;
/* 22 */     this.args.addAll(args);
/* 23 */     this.args.add(0, RoleInterface.getName(roleid));
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     testSendInvitation();
/* 30 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   void testGiveGift() {}
/*    */   
/*    */ 
/*    */   void testSendInvitation()
/*    */   {
/* 40 */     boolean ret = InvitationInterface.sendInvitationToRoles(this.roleid, FriendInterface.getAllFriends(this.roleid, true), this.giftType, this.args);
/*    */     
/* 42 */     if (ret) {
/* 43 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, "操作成功");
/*    */     } else {
/* 45 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, "操作失败,请检查参数");
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gift\main\PGM_Test.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */