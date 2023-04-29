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
/*     */ public final class ShiTuActive extends XBean implements xbean.ShiTuActive
/*     */ {
/*     */   private long reset_time;
/*     */   private HashMap<Long, xbean.AwardIndexIds> award_map;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.reset_time = 0L;
/*  21 */     this.award_map.clear();
/*     */   }
/*     */   
/*     */   ShiTuActive(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.award_map = new HashMap();
/*     */   }
/*     */   
/*     */   public ShiTuActive()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ShiTuActive(ShiTuActive _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ShiTuActive(xbean.ShiTuActive _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof ShiTuActive)) { assign((ShiTuActive)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ShiTuActive _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.reset_time = _o_.reset_time;
/*  53 */     this.award_map = new HashMap();
/*  54 */     for (Map.Entry<Long, xbean.AwardIndexIds> _e_ : _o_.award_map.entrySet()) {
/*  55 */       this.award_map.put(_e_.getKey(), new AwardIndexIds((xbean.AwardIndexIds)_e_.getValue(), this, "award_map"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  60 */     this.reset_time = _o_.reset_time;
/*  61 */     this.award_map = new HashMap();
/*  62 */     for (Map.Entry<Long, xbean.AwardIndexIds> _e_ : _o_.award_map.entrySet()) {
/*  63 */       this.award_map.put(_e_.getKey(), new AwardIndexIds((xbean.AwardIndexIds)_e_.getValue(), this, "award_map"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.reset_time);
/*  71 */     _os_.compact_uint32(this.award_map.size());
/*  72 */     for (Map.Entry<Long, xbean.AwardIndexIds> _e_ : this.award_map.entrySet())
/*     */     {
/*  74 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  75 */       ((xbean.AwardIndexIds)_e_.getValue()).marshal(_os_);
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*  84 */     this.reset_time = _os_.unmarshal_long();
/*     */     
/*  86 */     int size = _os_.uncompact_uint32();
/*  87 */     if (size >= 12)
/*     */     {
/*  89 */       this.award_map = new HashMap(size * 2);
/*     */     }
/*  91 */     for (; size > 0; size--)
/*     */     {
/*  93 */       long _k_ = 0L;
/*  94 */       _k_ = _os_.unmarshal_long();
/*  95 */       xbean.AwardIndexIds _v_ = new AwardIndexIds(0, this, "award_map");
/*  96 */       _v_.unmarshal(_os_);
/*  97 */       this.award_map.put(Long.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 100 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 106 */     _xdb_verify_unsafe_();
/* 107 */     int _size_ = 0;
/* 108 */     _size_ += CodedOutputStream.computeInt64Size(3, this.reset_time);
/* 109 */     for (Map.Entry<Long, xbean.AwardIndexIds> _e_ : this.award_map.entrySet())
/*     */     {
/* 111 */       _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/* 112 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */     }
/* 114 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 123 */       _output_.writeInt64(3, this.reset_time);
/* 124 */       for (Map.Entry<Long, xbean.AwardIndexIds> _e_ : this.award_map.entrySet())
/*     */       {
/* 126 */         _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/* 127 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 132 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 134 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 140 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 143 */       boolean done = false;
/* 144 */       while (!done)
/*     */       {
/* 146 */         int tag = _input_.readTag();
/* 147 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 151 */           done = true;
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 156 */           this.reset_time = _input_.readInt64();
/* 157 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 161 */           long _k_ = 0L;
/* 162 */           _k_ = _input_.readInt64();
/* 163 */           int readTag = _input_.readTag();
/* 164 */           if (10 != readTag)
/*     */           {
/* 166 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 168 */           xbean.AwardIndexIds _v_ = new AwardIndexIds(0, this, "award_map");
/* 169 */           _input_.readMessage(_v_);
/* 170 */           this.award_map.put(Long.valueOf(_k_), _v_);
/* 171 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 175 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 177 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 186 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 190 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 192 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ShiTuActive copy()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new ShiTuActive(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ShiTuActive toData()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ShiTuActive toBean()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new ShiTuActive(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ShiTuActive toDataIf()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ShiTuActive toBeanIf()
/*     */   {
/* 224 */     _xdb_verify_unsafe_();
/* 225 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getReset_time()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return this.reset_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.AwardIndexIds> getAward_map()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/* 248 */     return xdb.Logs.logMap(new xdb.LogKey(this, "award_map"), this.award_map);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.AwardIndexIds> getAward_mapAsData()
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/*     */     
/* 257 */     ShiTuActive _o_ = this;
/* 258 */     Map<Long, xbean.AwardIndexIds> award_map = new HashMap();
/* 259 */     for (Map.Entry<Long, xbean.AwardIndexIds> _e_ : _o_.award_map.entrySet())
/* 260 */       award_map.put(_e_.getKey(), new AwardIndexIds.Data((xbean.AwardIndexIds)_e_.getValue()));
/* 261 */     return award_map;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setReset_time(long _v_)
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     xdb.Logs.logIf(new xdb.LogKey(this, "reset_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 273 */         new xdb.logs.LogLong(this, ShiTuActive.this.reset_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 277 */             ShiTuActive.this.reset_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 281 */     });
/* 282 */     this.reset_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     ShiTuActive _o_ = null;
/* 290 */     if ((_o1_ instanceof ShiTuActive)) { _o_ = (ShiTuActive)_o1_;
/* 291 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 292 */       return false;
/* 293 */     if (this.reset_time != _o_.reset_time) return false;
/* 294 */     if (!this.award_map.equals(_o_.award_map)) return false;
/* 295 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     int _h_ = 0;
/* 303 */     _h_ = (int)(_h_ + this.reset_time);
/* 304 */     _h_ += this.award_map.hashCode();
/* 305 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     StringBuilder _sb_ = new StringBuilder();
/* 313 */     _sb_.append("(");
/* 314 */     _sb_.append(this.reset_time);
/* 315 */     _sb_.append(",");
/* 316 */     _sb_.append(this.award_map);
/* 317 */     _sb_.append(")");
/* 318 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 324 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 325 */     lb.add(new xdb.logs.ListenableChanged().setVarName("reset_time"));
/* 326 */     lb.add(new xdb.logs.ListenableMap().setVarName("award_map"));
/* 327 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ShiTuActive {
/*     */     private Const() {}
/*     */     
/*     */     ShiTuActive nThis() {
/* 334 */       return ShiTuActive.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 340 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ShiTuActive copy()
/*     */     {
/* 346 */       return ShiTuActive.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ShiTuActive toData()
/*     */     {
/* 352 */       return ShiTuActive.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ShiTuActive toBean()
/*     */     {
/* 357 */       return ShiTuActive.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ShiTuActive toDataIf()
/*     */     {
/* 363 */       return ShiTuActive.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ShiTuActive toBeanIf()
/*     */     {
/* 368 */       return ShiTuActive.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getReset_time()
/*     */     {
/* 375 */       ShiTuActive.this._xdb_verify_unsafe_();
/* 376 */       return ShiTuActive.this.reset_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.AwardIndexIds> getAward_map()
/*     */     {
/* 383 */       ShiTuActive.this._xdb_verify_unsafe_();
/* 384 */       return xdb.Consts.constMap(ShiTuActive.this.award_map);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.AwardIndexIds> getAward_mapAsData()
/*     */     {
/* 391 */       ShiTuActive.this._xdb_verify_unsafe_();
/*     */       
/* 393 */       ShiTuActive _o_ = ShiTuActive.this;
/* 394 */       Map<Long, xbean.AwardIndexIds> award_map = new HashMap();
/* 395 */       for (Map.Entry<Long, xbean.AwardIndexIds> _e_ : _o_.award_map.entrySet())
/* 396 */         award_map.put(_e_.getKey(), new AwardIndexIds.Data((xbean.AwardIndexIds)_e_.getValue()));
/* 397 */       return award_map;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setReset_time(long _v_)
/*     */     {
/* 404 */       ShiTuActive.this._xdb_verify_unsafe_();
/* 405 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 411 */       ShiTuActive.this._xdb_verify_unsafe_();
/* 412 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 418 */       ShiTuActive.this._xdb_verify_unsafe_();
/* 419 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 425 */       return ShiTuActive.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 431 */       return ShiTuActive.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 437 */       ShiTuActive.this._xdb_verify_unsafe_();
/* 438 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 444 */       return ShiTuActive.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 450 */       return ShiTuActive.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 456 */       ShiTuActive.this._xdb_verify_unsafe_();
/* 457 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 463 */       return ShiTuActive.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 469 */       return ShiTuActive.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 475 */       return ShiTuActive.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 481 */       return ShiTuActive.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 487 */       return ShiTuActive.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 493 */       return ShiTuActive.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 499 */       return ShiTuActive.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ShiTuActive
/*     */   {
/*     */     private long reset_time;
/*     */     
/*     */     private HashMap<Long, xbean.AwardIndexIds> award_map;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 513 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 518 */       this.award_map = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.ShiTuActive _o1_)
/*     */     {
/* 523 */       if ((_o1_ instanceof ShiTuActive)) { assign((ShiTuActive)_o1_);
/* 524 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 525 */       } else if ((_o1_ instanceof ShiTuActive.Const)) assign(((ShiTuActive.Const)_o1_).nThis()); else {
/* 526 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ShiTuActive _o_) {
/* 531 */       this.reset_time = _o_.reset_time;
/* 532 */       this.award_map = new HashMap();
/* 533 */       for (Map.Entry<Long, xbean.AwardIndexIds> _e_ : _o_.award_map.entrySet()) {
/* 534 */         this.award_map.put(_e_.getKey(), new AwardIndexIds.Data((xbean.AwardIndexIds)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 539 */       this.reset_time = _o_.reset_time;
/* 540 */       this.award_map = new HashMap();
/* 541 */       for (Map.Entry<Long, xbean.AwardIndexIds> _e_ : _o_.award_map.entrySet()) {
/* 542 */         this.award_map.put(_e_.getKey(), new AwardIndexIds.Data((xbean.AwardIndexIds)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 548 */       _os_.marshal(this.reset_time);
/* 549 */       _os_.compact_uint32(this.award_map.size());
/* 550 */       for (Map.Entry<Long, xbean.AwardIndexIds> _e_ : this.award_map.entrySet())
/*     */       {
/* 552 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 553 */         ((xbean.AwardIndexIds)_e_.getValue()).marshal(_os_);
/*     */       }
/* 555 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 561 */       this.reset_time = _os_.unmarshal_long();
/*     */       
/* 563 */       int size = _os_.uncompact_uint32();
/* 564 */       if (size >= 12)
/*     */       {
/* 566 */         this.award_map = new HashMap(size * 2);
/*     */       }
/* 568 */       for (; size > 0; size--)
/*     */       {
/* 570 */         long _k_ = 0L;
/* 571 */         _k_ = _os_.unmarshal_long();
/* 572 */         xbean.AwardIndexIds _v_ = xbean.Pod.newAwardIndexIdsData();
/* 573 */         _v_.unmarshal(_os_);
/* 574 */         this.award_map.put(Long.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 577 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 583 */       int _size_ = 0;
/* 584 */       _size_ += CodedOutputStream.computeInt64Size(3, this.reset_time);
/* 585 */       for (Map.Entry<Long, xbean.AwardIndexIds> _e_ : this.award_map.entrySet())
/*     */       {
/* 587 */         _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/* 588 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 590 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 598 */         _output_.writeInt64(3, this.reset_time);
/* 599 */         for (Map.Entry<Long, xbean.AwardIndexIds> _e_ : this.award_map.entrySet())
/*     */         {
/* 601 */           _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/* 602 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 607 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 609 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 617 */         boolean done = false;
/* 618 */         while (!done)
/*     */         {
/* 620 */           int tag = _input_.readTag();
/* 621 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 625 */             done = true;
/* 626 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 630 */             this.reset_time = _input_.readInt64();
/* 631 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 635 */             long _k_ = 0L;
/* 636 */             _k_ = _input_.readInt64();
/* 637 */             int readTag = _input_.readTag();
/* 638 */             if (10 != readTag)
/*     */             {
/* 640 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 642 */             xbean.AwardIndexIds _v_ = xbean.Pod.newAwardIndexIdsData();
/* 643 */             _input_.readMessage(_v_);
/* 644 */             this.award_map.put(Long.valueOf(_k_), _v_);
/* 645 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 649 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 651 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 660 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 664 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 666 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ShiTuActive copy()
/*     */     {
/* 672 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ShiTuActive toData()
/*     */     {
/* 678 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ShiTuActive toBean()
/*     */     {
/* 683 */       return new ShiTuActive(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ShiTuActive toDataIf()
/*     */     {
/* 689 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ShiTuActive toBeanIf()
/*     */     {
/* 694 */       return new ShiTuActive(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 700 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 704 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 708 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 712 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 716 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 720 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 724 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getReset_time()
/*     */     {
/* 731 */       return this.reset_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.AwardIndexIds> getAward_map()
/*     */     {
/* 738 */       return this.award_map;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.AwardIndexIds> getAward_mapAsData()
/*     */     {
/* 745 */       return this.award_map;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setReset_time(long _v_)
/*     */     {
/* 752 */       this.reset_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 758 */       if (!(_o1_ instanceof Data)) return false;
/* 759 */       Data _o_ = (Data)_o1_;
/* 760 */       if (this.reset_time != _o_.reset_time) return false;
/* 761 */       if (!this.award_map.equals(_o_.award_map)) return false;
/* 762 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 768 */       int _h_ = 0;
/* 769 */       _h_ = (int)(_h_ + this.reset_time);
/* 770 */       _h_ += this.award_map.hashCode();
/* 771 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 777 */       StringBuilder _sb_ = new StringBuilder();
/* 778 */       _sb_.append("(");
/* 779 */       _sb_.append(this.reset_time);
/* 780 */       _sb_.append(",");
/* 781 */       _sb_.append(this.award_map);
/* 782 */       _sb_.append(")");
/* 783 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ShiTuActive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */