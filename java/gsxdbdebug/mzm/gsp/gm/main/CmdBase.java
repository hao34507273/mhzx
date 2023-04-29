/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import xdb.util.Counter;
/*    */ 
/*    */ public abstract class CmdBase
/*    */ {
/*    */   protected Role m_gmRole;
/* 10 */   protected ArrayList<String> m_arguments = null;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void init(Role gm, ArrayList<String> arguments)
/*    */   {
/* 18 */     this.m_gmRole = gm;
/* 19 */     this.m_arguments = arguments;
/*    */   }
/*    */   
/*    */   public boolean execute()
/*    */   {
/* 24 */     GmManager.counterInvoke.increment(getClass().getCanonicalName());
/* 25 */     if ((!parse()) || (!fillData()))
/*    */     {
/* 27 */       sendError(1000, new Object[0]);
/* 28 */       printUsage();
/* 29 */       return true;
/*    */     }
/*    */     
/* 32 */     run();
/* 33 */     GmManager.counterSuccess.increment(getClass().getCanonicalName());
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   protected void sendError(String error)
/*    */   {
/* 39 */     if (this.m_gmRole != null) {
/* 40 */       GmManager.getInstance().sendResultToGM(this.m_gmRole.getRoleid(), error);
/*    */     }
/*    */   }
/*    */   
/*    */   protected void sendError(int strID, Object... args) {
/* 45 */     if (this.m_gmRole != null) {
/* 46 */       GmManager.getInstance().sendResultToGM(this.m_gmRole.getRoleid(), strID, args);
/*    */     }
/*    */   }
/*    */   
/*    */   protected abstract boolean parse();
/*    */   
/*    */   protected abstract boolean fillData();
/*    */   
/*    */   protected abstract void run();
/*    */   
/*    */   protected String usage() {
/* 57 */     return "";
/*    */   }
/*    */   
/*    */   private void printUsage()
/*    */   {
/* 62 */     if (this.m_gmRole != null)
/*    */     {
/*    */ 
/* 65 */       String msg = "usage: ." + getClass().getName().substring(19) + " " + usage();
/* 66 */       GmManager.getInstance().sendResultToGM(this.m_gmRole.getRoleid(), msg);
/*    */     }
/*    */   }
/*    */   
/*    */   public static Integer parseInt(String str)
/*    */   {
/*    */     try
/*    */     {
/* 74 */       return Integer.valueOf(Integer.parseInt(str));
/*    */     }
/*    */     catch (NumberFormatException e) {}
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 82 */     return null;
/*    */   }
/*    */   
/*    */   public static Long parseLong(String str)
/*    */   {
/*    */     try
/*    */     {
/* 89 */       return Long.valueOf(Long.parseLong(str));
/*    */     }
/*    */     catch (NumberFormatException e) {}
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 97 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\CmdBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */