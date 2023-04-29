/*     */ package mzm.gsp.activity.confbean;
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
/*     */ public class SJueZhanJiuXiaoCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SJueZhanJiuXiaoCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SJueZhanJiuXiaoCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int floor;
/*     */   public int fixAwardid;
/*  21 */   public java.util.ArrayList<Integer> npcids = new java.util.ArrayList();
/*     */   public int bossNPC;
/*     */   public int bossAward;
/*     */   public int winAward;
/*     */   public int mapid;
/*     */   public int activityid;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  30 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  31 */     this.floor = Integer.valueOf(rootElement.attributeValue("floor")).intValue();
/*  32 */     this.fixAwardid = Integer.valueOf(rootElement.attributeValue("fixAwardid")).intValue();
/*     */     
/*  34 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "npcids");
/*  35 */     if (collectionElement == null)
/*     */     {
/*  37 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  40 */     List<?> _nodeList = collectionElement.elements();
/*  41 */     int _len = _nodeList.size();
/*  42 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  44 */       Element elem = (Element)_nodeList.get(i);
/*  45 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  52 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  59 */         this.npcids.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*  62 */     this.bossNPC = Integer.valueOf(rootElement.attributeValue("bossNPC")).intValue();
/*  63 */     this.bossAward = Integer.valueOf(rootElement.attributeValue("bossAward")).intValue();
/*  64 */     this.winAward = Integer.valueOf(rootElement.attributeValue("winAward")).intValue();
/*  65 */     this.mapid = Integer.valueOf(rootElement.attributeValue("mapid")).intValue();
/*  66 */     this.activityid = Integer.valueOf(rootElement.attributeValue("activityid")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  71 */     _os_.marshal(this.id);
/*  72 */     _os_.marshal(this.floor);
/*  73 */     _os_.marshal(this.fixAwardid);
/*  74 */     _os_.compact_uint32(this.npcids.size());
/*  75 */     for (Integer _v_ : this.npcids)
/*     */     {
/*  77 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  79 */     _os_.marshal(this.bossNPC);
/*  80 */     _os_.marshal(this.bossAward);
/*  81 */     _os_.marshal(this.winAward);
/*  82 */     _os_.marshal(this.mapid);
/*  83 */     _os_.marshal(this.activityid);
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  89 */     this.id = _os_.unmarshal_int();
/*  90 */     this.floor = _os_.unmarshal_int();
/*  91 */     this.fixAwardid = _os_.unmarshal_int();
/*  92 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  95 */       int _v_ = _os_.unmarshal_int();
/*  96 */       this.npcids.add(Integer.valueOf(_v_));
/*     */     }
/*  98 */     this.bossNPC = _os_.unmarshal_int();
/*  99 */     this.bossAward = _os_.unmarshal_int();
/* 100 */     this.winAward = _os_.unmarshal_int();
/* 101 */     this.mapid = _os_.unmarshal_int();
/* 102 */     this.activityid = _os_.unmarshal_int();
/* 103 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 108 */     String path = dir + "mzm.gsp.activity.confbean.SJueZhanJiuXiaoCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 112 */       all = new java.util.HashMap();
/* 113 */       SAXReader reader = new SAXReader();
/* 114 */       org.dom4j.Document doc = reader.read(new File(path));
/* 115 */       Element root = doc.getRootElement();
/* 116 */       List<?> nodeList = root.elements();
/* 117 */       int len = nodeList.size();
/* 118 */       for (int i = 0; i < len; i++)
/*     */       {
/* 120 */         Element elem = (Element)nodeList.get(i);
/* 121 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity.confbean.SJueZhanJiuXiaoCfg"))
/*     */         {
/*     */ 
/* 124 */           SJueZhanJiuXiaoCfg obj = new SJueZhanJiuXiaoCfg();
/* 125 */           obj.loadFromXml(elem);
/* 126 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 127 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 132 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SJueZhanJiuXiaoCfg> all)
/*     */   {
/* 138 */     String path = dir + "mzm.gsp.activity.confbean.SJueZhanJiuXiaoCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 142 */       SAXReader reader = new SAXReader();
/* 143 */       org.dom4j.Document doc = reader.read(new File(path));
/* 144 */       Element root = doc.getRootElement();
/* 145 */       List<?> nodeList = root.elements();
/* 146 */       int len = nodeList.size();
/* 147 */       for (int i = 0; i < len; i++)
/*     */       {
/* 149 */         Element elem = (Element)nodeList.get(i);
/* 150 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity.confbean.SJueZhanJiuXiaoCfg"))
/*     */         {
/*     */ 
/* 153 */           SJueZhanJiuXiaoCfg obj = new SJueZhanJiuXiaoCfg();
/* 154 */           obj.loadFromXml(elem);
/* 155 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 156 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 161 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 167 */     all = new java.util.HashMap();
/*     */     
/* 169 */     String path = dir + "mzm.gsp.activity.confbean.SJueZhanJiuXiaoCfg.bny";
/*     */     try
/*     */     {
/* 172 */       File file = new File(path);
/* 173 */       if (file.exists())
/*     */       {
/* 175 */         byte[] bytes = new byte['Ѐ'];
/* 176 */         FileInputStream fis = new FileInputStream(file);
/* 177 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 178 */         int len = 0;
/* 179 */         while ((len = fis.read(bytes)) > 0)
/* 180 */           baos.write(bytes, 0, len);
/* 181 */         fis.close();
/* 182 */         bytes = baos.toByteArray();
/* 183 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 184 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 186 */           _os_.unmarshal_int();
/* 187 */           _os_.unmarshal_int();
/* 188 */           _os_.unmarshal_int();
/*     */         }
/* 190 */         _os_.unmarshal_int();
/* 191 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 194 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 196 */           SJueZhanJiuXiaoCfg _v_ = new SJueZhanJiuXiaoCfg();
/* 197 */           _v_.unmarshal(_os_);
/* 198 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 199 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 204 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 209 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SJueZhanJiuXiaoCfg> all)
/*     */   {
/* 216 */     String path = dir + "mzm.gsp.activity.confbean.SJueZhanJiuXiaoCfg.bny";
/*     */     try
/*     */     {
/* 219 */       File file = new File(path);
/* 220 */       if (file.exists())
/*     */       {
/* 222 */         byte[] bytes = new byte['Ѐ'];
/* 223 */         FileInputStream fis = new FileInputStream(file);
/* 224 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 225 */         int len = 0;
/* 226 */         while ((len = fis.read(bytes)) > 0)
/* 227 */           baos.write(bytes, 0, len);
/* 228 */         fis.close();
/* 229 */         bytes = baos.toByteArray();
/* 230 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 231 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 233 */           _os_.unmarshal_int();
/* 234 */           _os_.unmarshal_int();
/* 235 */           _os_.unmarshal_int();
/*     */         }
/* 237 */         _os_.unmarshal_int();
/* 238 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 241 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 243 */           SJueZhanJiuXiaoCfg _v_ = new SJueZhanJiuXiaoCfg();
/* 244 */           _v_.unmarshal(_os_);
/* 245 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 246 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 251 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 256 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SJueZhanJiuXiaoCfg getOld(int key)
/*     */   {
/* 264 */     return (SJueZhanJiuXiaoCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SJueZhanJiuXiaoCfg get(int key)
/*     */   {
/* 269 */     return (SJueZhanJiuXiaoCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SJueZhanJiuXiaoCfg> getOldAll()
/*     */   {
/* 274 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SJueZhanJiuXiaoCfg> getAll()
/*     */   {
/* 279 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SJueZhanJiuXiaoCfg> newAll)
/*     */   {
/* 284 */     oldAll = all;
/* 285 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 290 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\confbean\SJueZhanJiuXiaoCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */