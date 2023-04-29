/*    */ package mzm.gsp.children.fetuseducationmusic;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FetusEducationMusicManager
/*    */ {
/* 17 */   static Logger logger = Logger.getLogger("fetus_education_music");
/*    */   
/*    */   static void init()
/*    */   {
/* 21 */     FetusEducationMusicActivityHandler handler = new FetusEducationMusicActivityHandler();
/* 22 */     ActivityInterface.registerActivityByLogicType(69, handler);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isFetusEducationMusicSwitchOpenForRole(long roleid)
/*    */   {
/* 33 */     if (!OpenInterface.getOpenStatus(205))
/*    */     {
/* 35 */       return false;
/*    */     }
/* 37 */     if (OpenInterface.isBanPlay(roleid, 205))
/*    */     {
/* 39 */       OpenInterface.sendBanPlayMsg(roleid, 205);
/* 40 */       return false;
/*    */     }
/* 42 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean checkRoleStatus(long roleid, int status)
/*    */   {
/* 53 */     return RoleStatusInterface.checkCanSetStatus(roleid, status, true);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\fetuseducationmusic\FetusEducationMusicManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */