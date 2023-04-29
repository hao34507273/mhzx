/*     */ package mzm.gsp.masswedding.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SMassWeddingConsts
/*     */ {
/*  13 */   private static volatile SMassWeddingConsts oldInstance = null;
/*     */   
/*  15 */   private static SMassWeddingConsts instance = new SMassWeddingConsts();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SMassWeddingConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SMassWeddingConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int activityid = 350000403;
/*  32 */   public int mapid = 330000908;
/*  33 */   public int outMapid = 330000908;
/*  34 */   public int waiterNpc = 150112026;
/*  35 */   public int signUpServiceid = 150210011;
/*  36 */   public int maxCouple = 10;
/*  37 */   public int minCouple = 2;
/*  38 */   public int maxCacheCouples = 100;
/*  39 */   public int minPrice = 18888;
/*  40 */   public int coupleNotEnoughMailid = 340005405;
/*  41 */   public int notInTopNMailid = 340005406;
/*  42 */   public int outOfRankMailid = 340005407;
/*  43 */   public int leaveMailId = 340005407;
/*  44 */   public int serverReasonMailid = 340005407;
/*  45 */   public int lukeyBlesserMailid = 0;
/*  46 */   public int prepareMinute = 15;
/*  47 */   public int marryMinute = 15;
/*  48 */   public int robMarriageMinute = 15;
/*  49 */   public int rainAwardid = 0;
/*  50 */   public int rainAwardSec = 60;
/*  51 */   public int marryIntervalSec = 10;
/*  52 */   public int marrySpeed = 200;
/*  53 */   public int pointScacle = 200;
/*  54 */   public int blessAwardid = 0;
/*  55 */   public int luckyBlesserAwardid = 0;
/*  56 */   public int coupleAwardid = 0;
/*  57 */   public int robWinAwardid = 0;
/*  58 */   public int robFailAwardid = 0;
/*  59 */   public int supportSub = 40;
/*  60 */   public int luckyBlesserSec = 10;
/*  61 */   public int redGiftIntervalSec = 120;
/*  62 */   public int autoGetRedGiftSec = 5;
/*  63 */   public int randomRedGiftCfgid = 192100000;
/*  64 */   public int maleBuff = 701204005;
/*  65 */   public int femaleBuff = 701204006;
/*  66 */   public int mapRedGiftIntervalSec = 90;
/*  67 */   public int mapRedGiftControlid = 0;
/*  68 */   public int mapRedGiftControlNum = 0;
/*  69 */   public int massweddingBuffid = 0;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  73 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  78 */     String path = dir + "mzm.gsp.masswedding.confbean.SMassWeddingConsts.xml";
/*     */     try
/*     */     {
/*  81 */       SAXReader reader = new SAXReader();
/*  82 */       org.dom4j.Document doc = reader.read(new File(path));
/*  83 */       Element root = doc.getRootElement();
/*  84 */       Map<String, Element> data = new java.util.HashMap();
/*  85 */       java.util.List<?> nodeList = root.elements();
/*  86 */       int len = nodeList.size();
/*  87 */       for (int i = 0; i < len; i++)
/*     */       {
/*  89 */         Element element = (Element)nodeList.get(i);
/*  90 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  93 */           String name = element.attributeValue("name");
/*  94 */           if (data.put(name, element) != null)
/*  95 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  98 */       this.activityid = Integer.valueOf(((Element)data.get("activityid")).attributeValue("value")).intValue();
/*  99 */       this.mapid = Integer.valueOf(((Element)data.get("mapid")).attributeValue("value")).intValue();
/* 100 */       this.outMapid = Integer.valueOf(((Element)data.get("outMapid")).attributeValue("value")).intValue();
/* 101 */       this.waiterNpc = Integer.valueOf(((Element)data.get("waiterNpc")).attributeValue("value")).intValue();
/* 102 */       this.signUpServiceid = Integer.valueOf(((Element)data.get("signUpServiceid")).attributeValue("value")).intValue();
/* 103 */       this.maxCouple = Integer.valueOf(((Element)data.get("maxCouple")).attributeValue("value")).intValue();
/* 104 */       this.minCouple = Integer.valueOf(((Element)data.get("minCouple")).attributeValue("value")).intValue();
/* 105 */       this.maxCacheCouples = Integer.valueOf(((Element)data.get("maxCacheCouples")).attributeValue("value")).intValue();
/* 106 */       this.minPrice = Integer.valueOf(((Element)data.get("minPrice")).attributeValue("value")).intValue();
/* 107 */       this.coupleNotEnoughMailid = Integer.valueOf(((Element)data.get("coupleNotEnoughMailid")).attributeValue("value")).intValue();
/* 108 */       this.notInTopNMailid = Integer.valueOf(((Element)data.get("notInTopNMailid")).attributeValue("value")).intValue();
/* 109 */       this.outOfRankMailid = Integer.valueOf(((Element)data.get("outOfRankMailid")).attributeValue("value")).intValue();
/* 110 */       this.leaveMailId = Integer.valueOf(((Element)data.get("leaveMailId")).attributeValue("value")).intValue();
/* 111 */       this.serverReasonMailid = Integer.valueOf(((Element)data.get("serverReasonMailid")).attributeValue("value")).intValue();
/* 112 */       this.lukeyBlesserMailid = Integer.valueOf(((Element)data.get("lukeyBlesserMailid")).attributeValue("value")).intValue();
/* 113 */       this.prepareMinute = Integer.valueOf(((Element)data.get("prepareMinute")).attributeValue("value")).intValue();
/* 114 */       this.marryMinute = Integer.valueOf(((Element)data.get("marryMinute")).attributeValue("value")).intValue();
/* 115 */       this.robMarriageMinute = Integer.valueOf(((Element)data.get("robMarriageMinute")).attributeValue("value")).intValue();
/* 116 */       this.rainAwardid = Integer.valueOf(((Element)data.get("rainAwardid")).attributeValue("value")).intValue();
/* 117 */       this.rainAwardSec = Integer.valueOf(((Element)data.get("rainAwardSec")).attributeValue("value")).intValue();
/* 118 */       this.marryIntervalSec = Integer.valueOf(((Element)data.get("marryIntervalSec")).attributeValue("value")).intValue();
/* 119 */       this.marrySpeed = Integer.valueOf(((Element)data.get("marrySpeed")).attributeValue("value")).intValue();
/* 120 */       this.pointScacle = Integer.valueOf(((Element)data.get("pointScacle")).attributeValue("value")).intValue();
/* 121 */       this.blessAwardid = Integer.valueOf(((Element)data.get("blessAwardid")).attributeValue("value")).intValue();
/* 122 */       this.luckyBlesserAwardid = Integer.valueOf(((Element)data.get("luckyBlesserAwardid")).attributeValue("value")).intValue();
/* 123 */       this.coupleAwardid = Integer.valueOf(((Element)data.get("coupleAwardid")).attributeValue("value")).intValue();
/* 124 */       this.robWinAwardid = Integer.valueOf(((Element)data.get("robWinAwardid")).attributeValue("value")).intValue();
/* 125 */       this.robFailAwardid = Integer.valueOf(((Element)data.get("robFailAwardid")).attributeValue("value")).intValue();
/* 126 */       this.supportSub = Integer.valueOf(((Element)data.get("supportSub")).attributeValue("value")).intValue();
/* 127 */       this.luckyBlesserSec = Integer.valueOf(((Element)data.get("luckyBlesserSec")).attributeValue("value")).intValue();
/* 128 */       this.redGiftIntervalSec = Integer.valueOf(((Element)data.get("redGiftIntervalSec")).attributeValue("value")).intValue();
/* 129 */       this.autoGetRedGiftSec = Integer.valueOf(((Element)data.get("autoGetRedGiftSec")).attributeValue("value")).intValue();
/* 130 */       this.randomRedGiftCfgid = Integer.valueOf(((Element)data.get("randomRedGiftCfgid")).attributeValue("value")).intValue();
/* 131 */       this.maleBuff = Integer.valueOf(((Element)data.get("maleBuff")).attributeValue("value")).intValue();
/* 132 */       this.femaleBuff = Integer.valueOf(((Element)data.get("femaleBuff")).attributeValue("value")).intValue();
/* 133 */       this.mapRedGiftIntervalSec = Integer.valueOf(((Element)data.get("mapRedGiftIntervalSec")).attributeValue("value")).intValue();
/* 134 */       this.mapRedGiftControlid = Integer.valueOf(((Element)data.get("mapRedGiftControlid")).attributeValue("value")).intValue();
/* 135 */       this.mapRedGiftControlNum = Integer.valueOf(((Element)data.get("mapRedGiftControlNum")).attributeValue("value")).intValue();
/* 136 */       this.massweddingBuffid = Integer.valueOf(((Element)data.get("massweddingBuffid")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 140 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 145 */     String path = dir + "mzm.gsp.masswedding.confbean.SMassWeddingConsts.xml";
/*     */     try
/*     */     {
/* 148 */       SAXReader reader = new SAXReader();
/* 149 */       org.dom4j.Document doc = reader.read(new File(path));
/* 150 */       Element root = doc.getRootElement();
/* 151 */       Map<String, Element> data = new java.util.HashMap();
/* 152 */       java.util.List<?> nodeList = root.elements();
/* 153 */       int len = nodeList.size();
/* 154 */       for (int i = 0; i < len; i++)
/*     */       {
/* 156 */         Element element = (Element)nodeList.get(i);
/* 157 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 160 */           String name = element.attributeValue("name");
/* 161 */           if (data.put(name, element) != null)
/* 162 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 165 */       this.activityid = Integer.valueOf(((Element)data.get("activityid")).attributeValue("value")).intValue();
/* 166 */       this.mapid = Integer.valueOf(((Element)data.get("mapid")).attributeValue("value")).intValue();
/* 167 */       this.outMapid = Integer.valueOf(((Element)data.get("outMapid")).attributeValue("value")).intValue();
/* 168 */       this.waiterNpc = Integer.valueOf(((Element)data.get("waiterNpc")).attributeValue("value")).intValue();
/* 169 */       this.signUpServiceid = Integer.valueOf(((Element)data.get("signUpServiceid")).attributeValue("value")).intValue();
/* 170 */       this.maxCouple = Integer.valueOf(((Element)data.get("maxCouple")).attributeValue("value")).intValue();
/* 171 */       this.minCouple = Integer.valueOf(((Element)data.get("minCouple")).attributeValue("value")).intValue();
/* 172 */       this.maxCacheCouples = Integer.valueOf(((Element)data.get("maxCacheCouples")).attributeValue("value")).intValue();
/* 173 */       this.minPrice = Integer.valueOf(((Element)data.get("minPrice")).attributeValue("value")).intValue();
/* 174 */       this.coupleNotEnoughMailid = Integer.valueOf(((Element)data.get("coupleNotEnoughMailid")).attributeValue("value")).intValue();
/* 175 */       this.notInTopNMailid = Integer.valueOf(((Element)data.get("notInTopNMailid")).attributeValue("value")).intValue();
/* 176 */       this.outOfRankMailid = Integer.valueOf(((Element)data.get("outOfRankMailid")).attributeValue("value")).intValue();
/* 177 */       this.leaveMailId = Integer.valueOf(((Element)data.get("leaveMailId")).attributeValue("value")).intValue();
/* 178 */       this.serverReasonMailid = Integer.valueOf(((Element)data.get("serverReasonMailid")).attributeValue("value")).intValue();
/* 179 */       this.lukeyBlesserMailid = Integer.valueOf(((Element)data.get("lukeyBlesserMailid")).attributeValue("value")).intValue();
/* 180 */       this.prepareMinute = Integer.valueOf(((Element)data.get("prepareMinute")).attributeValue("value")).intValue();
/* 181 */       this.marryMinute = Integer.valueOf(((Element)data.get("marryMinute")).attributeValue("value")).intValue();
/* 182 */       this.robMarriageMinute = Integer.valueOf(((Element)data.get("robMarriageMinute")).attributeValue("value")).intValue();
/* 183 */       this.rainAwardid = Integer.valueOf(((Element)data.get("rainAwardid")).attributeValue("value")).intValue();
/* 184 */       this.rainAwardSec = Integer.valueOf(((Element)data.get("rainAwardSec")).attributeValue("value")).intValue();
/* 185 */       this.marryIntervalSec = Integer.valueOf(((Element)data.get("marryIntervalSec")).attributeValue("value")).intValue();
/* 186 */       this.marrySpeed = Integer.valueOf(((Element)data.get("marrySpeed")).attributeValue("value")).intValue();
/* 187 */       this.pointScacle = Integer.valueOf(((Element)data.get("pointScacle")).attributeValue("value")).intValue();
/* 188 */       this.blessAwardid = Integer.valueOf(((Element)data.get("blessAwardid")).attributeValue("value")).intValue();
/* 189 */       this.luckyBlesserAwardid = Integer.valueOf(((Element)data.get("luckyBlesserAwardid")).attributeValue("value")).intValue();
/* 190 */       this.coupleAwardid = Integer.valueOf(((Element)data.get("coupleAwardid")).attributeValue("value")).intValue();
/* 191 */       this.robWinAwardid = Integer.valueOf(((Element)data.get("robWinAwardid")).attributeValue("value")).intValue();
/* 192 */       this.robFailAwardid = Integer.valueOf(((Element)data.get("robFailAwardid")).attributeValue("value")).intValue();
/* 193 */       this.supportSub = Integer.valueOf(((Element)data.get("supportSub")).attributeValue("value")).intValue();
/* 194 */       this.luckyBlesserSec = Integer.valueOf(((Element)data.get("luckyBlesserSec")).attributeValue("value")).intValue();
/* 195 */       this.redGiftIntervalSec = Integer.valueOf(((Element)data.get("redGiftIntervalSec")).attributeValue("value")).intValue();
/* 196 */       this.autoGetRedGiftSec = Integer.valueOf(((Element)data.get("autoGetRedGiftSec")).attributeValue("value")).intValue();
/* 197 */       this.randomRedGiftCfgid = Integer.valueOf(((Element)data.get("randomRedGiftCfgid")).attributeValue("value")).intValue();
/* 198 */       this.maleBuff = Integer.valueOf(((Element)data.get("maleBuff")).attributeValue("value")).intValue();
/* 199 */       this.femaleBuff = Integer.valueOf(((Element)data.get("femaleBuff")).attributeValue("value")).intValue();
/* 200 */       this.mapRedGiftIntervalSec = Integer.valueOf(((Element)data.get("mapRedGiftIntervalSec")).attributeValue("value")).intValue();
/* 201 */       this.mapRedGiftControlid = Integer.valueOf(((Element)data.get("mapRedGiftControlid")).attributeValue("value")).intValue();
/* 202 */       this.mapRedGiftControlNum = Integer.valueOf(((Element)data.get("mapRedGiftControlNum")).attributeValue("value")).intValue();
/* 203 */       this.massweddingBuffid = Integer.valueOf(((Element)data.get("massweddingBuffid")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 207 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 211 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 214 */     String path = dir + "mzm.gsp.masswedding.confbean.SMassWeddingConsts.bny";
/*     */     try
/*     */     {
/* 217 */       File file = new File(path);
/* 218 */       if (file.exists())
/*     */       {
/* 220 */         byte[] bytes = new byte['Ѐ'];
/* 221 */         FileInputStream fis = new FileInputStream(file);
/* 222 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 223 */         int len = 0;
/* 224 */         while ((len = fis.read(bytes)) > 0)
/* 225 */           baos.write(bytes, 0, len);
/* 226 */         fis.close();
/* 227 */         bytes = baos.toByteArray();
/* 228 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 229 */         this.activityid = _os_.unmarshal_int();
/* 230 */         this.mapid = _os_.unmarshal_int();
/* 231 */         this.outMapid = _os_.unmarshal_int();
/* 232 */         this.waiterNpc = _os_.unmarshal_int();
/* 233 */         this.signUpServiceid = _os_.unmarshal_int();
/* 234 */         this.maxCouple = _os_.unmarshal_int();
/* 235 */         this.minCouple = _os_.unmarshal_int();
/* 236 */         this.maxCacheCouples = _os_.unmarshal_int();
/* 237 */         this.minPrice = _os_.unmarshal_int();
/* 238 */         this.coupleNotEnoughMailid = _os_.unmarshal_int();
/* 239 */         this.notInTopNMailid = _os_.unmarshal_int();
/* 240 */         this.outOfRankMailid = _os_.unmarshal_int();
/* 241 */         this.leaveMailId = _os_.unmarshal_int();
/* 242 */         this.serverReasonMailid = _os_.unmarshal_int();
/* 243 */         this.lukeyBlesserMailid = _os_.unmarshal_int();
/* 244 */         this.prepareMinute = _os_.unmarshal_int();
/* 245 */         this.marryMinute = _os_.unmarshal_int();
/* 246 */         this.robMarriageMinute = _os_.unmarshal_int();
/* 247 */         this.rainAwardid = _os_.unmarshal_int();
/* 248 */         this.rainAwardSec = _os_.unmarshal_int();
/* 249 */         this.marryIntervalSec = _os_.unmarshal_int();
/* 250 */         this.marrySpeed = _os_.unmarshal_int();
/* 251 */         this.pointScacle = _os_.unmarshal_int();
/* 252 */         this.blessAwardid = _os_.unmarshal_int();
/* 253 */         this.luckyBlesserAwardid = _os_.unmarshal_int();
/* 254 */         this.coupleAwardid = _os_.unmarshal_int();
/* 255 */         this.robWinAwardid = _os_.unmarshal_int();
/* 256 */         this.robFailAwardid = _os_.unmarshal_int();
/* 257 */         this.supportSub = _os_.unmarshal_int();
/* 258 */         this.luckyBlesserSec = _os_.unmarshal_int();
/* 259 */         this.redGiftIntervalSec = _os_.unmarshal_int();
/* 260 */         this.autoGetRedGiftSec = _os_.unmarshal_int();
/* 261 */         this.randomRedGiftCfgid = _os_.unmarshal_int();
/* 262 */         this.maleBuff = _os_.unmarshal_int();
/* 263 */         this.femaleBuff = _os_.unmarshal_int();
/* 264 */         this.mapRedGiftIntervalSec = _os_.unmarshal_int();
/* 265 */         this.mapRedGiftControlid = _os_.unmarshal_int();
/* 266 */         this.mapRedGiftControlNum = _os_.unmarshal_int();
/* 267 */         this.massweddingBuffid = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 272 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 278 */     String path = dir + "mzm.gsp.masswedding.confbean.SMassWeddingConsts.bny";
/*     */     try
/*     */     {
/* 281 */       File file = new File(path);
/* 282 */       if (file.exists())
/*     */       {
/* 284 */         byte[] bytes = new byte['Ѐ'];
/* 285 */         FileInputStream fis = new FileInputStream(file);
/* 286 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 287 */         int len = 0;
/* 288 */         while ((len = fis.read(bytes)) > 0)
/* 289 */           baos.write(bytes, 0, len);
/* 290 */         fis.close();
/* 291 */         bytes = baos.toByteArray();
/* 292 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 293 */         this.activityid = _os_.unmarshal_int();
/* 294 */         this.mapid = _os_.unmarshal_int();
/* 295 */         this.outMapid = _os_.unmarshal_int();
/* 296 */         this.waiterNpc = _os_.unmarshal_int();
/* 297 */         this.signUpServiceid = _os_.unmarshal_int();
/* 298 */         this.maxCouple = _os_.unmarshal_int();
/* 299 */         this.minCouple = _os_.unmarshal_int();
/* 300 */         this.maxCacheCouples = _os_.unmarshal_int();
/* 301 */         this.minPrice = _os_.unmarshal_int();
/* 302 */         this.coupleNotEnoughMailid = _os_.unmarshal_int();
/* 303 */         this.notInTopNMailid = _os_.unmarshal_int();
/* 304 */         this.outOfRankMailid = _os_.unmarshal_int();
/* 305 */         this.leaveMailId = _os_.unmarshal_int();
/* 306 */         this.serverReasonMailid = _os_.unmarshal_int();
/* 307 */         this.lukeyBlesserMailid = _os_.unmarshal_int();
/* 308 */         this.prepareMinute = _os_.unmarshal_int();
/* 309 */         this.marryMinute = _os_.unmarshal_int();
/* 310 */         this.robMarriageMinute = _os_.unmarshal_int();
/* 311 */         this.rainAwardid = _os_.unmarshal_int();
/* 312 */         this.rainAwardSec = _os_.unmarshal_int();
/* 313 */         this.marryIntervalSec = _os_.unmarshal_int();
/* 314 */         this.marrySpeed = _os_.unmarshal_int();
/* 315 */         this.pointScacle = _os_.unmarshal_int();
/* 316 */         this.blessAwardid = _os_.unmarshal_int();
/* 317 */         this.luckyBlesserAwardid = _os_.unmarshal_int();
/* 318 */         this.coupleAwardid = _os_.unmarshal_int();
/* 319 */         this.robWinAwardid = _os_.unmarshal_int();
/* 320 */         this.robFailAwardid = _os_.unmarshal_int();
/* 321 */         this.supportSub = _os_.unmarshal_int();
/* 322 */         this.luckyBlesserSec = _os_.unmarshal_int();
/* 323 */         this.redGiftIntervalSec = _os_.unmarshal_int();
/* 324 */         this.autoGetRedGiftSec = _os_.unmarshal_int();
/* 325 */         this.randomRedGiftCfgid = _os_.unmarshal_int();
/* 326 */         this.maleBuff = _os_.unmarshal_int();
/* 327 */         this.femaleBuff = _os_.unmarshal_int();
/* 328 */         this.mapRedGiftIntervalSec = _os_.unmarshal_int();
/* 329 */         this.mapRedGiftControlid = _os_.unmarshal_int();
/* 330 */         this.mapRedGiftControlNum = _os_.unmarshal_int();
/* 331 */         this.massweddingBuffid = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 336 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SMassWeddingConsts newInstance)
/*     */   {
/* 342 */     oldInstance = instance;
/* 343 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 348 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\confbean\SMassWeddingConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */