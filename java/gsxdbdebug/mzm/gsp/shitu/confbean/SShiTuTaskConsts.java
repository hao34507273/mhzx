/*     */ package mzm.gsp.shitu.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SShiTuTaskConsts
/*     */ {
/*  13 */   private static volatile SShiTuTaskConsts oldInstance = null;
/*     */   
/*  15 */   private static SShiTuTaskConsts instance = new SShiTuTaskConsts();
/*     */   public int TASK_GRAPH_ID_1;
/*     */   public int TASK_GRAPH_ID_2;
/*     */   public int TASK_GRAPH_ID_3;
/*     */   public int DAILY_MAX_FINISH_TIMES;
/*     */   public int DAILY_MAX_REFRESH_TIMES;
/*     */   
/*     */   public static SShiTuTaskConsts getOldInstance() {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SShiTuTaskConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int DAILY_REFRESH_TIME;
/*     */   
/*     */   public int RECEIVE_MAX_LEVEL;
/*     */   
/*     */   public int RECEIVE_MAX_TIMES;
/*     */   
/*     */   public int APPRENTICE_AWARD_MAIL_ID;
/*     */   
/*     */   public int DAILY_MAX_PUBLISH_TIMES;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  44 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  49 */     String path = dir + "mzm.gsp.shitu.confbean.SShiTuTaskConsts.xml";
/*     */     try
/*     */     {
/*  52 */       SAXReader reader = new SAXReader();
/*  53 */       org.dom4j.Document doc = reader.read(new File(path));
/*  54 */       Element root = doc.getRootElement();
/*  55 */       Map<String, Element> data = new java.util.HashMap();
/*  56 */       java.util.List<?> nodeList = root.elements();
/*  57 */       int len = nodeList.size();
/*  58 */       for (int i = 0; i < len; i++)
/*     */       {
/*  60 */         Element element = (Element)nodeList.get(i);
/*  61 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  64 */           String name = element.attributeValue("name");
/*  65 */           if (data.put(name, element) != null)
/*  66 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  69 */       this.TASK_GRAPH_ID_1 = Integer.valueOf(((Element)data.get("TASK_GRAPH_ID_1")).attributeValue("value")).intValue();
/*  70 */       this.TASK_GRAPH_ID_2 = Integer.valueOf(((Element)data.get("TASK_GRAPH_ID_2")).attributeValue("value")).intValue();
/*  71 */       this.TASK_GRAPH_ID_3 = Integer.valueOf(((Element)data.get("TASK_GRAPH_ID_3")).attributeValue("value")).intValue();
/*  72 */       this.DAILY_MAX_FINISH_TIMES = Integer.valueOf(((Element)data.get("DAILY_MAX_FINISH_TIMES")).attributeValue("value")).intValue();
/*  73 */       this.DAILY_MAX_REFRESH_TIMES = Integer.valueOf(((Element)data.get("DAILY_MAX_REFRESH_TIMES")).attributeValue("value")).intValue();
/*  74 */       this.DAILY_REFRESH_TIME = Integer.valueOf(((Element)data.get("DAILY_REFRESH_TIME")).attributeValue("value")).intValue();
/*  75 */       this.RECEIVE_MAX_LEVEL = Integer.valueOf(((Element)data.get("RECEIVE_MAX_LEVEL")).attributeValue("value")).intValue();
/*  76 */       this.RECEIVE_MAX_TIMES = Integer.valueOf(((Element)data.get("RECEIVE_MAX_TIMES")).attributeValue("value")).intValue();
/*  77 */       this.APPRENTICE_AWARD_MAIL_ID = Integer.valueOf(((Element)data.get("APPRENTICE_AWARD_MAIL_ID")).attributeValue("value")).intValue();
/*  78 */       this.DAILY_MAX_PUBLISH_TIMES = Integer.valueOf(((Element)data.get("DAILY_MAX_PUBLISH_TIMES")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  82 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  87 */     String path = dir + "mzm.gsp.shitu.confbean.SShiTuTaskConsts.xml";
/*     */     try
/*     */     {
/*  90 */       SAXReader reader = new SAXReader();
/*  91 */       org.dom4j.Document doc = reader.read(new File(path));
/*  92 */       Element root = doc.getRootElement();
/*  93 */       Map<String, Element> data = new java.util.HashMap();
/*  94 */       java.util.List<?> nodeList = root.elements();
/*  95 */       int len = nodeList.size();
/*  96 */       for (int i = 0; i < len; i++)
/*     */       {
/*  98 */         Element element = (Element)nodeList.get(i);
/*  99 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 102 */           String name = element.attributeValue("name");
/* 103 */           if (data.put(name, element) != null)
/* 104 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 107 */       this.TASK_GRAPH_ID_1 = Integer.valueOf(((Element)data.get("TASK_GRAPH_ID_1")).attributeValue("value")).intValue();
/* 108 */       this.TASK_GRAPH_ID_2 = Integer.valueOf(((Element)data.get("TASK_GRAPH_ID_2")).attributeValue("value")).intValue();
/* 109 */       this.TASK_GRAPH_ID_3 = Integer.valueOf(((Element)data.get("TASK_GRAPH_ID_3")).attributeValue("value")).intValue();
/* 110 */       this.DAILY_MAX_FINISH_TIMES = Integer.valueOf(((Element)data.get("DAILY_MAX_FINISH_TIMES")).attributeValue("value")).intValue();
/* 111 */       this.DAILY_MAX_REFRESH_TIMES = Integer.valueOf(((Element)data.get("DAILY_MAX_REFRESH_TIMES")).attributeValue("value")).intValue();
/* 112 */       this.DAILY_REFRESH_TIME = Integer.valueOf(((Element)data.get("DAILY_REFRESH_TIME")).attributeValue("value")).intValue();
/* 113 */       this.RECEIVE_MAX_LEVEL = Integer.valueOf(((Element)data.get("RECEIVE_MAX_LEVEL")).attributeValue("value")).intValue();
/* 114 */       this.RECEIVE_MAX_TIMES = Integer.valueOf(((Element)data.get("RECEIVE_MAX_TIMES")).attributeValue("value")).intValue();
/* 115 */       this.APPRENTICE_AWARD_MAIL_ID = Integer.valueOf(((Element)data.get("APPRENTICE_AWARD_MAIL_ID")).attributeValue("value")).intValue();
/* 116 */       this.DAILY_MAX_PUBLISH_TIMES = Integer.valueOf(((Element)data.get("DAILY_MAX_PUBLISH_TIMES")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 120 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 124 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 127 */     String path = dir + "mzm.gsp.shitu.confbean.SShiTuTaskConsts.bny";
/*     */     try
/*     */     {
/* 130 */       File file = new File(path);
/* 131 */       if (file.exists())
/*     */       {
/* 133 */         byte[] bytes = new byte['Ѐ'];
/* 134 */         FileInputStream fis = new FileInputStream(file);
/* 135 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 136 */         int len = 0;
/* 137 */         while ((len = fis.read(bytes)) > 0)
/* 138 */           baos.write(bytes, 0, len);
/* 139 */         fis.close();
/* 140 */         bytes = baos.toByteArray();
/* 141 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 142 */         this.TASK_GRAPH_ID_1 = _os_.unmarshal_int();
/* 143 */         this.TASK_GRAPH_ID_2 = _os_.unmarshal_int();
/* 144 */         this.TASK_GRAPH_ID_3 = _os_.unmarshal_int();
/* 145 */         this.DAILY_MAX_FINISH_TIMES = _os_.unmarshal_int();
/* 146 */         this.DAILY_MAX_REFRESH_TIMES = _os_.unmarshal_int();
/* 147 */         this.DAILY_REFRESH_TIME = _os_.unmarshal_int();
/* 148 */         this.RECEIVE_MAX_LEVEL = _os_.unmarshal_int();
/* 149 */         this.RECEIVE_MAX_TIMES = _os_.unmarshal_int();
/* 150 */         this.APPRENTICE_AWARD_MAIL_ID = _os_.unmarshal_int();
/* 151 */         this.DAILY_MAX_PUBLISH_TIMES = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 156 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 162 */     String path = dir + "mzm.gsp.shitu.confbean.SShiTuTaskConsts.bny";
/*     */     try
/*     */     {
/* 165 */       File file = new File(path);
/* 166 */       if (file.exists())
/*     */       {
/* 168 */         byte[] bytes = new byte['Ѐ'];
/* 169 */         FileInputStream fis = new FileInputStream(file);
/* 170 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 171 */         int len = 0;
/* 172 */         while ((len = fis.read(bytes)) > 0)
/* 173 */           baos.write(bytes, 0, len);
/* 174 */         fis.close();
/* 175 */         bytes = baos.toByteArray();
/* 176 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 177 */         this.TASK_GRAPH_ID_1 = _os_.unmarshal_int();
/* 178 */         this.TASK_GRAPH_ID_2 = _os_.unmarshal_int();
/* 179 */         this.TASK_GRAPH_ID_3 = _os_.unmarshal_int();
/* 180 */         this.DAILY_MAX_FINISH_TIMES = _os_.unmarshal_int();
/* 181 */         this.DAILY_MAX_REFRESH_TIMES = _os_.unmarshal_int();
/* 182 */         this.DAILY_REFRESH_TIME = _os_.unmarshal_int();
/* 183 */         this.RECEIVE_MAX_LEVEL = _os_.unmarshal_int();
/* 184 */         this.RECEIVE_MAX_TIMES = _os_.unmarshal_int();
/* 185 */         this.APPRENTICE_AWARD_MAIL_ID = _os_.unmarshal_int();
/* 186 */         this.DAILY_MAX_PUBLISH_TIMES = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 191 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SShiTuTaskConsts newInstance)
/*     */   {
/* 197 */     oldInstance = instance;
/* 198 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 203 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\confbean\SShiTuTaskConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */