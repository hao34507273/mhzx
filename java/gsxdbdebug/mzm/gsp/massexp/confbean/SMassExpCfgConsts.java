/*     */ package mzm.gsp.massexp.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SMassExpCfgConsts
/*     */ {
/*  13 */   private static volatile SMassExpCfgConsts oldInstance = null;
/*     */   
/*  15 */   private static SMassExpCfgConsts instance = new SMassExpCfgConsts();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SMassExpCfgConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SMassExpCfgConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int ACTIVITY_CFG_ID = 350000000;
/*  32 */   public int NPC_CFG_ID = 150100000;
/*  33 */   public int SERVER_LEVEL_LIMIT = 65;
/*  34 */   public int ROLE_LEVEL_RANK_INDEX = 100;
/*  35 */   public int RANGE_LEVEL = 3;
/*  36 */   public int AWARD_CFG_ID = 1;
/*  37 */   public int MAIL_CFG_ID = 340000000;
/*  38 */   public int TASK_ICON_ID = 0;
/*  39 */   public int MAX_GRID = 10;
/*  40 */   public int TASK_PERIOD = 72;
/*  41 */   public int NPC_GET_TASK_SERVICE_ID = 0;
/*  42 */   public int MIN_LEVEL = 60;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  46 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  51 */     String path = dir + "mzm.gsp.massexp.confbean.SMassExpCfgConsts.xml";
/*     */     try
/*     */     {
/*  54 */       SAXReader reader = new SAXReader();
/*  55 */       org.dom4j.Document doc = reader.read(new File(path));
/*  56 */       Element root = doc.getRootElement();
/*  57 */       Map<String, Element> data = new java.util.HashMap();
/*  58 */       java.util.List<?> nodeList = root.elements();
/*  59 */       int len = nodeList.size();
/*  60 */       for (int i = 0; i < len; i++)
/*     */       {
/*  62 */         Element element = (Element)nodeList.get(i);
/*  63 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  66 */           String name = element.attributeValue("name");
/*  67 */           if (data.put(name, element) != null)
/*  68 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  71 */       this.ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/*  72 */       this.NPC_CFG_ID = Integer.valueOf(((Element)data.get("NPC_CFG_ID")).attributeValue("value")).intValue();
/*  73 */       this.SERVER_LEVEL_LIMIT = Integer.valueOf(((Element)data.get("SERVER_LEVEL_LIMIT")).attributeValue("value")).intValue();
/*  74 */       this.ROLE_LEVEL_RANK_INDEX = Integer.valueOf(((Element)data.get("ROLE_LEVEL_RANK_INDEX")).attributeValue("value")).intValue();
/*  75 */       this.RANGE_LEVEL = Integer.valueOf(((Element)data.get("RANGE_LEVEL")).attributeValue("value")).intValue();
/*  76 */       this.AWARD_CFG_ID = Integer.valueOf(((Element)data.get("AWARD_CFG_ID")).attributeValue("value")).intValue();
/*  77 */       this.MAIL_CFG_ID = Integer.valueOf(((Element)data.get("MAIL_CFG_ID")).attributeValue("value")).intValue();
/*  78 */       this.TASK_ICON_ID = Integer.valueOf(((Element)data.get("TASK_ICON_ID")).attributeValue("value")).intValue();
/*  79 */       this.MAX_GRID = Integer.valueOf(((Element)data.get("MAX_GRID")).attributeValue("value")).intValue();
/*  80 */       this.TASK_PERIOD = Integer.valueOf(((Element)data.get("TASK_PERIOD")).attributeValue("value")).intValue();
/*  81 */       this.NPC_GET_TASK_SERVICE_ID = Integer.valueOf(((Element)data.get("NPC_GET_TASK_SERVICE_ID")).attributeValue("value")).intValue();
/*  82 */       this.MIN_LEVEL = Integer.valueOf(((Element)data.get("MIN_LEVEL")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  86 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  91 */     String path = dir + "mzm.gsp.massexp.confbean.SMassExpCfgConsts.xml";
/*     */     try
/*     */     {
/*  94 */       SAXReader reader = new SAXReader();
/*  95 */       org.dom4j.Document doc = reader.read(new File(path));
/*  96 */       Element root = doc.getRootElement();
/*  97 */       Map<String, Element> data = new java.util.HashMap();
/*  98 */       java.util.List<?> nodeList = root.elements();
/*  99 */       int len = nodeList.size();
/* 100 */       for (int i = 0; i < len; i++)
/*     */       {
/* 102 */         Element element = (Element)nodeList.get(i);
/* 103 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 106 */           String name = element.attributeValue("name");
/* 107 */           if (data.put(name, element) != null)
/* 108 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 111 */       this.ACTIVITY_CFG_ID = Integer.valueOf(((Element)data.get("ACTIVITY_CFG_ID")).attributeValue("value")).intValue();
/* 112 */       this.NPC_CFG_ID = Integer.valueOf(((Element)data.get("NPC_CFG_ID")).attributeValue("value")).intValue();
/* 113 */       this.SERVER_LEVEL_LIMIT = Integer.valueOf(((Element)data.get("SERVER_LEVEL_LIMIT")).attributeValue("value")).intValue();
/* 114 */       this.ROLE_LEVEL_RANK_INDEX = Integer.valueOf(((Element)data.get("ROLE_LEVEL_RANK_INDEX")).attributeValue("value")).intValue();
/* 115 */       this.RANGE_LEVEL = Integer.valueOf(((Element)data.get("RANGE_LEVEL")).attributeValue("value")).intValue();
/* 116 */       this.AWARD_CFG_ID = Integer.valueOf(((Element)data.get("AWARD_CFG_ID")).attributeValue("value")).intValue();
/* 117 */       this.MAIL_CFG_ID = Integer.valueOf(((Element)data.get("MAIL_CFG_ID")).attributeValue("value")).intValue();
/* 118 */       this.TASK_ICON_ID = Integer.valueOf(((Element)data.get("TASK_ICON_ID")).attributeValue("value")).intValue();
/* 119 */       this.MAX_GRID = Integer.valueOf(((Element)data.get("MAX_GRID")).attributeValue("value")).intValue();
/* 120 */       this.TASK_PERIOD = Integer.valueOf(((Element)data.get("TASK_PERIOD")).attributeValue("value")).intValue();
/* 121 */       this.NPC_GET_TASK_SERVICE_ID = Integer.valueOf(((Element)data.get("NPC_GET_TASK_SERVICE_ID")).attributeValue("value")).intValue();
/* 122 */       this.MIN_LEVEL = Integer.valueOf(((Element)data.get("MIN_LEVEL")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 126 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 130 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 133 */     String path = dir + "mzm.gsp.massexp.confbean.SMassExpCfgConsts.bny";
/*     */     try
/*     */     {
/* 136 */       File file = new File(path);
/* 137 */       if (file.exists())
/*     */       {
/* 139 */         byte[] bytes = new byte['Ѐ'];
/* 140 */         FileInputStream fis = new FileInputStream(file);
/* 141 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 142 */         int len = 0;
/* 143 */         while ((len = fis.read(bytes)) > 0)
/* 144 */           baos.write(bytes, 0, len);
/* 145 */         fis.close();
/* 146 */         bytes = baos.toByteArray();
/* 147 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 148 */         this.ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 149 */         this.NPC_CFG_ID = _os_.unmarshal_int();
/* 150 */         this.SERVER_LEVEL_LIMIT = _os_.unmarshal_int();
/* 151 */         this.ROLE_LEVEL_RANK_INDEX = _os_.unmarshal_int();
/* 152 */         this.RANGE_LEVEL = _os_.unmarshal_int();
/* 153 */         this.AWARD_CFG_ID = _os_.unmarshal_int();
/* 154 */         this.MAIL_CFG_ID = _os_.unmarshal_int();
/* 155 */         this.TASK_ICON_ID = _os_.unmarshal_int();
/* 156 */         this.MAX_GRID = _os_.unmarshal_int();
/* 157 */         this.TASK_PERIOD = _os_.unmarshal_int();
/* 158 */         this.NPC_GET_TASK_SERVICE_ID = _os_.unmarshal_int();
/* 159 */         this.MIN_LEVEL = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 164 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 170 */     String path = dir + "mzm.gsp.massexp.confbean.SMassExpCfgConsts.bny";
/*     */     try
/*     */     {
/* 173 */       File file = new File(path);
/* 174 */       if (file.exists())
/*     */       {
/* 176 */         byte[] bytes = new byte['Ѐ'];
/* 177 */         FileInputStream fis = new FileInputStream(file);
/* 178 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 179 */         int len = 0;
/* 180 */         while ((len = fis.read(bytes)) > 0)
/* 181 */           baos.write(bytes, 0, len);
/* 182 */         fis.close();
/* 183 */         bytes = baos.toByteArray();
/* 184 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 185 */         this.ACTIVITY_CFG_ID = _os_.unmarshal_int();
/* 186 */         this.NPC_CFG_ID = _os_.unmarshal_int();
/* 187 */         this.SERVER_LEVEL_LIMIT = _os_.unmarshal_int();
/* 188 */         this.ROLE_LEVEL_RANK_INDEX = _os_.unmarshal_int();
/* 189 */         this.RANGE_LEVEL = _os_.unmarshal_int();
/* 190 */         this.AWARD_CFG_ID = _os_.unmarshal_int();
/* 191 */         this.MAIL_CFG_ID = _os_.unmarshal_int();
/* 192 */         this.TASK_ICON_ID = _os_.unmarshal_int();
/* 193 */         this.MAX_GRID = _os_.unmarshal_int();
/* 194 */         this.TASK_PERIOD = _os_.unmarshal_int();
/* 195 */         this.NPC_GET_TASK_SERVICE_ID = _os_.unmarshal_int();
/* 196 */         this.MIN_LEVEL = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 201 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SMassExpCfgConsts newInstance)
/*     */   {
/* 207 */     oldInstance = instance;
/* 208 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 213 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\massexp\confbean\SMassExpCfgConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */