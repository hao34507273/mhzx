/*     */ package mzm.gsp.partner.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class PartnerConstants
/*     */ {
/*  13 */   private static volatile PartnerConstants oldInstance = null;
/*     */   
/*  15 */   private static PartnerConstants instance = new PartnerConstants();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static PartnerConstants getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static PartnerConstants getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int OPEN_LEVEL = 5;
/*  32 */   public int ITEM_ID = 210101000;
/*  33 */   public int ITEM_TYPE_ID = 210000034;
/*  34 */   public int FIGHT_NUM = 4;
/*  35 */   public int WASHGOLD_NUM = 50;
/*  36 */   public int LOVE_NUM = 2;
/*  37 */   public int NULL_LOVE_ID = 140500000;
/*  38 */   public int RECOVERY_MAIL_ID = 340001803;
/*  39 */   public int RECOVERY_DISCOUNT = 8000;
/*  40 */   public double PARTNER_LV_RET = 1.0D;
/*  41 */   public double YUAN_LV_RET = 1.0D;
/*  42 */   public int YUAN_LV_MAX = 30;
/*  43 */   public int loveRankHighFontColorR = 255;
/*  44 */   public int loveRankHighFontColorG = 255;
/*  45 */   public int loveRankHighFontColorB = 255;
/*  46 */   public int loveRankNormalFontColorR = 255;
/*  47 */   public int loveRankNormalFontColorG = 255;
/*  48 */   public int loveRankNormalFontColorB = 255;
/*  49 */   public int loveRankLowFontColorR = 255;
/*  50 */   public int loveRankLowFontColorG = 255;
/*  51 */   public int loveRankLowFontColorB = 255;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  55 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  60 */     String path = dir + "mzm.gsp.partner.confbean.PartnerConstants.xml";
/*     */     try
/*     */     {
/*  63 */       SAXReader reader = new SAXReader();
/*  64 */       org.dom4j.Document doc = reader.read(new File(path));
/*  65 */       Element root = doc.getRootElement();
/*  66 */       Map<String, Element> data = new java.util.HashMap();
/*  67 */       java.util.List<?> nodeList = root.elements();
/*  68 */       int len = nodeList.size();
/*  69 */       for (int i = 0; i < len; i++)
/*     */       {
/*  71 */         Element element = (Element)nodeList.get(i);
/*  72 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  75 */           String name = element.attributeValue("name");
/*  76 */           if (data.put(name, element) != null)
/*  77 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  80 */       this.OPEN_LEVEL = Integer.valueOf(((Element)data.get("OPEN_LEVEL")).attributeValue("value")).intValue();
/*  81 */       this.ITEM_ID = Integer.valueOf(((Element)data.get("ITEM_ID")).attributeValue("value")).intValue();
/*  82 */       this.ITEM_TYPE_ID = Integer.valueOf(((Element)data.get("ITEM_TYPE_ID")).attributeValue("value")).intValue();
/*  83 */       this.FIGHT_NUM = Integer.valueOf(((Element)data.get("FIGHT_NUM")).attributeValue("value")).intValue();
/*  84 */       this.WASHGOLD_NUM = Integer.valueOf(((Element)data.get("WASHGOLD_NUM")).attributeValue("value")).intValue();
/*  85 */       this.LOVE_NUM = Integer.valueOf(((Element)data.get("LOVE_NUM")).attributeValue("value")).intValue();
/*  86 */       this.NULL_LOVE_ID = Integer.valueOf(((Element)data.get("NULL_LOVE_ID")).attributeValue("value")).intValue();
/*  87 */       this.RECOVERY_MAIL_ID = Integer.valueOf(((Element)data.get("RECOVERY_MAIL_ID")).attributeValue("value")).intValue();
/*  88 */       this.RECOVERY_DISCOUNT = Integer.valueOf(((Element)data.get("RECOVERY_DISCOUNT")).attributeValue("value")).intValue();
/*  89 */       this.PARTNER_LV_RET = Double.valueOf(((Element)data.get("PARTNER_LV_RET")).attributeValue("value")).doubleValue();
/*  90 */       this.YUAN_LV_RET = Double.valueOf(((Element)data.get("YUAN_LV_RET")).attributeValue("value")).doubleValue();
/*  91 */       this.YUAN_LV_MAX = Integer.valueOf(((Element)data.get("YUAN_LV_MAX")).attributeValue("value")).intValue();
/*  92 */       this.loveRankHighFontColorR = Integer.valueOf(((Element)data.get("loveRankHighFontColorR")).attributeValue("value")).intValue();
/*  93 */       this.loveRankHighFontColorG = Integer.valueOf(((Element)data.get("loveRankHighFontColorG")).attributeValue("value")).intValue();
/*  94 */       this.loveRankHighFontColorB = Integer.valueOf(((Element)data.get("loveRankHighFontColorB")).attributeValue("value")).intValue();
/*  95 */       this.loveRankNormalFontColorR = Integer.valueOf(((Element)data.get("loveRankNormalFontColorR")).attributeValue("value")).intValue();
/*  96 */       this.loveRankNormalFontColorG = Integer.valueOf(((Element)data.get("loveRankNormalFontColorG")).attributeValue("value")).intValue();
/*  97 */       this.loveRankNormalFontColorB = Integer.valueOf(((Element)data.get("loveRankNormalFontColorB")).attributeValue("value")).intValue();
/*  98 */       this.loveRankLowFontColorR = Integer.valueOf(((Element)data.get("loveRankLowFontColorR")).attributeValue("value")).intValue();
/*  99 */       this.loveRankLowFontColorG = Integer.valueOf(((Element)data.get("loveRankLowFontColorG")).attributeValue("value")).intValue();
/* 100 */       this.loveRankLowFontColorB = Integer.valueOf(((Element)data.get("loveRankLowFontColorB")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 104 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 109 */     String path = dir + "mzm.gsp.partner.confbean.PartnerConstants.xml";
/*     */     try
/*     */     {
/* 112 */       SAXReader reader = new SAXReader();
/* 113 */       org.dom4j.Document doc = reader.read(new File(path));
/* 114 */       Element root = doc.getRootElement();
/* 115 */       Map<String, Element> data = new java.util.HashMap();
/* 116 */       java.util.List<?> nodeList = root.elements();
/* 117 */       int len = nodeList.size();
/* 118 */       for (int i = 0; i < len; i++)
/*     */       {
/* 120 */         Element element = (Element)nodeList.get(i);
/* 121 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 124 */           String name = element.attributeValue("name");
/* 125 */           if (data.put(name, element) != null)
/* 126 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 129 */       this.OPEN_LEVEL = Integer.valueOf(((Element)data.get("OPEN_LEVEL")).attributeValue("value")).intValue();
/* 130 */       this.ITEM_ID = Integer.valueOf(((Element)data.get("ITEM_ID")).attributeValue("value")).intValue();
/* 131 */       this.ITEM_TYPE_ID = Integer.valueOf(((Element)data.get("ITEM_TYPE_ID")).attributeValue("value")).intValue();
/* 132 */       this.FIGHT_NUM = Integer.valueOf(((Element)data.get("FIGHT_NUM")).attributeValue("value")).intValue();
/* 133 */       this.WASHGOLD_NUM = Integer.valueOf(((Element)data.get("WASHGOLD_NUM")).attributeValue("value")).intValue();
/* 134 */       this.LOVE_NUM = Integer.valueOf(((Element)data.get("LOVE_NUM")).attributeValue("value")).intValue();
/* 135 */       this.NULL_LOVE_ID = Integer.valueOf(((Element)data.get("NULL_LOVE_ID")).attributeValue("value")).intValue();
/* 136 */       this.RECOVERY_MAIL_ID = Integer.valueOf(((Element)data.get("RECOVERY_MAIL_ID")).attributeValue("value")).intValue();
/* 137 */       this.RECOVERY_DISCOUNT = Integer.valueOf(((Element)data.get("RECOVERY_DISCOUNT")).attributeValue("value")).intValue();
/* 138 */       this.PARTNER_LV_RET = Double.valueOf(((Element)data.get("PARTNER_LV_RET")).attributeValue("value")).doubleValue();
/* 139 */       this.YUAN_LV_RET = Double.valueOf(((Element)data.get("YUAN_LV_RET")).attributeValue("value")).doubleValue();
/* 140 */       this.YUAN_LV_MAX = Integer.valueOf(((Element)data.get("YUAN_LV_MAX")).attributeValue("value")).intValue();
/* 141 */       this.loveRankHighFontColorR = Integer.valueOf(((Element)data.get("loveRankHighFontColorR")).attributeValue("value")).intValue();
/* 142 */       this.loveRankHighFontColorG = Integer.valueOf(((Element)data.get("loveRankHighFontColorG")).attributeValue("value")).intValue();
/* 143 */       this.loveRankHighFontColorB = Integer.valueOf(((Element)data.get("loveRankHighFontColorB")).attributeValue("value")).intValue();
/* 144 */       this.loveRankNormalFontColorR = Integer.valueOf(((Element)data.get("loveRankNormalFontColorR")).attributeValue("value")).intValue();
/* 145 */       this.loveRankNormalFontColorG = Integer.valueOf(((Element)data.get("loveRankNormalFontColorG")).attributeValue("value")).intValue();
/* 146 */       this.loveRankNormalFontColorB = Integer.valueOf(((Element)data.get("loveRankNormalFontColorB")).attributeValue("value")).intValue();
/* 147 */       this.loveRankLowFontColorR = Integer.valueOf(((Element)data.get("loveRankLowFontColorR")).attributeValue("value")).intValue();
/* 148 */       this.loveRankLowFontColorG = Integer.valueOf(((Element)data.get("loveRankLowFontColorG")).attributeValue("value")).intValue();
/* 149 */       this.loveRankLowFontColorB = Integer.valueOf(((Element)data.get("loveRankLowFontColorB")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 153 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 157 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 160 */     String path = dir + "mzm.gsp.partner.confbean.PartnerConstants.bny";
/*     */     try
/*     */     {
/* 163 */       File file = new File(path);
/* 164 */       if (file.exists())
/*     */       {
/* 166 */         byte[] bytes = new byte['Ѐ'];
/* 167 */         FileInputStream fis = new FileInputStream(file);
/* 168 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 169 */         int len = 0;
/* 170 */         while ((len = fis.read(bytes)) > 0)
/* 171 */           baos.write(bytes, 0, len);
/* 172 */         fis.close();
/* 173 */         bytes = baos.toByteArray();
/* 174 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 175 */         this.OPEN_LEVEL = _os_.unmarshal_int();
/* 176 */         this.ITEM_ID = _os_.unmarshal_int();
/* 177 */         this.ITEM_TYPE_ID = _os_.unmarshal_int();
/* 178 */         this.FIGHT_NUM = _os_.unmarshal_int();
/* 179 */         this.WASHGOLD_NUM = _os_.unmarshal_int();
/* 180 */         this.LOVE_NUM = _os_.unmarshal_int();
/* 181 */         this.NULL_LOVE_ID = _os_.unmarshal_int();
/* 182 */         this.RECOVERY_MAIL_ID = _os_.unmarshal_int();
/* 183 */         this.RECOVERY_DISCOUNT = _os_.unmarshal_int();
/* 184 */         this.PARTNER_LV_RET = _os_.unmarshal_float();
/* 185 */         this.YUAN_LV_RET = _os_.unmarshal_float();
/* 186 */         this.YUAN_LV_MAX = _os_.unmarshal_int();
/* 187 */         this.loveRankHighFontColorR = _os_.unmarshal_int();
/* 188 */         this.loveRankHighFontColorG = _os_.unmarshal_int();
/* 189 */         this.loveRankHighFontColorB = _os_.unmarshal_int();
/* 190 */         this.loveRankNormalFontColorR = _os_.unmarshal_int();
/* 191 */         this.loveRankNormalFontColorG = _os_.unmarshal_int();
/* 192 */         this.loveRankNormalFontColorB = _os_.unmarshal_int();
/* 193 */         this.loveRankLowFontColorR = _os_.unmarshal_int();
/* 194 */         this.loveRankLowFontColorG = _os_.unmarshal_int();
/* 195 */         this.loveRankLowFontColorB = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 200 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 206 */     String path = dir + "mzm.gsp.partner.confbean.PartnerConstants.bny";
/*     */     try
/*     */     {
/* 209 */       File file = new File(path);
/* 210 */       if (file.exists())
/*     */       {
/* 212 */         byte[] bytes = new byte['Ѐ'];
/* 213 */         FileInputStream fis = new FileInputStream(file);
/* 214 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 215 */         int len = 0;
/* 216 */         while ((len = fis.read(bytes)) > 0)
/* 217 */           baos.write(bytes, 0, len);
/* 218 */         fis.close();
/* 219 */         bytes = baos.toByteArray();
/* 220 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 221 */         this.OPEN_LEVEL = _os_.unmarshal_int();
/* 222 */         this.ITEM_ID = _os_.unmarshal_int();
/* 223 */         this.ITEM_TYPE_ID = _os_.unmarshal_int();
/* 224 */         this.FIGHT_NUM = _os_.unmarshal_int();
/* 225 */         this.WASHGOLD_NUM = _os_.unmarshal_int();
/* 226 */         this.LOVE_NUM = _os_.unmarshal_int();
/* 227 */         this.NULL_LOVE_ID = _os_.unmarshal_int();
/* 228 */         this.RECOVERY_MAIL_ID = _os_.unmarshal_int();
/* 229 */         this.RECOVERY_DISCOUNT = _os_.unmarshal_int();
/* 230 */         this.PARTNER_LV_RET = _os_.unmarshal_float();
/* 231 */         this.YUAN_LV_RET = _os_.unmarshal_float();
/* 232 */         this.YUAN_LV_MAX = _os_.unmarshal_int();
/* 233 */         this.loveRankHighFontColorR = _os_.unmarshal_int();
/* 234 */         this.loveRankHighFontColorG = _os_.unmarshal_int();
/* 235 */         this.loveRankHighFontColorB = _os_.unmarshal_int();
/* 236 */         this.loveRankNormalFontColorR = _os_.unmarshal_int();
/* 237 */         this.loveRankNormalFontColorG = _os_.unmarshal_int();
/* 238 */         this.loveRankNormalFontColorB = _os_.unmarshal_int();
/* 239 */         this.loveRankLowFontColorR = _os_.unmarshal_int();
/* 240 */         this.loveRankLowFontColorG = _os_.unmarshal_int();
/* 241 */         this.loveRankLowFontColorB = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 246 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(PartnerConstants newInstance)
/*     */   {
/* 252 */     oldInstance = instance;
/* 253 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 258 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\confbean\PartnerConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */