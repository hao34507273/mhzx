/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.friendscircle.main.PGM_SetLocalFriendsCircle;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_setlocalfriendscircle
/*    */   extends CmdBase
/*    */ {
/*    */   private int type;
/*    */   private int value;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 19 */     if (this.m_arguments == null) {
/* 20 */       return false;
/*    */     }
/* 22 */     int index = 0;
/*    */     
/* 24 */     if (index >= this.m_arguments.size()) {
/* 25 */       return false;
/*    */     }
/* 27 */     Integer I_type = parseInt((String)this.m_arguments.get(index++));
/* 28 */     if (I_type == null) {
/* 29 */       return false;
/*    */     }
/* 31 */     this.type = I_type.intValue();
/*    */     
/* 33 */     if (index >= this.m_arguments.size()) {
/* 34 */       return false;
/*    */     }
/* 36 */     Integer I_value = parseInt((String)this.m_arguments.get(index++));
/* 37 */     if (I_value == null) {
/* 38 */       return false;
/*    */     }
/* 40 */     this.value = I_value.intValue();
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
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 54 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 61 */     new PGM_SetLocalFriendsCircle(this.m_gmRole.getRoleid(), this.type, this.value).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_setlocalfriendscircle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */