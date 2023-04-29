/*     */ package mzm.gsp.map.confbean;
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
/*     */ public class SMapPolygonCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SMapPolygonCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SMapPolygonCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int mapCfgid;
/*     */   public int tag;
/*  21 */   public java.util.ArrayList<Vertex> vertices = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  25 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  26 */     this.mapCfgid = Integer.valueOf(rootElement.attributeValue("mapCfgid")).intValue();
/*  27 */     this.tag = Integer.valueOf(rootElement.attributeValue("tag")).intValue();
/*     */     
/*  29 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "vertices");
/*  30 */     if (collectionElement == null)
/*     */     {
/*  32 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  35 */     List<?> _nodeList = collectionElement.elements();
/*  36 */     int _len = _nodeList.size();
/*  37 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  39 */       Element elem = (Element)_nodeList.get(i);
/*  40 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.Vertex"))
/*     */       {
/*     */         Vertex _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  47 */           _v_ = new Vertex();
/*  48 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  55 */         this.vertices.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  62 */     _os_.marshal(this.id);
/*  63 */     _os_.marshal(this.mapCfgid);
/*  64 */     _os_.marshal(this.tag);
/*  65 */     _os_.compact_uint32(this.vertices.size());
/*  66 */     for (Vertex _v_ : this.vertices)
/*     */     {
/*  68 */       _os_.marshal(_v_);
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  75 */     this.id = _os_.unmarshal_int();
/*  76 */     this.mapCfgid = _os_.unmarshal_int();
/*  77 */     this.tag = _os_.unmarshal_int();
/*  78 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  81 */       Vertex _v_ = new Vertex();
/*  82 */       _v_.unmarshal(_os_);
/*  83 */       this.vertices.add(_v_);
/*     */     }
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  90 */     String path = dir + "mzm.gsp.map.confbean.SMapPolygonCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  94 */       all = new java.util.HashMap();
/*  95 */       SAXReader reader = new SAXReader();
/*  96 */       org.dom4j.Document doc = reader.read(new File(path));
/*  97 */       Element root = doc.getRootElement();
/*  98 */       List<?> nodeList = root.elements();
/*  99 */       int len = nodeList.size();
/* 100 */       for (int i = 0; i < len; i++)
/*     */       {
/* 102 */         Element elem = (Element)nodeList.get(i);
/* 103 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.SMapPolygonCfg"))
/*     */         {
/*     */ 
/* 106 */           SMapPolygonCfg obj = new SMapPolygonCfg();
/* 107 */           obj.loadFromXml(elem);
/* 108 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 109 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 114 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SMapPolygonCfg> all)
/*     */   {
/* 120 */     String path = dir + "mzm.gsp.map.confbean.SMapPolygonCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 124 */       SAXReader reader = new SAXReader();
/* 125 */       org.dom4j.Document doc = reader.read(new File(path));
/* 126 */       Element root = doc.getRootElement();
/* 127 */       List<?> nodeList = root.elements();
/* 128 */       int len = nodeList.size();
/* 129 */       for (int i = 0; i < len; i++)
/*     */       {
/* 131 */         Element elem = (Element)nodeList.get(i);
/* 132 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.SMapPolygonCfg"))
/*     */         {
/*     */ 
/* 135 */           SMapPolygonCfg obj = new SMapPolygonCfg();
/* 136 */           obj.loadFromXml(elem);
/* 137 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 138 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 143 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 149 */     all = new java.util.HashMap();
/*     */     
/* 151 */     String path = dir + "mzm.gsp.map.confbean.SMapPolygonCfg.bny";
/*     */     try
/*     */     {
/* 154 */       File file = new File(path);
/* 155 */       if (file.exists())
/*     */       {
/* 157 */         byte[] bytes = new byte['Ѐ'];
/* 158 */         FileInputStream fis = new FileInputStream(file);
/* 159 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 160 */         int len = 0;
/* 161 */         while ((len = fis.read(bytes)) > 0)
/* 162 */           baos.write(bytes, 0, len);
/* 163 */         fis.close();
/* 164 */         bytes = baos.toByteArray();
/* 165 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 166 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 168 */           _os_.unmarshal_int();
/* 169 */           _os_.unmarshal_int();
/* 170 */           _os_.unmarshal_int();
/*     */         }
/* 172 */         _os_.unmarshal_int();
/* 173 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 176 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 178 */           SMapPolygonCfg _v_ = new SMapPolygonCfg();
/* 179 */           _v_.unmarshal(_os_);
/* 180 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 181 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 186 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 191 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SMapPolygonCfg> all)
/*     */   {
/* 198 */     String path = dir + "mzm.gsp.map.confbean.SMapPolygonCfg.bny";
/*     */     try
/*     */     {
/* 201 */       File file = new File(path);
/* 202 */       if (file.exists())
/*     */       {
/* 204 */         byte[] bytes = new byte['Ѐ'];
/* 205 */         FileInputStream fis = new FileInputStream(file);
/* 206 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 207 */         int len = 0;
/* 208 */         while ((len = fis.read(bytes)) > 0)
/* 209 */           baos.write(bytes, 0, len);
/* 210 */         fis.close();
/* 211 */         bytes = baos.toByteArray();
/* 212 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 213 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 215 */           _os_.unmarshal_int();
/* 216 */           _os_.unmarshal_int();
/* 217 */           _os_.unmarshal_int();
/*     */         }
/* 219 */         _os_.unmarshal_int();
/* 220 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 223 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 225 */           SMapPolygonCfg _v_ = new SMapPolygonCfg();
/* 226 */           _v_.unmarshal(_os_);
/* 227 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 228 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 233 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 238 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SMapPolygonCfg getOld(int key)
/*     */   {
/* 246 */     return (SMapPolygonCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SMapPolygonCfg get(int key)
/*     */   {
/* 251 */     return (SMapPolygonCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMapPolygonCfg> getOldAll()
/*     */   {
/* 256 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMapPolygonCfg> getAll()
/*     */   {
/* 261 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SMapPolygonCfg> newAll)
/*     */   {
/* 266 */     oldAll = all;
/* 267 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 272 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\confbean\SMapPolygonCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */