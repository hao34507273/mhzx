/*     */ package mzm.gsp.qingyunzhi.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class QingConsts
/*     */ {
/*  13 */   private static volatile QingConsts oldInstance = null;
/*     */   
/*  15 */   private static QingConsts instance = new QingConsts();
/*     */   public int ACTIVITYID;
/*     */   public int NPC_SERVICE;
/*     */   public int NORMAL_OPEN_LEVEL;
/*     */   public int ELITE_OPEN_LEVEL;
/*     */   public int HERO_OPEN_LEVEL;
/*     */   public int XIAYI_VALUE;
/*     */   
/*  23 */   public static QingConsts getOldInstance() { return oldInstance; }
/*     */   
/*     */ 
/*     */   public static QingConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int QING_NPC_ID;
/*     */   
/*     */   public int ELITE_ACTIVITYID;
/*     */   
/*     */   public int HERO_ACTIVITYID;
/*     */   
/*     */   public int HELP_ELITE_COUNT_MAX;
/*     */   
/*     */   public int HELP_HERO_COUNT_MAX;
/*     */   
/*     */   public int HELP_ELITE_AWARD_ID;
/*     */   
/*     */   public int HELP_HERO_AWARD_ID;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  47 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  52 */     String path = dir + "mzm.gsp.qingyunzhi.confbean.QingConsts.xml";
/*     */     try
/*     */     {
/*  55 */       SAXReader reader = new SAXReader();
/*  56 */       org.dom4j.Document doc = reader.read(new File(path));
/*  57 */       Element root = doc.getRootElement();
/*  58 */       Map<String, Element> data = new java.util.HashMap();
/*  59 */       java.util.List<?> nodeList = root.elements();
/*  60 */       int len = nodeList.size();
/*  61 */       for (int i = 0; i < len; i++)
/*     */       {
/*  63 */         Element element = (Element)nodeList.get(i);
/*  64 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  67 */           String name = element.attributeValue("name");
/*  68 */           if (data.put(name, element) != null)
/*  69 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  72 */       this.ACTIVITYID = Integer.valueOf(((Element)data.get("ACTIVITYID")).attributeValue("value")).intValue();
/*  73 */       this.NPC_SERVICE = Integer.valueOf(((Element)data.get("NPC_SERVICE")).attributeValue("value")).intValue();
/*  74 */       this.NORMAL_OPEN_LEVEL = Integer.valueOf(((Element)data.get("NORMAL_OPEN_LEVEL")).attributeValue("value")).intValue();
/*  75 */       this.ELITE_OPEN_LEVEL = Integer.valueOf(((Element)data.get("ELITE_OPEN_LEVEL")).attributeValue("value")).intValue();
/*  76 */       this.HERO_OPEN_LEVEL = Integer.valueOf(((Element)data.get("HERO_OPEN_LEVEL")).attributeValue("value")).intValue();
/*  77 */       this.XIAYI_VALUE = Integer.valueOf(((Element)data.get("XIAYI_VALUE")).attributeValue("value")).intValue();
/*  78 */       this.QING_NPC_ID = Integer.valueOf(((Element)data.get("QING_NPC_ID")).attributeValue("value")).intValue();
/*  79 */       this.ELITE_ACTIVITYID = Integer.valueOf(((Element)data.get("ELITE_ACTIVITYID")).attributeValue("value")).intValue();
/*  80 */       this.HERO_ACTIVITYID = Integer.valueOf(((Element)data.get("HERO_ACTIVITYID")).attributeValue("value")).intValue();
/*  81 */       this.HELP_ELITE_COUNT_MAX = Integer.valueOf(((Element)data.get("HELP_ELITE_COUNT_MAX")).attributeValue("value")).intValue();
/*  82 */       this.HELP_HERO_COUNT_MAX = Integer.valueOf(((Element)data.get("HELP_HERO_COUNT_MAX")).attributeValue("value")).intValue();
/*  83 */       this.HELP_ELITE_AWARD_ID = Integer.valueOf(((Element)data.get("HELP_ELITE_AWARD_ID")).attributeValue("value")).intValue();
/*  84 */       this.HELP_HERO_AWARD_ID = Integer.valueOf(((Element)data.get("HELP_HERO_AWARD_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  88 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  93 */     String path = dir + "mzm.gsp.qingyunzhi.confbean.QingConsts.xml";
/*     */     try
/*     */     {
/*  96 */       SAXReader reader = new SAXReader();
/*  97 */       org.dom4j.Document doc = reader.read(new File(path));
/*  98 */       Element root = doc.getRootElement();
/*  99 */       Map<String, Element> data = new java.util.HashMap();
/* 100 */       java.util.List<?> nodeList = root.elements();
/* 101 */       int len = nodeList.size();
/* 102 */       for (int i = 0; i < len; i++)
/*     */       {
/* 104 */         Element element = (Element)nodeList.get(i);
/* 105 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 108 */           String name = element.attributeValue("name");
/* 109 */           if (data.put(name, element) != null)
/* 110 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 113 */       this.ACTIVITYID = Integer.valueOf(((Element)data.get("ACTIVITYID")).attributeValue("value")).intValue();
/* 114 */       this.NPC_SERVICE = Integer.valueOf(((Element)data.get("NPC_SERVICE")).attributeValue("value")).intValue();
/* 115 */       this.NORMAL_OPEN_LEVEL = Integer.valueOf(((Element)data.get("NORMAL_OPEN_LEVEL")).attributeValue("value")).intValue();
/* 116 */       this.ELITE_OPEN_LEVEL = Integer.valueOf(((Element)data.get("ELITE_OPEN_LEVEL")).attributeValue("value")).intValue();
/* 117 */       this.HERO_OPEN_LEVEL = Integer.valueOf(((Element)data.get("HERO_OPEN_LEVEL")).attributeValue("value")).intValue();
/* 118 */       this.XIAYI_VALUE = Integer.valueOf(((Element)data.get("XIAYI_VALUE")).attributeValue("value")).intValue();
/* 119 */       this.QING_NPC_ID = Integer.valueOf(((Element)data.get("QING_NPC_ID")).attributeValue("value")).intValue();
/* 120 */       this.ELITE_ACTIVITYID = Integer.valueOf(((Element)data.get("ELITE_ACTIVITYID")).attributeValue("value")).intValue();
/* 121 */       this.HERO_ACTIVITYID = Integer.valueOf(((Element)data.get("HERO_ACTIVITYID")).attributeValue("value")).intValue();
/* 122 */       this.HELP_ELITE_COUNT_MAX = Integer.valueOf(((Element)data.get("HELP_ELITE_COUNT_MAX")).attributeValue("value")).intValue();
/* 123 */       this.HELP_HERO_COUNT_MAX = Integer.valueOf(((Element)data.get("HELP_HERO_COUNT_MAX")).attributeValue("value")).intValue();
/* 124 */       this.HELP_ELITE_AWARD_ID = Integer.valueOf(((Element)data.get("HELP_ELITE_AWARD_ID")).attributeValue("value")).intValue();
/* 125 */       this.HELP_HERO_AWARD_ID = Integer.valueOf(((Element)data.get("HELP_HERO_AWARD_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 129 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 133 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 136 */     String path = dir + "mzm.gsp.qingyunzhi.confbean.QingConsts.bny";
/*     */     try
/*     */     {
/* 139 */       File file = new File(path);
/* 140 */       if (file.exists())
/*     */       {
/* 142 */         byte[] bytes = new byte['Ѐ'];
/* 143 */         FileInputStream fis = new FileInputStream(file);
/* 144 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 145 */         int len = 0;
/* 146 */         while ((len = fis.read(bytes)) > 0)
/* 147 */           baos.write(bytes, 0, len);
/* 148 */         fis.close();
/* 149 */         bytes = baos.toByteArray();
/* 150 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 151 */         this.ACTIVITYID = _os_.unmarshal_int();
/* 152 */         this.NPC_SERVICE = _os_.unmarshal_int();
/* 153 */         this.NORMAL_OPEN_LEVEL = _os_.unmarshal_int();
/* 154 */         this.ELITE_OPEN_LEVEL = _os_.unmarshal_int();
/* 155 */         this.HERO_OPEN_LEVEL = _os_.unmarshal_int();
/* 156 */         this.XIAYI_VALUE = _os_.unmarshal_int();
/* 157 */         this.QING_NPC_ID = _os_.unmarshal_int();
/* 158 */         this.ELITE_ACTIVITYID = _os_.unmarshal_int();
/* 159 */         this.HERO_ACTIVITYID = _os_.unmarshal_int();
/* 160 */         this.HELP_ELITE_COUNT_MAX = _os_.unmarshal_int();
/* 161 */         this.HELP_HERO_COUNT_MAX = _os_.unmarshal_int();
/* 162 */         this.HELP_ELITE_AWARD_ID = _os_.unmarshal_int();
/* 163 */         this.HELP_HERO_AWARD_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 168 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 174 */     String path = dir + "mzm.gsp.qingyunzhi.confbean.QingConsts.bny";
/*     */     try
/*     */     {
/* 177 */       File file = new File(path);
/* 178 */       if (file.exists())
/*     */       {
/* 180 */         byte[] bytes = new byte['Ѐ'];
/* 181 */         FileInputStream fis = new FileInputStream(file);
/* 182 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 183 */         int len = 0;
/* 184 */         while ((len = fis.read(bytes)) > 0)
/* 185 */           baos.write(bytes, 0, len);
/* 186 */         fis.close();
/* 187 */         bytes = baos.toByteArray();
/* 188 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 189 */         this.ACTIVITYID = _os_.unmarshal_int();
/* 190 */         this.NPC_SERVICE = _os_.unmarshal_int();
/* 191 */         this.NORMAL_OPEN_LEVEL = _os_.unmarshal_int();
/* 192 */         this.ELITE_OPEN_LEVEL = _os_.unmarshal_int();
/* 193 */         this.HERO_OPEN_LEVEL = _os_.unmarshal_int();
/* 194 */         this.XIAYI_VALUE = _os_.unmarshal_int();
/* 195 */         this.QING_NPC_ID = _os_.unmarshal_int();
/* 196 */         this.ELITE_ACTIVITYID = _os_.unmarshal_int();
/* 197 */         this.HERO_ACTIVITYID = _os_.unmarshal_int();
/* 198 */         this.HELP_ELITE_COUNT_MAX = _os_.unmarshal_int();
/* 199 */         this.HELP_HERO_COUNT_MAX = _os_.unmarshal_int();
/* 200 */         this.HELP_ELITE_AWARD_ID = _os_.unmarshal_int();
/* 201 */         this.HELP_HERO_AWARD_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 206 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(QingConsts newInstance)
/*     */   {
/* 212 */     oldInstance = instance;
/* 213 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 218 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyunzhi\confbean\QingConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */