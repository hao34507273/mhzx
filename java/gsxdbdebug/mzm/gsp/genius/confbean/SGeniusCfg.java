/*     */ package mzm.gsp.genius.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SGeniusCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SGeniusCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SGeniusCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int geniusSeriesCfgid;
/*     */   public int layer;
/*     */   public int previousPoint;
/*  22 */   public ArrayList<PreviousGeniusCfg> previousGenius = new ArrayList();
/*     */   public int sourceSkillCfgid;
/*  24 */   public ArrayList<Integer> skills = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  28 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  29 */     this.geniusSeriesCfgid = Integer.valueOf(rootElement.attributeValue("geniusSeriesCfgid")).intValue();
/*  30 */     this.layer = Integer.valueOf(rootElement.attributeValue("layer")).intValue();
/*  31 */     this.previousPoint = Integer.valueOf(rootElement.attributeValue("previousPoint")).intValue();
/*     */     
/*  33 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "previousGenius");
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
/*  44 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.genius.confbean.PreviousGeniusCfg"))
/*     */       {
/*     */         PreviousGeniusCfg _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  51 */           _v_ = new PreviousGeniusCfg();
/*  52 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  59 */         this.previousGenius.add(_v_);
/*     */       }
/*     */     }
/*  62 */     this.sourceSkillCfgid = Integer.valueOf(rootElement.attributeValue("sourceSkillCfgid")).intValue();
/*     */     
/*  64 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "skills");
/*  65 */     if (collectionElement == null)
/*     */     {
/*  67 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  70 */     List<?> _nodeList = collectionElement.elements();
/*  71 */     int _len = _nodeList.size();
/*  72 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  74 */       Element elem = (Element)_nodeList.get(i);
/*  75 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  82 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  89 */         this.skills.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  96 */     _os_.marshal(this.id);
/*  97 */     _os_.marshal(this.geniusSeriesCfgid);
/*  98 */     _os_.marshal(this.layer);
/*  99 */     _os_.marshal(this.previousPoint);
/* 100 */     _os_.compact_uint32(this.previousGenius.size());
/* 101 */     for (PreviousGeniusCfg _v_ : this.previousGenius)
/*     */     {
/* 103 */       _os_.marshal(_v_);
/*     */     }
/* 105 */     _os_.marshal(this.sourceSkillCfgid);
/* 106 */     _os_.compact_uint32(this.skills.size());
/* 107 */     for (Integer _v_ : this.skills)
/*     */     {
/* 109 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 111 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 116 */     this.id = _os_.unmarshal_int();
/* 117 */     this.geniusSeriesCfgid = _os_.unmarshal_int();
/* 118 */     this.layer = _os_.unmarshal_int();
/* 119 */     this.previousPoint = _os_.unmarshal_int();
/* 120 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 123 */       PreviousGeniusCfg _v_ = new PreviousGeniusCfg();
/* 124 */       _v_.unmarshal(_os_);
/* 125 */       this.previousGenius.add(_v_);
/*     */     }
/* 127 */     this.sourceSkillCfgid = _os_.unmarshal_int();
/* 128 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 131 */       int _v_ = _os_.unmarshal_int();
/* 132 */       this.skills.add(Integer.valueOf(_v_));
/*     */     }
/* 134 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 139 */     String path = dir + "mzm.gsp.genius.confbean.SGeniusCfg.xml";
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
/* 152 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.genius.confbean.SGeniusCfg"))
/*     */         {
/*     */ 
/* 155 */           SGeniusCfg obj = new SGeniusCfg();
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
/*     */   public static void reLoadXml(String dir, Map<Integer, SGeniusCfg> all)
/*     */   {
/* 169 */     String path = dir + "mzm.gsp.genius.confbean.SGeniusCfg.xml";
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
/* 181 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.genius.confbean.SGeniusCfg"))
/*     */         {
/*     */ 
/* 184 */           SGeniusCfg obj = new SGeniusCfg();
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
/* 200 */     String path = dir + "mzm.gsp.genius.confbean.SGeniusCfg.bny";
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
/* 227 */           SGeniusCfg _v_ = new SGeniusCfg();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, SGeniusCfg> all)
/*     */   {
/* 247 */     String path = dir + "mzm.gsp.genius.confbean.SGeniusCfg.bny";
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
/* 274 */           SGeniusCfg _v_ = new SGeniusCfg();
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
/*     */   public static SGeniusCfg getOld(int key)
/*     */   {
/* 295 */     return (SGeniusCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SGeniusCfg get(int key)
/*     */   {
/* 300 */     return (SGeniusCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SGeniusCfg> getOldAll()
/*     */   {
/* 305 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SGeniusCfg> getAll()
/*     */   {
/* 310 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SGeniusCfg> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genius\confbean\SGeniusCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */