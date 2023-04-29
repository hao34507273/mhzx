/*     */ package mzm.gsp.util;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.math.BigDecimal;
/*     */ import java.net.InetAddress;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public class CommonUtils
/*     */ {
/*  19 */   public static int WAN_PERCENT = 10000;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getLongHigh(long l)
/*     */   {
/*  29 */     return (int)((l & 0xFFFFFFFF00000000) >>> 32);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getLongLow(long l)
/*     */   {
/*  40 */     return (int)(l & 0xFFFFFFFF);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getLong(int high, int low)
/*     */   {
/*  54 */     return high << 32 | low & 0xFFFFFFFF;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getUTF16Length(String str)
/*     */   {
/*  67 */     byte[] bytes = null;
/*     */     try
/*     */     {
/*  70 */       bytes = str.getBytes("UTF-16BE");
/*     */     }
/*     */     catch (UnsupportedEncodingException e)
/*     */     {
/*  74 */       throw new RuntimeException(e);
/*     */     }
/*  76 */     int length = 0;
/*  77 */     for (int i = 0; 
/*  78 */         i < bytes.length; i += 2)
/*     */     {
/*  80 */       int totalValue = (bytes[i] & 0xFF) << 8 | bytes[(i + 1)] & 0xFF;
/*  81 */       if ((totalValue < 123) && (totalValue > 47))
/*     */       {
/*  83 */         length++;
/*     */       }
/*     */       else
/*  86 */         length += 2;
/*     */     }
/*  88 */     return length;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static <T> void randomList(List<T> inList, int needNum, List<T> outList)
/*     */   {
/* 105 */     if (inList.isEmpty())
/*     */     {
/* 107 */       return;
/*     */     }
/* 109 */     int addNum = 0;
/* 110 */     while (addNum < needNum)
/*     */     {
/* 112 */       int rdmIdx = Xdb.random().nextInt(inList.size());
/* 113 */       outList.add(inList.get(rdmIdx));
/* 114 */       addNum++;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static <T> void regionRandom(Collection<T> inCollection, int needNum, List<T> outList)
/*     */   {
/* 134 */     ArrayList<T> tmpList = new ArrayList(inCollection);
/* 135 */     regionRandomByMutableArray(tmpList, needNum, outList);
/* 136 */     tmpList.clear();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static <T> void regionRandomByMutableArray(ArrayList<T> inList, int needNum, List<T> outList)
/*     */   {
/* 152 */     if (inList.size() <= needNum)
/*     */     {
/* 154 */       outList.addAll(inList);
/* 155 */       return;
/*     */     }
/*     */     
/* 158 */     int inSize = inList.size();
/* 159 */     while ((inSize > 0) && (needNum > 0))
/*     */     {
/* 161 */       int rdmIdx = Xdb.random().nextInt(inSize);
/* 162 */       T data = inList.get(rdmIdx);
/* 163 */       outList.add(data);
/*     */       
/* 165 */       inSize--;
/* 166 */       Collections.swap(inList, rdmIdx, inSize);
/* 167 */       needNum--;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int random(int min, int max)
/*     */   {
/* 180 */     if (min >= max)
/* 181 */       return min;
/* 182 */     return Xdb.random().nextInt(max - min) + min;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getUserId(String openId, String channel, int zoneid)
/*     */   {
/* 198 */     return String.format("%s$%s@%d", new Object[] { openId, channel, Integer.valueOf(zoneid) });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getOpenId(Octets octetsUserId)
/*     */   {
/* 210 */     String userId = octetsUserId.getString("UTF-8");
/* 211 */     return getOpenId(userId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getOpenId(String userId)
/*     */   {
/* 223 */     int platIndex = userId.lastIndexOf('$');
/* 224 */     int zoneIndex = userId.lastIndexOf('@');
/* 225 */     if ((zoneIndex - platIndex > 1) && (platIndex != -1))
/*     */     {
/* 227 */       return userId.substring(0, platIndex);
/*     */     }
/* 229 */     return userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getPlatName(Octets octetsUserId)
/*     */   {
/* 241 */     String userId = octetsUserId.getString("UTF-8");
/* 242 */     return getPlatName(userId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getPlatName(String userId)
/*     */   {
/* 254 */     int platIndex = userId.lastIndexOf('$');
/* 255 */     int zoneIndex = userId.lastIndexOf('@');
/* 256 */     if ((zoneIndex - platIndex > 1) && (platIndex != -1))
/*     */     {
/* 258 */       return userId.substring(platIndex + 1, zoneIndex);
/*     */     }
/* 260 */     return "shadow";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getZoneId(String userId)
/*     */   {
/* 272 */     int platIndex = userId.lastIndexOf('$');
/* 273 */     int zoneIndex = userId.lastIndexOf('@');
/* 274 */     if ((zoneIndex - platIndex > 1) && (platIndex != -1))
/*     */     {
/* 276 */       return Integer.valueOf(userId.substring(zoneIndex + 1)).intValue();
/*     */     }
/* 278 */     return GameServerInfoManager.getZoneId();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long roleNoToID(String roleNo)
/*     */   {
/* 292 */     int len = roleNo.length();
/* 293 */     if ((len < 7) || (len > 10))
/*     */     {
/* 295 */       return -1L;
/*     */     }
/*     */     
/* 298 */     int autoIncreaseNoIndex = len - 6;
/* 299 */     long zoneidTmp = Integer.parseInt(roleNo.substring(0, autoIncreaseNoIndex));
/* 300 */     long zoneid = zoneidTmp & GameServerInfoManager.ZONEID_MASK;
/* 301 */     long million = zoneidTmp >> GameServerInfoManager.LOCAL_ID_BITS;
/* 302 */     long autoIncreaseNo = Integer.parseInt(roleNo.substring(autoIncreaseNoIndex)) + million * 1000000L;
/* 303 */     return (autoIncreaseNo << GameServerInfoManager.LOCAL_ID_BITS) + zoneid;
/*     */   }
/*     */   
/*     */   public static String getHostName() throws Exception
/*     */   {
/* 308 */     String computerName = System.getenv("COMPUTERNAME");
/* 309 */     if (computerName != null)
/*     */     {
/* 311 */       return computerName;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 316 */       return InetAddress.getLocalHost().getHostName();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 320 */       String host = e.getMessage();
/* 321 */       if (host != null)
/*     */       {
/* 323 */         int colon = host.indexOf(':');
/* 324 */         if (colon > 0)
/*     */         {
/* 326 */           return host.substring(0, colon);
/*     */         }
/*     */       }
/*     */       
/* 330 */       throw new RuntimeException("UnknownHost");
/*     */     }
/*     */   }
/*     */   
/*     */   public static String getHostIp()
/*     */   {
/*     */     try
/*     */     {
/* 338 */       InetAddress netAddress = InetAddress.getLocalHost();
/* 339 */       if (null != netAddress)
/*     */       {
/* 341 */         return netAddress.getHostAddress();
/*     */       }
/* 343 */       return null;
/*     */     }
/*     */     catch (Exception e) {}
/*     */     
/*     */ 
/* 348 */     return null;
/*     */   }
/*     */   
/*     */   public static int convertIpStrToInt(String strIp)
/*     */     throws Exception
/*     */   {
/* 354 */     if (strIp.indexOf('.') == -1)
/*     */     {
/* 356 */       throw new IllegalArgumentException("strIp illegal");
/*     */     }
/*     */     
/* 359 */     String[] comps = strIp.split("\\.");
/* 360 */     if (comps.length != 4)
/*     */     {
/* 362 */       throw new IllegalArgumentException("strIp illegal");
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 367 */       return Integer.parseInt(comps[0]) << 24 & 0xFF000000 | Integer.parseInt(comps[1]) << 16 & 0xFF0000 | Integer.parseInt(comps[2]) << 8 & 0xFF00 | Integer.parseInt(comps[3]) & 0xFF;
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 372 */       throw e;
/*     */     }
/*     */   }
/*     */   
/*     */   public static String convertIpIntToStr(int ip)
/*     */   {
/* 378 */     StringBuffer sb = new StringBuffer();
/* 379 */     sb.append(String.valueOf(ip >>> 24 & 0xFF)).append(".");
/* 380 */     sb.append(String.valueOf(ip >>> 16 & 0xFF)).append(".");
/* 381 */     sb.append(String.valueOf(ip >>> 8 & 0xFF)).append(".");
/* 382 */     sb.append(String.valueOf(ip & 0xFF));
/* 383 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public static int convertIpStrToBigEndianInt(String strIp) throws Exception
/*     */   {
/* 388 */     if (strIp.indexOf('.') == -1)
/*     */     {
/* 390 */       throw new IllegalArgumentException("strIp illegal");
/*     */     }
/*     */     
/* 393 */     String[] comps = strIp.split("\\.");
/* 394 */     if (comps.length != 4)
/*     */     {
/* 396 */       throw new IllegalArgumentException("strIp illegal");
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 401 */       return Integer.parseInt(comps[3]) << 24 & 0xFF000000 | Integer.parseInt(comps[2]) << 16 & 0xFF0000 | Integer.parseInt(comps[1]) << 8 & 0xFF00 | Integer.parseInt(comps[0]) & 0xFF;
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 406 */       throw e;
/*     */     }
/*     */   }
/*     */   
/*     */   public static String convertIpBigEndianIntToStr(int ip)
/*     */   {
/* 412 */     StringBuffer sb = new StringBuffer();
/* 413 */     sb.append(String.valueOf(ip & 0xFF)).append('.');
/* 414 */     sb.append(String.valueOf(ip >>> 8 & 0xFF)).append('.');
/* 415 */     sb.append(String.valueOf(ip >>> 16 & 0xFF)).append('.');
/* 416 */     sb.append(String.valueOf(ip >>> 24 & 0xFF));
/* 417 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public static byte[] convertIpStrToBytes(String strIp) throws Exception
/*     */   {
/* 422 */     if (strIp.indexOf('.') == -1)
/*     */     {
/* 424 */       throw new IllegalArgumentException("strIp illegal");
/*     */     }
/*     */     
/* 427 */     String[] comps = strIp.split("\\.");
/* 428 */     if (comps.length != 4)
/*     */     {
/* 430 */       throw new IllegalArgumentException("strIp illegal");
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 435 */       byte[] address = new byte[4];
/* 436 */       address[0] = ((byte)(Integer.parseInt(comps[0]) & 0xFF));
/* 437 */       address[1] = ((byte)(Integer.parseInt(comps[1]) & 0xFF));
/* 438 */       address[2] = ((byte)(Integer.parseInt(comps[2]) & 0xFF));
/* 439 */       address[3] = ((byte)(Integer.parseInt(comps[3]) & 0xFF));
/* 440 */       return address;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 444 */       throw e;
/*     */     }
/*     */   }
/*     */   
/* 448 */   private static char[] HEX_CHAR_TABLE = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String bytesToHexString(byte[] bytes)
/*     */   {
/* 461 */     return bytesToHexString(bytes, 0, bytes.length);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String bytesToHexString(byte[] bytes, int begin, int end)
/*     */   {
/* 478 */     if (bytes == null)
/*     */     {
/* 480 */       return null;
/*     */     }
/*     */     
/* 483 */     int len = bytes.length;
/* 484 */     if ((begin < 0) || (end > len) || (begin >= end))
/*     */     {
/* 486 */       return null;
/*     */     }
/*     */     
/* 489 */     StringBuilder sb = new StringBuilder();
/* 490 */     for (int i = begin; i < end; i++)
/*     */     {
/* 492 */       byte b = bytes[i];
/* 493 */       sb.append(HEX_CHAR_TABLE[(b >>> 4 & 0xF)]);
/* 494 */       sb.append(HEX_CHAR_TABLE[(b & 0xF)]);
/*     */     }
/* 496 */     return sb.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int hexCharToByte(char c)
/*     */   {
/* 507 */     if ((c >= '0') && (c <= '9'))
/*     */     {
/* 509 */       return c - '0';
/*     */     }
/* 511 */     c = Character.toLowerCase(c);
/* 512 */     if ((c >= 'a') && (c <= 'f'))
/*     */     {
/* 514 */       return c - 'a' + 10;
/*     */     }
/* 516 */     throw new RuntimeException("hexCharToByte bad format char " + c);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static byte[] hexStringToBytes(String str)
/*     */   {
/* 527 */     int length = str.length() / 2;
/* 528 */     byte[] bytes = new byte[length];
/* 529 */     for (int i = 0; i < length; i++)
/*     */     {
/* 531 */       char c0 = str.charAt(i * 2);
/* 532 */       char c1 = str.charAt(i * 2 + 1);
/*     */       
/* 534 */       int b0 = hexCharToByte(c0);
/* 535 */       int b1 = hexCharToByte(c1);
/* 536 */       bytes[i] = ((byte)((b0 << 4 | b1) & 0xFF));
/*     */     }
/*     */     
/* 539 */     return bytes;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int multiply(int paramA, int paramB)
/*     */   {
/* 553 */     BigDecimal bigDecimalA = new BigDecimal(paramA);
/* 554 */     BigDecimal bigDecimalB = new BigDecimal(paramB);
/* 555 */     BigDecimal result = bigDecimalA.multiply(bigDecimalB);
/* 556 */     return result.intValueExact();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int add(int paramA, int paramB)
/*     */   {
/* 570 */     BigDecimal bigDecimalA = new BigDecimal(paramA);
/* 571 */     BigDecimal bigDecimalB = new BigDecimal(paramB);
/* 572 */     BigDecimal result = bigDecimalA.add(bigDecimalB);
/* 573 */     return result.intValueExact();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long multiply(long paramA, long paramB)
/*     */   {
/* 587 */     BigDecimal bigDecimalA = new BigDecimal(paramA);
/* 588 */     BigDecimal bigDecimalB = new BigDecimal(paramB);
/* 589 */     BigDecimal result = bigDecimalA.multiply(bigDecimalB);
/* 590 */     return result.longValueExact();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long add(long paramA, long paramB)
/*     */   {
/* 604 */     BigDecimal bigDecimalA = new BigDecimal(paramA);
/* 605 */     BigDecimal bigDecimalB = new BigDecimal(paramB);
/* 606 */     BigDecimal result = bigDecimalA.add(bigDecimalB);
/* 607 */     return result.longValueExact();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static byte[] md5(String content, String charset)
/*     */     throws NoSuchAlgorithmException, UnsupportedEncodingException
/*     */   {
/* 620 */     MessageDigest messageDigest = MessageDigest.getInstance("MD5");
/* 621 */     messageDigest.reset();
/* 622 */     messageDigest.update(content.getBytes(charset));
/* 623 */     return messageDigest.digest();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\CommonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */