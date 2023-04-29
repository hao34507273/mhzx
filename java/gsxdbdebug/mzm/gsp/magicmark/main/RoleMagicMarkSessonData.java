/*    */ package mzm.gsp.magicmark.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class RoleMagicMarkSessonData
/*    */ {
/* 52 */   private Map<Integer, MagicMarkOutOfDateSession> roleSessions = new HashMap();
/*    */   
/*    */   public void addSession(long roleid, int magicMarkType, long expiredTime) {
/* 55 */     synchronized (this.roleSessions) {
/* 56 */       MagicMarkOutOfDateSession oldSession = (MagicMarkOutOfDateSession)this.roleSessions.get(Integer.valueOf(magicMarkType));
/* 57 */       if (oldSession != null) {
/* 58 */         oldSession.stopTimer();
/*    */       }
/* 60 */       long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 61 */       long interValSecond = Math.max(0L, (expiredTime - curTime) / 1000L);
/* 62 */       MagicMarkOutOfDateSession newSession = new MagicMarkOutOfDateSession(interValSecond, roleid, magicMarkType, expiredTime);
/*    */       
/* 64 */       this.roleSessions.put(Integer.valueOf(magicMarkType), newSession);
/*    */     }
/*    */   }
/*    */   
/*    */   public void removeSession(int magicMarkType)
/*    */   {
/* 70 */     synchronized (this.roleSessions) {
/* 71 */       MagicMarkOutOfDateSession oldSession = (MagicMarkOutOfDateSession)this.roleSessions.remove(Integer.valueOf(magicMarkType));
/* 72 */       if (oldSession != null) {
/* 73 */         oldSession.stopTimer();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void clearSesson() {
/* 79 */     synchronized (this.roleSessions) {
/* 80 */       for (MagicMarkOutOfDateSession session : this.roleSessions.values()) {
/* 81 */         session.stopTimer();
/*    */       }
/* 83 */       this.roleSessions.clear();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\magicmark\main\RoleMagicMarkSessonData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */