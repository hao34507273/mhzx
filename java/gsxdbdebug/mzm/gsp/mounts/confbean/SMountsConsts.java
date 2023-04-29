/*     */ package mzm.gsp.mounts.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SMountsConsts
/*     */ {
/*  13 */   private static volatile SMountsConsts oldInstance = null;
/*     */   
/*  15 */   private static SMountsConsts instance = new SMountsConsts();
/*     */   
/*     */   public int mountsOpenLevel;
/*     */   public int maxMountsRank;
/*     */   public int maxBattleMounts;
/*     */   
/*     */   public static SMountsConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SMountsConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int maxMountsProtectPets;
/*     */   
/*     */   public int appearenceMountsExpiredMailId;
/*     */   
/*     */   public int maxMountsNum;
/*     */   
/*     */   public int rankUpMountsRestoreMailId;
/*     */   public int rankUpMountsRestoreProb;
/*     */   public int chiefMountsCellId;
/*     */   public int panda_cfg_id;
/*     */   public int fox_cfg_id;
/*     */   public int dou_dou_cfg_id;
/*     */   public int leopard_cfg_id;
/*     */   public int meng_yan_cfg_id;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  48 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  53 */     String path = dir + "mzm.gsp.mounts.confbean.SMountsConsts.xml";
/*     */     try
/*     */     {
/*  56 */       SAXReader reader = new SAXReader();
/*  57 */       org.dom4j.Document doc = reader.read(new File(path));
/*  58 */       Element root = doc.getRootElement();
/*  59 */       Map<String, Element> data = new java.util.HashMap();
/*  60 */       java.util.List<?> nodeList = root.elements();
/*  61 */       int len = nodeList.size();
/*  62 */       for (int i = 0; i < len; i++)
/*     */       {
/*  64 */         Element element = (Element)nodeList.get(i);
/*  65 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  68 */           String name = element.attributeValue("name");
/*  69 */           if (data.put(name, element) != null)
/*  70 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  73 */       this.mountsOpenLevel = Integer.valueOf(((Element)data.get("mountsOpenLevel")).attributeValue("value")).intValue();
/*  74 */       this.maxMountsRank = Integer.valueOf(((Element)data.get("maxMountsRank")).attributeValue("value")).intValue();
/*  75 */       this.maxBattleMounts = Integer.valueOf(((Element)data.get("maxBattleMounts")).attributeValue("value")).intValue();
/*  76 */       this.maxMountsProtectPets = Integer.valueOf(((Element)data.get("maxMountsProtectPets")).attributeValue("value")).intValue();
/*  77 */       this.appearenceMountsExpiredMailId = Integer.valueOf(((Element)data.get("appearenceMountsExpiredMailId")).attributeValue("value")).intValue();
/*  78 */       this.maxMountsNum = Integer.valueOf(((Element)data.get("maxMountsNum")).attributeValue("value")).intValue();
/*  79 */       this.rankUpMountsRestoreMailId = Integer.valueOf(((Element)data.get("rankUpMountsRestoreMailId")).attributeValue("value")).intValue();
/*  80 */       this.rankUpMountsRestoreProb = Integer.valueOf(((Element)data.get("rankUpMountsRestoreProb")).attributeValue("value")).intValue();
/*  81 */       this.chiefMountsCellId = Integer.valueOf(((Element)data.get("chiefMountsCellId")).attributeValue("value")).intValue();
/*  82 */       this.panda_cfg_id = Integer.valueOf(((Element)data.get("panda_cfg_id")).attributeValue("value")).intValue();
/*  83 */       this.fox_cfg_id = Integer.valueOf(((Element)data.get("fox_cfg_id")).attributeValue("value")).intValue();
/*  84 */       this.dou_dou_cfg_id = Integer.valueOf(((Element)data.get("dou_dou_cfg_id")).attributeValue("value")).intValue();
/*  85 */       this.leopard_cfg_id = Integer.valueOf(((Element)data.get("leopard_cfg_id")).attributeValue("value")).intValue();
/*  86 */       this.meng_yan_cfg_id = Integer.valueOf(((Element)data.get("meng_yan_cfg_id")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  90 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  95 */     String path = dir + "mzm.gsp.mounts.confbean.SMountsConsts.xml";
/*     */     try
/*     */     {
/*  98 */       SAXReader reader = new SAXReader();
/*  99 */       org.dom4j.Document doc = reader.read(new File(path));
/* 100 */       Element root = doc.getRootElement();
/* 101 */       Map<String, Element> data = new java.util.HashMap();
/* 102 */       java.util.List<?> nodeList = root.elements();
/* 103 */       int len = nodeList.size();
/* 104 */       for (int i = 0; i < len; i++)
/*     */       {
/* 106 */         Element element = (Element)nodeList.get(i);
/* 107 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 110 */           String name = element.attributeValue("name");
/* 111 */           if (data.put(name, element) != null)
/* 112 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 115 */       this.mountsOpenLevel = Integer.valueOf(((Element)data.get("mountsOpenLevel")).attributeValue("value")).intValue();
/* 116 */       this.maxMountsRank = Integer.valueOf(((Element)data.get("maxMountsRank")).attributeValue("value")).intValue();
/* 117 */       this.maxBattleMounts = Integer.valueOf(((Element)data.get("maxBattleMounts")).attributeValue("value")).intValue();
/* 118 */       this.maxMountsProtectPets = Integer.valueOf(((Element)data.get("maxMountsProtectPets")).attributeValue("value")).intValue();
/* 119 */       this.appearenceMountsExpiredMailId = Integer.valueOf(((Element)data.get("appearenceMountsExpiredMailId")).attributeValue("value")).intValue();
/* 120 */       this.maxMountsNum = Integer.valueOf(((Element)data.get("maxMountsNum")).attributeValue("value")).intValue();
/* 121 */       this.rankUpMountsRestoreMailId = Integer.valueOf(((Element)data.get("rankUpMountsRestoreMailId")).attributeValue("value")).intValue();
/* 122 */       this.rankUpMountsRestoreProb = Integer.valueOf(((Element)data.get("rankUpMountsRestoreProb")).attributeValue("value")).intValue();
/* 123 */       this.chiefMountsCellId = Integer.valueOf(((Element)data.get("chiefMountsCellId")).attributeValue("value")).intValue();
/* 124 */       this.panda_cfg_id = Integer.valueOf(((Element)data.get("panda_cfg_id")).attributeValue("value")).intValue();
/* 125 */       this.fox_cfg_id = Integer.valueOf(((Element)data.get("fox_cfg_id")).attributeValue("value")).intValue();
/* 126 */       this.dou_dou_cfg_id = Integer.valueOf(((Element)data.get("dou_dou_cfg_id")).attributeValue("value")).intValue();
/* 127 */       this.leopard_cfg_id = Integer.valueOf(((Element)data.get("leopard_cfg_id")).attributeValue("value")).intValue();
/* 128 */       this.meng_yan_cfg_id = Integer.valueOf(((Element)data.get("meng_yan_cfg_id")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 132 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 136 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 139 */     String path = dir + "mzm.gsp.mounts.confbean.SMountsConsts.bny";
/*     */     try
/*     */     {
/* 142 */       File file = new File(path);
/* 143 */       if (file.exists())
/*     */       {
/* 145 */         byte[] bytes = new byte['Ѐ'];
/* 146 */         FileInputStream fis = new FileInputStream(file);
/* 147 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 148 */         int len = 0;
/* 149 */         while ((len = fis.read(bytes)) > 0)
/* 150 */           baos.write(bytes, 0, len);
/* 151 */         fis.close();
/* 152 */         bytes = baos.toByteArray();
/* 153 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 154 */         this.mountsOpenLevel = _os_.unmarshal_int();
/* 155 */         this.maxMountsRank = _os_.unmarshal_int();
/* 156 */         this.maxBattleMounts = _os_.unmarshal_int();
/* 157 */         this.maxMountsProtectPets = _os_.unmarshal_int();
/* 158 */         this.appearenceMountsExpiredMailId = _os_.unmarshal_int();
/* 159 */         this.maxMountsNum = _os_.unmarshal_int();
/* 160 */         this.rankUpMountsRestoreMailId = _os_.unmarshal_int();
/* 161 */         this.rankUpMountsRestoreProb = _os_.unmarshal_int();
/* 162 */         this.chiefMountsCellId = _os_.unmarshal_int();
/* 163 */         this.panda_cfg_id = _os_.unmarshal_int();
/* 164 */         this.fox_cfg_id = _os_.unmarshal_int();
/* 165 */         this.dou_dou_cfg_id = _os_.unmarshal_int();
/* 166 */         this.leopard_cfg_id = _os_.unmarshal_int();
/* 167 */         this.meng_yan_cfg_id = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 172 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 178 */     String path = dir + "mzm.gsp.mounts.confbean.SMountsConsts.bny";
/*     */     try
/*     */     {
/* 181 */       File file = new File(path);
/* 182 */       if (file.exists())
/*     */       {
/* 184 */         byte[] bytes = new byte['Ѐ'];
/* 185 */         FileInputStream fis = new FileInputStream(file);
/* 186 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 187 */         int len = 0;
/* 188 */         while ((len = fis.read(bytes)) > 0)
/* 189 */           baos.write(bytes, 0, len);
/* 190 */         fis.close();
/* 191 */         bytes = baos.toByteArray();
/* 192 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 193 */         this.mountsOpenLevel = _os_.unmarshal_int();
/* 194 */         this.maxMountsRank = _os_.unmarshal_int();
/* 195 */         this.maxBattleMounts = _os_.unmarshal_int();
/* 196 */         this.maxMountsProtectPets = _os_.unmarshal_int();
/* 197 */         this.appearenceMountsExpiredMailId = _os_.unmarshal_int();
/* 198 */         this.maxMountsNum = _os_.unmarshal_int();
/* 199 */         this.rankUpMountsRestoreMailId = _os_.unmarshal_int();
/* 200 */         this.rankUpMountsRestoreProb = _os_.unmarshal_int();
/* 201 */         this.chiefMountsCellId = _os_.unmarshal_int();
/* 202 */         this.panda_cfg_id = _os_.unmarshal_int();
/* 203 */         this.fox_cfg_id = _os_.unmarshal_int();
/* 204 */         this.dou_dou_cfg_id = _os_.unmarshal_int();
/* 205 */         this.leopard_cfg_id = _os_.unmarshal_int();
/* 206 */         this.meng_yan_cfg_id = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 211 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SMountsConsts newInstance)
/*     */   {
/* 217 */     oldInstance = instance;
/* 218 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 223 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\confbean\SMountsConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */