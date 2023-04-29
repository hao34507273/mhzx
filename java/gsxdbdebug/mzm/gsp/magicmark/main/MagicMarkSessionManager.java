/*    */ package mzm.gsp.magicmark.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ class MagicMarkSessionManager
/*    */ {
/* 10 */   private static final Map<Long, RoleMagicMarkSessonData> roleMagicMarkSesson = new HashMap();
/*    */   
/*    */   static void addRoleSession(long roleid, int magicMarkType, long expiredTime) {
/* 13 */     synchronized (roleMagicMarkSesson) {
/* 14 */       RoleMagicMarkSessonData roleMagicMarkSessonData = (RoleMagicMarkSessonData)roleMagicMarkSesson.get(Long.valueOf(roleid));
/* 15 */       if (roleMagicMarkSessonData == null) {
/* 16 */         roleMagicMarkSessonData = new RoleMagicMarkSessonData();
/* 17 */         roleMagicMarkSesson.put(Long.valueOf(roleid), roleMagicMarkSessonData);
/*    */       }
/* 19 */       roleMagicMarkSessonData.addSession(roleid, magicMarkType, expiredTime);
/*    */     }
/*    */   }
/*    */   
/*    */   static void remRoleSession(long roleid, int magicMarkType) {
/* 24 */     synchronized (roleMagicMarkSesson) {
/* 25 */       RoleMagicMarkSessonData roleMagicMarkSessonData = (RoleMagicMarkSessonData)roleMagicMarkSesson.get(Long.valueOf(roleid));
/* 26 */       if (roleMagicMarkSessonData == null) {
/* 27 */         return;
/*    */       }
/* 29 */       roleMagicMarkSessonData.removeSession(magicMarkType);
/*    */     }
/*    */   }
/*    */   
/*    */   static void clearRoleSession(long roleid) {
/* 34 */     synchronized (roleMagicMarkSesson) {
/* 35 */       RoleMagicMarkSessonData roleMagicMarkSessonData = (RoleMagicMarkSessonData)roleMagicMarkSesson.remove(Long.valueOf(roleid));
/* 36 */       if (roleMagicMarkSessonData == null) {
/* 37 */         return;
/*    */       }
/* 39 */       roleMagicMarkSessonData.clearSesson();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\magicmark\main\MagicMarkSessionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */