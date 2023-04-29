/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum LogoutReason
/*    */ {
/*  7 */   LINK_BREAK("linkbreak", 1), 
/*  8 */   QUIT_GAME("quitgame", 2), 
/*  9 */   CHANGE_ROLE("changerole", 3), 
/* 10 */   OTHER_REASON("otherreason", 4);
/*    */   
/*    */   private String name;
/*    */   private int value;
/*    */   
/* 15 */   private LogoutReason(String name, int value) { this.name = name;
/* 16 */     this.value = value;
/*    */   }
/*    */   
/*    */   public int value() {
/* 20 */     return this.value;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 24 */     return this.name;
/*    */   }
/*    */   
/*    */   public static LogoutReason value(int value) {
/* 28 */     switch (value)
/*    */     {
/*    */     case 1: 
/* 31 */       return LINK_BREAK;
/*    */     case 2: 
/* 33 */       return QUIT_GAME;
/*    */     case 3: 
/* 35 */       return CHANGE_ROLE;
/*    */     case 4: 
/* 37 */       return OTHER_REASON;
/*    */     }
/* 39 */     throw new RuntimeException("can not find quit reason for value " + value);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\LogoutReason.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */