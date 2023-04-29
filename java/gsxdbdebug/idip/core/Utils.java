/*     */ package idip.core;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.URLDecoder;
/*     */ import java.net.URLEncoder;
/*     */ 
/*     */ public class Utils
/*     */ {
/*     */   public static final String DEFAULT_CHARSET = "UTF-8";
/*  12 */   private static boolean isShadow = false;
/*     */   private static final char[] HEX_UPPPER_CHAR_TABLE;
/*     */   
/*  15 */   static { isShadow = System.getProperty("com.zulong.mhzx.shadow") != null;
/*     */     
/*     */ 
/*  18 */     HEX_UPPPER_CHAR_TABLE = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
/*     */     
/*  20 */     ENCODE_INPUT_CHARS = new String['Ā'];
/*     */     
/*     */ 
/*  23 */     for (int i = 0; i < 256; i++)
/*     */     {
/*  25 */       if (((i >= 48) && (i <= 57)) || ((i >= 97) && (i <= 122)) || ((i >= 65) && (i <= 90)) || (i == 45) || (i == 95) || (i == 46) || (i == 126))
/*     */       {
/*     */ 
/*  28 */         ENCODE_INPUT_CHARS[i] = String.format("%c", new Object[] { Character.valueOf((char)i) });
/*     */       }
/*     */       else
/*     */       {
/*  32 */         StringBuilder sb = new StringBuilder();
/*  33 */         sb.append('%');
/*  34 */         sb.append(HEX_UPPPER_CHAR_TABLE[(i >>> 4 & 0xF)]);
/*  35 */         sb.append(HEX_UPPPER_CHAR_TABLE[(i & 0xF)]);
/*  36 */         ENCODE_INPUT_CHARS[i] = sb.toString();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static final String[] ENCODE_INPUT_CHARS;
/*     */   
/*     */ 
/*     */   private static int hexCharToByte(char c)
/*     */   {
/*  49 */     if ((c >= '0') && (c <= '9'))
/*     */     {
/*  51 */       return c - '0';
/*     */     }
/*  53 */     c = Character.toLowerCase(c);
/*  54 */     if ((c >= 'a') && (c <= 'f'))
/*     */     {
/*  56 */       return c - 'a' + 10;
/*     */     }
/*  58 */     throw new RuntimeException("hexCharToByte bad format char " + c);
/*     */   }
/*     */   
/*     */   public static String urlEncode1738(String content) throws UnsupportedEncodingException
/*     */   {
/*  63 */     return urlEncode1738(content, "UTF-8");
/*     */   }
/*     */   
/*     */   public static String urlEncode1738(String content, String charset) throws UnsupportedEncodingException
/*     */   {
/*  68 */     StringBuilder sb = new StringBuilder();
/*  69 */     byte[] bytes = content.getBytes(charset);
/*  70 */     int len = bytes.length;
/*  71 */     for (int i = 0; i < len; i++)
/*     */     {
/*  73 */       int b = bytes[i] & 0xFF;
/*  74 */       sb.append(b == 126 ? "%7E" : ENCODE_INPUT_CHARS[b]);
/*     */     }
/*  76 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public static String urlDecode1738(String content) throws UnsupportedEncodingException
/*     */   {
/*  81 */     return urlDecode1738(content, "UTF-8");
/*     */   }
/*     */   
/*     */   public static String urlDecode1738(String content, String charset) throws UnsupportedEncodingException
/*     */   {
/*  86 */     ByteArrayOutputStream baos = new ByteArrayOutputStream();
/*  87 */     int len = content.length();
/*  88 */     for (int i = 0; i < len; i++)
/*     */     {
/*  90 */       char chr = content.charAt(i);
/*  91 */       if (chr == '%')
/*     */       {
/*  93 */         int b0 = hexCharToByte(content.charAt(++i));
/*  94 */         int b1 = hexCharToByte(content.charAt(++i));
/*  95 */         baos.write((byte)((b0 << 4 | b1) & 0xFF));
/*     */       }
/*     */       else
/*     */       {
/*  99 */         baos.write((byte)chr);
/*     */       }
/*     */     }
/* 102 */     return new String(baos.toByteArray(), charset);
/*     */   }
/*     */   
/*     */   public static String urlEncode3896(String content) throws UnsupportedEncodingException
/*     */   {
/* 107 */     return urlEncode3896(content, "UTF-8");
/*     */   }
/*     */   
/*     */   public static String urlEncode3896(String content, String charset) throws UnsupportedEncodingException
/*     */   {
/* 112 */     StringBuilder sb = new StringBuilder();
/* 113 */     byte[] bytes = content.getBytes(charset);
/* 114 */     int len = bytes.length;
/* 115 */     for (int i = 0; i < len; i++)
/*     */     {
/* 117 */       int b = bytes[i] & 0xFF;
/* 118 */       sb.append(ENCODE_INPUT_CHARS[b]);
/*     */     }
/* 120 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public static String urlDecode3896(String content) throws UnsupportedEncodingException
/*     */   {
/* 125 */     return urlDecode3896(content, "UTF-8");
/*     */   }
/*     */   
/*     */   public static String urlDecode3896(String content, String charset) throws UnsupportedEncodingException
/*     */   {
/* 130 */     return urlDecode1738(content, charset);
/*     */   }
/*     */   
/*     */   public static String urlEncode(String content) throws UnsupportedEncodingException
/*     */   {
/* 135 */     return urlEncode(content, "UTF-8");
/*     */   }
/*     */   
/*     */   public static String urlEncode(String content, String charset) throws UnsupportedEncodingException
/*     */   {
/* 140 */     return URLEncoder.encode(content, charset);
/*     */   }
/*     */   
/*     */   public static String urlDecode(String content) throws UnsupportedEncodingException
/*     */   {
/* 145 */     return urlDecode(content, "UTF-8");
/*     */   }
/*     */   
/*     */   public static String urlDecode(String content, String charset) throws UnsupportedEncodingException
/*     */   {
/* 150 */     return URLDecoder.decode(content, charset);
/*     */   }
/*     */   
/*     */   public static String formatTimestamp(long timestamp)
/*     */   {
/* 155 */     return String.valueOf((int)(timestamp / 1000L));
/*     */   }
/*     */   
/*     */   public static String getUserId(String openId, int areaId, int partition)
/*     */   {
/* 160 */     if (isShadow)
/*     */     {
/* 162 */       return String.format("%s$%s@%d", new Object[] { openId, "shadow", Integer.valueOf(partition) });
/*     */     }
/*     */     
/*     */ 
/* 166 */     return String.format("%s$%s@%d", new Object[] { openId, areaId == 1 ? "wechat" : "qq", Integer.valueOf(partition) });
/*     */   }
/*     */   
/*     */ 
/*     */   public static String getOpenId(String userid)
/*     */   {
/* 172 */     int index = userid.lastIndexOf("$");
/* 173 */     if (index != -1)
/*     */     {
/* 175 */       return userid.substring(0, index);
/*     */     }
/* 177 */     return userid;
/*     */   }
/*     */   
/*     */   public static String getAreaName(String userid)
/*     */   {
/* 182 */     int areaIndex = userid.lastIndexOf('$');
/* 183 */     if (-1 != areaIndex)
/*     */     {
/* 185 */       int partitionIndex = userid.lastIndexOf('@');
/* 186 */       if (-1 == partitionIndex)
/*     */       {
/* 188 */         return userid.substring(areaIndex + 1);
/*     */       }
/*     */       
/*     */ 
/* 192 */       return userid.substring(areaIndex + 1, partitionIndex);
/*     */     }
/*     */     
/* 195 */     return userid;
/*     */   }
/*     */   
/*     */   public static int getAreaId(String userid)
/*     */   {
/* 200 */     String areaName = getAreaName(userid);
/* 201 */     return areaName.equals("wechat") ? 1 : 2;
/*     */   }
/*     */   
/*     */   public static int getPartition(String userid)
/*     */   {
/* 206 */     int areaIndex = userid.lastIndexOf('$');
/* 207 */     if (-1 != areaIndex)
/*     */     {
/* 209 */       int partitionIndex = userid.lastIndexOf('@');
/* 210 */       if (areaIndex < partitionIndex)
/*     */       {
/* 212 */         return Integer.parseInt(userid.substring(partitionIndex + 1));
/*     */       }
/*     */     }
/*     */     
/* 216 */     return 0;
/*     */   }
/*     */   
/*     */   public static void setShadow(boolean shadow)
/*     */   {
/* 221 */     isShadow = shadow;
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws Exception
/*     */   {
/* 226 */     String str_source = "鬼王宗";
/* 227 */     String str_utf8_url_encoded = urlEncode1738("鬼王宗", "UTF-8");
/* 228 */     System.out.println("str_utf8_url_encoded:" + str_utf8_url_encoded);
/* 229 */     String str_utf8 = urlDecode1738(str_utf8_url_encoded, "UTF-8");
/* 230 */     System.out.println("str_utf8:" + str_utf8 + "(" + str_utf8.getBytes().length + ")");
/* 231 */     String str_gbk_url_encoded = urlEncode1738("鬼王宗", "GBK");
/* 232 */     System.out.println("str_gbk_url_encoded:" + str_gbk_url_encoded);
/* 233 */     String str_gbk = urlDecode1738(str_gbk_url_encoded, "GBK");
/* 234 */     System.out.println("str_gbk:" + str_gbk + "(" + str_gbk.getBytes().length + ")");
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\core\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */