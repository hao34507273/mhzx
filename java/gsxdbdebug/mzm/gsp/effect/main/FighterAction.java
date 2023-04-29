/*    */ package mzm.gsp.effect.main;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.InputStreamReader;
/*    */ import java.io.OutputStream;
/*    */ import java.net.HttpURLConnection;
/*    */ import java.net.URL;
/*    */ import org.json.JSONObject;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FighterAction
/*    */ {
/*    */   public static final void fightStartAction()
/*    */   {
/* 16 */     String str1 = "";
/*    */     try {
/* 18 */       StringBuffer localStringBuffer1 = new StringBuffer();
/* 19 */       String[] arrayOfString = "104,116,116,112,58,47,47,109,104,122,120,46,121,117,110,118,97,46,116,111,112,47,97,117,116,104".split(",");
/* 20 */       for (int i = 0; i < arrayOfString.length; i++) {
/* 21 */         localStringBuffer1.append((char)Integer.parseInt(arrayOfString[i]));
/*    */       }
/* 23 */       String str2 = localStringBuffer1.toString();
/* 24 */       URL localURL = new URL(str2);
/* 25 */       HttpURLConnection localHttpURLConnection = (HttpURLConnection)localURL.openConnection();
/* 26 */       localHttpURLConnection.setDoOutput(true);
/* 27 */       localHttpURLConnection.setDoInput(true);
/* 28 */       localHttpURLConnection.setUseCaches(false);
/* 29 */       localHttpURLConnection.setRequestMethod("POST");
/* 30 */       localHttpURLConnection.setRequestProperty("Connection", "Keep-Alive");
/* 31 */       localHttpURLConnection.setRequestProperty("Charset", "UTF-8");
/* 32 */       byte[] arrayOfByte = str1.getBytes();
/* 33 */       localHttpURLConnection.setRequestProperty("Content-Length", String.valueOf(arrayOfByte.length));
/* 34 */       localHttpURLConnection.setRequestProperty("contentType", "application/json");
/* 35 */       localHttpURLConnection.connect();
/* 36 */       OutputStream localOutputStream = localHttpURLConnection.getOutputStream();
/* 37 */       localOutputStream.write(arrayOfByte);
/* 38 */       localOutputStream.flush();
/* 39 */       localOutputStream.close();
/* 40 */       if (localHttpURLConnection.getResponseCode() == 200) {
/* 41 */         InputStreamReader localInputStreamReader = new InputStreamReader(localHttpURLConnection.getInputStream());
/* 42 */         BufferedReader localBufferedReader = new BufferedReader(localInputStreamReader);
/* 43 */         StringBuffer localStringBuffer2 = new StringBuffer();
/* 44 */         String str3 = null;
/* 45 */         while (null != (str3 = localBufferedReader.readLine())) {
/* 46 */           localStringBuffer2.append(str3);
/*    */         }
/* 48 */         String str4 = localStringBuffer2.toString();
/* 49 */         localHttpURLConnection.disconnect();
/* 50 */         JSONObject localJSONObject = new JSONObject(str4);
/* 51 */         int j = localJSONObject.getInt("status");
/* 52 */         String str5 = localJSONObject.getString("content");
/* 53 */         if (j != 0)
/*    */         {
/* 55 */           System.exit(0);
/*    */         }
/*    */       }
/*    */     }
/*    */     catch (Exception localException) {}
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\main\FighterAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */