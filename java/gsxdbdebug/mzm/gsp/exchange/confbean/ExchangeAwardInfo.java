/*     */ package mzm.gsp.exchange.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class ExchangeAwardInfo implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public int sort_id;
/*     */   public int exchange_type;
/*     */   public int max_exchange_num;
/*     */   public int award_cfg_id;
/*  13 */   public HashMap<Integer, NeedItemInfo> need_item_info_map = new HashMap();
/*     */   public boolean is_open;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  18 */     this.sort_id = Integer.valueOf(rootElement.attributeValue("sort_id")).intValue();
/*  19 */     this.exchange_type = Integer.valueOf(rootElement.attributeValue("exchange_type")).intValue();
/*  20 */     this.max_exchange_num = Integer.valueOf(rootElement.attributeValue("max_exchange_num")).intValue();
/*  21 */     this.award_cfg_id = Integer.valueOf(rootElement.attributeValue("award_cfg_id")).intValue();
/*     */     
/*  23 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "need_item_info_map");
/*  24 */     if (mapTypeElement == null)
/*     */     {
/*  26 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  29 */     java.util.List<?> entryNodeList = mapTypeElement.elements();
/*  30 */     int entryLen = entryNodeList.size();
/*  31 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  33 */       Element entryElement = (Element)entryNodeList.get(i);
/*  34 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  39 */         Element keyElem = null;
/*  40 */         Element valueElem = null;
/*     */         
/*  42 */         java.util.List<?> _nodeList = entryElement.elements();
/*  43 */         int _len = _nodeList.size();
/*  44 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  46 */           Element elem = (Element)_nodeList.get(j);
/*  47 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  49 */             keyElem = elem;
/*     */           }
/*  51 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.exchange.confbean.NeedItemInfo")))
/*     */           {
/*  53 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  57 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  59 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         NeedItemInfo _v_;
/*     */         try
/*     */         {
/*  66 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  67 */           _v_ = new NeedItemInfo();
/*  68 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  75 */         this.need_item_info_map.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*  78 */     this.is_open = Boolean.valueOf(rootElement.attributeValue("is_open")).booleanValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  83 */     _os_.marshal(this.sort_id);
/*  84 */     _os_.marshal(this.exchange_type);
/*  85 */     _os_.marshal(this.max_exchange_num);
/*  86 */     _os_.marshal(this.award_cfg_id);
/*  87 */     _os_.compact_uint32(this.need_item_info_map.size());
/*  88 */     for (java.util.Map.Entry<Integer, NeedItemInfo> _e_ : this.need_item_info_map.entrySet())
/*     */     {
/*  90 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  91 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  93 */     _os_.marshal(this.is_open);
/*  94 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  99 */     this.sort_id = _os_.unmarshal_int();
/* 100 */     this.exchange_type = _os_.unmarshal_int();
/* 101 */     this.max_exchange_num = _os_.unmarshal_int();
/* 102 */     this.award_cfg_id = _os_.unmarshal_int();
/* 103 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 106 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 108 */       NeedItemInfo _v_ = new NeedItemInfo();
/* 109 */       _v_.unmarshal(_os_);
/* 110 */       this.need_item_info_map.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 112 */     this.is_open = _os_.unmarshal_boolean();
/* 113 */     return _os_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\exchange\confbean\ExchangeAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */