/*     */ package mzm.gsp.resourcecheck.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class BindYuanbaoAwardWhiteList implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, BindYuanbaoAwardWhiteList> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, BindYuanbaoAwardWhiteList> all = null;
/*     */   
/*     */   public int log_reason;
/*  19 */   public HashSet<Integer> award_cfgids = new HashSet();
/*  20 */   public HashSet<Integer> fix_award_cfgids = new HashSet();
/*  21 */   public HashSet<Integer> award_pool_cfgids = new HashSet();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  25 */     this.log_reason = Integer.valueOf(rootElement.attributeValue("log_reason")).intValue();
/*     */     
/*  27 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "award_cfgids");
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
/*  38 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  45 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  52 */         this.award_cfgids.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  56 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "fix_award_cfgids");
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
/*  81 */         this.fix_award_cfgids.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  85 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "award_pool_cfgids");
/*  86 */     if (collectionElement == null)
/*     */     {
/*  88 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  91 */     List<?> _nodeList = collectionElement.elements();
/*  92 */     int _len = _nodeList.size();
/*  93 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  95 */       Element elem = (Element)_nodeList.get(i);
/*  96 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 103 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 110 */         this.award_pool_cfgids.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 117 */     _os_.marshal(this.log_reason);
/* 118 */     _os_.compact_uint32(this.award_cfgids.size());
/* 119 */     for (Integer _v_ : this.award_cfgids)
/*     */     {
/* 121 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 123 */     _os_.compact_uint32(this.fix_award_cfgids.size());
/* 124 */     for (Integer _v_ : this.fix_award_cfgids)
/*     */     {
/* 126 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 128 */     _os_.compact_uint32(this.award_pool_cfgids.size());
/* 129 */     for (Integer _v_ : this.award_pool_cfgids)
/*     */     {
/* 131 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 133 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 138 */     this.log_reason = _os_.unmarshal_int();
/* 139 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 142 */       int _v_ = _os_.unmarshal_int();
/* 143 */       this.award_cfgids.add(Integer.valueOf(_v_));
/*     */     }
/* 145 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 148 */       int _v_ = _os_.unmarshal_int();
/* 149 */       this.fix_award_cfgids.add(Integer.valueOf(_v_));
/*     */     }
/* 151 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 154 */       int _v_ = _os_.unmarshal_int();
/* 155 */       this.award_pool_cfgids.add(Integer.valueOf(_v_));
/*     */     }
/* 157 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 162 */     String path = dir + "mzm.gsp.resourcecheck.confbean.BindYuanbaoAwardWhiteList.xml";
/*     */     
/*     */     try
/*     */     {
/* 166 */       all = new java.util.HashMap();
/* 167 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 168 */       org.dom4j.Document doc = reader.read(new File(path));
/* 169 */       Element root = doc.getRootElement();
/* 170 */       List<?> nodeList = root.elements();
/* 171 */       int len = nodeList.size();
/* 172 */       for (int i = 0; i < len; i++)
/*     */       {
/* 174 */         Element elem = (Element)nodeList.get(i);
/* 175 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.resourcecheck.confbean.BindYuanbaoAwardWhiteList"))
/*     */         {
/*     */ 
/* 178 */           BindYuanbaoAwardWhiteList obj = new BindYuanbaoAwardWhiteList();
/* 179 */           obj.loadFromXml(elem);
/* 180 */           if (all.put(Integer.valueOf(obj.log_reason), obj) != null) {
/* 181 */             throw new RuntimeException("duplicate key : " + obj.log_reason);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 186 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, BindYuanbaoAwardWhiteList> all)
/*     */   {
/* 192 */     String path = dir + "mzm.gsp.resourcecheck.confbean.BindYuanbaoAwardWhiteList.xml";
/*     */     
/*     */     try
/*     */     {
/* 196 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 197 */       org.dom4j.Document doc = reader.read(new File(path));
/* 198 */       Element root = doc.getRootElement();
/* 199 */       List<?> nodeList = root.elements();
/* 200 */       int len = nodeList.size();
/* 201 */       for (int i = 0; i < len; i++)
/*     */       {
/* 203 */         Element elem = (Element)nodeList.get(i);
/* 204 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.resourcecheck.confbean.BindYuanbaoAwardWhiteList"))
/*     */         {
/*     */ 
/* 207 */           BindYuanbaoAwardWhiteList obj = new BindYuanbaoAwardWhiteList();
/* 208 */           obj.loadFromXml(elem);
/* 209 */           if (all.put(Integer.valueOf(obj.log_reason), obj) != null) {
/* 210 */             throw new RuntimeException("duplicate key : " + obj.log_reason);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 215 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 221 */     all = new java.util.HashMap();
/*     */     
/* 223 */     String path = dir + "mzm.gsp.resourcecheck.confbean.BindYuanbaoAwardWhiteList.bny";
/*     */     try
/*     */     {
/* 226 */       File file = new File(path);
/* 227 */       if (file.exists())
/*     */       {
/* 229 */         byte[] bytes = new byte['Ѐ'];
/* 230 */         FileInputStream fis = new FileInputStream(file);
/* 231 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 232 */         int len = 0;
/* 233 */         while ((len = fis.read(bytes)) > 0)
/* 234 */           baos.write(bytes, 0, len);
/* 235 */         fis.close();
/* 236 */         bytes = baos.toByteArray();
/* 237 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 238 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 240 */           _os_.unmarshal_int();
/* 241 */           _os_.unmarshal_int();
/* 242 */           _os_.unmarshal_int();
/*     */         }
/* 244 */         _os_.unmarshal_int();
/* 245 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 248 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 250 */           BindYuanbaoAwardWhiteList _v_ = new BindYuanbaoAwardWhiteList();
/* 251 */           _v_.unmarshal(_os_);
/* 252 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 253 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 258 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 263 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, BindYuanbaoAwardWhiteList> all)
/*     */   {
/* 270 */     String path = dir + "mzm.gsp.resourcecheck.confbean.BindYuanbaoAwardWhiteList.bny";
/*     */     try
/*     */     {
/* 273 */       File file = new File(path);
/* 274 */       if (file.exists())
/*     */       {
/* 276 */         byte[] bytes = new byte['Ѐ'];
/* 277 */         FileInputStream fis = new FileInputStream(file);
/* 278 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 279 */         int len = 0;
/* 280 */         while ((len = fis.read(bytes)) > 0)
/* 281 */           baos.write(bytes, 0, len);
/* 282 */         fis.close();
/* 283 */         bytes = baos.toByteArray();
/* 284 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 285 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 287 */           _os_.unmarshal_int();
/* 288 */           _os_.unmarshal_int();
/* 289 */           _os_.unmarshal_int();
/*     */         }
/* 291 */         _os_.unmarshal_int();
/* 292 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 295 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 297 */           BindYuanbaoAwardWhiteList _v_ = new BindYuanbaoAwardWhiteList();
/* 298 */           _v_.unmarshal(_os_);
/* 299 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 300 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 305 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 310 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static BindYuanbaoAwardWhiteList getOld(int key)
/*     */   {
/* 318 */     return (BindYuanbaoAwardWhiteList)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static BindYuanbaoAwardWhiteList get(int key)
/*     */   {
/* 323 */     return (BindYuanbaoAwardWhiteList)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, BindYuanbaoAwardWhiteList> getOldAll()
/*     */   {
/* 328 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, BindYuanbaoAwardWhiteList> getAll()
/*     */   {
/* 333 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, BindYuanbaoAwardWhiteList> newAll)
/*     */   {
/* 338 */     oldAll = all;
/* 339 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 344 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\resourcecheck\confbean\BindYuanbaoAwardWhiteList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */