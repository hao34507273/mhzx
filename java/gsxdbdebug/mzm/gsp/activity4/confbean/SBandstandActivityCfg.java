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
/*     */ public class SBandstandActivityCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SBandstandActivityCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SBandstandActivityCfg> all = null;
/*     */   
/*     */   public int activityId;
/*     */   public int npcId;
/*     */   public int serviceId;
/*     */   public int awardId;
/*     */   public int dailyAwardCount;
/*  23 */   public java.util.ArrayList<Integer> musicIds = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  27 */     this.activityId = Integer.valueOf(rootElement.attributeValue("activityId")).intValue();
/*  28 */     this.npcId = Integer.valueOf(rootElement.attributeValue("npcId")).intValue();
/*  29 */     this.serviceId = Integer.valueOf(rootElement.attributeValue("serviceId")).intValue();
/*  30 */     this.awardId = Integer.valueOf(rootElement.attributeValue("awardId")).intValue();
/*  31 */     this.dailyAwardCount = Integer.valueOf(rootElement.attributeValue("dailyAwardCount")).intValue();
/*     */     
/*  33 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "musicIds");
/*  34 */     if (collectionElement == null)
/*     */     {
/*  36 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  39 */     List<?> _nodeList = collectionElement.elements();
/*  40 */     int _len = _nodeList.size();
/*  41 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  43 */       Element elem = (Element)_nodeList.get(i);
/*  44 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  51 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  58 */         this.musicIds.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  65 */     _os_.marshal(this.activityId);
/*  66 */     _os_.marshal(this.npcId);
/*  67 */     _os_.marshal(this.serviceId);
/*  68 */     _os_.marshal(this.awardId);
/*  69 */     _os_.marshal(this.dailyAwardCount);
/*  70 */     _os_.compact_uint32(this.musicIds.size());
/*  71 */     for (Integer _v_ : this.musicIds)
/*     */     {
/*  73 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  80 */     this.activityId = _os_.unmarshal_int();
/*  81 */     this.npcId = _os_.unmarshal_int();
/*  82 */     this.serviceId = _os_.unmarshal_int();
/*  83 */     this.awardId = _os_.unmarshal_int();
/*  84 */     this.dailyAwardCount = _os_.unmarshal_int();
/*  85 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  88 */       int _v_ = _os_.unmarshal_int();
/*  89 */       this.musicIds.add(Integer.valueOf(_v_));
/*     */     }
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  96 */     String path = dir + "mzm.gsp.activity4.confbean.SBandstandActivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 100 */       all = new java.util.HashMap();
/* 101 */       SAXReader reader = new SAXReader();
/* 102 */       org.dom4j.Document doc = reader.read(new File(path));
/* 103 */       Element root = doc.getRootElement();
/* 104 */       List<?> nodeList = root.elements();
/* 105 */       int len = nodeList.size();
/* 106 */       for (int i = 0; i < len; i++)
/*     */       {
/* 108 */         Element elem = (Element)nodeList.get(i);
/* 109 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity4.confbean.SBandstandActivityCfg"))
/*     */         {
/*     */ 
/* 112 */           SBandstandActivityCfg obj = new SBandstandActivityCfg();
/* 113 */           obj.loadFromXml(elem);
/* 114 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 115 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 120 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SBandstandActivityCfg> all)
/*     */   {
/* 126 */     String path = dir + "mzm.gsp.activity4.confbean.SBandstandActivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 130 */       SAXReader reader = new SAXReader();
/* 131 */       org.dom4j.Document doc = reader.read(new File(path));
/* 132 */       Element root = doc.getRootElement();
/* 133 */       List<?> nodeList = root.elements();
/* 134 */       int len = nodeList.size();
/* 135 */       for (int i = 0; i < len; i++)
/*     */       {
/* 137 */         Element elem = (Element)nodeList.get(i);
/* 138 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity4.confbean.SBandstandActivityCfg"))
/*     */         {
/*     */ 
/* 141 */           SBandstandActivityCfg obj = new SBandstandActivityCfg();
/* 142 */           obj.loadFromXml(elem);
/* 143 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 144 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 149 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 155 */     all = new java.util.HashMap();
/*     */     
/* 157 */     String path = dir + "mzm.gsp.activity4.confbean.SBandstandActivityCfg.bny";
/*     */     try
/*     */     {
/* 160 */       File file = new File(path);
/* 161 */       if (file.exists())
/*     */       {
/* 163 */         byte[] bytes = new byte['Ѐ'];
/* 164 */         FileInputStream fis = new FileInputStream(file);
/* 165 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 166 */         int len = 0;
/* 167 */         while ((len = fis.read(bytes)) > 0)
/* 168 */           baos.write(bytes, 0, len);
/* 169 */         fis.close();
/* 170 */         bytes = baos.toByteArray();
/* 171 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 172 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 174 */           _os_.unmarshal_int();
/* 175 */           _os_.unmarshal_int();
/* 176 */           _os_.unmarshal_int();
/*     */         }
/* 178 */         _os_.unmarshal_int();
/* 179 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 182 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 184 */           SBandstandActivityCfg _v_ = new SBandstandActivityCfg();
/* 185 */           _v_.unmarshal(_os_);
/* 186 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 187 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 192 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 197 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SBandstandActivityCfg> all)
/*     */   {
/* 204 */     String path = dir + "mzm.gsp.activity4.confbean.SBandstandActivityCfg.bny";
/*     */     try
/*     */     {
/* 207 */       File file = new File(path);
/* 208 */       if (file.exists())
/*     */       {
/* 210 */         byte[] bytes = new byte['Ѐ'];
/* 211 */         FileInputStream fis = new FileInputStream(file);
/* 212 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 213 */         int len = 0;
/* 214 */         while ((len = fis.read(bytes)) > 0)
/* 215 */           baos.write(bytes, 0, len);
/* 216 */         fis.close();
/* 217 */         bytes = baos.toByteArray();
/* 218 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 219 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 221 */           _os_.unmarshal_int();
/* 222 */           _os_.unmarshal_int();
/* 223 */           _os_.unmarshal_int();
/*     */         }
/* 225 */         _os_.unmarshal_int();
/* 226 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 229 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 231 */           SBandstandActivityCfg _v_ = new SBandstandActivityCfg();
/* 232 */           _v_.unmarshal(_os_);
/* 233 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 234 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 239 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 244 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SBandstandActivityCfg getOld(int key)
/*     */   {
/* 252 */     return (SBandstandActivityCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SBandstandActivityCfg get(int key)
/*     */   {
/* 257 */     return (SBandstandActivityCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBandstandActivityCfg> getOldAll()
/*     */   {
/* 262 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBandstandActivityCfg> getAll()
/*     */   {
/* 267 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SBandstandActivityCfg> newAll)
/*     */   {
/* 272 */     oldAll = all;
/* 273 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 278 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity4\confbean\SBandstandActivityCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */