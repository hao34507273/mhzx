/*     */ package mzm.gsp.legoushangcheng.confbean;
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
/*     */ public class LeGouShangChengGoodsCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, LeGouShangChengGoodsCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, LeGouShangChengGoodsCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int isShowDiscount;
/*     */   public int fix_award_Id;
/*     */   public int buy_top_limit;
/*     */   public int base_price;
/*     */   public int sale_rate;
/*     */   public int cost_currency_type;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  28 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  29 */     this.isShowDiscount = Integer.valueOf(rootElement.attributeValue("isShowDiscount")).intValue();
/*  30 */     this.fix_award_Id = Integer.valueOf(rootElement.attributeValue("fix_award_Id")).intValue();
/*  31 */     this.buy_top_limit = Integer.valueOf(rootElement.attributeValue("buy_top_limit")).intValue();
/*  32 */     this.base_price = Integer.valueOf(rootElement.attributeValue("base_price")).intValue();
/*  33 */     this.sale_rate = Integer.valueOf(rootElement.attributeValue("sale_rate")).intValue();
/*  34 */     this.cost_currency_type = Integer.valueOf(rootElement.attributeValue("cost_currency_type")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  39 */     _os_.marshal(this.id);
/*  40 */     _os_.marshal(this.isShowDiscount);
/*  41 */     _os_.marshal(this.fix_award_Id);
/*  42 */     _os_.marshal(this.buy_top_limit);
/*  43 */     _os_.marshal(this.base_price);
/*  44 */     _os_.marshal(this.sale_rate);
/*  45 */     _os_.marshal(this.cost_currency_type);
/*  46 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  51 */     this.id = _os_.unmarshal_int();
/*  52 */     this.isShowDiscount = _os_.unmarshal_int();
/*  53 */     this.fix_award_Id = _os_.unmarshal_int();
/*  54 */     this.buy_top_limit = _os_.unmarshal_int();
/*  55 */     this.base_price = _os_.unmarshal_int();
/*  56 */     this.sale_rate = _os_.unmarshal_int();
/*  57 */     this.cost_currency_type = _os_.unmarshal_int();
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  63 */     String path = dir + "mzm.gsp.legoushangcheng.confbean.LeGouShangChengGoodsCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  67 */       all = new java.util.HashMap();
/*  68 */       SAXReader reader = new SAXReader();
/*  69 */       org.dom4j.Document doc = reader.read(new File(path));
/*  70 */       Element root = doc.getRootElement();
/*  71 */       List<?> nodeList = root.elements();
/*  72 */       int len = nodeList.size();
/*  73 */       for (int i = 0; i < len; i++)
/*     */       {
/*  75 */         Element elem = (Element)nodeList.get(i);
/*  76 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.legoushangcheng.confbean.LeGouShangChengGoodsCfg"))
/*     */         {
/*     */ 
/*  79 */           LeGouShangChengGoodsCfg obj = new LeGouShangChengGoodsCfg();
/*  80 */           obj.loadFromXml(elem);
/*  81 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  82 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  87 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, LeGouShangChengGoodsCfg> all)
/*     */   {
/*  93 */     String path = dir + "mzm.gsp.legoushangcheng.confbean.LeGouShangChengGoodsCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  97 */       SAXReader reader = new SAXReader();
/*  98 */       org.dom4j.Document doc = reader.read(new File(path));
/*  99 */       Element root = doc.getRootElement();
/* 100 */       List<?> nodeList = root.elements();
/* 101 */       int len = nodeList.size();
/* 102 */       for (int i = 0; i < len; i++)
/*     */       {
/* 104 */         Element elem = (Element)nodeList.get(i);
/* 105 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.legoushangcheng.confbean.LeGouShangChengGoodsCfg"))
/*     */         {
/*     */ 
/* 108 */           LeGouShangChengGoodsCfg obj = new LeGouShangChengGoodsCfg();
/* 109 */           obj.loadFromXml(elem);
/* 110 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 111 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 116 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 122 */     all = new java.util.HashMap();
/*     */     
/* 124 */     String path = dir + "mzm.gsp.legoushangcheng.confbean.LeGouShangChengGoodsCfg.bny";
/*     */     try
/*     */     {
/* 127 */       File file = new File(path);
/* 128 */       if (file.exists())
/*     */       {
/* 130 */         byte[] bytes = new byte['Ѐ'];
/* 131 */         FileInputStream fis = new FileInputStream(file);
/* 132 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 133 */         int len = 0;
/* 134 */         while ((len = fis.read(bytes)) > 0)
/* 135 */           baos.write(bytes, 0, len);
/* 136 */         fis.close();
/* 137 */         bytes = baos.toByteArray();
/* 138 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 139 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 141 */           _os_.unmarshal_int();
/* 142 */           _os_.unmarshal_int();
/* 143 */           _os_.unmarshal_int();
/*     */         }
/* 145 */         _os_.unmarshal_int();
/* 146 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 149 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 151 */           LeGouShangChengGoodsCfg _v_ = new LeGouShangChengGoodsCfg();
/* 152 */           _v_.unmarshal(_os_);
/* 153 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 154 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 159 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 164 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, LeGouShangChengGoodsCfg> all)
/*     */   {
/* 171 */     String path = dir + "mzm.gsp.legoushangcheng.confbean.LeGouShangChengGoodsCfg.bny";
/*     */     try
/*     */     {
/* 174 */       File file = new File(path);
/* 175 */       if (file.exists())
/*     */       {
/* 177 */         byte[] bytes = new byte['Ѐ'];
/* 178 */         FileInputStream fis = new FileInputStream(file);
/* 179 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 180 */         int len = 0;
/* 181 */         while ((len = fis.read(bytes)) > 0)
/* 182 */           baos.write(bytes, 0, len);
/* 183 */         fis.close();
/* 184 */         bytes = baos.toByteArray();
/* 185 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 186 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 188 */           _os_.unmarshal_int();
/* 189 */           _os_.unmarshal_int();
/* 190 */           _os_.unmarshal_int();
/*     */         }
/* 192 */         _os_.unmarshal_int();
/* 193 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 196 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 198 */           LeGouShangChengGoodsCfg _v_ = new LeGouShangChengGoodsCfg();
/* 199 */           _v_.unmarshal(_os_);
/* 200 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 201 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 206 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 211 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static LeGouShangChengGoodsCfg getOld(int key)
/*     */   {
/* 219 */     return (LeGouShangChengGoodsCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static LeGouShangChengGoodsCfg get(int key)
/*     */   {
/* 224 */     return (LeGouShangChengGoodsCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, LeGouShangChengGoodsCfg> getOldAll()
/*     */   {
/* 229 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, LeGouShangChengGoodsCfg> getAll()
/*     */   {
/* 234 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, LeGouShangChengGoodsCfg> newAll)
/*     */   {
/* 239 */     oldAll = all;
/* 240 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 245 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\legoushangcheng\confbean\LeGouShangChengGoodsCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */