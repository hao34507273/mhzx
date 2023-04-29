/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class GuideState extends XBean implements xbean.GuideState
/*     */ {
/*     */   private HashMap<Integer, Integer> guideid2state;
/*     */   private HashMap<Integer, Integer> guideid2param;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.guideid2state.clear();
/*  21 */     this.guideid2param.clear();
/*     */   }
/*     */   
/*     */   GuideState(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.guideid2state = new HashMap();
/*  28 */     this.guideid2param = new HashMap();
/*     */   }
/*     */   
/*     */   public GuideState()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public GuideState(GuideState _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   GuideState(xbean.GuideState _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof GuideState)) { assign((GuideState)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(GuideState _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.guideid2state = new HashMap();
/*  54 */     for (Map.Entry<Integer, Integer> _e_ : _o_.guideid2state.entrySet())
/*  55 */       this.guideid2state.put(_e_.getKey(), _e_.getValue());
/*  56 */     this.guideid2param = new HashMap();
/*  57 */     for (Map.Entry<Integer, Integer> _e_ : _o_.guideid2param.entrySet()) {
/*  58 */       this.guideid2param.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  63 */     this.guideid2state = new HashMap();
/*  64 */     for (Map.Entry<Integer, Integer> _e_ : _o_.guideid2state.entrySet())
/*  65 */       this.guideid2state.put(_e_.getKey(), _e_.getValue());
/*  66 */     this.guideid2param = new HashMap();
/*  67 */     for (Map.Entry<Integer, Integer> _e_ : _o_.guideid2param.entrySet()) {
/*  68 */       this.guideid2param.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.compact_uint32(this.guideid2state.size());
/*  76 */     for (Map.Entry<Integer, Integer> _e_ : this.guideid2state.entrySet())
/*     */     {
/*  78 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  79 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  81 */     _os_.compact_uint32(this.guideid2param.size());
/*  82 */     for (Map.Entry<Integer, Integer> _e_ : this.guideid2param.entrySet())
/*     */     {
/*  84 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  85 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  87 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  93 */     _xdb_verify_unsafe_();
/*     */     
/*  95 */     int size = _os_.uncompact_uint32();
/*  96 */     if (size >= 12)
/*     */     {
/*  98 */       this.guideid2state = new HashMap(size * 2);
/*     */     }
/* 100 */     for (; size > 0; size--)
/*     */     {
/* 102 */       int _k_ = 0;
/* 103 */       _k_ = _os_.unmarshal_int();
/* 104 */       int _v_ = 0;
/* 105 */       _v_ = _os_.unmarshal_int();
/* 106 */       this.guideid2state.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/*     */ 
/* 110 */     int size = _os_.uncompact_uint32();
/* 111 */     if (size >= 12)
/*     */     {
/* 113 */       this.guideid2param = new HashMap(size * 2);
/*     */     }
/* 115 */     for (; size > 0; size--)
/*     */     {
/* 117 */       int _k_ = 0;
/* 118 */       _k_ = _os_.unmarshal_int();
/* 119 */       int _v_ = 0;
/* 120 */       _v_ = _os_.unmarshal_int();
/* 121 */       this.guideid2param.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/* 124 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 130 */     _xdb_verify_unsafe_();
/* 131 */     int _size_ = 0;
/* 132 */     for (Map.Entry<Integer, Integer> _e_ : this.guideid2state.entrySet())
/*     */     {
/* 134 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 135 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 137 */     for (Map.Entry<Integer, Integer> _e_ : this.guideid2param.entrySet())
/*     */     {
/* 139 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 140 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 142 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 148 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 151 */       for (Map.Entry<Integer, Integer> _e_ : this.guideid2state.entrySet())
/*     */       {
/* 153 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 154 */         _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 156 */       for (Map.Entry<Integer, Integer> _e_ : this.guideid2param.entrySet())
/*     */       {
/* 158 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 159 */         _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 164 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 166 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 175 */       boolean done = false;
/* 176 */       while (!done)
/*     */       {
/* 178 */         int tag = _input_.readTag();
/* 179 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 183 */           done = true;
/* 184 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 188 */           int _k_ = 0;
/* 189 */           _k_ = _input_.readInt32();
/* 190 */           int readTag = _input_.readTag();
/* 191 */           if (8 != readTag)
/*     */           {
/* 193 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 195 */           int _v_ = 0;
/* 196 */           _v_ = _input_.readInt32();
/* 197 */           this.guideid2state.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 198 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 202 */           int _k_ = 0;
/* 203 */           _k_ = _input_.readInt32();
/* 204 */           int readTag = _input_.readTag();
/* 205 */           if (16 != readTag)
/*     */           {
/* 207 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 209 */           int _v_ = 0;
/* 210 */           _v_ = _input_.readInt32();
/* 211 */           this.guideid2param.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 212 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 216 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 218 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 227 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 231 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 233 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GuideState copy()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return new GuideState(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GuideState toData()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GuideState toBean()
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     return new GuideState(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GuideState toDataIf()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GuideState toBeanIf()
/*     */   {
/* 265 */     _xdb_verify_unsafe_();
/* 266 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 272 */     _xdb_verify_unsafe_();
/* 273 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getGuideid2state()
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     return xdb.Logs.logMap(new xdb.LogKey(this, "guideid2state"), this.guideid2state);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getGuideid2stateAsData()
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/*     */     
/* 290 */     GuideState _o_ = this;
/* 291 */     Map<Integer, Integer> guideid2state = new HashMap();
/* 292 */     for (Map.Entry<Integer, Integer> _e_ : _o_.guideid2state.entrySet())
/* 293 */       guideid2state.put(_e_.getKey(), _e_.getValue());
/* 294 */     return guideid2state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getGuideid2param()
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     return xdb.Logs.logMap(new xdb.LogKey(this, "guideid2param"), this.guideid2param);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getGuideid2paramAsData()
/*     */   {
/* 309 */     _xdb_verify_unsafe_();
/*     */     
/* 311 */     GuideState _o_ = this;
/* 312 */     Map<Integer, Integer> guideid2param = new HashMap();
/* 313 */     for (Map.Entry<Integer, Integer> _e_ : _o_.guideid2param.entrySet())
/* 314 */       guideid2param.put(_e_.getKey(), _e_.getValue());
/* 315 */     return guideid2param;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     GuideState _o_ = null;
/* 323 */     if ((_o1_ instanceof GuideState)) { _o_ = (GuideState)_o1_;
/* 324 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 325 */       return false;
/* 326 */     if (!this.guideid2state.equals(_o_.guideid2state)) return false;
/* 327 */     if (!this.guideid2param.equals(_o_.guideid2param)) return false;
/* 328 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 334 */     _xdb_verify_unsafe_();
/* 335 */     int _h_ = 0;
/* 336 */     _h_ += this.guideid2state.hashCode();
/* 337 */     _h_ += this.guideid2param.hashCode();
/* 338 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 344 */     _xdb_verify_unsafe_();
/* 345 */     StringBuilder _sb_ = new StringBuilder();
/* 346 */     _sb_.append("(");
/* 347 */     _sb_.append(this.guideid2state);
/* 348 */     _sb_.append(",");
/* 349 */     _sb_.append(this.guideid2param);
/* 350 */     _sb_.append(")");
/* 351 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 357 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 358 */     lb.add(new xdb.logs.ListenableMap().setVarName("guideid2state"));
/* 359 */     lb.add(new xdb.logs.ListenableMap().setVarName("guideid2param"));
/* 360 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.GuideState {
/*     */     private Const() {}
/*     */     
/*     */     GuideState nThis() {
/* 367 */       return GuideState.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 373 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GuideState copy()
/*     */     {
/* 379 */       return GuideState.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GuideState toData()
/*     */     {
/* 385 */       return GuideState.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.GuideState toBean()
/*     */     {
/* 390 */       return GuideState.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GuideState toDataIf()
/*     */     {
/* 396 */       return GuideState.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.GuideState toBeanIf()
/*     */     {
/* 401 */       return GuideState.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getGuideid2state()
/*     */     {
/* 408 */       GuideState.this._xdb_verify_unsafe_();
/* 409 */       return xdb.Consts.constMap(GuideState.this.guideid2state);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getGuideid2stateAsData()
/*     */     {
/* 416 */       GuideState.this._xdb_verify_unsafe_();
/*     */       
/* 418 */       GuideState _o_ = GuideState.this;
/* 419 */       Map<Integer, Integer> guideid2state = new HashMap();
/* 420 */       for (Map.Entry<Integer, Integer> _e_ : _o_.guideid2state.entrySet())
/* 421 */         guideid2state.put(_e_.getKey(), _e_.getValue());
/* 422 */       return guideid2state;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getGuideid2param()
/*     */     {
/* 429 */       GuideState.this._xdb_verify_unsafe_();
/* 430 */       return xdb.Consts.constMap(GuideState.this.guideid2param);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getGuideid2paramAsData()
/*     */     {
/* 437 */       GuideState.this._xdb_verify_unsafe_();
/*     */       
/* 439 */       GuideState _o_ = GuideState.this;
/* 440 */       Map<Integer, Integer> guideid2param = new HashMap();
/* 441 */       for (Map.Entry<Integer, Integer> _e_ : _o_.guideid2param.entrySet())
/* 442 */         guideid2param.put(_e_.getKey(), _e_.getValue());
/* 443 */       return guideid2param;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 449 */       GuideState.this._xdb_verify_unsafe_();
/* 450 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 456 */       GuideState.this._xdb_verify_unsafe_();
/* 457 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 463 */       return GuideState.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 469 */       return GuideState.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 475 */       GuideState.this._xdb_verify_unsafe_();
/* 476 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 482 */       return GuideState.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 488 */       return GuideState.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 494 */       GuideState.this._xdb_verify_unsafe_();
/* 495 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 501 */       return GuideState.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 507 */       return GuideState.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 513 */       return GuideState.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 519 */       return GuideState.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 525 */       return GuideState.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 531 */       return GuideState.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 537 */       return GuideState.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.GuideState
/*     */   {
/*     */     private HashMap<Integer, Integer> guideid2state;
/*     */     
/*     */     private HashMap<Integer, Integer> guideid2param;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 551 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 556 */       this.guideid2state = new HashMap();
/* 557 */       this.guideid2param = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.GuideState _o1_)
/*     */     {
/* 562 */       if ((_o1_ instanceof GuideState)) { assign((GuideState)_o1_);
/* 563 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 564 */       } else if ((_o1_ instanceof GuideState.Const)) assign(((GuideState.Const)_o1_).nThis()); else {
/* 565 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(GuideState _o_) {
/* 570 */       this.guideid2state = new HashMap();
/* 571 */       for (Map.Entry<Integer, Integer> _e_ : _o_.guideid2state.entrySet())
/* 572 */         this.guideid2state.put(_e_.getKey(), _e_.getValue());
/* 573 */       this.guideid2param = new HashMap();
/* 574 */       for (Map.Entry<Integer, Integer> _e_ : _o_.guideid2param.entrySet()) {
/* 575 */         this.guideid2param.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 580 */       this.guideid2state = new HashMap();
/* 581 */       for (Map.Entry<Integer, Integer> _e_ : _o_.guideid2state.entrySet())
/* 582 */         this.guideid2state.put(_e_.getKey(), _e_.getValue());
/* 583 */       this.guideid2param = new HashMap();
/* 584 */       for (Map.Entry<Integer, Integer> _e_ : _o_.guideid2param.entrySet()) {
/* 585 */         this.guideid2param.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 591 */       _os_.compact_uint32(this.guideid2state.size());
/* 592 */       for (Map.Entry<Integer, Integer> _e_ : this.guideid2state.entrySet())
/*     */       {
/* 594 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 595 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 597 */       _os_.compact_uint32(this.guideid2param.size());
/* 598 */       for (Map.Entry<Integer, Integer> _e_ : this.guideid2param.entrySet())
/*     */       {
/* 600 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 601 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 603 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 610 */       int size = _os_.uncompact_uint32();
/* 611 */       if (size >= 12)
/*     */       {
/* 613 */         this.guideid2state = new HashMap(size * 2);
/*     */       }
/* 615 */       for (; size > 0; size--)
/*     */       {
/* 617 */         int _k_ = 0;
/* 618 */         _k_ = _os_.unmarshal_int();
/* 619 */         int _v_ = 0;
/* 620 */         _v_ = _os_.unmarshal_int();
/* 621 */         this.guideid2state.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/*     */ 
/* 625 */       int size = _os_.uncompact_uint32();
/* 626 */       if (size >= 12)
/*     */       {
/* 628 */         this.guideid2param = new HashMap(size * 2);
/*     */       }
/* 630 */       for (; size > 0; size--)
/*     */       {
/* 632 */         int _k_ = 0;
/* 633 */         _k_ = _os_.unmarshal_int();
/* 634 */         int _v_ = 0;
/* 635 */         _v_ = _os_.unmarshal_int();
/* 636 */         this.guideid2param.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 639 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 645 */       int _size_ = 0;
/* 646 */       for (Map.Entry<Integer, Integer> _e_ : this.guideid2state.entrySet())
/*     */       {
/* 648 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 649 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 651 */       for (Map.Entry<Integer, Integer> _e_ : this.guideid2param.entrySet())
/*     */       {
/* 653 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 654 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 656 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 664 */         for (Map.Entry<Integer, Integer> _e_ : this.guideid2state.entrySet())
/*     */         {
/* 666 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 667 */           _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*     */         }
/* 669 */         for (Map.Entry<Integer, Integer> _e_ : this.guideid2param.entrySet())
/*     */         {
/* 671 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 672 */           _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 677 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 679 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 687 */         boolean done = false;
/* 688 */         while (!done)
/*     */         {
/* 690 */           int tag = _input_.readTag();
/* 691 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 695 */             done = true;
/* 696 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 700 */             int _k_ = 0;
/* 701 */             _k_ = _input_.readInt32();
/* 702 */             int readTag = _input_.readTag();
/* 703 */             if (8 != readTag)
/*     */             {
/* 705 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 707 */             int _v_ = 0;
/* 708 */             _v_ = _input_.readInt32();
/* 709 */             this.guideid2state.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 710 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 714 */             int _k_ = 0;
/* 715 */             _k_ = _input_.readInt32();
/* 716 */             int readTag = _input_.readTag();
/* 717 */             if (16 != readTag)
/*     */             {
/* 719 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 721 */             int _v_ = 0;
/* 722 */             _v_ = _input_.readInt32();
/* 723 */             this.guideid2param.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 724 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 728 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 730 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 739 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 743 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 745 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GuideState copy()
/*     */     {
/* 751 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GuideState toData()
/*     */     {
/* 757 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.GuideState toBean()
/*     */     {
/* 762 */       return new GuideState(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GuideState toDataIf()
/*     */     {
/* 768 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.GuideState toBeanIf()
/*     */     {
/* 773 */       return new GuideState(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 779 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 783 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 787 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 791 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 795 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 799 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 803 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getGuideid2state()
/*     */     {
/* 810 */       return this.guideid2state;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getGuideid2stateAsData()
/*     */     {
/* 817 */       return this.guideid2state;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getGuideid2param()
/*     */     {
/* 824 */       return this.guideid2param;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getGuideid2paramAsData()
/*     */     {
/* 831 */       return this.guideid2param;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 837 */       if (!(_o1_ instanceof Data)) return false;
/* 838 */       Data _o_ = (Data)_o1_;
/* 839 */       if (!this.guideid2state.equals(_o_.guideid2state)) return false;
/* 840 */       if (!this.guideid2param.equals(_o_.guideid2param)) return false;
/* 841 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 847 */       int _h_ = 0;
/* 848 */       _h_ += this.guideid2state.hashCode();
/* 849 */       _h_ += this.guideid2param.hashCode();
/* 850 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 856 */       StringBuilder _sb_ = new StringBuilder();
/* 857 */       _sb_.append("(");
/* 858 */       _sb_.append(this.guideid2state);
/* 859 */       _sb_.append(",");
/* 860 */       _sb_.append(this.guideid2param);
/* 861 */       _sb_.append(")");
/* 862 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GuideState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */