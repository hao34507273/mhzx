/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.StringTokenizer;
/*    */ import javax.xml.parsers.DocumentBuilderFactory;
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ import org.w3c.dom.Element;
/*    */ 
/*    */ public class GMAuthManager
/*    */ {
/* 12 */   private static final Map<String, Integer> name2TypeMap = new java.util.HashMap();
/*    */   
/* 14 */   private static GMAuthManager instance = new GMAuthManager();
/*    */   
/*    */   public static GMAuthManager getInstance() {
/* 17 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   static int init(String dataPath)
/*    */   {
/*    */     try
/*    */     {
/* 27 */       DocumentBuilderFactory db = DocumentBuilderFactory.newInstance();
/* 28 */       db.setNamespaceAware(true);
/* 29 */       org.w3c.dom.Document doc = db.newDocumentBuilder().parse(dataPath);
/* 30 */       if (doc == null) {
/* 31 */         GameServer.logger().error("GM权限到类型的配置文件不存在");
/* 32 */         return -1;
/*    */       }
/*    */       
/* 35 */       org.w3c.dom.NodeList nodeList = doc.getElementsByTagName("cmd");
/* 36 */       for (int i = 0; i < nodeList.getLength(); i++) {
/* 37 */         Element element = (Element)nodeList.item(i);
/* 38 */         String names = element.getAttribute("name");
/* 39 */         int auth = Integer.valueOf(element.getAttribute("limit")).intValue();
/* 40 */         StringTokenizer tokenizer = new StringTokenizer(names, ",");
/* 41 */         while (tokenizer.hasMoreTokens()) {
/* 42 */           Integer oldAuth = (Integer)name2TypeMap.put(tokenizer.nextToken().toLowerCase(), Integer.valueOf(auth));
/* 43 */           if ((oldAuth != null) && (oldAuth.intValue() != auth)) {
/* 44 */             GameServer.logger().error("GM权限到类型的配置中一个命令对应不同的权限");
/* 45 */             return -1;
/*    */           }
/*    */         }
/*    */       }
/*    */     } catch (Exception e) {
/* 50 */       GameServer.logger().error("GM权限到类型的配置错误：" + e);
/* 51 */       return -1;
/*    */     }
/* 53 */     return 0;
/*    */   }
/*    */   
/*    */   int getCommandType(String commandName)
/*    */   {
/* 58 */     Integer type = (Integer)name2TypeMap.get(commandName);
/* 59 */     return type == null ? -1 : type.intValue();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\GMAuthManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */