/*     */ package mzm.gsp.award.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class AddModifyConsts
/*     */ {
/*  13 */   private static volatile AddModifyConsts oldInstance = null;
/*     */   
/*  15 */   private static AddModifyConsts instance = new AddModifyConsts();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static AddModifyConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static AddModifyConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int TEAMLEADER_EXP_ADD = 1000;
/*  32 */   public int STABLETEAM_EXP_ADD = 1000;
/*  33 */   public int DOUBLE_EXP_ADD = 10000;
/*  34 */   public int GANG_EXP_ADD = 1000;
/*  35 */   public int SWORN_EXP_ADD = 1000;
/*  36 */   public int MARRY_EXP_ADD = 1000;
/*  37 */   public int ZHAN_DUI_EXP_ADD = 1000;
/*  38 */   public int NEW_MARRIAGE_EXP_ADD = 1000;
/*  39 */   public int NEW_MARRIAGE_TEAM_EXP_ADD = 1000;
/*  40 */   public int TEAMLEADER_SILVER_ADD = 1000;
/*  41 */   public int STABLETEAM_SILVER_ADD = 1000;
/*  42 */   public int DOUBLE_SILVER_ADD = 10000;
/*  43 */   public int GANG_SILVER_ADD = 1000;
/*  44 */   public int SWORN_SILVER_ADD = 1000;
/*  45 */   public int MARRY_SILVER_ADD = 1000;
/*  46 */   public int ZHAN_DUI_SILVER_ADD = 1000;
/*  47 */   public int NEW_MARRIAGE_SILVER_ADD = 1000;
/*  48 */   public int NEW_MARRIAGE_TEAM_SILVER_ADD = 1000;
/*  49 */   public int DOUBLE_ITEMRATE_ADD = 1000;
/*  50 */   public int STORE_EXP_TRANSFORM = 1000;
/*  51 */   public int NEW_MARRIAGE_TEAM_BUFF_ID = 701203101;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  55 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  60 */     String path = dir + "mzm.gsp.award.confbean.AddModifyConsts.xml";
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
/*  80 */       this.TEAMLEADER_EXP_ADD = Integer.valueOf(((Element)data.get("TEAMLEADER_EXP_ADD")).attributeValue("value")).intValue();
/*  81 */       this.STABLETEAM_EXP_ADD = Integer.valueOf(((Element)data.get("STABLETEAM_EXP_ADD")).attributeValue("value")).intValue();
/*  82 */       this.DOUBLE_EXP_ADD = Integer.valueOf(((Element)data.get("DOUBLE_EXP_ADD")).attributeValue("value")).intValue();
/*  83 */       this.GANG_EXP_ADD = Integer.valueOf(((Element)data.get("GANG_EXP_ADD")).attributeValue("value")).intValue();
/*  84 */       this.SWORN_EXP_ADD = Integer.valueOf(((Element)data.get("SWORN_EXP_ADD")).attributeValue("value")).intValue();
/*  85 */       this.MARRY_EXP_ADD = Integer.valueOf(((Element)data.get("MARRY_EXP_ADD")).attributeValue("value")).intValue();
/*  86 */       this.ZHAN_DUI_EXP_ADD = Integer.valueOf(((Element)data.get("ZHAN_DUI_EXP_ADD")).attributeValue("value")).intValue();
/*  87 */       this.NEW_MARRIAGE_EXP_ADD = Integer.valueOf(((Element)data.get("NEW_MARRIAGE_EXP_ADD")).attributeValue("value")).intValue();
/*  88 */       this.NEW_MARRIAGE_TEAM_EXP_ADD = Integer.valueOf(((Element)data.get("NEW_MARRIAGE_TEAM_EXP_ADD")).attributeValue("value")).intValue();
/*  89 */       this.TEAMLEADER_SILVER_ADD = Integer.valueOf(((Element)data.get("TEAMLEADER_SILVER_ADD")).attributeValue("value")).intValue();
/*  90 */       this.STABLETEAM_SILVER_ADD = Integer.valueOf(((Element)data.get("STABLETEAM_SILVER_ADD")).attributeValue("value")).intValue();
/*  91 */       this.DOUBLE_SILVER_ADD = Integer.valueOf(((Element)data.get("DOUBLE_SILVER_ADD")).attributeValue("value")).intValue();
/*  92 */       this.GANG_SILVER_ADD = Integer.valueOf(((Element)data.get("GANG_SILVER_ADD")).attributeValue("value")).intValue();
/*  93 */       this.SWORN_SILVER_ADD = Integer.valueOf(((Element)data.get("SWORN_SILVER_ADD")).attributeValue("value")).intValue();
/*  94 */       this.MARRY_SILVER_ADD = Integer.valueOf(((Element)data.get("MARRY_SILVER_ADD")).attributeValue("value")).intValue();
/*  95 */       this.ZHAN_DUI_SILVER_ADD = Integer.valueOf(((Element)data.get("ZHAN_DUI_SILVER_ADD")).attributeValue("value")).intValue();
/*  96 */       this.NEW_MARRIAGE_SILVER_ADD = Integer.valueOf(((Element)data.get("NEW_MARRIAGE_SILVER_ADD")).attributeValue("value")).intValue();
/*  97 */       this.NEW_MARRIAGE_TEAM_SILVER_ADD = Integer.valueOf(((Element)data.get("NEW_MARRIAGE_TEAM_SILVER_ADD")).attributeValue("value")).intValue();
/*  98 */       this.DOUBLE_ITEMRATE_ADD = Integer.valueOf(((Element)data.get("DOUBLE_ITEMRATE_ADD")).attributeValue("value")).intValue();
/*  99 */       this.STORE_EXP_TRANSFORM = Integer.valueOf(((Element)data.get("STORE_EXP_TRANSFORM")).attributeValue("value")).intValue();
/* 100 */       this.NEW_MARRIAGE_TEAM_BUFF_ID = Integer.valueOf(((Element)data.get("NEW_MARRIAGE_TEAM_BUFF_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 104 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 109 */     String path = dir + "mzm.gsp.award.confbean.AddModifyConsts.xml";
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
/* 129 */       this.TEAMLEADER_EXP_ADD = Integer.valueOf(((Element)data.get("TEAMLEADER_EXP_ADD")).attributeValue("value")).intValue();
/* 130 */       this.STABLETEAM_EXP_ADD = Integer.valueOf(((Element)data.get("STABLETEAM_EXP_ADD")).attributeValue("value")).intValue();
/* 131 */       this.DOUBLE_EXP_ADD = Integer.valueOf(((Element)data.get("DOUBLE_EXP_ADD")).attributeValue("value")).intValue();
/* 132 */       this.GANG_EXP_ADD = Integer.valueOf(((Element)data.get("GANG_EXP_ADD")).attributeValue("value")).intValue();
/* 133 */       this.SWORN_EXP_ADD = Integer.valueOf(((Element)data.get("SWORN_EXP_ADD")).attributeValue("value")).intValue();
/* 134 */       this.MARRY_EXP_ADD = Integer.valueOf(((Element)data.get("MARRY_EXP_ADD")).attributeValue("value")).intValue();
/* 135 */       this.ZHAN_DUI_EXP_ADD = Integer.valueOf(((Element)data.get("ZHAN_DUI_EXP_ADD")).attributeValue("value")).intValue();
/* 136 */       this.NEW_MARRIAGE_EXP_ADD = Integer.valueOf(((Element)data.get("NEW_MARRIAGE_EXP_ADD")).attributeValue("value")).intValue();
/* 137 */       this.NEW_MARRIAGE_TEAM_EXP_ADD = Integer.valueOf(((Element)data.get("NEW_MARRIAGE_TEAM_EXP_ADD")).attributeValue("value")).intValue();
/* 138 */       this.TEAMLEADER_SILVER_ADD = Integer.valueOf(((Element)data.get("TEAMLEADER_SILVER_ADD")).attributeValue("value")).intValue();
/* 139 */       this.STABLETEAM_SILVER_ADD = Integer.valueOf(((Element)data.get("STABLETEAM_SILVER_ADD")).attributeValue("value")).intValue();
/* 140 */       this.DOUBLE_SILVER_ADD = Integer.valueOf(((Element)data.get("DOUBLE_SILVER_ADD")).attributeValue("value")).intValue();
/* 141 */       this.GANG_SILVER_ADD = Integer.valueOf(((Element)data.get("GANG_SILVER_ADD")).attributeValue("value")).intValue();
/* 142 */       this.SWORN_SILVER_ADD = Integer.valueOf(((Element)data.get("SWORN_SILVER_ADD")).attributeValue("value")).intValue();
/* 143 */       this.MARRY_SILVER_ADD = Integer.valueOf(((Element)data.get("MARRY_SILVER_ADD")).attributeValue("value")).intValue();
/* 144 */       this.ZHAN_DUI_SILVER_ADD = Integer.valueOf(((Element)data.get("ZHAN_DUI_SILVER_ADD")).attributeValue("value")).intValue();
/* 145 */       this.NEW_MARRIAGE_SILVER_ADD = Integer.valueOf(((Element)data.get("NEW_MARRIAGE_SILVER_ADD")).attributeValue("value")).intValue();
/* 146 */       this.NEW_MARRIAGE_TEAM_SILVER_ADD = Integer.valueOf(((Element)data.get("NEW_MARRIAGE_TEAM_SILVER_ADD")).attributeValue("value")).intValue();
/* 147 */       this.DOUBLE_ITEMRATE_ADD = Integer.valueOf(((Element)data.get("DOUBLE_ITEMRATE_ADD")).attributeValue("value")).intValue();
/* 148 */       this.STORE_EXP_TRANSFORM = Integer.valueOf(((Element)data.get("STORE_EXP_TRANSFORM")).attributeValue("value")).intValue();
/* 149 */       this.NEW_MARRIAGE_TEAM_BUFF_ID = Integer.valueOf(((Element)data.get("NEW_MARRIAGE_TEAM_BUFF_ID")).attributeValue("value")).intValue();
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
/* 160 */     String path = dir + "mzm.gsp.award.confbean.AddModifyConsts.bny";
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
/* 175 */         this.TEAMLEADER_EXP_ADD = _os_.unmarshal_int();
/* 176 */         this.STABLETEAM_EXP_ADD = _os_.unmarshal_int();
/* 177 */         this.DOUBLE_EXP_ADD = _os_.unmarshal_int();
/* 178 */         this.GANG_EXP_ADD = _os_.unmarshal_int();
/* 179 */         this.SWORN_EXP_ADD = _os_.unmarshal_int();
/* 180 */         this.MARRY_EXP_ADD = _os_.unmarshal_int();
/* 181 */         this.ZHAN_DUI_EXP_ADD = _os_.unmarshal_int();
/* 182 */         this.NEW_MARRIAGE_EXP_ADD = _os_.unmarshal_int();
/* 183 */         this.NEW_MARRIAGE_TEAM_EXP_ADD = _os_.unmarshal_int();
/* 184 */         this.TEAMLEADER_SILVER_ADD = _os_.unmarshal_int();
/* 185 */         this.STABLETEAM_SILVER_ADD = _os_.unmarshal_int();
/* 186 */         this.DOUBLE_SILVER_ADD = _os_.unmarshal_int();
/* 187 */         this.GANG_SILVER_ADD = _os_.unmarshal_int();
/* 188 */         this.SWORN_SILVER_ADD = _os_.unmarshal_int();
/* 189 */         this.MARRY_SILVER_ADD = _os_.unmarshal_int();
/* 190 */         this.ZHAN_DUI_SILVER_ADD = _os_.unmarshal_int();
/* 191 */         this.NEW_MARRIAGE_SILVER_ADD = _os_.unmarshal_int();
/* 192 */         this.NEW_MARRIAGE_TEAM_SILVER_ADD = _os_.unmarshal_int();
/* 193 */         this.DOUBLE_ITEMRATE_ADD = _os_.unmarshal_int();
/* 194 */         this.STORE_EXP_TRANSFORM = _os_.unmarshal_int();
/* 195 */         this.NEW_MARRIAGE_TEAM_BUFF_ID = _os_.unmarshal_int();
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
/* 206 */     String path = dir + "mzm.gsp.award.confbean.AddModifyConsts.bny";
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
/* 221 */         this.TEAMLEADER_EXP_ADD = _os_.unmarshal_int();
/* 222 */         this.STABLETEAM_EXP_ADD = _os_.unmarshal_int();
/* 223 */         this.DOUBLE_EXP_ADD = _os_.unmarshal_int();
/* 224 */         this.GANG_EXP_ADD = _os_.unmarshal_int();
/* 225 */         this.SWORN_EXP_ADD = _os_.unmarshal_int();
/* 226 */         this.MARRY_EXP_ADD = _os_.unmarshal_int();
/* 227 */         this.ZHAN_DUI_EXP_ADD = _os_.unmarshal_int();
/* 228 */         this.NEW_MARRIAGE_EXP_ADD = _os_.unmarshal_int();
/* 229 */         this.NEW_MARRIAGE_TEAM_EXP_ADD = _os_.unmarshal_int();
/* 230 */         this.TEAMLEADER_SILVER_ADD = _os_.unmarshal_int();
/* 231 */         this.STABLETEAM_SILVER_ADD = _os_.unmarshal_int();
/* 232 */         this.DOUBLE_SILVER_ADD = _os_.unmarshal_int();
/* 233 */         this.GANG_SILVER_ADD = _os_.unmarshal_int();
/* 234 */         this.SWORN_SILVER_ADD = _os_.unmarshal_int();
/* 235 */         this.MARRY_SILVER_ADD = _os_.unmarshal_int();
/* 236 */         this.ZHAN_DUI_SILVER_ADD = _os_.unmarshal_int();
/* 237 */         this.NEW_MARRIAGE_SILVER_ADD = _os_.unmarshal_int();
/* 238 */         this.NEW_MARRIAGE_TEAM_SILVER_ADD = _os_.unmarshal_int();
/* 239 */         this.DOUBLE_ITEMRATE_ADD = _os_.unmarshal_int();
/* 240 */         this.STORE_EXP_TRANSFORM = _os_.unmarshal_int();
/* 241 */         this.NEW_MARRIAGE_TEAM_BUFF_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 246 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(AddModifyConsts newInstance)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\confbean\AddModifyConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */