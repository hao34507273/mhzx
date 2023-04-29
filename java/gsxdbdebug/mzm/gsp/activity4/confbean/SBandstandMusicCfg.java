/*     */ package mzm.gsp.activity4.confbean;
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
/*     */ public class SBandstandMusicCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SBandstandMusicCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SBandstandMusicCfg> all = null;
/*     */   
/*     */   public int id;
/*  19 */   public ArrayList<SBandstandFragmentInfo> fragments = new ArrayList();
/*  20 */   public ArrayList<Integer> fragmentIndexesWithLyric = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  24 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*     */     
/*  26 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "fragments");
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
/*  37 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.activity4.confbean.SBandstandFragmentInfo"))
/*     */       {
/*     */         SBandstandFragmentInfo _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  44 */           _v_ = new SBandstandFragmentInfo();
/*  45 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  52 */         this.fragments.add(_v_);
/*     */       }
/*     */     }
/*     */     
/*  56 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "fragmentIndexesWithLyric");
/*  57 */     if (collectionElement == null)
/*     */     {
/*  59 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  62 */     List<?> _nodeList = collectionElement.elements();
/*  63 */     int _len = _nodeList.size();
/*  64 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  66 */       Element elem = (Element)_nodeList.get(i);
/*  67 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  74 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  81 */         this.fragmentIndexesWithLyric.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  88 */     _os_.marshal(this.id);
/*  89 */     _os_.compact_uint32(this.fragments.size());
/*  90 */     for (SBandstandFragmentInfo _v_ : this.fragments)
/*     */     {
/*  92 */       _os_.marshal(_v_);
/*     */     }
/*  94 */     _os_.compact_uint32(this.fragmentIndexesWithLyric.size());
/*  95 */     for (Integer _v_ : this.fragmentIndexesWithLyric)
/*     */     {
/*  97 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  99 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 104 */     this.id = _os_.unmarshal_int();
/* 105 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 108 */       SBandstandFragmentInfo _v_ = new SBandstandFragmentInfo();
/* 109 */       _v_.unmarshal(_os_);
/* 110 */       this.fragments.add(_v_);
/*     */     }
/* 112 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 115 */       int _v_ = _os_.unmarshal_int();
/* 116 */       this.fragmentIndexesWithLyric.add(Integer.valueOf(_v_));
/*     */     }
/* 118 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 123 */     String path = dir + "mzm.gsp.activity4.confbean.SBandstandMusicCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 127 */       all = new java.util.HashMap();
/* 128 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 129 */       org.dom4j.Document doc = reader.read(new File(path));
/* 130 */       Element root = doc.getRootElement();
/* 131 */       List<?> nodeList = root.elements();
/* 132 */       int len = nodeList.size();
/* 133 */       for (int i = 0; i < len; i++)
/*     */       {
/* 135 */         Element elem = (Element)nodeList.get(i);
/* 136 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity4.confbean.SBandstandMusicCfg"))
/*     */         {
/*     */ 
/* 139 */           SBandstandMusicCfg obj = new SBandstandMusicCfg();
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
/*     */   public static void reLoadXml(String dir, Map<Integer, SBandstandMusicCfg> all)
/*     */   {
/* 153 */     String path = dir + "mzm.gsp.activity4.confbean.SBandstandMusicCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 157 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 158 */       org.dom4j.Document doc = reader.read(new File(path));
/* 159 */       Element root = doc.getRootElement();
/* 160 */       List<?> nodeList = root.elements();
/* 161 */       int len = nodeList.size();
/* 162 */       for (int i = 0; i < len; i++)
/*     */       {
/* 164 */         Element elem = (Element)nodeList.get(i);
/* 165 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity4.confbean.SBandstandMusicCfg"))
/*     */         {
/*     */ 
/* 168 */           SBandstandMusicCfg obj = new SBandstandMusicCfg();
/* 169 */           obj.loadFromXml(elem);
/* 170 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 171 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 176 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 182 */     all = new java.util.HashMap();
/*     */     
/* 184 */     String path = dir + "mzm.gsp.activity4.confbean.SBandstandMusicCfg.bny";
/*     */     try
/*     */     {
/* 187 */       File file = new File(path);
/* 188 */       if (file.exists())
/*     */       {
/* 190 */         byte[] bytes = new byte['Ѐ'];
/* 191 */         FileInputStream fis = new FileInputStream(file);
/* 192 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 193 */         int len = 0;
/* 194 */         while ((len = fis.read(bytes)) > 0)
/* 195 */           baos.write(bytes, 0, len);
/* 196 */         fis.close();
/* 197 */         bytes = baos.toByteArray();
/* 198 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 199 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 201 */           _os_.unmarshal_int();
/* 202 */           _os_.unmarshal_int();
/* 203 */           _os_.unmarshal_int();
/*     */         }
/* 205 */         _os_.unmarshal_int();
/* 206 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 209 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 211 */           SBandstandMusicCfg _v_ = new SBandstandMusicCfg();
/* 212 */           _v_.unmarshal(_os_);
/* 213 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 214 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 219 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 224 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SBandstandMusicCfg> all)
/*     */   {
/* 231 */     String path = dir + "mzm.gsp.activity4.confbean.SBandstandMusicCfg.bny";
/*     */     try
/*     */     {
/* 234 */       File file = new File(path);
/* 235 */       if (file.exists())
/*     */       {
/* 237 */         byte[] bytes = new byte['Ѐ'];
/* 238 */         FileInputStream fis = new FileInputStream(file);
/* 239 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 240 */         int len = 0;
/* 241 */         while ((len = fis.read(bytes)) > 0)
/* 242 */           baos.write(bytes, 0, len);
/* 243 */         fis.close();
/* 244 */         bytes = baos.toByteArray();
/* 245 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 246 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 248 */           _os_.unmarshal_int();
/* 249 */           _os_.unmarshal_int();
/* 250 */           _os_.unmarshal_int();
/*     */         }
/* 252 */         _os_.unmarshal_int();
/* 253 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 256 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 258 */           SBandstandMusicCfg _v_ = new SBandstandMusicCfg();
/* 259 */           _v_.unmarshal(_os_);
/* 260 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 261 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 266 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 271 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SBandstandMusicCfg getOld(int key)
/*     */   {
/* 279 */     return (SBandstandMusicCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SBandstandMusicCfg get(int key)
/*     */   {
/* 284 */     return (SBandstandMusicCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBandstandMusicCfg> getOldAll()
/*     */   {
/* 289 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBandstandMusicCfg> getAll()
/*     */   {
/* 294 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SBandstandMusicCfg> newAll)
/*     */   {
/* 299 */     oldAll = all;
/* 300 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 305 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity4\confbean\SBandstandMusicCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */