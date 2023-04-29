/*     */ package mzm.gsp.children.confbean;
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
/*     */ public class SCourseCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SCourseCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SCourseCfg> all = null;
/*     */   
/*     */   public int courseType;
/*     */   public String name;
/*  20 */   public java.util.ArrayList<CourseEffectInfo> interests = new java.util.ArrayList();
/*     */   public int studyTime;
/*     */   public int vigor;
/*     */   public int moneyType;
/*     */   public int cost;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  28 */     this.courseType = Integer.valueOf(rootElement.attributeValue("courseType")).intValue();
/*  29 */     this.name = rootElement.attributeValue("name");
/*     */     
/*  31 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "interests");
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
/*  42 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.children.confbean.CourseEffectInfo"))
/*     */       {
/*     */         CourseEffectInfo _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  49 */           _v_ = new CourseEffectInfo();
/*  50 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  57 */         this.interests.add(_v_);
/*     */       }
/*     */     }
/*  60 */     this.studyTime = Integer.valueOf(rootElement.attributeValue("studyTime")).intValue();
/*  61 */     this.vigor = Integer.valueOf(rootElement.attributeValue("vigor")).intValue();
/*  62 */     this.moneyType = Integer.valueOf(rootElement.attributeValue("moneyType")).intValue();
/*  63 */     this.cost = Integer.valueOf(rootElement.attributeValue("cost")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  68 */     _os_.marshal(this.courseType);
/*  69 */     _os_.marshal(this.name, "UTF-8");
/*  70 */     _os_.compact_uint32(this.interests.size());
/*  71 */     for (CourseEffectInfo _v_ : this.interests)
/*     */     {
/*  73 */       _os_.marshal(_v_);
/*     */     }
/*  75 */     _os_.marshal(this.studyTime);
/*  76 */     _os_.marshal(this.vigor);
/*  77 */     _os_.marshal(this.moneyType);
/*  78 */     _os_.marshal(this.cost);
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  84 */     this.courseType = _os_.unmarshal_int();
/*  85 */     this.name = _os_.unmarshal_String("UTF-8");
/*  86 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  89 */       CourseEffectInfo _v_ = new CourseEffectInfo();
/*  90 */       _v_.unmarshal(_os_);
/*  91 */       this.interests.add(_v_);
/*     */     }
/*  93 */     this.studyTime = _os_.unmarshal_int();
/*  94 */     this.vigor = _os_.unmarshal_int();
/*  95 */     this.moneyType = _os_.unmarshal_int();
/*  96 */     this.cost = _os_.unmarshal_int();
/*  97 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 102 */     String path = dir + "mzm.gsp.children.confbean.SCourseCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 106 */       all = new java.util.HashMap();
/* 107 */       SAXReader reader = new SAXReader();
/* 108 */       org.dom4j.Document doc = reader.read(new File(path));
/* 109 */       Element root = doc.getRootElement();
/* 110 */       List<?> nodeList = root.elements();
/* 111 */       int len = nodeList.size();
/* 112 */       for (int i = 0; i < len; i++)
/*     */       {
/* 114 */         Element elem = (Element)nodeList.get(i);
/* 115 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.children.confbean.SCourseCfg"))
/*     */         {
/*     */ 
/* 118 */           SCourseCfg obj = new SCourseCfg();
/* 119 */           obj.loadFromXml(elem);
/* 120 */           if (all.put(Integer.valueOf(obj.courseType), obj) != null) {
/* 121 */             throw new RuntimeException("duplicate key : " + obj.courseType);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 126 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SCourseCfg> all)
/*     */   {
/* 132 */     String path = dir + "mzm.gsp.children.confbean.SCourseCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 136 */       SAXReader reader = new SAXReader();
/* 137 */       org.dom4j.Document doc = reader.read(new File(path));
/* 138 */       Element root = doc.getRootElement();
/* 139 */       List<?> nodeList = root.elements();
/* 140 */       int len = nodeList.size();
/* 141 */       for (int i = 0; i < len; i++)
/*     */       {
/* 143 */         Element elem = (Element)nodeList.get(i);
/* 144 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.children.confbean.SCourseCfg"))
/*     */         {
/*     */ 
/* 147 */           SCourseCfg obj = new SCourseCfg();
/* 148 */           obj.loadFromXml(elem);
/* 149 */           if (all.put(Integer.valueOf(obj.courseType), obj) != null) {
/* 150 */             throw new RuntimeException("duplicate key : " + obj.courseType);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 155 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 161 */     all = new java.util.HashMap();
/*     */     
/* 163 */     String path = dir + "mzm.gsp.children.confbean.SCourseCfg.bny";
/*     */     try
/*     */     {
/* 166 */       File file = new File(path);
/* 167 */       if (file.exists())
/*     */       {
/* 169 */         byte[] bytes = new byte['Ѐ'];
/* 170 */         FileInputStream fis = new FileInputStream(file);
/* 171 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 172 */         int len = 0;
/* 173 */         while ((len = fis.read(bytes)) > 0)
/* 174 */           baos.write(bytes, 0, len);
/* 175 */         fis.close();
/* 176 */         bytes = baos.toByteArray();
/* 177 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 178 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 180 */           _os_.unmarshal_int();
/* 181 */           _os_.unmarshal_int();
/* 182 */           _os_.unmarshal_int();
/*     */         }
/* 184 */         _os_.unmarshal_int();
/* 185 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 188 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 190 */           SCourseCfg _v_ = new SCourseCfg();
/* 191 */           _v_.unmarshal(_os_);
/* 192 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 193 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 198 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 203 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SCourseCfg> all)
/*     */   {
/* 210 */     String path = dir + "mzm.gsp.children.confbean.SCourseCfg.bny";
/*     */     try
/*     */     {
/* 213 */       File file = new File(path);
/* 214 */       if (file.exists())
/*     */       {
/* 216 */         byte[] bytes = new byte['Ѐ'];
/* 217 */         FileInputStream fis = new FileInputStream(file);
/* 218 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 219 */         int len = 0;
/* 220 */         while ((len = fis.read(bytes)) > 0)
/* 221 */           baos.write(bytes, 0, len);
/* 222 */         fis.close();
/* 223 */         bytes = baos.toByteArray();
/* 224 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 225 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 227 */           _os_.unmarshal_int();
/* 228 */           _os_.unmarshal_int();
/* 229 */           _os_.unmarshal_int();
/*     */         }
/* 231 */         _os_.unmarshal_int();
/* 232 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 235 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 237 */           SCourseCfg _v_ = new SCourseCfg();
/* 238 */           _v_.unmarshal(_os_);
/* 239 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 240 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 245 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 250 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SCourseCfg getOld(int key)
/*     */   {
/* 258 */     return (SCourseCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SCourseCfg get(int key)
/*     */   {
/* 263 */     return (SCourseCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCourseCfg> getOldAll()
/*     */   {
/* 268 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCourseCfg> getAll()
/*     */   {
/* 273 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SCourseCfg> newAll)
/*     */   {
/* 278 */     oldAll = all;
/* 279 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 284 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\confbean\SCourseCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */