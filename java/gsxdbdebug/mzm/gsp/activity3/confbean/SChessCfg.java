/*     */ package mzm.gsp.activity3.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SChessCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SChessCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SChessCfg> all = null;
/*     */   
/*     */   public int chessGameCfgId;
/*     */   public int maxRow;
/*     */   public int maxColumn;
/*     */   public int roundTimeLimit;
/*     */   public int surrenderRoundCount;
/*     */   public int drawRoundCount;
/*     */   public int maxRoundCount;
/*     */   public int noOperateLoseRoundCount;
/*     */   public double durationAfterMove;
/*     */   public double durationAfterMoveAttack;
/*     */   public double durationAfterTurnAttack;
/*     */   public double durationAfterTurnBeAttacked;
/*  30 */   public HashMap<Integer, Integer> chessPieceIndex2count = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  34 */     this.chessGameCfgId = Integer.valueOf(rootElement.attributeValue("chessGameCfgId")).intValue();
/*  35 */     this.maxRow = Integer.valueOf(rootElement.attributeValue("maxRow")).intValue();
/*  36 */     this.maxColumn = Integer.valueOf(rootElement.attributeValue("maxColumn")).intValue();
/*  37 */     this.roundTimeLimit = Integer.valueOf(rootElement.attributeValue("roundTimeLimit")).intValue();
/*  38 */     this.surrenderRoundCount = Integer.valueOf(rootElement.attributeValue("surrenderRoundCount")).intValue();
/*  39 */     this.drawRoundCount = Integer.valueOf(rootElement.attributeValue("drawRoundCount")).intValue();
/*  40 */     this.maxRoundCount = Integer.valueOf(rootElement.attributeValue("maxRoundCount")).intValue();
/*  41 */     this.noOperateLoseRoundCount = Integer.valueOf(rootElement.attributeValue("noOperateLoseRoundCount")).intValue();
/*  42 */     this.durationAfterMove = Double.valueOf(rootElement.attributeValue("durationAfterMove")).doubleValue();
/*  43 */     this.durationAfterMoveAttack = Double.valueOf(rootElement.attributeValue("durationAfterMoveAttack")).doubleValue();
/*  44 */     this.durationAfterTurnAttack = Double.valueOf(rootElement.attributeValue("durationAfterTurnAttack")).doubleValue();
/*  45 */     this.durationAfterTurnBeAttacked = Double.valueOf(rootElement.attributeValue("durationAfterTurnBeAttacked")).doubleValue();
/*     */     
/*  47 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "chessPieceIndex2count");
/*  48 */     if (mapTypeElement == null)
/*     */     {
/*  50 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  53 */     List<?> entryNodeList = mapTypeElement.elements();
/*  54 */     int entryLen = entryNodeList.size();
/*  55 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  57 */       Element entryElement = (Element)entryNodeList.get(i);
/*  58 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  63 */         Element keyElem = null;
/*  64 */         Element valueElem = null;
/*     */         
/*  66 */         List<?> _nodeList = entryElement.elements();
/*  67 */         int _len = _nodeList.size();
/*  68 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  70 */           Element elem = (Element)_nodeList.get(j);
/*  71 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  73 */             keyElem = elem;
/*     */           }
/*  75 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  77 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  81 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  83 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  90 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  91 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  98 */         this.chessPieceIndex2count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 105 */     _os_.marshal(this.chessGameCfgId);
/* 106 */     _os_.marshal(this.maxRow);
/* 107 */     _os_.marshal(this.maxColumn);
/* 108 */     _os_.marshal(this.roundTimeLimit);
/* 109 */     _os_.marshal(this.surrenderRoundCount);
/* 110 */     _os_.marshal(this.drawRoundCount);
/* 111 */     _os_.marshal(this.maxRoundCount);
/* 112 */     _os_.marshal(this.noOperateLoseRoundCount);
/* 113 */     _os_.marshal(this.durationAfterMove);
/* 114 */     _os_.marshal(this.durationAfterMoveAttack);
/* 115 */     _os_.marshal(this.durationAfterTurnAttack);
/* 116 */     _os_.marshal(this.durationAfterTurnBeAttacked);
/* 117 */     _os_.compact_uint32(this.chessPieceIndex2count.size());
/* 118 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.chessPieceIndex2count.entrySet())
/*     */     {
/* 120 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 121 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 123 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 128 */     this.chessGameCfgId = _os_.unmarshal_int();
/* 129 */     this.maxRow = _os_.unmarshal_int();
/* 130 */     this.maxColumn = _os_.unmarshal_int();
/* 131 */     this.roundTimeLimit = _os_.unmarshal_int();
/* 132 */     this.surrenderRoundCount = _os_.unmarshal_int();
/* 133 */     this.drawRoundCount = _os_.unmarshal_int();
/* 134 */     this.maxRoundCount = _os_.unmarshal_int();
/* 135 */     this.noOperateLoseRoundCount = _os_.unmarshal_int();
/* 136 */     this.durationAfterMove = _os_.unmarshal_float();
/* 137 */     this.durationAfterMoveAttack = _os_.unmarshal_float();
/* 138 */     this.durationAfterTurnAttack = _os_.unmarshal_float();
/* 139 */     this.durationAfterTurnBeAttacked = _os_.unmarshal_float();
/* 140 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 143 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 145 */       int _v_ = _os_.unmarshal_int();
/* 146 */       this.chessPieceIndex2count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 148 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 153 */     String path = dir + "mzm.gsp.activity3.confbean.SChessCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 157 */       all = new HashMap();
/* 158 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 159 */       org.dom4j.Document doc = reader.read(new File(path));
/* 160 */       Element root = doc.getRootElement();
/* 161 */       List<?> nodeList = root.elements();
/* 162 */       int len = nodeList.size();
/* 163 */       for (int i = 0; i < len; i++)
/*     */       {
/* 165 */         Element elem = (Element)nodeList.get(i);
/* 166 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.SChessCfg"))
/*     */         {
/*     */ 
/* 169 */           SChessCfg obj = new SChessCfg();
/* 170 */           obj.loadFromXml(elem);
/* 171 */           if (all.put(Integer.valueOf(obj.chessGameCfgId), obj) != null) {
/* 172 */             throw new RuntimeException("duplicate key : " + obj.chessGameCfgId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 177 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SChessCfg> all)
/*     */   {
/* 183 */     String path = dir + "mzm.gsp.activity3.confbean.SChessCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 187 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 188 */       org.dom4j.Document doc = reader.read(new File(path));
/* 189 */       Element root = doc.getRootElement();
/* 190 */       List<?> nodeList = root.elements();
/* 191 */       int len = nodeList.size();
/* 192 */       for (int i = 0; i < len; i++)
/*     */       {
/* 194 */         Element elem = (Element)nodeList.get(i);
/* 195 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.SChessCfg"))
/*     */         {
/*     */ 
/* 198 */           SChessCfg obj = new SChessCfg();
/* 199 */           obj.loadFromXml(elem);
/* 200 */           if (all.put(Integer.valueOf(obj.chessGameCfgId), obj) != null) {
/* 201 */             throw new RuntimeException("duplicate key : " + obj.chessGameCfgId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 206 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 212 */     all = new HashMap();
/*     */     
/* 214 */     String path = dir + "mzm.gsp.activity3.confbean.SChessCfg.bny";
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
/* 241 */           SChessCfg _v_ = new SChessCfg();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, SChessCfg> all)
/*     */   {
/* 261 */     String path = dir + "mzm.gsp.activity3.confbean.SChessCfg.bny";
/*     */     try
/*     */     {
/* 264 */       File file = new File(path);
/* 265 */       if (file.exists())
/*     */       {
/* 267 */         byte[] bytes = new byte['Ѐ'];
/* 268 */         FileInputStream fis = new FileInputStream(file);
/* 269 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 270 */         int len = 0;
/* 271 */         while ((len = fis.read(bytes)) > 0)
/* 272 */           baos.write(bytes, 0, len);
/* 273 */         fis.close();
/* 274 */         bytes = baos.toByteArray();
/* 275 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 276 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 278 */           _os_.unmarshal_int();
/* 279 */           _os_.unmarshal_int();
/* 280 */           _os_.unmarshal_int();
/*     */         }
/* 282 */         _os_.unmarshal_int();
/* 283 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 286 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 288 */           SChessCfg _v_ = new SChessCfg();
/* 289 */           _v_.unmarshal(_os_);
/* 290 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 291 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 296 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 301 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SChessCfg getOld(int key)
/*     */   {
/* 309 */     return (SChessCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SChessCfg get(int key)
/*     */   {
/* 314 */     return (SChessCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SChessCfg> getOldAll()
/*     */   {
/* 319 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SChessCfg> getAll()
/*     */   {
/* 324 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SChessCfg> newAll)
/*     */   {
/* 329 */     oldAll = all;
/* 330 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 335 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity3\confbean\SChessCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */