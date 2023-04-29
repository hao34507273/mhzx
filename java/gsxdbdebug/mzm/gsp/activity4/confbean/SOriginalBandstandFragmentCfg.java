/*     */ package mzm.gsp.activity4.confbean;
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
/*     */ public class SOriginalBandstandFragmentCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SOriginalBandstandFragmentCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SOriginalBandstandFragmentCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int typeId;
/*     */   public int index;
/*     */   public int fragmentType;
/*     */   public int musicCfgId;
/*     */   public int musicTime;
/*     */   public String lyric;
/*  25 */   public java.util.ArrayList<String> answers = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  29 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  30 */     this.typeId = Integer.valueOf(rootElement.attributeValue("typeId")).intValue();
/*  31 */     this.index = Integer.valueOf(rootElement.attributeValue("index")).intValue();
/*  32 */     this.fragmentType = Integer.valueOf(rootElement.attributeValue("fragmentType")).intValue();
/*  33 */     this.musicCfgId = Integer.valueOf(rootElement.attributeValue("musicCfgId")).intValue();
/*  34 */     this.musicTime = Integer.valueOf(rootElement.attributeValue("musicTime")).intValue();
/*  35 */     this.lyric = rootElement.attributeValue("lyric");
/*     */     
/*  37 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "answers");
/*  38 */     if (collectionElement == null)
/*     */     {
/*  40 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  43 */     List<?> _nodeList = collectionElement.elements();
/*  44 */     int _len = _nodeList.size();
/*  45 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  47 */       Element elem = (Element)_nodeList.get(i);
/*  48 */       if (elem.getName().equalsIgnoreCase("string"))
/*     */       {
/*     */         String _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  55 */           _v_ = elem.getText();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  62 */         this.answers.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _os_.marshal(this.id);
/*  70 */     _os_.marshal(this.typeId);
/*  71 */     _os_.marshal(this.index);
/*  72 */     _os_.marshal(this.fragmentType);
/*  73 */     _os_.marshal(this.musicCfgId);
/*  74 */     _os_.marshal(this.musicTime);
/*  75 */     _os_.marshal(this.lyric, "UTF-8");
/*  76 */     _os_.compact_uint32(this.answers.size());
/*  77 */     for (String _v_ : this.answers)
/*     */     {
/*  79 */       _os_.marshal(_v_, "UTF-8");
/*     */     }
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  86 */     this.id = _os_.unmarshal_int();
/*  87 */     this.typeId = _os_.unmarshal_int();
/*  88 */     this.index = _os_.unmarshal_int();
/*  89 */     this.fragmentType = _os_.unmarshal_int();
/*  90 */     this.musicCfgId = _os_.unmarshal_int();
/*  91 */     this.musicTime = _os_.unmarshal_int();
/*  92 */     this.lyric = _os_.unmarshal_String("UTF-8");
/*  93 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  96 */       String _v_ = _os_.unmarshal_String("UTF-8");
/*  97 */       this.answers.add(_v_);
/*     */     }
/*  99 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 104 */     String path = dir + "mzm.gsp.activity4.confbean.SOriginalBandstandFragmentCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 108 */       all = new java.util.HashMap();
/* 109 */       SAXReader reader = new SAXReader();
/* 110 */       org.dom4j.Document doc = reader.read(new File(path));
/* 111 */       Element root = doc.getRootElement();
/* 112 */       List<?> nodeList = root.elements();
/* 113 */       int len = nodeList.size();
/* 114 */       for (int i = 0; i < len; i++)
/*     */       {
/* 116 */         Element elem = (Element)nodeList.get(i);
/* 117 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity4.confbean.SOriginalBandstandFragmentCfg"))
/*     */         {
/*     */ 
/* 120 */           SOriginalBandstandFragmentCfg obj = new SOriginalBandstandFragmentCfg();
/* 121 */           obj.loadFromXml(elem);
/* 122 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 123 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 128 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SOriginalBandstandFragmentCfg> all)
/*     */   {
/* 134 */     String path = dir + "mzm.gsp.activity4.confbean.SOriginalBandstandFragmentCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 138 */       SAXReader reader = new SAXReader();
/* 139 */       org.dom4j.Document doc = reader.read(new File(path));
/* 140 */       Element root = doc.getRootElement();
/* 141 */       List<?> nodeList = root.elements();
/* 142 */       int len = nodeList.size();
/* 143 */       for (int i = 0; i < len; i++)
/*     */       {
/* 145 */         Element elem = (Element)nodeList.get(i);
/* 146 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity4.confbean.SOriginalBandstandFragmentCfg"))
/*     */         {
/*     */ 
/* 149 */           SOriginalBandstandFragmentCfg obj = new SOriginalBandstandFragmentCfg();
/* 150 */           obj.loadFromXml(elem);
/* 151 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 152 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 157 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 163 */     all = new java.util.HashMap();
/*     */     
/* 165 */     String path = dir + "mzm.gsp.activity4.confbean.SOriginalBandstandFragmentCfg.bny";
/*     */     try
/*     */     {
/* 168 */       File file = new File(path);
/* 169 */       if (file.exists())
/*     */       {
/* 171 */         byte[] bytes = new byte['Ѐ'];
/* 172 */         FileInputStream fis = new FileInputStream(file);
/* 173 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 174 */         int len = 0;
/* 175 */         while ((len = fis.read(bytes)) > 0)
/* 176 */           baos.write(bytes, 0, len);
/* 177 */         fis.close();
/* 178 */         bytes = baos.toByteArray();
/* 179 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 180 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 182 */           _os_.unmarshal_int();
/* 183 */           _os_.unmarshal_int();
/* 184 */           _os_.unmarshal_int();
/*     */         }
/* 186 */         _os_.unmarshal_int();
/* 187 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 190 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 192 */           SOriginalBandstandFragmentCfg _v_ = new SOriginalBandstandFragmentCfg();
/* 193 */           _v_.unmarshal(_os_);
/* 194 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 195 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 200 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 205 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SOriginalBandstandFragmentCfg> all)
/*     */   {
/* 212 */     String path = dir + "mzm.gsp.activity4.confbean.SOriginalBandstandFragmentCfg.bny";
/*     */     try
/*     */     {
/* 215 */       File file = new File(path);
/* 216 */       if (file.exists())
/*     */       {
/* 218 */         byte[] bytes = new byte['Ѐ'];
/* 219 */         FileInputStream fis = new FileInputStream(file);
/* 220 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 221 */         int len = 0;
/* 222 */         while ((len = fis.read(bytes)) > 0)
/* 223 */           baos.write(bytes, 0, len);
/* 224 */         fis.close();
/* 225 */         bytes = baos.toByteArray();
/* 226 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 227 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 229 */           _os_.unmarshal_int();
/* 230 */           _os_.unmarshal_int();
/* 231 */           _os_.unmarshal_int();
/*     */         }
/* 233 */         _os_.unmarshal_int();
/* 234 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 237 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 239 */           SOriginalBandstandFragmentCfg _v_ = new SOriginalBandstandFragmentCfg();
/* 240 */           _v_.unmarshal(_os_);
/* 241 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 242 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 247 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 252 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SOriginalBandstandFragmentCfg getOld(int key)
/*     */   {
/* 260 */     return (SOriginalBandstandFragmentCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SOriginalBandstandFragmentCfg get(int key)
/*     */   {
/* 265 */     return (SOriginalBandstandFragmentCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SOriginalBandstandFragmentCfg> getOldAll()
/*     */   {
/* 270 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SOriginalBandstandFragmentCfg> getAll()
/*     */   {
/* 275 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SOriginalBandstandFragmentCfg> newAll)
/*     */   {
/* 280 */     oldAll = all;
/* 281 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 286 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity4\confbean\SOriginalBandstandFragmentCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */