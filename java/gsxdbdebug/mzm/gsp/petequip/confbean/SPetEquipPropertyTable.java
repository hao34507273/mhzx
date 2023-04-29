/*     */ package mzm.gsp.petequip.confbean;
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
/*     */ public class SPetEquipPropertyTable implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SPetEquipPropertyTable> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SPetEquipPropertyTable> all = null;
/*     */   
/*     */   public int id;
/*     */   public String templatename;
/*  20 */   public java.util.LinkedList<SPetEquipPropBean> propList = new java.util.LinkedList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  24 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  25 */     this.templatename = rootElement.attributeValue("templatename");
/*     */     
/*  27 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "propList");
/*  28 */     if (collectionElement == null)
/*     */     {
/*  30 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  33 */     List<?> _nodeList = collectionElement.elements();
/*  34 */     int _len = _nodeList.size();
/*  35 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  37 */       Element elem = (Element)_nodeList.get(i);
/*  38 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.petequip.confbean.SPetEquipPropBean"))
/*     */       {
/*     */         SPetEquipPropBean _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  45 */           _v_ = new SPetEquipPropBean();
/*  46 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  53 */         this.propList.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  60 */     _os_.marshal(this.id);
/*  61 */     _os_.marshal(this.templatename, "UTF-8");
/*  62 */     _os_.compact_uint32(this.propList.size());
/*  63 */     for (SPetEquipPropBean _v_ : this.propList)
/*     */     {
/*  65 */       _os_.marshal(_v_);
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  72 */     this.id = _os_.unmarshal_int();
/*  73 */     this.templatename = _os_.unmarshal_String("UTF-8");
/*  74 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  77 */       SPetEquipPropBean _v_ = new SPetEquipPropBean();
/*  78 */       _v_.unmarshal(_os_);
/*  79 */       this.propList.add(_v_);
/*     */     }
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  86 */     String path = dir + "mzm.gsp.petequip.confbean.SPetEquipPropertyTable.xml";
/*     */     
/*     */     try
/*     */     {
/*  90 */       all = new java.util.HashMap();
/*  91 */       SAXReader reader = new SAXReader();
/*  92 */       org.dom4j.Document doc = reader.read(new File(path));
/*  93 */       Element root = doc.getRootElement();
/*  94 */       List<?> nodeList = root.elements();
/*  95 */       int len = nodeList.size();
/*  96 */       for (int i = 0; i < len; i++)
/*     */       {
/*  98 */         Element elem = (Element)nodeList.get(i);
/*  99 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.petequip.confbean.SPetEquipPropertyTable"))
/*     */         {
/*     */ 
/* 102 */           SPetEquipPropertyTable obj = new SPetEquipPropertyTable();
/* 103 */           obj.loadFromXml(elem);
/* 104 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 105 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 110 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SPetEquipPropertyTable> all)
/*     */   {
/* 116 */     String path = dir + "mzm.gsp.petequip.confbean.SPetEquipPropertyTable.xml";
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
/* 128 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.petequip.confbean.SPetEquipPropertyTable"))
/*     */         {
/*     */ 
/* 131 */           SPetEquipPropertyTable obj = new SPetEquipPropertyTable();
/* 132 */           obj.loadFromXml(elem);
/* 133 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 134 */             throw new RuntimeException("duplicate key : " + obj.id);
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
/* 145 */     all = new java.util.HashMap();
/*     */     
/* 147 */     String path = dir + "mzm.gsp.petequip.confbean.SPetEquipPropertyTable.bny";
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
/* 174 */           SPetEquipPropertyTable _v_ = new SPetEquipPropertyTable();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, SPetEquipPropertyTable> all)
/*     */   {
/* 194 */     String path = dir + "mzm.gsp.petequip.confbean.SPetEquipPropertyTable.bny";
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
/* 221 */           SPetEquipPropertyTable _v_ = new SPetEquipPropertyTable();
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
/*     */   public static SPetEquipPropertyTable getOld(int key)
/*     */   {
/* 242 */     return (SPetEquipPropertyTable)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SPetEquipPropertyTable get(int key)
/*     */   {
/* 247 */     return (SPetEquipPropertyTable)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPetEquipPropertyTable> getOldAll()
/*     */   {
/* 252 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPetEquipPropertyTable> getAll()
/*     */   {
/* 257 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SPetEquipPropertyTable> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petequip\confbean\SPetEquipPropertyTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */