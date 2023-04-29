/*     */ package mzm.gsp.crossbattle.confbean;
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
/*     */ public class SCrossBattleRoundRobinBetCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SCrossBattleRoundRobinBetCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SCrossBattleRoundRobinBetCfg> all = null;
/*     */   
/*     */   public int activity_cfg_id;
/*     */   public int moduleid;
/*     */   public int bet_level_limit;
/*     */   public int win_notice_mail_cfg_id;
/*     */   public int lose_notice_mail_cfg_id;
/*     */   public int tie_notice_mail_cfg_id;
/*     */   public double win_rate_of_return;
/*     */   public double lose_rate_of_return;
/*     */   public double tie_rate_of_return;
/*     */   public int bet_cost_type;
/*  28 */   public HashMap<Integer, Integer> bet_infos = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  32 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  33 */     this.moduleid = Integer.valueOf(rootElement.attributeValue("moduleid")).intValue();
/*  34 */     this.bet_level_limit = Integer.valueOf(rootElement.attributeValue("bet_level_limit")).intValue();
/*  35 */     this.win_notice_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("win_notice_mail_cfg_id")).intValue();
/*  36 */     this.lose_notice_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("lose_notice_mail_cfg_id")).intValue();
/*  37 */     this.tie_notice_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("tie_notice_mail_cfg_id")).intValue();
/*  38 */     this.win_rate_of_return = Double.valueOf(rootElement.attributeValue("win_rate_of_return")).doubleValue();
/*  39 */     this.lose_rate_of_return = Double.valueOf(rootElement.attributeValue("lose_rate_of_return")).doubleValue();
/*  40 */     this.tie_rate_of_return = Double.valueOf(rootElement.attributeValue("tie_rate_of_return")).doubleValue();
/*  41 */     this.bet_cost_type = Integer.valueOf(rootElement.attributeValue("bet_cost_type")).intValue();
/*     */     
/*  43 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "bet_infos");
/*  44 */     if (mapTypeElement == null)
/*     */     {
/*  46 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  49 */     List<?> entryNodeList = mapTypeElement.elements();
/*  50 */     int entryLen = entryNodeList.size();
/*  51 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  53 */       Element entryElement = (Element)entryNodeList.get(i);
/*  54 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  59 */         Element keyElem = null;
/*  60 */         Element valueElem = null;
/*     */         
/*  62 */         List<?> _nodeList = entryElement.elements();
/*  63 */         int _len = _nodeList.size();
/*  64 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  66 */           Element elem = (Element)_nodeList.get(j);
/*  67 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  69 */             keyElem = elem;
/*     */           }
/*  71 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  73 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  77 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  79 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  86 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  87 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  94 */         this.bet_infos.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 101 */     _os_.marshal(this.activity_cfg_id);
/* 102 */     _os_.marshal(this.moduleid);
/* 103 */     _os_.marshal(this.bet_level_limit);
/* 104 */     _os_.marshal(this.win_notice_mail_cfg_id);
/* 105 */     _os_.marshal(this.lose_notice_mail_cfg_id);
/* 106 */     _os_.marshal(this.tie_notice_mail_cfg_id);
/* 107 */     _os_.marshal(this.win_rate_of_return);
/* 108 */     _os_.marshal(this.lose_rate_of_return);
/* 109 */     _os_.marshal(this.tie_rate_of_return);
/* 110 */     _os_.marshal(this.bet_cost_type);
/* 111 */     _os_.compact_uint32(this.bet_infos.size());
/* 112 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.bet_infos.entrySet())
/*     */     {
/* 114 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 115 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 117 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 122 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 123 */     this.moduleid = _os_.unmarshal_int();
/* 124 */     this.bet_level_limit = _os_.unmarshal_int();
/* 125 */     this.win_notice_mail_cfg_id = _os_.unmarshal_int();
/* 126 */     this.lose_notice_mail_cfg_id = _os_.unmarshal_int();
/* 127 */     this.tie_notice_mail_cfg_id = _os_.unmarshal_int();
/* 128 */     this.win_rate_of_return = _os_.unmarshal_float();
/* 129 */     this.lose_rate_of_return = _os_.unmarshal_float();
/* 130 */     this.tie_rate_of_return = _os_.unmarshal_float();
/* 131 */     this.bet_cost_type = _os_.unmarshal_int();
/* 132 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 135 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 137 */       int _v_ = _os_.unmarshal_int();
/* 138 */       this.bet_infos.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 140 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 145 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleRoundRobinBetCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 149 */       all = new HashMap();
/* 150 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 151 */       org.dom4j.Document doc = reader.read(new File(path));
/* 152 */       Element root = doc.getRootElement();
/* 153 */       List<?> nodeList = root.elements();
/* 154 */       int len = nodeList.size();
/* 155 */       for (int i = 0; i < len; i++)
/*     */       {
/* 157 */         Element elem = (Element)nodeList.get(i);
/* 158 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.SCrossBattleRoundRobinBetCfg"))
/*     */         {
/*     */ 
/* 161 */           SCrossBattleRoundRobinBetCfg obj = new SCrossBattleRoundRobinBetCfg();
/* 162 */           obj.loadFromXml(elem);
/* 163 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 164 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 169 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SCrossBattleRoundRobinBetCfg> all)
/*     */   {
/* 175 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleRoundRobinBetCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 179 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 180 */       org.dom4j.Document doc = reader.read(new File(path));
/* 181 */       Element root = doc.getRootElement();
/* 182 */       List<?> nodeList = root.elements();
/* 183 */       int len = nodeList.size();
/* 184 */       for (int i = 0; i < len; i++)
/*     */       {
/* 186 */         Element elem = (Element)nodeList.get(i);
/* 187 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.SCrossBattleRoundRobinBetCfg"))
/*     */         {
/*     */ 
/* 190 */           SCrossBattleRoundRobinBetCfg obj = new SCrossBattleRoundRobinBetCfg();
/* 191 */           obj.loadFromXml(elem);
/* 192 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 193 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 198 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 204 */     all = new HashMap();
/*     */     
/* 206 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleRoundRobinBetCfg.bny";
/*     */     try
/*     */     {
/* 209 */       File file = new File(path);
/* 210 */       if (file.exists())
/*     */       {
/* 212 */         byte[] bytes = new byte['Ѐ'];
/* 213 */         FileInputStream fis = new FileInputStream(file);
/* 214 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 215 */         int len = 0;
/* 216 */         while ((len = fis.read(bytes)) > 0)
/* 217 */           baos.write(bytes, 0, len);
/* 218 */         fis.close();
/* 219 */         bytes = baos.toByteArray();
/* 220 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 221 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 223 */           _os_.unmarshal_int();
/* 224 */           _os_.unmarshal_int();
/* 225 */           _os_.unmarshal_int();
/*     */         }
/* 227 */         _os_.unmarshal_int();
/* 228 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 231 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 233 */           SCrossBattleRoundRobinBetCfg _v_ = new SCrossBattleRoundRobinBetCfg();
/* 234 */           _v_.unmarshal(_os_);
/* 235 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 236 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 241 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 246 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SCrossBattleRoundRobinBetCfg> all)
/*     */   {
/* 253 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleRoundRobinBetCfg.bny";
/*     */     try
/*     */     {
/* 256 */       File file = new File(path);
/* 257 */       if (file.exists())
/*     */       {
/* 259 */         byte[] bytes = new byte['Ѐ'];
/* 260 */         FileInputStream fis = new FileInputStream(file);
/* 261 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 262 */         int len = 0;
/* 263 */         while ((len = fis.read(bytes)) > 0)
/* 264 */           baos.write(bytes, 0, len);
/* 265 */         fis.close();
/* 266 */         bytes = baos.toByteArray();
/* 267 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 268 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 270 */           _os_.unmarshal_int();
/* 271 */           _os_.unmarshal_int();
/* 272 */           _os_.unmarshal_int();
/*     */         }
/* 274 */         _os_.unmarshal_int();
/* 275 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 278 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 280 */           SCrossBattleRoundRobinBetCfg _v_ = new SCrossBattleRoundRobinBetCfg();
/* 281 */           _v_.unmarshal(_os_);
/* 282 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 283 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 288 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 293 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SCrossBattleRoundRobinBetCfg getOld(int key)
/*     */   {
/* 301 */     return (SCrossBattleRoundRobinBetCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SCrossBattleRoundRobinBetCfg get(int key)
/*     */   {
/* 306 */     return (SCrossBattleRoundRobinBetCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCrossBattleRoundRobinBetCfg> getOldAll()
/*     */   {
/* 311 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCrossBattleRoundRobinBetCfg> getAll()
/*     */   {
/* 316 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SCrossBattleRoundRobinBetCfg> newAll)
/*     */   {
/* 321 */     oldAll = all;
/* 322 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 327 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\SCrossBattleRoundRobinBetCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */