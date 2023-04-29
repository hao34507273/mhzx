/*     */ package mzm.gsp.avatar.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SFactionDefaultAvatarConsts
/*     */ {
/*  13 */   private static volatile SFactionDefaultAvatarConsts oldInstance = null;
/*     */   
/*  15 */   private static SFactionDefaultAvatarConsts instance = new SFactionDefaultAvatarConsts();
/*     */   
/*     */   public int GuiwangMaleDefaultAvatarId;
/*     */   public int GuiwangFemaleDefaultAvatarId;
/*     */   public int QingyunMaleDefaultAvatarId;
/*     */   
/*     */   public static SFactionDefaultAvatarConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SFactionDefaultAvatarConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int QingyunFemaleDefaultAvatarId;
/*     */   
/*     */   public int TianyinMaleDefaultAvatarId;
/*     */   
/*     */   public int TianyinFemaleDefaultAvatarId;
/*     */   
/*     */   public int FenxiangMaleDefaultAvatarId;
/*     */   public int FenxiangFemaleDefaultAvatarId;
/*     */   public int HehuanMaleDefaultAvatarId;
/*     */   public int HehuanFemaleDefaultAvatarId;
/*     */   public int ShengwuMaleDefaultAvatarId;
/*     */   public int ShengwuFemaleDefaultAvatarId;
/*     */   public int CangyuMaleDefaultAvatarId;
/*     */   public int CangyuFemaleDefaultAvatarId;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  48 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  53 */     String path = dir + "mzm.gsp.avatar.confbean.SFactionDefaultAvatarConsts.xml";
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
/*  73 */       this.GuiwangMaleDefaultAvatarId = Integer.valueOf(((Element)data.get("GuiwangMaleDefaultAvatarId")).attributeValue("value")).intValue();
/*  74 */       this.GuiwangFemaleDefaultAvatarId = Integer.valueOf(((Element)data.get("GuiwangFemaleDefaultAvatarId")).attributeValue("value")).intValue();
/*  75 */       this.QingyunMaleDefaultAvatarId = Integer.valueOf(((Element)data.get("QingyunMaleDefaultAvatarId")).attributeValue("value")).intValue();
/*  76 */       this.QingyunFemaleDefaultAvatarId = Integer.valueOf(((Element)data.get("QingyunFemaleDefaultAvatarId")).attributeValue("value")).intValue();
/*  77 */       this.TianyinMaleDefaultAvatarId = Integer.valueOf(((Element)data.get("TianyinMaleDefaultAvatarId")).attributeValue("value")).intValue();
/*  78 */       this.TianyinFemaleDefaultAvatarId = Integer.valueOf(((Element)data.get("TianyinFemaleDefaultAvatarId")).attributeValue("value")).intValue();
/*  79 */       this.FenxiangMaleDefaultAvatarId = Integer.valueOf(((Element)data.get("FenxiangMaleDefaultAvatarId")).attributeValue("value")).intValue();
/*  80 */       this.FenxiangFemaleDefaultAvatarId = Integer.valueOf(((Element)data.get("FenxiangFemaleDefaultAvatarId")).attributeValue("value")).intValue();
/*  81 */       this.HehuanMaleDefaultAvatarId = Integer.valueOf(((Element)data.get("HehuanMaleDefaultAvatarId")).attributeValue("value")).intValue();
/*  82 */       this.HehuanFemaleDefaultAvatarId = Integer.valueOf(((Element)data.get("HehuanFemaleDefaultAvatarId")).attributeValue("value")).intValue();
/*  83 */       this.ShengwuMaleDefaultAvatarId = Integer.valueOf(((Element)data.get("ShengwuMaleDefaultAvatarId")).attributeValue("value")).intValue();
/*  84 */       this.ShengwuFemaleDefaultAvatarId = Integer.valueOf(((Element)data.get("ShengwuFemaleDefaultAvatarId")).attributeValue("value")).intValue();
/*  85 */       this.CangyuMaleDefaultAvatarId = Integer.valueOf(((Element)data.get("CangyuMaleDefaultAvatarId")).attributeValue("value")).intValue();
/*  86 */       this.CangyuFemaleDefaultAvatarId = Integer.valueOf(((Element)data.get("CangyuFemaleDefaultAvatarId")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  90 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  95 */     String path = dir + "mzm.gsp.avatar.confbean.SFactionDefaultAvatarConsts.xml";
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
/* 115 */       this.GuiwangMaleDefaultAvatarId = Integer.valueOf(((Element)data.get("GuiwangMaleDefaultAvatarId")).attributeValue("value")).intValue();
/* 116 */       this.GuiwangFemaleDefaultAvatarId = Integer.valueOf(((Element)data.get("GuiwangFemaleDefaultAvatarId")).attributeValue("value")).intValue();
/* 117 */       this.QingyunMaleDefaultAvatarId = Integer.valueOf(((Element)data.get("QingyunMaleDefaultAvatarId")).attributeValue("value")).intValue();
/* 118 */       this.QingyunFemaleDefaultAvatarId = Integer.valueOf(((Element)data.get("QingyunFemaleDefaultAvatarId")).attributeValue("value")).intValue();
/* 119 */       this.TianyinMaleDefaultAvatarId = Integer.valueOf(((Element)data.get("TianyinMaleDefaultAvatarId")).attributeValue("value")).intValue();
/* 120 */       this.TianyinFemaleDefaultAvatarId = Integer.valueOf(((Element)data.get("TianyinFemaleDefaultAvatarId")).attributeValue("value")).intValue();
/* 121 */       this.FenxiangMaleDefaultAvatarId = Integer.valueOf(((Element)data.get("FenxiangMaleDefaultAvatarId")).attributeValue("value")).intValue();
/* 122 */       this.FenxiangFemaleDefaultAvatarId = Integer.valueOf(((Element)data.get("FenxiangFemaleDefaultAvatarId")).attributeValue("value")).intValue();
/* 123 */       this.HehuanMaleDefaultAvatarId = Integer.valueOf(((Element)data.get("HehuanMaleDefaultAvatarId")).attributeValue("value")).intValue();
/* 124 */       this.HehuanFemaleDefaultAvatarId = Integer.valueOf(((Element)data.get("HehuanFemaleDefaultAvatarId")).attributeValue("value")).intValue();
/* 125 */       this.ShengwuMaleDefaultAvatarId = Integer.valueOf(((Element)data.get("ShengwuMaleDefaultAvatarId")).attributeValue("value")).intValue();
/* 126 */       this.ShengwuFemaleDefaultAvatarId = Integer.valueOf(((Element)data.get("ShengwuFemaleDefaultAvatarId")).attributeValue("value")).intValue();
/* 127 */       this.CangyuMaleDefaultAvatarId = Integer.valueOf(((Element)data.get("CangyuMaleDefaultAvatarId")).attributeValue("value")).intValue();
/* 128 */       this.CangyuFemaleDefaultAvatarId = Integer.valueOf(((Element)data.get("CangyuFemaleDefaultAvatarId")).attributeValue("value")).intValue();
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
/* 139 */     String path = dir + "mzm.gsp.avatar.confbean.SFactionDefaultAvatarConsts.bny";
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
/* 154 */         this.GuiwangMaleDefaultAvatarId = _os_.unmarshal_int();
/* 155 */         this.GuiwangFemaleDefaultAvatarId = _os_.unmarshal_int();
/* 156 */         this.QingyunMaleDefaultAvatarId = _os_.unmarshal_int();
/* 157 */         this.QingyunFemaleDefaultAvatarId = _os_.unmarshal_int();
/* 158 */         this.TianyinMaleDefaultAvatarId = _os_.unmarshal_int();
/* 159 */         this.TianyinFemaleDefaultAvatarId = _os_.unmarshal_int();
/* 160 */         this.FenxiangMaleDefaultAvatarId = _os_.unmarshal_int();
/* 161 */         this.FenxiangFemaleDefaultAvatarId = _os_.unmarshal_int();
/* 162 */         this.HehuanMaleDefaultAvatarId = _os_.unmarshal_int();
/* 163 */         this.HehuanFemaleDefaultAvatarId = _os_.unmarshal_int();
/* 164 */         this.ShengwuMaleDefaultAvatarId = _os_.unmarshal_int();
/* 165 */         this.ShengwuFemaleDefaultAvatarId = _os_.unmarshal_int();
/* 166 */         this.CangyuMaleDefaultAvatarId = _os_.unmarshal_int();
/* 167 */         this.CangyuFemaleDefaultAvatarId = _os_.unmarshal_int();
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
/* 178 */     String path = dir + "mzm.gsp.avatar.confbean.SFactionDefaultAvatarConsts.bny";
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
/* 193 */         this.GuiwangMaleDefaultAvatarId = _os_.unmarshal_int();
/* 194 */         this.GuiwangFemaleDefaultAvatarId = _os_.unmarshal_int();
/* 195 */         this.QingyunMaleDefaultAvatarId = _os_.unmarshal_int();
/* 196 */         this.QingyunFemaleDefaultAvatarId = _os_.unmarshal_int();
/* 197 */         this.TianyinMaleDefaultAvatarId = _os_.unmarshal_int();
/* 198 */         this.TianyinFemaleDefaultAvatarId = _os_.unmarshal_int();
/* 199 */         this.FenxiangMaleDefaultAvatarId = _os_.unmarshal_int();
/* 200 */         this.FenxiangFemaleDefaultAvatarId = _os_.unmarshal_int();
/* 201 */         this.HehuanMaleDefaultAvatarId = _os_.unmarshal_int();
/* 202 */         this.HehuanFemaleDefaultAvatarId = _os_.unmarshal_int();
/* 203 */         this.ShengwuMaleDefaultAvatarId = _os_.unmarshal_int();
/* 204 */         this.ShengwuFemaleDefaultAvatarId = _os_.unmarshal_int();
/* 205 */         this.CangyuMaleDefaultAvatarId = _os_.unmarshal_int();
/* 206 */         this.CangyuFemaleDefaultAvatarId = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 211 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SFactionDefaultAvatarConsts newInstance)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\confbean\SFactionDefaultAvatarConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */