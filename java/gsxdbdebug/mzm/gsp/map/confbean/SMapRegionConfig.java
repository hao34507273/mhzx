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
/*     */ public class SMapRegionConfig implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SMapRegionConfig> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SMapRegionConfig> all = null;
/*     */   
/*     */   public int id;
/*     */   public int mapId;
/*     */   public int x;
/*     */   public int y;
/*     */   public int w;
/*     */   public int h;
/*  24 */   public java.util.ArrayList<Integer> randomCells = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  28 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  29 */     this.mapId = Integer.valueOf(rootElement.attributeValue("mapId")).intValue();
/*  30 */     this.x = Integer.valueOf(rootElement.attributeValue("x")).intValue();
/*  31 */     this.y = Integer.valueOf(rootElement.attributeValue("y")).intValue();
/*  32 */     this.w = Integer.valueOf(rootElement.attributeValue("w")).intValue();
/*  33 */     this.h = Integer.valueOf(rootElement.attributeValue("h")).intValue();
/*     */     
/*  35 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "randomCells");
/*  36 */     if (collectionElement == null)
/*     */     {
/*  38 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  41 */     List<?> _nodeList = collectionElement.elements();
/*  42 */     int _len = _nodeList.size();
/*  43 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  45 */       Element elem = (Element)_nodeList.get(i);
/*  46 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  53 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  60 */         this.randomCells.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  67 */     _os_.marshal(this.id);
/*  68 */     _os_.marshal(this.mapId);
/*  69 */     _os_.marshal(this.x);
/*  70 */     _os_.marshal(this.y);
/*  71 */     _os_.marshal(this.w);
/*  72 */     _os_.marshal(this.h);
/*  73 */     _os_.compact_uint32(this.randomCells.size());
/*  74 */     for (Integer _v_ : this.randomCells)
/*     */     {
/*  76 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  83 */     this.id = _os_.unmarshal_int();
/*  84 */     this.mapId = _os_.unmarshal_int();
/*  85 */     this.x = _os_.unmarshal_int();
/*  86 */     this.y = _os_.unmarshal_int();
/*  87 */     this.w = _os_.unmarshal_int();
/*  88 */     this.h = _os_.unmarshal_int();
/*  89 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  92 */       int _v_ = _os_.unmarshal_int();
/*  93 */       this.randomCells.add(Integer.valueOf(_v_));
/*     */     }
/*  95 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 100 */     String path = dir + "mzm.gsp.map.confbean.SMapRegionConfig.xml";
/*     */     
/*     */     try
/*     */     {
/* 104 */       all = new java.util.HashMap();
/* 105 */       SAXReader reader = new SAXReader();
/* 106 */       org.dom4j.Document doc = reader.read(new File(path));
/* 107 */       Element root = doc.getRootElement();
/* 108 */       List<?> nodeList = root.elements();
/* 109 */       int len = nodeList.size();
/* 110 */       for (int i = 0; i < len; i++)
/*     */       {
/* 112 */         Element elem = (Element)nodeList.get(i);
/* 113 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.SMapRegionConfig"))
/*     */         {
/*     */ 
/* 116 */           SMapRegionConfig obj = new SMapRegionConfig();
/* 117 */           obj.loadFromXml(elem);
/* 118 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 119 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 124 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SMapRegionConfig> all)
/*     */   {
/* 130 */     String path = dir + "mzm.gsp.map.confbean.SMapRegionConfig.xml";
/*     */     
/*     */     try
/*     */     {
/* 134 */       SAXReader reader = new SAXReader();
/* 135 */       org.dom4j.Document doc = reader.read(new File(path));
/* 136 */       Element root = doc.getRootElement();
/* 137 */       List<?> nodeList = root.elements();
/* 138 */       int len = nodeList.size();
/* 139 */       for (int i = 0; i < len; i++)
/*     */       {
/* 141 */         Element elem = (Element)nodeList.get(i);
/* 142 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.SMapRegionConfig"))
/*     */         {
/*     */ 
/* 145 */           SMapRegionConfig obj = new SMapRegionConfig();
/* 146 */           obj.loadFromXml(elem);
/* 147 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 148 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 153 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 159 */     all = new java.util.HashMap();
/*     */     
/* 161 */     String path = dir + "mzm.gsp.map.confbean.SMapRegionConfig.bny";
/*     */     try
/*     */     {
/* 164 */       File file = new File(path);
/* 165 */       if (file.exists())
/*     */       {
/* 167 */         byte[] bytes = new byte['Ѐ'];
/* 168 */         FileInputStream fis = new FileInputStream(file);
/* 169 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 170 */         int len = 0;
/* 171 */         while ((len = fis.read(bytes)) > 0)
/* 172 */           baos.write(bytes, 0, len);
/* 173 */         fis.close();
/* 174 */         bytes = baos.toByteArray();
/* 175 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 176 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 178 */           _os_.unmarshal_int();
/* 179 */           _os_.unmarshal_int();
/* 180 */           _os_.unmarshal_int();
/*     */         }
/* 182 */         _os_.unmarshal_int();
/* 183 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 186 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 188 */           SMapRegionConfig _v_ = new SMapRegionConfig();
/* 189 */           _v_.unmarshal(_os_);
/* 190 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 191 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 196 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 201 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SMapRegionConfig> all)
/*     */   {
/* 208 */     String path = dir + "mzm.gsp.map.confbean.SMapRegionConfig.bny";
/*     */     try
/*     */     {
/* 211 */       File file = new File(path);
/* 212 */       if (file.exists())
/*     */       {
/* 214 */         byte[] bytes = new byte['Ѐ'];
/* 215 */         FileInputStream fis = new FileInputStream(file);
/* 216 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 217 */         int len = 0;
/* 218 */         while ((len = fis.read(bytes)) > 0)
/* 219 */           baos.write(bytes, 0, len);
/* 220 */         fis.close();
/* 221 */         bytes = baos.toByteArray();
/* 222 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 223 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 225 */           _os_.unmarshal_int();
/* 226 */           _os_.unmarshal_int();
/* 227 */           _os_.unmarshal_int();
/*     */         }
/* 229 */         _os_.unmarshal_int();
/* 230 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 233 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 235 */           SMapRegionConfig _v_ = new SMapRegionConfig();
/* 236 */           _v_.unmarshal(_os_);
/* 237 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 238 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 243 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 248 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SMapRegionConfig getOld(int key)
/*     */   {
/* 256 */     return (SMapRegionConfig)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SMapRegionConfig get(int key)
/*     */   {
/* 261 */     return (SMapRegionConfig)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMapRegionConfig> getOldAll()
/*     */   {
/* 266 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMapRegionConfig> getAll()
/*     */   {
/* 271 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SMapRegionConfig> newAll)
/*     */   {
/* 276 */     oldAll = all;
/* 277 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 282 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\confbean\SMapRegionConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */