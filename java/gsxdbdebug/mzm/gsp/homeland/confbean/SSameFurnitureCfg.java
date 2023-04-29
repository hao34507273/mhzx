/*     */ package mzm.gsp.homeland.confbean;
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
/*     */ public class SSameFurnitureCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SSameFurnitureCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SSameFurnitureCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int maxAddFengShui;
/*     */   public int max_add_beautiful_furniture_num;
/*  21 */   public java.util.ArrayList<Integer> itemIds = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  25 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  26 */     this.maxAddFengShui = Integer.valueOf(rootElement.attributeValue("maxAddFengShui")).intValue();
/*  27 */     this.max_add_beautiful_furniture_num = Integer.valueOf(rootElement.attributeValue("max_add_beautiful_furniture_num")).intValue();
/*     */     
/*  29 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "itemIds");
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
/*  40 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  47 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  54 */         this.itemIds.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  61 */     _os_.marshal(this.id);
/*  62 */     _os_.marshal(this.maxAddFengShui);
/*  63 */     _os_.marshal(this.max_add_beautiful_furniture_num);
/*  64 */     _os_.compact_uint32(this.itemIds.size());
/*  65 */     for (Integer _v_ : this.itemIds)
/*     */     {
/*  67 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  74 */     this.id = _os_.unmarshal_int();
/*  75 */     this.maxAddFengShui = _os_.unmarshal_int();
/*  76 */     this.max_add_beautiful_furniture_num = _os_.unmarshal_int();
/*  77 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  80 */       int _v_ = _os_.unmarshal_int();
/*  81 */       this.itemIds.add(Integer.valueOf(_v_));
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  88 */     String path = dir + "mzm.gsp.homeland.confbean.SSameFurnitureCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  92 */       all = new java.util.HashMap();
/*  93 */       SAXReader reader = new SAXReader();
/*  94 */       org.dom4j.Document doc = reader.read(new File(path));
/*  95 */       Element root = doc.getRootElement();
/*  96 */       List<?> nodeList = root.elements();
/*  97 */       int len = nodeList.size();
/*  98 */       for (int i = 0; i < len; i++)
/*     */       {
/* 100 */         Element elem = (Element)nodeList.get(i);
/* 101 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.homeland.confbean.SSameFurnitureCfg"))
/*     */         {
/*     */ 
/* 104 */           SSameFurnitureCfg obj = new SSameFurnitureCfg();
/* 105 */           obj.loadFromXml(elem);
/* 106 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 107 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 112 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SSameFurnitureCfg> all)
/*     */   {
/* 118 */     String path = dir + "mzm.gsp.homeland.confbean.SSameFurnitureCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 122 */       SAXReader reader = new SAXReader();
/* 123 */       org.dom4j.Document doc = reader.read(new File(path));
/* 124 */       Element root = doc.getRootElement();
/* 125 */       List<?> nodeList = root.elements();
/* 126 */       int len = nodeList.size();
/* 127 */       for (int i = 0; i < len; i++)
/*     */       {
/* 129 */         Element elem = (Element)nodeList.get(i);
/* 130 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.homeland.confbean.SSameFurnitureCfg"))
/*     */         {
/*     */ 
/* 133 */           SSameFurnitureCfg obj = new SSameFurnitureCfg();
/* 134 */           obj.loadFromXml(elem);
/* 135 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 136 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 141 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 147 */     all = new java.util.HashMap();
/*     */     
/* 149 */     String path = dir + "mzm.gsp.homeland.confbean.SSameFurnitureCfg.bny";
/*     */     try
/*     */     {
/* 152 */       File file = new File(path);
/* 153 */       if (file.exists())
/*     */       {
/* 155 */         byte[] bytes = new byte['Ѐ'];
/* 156 */         FileInputStream fis = new FileInputStream(file);
/* 157 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 158 */         int len = 0;
/* 159 */         while ((len = fis.read(bytes)) > 0)
/* 160 */           baos.write(bytes, 0, len);
/* 161 */         fis.close();
/* 162 */         bytes = baos.toByteArray();
/* 163 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 164 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 166 */           _os_.unmarshal_int();
/* 167 */           _os_.unmarshal_int();
/* 168 */           _os_.unmarshal_int();
/*     */         }
/* 170 */         _os_.unmarshal_int();
/* 171 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 174 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 176 */           SSameFurnitureCfg _v_ = new SSameFurnitureCfg();
/* 177 */           _v_.unmarshal(_os_);
/* 178 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 179 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 184 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 189 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SSameFurnitureCfg> all)
/*     */   {
/* 196 */     String path = dir + "mzm.gsp.homeland.confbean.SSameFurnitureCfg.bny";
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
/* 223 */           SSameFurnitureCfg _v_ = new SSameFurnitureCfg();
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
/*     */ 
/*     */   public static SSameFurnitureCfg getOld(int key)
/*     */   {
/* 244 */     return (SSameFurnitureCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SSameFurnitureCfg get(int key)
/*     */   {
/* 249 */     return (SSameFurnitureCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SSameFurnitureCfg> getOldAll()
/*     */   {
/* 254 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SSameFurnitureCfg> getAll()
/*     */   {
/* 259 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SSameFurnitureCfg> newAll)
/*     */   {
/* 264 */     oldAll = all;
/* 265 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 270 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\confbean\SSameFurnitureCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */