/*     */ package mzm.gsp.personal.confbean;
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
/*     */ public class SNSSubTypeOriginalCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SNSSubTypeOriginalCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SNSSubTypeOriginalCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public String subTypeName;
/*     */   public String typeName;
/*     */   public String defaultContent1;
/*     */   public String defaultContent2;
/*     */   public String defaultContent3;
/*     */   public String defaultContent4;
/*     */   public String defaultContent5;
/*     */   public int npcId;
/*     */   public String iconId;
/*     */   public int npcServiceId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  32 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  33 */     this.subTypeName = rootElement.attributeValue("subTypeName");
/*  34 */     this.typeName = rootElement.attributeValue("typeName");
/*  35 */     this.defaultContent1 = rootElement.attributeValue("defaultContent1");
/*  36 */     this.defaultContent2 = rootElement.attributeValue("defaultContent2");
/*  37 */     this.defaultContent3 = rootElement.attributeValue("defaultContent3");
/*  38 */     this.defaultContent4 = rootElement.attributeValue("defaultContent4");
/*  39 */     this.defaultContent5 = rootElement.attributeValue("defaultContent5");
/*  40 */     this.npcId = Integer.valueOf(rootElement.attributeValue("npcId")).intValue();
/*  41 */     this.iconId = rootElement.attributeValue("iconId");
/*  42 */     this.npcServiceId = Integer.valueOf(rootElement.attributeValue("npcServiceId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  47 */     _os_.marshal(this.id);
/*  48 */     _os_.marshal(this.subTypeName, "UTF-8");
/*  49 */     _os_.marshal(this.typeName, "UTF-8");
/*  50 */     _os_.marshal(this.defaultContent1, "UTF-8");
/*  51 */     _os_.marshal(this.defaultContent2, "UTF-8");
/*  52 */     _os_.marshal(this.defaultContent3, "UTF-8");
/*  53 */     _os_.marshal(this.defaultContent4, "UTF-8");
/*  54 */     _os_.marshal(this.defaultContent5, "UTF-8");
/*  55 */     _os_.marshal(this.npcId);
/*  56 */     _os_.marshal(this.iconId, "UTF-8");
/*  57 */     _os_.marshal(this.npcServiceId);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  63 */     this.id = _os_.unmarshal_int();
/*  64 */     this.subTypeName = _os_.unmarshal_String("UTF-8");
/*  65 */     this.typeName = _os_.unmarshal_String("UTF-8");
/*  66 */     this.defaultContent1 = _os_.unmarshal_String("UTF-8");
/*  67 */     this.defaultContent2 = _os_.unmarshal_String("UTF-8");
/*  68 */     this.defaultContent3 = _os_.unmarshal_String("UTF-8");
/*  69 */     this.defaultContent4 = _os_.unmarshal_String("UTF-8");
/*  70 */     this.defaultContent5 = _os_.unmarshal_String("UTF-8");
/*  71 */     this.npcId = _os_.unmarshal_int();
/*  72 */     this.iconId = _os_.unmarshal_String("UTF-8");
/*  73 */     this.npcServiceId = _os_.unmarshal_int();
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  79 */     String path = dir + "mzm.gsp.personal.confbean.SNSSubTypeOriginalCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  83 */       all = new java.util.HashMap();
/*  84 */       SAXReader reader = new SAXReader();
/*  85 */       org.dom4j.Document doc = reader.read(new File(path));
/*  86 */       Element root = doc.getRootElement();
/*  87 */       List<?> nodeList = root.elements();
/*  88 */       int len = nodeList.size();
/*  89 */       for (int i = 0; i < len; i++)
/*     */       {
/*  91 */         Element elem = (Element)nodeList.get(i);
/*  92 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.personal.confbean.SNSSubTypeOriginalCfg"))
/*     */         {
/*     */ 
/*  95 */           SNSSubTypeOriginalCfg obj = new SNSSubTypeOriginalCfg();
/*  96 */           obj.loadFromXml(elem);
/*  97 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  98 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 103 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SNSSubTypeOriginalCfg> all)
/*     */   {
/* 109 */     String path = dir + "mzm.gsp.personal.confbean.SNSSubTypeOriginalCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 113 */       SAXReader reader = new SAXReader();
/* 114 */       org.dom4j.Document doc = reader.read(new File(path));
/* 115 */       Element root = doc.getRootElement();
/* 116 */       List<?> nodeList = root.elements();
/* 117 */       int len = nodeList.size();
/* 118 */       for (int i = 0; i < len; i++)
/*     */       {
/* 120 */         Element elem = (Element)nodeList.get(i);
/* 121 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.personal.confbean.SNSSubTypeOriginalCfg"))
/*     */         {
/*     */ 
/* 124 */           SNSSubTypeOriginalCfg obj = new SNSSubTypeOriginalCfg();
/* 125 */           obj.loadFromXml(elem);
/* 126 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 127 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 132 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 138 */     all = new java.util.HashMap();
/*     */     
/* 140 */     String path = dir + "mzm.gsp.personal.confbean.SNSSubTypeOriginalCfg.bny";
/*     */     try
/*     */     {
/* 143 */       File file = new File(path);
/* 144 */       if (file.exists())
/*     */       {
/* 146 */         byte[] bytes = new byte['Ѐ'];
/* 147 */         FileInputStream fis = new FileInputStream(file);
/* 148 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 149 */         int len = 0;
/* 150 */         while ((len = fis.read(bytes)) > 0)
/* 151 */           baos.write(bytes, 0, len);
/* 152 */         fis.close();
/* 153 */         bytes = baos.toByteArray();
/* 154 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 155 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 157 */           _os_.unmarshal_int();
/* 158 */           _os_.unmarshal_int();
/* 159 */           _os_.unmarshal_int();
/*     */         }
/* 161 */         _os_.unmarshal_int();
/* 162 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 165 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 167 */           SNSSubTypeOriginalCfg _v_ = new SNSSubTypeOriginalCfg();
/* 168 */           _v_.unmarshal(_os_);
/* 169 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 170 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 175 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 180 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SNSSubTypeOriginalCfg> all)
/*     */   {
/* 187 */     String path = dir + "mzm.gsp.personal.confbean.SNSSubTypeOriginalCfg.bny";
/*     */     try
/*     */     {
/* 190 */       File file = new File(path);
/* 191 */       if (file.exists())
/*     */       {
/* 193 */         byte[] bytes = new byte['Ѐ'];
/* 194 */         FileInputStream fis = new FileInputStream(file);
/* 195 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 196 */         int len = 0;
/* 197 */         while ((len = fis.read(bytes)) > 0)
/* 198 */           baos.write(bytes, 0, len);
/* 199 */         fis.close();
/* 200 */         bytes = baos.toByteArray();
/* 201 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 202 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 204 */           _os_.unmarshal_int();
/* 205 */           _os_.unmarshal_int();
/* 206 */           _os_.unmarshal_int();
/*     */         }
/* 208 */         _os_.unmarshal_int();
/* 209 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 212 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 214 */           SNSSubTypeOriginalCfg _v_ = new SNSSubTypeOriginalCfg();
/* 215 */           _v_.unmarshal(_os_);
/* 216 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 217 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 222 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 227 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SNSSubTypeOriginalCfg getOld(int key)
/*     */   {
/* 235 */     return (SNSSubTypeOriginalCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SNSSubTypeOriginalCfg get(int key)
/*     */   {
/* 240 */     return (SNSSubTypeOriginalCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SNSSubTypeOriginalCfg> getOldAll()
/*     */   {
/* 245 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SNSSubTypeOriginalCfg> getAll()
/*     */   {
/* 250 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SNSSubTypeOriginalCfg> newAll)
/*     */   {
/* 255 */     oldAll = all;
/* 256 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 261 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\confbean\SNSSubTypeOriginalCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */