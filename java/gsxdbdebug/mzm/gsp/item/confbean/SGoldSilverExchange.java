/*     */ package mzm.gsp.item.confbean;
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
/*     */ public class SGoldSilverExchange implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SGoldSilverExchange> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SGoldSilverExchange> all = null;
/*     */   
/*     */   public int id;
/*     */   public int currencytype;
/*     */   public int serverlevel;
/*     */   public int value;
/*     */   public int needyuanbao;
/*     */   public String templatename;
/*     */   public int iconid;
/*     */   public int sort;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  29 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  30 */     this.currencytype = Integer.valueOf(rootElement.attributeValue("currencytype")).intValue();
/*  31 */     this.serverlevel = Integer.valueOf(rootElement.attributeValue("serverlevel")).intValue();
/*  32 */     this.value = Integer.valueOf(rootElement.attributeValue("value")).intValue();
/*  33 */     this.needyuanbao = Integer.valueOf(rootElement.attributeValue("needyuanbao")).intValue();
/*  34 */     this.templatename = rootElement.attributeValue("templatename");
/*  35 */     this.iconid = Integer.valueOf(rootElement.attributeValue("iconid")).intValue();
/*  36 */     this.sort = Integer.valueOf(rootElement.attributeValue("sort")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  41 */     _os_.marshal(this.id);
/*  42 */     _os_.marshal(this.currencytype);
/*  43 */     _os_.marshal(this.serverlevel);
/*  44 */     _os_.marshal(this.value);
/*  45 */     _os_.marshal(this.needyuanbao);
/*  46 */     _os_.marshal(this.templatename, "UTF-8");
/*  47 */     _os_.marshal(this.iconid);
/*  48 */     _os_.marshal(this.sort);
/*  49 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  54 */     this.id = _os_.unmarshal_int();
/*  55 */     this.currencytype = _os_.unmarshal_int();
/*  56 */     this.serverlevel = _os_.unmarshal_int();
/*  57 */     this.value = _os_.unmarshal_int();
/*  58 */     this.needyuanbao = _os_.unmarshal_int();
/*  59 */     this.templatename = _os_.unmarshal_String("UTF-8");
/*  60 */     this.iconid = _os_.unmarshal_int();
/*  61 */     this.sort = _os_.unmarshal_int();
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  67 */     String path = dir + "mzm.gsp.item.confbean.SGoldSilverExchange.xml";
/*     */     
/*     */     try
/*     */     {
/*  71 */       all = new java.util.HashMap();
/*  72 */       SAXReader reader = new SAXReader();
/*  73 */       org.dom4j.Document doc = reader.read(new File(path));
/*  74 */       Element root = doc.getRootElement();
/*  75 */       List<?> nodeList = root.elements();
/*  76 */       int len = nodeList.size();
/*  77 */       for (int i = 0; i < len; i++)
/*     */       {
/*  79 */         Element elem = (Element)nodeList.get(i);
/*  80 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SGoldSilverExchange"))
/*     */         {
/*     */ 
/*  83 */           SGoldSilverExchange obj = new SGoldSilverExchange();
/*  84 */           obj.loadFromXml(elem);
/*  85 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  86 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  91 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SGoldSilverExchange> all)
/*     */   {
/*  97 */     String path = dir + "mzm.gsp.item.confbean.SGoldSilverExchange.xml";
/*     */     
/*     */     try
/*     */     {
/* 101 */       SAXReader reader = new SAXReader();
/* 102 */       org.dom4j.Document doc = reader.read(new File(path));
/* 103 */       Element root = doc.getRootElement();
/* 104 */       List<?> nodeList = root.elements();
/* 105 */       int len = nodeList.size();
/* 106 */       for (int i = 0; i < len; i++)
/*     */       {
/* 108 */         Element elem = (Element)nodeList.get(i);
/* 109 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SGoldSilverExchange"))
/*     */         {
/*     */ 
/* 112 */           SGoldSilverExchange obj = new SGoldSilverExchange();
/* 113 */           obj.loadFromXml(elem);
/* 114 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 115 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 120 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 126 */     all = new java.util.HashMap();
/*     */     
/* 128 */     String path = dir + "mzm.gsp.item.confbean.SGoldSilverExchange.bny";
/*     */     try
/*     */     {
/* 131 */       File file = new File(path);
/* 132 */       if (file.exists())
/*     */       {
/* 134 */         byte[] bytes = new byte['Ѐ'];
/* 135 */         FileInputStream fis = new FileInputStream(file);
/* 136 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 137 */         int len = 0;
/* 138 */         while ((len = fis.read(bytes)) > 0)
/* 139 */           baos.write(bytes, 0, len);
/* 140 */         fis.close();
/* 141 */         bytes = baos.toByteArray();
/* 142 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 143 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 145 */           _os_.unmarshal_int();
/* 146 */           _os_.unmarshal_int();
/* 147 */           _os_.unmarshal_int();
/*     */         }
/* 149 */         _os_.unmarshal_int();
/* 150 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 153 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 155 */           SGoldSilverExchange _v_ = new SGoldSilverExchange();
/* 156 */           _v_.unmarshal(_os_);
/* 157 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 158 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 163 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 168 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SGoldSilverExchange> all)
/*     */   {
/* 175 */     String path = dir + "mzm.gsp.item.confbean.SGoldSilverExchange.bny";
/*     */     try
/*     */     {
/* 178 */       File file = new File(path);
/* 179 */       if (file.exists())
/*     */       {
/* 181 */         byte[] bytes = new byte['Ѐ'];
/* 182 */         FileInputStream fis = new FileInputStream(file);
/* 183 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 184 */         int len = 0;
/* 185 */         while ((len = fis.read(bytes)) > 0)
/* 186 */           baos.write(bytes, 0, len);
/* 187 */         fis.close();
/* 188 */         bytes = baos.toByteArray();
/* 189 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 190 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 192 */           _os_.unmarshal_int();
/* 193 */           _os_.unmarshal_int();
/* 194 */           _os_.unmarshal_int();
/*     */         }
/* 196 */         _os_.unmarshal_int();
/* 197 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 200 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 202 */           SGoldSilverExchange _v_ = new SGoldSilverExchange();
/* 203 */           _v_.unmarshal(_os_);
/* 204 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 205 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 210 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 215 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SGoldSilverExchange getOld(int key)
/*     */   {
/* 223 */     return (SGoldSilverExchange)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SGoldSilverExchange get(int key)
/*     */   {
/* 228 */     return (SGoldSilverExchange)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SGoldSilverExchange> getOldAll()
/*     */   {
/* 233 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SGoldSilverExchange> getAll()
/*     */   {
/* 238 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SGoldSilverExchange> newAll)
/*     */   {
/* 243 */     oldAll = all;
/* 244 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 249 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\SGoldSilverExchange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */