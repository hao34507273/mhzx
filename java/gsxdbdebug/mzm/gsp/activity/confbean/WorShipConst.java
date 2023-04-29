/*     */ package mzm.gsp.activity.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class WorShipConst
/*     */ {
/*  13 */   private static volatile WorShipConst oldInstance = null;
/*     */   
/*  15 */   private static WorShipConst instance = new WorShipConst();
/*     */   public int activityId;
/*     */   public int npcId;
/*     */   public int serviceid;
/*     */   public int awardId;
/*     */   
/*     */   public static WorShipConst getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static WorShipConst getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int facitonFileId;
/*     */   
/*     */   public int recordMax;
/*     */   
/*     */   public int functionTipId;
/*     */   
/*     */   public int refreshNpcCommontimeId;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  42 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  47 */     String path = dir + "mzm.gsp.activity.confbean.WorShipConst.xml";
/*     */     try
/*     */     {
/*  50 */       SAXReader reader = new SAXReader();
/*  51 */       org.dom4j.Document doc = reader.read(new File(path));
/*  52 */       Element root = doc.getRootElement();
/*  53 */       Map<String, Element> data = new java.util.HashMap();
/*  54 */       java.util.List<?> nodeList = root.elements();
/*  55 */       int len = nodeList.size();
/*  56 */       for (int i = 0; i < len; i++)
/*     */       {
/*  58 */         Element element = (Element)nodeList.get(i);
/*  59 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  62 */           String name = element.attributeValue("name");
/*  63 */           if (data.put(name, element) != null)
/*  64 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  67 */       this.activityId = Integer.valueOf(((Element)data.get("activityId")).attributeValue("value")).intValue();
/*  68 */       this.npcId = Integer.valueOf(((Element)data.get("npcId")).attributeValue("value")).intValue();
/*  69 */       this.serviceid = Integer.valueOf(((Element)data.get("serviceid")).attributeValue("value")).intValue();
/*  70 */       this.awardId = Integer.valueOf(((Element)data.get("awardId")).attributeValue("value")).intValue();
/*  71 */       this.facitonFileId = Integer.valueOf(((Element)data.get("facitonFileId")).attributeValue("value")).intValue();
/*  72 */       this.recordMax = Integer.valueOf(((Element)data.get("recordMax")).attributeValue("value")).intValue();
/*  73 */       this.functionTipId = Integer.valueOf(((Element)data.get("functionTipId")).attributeValue("value")).intValue();
/*  74 */       this.refreshNpcCommontimeId = Integer.valueOf(((Element)data.get("refreshNpcCommontimeId")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  78 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  83 */     String path = dir + "mzm.gsp.activity.confbean.WorShipConst.xml";
/*     */     try
/*     */     {
/*  86 */       SAXReader reader = new SAXReader();
/*  87 */       org.dom4j.Document doc = reader.read(new File(path));
/*  88 */       Element root = doc.getRootElement();
/*  89 */       Map<String, Element> data = new java.util.HashMap();
/*  90 */       java.util.List<?> nodeList = root.elements();
/*  91 */       int len = nodeList.size();
/*  92 */       for (int i = 0; i < len; i++)
/*     */       {
/*  94 */         Element element = (Element)nodeList.get(i);
/*  95 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  98 */           String name = element.attributeValue("name");
/*  99 */           if (data.put(name, element) != null)
/* 100 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 103 */       this.activityId = Integer.valueOf(((Element)data.get("activityId")).attributeValue("value")).intValue();
/* 104 */       this.npcId = Integer.valueOf(((Element)data.get("npcId")).attributeValue("value")).intValue();
/* 105 */       this.serviceid = Integer.valueOf(((Element)data.get("serviceid")).attributeValue("value")).intValue();
/* 106 */       this.awardId = Integer.valueOf(((Element)data.get("awardId")).attributeValue("value")).intValue();
/* 107 */       this.facitonFileId = Integer.valueOf(((Element)data.get("facitonFileId")).attributeValue("value")).intValue();
/* 108 */       this.recordMax = Integer.valueOf(((Element)data.get("recordMax")).attributeValue("value")).intValue();
/* 109 */       this.functionTipId = Integer.valueOf(((Element)data.get("functionTipId")).attributeValue("value")).intValue();
/* 110 */       this.refreshNpcCommontimeId = Integer.valueOf(((Element)data.get("refreshNpcCommontimeId")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 114 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 118 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 121 */     String path = dir + "mzm.gsp.activity.confbean.WorShipConst.bny";
/*     */     try
/*     */     {
/* 124 */       File file = new File(path);
/* 125 */       if (file.exists())
/*     */       {
/* 127 */         byte[] bytes = new byte['Ѐ'];
/* 128 */         FileInputStream fis = new FileInputStream(file);
/* 129 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 130 */         int len = 0;
/* 131 */         while ((len = fis.read(bytes)) > 0)
/* 132 */           baos.write(bytes, 0, len);
/* 133 */         fis.close();
/* 134 */         bytes = baos.toByteArray();
/* 135 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 136 */         this.activityId = _os_.unmarshal_int();
/* 137 */         this.npcId = _os_.unmarshal_int();
/* 138 */         this.serviceid = _os_.unmarshal_int();
/* 139 */         this.awardId = _os_.unmarshal_int();
/* 140 */         this.facitonFileId = _os_.unmarshal_int();
/* 141 */         this.recordMax = _os_.unmarshal_int();
/* 142 */         this.functionTipId = _os_.unmarshal_int();
/* 143 */         this.refreshNpcCommontimeId = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 148 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 154 */     String path = dir + "mzm.gsp.activity.confbean.WorShipConst.bny";
/*     */     try
/*     */     {
/* 157 */       File file = new File(path);
/* 158 */       if (file.exists())
/*     */       {
/* 160 */         byte[] bytes = new byte['Ѐ'];
/* 161 */         FileInputStream fis = new FileInputStream(file);
/* 162 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 163 */         int len = 0;
/* 164 */         while ((len = fis.read(bytes)) > 0)
/* 165 */           baos.write(bytes, 0, len);
/* 166 */         fis.close();
/* 167 */         bytes = baos.toByteArray();
/* 168 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 169 */         this.activityId = _os_.unmarshal_int();
/* 170 */         this.npcId = _os_.unmarshal_int();
/* 171 */         this.serviceid = _os_.unmarshal_int();
/* 172 */         this.awardId = _os_.unmarshal_int();
/* 173 */         this.facitonFileId = _os_.unmarshal_int();
/* 174 */         this.recordMax = _os_.unmarshal_int();
/* 175 */         this.functionTipId = _os_.unmarshal_int();
/* 176 */         this.refreshNpcCommontimeId = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 181 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(WorShipConst newInstance)
/*     */   {
/* 187 */     oldInstance = instance;
/* 188 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 193 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\confbean\WorShipConst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */