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
/*     */ public class SModifyValueTable implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SModifyValueTable> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SModifyValueTable> all = null;
/*     */   
/*     */   public int id;
/*     */   public String templatename;
/*     */   public double silverMod;
/*     */   public double masterMod;
/*     */   public double gangConbMod;
/*     */   public double vitalityMod;
/*     */   public double roleExpMod;
/*     */   public double petExpMod;
/*     */   public double practiceMod;
/*  27 */   public java.util.ArrayList<Double> itemTableModList = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  31 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  32 */     this.templatename = rootElement.attributeValue("templatename");
/*  33 */     this.silverMod = Double.valueOf(rootElement.attributeValue("silverMod")).doubleValue();
/*  34 */     this.masterMod = Double.valueOf(rootElement.attributeValue("masterMod")).doubleValue();
/*  35 */     this.gangConbMod = Double.valueOf(rootElement.attributeValue("gangConbMod")).doubleValue();
/*  36 */     this.vitalityMod = Double.valueOf(rootElement.attributeValue("vitalityMod")).doubleValue();
/*  37 */     this.roleExpMod = Double.valueOf(rootElement.attributeValue("roleExpMod")).doubleValue();
/*  38 */     this.petExpMod = Double.valueOf(rootElement.attributeValue("petExpMod")).doubleValue();
/*  39 */     this.practiceMod = Double.valueOf(rootElement.attributeValue("practiceMod")).doubleValue();
/*     */     
/*  41 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "itemTableModList");
/*  42 */     if (collectionElement == null)
/*     */     {
/*  44 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  47 */     List<?> _nodeList = collectionElement.elements();
/*  48 */     int _len = _nodeList.size();
/*  49 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  51 */       Element elem = (Element)_nodeList.get(i);
/*  52 */       if (elem.getName().equalsIgnoreCase("float"))
/*     */       {
/*     */         double _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  59 */           _v_ = Double.valueOf(elem.getText()).doubleValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  66 */         this.itemTableModList.add(Double.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  73 */     _os_.marshal(this.id);
/*  74 */     _os_.marshal(this.templatename, "UTF-8");
/*  75 */     _os_.marshal(this.silverMod);
/*  76 */     _os_.marshal(this.masterMod);
/*  77 */     _os_.marshal(this.gangConbMod);
/*  78 */     _os_.marshal(this.vitalityMod);
/*  79 */     _os_.marshal(this.roleExpMod);
/*  80 */     _os_.marshal(this.petExpMod);
/*  81 */     _os_.marshal(this.practiceMod);
/*  82 */     _os_.compact_uint32(this.itemTableModList.size());
/*  83 */     for (Double _v_ : this.itemTableModList)
/*     */     {
/*  85 */       _os_.marshal(_v_.doubleValue());
/*     */     }
/*  87 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  92 */     this.id = _os_.unmarshal_int();
/*  93 */     this.templatename = _os_.unmarshal_String("UTF-8");
/*  94 */     this.silverMod = _os_.unmarshal_float();
/*  95 */     this.masterMod = _os_.unmarshal_float();
/*  96 */     this.gangConbMod = _os_.unmarshal_float();
/*  97 */     this.vitalityMod = _os_.unmarshal_float();
/*  98 */     this.roleExpMod = _os_.unmarshal_float();
/*  99 */     this.petExpMod = _os_.unmarshal_float();
/* 100 */     this.practiceMod = _os_.unmarshal_float();
/* 101 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 104 */       double _v_ = _os_.unmarshal_float();
/* 105 */       this.itemTableModList.add(Double.valueOf(_v_));
/*     */     }
/* 107 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 112 */     String path = dir + "mzm.gsp.award.confbean.SModifyValueTable.xml";
/*     */     
/*     */     try
/*     */     {
/* 116 */       all = new java.util.HashMap();
/* 117 */       SAXReader reader = new SAXReader();
/* 118 */       org.dom4j.Document doc = reader.read(new File(path));
/* 119 */       Element root = doc.getRootElement();
/* 120 */       List<?> nodeList = root.elements();
/* 121 */       int len = nodeList.size();
/* 122 */       for (int i = 0; i < len; i++)
/*     */       {
/* 124 */         Element elem = (Element)nodeList.get(i);
/* 125 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.SModifyValueTable"))
/*     */         {
/*     */ 
/* 128 */           SModifyValueTable obj = new SModifyValueTable();
/* 129 */           obj.loadFromXml(elem);
/* 130 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 131 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 136 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SModifyValueTable> all)
/*     */   {
/* 142 */     String path = dir + "mzm.gsp.award.confbean.SModifyValueTable.xml";
/*     */     
/*     */     try
/*     */     {
/* 146 */       SAXReader reader = new SAXReader();
/* 147 */       org.dom4j.Document doc = reader.read(new File(path));
/* 148 */       Element root = doc.getRootElement();
/* 149 */       List<?> nodeList = root.elements();
/* 150 */       int len = nodeList.size();
/* 151 */       for (int i = 0; i < len; i++)
/*     */       {
/* 153 */         Element elem = (Element)nodeList.get(i);
/* 154 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.SModifyValueTable"))
/*     */         {
/*     */ 
/* 157 */           SModifyValueTable obj = new SModifyValueTable();
/* 158 */           obj.loadFromXml(elem);
/* 159 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 160 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 165 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 171 */     all = new java.util.HashMap();
/*     */     
/* 173 */     String path = dir + "mzm.gsp.award.confbean.SModifyValueTable.bny";
/*     */     try
/*     */     {
/* 176 */       File file = new File(path);
/* 177 */       if (file.exists())
/*     */       {
/* 179 */         byte[] bytes = new byte['Ѐ'];
/* 180 */         FileInputStream fis = new FileInputStream(file);
/* 181 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 182 */         int len = 0;
/* 183 */         while ((len = fis.read(bytes)) > 0)
/* 184 */           baos.write(bytes, 0, len);
/* 185 */         fis.close();
/* 186 */         bytes = baos.toByteArray();
/* 187 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 188 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 190 */           _os_.unmarshal_int();
/* 191 */           _os_.unmarshal_int();
/* 192 */           _os_.unmarshal_int();
/*     */         }
/* 194 */         _os_.unmarshal_int();
/* 195 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 198 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 200 */           SModifyValueTable _v_ = new SModifyValueTable();
/* 201 */           _v_.unmarshal(_os_);
/* 202 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 203 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 208 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 213 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SModifyValueTable> all)
/*     */   {
/* 220 */     String path = dir + "mzm.gsp.award.confbean.SModifyValueTable.bny";
/*     */     try
/*     */     {
/* 223 */       File file = new File(path);
/* 224 */       if (file.exists())
/*     */       {
/* 226 */         byte[] bytes = new byte['Ѐ'];
/* 227 */         FileInputStream fis = new FileInputStream(file);
/* 228 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 229 */         int len = 0;
/* 230 */         while ((len = fis.read(bytes)) > 0)
/* 231 */           baos.write(bytes, 0, len);
/* 232 */         fis.close();
/* 233 */         bytes = baos.toByteArray();
/* 234 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 235 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 237 */           _os_.unmarshal_int();
/* 238 */           _os_.unmarshal_int();
/* 239 */           _os_.unmarshal_int();
/*     */         }
/* 241 */         _os_.unmarshal_int();
/* 242 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 245 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 247 */           SModifyValueTable _v_ = new SModifyValueTable();
/* 248 */           _v_.unmarshal(_os_);
/* 249 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 250 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 255 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 260 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SModifyValueTable getOld(int key)
/*     */   {
/* 268 */     return (SModifyValueTable)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SModifyValueTable get(int key)
/*     */   {
/* 273 */     return (SModifyValueTable)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SModifyValueTable> getOldAll()
/*     */   {
/* 278 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SModifyValueTable> getAll()
/*     */   {
/* 283 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SModifyValueTable> newAll)
/*     */   {
/* 288 */     oldAll = all;
/* 289 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 294 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\confbean\SModifyValueTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */