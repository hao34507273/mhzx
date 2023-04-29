/*     */ package mzm.gsp.fight.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class PetBattleConsts
/*     */ {
/*  13 */   private static volatile PetBattleConsts oldInstance = null;
/*     */   
/*  15 */   private static PetBattleConsts instance = new PetBattleConsts();
/*     */   public int effectStart;
/*     */   public int effectWin;
/*     */   public int effectFail;
/*     */   public int effectEndCostTime;
/*     */   public String defaultAI;
/*     */   
/*     */   public static PetBattleConsts getOldInstance() {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static PetBattleConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int watchTime;
/*     */   
/*     */   public int redGrid;
/*     */   
/*     */   public int blueGrid;
/*     */   
/*     */   public int redGridNoPet;
/*     */   
/*     */   public int blueGridNoPet;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  44 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  49 */     String path = dir + "mzm.gsp.fight.confbean.PetBattleConsts.xml";
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
/*  69 */       this.effectStart = Integer.valueOf(((Element)data.get("effectStart")).attributeValue("value")).intValue();
/*  70 */       this.effectWin = Integer.valueOf(((Element)data.get("effectWin")).attributeValue("value")).intValue();
/*  71 */       this.effectFail = Integer.valueOf(((Element)data.get("effectFail")).attributeValue("value")).intValue();
/*  72 */       this.effectEndCostTime = Integer.valueOf(((Element)data.get("effectEndCostTime")).attributeValue("value")).intValue();
/*  73 */       this.defaultAI = String.valueOf(((Element)data.get("defaultAI")).attributeValue("value"));
/*  74 */       this.watchTime = Integer.valueOf(((Element)data.get("watchTime")).attributeValue("value")).intValue();
/*  75 */       this.redGrid = Integer.valueOf(((Element)data.get("redGrid")).attributeValue("value")).intValue();
/*  76 */       this.blueGrid = Integer.valueOf(((Element)data.get("blueGrid")).attributeValue("value")).intValue();
/*  77 */       this.redGridNoPet = Integer.valueOf(((Element)data.get("redGridNoPet")).attributeValue("value")).intValue();
/*  78 */       this.blueGridNoPet = Integer.valueOf(((Element)data.get("blueGridNoPet")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  82 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  87 */     String path = dir + "mzm.gsp.fight.confbean.PetBattleConsts.xml";
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
/* 107 */       this.effectStart = Integer.valueOf(((Element)data.get("effectStart")).attributeValue("value")).intValue();
/* 108 */       this.effectWin = Integer.valueOf(((Element)data.get("effectWin")).attributeValue("value")).intValue();
/* 109 */       this.effectFail = Integer.valueOf(((Element)data.get("effectFail")).attributeValue("value")).intValue();
/* 110 */       this.effectEndCostTime = Integer.valueOf(((Element)data.get("effectEndCostTime")).attributeValue("value")).intValue();
/* 111 */       this.defaultAI = String.valueOf(((Element)data.get("defaultAI")).attributeValue("value"));
/* 112 */       this.watchTime = Integer.valueOf(((Element)data.get("watchTime")).attributeValue("value")).intValue();
/* 113 */       this.redGrid = Integer.valueOf(((Element)data.get("redGrid")).attributeValue("value")).intValue();
/* 114 */       this.blueGrid = Integer.valueOf(((Element)data.get("blueGrid")).attributeValue("value")).intValue();
/* 115 */       this.redGridNoPet = Integer.valueOf(((Element)data.get("redGridNoPet")).attributeValue("value")).intValue();
/* 116 */       this.blueGridNoPet = Integer.valueOf(((Element)data.get("blueGridNoPet")).attributeValue("value")).intValue();
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
/* 127 */     String path = dir + "mzm.gsp.fight.confbean.PetBattleConsts.bny";
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
/* 142 */         this.effectStart = _os_.unmarshal_int();
/* 143 */         this.effectWin = _os_.unmarshal_int();
/* 144 */         this.effectFail = _os_.unmarshal_int();
/* 145 */         this.effectEndCostTime = _os_.unmarshal_int();
/* 146 */         this.defaultAI = _os_.unmarshal_String("UTF-8");
/* 147 */         this.watchTime = _os_.unmarshal_int();
/* 148 */         this.redGrid = _os_.unmarshal_int();
/* 149 */         this.blueGrid = _os_.unmarshal_int();
/* 150 */         this.redGridNoPet = _os_.unmarshal_int();
/* 151 */         this.blueGridNoPet = _os_.unmarshal_int();
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
/* 162 */     String path = dir + "mzm.gsp.fight.confbean.PetBattleConsts.bny";
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
/* 177 */         this.effectStart = _os_.unmarshal_int();
/* 178 */         this.effectWin = _os_.unmarshal_int();
/* 179 */         this.effectFail = _os_.unmarshal_int();
/* 180 */         this.effectEndCostTime = _os_.unmarshal_int();
/* 181 */         this.defaultAI = _os_.unmarshal_String("UTF-8");
/* 182 */         this.watchTime = _os_.unmarshal_int();
/* 183 */         this.redGrid = _os_.unmarshal_int();
/* 184 */         this.blueGrid = _os_.unmarshal_int();
/* 185 */         this.redGridNoPet = _os_.unmarshal_int();
/* 186 */         this.blueGridNoPet = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 191 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(PetBattleConsts newInstance)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\confbean\PetBattleConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */