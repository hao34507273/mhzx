/*     */ package mzm.gsp.avatar.confbean;
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
/*     */ public class SAvatarCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SAvatarCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SAvatarCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public String name;
/*     */   public int genderLimit;
/*     */   public int factionLimit;
/*  22 */   public java.util.ArrayList<PropertyBean> properties = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  26 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  27 */     this.name = rootElement.attributeValue("name");
/*  28 */     this.genderLimit = Integer.valueOf(rootElement.attributeValue("genderLimit")).intValue();
/*  29 */     this.factionLimit = Integer.valueOf(rootElement.attributeValue("factionLimit")).intValue();
/*     */     
/*  31 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "properties");
/*  32 */     if (collectionElement == null)
/*     */     {
/*  34 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  37 */     List<?> _nodeList = collectionElement.elements();
/*  38 */     int _len = _nodeList.size();
/*  39 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  41 */       Element elem = (Element)_nodeList.get(i);
/*  42 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.avatar.confbean.PropertyBean"))
/*     */       {
/*     */         PropertyBean _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  49 */           _v_ = new PropertyBean();
/*  50 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  57 */         this.properties.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  64 */     _os_.marshal(this.id);
/*  65 */     _os_.marshal(this.name, "UTF-8");
/*  66 */     _os_.marshal(this.genderLimit);
/*  67 */     _os_.marshal(this.factionLimit);
/*  68 */     _os_.compact_uint32(this.properties.size());
/*  69 */     for (PropertyBean _v_ : this.properties)
/*     */     {
/*  71 */       _os_.marshal(_v_);
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  78 */     this.id = _os_.unmarshal_int();
/*  79 */     this.name = _os_.unmarshal_String("UTF-8");
/*  80 */     this.genderLimit = _os_.unmarshal_int();
/*  81 */     this.factionLimit = _os_.unmarshal_int();
/*  82 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  85 */       PropertyBean _v_ = new PropertyBean();
/*  86 */       _v_.unmarshal(_os_);
/*  87 */       this.properties.add(_v_);
/*     */     }
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  94 */     String path = dir + "mzm.gsp.avatar.confbean.SAvatarCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  98 */       all = new java.util.HashMap();
/*  99 */       SAXReader reader = new SAXReader();
/* 100 */       org.dom4j.Document doc = reader.read(new File(path));
/* 101 */       Element root = doc.getRootElement();
/* 102 */       List<?> nodeList = root.elements();
/* 103 */       int len = nodeList.size();
/* 104 */       for (int i = 0; i < len; i++)
/*     */       {
/* 106 */         Element elem = (Element)nodeList.get(i);
/* 107 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.avatar.confbean.SAvatarCfg"))
/*     */         {
/*     */ 
/* 110 */           SAvatarCfg obj = new SAvatarCfg();
/* 111 */           obj.loadFromXml(elem);
/* 112 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 113 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 118 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SAvatarCfg> all)
/*     */   {
/* 124 */     String path = dir + "mzm.gsp.avatar.confbean.SAvatarCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 128 */       SAXReader reader = new SAXReader();
/* 129 */       org.dom4j.Document doc = reader.read(new File(path));
/* 130 */       Element root = doc.getRootElement();
/* 131 */       List<?> nodeList = root.elements();
/* 132 */       int len = nodeList.size();
/* 133 */       for (int i = 0; i < len; i++)
/*     */       {
/* 135 */         Element elem = (Element)nodeList.get(i);
/* 136 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.avatar.confbean.SAvatarCfg"))
/*     */         {
/*     */ 
/* 139 */           SAvatarCfg obj = new SAvatarCfg();
/* 140 */           obj.loadFromXml(elem);
/* 141 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 142 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 147 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 153 */     all = new java.util.HashMap();
/*     */     
/* 155 */     String path = dir + "mzm.gsp.avatar.confbean.SAvatarCfg.bny";
/*     */     try
/*     */     {
/* 158 */       File file = new File(path);
/* 159 */       if (file.exists())
/*     */       {
/* 161 */         byte[] bytes = new byte['Ѐ'];
/* 162 */         FileInputStream fis = new FileInputStream(file);
/* 163 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 164 */         int len = 0;
/* 165 */         while ((len = fis.read(bytes)) > 0)
/* 166 */           baos.write(bytes, 0, len);
/* 167 */         fis.close();
/* 168 */         bytes = baos.toByteArray();
/* 169 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 170 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 172 */           _os_.unmarshal_int();
/* 173 */           _os_.unmarshal_int();
/* 174 */           _os_.unmarshal_int();
/*     */         }
/* 176 */         _os_.unmarshal_int();
/* 177 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 180 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 182 */           SAvatarCfg _v_ = new SAvatarCfg();
/* 183 */           _v_.unmarshal(_os_);
/* 184 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 185 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 190 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 195 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SAvatarCfg> all)
/*     */   {
/* 202 */     String path = dir + "mzm.gsp.avatar.confbean.SAvatarCfg.bny";
/*     */     try
/*     */     {
/* 205 */       File file = new File(path);
/* 206 */       if (file.exists())
/*     */       {
/* 208 */         byte[] bytes = new byte['Ѐ'];
/* 209 */         FileInputStream fis = new FileInputStream(file);
/* 210 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 211 */         int len = 0;
/* 212 */         while ((len = fis.read(bytes)) > 0)
/* 213 */           baos.write(bytes, 0, len);
/* 214 */         fis.close();
/* 215 */         bytes = baos.toByteArray();
/* 216 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 217 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 219 */           _os_.unmarshal_int();
/* 220 */           _os_.unmarshal_int();
/* 221 */           _os_.unmarshal_int();
/*     */         }
/* 223 */         _os_.unmarshal_int();
/* 224 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 227 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 229 */           SAvatarCfg _v_ = new SAvatarCfg();
/* 230 */           _v_.unmarshal(_os_);
/* 231 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 232 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 237 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 242 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SAvatarCfg getOld(int key)
/*     */   {
/* 250 */     return (SAvatarCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SAvatarCfg get(int key)
/*     */   {
/* 255 */     return (SAvatarCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SAvatarCfg> getOldAll()
/*     */   {
/* 260 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SAvatarCfg> getAll()
/*     */   {
/* 265 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SAvatarCfg> newAll)
/*     */   {
/* 270 */     oldAll = all;
/* 271 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 276 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\confbean\SAvatarCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */