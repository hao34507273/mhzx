/*     */ package mzm.gsp.activity3.confbean;
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
/*     */ public class SChessGameCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SChessGameCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SChessGameCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int chessBoardType;
/*     */   public int chessPieceType;
/*     */   public int chessBoardMaxRow;
/*     */   public int chessBoardMaxColumn;
/*     */   public int roundTimeLimit;
/*     */   public int surrenderRoundCount;
/*     */   public int drawRoundCount;
/*     */   public int maxRoundCount;
/*     */   public int noOperateLoseRoundCount;
/*     */   public double durationAfterMove;
/*     */   public double durationAfterMoveAttack;
/*     */   public double durationAfterTurnAttack;
/*     */   public double durationAfterTurnBeAttacked;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  35 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  36 */     this.chessBoardType = Integer.valueOf(rootElement.attributeValue("chessBoardType")).intValue();
/*  37 */     this.chessPieceType = Integer.valueOf(rootElement.attributeValue("chessPieceType")).intValue();
/*  38 */     this.chessBoardMaxRow = Integer.valueOf(rootElement.attributeValue("chessBoardMaxRow")).intValue();
/*  39 */     this.chessBoardMaxColumn = Integer.valueOf(rootElement.attributeValue("chessBoardMaxColumn")).intValue();
/*  40 */     this.roundTimeLimit = Integer.valueOf(rootElement.attributeValue("roundTimeLimit")).intValue();
/*  41 */     this.surrenderRoundCount = Integer.valueOf(rootElement.attributeValue("surrenderRoundCount")).intValue();
/*  42 */     this.drawRoundCount = Integer.valueOf(rootElement.attributeValue("drawRoundCount")).intValue();
/*  43 */     this.maxRoundCount = Integer.valueOf(rootElement.attributeValue("maxRoundCount")).intValue();
/*  44 */     this.noOperateLoseRoundCount = Integer.valueOf(rootElement.attributeValue("noOperateLoseRoundCount")).intValue();
/*  45 */     this.durationAfterMove = Double.valueOf(rootElement.attributeValue("durationAfterMove")).doubleValue();
/*  46 */     this.durationAfterMoveAttack = Double.valueOf(rootElement.attributeValue("durationAfterMoveAttack")).doubleValue();
/*  47 */     this.durationAfterTurnAttack = Double.valueOf(rootElement.attributeValue("durationAfterTurnAttack")).doubleValue();
/*  48 */     this.durationAfterTurnBeAttacked = Double.valueOf(rootElement.attributeValue("durationAfterTurnBeAttacked")).doubleValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  53 */     _os_.marshal(this.id);
/*  54 */     _os_.marshal(this.chessBoardType);
/*  55 */     _os_.marshal(this.chessPieceType);
/*  56 */     _os_.marshal(this.chessBoardMaxRow);
/*  57 */     _os_.marshal(this.chessBoardMaxColumn);
/*  58 */     _os_.marshal(this.roundTimeLimit);
/*  59 */     _os_.marshal(this.surrenderRoundCount);
/*  60 */     _os_.marshal(this.drawRoundCount);
/*  61 */     _os_.marshal(this.maxRoundCount);
/*  62 */     _os_.marshal(this.noOperateLoseRoundCount);
/*  63 */     _os_.marshal(this.durationAfterMove);
/*  64 */     _os_.marshal(this.durationAfterMoveAttack);
/*  65 */     _os_.marshal(this.durationAfterTurnAttack);
/*  66 */     _os_.marshal(this.durationAfterTurnBeAttacked);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  72 */     this.id = _os_.unmarshal_int();
/*  73 */     this.chessBoardType = _os_.unmarshal_int();
/*  74 */     this.chessPieceType = _os_.unmarshal_int();
/*  75 */     this.chessBoardMaxRow = _os_.unmarshal_int();
/*  76 */     this.chessBoardMaxColumn = _os_.unmarshal_int();
/*  77 */     this.roundTimeLimit = _os_.unmarshal_int();
/*  78 */     this.surrenderRoundCount = _os_.unmarshal_int();
/*  79 */     this.drawRoundCount = _os_.unmarshal_int();
/*  80 */     this.maxRoundCount = _os_.unmarshal_int();
/*  81 */     this.noOperateLoseRoundCount = _os_.unmarshal_int();
/*  82 */     this.durationAfterMove = _os_.unmarshal_float();
/*  83 */     this.durationAfterMoveAttack = _os_.unmarshal_float();
/*  84 */     this.durationAfterTurnAttack = _os_.unmarshal_float();
/*  85 */     this.durationAfterTurnBeAttacked = _os_.unmarshal_float();
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  91 */     String path = dir + "mzm.gsp.activity3.confbean.SChessGameCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  95 */       all = new java.util.HashMap();
/*  96 */       SAXReader reader = new SAXReader();
/*  97 */       org.dom4j.Document doc = reader.read(new File(path));
/*  98 */       Element root = doc.getRootElement();
/*  99 */       List<?> nodeList = root.elements();
/* 100 */       int len = nodeList.size();
/* 101 */       for (int i = 0; i < len; i++)
/*     */       {
/* 103 */         Element elem = (Element)nodeList.get(i);
/* 104 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.SChessGameCfg"))
/*     */         {
/*     */ 
/* 107 */           SChessGameCfg obj = new SChessGameCfg();
/* 108 */           obj.loadFromXml(elem);
/* 109 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 110 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 115 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SChessGameCfg> all)
/*     */   {
/* 121 */     String path = dir + "mzm.gsp.activity3.confbean.SChessGameCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 125 */       SAXReader reader = new SAXReader();
/* 126 */       org.dom4j.Document doc = reader.read(new File(path));
/* 127 */       Element root = doc.getRootElement();
/* 128 */       List<?> nodeList = root.elements();
/* 129 */       int len = nodeList.size();
/* 130 */       for (int i = 0; i < len; i++)
/*     */       {
/* 132 */         Element elem = (Element)nodeList.get(i);
/* 133 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.SChessGameCfg"))
/*     */         {
/*     */ 
/* 136 */           SChessGameCfg obj = new SChessGameCfg();
/* 137 */           obj.loadFromXml(elem);
/* 138 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 139 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 144 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 150 */     all = new java.util.HashMap();
/*     */     
/* 152 */     String path = dir + "mzm.gsp.activity3.confbean.SChessGameCfg.bny";
/*     */     try
/*     */     {
/* 155 */       File file = new File(path);
/* 156 */       if (file.exists())
/*     */       {
/* 158 */         byte[] bytes = new byte['Ѐ'];
/* 159 */         FileInputStream fis = new FileInputStream(file);
/* 160 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 161 */         int len = 0;
/* 162 */         while ((len = fis.read(bytes)) > 0)
/* 163 */           baos.write(bytes, 0, len);
/* 164 */         fis.close();
/* 165 */         bytes = baos.toByteArray();
/* 166 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 167 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 169 */           _os_.unmarshal_int();
/* 170 */           _os_.unmarshal_int();
/* 171 */           _os_.unmarshal_int();
/*     */         }
/* 173 */         _os_.unmarshal_int();
/* 174 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 177 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 179 */           SChessGameCfg _v_ = new SChessGameCfg();
/* 180 */           _v_.unmarshal(_os_);
/* 181 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 182 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 187 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 192 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SChessGameCfg> all)
/*     */   {
/* 199 */     String path = dir + "mzm.gsp.activity3.confbean.SChessGameCfg.bny";
/*     */     try
/*     */     {
/* 202 */       File file = new File(path);
/* 203 */       if (file.exists())
/*     */       {
/* 205 */         byte[] bytes = new byte['Ѐ'];
/* 206 */         FileInputStream fis = new FileInputStream(file);
/* 207 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 208 */         int len = 0;
/* 209 */         while ((len = fis.read(bytes)) > 0)
/* 210 */           baos.write(bytes, 0, len);
/* 211 */         fis.close();
/* 212 */         bytes = baos.toByteArray();
/* 213 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 214 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 216 */           _os_.unmarshal_int();
/* 217 */           _os_.unmarshal_int();
/* 218 */           _os_.unmarshal_int();
/*     */         }
/* 220 */         _os_.unmarshal_int();
/* 221 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 224 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 226 */           SChessGameCfg _v_ = new SChessGameCfg();
/* 227 */           _v_.unmarshal(_os_);
/* 228 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 229 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 234 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 239 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SChessGameCfg getOld(int key)
/*     */   {
/* 247 */     return (SChessGameCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SChessGameCfg get(int key)
/*     */   {
/* 252 */     return (SChessGameCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SChessGameCfg> getOldAll()
/*     */   {
/* 257 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SChessGameCfg> getAll()
/*     */   {
/* 262 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SChessGameCfg> newAll)
/*     */   {
/* 267 */     oldAll = all;
/* 268 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 273 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity3\confbean\SChessGameCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */