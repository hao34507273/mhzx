/*     */ package mzm.gsp.guide.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class GuideCfgConsts
/*     */ {
/*  13 */   private static volatile GuideCfgConsts oldInstance = null;
/*     */   
/*  15 */   private static GuideCfgConsts instance = new GuideCfgConsts();
/*     */   public int FORCE_GUIDE_SPECIAL_EFFECT;
/*     */   public int UN_FORCE_GUIDE_SPECIAL_EFFECT;
/*     */   public int HAND_TIP;
/*     */   public int GUIWANG_GUIDE_ID;
/*     */   public int QINGYUN_GUIDE_ID;
/*     */   
/*     */   public static GuideCfgConsts getOldInstance() {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static GuideCfgConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int TIANYIN_GUIDE_ID;
/*     */   
/*     */   public int FENXIANG_GUIDE_ID;
/*     */   
/*     */   public int HEHUAN_GUIDE_ID;
/*     */   
/*     */   public int SHENGWU_GUIDE_ID;
/*     */   
/*     */   public int CANGYU_GUIDE_ID;
/*     */   
/*     */   public int FIGHT1_ID;
/*     */   public int FIGHT1_GUIDEID;
/*     */   public int FIGHT2_ID;
/*     */   public int FIGHT2_GUIDEID;
/*     */   public int NEWER_OR_OLDER_GUIDEID;
/*     */   public int WATI_SECOND_FORCE_FINISH;
/*     */   public int GUIWANG_SKILL_ID;
/*     */   public int QINGYUN_SKILL_ID;
/*     */   public int TIANYIN_SKILL_ID;
/*     */   public int FENXIANG_SKILL_ID;
/*     */   public int HEHUAN_SKILL_ID;
/*     */   public int SHENGWU_SKILL_ID;
/*     */   public int AIRCRAFR_ID;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  57 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  62 */     String path = dir + "mzm.gsp.guide.confbean.GuideCfgConsts.xml";
/*     */     try
/*     */     {
/*  65 */       SAXReader reader = new SAXReader();
/*  66 */       org.dom4j.Document doc = reader.read(new File(path));
/*  67 */       Element root = doc.getRootElement();
/*  68 */       Map<String, Element> data = new java.util.HashMap();
/*  69 */       java.util.List<?> nodeList = root.elements();
/*  70 */       int len = nodeList.size();
/*  71 */       for (int i = 0; i < len; i++)
/*     */       {
/*  73 */         Element element = (Element)nodeList.get(i);
/*  74 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  77 */           String name = element.attributeValue("name");
/*  78 */           if (data.put(name, element) != null)
/*  79 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  82 */       this.FORCE_GUIDE_SPECIAL_EFFECT = Integer.valueOf(((Element)data.get("FORCE_GUIDE_SPECIAL_EFFECT")).attributeValue("value")).intValue();
/*  83 */       this.UN_FORCE_GUIDE_SPECIAL_EFFECT = Integer.valueOf(((Element)data.get("UN_FORCE_GUIDE_SPECIAL_EFFECT")).attributeValue("value")).intValue();
/*  84 */       this.HAND_TIP = Integer.valueOf(((Element)data.get("HAND_TIP")).attributeValue("value")).intValue();
/*  85 */       this.GUIWANG_GUIDE_ID = Integer.valueOf(((Element)data.get("GUIWANG_GUIDE_ID")).attributeValue("value")).intValue();
/*  86 */       this.QINGYUN_GUIDE_ID = Integer.valueOf(((Element)data.get("QINGYUN_GUIDE_ID")).attributeValue("value")).intValue();
/*  87 */       this.TIANYIN_GUIDE_ID = Integer.valueOf(((Element)data.get("TIANYIN_GUIDE_ID")).attributeValue("value")).intValue();
/*  88 */       this.FENXIANG_GUIDE_ID = Integer.valueOf(((Element)data.get("FENXIANG_GUIDE_ID")).attributeValue("value")).intValue();
/*  89 */       this.HEHUAN_GUIDE_ID = Integer.valueOf(((Element)data.get("HEHUAN_GUIDE_ID")).attributeValue("value")).intValue();
/*  90 */       this.SHENGWU_GUIDE_ID = Integer.valueOf(((Element)data.get("SHENGWU_GUIDE_ID")).attributeValue("value")).intValue();
/*  91 */       this.CANGYU_GUIDE_ID = Integer.valueOf(((Element)data.get("CANGYU_GUIDE_ID")).attributeValue("value")).intValue();
/*  92 */       this.FIGHT1_ID = Integer.valueOf(((Element)data.get("FIGHT1_ID")).attributeValue("value")).intValue();
/*  93 */       this.FIGHT1_GUIDEID = Integer.valueOf(((Element)data.get("FIGHT1_GUIDEID")).attributeValue("value")).intValue();
/*  94 */       this.FIGHT2_ID = Integer.valueOf(((Element)data.get("FIGHT2_ID")).attributeValue("value")).intValue();
/*  95 */       this.FIGHT2_GUIDEID = Integer.valueOf(((Element)data.get("FIGHT2_GUIDEID")).attributeValue("value")).intValue();
/*  96 */       this.NEWER_OR_OLDER_GUIDEID = Integer.valueOf(((Element)data.get("NEWER_OR_OLDER_GUIDEID")).attributeValue("value")).intValue();
/*  97 */       this.WATI_SECOND_FORCE_FINISH = Integer.valueOf(((Element)data.get("WATI_SECOND_FORCE_FINISH")).attributeValue("value")).intValue();
/*  98 */       this.GUIWANG_SKILL_ID = Integer.valueOf(((Element)data.get("GUIWANG_SKILL_ID")).attributeValue("value")).intValue();
/*  99 */       this.QINGYUN_SKILL_ID = Integer.valueOf(((Element)data.get("QINGYUN_SKILL_ID")).attributeValue("value")).intValue();
/* 100 */       this.TIANYIN_SKILL_ID = Integer.valueOf(((Element)data.get("TIANYIN_SKILL_ID")).attributeValue("value")).intValue();
/* 101 */       this.FENXIANG_SKILL_ID = Integer.valueOf(((Element)data.get("FENXIANG_SKILL_ID")).attributeValue("value")).intValue();
/* 102 */       this.HEHUAN_SKILL_ID = Integer.valueOf(((Element)data.get("HEHUAN_SKILL_ID")).attributeValue("value")).intValue();
/* 103 */       this.SHENGWU_SKILL_ID = Integer.valueOf(((Element)data.get("SHENGWU_SKILL_ID")).attributeValue("value")).intValue();
/* 104 */       this.AIRCRAFR_ID = Integer.valueOf(((Element)data.get("AIRCRAFR_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 108 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 113 */     String path = dir + "mzm.gsp.guide.confbean.GuideCfgConsts.xml";
/*     */     try
/*     */     {
/* 116 */       SAXReader reader = new SAXReader();
/* 117 */       org.dom4j.Document doc = reader.read(new File(path));
/* 118 */       Element root = doc.getRootElement();
/* 119 */       Map<String, Element> data = new java.util.HashMap();
/* 120 */       java.util.List<?> nodeList = root.elements();
/* 121 */       int len = nodeList.size();
/* 122 */       for (int i = 0; i < len; i++)
/*     */       {
/* 124 */         Element element = (Element)nodeList.get(i);
/* 125 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 128 */           String name = element.attributeValue("name");
/* 129 */           if (data.put(name, element) != null)
/* 130 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 133 */       this.FORCE_GUIDE_SPECIAL_EFFECT = Integer.valueOf(((Element)data.get("FORCE_GUIDE_SPECIAL_EFFECT")).attributeValue("value")).intValue();
/* 134 */       this.UN_FORCE_GUIDE_SPECIAL_EFFECT = Integer.valueOf(((Element)data.get("UN_FORCE_GUIDE_SPECIAL_EFFECT")).attributeValue("value")).intValue();
/* 135 */       this.HAND_TIP = Integer.valueOf(((Element)data.get("HAND_TIP")).attributeValue("value")).intValue();
/* 136 */       this.GUIWANG_GUIDE_ID = Integer.valueOf(((Element)data.get("GUIWANG_GUIDE_ID")).attributeValue("value")).intValue();
/* 137 */       this.QINGYUN_GUIDE_ID = Integer.valueOf(((Element)data.get("QINGYUN_GUIDE_ID")).attributeValue("value")).intValue();
/* 138 */       this.TIANYIN_GUIDE_ID = Integer.valueOf(((Element)data.get("TIANYIN_GUIDE_ID")).attributeValue("value")).intValue();
/* 139 */       this.FENXIANG_GUIDE_ID = Integer.valueOf(((Element)data.get("FENXIANG_GUIDE_ID")).attributeValue("value")).intValue();
/* 140 */       this.HEHUAN_GUIDE_ID = Integer.valueOf(((Element)data.get("HEHUAN_GUIDE_ID")).attributeValue("value")).intValue();
/* 141 */       this.SHENGWU_GUIDE_ID = Integer.valueOf(((Element)data.get("SHENGWU_GUIDE_ID")).attributeValue("value")).intValue();
/* 142 */       this.CANGYU_GUIDE_ID = Integer.valueOf(((Element)data.get("CANGYU_GUIDE_ID")).attributeValue("value")).intValue();
/* 143 */       this.FIGHT1_ID = Integer.valueOf(((Element)data.get("FIGHT1_ID")).attributeValue("value")).intValue();
/* 144 */       this.FIGHT1_GUIDEID = Integer.valueOf(((Element)data.get("FIGHT1_GUIDEID")).attributeValue("value")).intValue();
/* 145 */       this.FIGHT2_ID = Integer.valueOf(((Element)data.get("FIGHT2_ID")).attributeValue("value")).intValue();
/* 146 */       this.FIGHT2_GUIDEID = Integer.valueOf(((Element)data.get("FIGHT2_GUIDEID")).attributeValue("value")).intValue();
/* 147 */       this.NEWER_OR_OLDER_GUIDEID = Integer.valueOf(((Element)data.get("NEWER_OR_OLDER_GUIDEID")).attributeValue("value")).intValue();
/* 148 */       this.WATI_SECOND_FORCE_FINISH = Integer.valueOf(((Element)data.get("WATI_SECOND_FORCE_FINISH")).attributeValue("value")).intValue();
/* 149 */       this.GUIWANG_SKILL_ID = Integer.valueOf(((Element)data.get("GUIWANG_SKILL_ID")).attributeValue("value")).intValue();
/* 150 */       this.QINGYUN_SKILL_ID = Integer.valueOf(((Element)data.get("QINGYUN_SKILL_ID")).attributeValue("value")).intValue();
/* 151 */       this.TIANYIN_SKILL_ID = Integer.valueOf(((Element)data.get("TIANYIN_SKILL_ID")).attributeValue("value")).intValue();
/* 152 */       this.FENXIANG_SKILL_ID = Integer.valueOf(((Element)data.get("FENXIANG_SKILL_ID")).attributeValue("value")).intValue();
/* 153 */       this.HEHUAN_SKILL_ID = Integer.valueOf(((Element)data.get("HEHUAN_SKILL_ID")).attributeValue("value")).intValue();
/* 154 */       this.SHENGWU_SKILL_ID = Integer.valueOf(((Element)data.get("SHENGWU_SKILL_ID")).attributeValue("value")).intValue();
/* 155 */       this.AIRCRAFR_ID = Integer.valueOf(((Element)data.get("AIRCRAFR_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 159 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 163 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 166 */     String path = dir + "mzm.gsp.guide.confbean.GuideCfgConsts.bny";
/*     */     try
/*     */     {
/* 169 */       File file = new File(path);
/* 170 */       if (file.exists())
/*     */       {
/* 172 */         byte[] bytes = new byte['Ѐ'];
/* 173 */         FileInputStream fis = new FileInputStream(file);
/* 174 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 175 */         int len = 0;
/* 176 */         while ((len = fis.read(bytes)) > 0)
/* 177 */           baos.write(bytes, 0, len);
/* 178 */         fis.close();
/* 179 */         bytes = baos.toByteArray();
/* 180 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 181 */         this.FORCE_GUIDE_SPECIAL_EFFECT = _os_.unmarshal_int();
/* 182 */         this.UN_FORCE_GUIDE_SPECIAL_EFFECT = _os_.unmarshal_int();
/* 183 */         this.HAND_TIP = _os_.unmarshal_int();
/* 184 */         this.GUIWANG_GUIDE_ID = _os_.unmarshal_int();
/* 185 */         this.QINGYUN_GUIDE_ID = _os_.unmarshal_int();
/* 186 */         this.TIANYIN_GUIDE_ID = _os_.unmarshal_int();
/* 187 */         this.FENXIANG_GUIDE_ID = _os_.unmarshal_int();
/* 188 */         this.HEHUAN_GUIDE_ID = _os_.unmarshal_int();
/* 189 */         this.SHENGWU_GUIDE_ID = _os_.unmarshal_int();
/* 190 */         this.CANGYU_GUIDE_ID = _os_.unmarshal_int();
/* 191 */         this.FIGHT1_ID = _os_.unmarshal_int();
/* 192 */         this.FIGHT1_GUIDEID = _os_.unmarshal_int();
/* 193 */         this.FIGHT2_ID = _os_.unmarshal_int();
/* 194 */         this.FIGHT2_GUIDEID = _os_.unmarshal_int();
/* 195 */         this.NEWER_OR_OLDER_GUIDEID = _os_.unmarshal_int();
/* 196 */         this.WATI_SECOND_FORCE_FINISH = _os_.unmarshal_int();
/* 197 */         this.GUIWANG_SKILL_ID = _os_.unmarshal_int();
/* 198 */         this.QINGYUN_SKILL_ID = _os_.unmarshal_int();
/* 199 */         this.TIANYIN_SKILL_ID = _os_.unmarshal_int();
/* 200 */         this.FENXIANG_SKILL_ID = _os_.unmarshal_int();
/* 201 */         this.HEHUAN_SKILL_ID = _os_.unmarshal_int();
/* 202 */         this.SHENGWU_SKILL_ID = _os_.unmarshal_int();
/* 203 */         this.AIRCRAFR_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 208 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 214 */     String path = dir + "mzm.gsp.guide.confbean.GuideCfgConsts.bny";
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
/* 229 */         this.FORCE_GUIDE_SPECIAL_EFFECT = _os_.unmarshal_int();
/* 230 */         this.UN_FORCE_GUIDE_SPECIAL_EFFECT = _os_.unmarshal_int();
/* 231 */         this.HAND_TIP = _os_.unmarshal_int();
/* 232 */         this.GUIWANG_GUIDE_ID = _os_.unmarshal_int();
/* 233 */         this.QINGYUN_GUIDE_ID = _os_.unmarshal_int();
/* 234 */         this.TIANYIN_GUIDE_ID = _os_.unmarshal_int();
/* 235 */         this.FENXIANG_GUIDE_ID = _os_.unmarshal_int();
/* 236 */         this.HEHUAN_GUIDE_ID = _os_.unmarshal_int();
/* 237 */         this.SHENGWU_GUIDE_ID = _os_.unmarshal_int();
/* 238 */         this.CANGYU_GUIDE_ID = _os_.unmarshal_int();
/* 239 */         this.FIGHT1_ID = _os_.unmarshal_int();
/* 240 */         this.FIGHT1_GUIDEID = _os_.unmarshal_int();
/* 241 */         this.FIGHT2_ID = _os_.unmarshal_int();
/* 242 */         this.FIGHT2_GUIDEID = _os_.unmarshal_int();
/* 243 */         this.NEWER_OR_OLDER_GUIDEID = _os_.unmarshal_int();
/* 244 */         this.WATI_SECOND_FORCE_FINISH = _os_.unmarshal_int();
/* 245 */         this.GUIWANG_SKILL_ID = _os_.unmarshal_int();
/* 246 */         this.QINGYUN_SKILL_ID = _os_.unmarshal_int();
/* 247 */         this.TIANYIN_SKILL_ID = _os_.unmarshal_int();
/* 248 */         this.FENXIANG_SKILL_ID = _os_.unmarshal_int();
/* 249 */         this.HEHUAN_SKILL_ID = _os_.unmarshal_int();
/* 250 */         this.SHENGWU_SKILL_ID = _os_.unmarshal_int();
/* 251 */         this.AIRCRAFR_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 256 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(GuideCfgConsts newInstance)
/*     */   {
/* 262 */     oldInstance = instance;
/* 263 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 268 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guide\confbean\GuideCfgConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */