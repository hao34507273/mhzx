/*     */ package mzm.gsp.award.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class STempAwardServerLevel extends SAwardServerLevel_father implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, STempAwardServerLevel> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, STempAwardServerLevel> all = null;
/*     */   
/*     */ 
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  22 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  23 */     this.awardSerLvType = Integer.valueOf(rootElement.attributeValue("awardSerLvType")).intValue();
/*  24 */     this.levelMin = Integer.valueOf(rootElement.attributeValue("levelMin")).intValue();
/*  25 */     this.levelMax = Integer.valueOf(rootElement.attributeValue("levelMax")).intValue();
/*  26 */     this.roleExpMod = Double.valueOf(rootElement.attributeValue("roleExpMod")).doubleValue();
/*  27 */     this.petExpMod = Double.valueOf(rootElement.attributeValue("petExpMod")).doubleValue();
/*  28 */     this.practiceMod = Double.valueOf(rootElement.attributeValue("practiceMod")).doubleValue();
/*  29 */     this.effectLevel = Integer.valueOf(rootElement.attributeValue("effectLevel")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  34 */     _os_.marshal(this.id);
/*  35 */     _os_.marshal(this.awardSerLvType);
/*  36 */     _os_.marshal(this.levelMin);
/*  37 */     _os_.marshal(this.levelMax);
/*  38 */     _os_.marshal(this.roleExpMod);
/*  39 */     _os_.marshal(this.petExpMod);
/*  40 */     _os_.marshal(this.practiceMod);
/*  41 */     _os_.marshal(this.effectLevel);
/*  42 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  47 */     this.id = _os_.unmarshal_int();
/*  48 */     this.awardSerLvType = _os_.unmarshal_int();
/*  49 */     this.levelMin = _os_.unmarshal_int();
/*  50 */     this.levelMax = _os_.unmarshal_int();
/*  51 */     this.roleExpMod = _os_.unmarshal_float();
/*  52 */     this.petExpMod = _os_.unmarshal_float();
/*  53 */     this.practiceMod = _os_.unmarshal_float();
/*  54 */     this.effectLevel = _os_.unmarshal_int();
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  60 */     String path = dir + "mzm.gsp.award.confbean.STempAwardServerLevel.xml";
/*     */     
/*     */     try
/*     */     {
/*  64 */       all = new java.util.HashMap();
/*  65 */       SAXReader reader = new SAXReader();
/*  66 */       org.dom4j.Document doc = reader.read(new File(path));
/*  67 */       Element root = doc.getRootElement();
/*  68 */       List<?> nodeList = root.elements();
/*  69 */       int len = nodeList.size();
/*  70 */       for (int i = 0; i < len; i++)
/*     */       {
/*  72 */         Element elem = (Element)nodeList.get(i);
/*  73 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.STempAwardServerLevel"))
/*     */         {
/*     */ 
/*  76 */           STempAwardServerLevel obj = new STempAwardServerLevel();
/*  77 */           obj.loadFromXml(elem);
/*  78 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  79 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  84 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, STempAwardServerLevel> all)
/*     */   {
/*  90 */     String path = dir + "mzm.gsp.award.confbean.STempAwardServerLevel.xml";
/*     */     
/*     */     try
/*     */     {
/*  94 */       SAXReader reader = new SAXReader();
/*  95 */       org.dom4j.Document doc = reader.read(new File(path));
/*  96 */       Element root = doc.getRootElement();
/*  97 */       List<?> nodeList = root.elements();
/*  98 */       int len = nodeList.size();
/*  99 */       for (int i = 0; i < len; i++)
/*     */       {
/* 101 */         Element elem = (Element)nodeList.get(i);
/* 102 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.STempAwardServerLevel"))
/*     */         {
/*     */ 
/* 105 */           STempAwardServerLevel obj = new STempAwardServerLevel();
/* 106 */           obj.loadFromXml(elem);
/* 107 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 108 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 113 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 119 */     all = new java.util.HashMap();
/*     */     
/* 121 */     String path = dir + "mzm.gsp.award.confbean.STempAwardServerLevel.bny";
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
/* 136 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 138 */           _os_.unmarshal_int();
/* 139 */           _os_.unmarshal_int();
/* 140 */           _os_.unmarshal_int();
/*     */         }
/* 142 */         _os_.unmarshal_int();
/* 143 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 146 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 148 */           STempAwardServerLevel _v_ = new STempAwardServerLevel();
/* 149 */           _v_.unmarshal(_os_);
/* 150 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 151 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 156 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 161 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, STempAwardServerLevel> all)
/*     */   {
/* 168 */     String path = dir + "mzm.gsp.award.confbean.STempAwardServerLevel.bny";
/*     */     try
/*     */     {
/* 171 */       File file = new File(path);
/* 172 */       if (file.exists())
/*     */       {
/* 174 */         byte[] bytes = new byte['Ѐ'];
/* 175 */         FileInputStream fis = new FileInputStream(file);
/* 176 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 177 */         int len = 0;
/* 178 */         while ((len = fis.read(bytes)) > 0)
/* 179 */           baos.write(bytes, 0, len);
/* 180 */         fis.close();
/* 181 */         bytes = baos.toByteArray();
/* 182 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 183 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 185 */           _os_.unmarshal_int();
/* 186 */           _os_.unmarshal_int();
/* 187 */           _os_.unmarshal_int();
/*     */         }
/* 189 */         _os_.unmarshal_int();
/* 190 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 193 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 195 */           STempAwardServerLevel _v_ = new STempAwardServerLevel();
/* 196 */           _v_.unmarshal(_os_);
/* 197 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 198 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 203 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 208 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 214 */     for (Map.Entry<Integer, STempAwardServerLevel> entry : all.entrySet())
/*     */     {
/* 216 */       if (SAwardServerLevel_father.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 218 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 222 */       SAwardServerLevel_father.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, STempAwardServerLevel> all, Map<Integer, SAwardServerLevel_father> parent)
/*     */   {
/* 229 */     for (Map.Entry<Integer, STempAwardServerLevel> entry : all.entrySet())
/*     */     {
/* 231 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 233 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 237 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static STempAwardServerLevel getOld(int key)
/*     */   {
/* 244 */     return (STempAwardServerLevel)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static STempAwardServerLevel get(int key)
/*     */   {
/* 249 */     return (STempAwardServerLevel)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, STempAwardServerLevel> getOldAllSelf()
/*     */   {
/* 254 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, STempAwardServerLevel> getAllSelf()
/*     */   {
/* 259 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, STempAwardServerLevel> newAll)
/*     */   {
/* 264 */     oldAll = all;
/* 265 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 270 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\confbean\STempAwardServerLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */