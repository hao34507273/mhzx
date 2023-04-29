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
/*     */ public final class Giftid2count extends XBean implements xbean.Giftid2count
/*     */ {
/*     */   private HashMap<Integer, Integer> giftid2count;
/*     */   private HashMap<Integer, xbean.TimeLimitGiftInfo> gift_cfg_id2gift_info;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.giftid2count.clear();
/*  21 */     this.gift_cfg_id2gift_info.clear();
/*     */   }
/*     */   
/*     */   Giftid2count(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.giftid2count = new HashMap();
/*  28 */     this.gift_cfg_id2gift_info = new HashMap();
/*     */   }
/*     */   
/*     */   public Giftid2count()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public Giftid2count(Giftid2count _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   Giftid2count(xbean.Giftid2count _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof Giftid2count)) { assign((Giftid2count)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Giftid2count _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.giftid2count = new HashMap();
/*  54 */     for (Map.Entry<Integer, Integer> _e_ : _o_.giftid2count.entrySet())
/*  55 */       this.giftid2count.put(_e_.getKey(), _e_.getValue());
/*  56 */     this.gift_cfg_id2gift_info = new HashMap();
/*  57 */     for (Map.Entry<Integer, xbean.TimeLimitGiftInfo> _e_ : _o_.gift_cfg_id2gift_info.entrySet()) {
/*  58 */       this.gift_cfg_id2gift_info.put(_e_.getKey(), new TimeLimitGiftInfo((xbean.TimeLimitGiftInfo)_e_.getValue(), this, "gift_cfg_id2gift_info"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  63 */     this.giftid2count = new HashMap();
/*  64 */     for (Map.Entry<Integer, Integer> _e_ : _o_.giftid2count.entrySet())
/*  65 */       this.giftid2count.put(_e_.getKey(), _e_.getValue());
/*  66 */     this.gift_cfg_id2gift_info = new HashMap();
/*  67 */     for (Map.Entry<Integer, xbean.TimeLimitGiftInfo> _e_ : _o_.gift_cfg_id2gift_info.entrySet()) {
/*  68 */       this.gift_cfg_id2gift_info.put(_e_.getKey(), new TimeLimitGiftInfo((xbean.TimeLimitGiftInfo)_e_.getValue(), this, "gift_cfg_id2gift_info"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.compact_uint32(this.giftid2count.size());
/*  76 */     for (Map.Entry<Integer, Integer> _e_ : this.giftid2count.entrySet())
/*     */     {
/*  78 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  79 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  81 */     _os_.compact_uint32(this.gift_cfg_id2gift_info.size());
/*  82 */     for (Map.Entry<Integer, xbean.TimeLimitGiftInfo> _e_ : this.gift_cfg_id2gift_info.entrySet())
/*     */     {
/*  84 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  85 */       ((xbean.TimeLimitGiftInfo)_e_.getValue()).marshal(_os_);
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
/*  98 */       this.giftid2count = new HashMap(size * 2);
/*     */     }
/* 100 */     for (; size > 0; size--)
/*     */     {
/* 102 */       int _k_ = 0;
/* 103 */       _k_ = _os_.unmarshal_int();
/* 104 */       int _v_ = 0;
/* 105 */       _v_ = _os_.unmarshal_int();
/* 106 */       this.giftid2count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/*     */ 
/* 110 */     int size = _os_.uncompact_uint32();
/* 111 */     if (size >= 12)
/*     */     {
/* 113 */       this.gift_cfg_id2gift_info = new HashMap(size * 2);
/*     */     }
/* 115 */     for (; size > 0; size--)
/*     */     {
/* 117 */       int _k_ = 0;
/* 118 */       _k_ = _os_.unmarshal_int();
/* 119 */       xbean.TimeLimitGiftInfo _v_ = new TimeLimitGiftInfo(0, this, "gift_cfg_id2gift_info");
/* 120 */       _v_.unmarshal(_os_);
/* 121 */       this.gift_cfg_id2gift_info.put(Integer.valueOf(_k_), _v_);
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
/* 132 */     for (Map.Entry<Integer, Integer> _e_ : this.giftid2count.entrySet())
/*     */     {
/* 134 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 135 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 137 */     for (Map.Entry<Integer, xbean.TimeLimitGiftInfo> _e_ : this.gift_cfg_id2gift_info.entrySet())
/*     */     {
/* 139 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 140 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
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
/* 151 */       for (Map.Entry<Integer, Integer> _e_ : this.giftid2count.entrySet())
/*     */       {
/* 153 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 154 */         _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 156 */       for (Map.Entry<Integer, xbean.TimeLimitGiftInfo> _e_ : this.gift_cfg_id2gift_info.entrySet())
/*     */       {
/* 158 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 159 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
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
/* 197 */           this.giftid2count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 198 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 202 */           int _k_ = 0;
/* 203 */           _k_ = _input_.readInt32();
/* 204 */           int readTag = _input_.readTag();
/* 205 */           if (18 != readTag)
/*     */           {
/* 207 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 209 */           xbean.TimeLimitGiftInfo _v_ = new TimeLimitGiftInfo(0, this, "gift_cfg_id2gift_info");
/* 210 */           _input_.readMessage(_v_);
/* 211 */           this.gift_cfg_id2gift_info.put(Integer.valueOf(_k_), _v_);
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
/*     */   public xbean.Giftid2count copy()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return new Giftid2count(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Giftid2count toData()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Giftid2count toBean()
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     return new Giftid2count(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Giftid2count toDataIf()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Giftid2count toBeanIf()
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
/*     */   public Map<Integer, Integer> getGiftid2count()
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     return xdb.Logs.logMap(new xdb.LogKey(this, "giftid2count"), this.giftid2count);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getGiftid2countAsData()
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/*     */     
/* 290 */     Giftid2count _o_ = this;
/* 291 */     Map<Integer, Integer> giftid2count = new HashMap();
/* 292 */     for (Map.Entry<Integer, Integer> _e_ : _o_.giftid2count.entrySet())
/* 293 */       giftid2count.put(_e_.getKey(), _e_.getValue());
/* 294 */     return giftid2count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.TimeLimitGiftInfo> getGift_cfg_id2gift_info()
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     return xdb.Logs.logMap(new xdb.LogKey(this, "gift_cfg_id2gift_info"), this.gift_cfg_id2gift_info);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.TimeLimitGiftInfo> getGift_cfg_id2gift_infoAsData()
/*     */   {
/* 309 */     _xdb_verify_unsafe_();
/*     */     
/* 311 */     Giftid2count _o_ = this;
/* 312 */     Map<Integer, xbean.TimeLimitGiftInfo> gift_cfg_id2gift_info = new HashMap();
/* 313 */     for (Map.Entry<Integer, xbean.TimeLimitGiftInfo> _e_ : _o_.gift_cfg_id2gift_info.entrySet())
/* 314 */       gift_cfg_id2gift_info.put(_e_.getKey(), new TimeLimitGiftInfo.Data((xbean.TimeLimitGiftInfo)_e_.getValue()));
/* 315 */     return gift_cfg_id2gift_info;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     Giftid2count _o_ = null;
/* 323 */     if ((_o1_ instanceof Giftid2count)) { _o_ = (Giftid2count)_o1_;
/* 324 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 325 */       return false;
/* 326 */     if (!this.giftid2count.equals(_o_.giftid2count)) return false;
/* 327 */     if (!this.gift_cfg_id2gift_info.equals(_o_.gift_cfg_id2gift_info)) return false;
/* 328 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 334 */     _xdb_verify_unsafe_();
/* 335 */     int _h_ = 0;
/* 336 */     _h_ += this.giftid2count.hashCode();
/* 337 */     _h_ += this.gift_cfg_id2gift_info.hashCode();
/* 338 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 344 */     _xdb_verify_unsafe_();
/* 345 */     StringBuilder _sb_ = new StringBuilder();
/* 346 */     _sb_.append("(");
/* 347 */     _sb_.append(this.giftid2count);
/* 348 */     _sb_.append(",");
/* 349 */     _sb_.append(this.gift_cfg_id2gift_info);
/* 350 */     _sb_.append(")");
/* 351 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 357 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 358 */     lb.add(new xdb.logs.ListenableMap().setVarName("giftid2count"));
/* 359 */     lb.add(new xdb.logs.ListenableMap().setVarName("gift_cfg_id2gift_info"));
/* 360 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.Giftid2count {
/*     */     private Const() {}
/*     */     
/*     */     Giftid2count nThis() {
/* 367 */       return Giftid2count.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 373 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Giftid2count copy()
/*     */     {
/* 379 */       return Giftid2count.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Giftid2count toData()
/*     */     {
/* 385 */       return Giftid2count.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.Giftid2count toBean()
/*     */     {
/* 390 */       return Giftid2count.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Giftid2count toDataIf()
/*     */     {
/* 396 */       return Giftid2count.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.Giftid2count toBeanIf()
/*     */     {
/* 401 */       return Giftid2count.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getGiftid2count()
/*     */     {
/* 408 */       Giftid2count.this._xdb_verify_unsafe_();
/* 409 */       return xdb.Consts.constMap(Giftid2count.this.giftid2count);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getGiftid2countAsData()
/*     */     {
/* 416 */       Giftid2count.this._xdb_verify_unsafe_();
/*     */       
/* 418 */       Giftid2count _o_ = Giftid2count.this;
/* 419 */       Map<Integer, Integer> giftid2count = new HashMap();
/* 420 */       for (Map.Entry<Integer, Integer> _e_ : _o_.giftid2count.entrySet())
/* 421 */         giftid2count.put(_e_.getKey(), _e_.getValue());
/* 422 */       return giftid2count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.TimeLimitGiftInfo> getGift_cfg_id2gift_info()
/*     */     {
/* 429 */       Giftid2count.this._xdb_verify_unsafe_();
/* 430 */       return xdb.Consts.constMap(Giftid2count.this.gift_cfg_id2gift_info);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.TimeLimitGiftInfo> getGift_cfg_id2gift_infoAsData()
/*     */     {
/* 437 */       Giftid2count.this._xdb_verify_unsafe_();
/*     */       
/* 439 */       Giftid2count _o_ = Giftid2count.this;
/* 440 */       Map<Integer, xbean.TimeLimitGiftInfo> gift_cfg_id2gift_info = new HashMap();
/* 441 */       for (Map.Entry<Integer, xbean.TimeLimitGiftInfo> _e_ : _o_.gift_cfg_id2gift_info.entrySet())
/* 442 */         gift_cfg_id2gift_info.put(_e_.getKey(), new TimeLimitGiftInfo.Data((xbean.TimeLimitGiftInfo)_e_.getValue()));
/* 443 */       return gift_cfg_id2gift_info;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 449 */       Giftid2count.this._xdb_verify_unsafe_();
/* 450 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 456 */       Giftid2count.this._xdb_verify_unsafe_();
/* 457 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 463 */       return Giftid2count.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 469 */       return Giftid2count.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 475 */       Giftid2count.this._xdb_verify_unsafe_();
/* 476 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 482 */       return Giftid2count.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 488 */       return Giftid2count.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 494 */       Giftid2count.this._xdb_verify_unsafe_();
/* 495 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 501 */       return Giftid2count.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 507 */       return Giftid2count.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 513 */       return Giftid2count.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 519 */       return Giftid2count.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 525 */       return Giftid2count.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 531 */       return Giftid2count.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 537 */       return Giftid2count.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.Giftid2count
/*     */   {
/*     */     private HashMap<Integer, Integer> giftid2count;
/*     */     
/*     */     private HashMap<Integer, xbean.TimeLimitGiftInfo> gift_cfg_id2gift_info;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 551 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 556 */       this.giftid2count = new HashMap();
/* 557 */       this.gift_cfg_id2gift_info = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.Giftid2count _o1_)
/*     */     {
/* 562 */       if ((_o1_ instanceof Giftid2count)) { assign((Giftid2count)_o1_);
/* 563 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 564 */       } else if ((_o1_ instanceof Giftid2count.Const)) assign(((Giftid2count.Const)_o1_).nThis()); else {
/* 565 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Giftid2count _o_) {
/* 570 */       this.giftid2count = new HashMap();
/* 571 */       for (Map.Entry<Integer, Integer> _e_ : _o_.giftid2count.entrySet())
/* 572 */         this.giftid2count.put(_e_.getKey(), _e_.getValue());
/* 573 */       this.gift_cfg_id2gift_info = new HashMap();
/* 574 */       for (Map.Entry<Integer, xbean.TimeLimitGiftInfo> _e_ : _o_.gift_cfg_id2gift_info.entrySet()) {
/* 575 */         this.gift_cfg_id2gift_info.put(_e_.getKey(), new TimeLimitGiftInfo.Data((xbean.TimeLimitGiftInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 580 */       this.giftid2count = new HashMap();
/* 581 */       for (Map.Entry<Integer, Integer> _e_ : _o_.giftid2count.entrySet())
/* 582 */         this.giftid2count.put(_e_.getKey(), _e_.getValue());
/* 583 */       this.gift_cfg_id2gift_info = new HashMap();
/* 584 */       for (Map.Entry<Integer, xbean.TimeLimitGiftInfo> _e_ : _o_.gift_cfg_id2gift_info.entrySet()) {
/* 585 */         this.gift_cfg_id2gift_info.put(_e_.getKey(), new TimeLimitGiftInfo.Data((xbean.TimeLimitGiftInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 591 */       _os_.compact_uint32(this.giftid2count.size());
/* 592 */       for (Map.Entry<Integer, Integer> _e_ : this.giftid2count.entrySet())
/*     */       {
/* 594 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 595 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 597 */       _os_.compact_uint32(this.gift_cfg_id2gift_info.size());
/* 598 */       for (Map.Entry<Integer, xbean.TimeLimitGiftInfo> _e_ : this.gift_cfg_id2gift_info.entrySet())
/*     */       {
/* 600 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 601 */         ((xbean.TimeLimitGiftInfo)_e_.getValue()).marshal(_os_);
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
/* 613 */         this.giftid2count = new HashMap(size * 2);
/*     */       }
/* 615 */       for (; size > 0; size--)
/*     */       {
/* 617 */         int _k_ = 0;
/* 618 */         _k_ = _os_.unmarshal_int();
/* 619 */         int _v_ = 0;
/* 620 */         _v_ = _os_.unmarshal_int();
/* 621 */         this.giftid2count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/*     */ 
/* 625 */       int size = _os_.uncompact_uint32();
/* 626 */       if (size >= 12)
/*     */       {
/* 628 */         this.gift_cfg_id2gift_info = new HashMap(size * 2);
/*     */       }
/* 630 */       for (; size > 0; size--)
/*     */       {
/* 632 */         int _k_ = 0;
/* 633 */         _k_ = _os_.unmarshal_int();
/* 634 */         xbean.TimeLimitGiftInfo _v_ = xbean.Pod.newTimeLimitGiftInfoData();
/* 635 */         _v_.unmarshal(_os_);
/* 636 */         this.gift_cfg_id2gift_info.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 639 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 645 */       int _size_ = 0;
/* 646 */       for (Map.Entry<Integer, Integer> _e_ : this.giftid2count.entrySet())
/*     */       {
/* 648 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 649 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 651 */       for (Map.Entry<Integer, xbean.TimeLimitGiftInfo> _e_ : this.gift_cfg_id2gift_info.entrySet())
/*     */       {
/* 653 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 654 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 656 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 664 */         for (Map.Entry<Integer, Integer> _e_ : this.giftid2count.entrySet())
/*     */         {
/* 666 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 667 */           _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*     */         }
/* 669 */         for (Map.Entry<Integer, xbean.TimeLimitGiftInfo> _e_ : this.gift_cfg_id2gift_info.entrySet())
/*     */         {
/* 671 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 672 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
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
/* 709 */             this.giftid2count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 710 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 714 */             int _k_ = 0;
/* 715 */             _k_ = _input_.readInt32();
/* 716 */             int readTag = _input_.readTag();
/* 717 */             if (18 != readTag)
/*     */             {
/* 719 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 721 */             xbean.TimeLimitGiftInfo _v_ = xbean.Pod.newTimeLimitGiftInfoData();
/* 722 */             _input_.readMessage(_v_);
/* 723 */             this.gift_cfg_id2gift_info.put(Integer.valueOf(_k_), _v_);
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
/*     */     public xbean.Giftid2count copy()
/*     */     {
/* 751 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Giftid2count toData()
/*     */     {
/* 757 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.Giftid2count toBean()
/*     */     {
/* 762 */       return new Giftid2count(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Giftid2count toDataIf()
/*     */     {
/* 768 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.Giftid2count toBeanIf()
/*     */     {
/* 773 */       return new Giftid2count(this, null, null);
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
/*     */     public Map<Integer, Integer> getGiftid2count()
/*     */     {
/* 810 */       return this.giftid2count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getGiftid2countAsData()
/*     */     {
/* 817 */       return this.giftid2count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.TimeLimitGiftInfo> getGift_cfg_id2gift_info()
/*     */     {
/* 824 */       return this.gift_cfg_id2gift_info;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.TimeLimitGiftInfo> getGift_cfg_id2gift_infoAsData()
/*     */     {
/* 831 */       return this.gift_cfg_id2gift_info;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 837 */       if (!(_o1_ instanceof Data)) return false;
/* 838 */       Data _o_ = (Data)_o1_;
/* 839 */       if (!this.giftid2count.equals(_o_.giftid2count)) return false;
/* 840 */       if (!this.gift_cfg_id2gift_info.equals(_o_.gift_cfg_id2gift_info)) return false;
/* 841 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 847 */       int _h_ = 0;
/* 848 */       _h_ += this.giftid2count.hashCode();
/* 849 */       _h_ += this.gift_cfg_id2gift_info.hashCode();
/* 850 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 856 */       StringBuilder _sb_ = new StringBuilder();
/* 857 */       _sb_.append("(");
/* 858 */       _sb_.append(this.giftid2count);
/* 859 */       _sb_.append(",");
/* 860 */       _sb_.append(this.gift_cfg_id2gift_info);
/* 861 */       _sb_.append(")");
/* 862 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Giftid2count.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */