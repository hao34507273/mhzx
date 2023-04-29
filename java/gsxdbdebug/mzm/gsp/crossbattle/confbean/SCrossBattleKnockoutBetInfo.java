/*     */ package mzm.gsp.crossbattle.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SCrossBattleKnockoutBetInfo implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public int moduleid;
/*     */   public int bet_level_limit;
/*     */   public int win_notice_mail_cfg_id;
/*     */   public int lose_notice_mail_cfg_id;
/*     */   public int tie_notice_mail_cfg_id;
/*     */   public int bet_fail_notice_mail_cfg_id;
/*     */   public double win_multiple;
/*     */   public int bet_cost_type;
/*     */   public int max_return_money_num;
/*  18 */   public HashMap<Integer, Integer> bet_infos = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  22 */     this.moduleid = Integer.valueOf(rootElement.attributeValue("moduleid")).intValue();
/*  23 */     this.bet_level_limit = Integer.valueOf(rootElement.attributeValue("bet_level_limit")).intValue();
/*  24 */     this.win_notice_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("win_notice_mail_cfg_id")).intValue();
/*  25 */     this.lose_notice_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("lose_notice_mail_cfg_id")).intValue();
/*  26 */     this.tie_notice_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("tie_notice_mail_cfg_id")).intValue();
/*  27 */     this.bet_fail_notice_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("bet_fail_notice_mail_cfg_id")).intValue();
/*  28 */     this.win_multiple = Double.valueOf(rootElement.attributeValue("win_multiple")).doubleValue();
/*  29 */     this.bet_cost_type = Integer.valueOf(rootElement.attributeValue("bet_cost_type")).intValue();
/*  30 */     this.max_return_money_num = Integer.valueOf(rootElement.attributeValue("max_return_money_num")).intValue();
/*     */     
/*  32 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "bet_infos");
/*  33 */     if (mapTypeElement == null)
/*     */     {
/*  35 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  38 */     java.util.List<?> entryNodeList = mapTypeElement.elements();
/*  39 */     int entryLen = entryNodeList.size();
/*  40 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  42 */       Element entryElement = (Element)entryNodeList.get(i);
/*  43 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  48 */         Element keyElem = null;
/*  49 */         Element valueElem = null;
/*     */         
/*  51 */         java.util.List<?> _nodeList = entryElement.elements();
/*  52 */         int _len = _nodeList.size();
/*  53 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  55 */           Element elem = (Element)_nodeList.get(j);
/*  56 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  58 */             keyElem = elem;
/*     */           }
/*  60 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  62 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  66 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  68 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  75 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  76 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  83 */         this.bet_infos.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  90 */     _os_.marshal(this.moduleid);
/*  91 */     _os_.marshal(this.bet_level_limit);
/*  92 */     _os_.marshal(this.win_notice_mail_cfg_id);
/*  93 */     _os_.marshal(this.lose_notice_mail_cfg_id);
/*  94 */     _os_.marshal(this.tie_notice_mail_cfg_id);
/*  95 */     _os_.marshal(this.bet_fail_notice_mail_cfg_id);
/*  96 */     _os_.marshal(this.win_multiple);
/*  97 */     _os_.marshal(this.bet_cost_type);
/*  98 */     _os_.marshal(this.max_return_money_num);
/*  99 */     _os_.compact_uint32(this.bet_infos.size());
/* 100 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.bet_infos.entrySet())
/*     */     {
/* 102 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 103 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 105 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 110 */     this.moduleid = _os_.unmarshal_int();
/* 111 */     this.bet_level_limit = _os_.unmarshal_int();
/* 112 */     this.win_notice_mail_cfg_id = _os_.unmarshal_int();
/* 113 */     this.lose_notice_mail_cfg_id = _os_.unmarshal_int();
/* 114 */     this.tie_notice_mail_cfg_id = _os_.unmarshal_int();
/* 115 */     this.bet_fail_notice_mail_cfg_id = _os_.unmarshal_int();
/* 116 */     this.win_multiple = _os_.unmarshal_float();
/* 117 */     this.bet_cost_type = _os_.unmarshal_int();
/* 118 */     this.max_return_money_num = _os_.unmarshal_int();
/* 119 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 122 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 124 */       int _v_ = _os_.unmarshal_int();
/* 125 */       this.bet_infos.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 127 */     return _os_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\SCrossBattleKnockoutBetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */