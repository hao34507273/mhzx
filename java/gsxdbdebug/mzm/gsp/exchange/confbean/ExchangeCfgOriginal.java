/*     */ package mzm.gsp.exchange.confbean;
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
/*     */ public class ExchangeCfgOriginal implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, ExchangeCfgOriginal> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, ExchangeCfgOriginal> all = null;
/*     */   
/*     */   public int id;
/*     */   public int activity_cfg_id;
/*     */   public int moduleid;
/*     */   public int page_cfg_id;
/*     */   public int display_sort_id;
/*     */   public int sort_id;
/*     */   public int exchange_type;
/*     */   public int max_exchange_num;
/*     */   public int award_cfg_id;
/*     */   public boolean is_open;
/*  28 */   public java.util.ArrayList<NeedItemInfo> need_item_info_list = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  32 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  33 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  34 */     this.moduleid = Integer.valueOf(rootElement.attributeValue("moduleid")).intValue();
/*  35 */     this.page_cfg_id = Integer.valueOf(rootElement.attributeValue("page_cfg_id")).intValue();
/*  36 */     this.display_sort_id = Integer.valueOf(rootElement.attributeValue("display_sort_id")).intValue();
/*  37 */     this.sort_id = Integer.valueOf(rootElement.attributeValue("sort_id")).intValue();
/*  38 */     this.exchange_type = Integer.valueOf(rootElement.attributeValue("exchange_type")).intValue();
/*  39 */     this.max_exchange_num = Integer.valueOf(rootElement.attributeValue("max_exchange_num")).intValue();
/*  40 */     this.award_cfg_id = Integer.valueOf(rootElement.attributeValue("award_cfg_id")).intValue();
/*  41 */     this.is_open = Boolean.valueOf(rootElement.attributeValue("is_open")).booleanValue();
/*     */     
/*  43 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "need_item_info_list");
/*  44 */     if (collectionElement == null)
/*     */     {
/*  46 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  49 */     List<?> _nodeList = collectionElement.elements();
/*  50 */     int _len = _nodeList.size();
/*  51 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  53 */       Element elem = (Element)_nodeList.get(i);
/*  54 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.exchange.confbean.NeedItemInfo"))
/*     */       {
/*     */         NeedItemInfo _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  61 */           _v_ = new NeedItemInfo();
/*  62 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  69 */         this.need_item_info_list.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  76 */     _os_.marshal(this.id);
/*  77 */     _os_.marshal(this.activity_cfg_id);
/*  78 */     _os_.marshal(this.moduleid);
/*  79 */     _os_.marshal(this.page_cfg_id);
/*  80 */     _os_.marshal(this.display_sort_id);
/*  81 */     _os_.marshal(this.sort_id);
/*  82 */     _os_.marshal(this.exchange_type);
/*  83 */     _os_.marshal(this.max_exchange_num);
/*  84 */     _os_.marshal(this.award_cfg_id);
/*  85 */     _os_.marshal(this.is_open);
/*  86 */     _os_.compact_uint32(this.need_item_info_list.size());
/*  87 */     for (NeedItemInfo _v_ : this.need_item_info_list)
/*     */     {
/*  89 */       _os_.marshal(_v_);
/*     */     }
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  96 */     this.id = _os_.unmarshal_int();
/*  97 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  98 */     this.moduleid = _os_.unmarshal_int();
/*  99 */     this.page_cfg_id = _os_.unmarshal_int();
/* 100 */     this.display_sort_id = _os_.unmarshal_int();
/* 101 */     this.sort_id = _os_.unmarshal_int();
/* 102 */     this.exchange_type = _os_.unmarshal_int();
/* 103 */     this.max_exchange_num = _os_.unmarshal_int();
/* 104 */     this.award_cfg_id = _os_.unmarshal_int();
/* 105 */     this.is_open = _os_.unmarshal_boolean();
/* 106 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 109 */       NeedItemInfo _v_ = new NeedItemInfo();
/* 110 */       _v_.unmarshal(_os_);
/* 111 */       this.need_item_info_list.add(_v_);
/*     */     }
/* 113 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 118 */     String path = dir + "mzm.gsp.exchange.confbean.ExchangeCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 122 */       all = new java.util.HashMap();
/* 123 */       SAXReader reader = new SAXReader();
/* 124 */       org.dom4j.Document doc = reader.read(new File(path));
/* 125 */       Element root = doc.getRootElement();
/* 126 */       List<?> nodeList = root.elements();
/* 127 */       int len = nodeList.size();
/* 128 */       for (int i = 0; i < len; i++)
/*     */       {
/* 130 */         Element elem = (Element)nodeList.get(i);
/* 131 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.exchange.confbean.ExchangeCfgOriginal"))
/*     */         {
/*     */ 
/* 134 */           ExchangeCfgOriginal obj = new ExchangeCfgOriginal();
/* 135 */           obj.loadFromXml(elem);
/* 136 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 137 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 142 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, ExchangeCfgOriginal> all)
/*     */   {
/* 148 */     String path = dir + "mzm.gsp.exchange.confbean.ExchangeCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 152 */       SAXReader reader = new SAXReader();
/* 153 */       org.dom4j.Document doc = reader.read(new File(path));
/* 154 */       Element root = doc.getRootElement();
/* 155 */       List<?> nodeList = root.elements();
/* 156 */       int len = nodeList.size();
/* 157 */       for (int i = 0; i < len; i++)
/*     */       {
/* 159 */         Element elem = (Element)nodeList.get(i);
/* 160 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.exchange.confbean.ExchangeCfgOriginal"))
/*     */         {
/*     */ 
/* 163 */           ExchangeCfgOriginal obj = new ExchangeCfgOriginal();
/* 164 */           obj.loadFromXml(elem);
/* 165 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 166 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 171 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 177 */     all = new java.util.HashMap();
/*     */     
/* 179 */     String path = dir + "mzm.gsp.exchange.confbean.ExchangeCfgOriginal.bny";
/*     */     try
/*     */     {
/* 182 */       File file = new File(path);
/* 183 */       if (file.exists())
/*     */       {
/* 185 */         byte[] bytes = new byte['Ѐ'];
/* 186 */         FileInputStream fis = new FileInputStream(file);
/* 187 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 188 */         int len = 0;
/* 189 */         while ((len = fis.read(bytes)) > 0)
/* 190 */           baos.write(bytes, 0, len);
/* 191 */         fis.close();
/* 192 */         bytes = baos.toByteArray();
/* 193 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 194 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 196 */           _os_.unmarshal_int();
/* 197 */           _os_.unmarshal_int();
/* 198 */           _os_.unmarshal_int();
/*     */         }
/* 200 */         _os_.unmarshal_int();
/* 201 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 204 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 206 */           ExchangeCfgOriginal _v_ = new ExchangeCfgOriginal();
/* 207 */           _v_.unmarshal(_os_);
/* 208 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 209 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 214 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 219 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, ExchangeCfgOriginal> all)
/*     */   {
/* 226 */     String path = dir + "mzm.gsp.exchange.confbean.ExchangeCfgOriginal.bny";
/*     */     try
/*     */     {
/* 229 */       File file = new File(path);
/* 230 */       if (file.exists())
/*     */       {
/* 232 */         byte[] bytes = new byte['Ѐ'];
/* 233 */         FileInputStream fis = new FileInputStream(file);
/* 234 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 235 */         int len = 0;
/* 236 */         while ((len = fis.read(bytes)) > 0)
/* 237 */           baos.write(bytes, 0, len);
/* 238 */         fis.close();
/* 239 */         bytes = baos.toByteArray();
/* 240 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 241 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 243 */           _os_.unmarshal_int();
/* 244 */           _os_.unmarshal_int();
/* 245 */           _os_.unmarshal_int();
/*     */         }
/* 247 */         _os_.unmarshal_int();
/* 248 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 251 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 253 */           ExchangeCfgOriginal _v_ = new ExchangeCfgOriginal();
/* 254 */           _v_.unmarshal(_os_);
/* 255 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 256 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 261 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 266 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static ExchangeCfgOriginal getOld(int key)
/*     */   {
/* 274 */     return (ExchangeCfgOriginal)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static ExchangeCfgOriginal get(int key)
/*     */   {
/* 279 */     return (ExchangeCfgOriginal)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, ExchangeCfgOriginal> getOldAll()
/*     */   {
/* 284 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, ExchangeCfgOriginal> getAll()
/*     */   {
/* 289 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, ExchangeCfgOriginal> newAll)
/*     */   {
/* 294 */     oldAll = all;
/* 295 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 300 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\exchange\confbean\ExchangeCfgOriginal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */