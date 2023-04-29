/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import javax.xml.parsers.DocumentBuilderFactory;
/*    */ import org.w3c.dom.Document;
/*    */ import org.w3c.dom.Element;
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ public class GMDebugCmdManager
/*    */ {
/* 11 */   private static final Set<String> debugCmdSet = new java.util.HashSet();
/*    */   
/* 13 */   private static GMDebugCmdManager instance = new GMDebugCmdManager();
/*    */   
/*    */   String[] getAllCmds() {
/* 16 */     String[] ret = new String[debugCmdSet.size()];
/* 17 */     debugCmdSet.toArray(ret);
/* 18 */     return ret;
/*    */   }
/*    */   
/*    */   public static GMDebugCmdManager getInstance() {
/* 22 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   static int init(String dataPath)
/*    */   {
/*    */     try
/*    */     {
/* 32 */       DocumentBuilderFactory db = DocumentBuilderFactory.newInstance();
/* 33 */       db.setNamespaceAware(true);
/* 34 */       Document doc = db.newDocumentBuilder().parse(dataPath);
/* 35 */       if (doc == null) {
/* 36 */         mzm.gsp.GameServer.logger().error("GM调试命令的配置文件不存在");
/* 37 */         return -1;
/*    */       }
/*    */       
/* 40 */       NodeList nodeList = doc.getElementsByTagName("cmd");
/* 41 */       for (int i = 0; i < nodeList.getLength(); i++) {
/* 42 */         Element element = (Element)nodeList.item(i);
/* 43 */         String name = element.getAttribute("name");
/* 44 */         if (name != null)
/* 45 */           debugCmdSet.add(name.toLowerCase());
/*    */       }
/*    */     } catch (Exception e) {
/* 48 */       mzm.gsp.GameServer.logger().error("GM调试命令的配置错误：" + e);
/* 49 */       return -1;
/*    */     }
/* 51 */     return 0;
/*    */   }
/*    */   
/*    */   boolean isDebugCmd(String commandName)
/*    */   {
/* 56 */     return debugCmdSet.contains(commandName);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\GMDebugCmdManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */