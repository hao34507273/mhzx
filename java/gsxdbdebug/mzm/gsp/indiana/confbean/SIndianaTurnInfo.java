/*     */ package mzm.gsp.indiana.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SIndianaTurnInfo implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public int diaplay_turn;
/*     */   public int begin_timestamp;
/*     */   public int end_timestamp;
/*  12 */   public HashMap<Integer, SIndianaAwardInfo> award_infos = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  16 */     this.diaplay_turn = Integer.valueOf(rootElement.attributeValue("diaplay_turn")).intValue();
/*  17 */     this.begin_timestamp = Integer.valueOf(rootElement.attributeValue("begin_timestamp")).intValue();
/*  18 */     this.end_timestamp = Integer.valueOf(rootElement.attributeValue("end_timestamp")).intValue();
/*     */     
/*  20 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "award_infos");
/*  21 */     if (mapTypeElement == null)
/*     */     {
/*  23 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  26 */     java.util.List<?> entryNodeList = mapTypeElement.elements();
/*  27 */     int entryLen = entryNodeList.size();
/*  28 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  30 */       Element entryElement = (Element)entryNodeList.get(i);
/*  31 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  36 */         Element keyElem = null;
/*  37 */         Element valueElem = null;
/*     */         
/*  39 */         java.util.List<?> _nodeList = entryElement.elements();
/*  40 */         int _len = _nodeList.size();
/*  41 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  43 */           Element elem = (Element)_nodeList.get(j);
/*  44 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  46 */             keyElem = elem;
/*     */           }
/*  48 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.indiana.confbean.SIndianaAwardInfo")))
/*     */           {
/*  50 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  54 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  56 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         SIndianaAwardInfo _v_;
/*     */         try
/*     */         {
/*  63 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  64 */           _v_ = new SIndianaAwardInfo();
/*  65 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  72 */         this.award_infos.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  79 */     _os_.marshal(this.diaplay_turn);
/*  80 */     _os_.marshal(this.begin_timestamp);
/*  81 */     _os_.marshal(this.end_timestamp);
/*  82 */     _os_.compact_uint32(this.award_infos.size());
/*  83 */     for (java.util.Map.Entry<Integer, SIndianaAwardInfo> _e_ : this.award_infos.entrySet())
/*     */     {
/*  85 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  86 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  88 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  93 */     this.diaplay_turn = _os_.unmarshal_int();
/*  94 */     this.begin_timestamp = _os_.unmarshal_int();
/*  95 */     this.end_timestamp = _os_.unmarshal_int();
/*  96 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  99 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 101 */       SIndianaAwardInfo _v_ = new SIndianaAwardInfo();
/* 102 */       _v_.unmarshal(_os_);
/* 103 */       this.award_infos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 105 */     return _os_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\confbean\SIndianaTurnInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */