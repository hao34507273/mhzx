/*     */ package mzm.gsp.ladder.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SLadderConsts
/*     */ {
/*  13 */   private static volatile SLadderConsts oldInstance = null;
/*     */   
/*  15 */   private static SLadderConsts instance = new SLadderConsts();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SLadderConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SLadderConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int activityid = 350000040;
/*  32 */   public int npcid = 150113304;
/*  33 */   public int npcServiceid = 150210353;
/*  34 */   public int k = 32;
/*  35 */   public int leaveSec = 15;
/*  36 */   public int fightAwardid = 0;
/*  37 */   public int seasonParam = 0;
/*  38 */   public int weekFightScoreLimit = 500;
/*  39 */   public int protectSec = 7200;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  43 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  48 */     String path = dir + "mzm.gsp.ladder.confbean.SLadderConsts.xml";
/*     */     try
/*     */     {
/*  51 */       SAXReader reader = new SAXReader();
/*  52 */       org.dom4j.Document doc = reader.read(new File(path));
/*  53 */       Element root = doc.getRootElement();
/*  54 */       Map<String, Element> data = new java.util.HashMap();
/*  55 */       java.util.List<?> nodeList = root.elements();
/*  56 */       int len = nodeList.size();
/*  57 */       for (int i = 0; i < len; i++)
/*     */       {
/*  59 */         Element element = (Element)nodeList.get(i);
/*  60 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  63 */           String name = element.attributeValue("name");
/*  64 */           if (data.put(name, element) != null)
/*  65 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  68 */       this.activityid = Integer.valueOf(((Element)data.get("activityid")).attributeValue("value")).intValue();
/*  69 */       this.npcid = Integer.valueOf(((Element)data.get("npcid")).attributeValue("value")).intValue();
/*  70 */       this.npcServiceid = Integer.valueOf(((Element)data.get("npcServiceid")).attributeValue("value")).intValue();
/*  71 */       this.k = Integer.valueOf(((Element)data.get("k")).attributeValue("value")).intValue();
/*  72 */       this.leaveSec = Integer.valueOf(((Element)data.get("leaveSec")).attributeValue("value")).intValue();
/*  73 */       this.fightAwardid = Integer.valueOf(((Element)data.get("fightAwardid")).attributeValue("value")).intValue();
/*  74 */       this.seasonParam = Integer.valueOf(((Element)data.get("seasonParam")).attributeValue("value")).intValue();
/*  75 */       this.weekFightScoreLimit = Integer.valueOf(((Element)data.get("weekFightScoreLimit")).attributeValue("value")).intValue();
/*  76 */       this.protectSec = Integer.valueOf(((Element)data.get("protectSec")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  80 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  85 */     String path = dir + "mzm.gsp.ladder.confbean.SLadderConsts.xml";
/*     */     try
/*     */     {
/*  88 */       SAXReader reader = new SAXReader();
/*  89 */       org.dom4j.Document doc = reader.read(new File(path));
/*  90 */       Element root = doc.getRootElement();
/*  91 */       Map<String, Element> data = new java.util.HashMap();
/*  92 */       java.util.List<?> nodeList = root.elements();
/*  93 */       int len = nodeList.size();
/*  94 */       for (int i = 0; i < len; i++)
/*     */       {
/*  96 */         Element element = (Element)nodeList.get(i);
/*  97 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 100 */           String name = element.attributeValue("name");
/* 101 */           if (data.put(name, element) != null)
/* 102 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 105 */       this.activityid = Integer.valueOf(((Element)data.get("activityid")).attributeValue("value")).intValue();
/* 106 */       this.npcid = Integer.valueOf(((Element)data.get("npcid")).attributeValue("value")).intValue();
/* 107 */       this.npcServiceid = Integer.valueOf(((Element)data.get("npcServiceid")).attributeValue("value")).intValue();
/* 108 */       this.k = Integer.valueOf(((Element)data.get("k")).attributeValue("value")).intValue();
/* 109 */       this.leaveSec = Integer.valueOf(((Element)data.get("leaveSec")).attributeValue("value")).intValue();
/* 110 */       this.fightAwardid = Integer.valueOf(((Element)data.get("fightAwardid")).attributeValue("value")).intValue();
/* 111 */       this.seasonParam = Integer.valueOf(((Element)data.get("seasonParam")).attributeValue("value")).intValue();
/* 112 */       this.weekFightScoreLimit = Integer.valueOf(((Element)data.get("weekFightScoreLimit")).attributeValue("value")).intValue();
/* 113 */       this.protectSec = Integer.valueOf(((Element)data.get("protectSec")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 117 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 121 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 124 */     String path = dir + "mzm.gsp.ladder.confbean.SLadderConsts.bny";
/*     */     try
/*     */     {
/* 127 */       File file = new File(path);
/* 128 */       if (file.exists())
/*     */       {
/* 130 */         byte[] bytes = new byte['Ѐ'];
/* 131 */         FileInputStream fis = new FileInputStream(file);
/* 132 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 133 */         int len = 0;
/* 134 */         while ((len = fis.read(bytes)) > 0)
/* 135 */           baos.write(bytes, 0, len);
/* 136 */         fis.close();
/* 137 */         bytes = baos.toByteArray();
/* 138 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 139 */         this.activityid = _os_.unmarshal_int();
/* 140 */         this.npcid = _os_.unmarshal_int();
/* 141 */         this.npcServiceid = _os_.unmarshal_int();
/* 142 */         this.k = _os_.unmarshal_int();
/* 143 */         this.leaveSec = _os_.unmarshal_int();
/* 144 */         this.fightAwardid = _os_.unmarshal_int();
/* 145 */         this.seasonParam = _os_.unmarshal_int();
/* 146 */         this.weekFightScoreLimit = _os_.unmarshal_int();
/* 147 */         this.protectSec = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 152 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 158 */     String path = dir + "mzm.gsp.ladder.confbean.SLadderConsts.bny";
/*     */     try
/*     */     {
/* 161 */       File file = new File(path);
/* 162 */       if (file.exists())
/*     */       {
/* 164 */         byte[] bytes = new byte['Ѐ'];
/* 165 */         FileInputStream fis = new FileInputStream(file);
/* 166 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 167 */         int len = 0;
/* 168 */         while ((len = fis.read(bytes)) > 0)
/* 169 */           baos.write(bytes, 0, len);
/* 170 */         fis.close();
/* 171 */         bytes = baos.toByteArray();
/* 172 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 173 */         this.activityid = _os_.unmarshal_int();
/* 174 */         this.npcid = _os_.unmarshal_int();
/* 175 */         this.npcServiceid = _os_.unmarshal_int();
/* 176 */         this.k = _os_.unmarshal_int();
/* 177 */         this.leaveSec = _os_.unmarshal_int();
/* 178 */         this.fightAwardid = _os_.unmarshal_int();
/* 179 */         this.seasonParam = _os_.unmarshal_int();
/* 180 */         this.weekFightScoreLimit = _os_.unmarshal_int();
/* 181 */         this.protectSec = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 186 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SLadderConsts newInstance)
/*     */   {
/* 192 */     oldInstance = instance;
/* 193 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 198 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\confbean\SLadderConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */