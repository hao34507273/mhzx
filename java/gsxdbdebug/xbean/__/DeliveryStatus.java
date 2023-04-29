/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.LinkedList;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class DeliveryStatus extends XBean implements xbean.DeliveryStatus
/*      */ {
/*      */   private int delivery_count;
/*      */   private LinkedList<Long> recycled_item_list;
/*      */   private HashMap<Long, Integer> item_holders;
/*      */   private int send_card_count;
/*      */   private SetX<Long> mail_receivers;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.delivery_count = 0;
/*   27 */     this.recycled_item_list.clear();
/*   28 */     this.item_holders.clear();
/*   29 */     this.send_card_count = 0;
/*   30 */     this.mail_receivers.clear();
/*      */   }
/*      */   
/*      */   DeliveryStatus(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.recycled_item_list = new LinkedList();
/*   37 */     this.item_holders = new HashMap();
/*   38 */     this.mail_receivers = new SetX();
/*      */   }
/*      */   
/*      */   public DeliveryStatus()
/*      */   {
/*   43 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public DeliveryStatus(DeliveryStatus _o_)
/*      */   {
/*   48 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   DeliveryStatus(xbean.DeliveryStatus _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   53 */     super(_xp_, _vn_);
/*   54 */     if ((_o1_ instanceof DeliveryStatus)) { assign((DeliveryStatus)_o1_);
/*   55 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   56 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   57 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(DeliveryStatus _o_) {
/*   62 */     _o_._xdb_verify_unsafe_();
/*   63 */     this.delivery_count = _o_.delivery_count;
/*   64 */     this.recycled_item_list = new LinkedList();
/*   65 */     this.recycled_item_list.addAll(_o_.recycled_item_list);
/*   66 */     this.item_holders = new HashMap();
/*   67 */     for (Map.Entry<Long, Integer> _e_ : _o_.item_holders.entrySet())
/*   68 */       this.item_holders.put(_e_.getKey(), _e_.getValue());
/*   69 */     this.send_card_count = _o_.send_card_count;
/*   70 */     this.mail_receivers = new SetX();
/*   71 */     this.mail_receivers.addAll(_o_.mail_receivers);
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   76 */     this.delivery_count = _o_.delivery_count;
/*   77 */     this.recycled_item_list = new LinkedList();
/*   78 */     this.recycled_item_list.addAll(_o_.recycled_item_list);
/*   79 */     this.item_holders = new HashMap();
/*   80 */     for (Map.Entry<Long, Integer> _e_ : _o_.item_holders.entrySet())
/*   81 */       this.item_holders.put(_e_.getKey(), _e_.getValue());
/*   82 */     this.send_card_count = _o_.send_card_count;
/*   83 */     this.mail_receivers = new SetX();
/*   84 */     this.mail_receivers.addAll(_o_.mail_receivers);
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   90 */     _xdb_verify_unsafe_();
/*   91 */     _os_.marshal(this.delivery_count);
/*   92 */     _os_.compact_uint32(this.recycled_item_list.size());
/*   93 */     for (Long _v_ : this.recycled_item_list)
/*      */     {
/*   95 */       _os_.marshal(_v_.longValue());
/*      */     }
/*   97 */     _os_.compact_uint32(this.item_holders.size());
/*   98 */     for (Map.Entry<Long, Integer> _e_ : this.item_holders.entrySet())
/*      */     {
/*  100 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  101 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  103 */     _os_.marshal(this.send_card_count);
/*  104 */     _os_.compact_uint32(this.mail_receivers.size());
/*  105 */     for (Long _v_ : this.mail_receivers)
/*      */     {
/*  107 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  109 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  115 */     _xdb_verify_unsafe_();
/*  116 */     this.delivery_count = _os_.unmarshal_int();
/*  117 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  119 */       long _v_ = 0L;
/*  120 */       _v_ = _os_.unmarshal_long();
/*  121 */       this.recycled_item_list.add(Long.valueOf(_v_));
/*      */     }
/*      */     
/*  124 */     int size = _os_.uncompact_uint32();
/*  125 */     if (size >= 12)
/*      */     {
/*  127 */       this.item_holders = new HashMap(size * 2);
/*      */     }
/*  129 */     for (; size > 0; size--)
/*      */     {
/*  131 */       long _k_ = 0L;
/*  132 */       _k_ = _os_.unmarshal_long();
/*  133 */       int _v_ = 0;
/*  134 */       _v_ = _os_.unmarshal_int();
/*  135 */       this.item_holders.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  138 */     this.send_card_count = _os_.unmarshal_int();
/*  139 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  141 */       long _v_ = 0L;
/*  142 */       _v_ = _os_.unmarshal_long();
/*  143 */       this.mail_receivers.add(Long.valueOf(_v_));
/*      */     }
/*  145 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  151 */     _xdb_verify_unsafe_();
/*  152 */     int _size_ = 0;
/*  153 */     _size_ += CodedOutputStream.computeInt32Size(1, this.delivery_count);
/*  154 */     for (Long _v_ : this.recycled_item_list)
/*      */     {
/*  156 */       _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*      */     }
/*  158 */     for (Map.Entry<Long, Integer> _e_ : this.item_holders.entrySet())
/*      */     {
/*  160 */       _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/*  161 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  163 */     _size_ += CodedOutputStream.computeInt32Size(4, this.send_card_count);
/*  164 */     for (Long _v_ : this.mail_receivers)
/*      */     {
/*  166 */       _size_ += CodedOutputStream.computeInt64Size(5, _v_.longValue());
/*      */     }
/*  168 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  174 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  177 */       _output_.writeInt32(1, this.delivery_count);
/*  178 */       for (Long _v_ : this.recycled_item_list)
/*      */       {
/*  180 */         _output_.writeInt64(2, _v_.longValue());
/*      */       }
/*  182 */       for (Map.Entry<Long, Integer> _e_ : this.item_holders.entrySet())
/*      */       {
/*  184 */         _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/*  185 */         _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  187 */       _output_.writeInt32(4, this.send_card_count);
/*  188 */       for (Long _v_ : this.mail_receivers)
/*      */       {
/*  190 */         _output_.writeInt64(5, _v_.longValue());
/*      */       }
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  195 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  197 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  203 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  206 */       boolean done = false;
/*  207 */       while (!done)
/*      */       {
/*  209 */         int tag = _input_.readTag();
/*  210 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  214 */           done = true;
/*  215 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  219 */           this.delivery_count = _input_.readInt32();
/*  220 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  224 */           long _v_ = 0L;
/*  225 */           _v_ = _input_.readInt64();
/*  226 */           this.recycled_item_list.add(Long.valueOf(_v_));
/*  227 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  231 */           long _k_ = 0L;
/*  232 */           _k_ = _input_.readInt64();
/*  233 */           int readTag = _input_.readTag();
/*  234 */           if (24 != readTag)
/*      */           {
/*  236 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  238 */           int _v_ = 0;
/*  239 */           _v_ = _input_.readInt32();
/*  240 */           this.item_holders.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  241 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  245 */           this.send_card_count = _input_.readInt32();
/*  246 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  250 */           long _v_ = 0L;
/*  251 */           _v_ = _input_.readInt64();
/*  252 */           this.mail_receivers.add(Long.valueOf(_v_));
/*  253 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  257 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  259 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  268 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  272 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  274 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.DeliveryStatus copy()
/*      */   {
/*  280 */     _xdb_verify_unsafe_();
/*  281 */     return new DeliveryStatus(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.DeliveryStatus toData()
/*      */   {
/*  287 */     _xdb_verify_unsafe_();
/*  288 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.DeliveryStatus toBean()
/*      */   {
/*  293 */     _xdb_verify_unsafe_();
/*  294 */     return new DeliveryStatus(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.DeliveryStatus toDataIf()
/*      */   {
/*  300 */     _xdb_verify_unsafe_();
/*  301 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.DeliveryStatus toBeanIf()
/*      */   {
/*  306 */     _xdb_verify_unsafe_();
/*  307 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  313 */     _xdb_verify_unsafe_();
/*  314 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getDelivery_count()
/*      */   {
/*  321 */     _xdb_verify_unsafe_();
/*  322 */     return this.delivery_count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public java.util.List<Long> getRecycled_item_list()
/*      */   {
/*  329 */     _xdb_verify_unsafe_();
/*  330 */     return xdb.Logs.logList(new LogKey(this, "recycled_item_list"), this.recycled_item_list);
/*      */   }
/*      */   
/*      */ 
/*      */   public java.util.List<Long> getRecycled_item_listAsData()
/*      */   {
/*  336 */     _xdb_verify_unsafe_();
/*      */     
/*  338 */     DeliveryStatus _o_ = this;
/*  339 */     java.util.List<Long> recycled_item_list = new LinkedList();
/*  340 */     recycled_item_list.addAll(_o_.recycled_item_list);
/*  341 */     return recycled_item_list;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public java.util.Map<Long, Integer> getItem_holders()
/*      */   {
/*  348 */     _xdb_verify_unsafe_();
/*  349 */     return xdb.Logs.logMap(new LogKey(this, "item_holders"), this.item_holders);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public java.util.Map<Long, Integer> getItem_holdersAsData()
/*      */   {
/*  356 */     _xdb_verify_unsafe_();
/*      */     
/*  358 */     DeliveryStatus _o_ = this;
/*  359 */     java.util.Map<Long, Integer> item_holders = new HashMap();
/*  360 */     for (Map.Entry<Long, Integer> _e_ : _o_.item_holders.entrySet())
/*  361 */       item_holders.put(_e_.getKey(), _e_.getValue());
/*  362 */     return item_holders;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getSend_card_count()
/*      */   {
/*  369 */     _xdb_verify_unsafe_();
/*  370 */     return this.send_card_count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Long> getMail_receivers()
/*      */   {
/*  377 */     _xdb_verify_unsafe_();
/*  378 */     return xdb.Logs.logSet(new LogKey(this, "mail_receivers"), this.mail_receivers);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Long> getMail_receiversAsData()
/*      */   {
/*  384 */     _xdb_verify_unsafe_();
/*      */     
/*  386 */     DeliveryStatus _o_ = this;
/*  387 */     Set<Long> mail_receivers = new SetX();
/*  388 */     mail_receivers.addAll(_o_.mail_receivers);
/*  389 */     return mail_receivers;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDelivery_count(int _v_)
/*      */   {
/*  396 */     _xdb_verify_unsafe_();
/*  397 */     xdb.Logs.logIf(new LogKey(this, "delivery_count")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  401 */         new xdb.logs.LogInt(this, DeliveryStatus.this.delivery_count)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  405 */             DeliveryStatus.this.delivery_count = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  409 */     });
/*  410 */     this.delivery_count = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSend_card_count(int _v_)
/*      */   {
/*  417 */     _xdb_verify_unsafe_();
/*  418 */     xdb.Logs.logIf(new LogKey(this, "send_card_count")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  422 */         new xdb.logs.LogInt(this, DeliveryStatus.this.send_card_count)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  426 */             DeliveryStatus.this.send_card_count = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  430 */     });
/*  431 */     this.send_card_count = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  437 */     _xdb_verify_unsafe_();
/*  438 */     DeliveryStatus _o_ = null;
/*  439 */     if ((_o1_ instanceof DeliveryStatus)) { _o_ = (DeliveryStatus)_o1_;
/*  440 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  441 */       return false;
/*  442 */     if (this.delivery_count != _o_.delivery_count) return false;
/*  443 */     if (!this.recycled_item_list.equals(_o_.recycled_item_list)) return false;
/*  444 */     if (!this.item_holders.equals(_o_.item_holders)) return false;
/*  445 */     if (this.send_card_count != _o_.send_card_count) return false;
/*  446 */     if (!this.mail_receivers.equals(_o_.mail_receivers)) return false;
/*  447 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  453 */     _xdb_verify_unsafe_();
/*  454 */     int _h_ = 0;
/*  455 */     _h_ += this.delivery_count;
/*  456 */     _h_ += this.recycled_item_list.hashCode();
/*  457 */     _h_ += this.item_holders.hashCode();
/*  458 */     _h_ += this.send_card_count;
/*  459 */     _h_ += this.mail_receivers.hashCode();
/*  460 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  466 */     _xdb_verify_unsafe_();
/*  467 */     StringBuilder _sb_ = new StringBuilder();
/*  468 */     _sb_.append("(");
/*  469 */     _sb_.append(this.delivery_count);
/*  470 */     _sb_.append(",");
/*  471 */     _sb_.append(this.recycled_item_list);
/*  472 */     _sb_.append(",");
/*  473 */     _sb_.append(this.item_holders);
/*  474 */     _sb_.append(",");
/*  475 */     _sb_.append(this.send_card_count);
/*  476 */     _sb_.append(",");
/*  477 */     _sb_.append(this.mail_receivers);
/*  478 */     _sb_.append(")");
/*  479 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  485 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  486 */     lb.add(new xdb.logs.ListenableChanged().setVarName("delivery_count"));
/*  487 */     lb.add(new xdb.logs.ListenableChanged().setVarName("recycled_item_list"));
/*  488 */     lb.add(new xdb.logs.ListenableMap().setVarName("item_holders"));
/*  489 */     lb.add(new xdb.logs.ListenableChanged().setVarName("send_card_count"));
/*  490 */     lb.add(new xdb.logs.ListenableSet().setVarName("mail_receivers"));
/*  491 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.DeliveryStatus {
/*      */     private Const() {}
/*      */     
/*      */     DeliveryStatus nThis() {
/*  498 */       return DeliveryStatus.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  504 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DeliveryStatus copy()
/*      */     {
/*  510 */       return DeliveryStatus.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DeliveryStatus toData()
/*      */     {
/*  516 */       return DeliveryStatus.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.DeliveryStatus toBean()
/*      */     {
/*  521 */       return DeliveryStatus.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DeliveryStatus toDataIf()
/*      */     {
/*  527 */       return DeliveryStatus.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.DeliveryStatus toBeanIf()
/*      */     {
/*  532 */       return DeliveryStatus.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDelivery_count()
/*      */     {
/*  539 */       DeliveryStatus.this._xdb_verify_unsafe_();
/*  540 */       return DeliveryStatus.this.delivery_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public java.util.List<Long> getRecycled_item_list()
/*      */     {
/*  547 */       DeliveryStatus.this._xdb_verify_unsafe_();
/*  548 */       return xdb.Consts.constList(DeliveryStatus.this.recycled_item_list);
/*      */     }
/*      */     
/*      */ 
/*      */     public java.util.List<Long> getRecycled_item_listAsData()
/*      */     {
/*  554 */       DeliveryStatus.this._xdb_verify_unsafe_();
/*      */       
/*  556 */       DeliveryStatus _o_ = DeliveryStatus.this;
/*  557 */       java.util.List<Long> recycled_item_list = new LinkedList();
/*  558 */       recycled_item_list.addAll(_o_.recycled_item_list);
/*  559 */       return recycled_item_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public java.util.Map<Long, Integer> getItem_holders()
/*      */     {
/*  566 */       DeliveryStatus.this._xdb_verify_unsafe_();
/*  567 */       return xdb.Consts.constMap(DeliveryStatus.this.item_holders);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public java.util.Map<Long, Integer> getItem_holdersAsData()
/*      */     {
/*  574 */       DeliveryStatus.this._xdb_verify_unsafe_();
/*      */       
/*  576 */       DeliveryStatus _o_ = DeliveryStatus.this;
/*  577 */       java.util.Map<Long, Integer> item_holders = new HashMap();
/*  578 */       for (Map.Entry<Long, Integer> _e_ : _o_.item_holders.entrySet())
/*  579 */         item_holders.put(_e_.getKey(), _e_.getValue());
/*  580 */       return item_holders;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSend_card_count()
/*      */     {
/*  587 */       DeliveryStatus.this._xdb_verify_unsafe_();
/*  588 */       return DeliveryStatus.this.send_card_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getMail_receivers()
/*      */     {
/*  595 */       DeliveryStatus.this._xdb_verify_unsafe_();
/*  596 */       return xdb.Consts.constSet(DeliveryStatus.this.mail_receivers);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Long> getMail_receiversAsData()
/*      */     {
/*  602 */       DeliveryStatus.this._xdb_verify_unsafe_();
/*      */       
/*  604 */       DeliveryStatus _o_ = DeliveryStatus.this;
/*  605 */       Set<Long> mail_receivers = new SetX();
/*  606 */       mail_receivers.addAll(_o_.mail_receivers);
/*  607 */       return mail_receivers;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDelivery_count(int _v_)
/*      */     {
/*  614 */       DeliveryStatus.this._xdb_verify_unsafe_();
/*  615 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSend_card_count(int _v_)
/*      */     {
/*  622 */       DeliveryStatus.this._xdb_verify_unsafe_();
/*  623 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  629 */       DeliveryStatus.this._xdb_verify_unsafe_();
/*  630 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  636 */       DeliveryStatus.this._xdb_verify_unsafe_();
/*  637 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  643 */       return DeliveryStatus.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  649 */       return DeliveryStatus.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  655 */       DeliveryStatus.this._xdb_verify_unsafe_();
/*  656 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  662 */       return DeliveryStatus.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  668 */       return DeliveryStatus.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  674 */       DeliveryStatus.this._xdb_verify_unsafe_();
/*  675 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  681 */       return DeliveryStatus.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  687 */       return DeliveryStatus.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  693 */       return DeliveryStatus.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  699 */       return DeliveryStatus.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  705 */       return DeliveryStatus.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  711 */       return DeliveryStatus.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  717 */       return DeliveryStatus.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.DeliveryStatus
/*      */   {
/*      */     private int delivery_count;
/*      */     
/*      */     private LinkedList<Long> recycled_item_list;
/*      */     
/*      */     private HashMap<Long, Integer> item_holders;
/*      */     
/*      */     private int send_card_count;
/*      */     
/*      */     private HashSet<Long> mail_receivers;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  737 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  742 */       this.recycled_item_list = new LinkedList();
/*  743 */       this.item_holders = new HashMap();
/*  744 */       this.mail_receivers = new HashSet();
/*      */     }
/*      */     
/*      */     Data(xbean.DeliveryStatus _o1_)
/*      */     {
/*  749 */       if ((_o1_ instanceof DeliveryStatus)) { assign((DeliveryStatus)_o1_);
/*  750 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  751 */       } else if ((_o1_ instanceof DeliveryStatus.Const)) assign(((DeliveryStatus.Const)_o1_).nThis()); else {
/*  752 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(DeliveryStatus _o_) {
/*  757 */       this.delivery_count = _o_.delivery_count;
/*  758 */       this.recycled_item_list = new LinkedList();
/*  759 */       this.recycled_item_list.addAll(_o_.recycled_item_list);
/*  760 */       this.item_holders = new HashMap();
/*  761 */       for (Map.Entry<Long, Integer> _e_ : _o_.item_holders.entrySet())
/*  762 */         this.item_holders.put(_e_.getKey(), _e_.getValue());
/*  763 */       this.send_card_count = _o_.send_card_count;
/*  764 */       this.mail_receivers = new HashSet();
/*  765 */       this.mail_receivers.addAll(_o_.mail_receivers);
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  770 */       this.delivery_count = _o_.delivery_count;
/*  771 */       this.recycled_item_list = new LinkedList();
/*  772 */       this.recycled_item_list.addAll(_o_.recycled_item_list);
/*  773 */       this.item_holders = new HashMap();
/*  774 */       for (Map.Entry<Long, Integer> _e_ : _o_.item_holders.entrySet())
/*  775 */         this.item_holders.put(_e_.getKey(), _e_.getValue());
/*  776 */       this.send_card_count = _o_.send_card_count;
/*  777 */       this.mail_receivers = new HashSet();
/*  778 */       this.mail_receivers.addAll(_o_.mail_receivers);
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  784 */       _os_.marshal(this.delivery_count);
/*  785 */       _os_.compact_uint32(this.recycled_item_list.size());
/*  786 */       for (Long _v_ : this.recycled_item_list)
/*      */       {
/*  788 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  790 */       _os_.compact_uint32(this.item_holders.size());
/*  791 */       for (Map.Entry<Long, Integer> _e_ : this.item_holders.entrySet())
/*      */       {
/*  793 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  794 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  796 */       _os_.marshal(this.send_card_count);
/*  797 */       _os_.compact_uint32(this.mail_receivers.size());
/*  798 */       for (Long _v_ : this.mail_receivers)
/*      */       {
/*  800 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  802 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  808 */       this.delivery_count = _os_.unmarshal_int();
/*  809 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  811 */         long _v_ = 0L;
/*  812 */         _v_ = _os_.unmarshal_long();
/*  813 */         this.recycled_item_list.add(Long.valueOf(_v_));
/*      */       }
/*      */       
/*  816 */       int size = _os_.uncompact_uint32();
/*  817 */       if (size >= 12)
/*      */       {
/*  819 */         this.item_holders = new HashMap(size * 2);
/*      */       }
/*  821 */       for (; size > 0; size--)
/*      */       {
/*  823 */         long _k_ = 0L;
/*  824 */         _k_ = _os_.unmarshal_long();
/*  825 */         int _v_ = 0;
/*  826 */         _v_ = _os_.unmarshal_int();
/*  827 */         this.item_holders.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  830 */       this.send_card_count = _os_.unmarshal_int();
/*  831 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  833 */         long _v_ = 0L;
/*  834 */         _v_ = _os_.unmarshal_long();
/*  835 */         this.mail_receivers.add(Long.valueOf(_v_));
/*      */       }
/*  837 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  843 */       int _size_ = 0;
/*  844 */       _size_ += CodedOutputStream.computeInt32Size(1, this.delivery_count);
/*  845 */       for (Long _v_ : this.recycled_item_list)
/*      */       {
/*  847 */         _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*      */       }
/*  849 */       for (Map.Entry<Long, Integer> _e_ : this.item_holders.entrySet())
/*      */       {
/*  851 */         _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/*  852 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  854 */       _size_ += CodedOutputStream.computeInt32Size(4, this.send_card_count);
/*  855 */       for (Long _v_ : this.mail_receivers)
/*      */       {
/*  857 */         _size_ += CodedOutputStream.computeInt64Size(5, _v_.longValue());
/*      */       }
/*  859 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  867 */         _output_.writeInt32(1, this.delivery_count);
/*  868 */         for (Long _v_ : this.recycled_item_list)
/*      */         {
/*  870 */           _output_.writeInt64(2, _v_.longValue());
/*      */         }
/*  872 */         for (Map.Entry<Long, Integer> _e_ : this.item_holders.entrySet())
/*      */         {
/*  874 */           _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/*  875 */           _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*  877 */         _output_.writeInt32(4, this.send_card_count);
/*  878 */         for (Long _v_ : this.mail_receivers)
/*      */         {
/*  880 */           _output_.writeInt64(5, _v_.longValue());
/*      */         }
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/*  885 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  887 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  895 */         boolean done = false;
/*  896 */         while (!done)
/*      */         {
/*  898 */           int tag = _input_.readTag();
/*  899 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  903 */             done = true;
/*  904 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  908 */             this.delivery_count = _input_.readInt32();
/*  909 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  913 */             long _v_ = 0L;
/*  914 */             _v_ = _input_.readInt64();
/*  915 */             this.recycled_item_list.add(Long.valueOf(_v_));
/*  916 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  920 */             long _k_ = 0L;
/*  921 */             _k_ = _input_.readInt64();
/*  922 */             int readTag = _input_.readTag();
/*  923 */             if (24 != readTag)
/*      */             {
/*  925 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  927 */             int _v_ = 0;
/*  928 */             _v_ = _input_.readInt32();
/*  929 */             this.item_holders.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  930 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  934 */             this.send_card_count = _input_.readInt32();
/*  935 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  939 */             long _v_ = 0L;
/*  940 */             _v_ = _input_.readInt64();
/*  941 */             this.mail_receivers.add(Long.valueOf(_v_));
/*  942 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  946 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  948 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  957 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/*  961 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  963 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DeliveryStatus copy()
/*      */     {
/*  969 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DeliveryStatus toData()
/*      */     {
/*  975 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.DeliveryStatus toBean()
/*      */     {
/*  980 */       return new DeliveryStatus(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DeliveryStatus toDataIf()
/*      */     {
/*  986 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.DeliveryStatus toBeanIf()
/*      */     {
/*  991 */       return new DeliveryStatus(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  997 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1001 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1005 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1009 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1013 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1017 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1021 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDelivery_count()
/*      */     {
/* 1028 */       return this.delivery_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public java.util.List<Long> getRecycled_item_list()
/*      */     {
/* 1035 */       return this.recycled_item_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public java.util.List<Long> getRecycled_item_listAsData()
/*      */     {
/* 1042 */       return this.recycled_item_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public java.util.Map<Long, Integer> getItem_holders()
/*      */     {
/* 1049 */       return this.item_holders;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public java.util.Map<Long, Integer> getItem_holdersAsData()
/*      */     {
/* 1056 */       return this.item_holders;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSend_card_count()
/*      */     {
/* 1063 */       return this.send_card_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getMail_receivers()
/*      */     {
/* 1070 */       return this.mail_receivers;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getMail_receiversAsData()
/*      */     {
/* 1077 */       return this.mail_receivers;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDelivery_count(int _v_)
/*      */     {
/* 1084 */       this.delivery_count = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSend_card_count(int _v_)
/*      */     {
/* 1091 */       this.send_card_count = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1097 */       if (!(_o1_ instanceof Data)) return false;
/* 1098 */       Data _o_ = (Data)_o1_;
/* 1099 */       if (this.delivery_count != _o_.delivery_count) return false;
/* 1100 */       if (!this.recycled_item_list.equals(_o_.recycled_item_list)) return false;
/* 1101 */       if (!this.item_holders.equals(_o_.item_holders)) return false;
/* 1102 */       if (this.send_card_count != _o_.send_card_count) return false;
/* 1103 */       if (!this.mail_receivers.equals(_o_.mail_receivers)) return false;
/* 1104 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1110 */       int _h_ = 0;
/* 1111 */       _h_ += this.delivery_count;
/* 1112 */       _h_ += this.recycled_item_list.hashCode();
/* 1113 */       _h_ += this.item_holders.hashCode();
/* 1114 */       _h_ += this.send_card_count;
/* 1115 */       _h_ += this.mail_receivers.hashCode();
/* 1116 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1122 */       StringBuilder _sb_ = new StringBuilder();
/* 1123 */       _sb_.append("(");
/* 1124 */       _sb_.append(this.delivery_count);
/* 1125 */       _sb_.append(",");
/* 1126 */       _sb_.append(this.recycled_item_list);
/* 1127 */       _sb_.append(",");
/* 1128 */       _sb_.append(this.item_holders);
/* 1129 */       _sb_.append(",");
/* 1130 */       _sb_.append(this.send_card_count);
/* 1131 */       _sb_.append(",");
/* 1132 */       _sb_.append(this.mail_receivers);
/* 1133 */       _sb_.append(")");
/* 1134 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\DeliveryStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */