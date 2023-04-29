/*     */ package mzm.gsp.foolsday.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class FoolsDayConsts
/*     */ {
/*  13 */   private static volatile FoolsDayConsts oldInstance = null;
/*     */   
/*  15 */   private static FoolsDayConsts instance = new FoolsDayConsts();
/*     */   public int ACTIVITY_CFG_ID;
/*     */   public int REFRESH_MAX_TIME;
/*     */   public int REFRESH_BUFF_NUM;
/*     */   public int MIN_AWARD_ID_1;
/*     */   
/*     */   public static FoolsDayConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static FoolsDayConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int MIN_AWARD_ID_2;
/*     */   
/*     */   public int MIN_AWARD_ID_3;
/*     */   
/*     */   public int OPEN_CHEST_POINT;
/*     */   
/*     */   public int TITLE_AWARD_NEED_POINT;
/*     */   
/*     */   public int TITLE_AWARD_ID;
/*     */   public int TITLE_AWARD_ICON_ID;
/*     */   public int MAKE_CHEST_EFFECT_ID;
/*     */   public int MAKE_CHEST_MAX_NUM;
/*     */   public int OPEN_CHEST_MAX_TIME;
/*     */   public int OPEN_SAME_ROLE_CHEST_MAX_TIME;
/*     */   public int ACTIVITY_TIPS_CONTENT_ID;
/*     */   public int BUFF_TIPS_CONTENT_ID;
/*     */   public int CHEST_ITEM_CFG_ID;
/*     */   public int OPEN_CHEST_MIN_LEVLE;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  52 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  57 */     String path = dir + "mzm.gsp.foolsday.confbean.FoolsDayConsts.xml";
/*     */     try
/*     */     {
/*  60 */       SAXReader reader = new SAXReader();
/*  61 */       org.dom4j.Document doc = reader.read(new File(path));
/*  62 */       Element root = doc.getRootElement();
/*  63 */       Map<String, Element> data = new java.util.HashMap();
/*  64 */       java.util.List<?> nodeList = root.elements();
/*  65 */       int len = nodeList.size();
/*  66 */       for (int i = 0; i < len; i++)
/*     */       {
/*  68 */         Element element = (Element)nodeList.get(i);
/*  69 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  72 */           String name = element.attributeValue("name");
/*  73 */           if (data.put(name, element) != null)
/*  74 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  77 */       this.ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/*  78 */       this.REFRESH_MAX_TIME = Integer.valueOf(((Element)data.get("REFRESH_MAX_TIME")).attributeValue("value")).intValue();
/*  79 */       this.REFRESH_BUFF_NUM = Integer.valueOf(((Element)data.get("REFRESH_BUFF_NUM")).attributeValue("value")).intValue();
/*  80 */       this.MIN_AWARD_ID_1 = Integer.valueOf(((Element)data.get("MIN_AWARD_ID_1")).attributeValue("value")).intValue();
/*  81 */       this.MIN_AWARD_ID_2 = Integer.valueOf(((Element)data.get("MIN_AWARD_ID_2")).attributeValue("value")).intValue();
/*  82 */       this.MIN_AWARD_ID_3 = Integer.valueOf(((Element)data.get("MIN_AWARD_ID_3")).attributeValue("value")).intValue();
/*  83 */       this.OPEN_CHEST_POINT = Integer.valueOf(((Element)data.get("OPEN_CHEST_POINT")).attributeValue("value")).intValue();
/*  84 */       this.TITLE_AWARD_NEED_POINT = Integer.valueOf(((Element)data.get("TITLE_AWARD_NEED_POINT")).attributeValue("value")).intValue();
/*  85 */       this.TITLE_AWARD_ID = Integer.valueOf(((Element)data.get("TITLE_AWARD_ID")).attributeValue("value")).intValue();
/*  86 */       this.TITLE_AWARD_ICON_ID = Integer.valueOf(((Element)data.get("TITLE_AWARD_ICON_ID")).attributeValue("value")).intValue();
/*  87 */       this.MAKE_CHEST_EFFECT_ID = Integer.valueOf(((Element)data.get("MAKE_CHEST_EFFECT_ID")).attributeValue("value")).intValue();
/*  88 */       this.MAKE_CHEST_MAX_NUM = Integer.valueOf(((Element)data.get("MAKE_CHEST_MAX_NUM")).attributeValue("value")).intValue();
/*  89 */       this.OPEN_CHEST_MAX_TIME = Integer.valueOf(((Element)data.get("OPEN_CHEST_MAX_TIME")).attributeValue("value")).intValue();
/*  90 */       this.OPEN_SAME_ROLE_CHEST_MAX_TIME = Integer.valueOf(((Element)data.get("OPEN_SAME_ROLE_CHEST_MAX_TIME")).attributeValue("value")).intValue();
/*  91 */       this.ACTIVITY_TIPS_CONTENT_ID = Integer.valueOf(((Element)data.get("ACTIVITY_TIPS_CONTENT_ID")).attributeValue("value")).intValue();
/*  92 */       this.BUFF_TIPS_CONTENT_ID = Integer.valueOf(((Element)data.get("BUFF_TIPS_CONTENT_ID")).attributeValue("value")).intValue();
/*  93 */       this.CHEST_ITEM_CFG_ID = Integer.valueOf(((Element)data.get("CHEST_ITEM_CFG_ID")).attributeValue("value")).intValue();
/*  94 */       this.OPEN_CHEST_MIN_LEVLE = Integer.valueOf(((Element)data.get("OPEN_CHEST_MIN_LEVLE")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  98 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 103 */     String path = dir + "mzm.gsp.foolsday.confbean.FoolsDayConsts.xml";
/*     */     try
/*     */     {
/* 106 */       SAXReader reader = new SAXReader();
/* 107 */       org.dom4j.Document doc = reader.read(new File(path));
/* 108 */       Element root = doc.getRootElement();
/* 109 */       Map<String, Element> data = new java.util.HashMap();
/* 110 */       java.util.List<?> nodeList = root.elements();
/* 111 */       int len = nodeList.size();
/* 112 */       for (int i = 0; i < len; i++)
/*     */       {
/* 114 */         Element element = (Element)nodeList.get(i);
/* 115 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 118 */           String name = element.attributeValue("name");
/* 119 */           if (data.put(name, element) != null)
/* 120 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 123 */       this.ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/* 124 */       this.REFRESH_MAX_TIME = Integer.valueOf(((Element)data.get("REFRESH_MAX_TIME")).attributeValue("value")).intValue();
/* 125 */       this.REFRESH_BUFF_NUM = Integer.valueOf(((Element)data.get("REFRESH_BUFF_NUM")).attributeValue("value")).intValue();
/* 126 */       this.MIN_AWARD_ID_1 = Integer.valueOf(((Element)data.get("MIN_AWARD_ID_1")).attributeValue("value")).intValue();
/* 127 */       this.MIN_AWARD_ID_2 = Integer.valueOf(((Element)data.get("MIN_AWARD_ID_2")).attributeValue("value")).intValue();
/* 128 */       this.MIN_AWARD_ID_3 = Integer.valueOf(((Element)data.get("MIN_AWARD_ID_3")).attributeValue("value")).intValue();
/* 129 */       this.OPEN_CHEST_POINT = Integer.valueOf(((Element)data.get("OPEN_CHEST_POINT")).attributeValue("value")).intValue();
/* 130 */       this.TITLE_AWARD_NEED_POINT = Integer.valueOf(((Element)data.get("TITLE_AWARD_NEED_POINT")).attributeValue("value")).intValue();
/* 131 */       this.TITLE_AWARD_ID = Integer.valueOf(((Element)data.get("TITLE_AWARD_ID")).attributeValue("value")).intValue();
/* 132 */       this.TITLE_AWARD_ICON_ID = Integer.valueOf(((Element)data.get("TITLE_AWARD_ICON_ID")).attributeValue("value")).intValue();
/* 133 */       this.MAKE_CHEST_EFFECT_ID = Integer.valueOf(((Element)data.get("MAKE_CHEST_EFFECT_ID")).attributeValue("value")).intValue();
/* 134 */       this.MAKE_CHEST_MAX_NUM = Integer.valueOf(((Element)data.get("MAKE_CHEST_MAX_NUM")).attributeValue("value")).intValue();
/* 135 */       this.OPEN_CHEST_MAX_TIME = Integer.valueOf(((Element)data.get("OPEN_CHEST_MAX_TIME")).attributeValue("value")).intValue();
/* 136 */       this.OPEN_SAME_ROLE_CHEST_MAX_TIME = Integer.valueOf(((Element)data.get("OPEN_SAME_ROLE_CHEST_MAX_TIME")).attributeValue("value")).intValue();
/* 137 */       this.ACTIVITY_TIPS_CONTENT_ID = Integer.valueOf(((Element)data.get("ACTIVITY_TIPS_CONTENT_ID")).attributeValue("value")).intValue();
/* 138 */       this.BUFF_TIPS_CONTENT_ID = Integer.valueOf(((Element)data.get("BUFF_TIPS_CONTENT_ID")).attributeValue("value")).intValue();
/* 139 */       this.CHEST_ITEM_CFG_ID = Integer.valueOf(((Element)data.get("CHEST_ITEM_CFG_ID")).attributeValue("value")).intValue();
/* 140 */       this.OPEN_CHEST_MIN_LEVLE = Integer.valueOf(((Element)data.get("OPEN_CHEST_MIN_LEVLE")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 144 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 148 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 151 */     String path = dir + "mzm.gsp.foolsday.confbean.FoolsDayConsts.bny";
/*     */     try
/*     */     {
/* 154 */       File file = new File(path);
/* 155 */       if (file.exists())
/*     */       {
/* 157 */         byte[] bytes = new byte['Ѐ'];
/* 158 */         FileInputStream fis = new FileInputStream(file);
/* 159 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 160 */         int len = 0;
/* 161 */         while ((len = fis.read(bytes)) > 0)
/* 162 */           baos.write(bytes, 0, len);
/* 163 */         fis.close();
/* 164 */         bytes = baos.toByteArray();
/* 165 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 166 */         this.ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 167 */         this.REFRESH_MAX_TIME = _os_.unmarshal_int();
/* 168 */         this.REFRESH_BUFF_NUM = _os_.unmarshal_int();
/* 169 */         this.MIN_AWARD_ID_1 = _os_.unmarshal_int();
/* 170 */         this.MIN_AWARD_ID_2 = _os_.unmarshal_int();
/* 171 */         this.MIN_AWARD_ID_3 = _os_.unmarshal_int();
/* 172 */         this.OPEN_CHEST_POINT = _os_.unmarshal_int();
/* 173 */         this.TITLE_AWARD_NEED_POINT = _os_.unmarshal_int();
/* 174 */         this.TITLE_AWARD_ID = _os_.unmarshal_int();
/* 175 */         this.TITLE_AWARD_ICON_ID = _os_.unmarshal_int();
/* 176 */         this.MAKE_CHEST_EFFECT_ID = _os_.unmarshal_int();
/* 177 */         this.MAKE_CHEST_MAX_NUM = _os_.unmarshal_int();
/* 178 */         this.OPEN_CHEST_MAX_TIME = _os_.unmarshal_int();
/* 179 */         this.OPEN_SAME_ROLE_CHEST_MAX_TIME = _os_.unmarshal_int();
/* 180 */         this.ACTIVITY_TIPS_CONTENT_ID = _os_.unmarshal_int();
/* 181 */         this.BUFF_TIPS_CONTENT_ID = _os_.unmarshal_int();
/* 182 */         this.CHEST_ITEM_CFG_ID = _os_.unmarshal_int();
/* 183 */         this.OPEN_CHEST_MIN_LEVLE = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 188 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 194 */     String path = dir + "mzm.gsp.foolsday.confbean.FoolsDayConsts.bny";
/*     */     try
/*     */     {
/* 197 */       File file = new File(path);
/* 198 */       if (file.exists())
/*     */       {
/* 200 */         byte[] bytes = new byte['Ѐ'];
/* 201 */         FileInputStream fis = new FileInputStream(file);
/* 202 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 203 */         int len = 0;
/* 204 */         while ((len = fis.read(bytes)) > 0)
/* 205 */           baos.write(bytes, 0, len);
/* 206 */         fis.close();
/* 207 */         bytes = baos.toByteArray();
/* 208 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 209 */         this.ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 210 */         this.REFRESH_MAX_TIME = _os_.unmarshal_int();
/* 211 */         this.REFRESH_BUFF_NUM = _os_.unmarshal_int();
/* 212 */         this.MIN_AWARD_ID_1 = _os_.unmarshal_int();
/* 213 */         this.MIN_AWARD_ID_2 = _os_.unmarshal_int();
/* 214 */         this.MIN_AWARD_ID_3 = _os_.unmarshal_int();
/* 215 */         this.OPEN_CHEST_POINT = _os_.unmarshal_int();
/* 216 */         this.TITLE_AWARD_NEED_POINT = _os_.unmarshal_int();
/* 217 */         this.TITLE_AWARD_ID = _os_.unmarshal_int();
/* 218 */         this.TITLE_AWARD_ICON_ID = _os_.unmarshal_int();
/* 219 */         this.MAKE_CHEST_EFFECT_ID = _os_.unmarshal_int();
/* 220 */         this.MAKE_CHEST_MAX_NUM = _os_.unmarshal_int();
/* 221 */         this.OPEN_CHEST_MAX_TIME = _os_.unmarshal_int();
/* 222 */         this.OPEN_SAME_ROLE_CHEST_MAX_TIME = _os_.unmarshal_int();
/* 223 */         this.ACTIVITY_TIPS_CONTENT_ID = _os_.unmarshal_int();
/* 224 */         this.BUFF_TIPS_CONTENT_ID = _os_.unmarshal_int();
/* 225 */         this.CHEST_ITEM_CFG_ID = _os_.unmarshal_int();
/* 226 */         this.OPEN_CHEST_MIN_LEVLE = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 231 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(FoolsDayConsts newInstance)
/*     */   {
/* 237 */     oldInstance = instance;
/* 238 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 243 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\foolsday\confbean\FoolsDayConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */