/*    */ package mzm.event;
/*    */ 
/*    */ import java.util.Map;
/*    */ 
/*    */ public class ModulerInitInfo
/*    */ {
/*  7 */   private int modulePriorityId = 0;
/*    */   private String moduleName;
/*    */   private Map<String, String> env;
/*    */   
/*    */   void setModuleName(String moduleName)
/*    */   {
/* 13 */     this.moduleName = moduleName;
/*    */   }
/*    */   
/*    */   int getModulePriorityId()
/*    */   {
/* 18 */     return this.modulePriorityId;
/*    */   }
/*    */   
/*    */   String getModuleName()
/*    */   {
/* 23 */     return this.moduleName;
/*    */   }
/*    */   
/*    */   void setEnv(Map<String, String> env)
/*    */   {
/* 28 */     this.env = env;
/*    */   }
/*    */   
/*    */   Map<String, String> getEnv()
/*    */   {
/* 33 */     return this.env;
/*    */   }
/*    */   
/*    */   public static void main(String[] args)
/*    */   {
/* 38 */     ModulerInitInfo m = new ModulerInitInfo();
/* 39 */     Map<String, String> env = new java.util.TreeMap();
/* 40 */     env.put("ab", "cd");
/* 41 */     env.put("abc", "cdf");
/*    */     
/* 43 */     m.setEnv(env);
/* 44 */     m.setModuleName("modulename");
/* 45 */     com.thoughtworks.xstream.XStream xstream = new com.thoughtworks.xstream.XStream();
/* 46 */     System.out.println(xstream.toXML(new ModulerInitInfo[] { m }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\event\ModulerInitInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */