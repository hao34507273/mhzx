/*     */ package mzm.gsp.constellation.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SConstellationConsts
/*     */ {
/*  13 */   private static volatile SConstellationConsts oldInstance = null;
/*     */   
/*  15 */   private static SConstellationConsts instance = new SConstellationConsts();
/*     */   public int Activityid;
/*     */   public int BeforeNotifyMinutes;
/*     */   public int StartCountDown;
/*     */   public int PerTurnLastSeconds;
/*     */   
/*     */   public static SConstellationConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SConstellationConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int PauseSeconds;
/*     */   
/*     */   public int ChangeTimes;
/*     */   
/*     */   public int CloseSeconds;
/*     */   
/*     */   public int CardCountPerTurn;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  42 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  47 */     String path = dir + "mzm.gsp.constellation.confbean.SConstellationConsts.xml";
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
/*  67 */       this.Activityid = Integer.valueOf(((Element)data.get("Activityid")).attributeValue("value")).intValue();
/*  68 */       this.BeforeNotifyMinutes = Integer.valueOf(((Element)data.get("BeforeNotifyMinutes")).attributeValue("value")).intValue();
/*  69 */       this.StartCountDown = Integer.valueOf(((Element)data.get("StartCountDown")).attributeValue("value")).intValue();
/*  70 */       this.PerTurnLastSeconds = Integer.valueOf(((Element)data.get("PerTurnLastSeconds")).attributeValue("value")).intValue();
/*  71 */       this.PauseSeconds = Integer.valueOf(((Element)data.get("PauseSeconds")).attributeValue("value")).intValue();
/*  72 */       this.ChangeTimes = Integer.valueOf(((Element)data.get("ChangeTimes")).attributeValue("value")).intValue();
/*  73 */       this.CloseSeconds = Integer.valueOf(((Element)data.get("CloseSeconds")).attributeValue("value")).intValue();
/*  74 */       this.CardCountPerTurn = Integer.valueOf(((Element)data.get("CardCountPerTurn")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  78 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  83 */     String path = dir + "mzm.gsp.constellation.confbean.SConstellationConsts.xml";
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
/* 103 */       this.Activityid = Integer.valueOf(((Element)data.get("Activityid")).attributeValue("value")).intValue();
/* 104 */       this.BeforeNotifyMinutes = Integer.valueOf(((Element)data.get("BeforeNotifyMinutes")).attributeValue("value")).intValue();
/* 105 */       this.StartCountDown = Integer.valueOf(((Element)data.get("StartCountDown")).attributeValue("value")).intValue();
/* 106 */       this.PerTurnLastSeconds = Integer.valueOf(((Element)data.get("PerTurnLastSeconds")).attributeValue("value")).intValue();
/* 107 */       this.PauseSeconds = Integer.valueOf(((Element)data.get("PauseSeconds")).attributeValue("value")).intValue();
/* 108 */       this.ChangeTimes = Integer.valueOf(((Element)data.get("ChangeTimes")).attributeValue("value")).intValue();
/* 109 */       this.CloseSeconds = Integer.valueOf(((Element)data.get("CloseSeconds")).attributeValue("value")).intValue();
/* 110 */       this.CardCountPerTurn = Integer.valueOf(((Element)data.get("CardCountPerTurn")).attributeValue("value")).intValue();
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
/* 121 */     String path = dir + "mzm.gsp.constellation.confbean.SConstellationConsts.bny";
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
/* 136 */         this.Activityid = _os_.unmarshal_int();
/* 137 */         this.BeforeNotifyMinutes = _os_.unmarshal_int();
/* 138 */         this.StartCountDown = _os_.unmarshal_int();
/* 139 */         this.PerTurnLastSeconds = _os_.unmarshal_int();
/* 140 */         this.PauseSeconds = _os_.unmarshal_int();
/* 141 */         this.ChangeTimes = _os_.unmarshal_int();
/* 142 */         this.CloseSeconds = _os_.unmarshal_int();
/* 143 */         this.CardCountPerTurn = _os_.unmarshal_int();
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
/* 154 */     String path = dir + "mzm.gsp.constellation.confbean.SConstellationConsts.bny";
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
/* 169 */         this.Activityid = _os_.unmarshal_int();
/* 170 */         this.BeforeNotifyMinutes = _os_.unmarshal_int();
/* 171 */         this.StartCountDown = _os_.unmarshal_int();
/* 172 */         this.PerTurnLastSeconds = _os_.unmarshal_int();
/* 173 */         this.PauseSeconds = _os_.unmarshal_int();
/* 174 */         this.ChangeTimes = _os_.unmarshal_int();
/* 175 */         this.CloseSeconds = _os_.unmarshal_int();
/* 176 */         this.CardCountPerTurn = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 181 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SConstellationConsts newInstance)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\constellation\confbean\SConstellationConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */