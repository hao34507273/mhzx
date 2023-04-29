/*     */ package mzm.gsp.luckybag.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SLuckyBagCfgConsts
/*     */ {
/*  13 */   private static volatile SLuckyBagCfgConsts oldInstance = null;
/*     */   
/*  15 */   private static SLuckyBagCfgConsts instance = new SLuckyBagCfgConsts();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SLuckyBagCfgConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SLuckyBagCfgConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int BRASS_ITEM_ID = 0;
/*  32 */   public int OPEN_BRASS_BAG_NEED_NUM = 1;
/*  33 */   public int BRASS_BAG_AWARD_ID = 0;
/*  34 */   public int BRASS_UI_CFG_ID = 0;
/*  35 */   public int BRASS_MAP_ITEM_HANDLER_TYPE = 3;
/*  36 */   public int JADE_ITEM_ID = 0;
/*  37 */   public int OPEN_JADE_BAG_NEED_NUM = 1;
/*  38 */   public int JADE_BAG_AWARD_ID = 0;
/*  39 */   public int JADE_UI_CFG_ID = 0;
/*  40 */   public int JADE_MAP_ITEM_HANDLER_TYPE = 2;
/*  41 */   public int ACTIVITY_CFG_ID = 0;
/*  42 */   public int MIN_LEVEL = 30;
/*  43 */   public int INIT_LUCKY_BAG_NUM_LEVEL_CFG_ID = 290100000;
/*  44 */   public int BRASS_BAG_GET_AWARD_ID = 5902;
/*  45 */   public int JADE_BAG_GET_AWARD_ID = 5901;
/*     */   public int BOX_MAP_ITEM_HANDLER_TYPE;
/*     */   public int BOX_BAG_GET_AWARD_ID;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  51 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  56 */     String path = dir + "mzm.gsp.luckybag.confbean.SLuckyBagCfgConsts.xml";
/*     */     try
/*     */     {
/*  59 */       SAXReader reader = new SAXReader();
/*  60 */       org.dom4j.Document doc = reader.read(new File(path));
/*  61 */       Element root = doc.getRootElement();
/*  62 */       Map<String, Element> data = new java.util.HashMap();
/*  63 */       java.util.List<?> nodeList = root.elements();
/*  64 */       int len = nodeList.size();
/*  65 */       for (int i = 0; i < len; i++)
/*     */       {
/*  67 */         Element element = (Element)nodeList.get(i);
/*  68 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  71 */           String name = element.attributeValue("name");
/*  72 */           if (data.put(name, element) != null)
/*  73 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  76 */       this.BRASS_ITEM_ID = Integer.valueOf(((Element)data.get("BRASS_ITEM_ID")).attributeValue("value")).intValue();
/*  77 */       this.OPEN_BRASS_BAG_NEED_NUM = Integer.valueOf(((Element)data.get("OPEN_BRASS_BAG_NEED_NUM")).attributeValue("value")).intValue();
/*  78 */       this.BRASS_BAG_AWARD_ID = Integer.valueOf(((Element)data.get("BRASS_BAG_AWARD_ID")).attributeValue("value")).intValue();
/*  79 */       this.BRASS_UI_CFG_ID = Integer.valueOf(((Element)data.get("BRASS_UI_CFG_ID")).attributeValue("value")).intValue();
/*  80 */       this.BRASS_MAP_ITEM_HANDLER_TYPE = Integer.valueOf(((Element)data.get("BRASS_MAP_ITEM_HANDLER_TYPE")).attributeValue("value")).intValue();
/*  81 */       this.JADE_ITEM_ID = Integer.valueOf(((Element)data.get("JADE_ITEM_ID")).attributeValue("value")).intValue();
/*  82 */       this.OPEN_JADE_BAG_NEED_NUM = Integer.valueOf(((Element)data.get("OPEN_JADE_BAG_NEED_NUM")).attributeValue("value")).intValue();
/*  83 */       this.JADE_BAG_AWARD_ID = Integer.valueOf(((Element)data.get("JADE_BAG_AWARD_ID")).attributeValue("value")).intValue();
/*  84 */       this.JADE_UI_CFG_ID = Integer.valueOf(((Element)data.get("JADE_UI_CFG_ID")).attributeValue("value")).intValue();
/*  85 */       this.JADE_MAP_ITEM_HANDLER_TYPE = Integer.valueOf(((Element)data.get("JADE_MAP_ITEM_HANDLER_TYPE")).attributeValue("value")).intValue();
/*  86 */       this.ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/*  87 */       this.MIN_LEVEL = Integer.valueOf(((Element)data.get("MIN_LEVEL")).attributeValue("value")).intValue();
/*  88 */       this.INIT_LUCKY_BAG_NUM_LEVEL_CFG_ID = Integer.valueOf(((Element)data.get("INIT_LUCKY_BAG_NUM_LEVEL_CFG_ID")).attributeValue("value")).intValue();
/*  89 */       this.BRASS_BAG_GET_AWARD_ID = Integer.valueOf(((Element)data.get("BRASS_BAG_GET_AWARD_ID")).attributeValue("value")).intValue();
/*  90 */       this.JADE_BAG_GET_AWARD_ID = Integer.valueOf(((Element)data.get("JADE_BAG_GET_AWARD_ID")).attributeValue("value")).intValue();
/*  91 */       this.BOX_MAP_ITEM_HANDLER_TYPE = Integer.valueOf(((Element)data.get("BOX_MAP_ITEM_HANDLER_TYPE")).attributeValue("value")).intValue();
/*  92 */       this.BOX_BAG_GET_AWARD_ID = Integer.valueOf(((Element)data.get("BOX_BAG_GET_AWARD_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  96 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 101 */     String path = dir + "mzm.gsp.luckybag.confbean.SLuckyBagCfgConsts.xml";
/*     */     try
/*     */     {
/* 104 */       SAXReader reader = new SAXReader();
/* 105 */       org.dom4j.Document doc = reader.read(new File(path));
/* 106 */       Element root = doc.getRootElement();
/* 107 */       Map<String, Element> data = new java.util.HashMap();
/* 108 */       java.util.List<?> nodeList = root.elements();
/* 109 */       int len = nodeList.size();
/* 110 */       for (int i = 0; i < len; i++)
/*     */       {
/* 112 */         Element element = (Element)nodeList.get(i);
/* 113 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 116 */           String name = element.attributeValue("name");
/* 117 */           if (data.put(name, element) != null)
/* 118 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 121 */       this.BRASS_ITEM_ID = Integer.valueOf(((Element)data.get("BRASS_ITEM_ID")).attributeValue("value")).intValue();
/* 122 */       this.OPEN_BRASS_BAG_NEED_NUM = Integer.valueOf(((Element)data.get("OPEN_BRASS_BAG_NEED_NUM")).attributeValue("value")).intValue();
/* 123 */       this.BRASS_BAG_AWARD_ID = Integer.valueOf(((Element)data.get("BRASS_BAG_AWARD_ID")).attributeValue("value")).intValue();
/* 124 */       this.BRASS_UI_CFG_ID = Integer.valueOf(((Element)data.get("BRASS_UI_CFG_ID")).attributeValue("value")).intValue();
/* 125 */       this.BRASS_MAP_ITEM_HANDLER_TYPE = Integer.valueOf(((Element)data.get("BRASS_MAP_ITEM_HANDLER_TYPE")).attributeValue("value")).intValue();
/* 126 */       this.JADE_ITEM_ID = Integer.valueOf(((Element)data.get("JADE_ITEM_ID")).attributeValue("value")).intValue();
/* 127 */       this.OPEN_JADE_BAG_NEED_NUM = Integer.valueOf(((Element)data.get("OPEN_JADE_BAG_NEED_NUM")).attributeValue("value")).intValue();
/* 128 */       this.JADE_BAG_AWARD_ID = Integer.valueOf(((Element)data.get("JADE_BAG_AWARD_ID")).attributeValue("value")).intValue();
/* 129 */       this.JADE_UI_CFG_ID = Integer.valueOf(((Element)data.get("JADE_UI_CFG_ID")).attributeValue("value")).intValue();
/* 130 */       this.JADE_MAP_ITEM_HANDLER_TYPE = Integer.valueOf(((Element)data.get("JADE_MAP_ITEM_HANDLER_TYPE")).attributeValue("value")).intValue();
/* 131 */       this.ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/* 132 */       this.MIN_LEVEL = Integer.valueOf(((Element)data.get("MIN_LEVEL")).attributeValue("value")).intValue();
/* 133 */       this.INIT_LUCKY_BAG_NUM_LEVEL_CFG_ID = Integer.valueOf(((Element)data.get("INIT_LUCKY_BAG_NUM_LEVEL_CFG_ID")).attributeValue("value")).intValue();
/* 134 */       this.BRASS_BAG_GET_AWARD_ID = Integer.valueOf(((Element)data.get("BRASS_BAG_GET_AWARD_ID")).attributeValue("value")).intValue();
/* 135 */       this.JADE_BAG_GET_AWARD_ID = Integer.valueOf(((Element)data.get("JADE_BAG_GET_AWARD_ID")).attributeValue("value")).intValue();
/* 136 */       this.BOX_MAP_ITEM_HANDLER_TYPE = Integer.valueOf(((Element)data.get("BOX_MAP_ITEM_HANDLER_TYPE")).attributeValue("value")).intValue();
/* 137 */       this.BOX_BAG_GET_AWARD_ID = Integer.valueOf(((Element)data.get("BOX_BAG_GET_AWARD_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 141 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 145 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 148 */     String path = dir + "mzm.gsp.luckybag.confbean.SLuckyBagCfgConsts.bny";
/*     */     try
/*     */     {
/* 151 */       File file = new File(path);
/* 152 */       if (file.exists())
/*     */       {
/* 154 */         byte[] bytes = new byte['Ѐ'];
/* 155 */         FileInputStream fis = new FileInputStream(file);
/* 156 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 157 */         int len = 0;
/* 158 */         while ((len = fis.read(bytes)) > 0)
/* 159 */           baos.write(bytes, 0, len);
/* 160 */         fis.close();
/* 161 */         bytes = baos.toByteArray();
/* 162 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 163 */         this.BRASS_ITEM_ID = _os_.unmarshal_int();
/* 164 */         this.OPEN_BRASS_BAG_NEED_NUM = _os_.unmarshal_int();
/* 165 */         this.BRASS_BAG_AWARD_ID = _os_.unmarshal_int();
/* 166 */         this.BRASS_UI_CFG_ID = _os_.unmarshal_int();
/* 167 */         this.BRASS_MAP_ITEM_HANDLER_TYPE = _os_.unmarshal_int();
/* 168 */         this.JADE_ITEM_ID = _os_.unmarshal_int();
/* 169 */         this.OPEN_JADE_BAG_NEED_NUM = _os_.unmarshal_int();
/* 170 */         this.JADE_BAG_AWARD_ID = _os_.unmarshal_int();
/* 171 */         this.JADE_UI_CFG_ID = _os_.unmarshal_int();
/* 172 */         this.JADE_MAP_ITEM_HANDLER_TYPE = _os_.unmarshal_int();
/* 173 */         this.ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 174 */         this.MIN_LEVEL = _os_.unmarshal_int();
/* 175 */         this.INIT_LUCKY_BAG_NUM_LEVEL_CFG_ID = _os_.unmarshal_int();
/* 176 */         this.BRASS_BAG_GET_AWARD_ID = _os_.unmarshal_int();
/* 177 */         this.JADE_BAG_GET_AWARD_ID = _os_.unmarshal_int();
/* 178 */         this.BOX_MAP_ITEM_HANDLER_TYPE = _os_.unmarshal_int();
/* 179 */         this.BOX_BAG_GET_AWARD_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 184 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 190 */     String path = dir + "mzm.gsp.luckybag.confbean.SLuckyBagCfgConsts.bny";
/*     */     try
/*     */     {
/* 193 */       File file = new File(path);
/* 194 */       if (file.exists())
/*     */       {
/* 196 */         byte[] bytes = new byte['Ѐ'];
/* 197 */         FileInputStream fis = new FileInputStream(file);
/* 198 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 199 */         int len = 0;
/* 200 */         while ((len = fis.read(bytes)) > 0)
/* 201 */           baos.write(bytes, 0, len);
/* 202 */         fis.close();
/* 203 */         bytes = baos.toByteArray();
/* 204 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 205 */         this.BRASS_ITEM_ID = _os_.unmarshal_int();
/* 206 */         this.OPEN_BRASS_BAG_NEED_NUM = _os_.unmarshal_int();
/* 207 */         this.BRASS_BAG_AWARD_ID = _os_.unmarshal_int();
/* 208 */         this.BRASS_UI_CFG_ID = _os_.unmarshal_int();
/* 209 */         this.BRASS_MAP_ITEM_HANDLER_TYPE = _os_.unmarshal_int();
/* 210 */         this.JADE_ITEM_ID = _os_.unmarshal_int();
/* 211 */         this.OPEN_JADE_BAG_NEED_NUM = _os_.unmarshal_int();
/* 212 */         this.JADE_BAG_AWARD_ID = _os_.unmarshal_int();
/* 213 */         this.JADE_UI_CFG_ID = _os_.unmarshal_int();
/* 214 */         this.JADE_MAP_ITEM_HANDLER_TYPE = _os_.unmarshal_int();
/* 215 */         this.ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 216 */         this.MIN_LEVEL = _os_.unmarshal_int();
/* 217 */         this.INIT_LUCKY_BAG_NUM_LEVEL_CFG_ID = _os_.unmarshal_int();
/* 218 */         this.BRASS_BAG_GET_AWARD_ID = _os_.unmarshal_int();
/* 219 */         this.JADE_BAG_GET_AWARD_ID = _os_.unmarshal_int();
/* 220 */         this.BOX_MAP_ITEM_HANDLER_TYPE = _os_.unmarshal_int();
/* 221 */         this.BOX_BAG_GET_AWARD_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 226 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SLuckyBagCfgConsts newInstance)
/*     */   {
/* 232 */     oldInstance = instance;
/* 233 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 238 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckybag\confbean\SLuckyBagCfgConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */