/*     */ package mzm.gsp.signaward.confbean;
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
/*     */ public class SLevelUpAward implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SLevelUpAward> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SLevelUpAward> all = null;
/*     */   
/*     */   public int id;
/*     */   public String templatename;
/*     */   public int gifttype;
/*     */   public String giftbagname;
/*     */   public int menpai;
/*     */   public int gender;
/*     */   public int level;
/*  25 */   public java.util.ArrayList<ItemId2Count> itemIdCountList = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  29 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  30 */     this.templatename = rootElement.attributeValue("templatename");
/*  31 */     this.gifttype = Integer.valueOf(rootElement.attributeValue("gifttype")).intValue();
/*  32 */     this.giftbagname = rootElement.attributeValue("giftbagname");
/*  33 */     this.menpai = Integer.valueOf(rootElement.attributeValue("menpai")).intValue();
/*  34 */     this.gender = Integer.valueOf(rootElement.attributeValue("gender")).intValue();
/*  35 */     this.level = Integer.valueOf(rootElement.attributeValue("level")).intValue();
/*     */     
/*  37 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "itemIdCountList");
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
/*  48 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.signaward.confbean.ItemId2Count"))
/*     */       {
/*     */         ItemId2Count _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  55 */           _v_ = new ItemId2Count();
/*  56 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  63 */         this.itemIdCountList.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _os_.marshal(this.id);
/*  71 */     _os_.marshal(this.templatename, "UTF-8");
/*  72 */     _os_.marshal(this.gifttype);
/*  73 */     _os_.marshal(this.giftbagname, "UTF-8");
/*  74 */     _os_.marshal(this.menpai);
/*  75 */     _os_.marshal(this.gender);
/*  76 */     _os_.marshal(this.level);
/*  77 */     _os_.compact_uint32(this.itemIdCountList.size());
/*  78 */     for (ItemId2Count _v_ : this.itemIdCountList)
/*     */     {
/*  80 */       _os_.marshal(_v_);
/*     */     }
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  87 */     this.id = _os_.unmarshal_int();
/*  88 */     this.templatename = _os_.unmarshal_String("UTF-8");
/*  89 */     this.gifttype = _os_.unmarshal_int();
/*  90 */     this.giftbagname = _os_.unmarshal_String("UTF-8");
/*  91 */     this.menpai = _os_.unmarshal_int();
/*  92 */     this.gender = _os_.unmarshal_int();
/*  93 */     this.level = _os_.unmarshal_int();
/*  94 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  97 */       ItemId2Count _v_ = new ItemId2Count();
/*  98 */       _v_.unmarshal(_os_);
/*  99 */       this.itemIdCountList.add(_v_);
/*     */     }
/* 101 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 106 */     String path = dir + "mzm.gsp.signaward.confbean.SLevelUpAward.xml";
/*     */     
/*     */     try
/*     */     {
/* 110 */       all = new java.util.HashMap();
/* 111 */       SAXReader reader = new SAXReader();
/* 112 */       org.dom4j.Document doc = reader.read(new File(path));
/* 113 */       Element root = doc.getRootElement();
/* 114 */       List<?> nodeList = root.elements();
/* 115 */       int len = nodeList.size();
/* 116 */       for (int i = 0; i < len; i++)
/*     */       {
/* 118 */         Element elem = (Element)nodeList.get(i);
/* 119 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.signaward.confbean.SLevelUpAward"))
/*     */         {
/*     */ 
/* 122 */           SLevelUpAward obj = new SLevelUpAward();
/* 123 */           obj.loadFromXml(elem);
/* 124 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 125 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 130 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SLevelUpAward> all)
/*     */   {
/* 136 */     String path = dir + "mzm.gsp.signaward.confbean.SLevelUpAward.xml";
/*     */     
/*     */     try
/*     */     {
/* 140 */       SAXReader reader = new SAXReader();
/* 141 */       org.dom4j.Document doc = reader.read(new File(path));
/* 142 */       Element root = doc.getRootElement();
/* 143 */       List<?> nodeList = root.elements();
/* 144 */       int len = nodeList.size();
/* 145 */       for (int i = 0; i < len; i++)
/*     */       {
/* 147 */         Element elem = (Element)nodeList.get(i);
/* 148 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.signaward.confbean.SLevelUpAward"))
/*     */         {
/*     */ 
/* 151 */           SLevelUpAward obj = new SLevelUpAward();
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
/*     */   public static void loadBny(String dir)
/*     */   {
/* 165 */     all = new java.util.HashMap();
/*     */     
/* 167 */     String path = dir + "mzm.gsp.signaward.confbean.SLevelUpAward.bny";
/*     */     try
/*     */     {
/* 170 */       File file = new File(path);
/* 171 */       if (file.exists())
/*     */       {
/* 173 */         byte[] bytes = new byte['Ѐ'];
/* 174 */         FileInputStream fis = new FileInputStream(file);
/* 175 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 176 */         int len = 0;
/* 177 */         while ((len = fis.read(bytes)) > 0)
/* 178 */           baos.write(bytes, 0, len);
/* 179 */         fis.close();
/* 180 */         bytes = baos.toByteArray();
/* 181 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 182 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 184 */           _os_.unmarshal_int();
/* 185 */           _os_.unmarshal_int();
/* 186 */           _os_.unmarshal_int();
/*     */         }
/* 188 */         _os_.unmarshal_int();
/* 189 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 192 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 194 */           SLevelUpAward _v_ = new SLevelUpAward();
/* 195 */           _v_.unmarshal(_os_);
/* 196 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 197 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 202 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 207 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SLevelUpAward> all)
/*     */   {
/* 214 */     String path = dir + "mzm.gsp.signaward.confbean.SLevelUpAward.bny";
/*     */     try
/*     */     {
/* 217 */       File file = new File(path);
/* 218 */       if (file.exists())
/*     */       {
/* 220 */         byte[] bytes = new byte['Ѐ'];
/* 221 */         FileInputStream fis = new FileInputStream(file);
/* 222 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 223 */         int len = 0;
/* 224 */         while ((len = fis.read(bytes)) > 0)
/* 225 */           baos.write(bytes, 0, len);
/* 226 */         fis.close();
/* 227 */         bytes = baos.toByteArray();
/* 228 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 229 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 231 */           _os_.unmarshal_int();
/* 232 */           _os_.unmarshal_int();
/* 233 */           _os_.unmarshal_int();
/*     */         }
/* 235 */         _os_.unmarshal_int();
/* 236 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 239 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 241 */           SLevelUpAward _v_ = new SLevelUpAward();
/* 242 */           _v_.unmarshal(_os_);
/* 243 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 244 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 249 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 254 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SLevelUpAward getOld(int key)
/*     */   {
/* 262 */     return (SLevelUpAward)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SLevelUpAward get(int key)
/*     */   {
/* 267 */     return (SLevelUpAward)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SLevelUpAward> getOldAll()
/*     */   {
/* 272 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SLevelUpAward> getAll()
/*     */   {
/* 277 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SLevelUpAward> newAll)
/*     */   {
/* 282 */     oldAll = all;
/* 283 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 288 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\confbean\SLevelUpAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */