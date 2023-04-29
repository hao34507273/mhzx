/*     */ package mzm.gsp.marriage.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SMarriageConsts
/*     */ {
/*  13 */   private static volatile SMarriageConsts oldInstance = null;
/*     */   
/*  15 */   private static SMarriageConsts instance = new SMarriageConsts();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SMarriageConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SMarriageConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int marriageNPC = 150100000;
/*  32 */   public int needLevel = 30;
/*  33 */   public int friendValue = 3000;
/*  34 */   public int refuseMarriageSec = 300;
/*  35 */   public int defaultTitle = 190200000;
/*  36 */   public int giftNotify = 430500000;
/*  37 */   public int divorceSilver = 30000;
/*  38 */   public int forceDivorceSilver = 300000;
/*  39 */   public int forceDivorceHour = 72;
/*  40 */   public int forceDivorceMail = 340000000;
/*  41 */   public int divorceMail = 340000000;
/*  42 */   public int cancelDivorceMail = 340000000;
/*  43 */   public int divorceFriendValue = 2000;
/*  44 */   public int forceDivorceFriendValue = 1;
/*  45 */   public int canDivorceAfterMarriageHour = 144;
/*  46 */   public int sugerControlerid = 701100000;
/*  47 */   public int marriageMapid = 330000000;
/*  48 */   public int x = 100;
/*  49 */   public int y = 100;
/*  50 */   public int giftTime = 1440;
/*  51 */   public int marriageBuffid1 = 701200000;
/*  52 */   public int coupleInteamBuffid = 701200000;
/*  53 */   public int manModelBuff = 701200000;
/*  54 */   public int womenModelBuff = 701200000;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  58 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  63 */     String path = dir + "mzm.gsp.marriage.confbean.SMarriageConsts.xml";
/*     */     try
/*     */     {
/*  66 */       SAXReader reader = new SAXReader();
/*  67 */       org.dom4j.Document doc = reader.read(new File(path));
/*  68 */       Element root = doc.getRootElement();
/*  69 */       Map<String, Element> data = new java.util.HashMap();
/*  70 */       java.util.List<?> nodeList = root.elements();
/*  71 */       int len = nodeList.size();
/*  72 */       for (int i = 0; i < len; i++)
/*     */       {
/*  74 */         Element element = (Element)nodeList.get(i);
/*  75 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  78 */           String name = element.attributeValue("name");
/*  79 */           if (data.put(name, element) != null)
/*  80 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  83 */       this.marriageNPC = Integer.valueOf(((Element)data.get("marriageNPC")).attributeValue("value")).intValue();
/*  84 */       this.needLevel = Integer.valueOf(((Element)data.get("needLevel")).attributeValue("value")).intValue();
/*  85 */       this.friendValue = Integer.valueOf(((Element)data.get("friendValue")).attributeValue("value")).intValue();
/*  86 */       this.refuseMarriageSec = Integer.valueOf(((Element)data.get("refuseMarriageSec")).attributeValue("value")).intValue();
/*  87 */       this.defaultTitle = Integer.valueOf(((Element)data.get("defaultTitle")).attributeValue("value")).intValue();
/*  88 */       this.giftNotify = Integer.valueOf(((Element)data.get("giftNotify")).attributeValue("value")).intValue();
/*  89 */       this.divorceSilver = Integer.valueOf(((Element)data.get("divorceSilver")).attributeValue("value")).intValue();
/*  90 */       this.forceDivorceSilver = Integer.valueOf(((Element)data.get("forceDivorceSilver")).attributeValue("value")).intValue();
/*  91 */       this.forceDivorceHour = Integer.valueOf(((Element)data.get("forceDivorceHour")).attributeValue("value")).intValue();
/*  92 */       this.forceDivorceMail = Integer.valueOf(((Element)data.get("forceDivorceMail")).attributeValue("value")).intValue();
/*  93 */       this.divorceMail = Integer.valueOf(((Element)data.get("divorceMail")).attributeValue("value")).intValue();
/*  94 */       this.cancelDivorceMail = Integer.valueOf(((Element)data.get("cancelDivorceMail")).attributeValue("value")).intValue();
/*  95 */       this.divorceFriendValue = Integer.valueOf(((Element)data.get("divorceFriendValue")).attributeValue("value")).intValue();
/*  96 */       this.forceDivorceFriendValue = Integer.valueOf(((Element)data.get("forceDivorceFriendValue")).attributeValue("value")).intValue();
/*  97 */       this.canDivorceAfterMarriageHour = Integer.valueOf(((Element)data.get("canDivorceAfterMarriageHour")).attributeValue("value")).intValue();
/*  98 */       this.sugerControlerid = Integer.valueOf(((Element)data.get("sugerControlerid")).attributeValue("value")).intValue();
/*  99 */       this.marriageMapid = Integer.valueOf(((Element)data.get("marriageMapid")).attributeValue("value")).intValue();
/* 100 */       this.x = Integer.valueOf(((Element)data.get("x")).attributeValue("value")).intValue();
/* 101 */       this.y = Integer.valueOf(((Element)data.get("y")).attributeValue("value")).intValue();
/* 102 */       this.giftTime = Integer.valueOf(((Element)data.get("giftTime")).attributeValue("value")).intValue();
/* 103 */       this.marriageBuffid1 = Integer.valueOf(((Element)data.get("marriageBuffid1")).attributeValue("value")).intValue();
/* 104 */       this.coupleInteamBuffid = Integer.valueOf(((Element)data.get("coupleInteamBuffid")).attributeValue("value")).intValue();
/* 105 */       this.manModelBuff = Integer.valueOf(((Element)data.get("manModelBuff")).attributeValue("value")).intValue();
/* 106 */       this.womenModelBuff = Integer.valueOf(((Element)data.get("womenModelBuff")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 110 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 115 */     String path = dir + "mzm.gsp.marriage.confbean.SMarriageConsts.xml";
/*     */     try
/*     */     {
/* 118 */       SAXReader reader = new SAXReader();
/* 119 */       org.dom4j.Document doc = reader.read(new File(path));
/* 120 */       Element root = doc.getRootElement();
/* 121 */       Map<String, Element> data = new java.util.HashMap();
/* 122 */       java.util.List<?> nodeList = root.elements();
/* 123 */       int len = nodeList.size();
/* 124 */       for (int i = 0; i < len; i++)
/*     */       {
/* 126 */         Element element = (Element)nodeList.get(i);
/* 127 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 130 */           String name = element.attributeValue("name");
/* 131 */           if (data.put(name, element) != null)
/* 132 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 135 */       this.marriageNPC = Integer.valueOf(((Element)data.get("marriageNPC")).attributeValue("value")).intValue();
/* 136 */       this.needLevel = Integer.valueOf(((Element)data.get("needLevel")).attributeValue("value")).intValue();
/* 137 */       this.friendValue = Integer.valueOf(((Element)data.get("friendValue")).attributeValue("value")).intValue();
/* 138 */       this.refuseMarriageSec = Integer.valueOf(((Element)data.get("refuseMarriageSec")).attributeValue("value")).intValue();
/* 139 */       this.defaultTitle = Integer.valueOf(((Element)data.get("defaultTitle")).attributeValue("value")).intValue();
/* 140 */       this.giftNotify = Integer.valueOf(((Element)data.get("giftNotify")).attributeValue("value")).intValue();
/* 141 */       this.divorceSilver = Integer.valueOf(((Element)data.get("divorceSilver")).attributeValue("value")).intValue();
/* 142 */       this.forceDivorceSilver = Integer.valueOf(((Element)data.get("forceDivorceSilver")).attributeValue("value")).intValue();
/* 143 */       this.forceDivorceHour = Integer.valueOf(((Element)data.get("forceDivorceHour")).attributeValue("value")).intValue();
/* 144 */       this.forceDivorceMail = Integer.valueOf(((Element)data.get("forceDivorceMail")).attributeValue("value")).intValue();
/* 145 */       this.divorceMail = Integer.valueOf(((Element)data.get("divorceMail")).attributeValue("value")).intValue();
/* 146 */       this.cancelDivorceMail = Integer.valueOf(((Element)data.get("cancelDivorceMail")).attributeValue("value")).intValue();
/* 147 */       this.divorceFriendValue = Integer.valueOf(((Element)data.get("divorceFriendValue")).attributeValue("value")).intValue();
/* 148 */       this.forceDivorceFriendValue = Integer.valueOf(((Element)data.get("forceDivorceFriendValue")).attributeValue("value")).intValue();
/* 149 */       this.canDivorceAfterMarriageHour = Integer.valueOf(((Element)data.get("canDivorceAfterMarriageHour")).attributeValue("value")).intValue();
/* 150 */       this.sugerControlerid = Integer.valueOf(((Element)data.get("sugerControlerid")).attributeValue("value")).intValue();
/* 151 */       this.marriageMapid = Integer.valueOf(((Element)data.get("marriageMapid")).attributeValue("value")).intValue();
/* 152 */       this.x = Integer.valueOf(((Element)data.get("x")).attributeValue("value")).intValue();
/* 153 */       this.y = Integer.valueOf(((Element)data.get("y")).attributeValue("value")).intValue();
/* 154 */       this.giftTime = Integer.valueOf(((Element)data.get("giftTime")).attributeValue("value")).intValue();
/* 155 */       this.marriageBuffid1 = Integer.valueOf(((Element)data.get("marriageBuffid1")).attributeValue("value")).intValue();
/* 156 */       this.coupleInteamBuffid = Integer.valueOf(((Element)data.get("coupleInteamBuffid")).attributeValue("value")).intValue();
/* 157 */       this.manModelBuff = Integer.valueOf(((Element)data.get("manModelBuff")).attributeValue("value")).intValue();
/* 158 */       this.womenModelBuff = Integer.valueOf(((Element)data.get("womenModelBuff")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 162 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 166 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 169 */     String path = dir + "mzm.gsp.marriage.confbean.SMarriageConsts.bny";
/*     */     try
/*     */     {
/* 172 */       File file = new File(path);
/* 173 */       if (file.exists())
/*     */       {
/* 175 */         byte[] bytes = new byte['Ѐ'];
/* 176 */         FileInputStream fis = new FileInputStream(file);
/* 177 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 178 */         int len = 0;
/* 179 */         while ((len = fis.read(bytes)) > 0)
/* 180 */           baos.write(bytes, 0, len);
/* 181 */         fis.close();
/* 182 */         bytes = baos.toByteArray();
/* 183 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 184 */         this.marriageNPC = _os_.unmarshal_int();
/* 185 */         this.needLevel = _os_.unmarshal_int();
/* 186 */         this.friendValue = _os_.unmarshal_int();
/* 187 */         this.refuseMarriageSec = _os_.unmarshal_int();
/* 188 */         this.defaultTitle = _os_.unmarshal_int();
/* 189 */         this.giftNotify = _os_.unmarshal_int();
/* 190 */         this.divorceSilver = _os_.unmarshal_int();
/* 191 */         this.forceDivorceSilver = _os_.unmarshal_int();
/* 192 */         this.forceDivorceHour = _os_.unmarshal_int();
/* 193 */         this.forceDivorceMail = _os_.unmarshal_int();
/* 194 */         this.divorceMail = _os_.unmarshal_int();
/* 195 */         this.cancelDivorceMail = _os_.unmarshal_int();
/* 196 */         this.divorceFriendValue = _os_.unmarshal_int();
/* 197 */         this.forceDivorceFriendValue = _os_.unmarshal_int();
/* 198 */         this.canDivorceAfterMarriageHour = _os_.unmarshal_int();
/* 199 */         this.sugerControlerid = _os_.unmarshal_int();
/* 200 */         this.marriageMapid = _os_.unmarshal_int();
/* 201 */         this.x = _os_.unmarshal_int();
/* 202 */         this.y = _os_.unmarshal_int();
/* 203 */         this.giftTime = _os_.unmarshal_int();
/* 204 */         this.marriageBuffid1 = _os_.unmarshal_int();
/* 205 */         this.coupleInteamBuffid = _os_.unmarshal_int();
/* 206 */         this.manModelBuff = _os_.unmarshal_int();
/* 207 */         this.womenModelBuff = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 212 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 218 */     String path = dir + "mzm.gsp.marriage.confbean.SMarriageConsts.bny";
/*     */     try
/*     */     {
/* 221 */       File file = new File(path);
/* 222 */       if (file.exists())
/*     */       {
/* 224 */         byte[] bytes = new byte['Ѐ'];
/* 225 */         FileInputStream fis = new FileInputStream(file);
/* 226 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 227 */         int len = 0;
/* 228 */         while ((len = fis.read(bytes)) > 0)
/* 229 */           baos.write(bytes, 0, len);
/* 230 */         fis.close();
/* 231 */         bytes = baos.toByteArray();
/* 232 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 233 */         this.marriageNPC = _os_.unmarshal_int();
/* 234 */         this.needLevel = _os_.unmarshal_int();
/* 235 */         this.friendValue = _os_.unmarshal_int();
/* 236 */         this.refuseMarriageSec = _os_.unmarshal_int();
/* 237 */         this.defaultTitle = _os_.unmarshal_int();
/* 238 */         this.giftNotify = _os_.unmarshal_int();
/* 239 */         this.divorceSilver = _os_.unmarshal_int();
/* 240 */         this.forceDivorceSilver = _os_.unmarshal_int();
/* 241 */         this.forceDivorceHour = _os_.unmarshal_int();
/* 242 */         this.forceDivorceMail = _os_.unmarshal_int();
/* 243 */         this.divorceMail = _os_.unmarshal_int();
/* 244 */         this.cancelDivorceMail = _os_.unmarshal_int();
/* 245 */         this.divorceFriendValue = _os_.unmarshal_int();
/* 246 */         this.forceDivorceFriendValue = _os_.unmarshal_int();
/* 247 */         this.canDivorceAfterMarriageHour = _os_.unmarshal_int();
/* 248 */         this.sugerControlerid = _os_.unmarshal_int();
/* 249 */         this.marriageMapid = _os_.unmarshal_int();
/* 250 */         this.x = _os_.unmarshal_int();
/* 251 */         this.y = _os_.unmarshal_int();
/* 252 */         this.giftTime = _os_.unmarshal_int();
/* 253 */         this.marriageBuffid1 = _os_.unmarshal_int();
/* 254 */         this.coupleInteamBuffid = _os_.unmarshal_int();
/* 255 */         this.manModelBuff = _os_.unmarshal_int();
/* 256 */         this.womenModelBuff = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 261 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SMarriageConsts newInstance)
/*     */   {
/* 267 */     oldInstance = instance;
/* 268 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 273 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\confbean\SMarriageConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */