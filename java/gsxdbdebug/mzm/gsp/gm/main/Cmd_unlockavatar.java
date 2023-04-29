/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.avatar.main.PGMUnlockAvatar;
/*    */ 
/*    */ public class Cmd_unlockavatar extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int avatarId;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 14 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 16 */     if (this.m_arguments == null) {
/* 17 */       return false;
/*    */     }
/* 19 */     int index = 0;
/*    */     
/* 21 */     if (index >= this.m_arguments.size()) {
/* 22 */       return false;
/*    */     }
/* 24 */     Long targetId = null;
/* 25 */     targetId = xtable.Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 27 */     if (targetId != null)
/*    */     {
/* 29 */       this.roleId = targetId.longValue();
/* 30 */       index++;
/*    */     }
/*    */     
/* 33 */     if (index >= this.m_arguments.size()) {
/* 34 */       return false;
/*    */     }
/* 36 */     Integer I_avatarId = parseInt((String)this.m_arguments.get(index++));
/* 37 */     if (I_avatarId == null) {
/* 38 */       return false;
/*    */     }
/* 40 */     this.avatarId = I_avatarId.intValue();
/*    */     
/* 42 */     if (index != this.m_arguments.size()) {
/* 43 */       return false;
/*    */     }
/* 45 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 53 */     return true;
/*    */   }
/*    */   
/*    */   protected void run()
/*    */   {
/* 58 */     new PGMUnlockAvatar(this.m_gmRole.getRoleid(), this.roleId, this.avatarId).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_unlockavatar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */