/*     */ package mzm.gsp.mounts.confbean;
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
/*     */ public class SMountsStarLifeOriginalCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SMountsStarLifeOriginalCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SMountsStarLifeOriginalCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int mountsCfgId;
/*     */   public int starLevel;
/*     */   public int starNum;
/*     */   public int unLockRank;
/*  23 */   public java.util.ArrayList<StarLifePro2Value> proList = new java.util.ArrayList();
/*     */   public int costItemId;
/*     */   public int costItemType;
/*     */   public int costItemNum;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  30 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  31 */     this.mountsCfgId = Integer.valueOf(rootElement.attributeValue("mountsCfgId")).intValue();
/*  32 */     this.starLevel = Integer.valueOf(rootElement.attributeValue("starLevel")).intValue();
/*  33 */     this.starNum = Integer.valueOf(rootElement.attributeValue("starNum")).intValue();
/*  34 */     this.unLockRank = Integer.valueOf(rootElement.attributeValue("unLockRank")).intValue();
/*     */     
/*  36 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "proList");
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
/*  47 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.mounts.confbean.StarLifePro2Value"))
/*     */       {
/*     */         StarLifePro2Value _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  54 */           _v_ = new StarLifePro2Value();
/*  55 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  62 */         this.proList.add(_v_);
/*     */       }
/*     */     }
/*  65 */     this.costItemId = Integer.valueOf(rootElement.attributeValue("costItemId")).intValue();
/*  66 */     this.costItemType = Integer.valueOf(rootElement.attributeValue("costItemType")).intValue();
/*  67 */     this.costItemNum = Integer.valueOf(rootElement.attributeValue("costItemNum")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _os_.marshal(this.id);
/*  73 */     _os_.marshal(this.mountsCfgId);
/*  74 */     _os_.marshal(this.starLevel);
/*  75 */     _os_.marshal(this.starNum);
/*  76 */     _os_.marshal(this.unLockRank);
/*  77 */     _os_.compact_uint32(this.proList.size());
/*  78 */     for (StarLifePro2Value _v_ : this.proList)
/*     */     {
/*  80 */       _os_.marshal(_v_);
/*     */     }
/*  82 */     _os_.marshal(this.costItemId);
/*  83 */     _os_.marshal(this.costItemType);
/*  84 */     _os_.marshal(this.costItemNum);
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  90 */     this.id = _os_.unmarshal_int();
/*  91 */     this.mountsCfgId = _os_.unmarshal_int();
/*  92 */     this.starLevel = _os_.unmarshal_int();
/*  93 */     this.starNum = _os_.unmarshal_int();
/*  94 */     this.unLockRank = _os_.unmarshal_int();
/*  95 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  98 */       StarLifePro2Value _v_ = new StarLifePro2Value();
/*  99 */       _v_.unmarshal(_os_);
/* 100 */       this.proList.add(_v_);
/*     */     }
/* 102 */     this.costItemId = _os_.unmarshal_int();
/* 103 */     this.costItemType = _os_.unmarshal_int();
/* 104 */     this.costItemNum = _os_.unmarshal_int();
/* 105 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 110 */     String path = dir + "mzm.gsp.mounts.confbean.SMountsStarLifeOriginalCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 114 */       all = new java.util.HashMap();
/* 115 */       SAXReader reader = new SAXReader();
/* 116 */       org.dom4j.Document doc = reader.read(new File(path));
/* 117 */       Element root = doc.getRootElement();
/* 118 */       List<?> nodeList = root.elements();
/* 119 */       int len = nodeList.size();
/* 120 */       for (int i = 0; i < len; i++)
/*     */       {
/* 122 */         Element elem = (Element)nodeList.get(i);
/* 123 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.mounts.confbean.SMountsStarLifeOriginalCfg"))
/*     */         {
/*     */ 
/* 126 */           SMountsStarLifeOriginalCfg obj = new SMountsStarLifeOriginalCfg();
/* 127 */           obj.loadFromXml(elem);
/* 128 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 129 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 134 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SMountsStarLifeOriginalCfg> all)
/*     */   {
/* 140 */     String path = dir + "mzm.gsp.mounts.confbean.SMountsStarLifeOriginalCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 144 */       SAXReader reader = new SAXReader();
/* 145 */       org.dom4j.Document doc = reader.read(new File(path));
/* 146 */       Element root = doc.getRootElement();
/* 147 */       List<?> nodeList = root.elements();
/* 148 */       int len = nodeList.size();
/* 149 */       for (int i = 0; i < len; i++)
/*     */       {
/* 151 */         Element elem = (Element)nodeList.get(i);
/* 152 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.mounts.confbean.SMountsStarLifeOriginalCfg"))
/*     */         {
/*     */ 
/* 155 */           SMountsStarLifeOriginalCfg obj = new SMountsStarLifeOriginalCfg();
/* 156 */           obj.loadFromXml(elem);
/* 157 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 158 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 163 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 169 */     all = new java.util.HashMap();
/*     */     
/* 171 */     String path = dir + "mzm.gsp.mounts.confbean.SMountsStarLifeOriginalCfg.bny";
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
/* 198 */           SMountsStarLifeOriginalCfg _v_ = new SMountsStarLifeOriginalCfg();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, SMountsStarLifeOriginalCfg> all)
/*     */   {
/* 218 */     String path = dir + "mzm.gsp.mounts.confbean.SMountsStarLifeOriginalCfg.bny";
/*     */     try
/*     */     {
/* 221 */       File file = new File(path);
/* 222 */       if (file.exists())
/*     */       {
/* 224 */         byte[] bytes = new byte['Ѐ'];
/* 225 */         FileInputStream fis = new FileInputStream(file);
/* 226 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 227 */         int len = 0;
/* 228 */         while ((len = fis.read(bytes)) > 0)
/* 229 */           baos.write(bytes, 0, len);
/* 230 */         fis.close();
/* 231 */         bytes = baos.toByteArray();
/* 232 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 233 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 235 */           _os_.unmarshal_int();
/* 236 */           _os_.unmarshal_int();
/* 237 */           _os_.unmarshal_int();
/*     */         }
/* 239 */         _os_.unmarshal_int();
/* 240 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 243 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 245 */           SMountsStarLifeOriginalCfg _v_ = new SMountsStarLifeOriginalCfg();
/* 246 */           _v_.unmarshal(_os_);
/* 247 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 248 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 253 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 258 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SMountsStarLifeOriginalCfg getOld(int key)
/*     */   {
/* 266 */     return (SMountsStarLifeOriginalCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SMountsStarLifeOriginalCfg get(int key)
/*     */   {
/* 271 */     return (SMountsStarLifeOriginalCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMountsStarLifeOriginalCfg> getOldAll()
/*     */   {
/* 276 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMountsStarLifeOriginalCfg> getAll()
/*     */   {
/* 281 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SMountsStarLifeOriginalCfg> newAll)
/*     */   {
/* 286 */     oldAll = all;
/* 287 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 292 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\confbean\SMountsStarLifeOriginalCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */