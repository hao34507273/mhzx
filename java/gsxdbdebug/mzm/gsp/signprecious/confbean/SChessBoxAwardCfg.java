/*     */ package mzm.gsp.signprecious.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SChessBoxAwardCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SChessBoxAwardCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SChessBoxAwardCfg> all = null;
/*     */   
/*     */   public int cell_num;
/*     */   public int cell_award_type;
/*     */   public int gold_precious_cfg_id;
/*     */   public int arrive_cost_yuan_bao;
/*     */   public int arrive_rate;
/*     */   public int normal_arrive_lucky_rate;
/*     */   public int yuan_bao_arrive_lucky_rate;
/*  25 */   public TreeMap<Integer, LuckyGoldPerciousBean> lucky_gold_percious_random_map = new TreeMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  29 */     this.cell_num = Integer.valueOf(rootElement.attributeValue("cell_num")).intValue();
/*  30 */     this.cell_award_type = Integer.valueOf(rootElement.attributeValue("cell_award_type")).intValue();
/*  31 */     this.gold_precious_cfg_id = Integer.valueOf(rootElement.attributeValue("gold_precious_cfg_id")).intValue();
/*  32 */     this.arrive_cost_yuan_bao = Integer.valueOf(rootElement.attributeValue("arrive_cost_yuan_bao")).intValue();
/*  33 */     this.arrive_rate = Integer.valueOf(rootElement.attributeValue("arrive_rate")).intValue();
/*  34 */     this.normal_arrive_lucky_rate = Integer.valueOf(rootElement.attributeValue("normal_arrive_lucky_rate")).intValue();
/*  35 */     this.yuan_bao_arrive_lucky_rate = Integer.valueOf(rootElement.attributeValue("yuan_bao_arrive_lucky_rate")).intValue();
/*     */     
/*  37 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "lucky_gold_percious_random_map");
/*  38 */     if (mapTypeElement == null)
/*     */     {
/*  40 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  43 */     List<?> entryNodeList = mapTypeElement.elements();
/*  44 */     int entryLen = entryNodeList.size();
/*  45 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  47 */       Element entryElement = (Element)entryNodeList.get(i);
/*  48 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  53 */         Element keyElem = null;
/*  54 */         Element valueElem = null;
/*     */         
/*  56 */         List<?> _nodeList = entryElement.elements();
/*  57 */         int _len = _nodeList.size();
/*  58 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  60 */           Element elem = (Element)_nodeList.get(j);
/*  61 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  63 */             keyElem = elem;
/*     */           }
/*  65 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.signprecious.confbean.LuckyGoldPerciousBean")))
/*     */           {
/*  67 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  71 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  73 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         LuckyGoldPerciousBean _v_;
/*     */         try
/*     */         {
/*  80 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  81 */           _v_ = new LuckyGoldPerciousBean();
/*  82 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  89 */         this.lucky_gold_percious_random_map.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  96 */     _os_.marshal(this.cell_num);
/*  97 */     _os_.marshal(this.cell_award_type);
/*  98 */     _os_.marshal(this.gold_precious_cfg_id);
/*  99 */     _os_.marshal(this.arrive_cost_yuan_bao);
/* 100 */     _os_.marshal(this.arrive_rate);
/* 101 */     _os_.marshal(this.normal_arrive_lucky_rate);
/* 102 */     _os_.marshal(this.yuan_bao_arrive_lucky_rate);
/* 103 */     _os_.compact_uint32(this.lucky_gold_percious_random_map.size());
/* 104 */     for (java.util.Map.Entry<Integer, LuckyGoldPerciousBean> _e_ : this.lucky_gold_percious_random_map.entrySet())
/*     */     {
/* 106 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 107 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 109 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 114 */     this.cell_num = _os_.unmarshal_int();
/* 115 */     this.cell_award_type = _os_.unmarshal_int();
/* 116 */     this.gold_precious_cfg_id = _os_.unmarshal_int();
/* 117 */     this.arrive_cost_yuan_bao = _os_.unmarshal_int();
/* 118 */     this.arrive_rate = _os_.unmarshal_int();
/* 119 */     this.normal_arrive_lucky_rate = _os_.unmarshal_int();
/* 120 */     this.yuan_bao_arrive_lucky_rate = _os_.unmarshal_int();
/* 121 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 124 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 126 */       LuckyGoldPerciousBean _v_ = new LuckyGoldPerciousBean();
/* 127 */       _v_.unmarshal(_os_);
/* 128 */       this.lucky_gold_percious_random_map.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 130 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 135 */     String path = dir + "mzm.gsp.signprecious.confbean.SChessBoxAwardCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 139 */       all = new TreeMap();
/* 140 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 141 */       org.dom4j.Document doc = reader.read(new File(path));
/* 142 */       Element root = doc.getRootElement();
/* 143 */       List<?> nodeList = root.elements();
/* 144 */       int len = nodeList.size();
/* 145 */       for (int i = 0; i < len; i++)
/*     */       {
/* 147 */         Element elem = (Element)nodeList.get(i);
/* 148 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.signprecious.confbean.SChessBoxAwardCfg"))
/*     */         {
/*     */ 
/* 151 */           SChessBoxAwardCfg obj = new SChessBoxAwardCfg();
/* 152 */           obj.loadFromXml(elem);
/* 153 */           if (all.put(Integer.valueOf(obj.cell_num), obj) != null) {
/* 154 */             throw new RuntimeException("duplicate key : " + obj.cell_num);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 159 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SChessBoxAwardCfg> all)
/*     */   {
/* 165 */     String path = dir + "mzm.gsp.signprecious.confbean.SChessBoxAwardCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 169 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 170 */       org.dom4j.Document doc = reader.read(new File(path));
/* 171 */       Element root = doc.getRootElement();
/* 172 */       List<?> nodeList = root.elements();
/* 173 */       int len = nodeList.size();
/* 174 */       for (int i = 0; i < len; i++)
/*     */       {
/* 176 */         Element elem = (Element)nodeList.get(i);
/* 177 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.signprecious.confbean.SChessBoxAwardCfg"))
/*     */         {
/*     */ 
/* 180 */           SChessBoxAwardCfg obj = new SChessBoxAwardCfg();
/* 181 */           obj.loadFromXml(elem);
/* 182 */           if (all.put(Integer.valueOf(obj.cell_num), obj) != null) {
/* 183 */             throw new RuntimeException("duplicate key : " + obj.cell_num);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 188 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 194 */     all = new TreeMap();
/*     */     
/* 196 */     String path = dir + "mzm.gsp.signprecious.confbean.SChessBoxAwardCfg.bny";
/*     */     try
/*     */     {
/* 199 */       File file = new File(path);
/* 200 */       if (file.exists())
/*     */       {
/* 202 */         byte[] bytes = new byte['Ѐ'];
/* 203 */         FileInputStream fis = new FileInputStream(file);
/* 204 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 205 */         int len = 0;
/* 206 */         while ((len = fis.read(bytes)) > 0)
/* 207 */           baos.write(bytes, 0, len);
/* 208 */         fis.close();
/* 209 */         bytes = baos.toByteArray();
/* 210 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 211 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 213 */           _os_.unmarshal_int();
/* 214 */           _os_.unmarshal_int();
/* 215 */           _os_.unmarshal_int();
/*     */         }
/* 217 */         _os_.unmarshal_int();
/* 218 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 221 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 223 */           SChessBoxAwardCfg _v_ = new SChessBoxAwardCfg();
/* 224 */           _v_.unmarshal(_os_);
/* 225 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 226 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 231 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 236 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SChessBoxAwardCfg> all)
/*     */   {
/* 243 */     String path = dir + "mzm.gsp.signprecious.confbean.SChessBoxAwardCfg.bny";
/*     */     try
/*     */     {
/* 246 */       File file = new File(path);
/* 247 */       if (file.exists())
/*     */       {
/* 249 */         byte[] bytes = new byte['Ѐ'];
/* 250 */         FileInputStream fis = new FileInputStream(file);
/* 251 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 252 */         int len = 0;
/* 253 */         while ((len = fis.read(bytes)) > 0)
/* 254 */           baos.write(bytes, 0, len);
/* 255 */         fis.close();
/* 256 */         bytes = baos.toByteArray();
/* 257 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 258 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 260 */           _os_.unmarshal_int();
/* 261 */           _os_.unmarshal_int();
/* 262 */           _os_.unmarshal_int();
/*     */         }
/* 264 */         _os_.unmarshal_int();
/* 265 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 268 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 270 */           SChessBoxAwardCfg _v_ = new SChessBoxAwardCfg();
/* 271 */           _v_.unmarshal(_os_);
/* 272 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 273 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 278 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 283 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SChessBoxAwardCfg getOld(int key)
/*     */   {
/* 291 */     return (SChessBoxAwardCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SChessBoxAwardCfg get(int key)
/*     */   {
/* 296 */     return (SChessBoxAwardCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SChessBoxAwardCfg> getOldAll()
/*     */   {
/* 301 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SChessBoxAwardCfg> getAll()
/*     */   {
/* 306 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SChessBoxAwardCfg> newAll)
/*     */   {
/* 311 */     oldAll = all;
/* 312 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 317 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signprecious\confbean\SChessBoxAwardCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */