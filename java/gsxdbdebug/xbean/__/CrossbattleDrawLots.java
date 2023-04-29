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
/*     */ public final class CrossbattleDrawLots extends XBean implements xbean.CrossbattleDrawLots
/*     */ {
/*     */   private boolean reported;
/*     */   private HashMap<Long, xbean.DrawLotsZoneInfo> corps;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.reported = false;
/*  21 */     this.corps.clear();
/*     */   }
/*     */   
/*     */   CrossbattleDrawLots(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.corps = new HashMap();
/*     */   }
/*     */   
/*     */   public CrossbattleDrawLots()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public CrossbattleDrawLots(CrossbattleDrawLots _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   CrossbattleDrawLots(xbean.CrossbattleDrawLots _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof CrossbattleDrawLots)) { assign((CrossbattleDrawLots)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(CrossbattleDrawLots _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.reported = _o_.reported;
/*  53 */     this.corps = new HashMap();
/*  54 */     for (Map.Entry<Long, xbean.DrawLotsZoneInfo> _e_ : _o_.corps.entrySet()) {
/*  55 */       this.corps.put(_e_.getKey(), new DrawLotsZoneInfo((xbean.DrawLotsZoneInfo)_e_.getValue(), this, "corps"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  60 */     this.reported = _o_.reported;
/*  61 */     this.corps = new HashMap();
/*  62 */     for (Map.Entry<Long, xbean.DrawLotsZoneInfo> _e_ : _o_.corps.entrySet()) {
/*  63 */       this.corps.put(_e_.getKey(), new DrawLotsZoneInfo((xbean.DrawLotsZoneInfo)_e_.getValue(), this, "corps"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.reported);
/*  71 */     _os_.compact_uint32(this.corps.size());
/*  72 */     for (Map.Entry<Long, xbean.DrawLotsZoneInfo> _e_ : this.corps.entrySet())
/*     */     {
/*  74 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  75 */       ((xbean.DrawLotsZoneInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*  84 */     this.reported = _os_.unmarshal_boolean();
/*     */     
/*  86 */     int size = _os_.uncompact_uint32();
/*  87 */     if (size >= 12)
/*     */     {
/*  89 */       this.corps = new HashMap(size * 2);
/*     */     }
/*  91 */     for (; size > 0; size--)
/*     */     {
/*  93 */       long _k_ = 0L;
/*  94 */       _k_ = _os_.unmarshal_long();
/*  95 */       xbean.DrawLotsZoneInfo _v_ = new DrawLotsZoneInfo(0, this, "corps");
/*  96 */       _v_.unmarshal(_os_);
/*  97 */       this.corps.put(Long.valueOf(_k_), _v_);
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
/* 108 */     _size_ += CodedOutputStream.computeBoolSize(1, this.reported);
/* 109 */     for (Map.Entry<Long, xbean.DrawLotsZoneInfo> _e_ : this.corps.entrySet())
/*     */     {
/* 111 */       _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 112 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
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
/* 123 */       _output_.writeBool(1, this.reported);
/* 124 */       for (Map.Entry<Long, xbean.DrawLotsZoneInfo> _e_ : this.corps.entrySet())
/*     */       {
/* 126 */         _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 127 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
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
/*     */         case 8: 
/* 156 */           this.reported = _input_.readBool();
/* 157 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 161 */           long _k_ = 0L;
/* 162 */           _k_ = _input_.readInt64();
/* 163 */           int readTag = _input_.readTag();
/* 164 */           if (18 != readTag)
/*     */           {
/* 166 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 168 */           xbean.DrawLotsZoneInfo _v_ = new DrawLotsZoneInfo(0, this, "corps");
/* 169 */           _input_.readMessage(_v_);
/* 170 */           this.corps.put(Long.valueOf(_k_), _v_);
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
/*     */   public xbean.CrossbattleDrawLots copy()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new CrossbattleDrawLots(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossbattleDrawLots toData()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CrossbattleDrawLots toBean()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new CrossbattleDrawLots(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossbattleDrawLots toDataIf()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CrossbattleDrawLots toBeanIf()
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
/*     */   public boolean getReported()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return this.reported;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.DrawLotsZoneInfo> getCorps()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/* 248 */     return xdb.Logs.logMap(new xdb.LogKey(this, "corps"), this.corps);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.DrawLotsZoneInfo> getCorpsAsData()
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/*     */     
/* 257 */     CrossbattleDrawLots _o_ = this;
/* 258 */     Map<Long, xbean.DrawLotsZoneInfo> corps = new HashMap();
/* 259 */     for (Map.Entry<Long, xbean.DrawLotsZoneInfo> _e_ : _o_.corps.entrySet())
/* 260 */       corps.put(_e_.getKey(), new DrawLotsZoneInfo.Data((xbean.DrawLotsZoneInfo)_e_.getValue()));
/* 261 */     return corps;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setReported(boolean _v_)
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     xdb.Logs.logIf(new xdb.LogKey(this, "reported")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 273 */         new xdb.logs.LogObject(this, Boolean.valueOf(CrossbattleDrawLots.this.reported))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 277 */             CrossbattleDrawLots.this.reported = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 281 */     });
/* 282 */     this.reported = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     CrossbattleDrawLots _o_ = null;
/* 290 */     if ((_o1_ instanceof CrossbattleDrawLots)) { _o_ = (CrossbattleDrawLots)_o1_;
/* 291 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 292 */       return false;
/* 293 */     if (this.reported != _o_.reported) return false;
/* 294 */     if (!this.corps.equals(_o_.corps)) return false;
/* 295 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     int _h_ = 0;
/* 303 */     _h_ += (this.reported ? 1231 : 1237);
/* 304 */     _h_ += this.corps.hashCode();
/* 305 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     StringBuilder _sb_ = new StringBuilder();
/* 313 */     _sb_.append("(");
/* 314 */     _sb_.append(this.reported);
/* 315 */     _sb_.append(",");
/* 316 */     _sb_.append(this.corps);
/* 317 */     _sb_.append(")");
/* 318 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 324 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 325 */     lb.add(new xdb.logs.ListenableChanged().setVarName("reported"));
/* 326 */     lb.add(new xdb.logs.ListenableMap().setVarName("corps"));
/* 327 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.CrossbattleDrawLots {
/*     */     private Const() {}
/*     */     
/*     */     CrossbattleDrawLots nThis() {
/* 334 */       return CrossbattleDrawLots.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 340 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossbattleDrawLots copy()
/*     */     {
/* 346 */       return CrossbattleDrawLots.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossbattleDrawLots toData()
/*     */     {
/* 352 */       return CrossbattleDrawLots.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.CrossbattleDrawLots toBean()
/*     */     {
/* 357 */       return CrossbattleDrawLots.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossbattleDrawLots toDataIf()
/*     */     {
/* 363 */       return CrossbattleDrawLots.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.CrossbattleDrawLots toBeanIf()
/*     */     {
/* 368 */       return CrossbattleDrawLots.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getReported()
/*     */     {
/* 375 */       CrossbattleDrawLots.this._xdb_verify_unsafe_();
/* 376 */       return CrossbattleDrawLots.this.reported;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.DrawLotsZoneInfo> getCorps()
/*     */     {
/* 383 */       CrossbattleDrawLots.this._xdb_verify_unsafe_();
/* 384 */       return xdb.Consts.constMap(CrossbattleDrawLots.this.corps);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.DrawLotsZoneInfo> getCorpsAsData()
/*     */     {
/* 391 */       CrossbattleDrawLots.this._xdb_verify_unsafe_();
/*     */       
/* 393 */       CrossbattleDrawLots _o_ = CrossbattleDrawLots.this;
/* 394 */       Map<Long, xbean.DrawLotsZoneInfo> corps = new HashMap();
/* 395 */       for (Map.Entry<Long, xbean.DrawLotsZoneInfo> _e_ : _o_.corps.entrySet())
/* 396 */         corps.put(_e_.getKey(), new DrawLotsZoneInfo.Data((xbean.DrawLotsZoneInfo)_e_.getValue()));
/* 397 */       return corps;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setReported(boolean _v_)
/*     */     {
/* 404 */       CrossbattleDrawLots.this._xdb_verify_unsafe_();
/* 405 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 411 */       CrossbattleDrawLots.this._xdb_verify_unsafe_();
/* 412 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 418 */       CrossbattleDrawLots.this._xdb_verify_unsafe_();
/* 419 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 425 */       return CrossbattleDrawLots.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 431 */       return CrossbattleDrawLots.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 437 */       CrossbattleDrawLots.this._xdb_verify_unsafe_();
/* 438 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 444 */       return CrossbattleDrawLots.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 450 */       return CrossbattleDrawLots.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 456 */       CrossbattleDrawLots.this._xdb_verify_unsafe_();
/* 457 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 463 */       return CrossbattleDrawLots.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 469 */       return CrossbattleDrawLots.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 475 */       return CrossbattleDrawLots.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 481 */       return CrossbattleDrawLots.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 487 */       return CrossbattleDrawLots.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 493 */       return CrossbattleDrawLots.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 499 */       return CrossbattleDrawLots.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.CrossbattleDrawLots
/*     */   {
/*     */     private boolean reported;
/*     */     
/*     */     private HashMap<Long, xbean.DrawLotsZoneInfo> corps;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 513 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 518 */       this.corps = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.CrossbattleDrawLots _o1_)
/*     */     {
/* 523 */       if ((_o1_ instanceof CrossbattleDrawLots)) { assign((CrossbattleDrawLots)_o1_);
/* 524 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 525 */       } else if ((_o1_ instanceof CrossbattleDrawLots.Const)) assign(((CrossbattleDrawLots.Const)_o1_).nThis()); else {
/* 526 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(CrossbattleDrawLots _o_) {
/* 531 */       this.reported = _o_.reported;
/* 532 */       this.corps = new HashMap();
/* 533 */       for (Map.Entry<Long, xbean.DrawLotsZoneInfo> _e_ : _o_.corps.entrySet()) {
/* 534 */         this.corps.put(_e_.getKey(), new DrawLotsZoneInfo.Data((xbean.DrawLotsZoneInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 539 */       this.reported = _o_.reported;
/* 540 */       this.corps = new HashMap();
/* 541 */       for (Map.Entry<Long, xbean.DrawLotsZoneInfo> _e_ : _o_.corps.entrySet()) {
/* 542 */         this.corps.put(_e_.getKey(), new DrawLotsZoneInfo.Data((xbean.DrawLotsZoneInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 548 */       _os_.marshal(this.reported);
/* 549 */       _os_.compact_uint32(this.corps.size());
/* 550 */       for (Map.Entry<Long, xbean.DrawLotsZoneInfo> _e_ : this.corps.entrySet())
/*     */       {
/* 552 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 553 */         ((xbean.DrawLotsZoneInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 555 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 561 */       this.reported = _os_.unmarshal_boolean();
/*     */       
/* 563 */       int size = _os_.uncompact_uint32();
/* 564 */       if (size >= 12)
/*     */       {
/* 566 */         this.corps = new HashMap(size * 2);
/*     */       }
/* 568 */       for (; size > 0; size--)
/*     */       {
/* 570 */         long _k_ = 0L;
/* 571 */         _k_ = _os_.unmarshal_long();
/* 572 */         xbean.DrawLotsZoneInfo _v_ = xbean.Pod.newDrawLotsZoneInfoData();
/* 573 */         _v_.unmarshal(_os_);
/* 574 */         this.corps.put(Long.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 577 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 583 */       int _size_ = 0;
/* 584 */       _size_ += CodedOutputStream.computeBoolSize(1, this.reported);
/* 585 */       for (Map.Entry<Long, xbean.DrawLotsZoneInfo> _e_ : this.corps.entrySet())
/*     */       {
/* 587 */         _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 588 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 590 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 598 */         _output_.writeBool(1, this.reported);
/* 599 */         for (Map.Entry<Long, xbean.DrawLotsZoneInfo> _e_ : this.corps.entrySet())
/*     */         {
/* 601 */           _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 602 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
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
/*     */           case 8: 
/* 630 */             this.reported = _input_.readBool();
/* 631 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 635 */             long _k_ = 0L;
/* 636 */             _k_ = _input_.readInt64();
/* 637 */             int readTag = _input_.readTag();
/* 638 */             if (18 != readTag)
/*     */             {
/* 640 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 642 */             xbean.DrawLotsZoneInfo _v_ = xbean.Pod.newDrawLotsZoneInfoData();
/* 643 */             _input_.readMessage(_v_);
/* 644 */             this.corps.put(Long.valueOf(_k_), _v_);
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
/*     */     public xbean.CrossbattleDrawLots copy()
/*     */     {
/* 672 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossbattleDrawLots toData()
/*     */     {
/* 678 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.CrossbattleDrawLots toBean()
/*     */     {
/* 683 */       return new CrossbattleDrawLots(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossbattleDrawLots toDataIf()
/*     */     {
/* 689 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.CrossbattleDrawLots toBeanIf()
/*     */     {
/* 694 */       return new CrossbattleDrawLots(this, null, null);
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
/*     */     public boolean getReported()
/*     */     {
/* 731 */       return this.reported;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.DrawLotsZoneInfo> getCorps()
/*     */     {
/* 738 */       return this.corps;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.DrawLotsZoneInfo> getCorpsAsData()
/*     */     {
/* 745 */       return this.corps;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setReported(boolean _v_)
/*     */     {
/* 752 */       this.reported = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 758 */       if (!(_o1_ instanceof Data)) return false;
/* 759 */       Data _o_ = (Data)_o1_;
/* 760 */       if (this.reported != _o_.reported) return false;
/* 761 */       if (!this.corps.equals(_o_.corps)) return false;
/* 762 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 768 */       int _h_ = 0;
/* 769 */       _h_ += (this.reported ? 1231 : 1237);
/* 770 */       _h_ += this.corps.hashCode();
/* 771 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 777 */       StringBuilder _sb_ = new StringBuilder();
/* 778 */       _sb_.append("(");
/* 779 */       _sb_.append(this.reported);
/* 780 */       _sb_.append(",");
/* 781 */       _sb_.append(this.corps);
/* 782 */       _sb_.append(")");
/* 783 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CrossbattleDrawLots.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */