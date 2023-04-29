/*    */ package mzm.gsp.util;
/*    */ 
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class FormatStringManager
/*    */ {
/* 10 */   private static String regex1 = "\\{\\d+\\}";
/* 11 */   private static String regex2 = "%%%d\\$s";
/* 12 */   private static Pattern pattern = Pattern.compile(regex1);
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String format(String input)
/*    */   {
/* 20 */     Matcher matcher = pattern.matcher(input);
/* 21 */     StringBuffer sb = new StringBuffer();
/*    */     try {
/* 23 */       while (matcher.find()) {
/* 24 */         String str = matcher.group();
/* 25 */         int index = Integer.parseInt(str.substring(1, str.length() - 1));
/* 26 */         matcher.appendReplacement(sb, String.format(regex2, new Object[] { Integer.valueOf(index + 1) }));
/*    */       }
/* 28 */       matcher.appendTail(sb);
/*    */     } catch (Exception e) {
/* 30 */       GameServer.logger().error("格式化客户端格式字符串为服务器格式出错:" + e.toString());
/*    */     }
/* 32 */     return sb.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\FormatStringManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */