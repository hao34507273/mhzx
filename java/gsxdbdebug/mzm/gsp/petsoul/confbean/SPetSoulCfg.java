/*     */ package mzm.gsp.petsoul.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SPetSoulCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SPetSoulCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SPetSoulCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int pos;
/*     */   public int level;
/*     */   public int exp;
/*  22 */   public LinkedList<SPetPropBean> propList = new LinkedList();
/*  23 */   public LinkedList<Integer> itemList = new LinkedList();
/*     */   public int addScore;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  28 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  29 */     this.pos = Integer.valueOf(rootElement.attributeValue("pos")).intValue();
/*  30 */     this.level = Integer.valueOf(rootElement.attributeValue("level")).intValue();
/*  31 */     this.exp = Integer.valueOf(rootElement.attributeValue("exp")).intValue();
/*     */     
/*  33 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "propList");
/*  34 */     if (collectionElement == null)
/*     */     {
/*  36 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  39 */     List<?> _nodeList = collectionElement.elements();
/*  40 */     int _len = _nodeList.size();
/*  41 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  43 */       Element elem = (Element)_nodeList.get(i);
/*  44 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.petsoul.confbean.SPetPropBean"))
/*     */       {
/*     */         SPetPropBean _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  51 */           _v_ = new SPetPropBean();
/*  52 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  59 */         this.propList.add(_v_);
/*     */       }
/*     */     }
/*     */     
/*  63 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "itemList");
/*  64 */     if (collectionElement == null)
/*     */     {
/*  66 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  69 */     List<?> _nodeList = collectionElement.elements();
/*  70 */     int _len = _nodeList.size();
/*  71 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  73 */       Element elem = (Element)_nodeList.get(i);
/*  74 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  81 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  88 */         this.itemList.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*  91 */     this.addScore = Integer.valueOf(rootElement.attributeValue("addScore")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  96 */     _os_.marshal(this.id);
/*  97 */     _os_.marshal(this.pos);
/*  98 */     _os_.marshal(this.level);
/*  99 */     _os_.marshal(this.exp);
/* 100 */     _os_.compact_uint32(this.propList.size());
/* 101 */     for (SPetPropBean _v_ : this.propList)
/*     */     {
/* 103 */       _os_.marshal(_v_);
/*     */     }
/* 105 */     _os_.compact_uint32(this.itemList.size());
/* 106 */     for (Integer _v_ : this.itemList)
/*     */     {
/* 108 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 110 */     _os_.marshal(this.addScore);
/* 111 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 116 */     this.id = _os_.unmarshal_int();
/* 117 */     this.pos = _os_.unmarshal_int();
/* 118 */     this.level = _os_.unmarshal_int();
/* 119 */     this.exp = _os_.unmarshal_int();
/* 120 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 123 */       SPetPropBean _v_ = new SPetPropBean();
/* 124 */       _v_.unmarshal(_os_);
/* 125 */       this.propList.add(_v_);
/*     */     }
/* 127 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 130 */       int _v_ = _os_.unmarshal_int();
/* 131 */       this.itemList.add(Integer.valueOf(_v_));
/*     */     }
/* 133 */     this.addScore = _os_.unmarshal_int();
/* 134 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 139 */     String path = dir + "mzm.gsp.petsoul.confbean.SPetSoulCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 143 */       all = new java.util.HashMap();
/* 144 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 145 */       org.dom4j.Document doc = reader.read(new File(path));
/* 146 */       Element root = doc.getRootElement();
/* 147 */       List<?> nodeList = root.elements();
/* 148 */       int len = nodeList.size();
/* 149 */       for (int i = 0; i < len; i++)
/*     */       {
/* 151 */         Element elem = (Element)nodeList.get(i);
/* 152 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.petsoul.confbean.SPetSoulCfg"))
/*     */         {
/*     */ 
/* 155 */           SPetSoulCfg obj = new SPetSoulCfg();
/* 156 */           obj.loadFromXml(elem);
/* 157 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 158 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 163 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SPetSoulCfg> all)
/*     */   {
/* 169 */     String path = dir + "mzm.gsp.petsoul.confbean.SPetSoulCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 173 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 174 */       org.dom4j.Document doc = reader.read(new File(path));
/* 175 */       Element root = doc.getRootElement();
/* 176 */       List<?> nodeList = root.elements();
/* 177 */       int len = nodeList.size();
/* 178 */       for (int i = 0; i < len; i++)
/*     */       {
/* 180 */         Element elem = (Element)nodeList.get(i);
/* 181 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.petsoul.confbean.SPetSoulCfg"))
/*     */         {
/*     */ 
/* 184 */           SPetSoulCfg obj = new SPetSoulCfg();
/* 185 */           obj.loadFromXml(elem);
/* 186 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 187 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 192 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 198 */     all = new java.util.HashMap();
/*     */     
/* 200 */     String path = dir + "mzm.gsp.petsoul.confbean.SPetSoulCfg.bny";
/*     */     try
/*     */     {
/* 203 */       File file = new File(path);
/* 204 */       if (file.exists())
/*     */       {
/* 206 */         byte[] bytes = new byte['Ѐ'];
/* 207 */         FileInputStream fis = new FileInputStream(file);
/* 208 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 209 */         int len = 0;
/* 210 */         while ((len = fis.read(bytes)) > 0)
/* 211 */           baos.write(bytes, 0, len);
/* 212 */         fis.close();
/* 213 */         bytes = baos.toByteArray();
/* 214 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 215 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 217 */           _os_.unmarshal_int();
/* 218 */           _os_.unmarshal_int();
/* 219 */           _os_.unmarshal_int();
/*     */         }
/* 221 */         _os_.unmarshal_int();
/* 222 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 225 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 227 */           SPetSoulCfg _v_ = new SPetSoulCfg();
/* 228 */           _v_.unmarshal(_os_);
/* 229 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 230 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 235 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 240 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SPetSoulCfg> all)
/*     */   {
/* 247 */     String path = dir + "mzm.gsp.petsoul.confbean.SPetSoulCfg.bny";
/*     */     try
/*     */     {
/* 250 */       File file = new File(path);
/* 251 */       if (file.exists())
/*     */       {
/* 253 */         byte[] bytes = new byte['Ѐ'];
/* 254 */         FileInputStream fis = new FileInputStream(file);
/* 255 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 256 */         int len = 0;
/* 257 */         while ((len = fis.read(bytes)) > 0)
/* 258 */           baos.write(bytes, 0, len);
/* 259 */         fis.close();
/* 260 */         bytes = baos.toByteArray();
/* 261 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 262 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 264 */           _os_.unmarshal_int();
/* 265 */           _os_.unmarshal_int();
/* 266 */           _os_.unmarshal_int();
/*     */         }
/* 268 */         _os_.unmarshal_int();
/* 269 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 272 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 274 */           SPetSoulCfg _v_ = new SPetSoulCfg();
/* 275 */           _v_.unmarshal(_os_);
/* 276 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 277 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 282 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 287 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SPetSoulCfg getOld(int key)
/*     */   {
/* 295 */     return (SPetSoulCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SPetSoulCfg get(int key)
/*     */   {
/* 300 */     return (SPetSoulCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPetSoulCfg> getOldAll()
/*     */   {
/* 305 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPetSoulCfg> getAll()
/*     */   {
/* 310 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SPetSoulCfg> newAll)
/*     */   {
/* 315 */     oldAll = all;
/* 316 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 321 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petsoul\confbean\SPetSoulCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */