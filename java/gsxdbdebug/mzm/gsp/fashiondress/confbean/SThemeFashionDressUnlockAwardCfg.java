/*     */ package mzm.gsp.fashiondress.confbean;
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
/*     */ public class SThemeFashionDressUnlockAwardCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SThemeFashionDressUnlockAwardCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SThemeFashionDressUnlockAwardCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int theme_fashion_dress_cfg_Id;
/*     */   public int unlock_fashion_dress_type_num;
/*     */   public int fix_award_id;
/*  22 */   public ArrayList<Pro2Value> proList = new ArrayList();
/*  23 */   public ArrayList<Integer> buffList = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  27 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  28 */     this.theme_fashion_dress_cfg_Id = Integer.valueOf(rootElement.attributeValue("theme_fashion_dress_cfg_Id")).intValue();
/*  29 */     this.unlock_fashion_dress_type_num = Integer.valueOf(rootElement.attributeValue("unlock_fashion_dress_type_num")).intValue();
/*  30 */     this.fix_award_id = Integer.valueOf(rootElement.attributeValue("fix_award_id")).intValue();
/*     */     
/*  32 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "proList");
/*  33 */     if (collectionElement == null)
/*     */     {
/*  35 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  38 */     List<?> _nodeList = collectionElement.elements();
/*  39 */     int _len = _nodeList.size();
/*  40 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  42 */       Element elem = (Element)_nodeList.get(i);
/*  43 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.fashiondress.confbean.Pro2Value"))
/*     */       {
/*     */         Pro2Value _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  50 */           _v_ = new Pro2Value();
/*  51 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  58 */         this.proList.add(_v_);
/*     */       }
/*     */     }
/*     */     
/*  62 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "buffList");
/*  63 */     if (collectionElement == null)
/*     */     {
/*  65 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  68 */     List<?> _nodeList = collectionElement.elements();
/*  69 */     int _len = _nodeList.size();
/*  70 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  72 */       Element elem = (Element)_nodeList.get(i);
/*  73 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  80 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  87 */         this.buffList.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  94 */     _os_.marshal(this.id);
/*  95 */     _os_.marshal(this.theme_fashion_dress_cfg_Id);
/*  96 */     _os_.marshal(this.unlock_fashion_dress_type_num);
/*  97 */     _os_.marshal(this.fix_award_id);
/*  98 */     _os_.compact_uint32(this.proList.size());
/*  99 */     for (Pro2Value _v_ : this.proList)
/*     */     {
/* 101 */       _os_.marshal(_v_);
/*     */     }
/* 103 */     _os_.compact_uint32(this.buffList.size());
/* 104 */     for (Integer _v_ : this.buffList)
/*     */     {
/* 106 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 108 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 113 */     this.id = _os_.unmarshal_int();
/* 114 */     this.theme_fashion_dress_cfg_Id = _os_.unmarshal_int();
/* 115 */     this.unlock_fashion_dress_type_num = _os_.unmarshal_int();
/* 116 */     this.fix_award_id = _os_.unmarshal_int();
/* 117 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 120 */       Pro2Value _v_ = new Pro2Value();
/* 121 */       _v_.unmarshal(_os_);
/* 122 */       this.proList.add(_v_);
/*     */     }
/* 124 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 127 */       int _v_ = _os_.unmarshal_int();
/* 128 */       this.buffList.add(Integer.valueOf(_v_));
/*     */     }
/* 130 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 135 */     String path = dir + "mzm.gsp.fashiondress.confbean.SThemeFashionDressUnlockAwardCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 139 */       all = new java.util.HashMap();
/* 140 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 141 */       org.dom4j.Document doc = reader.read(new File(path));
/* 142 */       Element root = doc.getRootElement();
/* 143 */       List<?> nodeList = root.elements();
/* 144 */       int len = nodeList.size();
/* 145 */       for (int i = 0; i < len; i++)
/*     */       {
/* 147 */         Element elem = (Element)nodeList.get(i);
/* 148 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.fashiondress.confbean.SThemeFashionDressUnlockAwardCfg"))
/*     */         {
/*     */ 
/* 151 */           SThemeFashionDressUnlockAwardCfg obj = new SThemeFashionDressUnlockAwardCfg();
/* 152 */           obj.loadFromXml(elem);
/* 153 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 154 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 159 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SThemeFashionDressUnlockAwardCfg> all)
/*     */   {
/* 165 */     String path = dir + "mzm.gsp.fashiondress.confbean.SThemeFashionDressUnlockAwardCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 169 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 170 */       org.dom4j.Document doc = reader.read(new File(path));
/* 171 */       Element root = doc.getRootElement();
/* 172 */       List<?> nodeList = root.elements();
/* 173 */       int len = nodeList.size();
/* 174 */       for (int i = 0; i < len; i++)
/*     */       {
/* 176 */         Element elem = (Element)nodeList.get(i);
/* 177 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.fashiondress.confbean.SThemeFashionDressUnlockAwardCfg"))
/*     */         {
/*     */ 
/* 180 */           SThemeFashionDressUnlockAwardCfg obj = new SThemeFashionDressUnlockAwardCfg();
/* 181 */           obj.loadFromXml(elem);
/* 182 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 183 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 188 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 194 */     all = new java.util.HashMap();
/*     */     
/* 196 */     String path = dir + "mzm.gsp.fashiondress.confbean.SThemeFashionDressUnlockAwardCfg.bny";
/*     */     try
/*     */     {
/* 199 */       File file = new File(path);
/* 200 */       if (file.exists())
/*     */       {
/* 202 */         byte[] bytes = new byte['Ѐ'];
/* 203 */         FileInputStream fis = new FileInputStream(file);
/* 204 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 205 */         int len = 0;
/* 206 */         while ((len = fis.read(bytes)) > 0)
/* 207 */           baos.write(bytes, 0, len);
/* 208 */         fis.close();
/* 209 */         bytes = baos.toByteArray();
/* 210 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 211 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 213 */           _os_.unmarshal_int();
/* 214 */           _os_.unmarshal_int();
/* 215 */           _os_.unmarshal_int();
/*     */         }
/* 217 */         _os_.unmarshal_int();
/* 218 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 221 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 223 */           SThemeFashionDressUnlockAwardCfg _v_ = new SThemeFashionDressUnlockAwardCfg();
/* 224 */           _v_.unmarshal(_os_);
/* 225 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 226 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 231 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 236 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SThemeFashionDressUnlockAwardCfg> all)
/*     */   {
/* 243 */     String path = dir + "mzm.gsp.fashiondress.confbean.SThemeFashionDressUnlockAwardCfg.bny";
/*     */     try
/*     */     {
/* 246 */       File file = new File(path);
/* 247 */       if (file.exists())
/*     */       {
/* 249 */         byte[] bytes = new byte['Ѐ'];
/* 250 */         FileInputStream fis = new FileInputStream(file);
/* 251 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 252 */         int len = 0;
/* 253 */         while ((len = fis.read(bytes)) > 0)
/* 254 */           baos.write(bytes, 0, len);
/* 255 */         fis.close();
/* 256 */         bytes = baos.toByteArray();
/* 257 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 258 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 260 */           _os_.unmarshal_int();
/* 261 */           _os_.unmarshal_int();
/* 262 */           _os_.unmarshal_int();
/*     */         }
/* 264 */         _os_.unmarshal_int();
/* 265 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 268 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 270 */           SThemeFashionDressUnlockAwardCfg _v_ = new SThemeFashionDressUnlockAwardCfg();
/* 271 */           _v_.unmarshal(_os_);
/* 272 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 273 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 278 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 283 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SThemeFashionDressUnlockAwardCfg getOld(int key)
/*     */   {
/* 291 */     return (SThemeFashionDressUnlockAwardCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SThemeFashionDressUnlockAwardCfg get(int key)
/*     */   {
/* 296 */     return (SThemeFashionDressUnlockAwardCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SThemeFashionDressUnlockAwardCfg> getOldAll()
/*     */   {
/* 301 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SThemeFashionDressUnlockAwardCfg> getAll()
/*     */   {
/* 306 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SThemeFashionDressUnlockAwardCfg> newAll)
/*     */   {
/* 311 */     oldAll = all;
/* 312 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 317 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\confbean\SThemeFashionDressUnlockAwardCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */