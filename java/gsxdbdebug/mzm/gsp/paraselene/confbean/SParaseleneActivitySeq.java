/*     */ package mzm.gsp.paraselene.confbean;
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
/*     */ public class SParaseleneActivitySeq implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SParaseleneActivitySeq> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SParaseleneActivitySeq> all = null;
/*     */   
/*     */   public int layer;
/*     */   public int id;
/*     */   public int mapid;
/*     */   public int tasktype;
/*     */   public int contentid;
/*     */   public int rewardid;
/*     */   public int awardpoollibid;
/*     */   public int npcid;
/*     */   public int npcservice;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  30 */     this.layer = Integer.valueOf(rootElement.attributeValue("layer")).intValue();
/*  31 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  32 */     this.mapid = Integer.valueOf(rootElement.attributeValue("mapid")).intValue();
/*  33 */     this.tasktype = Integer.valueOf(rootElement.attributeValue("tasktype")).intValue();
/*  34 */     this.contentid = Integer.valueOf(rootElement.attributeValue("contentid")).intValue();
/*  35 */     this.rewardid = Integer.valueOf(rootElement.attributeValue("rewardid")).intValue();
/*  36 */     this.awardpoollibid = Integer.valueOf(rootElement.attributeValue("awardpoollibid")).intValue();
/*  37 */     this.npcid = Integer.valueOf(rootElement.attributeValue("npcid")).intValue();
/*  38 */     this.npcservice = Integer.valueOf(rootElement.attributeValue("npcservice")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  43 */     _os_.marshal(this.layer);
/*  44 */     _os_.marshal(this.id);
/*  45 */     _os_.marshal(this.mapid);
/*  46 */     _os_.marshal(this.tasktype);
/*  47 */     _os_.marshal(this.contentid);
/*  48 */     _os_.marshal(this.rewardid);
/*  49 */     _os_.marshal(this.awardpoollibid);
/*  50 */     _os_.marshal(this.npcid);
/*  51 */     _os_.marshal(this.npcservice);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  57 */     this.layer = _os_.unmarshal_int();
/*  58 */     this.id = _os_.unmarshal_int();
/*  59 */     this.mapid = _os_.unmarshal_int();
/*  60 */     this.tasktype = _os_.unmarshal_int();
/*  61 */     this.contentid = _os_.unmarshal_int();
/*  62 */     this.rewardid = _os_.unmarshal_int();
/*  63 */     this.awardpoollibid = _os_.unmarshal_int();
/*  64 */     this.npcid = _os_.unmarshal_int();
/*  65 */     this.npcservice = _os_.unmarshal_int();
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  71 */     String path = dir + "mzm.gsp.paraselene.confbean.SParaseleneActivitySeq.xml";
/*     */     
/*     */     try
/*     */     {
/*  75 */       all = new java.util.TreeMap();
/*  76 */       SAXReader reader = new SAXReader();
/*  77 */       org.dom4j.Document doc = reader.read(new File(path));
/*  78 */       Element root = doc.getRootElement();
/*  79 */       List<?> nodeList = root.elements();
/*  80 */       int len = nodeList.size();
/*  81 */       for (int i = 0; i < len; i++)
/*     */       {
/*  83 */         Element elem = (Element)nodeList.get(i);
/*  84 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.paraselene.confbean.SParaseleneActivitySeq"))
/*     */         {
/*     */ 
/*  87 */           SParaseleneActivitySeq obj = new SParaseleneActivitySeq();
/*  88 */           obj.loadFromXml(elem);
/*  89 */           if (all.put(Integer.valueOf(obj.layer), obj) != null) {
/*  90 */             throw new RuntimeException("duplicate key : " + obj.layer);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  95 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SParaseleneActivitySeq> all)
/*     */   {
/* 101 */     String path = dir + "mzm.gsp.paraselene.confbean.SParaseleneActivitySeq.xml";
/*     */     
/*     */     try
/*     */     {
/* 105 */       SAXReader reader = new SAXReader();
/* 106 */       org.dom4j.Document doc = reader.read(new File(path));
/* 107 */       Element root = doc.getRootElement();
/* 108 */       List<?> nodeList = root.elements();
/* 109 */       int len = nodeList.size();
/* 110 */       for (int i = 0; i < len; i++)
/*     */       {
/* 112 */         Element elem = (Element)nodeList.get(i);
/* 113 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.paraselene.confbean.SParaseleneActivitySeq"))
/*     */         {
/*     */ 
/* 116 */           SParaseleneActivitySeq obj = new SParaseleneActivitySeq();
/* 117 */           obj.loadFromXml(elem);
/* 118 */           if (all.put(Integer.valueOf(obj.layer), obj) != null) {
/* 119 */             throw new RuntimeException("duplicate key : " + obj.layer);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 124 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 130 */     all = new java.util.TreeMap();
/*     */     
/* 132 */     String path = dir + "mzm.gsp.paraselene.confbean.SParaseleneActivitySeq.bny";
/*     */     try
/*     */     {
/* 135 */       File file = new File(path);
/* 136 */       if (file.exists())
/*     */       {
/* 138 */         byte[] bytes = new byte['Ѐ'];
/* 139 */         FileInputStream fis = new FileInputStream(file);
/* 140 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 141 */         int len = 0;
/* 142 */         while ((len = fis.read(bytes)) > 0)
/* 143 */           baos.write(bytes, 0, len);
/* 144 */         fis.close();
/* 145 */         bytes = baos.toByteArray();
/* 146 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 147 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 149 */           _os_.unmarshal_int();
/* 150 */           _os_.unmarshal_int();
/* 151 */           _os_.unmarshal_int();
/*     */         }
/* 153 */         _os_.unmarshal_int();
/* 154 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 157 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 159 */           SParaseleneActivitySeq _v_ = new SParaseleneActivitySeq();
/* 160 */           _v_.unmarshal(_os_);
/* 161 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 162 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 167 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 172 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SParaseleneActivitySeq> all)
/*     */   {
/* 179 */     String path = dir + "mzm.gsp.paraselene.confbean.SParaseleneActivitySeq.bny";
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
/* 206 */           SParaseleneActivitySeq _v_ = new SParaseleneActivitySeq();
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
/*     */ 
/*     */   public static SParaseleneActivitySeq getOld(int key)
/*     */   {
/* 227 */     return (SParaseleneActivitySeq)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SParaseleneActivitySeq get(int key)
/*     */   {
/* 232 */     return (SParaseleneActivitySeq)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SParaseleneActivitySeq> getOldAll()
/*     */   {
/* 237 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SParaseleneActivitySeq> getAll()
/*     */   {
/* 242 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SParaseleneActivitySeq> newAll)
/*     */   {
/* 247 */     oldAll = all;
/* 248 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 253 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\confbean\SParaseleneActivitySeq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */