/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class WingPlan extends XBean implements xbean.WingPlan
/*      */ {
/*      */   private int curlv;
/*      */   private int currank;
/*      */   private int curexp;
/*      */   private int curwing;
/*      */   private HashMap<Integer, xbean.WingContent> wings;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.curlv = 0;
/*   27 */     this.currank = 0;
/*   28 */     this.curexp = 0;
/*   29 */     this.curwing = 0;
/*   30 */     this.wings.clear();
/*      */   }
/*      */   
/*      */   WingPlan(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.wings = new HashMap();
/*      */   }
/*      */   
/*      */   public WingPlan()
/*      */   {
/*   41 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public WingPlan(WingPlan _o_)
/*      */   {
/*   46 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   WingPlan(xbean.WingPlan _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   51 */     super(_xp_, _vn_);
/*   52 */     if ((_o1_ instanceof WingPlan)) { assign((WingPlan)_o1_);
/*   53 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   54 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   55 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(WingPlan _o_) {
/*   60 */     _o_._xdb_verify_unsafe_();
/*   61 */     this.curlv = _o_.curlv;
/*   62 */     this.currank = _o_.currank;
/*   63 */     this.curexp = _o_.curexp;
/*   64 */     this.curwing = _o_.curwing;
/*   65 */     this.wings = new HashMap();
/*   66 */     for (Map.Entry<Integer, xbean.WingContent> _e_ : _o_.wings.entrySet()) {
/*   67 */       this.wings.put(_e_.getKey(), new WingContent((xbean.WingContent)_e_.getValue(), this, "wings"));
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   72 */     this.curlv = _o_.curlv;
/*   73 */     this.currank = _o_.currank;
/*   74 */     this.curexp = _o_.curexp;
/*   75 */     this.curwing = _o_.curwing;
/*   76 */     this.wings = new HashMap();
/*   77 */     for (Map.Entry<Integer, xbean.WingContent> _e_ : _o_.wings.entrySet()) {
/*   78 */       this.wings.put(_e_.getKey(), new WingContent((xbean.WingContent)_e_.getValue(), this, "wings"));
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   84 */     _xdb_verify_unsafe_();
/*   85 */     _os_.marshal(this.curlv);
/*   86 */     _os_.marshal(this.currank);
/*   87 */     _os_.marshal(this.curexp);
/*   88 */     _os_.marshal(this.curwing);
/*   89 */     _os_.compact_uint32(this.wings.size());
/*   90 */     for (Map.Entry<Integer, xbean.WingContent> _e_ : this.wings.entrySet())
/*      */     {
/*   92 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*   93 */       ((xbean.WingContent)_e_.getValue()).marshal(_os_);
/*      */     }
/*   95 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  101 */     _xdb_verify_unsafe_();
/*  102 */     this.curlv = _os_.unmarshal_int();
/*  103 */     this.currank = _os_.unmarshal_int();
/*  104 */     this.curexp = _os_.unmarshal_int();
/*  105 */     this.curwing = _os_.unmarshal_int();
/*      */     
/*  107 */     int size = _os_.uncompact_uint32();
/*  108 */     if (size >= 12)
/*      */     {
/*  110 */       this.wings = new HashMap(size * 2);
/*      */     }
/*  112 */     for (; size > 0; size--)
/*      */     {
/*  114 */       int _k_ = 0;
/*  115 */       _k_ = _os_.unmarshal_int();
/*  116 */       xbean.WingContent _v_ = new WingContent(0, this, "wings");
/*  117 */       _v_.unmarshal(_os_);
/*  118 */       this.wings.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  121 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  127 */     _xdb_verify_unsafe_();
/*  128 */     int _size_ = 0;
/*  129 */     _size_ += CodedOutputStream.computeInt32Size(1, this.curlv);
/*  130 */     _size_ += CodedOutputStream.computeInt32Size(2, this.currank);
/*  131 */     _size_ += CodedOutputStream.computeInt32Size(3, this.curexp);
/*  132 */     _size_ += CodedOutputStream.computeInt32Size(4, this.curwing);
/*  133 */     for (Map.Entry<Integer, xbean.WingContent> _e_ : this.wings.entrySet())
/*      */     {
/*  135 */       _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getKey()).intValue());
/*  136 */       _size_ += CodedOutputStream.computeMessageSize(5, (ppbio.Message)_e_.getValue());
/*      */     }
/*  138 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  144 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  147 */       _output_.writeInt32(1, this.curlv);
/*  148 */       _output_.writeInt32(2, this.currank);
/*  149 */       _output_.writeInt32(3, this.curexp);
/*  150 */       _output_.writeInt32(4, this.curwing);
/*  151 */       for (Map.Entry<Integer, xbean.WingContent> _e_ : this.wings.entrySet())
/*      */       {
/*  153 */         _output_.writeInt32(5, ((Integer)_e_.getKey()).intValue());
/*  154 */         _output_.writeMessage(5, (ppbio.Message)_e_.getValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  159 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  161 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  167 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  170 */       boolean done = false;
/*  171 */       while (!done)
/*      */       {
/*  173 */         int tag = _input_.readTag();
/*  174 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  178 */           done = true;
/*  179 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  183 */           this.curlv = _input_.readInt32();
/*  184 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  188 */           this.currank = _input_.readInt32();
/*  189 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  193 */           this.curexp = _input_.readInt32();
/*  194 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  198 */           this.curwing = _input_.readInt32();
/*  199 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  203 */           int _k_ = 0;
/*  204 */           _k_ = _input_.readInt32();
/*  205 */           int readTag = _input_.readTag();
/*  206 */           if (42 != readTag)
/*      */           {
/*  208 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  210 */           xbean.WingContent _v_ = new WingContent(0, this, "wings");
/*  211 */           _input_.readMessage(_v_);
/*  212 */           this.wings.put(Integer.valueOf(_k_), _v_);
/*  213 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  217 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  219 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  228 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  232 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  234 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.WingPlan copy()
/*      */   {
/*  240 */     _xdb_verify_unsafe_();
/*  241 */     return new WingPlan(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.WingPlan toData()
/*      */   {
/*  247 */     _xdb_verify_unsafe_();
/*  248 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.WingPlan toBean()
/*      */   {
/*  253 */     _xdb_verify_unsafe_();
/*  254 */     return new WingPlan(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.WingPlan toDataIf()
/*      */   {
/*  260 */     _xdb_verify_unsafe_();
/*  261 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.WingPlan toBeanIf()
/*      */   {
/*  266 */     _xdb_verify_unsafe_();
/*  267 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  273 */     _xdb_verify_unsafe_();
/*  274 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurlv()
/*      */   {
/*  281 */     _xdb_verify_unsafe_();
/*  282 */     return this.curlv;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurrank()
/*      */   {
/*  289 */     _xdb_verify_unsafe_();
/*  290 */     return this.currank;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurexp()
/*      */   {
/*  297 */     _xdb_verify_unsafe_();
/*  298 */     return this.curexp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurwing()
/*      */   {
/*  305 */     _xdb_verify_unsafe_();
/*  306 */     return this.curwing;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.WingContent> getWings()
/*      */   {
/*  313 */     _xdb_verify_unsafe_();
/*  314 */     return xdb.Logs.logMap(new LogKey(this, "wings"), this.wings);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.WingContent> getWingsAsData()
/*      */   {
/*  321 */     _xdb_verify_unsafe_();
/*      */     
/*  323 */     WingPlan _o_ = this;
/*  324 */     Map<Integer, xbean.WingContent> wings = new HashMap();
/*  325 */     for (Map.Entry<Integer, xbean.WingContent> _e_ : _o_.wings.entrySet())
/*  326 */       wings.put(_e_.getKey(), new WingContent.Data((xbean.WingContent)_e_.getValue()));
/*  327 */     return wings;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurlv(int _v_)
/*      */   {
/*  334 */     _xdb_verify_unsafe_();
/*  335 */     xdb.Logs.logIf(new LogKey(this, "curlv")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  339 */         new LogInt(this, WingPlan.this.curlv)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  343 */             WingPlan.this.curlv = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  347 */     });
/*  348 */     this.curlv = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurrank(int _v_)
/*      */   {
/*  355 */     _xdb_verify_unsafe_();
/*  356 */     xdb.Logs.logIf(new LogKey(this, "currank")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  360 */         new LogInt(this, WingPlan.this.currank)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  364 */             WingPlan.this.currank = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  368 */     });
/*  369 */     this.currank = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurexp(int _v_)
/*      */   {
/*  376 */     _xdb_verify_unsafe_();
/*  377 */     xdb.Logs.logIf(new LogKey(this, "curexp")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  381 */         new LogInt(this, WingPlan.this.curexp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  385 */             WingPlan.this.curexp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  389 */     });
/*  390 */     this.curexp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurwing(int _v_)
/*      */   {
/*  397 */     _xdb_verify_unsafe_();
/*  398 */     xdb.Logs.logIf(new LogKey(this, "curwing")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  402 */         new LogInt(this, WingPlan.this.curwing)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  406 */             WingPlan.this.curwing = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  410 */     });
/*  411 */     this.curwing = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  417 */     _xdb_verify_unsafe_();
/*  418 */     WingPlan _o_ = null;
/*  419 */     if ((_o1_ instanceof WingPlan)) { _o_ = (WingPlan)_o1_;
/*  420 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  421 */       return false;
/*  422 */     if (this.curlv != _o_.curlv) return false;
/*  423 */     if (this.currank != _o_.currank) return false;
/*  424 */     if (this.curexp != _o_.curexp) return false;
/*  425 */     if (this.curwing != _o_.curwing) return false;
/*  426 */     if (!this.wings.equals(_o_.wings)) return false;
/*  427 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  433 */     _xdb_verify_unsafe_();
/*  434 */     int _h_ = 0;
/*  435 */     _h_ += this.curlv;
/*  436 */     _h_ += this.currank;
/*  437 */     _h_ += this.curexp;
/*  438 */     _h_ += this.curwing;
/*  439 */     _h_ += this.wings.hashCode();
/*  440 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  446 */     _xdb_verify_unsafe_();
/*  447 */     StringBuilder _sb_ = new StringBuilder();
/*  448 */     _sb_.append("(");
/*  449 */     _sb_.append(this.curlv);
/*  450 */     _sb_.append(",");
/*  451 */     _sb_.append(this.currank);
/*  452 */     _sb_.append(",");
/*  453 */     _sb_.append(this.curexp);
/*  454 */     _sb_.append(",");
/*  455 */     _sb_.append(this.curwing);
/*  456 */     _sb_.append(",");
/*  457 */     _sb_.append(this.wings);
/*  458 */     _sb_.append(")");
/*  459 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  465 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  466 */     lb.add(new ListenableChanged().setVarName("curlv"));
/*  467 */     lb.add(new ListenableChanged().setVarName("currank"));
/*  468 */     lb.add(new ListenableChanged().setVarName("curexp"));
/*  469 */     lb.add(new ListenableChanged().setVarName("curwing"));
/*  470 */     lb.add(new xdb.logs.ListenableMap().setVarName("wings"));
/*  471 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.WingPlan {
/*      */     private Const() {}
/*      */     
/*      */     WingPlan nThis() {
/*  478 */       return WingPlan.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  484 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WingPlan copy()
/*      */     {
/*  490 */       return WingPlan.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WingPlan toData()
/*      */     {
/*  496 */       return WingPlan.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.WingPlan toBean()
/*      */     {
/*  501 */       return WingPlan.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WingPlan toDataIf()
/*      */     {
/*  507 */       return WingPlan.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.WingPlan toBeanIf()
/*      */     {
/*  512 */       return WingPlan.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurlv()
/*      */     {
/*  519 */       WingPlan.this._xdb_verify_unsafe_();
/*  520 */       return WingPlan.this.curlv;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrank()
/*      */     {
/*  527 */       WingPlan.this._xdb_verify_unsafe_();
/*  528 */       return WingPlan.this.currank;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurexp()
/*      */     {
/*  535 */       WingPlan.this._xdb_verify_unsafe_();
/*  536 */       return WingPlan.this.curexp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurwing()
/*      */     {
/*  543 */       WingPlan.this._xdb_verify_unsafe_();
/*  544 */       return WingPlan.this.curwing;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.WingContent> getWings()
/*      */     {
/*  551 */       WingPlan.this._xdb_verify_unsafe_();
/*  552 */       return xdb.Consts.constMap(WingPlan.this.wings);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.WingContent> getWingsAsData()
/*      */     {
/*  559 */       WingPlan.this._xdb_verify_unsafe_();
/*      */       
/*  561 */       WingPlan _o_ = WingPlan.this;
/*  562 */       Map<Integer, xbean.WingContent> wings = new HashMap();
/*  563 */       for (Map.Entry<Integer, xbean.WingContent> _e_ : _o_.wings.entrySet())
/*  564 */         wings.put(_e_.getKey(), new WingContent.Data((xbean.WingContent)_e_.getValue()));
/*  565 */       return wings;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurlv(int _v_)
/*      */     {
/*  572 */       WingPlan.this._xdb_verify_unsafe_();
/*  573 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrank(int _v_)
/*      */     {
/*  580 */       WingPlan.this._xdb_verify_unsafe_();
/*  581 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurexp(int _v_)
/*      */     {
/*  588 */       WingPlan.this._xdb_verify_unsafe_();
/*  589 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurwing(int _v_)
/*      */     {
/*  596 */       WingPlan.this._xdb_verify_unsafe_();
/*  597 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  603 */       WingPlan.this._xdb_verify_unsafe_();
/*  604 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  610 */       WingPlan.this._xdb_verify_unsafe_();
/*  611 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  617 */       return WingPlan.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  623 */       return WingPlan.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  629 */       WingPlan.this._xdb_verify_unsafe_();
/*  630 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  636 */       return WingPlan.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  642 */       return WingPlan.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  648 */       WingPlan.this._xdb_verify_unsafe_();
/*  649 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  655 */       return WingPlan.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  661 */       return WingPlan.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  667 */       return WingPlan.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  673 */       return WingPlan.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  679 */       return WingPlan.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  685 */       return WingPlan.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  691 */       return WingPlan.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.WingPlan
/*      */   {
/*      */     private int curlv;
/*      */     
/*      */     private int currank;
/*      */     
/*      */     private int curexp;
/*      */     
/*      */     private int curwing;
/*      */     
/*      */     private HashMap<Integer, xbean.WingContent> wings;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  711 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  716 */       this.wings = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.WingPlan _o1_)
/*      */     {
/*  721 */       if ((_o1_ instanceof WingPlan)) { assign((WingPlan)_o1_);
/*  722 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  723 */       } else if ((_o1_ instanceof WingPlan.Const)) assign(((WingPlan.Const)_o1_).nThis()); else {
/*  724 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(WingPlan _o_) {
/*  729 */       this.curlv = _o_.curlv;
/*  730 */       this.currank = _o_.currank;
/*  731 */       this.curexp = _o_.curexp;
/*  732 */       this.curwing = _o_.curwing;
/*  733 */       this.wings = new HashMap();
/*  734 */       for (Map.Entry<Integer, xbean.WingContent> _e_ : _o_.wings.entrySet()) {
/*  735 */         this.wings.put(_e_.getKey(), new WingContent.Data((xbean.WingContent)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  740 */       this.curlv = _o_.curlv;
/*  741 */       this.currank = _o_.currank;
/*  742 */       this.curexp = _o_.curexp;
/*  743 */       this.curwing = _o_.curwing;
/*  744 */       this.wings = new HashMap();
/*  745 */       for (Map.Entry<Integer, xbean.WingContent> _e_ : _o_.wings.entrySet()) {
/*  746 */         this.wings.put(_e_.getKey(), new WingContent.Data((xbean.WingContent)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  752 */       _os_.marshal(this.curlv);
/*  753 */       _os_.marshal(this.currank);
/*  754 */       _os_.marshal(this.curexp);
/*  755 */       _os_.marshal(this.curwing);
/*  756 */       _os_.compact_uint32(this.wings.size());
/*  757 */       for (Map.Entry<Integer, xbean.WingContent> _e_ : this.wings.entrySet())
/*      */       {
/*  759 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  760 */         ((xbean.WingContent)_e_.getValue()).marshal(_os_);
/*      */       }
/*  762 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  768 */       this.curlv = _os_.unmarshal_int();
/*  769 */       this.currank = _os_.unmarshal_int();
/*  770 */       this.curexp = _os_.unmarshal_int();
/*  771 */       this.curwing = _os_.unmarshal_int();
/*      */       
/*  773 */       int size = _os_.uncompact_uint32();
/*  774 */       if (size >= 12)
/*      */       {
/*  776 */         this.wings = new HashMap(size * 2);
/*      */       }
/*  778 */       for (; size > 0; size--)
/*      */       {
/*  780 */         int _k_ = 0;
/*  781 */         _k_ = _os_.unmarshal_int();
/*  782 */         xbean.WingContent _v_ = xbean.Pod.newWingContentData();
/*  783 */         _v_.unmarshal(_os_);
/*  784 */         this.wings.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  787 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  793 */       int _size_ = 0;
/*  794 */       _size_ += CodedOutputStream.computeInt32Size(1, this.curlv);
/*  795 */       _size_ += CodedOutputStream.computeInt32Size(2, this.currank);
/*  796 */       _size_ += CodedOutputStream.computeInt32Size(3, this.curexp);
/*  797 */       _size_ += CodedOutputStream.computeInt32Size(4, this.curwing);
/*  798 */       for (Map.Entry<Integer, xbean.WingContent> _e_ : this.wings.entrySet())
/*      */       {
/*  800 */         _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getKey()).intValue());
/*  801 */         _size_ += CodedOutputStream.computeMessageSize(5, (ppbio.Message)_e_.getValue());
/*      */       }
/*  803 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  811 */         _output_.writeInt32(1, this.curlv);
/*  812 */         _output_.writeInt32(2, this.currank);
/*  813 */         _output_.writeInt32(3, this.curexp);
/*  814 */         _output_.writeInt32(4, this.curwing);
/*  815 */         for (Map.Entry<Integer, xbean.WingContent> _e_ : this.wings.entrySet())
/*      */         {
/*  817 */           _output_.writeInt32(5, ((Integer)_e_.getKey()).intValue());
/*  818 */           _output_.writeMessage(5, (ppbio.Message)_e_.getValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  823 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  825 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  833 */         boolean done = false;
/*  834 */         while (!done)
/*      */         {
/*  836 */           int tag = _input_.readTag();
/*  837 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  841 */             done = true;
/*  842 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  846 */             this.curlv = _input_.readInt32();
/*  847 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  851 */             this.currank = _input_.readInt32();
/*  852 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  856 */             this.curexp = _input_.readInt32();
/*  857 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  861 */             this.curwing = _input_.readInt32();
/*  862 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  866 */             int _k_ = 0;
/*  867 */             _k_ = _input_.readInt32();
/*  868 */             int readTag = _input_.readTag();
/*  869 */             if (42 != readTag)
/*      */             {
/*  871 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  873 */             xbean.WingContent _v_ = xbean.Pod.newWingContentData();
/*  874 */             _input_.readMessage(_v_);
/*  875 */             this.wings.put(Integer.valueOf(_k_), _v_);
/*  876 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  880 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  882 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  891 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  895 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  897 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WingPlan copy()
/*      */     {
/*  903 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WingPlan toData()
/*      */     {
/*  909 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.WingPlan toBean()
/*      */     {
/*  914 */       return new WingPlan(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WingPlan toDataIf()
/*      */     {
/*  920 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.WingPlan toBeanIf()
/*      */     {
/*  925 */       return new WingPlan(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  931 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  935 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  939 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  943 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  947 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  951 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  955 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurlv()
/*      */     {
/*  962 */       return this.curlv;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrank()
/*      */     {
/*  969 */       return this.currank;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurexp()
/*      */     {
/*  976 */       return this.curexp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurwing()
/*      */     {
/*  983 */       return this.curwing;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.WingContent> getWings()
/*      */     {
/*  990 */       return this.wings;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.WingContent> getWingsAsData()
/*      */     {
/*  997 */       return this.wings;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurlv(int _v_)
/*      */     {
/* 1004 */       this.curlv = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrank(int _v_)
/*      */     {
/* 1011 */       this.currank = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurexp(int _v_)
/*      */     {
/* 1018 */       this.curexp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurwing(int _v_)
/*      */     {
/* 1025 */       this.curwing = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1031 */       if (!(_o1_ instanceof Data)) return false;
/* 1032 */       Data _o_ = (Data)_o1_;
/* 1033 */       if (this.curlv != _o_.curlv) return false;
/* 1034 */       if (this.currank != _o_.currank) return false;
/* 1035 */       if (this.curexp != _o_.curexp) return false;
/* 1036 */       if (this.curwing != _o_.curwing) return false;
/* 1037 */       if (!this.wings.equals(_o_.wings)) return false;
/* 1038 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1044 */       int _h_ = 0;
/* 1045 */       _h_ += this.curlv;
/* 1046 */       _h_ += this.currank;
/* 1047 */       _h_ += this.curexp;
/* 1048 */       _h_ += this.curwing;
/* 1049 */       _h_ += this.wings.hashCode();
/* 1050 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1056 */       StringBuilder _sb_ = new StringBuilder();
/* 1057 */       _sb_.append("(");
/* 1058 */       _sb_.append(this.curlv);
/* 1059 */       _sb_.append(",");
/* 1060 */       _sb_.append(this.currank);
/* 1061 */       _sb_.append(",");
/* 1062 */       _sb_.append(this.curexp);
/* 1063 */       _sb_.append(",");
/* 1064 */       _sb_.append(this.curwing);
/* 1065 */       _sb_.append(",");
/* 1066 */       _sb_.append(this.wings);
/* 1067 */       _sb_.append(")");
/* 1068 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\WingPlan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */