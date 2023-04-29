/*     */ package mzm.gsp.singlebattle.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SingleBattleConsts
/*     */ {
/*  13 */   private static volatile SingleBattleConsts oldInstance = null;
/*     */   
/*  15 */   private static SingleBattleConsts instance = new SingleBattleConsts();
/*     */   public int friendColour;
/*     */   public int attackColour;
/*     */   public int protectColour;
/*     */   public int positionSourceCalInterval;
/*     */   public int gatherStateIcon;
/*     */   public int grabSucEffectId;
/*     */   
/*  23 */   public static SingleBattleConsts getOldInstance() { return oldInstance; }
/*     */   
/*     */ 
/*     */   public static SingleBattleConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void loadXml(String dir)
/*     */   {
/*  40 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  45 */     String path = dir + "mzm.gsp.singlebattle.confbean.SingleBattleConsts.xml";
/*     */     try
/*     */     {
/*  48 */       SAXReader reader = new SAXReader();
/*  49 */       org.dom4j.Document doc = reader.read(new File(path));
/*  50 */       Element root = doc.getRootElement();
/*  51 */       Map<String, Element> data = new java.util.HashMap();
/*  52 */       java.util.List<?> nodeList = root.elements();
/*  53 */       int len = nodeList.size();
/*  54 */       for (int i = 0; i < len; i++)
/*     */       {
/*  56 */         Element element = (Element)nodeList.get(i);
/*  57 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  60 */           String name = element.attributeValue("name");
/*  61 */           if (data.put(name, element) != null)
/*  62 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  65 */       this.friendColour = Integer.valueOf(((Element)data.get("friendColour")).attributeValue("value")).intValue();
/*  66 */       this.attackColour = Integer.valueOf(((Element)data.get("attackColour")).attributeValue("value")).intValue();
/*  67 */       this.protectColour = Integer.valueOf(((Element)data.get("protectColour")).attributeValue("value")).intValue();
/*  68 */       this.positionSourceCalInterval = Integer.valueOf(((Element)data.get("positionSourceCalInterval")).attributeValue("value")).intValue();
/*  69 */       this.gatherStateIcon = Integer.valueOf(((Element)data.get("gatherStateIcon")).attributeValue("value")).intValue();
/*  70 */       this.grabSucEffectId = Integer.valueOf(((Element)data.get("grabSucEffectId")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  74 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  79 */     String path = dir + "mzm.gsp.singlebattle.confbean.SingleBattleConsts.xml";
/*     */     try
/*     */     {
/*  82 */       SAXReader reader = new SAXReader();
/*  83 */       org.dom4j.Document doc = reader.read(new File(path));
/*  84 */       Element root = doc.getRootElement();
/*  85 */       Map<String, Element> data = new java.util.HashMap();
/*  86 */       java.util.List<?> nodeList = root.elements();
/*  87 */       int len = nodeList.size();
/*  88 */       for (int i = 0; i < len; i++)
/*     */       {
/*  90 */         Element element = (Element)nodeList.get(i);
/*  91 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  94 */           String name = element.attributeValue("name");
/*  95 */           if (data.put(name, element) != null)
/*  96 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  99 */       this.friendColour = Integer.valueOf(((Element)data.get("friendColour")).attributeValue("value")).intValue();
/* 100 */       this.attackColour = Integer.valueOf(((Element)data.get("attackColour")).attributeValue("value")).intValue();
/* 101 */       this.protectColour = Integer.valueOf(((Element)data.get("protectColour")).attributeValue("value")).intValue();
/* 102 */       this.positionSourceCalInterval = Integer.valueOf(((Element)data.get("positionSourceCalInterval")).attributeValue("value")).intValue();
/* 103 */       this.gatherStateIcon = Integer.valueOf(((Element)data.get("gatherStateIcon")).attributeValue("value")).intValue();
/* 104 */       this.grabSucEffectId = Integer.valueOf(((Element)data.get("grabSucEffectId")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 108 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 112 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 115 */     String path = dir + "mzm.gsp.singlebattle.confbean.SingleBattleConsts.bny";
/*     */     try
/*     */     {
/* 118 */       File file = new File(path);
/* 119 */       if (file.exists())
/*     */       {
/* 121 */         byte[] bytes = new byte['Ѐ'];
/* 122 */         FileInputStream fis = new FileInputStream(file);
/* 123 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 124 */         int len = 0;
/* 125 */         while ((len = fis.read(bytes)) > 0)
/* 126 */           baos.write(bytes, 0, len);
/* 127 */         fis.close();
/* 128 */         bytes = baos.toByteArray();
/* 129 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 130 */         this.friendColour = _os_.unmarshal_int();
/* 131 */         this.attackColour = _os_.unmarshal_int();
/* 132 */         this.protectColour = _os_.unmarshal_int();
/* 133 */         this.positionSourceCalInterval = _os_.unmarshal_int();
/* 134 */         this.gatherStateIcon = _os_.unmarshal_int();
/* 135 */         this.grabSucEffectId = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 140 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 146 */     String path = dir + "mzm.gsp.singlebattle.confbean.SingleBattleConsts.bny";
/*     */     try
/*     */     {
/* 149 */       File file = new File(path);
/* 150 */       if (file.exists())
/*     */       {
/* 152 */         byte[] bytes = new byte['Ѐ'];
/* 153 */         FileInputStream fis = new FileInputStream(file);
/* 154 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 155 */         int len = 0;
/* 156 */         while ((len = fis.read(bytes)) > 0)
/* 157 */           baos.write(bytes, 0, len);
/* 158 */         fis.close();
/* 159 */         bytes = baos.toByteArray();
/* 160 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 161 */         this.friendColour = _os_.unmarshal_int();
/* 162 */         this.attackColour = _os_.unmarshal_int();
/* 163 */         this.protectColour = _os_.unmarshal_int();
/* 164 */         this.positionSourceCalInterval = _os_.unmarshal_int();
/* 165 */         this.gatherStateIcon = _os_.unmarshal_int();
/* 166 */         this.grabSucEffectId = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 171 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SingleBattleConsts newInstance)
/*     */   {
/* 177 */     oldInstance = instance;
/* 178 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 183 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\confbean\SingleBattleConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */