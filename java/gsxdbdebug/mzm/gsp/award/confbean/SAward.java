/*     */ package mzm.gsp.award.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SAward implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SAward> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SAward> all = null;
/*     */   
/*     */   public int id;
/*     */   public String templatename;
/*     */   public int addModifyCnfId;
/*     */   public int awardId;
/*     */   public int awardItemId;
/*     */   public int awardExpId;
/*     */   public int awardMoneyId;
/*     */   public int appellationId;
/*     */   public int titleId;
/*     */   public boolean activeGet;
/*     */   public int gemId;
/*     */   public int gemLibId;
/*     */   public int globaDropId;
/*     */   public int globaDropLibId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  35 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  36 */     this.templatename = rootElement.attributeValue("templatename");
/*  37 */     this.addModifyCnfId = Integer.valueOf(rootElement.attributeValue("addModifyCnfId")).intValue();
/*  38 */     this.awardId = Integer.valueOf(rootElement.attributeValue("awardId")).intValue();
/*  39 */     this.awardItemId = Integer.valueOf(rootElement.attributeValue("awardItemId")).intValue();
/*  40 */     this.awardExpId = Integer.valueOf(rootElement.attributeValue("awardExpId")).intValue();
/*  41 */     this.awardMoneyId = Integer.valueOf(rootElement.attributeValue("awardMoneyId")).intValue();
/*  42 */     this.appellationId = Integer.valueOf(rootElement.attributeValue("appellationId")).intValue();
/*  43 */     this.titleId = Integer.valueOf(rootElement.attributeValue("titleId")).intValue();
/*  44 */     this.activeGet = Boolean.valueOf(rootElement.attributeValue("activeGet")).booleanValue();
/*  45 */     this.gemId = Integer.valueOf(rootElement.attributeValue("gemId")).intValue();
/*  46 */     this.gemLibId = Integer.valueOf(rootElement.attributeValue("gemLibId")).intValue();
/*  47 */     this.globaDropId = Integer.valueOf(rootElement.attributeValue("globaDropId")).intValue();
/*  48 */     this.globaDropLibId = Integer.valueOf(rootElement.attributeValue("globaDropLibId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  53 */     _os_.marshal(this.id);
/*  54 */     _os_.marshal(this.templatename, "UTF-8");
/*  55 */     _os_.marshal(this.addModifyCnfId);
/*  56 */     _os_.marshal(this.awardId);
/*  57 */     _os_.marshal(this.awardItemId);
/*  58 */     _os_.marshal(this.awardExpId);
/*  59 */     _os_.marshal(this.awardMoneyId);
/*  60 */     _os_.marshal(this.appellationId);
/*  61 */     _os_.marshal(this.titleId);
/*  62 */     _os_.marshal(this.activeGet);
/*  63 */     _os_.marshal(this.gemId);
/*  64 */     _os_.marshal(this.gemLibId);
/*  65 */     _os_.marshal(this.globaDropId);
/*  66 */     _os_.marshal(this.globaDropLibId);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  72 */     this.id = _os_.unmarshal_int();
/*  73 */     this.templatename = _os_.unmarshal_String("UTF-8");
/*  74 */     this.addModifyCnfId = _os_.unmarshal_int();
/*  75 */     this.awardId = _os_.unmarshal_int();
/*  76 */     this.awardItemId = _os_.unmarshal_int();
/*  77 */     this.awardExpId = _os_.unmarshal_int();
/*  78 */     this.awardMoneyId = _os_.unmarshal_int();
/*  79 */     this.appellationId = _os_.unmarshal_int();
/*  80 */     this.titleId = _os_.unmarshal_int();
/*  81 */     this.activeGet = _os_.unmarshal_boolean();
/*  82 */     this.gemId = _os_.unmarshal_int();
/*  83 */     this.gemLibId = _os_.unmarshal_int();
/*  84 */     this.globaDropId = _os_.unmarshal_int();
/*  85 */     this.globaDropLibId = _os_.unmarshal_int();
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  91 */     String path = dir + "mzm.gsp.award.confbean.SAward.xml";
/*     */     
/*     */     try
/*     */     {
/*  95 */       all = new java.util.HashMap();
/*  96 */       SAXReader reader = new SAXReader();
/*  97 */       org.dom4j.Document doc = reader.read(new File(path));
/*  98 */       Element root = doc.getRootElement();
/*  99 */       List<?> nodeList = root.elements();
/* 100 */       int len = nodeList.size();
/* 101 */       for (int i = 0; i < len; i++)
/*     */       {
/* 103 */         Element elem = (Element)nodeList.get(i);
/* 104 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.SAward"))
/*     */         {
/*     */ 
/* 107 */           SAward obj = new SAward();
/* 108 */           obj.loadFromXml(elem);
/* 109 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 110 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 115 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SAward> all)
/*     */   {
/* 121 */     String path = dir + "mzm.gsp.award.confbean.SAward.xml";
/*     */     
/*     */     try
/*     */     {
/* 125 */       SAXReader reader = new SAXReader();
/* 126 */       org.dom4j.Document doc = reader.read(new File(path));
/* 127 */       Element root = doc.getRootElement();
/* 128 */       List<?> nodeList = root.elements();
/* 129 */       int len = nodeList.size();
/* 130 */       for (int i = 0; i < len; i++)
/*     */       {
/* 132 */         Element elem = (Element)nodeList.get(i);
/* 133 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.SAward"))
/*     */         {
/*     */ 
/* 136 */           SAward obj = new SAward();
/* 137 */           obj.loadFromXml(elem);
/* 138 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 139 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 144 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 150 */     all = new java.util.HashMap();
/*     */     
/* 152 */     String path = dir + "mzm.gsp.award.confbean.SAward.bny";
/*     */     try
/*     */     {
/* 155 */       File file = new File(path);
/* 156 */       if (file.exists())
/*     */       {
/* 158 */         byte[] bytes = new byte['Ѐ'];
/* 159 */         FileInputStream fis = new FileInputStream(file);
/* 160 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 161 */         int len = 0;
/* 162 */         while ((len = fis.read(bytes)) > 0)
/* 163 */           baos.write(bytes, 0, len);
/* 164 */         fis.close();
/* 165 */         bytes = baos.toByteArray();
/* 166 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 167 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 169 */           _os_.unmarshal_int();
/* 170 */           _os_.unmarshal_int();
/* 171 */           _os_.unmarshal_int();
/*     */         }
/* 173 */         _os_.unmarshal_int();
/* 174 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 177 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 179 */           SAward _v_ = new SAward();
/* 180 */           _v_.unmarshal(_os_);
/* 181 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 182 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 187 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 192 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SAward> all)
/*     */   {
/* 199 */     String path = dir + "mzm.gsp.award.confbean.SAward.bny";
/*     */     try
/*     */     {
/* 202 */       File file = new File(path);
/* 203 */       if (file.exists())
/*     */       {
/* 205 */         byte[] bytes = new byte['Ѐ'];
/* 206 */         FileInputStream fis = new FileInputStream(file);
/* 207 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 208 */         int len = 0;
/* 209 */         while ((len = fis.read(bytes)) > 0)
/* 210 */           baos.write(bytes, 0, len);
/* 211 */         fis.close();
/* 212 */         bytes = baos.toByteArray();
/* 213 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 214 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 216 */           _os_.unmarshal_int();
/* 217 */           _os_.unmarshal_int();
/* 218 */           _os_.unmarshal_int();
/*     */         }
/* 220 */         _os_.unmarshal_int();
/* 221 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 224 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 226 */           SAward _v_ = new SAward();
/* 227 */           _v_.unmarshal(_os_);
/* 228 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 229 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 234 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 239 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SAward getOld(int key)
/*     */   {
/* 247 */     return (SAward)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SAward get(int key)
/*     */   {
/* 252 */     return (SAward)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SAward> getOldAll()
/*     */   {
/* 257 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SAward> getAll()
/*     */   {
/* 262 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SAward> newAll)
/*     */   {
/* 267 */     oldAll = all;
/* 268 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 273 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\confbean\SAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */