/*     */ package mzm.gsp.award.confbean;
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
/*     */ public class SAwardMoney implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SAwardMoney> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SAwardMoney> all = null;
/*     */   
/*     */   public int id;
/*     */   public String templatename;
/*     */   public int awardId;
/*     */   public int levelType;
/*     */   public int levelMin;
/*     */   public int levelMax;
/*  24 */   public ArrayList<MoneyBean> moneyBean = new ArrayList();
/*  25 */   public ArrayList<TokenBean> tokenBean = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  29 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  30 */     this.templatename = rootElement.attributeValue("templatename");
/*  31 */     this.awardId = Integer.valueOf(rootElement.attributeValue("awardId")).intValue();
/*  32 */     this.levelType = Integer.valueOf(rootElement.attributeValue("levelType")).intValue();
/*  33 */     this.levelMin = Integer.valueOf(rootElement.attributeValue("levelMin")).intValue();
/*  34 */     this.levelMax = Integer.valueOf(rootElement.attributeValue("levelMax")).intValue();
/*     */     
/*  36 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "moneyBean");
/*  37 */     if (collectionElement == null)
/*     */     {
/*  39 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  42 */     List<?> _nodeList = collectionElement.elements();
/*  43 */     int _len = _nodeList.size();
/*  44 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  46 */       Element elem = (Element)_nodeList.get(i);
/*  47 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.MoneyBean"))
/*     */       {
/*     */         MoneyBean _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  54 */           _v_ = new MoneyBean();
/*  55 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  62 */         this.moneyBean.add(_v_);
/*     */       }
/*     */     }
/*     */     
/*  66 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "tokenBean");
/*  67 */     if (collectionElement == null)
/*     */     {
/*  69 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  72 */     List<?> _nodeList = collectionElement.elements();
/*  73 */     int _len = _nodeList.size();
/*  74 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  76 */       Element elem = (Element)_nodeList.get(i);
/*  77 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.TokenBean"))
/*     */       {
/*     */         TokenBean _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  84 */           _v_ = new TokenBean();
/*  85 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  92 */         this.tokenBean.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  99 */     _os_.marshal(this.id);
/* 100 */     _os_.marshal(this.templatename, "UTF-8");
/* 101 */     _os_.marshal(this.awardId);
/* 102 */     _os_.marshal(this.levelType);
/* 103 */     _os_.marshal(this.levelMin);
/* 104 */     _os_.marshal(this.levelMax);
/* 105 */     _os_.compact_uint32(this.moneyBean.size());
/* 106 */     for (MoneyBean _v_ : this.moneyBean)
/*     */     {
/* 108 */       _os_.marshal(_v_);
/*     */     }
/* 110 */     _os_.compact_uint32(this.tokenBean.size());
/* 111 */     for (TokenBean _v_ : this.tokenBean)
/*     */     {
/* 113 */       _os_.marshal(_v_);
/*     */     }
/* 115 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 120 */     this.id = _os_.unmarshal_int();
/* 121 */     this.templatename = _os_.unmarshal_String("UTF-8");
/* 122 */     this.awardId = _os_.unmarshal_int();
/* 123 */     this.levelType = _os_.unmarshal_int();
/* 124 */     this.levelMin = _os_.unmarshal_int();
/* 125 */     this.levelMax = _os_.unmarshal_int();
/* 126 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 129 */       MoneyBean _v_ = new MoneyBean();
/* 130 */       _v_.unmarshal(_os_);
/* 131 */       this.moneyBean.add(_v_);
/*     */     }
/* 133 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 136 */       TokenBean _v_ = new TokenBean();
/* 137 */       _v_.unmarshal(_os_);
/* 138 */       this.tokenBean.add(_v_);
/*     */     }
/* 140 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 145 */     String path = dir + "mzm.gsp.award.confbean.SAwardMoney.xml";
/*     */     
/*     */     try
/*     */     {
/* 149 */       all = new java.util.HashMap();
/* 150 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 151 */       org.dom4j.Document doc = reader.read(new File(path));
/* 152 */       Element root = doc.getRootElement();
/* 153 */       List<?> nodeList = root.elements();
/* 154 */       int len = nodeList.size();
/* 155 */       for (int i = 0; i < len; i++)
/*     */       {
/* 157 */         Element elem = (Element)nodeList.get(i);
/* 158 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.SAwardMoney"))
/*     */         {
/*     */ 
/* 161 */           SAwardMoney obj = new SAwardMoney();
/* 162 */           obj.loadFromXml(elem);
/* 163 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 164 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 169 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SAwardMoney> all)
/*     */   {
/* 175 */     String path = dir + "mzm.gsp.award.confbean.SAwardMoney.xml";
/*     */     
/*     */     try
/*     */     {
/* 179 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 180 */       org.dom4j.Document doc = reader.read(new File(path));
/* 181 */       Element root = doc.getRootElement();
/* 182 */       List<?> nodeList = root.elements();
/* 183 */       int len = nodeList.size();
/* 184 */       for (int i = 0; i < len; i++)
/*     */       {
/* 186 */         Element elem = (Element)nodeList.get(i);
/* 187 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.SAwardMoney"))
/*     */         {
/*     */ 
/* 190 */           SAwardMoney obj = new SAwardMoney();
/* 191 */           obj.loadFromXml(elem);
/* 192 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 193 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 198 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 204 */     all = new java.util.HashMap();
/*     */     
/* 206 */     String path = dir + "mzm.gsp.award.confbean.SAwardMoney.bny";
/*     */     try
/*     */     {
/* 209 */       File file = new File(path);
/* 210 */       if (file.exists())
/*     */       {
/* 212 */         byte[] bytes = new byte['Ѐ'];
/* 213 */         FileInputStream fis = new FileInputStream(file);
/* 214 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 215 */         int len = 0;
/* 216 */         while ((len = fis.read(bytes)) > 0)
/* 217 */           baos.write(bytes, 0, len);
/* 218 */         fis.close();
/* 219 */         bytes = baos.toByteArray();
/* 220 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 221 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 223 */           _os_.unmarshal_int();
/* 224 */           _os_.unmarshal_int();
/* 225 */           _os_.unmarshal_int();
/*     */         }
/* 227 */         _os_.unmarshal_int();
/* 228 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 231 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 233 */           SAwardMoney _v_ = new SAwardMoney();
/* 234 */           _v_.unmarshal(_os_);
/* 235 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 236 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 241 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 246 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SAwardMoney> all)
/*     */   {
/* 253 */     String path = dir + "mzm.gsp.award.confbean.SAwardMoney.bny";
/*     */     try
/*     */     {
/* 256 */       File file = new File(path);
/* 257 */       if (file.exists())
/*     */       {
/* 259 */         byte[] bytes = new byte['Ѐ'];
/* 260 */         FileInputStream fis = new FileInputStream(file);
/* 261 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 262 */         int len = 0;
/* 263 */         while ((len = fis.read(bytes)) > 0)
/* 264 */           baos.write(bytes, 0, len);
/* 265 */         fis.close();
/* 266 */         bytes = baos.toByteArray();
/* 267 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 268 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 270 */           _os_.unmarshal_int();
/* 271 */           _os_.unmarshal_int();
/* 272 */           _os_.unmarshal_int();
/*     */         }
/* 274 */         _os_.unmarshal_int();
/* 275 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 278 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 280 */           SAwardMoney _v_ = new SAwardMoney();
/* 281 */           _v_.unmarshal(_os_);
/* 282 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 283 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 288 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 293 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SAwardMoney getOld(int key)
/*     */   {
/* 301 */     return (SAwardMoney)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SAwardMoney get(int key)
/*     */   {
/* 306 */     return (SAwardMoney)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SAwardMoney> getOldAll()
/*     */   {
/* 311 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SAwardMoney> getAll()
/*     */   {
/* 316 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SAwardMoney> newAll)
/*     */   {
/* 321 */     oldAll = all;
/* 322 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 327 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\confbean\SAwardMoney.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */