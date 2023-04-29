/*     */ package mzm.gsp.petarena.confbean;
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
/*     */ public class SPetArenaRobotCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SPetArenaRobotCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SPetArenaRobotCfg> all = null;
/*     */   
/*     */   public int maxRank;
/*     */   public int minRank;
/*     */   public int formationLevel;
/*  21 */   public ArrayList<Integer> formationCfgids = new ArrayList();
/*  22 */   public ArrayList<Integer> positions = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  26 */     this.maxRank = Integer.valueOf(rootElement.attributeValue("maxRank")).intValue();
/*  27 */     this.minRank = Integer.valueOf(rootElement.attributeValue("minRank")).intValue();
/*  28 */     this.formationLevel = Integer.valueOf(rootElement.attributeValue("formationLevel")).intValue();
/*     */     
/*  30 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "formationCfgids");
/*  31 */     if (collectionElement == null)
/*     */     {
/*  33 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  36 */     List<?> _nodeList = collectionElement.elements();
/*  37 */     int _len = _nodeList.size();
/*  38 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  40 */       Element elem = (Element)_nodeList.get(i);
/*  41 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  48 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  55 */         this.formationCfgids.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  59 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "positions");
/*  60 */     if (collectionElement == null)
/*     */     {
/*  62 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  65 */     List<?> _nodeList = collectionElement.elements();
/*  66 */     int _len = _nodeList.size();
/*  67 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  69 */       Element elem = (Element)_nodeList.get(i);
/*  70 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  77 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  84 */         this.positions.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  91 */     _os_.marshal(this.maxRank);
/*  92 */     _os_.marshal(this.minRank);
/*  93 */     _os_.marshal(this.formationLevel);
/*  94 */     _os_.compact_uint32(this.formationCfgids.size());
/*  95 */     for (Integer _v_ : this.formationCfgids)
/*     */     {
/*  97 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  99 */     _os_.compact_uint32(this.positions.size());
/* 100 */     for (Integer _v_ : this.positions)
/*     */     {
/* 102 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 104 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 109 */     this.maxRank = _os_.unmarshal_int();
/* 110 */     this.minRank = _os_.unmarshal_int();
/* 111 */     this.formationLevel = _os_.unmarshal_int();
/* 112 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 115 */       int _v_ = _os_.unmarshal_int();
/* 116 */       this.formationCfgids.add(Integer.valueOf(_v_));
/*     */     }
/* 118 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 121 */       int _v_ = _os_.unmarshal_int();
/* 122 */       this.positions.add(Integer.valueOf(_v_));
/*     */     }
/* 124 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 129 */     String path = dir + "mzm.gsp.petarena.confbean.SPetArenaRobotCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 133 */       all = new java.util.TreeMap();
/* 134 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 135 */       org.dom4j.Document doc = reader.read(new File(path));
/* 136 */       Element root = doc.getRootElement();
/* 137 */       List<?> nodeList = root.elements();
/* 138 */       int len = nodeList.size();
/* 139 */       for (int i = 0; i < len; i++)
/*     */       {
/* 141 */         Element elem = (Element)nodeList.get(i);
/* 142 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.petarena.confbean.SPetArenaRobotCfg"))
/*     */         {
/*     */ 
/* 145 */           SPetArenaRobotCfg obj = new SPetArenaRobotCfg();
/* 146 */           obj.loadFromXml(elem);
/* 147 */           if (all.put(Integer.valueOf(obj.maxRank), obj) != null) {
/* 148 */             throw new RuntimeException("duplicate key : " + obj.maxRank);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 153 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SPetArenaRobotCfg> all)
/*     */   {
/* 159 */     String path = dir + "mzm.gsp.petarena.confbean.SPetArenaRobotCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 163 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 164 */       org.dom4j.Document doc = reader.read(new File(path));
/* 165 */       Element root = doc.getRootElement();
/* 166 */       List<?> nodeList = root.elements();
/* 167 */       int len = nodeList.size();
/* 168 */       for (int i = 0; i < len; i++)
/*     */       {
/* 170 */         Element elem = (Element)nodeList.get(i);
/* 171 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.petarena.confbean.SPetArenaRobotCfg"))
/*     */         {
/*     */ 
/* 174 */           SPetArenaRobotCfg obj = new SPetArenaRobotCfg();
/* 175 */           obj.loadFromXml(elem);
/* 176 */           if (all.put(Integer.valueOf(obj.maxRank), obj) != null) {
/* 177 */             throw new RuntimeException("duplicate key : " + obj.maxRank);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 182 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 188 */     all = new java.util.TreeMap();
/*     */     
/* 190 */     String path = dir + "mzm.gsp.petarena.confbean.SPetArenaRobotCfg.bny";
/*     */     try
/*     */     {
/* 193 */       File file = new File(path);
/* 194 */       if (file.exists())
/*     */       {
/* 196 */         byte[] bytes = new byte['Ѐ'];
/* 197 */         FileInputStream fis = new FileInputStream(file);
/* 198 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 199 */         int len = 0;
/* 200 */         while ((len = fis.read(bytes)) > 0)
/* 201 */           baos.write(bytes, 0, len);
/* 202 */         fis.close();
/* 203 */         bytes = baos.toByteArray();
/* 204 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 205 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 207 */           _os_.unmarshal_int();
/* 208 */           _os_.unmarshal_int();
/* 209 */           _os_.unmarshal_int();
/*     */         }
/* 211 */         _os_.unmarshal_int();
/* 212 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 215 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 217 */           SPetArenaRobotCfg _v_ = new SPetArenaRobotCfg();
/* 218 */           _v_.unmarshal(_os_);
/* 219 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 220 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 225 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 230 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SPetArenaRobotCfg> all)
/*     */   {
/* 237 */     String path = dir + "mzm.gsp.petarena.confbean.SPetArenaRobotCfg.bny";
/*     */     try
/*     */     {
/* 240 */       File file = new File(path);
/* 241 */       if (file.exists())
/*     */       {
/* 243 */         byte[] bytes = new byte['Ѐ'];
/* 244 */         FileInputStream fis = new FileInputStream(file);
/* 245 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 246 */         int len = 0;
/* 247 */         while ((len = fis.read(bytes)) > 0)
/* 248 */           baos.write(bytes, 0, len);
/* 249 */         fis.close();
/* 250 */         bytes = baos.toByteArray();
/* 251 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 252 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 254 */           _os_.unmarshal_int();
/* 255 */           _os_.unmarshal_int();
/* 256 */           _os_.unmarshal_int();
/*     */         }
/* 258 */         _os_.unmarshal_int();
/* 259 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 262 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 264 */           SPetArenaRobotCfg _v_ = new SPetArenaRobotCfg();
/* 265 */           _v_.unmarshal(_os_);
/* 266 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 267 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 272 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 277 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SPetArenaRobotCfg getOld(int key)
/*     */   {
/* 285 */     return (SPetArenaRobotCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SPetArenaRobotCfg get(int key)
/*     */   {
/* 290 */     return (SPetArenaRobotCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPetArenaRobotCfg> getOldAll()
/*     */   {
/* 295 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPetArenaRobotCfg> getAll()
/*     */   {
/* 300 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SPetArenaRobotCfg> newAll)
/*     */   {
/* 305 */     oldAll = all;
/* 306 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 311 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\confbean\SPetArenaRobotCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */