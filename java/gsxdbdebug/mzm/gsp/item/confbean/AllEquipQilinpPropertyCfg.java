/*     */ package mzm.gsp.item.confbean;
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
/*     */ public class AllEquipQilinpPropertyCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, AllEquipQilinpPropertyCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, AllEquipQilinpPropertyCfg> all = null;
/*     */   
/*     */   public int linlevel;
/*  19 */   public java.util.ArrayList<Property2Param> propertyparams = new java.util.ArrayList();
/*     */   public String desc;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  24 */     this.linlevel = Integer.valueOf(rootElement.attributeValue("linlevel")).intValue();
/*     */     
/*  26 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "propertyparams");
/*  27 */     if (collectionElement == null)
/*     */     {
/*  29 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  32 */     List<?> _nodeList = collectionElement.elements();
/*  33 */     int _len = _nodeList.size();
/*  34 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  36 */       Element elem = (Element)_nodeList.get(i);
/*  37 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.Property2Param"))
/*     */       {
/*     */         Property2Param _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  44 */           _v_ = new Property2Param();
/*  45 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  52 */         this.propertyparams.add(_v_);
/*     */       }
/*     */     }
/*  55 */     this.desc = rootElement.attributeValue("desc");
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  60 */     _os_.marshal(this.linlevel);
/*  61 */     _os_.compact_uint32(this.propertyparams.size());
/*  62 */     for (Property2Param _v_ : this.propertyparams)
/*     */     {
/*  64 */       _os_.marshal(_v_);
/*     */     }
/*  66 */     _os_.marshal(this.desc, "UTF-8");
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  72 */     this.linlevel = _os_.unmarshal_int();
/*  73 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  76 */       Property2Param _v_ = new Property2Param();
/*  77 */       _v_.unmarshal(_os_);
/*  78 */       this.propertyparams.add(_v_);
/*     */     }
/*  80 */     this.desc = _os_.unmarshal_String("UTF-8");
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  86 */     String path = dir + "mzm.gsp.item.confbean.AllEquipQilinpPropertyCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  90 */       all = new java.util.TreeMap();
/*  91 */       SAXReader reader = new SAXReader();
/*  92 */       org.dom4j.Document doc = reader.read(new File(path));
/*  93 */       Element root = doc.getRootElement();
/*  94 */       List<?> nodeList = root.elements();
/*  95 */       int len = nodeList.size();
/*  96 */       for (int i = 0; i < len; i++)
/*     */       {
/*  98 */         Element elem = (Element)nodeList.get(i);
/*  99 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.AllEquipQilinpPropertyCfg"))
/*     */         {
/*     */ 
/* 102 */           AllEquipQilinpPropertyCfg obj = new AllEquipQilinpPropertyCfg();
/* 103 */           obj.loadFromXml(elem);
/* 104 */           if (all.put(Integer.valueOf(obj.linlevel), obj) != null) {
/* 105 */             throw new RuntimeException("duplicate key : " + obj.linlevel);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 110 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, AllEquipQilinpPropertyCfg> all)
/*     */   {
/* 116 */     String path = dir + "mzm.gsp.item.confbean.AllEquipQilinpPropertyCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 120 */       SAXReader reader = new SAXReader();
/* 121 */       org.dom4j.Document doc = reader.read(new File(path));
/* 122 */       Element root = doc.getRootElement();
/* 123 */       List<?> nodeList = root.elements();
/* 124 */       int len = nodeList.size();
/* 125 */       for (int i = 0; i < len; i++)
/*     */       {
/* 127 */         Element elem = (Element)nodeList.get(i);
/* 128 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.AllEquipQilinpPropertyCfg"))
/*     */         {
/*     */ 
/* 131 */           AllEquipQilinpPropertyCfg obj = new AllEquipQilinpPropertyCfg();
/* 132 */           obj.loadFromXml(elem);
/* 133 */           if (all.put(Integer.valueOf(obj.linlevel), obj) != null) {
/* 134 */             throw new RuntimeException("duplicate key : " + obj.linlevel);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 139 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 145 */     all = new java.util.TreeMap();
/*     */     
/* 147 */     String path = dir + "mzm.gsp.item.confbean.AllEquipQilinpPropertyCfg.bny";
/*     */     try
/*     */     {
/* 150 */       File file = new File(path);
/* 151 */       if (file.exists())
/*     */       {
/* 153 */         byte[] bytes = new byte['Ѐ'];
/* 154 */         FileInputStream fis = new FileInputStream(file);
/* 155 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 156 */         int len = 0;
/* 157 */         while ((len = fis.read(bytes)) > 0)
/* 158 */           baos.write(bytes, 0, len);
/* 159 */         fis.close();
/* 160 */         bytes = baos.toByteArray();
/* 161 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 162 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 164 */           _os_.unmarshal_int();
/* 165 */           _os_.unmarshal_int();
/* 166 */           _os_.unmarshal_int();
/*     */         }
/* 168 */         _os_.unmarshal_int();
/* 169 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 172 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 174 */           AllEquipQilinpPropertyCfg _v_ = new AllEquipQilinpPropertyCfg();
/* 175 */           _v_.unmarshal(_os_);
/* 176 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 177 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 182 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 187 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, AllEquipQilinpPropertyCfg> all)
/*     */   {
/* 194 */     String path = dir + "mzm.gsp.item.confbean.AllEquipQilinpPropertyCfg.bny";
/*     */     try
/*     */     {
/* 197 */       File file = new File(path);
/* 198 */       if (file.exists())
/*     */       {
/* 200 */         byte[] bytes = new byte['Ѐ'];
/* 201 */         FileInputStream fis = new FileInputStream(file);
/* 202 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 203 */         int len = 0;
/* 204 */         while ((len = fis.read(bytes)) > 0)
/* 205 */           baos.write(bytes, 0, len);
/* 206 */         fis.close();
/* 207 */         bytes = baos.toByteArray();
/* 208 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 209 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 211 */           _os_.unmarshal_int();
/* 212 */           _os_.unmarshal_int();
/* 213 */           _os_.unmarshal_int();
/*     */         }
/* 215 */         _os_.unmarshal_int();
/* 216 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 219 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 221 */           AllEquipQilinpPropertyCfg _v_ = new AllEquipQilinpPropertyCfg();
/* 222 */           _v_.unmarshal(_os_);
/* 223 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 224 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 229 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 234 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static AllEquipQilinpPropertyCfg getOld(int key)
/*     */   {
/* 242 */     return (AllEquipQilinpPropertyCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static AllEquipQilinpPropertyCfg get(int key)
/*     */   {
/* 247 */     return (AllEquipQilinpPropertyCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, AllEquipQilinpPropertyCfg> getOldAll()
/*     */   {
/* 252 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, AllEquipQilinpPropertyCfg> getAll()
/*     */   {
/* 257 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, AllEquipQilinpPropertyCfg> newAll)
/*     */   {
/* 262 */     oldAll = all;
/* 263 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 268 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\AllEquipQilinpPropertyCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */