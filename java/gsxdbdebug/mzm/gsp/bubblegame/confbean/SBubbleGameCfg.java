/*     */ package mzm.gsp.bubblegame.confbean;
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
/*     */ public class SBubbleGameCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SBubbleGameCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SBubbleGameCfg> all = null;
/*     */   
/*     */   public int game_id;
/*     */   public int moduleid;
/*     */   public int turn_sum;
/*     */   public int game_time;
/*     */   public int right_award_id;
/*     */   public int wrong_award_id;
/*     */   public int point_upper_limit;
/*     */   public int right_point;
/*     */   public int wrong_point;
/*     */   public int tips_time;
/*     */   public int countdown_time;
/*  29 */   public TreeMap<Integer, Integer> right_sum_award_info = new TreeMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  33 */     this.game_id = Integer.valueOf(rootElement.attributeValue("game_id")).intValue();
/*  34 */     this.moduleid = Integer.valueOf(rootElement.attributeValue("moduleid")).intValue();
/*  35 */     this.turn_sum = Integer.valueOf(rootElement.attributeValue("turn_sum")).intValue();
/*  36 */     this.game_time = Integer.valueOf(rootElement.attributeValue("game_time")).intValue();
/*  37 */     this.right_award_id = Integer.valueOf(rootElement.attributeValue("right_award_id")).intValue();
/*  38 */     this.wrong_award_id = Integer.valueOf(rootElement.attributeValue("wrong_award_id")).intValue();
/*  39 */     this.point_upper_limit = Integer.valueOf(rootElement.attributeValue("point_upper_limit")).intValue();
/*  40 */     this.right_point = Integer.valueOf(rootElement.attributeValue("right_point")).intValue();
/*  41 */     this.wrong_point = Integer.valueOf(rootElement.attributeValue("wrong_point")).intValue();
/*  42 */     this.tips_time = Integer.valueOf(rootElement.attributeValue("tips_time")).intValue();
/*  43 */     this.countdown_time = Integer.valueOf(rootElement.attributeValue("countdown_time")).intValue();
/*     */     
/*  45 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "right_sum_award_info");
/*  46 */     if (mapTypeElement == null)
/*     */     {
/*  48 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  51 */     List<?> entryNodeList = mapTypeElement.elements();
/*  52 */     int entryLen = entryNodeList.size();
/*  53 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  55 */       Element entryElement = (Element)entryNodeList.get(i);
/*  56 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  61 */         Element keyElem = null;
/*  62 */         Element valueElem = null;
/*     */         
/*  64 */         List<?> _nodeList = entryElement.elements();
/*  65 */         int _len = _nodeList.size();
/*  66 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  68 */           Element elem = (Element)_nodeList.get(j);
/*  69 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  71 */             keyElem = elem;
/*     */           }
/*  73 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  75 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  79 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  81 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  88 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  89 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  96 */         this.right_sum_award_info.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 103 */     _os_.marshal(this.game_id);
/* 104 */     _os_.marshal(this.moduleid);
/* 105 */     _os_.marshal(this.turn_sum);
/* 106 */     _os_.marshal(this.game_time);
/* 107 */     _os_.marshal(this.right_award_id);
/* 108 */     _os_.marshal(this.wrong_award_id);
/* 109 */     _os_.marshal(this.point_upper_limit);
/* 110 */     _os_.marshal(this.right_point);
/* 111 */     _os_.marshal(this.wrong_point);
/* 112 */     _os_.marshal(this.tips_time);
/* 113 */     _os_.marshal(this.countdown_time);
/* 114 */     _os_.compact_uint32(this.right_sum_award_info.size());
/* 115 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.right_sum_award_info.entrySet())
/*     */     {
/* 117 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 118 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 120 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 125 */     this.game_id = _os_.unmarshal_int();
/* 126 */     this.moduleid = _os_.unmarshal_int();
/* 127 */     this.turn_sum = _os_.unmarshal_int();
/* 128 */     this.game_time = _os_.unmarshal_int();
/* 129 */     this.right_award_id = _os_.unmarshal_int();
/* 130 */     this.wrong_award_id = _os_.unmarshal_int();
/* 131 */     this.point_upper_limit = _os_.unmarshal_int();
/* 132 */     this.right_point = _os_.unmarshal_int();
/* 133 */     this.wrong_point = _os_.unmarshal_int();
/* 134 */     this.tips_time = _os_.unmarshal_int();
/* 135 */     this.countdown_time = _os_.unmarshal_int();
/* 136 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 139 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 141 */       int _v_ = _os_.unmarshal_int();
/* 142 */       this.right_sum_award_info.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 144 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 149 */     String path = dir + "mzm.gsp.bubblegame.confbean.SBubbleGameCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 153 */       all = new java.util.HashMap();
/* 154 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 155 */       org.dom4j.Document doc = reader.read(new File(path));
/* 156 */       Element root = doc.getRootElement();
/* 157 */       List<?> nodeList = root.elements();
/* 158 */       int len = nodeList.size();
/* 159 */       for (int i = 0; i < len; i++)
/*     */       {
/* 161 */         Element elem = (Element)nodeList.get(i);
/* 162 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.bubblegame.confbean.SBubbleGameCfg"))
/*     */         {
/*     */ 
/* 165 */           SBubbleGameCfg obj = new SBubbleGameCfg();
/* 166 */           obj.loadFromXml(elem);
/* 167 */           if (all.put(Integer.valueOf(obj.game_id), obj) != null) {
/* 168 */             throw new RuntimeException("duplicate key : " + obj.game_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 173 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SBubbleGameCfg> all)
/*     */   {
/* 179 */     String path = dir + "mzm.gsp.bubblegame.confbean.SBubbleGameCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 183 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 184 */       org.dom4j.Document doc = reader.read(new File(path));
/* 185 */       Element root = doc.getRootElement();
/* 186 */       List<?> nodeList = root.elements();
/* 187 */       int len = nodeList.size();
/* 188 */       for (int i = 0; i < len; i++)
/*     */       {
/* 190 */         Element elem = (Element)nodeList.get(i);
/* 191 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.bubblegame.confbean.SBubbleGameCfg"))
/*     */         {
/*     */ 
/* 194 */           SBubbleGameCfg obj = new SBubbleGameCfg();
/* 195 */           obj.loadFromXml(elem);
/* 196 */           if (all.put(Integer.valueOf(obj.game_id), obj) != null) {
/* 197 */             throw new RuntimeException("duplicate key : " + obj.game_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 202 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 208 */     all = new java.util.HashMap();
/*     */     
/* 210 */     String path = dir + "mzm.gsp.bubblegame.confbean.SBubbleGameCfg.bny";
/*     */     try
/*     */     {
/* 213 */       File file = new File(path);
/* 214 */       if (file.exists())
/*     */       {
/* 216 */         byte[] bytes = new byte['Ѐ'];
/* 217 */         FileInputStream fis = new FileInputStream(file);
/* 218 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 219 */         int len = 0;
/* 220 */         while ((len = fis.read(bytes)) > 0)
/* 221 */           baos.write(bytes, 0, len);
/* 222 */         fis.close();
/* 223 */         bytes = baos.toByteArray();
/* 224 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 225 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 227 */           _os_.unmarshal_int();
/* 228 */           _os_.unmarshal_int();
/* 229 */           _os_.unmarshal_int();
/*     */         }
/* 231 */         _os_.unmarshal_int();
/* 232 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 235 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 237 */           SBubbleGameCfg _v_ = new SBubbleGameCfg();
/* 238 */           _v_.unmarshal(_os_);
/* 239 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 240 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 245 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 250 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SBubbleGameCfg> all)
/*     */   {
/* 257 */     String path = dir + "mzm.gsp.bubblegame.confbean.SBubbleGameCfg.bny";
/*     */     try
/*     */     {
/* 260 */       File file = new File(path);
/* 261 */       if (file.exists())
/*     */       {
/* 263 */         byte[] bytes = new byte['Ѐ'];
/* 264 */         FileInputStream fis = new FileInputStream(file);
/* 265 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 266 */         int len = 0;
/* 267 */         while ((len = fis.read(bytes)) > 0)
/* 268 */           baos.write(bytes, 0, len);
/* 269 */         fis.close();
/* 270 */         bytes = baos.toByteArray();
/* 271 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 272 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 274 */           _os_.unmarshal_int();
/* 275 */           _os_.unmarshal_int();
/* 276 */           _os_.unmarshal_int();
/*     */         }
/* 278 */         _os_.unmarshal_int();
/* 279 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 282 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 284 */           SBubbleGameCfg _v_ = new SBubbleGameCfg();
/* 285 */           _v_.unmarshal(_os_);
/* 286 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 287 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 292 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 297 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SBubbleGameCfg getOld(int key)
/*     */   {
/* 305 */     return (SBubbleGameCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SBubbleGameCfg get(int key)
/*     */   {
/* 310 */     return (SBubbleGameCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBubbleGameCfg> getOldAll()
/*     */   {
/* 315 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBubbleGameCfg> getAll()
/*     */   {
/* 320 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SBubbleGameCfg> newAll)
/*     */   {
/* 325 */     oldAll = all;
/* 326 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 331 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bubblegame\confbean\SBubbleGameCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */